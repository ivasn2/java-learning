/*Изменение текста:
замена;
удаление;
вставка. */

public class TextEditor {

    // Замена слова
    public String replaceWord(String text, String oldWord, String newWord) {
        StringBuilder sb = new StringBuilder(text);

        // Ищем слово
        int index = sb.indexOf(oldWord);

        while (index != -1) {

            sb.replace(index, index + oldWord.length(), newWord);

            index = sb.indexOf(oldWord);
        }

        return sb.toString();
    }

    // Удаление слова
    public String deleteWord(String text, String deleteWord) {

        StringBuilder builder = new StringBuilder(text);

        int index = builder.indexOf(deleteWord);

        while (index != -1) {

            builder.delete(index, index + deleteWord.length());

            index = builder.indexOf(deleteWord);
        }

        return builder.toString();
    }

    // Вставка слова
    public String insertText(String text, String newText) {
        StringBuilder builder = new StringBuilder(text);
        builder.append(" ").append(newText);
        return builder.toString();
    }


}
