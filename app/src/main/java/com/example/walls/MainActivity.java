package com.example.walls;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Scanner;

import static java.lang.Thread.sleep;
import static java.util.concurrent.TimeUnit.SECONDS;

public class MainActivity extends AppCompatActivity {
    public static int[][] pole = new int[9][9];
    public static int x2 = 4, y2 = 4, wall = 1, hode = 1;
    public static boolean t = false, time = false;
    public static Scanner sc = new Scanner(System.in);


    public void out() {
        String str = "";
        TextView all = findViewById(R.id.all);
        for (int i = 0; i < pole.length; i++) {
            for (int j = 0; j < pole.length; j++) {
                str += pole[j][i] + "     ";
            }
            str += "\n";
        }
        all.setText(str);
    }

    public void pl1_hode(int n) {
        boolean t = false;
        TextView help = findViewById(R.id.help);

        while (t == false) {
            if (n == 1 && (pole[x2][y2 - 1]) == 0) {//вверх
                pole[x2][y2] = 0;
                y2 = y2 - 1;
                pole[x2][y2] = 2;
                t = true;
                hode = 2;
            }

            if (n == 2 && (pole[x2 + 1][y2]) == 0) {//вправо
                pole[x2][y2] = 0;
                x2 = x2 + 1;
                pole[x2][y2] = 2;
                t = true;
                hode = 2;
            }

            if (n == 3 && (pole[x2][y2 + 1]) == 0) {//вниз
                pole[x2][y2] = 0;
                y2 = y2 + 1;
                pole[x2][y2] = 2;
                t = true;
                hode = 2;
            }

            if (n == 4 && (pole[x2 - 1][y2]) == 0) {//влево
                pole[x2][y2] = 0;
                x2 = x2 - 1;
                pole[x2][y2] = 2;
                t = true;
                hode = 2;
            }
            if (n == 9) {
                pole[99][99] = 2;
                t = true;
            }
            if (t == false) {
                help.setText("Стенка\nВыберите другое направление");
                hode = 1;
                return;
            }
        }

    }

    public void pl2_hode(int x1, int y1) {
        TextView help = findViewById(R.id.help);
        if (pole[x1][y1] == 1 || pole[x1][y1] == 2) {
            help.setText("Вы не можете сюда походить, введите координаты повторно");

            hode = 2;
            return;
        } else {
            pole[x1][y1] = 1;
            hode = 1;
        }

    }

    public void clean() {
        for (int i = 0; i < pole.length; i++) {
            for (int j = 0; j < pole.length; j++) {
                if (pole[j][i] != 1 && pole[j][i] != 2) {
                    pole[j][i] = 0;
                }
            }
        }
    }

    public void cikl() {
        for (int i = 0; i < pole.length; i++) {
            for (int j = 0; j < pole.length; j++) {
                if (pole[j][i] == 1) {
                    zap(j, i);
                }
            }
        }
    }

    public void zap(int x, int y) {
        int x1 = x, y1 = y;
        try {
            while (pole[x][y - 1] != 1) {
                if (pole[x][y - 1] == 2) {
                    y = y - 1;
                }
                y = y - 1;
                if (pole[x][y] != 1) {
                    pole[x][y] = pole[x][y] + 3;
                }
            }
        } catch (Exception e) {
        }
        x = x1;
        y = y1;
        try {
            while (pole[x][y + 1] != 1) {
                if (pole[x][y + 1] == 2) {
                    y = y + 1;
                }
                y = y + 1;
                if (pole[x][y] != 1) {
                    pole[x][y] = pole[x][y] + 3;
                }


            }
        } catch (Exception e) {
        }
        x = x1;
        y = y1;
        try {
            while (pole[x - 1][y] != 1) {
                if (pole[x - 1][y] == 2) {
                    x = x - 1;
                }
                x = x - 1;
                if (pole[x][y] != 1) {
                    pole[x][y] = pole[x][y] + 3;
                }
            }
        } catch (Exception e) {
        }
        x = x1;
        y = y1;
        try {
            while (pole[x + 1][y] != 1) {
                if (pole[x + 1][y] == 2) {
                    x = x + 1;
                }
                x = x + 1;
                if (pole[x][y] != 1) {
                    pole[x][y] = pole[x][y] + 3;
                }
            }
        } catch (Exception e) {
        }

    }

    public void proverka(int x, int y) {
        Button button = findViewById(R.id.button);
        int x1 = x, y1 = y;
        TextView help = findViewById(R.id.help);
        boolean t = true;
        try {
            while (pole[x][y - 1] != 1) {
                y = y - 1;
                if (pole[x][y] != 12 || pole[x][y] == 1) {
                    t = false;
                }
            }
        } catch (Exception e) {
        }
        x = x1;
        y = y1;
        try {
            while (pole[x][y + 1] != 1) {
                y = y + 1;
                if (pole[x][y] != 12 || pole[x][y] == 1) {
                    t = false;
                }
            }
        } catch (Exception e) {
        }
        x = x1;
        y = y1;
        try {
            while (pole[x - 1][y] != 1) {
                x = x - 1;
                if (pole[x][y] != 12 || pole[x][y] == 1) {
                    t = false;
                }
            }
        } catch (Exception e) {
        }
        x = x1;
        y = y1;
        try {
            while (pole[x + 1][y] != 1) {
                x = x + 1;
                if (pole[x][y] != 12 || pole[x][y] == 1) {
                    t = false;
                }
            }
        } catch (Exception e) {
        }


        if (t == true) {
            hode = 4;
            help.setText("Кот в клетке");
            button.setText("Заново?");
        }
    }

    public void find12() {
        for (int i = 0; i < pole.length; i++) {
            for (int j = 0; j < pole.length; j++) {
                if (pole[j][i] == 12) {
                    rec(j, i);


                }
            }
        }
    }

    public void rec(int x, int y) {
        if (pole[x + 1][y] != 12 && pole[x + 1][y] != 1 && pole[x + 1][y] != 2) {
            pole[x][y] = 0;
        }
        if (pole[x][y + 1] != 12 && pole[x][y + 1] != 1 && pole[x][y + 1] != 2) {
            pole[x][y] = 0;
        }
        if (pole[x - 1][y] != 12 && pole[x - 1][y] != 1 && pole[x - 1][y] != 2) {
            pole[x][y] = 0;
        }
        if (pole[x][y - 1] != 12 && pole[x][y - 1] != 1 && pole[x][y - 1] != 2) {
            pole[x][y] = 0;
        }


        if (pole[x][y - 1] == 12 && pole[x][y] == 0) {
            rec(x, y - 1);
        }
        if (pole[x][y + 1] == 12 && pole[x][y] == 0) {
            rec(x, y + 1);
        }
        if (pole[x + 1][y] == 12 && pole[x][y] == 0) {
            rec(x + 1, y);
        }
        if (pole[x - 1][y] == 12 && pole[x][y] == 0) {
            rec(x - 1, y);
        }


    }

    public void over() {
        for (int i = 0; i < pole.length; i++) {
            for (int j = 0; j < pole.length; j++) {
                pole[j][i] = 0;
            }
        }
        x2 = 4;
        y2 = 4;
        hode = 1;
        pole[x2][y2] = 2;
    }

    public int get_x(String s) {
        int x;
        x = Integer.parseInt(String.valueOf(s.charAt(0)));
        return x;
    }

    public int get_y(String s) {
        int y;
        y = Integer.parseInt(String.valueOf(s.charAt(2)));
        return y;
    }

    public void but(View view) {
        int x, y;
        TextView help = findViewById(R.id.help);
        TextView all = findViewById(R.id.all);
        EditText vvod = findViewById(R.id.vvod);
        Button button = findViewById(R.id.button);
        if (hode == 3) {
            button.setText("Ввести");
            help.setText("Ход кота\nВыберите направление");
            over();
            return;
        }
        if (hode == 5) {
            button.setText("Ввести");
            help.setText("Ход кота\nВыберите направление");
            hode = 1;
            onResume();
        }
        if (hode == 4) {
            button.setText("Ввести");
            help.setText("Ход кота\nВыберите направление");
            over();
            return;
        }
        try {
            if (hode == 2) {
                x = get_x(vvod.getText().toString());
                y = get_y(vvod.getText().toString());
                pl2_hode(x, y);
                cikl();
                find12();
                proverka(x2, y2);
                clean();
                out();
                onResume();
                return;
            }
            if (hode == 1) {
                pl1_hode(Integer.parseInt(String.copyValueOf(new char[]{(vvod.getText().toString()).charAt(0)})));
                out();
                onResume();
                return;
            }
        } catch (IndexOutOfBoundsException e) {
            help.setText("Кот сбежал");
            hode = 3;
            button.setText("Заново?");
        }


        time = true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        boolean t1 = false;
        pole[x2][y2] = 2;


        TextView help = findViewById(R.id.help);
        TextView all = findViewById(R.id.all);
        EditText vvod = findViewById(R.id.vvod);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        out();


    }


    public void onResume() {
        super.onResume();
        TextView help = findViewById(R.id.help);
        TextView all = findViewById(R.id.all);

        boolean t1 = false;
        if (hode == 1) {
            help.setText("Ход кота\nВыберите направление");
        }
        if (hode == 2) {
            help.setText("Ход стенки\nВыберите координату");
        }
    }

    public void c() {
        TextView help = findViewById(R.id.help);
        TextView all = findViewById(R.id.all);
        help.setText("Ход кота\nВыберите направление");
    }


}