package fr.eql.ai108.modele;

public class CalculService {
	public Resultat calcul(String op, int num1, int num2) {
		Resultat res = new Resultat();
		
		switch (op) {
		case "add":
			res.setNum(num1 + num2);
			res.setOperation("Addition");
			break;
		case "sub":
			res.setNum(num1 - num2);
			res.setOperation("Soustraction");
			break;
		case "mul":
			res.setNum(num1 * num2);
			res.setOperation("Multiplication");
			break;
		case "div":
			res.setNum(num1 / num2);
			res.setOperation("Division");
			break;

		default:
			break;
		}
		
		return res;
	}
}
