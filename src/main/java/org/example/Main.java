package org.example;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("1 задание:");
        Button button1 = new Button();
        Button button2 = new Button();
        button1.click();
        button1.click();
        button1.click();
        button2.click();
        button2.click();

        System.out.println("\n2 задание:");
        Balance balance = new Balance();
        int right = balance.add_right();
        int left = balance.add_left();
        balance.result(right, left);

        System.out.println("\n3 задание:");
        Bell bell = new Bell();
        bell.sound();
        bell.sound();
        bell.sound();
        System.out.println(); // add a newline character

        System.out.println("\n4 задание:");
        OddEvenSeparator separator = new OddEvenSeparator();
        separator.addNumber(1);
        separator.addNumber(2);
        separator.addNumber(3);
        separator.addNumber(4);
        separator.addNumber(5);
        separator.even();
        separator.odd();

        System.out.println("\n5 задание:");
        Table table = new Table(3, 3);
        table.set_value(0, 0, 1);
        table.set_value(0, 1, 2);
        table.set_value(0, 2, 3);
        table.set_value(1, 0, 4);
        table.set_value(1, 1, 5);
        table.set_value(1, 2, 6);
        table.set_value(2, 0, 7);
        table.set_value(2, 1, 8);
        table.set_value(2, 2, 9);
        table.print();
        System.out.println("Average: " + table.average());
    }
}

class Button {
    private int count = 0;
    public void click() {
        count++;
        System.out.println(count);
    }
}

class Balance{
    Scanner scanner = new Scanner(System.in);
    public int add_right(){
        System.out.print("R = ");
        return scanner.nextInt();
    }
    public int add_left(){
        System.out.print("L = ");
        return scanner.nextInt();
    }
    public void result(int r,int l){
        if (l==r){
            System.out.println("=");
        }else if (l>r){
            System.out.println("L");
        }else{
            System.out.println("R");
        }
    }
}
class Bell{
    public void sound(){
        System.out.print("ding dong ");
    }
}
class OddEvenSeparator {
    private ArrayList<Integer> evenNumbers;
    private ArrayList<Integer> oddNumbers;

    public OddEvenSeparator() {
        evenNumbers = new ArrayList<>();
        oddNumbers = new ArrayList<>();
    }

    public void addNumber(int number) {
        if (number % 2 == 0) {
            evenNumbers.add(number);
        } else {
            oddNumbers.add(number);
        }
    }

    public void even() {
        System.out.println("Чётные числа:");
        for (int number : evenNumbers) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

    public void odd() {
        System.out.println("Нечётные числа:");
        for (int number : oddNumbers) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
}
class Table {
    public int rows=10;
    public int cols=10;
    public int n_rows() {
        return this.rows;
    }
    public int n_cols() {
        return this.cols;
    }
    int[][]Tab=new int[rows][cols];
    public Table(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
    }
    public void set_value(int row, int col, int value) {
        Tab[row][col]=value;
    }
    public int get_value(int row, int col) {
        return Tab[row][col];
    }
    public void print() {
        for (int i = 0; i < (n_cols()); ++i) {
            for (int j = 0; j < (n_rows()); ++j) {
                System.out.print(get_value(i,j));
            }
            System.out.println();
        }
    }
    public float average() {
        float res=0;
        for (int i = 0; i < (n_cols()); ++i) {
            for (int j = 0; j < (n_rows()); ++j) {
                res=res+Tab[i][j];
            }
        }return res/((n_cols())*(n_rows()));
    }
}