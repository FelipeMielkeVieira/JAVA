import java.util.Scanner;

public class Executavel {
    private static Scanner sc = new Scanner(System.in);
    private static Banco banco = new Banco();

    public static void main(String[] args) {
        do {
            try {
                menuPrincipal();
            } catch (RuntimeException exception) {
                System.out.println(exception.getClass().getSimpleName() + ": " + exception.getMessage());
            }
        } while (true);
    }

    private static void menuPrincipal() {
        System.out.print("""
                >>>>> MENU PRINCIPAL <<<<<
                1- Criar conta
                2- Selecionar conta
                3- Remover conta
                4- Gerar relatório
                5- Finalizar
                >\040""");
        switch (sc.nextInt()) {
            case 1 -> banco.inserir(coletarDados());
            case 2 -> menuConta(escolherConta());
            case 3 -> banco.remover(escolherConta());
            case 4 -> System.out.print(banco.mostrarContas());
            case 5 -> System.exit(0);
            default -> throw new OpcaoInvalidaException();
        }
    }

    private static void menuConta(ContaBancaria conta) {
        int opcao;
        do {
            System.out.print("""
                    >>>>> MENU CONTA <<<<<
                    1) Depositar
                    2) Sacar
                    3) Transferir
                    4) Gerar relatório
                    5) Retornar ao menu anterior
                    >\040""");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1 -> conta.depositar(valor());
                case 2 -> conta.sacar(valor());
                case 3 -> conta.transferir(escolherConta(), valor());
                case 4 -> System.out.println(conta.mostrarDados());
                case 5 -> System.out.println("Volte sempre!");
                default -> throw new OpcaoInvalidaException();
            }
        } while (opcao != 5);
    }

    private static double valor() {
        System.out.print("Informe o valor da operação: \n> ");
        return sc.nextDouble();
    }

    private static ContaBancaria escolherConta() {
        System.out.print("Informe o número da conta: \n> ");
        return banco.procurarConta(sc.nextInt());
    }

    private static ContaBancaria coletarDados() {
        System.out.print("""
                Qual conta deseja criar?
                1- Corrente
                2- Poupança
                >\040""");
        int opcao = sc.nextInt();
        switch (opcao) {
            case 1 -> {
                System.out.print("Informe a taxa de operação: \n> ");
                double taxaDeOperacao = sc.nextDouble();
                System.out.print("Informe o limite da conta: \n> ");
                double limite = sc.nextDouble();
                return new ContaCorrente(taxaDeOperacao, limite);
            }
            case 2 -> {
                System.out.print("Informe a taxa de operação: \n> ");
                double taxaDeOperacao = sc.nextDouble();
                return new ContaPoupanca(taxaDeOperacao);
            }
            default -> throw new OpcaoInvalidaException();
        }
    }
}
