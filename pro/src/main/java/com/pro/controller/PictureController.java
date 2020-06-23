package com.pro.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.UUID;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

//import com.etc.entity.JsonResult;
//import com.etc.enums.ErrorEnum;
//import com.etc.excetpion.SBMException;

@RestController
@RequestMapping("**.do")
public class PictureController {

	private String localPath = "";

	public PictureController() throws UnsupportedEncodingException{
		localPath = (String.valueOf(Thread.currentThread().getContextClassLoader().getResource("")+"static/")).replaceAll("file:/", "").replaceAll("%20", " ").trim();
		if(localPath.indexOf(":") != 1){
			localPath = File.separator + localPath;
		}
		localPath = URLDecoder.decode(localPath,"UTF-8");   //解决绝对路径中文乱码
	}

	@RequestMapping("/savepic")
	public String save(@RequestParam("pic") MultipartFile pic) throws IOException {
		//获取项目编译之后的文件路径，一般是“项目路径/target/classes”

		//遍历文件
		if(pic != null){
			String uuid = UUID.randomUUID().toString().replaceAll("-","");
			String contentType=pic.getContentType();
			//获得文件后缀名称
			String imageName=contentType.substring(contentType.indexOf("/")+1);
			//String fileName = pic.getOriginalFilename();//不用原文件名，避免重复
			String fileName = uuid+"."+imageName;
			String filePath = localPath + "uploadFiles/";//自定义上传路径
			String savePath = "uploadFiles/"+fileName;    //存储到数据库需要用带项目路径，便于后续访问
			//System.out.println(filePath+fileName);
			File file = new File(filePath,fileName);   //上传到本地需要保存到物理路径
			if(!file.exists()){//判断文件夹是否存在，如果不存在则创建
				if(!file.getParentFile().exists()){
					file.getParentFile().mkdirs();
				}
				file.createNewFile();
			}
			pic.transferTo(file);//上传文件
			return  savePath;
		}else{
//			throw new SBMException(ErrorEnum.UPLOAD_FILE_FAIL);
			return null;
		}
	}

//	@RequestMapping("removepic")
//	public JsonResult removepic(String paths) throws IOException {
//		boolean clear = true;
//		paths = URLDecoder.decode(paths,"UTF-8");
//		for(String path : paths.split(";")){
//			File file = new File(localPath+path);
//			if(file.exists()){
//				file.delete();
//			}else{
//				clear = false;
//			}
//		}
//		if(!clear){
//			throw new SBMException(ErrorEnum.REMOVE_FILE_FAIL);
//		}
//		return new JsonResult("删除成功");
//	}
}
