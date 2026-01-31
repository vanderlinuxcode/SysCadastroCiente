package dao;

import controller.Usuario;

// Interface abstrata para operações de persistência de Usuário
public abstract class UsuarioDAO {

    // Busca usuário pelo login
    public abstract Usuario buscarPorUsuario(String login);
}
