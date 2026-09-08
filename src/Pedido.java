public class Pedido {

    private int numCliente;
    private String nomeCliente;
    private float valorProduto;
    private double pesoTotal;
    private Entrega modEntrega;

    public Pedido(){
    }

    public int getNumCliente() {

        return numCliente;
    }

    public void setNumCliente(int numCliente) {

        this.numCliente = numCliente;
    }

    public String getNomeCliente() {

        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        //Confere se há um nome cliente
        if (nomeCliente == null || nomeCliente.trim().isEmpty()){
            throw new IllegalArgumentException("Insira um nome !!!");
        }else {
            this.nomeCliente = nomeCliente;
        }
    }

    public float getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(float valorProduto) {
        if (valorProduto <= 0) {
            throw new IllegalArgumentException("O valor do produto nao pode ser igual a R$ 0,00 /nPor favor insira um valor correto !");
        } else {
            this.valorProduto = valorProduto;
        }
    }

    public double getPesoTotal() {
        return pesoTotal;
    }

    public void setPesoTotal(double pesoTotal) {
        if (pesoTotal <= 0) {
            throw new IllegalArgumentException("Peso dos produtos nao pode ser igual a 0 !!!");
        } else {
            this.pesoTotal = pesoTotal;
        }
    }

    public Entrega getModEntrega() {
        return modEntrega;
    }

    public void setModEntrega(Entrega modEntrega) {
        this.modEntrega = modEntrega;
    }

    public double calcularFrete(Pedido pedido) {
        return modEntrega.calcularFrete(pedido);
    }

    public double calcularTotal(){

        return valorProduto + calcularFrete(this);
    }

    public String calcularPrazo() {
        return modEntrega.calcularPrazo();
    }

    public void exibirResumo() {
        System.out.println("Pedido: " + numCliente);
        System.out.println("Cliente: " + nomeCliente);
        System.out.println("Modalidade: " + modEntrega.getClass().getSimpleName());
        System.out.println("Produtos: R$ " + String.format("%.2f", valorProduto));
        System.out.println("Peso: " + String.format("%.2f", pesoTotal) + " kg");
        System.out.println("Frete: R$ " + String.format("%.2f", calcularFrete(this)));
        System.out.println("Total: R$ " + String.format("%.2f", calcularTotal()));
        System.out.println("Prazo: " + calcularPrazo());
        System.out.println("----------------------------------------");
    }
}
