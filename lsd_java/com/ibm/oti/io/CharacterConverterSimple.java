/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.io;

import com.ibm.oti.io.CharacterConverter;
import com.ibm.oti.util.BinarySearch;
import com.ibm.oti.vm.VM;

abstract class CharacterConverterSimple
extends CharacterConverter {
    private static final boolean useNative = VM.useNatives();

    CharacterConverterSimple() {
    }

    abstract String byteTable() {
    }

    abstract String charKeys() {
    }

    abstract String charValues() {
    }

    private native int convertImpl(byte[] byArray, int n, char[] cArray, int n2, int n3, String string) {
    }

    @Override
    public int convert(byte[] byArray, int n, char[] cArray, int n2, int n3) {
        if (useNative) {
            return this.convertImpl(byArray, n, cArray, n2, n3, this.byteTable());
        }
        String string = this.byteTable();
        int n4 = n3;
        while (--n4 >= 0) {
            char c2 = byArray[n++];
            cArray[n2++] = c2 < '\u0000' ? string.charAt(c2 + 128) : c2;
        }
        return n;
    }

    private native byte[] convertImpl(char[] cArray, int n, int n2, String string, String string2) {
    }

    @Override
    public byte[] convert(char[] cArray, int n, int n2) {
        if (useNative) {
            return this.convertImpl(cArray, n, n2, this.charKeys(), this.charValues());
        }
        byte[] byArray = new byte[n2];
        int n3 = 0;
        int n4 = n + n2;
        String string = this.charKeys();
        String string2 = this.charValues();
        int n5 = n;
        while (n5 < n4) {
            char c2 = cArray[n5];
            if (c2 <= '\u007f') {
                byArray[n3++] = (byte)c2;
            } else {
                int n6 = BinarySearch.binarySearch(string, c2);
                if (n6 >= 0) {
                    byArray[n3++] = (byte)string2.charAt(n6);
                } else {
                    if (c2 >= '\ud80000' && c2 < '\udc0000' && n5 + 1 < n4 && cArray[n5 + 1] >= '\udc0000' && cArray[n5 + 1] < '\ue00000') {
                        ++n5;
                    }
                    byArray[n3++] = 63;
                }
            }
            ++n5;
        }
        if (n3 < byArray.length) {
            byte[] byArray2 = new byte[n3];
            System.arraycopy((Object)byArray, 0, (Object)byArray2, 0, n3);
            return byArray2;
        }
        return byArray;
    }
}

