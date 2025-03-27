public class Mahasiswa11 {
    String nim;
    String nama;
    String kelas;
    double ipk;

    public Mahasiswa11(String nim, String nama, String kelas, double ipk) {
        this.nim = nim;
        this.nama = nama;
        this.kelas = kelas;
        this.ipk = ipk;
    }

    public double getIpk() { // Getter untuk IPK
        return ipk;
    }

    public void tampilInformasi() { // Menampilkan data mahasiswa
        System.out.println("NIM\t: " + nim);
        System.out.println("Nama\t: " + nama);
        System.out.println("Kelas\t: " + kelas);
        System.out.println("IPK\t: " + ipk);
        System.out.println("------------------------");
    }
}
