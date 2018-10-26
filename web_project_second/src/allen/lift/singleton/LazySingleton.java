package allen.lift.singleton;

/**
 * ��˵��:
 * 
 * @author Allen Wang
 * 
 * @Email 1303542271@qq.com
 * 
 * @Version 2016��9��5������11:50:04
 * 
 */
public class LazySingleton {

	// ����ʽ����ģʽ

	// �Ƚ������������ʱ��������ʵ�������������ٶȿ죬������ʱ��ȡ������ٶ���

	private static LazySingleton instance = null;// ��̬˽�ó�Ա��û�г�ʼ��

	private LazySingleton() {

		// ˽�й��캯��
	}

	public static synchronized LazySingleton getInstance() { // ��̬��ͬ�����������ʵ�
	
		if (instance == null) {

			instance = new LazySingleton();
		}
		return instance;
	}

	public static LazySingleton getInsTance() { // ��̬��ͬ�����������ʵ�
		
		//��һ�η��ʵ�ʱ�򴴽�����
		if (instance == null) {
				//��һ�δ��������ʱ�����
			synchronized (LazySingleton.class) {
				//�ж��Ƿ��Ѿ���������
				if(instance==null){
					//������������
					instance = new LazySingleton();
				}
			}
		}
		return instance;
	}
	
	
	/*
	 * �ؼ��㣺
	 * 
	 * 1�����캯������Ϊ˽��----�����ڱ����������ȡ����Ķ���ֻ�����������еõ��Լ��Ķ���
	 * 
	 * 2����Ա����Ϊstatic�ģ�û�г�ʼ��----����ؿ죬���������Ψһʵ������static��֤���������л�ȡ�������
	 * 
	 * 3���������ʵ�getInstance��
	 * 	
	 *    public��synchronized-----public��֤���⹫����ͬ����֤���߳�ʱ����ȷ�ԣ���Ϊ����������ڼ���ʱ��ʼ���ģ�
	 */

}
