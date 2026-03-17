package com.example.shop.config;

import com.example.shop.entity.Customer;
import com.example.shop.entity.Inventory;
import com.example.shop.entity.Product;
import com.example.shop.repository.CustomerRepository;
import com.example.shop.repository.InventoryRepository;
import com.example.shop.repository.ProductRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadData(
            CustomerRepository customerRepo,
            ProductRepository productRepo,
            InventoryRepository inventoryRepo
    ) {

        return args -> {

            // Seed only if database is empty
            if (customerRepo.count() > 0) {
                System.out.println("Database already seeded.");
                return;
            }

            // ----- Customers -----

            Customer c1 = new Customer();
            c1.setName("Alice");
            c1.setEmail("alice@mail.com");

            Customer c2 = new Customer();
            c2.setName("Bob");
            c2.setEmail("bob@mail.com");

            Customer c3 = new Customer();
            c3.setName("Charlie");
            c3.setEmail("charlie@mail.com");

            Customer c4 = new Customer();
            c4.setName("Diana");
            c4.setEmail("diana@mail.com");

            Customer c5 = new Customer();
            c5.setName("Eve");
            c5.setEmail("eve@mail.com");

            customerRepo.save(c1);
            customerRepo.save(c2);
            customerRepo.save(c3);
            customerRepo.save(c4);
            customerRepo.save(c5);

            // ----- Products -----

            Product p1 = new Product();
            p1.setName("Gaming Mouse");
            p1.setPrice(499);

            Product p2 = new Product();
            p2.setName("Mechanical Keyboard");
            p2.setPrice(1299);

            Product p3 = new Product();
            p3.setName("4K Monitor");
            p3.setPrice(3999);

            Product p4 = new Product();
            p4.setName("USB-C Hub");
            p4.setPrice(699);

            Product p5 = new Product();
            p5.setName("Webcam");
            p5.setPrice(899);

            productRepo.save(p1);
            productRepo.save(p2);
            productRepo.save(p3);
            productRepo.save(p4);
            productRepo.save(p5);

            // ----- Inventory -----

            Inventory i1 = new Inventory();
            i1.setProduct(p1);
            i1.setQuantity(20);

            Inventory i2 = new Inventory();
            i2.setProduct(p2);
            i2.setQuantity(15);

            Inventory i3 = new Inventory();
            i3.setProduct(p3);
            i3.setQuantity(10);

            Inventory i4 = new Inventory();
            i4.setProduct(p4);
            i4.setQuantity(30);

            Inventory i5 = new Inventory();
            i5.setProduct(p5);
            i5.setQuantity(25);

            inventoryRepo.save(i1);
            inventoryRepo.save(i2);
            inventoryRepo.save(i3);
            inventoryRepo.save(i4);
            inventoryRepo.save(i5);

            System.out.println("Database seeded with demo data.");
        };
    }
}