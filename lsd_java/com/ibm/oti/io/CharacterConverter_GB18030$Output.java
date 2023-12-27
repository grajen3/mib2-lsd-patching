/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.io;

class CharacterConverter_GB18030$Output {
    byte[] buf;
    int byteSize;
    int pos = 0;

    public CharacterConverter_GB18030$Output(int n) {
        this.byteSize = n * 4;
        this.buf = new byte[n];
    }

    public void write(int n) {
        if (this.pos == this.buf.length) {
            int n2 = this.buf.length * 2;
            if (n2 < this.byteSize) {
                n2 = this.byteSize;
            }
            byte[] byArray = new byte[n2];
            System.arraycopy((Object)this.buf, 0, (Object)byArray, 0, this.buf.length);
            this.buf = byArray;
        }
        this.buf[this.pos++] = (byte)n;
    }

    public byte[] toByteArray() {
        if (this.pos == this.buf.length) {
            return this.buf;
        }
        byte[] byArray = new byte[this.pos];
        System.arraycopy((Object)this.buf, 0, (Object)byArray, 0, this.pos);
        return byArray;
    }
}

