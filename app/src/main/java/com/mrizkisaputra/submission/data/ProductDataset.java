package com.mrizkisaputra.submission.data;


import com.mrizkisaputra.submission.Product;
import com.mrizkisaputra.submission.R;

import java.util.ArrayList;

public class ProductDataset {

    private static String[] productTitleName = {
            "Acer Predator Hellio 8/1TB SSD Core i7 NVIDIA RTX", "Acer Nitro 5 8/512 HDD Ryzen5 AMD GTX", "ACer Nitro 7 8/512 SSD Core i5 NVIDIA RTX", "Msi Gaming Ryzen7 8/1TB SSD", "HP Pavilion 15 8/512 SSD Ryzen5 NVIDIA RTX",
            "HP Omen 8/1TB SSD Ryzen7 NVIDIA RTX", "Asus TUF 8/512 SSD Ryzen7 NVIDIA RTX", "Asus ROG 12/1TB SSD Core i7 NVIDIA RTX", "Lenovo Legion 8/512 SSD Ryzen7 NViDIA RTX", "HP Evny 8/215 SSD Core i5"
    };

    private static String[] productSubTitleName = {
            "Acer Predator", "Acer Nitro 5", "Acer Nitro 7", "Msi", "HP Pavilion", "HP Omen",
            "Asus Tuf", "Asus Rog", "Lenovo Legion", "HP Evny"
    };

    private static String[] productPrice = {
            "Rp 15.000.000", "Rp 9.999.999", "Rp 12.99.999", "Rp 17.000.000", " Rp 10.000.000", "Rp 18.000.000", "Rp 15.000.000",
            "Rp 20.999.999", "Rp 15.550.000", "Rp 11.000.000"
    };

    private static String[] productDetail = {
            "There are many variations of passages of Lorem Ipsum.There are many variations of passages of Lorem Ipsum available, but the majority have suffered, There are many variations of passages of Lorem Ipsum available, but the majority have suffered available, but the majority have suffered There are many variations of passages of Lorem Ipsum available, but the majority have suffered ",
            "There are many variations of passages of Lorem Ipsum.There are many variations of passages of Lorem Ipsum available, but the majority have suffered, There are many variations of passages of Lorem Ipsum available, but the majority have suffered available, but the majority have suffered There are many variations of passages of Lorem Ipsum available, but the majority have suffered ",
            "There are many variations of passages of Lorem Ipsum.There are many variations of passages of Lorem Ipsum available, but the majority have suffered, There are many variations of passages of Lorem Ipsum available, but the majority have suffered available, but the majority have suffered There are many variations of passages of Lorem Ipsum available, but the majority have suffered ",
            "There are many variations of passages of Lorem Ipsum.There are many variations of passages of Lorem Ipsum available, but the majority have suffered, There are many variations of passages of Lorem Ipsum available, but the majority have suffered available, but the majority have suffered There are many variations of passages of Lorem Ipsum available, but the majority have suffered ",
            "There are many variations of passages of Lorem Ipsum.There are many variations of passages of Lorem Ipsum available, but the majority have suffered, There are many variations of passages of Lorem Ipsum available, but the majority have suffered available, but the majority have suffered There are many variations of passages of Lorem Ipsum available, but the majority have suffered ",
            "There are many variations of passages of Lorem Ipsum.There are many variations of passages of Lorem Ipsum available, but the majority have suffered, There are many variations of passages of Lorem Ipsum available, but the majority have suffered available, but the majority have suffered There are many variations of passages of Lorem Ipsum available, but the majority have suffered ",
            "There are many variations of passages of Lorem Ipsum.There are many variations of passages of Lorem Ipsum available, but the majority have suffered, There are many variations of passages of Lorem Ipsum available, but the majority have suffered available, but the majority have suffered There are many variations of passages of Lorem Ipsum available, but the majority have suffered ",
            "There are many variations of passages of Lorem Ipsum.There are many variations of passages of Lorem Ipsum available, but the majority have suffered, There are many variations of passages of Lorem Ipsum available, but the majority have suffered available, but the majority have suffered There are many variations of passages of Lorem Ipsum available, but the majority have suffered ",
            "There are many variations of passages of Lorem Ipsum.There are many variations of passages of Lorem Ipsum available, but the majority have suffered, There are many variations of passages of Lorem Ipsum available, but the majority have suffered available, but the majority have suffered There are many variations of passages of Lorem Ipsum available, but the majority have suffered ",
            "There are many variations of passages of Lorem Ipsum.There are many variations of passages of Lorem Ipsum available, but the majority have suffered, There are many variations of passages of Lorem Ipsum available, but the majority have suffered available, but the majority have suffered There are many variations of passages of Lorem Ipsum available, but the majority have suffered ",
    };

    private static int[] productStock = {
            10, 6, 18, 3, 7, 10, 12, 4, 13, 6
    };

    private static String[] productOperatingSystem = {
            "Windows 10 Home +Microsoft", "Windows 10 Home", "Windows 10 +Microsoft", "Windows 10 +Microsoft", "Windows 10 Home +Microsoft",
            "Windows 10", "Windows 10", "Windows 10 Home", "Windows 10", "Windows 10 Home"
    };

    private static String[] productResolusi = {
            "FHD 1920 x 1080", "1920x1080", "FHD 1920 x 1080", "1920 x 1080", "FHD 1920x1080", "FHD 1920 x 1080", "1920 x 1080", "FHD 1920 x 1080",
            "FHD 1920x1080", "FHD 1920 x 1080"
    };

    private static String[] productSpek = {
            "1TB SSD | 8 GB","512HDD | 8GB","512 SSD | 8GB","1TB SSD | GB", "512SSD | 8GB", "1TB SSD | 8GB", "512 SSD | 8GB", "1TB SSD | 12GB", "512 SSD | 8GB","215 SSD | 8GB"
    };

    private static int[] productPhoto = {
            R.drawable.acerpredatorhellio,
            R.drawable.acernitro5,
            R.drawable.acernitro7,
            R.drawable.msi,
            R.drawable.hppavilion,
            R.drawable.hpomen,
            R.drawable.asustuf,
            R.drawable.asusrog,
            R.drawable.lenovolegion,
            R.drawable.hpenvy
    };

    public static ArrayList<Product> getDataProduct() {
        ArrayList<Product> list = new ArrayList<>();
        for (int i = 0; i < productTitleName.length; i++) {
            Product product = new Product();
            product.setProductTitleName(productTitleName[i]);
            product.setProductSubtitleName(productSubTitleName[i]);
            product.setProductPrice(productPrice[i]);
            product.setProductPhoto(productPhoto[i]);
            product.setProductDetail(productDetail[i]);
            product.setProductOperatingSystem(productOperatingSystem[i]);
            product.setProductResolusi(productResolusi[i]);
            product.setProductSpek(productSpek[i]);
            product.setProductStok(productStock[i]);

            list.add(product);
        }

        return list;
    }
}
