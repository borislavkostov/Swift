import java.util.Scanner;

public class Test {
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		String line = "";
		Student st[] = new Student[10];
		Worker wk[] = new Worker[10];
		int i =0;
		int j =0;
		for(;;){
			line = input.nextLine();
			String str[] = line.trim().split(" ");
			if(str.length==5){
				i++;
				st[i]=makeStudent(str);
				System.out.println(st[i]);
			}else if(str.length==4){
				j++;
				wk[j]=makeWorkert(str);
				System.out.println(wk[j]);
			}else if(str[0].equals("END")){
				break;
			}
		}
	}
	public static Student makeStudent(String str[]){
		Student st = new Student(str[0],str[1],str[2],Integer.parseInt(str[3]),Integer.parseInt(str[4]));
		return st;
	}
	public static Worker makeWorkert(String str[]){
		Worker st = new Worker(str[0],str[1],Double.parseDouble(str[2]),Integer.parseInt(str[3]));
		return st;
	}
}
