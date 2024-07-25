
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//for(int i = 3; i > 0; i --) {
			//System.out.println(i);
			//try {
			//	Thread.sleep(1000);
			//} catch (InterruptedException e) {
				// TODO Auto-generated catch block
			//	e.printStackTrace();
		//	}
		//}
		//System.out.println("done");
		
		
		MyThread thread2 = new MyThread();
		
		MyThread2 thread1 = new MyThread2();
		thread2.start();
		thread1.start();
	}
	
}
