package com.reiform.bobolink.parse.load;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import com.reiform.bobolink.debug.SyntaxErrorException;
import com.reiform.bobolink.parse.io.BLFileLoader;
import com.reiform.bobolink.parse.utils.BLRawTLBlob;
import com.reiform.bobolink.parse.utils.ParenUtils;

public class BLRawNamespace extends BLRawStructure implements Runnable {
	private String ns_path;
	private String ns_name;
	private BLRawProject project;
	private ArrayList<BLRawTLBlob> top_level_blobs;
	
	
	public BLRawNamespace(String ns_path, BLRawProject project) {
		this.ns_path = ns_path;
		this.project = project;
	}

	@Override
	public void load() {
		BLFileLoader loader = new BLFileLoader(ns_path);
		
		try {
			ArrayList<String> ns_lines = loader.load();
			
			ParenUtils.balanced(ns_lines);
			
			String ns_line = "";
			for (String s : ns_lines) {
				ns_line += s;
			}
			
			top_level_blobs = ParenUtils.load_top_level_blobs(ns_line);
			
			//TODO: get import/ns blob and recursively load
			
			
			String parsed_ns = "";
			project.register_completed_load(parsed_ns, this);
			
			//TODO: project.propose_ns_load()
			
		} catch (FileNotFoundException | SyntaxErrorException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		//namespaces are loaded into threads
		load();	
	}
}
