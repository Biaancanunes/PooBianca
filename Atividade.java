package javaapplication1;



public class Atividade {
	    
	    private String nome;
	    private String desc;
	    private String status;
	    private String tag;
	    private Disciplina disc;
	    private int cod;
	    
	    
	    
	    
	    public Atividade(String nome, String desc, String status, String tag,int cod) {
	        this.nome = nome;
	        this.desc = desc;
	        this.status = status;
	        this.tag = tag;
	        this.cod = cod;
	    }

	    @Override
	    public String toString() {
	        return "Atividade{" + "nome=" + nome + ", desc=" + desc + ", status=" + status + ", tag=" + tag + ", Disciplina=" + disc.getAcr() + '}';
	    }

	    
	    public void setDisc(Disciplina x) {
	        this.disc = x;
	    }

	    public Disciplina getDisc() {
	        return disc;
	    }
	    
	    
	    public void setTag(String tag) {
	        this.tag = tag;
	    }

	    public String getTag() {
	        return tag;
	    }

	    public String getNome() {
	        return nome;
	    }

	    public String getDesc() {
	        return desc;
	    }

	    public String getStatus() {
	        return status;
	    }

	    public void setNome(String nome) {
	        this.nome = nome;
	    }

	    public void setDesc(String desc) {
	        this.desc = desc;
	    }

	    public void setStatus(String status) {
	        this.status = status;
	    }

	    public int getCod() {
	        return cod;
	    }
}