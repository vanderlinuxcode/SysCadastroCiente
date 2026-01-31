package dao;

import model.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// DAO responsável pelas operações de persistência de Cliente
public class ClienteDAO {

    // Insere um novo cliente no banco de dados
    public void inserir(Cliente cliente) {
        String sql = "INSERT INTO clientes (nome, idade, email, telefone, cpf) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setInt(2, cliente.getIdade());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefone());
            stmt.setString(5, cliente.getCpf());
            stmt.executeUpdate();
            System.out.println("Cliente cadastrado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar cliente: " + e.getMessage());
        }
    }

    // Lista todos os clientes cadastrados
    public List<Cliente> listar() {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM clientes";
        try (Connection conn = Conexao.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setIdade(rs.getInt("idade"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setCpf(rs.getString("cpf"));
                lista.add(cliente);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar clientes: " + e.getMessage());
        }
        return lista;
    }

    // Atualiza os dados de um cliente existente
    public boolean atualizar(Cliente cliente) {
        String sql = "UPDATE clientes SET nome = ?, idade = ?, email = ?, telefone = ?, cpf = ? WHERE id = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome().trim());
            stmt.setInt(2, cliente.getIdade());
            stmt.setString(3, cliente.getEmail().trim());
            stmt.setString(4, cliente.getTelefone().trim());
            stmt.setString(5, cliente.getCpf().trim());
            stmt.setInt(6, cliente.getId());
            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar cliente: " + e.getMessage());
            return false;
        }
    }

    // Exclui um cliente pelo ID
    public void excluir(int id) {
        String sql = "DELETE FROM clientes WHERE id = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Cliente excluído com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao excluir cliente: " + e.getMessage());
        }
    }

    // Testa a conexão com o banco de dados
    public boolean testarConexao() {
        return Conexao.testarConexao();
    }
}
