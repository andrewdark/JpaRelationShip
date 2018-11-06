package ua.pp.darnsoft.models.manytoone.jointable;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 2, max = 64)
    @Column(length = 64)
    private String name;

    @OneToMany(mappedBy = "buyer", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Set<Goods> goods = new HashSet<>();

    public Buyer() {
    }

    public Buyer(@Size(min = 2, max = 64) String name) {
        this.name = name;
    }

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

    public Set<Goods> getGoods() {
        return goods;
    }

    public void setGoods(Set<Goods> goods) {
        this.goods = goods;
    }
}
