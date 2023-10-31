package classes;

public class LDENode {
    private LDENode ant;
    private Integer info;
    private LDENode prox;
    
    public LDENode (Integer valor) {
        this.info = valor;
    }
    
    public void setInfo (Integer valor) {
        this.info = valor;
    }
    
    public void setProx (LDENode novoProx) {
        this.prox = novoProx;
    }
    
    public void setAnt (LDENode novoAnt) {
        this.ant = novoAnt;
    }
    
    public Integer getInfo() {
        return this.info;
    }
    
    public LDENode getProx () {
        return this.prox;
    }
    
    public LDENode getAnt () {
        return this.ant;
    }
}
