import javax.swing.JOptionPane;

public class Main {
    public static void main (String[] args) {
        String menu = "1-Cadastrar\n2-Atualizar\n3-Apagar\n4-Listar\n0-Sair";
        int opcao;
        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch (opcao) {
                case 1:{
                    String nome = JOptionPane.showInputDialog("Nome?");
                    String fone = JOptionPane.showInputDialog("Telefone?");
                    String email = JOptionPane.showInputDialog("Email?");
                    Pessoa p = new Pessoa();
                    p.setNome(nome);
                    p.setFone(fone);
                    p.setEmail(email);
                    p.cadastrar();
                    break;
                }
                case 2:{
                    String nome = JOptionPane.showInputDialog("Nome?");
                    String fone = JOptionPane.showInputDialog("Fone?");
                    String email = JOptionPane.showInputDialog("Email?");
                    
                    int codigo = Integer.parseInt(
                            JOptionPane.showInputDialog("Código?")
                    );
                    Pessoa p = new Pessoa();
                    p.setCodigo(codigo);
                    p.setNome(nome);
                    p.setEmail(email);
                    p.setFone(fone);
                    p.atualizar();
                          
                    break;
                }
                case 3:{
                    int codigo = Integer.parseInt(
                            JOptionPane.showInputDialog("Código?")
                    );
                    
                    Pessoa p = new Pessoa();
                    p.setCodigo(codigo);
                    p.deletar();
                    
                    break;
                }
                case 4:{
                    Pessoa p = new Pessoa();
                    p.listar();
                    break;
                }
                case 0:
                    JOptionPane.showMessageDialog(null, "Obrigado, volte sempre!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcao invalida");
            }
        } while (opcao != 0);
    }
}
