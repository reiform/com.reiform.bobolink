package com.reiform.bobolink.parse;

import com.reiform.bobolink.parse.load.BLRawProject;

public class BLLoader {
	//i.e. main.bl
	private String entry_pt_file;
	
	public BLLoader(String entry_pt_file) {
		this.entry_pt_file = entry_pt_file;
	}
	
	public void load_project() {
		BLRawProject p = new BLRawProject("main.bl");
		p.load();
	}
}
