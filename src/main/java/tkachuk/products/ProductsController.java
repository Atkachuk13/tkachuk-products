package tkachuk.products;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class ProductsController
{
    private ProductsService service;
    JLabel[] images;

    public ProductsController(ProductsService service, JLabel[] images)
    {
        this.service = service;
        this.images = images;
    }

    public void display()
    {
        ProductsResponse products = service.getProducts()
                .blockingGet();

        for (int i = 0; i < images.length; i++)
        {
            Product product = products.products[i];
            try
            {
                URL url = new URL(product.thumbnail);
                Image image = ImageIO.read(url);
                ImageIcon imageIcon = new ImageIcon(image);
                images[i].setIcon(imageIcon);
            } catch (MalformedURLException e)
            {
                throw new RuntimeException(e);
            } catch (IOException e)
            {
                throw new RuntimeException(e);
            }

        }
    }
}
