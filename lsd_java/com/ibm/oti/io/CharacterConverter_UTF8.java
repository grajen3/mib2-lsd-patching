/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.io;

import com.ibm.oti.io.CharacterConverter;

class CharacterConverter_UTF8
extends CharacterConverter {
    CharacterConverter_UTF8() {
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public int countChars(byte[] byArray, int n, int n2) {
        if (n2 < 0) {
            throw new StringIndexOutOfBoundsException();
        }
        int n3 = n + n2;
        int n4 = 0;
        int n5 = n;
        while (n5 < n3) {
            block17: {
                byte by = byArray[n5];
                if (by >= 0) {
                    ++n5;
                } else {
                    if ((by & 0xE0) == 192) {
                        if (n5 + 1 >= n3) return n4;
                        if ((byArray[n5 + 1] & 0xC0) == 128) {
                            n5 += 2;
                            break block17;
                        } else {
                            if (n4 == 0) {
                                return -1;
                            }
                            int n6 = n4;
                            return n6;
                        }
                    }
                    if ((by & 0xF0) == 224) {
                        if (n5 + 2 >= n3) return n4;
                        if ((byArray[n5 + 1] & 0xC0) == 128 && (byArray[n5 + 2] & 0xC0) == 128) {
                            n5 += 3;
                            break block17;
                        } else {
                            if (n4 == 0) {
                                return -1;
                            }
                            int n7 = n4;
                            return n7;
                        }
                    }
                    if ((by & 0xF8) == 240) {
                        if (n5 + 3 >= n3) return n4;
                        if ((byArray[n5 + 1] & 0xC0) == 128 && (byArray[n5 + 2] & 0xC0) == 128 && (byArray[n5 + 3] & 0xC0) == 128 && (((by & 7) << 2 | byArray[n5 + 1] >> 4 & 3) - 1 & 0x1F) < 16) {
                            n5 += 4;
                            ++n4;
                            break block17;
                        } else {
                            if (n4 == 0) {
                                return -1;
                            }
                            int n8 = n4;
                            return n8;
                        }
                    }
                    if (n4 == 0) {
                        return -1;
                    }
                    int n9 = n4;
                    return n9;
                }
            }
            ++n4;
        }
        return n4;
    }

    @Override
    public int convert(byte[] byArray, int n, char[] cArray, int n2, int n3) {
        int n4 = n2 + n3;
        while (n2 < n4) {
            byte by;
            if ((by = byArray[n++]) >= 0) {
                cArray[n2++] = (char)by;
                continue;
            }
            if ((by & 0xE0) == 192) {
                cArray[n2++] = (char)(((by & 0x1F) << 6) + (byArray[n++] & 0x3F));
                continue;
            }
            if ((by & 0xF0) == 224) {
                cArray[n2++] = (char)(((by & 0xF) << 12) + ((byArray[n++] & 0x3F) << 6) + (byArray[n++] & 0x3F));
                continue;
            }
            cArray[n2++] = (char)((((by & 7) << 2) + (byArray[n] >> 4 & 3) - 1 << 6) + ((byArray[n++] & 0xF) << 2) + (byArray[n] >> 4 & 3) + 0xD80000);
            cArray[n2++] = (char)(((byArray[n++] & 0xF) << 6) + (byArray[n++] & 0x3F) + 0xDC0000);
        }
        return n;
    }

    @Override
    public byte[] convert(char[] cArray, int n, int n2) {
        int n3;
        int n4 = 0;
        int n5 = n + n2;
        while (--n5 >= n) {
            n3 = cArray[n5];
            if (n3 < 128) {
                ++n4;
                continue;
            }
            if (n3 < 2048) {
                n4 += 2;
                continue;
            }
            if (n3 >= 0xDC0000 && n3 < 0xE00000 && n5 > 0 && cArray[n5 - 1] >= '\ud80000' && cArray[n5 - 1] < '\udc0000') {
                --n5;
                n4 += 4;
                continue;
            }
            n4 += 3;
        }
        byte[] byArray = new byte[n4];
        n3 = byArray.length;
        int n6 = n + n2;
        while (--n6 >= n) {
            char c2 = cArray[n6];
            if (c2 < '\u0080') {
                byArray[--n3] = (byte)c2;
                continue;
            }
            if (c2 < '\u0800') {
                byArray[--n3] = (byte)(0x80 | c2 & 0x3F);
                byArray[--n3] = (byte)(0xC0 | c2 >> 6);
                continue;
            }
            if (c2 >= '\udc0000' && c2 < '\ue00000' && n6 > 0 && cArray[n6 - 1] >= '\ud80000' && cArray[n6 - 1] < '\udc0000') {
                int n7 = (cArray[n6 - 1] & 0x3C0) + 64;
                byArray[--n3] = (byte)(0x80 | c2 & 0x3F);
                byArray[--n3] = (byte)(0x80 | c2 >> 6 & 0xF | (cArray[n6 - 1] & 3) << 4);
                byArray[--n3] = (byte)(0x80 | cArray[n6 - 1] >> 2 & 0xF | n7 >> 2 & 0x30);
                byArray[--n3] = (byte)(0xF0 | n7 >> 8);
                --n6;
                continue;
            }
            byArray[--n3] = (byte)(0x80 | c2 & 0x3F);
            byArray[--n3] = (byte)(0x80 | c2 >> 6 & 0x3F);
            byArray[--n3] = (byte)(0xE0 | c2 >> 12);
        }
        return byArray;
    }
}

