import java.time.LocalDate;

public class EntregaAgendada extends Entrega {

    private LocalDate dataEntrega;
    public EntregaAgendada(String destino, double peso, LocalDate dataEntrega) {
        super(destino);
        this.dataEntrega = LocalDate.now().plusDays(1);
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        //Verifica se há uma data de entrega ese ela e valida
        if (dataEntrega == null || dataEntrega.isBefore(LocalDate.now())) {
            //Adiciona um dia a mais da data de hoje
            this.dataEntrega = LocalDate.now().plusDays(1);
        } else {
            this.dataEntrega = dataEntrega;
        }
    }

    //Valor da entrega Agendada R$ 35,00
    @Override
    public double calcularFrete(Pedido pedido) {
        return 35 + (pedido.getPesoTotal() * 2.5);
    }

    @Override
    public String calcularPrazo() {
        return "A entrega sera realizada no dia: " + dataEntrega;
    }
}
