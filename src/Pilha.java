
public class Pilha {
    private String[] elementos;
    private int topo; 

    public Pilha(int capacidade) {
        elementos = new String[capacidade];
        topo = 0;
    }

    
    public boolean empilhar(String valor) {
        if (estaCheia()) {
            return false;
        }
        elementos[topo] = valor;
        topo++;
        return true;
    }

    
    public String desempilhar() {
        if (estaVazia()) {
            return null;
        }
        topo--;
        String removido = elementos[topo];
        elementos[topo] = null;
        return removido;
    }

    
    public String consultarTopo() {
        if (estaVazia()) {
            return null;
        }
        return elementos[topo - 1];
    }

    public boolean estaVazia() {
        return topo == 0;
    }

    public boolean estaCheia() {
        return topo == elementos.length;
    }

    public int tamanho() {
        return topo;
    }
}
