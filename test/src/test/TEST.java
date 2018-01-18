package test;

public class TEST {

	

	public static void main(String[] args) {
		
		
		SigletonDemo s4 = SigletonDemo.getInstance();
		
		SigletonDemo s5 = SigletonDemo.getInstance();
		
		System.out.println(s4==s5);
		
		SingletonL s6 = SingletonL.getInstance();
		SingletonL s7 = SingletonL.getInstance();
		System.out.println(s6==s7);
		

	}

}
