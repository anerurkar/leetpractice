package com.leetcode.exercises;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * 
 *
 */
public class RateLimit {
	
	/**
	 * https://leetcode.com/discuss/interview-question/124558/Implement-a-Rate-Limiter/
	 * Implement a Rates limiter class with an isAllow method
	 * Every request comes with a unique client Id
	 * Deny a request if that client has made more than 100 requests in past 1 sec
	 * 
	 */
	public static void main(String[] args) {
		
		// Call isAllowed methood which calls a method hitAPI()
		Integer numberOfCalls = 100;
		String clientId = "001";  // Unique id for each client
		Boolean isAllowed = isAllowed(clientId);
		
	}
	
	class MyTimer implements Runnable{
		
		@Override
		public void run() {
			System.out.println("Thread started");
		}
	}

	private static Boolean isAllowed(String clientId) {
		
		Integer counter = 0;
		Thread t1 = new Thread();
		t1.start();
		Thread t2 = new Thread(new RateLimit().new MyTimer());
		t2.start();
		TimeUnit t = TimeUnit.SECONDS;
		
		if (null != clientId) {
			try {
				LocalDateTime dt = LocalDateTime.now(), seconds;
				
				
				for (int i = 1; i <= 1000; i++) {
					dt.plusSeconds(1);
					RateLimit.hitAPI(counter);
					seconds = dt.minusSeconds(60);
					if(dt.equals(TimeUnit.SECONDS)) {
						break;
					}
				}
				
				
				//t.wait(1000);
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return null;
	}
	
	public static Integer hitAPI(Integer counter) {
		System.out.println("hitAPI is called");
		return counter++;
	}
	
}
