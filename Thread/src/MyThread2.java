
public class MyThread2 extends Thread{
	@Override
	public void run() {
		System.out.println("3");
		for(int i = 10; i > 0;i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("hi");
	}
}
