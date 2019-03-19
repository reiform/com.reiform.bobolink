package com.reiform.bobolink.parse;

@SuppressWarnings("serial")
public class BLLoadException extends Exception {
	public BLLoadException(String filename, Throwable err) {
		super("Error loading file: " + filename, err);
	}
}
