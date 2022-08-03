public class Segitiga extends MainAbstract {
    static Double alas, tinggi, a, b, c;

    public static void main(String[] args) {
        Segitiga segitiga = new Segitiga();
        segitiga.a = 6.00;
        segitiga.b = 8.00;
        segitiga.c = 10.00;
        segitiga.alas = 20.00;
        segitiga.tinggi = 10.00;

        double keliling = a + b + c;
        segitiga.keliling(keliling);

        double luas = 0.5 * alas * tinggi;
        segitiga.luas(luas);
    }

    @Override
    void keliling(double k) {
        super.keliling(k);
    }

    @Override
    void luas(double l) {
        System.out.println("Luas segitiga dengan alas = " + alas + " cm dan tinggi = " + tinggi + " cm adalah " + l);
    }
}