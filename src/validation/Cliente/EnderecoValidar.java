package validation.Cliente;

// Classe não herdável
public final class EnderecoValidar {
    
    // Construtor não instanciável
    private EnderecoValidar() {}
    
    // Método que valida a entrada de dado Endereco
    public static String validar(String endereco) {
        if (endereco == null || endereco.isBlank()) { 
            throw new IllegalArgumentException("O endereço não pode estar vazio."); 
        }
        endereco = endereco.trim();

        if (!endereco.matches("^[\\p{L}0-9 .,-]+$")) {
            throw new IllegalArgumentException("O endereço contém caracteres inválidos."); 
        }

        if (endereco.length() < 5 || endereco.length() > 150) { 
            throw new IllegalArgumentException("O endereço deve ter entre 5 e 150 caracteres."); 
        }

        return endereco;
    }
}