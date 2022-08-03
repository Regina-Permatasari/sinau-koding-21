public class Main implements MainInterface {
    private double sisi;

    public static void main(String[] args) {
        Main main = new Main();
        main.sisi = 20;
        
        main.keliling();
        main.luas();
    }

    @Override
    public void keliling() {
        double keliling = sisi * 4;

        System.out.println("Keliling persegi dengan sisi = " + sisi + " cm adalah " + keliling);
    }

    @Override
    public void luas() {
        double luas = sisi * sisi;
        
        System.out.println("Luas persegi dengan sisi = " + sisi + " cm adalah " + luas);
        
    }
}
