import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.script.ScriptEngine;

public class Task9_ExpressionCalculator {
	public static void main(String[] args) throws ScriptException {
		Scanner input = new Scanner(System.in);
		System.out.println(2^2);
		String expression = input.nextLine();
		List<Integer> index = new ArrayList<>();
		for (int i = 0; i < index.size(); i++) {
			index.add(expression.indexOf("^")+1);
		}
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");
		String foo = expression;
		System.out.println(engine.eval(foo));
		
	}
}
