package test;
/*
 * 懒汉模式  线程不安全
 */
public class SingletonL {

	private SingletonL() {}
	
	//声明类的实例
	private static SingletonL instance;
	
	public static SingletonL getInstance(){
		if(instance==null){
			instance=new SingletonL();
		}
		
		return instance;
	}

}
