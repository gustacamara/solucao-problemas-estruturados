public class ArvoreBinaria {
    private No raiz;

    class No {
        private int info;
        private No direita;
        private No esquerda;

        public No getDireita() {
            return direita;
        }

        public void setDireita(No direita) {
            this.direita = direita;
        }

        public No getEsquerda() {
            return esquerda;
        }

        public void setEsquerda(No esquerda) {
            this.esquerda = esquerda;
        }

        public No(int info) {
            this.info = info;
            this.esquerda = null;
            this.direita = null;
        }
    }
        void inserir(int info) {
            raiz = inserir(raiz, info);
        }

        No inserir(No node, int info) {
            if(node == null) {
                return new No(info);
            }
            if(info < node.info) {
                node.esquerda = inserir(node.esquerda, info);
            } else if ( info > node.info) {
                node.direita = inserir(node.direita, info);
            }
            return node;
        }

        void remover(int info){
            raiz = remover(raiz, info);
        }

        No remover(No node, int info) {
            if (node == null) return null;
            if (info > node.info) {
                node.esquerda = remover(node.esquerda, info);
            }
            else if (info < node.info) {
                node.direita = remover(node.direita, info);
            }else{

                if( node.esquerda != null && node.direita != null) {
                    No maiorEsquerda = encontrarMaior(node.esquerda);
                    node.info = maiorEsquerda.info;
                    node.esquerda = remover(node.esquerda, maiorEsquerda.info);
                } else if (node.esquerda != null) {
                    node = node.esquerda;
                }else {
                    node = node.direita;
                }

            }
            return node;
        }

        No encontrarMaior(No node) {
            while(node.esquerda != null) {
                node = node.esquerda;
            }
            return node;
        }

        void desenhar(No node, int nivel) {
            if (node == null) return;
            desenhar(node.direita, nivel + 1);
            for (int i = 0; i < nivel; i++) System.out.print("\t");
            System.out.println(node.info);
            desenhar(node.esquerda, nivel + 1);
        }

    void emOrdem(No node) {
        if (node == null) return;
        emOrdem(node.esquerda);
        System.out.print(node.info + " ");
        emOrdem(node.direita);
    }
    void preOrdem(No node) {
        if (node != null) {
            System.out.print(node.info + " ");
            preOrdem(node.esquerda);
            preOrdem(node.direita);
        }
    }
    void posOrdem(No node) {
        if (node != null) {
            posOrdem(node.esquerda);
            posOrdem(node.direita);
            System.out.print(node.info + " ");
        }
    }


    public static void main(String args[]) {
        ArvoreBinaria arvore = new ArvoreBinaria();
        arvore.inserir(10);
        arvore.inserir(5);
        arvore.inserir(15);
        arvore.inserir(3);
        arvore.inserir(7);
        arvore.inserir(12);
        arvore.inserir(18);

        arvore.desenhar(arvore.raiz, 0);

        System.out.println("pós ordem");
        arvore.posOrdem(arvore.raiz);
        System.out.println("\n");

        System.out.println("pre ordem");
        arvore.preOrdem(arvore.raiz);
        System.out.println("\n");

        System.out.println("em ordem");
        arvore.emOrdem(arvore.raiz);
        System.out.println("\n");
    }
}
