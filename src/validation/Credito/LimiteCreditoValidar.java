package validation.Credito;

// Classe não herdável
public final class LimiteCreditoValidar {
    
    // Construtor não instanciável
    private LimiteCreditoValidar() {}

    // Método que valida a entrada de dado Limite
    public static double validar(double limite) {
        if (limite < 200.0 || limite > 100000.0) {
            throw new IllegalArgumentException("O limite deve conter entre R$ 200 a R$ 100.000.");
        }

        return limite;
    }
}
