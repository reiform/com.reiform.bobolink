package com.reiform.bobolink.parse.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.reiform.bobolink.debug.BLFileNotFoundException;

public class BLFileLoader {
	private String path;
	
	public BLFileLoader(String path) {
		this.path = path;
	}
	
	public ArrayList<String> load() throws FileNotFoundException {
		ArrayList<String> output = new ArrayList<String>();;
		File file = new File(path);
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);

		String line;
		try {
			while((line = br.readLine()) != null){
			     output.add(line);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return output;
	}
}
