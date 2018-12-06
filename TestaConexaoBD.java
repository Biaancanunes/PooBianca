package javaapplication1;



import java.util.ArrayList;
import java.util.Scanner;
import javaapplication1.DAOPessoa;
import javaapplication1.Disciplina;

public class TestaConexaoBD {

	public static void main(String[] args) {
            
                ConexaoBD x = new ConexaoBD();
		DAOPessoa conexao = new DAOPessoa();
                
                Scanner s = new Scanner(System.in);
                
                System.out.println("Oque voce deseja fazer:\n 1-Criar Usuario 2-Fazer Login 3-sair");
       
                
                int alet = s.nextInt();
        
                while(alet<4 ){
                    if(alet==1){
                        System.out.println("Digite o nome:");
                        String nome = s.next();
                        System.out.println("Digite a senha:");
                        String senha = s.next();

                        conexao.cadastrarAluno(new Aluno(nome,senha));
                        System.out.println("Aluno cadastrado.");
                        
                        System.out.println("Oque voce deseja fazer:\n 1-Criar Usuario 2-Fazer Login 3-sair");
                        alet = s.nextInt();
                    }
                    if(alet==2) {
                        System.out.println("Digite o nome:");
                        String nome = s.next();
                        System.out.println("Digite a senha:");
                        String senha = s.next();
                        
                        Aluno al = conexao.login(nome, senha);
                        
                        if(al != null) {
                            System.out.println("Logado com sucesso." +  al.getnome());
                            menuUsuario(al, conexao);
                        }else {
                            System.out.println("Usuário inexistente.");
                            System.out.println("Oque voce deseja fazer:\n 1-Criar Usuario 2-Fazer Login 3-sair");
                        }
                        alet = s.nextInt();
                        
                    }                
		}
	
        }
        
        public static void menuUsuario(Aluno al, DAOPessoa conexao) {
            Scanner s = new Scanner(System.in);
            
            int alet = s.nextInt();
        
            while(alet<4 ){
                System.out.println("Oque voce deseja fazer:\n 1-Criar Disciplina 2-criar Atividade 3-Criar TAG 4-sair");
            
                if(alet==1){
                    System.out.println("Digite o nome:");
                    String nome = s.next();
                    System.out.println("Digite a professor:");
                    String professor = s.next();

                    conexao.criarDisciplina(new Disciplina(nome,professor));
                    System.out.println("-------------------------------------");

                    System.out.println("Oque voce deseja fazer:\n 1-Criar Usuario 2-Criar Disciplina 3-criar Atividade 4-sair");

                    alet = s.nextInt();
                }
                if(alet==2){
                    System.out.println("Digite o nome:");
                    String nome = s.next();
                    System.out.println("Digite a descriçao:");
                    String desc = s.next();
                    System.out.println("Digite o statuis:");
                    String status = s.next();
                    System.out.println("Digite a tag:");
                    String tag = s.next();
                    System.out.println("Digite a codigo:");
                    int cod = s.nextInt();

                    conexao.criarATV(new Atividade(nome,desc,status,tag,cod));
                    System.out.println("-------------------------------------");

                    System.out.println("Oque voce deseja fazer:\n 1-Criar Usuario 2-Criar Disciplina 3-criar Atividade 4-sair");

                    alet = s.nextInt();
                }
            }
        }
}

