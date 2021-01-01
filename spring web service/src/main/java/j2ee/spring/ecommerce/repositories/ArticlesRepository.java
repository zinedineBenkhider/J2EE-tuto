package j2ee.spring.ecommerce.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticlesRepository extends CrudRepository<ArticleEntity, Integer> {

}
