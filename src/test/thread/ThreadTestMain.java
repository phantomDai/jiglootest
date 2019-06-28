package test.thread;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class ThreadTestMain {
	
	static class WriteString implements Runnable {
		private List<String> sl;
		public WriteString(List<String> ssl) {
			sl = ssl;
		}
		public void run() {
			int i = 0;
			String s;
			while (i++ < 20) {
				s = new Integer(i).toString();
				sl.add(s);
				try {
					TimeUnit.MILLISECONDS.sleep(new Random().nextInt(1500));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	static class ReadString implements Runnable {
		List<String> sl;
		public ReadString(List<String> ssl) {
			sl = ssl;
		}
		public void run() {
			int i = 0;
			while (i < 20) {
				if (i < sl.size()) {
					System.out.println("size:" + sl.size());
					System.out.print(i + ": ");
					System.out.println(sl.get(i));
					++i;
				} else {
					try {
						TimeUnit.MILLISECONDS.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		List<String> sl = new ArrayList<String>();
		Thread th1 = new Thread(new WriteString(sl));
		Thread th2 = new Thread(new ReadString(sl));
		th1.start();
		th2.start();
//		try {
//			TimeUnit.MILLISECONDS.sleep(10000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(sl.size());
	}

}
