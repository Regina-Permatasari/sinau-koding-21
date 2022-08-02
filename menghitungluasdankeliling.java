import java.util.Scanner;

public class menghitungluasdankeliling {

    static int menu = 100;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (menu <= 100) {
            System.out.println("Menghitung Luas dan Keliling Bangun Datar");
            System.out.println("------------------------------MENU-----------------------------------");
            System.out.println("1. Persegi Panjang");
            System.out.println("2. Persegi");
            System.out.println("3. Segitiga");
            System.out.println("4. Keluar");
            System.out.println("---------------------------------------------------------------------");
            System.out.print("Masukkan menu : ");
            menu = input.nextInt();
            // input.close();

            if (menu == 1) {
                persegiPanjang();
            } else if (menu == 2) {
                persegi();
            } else if (menu == 3) {
                segitiga();
            } else if (menu == 4) {
                System.exit(0);
            }
        }
    }

    // PERSEGI
    static void persegi() {
        Scanner input = new Scanner(System.in);

        System.out.println("Luas dan Keliling Persegi");
        System.out.println("------------------------------MENU-----------------------------------");
        System.out.println("1. Keliling");
        System.out.println("2. Luas");
        System.out.println("3. Keluar");
        System.out.println("---------------------------------------------------------------------");
        System.out.print("Masukkan pilihan : ");

        int pilihan = input.nextInt();
        // input.close();

        if (pilihan == 1) {
            System.out.println("Masukkan sisi :");
            double sisi = input.nextDouble();
            kelilingPersegi(sisi);
        } else if (pilihan == 2) {
            System.out.print("Masukkan sisi :");
            double sisi = input.nextDouble();
            luasPersegi(sisi);
        }
    }

    static void luasPersegi(double s) {
        Double luas = s * s;

        System.out.println("Luas persegi dengan sisi " + s + " adalah " + luas);
        System.out.println();
    }

    static void kelilingPersegi(double s) {
        Double keliling = s * 4;

        System.out.println("Keliling persegi dengan sisi " + s + " adalah " + keliling);
        System.out.println();
    }

    // PERSEGI PANJANG
    static void persegiPanjang() {
        Scanner input = new Scanner(System.in);

        System.out.println("Luas dan Keliling Persegi Panjang");
        System.out.println("------------------------------MENU-----------------------------------");
        System.out.println("1. Keliling");
        System.out.println("2. Luas");
        System.out.println("3. Keluar");
        System.out.println("---------------------------------------------------------------------");
        System.out.print("Masukkan pilihan : ");

        int pilihan = input.nextInt();
        // input.close();

        if (pilihan == 1) {
            System.out.println("Masukkan Panjang :");
            double panjang = input.nextDouble();
            System.out.println("Masukkan Lebar :");
            double lebar = input.nextDouble();
            kelilingpersegiPanjang(panjang, lebar);
        } else if (pilihan == 2) {
            System.out.println("Masukkan Panjang :");
            double panjang = input.nextDouble();
            System.out.println("Masukkan Lebar :");
            double lebar = input.nextDouble();
            luaspersegiPanjang(panjang, lebar);
        }
    }

    static void luaspersegiPanjang(double panjang, double lebar) {
        Double luas = panjang * lebar;

        System.out
                .println("Luas persegi panjang dengan panjang " + panjang + " dan lebar " + lebar + " adalah " + luas);
        System.out.println();
    }

    static void kelilingpersegiPanjang(double panjang, double lebar) {
        Double keliling = 2 * (panjang + lebar);

        System.out.println(
                "Keliling persegi panjang dengan panjang " + panjang + " dan lebar " + lebar + " adalah " + keliling);
        System.out.println();
    }

    // SEGITIGA
    static void segitiga() {
        Scanner input = new Scanner(System.in);

        System.out.println("Luas dan Keliling Segitiga");
        System.out.println("------------------------------MENU-----------------------------------");
        System.out.println("1. Keliling");
        System.out.println("2. Luas");
        System.out.println("3. Keluar");
        System.out.println("---------------------------------------------------------------------");
        System.out.print("Masukkan pilihan : ");

        int pilihan = input.nextInt();
        // input.close();

        if (pilihan == 1) {
            System.out.println("Masukkan sisi a :");
            double a = input.nextDouble();
            System.out.println("Masukkan sisi b :");
            double b = input.nextDouble();
            System.out.println("Masukkan sisi c :");
            double c = input.nextDouble();
            kelilingSegitiga(a, b, c);
        } else if (pilihan == 2) {
            System.out.println("Masukkan Alas :");
            double alas = input.nextDouble();
            System.out.println("Masukkan Tinggi :");
            double tinggi = input.nextDouble();
            luasSegitiga(alas, tinggi);
        }
    }

    static void luasSegitiga(double alas, double tinggi) {
        Double luas = 0.5 * alas * tinggi;

        System.out.println("Luas segitiga dengan alas " + alas + " dan tinggi " + tinggi + " adalah " + luas);
        System.out.println();
    }

    static void kelilingSegitiga(double a, double b, double c) {
        Double keliling = a + b + c;

        System.out.println(
                "Keliling segitiga dengan sisi A " + a + " sisi b " + b + " sisi c " + c + " adalah " + keliling);
        System.out.println();
    }
}
