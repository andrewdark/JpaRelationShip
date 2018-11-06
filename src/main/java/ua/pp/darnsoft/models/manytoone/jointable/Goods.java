package ua.pp.darnsoft.models.manytoone.jointable;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 2, max = 64)
    @Column(length = 64)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "GOODS_BUYER",
            joinColumns = @JoinColumn(name = "GOODS_ID"),
            inverseJoinColumns = @JoinColumn(name = "BUYER_ID", nullable = false))
    private Buyer buyer;

    public Goods() {
    }

    public Goods(@Size(min = 2, max = 64) String name) {
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

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }
}
