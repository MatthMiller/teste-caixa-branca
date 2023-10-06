package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class User {
    // ponto de Início
    public Connection conectarBD(){ //Ponto 02: tentando conexão com bd
        Connection conn = null;
        try{
            Class.forName("com.mysql.Driver.Manager").newInstance();
            String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";
            conn =  DriverManager.getConnection(url);
        }catch (Exception e) { }
        return conn;}
    //Ponto 03: retorno da conexão
    //Ponto 05: sucesso na conexão (continua para o 6) OU
    //Ponto 04: Falha na conexão ao BD e então:
    //Ponto 13: FIM.   

    //Ponto 1: Variaveis de controle de login
    //1 pq não está dentro de um método, roda quando uma isntancia da classe é criada.
    public String nome="";
    public boolean result = false;
    
    public boolean verificarUsuario(String login, String senha){
        //Ponto 06: entrando com informações pra pegar dados no BD
        String sql = "";
        Connection conn = conectarBD();
        //INSTRUÇÃO SQL
        sql += "select nome from usuarios ";
        sql +="where login = " + "'" + login + "'";
        sql += " and senha = " + "'" + senha + "';";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            //Ponto 07: Retorno dos dados do BD
            
            //Ponto 08: IF Verificando resultados
            //Ponto 10: Consulta com restultados (continua para o 11)
            //Ponto 09: Consulta sem resultados e então
            //Ponto 13: Fim 
            if(rs.next()){ //Ponto final 02: Falha na consulta
                
                //Ponto 11: "Update" variaves de controle
                result = true;
                nome = rs.getString("nome");}
            } catch (Exception e) { } 
                //Ponto 12 return da variavel result.
                //Ponto 13 Fim, mas dessa vez com sucesso.
                return result;
            } 
            //Ponto Final 03: Sucesso!
        }//fim da class
