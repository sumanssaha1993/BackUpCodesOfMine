package com.maventic.java;

import java.util.Timer;

public class FileChecker {

	public static void main(String[] args) {

		Timer time = new Timer(); // Instantiate Timer Object
		ScheduleTask st = new ScheduleTask(); // Instantiate SheduledTask class
		time.schedule(st, 0, 10000); // Create Repetitively task for every 10 secs

		//for demo only.
		for (int i = 0; i <= 5; i++) {
			System.out.println("Execution in Main Thread...." + i);
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (i == 5) {
				System.out.println("Application Terminates");
				System.exit(0);
			}
		}
		
	}
	

}
