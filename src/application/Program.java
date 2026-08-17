package application;

import entities.Produtos.ImportedProduct;
import entities.Produtos.Product;
import entities.Produtos.UsedProduct;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Product> products = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {

            System.out.println("Product #" + i + " data:");

            System.out.print("Common, used or imported (c/u/i)? ");
            char type = sc.next().charAt(0);

            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();

            System.out.print("Price: ");
            double price = sc.nextDouble();

            if (type == 'i') {

                System.out.print("Customs fee: ");
                double customsFee = sc.nextDouble();

                products.add(new ImportedProduct(name, price, customsFee));

            } else if (type == 'u') {

                System.out.print("Manufacture date (DD/MM/YYYY): ");
                sc.nextLine();
                String manufactureDate = sc.nextLine();

                products.add(new UsedProduct(name, price, manufactureDate));

            } else {

                products.add(new Product(name, price));

            }
        }

        System.out.println();
        System.out.println("PRICE TAGS:");

        for (Product p : products) {
            System.out.println(p.priceTag());
        }

        sc.close();
    }
}