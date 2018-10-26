package allen.lift.singleton;

/**
 * 类说明:
 * 
 * @author Allen Wang
 * 
 * @Email 1303542271@qq.com
 * 
 * @Version 2016年9月5日上午11:51:08 测试类
 * 
 */
public class Tomcat implements Runnable {

	public void run() {
		// 获取实例 测试饿汉式
		HungrySingleton.getInstance();
	}

	/**
	 * 程序入口
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		// 创建多线程
		for (int i = 0; i < 5; i++) {
			
			Thread th=new Thread(new Tomcat());
			th.start();
		
		}	
 
	}
	
}
