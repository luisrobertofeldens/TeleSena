import java.util.ArrayList;

public class ControleTeleSena {
    ArrayList<Integer> sorteados = new ArrayList<>();
    int nDeGanhadores = 0;
    ArrayList<Pessoa> ganhadores = new ArrayList<>();
    Pessoa[] listaDePessoas;

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
    }

    public void primeiroSorteio(){
        TeleSena valoresIniciais = new TeleSena();

        for (int i = 0; i < valoresIniciais.getNumeros1().length; i++) {
            this.sorteados.add(valoresIniciais.getNumeros1()[i]);
        }

    }

    public void checagem(){
        nDeGanhadores = 0;
        // percorre lista de pessoas
        for (int i = 0; i < listaDePessoas.length; i++) { 
            //percorre lista de telessenas possuídas pela pessoa "i"
            for (int j = 0; j < listaDePessoas[i].teleSenasPossuidas.length ; j++) {

                int certosNaTabela1 = 0;
                int certosNaTabela2 = 0;

                //percorre valor sorteado do "gabarito"
                for (int k = 0; k < sorteados.size(); k++) {
                    
                    //compara o valor certo com o valor da cartela
                    for (int l = 0; l < listaDePessoas[i].teleSenasPossuidas[j].getNumeros1().length; l++) {
                        if (sorteados.get(k) == listaDePessoas[i].teleSenasPossuidas[j].getNumeros1()[l]){
                            certosNaTabela1++;
                        }
                        if (sorteados.get(k) == listaDePessoas[i].teleSenasPossuidas[j].getNumeros2()[l]) {
                            certosNaTabela2++;
                        }

                    }
                        
                    
                }
                if (certosNaTabela1 == listaDePessoas[i].teleSenasPossuidas[j].getNumeros1().length || certosNaTabela2 == listaDePessoas[i].teleSenasPossuidas[j].getNumeros2().length) {
                    ganhadores.add(listaDePessoas[i]);
                    this.nDeGanhadores ++;  
                }         
            }
        }
    }
    
    public void adicionarNumero(){
        int n;
        boolean repetido;
        do {
                n = (int) (Math.random() * 60 + 1);
                repetido = false;
                for (int i = 0; i < sorteados.size(); i++) {
                    if (n == sorteados.get(i)) {
                        repetido = true;
                        break;
                    }
                }
        }while (repetido);
        sorteados.add(n);


    }

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

    public void exibirNumerosFinais(){
        System.out.println("Números sorteados: " + sorteados.toString());
    }


    public double premio(){
        double premio = vendidas() * 8;
        return premio;
    }

    public void exibirGanhadores(){
        System.out.println("Ganhador(es): ");
        premio();
        for (int i = 0; i < ganhadores.size(); i++) {
            System.out.printf(ganhadores.get(i).getNome() + " ganhou: R$%.2f (O Leão vai comer R$%.2f do teu prêmio, otário XD )\n", ganhadores.get(i).getPremiacao(), ganhadores.get(i).getPremiacao()*0.275);

        }

    }

    public int vendidas() {
        int totalVendidas = 0;
        for (int i = 0; i < listaDePessoas.length; i++) {
            totalVendidas += listaDePessoas[i].getCompradas();
        }
        return totalVendidas;
    }

    public double lucro(){
        double lucro = vendidas() * 10 - premio();
        return lucro;
    }

    public void financas(){
        System.out.println("Número de TeleSenas vendidas: " + vendidas());
        System.out.printf("Lucro: R$%.2f \n", lucro());
        System.out.printf("Valor distribuído aos vencedores: R$%.2f \n", premio());
    }

}
