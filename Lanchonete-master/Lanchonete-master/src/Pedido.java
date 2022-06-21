import java.util.ArrayList;
public class Pedido {
    private ArrayList<Opcao> pedido = new ArrayList<>();
    public void adicionar(Opcao opcao){
        boolean existe = false;
        for (Opcao opcao1 : pedido){
            if(opcao.equals(opcao1)){
                existe = true;
                opcao1.setQuantidade(opcao1.getQuantidade()+1);
                break;
            }
        }
        if (!existe) {
            opcao.setQuantidade(1);
            pedido.add(opcao);
        }
    }
    public void remover(Opcao opcao){
        pedido.remove(opcao);
    }
    @Override
    public String toString(){
        double total = 0;
        String cupom = """
                    > > > > > > > > PEDIDO < < < < < < < <
                    COD DESCRIÇÃO            QTD PREÇO
                    """;
        for (Opcao opcao: pedido){
            cupom += opcao.toStringPedido() + "\n";
            total += opcao.getPreco() * opcao.getQuantidade();
        }
        cupom += String.format("TOTAL:  \t\t\t\t\t R$ %.2f", total);
        return cupom;
    }
}