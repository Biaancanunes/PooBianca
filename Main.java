package javaapplication1;

import java.util.Scanner;


public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        //OBS: O STATUS DAS ATIVIDADES DEVEM SER = "    Em andamento / Finalizada / Arquivada
        
        Sistema x = new Sistema();
        
        
        Scanner s = new Scanner(System.in);
        
        
        System.out.println("Oque voce deseja fazer:\n 1-Criar Usuario 2-Fazer Login 3-sair");
       
                
        int alet = s.nextInt();

        while(alet<4 ){
            if(alet==1){
                System.out.println("Digite o nome:");
                String nome = s.next();
                System.out.println("Digite a senha:");
                String senha = s.next();

                x.bd.cadastrarAluno(new Aluno(nome,senha));
                System.out.println("Aluno cadastrado.");

                System.out.println("Oque voce deseja fazer:\n 1-Criar Usuario 2-Fazer Login 3-sair");
                alet = s.nextInt();
            }
            else if(alet==2) {
                System.out.println("Digite o nome:");
                String nome = s.next();
                System.out.println("Digite a senha:");
                String senha = s.next();

                Aluno al = x.bd.login(nome, senha);

                if(al != null) {
                    System.out.println("Logado com sucesso." +  al.getnome());
                    menuUsuario(al, x, s);
                }else {
                    System.out.println("Usuário inexistente.");
                }
                System.out.println("Oque voce deseja fazer:\n 1-Criar Usuario 2-Fazer Login 3-sair");
                alet = s.nextInt();

            }else {
                break;
            }             
        }
        
        
    }
    
    public static void menuUsuario(Aluno al, Sistema x, Scanner s) {
        System.out.println("_______________________________________________________________________________________________");
        System.out.println("Oque voce deseja fazer:\n 1-Criar Atividade 2-Criar Disciplina 3-Buscar Atividade 4-Excluir Atividade 5-Ver feed");
       
        
        int alet = s.nextInt();
        
        while(alet<7){
        if(alet == 1){
            System.out.println("Digite o nome:");
            String nome = s.next();
            System.out.println("Digite a descrição:");
            String desc = s.next();
            System.out.println("Digite a Status:");
            String stts = s.next();
            System.out.println("Digite a Tag:");
            String tag = s.next();
            System.out.println("Digite o professor:");
            String prof = s.next();
            System.out.println("Digite o codigo da atividade");
            
            int cod = s.nextInt();
            x.criarAtv(nome, desc, stts, tag,prof, cod);
            System.out.println("_______________________________________________________________________________________________");
            x.visualizarAtvs();
            
        }
        else if(alet == 2){
            System.out.println("Digite seu Nome:");
            String acr = s.next();
            System.out.println("Digite o nome do professor:");
            String prof = s.next();
            System.out.println("_______________________________________________________________________________________________");
            x.criarDisc(acr, prof);
            System.out.println("_______________________________________________________________________________________________");
        }
        else if(alet == 3 ){
            x.visualizarAtvs();
        	System.out.println("Digite o codigo da atividade:");
            int cod = s.nextInt();
            x.buscar(cod);
            
        }
        else if(alet == 4){
            System.out.println("Digite o codigo da atividade pra ser excluida");
            int code = s.nextInt();
            x.excluirAtividade(code);
        }
        else if(alet == 5){
          x.feed();
        }else {
            break;
        }
        
        System.out.println(" ");
        System.out.println("Oque voce deseja fazer:\n 1-Criar Atividade 2-Criar Disciplina 3-Buscar Atividade 4-Excluir Atividade 5-Ver feed 6-sair");
        alet = s.nextInt();
        
    }
    }
}