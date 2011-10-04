package core;

import java.io.IOException;

public class Log {
	
	private static boolean enabled = true;
	
	public static void waitConfirmation() {
		enabled = true;
	}
	
	public static void dontWaitConfirmation() {
		enabled = false;
	}	
	
	public static void show(String message) {
		try {
			if (enabled) {
				System.out.print(message);				
				System.in.read();
			} else
				System.out.println(message);
		} catch (IOException e) {
		}
	}
}
