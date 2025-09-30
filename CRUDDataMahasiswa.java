import java.util.Scanner;

class Mahasiswa {
    String nama;
    int NIM;
    double IPK;

    Mahasiswa(String nama, int NIM, double IPK) {
        this.nama = nama;
        this.NIM = NIM;
        this.IPK = IPK;
    }

    void rubahIPK(double IPKBaru) {
        this.IPK = IPKBaru;
    }

    void tampilkanInfo() {
        System.out.println("Nama: " + this.nama + ", NIM: " + this.NIM + ", IPK: " + this.IPK);
    }
}

public class CRUDDataMahasiswa {
    public static void main(String[] args) throws Exception {
        System.out.println("=============================");
        System.out.println(" CRUD Project Data Mahasiswa");
        System.out.println("=============================");
        Scanner inputTerminal = new Scanner(System.in);
        Mahasiswa[] mahasiswaList = new Mahasiswa[100];
        int count = 0;

        // CRUD loop
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Tampilkan Semua Mahasiswa");
            System.out.println("3. Update IPK Mahasiswa");
            System.out.println("4. Hapus Mahasiswa");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi (1-5): ");
            int pilihan = inputTerminal.nextInt();
            inputTerminal.nextLine();

            switch (pilihan) {
                case 1:
                    // Tambah mahasiswa
                    System.out.print("Masukkan Nama: ");
                    String nama = inputTerminal.nextLine();
                    System.out.print("Masukkan NIM: ");
                    int NIM = inputTerminal.nextInt();
                    System.out.print("Masukkan IPK: ");
                    double IPK = inputTerminal.nextDouble();

                    mahasiswaList[count++] = new Mahasiswa(nama, NIM, IPK);
                    System.out.println("Mahasiswa berhasil ditambahkan.");
                    break;
                case 2:
                    // Tampilkan semua mahasiswa
                    System.out.println("Daftar Mahasiswa:");
                    if (count > 0) {
                        for (int i = 0; i < count; i++) {
                            mahasiswaList[i].tampilkanInfo();
                        }
                    } else {
                        System.out.println("Data mahasiswa tidak ada, silahkan tambahkan data terlebih dahulu!");
                    }
                    break;
                case 3:
                    // Update IPK mahasiswa
                    System.out.print("Masukkan NIM Mahasiswa yang akan diupdate: ");
                    int nimUpdate = inputTerminal.nextInt();
                    boolean nimUpdateDitemukan = false;

                    for (int i = 0; i < count; i++) {
                        if (mahasiswaList[i].NIM == nimUpdate) {
                            System.out.print("Masukkan IPK baru: ");
                            double ipkBaru = inputTerminal.nextDouble();
                            mahasiswaList[i].rubahIPK(ipkBaru);
                            System.out.println("IPK berhasil diupdate.");
                            nimUpdateDitemukan = true;
                            break;
                        }
                    }

                    if (!nimUpdateDitemukan) {
                        System.out.println("Mahasiswa dengan NIM tersebut tidak ditemukan.");
                    }
                    break;
                case 4:
                    // Hapus mahasiswa
                    System.out.print("Masukkan NIM Mahasiswa yang akan dihapus: ");
                    int nimHapus = inputTerminal.nextInt();
                    boolean nimHapusDitemukan = false;

                    for (int i = 0; i < count; i++) {
                        if (mahasiswaList[i].NIM == nimHapus) {
                            for (int j = i; j < count - 1; j++) {
                                mahasiswaList[j] = mahasiswaList[j + 1];
                            }
                            mahasiswaList[--count] = null;
                            System.out.println("Mahasiswa berhasil dihapus.");
                            nimHapusDitemukan = true;
                            break;
                        }
                    }

                    if (!nimHapusDitemukan) {
                        System.out.println("Mahasiswa dengan NIM tersebut tidak ditemukan.");
                    }
                    break;
                case 5:
                    // Keluar
                    System.out.println("Keluar dari program.");
                    return;
                default:
                    System.out.println("Opsi tidak ada. Silakan pilih 1-5!");
            }
        }
    }
}
