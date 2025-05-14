import java.util.Scanner;

public class Main {

    public static void zadanie_4(){
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Введите первое число: ");
            double num1 = scanner.nextDouble();

            System.out.print("Введите оператор (+, -, *, /, %): ");
            String operator = scanner.next();

            System.out.print("Введите второе число: ");
            double num2 = scanner.nextDouble();

            Double result = null;

            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 == 0) {
                        System.out.println("Ошибка: Деление на ноль!");
                        return;
                    }
                    result = num1 / num2;
                    break;
                case "%":
                    if (num2 == 0) {
                        System.out.println("Ошибка: Деление на ноль!");
                        return;
                    }
                    result = num1 % num2;
                    break;
                default:
                    System.out.println("Ошибка: Некорректный оператор!");
                    return;
            }

            System.out.println("Результат: " + (result != null ? result : "Ошибка вычисления"));


            boolean isPositive = (result != null) && (result > 0);
            System.out.println("Результат положительный? " + isPositive);


        } catch (Exception e) {
            System.out.println("Ошибка: Некорректный ввод числа!");
        } finally {
            scanner.close();
        }
    }


    public static void zadanie_3(){
        int count = 0;
        System.out.println("Введите слово: ");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String vowels = "aeiouyAEIOUY"; // Строка со всеми гласными (в верхнем и нижнем регистре)

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (vowels.indexOf(ch) != -1) { // Проверяем, есть ли символ в строке гласных
                count++;
            }
        }
        System.out.println("Слово: " + str);
        System.out.println("Гласных букв: " + count);
    }


    public static void zadanie_2(){
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }



    public static void zadanie_1(){
        int age = 21;
        float avg_score = 4.5F;
        String name = "Максим";
        boolean status = true;
        System.out.println(
                "Имя: " + name + " " + String.valueOf(name).getClass().getSimpleName() + "\n" +
                        "Возраст: " + age + " " + Integer.valueOf(age).getClass().getSimpleName() + "\n" +
                        "Средний балл: " + avg_score + " " + Float.valueOf(avg_score).getClass().getSimpleName() + "\n" +
                        "Студент: " + status + " " + Boolean.valueOf(status).getClass().getSimpleName()
        );
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println(
                "1. Задание №1 \n" +
                "2. Задание №2 \n" +
                "3. Задание №3 \n" +
                "4. Задание №4 \n" +
                "5. Задание №5 \n"
        );
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                zadanie_1();
                break;
            case 2:
                zadanie_2();
                break;
            case 3:
                zadanie_3();
                break;
            case 4:
                zadanie_4();
                break;
            case 5:
                matrix.matrixx();
                break;
        }
    }

}