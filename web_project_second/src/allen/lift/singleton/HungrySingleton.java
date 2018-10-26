package allen.lift.singleton;

/**
 * 类说明:
 * 
 * @author Allen Wang
 * 
 * @Email 1303542271@qq.com
 * 
 * @Version 2016年9月5日上午11:48:21
 * 
 */
public class HungrySingleton {
	
	// 饿汉单例模式

	//在类加载时就完成了初始化，所以类加载较慢，但获取对象的速度快
	private static HungrySingleton instance = new HungrySingleton();// 静态私有成员，已初始化

	
	private HungrySingleton() {

		// 私有构造函数
	}

	public static HungrySingleton getInstance() { // 静态，不用同步（类加载时已初始化，不会有多线程的问题）

		return instance;
	}

	/*
	 * 1）私有构造函数
	 * 
	 * 2）静态私有成员--在类加载时已初始化
	 * 
	 * 3）公开访问点getInstance-----不需要同步，因为在类加载时已经初始化完毕，也不需要判断null，直接返回
	 */
	
}
