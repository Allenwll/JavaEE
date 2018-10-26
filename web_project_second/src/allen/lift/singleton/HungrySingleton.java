package allen.lift.singleton;

/**
 * ��˵��:
 * 
 * @author Allen Wang
 * 
 * @Email 1303542271@qq.com
 * 
 * @Version 2016��9��5������11:48:21
 * 
 */
public class HungrySingleton {
	
	// ��������ģʽ

	//�������ʱ������˳�ʼ������������ؽ���������ȡ������ٶȿ�
	private static HungrySingleton instance = new HungrySingleton();// ��̬˽�г�Ա���ѳ�ʼ��

	
	private HungrySingleton() {

		// ˽�й��캯��
	}

	public static HungrySingleton getInstance() { // ��̬������ͬ���������ʱ�ѳ�ʼ���������ж��̵߳����⣩

		return instance;
	}

	/*
	 * 1��˽�й��캯��
	 * 
	 * 2����̬˽�г�Ա--�������ʱ�ѳ�ʼ��
	 * 
	 * 3���������ʵ�getInstance-----����Ҫͬ������Ϊ�������ʱ�Ѿ���ʼ����ϣ�Ҳ����Ҫ�ж�null��ֱ�ӷ���
	 */
	
}
