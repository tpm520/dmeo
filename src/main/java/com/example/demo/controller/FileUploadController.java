package com.example.demo.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("file")
@Api(tags="文件上传下载")
public class FileUploadController {
	private String path = "src/main/resources/static/imgs";
	/*
	 *  单文件上传
	 */
	
	@PostMapping("oneupload")
	@ApiOperation(value = "单文件上传",notes="单文件上传")
	@ResponseBody
	public String fileUploadOne(@RequestParam("file") MultipartFile file) {
		
		if(file.isEmpty()) return "空文件无法上传";
		
		File filePath = new File(path);
		
		if(!filePath.exists()) {
			filePath.mkdirs();
		};
		
		File dest = new File(filePath.getAbsoluteFile()+File.separator+file.getOriginalFilename());
		System.out.println(dest.getAbsolutePath());
		try {
			file.transferTo(dest);
			return "上传成功";
		} catch (IllegalStateException e) {
			e.printStackTrace();
			return "参数有误";
		} catch (IOException e) {
			e.printStackTrace();
			return "参数有误";
		}
	}
	
	@RequestMapping("joinupload")
	public String mangfile() {
		return "upload";
	}
	
	/**
	 * 多文件上传
	 */
	@PostMapping("mangfile")
	@ApiOperation(value="多文件上传",notes="多文件上传")
	
	@ApiImplicitParam(name = "files",
	value="上传多个文件",
	paramType = "formData",
	allowMultiple = true,
	required = true,
	dataType="file")
	
	@ResponseBody
	public Map<String,Object> mulFileUpload(@RequestParam(value="files",required = true) MultipartFile[] files) {
		//MultipartHttpServletRequest mr = (MultipartHttpServletRequest)request;
		//List<MultipartFile> files = (List<MultipartFile>)mr.getFile("file");
		Map<String,Object> maps = new HashMap<String, Object>();
		if(files.length==0) {
			maps.put("error", "上传文件不能为空");
			return maps;
		}
		File savePath = new File(path);
		if(!savePath.exists()) {
			savePath.mkdirs();
		}
		Integer allNum = files.length;
		Integer success = 0;
		List<String> imgs = new ArrayList<String>();
		for(MultipartFile file:files) {
			String originalName = file.getOriginalFilename();
			String imgUrl = savePath.getAbsolutePath()+File.separator+originalName;
			try {
				imgs.add(imgUrl);
				file.transferTo(new File(imgUrl));
				success++;
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		maps.put("success", success);
		maps.put("error", allNum-success);
		maps.put("imgs", imgs);
		return maps;
	}
}
