public class EntregaExpressa extends Entrega{
    public EntregaExpressa(String destino) {
        super(destino);
    }


    //Valor da entrega Expressa R$ 20,00
    @Override
    public double calcularFrete(Pedido pedido) {
        return 20 + (pedido.getPesoTotal() * 2.5);
    }

    @Override
    public String calcularPrazo() {
        return "Entrega em ate 2 dias úteis";
    }
}
