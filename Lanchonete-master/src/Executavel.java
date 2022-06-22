import java.util.Scanner;

public class Executavel {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        addPadrao();
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
                1- Adicionar ao cardápio
                2- Mostrar o cardápio
                3- Remover do cardápio
                4- Fazer pedido
                5- Finalizar
                >\040""");
        switch (sc.nextInt()) {
            case 1 -> Opcao.inserir(coletarDados());
            case 2 -> System.out.print(Opcao.mostrarOpcoes());
            case 3 -> Opcao.remover(escolherOpcao());
            case 4 -> fazerPedido();
            case 5 -> System.exit(0);
            default -> throw new OpcaoMenuInvalidaException();
        }
    }

    private static void fazerPedido() {
        Pedido pedido = new Pedido();
        int opcao;
        do {
            System.out.print("""
                    >>>>> FAÇA SEU PEDIDO <<<<<
                    1) Adicionar ao pedido
                    2) Mostrar o pedido
                    3) Remover do pedido
                    4) Finalizar pedido
                    >\040""");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1 -> {
                    System.out.println(Opcao.mostrarOpcoes());
                    pedido.adicionar(escolherOpcao());
                }
                case 2 -> System.out.println(pedido.toString());
                case 3 -> pedido.remover(escolherOpcao());
                case 4 -> {
                    System.out.println(pedido.toString());
                    System.out.println("Volte sempre!");
                }
                default -> throw new OpcaoMenuInvalidaException();
            }
        } while (opcao != 4);
    }

    private static double valor() {
        System.out.print("Informe o valor da operação: \n> ");
        return sc.nextDouble();
    }

    private static Opcao escolherOpcao() {
        System.out.print("Informe a opção desejada: \n> ");
        return Opcao.procurarOpcao(sc.nextInt());
    }

    private static Opcao coletarDados() {
        System.out.print("""
                Qual tipo deseja adicionar?
                1- Lanche
                2- Porção
                3- Bebida
                >\040""");
        int opcao = sc.nextInt();
        System.out.print("Informe a descrição: \n> ");
        String descricao = sc.next();
        System.out.print("Informe o preço: \n> R$ ");
        double preco = sc.nextDouble();
        switch (opcao) {
            case 1 -> {
                System.out.print("Informe o peso (em quilos): \n> ");
                double peso = sc.nextDouble();
                return new Lanche(descricao, preco, peso);
            }
            case 2 -> {
                System.out.print("Informe o tamanho: \n> ");
                String tamanho = sc.next();
                return new Porcao(descricao, preco, tamanho);
            }
            case 3 -> {
               System.out.print("Informe o volume (em litros): \n> ");
                double volume = sc.nextDouble();
                return new Bebida(descricao, preco, volume);
            }
            default -> throw new OpcaoMenuInvalidaException();
        }
    }
    private static void addPadrao() {
        Lanche xsalada = new Lanche("X-Salada", 12.0, 0.8);
        Lanche xtudo = new Lanche("X-Tudo", 18.0, 1.2);
        Lanche xburger = new Lanche("X-Burger", 10.0, 0.6);
        Lanche xbacon = new Lanche("X-Bacon", 15.0, 1.0);
        Opcao.inserir(xsalada);
        Opcao.inserir(xtudo);
        Opcao.inserir(xburger);
        Opcao.inserir(xbacon);

        Bebida refri200 = new Bebida("Refrigerante",5.0,0.2);
        Bebida refri500 = new Bebida("Refrigerante",10.0,0.5);
        Bebida suco200 = new Bebida("Suco",6.0,0.2);
        Bebida suco500 = new Bebida("Suco",12.0,0.5);
        Opcao.inserir(refri200);
        Opcao.inserir(refri500);
        Opcao.inserir(suco200);
        Opcao.inserir(suco500);

        Porcao fritasP = new Porcao("Batata Frita",3.5,"Pequena");
        Porcao fritasM = new Porcao("Batata Frita",4.5,"Média");
        Porcao fritasG = new Porcao("Batata Frita",5.5,"Grande");
        Porcao salada = new Porcao("Salada",8.0,"Média");
        Opcao.inserir(fritasP);
        Opcao.inserir(fritasM);
        Opcao.inserir(fritasG);
        Opcao.inserir(salada);
    }
}
