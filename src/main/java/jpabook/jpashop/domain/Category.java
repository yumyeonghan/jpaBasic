package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {

    @Id @GeneratedValue
    private Long id;

    private String  name;

    //카테고리 부모를 만들어 서로 맵핑
    @ManyToOne
    @JoinColumn(name="PARENT_ID")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> child=new ArrayList<>();

    //실무에선 안쓰지만 예시
    @ManyToMany
    @JoinTable(name="CATEGORY_ITEM",
                joinColumns = @JoinColumn(name="CATEGORY_ID"),
                inverseJoinColumns = @JoinColumn(name="ITEM_ID")
    )
    private List<Item> items=new ArrayList<>();
}
