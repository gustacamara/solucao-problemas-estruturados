import java.util.Scanner;

public class EstruturaPilha {
    static class Pilha {
        private int capacidade;
        private int topo;
        private int[] dados;

        public Pilha(int capacidade, int[] dados) {
            this.capacidade = capacidade - 1;
            this.dados = dados;
            topo = -1;
        }

        void inserir(int novoValor) {
            if (topo != capacidade) {
                topo++;
                dados[topo] = novoValor;
            } else {
                System.out.println("Pilha cheia, libere lugares para poder adicionar!");
            }
        }

        void remover() {
            if (topo != - 1) {
                topo--;
            } else{
                System.out.println("Pilha vazia");
            }
        }

        void filaCheia() {
            if (topo == capacidade) {
                System.out.println("Pilha cheia\n");
            } else {
                System.out.println("Pilha não cheia. \n");
            }
        }

        void exibir() {
            System.out.println("Sua pilha: \n");
            for (int i = 0; i <= capacidade; i++) {
                if ( topo == i) {
                    System.out.println(dados[i] + " -> topo");
                }else{
                    System.out.println(dados[i]);

                }
            }
            System.out.println("fim.\n");
        }

        void filaVazia() {
            if (topo == -1 ) {
                System.out.println("Pilha vazia");
            } else {
                System.out.println("Pilha não vazia");
            }
        }

    }
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o tamanho da lista: ");
        int tamanho = entrada.nextInt();

        Pilha pilha = new Pilha(tamanho, new int[ tamanho ]);

        while (true) {
            System.out.println("\nEscolha oque gostaria de fazer com a sua fila: \n" +
                    "\n01 - remover" +
                    "\n02 - inserir" +
                    "\n03 - verificar se esta vazia" +
                    "\n04 - verificar se esta cheia" +
                    "\n05 - printar a fila");

            int choice = entrada.nextInt();
            switch (choice) {
                case 01:
                    pilha.remover();
                    break;

                case 02:
                    System.out.println("Escolha um valor pra inserir: ");
                    int value = entrada.nextInt();
                    pilha.inserir(value);
                    break;

                case 03:
                    System.out.println("Verificando se esta vazia!");
                    pilha.filaVazia();
                    break;

                case 04:
                    System.out.println("Verificando se esta cheia");
                    pilha.filaCheia();
                    break;


                case 05:
                    pilha.exibir();
                    break;


                default:
                    System.out.println("Encerrando programa");
                    break;
            }
            pilha.exibir();
        }

    }
}
