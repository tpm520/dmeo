package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Article;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("article")
@Api(tags="文章管理api")
public class ArticleController {
	
	@ApiOperation(value="查询所有的文章",notes="查询文章内容")
	@RequestMapping(value = "find",method=RequestMethod.GET)
	public List<Article> findArticle(){
		return null;
	}
}
