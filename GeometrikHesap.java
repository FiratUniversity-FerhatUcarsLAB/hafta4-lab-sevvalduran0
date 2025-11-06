/*
 * Ad Soyad :ŞEVVAL DURAN
 * Ogrenci No: 240541088
 * Tarih:06.11
 * Aciklama:Gorev 2 - Geometrik Hesap
 *
 *Bu program girilen yarıçapa göre daire ve küreye ait geometrik hesaplamaları yapar
  
import java.util.Scanner;

public class DaireVeKureHesaplayici {
    public static void main(String[] args) {
        final double PI = 3.14159;
        Scanner input = new Scanner(System.in);

        System.out.print("Dairenin yaricapini girin: ");
        double r = input.nextDouble();

        double alan = PI * r * r;
        double cevre = 2 * PI * r;
        double cap = 2 * r;
        double kureHacmi = (4.0 / 3.0) * PI * r * r * r;
        double kureYuzey = 4 * PI * r * r;

        System.out.println("\n=== HESAPLAMA SONUÇLARI ===");
        System.out.printf("Yaricap: %.2f%n", r);
        System.out.printf("Dairenin Alani: %.2f%n", alan);
        System.out.printf("Dairenin Cevresi: %.2f%n", cevre);
        System.out.printf("Dairenin Capi: %.2f%n", cap);
        System.out.printf("Kurenin Hacmi: %.2f%n", kureHacmi);
        System.out.printf("Kurenin Yuzey Alani: %.2f%n", kureYuzey);

        input.close();
    }
}
