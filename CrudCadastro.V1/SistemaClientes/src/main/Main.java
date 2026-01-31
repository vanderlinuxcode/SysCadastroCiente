package main;

import view.ClienteViewFormSwing;

// Classe principal que inicializa a aplicação
public class Main {

    // Método main: ponto de entrada da aplicação
    public static void main(String[] args) {
        ClienteViewFormSwing view = new ClienteViewFormSwing();
        view.createFormPanel();
    }
}
