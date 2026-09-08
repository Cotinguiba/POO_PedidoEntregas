public class RetiradaLoja extends Entrega{
    public RetiradaLoja(String destino) {
        super(destino);
    }

    //Retirada loja o frete e gratis
    @Override
    public double calcularFrete(Pedido pedido) {
        return 0;
    }

    @Override
    public String calcularPrazo() {
        return "Retirada disponivel em até 1 dia útil";
    }
}
