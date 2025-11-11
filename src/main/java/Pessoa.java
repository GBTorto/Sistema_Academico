
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;


public class Pessoa {
    private int codigo;
    private String nome;
    private String fone;
    private String email;
    //construtor padrão
    public Pessoa () {};
    //construtor com todos os parâmetros: sobrecarga
    public Pessoa (int codigo, String nome, String fone, String email) {
        this.codigo = codigo;
        this.nome = nome;
        this.fone = fone;
        this.email = email;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void cadastrar() {
        //1. definir o comando SQL
        String sql = "insert into tb_pessoa (nome, tel, email) values (?, ?, ?)";
        //2. abrir uma conexão
        ConnectionFactory factory = new ConnectionFactory();
        //o comando try a seguir é um try with resources
        try (Connection c = factory.obtemConexao()){
            //3. pré compilar o comando sql
            PreparedStatement ps = c.prepareStatement(sql);
            //4. preencher os dados faltantes: ?
            ps.setString(1, nome);
            ps.setString(2, fone);
            ps.setString(3, email);
            //5. executar o comando
            ps.execute();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void atualizar(){
        //1. Define a String sql
        String sql = "update tb_pessoa set nome = ?, tel = ?, email = ? where codigo = ?";
        //2. Abre a conexão
        ConnectionFactory factory = new ConnectionFactory();
        
        try(Connection c = factory.obtemConexao()){
            //3. Pré compila o comando sql
            PreparedStatement ps = c.prepareStatement(sql);
            
            //4. Preencher os placeholders
            ps.setString(1, nome);
            ps.setString(2, fone);
            ps.setString(3, email);
            ps.setInt(4, codigo);
            ps.execute();
        }
        catch(Exception e){
            e.printStackTrace();
        
        }
    }
    public void deletar(){
        //1. Definir a string sql         
        String sql = "delete from tb_pessoa where codigo = ?";

        //2. Para abrir a conexão, nomear uma fábrica
        ConnectionFactory factory = new ConnectionFactory();
        
        //3. Oedur a conexão como recurso do try
        try(Connection c = factory.obtemConexao()){
            //4. Pré compilar o comando sql
            PreparedStatement ps = c.prepareCall(sql);
            
            //5. Preenche o campo que falta
            ps.setInt(1, codigo);
            
            //6. Executa o comando
            ps.execute();
        }
        catch(Exception e){
            
         
        }
        
    }
    public void listar() {
        //1.Criar comando SQL 
        String sql = "select * from tb_pessoa";
        //2. Nomeia a fabrica de conexões
        ConnectionFactory factory = new ConnectionFactory();
        //3. Pede a conexão no try
        try(Connection c = factory.obtemConexao()){
            //4. Pré compila o comando sql 
            PreparedStatement ps = c.prepareCall(sql);
            //5. A execução devolve o conjunto do resultado 
            ResultSet rs = ps.executeQuery();
            // 6. iterar sobre o resultado
            while (rs.next()){
                int codigo = rs.getInt("codigo");
                String nome = rs.getString("nome");
                String fone = rs.getString("tel");
                String email = rs.getString("email");
                String aux = String.format("codigo: %d, nome: %s, fone: %s, email: %s ", codigo, nome, fone, email);
                JOptionPane.showMessageDialog(null, aux);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
    

    
