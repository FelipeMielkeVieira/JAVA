import java.util.ArrayList;
import java.util.List;

public class Pedido implements Interface {
    private List<Opcao> pedido = new ArrayList<>();

    @Override
    public void inserir(){
        Opcao escolha = Executavel.escolherOpcao();
        if(pedido.contains(escolha)) {
            int posicao = pedido.indexOf(escolha);
            Opcao opcao1 = pedido.get(posicao);
            opcao1.setQuantidade(opcao1.getQuantidade()+1);
        } else {
            escolha.setQuantidade(1);
            pedido.add(escolha);
        }
    }

    @Override
    public void remover(){
        pedido.remove(Executavel.escolherOpcao());
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