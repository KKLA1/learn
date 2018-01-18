package test;
/*
 * 单例模式  某个实例有且只有一个
 * 恶汉模式，线程安全的 占有系统资源   在加载文件时对象就已经被创建 类加载时就会创建这个类唯一的实例
 */
public class SigletonDemo {

	//1.将构造器私有化
	private SigletonDemo() {
		
	}
	
	//2.创建类的实例
	private static SigletonDemo instance = new SigletonDemo();
	
	
	//3.
	public static SigletonDemo getInstance(){
		
		return instance;
	} 
	

}
