package com.reiform.bobolink.parse.load;

import java.util.HashMap;

public class BLRawProject extends BLRawStructure {
	private String entry_pt_ns_path;
	private HashMap<String,BLRawNamespace> ns_record;
	
	public BLRawProject(String entry_pt_ns_path) {
		this.entry_pt_ns_path = entry_pt_ns_path;
	}

	@Override
	public void load() {
		//start by loading entry pt ns
		//which will propose other namespaces to load
		
		//ns_record.put()
		BLRawNamespace ns = new BLRawNamespace(entry_pt_ns_path, this);
		ns.load();
	}
	
	public void propose_ns_load(String ns) {
		//check if ns loaded, otherwise load
	}

}
