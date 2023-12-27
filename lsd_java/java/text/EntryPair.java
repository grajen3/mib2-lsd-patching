/*
 * Decompiled with CFR 0.152.
 */
package java.text;

final class EntryPair {
    public String entryName;
    public int value;
    public boolean fwd;

    public EntryPair(String string, int n) {
        this(string, n, true);
    }

    public EntryPair(String string, int n, boolean bl) {
        this.entryName = string;
        this.value = n;
        this.fwd = bl;
    }
}

