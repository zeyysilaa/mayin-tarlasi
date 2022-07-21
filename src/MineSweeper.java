import java.util.Scanner;

public class MineSweeper {
    int sütun, satır;
    boolean isPatladi = false;
    boolean isWin = false;

    MineSweeper(int sütun, int satır) {
        this.sütun = sütun;
        this.satır = satır;

    }

    public void Tarama(String[][] mayin, String[][] tarla, int a, int b) {
        int count = 0;
        if ((b - 1 >= 0) && (mayin[a][b - 1]).equals("*")) {
            count++;
        }
        if ((b + 1 < mayin[0].length) && (mayin[a][b + 1]).equals("*")) {
            count++;
        }
        if ((a - 1 >= 0) && (mayin[a - 1][b]).equals("*")) {
            count++;
        }
        if ((a - 1 >= 0) && (b + 1 < mayin[0].length) && (mayin[a - 1][b + 1]).equals("*")) {
            count++;
        }
        if ((a - 1 >= 0) && (b - 1 >= 0) && (mayin[a - 1][b - 1]).equals("*")) {
            count++;
        }
        if ((a + 1 < mayin[0].length) && (mayin[a + 1][b]).equals("*")) {
            count++;
        }

        if ((a + 1 < mayin[0].length) && (b + 1 < mayin[0].length) && (mayin[a + 1][b + 1]).equals("*")) {
            count++;
        }
        if ((a + 1 < mayin[0].length) && (b - 1 >= 0) && (mayin[a + 1][b - 1]).equals("*")) {
            count++;
        }
        if ((mayin[a][b]).equals("*")) {
            isPatladi = true;
        }

        mayin[a][b] = Integer.toString(count);
        Esitleme(mayin, tarla, a, b);
    }

    public void Esitleme(String[][] tara, String[][] tarla, int a, int b) {
        tarla[a][b] = tara[a][b];
    }

    public void Print(String[][] print) {
        for (int i = 0; i < satır; i++) {
            for (int j = 0; j < sütun; j++) {
                System.out.print(print[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public void run() {
        Scanner input = new Scanner(System.in);
        int mayinsayisi = (satır * sütun) / 4;
        String tarla[][] = new String[satır][sütun];
        String mayin[][] = new String[satır][sütun];
        for (int i = 0; i < satır; i++) {
            for (int j = 0; j < sütun; j++) {
                tarla[i][j] = "-";
            }
        }
        for (int i = 0; i < satır; i++) {
            for (int j = 0; j < sütun; j++) {
                mayin[i][j] = "-";
            }
        }
        for (int i = 0; i < mayinsayisi; i++) {
            mayin[(int) (Math.random()) * satır][(int) (Math.random() * sütun)] = "*";
        }
        int count = 0;
        while (!isPatladi) {
            count++;
            Print(tarla);
            System.out.println("Satir giriniz : \nSutun giriniz : ");
            int secilensatır = input.nextInt() - 1;
            int secilensütun = input.nextInt() - 1;
            Tarama(mayin, tarla, secilensatır, secilensütun);
            if (isPatladi) {
                tarla[secilensatır][secilensütun] = "X";
                System.out.println("!!OYUN BITTI!!");
                Print(tarla);
                break;
            }
            if ((satır * sütun) - mayinsayisi == count) {
                System.out.println("!!TEBRIKLER, KAZANDINIZ!!");
                Print(tarla);
                break;
            }
            System.out.println("=============================================================");
        }
        Print(mayin);

    }

}
