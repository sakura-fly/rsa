package th;

import javax.servlet.http.HttpSession;

public class Timeout {
	public void sessionTimeout(HttpSession s) {
		// run in a second
		final long timeInterval = 1000;
		Runnable runnable = new Runnable() {
			public void run() {
				try {
					Thread.sleep(timeInterval * 10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				s.removeAttribute("rsa");
			}
		};
		Thread thread = new Thread(runnable);
		thread.start();
	}
}
