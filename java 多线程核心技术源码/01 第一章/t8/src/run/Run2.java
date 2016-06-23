package run;

import mythread.MyThread2;

public class Run2 {
	public static void main(String[] args) throws Exception {
		MyThread2 mythread = new MyThread2();
		MyThread2 t2 = new MyThread2();
		
		System.out.println("begin =" + System.currentTimeMillis());
		mythread.start();
		t2.setName("B");
		//mythread.sleep(5000);
		t2.start();
		System.out.println("end   =" + System.currentTimeMillis());
	}
}
