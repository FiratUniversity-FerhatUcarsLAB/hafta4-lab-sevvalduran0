/*
 * Ad Soayd :ŞEVVAL DURAN
 * Ogrenci No:240541088
 * Tarih:06.11
 * Aciklama: Gorev 3 Maas Hesabi
 *
 * Bu program maaş bordrosu hesaplama ve formatlama işini yapar.
import java.util.Scanner;
import java.text.DecimalFormat;

public class MaasBordrosuHesaplayici {

    // Özel gereksinim: Tüm kesinti oranlarını sabit (final) olarak tanımlayın
    private static final double SGK_ORAN = 0.14;       // %14
    private static final double GELIR_VERGISI_ORAN = 0.15; // %15
    private static final double DAMGA_VERGISI_ORAN = 0.00759; // %0.759
    
    // Mesai hesaplama sabitleri
    private static final int AYLIK_ORTALAMA_CALISMA_SAATI = 160;
    private static final double MESAI_KAT_SAYISI = 1.5;
    private static final int AYLIK_IS_GUNU_SAYISI = 22; // İstatistikler için varsayım

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Para değerleri için 2 ondalık basamak formatı
        DecimalFormat paraFormat = new DecimalFormat("#,##0.00 TL");
        // Yüzde değerleri için 1 ondalık basamak formatı
        DecimalFormat yuzdeFormat = new DecimalFormat("0.0'%'");

        // Kullanıcıdan Bilgileri Alınması
        System.out.println("Calisan Maas Bordrosu Hesaplama Programı");
        System.out.println("----------------------------------------------");

        System.out.print("Calisanin Adi ve Soyadi: ");
        String adSoyad = scanner.nextLine();

        System.out.print("Aylik Brut Maas (TL): ");
        double brutMaas = scanner.nextDouble();

        System.out.print("Haftalik Calisma Saati (Saat): ");
        int haftalikCalismaSaati = scanner.nextInt();

        System.out.print("Mesai Saati Sayisi (Saat): ");
        int mesaiSaati = scanner.nextInt();

        // --- HESAPLAMALAR ---
  
        // 1. Toplam Gelir ve Mesai Ücreti Hesaplama
        
        // Brut saatlik ücret = Brut Maas / 160
        double brutSaatlikUcret = brutMaas / AYLIK_ORTALAMA_CALISMA_SAATI;
        
        // Mesai ücreti = (Brut Maas / 160) × Mesai Saati × 1.5
        double mesaiUcreti = brutSaatlikUcret * mesaiSaati * MESAI_KAT_SAYISI;
        
        // Toplam Gelir = Brut maas + Mesai ücreti
        double toplamGelir = brutMaas + mesaiUcreti;

        // 2. Kesintiler Hesaplama
        
        // SGK Kesintisi: Toplam Gelirin %14'ü
        double sgkKesintisi = toplamGelir * SGK_ORAN;
        
        // Gelir Vergisi: Toplam Gelirin %15'ü
        double gelirVergisi = toplamGelir * GELIR_VERGISI_ORAN;
        
        // Damga Vergisi: Toplam Gelirin %0.759'ü
        double damgaVergisi = toplamGelir * DAMGA_VERGISI_ORAN;
        
        // Toplam Kesinti: Tüm kesintilerin toplamı
        double toplamKesinti = sgkKesintisi + gelirVergisi + damgaVergisi;

        // 3. Net Maaş Hesaplama
        
        // Net Maaş = Toplam Gelir - Toplam Kesinti
        double netMaas = toplamGelir - toplamKesinti;
        
        // 4. İstatistikler Hesaplama
        
        // Kesinti oranı (yüzde olarak) = (Toplam Kesinti / Toplam Gelir) * 100
        double kesintiOrani = (toplamKesinti / toplamGelir);
        
        // Aylık toplam calisma saati
        // Haftalık 40 saat varsayımıyla aylık calisma saati: (40 / 7) * 30 -> Karmasik
        // En basit yöntemle, brüt maaşın hesaplandığı 160 saati baz alalım, mesai ekleyelim:
        int toplamCalismaSaati = AYLIK_ORTALAMA_CALISMA_SAATI + mesaiSaati;
        
        // Saatlik net kazanç = Net Maas / Toplam Calisma Saati
        double saatlikNetKazanc = netMaas / toplamCalismaSaati;
        
        // Günlük net kazanç = Net Maas / 22 iş günü
        double gunlukNetKazanc = netMaas / AYLIK_IS_GUNU_SAYISI;

        // --- BORDRO ÇIKTISI ---

        System.out.println("\n\n=== 📄 Calisan Maas Bordrosu 📄 ===");
        System.out.println("----------------------------------------------");
        System.out.printf("| %-20s | %-20s |\n", "Calisan Adi Soyadı", adSoyad);
        System.out.printf("| %-20s | %-20s |\n", "Haftalik Çalışma", haftalikCalismaSaati + " Saat");
        System.out.printf("| %-20s | %-20s |\n", "Mesai Saati", mesaiSaati + " Saat");
        System.out.println("----------------------------------------------");
        
        // 1. Gelir Bilgileri
        System.out.println("### GELİR BİLGİLERİ ###");
        System.out.printf("| %-20s | %-20s |\n", "Brut Maas", paraFormat.format(brutMaas));
        System.out.printf("| %-20s | %-20s |\n", "Mesai Ücreti", paraFormat.format(mesaiUcreti));
        System.out.println("|----------------------|----------------------|");
        System.out.printf("| %-20s | %-20s |\n", "**TOPLAM GELİR**", "**" + paraFormat.format(toplamGelir) + "**");
        System.out.println("----------------------------------------------");
        
        // 2. Kesinti Bilgileri
        System.out.println("### KESINTI BILGILERI ###");
        System.out.printf("| %-20s | %-20s |\n", "SGK Kesintisi (%14)", paraFormat.format(sgkKesintisi));
        System.out.printf("| %-20s | %-20s |\n", "Gelir Vergisi (%15)", paraFormat.format(gelirVergisi));
        System.out.printf("| %-20s | %-20s |\n", "Damga Vergisi (%0.759)", paraFormat.format(damgaVergisi));
        System.out.println("|----------------------|----------------------|");
        System.out.printf("| %-20s | %-20s |\n", "**TOPLAM KESİNTİ**", "**" + paraFormat.format(toplamKesinti) + "**");
        System.out.println("----------------------------------------------");
        
        // 3. Net Ödeme
        System.out.println("### NET ODEME ###");
        System.out.printf("| %-20s | %-20s |\n", "**NET MAAŞ**", "**" + paraFormat.format(netMaas) + "**");
        System.out.println("==============================================");
        
        // 4. İstatistikler
        System.out.println("### ISTATISTIKLER ###");
        System.out.printf("| %-20s | %-20s |\n", "Kesinti Oranı", yuzdeFormat.format(kesintiOrani));
        System.out.printf("| %-20s | %-20s |\n", "Saatlik Net Kazanç", paraFormat.format(saatlikNetKazanc));
        System.out.printf("| %-20s | %-20s |\n", "Günlük Net Kazanç", paraFormat.format(gunlukNetKazanc));
        System.out.println("----------------------------------------------");

        scanner.close();
    }
}
