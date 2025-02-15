package exercise;

public class ReversedSequence implements CharSequence {
    private final String original;

    public ReversedSequence(String original) {
        this.original = original;
    }

    @Override
    public char charAt(int index) {
        // Возвращаем символ из оригинальной строки, но с перевернутым индексом
        return original.charAt(original.length() - 1 - index);
    }

    @Override
    public int length() {
        return original.length(); // Длина остается такой же, как у оригинальной строки
    }


    @Override
    public CharSequence subSequence(int start, int end) {
        // Индексы для перевернутой строки
        String result = "";
        for (int i = 0; i < original.length(); i++) {
            result = original.charAt(i) + result;
        }
        return new StringBuilder(result.substring(start,end));
    }


    @Override
    public String toString() {
        return new StringBuilder(original).reverse().toString(); // Возвращаем перевернутую строку
    }
}
