/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.io;

import com.ibm.oti.io.CharacterConverter_UNICODE;

public class CharacterConverter_UTF16
extends CharacterConverter_UNICODE {
    @Override
    public byte[] convert(char[] cArray, int n, int n2) {
        int n3 = (n2 << 1) + (this.writeTag ? 2 : 0);
        byte[] byArray = new byte[n3];
        int n4 = 0;
        if (this.writeTag) {
            byArray[n4++] = -2;
            byArray[n4++] = -1;
            if (this.isModal) {
                this.writeTag = false;
            }
        }
        int n5 = n + n2;
        int n6 = n;
        while (n6 < n5) {
            byArray[n4++] = (byte)(cArray[n6] >> 8);
            byArray[n4++] = (byte)cArray[n6];
            ++n6;
        }
        return byArray;
    }
}

