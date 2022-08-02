import java.util.Scanner;

public class bilanganprima {
    public static void main(String[] args) {
        //inisialisasi modul
        Scanner input = new Scanner(System.in);

        // main menu
        System.out.print("Enter number :");
        int numbers = input.nextInt();

        input.close();

        for (int i = 0; i <= numbers; i++){
            checkbilanganprima(i);
        }
        System.exit(0);
        
    }

    public static void checkbilanganprima(int n) {
        int i, flag = 0;
        for (i = 2; i <= n / 2 ; ++i) {
            if (n % i == 0) {
                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            System.out.println(n+" Bilangan Prima");
        } else {
            System.out.println(n+" Bukan Bilangan Prima");
        }
    }

}