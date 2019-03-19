package com.reiform.bobolink.parse.load;

import java.io.FileNotFoundException;
import java.util.HashMap;

import com.reiform.bobolink.parse.io.BLFileLoader;

public class BLRawNamespace extends BLRawStructure {
	private String ns_path;
	private String ns_name;
	BLRawProject project;
	private BLRawNSExprTree expr_tree;
	
	public BLRawNamespace(String ns_path, BLRawProject project) {
		this.ns_path = ns_path;
		this.project = project;
	}

	@Override
	public void load() {
		BLFileLoader loader = new BLFileLoader(ns_path);
		try {
			//set ns file contents
			expr_tree = new BLRawNSExprTree(loader.load());
			//load expressions
			expr_tree.load();
			
			//TODO: project.propose_ns_load()
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public BLRawNSExprTree get_expr_tree() {
		return expr_tree;
	}
}
