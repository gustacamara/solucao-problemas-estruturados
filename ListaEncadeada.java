import javax.swing.JOptionPane;

public class ListaEncadeada {   
    class No {
        int dado;
        No proximo;

        No(int elemento) {
            this.dado = elemento;
            this.proximo = null;
        }
    }
    No inicio = null;

    public void insereElemento(int elemento) {
        No novoNo = new No(elemento);

        if (inicio == null) {
            inicio = novoNo;
        } else {
            No atual = inicio;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novoNo;
        }
    }

    public void exibeLista() {
        No atual = inicio;
        System.out.print("Lista: ");
        while (atual != null) {
            System.out.print(atual.dado + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }

    public void removeElemento(int valor) {

        No atual = inicio;
        No anterior;
        if ( atual.dado == valor) {
            inicio = atual.proximo;
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
        ListaEncadeada lista = new ListaEncadeada();

        lista.insereElemento(10);
        lista.insereElemento(20);
        lista.insereElemento(10);
        lista.insereElemento(30);

        lista.exibeLista();

        lista.removeElemento(10);
        lista.exibeLista();
    }
}


