public class PersegiPanjang extends MainAbstract {
    static Double panjang, lebar;

    public static void main(String[] args) {
        PersegiPanjang persegiPanjang = new PersegiPanjang();
        persegiPanjang.lebar = 10.00;
        persegiPanjang.panjang = 15.00;

        double keliling = 2 * (panjang + lebar);
        persegiPanjang.keliling(keliling);

        double luas = panjang * lebar;
        persegiPanjang.luas(luas);
    }

    @Override
    void keliling(double k) {
        super.keliling(k);
    }

    @Override
    void luas(double l) {
        System.out.println("Luas persegi panjang dengan panjang = " + panjang + " cm dan lebar = " + lebar + " cm adalah " + l);
    }
}