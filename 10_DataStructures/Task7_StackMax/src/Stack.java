import java.util.ArrayList;
import java.util.Collections;

public class Stack<E> {
	private ArrayList<E> stack = new ArrayList<>();
	
	public Stack(ArrayList<E> stack){
		this.stack=stack;
	}
	
	public ArrayList<E> getStack() {
		return stack;
	}

	public void setStack(ArrayList<E> stack) {
		this.stack = stack;
	}

	public void push(E value) {
		this.stack.add(value);
	}

	public void pop() {
		System.out.println(this.stack.get(this.stack.size() - 1));
		this.stack.remove(this.stack.size() - 1);
	}

	public void max() {
		System.out.println(Collections.max(this.stack,null));
	}

	public void getValues() {
		for (int i = stack.size()-1; i > 0; i--) {
			System.out.print(this.stack.get(i) + " ");
		}
		System.out.println();
	}
}
