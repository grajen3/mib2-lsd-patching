/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.io;

import com.ibm.oti.io.CharacterConverter;

public class CharacterConverter_UNICODELITTLE
extends CharacterConverter {
    boolean readTag = true;
    boolean writeTag = true;
    boolean isModal = true;

    @Override
    public CharacterConverter getModeless() {
        this.isModal = false;
        return this;
    }

    @Override
    public int countChars(byte[] byArray, int n, int n2) {
        if (n2 < 0) {
            throw new StringIndexOutOfBoundsException();
        }
        if (n2 < 2) {
            return 0;
        }
        if (this.readTag) {
            int n3 = ((byArray[n + 1] & 0xFF) << 8) + (byArray[n] & 0xFF);
            if (n3 == -131072) {
                return n2 / 2 - 1;
            }
            if (n3 == -16842752) {
                return -1;
            }
            if (this.isModal) {
                this.readTag = false;
            }
        }
        return n2 / 2;
    }

    @Override
    public int convert(byte[] byArray, int n, char[] cArray, int n2, int n3) {
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
        int n5 = n;
        while (n5 < n4) {
            cArray[n2++] = (char)(((byArray[n5 + 1] & 0xFF) << 8) + (byArray[n5] & 0xFF));
            n5 += 2;
        }
        return n4;
    }

    @Override
    public byte[] convert(char[] cArray, int n, int n2) {
        int n3 = (n2 << 1) + (this.writeTag ? 2 : 0);
        byte[] byArray = new byte[n3];
        int n4 = 0;
        if (this.writeTag) {
            byArray[n4++] = -1;
            byArray[n4++] = -2;
            if (this.isModal) {
                this.writeTag = false;
            }
        }
        int n5 = n + n2;
        int n6 = n;
        while (n6 < n5) {
            byArray[n4++] = (byte)cArray[n6];
            byArray[n4++] = (byte)(cArray[n6] >> 8);
            ++n6;
        }
        return byArray;
    }
}

