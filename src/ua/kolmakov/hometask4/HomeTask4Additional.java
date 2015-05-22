package ua.kolmakov.hometask4;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Kolmakov Alexey on 21.05.2015.
 * <p>
 * HomeTask4Additional
 */
public class HomeTask4Additional {

    public static void main(String[] args) {
//1) Задан одномерный массив X[M+N]. Сформировать двумерный массив A[M][N],элементы которого вычисляются по следующим правилам:
//- элементы с четной суммой индексов массива А:
//- элементы с нечетной суммой индексов массива А:
// сумма индексов 0+0 считается четной.
/*непонятно задание 1) ?*/

// 2) Создать двумерный массив из 6 строк по 7 столбцов в каждой из случайных целых чисел из отрезка [0;9]. Вывести массив на экран.
// Преобразовать массив таким образом, чтобы на первом месте в каждой строке стоял её наибольший элемент.
// При этом изменять состав массива нельзя, а можно только переставлять элементы в рамках одной строки
// Порядок остальных элементов строки не важен (т.е. можно соврешить только одну перестановку, а можно отсортировать по убыванию каждую строку). Вывести преобразованный массив на экран.
        System.out.println("2)");
        int array[][] = new int[6][7];
        array = fillInValues(array, 0, 9);
        System.out.println("исходный массив: "/* + Arrays.deepToString(array)*/);
        printAllElements(array);
        int[][] modifiedArray = moveMaxElementPerSubArrayToFirstPosition(array);
        System.out.println("модифицированный массив: " /*+ Arrays.deepToString(array)*/);
        printAllElements(modifiedArray);

// 2a) Для проверки остаточных знаний учеников после летних каникул, учитель младших классов решил начинать каждый урок с того, чтобы задавать каждому ученику пример из таблицы умножения,
// но в классе 15 человек, а примеры среди них не должны повторяться. В помощь учителю напишите программу, которая будет выводить на экран 15 случайных примеров из таблицы умножения
// (от 2*2 до 9*9, потому что задания по умножению на 1 и на 10 — слишком просты). При этом среди 15 примеров не должно быть повторяющихся (примеры 2*3 и 3*2 и им подобные пары считать повторяющимися).
        System.out.println("2а) (таблица умножения)");
        int x, y;
        Random rnd = new Random();
        // Stores "true" in the combinations[x][y] if "x * y" was already use
        boolean[][] combinations = new boolean[10][10];
        for (int i = 0; i < 15; i++) {
            x = rnd.nextInt(8) + 2;
            y = rnd.nextInt(8) + 2;
            if (isUniqueCombination(x, y, combinations)) {
                System.out.println("(" + x + " * " + y + ") ");
            } else i--;
        }
        System.out.println();

// 3) Имеется массив String[] a, в котором хранятся числа. Требуется преобразовать его в двумерный массив int[][] c, потом найдите сумму каждой цифры этих чисел.
        /*непонятно задание 3) ?*/

// 4) Создать двумерный массив из 8 строк по 5 столбцов в каждой из случайных целых чисел из отрезка [10;99].
// Вывести массив на экран только четные строки и столбцы (включая первыую строку и столбец) (сделать несколько способов вывода).
        System.out.println("4)");
        array = new int[8][5];
        array = fillInValues(array, 10, 99);
        printAllElements(array);
        printEvenElements(array);
        printEvenElements2(array);

// 5) Есть массив, заполненниы слцчайными числами до 100. Вывести количество значений в жиапазонах: 10-20, 30-40, 40-50.


// 6) Загадуем число от 0 до 100. У вас есть семь попыток на угадывание.
// При каждой попытке будет выводиться сообщение - "Мало" или "Много". Если угадаете, уложившись в семь попыток, то выиграли.
// Если нет, Выводим сообщение и снова загадываем и повторяем все снова
// Для генерации секретного числа и чтения с консоли используете код:
//        Random r = new Random();
//        int secret = r.nextInt(100) + 1;
//        int i = System.in.read();

        Game game = new Game();
        game.start();
    }

    private static int[][] fillInValues(int[][] array, int minValue, int maxValue) {

        Random rnd = new Random();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = rnd.nextInt(maxValue - minValue + 1) + minValue;
            }
        }
        return array;
    }

    private static int[][] moveMaxElementPerSubArrayToFirstPosition(int[][] array) {
        for (int sub[] : array) {
            sub = maxElementFirst(sub);
        }
        return array;
    }

    private static int[] maxElementFirst(int[] sub) {
        int indexOfMax = 0;
        for (int i = 1; i < sub.length; i++) {
            if (sub[i] > sub[indexOfMax]) {
                indexOfMax = i;
            }
        }
        if (indexOfMax != 0) {
            int tmp = sub[indexOfMax];
            sub[indexOfMax] = sub[0];
            sub[0] = tmp;
        }
        return sub;
    }

    private static boolean isUniqueCombination(int x, int y, boolean[][] combinations) {
        if (combinations[x][y] || combinations[y][x])
            return false;
        combinations[x][y] = true;
        return true;
    }

    private static void printAllElements(int[][] array) {
        System.out.println("Все элементы массива: ");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void printEvenElements(int[][] array) {
        System.out.println("Элементы массива с четными индексами: ");
        for (int i = 0; i < array.length; i += 2) {
            for (int j = 0; j < array[i].length; j += 2) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void printEvenElements2(int[][] array) {
        System.out.println("Элементы массива с четными индексами версия 2: ");
        boolean isEvenLine = true;
        boolean isEvenColumn = true;
        for (int subArray[] : array) {
            if (isEvenLine) {
                for (int element : subArray) {
                    if (isEvenColumn) {
                        System.out.print(element + " ");
                    }
                    isEvenColumn = !isEvenColumn;
                }
                System.out.println();
            }
            isEvenLine = !isEvenLine;
            isEvenColumn = true;
        }
    }

    /*********************************************************************/


}

class Game {
    private static Random rnd = new Random();
    private byte retryCounter;
    private int secret;
    private int variant;
    private boolean isValidVariant;

    Game() {
        retryCounter = 7;
        System.out.println(" Угадай число с 7-ми попыток  ");
    }


    public void start() {
        secret = rnd.nextInt(100) + 1;
        System.out.println(" Введите число от 1 до 100;    secret = " + secret);
        while (retryCounter > 0) {
            isValidVariant = true;
            retryCounter--;
            variant = inputNumber();
            if (isValidVariant) {
                checkAnswer();
            }
        }
        end();
    }

    private int inputNumber() {
        Scanner scanner = new Scanner(System.in);
        int number;
        if (scanner.hasNextInt()) {
            number = scanner.nextInt();
            if (number < 1 || number > 100) {
                isValidVariant = false;
                System.out.print("Введено неверное значение. ");
                System.out.println("Осталось " + retryCounter + " попыток");
                return 0;
            } else {
                return number;
            }
        }
        System.out.print("Введено неверное значение. ");
        System.out.println("Осталось " + retryCounter + " попыток");
        isValidVariant = false;
        return 0;
    }

    private void checkAnswer() {
        if (variant == secret) {
            System.out.println("Молодец, угадал!");
            retryCounter = 0;
        } else if (variant > secret) {
            System.out.print("Ваше число больше. ");
            System.out.println("Осталось " + retryCounter + " попыток");

        } else if (variant < secret) {
            System.out.print("Ваше число меньше. ");
            System.out.println("Осталось " + retryCounter + " попыток");
        }
    }

    private void end() {
        System.out.println("Игра окончена!");
        retryCounter = 0;
    }
}