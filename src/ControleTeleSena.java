import java.util.ArrayList;

public class ControleTeleSena {
    ArrayList<Integer> sorteados = new ArrayList<>();
    int nDeGanhadores = 0;
    ArrayList<Pessoa> ganhadores = new ArrayList<>();
    Pessoa[] listaDePessoas;
    TeleSena modelo;

    // Construtor responsável por preencher o Array de Pessoas. Segue a mesma lógica do gerador de números de Tele Sena
    public ControleTeleSena(){
        Pessoa[] listaDePessoas = new Pessoa[20];
        Pessoa n;
        boolean repetido;
        for (int i = 0; i < listaDePessoas.length; i++) {
            do {
                n = new Pessoa();
                repetido = false;
                for (int j = 0; j < i; j++) {
                    if (n.getNome().equals(listaDePessoas[j].getNome())) {
                        repetido = true;
                        break;
                    }
                }
            } while (repetido);
            listaDePessoas[i] = n;
        }
        this.listaDePessoas = listaDePessoas;

        this.modelo = new TeleSena();
    }

    // Preenche as primeiras 25 posições do Array de números sorteados criando uma nova Tele Sena e pegando os números de um array de números
    public void primeiroSorteio(){
        TeleSena valoresIniciais = new TeleSena();

        for (int i = 0; i < valoresIniciais.getNumeros1().length; i++) {
            this.sorteados.add(valoresIniciais.getNumeros1()[i]);
        }

    }

    // Verifica se há ganhadores
    public void checagem(){
        nDeGanhadores = 0;
        // percorre lista de pessoas
        for (int i = 0; i < listaDePessoas.length; i++)

            //percorre lista de telessenas possuídas pela pessoa "i"
            for (int j = 0; j < listaDePessoas[i].teleSenasPossuidas.length ; j++) {

                int certosNaTabela1 = 0;
                int certosNaTabela2 = 0;

                //percorre valor sorteado do "gabarito"
                for (int k = 0; k < sorteados.size(); k++)
                    
                    //compara o valor certo com o valor da cartela
                    for (int l = 0; l < listaDePessoas[i].teleSenasPossuidas[j].getNumeros1().length; l++) {
                        if (sorteados.get(k) == listaDePessoas[i].teleSenasPossuidas[j].getNumeros1()[l])
                            certosNaTabela1++;
        
                        if (sorteados.get(k) == listaDePessoas[i].teleSenasPossuidas[j].getNumeros2()[l])
                            certosNaTabela2++;
                        
                    }
                        
                if (certosNaTabela1 == listaDePessoas[i].teleSenasPossuidas[j].getNumeros1().length || certosNaTabela2 == listaDePessoas[i].teleSenasPossuidas[j].getNumeros2().length) {
                    ganhadores.add(listaDePessoas[i]);
                    this.nDeGanhadores ++;  
                }         
            }
    }
    
    // Gera um novo número, verifica se já esta no array de resposta, e caso não esteja, adiciona-o a ele
    public void adicionarNumero(){
        int n;
        boolean repetido;
        do {
            n = (int) (Math.random() * 60 + 1);
            repetido = false;
            for (int i = 0; i < sorteados.size(); i++)

                if (n == sorteados.get(i)) {
                    repetido = true;
                    break;
                }

        }while (repetido);
        sorteados.add(n);
    }

    // Realiza o sorteio utilizando os métodos "primeiroSorteio", "checagem" e "adicionarNumero", os quais já foram descritos acima
    public void sorteio(){

        primeiroSorteio();
        checagem();
        int x = 0;

        while (nDeGanhadores == 0) {

            adicionarNumero();

            x++;

            checagem();  

        }
        System.out.printf("\nAlguém ganhou após " + x + " rolagem(ns) de número extra.\n\n" );

        for (int i = 0; i < ganhadores.size(); i++) {
            ganhadores.get(i).setPremiacao(premio()/ganhadores.size());
        }

    }

    // Exibe todos números que foram sorteados
    public void exibirNumerosFinais(){
        System.out.println("Números sorteados: " + sorteados.toString());
    }

    // Calcula qual será o valor total do prêmio a ser distribuído
    public double premio(){
        double premio = vendidas() * modelo.preco * 0.8;
        return premio;
    }

    // Exibe os ganhadores, qual o valor de seus prêmio e quanto de seu prêmio "comido" pelo imposto
    public void exibirGanhadores(){
        System.out.println("Ganhador(es): ");
        premio();
        for (int i = 0; i < ganhadores.size(); i++)

            System.out.printf(ganhadores.get(i).getNome() + " ganhou: R$%.2f (O Leão vai comer R$%.2f do teu prêmio, otário XD )\n", ganhadores.get(i).getPremiacao(), ganhadores.get(i).getPremiacao()*0.275);

    }

    // Verifica quantas Tele Senas cada pessoa comprou e soma-as ao contador
    public int vendidas() {
        int totalVendidas = 0;
        for (int i = 0; i < listaDePessoas.length; i++)
            totalVendidas += listaDePessoas[i].getCompradas();

        return totalVendidas;
    }

    //  Calcula o lucro gerado com a vendas das telesenas
    public double lucro(){
        double lucro = vendidas() * modelo.preco - premio();
        return lucro;
    }

    // Exibe quantas Tele Senas foram vendidas, qual foi o valor distribuído como prêmio e qual o lucro gerado
    // Utiliza os métodos descritos acima
    public void financas(){
        System.out.println("Número de TeleSenas vendidas: " + vendidas());
        System.out.printf("Lucro: R$%.2f \n", lucro());
        System.out.printf("Valor distribuído aos vencedores: R$%.2f \n", premio());
    }

}
