import java.util.*;


public class Main {
    static Logger logger = Logger.getInstance();

    public static void main(String[] args) {
        List<Integer> listInteger = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int enumList;
        int userMaxNumber;
        int userFirstNumber;
        int userMaxFilterNumber;

        logger.log("Запуск программы");
        try {
            while (true) {
                logger.log("Введите целое положительное число размера случайной последовательности");
                userFirstNumber = scanner.nextInt();
                if (userFirstNumber > 0) {
                    logger.log("Вы ввели число <" + userFirstNumber + "> такой длины будет последовательность");
                    break;
                } else {
                    checkData(userFirstNumber);
                }
            }

            while (true) {
                logger.log("Введите положительное максимальное желаемое допустимое значение в данной последовательности");
                userMaxNumber = scanner.nextInt();

                if (userMaxNumber > 0) {
                    logger.log("Вы ввели число <" + userMaxNumber + ">");
                    break;
                } else {
                    checkData(userMaxNumber);
                }
            }

            logger.log("Выполняется генерация списка");

            for (int i = 0; i < userFirstNumber; i++) {
                enumList = random.nextInt(userMaxNumber);
                if (enumList > 0) {
                    listInteger.add(enumList);
                } else i--;
            }

            List<String> listRandom = listInteger
                    .stream()
                    .map(Object::toString).toList();

            logger.log("Список по Вашим значениям: \n" + listRandom);
            logger.log("Проверка, размер списка: " + listRandom.size());

            while (true) {
                logger.log("Введите целое положительное число, меньше которого убрать значения (порог фильтрации)");
                userMaxFilterNumber = scanner.nextInt();
                if (userMaxFilterNumber > 0) {
                    logger.log("Вы ввели число <" + userMaxFilterNumber + ">");
                    break;
                } else {
                    checkData(userMaxFilterNumber);
                }
            }

            logger.log("Выполняется фильтрация списка");
            Filter filter = new Filter(userMaxFilterNumber);
            List<Integer> filtredList = filter.filterOut(listInteger);
            logger.log("Фильтрация списка выполнена");

            List<String> result = filtredList
                    .stream()
                    .map(Object::toString).toList();
            logger.log("Список сгенерирован");
            logger.log("Итоговый список: \n" + result);
            logger.log("Проверка, размер списка: " + result.size());
            logger.log("Работа программы завершена");

        } catch (InputMismatchException e) {
            logger.log("Вы ввели не число");
        }
    }


    public static boolean checkData(int number) {
        if (number == 0) {
            logger.log("Вы ввели ноль, прошу ввести положительное число");
        } else {
            logger.log("Вы ввели отрицательное число, прошу ввести положительное");
        }
        return false;
    }
}