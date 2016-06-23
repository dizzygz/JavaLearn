package extthread;

public class ThreadA extends Thread {

	private ThreadB b;

	public ThreadA(ThreadB b) {
		super();
		this.b = b;
	}

	@Override
	public void run() {
		try {
			synchronized (b) {
				b.start();
				Thread.sleep(6000);
				// Thread.sleep()≤ª Õ∑≈À¯£°
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
