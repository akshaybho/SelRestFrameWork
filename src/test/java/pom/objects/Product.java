package pom.objects;

import utilities.Utils;

import java.io.IOException;

public class Product {

    private int id;
    private String name;

    public Product()
    {

    }
    public Product(int id) throws IOException {
        Product[] prod = Utils.deserializeJson("products.json", Product[].class);

        for(Product products : prod)
        {
            if(products.getId() == id)
            {
                this.id = id;
                this.name = products.getName();
            }
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
