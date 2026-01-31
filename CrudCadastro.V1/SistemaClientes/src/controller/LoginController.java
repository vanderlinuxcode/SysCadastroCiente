package controller;

import dao.UsuarioDAOImpl;

/**
 * Controller responsável pela autenticação de usuários.
 */
public class LoginController {
    private UsuarioDAOImpl usuarioDAO;

    // Construtor: inicializa o DAO de usuário
    public LoginController() {
        this.usuarioDAO = new UsuarioDAOImpl();
    }

    // Autentica usuário comparando senha informada com senha criptografada
    public boolean autenticar(String usuario, String senha) {
        Usuario u = usuarioDAO.buscarPorUsuario(usuario);
        if (u == null) return false;
        return BCrypt.checkpw(senha, u.getSenhaCriptografada());
    }
}
