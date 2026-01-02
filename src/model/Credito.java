package model;

import java.time.YearMonth;
import java.util.concurrent.ThreadLocalRandom;

import service.ProcessarTransacao;
import validation.Credito.LimiteCreditoValidar;

public class Credito implements Cartao {

    private Cliente cliente;
    private final String numero;
    private final YearMonth vencimento;
    private final int cvv;
    private double limite;
    private double limiteDisponivel;
    
    public Credito(Cliente cliente, double limite) {
        this.cliente = cliente;

        this.numero = (ThreadLocalRandom.current().nextInt(1000, 10000)) + " " +
        (ThreadLocalRandom.current().nextInt(1000, 10000)) + " " +
        (ThreadLocalRandom.current().nextInt(1000, 10000)) + " " +
        (ThreadLocalRandom.current().nextInt(1000, 10000));
        
        YearMonth venc = YearMonth.now().plusYears(3);

        this.vencimento = venc;
        this.cvv = ThreadLocalRandom.current().nextInt(100, 1000);
        this.limite = LimiteCreditoValidar.validar(limite);
        this.limiteDisponivel = limite;
    }

    // Getters
    public Cliente getCliente() {
        return cliente;
    }
    public String getNumero() {
        return numero;
    }
    public YearMonth getVencimento() {
        return vencimento;
    }
    public int getCvv() {
        return cvv;
    }
    public double getLimite() {
        return limite;
    }
    public double getLimiteDisponivel() {
        return limiteDisponivel;
    }

    // Setters 
    public void setLimite(double limite) {
        this.limite = limite;
    }
    public void setLimiteDisponivel(double limiteDisponivel) {
        this.limiteDisponivel = limiteDisponivel;
    }

    @Override
    public String getTipo() {
        return "Crédito";
    }
    @Override
    public void informacoesCartao() {
        System.out.println("\nCADASTRO DO SEU CARTÃO DE CRÉDITO");
        System.out.println("Número do Cartão: " + getNumero());
        System.out.println("CVV: " + getCvv());
        System.out.println("Vencimento: " + getVencimento());
        System.out.println("Limite Liberado: " + getLimite());
        System.out.println("Limite Disponível " + getLimiteDisponivel());
        System.out.println();
    }

    // Necessário criar validador de transação
    @Override
    public boolean autorizarPagamento(double valor) {
        return ProcessarTransacao.processamento(this, valor);
    }
}
