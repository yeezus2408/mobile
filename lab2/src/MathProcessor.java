import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

public class MathProcessor {
    private List<Double> numbers;

    public MathProcessor(List<Double> numbers) {
        this.numbers = numbers;
    }

    public List<Double> process(Function<Double, Double> handler) {
        List<Double> result = new ArrayList<>();
        for (double number : numbers) {
            result.add(handler.apply(number));
        }
        return result;
    }

    public static List<Double> getRandomNumbers(int count, double min, double max) {
        List<Double> randomNumbers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            double randomNumber = min + (max - min) * random.nextDouble();
            randomNumbers.add(randomNumber);
        }
        return randomNumbers;
    }

    public static void main(String[] args) {
        List<Double> numbers = MathProcessor.getRandomNumbers(5, 1.0, 10.0);
        System.out.println("Исходные числа: " + numbers);

        MathProcessor processor = new MathProcessor(numbers);

        List<Double> squaredNumbers = processor.process(x -> x * x);
        System.out.println("Числа в квадрате: " + squaredNumbers);

        List<Double> squareRootNumbers = processor.process(Math::sqrt);
        System.out.println("Квадратные корни чисел: " + squareRootNumbers);

        List<Double> incrementedNumbers = processor.process(x -> x + 5);
        System.out.println("Числа, увеличенные на 5: " + incrementedNumbers);
    }
}
