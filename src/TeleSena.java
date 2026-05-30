import java.util.Arrays;

public class TeleSena {
    int preço = 10;
    private int[] numeros1 = new int[25];
    private int[] numeros2 = new int[25];

    public int[] sorteio1(int[] numeros1){
        int sorteado = 0;
        while(true){
            sorteado = (int)(Math.random() * 60 + 1);
            for (int i = 0; i < numeros1.length; i++) 
                if (sorteado != numeros1[i]) 
                    numeros1[i] = sorteado;
            
            if (numeros1[24] > 0) 
                break;
        }
        Arrays.sort(numeros1);
        return numeros1;
    }
    public int[] sorteio2(int[] numeros2){
        int sorteado = 0;
        while(true){
            sorteado = (int)(Math.random() * 60 + 1);
            for (int i = 0; i < numeros2.length; i++) 
                if (sorteado != numeros2[i]) 
                    numeros2[i] = sorteado;
            
            if (numeros2[24] > 0) 
                break;
        }
        Arrays.sort(numeros2);
        return numeros2;
    }

    public TeleSena(int preço, int[] numeros1, int[] numeros2){
        this.preço = preço;
        this.numeros1 = numeros1;
        this.numeros2 = numeros2;

    }

    public int[] getNumeros1(){
        return numeros1;
    }
    public int[] getNumeros2(){
        return numeros2;
    }

}
