package com.reiform.bobolink.debug;

import java.io.FileNotFoundException;

@SuppressWarnings("serial")
public class BLFileNotFoundException extends FileNotFoundException {
	public BLFileNotFoundException(String message) {
		super(message);
	}
}
