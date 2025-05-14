public class ArvoreBinariaEstatica {

    Node raiz = null;

    class Node {
        public Node esquerda;
        public Node direita;
        public char dado;
        public int nivel;

        public Node(char dado) {
            this.dado = dado;
            esquerda = null;
            direita = null;
            nivel = 0;
        }

        public Node(char dado, int nivel) {
            this.dado = dado;
            esquerda = null;
            direita = null;
            this.nivel = nivel;
        }

    }

    public void inserir(char c, int index) {
        raiz = inserir(raiz, c, index);
    }



    public Node inserir(Node node, char c, int index) {
        if (node == null) {
            return new Node (c);
        }

        if (index == node.nivel * 2 + 2) {
            node.direita = new Node(c, index);
            return node;
        }
        if (index == node.nivel * 2 + 1) {
            node.esquerda = new Node(c, index);
            return node;
        }

        inserir(node.esquerda, c, index);
        inserir(node.direita, c, index);

        return node;
    }
    void desenhar(Node node, int nivel) {
        if (node == null) return;
        desenhar(node.direita, nivel + 1);
        for (int i = 0; i < nivel; i++) System.out.print("\t");
        System.out.println(node.dado);
        desenhar(node.esquerda, nivel + 1);
    }

    public static void main(String[] args) {
        char[] ordem = {'a', 'b', 'c', 'd', 'e', ' ', 'f', ' ', ' ', 'g', ' ', ' ', ' ', 'h', 'i'};
        ArvoreBinariaEstatica arvore = new ArvoreBinariaEstatica();

        int i = 0;
        for (char c: ordem) {
            arvore.inserir(c, i);
            arvore.desenhar(arvore.raiz, 0);
            i++;
        }
    }
}
