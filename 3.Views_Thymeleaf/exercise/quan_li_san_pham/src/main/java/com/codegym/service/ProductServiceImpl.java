package com.codegym.service;

import com.codegym.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService{
    public static Map<Integer,Product> productList ;
    static {
        productList = new HashMap<>();
        productList.put(1,new Product(1,"Fan","Senko","VietNam"));
        productList.put(2,new Product(2,"Motor","Honda","VietNam"));
        productList.put(3,new Product(3,"Oto","Mecesdes","GG"));
        productList.put(4,new Product(4,"Coffee","Nescafe","VietNam"));
        productList.put(5,new Product(5,"Iphone","Apples","American"));
    }
    @Override
    public List<Product> getAll() {
        return new ArrayList<>(productList.values());
    }

    @Override
    public Product getById(int id) {
        return productList.get(id);
    }

    @Override
    public void createNew(Product product) {
        productList.put(product.getId(),product);
    }

    @Override
    public void delete(int id) {
        productList.remove(id);
    }

    @Override
    public void update(int id, Product product) {
        productList.put(id,product);
    }
}
