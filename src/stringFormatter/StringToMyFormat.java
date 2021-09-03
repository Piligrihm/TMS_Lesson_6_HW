package stringFormatter;

import com.tms.exception.ContainSequanceAtEndException;
import com.tms.exception.ContainSequanceAtStartException;
import com.tms.exception.ContainSequanceException;

public class StringToMyFormat {

    /**
     * Метод выводит заданное кол-во "первых" 4-х значных числовых блоков в одной строке
     *
     * @param str    - принимаемая на вход строка
     * @param number - максимальное кол-во блоков для вывода
     * @return - возвращает строку
     */
    public static void twoFirstNumericBlocks(String str, int number) {
        String result = "";
        if (isValid(str)) {
            String[] wordsArray = str.split("-");
            for (int i = 0, j = 0; i < wordsArray.length; i++) {
                if (isNumeric(wordsArray[i]) && wordsArray[i].length() == 4) {
                    if (j < number) {
                        result += wordsArray[i];
                    }
                    j++;
                }
            }
        }
        System.out.println(result);
    }

    /**
     * Метод предназначен для замены символов в не числовых блоках на другие
     *
     * @param str       - принимаемая на вход строка
     * @param character - символ, на который будут заменены все элементы блока
     * @param blockSize - размер блока
     * @return - возвращает строку
     */
    public static void threeCharBlocksReplace(String str, char character, int blockSize) {
        String result = "";
        if (isValid(str)) {
            String[] wordsArray = str.split("-");
            for (int i = 0; i < wordsArray.length; i++) {
                if (!isNumeric(wordsArray[i]) && wordsArray[i].length() == blockSize) {
                    wordsArray[i] = changeChar(wordsArray[i], character);
                }
                if (i != wordsArray.length - 1) {
                    result += wordsArray[i] + "-";
                } else {
                    result += wordsArray[i];
                }
            }
        }
        System.out.println(result);
    }

    /**
     * Метод позволяет вывести на экран только буквы (исп. StringBuilder)
     *
     * @param str       - принимаемая на вход строка
     * @param delimiter - заданнвй делитель
     */
    public static void onlyLetterIntoString(String str, char delimiter) {
        String result = "";
        if (isValid(str)) {
            String[] wordsArray = str.toLowerCase().split("-");
            for (int i = 0; i < wordsArray.length; i++) {
                if (isNumeric(wordsArray[i])) {
                    wordsArray[i] = "";
                } else {
                    wordsArray[i] = wordsArray[i].replaceAll("[0-9]", "");
                    if (i != wordsArray.length - 1) {
                        result += wordsArray[i] + delimiter;
                    } else {
                        result += wordsArray[i];
                    }
                }
            }
        }
        System.out.println(result);
    }

    /**
     * Метод позволяет вывести на экран только буквы (исп. StringBuilder)
     *
     * @param str       - принимаемая на вход строка
     * @param delimiter - заданнвй делитель
     */
    public static void onlyLetterIntoStringByStringBuilder(String str, char delimiter) {
        String result = "";
        if (isValid(str)) {
            int counter = 0;
            StringBuilder sb = new StringBuilder("Letters:");
            String[] wordsArray = str.toUpperCase().split("-");
            for (String element : wordsArray) {
                counter++;
                String tempString = "";
                if (!isNumeric(element)) {
                    element = element.replaceAll("[0-9]", "");
                    sb.append(element);
                    if (counter < wordsArray.length)
                        sb.append(delimiter);
                }
            }
            System.out.println(sb);
        }
    }


    /**
     * Метод позволяет проверить наличие последовательности символов в строке. Вне зависимости от регистра
     *
     * @param str          - строка, принимаемая на вход
     * @param charSequence - последовательность символов, принимаемая на вход
     * @return - возвращает булево значение
     */
    public static void checkCharSequence(String str, String charSequence) throws ContainSequanceException {
        String result = "";
        if (isValid(str)) {
            charSequence = charSequence.toLowerCase();
            str = str.toLowerCase();
            if (str.contains(charSequence)) {
                result = "Последовательность - " + charSequence + " -  в строке присутствует";
            } else {
                throw new ContainSequanceException("Заданная последовательность в строке не присутствует");
            }
        }
        System.out.println(result);
    }

    /**
     * Метод позволяет проверить, является ли заданная последовательность символов началом строки
     *
     * @param str          - строка, принимаемая на вход
     * @param charSequence - последовательность символов, принимаемая на вход
     * @return возвращает строку
     */
    public static void checkStringStart(String str, String charSequence) throws ContainSequanceAtStartException {
        String result = "";
        if (isValid(str)) {
            charSequence = charSequence.toLowerCase();
            str = str.toLowerCase();
            if (str.startsWith(charSequence)) {
                result = "Последовательность - " + charSequence + " - является началом строки";
            } else {
                throw new ContainSequanceAtStartException("Заданная последовательность не является началом строки");
            }
        }
        System.out.println(result);
    }

    /**
     * Метод позаоляет проверить, является ли заданная последовательность символов окончанием строки
     *
     * @param str          - строка, принимаемая на вход
     * @param charSequence - последовательность символов, принимаемая на вход
     * @return возвращает строку
     */
    public static void checkStringEnd(String str, String charSequence) throws ContainSequanceAtEndException {
        String result = "";
        if (isValid(str)) {
            charSequence = charSequence.toLowerCase();
            str = str.toLowerCase();
            if (str.startsWith(charSequence)) {
                result = "Последовательность - " + charSequence + " - является окончанием строки";
            } else {
                throw new ContainSequanceAtEndException("Заданная последовательность не является окончание строки");
            }
        }
        System.out.println(result);
    }


    /**
     * Метод заменяет символ в строке на указанный
     *
     * @param str       - строка, принимаетмая на вход
     * @param character - символ, на который будет меняться
     * @return возвращает строку
     */
    private static String changeChar(String str, char character) {
        String result = "";
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (!Character.isDigit(character)) {
                charArray[i] = character;
            }
            result += charArray[i];
        }
        return result;
    }

    /**
     * Метод определяет, является ли заданная строка числом
     *
     * @param str - принимаемая для проверки строка
     * @return возвращает булево значение
     */
    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }

    /**
     * Данный метод проверяет, корректно ли введена строка
     *
     * @param str - принимает введенную строку
     * @return - возвращает булево значние
     */
    private static boolean isValid(String str) {
        if (str != null && !str.isEmpty()) {
            return true;
        } else {
            System.out.print("Введенное значение не корректно. Строка пуста или null");
            return false;
        }
    }
}
