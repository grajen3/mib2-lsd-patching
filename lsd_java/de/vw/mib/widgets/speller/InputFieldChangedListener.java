/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller;

public interface InputFieldChangedListener {
    public static final int UPDATE_ALL;
    public static final int UPDATE_ENTERED_TEXT;
    public static final int UPDATE_CURSOR_POSITION;

    default public void inputFieldChanged(int n) {
    }
}

