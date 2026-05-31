public class Pessoa {
    private String nome;
    TeleSena[] teleSenasPossuidas;
    private final String[] nomes = { "Brontélio", "Xifrósia", "Trambúlio", "Grelfina", "Zanzor","Pindalvo", "Crostélia", "Vrumildo", "Nefastina", "Glupério", "Tortúlio", "Beringelaide", "Quasímodo", "Frutêncio", "Xampolina", "Drungélio", "Pafúncia", "Zigorfo", "Lombrélia", "Crustácio", "Trepidino", "Vespúlia", "Gnorfredo", "Pitulina", "Estrambélio", "Minguarda", "Jambroso", "Turbélia", "Fungêncio", "Waldromiro", "Zorbélio", "Frungus", "Nebulino", "Xartrudes", "Plimplão", "Vortélia", "Grisaldo", "Marmulino", "Quintófio", "Blércia","Trombaldo", "Ypsilina", "Crongélio", "Farfalina", "Jujuberto", "Exdrúxula", "Pimpolácio", "Gorgonzélia", "Trastônio", "Veludina" };
    
    private final String[] sobrenomes = { "das Neblinhas Cósmicas", "Quebrapedra", "do Abismo Dançante", "Pereira de Marte", "Sete-Sapatos", "dos Ventos Quadrados", "Alfaceiro", "da Lua Enferrujada", "Escafandro", "do Pântano Celestial", "Batatovski", "das Engrenagens Tristes", "Macarrones", "do Relógio Derretido", "Pseudônimo", "das Galáxias Miúdas", "Parafusetti", "do Horizonte Torto", "Catapimbas", "dos Croissants Sagrados", "do Cachimbo Astral", "das Batatas Radiantes", "Queijo de Saturno", "da Montanha Invertida", "dos Pombos Metafísicos", "Escorregoso", "da Sétima Geladeira", "Pernalongares", "do Oceano de Mingau", "Três-Cogumelos", "das Nuvens Cúbicas", "Picolé de Bronze","do Chapéu Transparente", "Pé-de-Tornado", "das Sombras Fluorescentes", "Biscoitovski", "do Reino das Colheres", "Sete-Rabanetes", "das Janelas Submersas", "Paralelepipedeski", "do Planeta Melancia", "Cebolêncio", "das Girafas Elétricas", "do Bigode Interplanetário", "Quatro-Trombetas", "das Pipocas Eternas", "Maracujá de Ferro", "do Cofre Voador", "dos Jacarés Filosóficos", "Pão-de-Cometa" };


    final public String gerarNome() {
        int nr = (int) (Math.random() * nomes.length);
        int sr = (int) (Math.random() * sobrenomes.length);
        String nomeGerado = nomes[nr] + " " + sobrenomes[sr];
        return nomeGerado;
    }

    public Pessoa(){
        this.nome = gerarNome();
    }
    
    public String getNome(){
        return this.nome;
    }

}
