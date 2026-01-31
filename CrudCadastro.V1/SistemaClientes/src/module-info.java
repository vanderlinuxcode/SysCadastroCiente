/**
 * Módulo principal do sistema de cadastro de clientes.
 * Define dependências necessárias para JDBC e Swing.
 */
module SistemaClientes {
    requires jdk.jdi;
    requires java.sql;
    requires java.desktop; // necessário para javax.swing, java.awt, etc.
}
