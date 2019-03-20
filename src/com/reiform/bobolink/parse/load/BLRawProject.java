package com.reiform.bobolink.parse.load;

import java.util.HashMap;

public class BLRawProject extends BLRawStructure {
	private String entry_pt_ns_path;
	private HashMap<String,BLRawNamespace> ns_record;
	
	public BLRawProject(String entry_pt_ns_path) {
		this.entry_pt_ns_path = entry_pt_ns_path;
		ns_record = new HashMap<String, BLRawNamespace>();
	}

	@Override
	public void load() {
		//start by loading entry pt ns
		//which will propose other namespaces to load
		
		//ns_record.put()
		BLRawNamespace entry_pt_ns = new BLRawNamespace(entry_pt_ns_path, this);
		entry_pt_ns.load();
	}
	
	public synchronized void propose_ns_load(String ns) {
		//check if ns loaded, otherwise load
		if (!ns_record.containsKey(ns)) {
			Thread ns_loader = new Thread(new BLRawNamespace(ns, this));
			ns_loader.start();
			//TODO: prevent too many threads
		}
	}
	
	public synchronized void register_completed_load(String ns, BLRawNamespace loaded_ns) {
		//respond to completed loads (from ns load threads)
		ns_record.put(ns, loaded_ns);
	}

}
