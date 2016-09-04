package com.vmetry.ntl.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;

import com.vmetry.ntl.initializer.Initializer;

public class ReportGenerator extends Initializer {
@Test
	public static void archiveFile() throws IOException
	{
		if(isArchive){
		SimpleDateFormat sf=new SimpleDateFormat("YYYY-MM-dd-hh-mm-ss-mmm");
		String date=sf.format(new Date());
		File src=new File("D:\\DDTest\\Screenshot");
		File dst=new File("D:\\DDTest\\ArchiveFolder\\old_"+date);
		
		FileUtils.copyDirectory(src, dst);
		FileUtils.cleanDirectory(src);
		isArchive=false;
		}
	}
}
