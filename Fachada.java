package javaapplication1;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Vinícius
 */
public class Fachada {
    
    ArrayList<Atividade> lista = new ArrayList<Atividade>();
    ArrayList<Disciplina> listaDisc = new ArrayList<Disciplina>();
    ArrayList<Aluno> listaAluno = new ArrayList<Aluno>();


    public Fachada() {
    }
    
    
   
    
    
    
    public void buscar(int codo){
    	for(Atividade p: lista){
    		if(p.getStatus() == "Concluida")
    			System.out.println("A atividade ja esta concluida e arquivada");
            else if(p.getCod() == codo){
                System.out.println(p.toString());
            }
        }
    }
   
    public void excluirAtividade(int co){
        for(Atividade p: lista){
            if(p.getCod()== co){
                lista.remove(p);
            } else {
                System.out.println(" ");

            }
        }
    }
    
    public void concluirAtividade(int tagB){
        for(Atividade p: lista){
            if(p.getCod()== tagB){
                p.setStatus("Concluida");
                System.out.println("Atividade concluida");
            }
        }
    }
    public void visualizarAtvs(){
        System.out.println("ATIVIDADES");
        for(Atividade p: lista){
            System.out.println("Atividade de " + p.getDisc().getAcr());
            System.out.println("Nome da atividade " + " = " + p.getNome());
            System.out.println("Descriçao " + " = " +  p.getDesc());
            System.out.println("Codigo " + " = " +  p.getCod());
            System.out.println("_______________________________________________________________________________________________");
        }
    }
    public void feed(){
    	System.out.println("Concluidas e arquivadas");
    	for(Atividade p: lista){
            if(p.getStatus() == "Concluida"){
                System.out.println(p.toString());
            }
    	}
        System.out.println("Nao Concluidas");
        for(Atividade a: lista){
             if(a.getStatus() != "Concluida"){
                System.out.println(a.toString());
             }
        
       }
    }
}
