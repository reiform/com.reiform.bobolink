package com.reiform.bobolink.parse.utils;

import java.util.ArrayList;

public class BLRawTLBlob {
	private ArrayList<BLRawTLBlob> children;
	
	private String expr;
	private String[] components;
	
	public BLRawTLBlob(String expr) {
		this.expr = expr;
		
		//only need to load children if more nesting
//		if(expr.matches(".*[\\(\\)\\[\\]\\{\\}].*")) {
//			children = ParenUtils.load_blobs(expr);
//		}
	}
	
	public String get_blob() {
		return expr;
	}
}
