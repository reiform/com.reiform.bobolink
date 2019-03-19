package com.reiform.bobolink.debug;

import java.io.PrintStream;

@SuppressWarnings("serial")
public abstract class BobolinkDebugException extends Exception {
	private int line_number;
	private String message;
	
	public BobolinkDebugException(int line_number, String message) {
		super();
		this.line_number = line_number;
		this.message = message;
	}
	
	public void get_debug_output(PrintStream out) {
		out.println("Compilation Error: " + message + ", line: " + line_number);
	}
}
