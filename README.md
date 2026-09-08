# Sistema de Pedidos e Entregas - Vende Mais

Este projeto consiste em um sistema de gerenciamento de pedidos e cálculo de frete/prazo de entregas para a rede varejista **Vende Mais**. A aplicação foi desenvolvida em **Java**, utilizando conceitos fundamentais de **Programação Orientada a Objetos (POO)** como Encapsulamento, Herança, Abstração, Polimorfismo e Composição.

---

##  Arquitetura do Sistema e Conceitos de POO

### 1. Abstração e Herança
- **`Entrega` (Classe Abstrata):** Define a estrutura base e obrigatória para todas as modalidades de entrega. Contém o atributo privado `destino` e os métodos abstratos `calcularFrete(Pedido pedido)` e `calcularPrazo()`.
- **Subclasses Concretas:**
  - `EntregaNormal`
  - `EntregaExpressa`
  - `RetiradaNaLoja`
  - `EntregaAgendada`
  
  Todas estendem `Entrega` e fornecem implementações específicas para as regras de cálculo e exibição de prazos.

### 2. Polimorfismo
O método `calcularFrete(Pedido pedido)` e `calcularPrazo()` comportam-se de forma dinâmica de acordo com o tipo do objeto instanciado (seja `EntregaExpressa`, `RetiradaNaLoja`, etc.), permitindo que a classe `Pedido` processe qualquer tipo de entrega de forma genérica, sem a necessidade de múltiplos blocos `if/else`.

### 3. Composição
A classe `Pedido` possui uma relação de **composição/associação** com a classe abstrata `Entrega` (`private Entrega modEntrega;`). O pedido delega a responsabilidade de calcular o valor do frete e o prazo final para o objeto de entrega associado a ele.

### 4. Encapsulamento e Validações
Todos os atributos das classes possuem visibilidade `private` e são acessados através de métodos *Getters* e *Setters*. Validações estritas foram implementadas nos métodos e construtores:
- O valor do produto e o peso devem ser maiores que zero (`> 0`).
- O nome do cliente e o destino não podem ser nulos ou vazios.
- A modalidade de entrega é **obrigatória** na criação do pedido.
- A data de entrega agendada não pode ser anterior à data atual.

---

##  Regras das Modalidades de Entrega

| Modalidade | Regra de Frete (R$) | Prazo de Entrega |
| :--- | :--- | :--- |
| **Entrega Normal** | `R$ 10,00 + (peso * 2,50)` | Até 7 dias úteis |
| **Entrega Expressa** | `R$ 20,00 + (peso * 2,50)` | Até 2 dias úteis |
| **Retirada na Loja** | `Grátis (R$ 0,00)` | Disponível em até 1 dia útil |
| **Entrega Agendada** | `R$ 35,00 + (peso * 2,50)` | Data específica informada pelo cliente |

---

##  Relatório Comparativo de Modalidades

Considerando um mesmo pedido de teste com as seguintes características:
- **Cliente:** Renato Oliveira
- **Valor dos Produtos:** R$ 1.299,90
- **Peso do Pacote:** 4,50 kg

| Modalidade | Valor dos Produtos | Frete | Total do Pedido | Prazo Estimado |
| :--- | :---: | :---: | :---: | :--- |
| **Normal** | R$ 1.299,90 | R$ 21,25 | **R$ 1.321,15** | Entrega em até 7 dias |
| **Expressa** | R$ 1.299,90 | R$ 31,25 | **R$ 1.331,15** | Entrega em até 2 dias úteis |
| **Retirada** | R$ 1.299,90 | R$ 0,00 | **R$ 1.299,90** | Retirada disponível em até 1 dia útil |
| **Agendada** | R$ 1.299,90 | R$ 46,25 | **R$ 1.346,15** | Entrega agendada para a data escolhida |

---

##  Cálculo do Valor Total

O valor total do pedido é calculado pela fórmula:

$$	ext{Total} = 	ext{Valor dos Produtos} + 	ext{Valor do Frete}$$

Onde o frete é obtido dinamicamente através do método:
```java
public double calcularTotal() {
    return valorProduto + calcularFrete();
}
```

---

##  Como Executar o Projeto

### Pré-requisitos
- **Java Development Kit (JDK)** versão 11 ou superior instalada.
- IDE de sua preferência (Eclipse, IntelliJ IDEA, VS Code) ou terminal/prompt de comando.

### Passos para execução pelo Terminal
1. Compile todas as classes `.java`:
   ```bash
   javac *.java
   ```
2. Execute a classe principal (`Main`):
   ```bash
   java Main
   ```

---

##  Estrutura de Arquivos do Projeto

```
src/
 ├── Entrega.java          # Classe Abstrata base
 ├── EntregaNormal.java    # Implementação de Entrega Normal
 ├── EntregaExpressa.java   # Implementação de Entrega Expressa
 ├── RetiradaNaLoja.java   # Implementação de Retirada na Loja
 ├── EntregaAgendada.java  # Implementação de Entrega Agendada
 ├── Pedido.java           # Classe do Pedido
 └── Main.java             # Demonstração e testes de validação
```
