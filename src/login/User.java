package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class User {
    public Connection conectarBD(){ // 2. Tenta conectar ao banco de dados
        Connection conn = null;
        try{
            Class.forName("com.mysql.Driver.Manager").newInstance();
            String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";
            conn =  DriverManager.getConnection(url);
        }catch (Exception e) {
        
        }
        return conn;
    }
    // 03. Retorno da conexão
    // 05. Sucesso ao conectar. Continua para o 6, ou
    // 04. Falha da conexão
    // 13. Fim do programa (erro)

    // 01. Declaração de varíaveis/propriedades
    public String nome="";
    public boolean result = false;
    
    public boolean verificarUsuario(String login, String senha){
        // 06. Consulta no banco de dados
        String sql = "";
        Connection conn = conectarBD();
        //INSTRUÇÃO SQL
        sql += "select nome from usuarios ";
        sql +="where login = " + "'" + login + "'";
        sql += " and senha = " + "'" + senha + "';";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            // 07. Retorno da consulta
            
            // 08. Validação do retorno
            // 10. Consulta com restultados. Continua para o 11
            // 09. Consulta sem resultados e
            // 13. Fim do programa (erro)
            if(rs.next()){
                // 11. Variáveis recebem novos valores
                result = true;
                nome = rs.getString("nome");}
            } catch (Exception e) { } 
                // 12. Propriedade "result" é retornada pelo método
                // 13. Fim do programa. (erro)
                return result;
            } 
            // 13. Fim do programa (sucesso)
        }
