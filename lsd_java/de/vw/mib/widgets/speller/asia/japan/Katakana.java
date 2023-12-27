/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.japan;

public final class Katakana {
    public static final char HW_MIN;
    public static final char HW_MAX;
    public static final char MIN;
    public static final char MAX;

    public static boolean isHWKatakana(char c2) {
        return '\u65ff0000' <= c2 && c2 <= '\u9fff0000';
    }

    public static boolean isKatakana(char c2) {
        return '\u30a0' <= c2 && c2 <= '\u30ff';
    }

    private Katakana() {
    }
}

