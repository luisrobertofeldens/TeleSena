public class Principal {

    public static void main(String[] args) {
        ControleTeleSena teste = new ControleTeleSena();

        System.out.println("$$$$ REALIZANDO SORTEIO E CHECANDO GANHADORES $$$$");

        try{
            Thread.sleep(800);
        }catch(Exception e){}

        teste.sorteio();
        
        try{
            Thread.sleep(800);
        }catch(Exception e){}
        

        System.out.println();

        System.out.println("Calculando Prêmio");

        try{
            Thread.sleep(800);
        }catch(Exception e){}

        teste.premio();
        
        System.out.println();

        teste.exibirGanhadores();

        try{
            Thread.sleep(800);
        }catch(Exception e){}

        System.out.println();

        teste.financas();

        try{
            Thread.sleep(800);
        }catch(Exception e){}
        System.out.println();

        teste.exibirNumerosFinais();
    }

}