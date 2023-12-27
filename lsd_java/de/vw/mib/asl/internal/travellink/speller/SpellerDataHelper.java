/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.speller;

import de.vw.mib.properties.values.SpellerData;

public final class SpellerDataHelper {
    private SpellerDataHelper() {
    }

    public static void deleteChar(SpellerData spellerData) {
        String string = spellerData.getEnteredText();
        int n = spellerData.getCursorPosition();
        if (spellerData.getSelectionStart() != spellerData.getSelectionEnd()) {
            spellerData.setEnteredText("");
            SpellerDataHelper.deselectAll(spellerData);
            spellerData.setCursorPosition(0);
            return;
        }
        if (string.length() > 0 && n > 0 && n <= string.length() + 1) {
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

    public static void addChar(SpellerData spellerData, String string) {
        String string2 = spellerData.getEnteredText();
        int n = spellerData.getCursorPosition();
        if (spellerData.getSelectionStart() != spellerData.getSelectionEnd()) {
            spellerData.setEnteredText(string);
            SpellerDataHelper.deselectAll(spellerData);
            spellerData.setCursorPosition(spellerData.getEnteredText().length());
            return;
        }
        if (n > string2.length()) {
            spellerData.setCursorPosition(string2.length());
        }
        if (string2.length() == 0) {
            spellerData.setEnteredText(string);
        } else if (n == 0) {
            spellerData.setEnteredText(new StringBuffer().append(string).append(string2).toString());
        } else if (n == string2.length()) {
            spellerData.setEnteredText(new StringBuffer().append(string2).append(string).toString());
        } else {
            spellerData.setEnteredText(new StringBuffer(string2.substring(0, n)).append(string).append(string2.substring(n)).toString());
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

