package coloracaodegrafoia;

import java.util.LinkedList;

//RELACIONAMENTO E DADOS DO GRAFO
public class GrafoNo {

    private coresEnum cor; // RGB
    private LinkedList<GrafoNo> nosAdjacentes;

    public GrafoNo() {
        this.nosAdjacentes = new LinkedList<GrafoNo>();
        this.cor = coresEnum.WHITE;
    }

    public coresEnum getCor() {
        return this.cor;
    }

    public void setCor(coresEnum cor) {
        this.cor = cor;
    }

    public LinkedList<GrafoNo> getNosAdjacentes() {
        return this.nosAdjacentes;
    }

    public void adicionaNoAdjacente(GrafoNo no) {
        this.nosAdjacentes.addLast(no);
    }

    public GrafoNo getNoAdjacente(int indice) {
        return this.nosAdjacentes.get(indice);
    }

    public int getQuantidadeNosAdjacentes() {
        return this.nosAdjacentes.size();
    }



}
