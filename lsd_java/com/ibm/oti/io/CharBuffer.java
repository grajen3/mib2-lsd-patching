/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.io;

public class CharBuffer {
    char[] buffer;
    int offset;
    int size;
    int pos;

    public CharBuffer(char[] cArray, int n, int n2) {
        this.buffer = cArray;
        this.offset = n;
        this.pos = n;
        this.size = n2;
    }

    public CharBuffer(int n) {
        this.buffer = new char[n];
        this.offset = 0;
        this.pos = 0;
        this.size = n;
    }

    public int getOffset() {
        return this.offset;
    }

    public int getPos() {
        return this.pos;
    }

    public int getSize() {
        return this.size;
    }

    public void setPos(int n) {
        this.pos = n;
    }

    public void setOffset(int n) {
        this.offset = n;
    }

    public char[] getChars() {
        return this.buffer;
    }
}

