public class TeleSena {
    final double preco = 10.00;
    private int[] numeros1;
    private int[] numeros2;

    public int[] gerarSorteio() {
        int[] sorteados = new int[25];
        int n;
        boolean repetido;
        for (int i = 0; i < sorteados.length; i++) {
            // No DO abaixo ↓ , por padrão repetido é falso.
            do {
                n = (int) (Math.random() * 60 + 1);
                repetido = false;
                // Caso o número sorteado já exita no Array que é percorrido abaixo, "repetido" se torna True e o loop continua.
                for (int j = 0; j < i; j++) {
                    if (n == sorteados[j]) {
                        repetido = true;
                        break;
                    }
                }
            } while (repetido); // Caso contrário, a execução sai do loop e transforma a próxima posição do Array "sorteados" no valor aleatório "n" 
            sorteados[i] = n;
        }
        // Ao terminar de preencher o array o método retorna-o
        return sorteados;
    }

    // Construtor que preenche as tabelas da telesena
    public TeleSena() {
        this.numeros1 = gerarSorteio();
        this.numeros2 = gerarSorteio();

    }

    // Getters ↓

    public int[] getNumeros1() {
        return numeros1;
    }

    public int[] getNumeros2() {
        return numeros2;
    }
    
}
