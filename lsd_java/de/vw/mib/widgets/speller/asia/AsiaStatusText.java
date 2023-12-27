/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia;

public final class AsiaStatusText {
    private static final String BAD_PARAM_TEXT;
    private static final String EMPTY_TEXT;
    private static final String FULL_TEXT;
    private static final String INVALID_INPUT_TEXT;
    private static final String NEED_SELLIST_BUILD_TEXT;
    private static final String OUT_OF_RANGE_TEXT;
    private static final String UNKNOWN_TEXT;

    public static String getText(int n) {
        switch (n) {
            case 27: {
                return "Bad parameter passed";
            }
            case 6: {
                return "Buffer empty";
            }
            case 5: {
                return "Buffer full";
            }
            case 49: {
                return "Input is invalid";
            }
            case 34: {
                return "Need to build selection list";
            }
            case 7: {
                return "Out of range";
            }
            case 0: {
                return "General error";
            }
        }
        return new StringBuffer().append("Unknown asia input status: '").append(n).append("'").toString();
    }

    private AsiaStatusText() {
    }
}

