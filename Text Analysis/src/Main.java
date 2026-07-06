/* Тут будет:
Scanner;
меню;
вызов методов */

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        TextAnalyzer analyzer = new TextAnalyzer();
        TextEditor editor = new TextEditor();
        String text = "";

        // Вызов меню
        while (true) {

            // ОБРАБОТКА ИСКЛЮЧЕНИЯ
            System.out.print("Введите строку: ");
            text = scanner.nextLine();

            menu();

            // ОБРАБОТКА ИСКЛЮЧЕНИЯ
            System.out.print("Введите число: ");
            int number = scanner.nextInt();

            scanner.nextLine();


            switch (number) {
                case 1:

                    System.out.println("=== СТАТИСТИКА ===");

                    System.out.println("Количество символов: "
                            + analyzer.countCharacters(text));

                    System.out.println("Количество символов без пробелов: "
                            + analyzer.countCharactersWithoutSpaces(text));

                    System.out.println("Количество цифр: "
                            + analyzer.countNumbers(text));

                    System.out.println("Количество букв: "
                            + analyzer.countOfLetters(text));

                    System.out.println("Количество специальных символов: "
                            + analyzer.countOfSpecialCharacters(text));

                    System.out.println("Количество слов: "
                            + analyzer.countWords(text));

                    System.out.println("Самое длинное слово: "
                            + analyzer.longWord(text));

                    System.out.println("Самое короткое слово: "
                            + analyzer.shortWord(text));

                    System.out.println("Средняя длина слова: "
                            + analyzer.averageLength(text));

                    System.out.println("Количество заглавных букв: "
                            + analyzer.numberCapital(text));

                    System.out.println("Количество строчных букв: "
                            + analyzer.numberLowercase(text));

                    break;

                case 2:

                    System.out.println("=== ПОИСК СЛОВА ===");

                    // ОБРАБОТКА ИСКЛЮЧЕНИЯ
                    System.out.println("Введите слово:");
                    String searchWord = scanner.nextLine();

                    analyzer.searchWord(text, searchWord);
                    break;

                case 3:

                    System.out.println("=== ЗАМЕНА СЛОВА ===");

                    // ОБРАБОТКА ИСКЛЮЧЕНИЯ
                    System.out.print("Какое слово заменить: ");
                    String oldWord = scanner.nextLine();

                    // ОБРАБОТКА ИСКЛЮЧЕНИЯ
                    System.out.print("На какое слово заменить: ");
                    String newWord = scanner.nextLine();

                    text = editor.replaceWord(text, oldWord, newWord);

                    System.out.println("Новый текст:");
                    System.out.println(text);

                    break;

                case 4:

                    System.out.println("=== УДАЛЕНИЕ СЛОВА ===");

                    // ОБРАБОТКА ИСКЛЮЧЕНИЯ
                    System.out.print("Какое слово удалить: ");
                    String deleteWord = scanner.nextLine();

                    text = editor.deleteWord(text, deleteWord);

                    System.out.println("Новый текст:");
                    System.out.println(text);

                    break;

                case 5:

                    System.out.println("=== ВСТАВКА НОВОГО СЛОВА ===");

                    // ОБРАБОТКА ИСКЛЮЧЕНИЯ
                    System.out.print("Какое слово вставить: ");
                    String insertWord = scanner.nextLine();

                    text = editor.insertText(text, insertWord);

                    System.out.println("Новый текст:");
                    System.out.println(text);

                    break;

                case 6:

                    System.out.println("=== ЧАСТОТНЫЙ АНАЛИЗ ===");
                    System.out.println("Повторение всех слов в строке: ");
                    analyzer.repeatWords(text);

                    System.out.println("Повторение всех символов в строке: ");
                    analyzer.repeatCharacters(text);

                    break;

                case 7:

                    System.out.println("=== СОРТИРОВКА ПО АЛФАВИТУ ===");
                    String[] sorted = analyzer.sortByAlphabet(text);

                    for (String word : sorted) {
                        System.out.println(word);
                    }

                    break;

                case 8:

                    System.out.println("=== СОРТИРОВКА ПО ДЛИНЕ ===");
                    String[] sorteda = analyzer.sortByLength(text);

                    for (String word : sorteda) {
                        System.out.println(word);
                    }

                    break;

                case 9:

                    System.out.println("=== СОРТИРОВКА ПО ЧАСТОТЕ ===");
                    Map<String, Integer> freqMap = analyzer.sortByFrequency(text);

                    List<Map.Entry<String, Integer>> list =
                            new ArrayList<>(freqMap.entrySet());

                    list.sort((a, b) -> b.getValue().compareTo(a.getValue()));

                    for (Map.Entry<String, Integer> entry : list) {
                        System.out.println(entry.getKey() + " -> " + entry.getValue());
                    }

                    break;

                case 10:

                    System.out.println("Выход из программы...");
                    return;

                default:
                    System.out.println("Введите число от 1 до 10 !!!!!");
            }
        }

    }

    public static void menu() {
        System.out.println("=== МЕНЮ ===");
        System.out.println("1. Показать статистику");
        System.out.println("2. Найти слово");
        System.out.println("3. Заменить слово");
        System.out.println("4. Удалить слово");
        System.out.println("5. Вставка нового слова");
        System.out.println("6. Частотный анализ");
        System.out.println("7. Сортировка слов по алфавиту");
        System.out.println("8. Сортировка слов по длине");
        System.out.println("9. Сортировка слов по частоте");
        System.out.println("10. Выход");
    }
}