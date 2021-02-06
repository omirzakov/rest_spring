package com.example.rest_iitu.controller;

import com.example.rest_iitu.classes.Product;
import com.example.rest_iitu.exceptions.NotFoundException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("products")
public class ProductController {
    private int counter = 5;

    private List<Map<String, String>> products = new ArrayList<Map<String, String>>() {{
        add(new HashMap<String, String>() {{ put("id", "1"); put("name", "Iphone 6s"); put("imageURL", "https://object.pscloud.io/cms/cms/Photo/img_0_77_2249_0_320.webp");   put("uriName", "iphone6s"); }});
        add(new HashMap<String, String>() {{ put("id", "2"); put("name", "Iphone 7");  put("imageURL", "https://object.pscloud.io/cms/cms/Photo/img_0_77_1084_0_320.webp");   put("uriName", "iphone7"); }});
        add(new HashMap<String, String>() {{ put("id", "3"); put("name", "Iphone SE"); put("imageURL", "https://object.pscloud.io/cms/cms/Photo/img_0_77_2744_3_6_320.webp"); put("uriName", "iphonese"); }});
        add(new HashMap<String, String>() {{ put("id", "3"); put("name", "Iphone XR"); put("imageURL", "https://object.pscloud.io/cms/cms/Photo/img_0_77_2758_0_6_320.webp"); put("uriName", "iphonexr"); }});
    }};



    @GetMapping
    public List<Map<String, String>> list() {
        return products;
    }

    @GetMapping("{id}")
    public Map<String, String> getOne(@PathVariable String id) {
        return getProduct(id);
    }


    private Map<String, String> getProduct(@PathVariable String id) {
        return products.stream()
                .filter(messages -> messages.get("id").equals(id))
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }

    @PostMapping
    public Map<String, String> create(@RequestBody Map<String, String> product) {
        System.out.println(product);
        product.put("id", String.valueOf(counter++));
        products.add(product);

        return product;
    }

    @PutMapping("{uriName}")
    public Map<String, String> update(@PathVariable String uriName, @RequestBody Map<String, String> product) {
        Map<String, String> productFromDB = getProduct(product.get("id"));

        productFromDB.putAll(product);
        productFromDB.put("uriName", uriName);

        return productFromDB;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        Map<String, String> product = getProduct(id);

        products.remove(product);
    }
}
