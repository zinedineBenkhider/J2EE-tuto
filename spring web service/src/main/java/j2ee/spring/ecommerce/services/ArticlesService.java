package j2ee.spring.ecommerce.services;

import j2ee.spring.ecommerce.repositories.ArticlesRepository;
import j2ee.spring.ecommerce.repositories.ArticleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticlesService {
    @Autowired
    private ArticlesRepository articlesRepository;

    public Iterable<ArticleEntity> getAllArticles(){
        return articlesRepository.findAll();
    }
    public ArticleEntity getArticleById(int id){
        return articlesRepository.findById(id).get();
    }
    public void createArticle(String name,int price){
        ArticleEntity articleEntity=new ArticleEntity(name,price);
        articlesRepository.save(articleEntity);
    }
}
