import java.util.Scanner;

public class CekPasswordKuat {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("===============================================");
        System.out.println("Selamat Datang di program Cek Kekuatan Password");
        System.out.println("===============================================");
        System.out.print("Masukkan password: ");
        String password = input.nextLine();

        if (passwordKuat(password)) {
            System.out.println("Password sudah kuat.");
        } else {
            System.out.println("Password masih lemah, silahkan tambahkan karakter lain minimal 8 karakter yang mengandung huruf besar, huruf kecil, angka, dan simbol.");
        }
    }

    private static boolean passwordKuat(String password) {
        if (password.length() < 8) {
            return false;
        }

        boolean mengandungUpperCase = false;
        boolean mengandungLowerCase = false;
        boolean mengandungDigit = false;
        boolean mengandungSimbol = false;

        // pakai perulangan untuk memeriksa setiap karakter dalam password
        for (int i = 0; i < password.length(); i++) {
            char karakter = password.charAt(i);
            if (Character.isUpperCase(karakter)) {
                mengandungUpperCase = true;
            } else if (Character.isLowerCase(karakter)) {
                mengandungLowerCase = true;
            } else if (Character.isDigit(karakter)) {
                mengandungDigit = true;
            } else {
                mengandungSimbol = true;
            }
        }

        return mengandungUpperCase && mengandungLowerCase && mengandungDigit && mengandungSimbol;
    }
}
