package fr.eql.ai108.modele;

public class Resultat {
	
	private String operation;
	private int num;
	
	
	public Resultat(String operation, int num) {
		super();
		this.operation = operation;
		this.num = num;
	}
	public Resultat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}	
}
