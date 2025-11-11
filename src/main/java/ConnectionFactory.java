import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    String url = "jdbc:mysql://localhost:3306/db_pessoas?useSSL=false&serverTimezone=America/Sao_Paulo";
    String user = "root";
    String password = "anima123";
    
    public Connection obtemConexao () {
        try {
            //Connection c = DriverManager.getConnection("jdbc:mysql://" + host + ":" + porta + "/" + bd,usuario, senha);
            Connection c = DriverManager.getConnection(url, user, password);
            return c;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
