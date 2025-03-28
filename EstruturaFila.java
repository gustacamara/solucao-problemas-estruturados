import java.util.Scanner;

public class EstruturaFila {
    static class Pilha {
        private char[] fila;
        private int maximo;
        private int inicio;
        private int fim;

        public Pilha(int maximo, char[] fila) {
            this.maximo = maximo;
            this.fila = fila;
            fim = 0;
            inicio = 0;
        }
    

        public void inserir(char dado) {
            if(!ehCheia()) {
                fim++;
                fim = fim % maximo;
                fila[fim] = dado;
            }else{
                System.out.println("Fila está cheia, não é possivel inserir!");
            }
        }

        public void remover() {
            if(!ehVazia()) {
                fila[inicio % maximo] = 0;
                inicio++;
                inicio = inicio % maximo;
            }else{
                System.out.println("Fila está vazia, não é possivel remover!");
            }
        }

        public void exibir() {
            System.out.println("Sua pilha: \n");
            for (int i = 0; i <= maximo - 1; i++) {
                if ( fim == i) {
                    System.out.println(fila[i] + " -> topo");
                }else if (inicio == i) {
                    System.out.println(fila[i] + " -> primeiro");
                }else {
                    System.out.println(fila[i]);
                }
            }
            System.out.println("fim.\n");
        }

        public boolean ehCheia() {
            int aux = fim + 1;
            return (aux % maximo == inicio);
        }

        public boolean ehVazia() {
            int aux = inicio + 1;
            return  (aux % maximo == fim);
        }

        public int getMaximo() {
            return maximo;
        }

        public int getInicio() {
            return inicio;
        }

        public int getFim() {
            return fim;
        }
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o tamanho da lista: ");
        int tamanho = entrada.nextInt();

        Pilha pilha = new Pilha(tamanho, new char[tamanho]);

        while (true) {
            System.out.println("\nEscolha oque gostaria de fazer com a sua fila: \n" +
                    "\n1 - remover" +
                    "\n2 - inserir" +
                    "\n3 - verificar se esta vazia" +
                    "\n4 - verificar se esta cheia" +
                    "\n5 - printar a fila" +
                    "\n6 - capacidade" +
                    "\n7 - ultimo" +
                    "\n8 - primeiro");

            int choice = entrada.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Removendo!");
                    pilha.remover();
                    break;

                case 2:
                    System.out.println("Escolha um valor pra inserir: ");
                    char value = entrada.next().charAt(0);
                    pilha.inserir(value);
                    break;

                case 3:
                    System.out.println("Verificando se esta vazia: " + pilha.ehVazia());
                    break;

                case 4:
                    System.out.println("Verificando se esta cheia: " + pilha.ehCheia());
                    break;


                case 5:
                    pilha.exibir();
                    break;

                case 6:
                    System.out.println("Capacidade: " + pilha.getMaximo());
                    break;

                case 7:
                    System.out.println("Topo: " + pilha.getFim());
                    break;

                case 8:
                    System.out.println("Fundo: " + pilha.getInicio());
                    break;

                default:
                    System.out.println("Encerrando programa");
                    break;
            }
            pilha.exibir();
        }

    }
}

