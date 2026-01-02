package validation.Credito;

import model.Credito;
import model.Cliente;

// Classe não herdável
public final class CartaoCreditoValidar {

    // Construtor não instanciável
    private CartaoCreditoValidar() {}

    // Método que valida a entrada de dado Cartao
    public static void validar(Cliente cliente, Credito cartao) {
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não pode ser nulo.");
        }

        if (cartao == null) {
            throw new IllegalArgumentException("Cartão não pode ser nulo.");
        }

        if (cliente.getCartao() != null) {
            throw new IllegalStateException("Cliente já possui cartão.");
        }

        if (cartao.getCliente() != cliente) {
            throw new IllegalArgumentException("Cartão não pertence a este cliente.");
        }
    }
}
