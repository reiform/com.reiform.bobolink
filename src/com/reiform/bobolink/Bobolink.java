package com.reiform.bobolink;

import com.reiform.bobolink.parse.BLLoader;

public class Bobolink {

	public static void main(String[] args) {
		//parse args
		
		BLLoader project_loader = new BLLoader("main.bl");
		project_loader.load_project();
	}

}
