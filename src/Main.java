import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Entrega entregaSelecionada = null;
        boolean opcaoValida = false;

        // Repete o menu até que o usuário selecione uma opção válida
        while (!opcaoValida) {
            System.out.println("=== VENDEMAIS ===");
            System.out.println("Selecione a modalidade de entrega do pedido:");
            System.out.println("1: Entrega Normal (7 dias)");
            System.out.println("2: Entrega Expressa (2 dias)");
            System.out.println("3: Retirada na Loja (Grátis)");
            System.out.println("4: Entrega Agendada");

            System.out.print("Digite a opção desejada: ");
            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    System.out.print("Informe o endereço de entrega: ");
                    String destinoNormal = scanner.nextLine();
                    entregaSelecionada = new EntregaNormal(destinoNormal);
                    opcaoValida = true; // Marca como válida para sair do loop
                    break;

                case 2:
                    System.out.print("Informe o endereço para entrega expressa: ");
                    String destinoExpressa = scanner.nextLine();
                    entregaSelecionada = new EntregaExpressa(destinoExpressa);
                    opcaoValida = true;
                    break;

                case 3:
                    System.out.print("Informe a loja para retirada: ");
                    String destinoRetirada = scanner.nextLine();
                    entregaSelecionada = new RetiradaLoja(destinoRetirada);
                    opcaoValida = true;
                    break;

                case 4:
                    System.out.print("Informe o endereço para entrega agendada: ");
                    String destinoAgendada = scanner.nextLine();

                    System.out.print("Agendar para daqui a quantos dias? ");
                    int dias = Integer.parseInt(scanner.nextLine());
                    LocalDate dataAgendada = LocalDate.now().plusDays(dias);

                    entregaSelecionada = new EntregaAgendada(destinoAgendada, 0, dataAgendada);
                    opcaoValida = true;
                    break;

                default:
                    System.out.println("\n[ERRO] Opção inválida! Por favor, escolha novamente.\n");
                    // Não altera 'opcaoValida', fazendo o 'while' repetir o menu
                    break;
            }
        }

        Pedido pedido = new Pedido();

        int numeroAleatorio = (int) (Math.random() * 1000);
        pedido.setNumCliente(numeroAleatorio);

        System.out.print("Insira o nome do cliente: ");
        pedido.setNomeCliente(scanner.nextLine());

        System.out.print("Insira o valor total dos produtos (R$): ");
        pedido.setValorProduto(Float.parseFloat(scanner.nextLine()));

        System.out.print("Insira o peso total do pacote (kg): ");
        pedido.setPesoTotal(Double.parseDouble(scanner.nextLine()));

        pedido.setModEntrega(entregaSelecionada);

        System.out.println("\n=== RESUMO DO PEDIDO ===");
        pedido.exibirResumo();

        scanner.close();
    }
}