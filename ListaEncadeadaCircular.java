public class ListaEncadeadaCircular {
  No inicio = null;

  class No {
    int dado;
    No proximo;

    No(int elemento) {
      this.dado = elemento;
      this.proximo = null;
    }
  }

  public void insereElemento(int elemento) {
    No novoNo = new No(elemento);

    if (inicio == null) {
      inicio = novoNo;
      novoNo.proximo = inicio;
    } else {
      No atual = inicio;
      while (atual.proximo != inicio) {
        atual = atual.proximo;
      }
      atual.proximo = novoNo;
      novoNo.proximo = inicio;
    }
  }

  public void exibeLista() {
    No atual = inicio;
    System.out.print("Lista: ");
    while (atual.proximo != inicio) {
      System.out.print(atual.dado + " ");
      atual = atual.proximo;
    }
    System.out.print(atual.dado + " ");
    System.out.println();
  }

  public void removeElemento(int valor) {

    No atual = inicio;
    No anterior;
//    lida com o primerio valor
    if ( atual.dado == valor) {
      No novoInicio = atual.proximo;

      while(atual.proximo != inicio){
        atual = atual.proximo;
      }
      atual.proximo = novoInicio;
      inicio = novoInicio;
      System.out.printf("Valor %d deletado!\n", valor);
      return;
    }

    while (atual.proximo != inicio){
      anterior = atual;
      atual = atual.proximo;
      if (atual.dado == valor){
        anterior.proximo = atual.proximo;
        System.out.printf("Valor %d deletado!\n", valor);
        break;
      }
      if (atual.proximo == inicio) {
        System.out.println("Numero inexistente!");
        break;
      }
    }
  }

  public static void main(String[] args) {
    ListaEncadeadaCircular lista = new ListaEncadeadaCircular();
    lista.insereElemento(10);
    lista.insereElemento(30);
    lista.insereElemento(10);
    lista.insereElemento(30);
    lista.insereElemento(50);
    lista.insereElemento(60);
    lista.insereElemento(70);


    lista.exibeLista();
    lista.removeElemento(70);
    lista.removeElemento(100);
    lista.insereElemento(90);
    lista.removeElemento(90);

    lista.exibeLista();
  }
}


