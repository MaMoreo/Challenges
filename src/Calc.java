import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calc {

	public double evaluate(String expr) {

		String[] nuops = expr.split(" ");
		
		Character[] stack = new Character[expr.length()];

		int cont = 0;
		for (int i = expr.length()-1; i >= 0; i --) {

			if (isOperator(expr.charAt(i))) {
				stack[cont] = expr.charAt(i);
				cont ++;
			} else {  // is a number
				if( ! isNumber(stack[cont-1])) { // peek not a number
					stack[cont] = expr.charAt(i);
					cont ++;
			    }else {
			    	// is a number
			    	Character n1 = expr.charAt(i) ;
			    	Character n2 = stack[cont-1];
			    	Character op = stack[cont-2];
			    	cont = cont - 2;
			    	char a = performOperation(n1, n2, op) ;
			    	stack [cont] = a;
			      } 
			  }
		}
		
		return stack[0];
	
	}
	
	private boolean isNumber(Character a) {
		 Pattern p = Pattern.compile("\\d");
		 Matcher m = p.matcher(a.toString());
		 return m.matches();
	}
	
	private boolean isOperator(Character a) {
		 Pattern p = Pattern.compile("[-|+|*|/]");
		 Matcher m = p.matcher(a.toString());
		 return m.matches();
	}
	
	private Character performOperation(Character n1,Character n2,Character op) {
		 
		Integer p1 = Integer.valueOf(n1.toString());
		Integer p2 = Integer.valueOf(n2.toString());
		
		
		Pattern p = Pattern.compile("-");
		Matcher m = p.matcher(op.toString());
		if (m.matches())
			 return Character.forDigit((p1 - p2), 10);
		 
	    m = Pattern.compile("\\+").matcher(op.toString());
		if (m.matches()) {
		 return Character.forDigit((p1 + p2), 10);
		 
		}
		
		p = Pattern.compile("/");
		m = p.matcher(op.toString());
		if (m.matches())
			 return Character.forDigit((p1 / p2), 10);
		

		return Character.forDigit((p1 * p2), 10);
	}
}
