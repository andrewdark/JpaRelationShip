package ua.pp.darnsoft.models.manytomany;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
public class BigItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 2, max = 64)
    @Column(name = "name", length = 65, nullable = false)
    private String name;
    @ManyToMany(mappedBy = "bigItems")
    private Set<Category> categories = new HashSet<>();

    public BigItem() {
    }

    public BigItem(@Size(min = 2, max = 64) String name) {
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

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
