public class EntregaNormal extends Entrega{

    public EntregaNormal(String destino) {
        super(destino);
    }


    //Valor da entrega normal R$ 10,00
    @Override
    public double calcularFrete(Pedido pedido) {
        return 10 + (pedido.getPesoTotal() * 2.5);

    }

    @Override
    public String calcularPrazo() {
        return "Entrega em ate 7 dias";
    }
}
