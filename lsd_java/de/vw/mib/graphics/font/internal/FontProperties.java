/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.font.internal;

public final class FontProperties {
    public static final int LINKED_FONT_FILENAME;
    public static final int LINKED_FONT_LOCALE;
    public static final int LINKED_FONT_RANGE_START;
    public static final int LINKED_FONT_RANGE_END;
    public static final char RANGE_INTERCONNECT_CHAR;
    public static final char RANGE_SEPARATOR_CHAR;
    public final int skinId;
    public final String[] mainFonts;
    public final String[][][] linkedFonts;
    public final char[][][][] exclusionRanges;
    public final String[] complexScriptFonts;
    public final char[][][] complexScriptRanges;

    public FontProperties(int n, String[] stringArray, String[][][] stringArray2, char[][][][] cArray, String[] stringArray3, char[][][] cArray2) {
        this.skinId = n;
        this.mainFonts = stringArray;
        this.linkedFonts = stringArray2;
        this.exclusionRanges = cArray;
        this.complexScriptFonts = stringArray3;
        this.complexScriptRanges = cArray2;
    }

    public FontProperties(int n) {
        this.skinId = n;
        this.mainFonts = new String[0];
        this.linkedFonts = new String[0][0][0];
        this.exclusionRanges = new char[0][0][0][0];
        this.complexScriptFonts = new String[0];
        this.complexScriptRanges = new char[0][0][0];
    }

    public static char[] getRange(String string) {
        int n = string.indexOf(45);
        if (n <= 0) {
            throw new NumberFormatException(new StringBuffer().append("Invalid range '").append(string).append("'.").toString());
        }
        try {
            char c2 = (char)Integer.valueOf(string.substring(0, n).trim(), 16).intValue();
            char c3 = (char)Integer.valueOf(string.substring(n + 1).trim(), 16).intValue();
            return new char[]{c2, c3};
        }
        catch (Exception exception) {
            throw new NumberFormatException(new StringBuffer().append("Error parsing range: ").append(string).toString());
        }
    }

    public int getFontId(String string) {
        for (int i2 = 0; i2 < this.mainFonts.length; ++i2) {
            if (!this.mainFonts[i2].equals(string)) continue;
            return i2;
        }
        return -1;
    }
}

