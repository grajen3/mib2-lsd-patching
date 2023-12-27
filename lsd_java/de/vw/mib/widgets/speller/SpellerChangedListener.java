/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller;

public interface SpellerChangedListener {
    public static final int UPDATE_CURSOR_POSITION;
    public static final int UPDATE_ENTERED_TEXT;
    public static final int UPDATE_INFO_TEXT;
    public static final int UPDATE_MATCH_COMPLETION;
    public static final int UPDATE_MATCH_TEXT;
    public static final int UPDATE_MODE;
    public static final int UPDATE_SELECTION;
    public static final int UPDATE_ALL;

    default public void spellerChanged(int n) {
    }
}

