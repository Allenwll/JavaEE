package allen.lift.singleton;

/**
 * 类说明:
 * 
 * @author Allen Wang
 * 
 * @Email 1303542271@qq.com
 * 
 * @Version 2016年9月5日上午11:50:04
 * 
 */
public class LazySingleton {

	// 懒汉式单例模式

	// 比较懒，在类加载时，不创建实例，因此类加载速度快，但运行时获取对象的速度慢

	private static LazySingleton instance = null;// 静态私用成员，没有初始化

	private LazySingleton() {

		// 私有构造函数
	}

	public static synchronized LazySingleton getInstance() { // 静态，同步，公开访问点
	
		if (instance == null) {

			instance = new LazySingleton();
		}
		return instance;
	}

	public static LazySingleton getInsTance() { // 静态，同步，公开访问点
		
		//第一次访问的时候创建对象
		if (instance == null) {
				//第一次创建对象的时候加锁
			synchronized (LazySingleton.class) {
				//判断是否已经创建对象
				if(instance==null){
					//创建对象，载入
					instance = new LazySingleton();
				}
			}
		}
		return instance;
	}
	
	
	/*
	 * 关键点：
	 * 
	 * 1）构造函数定义为私有----不能在别的类中来获取该类的对象，只能在类自身中得到自己的对象
	 * 
	 * 2）成员变量为static的，没有初始化----类加载快，但访问类的唯一实例慢，static保证在自身类中获取自身对象
	 * 
	 * 3）公开访问点getInstance：
	 * 	
	 *    public和synchronized-----public保证对外公开，同步保证多线程时的正确性（因为类变量不是在加载时初始化的）
	 */

}
