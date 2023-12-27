/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.config.bcf;

import de.esolutions.fw.util.commons.StringConverter;
import java.io.UnsupportedEncodingException;

public class BCFStringEntry {
    private String entry;
    private int len;
    private BCFStringEntry mergeWith;
    private int mergeOffset;
    private int baseOffset;

    public BCFStringEntry(String string) {
        this.entry = string;
        this.len = string.length();
    }

    public int getOffset() {
        if (this.mergeWith != null) {
            return this.mergeWith.getOffset() + this.mergeOffset;
        }
        return this.baseOffset;
    }

    public int getLength() {
        return this.len;
    }

    public void setBaseOffset(int n) {
        this.baseOffset = n;
    }

    public void setMerge(BCFStringEntry bCFStringEntry, int n) {
        this.mergeWith = bCFStringEntry;
        this.mergeOffset = n;
    }

    public BCFStringEntry getMergeWith() {
        return this.mergeWith;
    }

    public int getMergeOffset() {
        return this.mergeOffset;
    }

    public byte[] toBytes() {
        byte[] byArray;
        try {
            byArray = StringConverter.UTF8.getBytes(this.entry);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            byArray = this.entry.getBytes();
        }
        return byArray;
    }

    public int canMerge(BCFStringEntry bCFStringEntry) {
        String string = bCFStringEntry.entry;
        int n = string.length();
        if (n > this.len) {
            return -1;
        }
        if (n == this.len) {
            if (string.equals(this.entry)) {
                return 0;
            }
            return -1;
        }
        int n2 = this.len - n;
        if (this.entry.substring(n2).equals(string)) {
            return n2;
        }
        return -1;
    }
}

