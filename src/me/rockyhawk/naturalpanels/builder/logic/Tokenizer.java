package me.rockyhawk.naturalpanels.builder.logic;

import java.util.ArrayList;
import java.util.List;

public class Tokenizer {
    public static List<Token> tokenize(String input) {
        List<Token> tokens = new ArrayList<>();
        String[] parts = input.replace("(", " ( ").replace(")", " ) ").split("\\s+");
        for (String part : parts) {
            if (!part.isBlank()) tokens.add(new Token(part));
        }
        return tokens;
    }
}
