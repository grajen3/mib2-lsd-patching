/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.speller;

import de.vw.mib.properties.values.SpellerData;

public interface SpellerEngine {
    public static final int CONF_REPLACE_SELECTED;
    public static final int CONF_SELECT_INSERTED;
    public static final int CONF_SUPPORT_BLOCKS;
    public static final int CONF_SUPPORT_CURSOR;

    default public void cursorCharLeft() {
    }

    default public void cursorCharRight() {
    }

    default public void setCursor(int n) {
    }

    default public void setSelection(int n, int n2) {
    }

    default public void resetSelection() {
    }

    default public void insertText(String string) {
    }

    default public void deleteCharLeft() {
    }

    default public int getConfiguration() {
    }

    default public void setConfiguration(int n) {
    }

    default public SpellerData getSpellerData() {
    }

    default public boolean isDataPending() {
    }
}

