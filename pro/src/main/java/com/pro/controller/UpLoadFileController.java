package com.pro.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import net.sf.json.JSONObject;

@RestController
public class UpLoadFileController {
	
	/*		根据时间来获取时间相关的字符串，避免重复命名		 */
	 public String dates(){
         Date currentTime = new Date();
         SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
         String dateString = formatter.format(currentTime);
         return dateString;
    }
	 
	 /**
	  * 
	  */
	 @RequestMapping("wx_upload.do")
	    public void  uploadPicture(HttpServletRequest request, HttpServletResponse response,PrintWriter writer) throws Exception {
	        System.out.println("进入get方法！");
		//获取从前台传过来得图片
	        MultipartHttpServletRequest req =(MultipartHttpServletRequest)request;
	        MultipartFile multipartFile =  req.getFile("file");
		//获取图片的文件类型
	        String houzhu=multipartFile.getContentType();
	        int one = houzhu.lastIndexOf("/");
	        System.out.println(houzhu.substring((one+1),houzhu.length()));
	        System.out.println(multipartFile.getName());
		//根据获取到的文件类型截取出图片后缀
	        String type=houzhu.substring((one+1),houzhu.length());
	        System.out.println(multipartFile.getContentType());
	 
	        String filename="";
		// request.getRealPath获取我们项目的根地址在加上我们要保存的地址
	        String realPath = request.getRealPath("/upload/wximg/");
	        try {
	            File dir = new File(realPath);
	            if (!dir.exists()) {
	                dir.mkdir();
	            }
	            //获取到当前的日期时间用户生成文件名防止文件名重复
	            String filedata=this.dates();
		    //生成一个随机数来防止文件名重复
	            int x=(int)(Math.random()*1000);
	            filename="agriCulture"+x+filedata;
	            System.out.println(x);
	            System.out.println("所设置的图片文件名称为==="+filename);
	            //		    将文件的地址和生成的文件名拼在一起
	            File file  =  new File(realPath,filename+"."+type);
	            multipartFile.transferTo(file);
		    //将图片在项目中的地址和isok状态储存为json格式返回给前台，由于公司项目中没有fastjson只能用这个
	            JSONObject jsonObject=new JSONObject();
	            jsonObject.put("isOk",1);
	            jsonObject.put("address","/upload/wximg/"+filename+"."+type);
	 
	            writer.write(jsonObject.toString());
//	            return filename;
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (IllegalStateException e) {
	            e.printStackTrace();
	        }
	        
//	        return filename+"无值";
	 }
	

}
