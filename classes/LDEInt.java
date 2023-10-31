package classes;

public class LDEInt {
    private LDENode primeiro;
    private LDENode ultimo;
    private int qtd;
   public void removerValor(int valor){
    LDENode anterior, proximo ,aux = primeiro;
    while (aux != null) {
     anterior = aux.getAnt();
     proximo = aux.getProx();
     if (anterior == null) {
     primeiro = proximo;
     if (proximo != null) {
        proximo.setAnt(null);
     }
     }
    }

}
    public void inserirOrdenadosRepetidos(int valor){
     LDENode novo = new LDENode(valor);
     LDENode aux, anterior;
     if (isEmpty()) {
        primeiro = novo;
        ultimo = novo;
        qtd++;
        System.out.println("INSERÇÃO: OK");
     } else if (valor < primeiro.getInfo()) {
        primeiro.setAnt(novo);
        novo.setProx(primeiro);
        primeiro = novo;
        qtd++;
        System.out.println("INSERÇÃO: OK");
     } else if (valor >= ultimo.getInfo()) {
            ultimo.setProx(novo);
            novo.setAnt(ultimo);
            ultimo = novo;
            qtd++;
            System.out.println("INSERÇÃO: OK");
     } else {
        aux = primeiro;
        while (aux != null) {
            if (aux.getInfo()>= valor) {
                anterior = aux.getAnt();
                anterior.setProx(novo);
                novo.setAnt(anterior);
                novo.setProx(aux);
                aux.setAnt(novo);
               qtd++;
               System.out.println("INSERÇÃO: OK");
            } else {
              aux =  aux.getProx();
            }
        }
     } 
     }


    
    public void inserirOrdenado(int valor) {
        LDENode novo = new LDENode(valor);
        LDENode aux, anterior;
        if (this.isEmpty() == true) {
            this.primeiro = novo;
            this.ultimo = novo;
            this.qtd++;
            System.out.println("Inserção efetuada!");
        } else if (valor < this.primeiro.getInfo()) {
            this.primeiro.setAnt(novo);
            novo.setProx(this.primeiro);
            this.primeiro = novo;
            this.qtd++;
            System.out.println("Inserção efetuada!");
        } else if (valor == this.primeiro.getInfo()) {
            System.out.println("Valor repetido!");
        } else if (valor > this.ultimo.getInfo()) {
            this.ultimo.setProx(novo);
            novo.setAnt(this.ultimo);
            this.ultimo = novo;
            this.qtd++;
            System.out.println("Inserção efetuada!");
        } else if (valor == this.ultimo.getInfo()) {
            System.out.println("Valor repetido!");
        } else { // inserção no "meio" da lista
            aux = this.primeiro;
            while (aux != null) {
                if (aux.getInfo() == valor) {
                    System.out.println("Valor repetido! Bye bye!");
                    return;
                } else if (aux.getInfo() > valor) { // achei ponto de inserção
                    anterior = aux.getAnt();
                    anterior.setProx(novo);
                    novo.setAnt(anterior);
                    novo.setProx(aux);
                    aux.setAnt(novo);
                    this.qtd++;
                    System.out.println("Inserção efetuada!");
                    return;
                } else {
                    aux = aux.getProx();
                }
            }
        }
    }

    public boolean isEmpty() { // teste forte!
        if (this.primeiro == null && this.ultimo == null && this.qtd == 0) {
            return true;
        } else {
            return false;
        }
    }

    private LDENode buscar(int valor) { // BUSCA SEQUENCIAL MELHORADA
        LDENode aux = this.primeiro;
        boolean achou = false;
        while (aux != null) {
            if (aux.getInfo() == valor) {
                achou = true;
                break;
            } 
            else if (aux.getInfo() > valor) {
                break;
            }
            else {
                aux = aux.getProx();
            }
        }
        if (achou == false) {
            return null;
        } else {
            return aux;
        }
    }

    public void remover(int valor) { // BUSCAR E REMOVER
        if (this.isEmpty()) {
            System.out.println("Lista vazia!");
        } else if (this.primeiro.getInfo() == valor) {
            this.primeiro = this.primeiro.getProx();
            this.qtd--;
            if (this.qtd == 0) {
                this.ultimo = null;
            } else {
                this.primeiro.setAnt(null);
            }
            System.out.println("Remoção efetuada!");
        } 
        else if (valor < this.primeiro.getInfo()) {
            System.out.println("Valor não encontrado!");
        }
        else if (this.ultimo.getInfo() == valor) {
            this.ultimo = this.ultimo.getAnt();
            this.ultimo.setProx(null);
            this.qtd--;
            System.out.println("Remoção efetuada!");
        }
        else if (valor > this.ultimo.getInfo()) {
            System.out.println("Valor não encontrado!");
        }
        else { // meio
            LDENode retorno = this.buscar(valor);
            LDENode anterior, proximo;
            if (retorno == null) {
                System.out.println("Valor não encontrado.");
            } else {
                anterior = retorno.getAnt();
                proximo = retorno.getProx();
                anterior.setProx(proximo);
                proximo.setAnt(anterior);
                qtd--;
                System.out.println("Remoção efetuada!");
            }
        }
    }

    public void exibirTodos() {
        LDENode aux = this.primeiro;

        if (this.isEmpty()) {
            System.out.println("Lista vazia!");
        } else {
            while (aux != null) {
                System.out.println(aux.getInfo());
                aux = aux.getProx();
            }
        }
    }
}
