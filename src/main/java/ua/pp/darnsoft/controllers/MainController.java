package ua.pp.darnsoft.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.pp.darnsoft.models.manytomany.BigItem;
import ua.pp.darnsoft.models.manytomany.Category;
import ua.pp.darnsoft.models.manytomany.intermediate.entity.RoleE;
import ua.pp.darnsoft.models.manytomany.intermediate.entity.RoledUser;
import ua.pp.darnsoft.models.manytomany.intermediate.entity.UserE;
import ua.pp.darnsoft.models.manytoone.Bid;
import ua.pp.darnsoft.models.manytoone.Item;
import ua.pp.darnsoft.models.manytoone.jointable.Buyer;
import ua.pp.darnsoft.models.manytoone.jointable.Goods;
import ua.pp.darnsoft.models.onetoone.Address;
import ua.pp.darnsoft.models.onetoone.User;
import ua.pp.darnsoft.repository.*;

import java.math.BigDecimal;

import static java.util.Arrays.asList;

@Controller
public class MainController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    BuyerRepository buyerRepository;
    @Autowired
    BigItemRepository bigItemRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    RoledUserRepository roledUserRepository;
    @Autowired
    UserERepository userERepository;
    @Autowired
    RoleERepository roleERepository;

    @GetMapping(value = {"/", "/index"})
    public String index(Model dasModel) {
        User u1 = new User("Ololoev");
        Address adr1 = new Address("Odessa");
        u1.setAddress(adr1);
        adr1.setUser(u1);
        userRepository.save(u1);

        //userRepository.save(u1);
        User unknown = userRepository.findById(u1.getId()).get();

        dasModel.addAttribute("user", unknown);


        return "index";
    }

    @GetMapping(value = "/ManyToOne")
    public String manyToOne(Model dasModel) {
        Item item = new Item("kkkkk");

        Bid b1 = new Bid();
        Bid b2 = new Bid();
        Bid b3 = new Bid();
        b1.setPrice(new BigDecimal(1.01));
        b2.setPrice(new BigDecimal(2.02));
        b3.setPrice(new BigDecimal(3.03));
        b1.setItem(item);
        b2.setItem(item);
        b3.setItem(item);
        item.getBids().add(b1);
        item.getBids().add(b2);
        item.getBids().add(b3);

        itemRepository.save(item);

        dasModel.addAttribute("item", item);
        //______________________________________JOIN_TABLE______________________
        Buyer buyer = new Buyer("Tolik");

        Goods g1 = new Goods("goods_1");
        Goods g2 = new Goods("goods_2");
        Goods g3 = new Goods("goods_3");
        buyer.getGoods().add(g1);
        buyer.getGoods().add(g2);
        buyer.getGoods().add(g3);
        g1.setBuyer(buyer);
        g2.setBuyer(buyer);
        g3.setBuyer(buyer);
        buyerRepository.save(buyer);
        dasModel.addAttribute("buyer", buyer);
        return "ManyToOne";
    }

    @GetMapping(value = "/ManyToMany")
    public String manyToMany(Model dasModel) {
        Category cat1 = new Category("SomeCategory");
        Category cat2 = new Category("OtherCategory");

        BigItem it1 = new BigItem("SomeItem");
        BigItem it2 = new BigItem("OtherItem");
        BigItem it3 = new BigItem("BigItem_333");
        BigItem it4 = new BigItem("BigItem_444");

        cat1.getBigItems().add(it1);
        it1.getCategories().add(cat1);

        cat2.getBigItems().add(it2);
        it2.getCategories().add(cat2);

        cat1.getBigItems().add(it3);
        it3.getCategories().add(cat1);

        cat1.getBigItems().add(it4);
        it4.getCategories().add(cat1);
        it4.getCategories().add(cat2);

        categoryRepository.save(cat1);
        categoryRepository.save(cat2);

        dasModel.addAttribute("categories", categoryRepository.findAll());
        dasModel.addAttribute("items", bigItemRepository.findAll());
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        UserE u1 = new UserE();
        u1.setUserName("Admin");
        u1.setEncryptedPassword("123456");
        u1.setEnabled(true);
        UserE u2 = new UserE();
        u2.setUserName("User");
        u2.setEncryptedPassword("123456");
        u2.setEnabled(true);
        UserE u3 = new UserE();
        u3.setUserName("Guest");
        u3.setEncryptedPassword("123456");
        u3.setEnabled(true);
        userERepository.saveAll(asList(u1, u2, u3));

        RoleE r1 = new RoleE();
        r1.setRoleName("ROLE_USER");
        RoleE r2 = new RoleE();
        r2.setRoleName("ROLE_ADMIN");
        roleERepository.saveAll(asList(r1, r2));

        RoledUser link0 = new RoledUser(r1, u1);
        RoledUser link1 = new RoledUser(r1, u2);
        RoledUser link2 = new RoledUser(r1, u3);
        RoledUser link3 = new RoledUser(r2, u1);

        roledUserRepository.saveAll(asList(link1, link2, link3));

        dasModel.addAttribute("roledusers",roledUserRepository.findAll());
        return "ManyToMany";
    }

}
