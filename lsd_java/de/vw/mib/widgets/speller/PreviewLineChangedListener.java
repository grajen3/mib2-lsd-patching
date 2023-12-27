/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller;

public interface PreviewLineChangedListener {
    public static final int CONTENT_INDEX_HIDDEN;
    public static final int CONTENT_INDEX_HISTORY;
    public static final int CONTENT_INDEX_PREVIEW;
    public static final int CONTENT_INDEX_RESULT;

    default public void activeContentChanged(int n) {
    }
}

