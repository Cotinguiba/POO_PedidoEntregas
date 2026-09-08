public abstract class Entrega {
    private String destino;


    public Entrega(String destino) {

        //Valida se há um destino
        if (destino == null || destino.trim().isEmpty()) {
            //Retorna uma mensagem caso o destino esteja vazio
            throw new IllegalArgumentException("Insira um destino !");
        } else {
            this.destino = destino;
        }
    }

    public String getDestino() {
        return destino;
    }

    //Construtor obrigatorio para calcular o frete
    public abstract  double calcularFrete(Pedido pedido);

    //Construtor obrigatorio para calcular o prazo
    public abstract String calcularPrazo();

}

