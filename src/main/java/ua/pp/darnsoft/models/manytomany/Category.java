package ua.pp.darnsoft.models.manytomany;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 2, max = 64)
    @Column(name = "name", length = 65, nullable = false)
    private String name;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "CATEGORY_BIGITEM",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "bigitem_id"))
    private Set<BigItem> bigItems = new HashSet<>();

    public Category() {
    }

    public Category(@Size(min = 2, max = 64) String name) {
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

    public Set<BigItem> getBigItems() {
        return bigItems;
    }

    public void setBigItems(Set<BigItem> bigItems) {
        this.bigItems = bigItems;
    }
}
