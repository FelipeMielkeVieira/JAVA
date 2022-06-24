import java.util.ArrayList;
import java.util.List;

public class Pedido implements Interface {
    private List<Opcao> pedido = new ArrayList<>();
    @Override
    public void inserir(){
        Opcao escolha = Executavel.escolherOpcao();
        //Contains retorna booleano dizendo se existe o item dentro da lista
        if (pedido.contains(escolha)) {
            int posicao = pedido.indexOf(escolha);
            Opcao opcao = pedido.get(posicao);
            opcao.setQuantidade(opcao.getQuantidade()+1);
        } else {
            escolha.setQuantidade(1);
            pedido.add(escolha);
        }
//        for (Opcao opcao : pedido){
//            if(escolha.equals(opcao)){
//                opcao.setQuantidade(opcao.getQuantidade()+1);
//                break;
//            }
//        }
//        if (!existe) {
//            escolha.setQuantidade(1);
//            pedido.add(escolha);
//        }
    }

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