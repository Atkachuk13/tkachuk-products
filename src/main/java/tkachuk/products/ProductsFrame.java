package tkachuk.products;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

public class ProductsFrame extends JFrame
{
    private JLabel[] labels = new JLabel[9];
    private ProductsController controller;

    public ProductsFrame()
    {
        setTitle(("Products"));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900, 700);

        setLayout(new GridLayout(3, 3));
        for (int i = 0; i < labels.length; i++)
        {
            final int index = i;
            labels[i] = new JLabel();

            labels[i].addMouseListener(new MouseAdapter()
            {
                @Override
                public void mouseClicked(MouseEvent e)
                {
                    Product product = (Product) labels[index].getClientProperty("product");
                    if (product != null)
                    {
                        try
                        {
                            URL imageUrl = new URL(product.thumbnail);
                            new ProductsDisplayFrame(imageUrl, product.title, product.description);
                        } catch (Exception ex)
                        {
                            ex.printStackTrace();
                        }
                    }
                }
            });

            add(labels[i]);

        }

        controller = new ProductsController(new ProductsServiceFactory().create(),
                labels);
        controller.display();
    }

    public static void main(String[] args)
    {
        new ProductsFrame().setVisible(true);
    }
}
