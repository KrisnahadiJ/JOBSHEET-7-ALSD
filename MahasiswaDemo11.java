import java.util.Locale;
import java.util.Scanner;

public class MahasiswaDemo11 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US); // Untuk membaca angka desimal dengan titik
        Scanner sc = new Scanner(System.in);
        MahasiswaBerprestasi11 list = new MahasiswaBerprestasi11(10);

        System.out.print("Masukkan jumlah mahasiswa: ");
        int jumlahMahasiswa = sc.nextInt();
        sc.nextLine(); // Konsumsi newline

        for (int i = 0; i < jumlahMahasiswa; i++) {
            System.out.println("Masukkan data mahasiswa ke-" + (i + 1) + ":");
            System.out.print("NIM: ");
            String nim = sc.nextLine();
            System.out.print("Nama: ");
            String nama = sc.nextLine();
            System.out.print("Kelas: ");
            String kelas = sc.nextLine();
            System.out.print("IPK: ");
            double ipk = sc.nextDouble();
            sc.nextLine(); // Konsumsi newline

            list.tambah(new Mahasiswa11(nim, nama, kelas, ipk));
        }

        System.out.println("\nData mahasiswa sebelum sorting:");
        list.tampil();

        // Pencarian data menggunakan sequential search dam binary search
        System.out.println("---------------------------------------------");
        System.out.println("----------------Pencarian data---------------");
        System.out.println("---------------------------------------------");
        System.out.print("Masukkan IPK mahasiswa yang dicari: ");
        double cari = sc.nextDouble();
        System.out.println("---------------------------------------------");
        System.out.println("---------Menggunakan sequential search-------");
        System.out.println("---------------------------------------------");
        int posisiSequential = list.sequentialSearch11(cari);
        list.tampilPosisi11(cari, posisiSequential);
        list.tampilDataSearch11(cari, posisiSequential);

        // Sorting dan menampilkan data
        System.out.println("\nData mahasiswa setelah sorting berdasarkan IPK (DESC) dengan Bubble Sort:");
        list.bubbleSort();
        list.tampil();

        System.out.println("\nData yang sudah terurut menggunakan SELECTION SORT (ASC):");
        list.selectionSortAscending();
        list.tampil();

        System.out.println("\nData yang sudah terurut menggunakan INSERTION SORT (ASC):");
        list.insertionSortAscending();
        list.tampil();

        sc.close(); // Menutup scanner
    }
}