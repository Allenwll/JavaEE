package allen.lift.singleton;

/**
 * ��˵��:
 * 
 * @author Allen Wang
 * 
 * @Email 1303542271@qq.com
 * 
 * @Version 2016��9��5������11:51:08 ������
 * 
 */
public class Tomcat implements Runnable {

	public void run() {
		// ��ȡʵ�� ���Զ���ʽ
		HungrySingleton.getInstance();
	}

	/**
	 * �������
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		// �������߳�
		for (int i = 0; i < 5; i++) {
			
			Thread th=new Thread(new Tomcat());
			th.start();
		
		}	
 
	}
	
}
