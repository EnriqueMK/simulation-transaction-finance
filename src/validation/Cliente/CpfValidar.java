package validation.Cliente;

// Classe não herdável
public final class CpfValidar {
    
    // Construtor não instanciável
    private CpfValidar() {}

    // Método que valida a entrada de dado CPF
    public static String validar(String cpf) {
        if (cpf == null || cpf.isBlank()) { 
            throw new IllegalArgumentException("O CPF não pode estar vazio."); 
        }
        cpf = cpf.trim();
        
        if (cpf.contains(" ")) { 
            throw new IllegalArgumentException("O CPF não pode conter espaços."); 
        }
        if (!cpf.matches("^[0-9]{11}$")) { 
            throw new IllegalArgumentException("O CPF deve conter exatamente 11 números."); 
        }

        return cpf;
    }
}
