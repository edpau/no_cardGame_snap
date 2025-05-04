package org.example.card;

public record SymbolValue(String symbol, int value) {
    public static final SymbolValue[] SYMBOLS_AND_VALUES = {
            new SymbolValue("2", 2), new SymbolValue("3", 3), new SymbolValue("4", 4),
            new SymbolValue("5", 5), new SymbolValue("6", 6), new SymbolValue("7", 7),
            new SymbolValue("8", 8), new SymbolValue("9", 9), new SymbolValue("10", 10),
            new SymbolValue("J", 11), new SymbolValue("Q", 12), new SymbolValue("K", 13),
            new SymbolValue("A", 14)};
}
