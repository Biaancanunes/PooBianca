package javaapplication1;


import java.util.ArrayList;

public class Sistema {
    
    ArrayList<Atividade> lista = new ArrayList<Atividade>();
    ArrayList<Disciplina> listaDisc = new ArrayList<Disciplina>();
    
    ConexaoBD bd = new ConexaoBD();

    public Sistema() {
    }
    
    public void criarDisc(String acron, String profe){
        Disciplina k = new Disciplina(acron,profe);
        listaDisc.add(k);
        bd.criarDisciplina(k);
        System.out.println("Disciplina criada " + k.toString());        
    }
    
    public void criarAtv(String nomee, String desc, String statuss, String tagi,String nomeProf,int cod){
        Atividade s = new Atividade (nomee,desc,statuss,tagi,cod);
        
        bd.criarATV(s);
        
        for(Disciplina p: listaDisc){
            if(p.getProf().contains(nomeProf)){
                s.setDisc(p);
                lista.add(s);
            }
        }
        
    }
    
    public void buscar(int codo){
        Atividade atv = bd.buscarAtv(codo);
    	System.out.println(atv);
    }
   
    public void excluirAtividade(int co){
        for(Atividade p: lista){
            if(p.getCod()== co){
                lista.remove(p);
                bd.excluiratv(co);
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
        ArrayList<Atividade> listaAtvs = bd.lerAtvs();

        //System.out.println("Nao Concluidas");
        for(Atividade a: listaAtvs){
            if(a != null)
                System.out.println(a.toString());
        
       }
    }
}