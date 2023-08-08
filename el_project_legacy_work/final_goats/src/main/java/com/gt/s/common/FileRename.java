package com.gt.s.common;

import java.io.File;


import com.oreilly.servlet.multipart.FileRenamePolicy;

public class FileRename implements FileRenamePolicy {

	@Override
	public File rename(File sf) {
		// TODO Auto-generated method stub
		String f = sf.getName();
		
		try {
			String s = f;
			for (int i = 1; sf.exists(); i++) {
				int lt = s.lastIndexOf(".");
				String s1 = s.substring(0,lt);
				String s2 = s.substring(lt);
				String st = "_" + i + "_";
				
				f = s1.concat(st).concat(s2);
				sf = new File(sf.getParent(),f);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("e >>>> : " + e.getMessage());
		}
		
		return sf;
	}

}
