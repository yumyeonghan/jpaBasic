package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
//item 만 단독으로 테이블에 저장 할 상황이 있으면 일반 class 없으면 추상 클래스
//item 클래스에 BaseEntity 클래스를 상속받게 하여 공통 속성을 사용하게 함.
//이런식으로 모든 엔티티에 BaseEntity 클래스를 상속시키면 공통 속성 사용 가능.
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //상속, 단일 테이블 전략 (JOINED 사용할수있음)
@DiscriminatorColumn
public abstract class Item extends BaseEntity{

    @Id @GeneratedValue
    @Column(name="ITEM_ID")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    @ManyToMany(mappedBy = "items")
    private List<Category> categories=new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
}
