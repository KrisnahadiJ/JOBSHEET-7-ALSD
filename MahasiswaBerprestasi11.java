import java.util.Scanner;

public class MahasiswaBerprestasi11 {
    Mahasiswa11 listMhs[];
    int idx;

    // Konstruktor yang menerima jumlah mahasiswa sebagai input
    public MahasiswaBerprestasi11(int jumlahMahasiswa) {
        listMhs = new Mahasiswa11[jumlahMahasiswa];
        idx = 0;
    }

    public void tambah(Mahasiswa11 mhs) {
        if (idx < listMhs.length) {
            listMhs[idx] = mhs;
            idx++;
        } else {
            System.out.println("Data sudah penuh!");
        }
    }

    public void tampil() {
        for (int i = 0; i < idx; i++) { // Menghindari NullPointerException
            listMhs[i].tampilInformasi();
        }
    }

    public void bubbleSort() {
        for (int i = 0; i < idx - 1; i++) {
            for (int j = 1; j < idx - i; j++) {
                if (listMhs[j - 1].getIpk() < listMhs[j].getIpk()) {
                    Mahasiswa11 tmp = listMhs[j];
                    listMhs[j] = listMhs[j - 1];
                    listMhs[j - 1] = tmp;
                }
            }
        }
    }

    public void selectionSortAscending() {
        for (int i = 0; i < idx - 1; i++) {
            int idxMin = i;
            for (int j = i + 1; j < idx; j++) {
                if (listMhs[j].getIpk() < listMhs[idxMin].getIpk()) {
                    idxMin = j;
                }
            }
            Mahasiswa11 tmp = listMhs[idxMin];
            listMhs[idxMin] = listMhs[i];
            listMhs[i] = tmp;
        }
    }

    public void insertionSortAscending() { // Ditambahkan karena dipanggil di MahasiswaDemo11
        for (int i = 1; i < idx; i++) {
            Mahasiswa11 temp = listMhs[i];
            int j = i;
            while (j > 0 && listMhs[j - 1].getIpk() > temp.getIpk()) {
                listMhs[j] = listMhs[j - 1];
                j--;
            }
            listMhs[j] = temp;
        }
    }

    public int sequentialSearch11(double cari) {
        int posisi = -1;
        for (int j = 0; j < idx; j++) {
            if (listMhs[j].getIpk() == cari) {
                posisi = j;
                break;
            }
        }
        return posisi;
    }

    public void tampilPosisi11(double x, int pos) {
        if (pos != -1) {
            System.out.println("Data mahasiswa dengan IPK " + x + " ditemukan pada index " + pos);
        } else {
            System.out.println("Data tidak ditemukan");
        }
    }

    public void tampilDataSearch11(double x, int pos) { // Tambahan
        if (pos != -1) {
            System.out.println("NIM\t: " + listMhs[pos].nim);
            System.out.println("Nama\t: " + listMhs[pos].nama);
            System.out.println("Kelas\t: " + listMhs[pos].kelas);
            System.out.println("IPK\t: " + x);
        } else {
            System.out.println("Data mahasiswa dengan IPK " + x + " tidak ditemukan");
        }
    }

    public int findBinarySearch11(double cari, int left, int right) {
        if (right >= left) {
            int mid = left + (right - left) / 2; // Menghindari overflow
    
            // Jika elemen ditemukan di tengah
            if (listMhs[mid].getIpk() == cari) {
                return mid;
            }
    
            // Jika elemen lebih besar dari nilai tengah, cari di sebelah kiri (descending order)
            if (listMhs[mid].getIpk() < cari) {
                return findBinarySearch11(cari, left, mid - 1);
            }
    
            // Jika elemen lebih kecil dari nilai tengah, cari di sebelah kanan (descending order)
            return findBinarySearch11(cari, mid + 1, right);
        }
    
        // Elemen tidak ditemukan
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Masukkan jumlah mahasiswa: ");
        int jumlahMahasiswa = sc.nextInt();
        sc.nextLine(); // Membuang newline
        
        MahasiswaBerprestasi11 daftarMahasiswa = new MahasiswaBerprestasi11(jumlahMahasiswa);

        // Memasukkan data mahasiswa dari input keyboard
        for (int i = 0; i < jumlahMahasiswa; i++) {
            System.out.println("Mahasiswa ke-" + (i + 1));
            System.out.print("Masukkan NIM: ");
            String nim = sc.nextLine();
            System.out.print("Masukkan Nama: ");
            String nama = sc.nextLine();
            System.out.print("Masukkan Kelas: ");
            String kelas = sc.nextLine();
            System.out.print("Masukkan IPK: ");
            double ipk = sc.nextDouble();
            sc.nextLine(); // Membuang newline

            Mahasiswa11 mhs = new Mahasiswa11(nim, nama, kelas, ipk);
            daftarMahasiswa.tambah(mhs);
        }

        System.out.println("\nData Mahasiswa:");
        daftarMahasiswa.tampil();
        
        sc.close();
    }
}
