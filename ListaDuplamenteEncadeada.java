public class ListaDuplamenteEncadeada {
    No cauda = null;
    No cabeca = null;
    class No {
        int dado;
        No proximo;
        No anterior;

        No(int elemento) {
            this.dado = elemento;
            this.proximo = null;
            this.anterior = null;
        }
    }

    public void insereElemento(int elemento) {
        No novoNo = new No(elemento);

        if (cabeca == null) {
            cabeca = novoNo;
            cauda = novoNo;
        } else {
            cauda.proximo = novoNo;
            novoNo.anterior = cauda;

            cauda = novoNo;
        }
    }

    public void exibeLista() {
        No atual = cabeca;
        System.out.print("Lista: ");
        while (atual != null) {
            System.out.print(atual.dado + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }

    public void removeElemento(int valor) {

        No atual = cabeca;
        No anterior;
        if ( atual.dado == valor) {
            cabeca = atual.proximo;
            atual.proximo.anterior = null;

            System.out.printf("Valor %d deletado!\n", valor);
            return;
        }
        while (atual != null){
            anterior = atual;
            atual = atual.proximo;
            if (atual.dado == valor){
                anterior.proximo = atual.proximo;
                System.out.printf("Valor %d deletado!\n", valor);
                break;
            }
            if (atual.proximo == null) {
                System.out.println("Numero inexistente!");
                break;
            }
        }
    }

    public static void main(String[] args) {
        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();

        lista.insereElemento(10);
        lista.insereElemento(20);
        lista.insereElemento(10);
        lista.insereElemento(30);

        lista.exibeLista();

        lista.removeElemento(10);
        lista.insereElemento(45);
        lista.exibeLista();
    }
}