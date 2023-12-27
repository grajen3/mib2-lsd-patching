/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.util;

import de.vw.mib.properties.values.SpellerData;

public final class SpellerDataHelper {
    private SpellerDataHelper() {
    }

    public static void deleteChar(SpellerData spellerData) {
        String string = spellerData.getEnteredText();
        int n = spellerData.getCursorPosition();
        if (spellerData.getSelectionStart() != spellerData.getSelectionEnd()) {
            if (spellerData.getSelectionEnd() - spellerData.getSelectionStart() == string.length()) {
                spellerData.setEnteredText("");
                SpellerDataHelper.deselectAll(spellerData);
                spellerData.setCursorPosition(0);
            } else {
                SpellerDataHelper.removeSelectedCharacters(spellerData);
            }
            return;
        }
        if (n > string.length()) {
            spellerData.setCursorPosition(string.length());
            n = string.length();
        }
        if (string.length() > 0 && n > 0 && n <= string.length()) {
            if (n == 1) {
                spellerData.setEnteredText(string.substring(1));
            } else if (n == string.length()) {
                spellerData.setEnteredText(string.substring(0, string.length() - 1));
            } else {
                spellerData.setEnteredText(new StringBuffer().append(string.substring(0, n - 1)).append(string.substring(n)).toString());
            }
            spellerData.setCursorPosition(n - 1);
        }
    }

    private static String removeSelectedCharacters(SpellerData spellerData) {
        String string = "";
        String string2 = "";
        try {
            string = spellerData.getEnteredText().substring(0, spellerData.getSelectionStart());
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            // empty catch block
        }
        try {
            string2 = spellerData.getEnteredText().substring(spellerData.getSelectionEnd());
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            // empty catch block
        }
        String string3 = new StringBuffer().append(string).append(string2).toString();
        spellerData.setEnteredText(string3);
        spellerData.setCursorPosition(spellerData.getSelectionStart());
        SpellerDataHelper.deselectAll(spellerData);
        return spellerData.getEnteredText();
    }

    public static void addChar(SpellerData spellerData, String string) {
        if (string == null || string.length() == 0) {
            return;
        }
        String string2 = spellerData.getEnteredText();
        int n = spellerData.getCursorPosition();
        if (spellerData.getSelectionStart() != spellerData.getSelectionEnd()) {
            if (spellerData.getSelectionEnd() - spellerData.getSelectionStart() == string2.length()) {
                spellerData.setEnteredText(string);
                SpellerDataHelper.deselectAll(spellerData);
                spellerData.setCursorPosition(spellerData.getEnteredText().length());
                return;
            }
            string2 = SpellerDataHelper.removeSelectedCharacters(spellerData);
            n = spellerData.getCursorPosition();
        }
        if (n > string2.length()) {
            spellerData.setCursorPosition(string2.length());
            n = string2.length();
        }
        if (string2.length() == 0) {
            spellerData.setEnteredText(string);
        } else if (n == 0) {
            spellerData.setEnteredText(new StringBuffer().append(string).append(string2).toString());
        } else if (n >= string2.length()) {
            spellerData.setEnteredText(new StringBuffer().append(string2).append(string).toString());
        } else {
            if (n != spellerData.getCursorPosition()) {
                n = spellerData.getCursorPosition();
            }
            int n2 = Math.min(n, string2.length());
            spellerData.setEnteredText(new StringBuffer(string2.substring(0, n2)).append(string).append(string2.substring(n2)).toString());
        }
        spellerData.setCursorPosition(n + string.length());
    }

    public static void selectAll(SpellerData spellerData) {
        spellerData.setSelectionStart(0);
        spellerData.setSelectionEnd(spellerData.getEnteredText().length());
    }

    public static void deselectAll(SpellerData spellerData) {
        spellerData.setSelectionStart(0);
        spellerData.setSelectionEnd(0);
    }

    public static void clear(SpellerData spellerData) {
        SpellerDataHelper.deselectAll(spellerData);
        spellerData.setCursorPosition(0);
        spellerData.setEnteredText("");
    }
}

