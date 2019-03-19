package com.reiform.bobolink.debug;

@SuppressWarnings("serial")
public class SyntaxErrorException extends BobolinkDebugException {
	public SyntaxErrorException(int line, String message) {
		super(line, message);
	}
}
