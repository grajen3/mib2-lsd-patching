/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.io;

import com.ibm.oti.io.CharacterConverter_UNICODELITTLE;

public class CharacterConverter_UNICODE
extends CharacterConverter_UNICODELITTLE {
    boolean bigEndian = true;

    private int countChars(byte[] byArray, int n, int n2, boolean[] blArray) {
        if (n2 < 0) {
            throw new StringIndexOutOfBoundsException();
        }
        if (n2 < 2) {
            return 0;
        }
        if (this.readTag) {
            int n3 = ((byArray[n] & 0xFF) << 8) + (byArray[n + 1] & 0xFF);
            if (n3 == -131072) {
                blArray[0] = true;
                return n2 / 2 - 1;
            }
            if (n3 == -16842752) {
                blArray[0] = false;
                return n2 / 2 - 1;
            }
            return -1;
        }
        return n2 / 2;
    }

    private int convert(byte[] byArray, int n, char[] cArray, int n2, int n3, boolean bl) {
        if (n3 == 0) {
            return n;
        }
        if (this.readTag) {
            n += 2;
            if (this.isModal) {
                this.readTag = false;
            }
        }
        int n4 = n + (n3 << 1);
        if (bl) {
            int n5 = n;
            while (n5 < n4) {
                cArray[n2++] = (char)(((byArray[n5] & 0xFF) << 8) + (byArray[n5 + 1] & 0xFF));
                n5 += 2;
            }
        } else {
            int n6 = n;
            while (n6 < n4) {
                cArray[n2++] = (char)(((byArray[n6 + 1] & 0xFF) << 8) + (byArray[n6] & 0xFF));
                n6 += 2;
            }
        }
        return n4;
    }

    @Override
    public char[] convert(byte[] byArray, int n, int n2) {
        boolean[] blArray = new boolean[1];
        int n3 = this.countChars(byArray, n, n2, blArray);
        if (n3 == -1) {
            return new char[0];
        }
        char[] cArray = new char[n3];
        this.convert(byArray, n, cArray, 0, n3, blArray[0]);
        return cArray;
    }

    @Override
    public int countChars(byte[] byArray, int n, int n2) {
        if (!this.isModal) {
            throw new RuntimeException("IllegalStateException");
        }
        boolean[] blArray = new boolean[1];
        int n3 = this.countChars(byArray, n, n2, blArray);
        this.bigEndian = blArray[0];
        return n3;
    }

    @Override
    public int convert(byte[] byArray, int n, char[] cArray, int n2, int n3) {
        if (!this.isModal) {
            throw new RuntimeException("IllegalStateException");
        }
        return this.convert(byArray, n, cArray, n2, n3, this.bigEndian);
    }
}

