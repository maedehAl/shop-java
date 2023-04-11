package org.example.view;

import org.example.model.Product;

import java.util.List;

public class ProductView {

    public String getProductListView(List<Product> products) {
        String respone = "<html>\n" +
                "<head>\n" +
                "    <title>hello world</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div style=\"width: 600px;margin: auto\">\n" +
                "<b>it is  products ... </b>\n" +
                "<br/>\n" +
                "<table>\n" +
                "    <tr>\n" +
                "        <td>id</td>\n" +
                "        <td>name</td>\n" +
                "        <td>price</td>\n" +
                "        <td>count</td>\n" +
                "    </tr>\n";

        for (Product product: products) {
            respone += "<tr> " +
                    "<td>" + product.getId() + "</td>" +
                    "<td>" + product.getNAME() + "</td>" +
                    "<td>" + product.getPRICE() + "</td>" +
                    "<td>" + product.getCOUNT() + "</td>" +
                    " </tr>";
        }
        respone += "\n" +
                "</table>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>";


        return respone;
    }
}
