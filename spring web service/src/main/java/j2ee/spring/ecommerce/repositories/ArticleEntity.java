package j2ee.spring.ecommerce.repositories;

import javax.persistence.*;

@Entity
@Table(name = "articles")
public class ArticleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private int price;

    public ArticleEntity(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public ArticleEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
