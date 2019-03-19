package com.reiform.bobolink.parse.load;

import java.util.ArrayList;

import com.reiform.bobolink.debug.SyntaxErrorException;
import com.reiform.bobolink.parse.utils.ParenChecker;

public class BLRawNSExprTree extends BLRawStructure {
	private ArrayList<String> ns_lines;
	private BLRawSExpr[] ns_components;

	public BLRawNSExprTree(ArrayList<String> ns_lines) {
		this.ns_lines = ns_lines;
	}
	
	@Override
	public void load() {
		//load tree from ns_contents into components
		try {
			if (ParenChecker.balanced(ns_lines)) {
				//String[] temp = ns_contents.split("\\s+");
//				for (String s : temp) {
//					System.out.println(s);
//				}
			} else {
				System.out.println("Parentheses not balanced");
			}
		} catch (SyntaxErrorException e) {
			e.get_debug_output(System.out);
		}	
	}
	
	public String[] get_ns_refs() {
		
		return null;
	}
	
	public boolean requires_ns_refs() {
		return "import" == ns_components[0].first_symbol();
	}
	
	private class BLRawSExpr extends BLRawStructure {
		private BLRawSExpr[] components;
		private String expr;
		
		public BLRawSExpr(String expr) {
			this.expr = expr;
		}
		
		public String get_expr() {
			return expr;
		}
		
		public String first_symbol() {
			return components[0].get_expr();
		}

		@Override
		public void load() {
			String[] split = expr.split("\\s+");
			components = new BLRawSExpr[split.length];
			for (int i=0; i< components.length; i++) {
				components[i] = new BLRawSExpr(split[i]);
				components[i].load();
				System.out.println(components[i]);
				//test.split("\\()");
			}
		}
		
	}

}
