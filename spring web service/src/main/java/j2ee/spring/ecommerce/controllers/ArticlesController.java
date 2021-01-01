package j2ee.spring.ecommerce.controllers;

import j2ee.spring.ecommerce.services.ArticlesService;
import j2ee.spring.ecommerce.repositories.ArticleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class ArticlesController {

    @Autowired
    ArticlesService articlesService;

    @RequestMapping(path = "/",method = RequestMethod.GET)
    public String index(){
        return "index" ;
    }

    @PostMapping(path = "/")
    public String addArticle(@RequestParam("name") String name, @RequestParam("price") int price){
        articlesService.createArticle(name,price);
        return "redirect:/articles";
    }

    @RequestMapping(path = "/articles",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Iterable<ArticleEntity> getAllArticles(){
        return articlesService.getAllArticles() ;
    }

    @RequestMapping(path = "/article",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ArticleEntity getArticleBydId(@NonNull @RequestParam(value = "id") int id){
        return articlesService.getArticleById(id);
    }

}
