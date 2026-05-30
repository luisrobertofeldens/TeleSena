public class TeleSena {
    final int preço = 10;
    private int[] numeros1;
    private int[] numeros2;

    public int[] gerarSorteio(){
        int[] sorteados = new int[25];
        int n;
        boolean repetido;
        for (int i = 0; i < sorteados.length; i++) {
            do {
                n = (int)(Math.random() * 60 + 1);
                repetido = false;
                for (int j = 0; j < i; j++) {
                    if(n == sorteados[j]){
                        repetido = true;
                        break;
                    }
                }
            } while (repetido);
            sorteados[i] = n;

        }
            return sorteados;
    }

    public TeleSena(){
        this.numeros1 = gerarSorteio();
        this.numeros2 = gerarSorteio();

    }

    public int[] getNumeros1(){
        return numeros1;
    }
    public int[] getNumeros2(){
        return numeros2;
    }

}
