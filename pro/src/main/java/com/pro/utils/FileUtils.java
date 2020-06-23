package com.pro.utils;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class FileUtils {
	/**
	 * 
	 * @param file 文件
	 * @param path   文件存放路径
	 * @param fileName 原文件名
	 * @return
	 */
	 public static boolean upload(MultipartFile file, String path, String fileName){

	        // 生成新的文件名
	        String realPath = path + "/" + FileNameUtils.getFileName(fileName);

	        //使用原文件名
	       // String realPath = path + "/" + fileName;

	        File dest = new File(realPath);

	        //判断文件父目录是否存在
	        if(!dest.getParentFile().exists()){
	            dest.getParentFile().mkdir();
	        }

	        try {
	            //保存文件
	            file.transferTo(dest);
	            return true;
	        } catch (IllegalStateException e) {	            
	            e.printStackTrace();
	            return false;
	        } catch (IOException e) {
	       	    e.printStackTrace();
	            return false;
	        }

	    }

}
