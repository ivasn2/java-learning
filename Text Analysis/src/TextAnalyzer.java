/* Тут вся аналитика текста:
подсчёт слов;
подсчёт символов;
поиск слов;
анализ регистра;
частотный анализ. */

import java.util.*;

public class TextAnalyzer {

    // =================== ПОДСЧЕТ СИМВОЛОВ ===================
    public int countCharacters(String text) {
        return text.length();
    }

    // Кол-во символов без пробелов
    public int countCharactersWithoutSpaces(String text) {

        // Заменяем в слове пробел на пустую строку, то есть удаляем её
        text = text.replaceAll(" ", "");
        return text.length();
    }

    // Кол-во цифр
    public int countNumbers(String text) {
        int countNumbers = 0;
        for (char c : text.toCharArray()) {
            if (Character.isDigit(c)) {
                countNumbers++;
            }
        }
        return countNumbers;
    }

    // Кол-во букв
    public int countOfLetters(String text) {
        int countLetters = 0;
        for (char c : text.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                countLetters++;
            }
        }
        return countLetters;
    }

    // Кол-во специальных символов
    public int countOfSpecialCharacters(String text) {
        String textWithSpecialCharacters = text.replaceAll("[a-zA-Zа-яА-Я0-9 ]", "");
        return textWithSpecialCharacters.length();
    }





    // =================== ПОДСЧЕТ СЛОВ ===================
    // Подсчет слов
    public int countWords(String text) {
        // Удаляем всё кроме букв, цифр и пробелов
        text = text.replaceAll("[^a-zA-Zа-яА-Я0-9 ]", "");
        String[] words = text.trim().split("\\s+");
        return words.length;
    }

    // Самое длинное слово
    public String longWord(String text) {
        String longWord = "";
        int wordLength = 0;
        String[] words = text.trim().split("\\s+");
        for (String word : words) {
            if (word.length() > wordLength) {
                wordLength = word.length();
                longWord = word;
            }
        }
        return longWord;
    }

    // Самое короткое слово
    public String shortWord(String text) {
        String shortWord = "";
        int wordLength = Integer.MAX_VALUE;
        String[] words = text.trim().split("\\s+");
        for (String word : words) {
            if (word.length() < wordLength) {
                wordLength = word.length();
                shortWord = word;
            }
        }
        return shortWord;
    }

    // Средняя длина слова
    public double averageLength(String text) {
        return (double) countOfLetters(text) / countWords(text);
    }

    // Кол-во заглавных букв
    public int numberCapital(String text) {
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if (Character.isUpperCase(text.charAt(i))) {
                count++;
            }
        }
        return count;
    }

    // Кол-во прописных букв
    public int numberLowercase(String text) {
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if (Character.isLowerCase(text.charAt(i))) {
                count++;
            }
        }
        return count;
    }




    // =================== ЧАСТОТНЫЙ АНАЛИЗ ===================
    //  Подсчет повторений каждого слова в строке
    public void repeatWords(String text) {
        String cleanText = text.toLowerCase().replaceAll("[^a-zа-яё\\s]", "");
        String[] words = cleanText.split("\\s+");

        // Считаем слова с помощью Map
        Map<String, Integer> wordCountMap = new HashMap<>();
        for (String word : words) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            System.out.println(entry.getKey() + "-> " + entry.getValue());
        }
    }

    // Подсчет повторений каждого символа в строке
    public void repeatCharacters(String text) {
        Map<Character, Integer> charMap = new HashMap<>();

        for (char c : text.toCharArray()) {
            if (c != ' ') { // чтобы не считать пробелы
                charMap.put(c, charMap.getOrDefault(c, 0) + 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }




    // =================== ПОИСК В ТЕКСТЕ ===================
    public void searchWord(String text, String searchWord) {
        // Для поиска без учета регистра
        text = text.toLowerCase();
        searchWord = searchWord.toLowerCase();

        int count = 0;
        int index = 0;

        System.out.println("Позиции слова:");

        // Пока слово находится
        while ((index = text.indexOf(searchWord, index)) != -1) {

            System.out.println(index);

            count++;

            // Сдвигаемся дальше
            index += searchWord.length();
        }

        System.out.println("Количество повторений: " + count);
    }

    // =================== СОРТИРОВКА ===================
    // По алфавиту
    public String[] sortByAlphabet(String text) {
        String[] words = text.trim().split("\\s+");
        Arrays.sort(words);
        return words;
    }

    // По длине
    public String[] sortByLength(String text) {
        String[] words = text.trim().split("\\s+");

        Arrays.sort(words, (a, b) -> a.length() - b.length());

        return words;
    }

    // По частоте
    public Map<String, Integer> sortByFrequency(String text) {

        String[] words = text.toLowerCase()
                .replaceAll("[^a-zA-Zа-яА-Я0-9 ]", "")
                .trim()
                .split("\\s+");

        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        return map;
    }

}
