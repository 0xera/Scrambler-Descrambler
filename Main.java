package ru.aydarov.ecm;
import org.jetbrains.annotations.NotNull;
import java.util.stream.IntStream;

public class Main {
    private static String codeScramble = "";
    private static String codeDescramble = "";

    public static void main(String[] args) {
        String codeOriginal = String.join("", args);
        System.out.println(codeOriginal);
        scrambling(codeOriginal);
        descrambling(codeScramble);
        if (codeOriginal.equals(codeDescramble)) System.out.println("Good work");
        else System.out.println("Bad work");
    }

    private static void descrambling(@NotNull String inputCode) {
        StringBuilder codeBuilder = new StringBuilder();
        IntStream.range(0, inputCode.length())
                .peek(i -> {
                    if (i - 3 < 0) codeBuilder.append(inputCode.charAt(i));
                    else if (i - 5 < 0)
                        codeBuilder.append(inputCode.charAt(i) - '0' ^ inputCode.charAt(i - 3) - '0');
                    else if (i - 10 < 0)
                        codeBuilder.append((inputCode.charAt(i) - '0' ^ inputCode.charAt(i - 3) - '0' ^ inputCode.charAt(i - 5) - '0'));
                    else
                        codeBuilder.append(inputCode.charAt(i) ^ inputCode.charAt(i - 3) ^ inputCode.charAt(i - 5) ^ inputCode.charAt(i - 10));
                })
                .filter(i -> i == inputCode.length() - 1)
                .peek(i -> codeDescramble = codeBuilder.toString())
                .forEach(i -> System.out.println(codeBuilder));
    }

    private static void scrambling(@NotNull String inputCode) {
        StringBuilder codeBuilder = new StringBuilder();
        IntStream.range(0, inputCode.length())
                .peek(i -> {
                    if (i - 3 < 0) codeBuilder.append(inputCode.charAt(i));
                    else if (i - 5 < 0)
                        codeBuilder.append(inputCode.charAt(i) - '0' ^ codeBuilder.charAt(i - 3) - '0');
                    else if (i - 10 < 0)
                        codeBuilder.append((inputCode.charAt(i) - '0' ^ codeBuilder.charAt(i - 3) - '0' ^ codeBuilder.charAt(i - 5) - '0'));
                    else
                        codeBuilder.append(inputCode.charAt(i) ^ codeBuilder.charAt(i - 3) ^ codeBuilder.charAt(i - 5) ^ codeBuilder.charAt(i - 10));
                })
                .filter(i -> i == inputCode.length() - 1)
                .peek(i -> codeScramble = codeBuilder.toString())
                .forEach(i -> System.out.println(codeBuilder));
    }
}