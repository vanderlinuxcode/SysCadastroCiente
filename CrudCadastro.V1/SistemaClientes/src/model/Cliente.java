package model;

// Classe que representa a entidade Cliente no sistema
public class Cliente {
    // Atributos encapsulados
    private int id;
    private String nome;
    private int idade;
    private String email;
    private String telefone;
    private String cpf;
    
    // Construtor padrão
    public Cliente() {}
    
    // Construtor com parâmetros
    public Cliente(int id, String nome, int idade, String email, String telefone, String cpf) {
        // Inicializa atributos da entidade Cliente
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;        
    }

    // Métodos getters
    public int getId() { return id; }
    public String getNome() { return nome; }
    public int getIdade() { return idade; }
    public String getEmail() { return email; }
    public String getTelefone() { return telefone; }
    public String getCpf() { return cpf; }

    // Métodos setters
    public void setId(int id) { this.id = id; }
    public void setNome(String nome) { this.nome = nome; }
    public void setIdade(int idade) { this.idade = idade; }
    public void setEmail(String email) { this.email = email; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public void setCpf(String cpf) { this.cpf = cpf; }
}
