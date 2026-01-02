package validation.Cliente;

// Classe não herdável
public final class TelefoneValidar {

    // Construtor não instanciável
    private TelefoneValidar() {}
    
    // Método que valida a entrada de dado Telefone
    public static String validar(String telefone) {
        if (telefone == null || telefone.isBlank()) { 
            throw new IllegalArgumentException("O telefone não pode estar vazio."); 
        }
        telefone = telefone.trim();
        
        if (telefone.contains(" ")) { 
            throw new IllegalArgumentException("O telefone não pode conter espaços."); 
        }

        if (!telefone.matches("^[0-9]{10,11}$")) { 
            throw new IllegalArgumentException("O telefone deve conter entre 10 e 11 números."); 
        }

        return telefone;
    }
}