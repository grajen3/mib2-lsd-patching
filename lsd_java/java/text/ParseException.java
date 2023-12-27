/*
 * Decompiled with CFR 0.152.
 */
package java.text;

public class ParseException
extends Exception {
    private static final long serialVersionUID;
    private int errorOffset;

    public ParseException(String string, int n) {
        super(string);
        this.errorOffset = n;
    }

    public int getErrorOffset() {
        return this.errorOffset;
    }
}

