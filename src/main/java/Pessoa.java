
import java.sql.Connection;
import java.sql.PreparedStatement;


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
}
