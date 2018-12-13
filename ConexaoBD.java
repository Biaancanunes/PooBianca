package javaapplication1;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ConexaoBD {

	private Connection conexao;
	private String driver, caminho, user, password;
	
	public ConexaoBD() {
		// atributo para definição do serviço do BD utilizado pela aplicação
		this.driver = "org.postgresql.Driver";
		// atributo para definição da url de acesso ao banco
		this.caminho = "jdbc:postgresql://localhost:5432/ifpb";
		// atributo para definição do login do usuário no banco
		this.user = "postgres";
		// atributo para definição da senha do usuário no banco
		this.password = "ifpb";
		// objeto responsável pelo estabelecimento da conexão com o BD (será inicializado quando a conexão
		// com o banco for iniciada)
		this.conexao = null;
	}
	
	public void conectar() {
		// seta o drive de conexão como propriedade do sistema acessível pela aplicação ao ser
		// executada sobre a instância da JVM (o driver do BD deve ser importado para o projeto no Java Build Path) 
		System.setProperty("jdbc.Drivers", driver);
		
		try {
			// inicialização da conexão com o banco
			conexao = DriverManager.getConnection(caminho, user, password);
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void desconectar() {
		try {
			// finalização da conexão com o banco (deve sempre ser chamado ao encerrar um
			// acesso ao banco)
			conexao.close();
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public ResultSet executarSQL(String comando) {
		// toda consulta ao banco resulta em um objeto do tipo ResultSet
		ResultSet resultado = null;
		
		try {
			// objeto que permita e realiza a interface dos comandos SQL a serem enviados da
			// aplicação Java para o BD
			PreparedStatement stm = conexao.prepareStatement(comando);
			stm.execute();
			resultado = stm.getResultSet();
			
			// outra forma de realizar consultas ao banco:
			// Statement stm = conexao.createStatement();
			// resultado = stm.executeQuery(comando);
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		return resultado;
	}

	// para acessar a conexão (que está encapsulada)
	public Connection getConexao() {
		return conexao;
	}
        
        public Aluno login(String nome, String senha) {
            conectar();
            
            try {
                PreparedStatement pst = getConexao().prepareStatement("select * from Aluno where nome = ? and senha = ?");
                
                pst.setString(1, nome);
                pst.setString(2, senha);
                
                pst.execute();
                
                ResultSet rs = pst.getResultSet();
                
                String nomeAluno = "";
                String senhaAluno = "";
                
                while (rs.next() ) {
                    nomeAluno = rs.getString("nome");
                    senhaAluno = rs.getString("senha");
                }
                
                if(!nomeAluno.equals("") && !senhaAluno.equals("")) {
                    return new Aluno(nomeAluno, senhaAluno);
                }
                
                return null;
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
                e.printStackTrace();
            } finally {
                // o banco deve ser desconectado, mesmo quando a exceção é lançada
                desconectar();
            }
            
            return null;
        }
        
        public void criarDisciplina(Disciplina User) {
		// abrindo a conexão com o BD
		conectar();

		try {
			// usando um PreparedStatement com valores externos como parâmetros (representados pelo '?')
                        
			PreparedStatement pst = getConexao().prepareStatement("insert into Disciplina(nome,prof) values(?,?)");
			// os métodos set devem ser escolhidos de acordo com os tipos dos atributos da entidade que está
			// sendo acessada. A sequência é determinada por índices, iniciando do valor 1.
			
			pst.setString(1,User.getAcr());
			pst.setString(2, User.getProf());
			
			
			
			// solicitação da execução da query, após seu preparo
			pst.execute();
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			// o banco deve ser desconectado, mesmo quando a exceção é lançada
			desconectar();
		}
        }
          
        public void cadastrarAluno(Aluno Alun) {
		// abrindo a conexão com o BD
		conectar();

		try {
			// usando um PreparedStatement com valores externos como parâmetros (representados pelo '?')
			PreparedStatement pst = getConexao().prepareStatement("insert into Aluno(nome,senha) values(?,?)");
			// os métodos set devem ser escolhidos de acordo com os tipos dos atributos da entidade que está
			// sendo acessada. A sequência é determinada por índices, iniciando do valor 1.
			
			pst.setString(1,Alun.getnome());
			pst.setString(2, Alun.getsenha());
			
			
			
			
			
			// solicitação da execução da query, após seu preparo
			pst.execute();
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			// o banco deve ser desconectado, mesmo quando a exceção é lançada
			desconectar();
		}
          
		
	}
        
        public void criarATV(Atividade atividade) {
		// abrindo a conexão com o BD
		conectar();

		try {
			// usando um PreparedStatement com valores externos como parâmetros (representados pelo '?')
			PreparedStatement pst = getConexao().prepareStatement("insert into Atividade values(?,?,?,?,?)");
			// os métodos set devem ser escolhidos de acordo com os tipos dos atributos da entidade que está
			// sendo acessada. A sequência é determinada por índices, iniciando do valor 1.
			
			pst.setString(1,atividade.getNome());
			pst.setString(2,atividade.getDesc());
                        pst.setString(3,atividade.getStatus());
                        pst.setString(4,atividade.getTag());
                        pst.setInt(5,atividade.getCod());
                        //pst.setString(6, atividade.getDisc().getAcr());
		
			// solicitação da execução da query, após seu preparo
			pst.execute();
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			// o banco deve ser desconectado, mesmo quando a exceção é lançada
			desconectar();
		}
          
		
	}
	public void excluiratv(int cod) {
		// abrindo a conexão com o BD
		conectar();
		
		try {
			PreparedStatement stm = getConexao().prepareStatement("delete from atividade where cod = \'" + cod + "\'");
			stm.execute();
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			// o banco deve ser desconectado, mesmo quando a exceção é lançada
			desconectar();
		}
	}
        
        public ArrayList<Atividade> lerAtvs() {
            conectar();
            String query = "SELECT * FROM atividade";
            
            ResultSet rs = executarSQL(query);
            
            ArrayList<Atividade> atvs = new ArrayList<Atividade>();
            try{
                while(rs.next()) {
                    String nome = rs.getString("nome");
                    String descr = rs.getString("descr");
                    String stts = rs.getString("stts");
                    String tag = rs.getString("tag");
                    int cod = rs.getInt("cod");
                    
                    atvs.add(new Atividade(nome, descr, stts, tag, cod));
                }
            }catch(Exception e) {
                    
             }
            
            return atvs;
        }
        
        public Atividade buscarAtv(int cod) {
            conectar();
            String query = "SELECT * FROM atividade WHERE cod=" + cod;
            
            ResultSet rs = executarSQL(query);
            
            Atividade atv;
            try{
                while(rs.next()) {
                    String nome = rs.getString("nome");
                    String descr = rs.getString("descr");
                    String stts = rs.getString("stts");
                    String tag = rs.getString("tag");
                    
                    return new Atividade(nome, descr, stts, tag, cod);
                }
            }catch(Exception e) {
                    
             }
            
            return null;
        }
	
}