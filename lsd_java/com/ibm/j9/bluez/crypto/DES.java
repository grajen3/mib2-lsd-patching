/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.j9.bluez.crypto;

import com.ibm.j9.bluez.crypto.CL3;
import com.ibm.j9.bluez.crypto.CL3Key;

public class DES {
    private static final int[] PC;
    private static final int[] SP0;
    private static final int[] SP1;

    static {
        int n;
        PC = new int[512];
        byte[] byArray = CL3.getBytes("\u0002\u0007\"\u0000X\u0014&\u0019\u0006H\u0002P\u0010(8\u0000\t\u0006\u0000\u0012\u0000$6\u0014\u0010\u0002\u00002\u000004\u0011\u000e\u0004\u0000!hP\u0018 \r@d\u0000PD\u0000\u0019\u0010\u0002\u00021@\u0010*\t\r\u0004@\u0010i\u0000\n\u000b");
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        do {
            byte by;
            if ((by = byArray[n4]) == 32) continue;
            n = 0;
            do {
                if ((1 << n2 & n) == 0) continue;
                int n5 = n3 + n;
                PC[n5] = PC[n5] | 1 << by;
            } while (++n < 64);
            if ((n2 = (n2 + 1) % 6) != 0) continue;
            n3 += 64;
        } while (++n4 < 56);
        SP0 = new int[256];
        SP1 = new int[256];
        byArray = CL3.getBytes("@\rs\u0014TY%\u001eK\u000b\"\tRYI95%2YW}\u0003\u0012\u0004A0\u0000\bI$(\u0000Q\u0014\u0002\u0002J\u0004D\u0012 (\u0000@Y\u0010!\u0016\u00020\u0001 \u0011-iC\u0007RX6(o\u007fA$\f\u0000`I\u0011\u0001P\u0005\u0000$4\u0006  \n\n\b(\f\u0000R\f\u0010A\u0004\u0011\u0010a@\u0004XSU\u0016.pe\u0007a@)\u0016K\u001as\u0016=&$Q\u0004V\rJ\u001bj\"gO\u0004\u0005\u0014l\u000emF[#(3\u0010)rEG\rpKc\u000e \u0000&J(mM\u0013\u00146Zd\u0000\u0004F\u001a-\u001d\u001cy&\u001cV\u0010\u000e8aqSI1%r`\u0015M9\u0014S4RFlh");
        byte[] byArray2 = CL3.getBytes("\u0001'%dK''$N\u0018d\t\u0012yGa4i\u0013GH\u0000\u0011K#G\u0016#'&fL\u0000\u0002\u000b\u0016\u001d\u000f\f\u001c\u001f9C\u0014\u0001c-\u0016RXpV\u001cxAG\u0014Z+)\fkRe\u007fP\t\u0018!\u000008\u0000B( \t\u0010\u0010\u0018#\u0010 ,\u0011A\u0002\u0012\t!\u0004\u0018\u0003 )\u0004\u0004\u0005]\u0014T^rFi-\u0002\bpYcltX\u0002k<\u0001R<lIK\u0016L9F\b\r\u001b\u0006_\u0013\u0018S\u001a.D\u0019,+\u00165\u0014\u0016fL\u007f|\u0001D\u0004\u0002H@BIB\b\u0001\n\u0002\u0004)!\u0004\f\u00004`!\u0006\fA\u0011\u0010`\u0012B\u0002\u0005\u0016<l\u0018N\u001ai5\u0014");
        int[] nArray = SP0;
        while (true) {
            n3 = 0;
            int n6 = 63;
            int n7 = 0;
            int n8 = 0;
            long l = 0L;
            n4 = 3;
            do {
                n = 0;
                do {
                    if (l == 0L) {
                        if ((n8 = byArray[n3++] & 0xFF) == 0) {
                            n += 64;
                            continue;
                        }
                        if (n8 == 255) {
                            n7 = 2;
                            continue;
                        }
                        l = 0L;
                        int n9 = 0;
                        do {
                            l <<= 8;
                            l |= (long)(byArray[n3++] & 0xFF);
                        } while (++n9 < 8);
                    }
                    if ((l & 1L << n6) != 0L) {
                        int n10 = n;
                        nArray[n10] = nArray[n10] | n8 << n4 * 8;
                    }
                    ++n;
                    if (--n6 >= 0) continue;
                    n6 = 63;
                    l = 0L;
                    if (n7 <= 0) continue;
                    --n7;
                    n -= 64;
                } while (n < 256);
            } while (--n4 >= 0);
            if (nArray != SP0) break;
            nArray = SP1;
            byArray = byArray2;
        }
    }

    public static CL3Key desKey(byte[] byArray, int n, int n2) {
        if (n2 <= 0) {
            n2 = -n2;
        }
        int[] nArray = PC;
        int[] nArray2 = new int[n2 == 8 ? 32 : 96];
        boolean bl = true;
        int n3 = 0;
        int n4 = 0;
        do {
            int n5 = CL3.lsbf4(byArray, n + n3);
            int n6 = CL3.lsbf4(byArray, n + n3 + 4);
            int n7 = (n6 >>> 4 ^ n5) & 0xF0F0F0F;
            n5 ^= n7;
            n6 ^= n7 << 4;
            n7 = (n5 << 18 ^ n5) & 0xCCCC;
            n5 ^= n7 ^ n7 >>> 18;
            n7 = (n6 << 18 ^ n6) & 0xCCCC;
            n6 ^= n7 ^ n7 >>> 18;
            n7 = (n6 >>> 1 ^ n5) & 0x55555555;
            n5 ^= n7;
            n6 ^= n7 << 1;
            n7 = (n5 >>> 8 ^ n6) & 0xFF00FF00;
            n6 ^= n7;
            n5 ^= n7 << 8;
            n7 = (n6 >>> 1 ^ n5) & 0x55555555;
            n6 ^= n7 << 1;
            n6 = n6 << 16 & 0xFF00 | n6 & 0xFF0000 | n6 >> 16 & 0xFF | (n5 ^= n7) >> 4 & 0xF;
            n5 &= 0xFFFFFF0F;
            do {
                int n8 = -1515542166 >> n4 & 3;
                n5 = (n5 >>> n8 | n5 << 28 - n8) & 0xFFFFFF0F;
                int n9 = nArray[n5 & 0x3F] | nArray[0x40 | n5 >> 6 & 3 | n5 >> 7 & 0x3C] | nArray[0x80 | n5 >> 13 & 0xF | n5 >> 14 & 0x30] | nArray[0xC0 | n5 >> 20 & 1 | n5 >> 21 & 6 | n5 >> 22 & 0x38];
                n6 = (n6 >>> n8 | n6 << 28 - n8) & 0xFFFFFF0F;
                n7 = nArray[0x100 | n6 & 0x3F] | nArray[0x140 | n6 >> 7 & 3 | n6 >> 8 & 0x3C] | nArray[0x180 | n6 >> 15 & 0x3F] | nArray[0x1C0 | n6 >> 21 & 0xF | n6 >> 22 & 0x30];
                nArray2[bl ? n4 : 94 - n4] = n7 << 16 | n9 & 0xFFFF0000;
                n9 = n9 >>> 16 | n7 & 0xFFFF;
                nArray2[bl ? n4 + 1 : 95 - n4] = n9 << 4 | n9 >>> 28;
            } while (((n4 += 2) & 0x1F) != 0);
            bl ^= true;
            n3 = (n3 + 8) % n2;
        } while (n4 < nArray2.length);
        return new CL3Key(nArray2, 32);
    }

    public static void des(CL3Key cL3Key, int n, byte[] byArray, int n2, byte[] byArray2, int n3, byte[] byArray3, int n4, int n5) {
        int[] nArray = SP0;
        int[] nArray2 = SP1;
        int[] nArray3 = (int[])cL3Key.obj;
        int n6 = 0;
        int n7 = 0;
        int n8 = 0;
        int n9 = 0;
        int n10 = nArray3.length;
        if (byArray != null) {
            n6 = CL3.lsbf4(byArray, n2 + 0);
            n7 = CL3.lsbf4(byArray, n2 + 4);
        }
        n5 += n3;
        while (n3 < n5) {
            int n11;
            int n12;
            int n13;
            int n14 = CL3.lsbf4(byArray2, n3);
            int n15 = CL3.lsbf4(byArray2, n3 + 4);
            n3 += 8;
            if (byArray != null) {
                if (n == 0) {
                    n14 ^= n6;
                    n15 ^= n7;
                } else {
                    n8 = n14;
                    n9 = n15;
                }
            }
            int n16 = (n15 >>> 4 ^ n14) & 0xF0F0F0F;
            n14 ^= n16;
            n15 ^= n16 << 4;
            n16 = (n14 >>> 16 ^ n15) & 0xFFFF0000;
            n15 ^= n16;
            n14 ^= n16 << 16;
            n16 = (n15 >>> 2 ^ n14) & 0x33333333;
            n14 ^= n16;
            n15 ^= n16 << 2;
            n16 = (n14 >>> 8 ^ n15) & 0xFF00FF00;
            n15 ^= n16;
            n14 ^= n16 << 8;
            n16 = (n15 >>> 1 ^ n14) & 0x55555555;
            int n17 = (n15 ^= n16 << 1) << 1 | n15 >>> 31;
            n15 = (n14 ^= n16) << 1 | n14 >>> 31;
            if (n == 0) {
                n13 = 32;
                n12 = 0;
                n11 = 2;
            } else {
                n11 = -2;
                n12 = n10 + -2;
                n13 = n12 - 32;
            }
            while (true) {
                n14 = n17;
                do {
                    n16 = n15 ^ nArray3[n12 + 1];
                    n16 = n16 >>> 4 | n16 << 28 | 0x40C040C0;
                    n17 = n15 ^ nArray3[n12] | 0x800080;
                    n14 ^= nArray[n16 & 0x7F] | nArray[n16 >>> 8 & 0xFF] | nArray2[n16 >>> 16 & 0x7F] | nArray2[n16 >>> 24] | nArray[n17 & 0x3F] | nArray[n17 >>> 8 & 0xBF] | nArray2[n17 >>> 16 & 0x3F] | nArray2[n17 >>> 24 & 0xBF];
                    n16 = n14 ^ nArray3[(n12 += n11) + 1];
                    n16 = n16 >>> 4 | n16 << 28 | 0x40C040C0;
                    n17 = n14 ^ nArray3[n12] | 0x800080;
                    n15 ^= nArray[n16 & 0x7F] | nArray[n16 >>> 8 & 0xFF] | nArray2[n16 >>> 16 & 0x7F] | nArray2[n16 >>> 24] | nArray[n17 & 0x3F] | nArray[n17 >>> 8 & 0xBF] | nArray2[n17 >>> 16 & 0x3F] | nArray2[n17 >>> 24 & 0xBF];
                } while ((n12 += n11) != n13);
                if ((n13 += 16 * n11) < -4 || n13 > n10) break;
                n17 = n15;
                n15 = n14;
            }
            n14 = n14 >>> 1 | n14 << 31;
            n15 = n15 >>> 1 | n15 << 31;
            n16 = (n15 >>> 1 ^ n14) & 0x55555555;
            n14 ^= n16;
            n15 ^= n16 << 1;
            n16 = (n14 >>> 8 ^ n15) & 0xFF00FF00;
            n15 ^= n16;
            n14 ^= n16 << 8;
            n16 = (n15 >>> 2 ^ n14) & 0x33333333;
            n14 ^= n16;
            n15 ^= n16 << 2;
            n16 = (n14 >>> 16 ^ n15) & 0xFFFF0000;
            n15 ^= n16;
            n14 ^= n16 << 16;
            n16 = (n15 >>> 4 ^ n14) & 0xF0F0F0F;
            n14 ^= n16;
            n15 ^= n16 << 4;
            if (byArray != null) {
                if (n == 0) {
                    n6 = n14;
                    n7 = n15;
                } else {
                    n14 ^= n6;
                    n15 ^= n7;
                    n6 = n8;
                    n7 = n9;
                }
            }
            if (byArray3 == null) continue;
            CL3.lsbf4(n14, byArray3, n4);
            CL3.lsbf4(n15, byArray3, n4 + 4);
            n4 += 8;
        }
        if (byArray != null) {
            CL3.lsbf4(n6, byArray, n2 + 0);
            CL3.lsbf4(n7, byArray, n2 + 4);
        }
    }
}

