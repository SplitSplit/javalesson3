package ru.ponomaryov.se;

import java.util.Scanner;

/**
 * @author Oleg Ponomaryov
 * @version 1.0.0
 */

public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        playGuessNumder();
        playGuessWord();
    }

    private static void playGuessNumder() {
        int gNumber;
        int enteredNumber = 1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Игра угадай число (число от 0 до 9)");
        while (enteredNumber == 1) {
            gNumber = (int) (Math.random() * 9.0);
            for (int i = 0; i < 3; i++) {
                System.out.print("Введите число: ");
                enteredNumber = sc.nextInt();
                if (enteredNumber > gNumber) {
                    System.out.println("Ваше число больше загаданного");
                } else if (enteredNumber < gNumber) {
                    System.out.println("Ваше число меньше загаданного");
                } else if (enteredNumber == gNumber) {
                    System.out.println("Вы угадали число");
                    break;
                }
            }
            if(enteredNumber != gNumber) {
                System.out.println("Вы проиграли. Загаданно число: " + gNumber);
            }
            System.out.print("Повторить игру еще раз? (1 - да/0 - нет)");
            enteredNumber = sc.nextInt();
        }
    }

    private static void playGuessWord() {
        final String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        int gWord;
        Scanner sc = new Scanner(System.in);
        String enteredWord;
        Character[] printWord = new Character[15];

        for(int a=0; a<15; a++) {
            printWord[a] = '#';
        }
        System.out.println("Игра \"Угадай слово\" (для выхода введите \"exit\")");
        gWord = (int) (Math.random() * 24.0);
        while(true) {
            System.out.print("Введите слово: ");
            enteredWord = sc.nextLine();
            if(enteredWord.equals("exit")) {
                break;
            }
            for(int i=0; i<enteredWord.length() && i < 15; i++) {
                if(words[gWord].length() > i) {
                    if(enteredWord.charAt(i) == words[gWord].charAt(i) && printWord[i] == '#') {
                        printWord[i] = enteredWord.charAt(i);
                    }
                }
            }
            boolean equalFlag = true;
            for(int a=0; a<words[gWord].length(); a++) {
                if(printWord[a] != words[gWord].charAt(a)) {
                    equalFlag = false;
                }
            }
            if(equalFlag) {
                System.out.println("Вы угадали слово \"" + words[gWord] + "\"");
                System.out.println("Загадано новое слово");
                gWord = (int) (Math.random() * 24.0);
                for(int b=0;b<15; b++) {
                    printWord[b] = '#';
                }
            } else {
                for(int b=0;b<15; b++) {
                    System.out.print(printWord[b]);
                }
                System.out.println();
            }
        }
    }
}
