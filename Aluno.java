package javaapplication1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Bianca
 */
public class Aluno {
        private String nome;
	private String senha;

    Aluno(String nome, String senha) {
        this.nome = nome;
	this.senha = senha;
    }
            
        public void setnome(String nome) {
        this.nome = nome;
    }

    public void setsenha(String senha) {
        this.senha = senha;
    }

   

    public String getnome() {
        return nome;
    }

    public String getsenha() {
        return senha;
    }
}
