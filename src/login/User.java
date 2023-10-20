package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/** A classe User é responsável por estabelecer uma conexão com o banco de dados,
 * autenticar o login do usuário e armazenar o nome do usuário.
 */
public class User {
    /** Método conectarBD: 
     * Cria uma conexão com o banco de dados.
     * @return Retorna a conexão para ser usada em outros métodos. 
     */
    public Connection conectarBD(){
        Connection conn = null;
        try{
            Class.forName("com.mysql.Driver.Manager").newInstance();
            String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";
            conn =  DriverManager.getConnection(url);
        }catch (Exception e) {
            // Trata exceções, se ocorrerem
        }
        return conn;
    }

    /* As variaveis da classe são declaradas e inicializadas. */
    public String nome="";
     /** A variável 'nome' armazenará o nome do usuário,
     * caso o login seja bem-sucedido.
     */
    public boolean result = false;
    
    /** 
     * A variável 'result' indica se o usuário fez o login com sucesso ou não.
     * Se o login for bem-sucedido, o valor é alterado para True.
     */
    
    /** 
     * Método verificarUsuario: 
     * Executa uma consulta MYSQL com o login e senha fornecidos pelo usuário,
     * determinando se o login foi bem-sucedido ou não.
     * @return Retorna um valor booleano que indica se o login foi bem-sucedido ou não.
     */
    public boolean verificarUsuario(String login, String senha){
        String sql = "";
        Connection conn = conectarBD();
        // INSTRUÇÃO SQL
        /** 
         * Concatena uma String predefinida com o login e senha inseridos pelo usuário,
         * gerando a instrução SQL que realizará a consulta.
         */
        sql += "select nome from usuarios ";
        sql +="where login = " + "'" + login + "'";
        sql += " and senha = " + "'" + senha + "';";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            /** 
             * Verifica se houve um resultado da consulta realizada.
             * Se não houver, uma exceção é lançada.
             * Se houver, o código continua, e as variáveis 'result' e 'nome' recebem novos valores.
             */
            if(rs.next()){
                result = true;
                nome = rs.getString("nome");}
            } catch (Exception e) {
                // Trata exceções, se ocorrerem
            } 
                return result;
            } 
        }
