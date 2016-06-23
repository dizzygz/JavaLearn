package exthread;

public class MyThread extends Thread {
	@Override
	public void run() {
		//super.run();
		for (int i = 0; i < 500000; i++) {
			System.out.println("i=" + (i + 1));
			if (this.interrupted()) {
				System.out.println("Exit since it's interruptted!");
				break;
			}
			
		}
	}
}
