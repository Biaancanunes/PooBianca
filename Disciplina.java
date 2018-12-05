package javaapplication1;

import java.util.ArrayList;


public class Disciplina {
    
    private String acr;
    private String prof;
   
    

    

    public void setAcr(String acr) {
        this.acr = acr;
    }

    public void setProf(String prof) {
        this.prof = prof;
    }

   

    public String getAcr() {
        return acr;
    }

    public String getProf() {
        return prof;
    }
    

    Disciplina(String acr, String prof){
    	this.acr = acr;
    	this.prof = prof;
    
    }

    @Override
    public String toString() {
        return "Disciplina{" + "Nome da disciplina =" + acr + ", professor=" + prof + '}';
    }
}