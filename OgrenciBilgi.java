/*
 * Ad Soyad: [ŞEVVAL DURAN]
 * Ogrenci No: [240541088]
 * Tarih: [06.11]
 * Aciklama: Gorev 1 - Ogrenci Bilgi Sistemi
 * 
 * Bu program kullanicidan ogrenci bilgilerini alir ve
 * duzenli bir formatta ekrana yazdirir.
 * Diğer java dosyalarının başında da bu örnek formattaki gibi kısa bilgi giriniz
 */

import java.util.Scanner;

public class OgrenciBilgiSistemi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Bilgilerin kullanıcıdan alınması
        System.out.print("Öğrencinin adını girin: ");
        String ad = input.nextLine();

        System.out.print("Öğrencinin soyadını girin: ");
        String soyad = input.nextLine();

        System.out.print("Öğrenci numarasını girin: ");
        int ogrNo = input.nextInt();

        System.out.print("Yaşını girin: ");
        int yas = input.nextInt();

        System.out.print("GPA (0.00 - 4.00): ");
        double gpa = input.nextDouble();

        // Durum belirleme
        String durum;
        if (gpa >= 2.5) {
            durum = "Basarili Ogrenci";
        } else {
            durum = "Basarisiz Ogrenci";
        }

        // Çıktının düzenli şekilde yazdırılması
        System.out.println("\n=== OGRENCI BILGI SISTEMI ===");
        System.out.printf("Ad Soyad: %s %s%n", ad, soyad);
        System.out.printf("Ogrenci No: %d%n", ogrNo);
        System.out.printf("Yas: %d%n", yas);
        System.out.printf("GPA: %.2f%n", gpa);
        System.out.printf("Durum: %s%n", durum);

        input.close();
    }
}

