/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.io;

import com.ibm.oti.io.CharacterConverterSJIS;
import com.ibm.oti.io.CharacterConverter_EUC_JP;
import com.ibm.oti.util.BinarySearch;

class CharacterConverter_SJIS
extends CharacterConverterSJIS {
    CharacterConverter_SJIS() {
    }

    @Override
    String getByteTable() {
        return CharacterConverter_EUC_JP.jis208;
    }

    @Override
    String getCharTableKeys() {
        return CharacterConverter_EUC_JP.keys;
    }

    @Override
    String getCharTableValues() {
        return CharacterConverter_EUC_JP.values;
    }

    @Override
    public byte[] convert(char[] cArray, int n, int n2) {
        int n3 = 0;
        n2 += n;
        int n4 = n;
        while (n4 < n2) {
            char c2 = cArray[n4];
            n3 = c2 < '\u0080' || c2 == '\u00a5' || c2 >= '\u61ff0000' && c2 <= '\u9fff0000' ? ++n3 : (n3 += 2);
            ++n4;
        }
        n4 = 0;
        String string = this.getCharTableKeys();
        String string2 = this.getCharTableValues();
        byte[] byArray = new byte[n3];
        int n5 = n;
        while (n5 < n2) {
            char c3 = cArray[n5];
            if (c3 < '\u0080') {
                byArray[n4++] = (byte)c3;
            } else {
                int n6 = BinarySearch.binarySearch(string, c3);
                if (n6 == -1) {
                    byArray[n4++] = 63;
                } else {
                    char c4 = string2.charAt(n6);
                    byte by = (byte)(c4 >> 8);
                    if (by > 0) {
                        byArray[n4++] = 63;
                    } else if (by < 0 && by >= -96) {
                        byte by2 = (byte)(by - 160);
                        byArray[n4++] = (byte)((by2 + 1 >> 1) + (by2 < 63 ? 128 : 192));
                        byte by3 = (byte)(c4 - 160);
                        byArray[n4++] = (byte)(by3 + (by2 % 2 != 0 ? (by3 > 63 ? 64 : 63) : 158));
                    } else {
                        byArray[n4++] = (byte)c4;
                    }
                }
            }
            ++n5;
        }
        if (n4 < byArray.length) {
            byte[] byArray2 = new byte[n4];
            System.arraycopy((Object)byArray, 0, (Object)byArray2, 0, n4);
            byArray = byArray2;
        }
        return byArray;
    }
}

