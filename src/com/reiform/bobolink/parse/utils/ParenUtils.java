package com.reiform.bobolink.parse.utils;

import java.util.ArrayList;
import java.util.Stack;

import com.reiform.bobolink.debug.SyntaxErrorException;

public class ParenUtils {
	private static final char L_PAREN = '(';
	private static final char R_PAREN = ')';
	private static final char L_BRACE = '[';
	private static final char R_BRACE = ']';
	private static final char L_BRACKET = '{';
	private static final char R_BRACKET = '}';
	
	public static boolean balanced(ArrayList<String> lines) throws SyntaxErrorException {
		Stack<Character> balance_history = new Stack<Character>();
		
		for (int i = 0; i< lines.size(); i++) {
			
			for (int c = 0; c < lines.get(i).length(); c++) {
				
				Character current = lines.get(i).charAt(c);

				
				if (current.equals(L_PAREN) || 
					current.equals(L_BRACE) || 
					current.equals(L_BRACKET)) {
					balance_history.push(current);
					
				} else {
					boolean balanced = true;
					
					if (current.equals(R_PAREN) || 
						current.equals(R_BRACE) || 
						current.equals(R_BRACKET)) {
					
						char current_char = balance_history.pop();
						
						switch (current) {
							case R_PAREN : balanced = current_char == L_PAREN; break;
							case R_BRACE : balanced = current_char == L_BRACE; break;
							case R_BRACKET : balanced = current_char == L_BRACKET; break;
							default: break;
						
						}
						
						if (!balanced) {
							
						}
					}
				}
			}
		}
		if (balance_history.isEmpty()) return true;
		
		//parentheses not closed
		throw new SyntaxErrorException(lines.size(), "Unbalanced parentheses");
	}
	
	public static ArrayList<BLRawTLBlob> load_top_level_blobs(String line) {
		ArrayList<BLRawTLBlob> top_level_ns_blobs = new ArrayList<BLRawTLBlob>();
		Stack<Character> blob_parens = new Stack<Character>();
		
		String blob = "";  
		
		for (int i=0; i < line.length(); i++) {
			
			char current = line.charAt(i);
			
			if (current == L_PAREN) {
				blob_parens.push(current);
				
			} else {
				if (current == R_PAREN) {		
					blob_parens.pop();	
				}
			}
			blob += current;
			
			if (blob_parens.isEmpty()) {
				top_level_ns_blobs.add(new BLRawTLBlob(blob));
				blob = "";
				
			}	
		}
		return top_level_ns_blobs;
	}
}
