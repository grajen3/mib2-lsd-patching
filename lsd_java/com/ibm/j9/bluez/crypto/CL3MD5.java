/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.j9.bluez.crypto;

public class CL3MD5 {
    protected int type;
    protected Object obj;

    protected CL3MD5(Object object, int n) {
        this.obj = object;
        this.type = n;
    }

    public static CL3MD5 md5Init(CL3MD5 cL3MD5) {
        int[] nArray;
        if (cL3MD5 == null) {
            nArray = new int[21];
            cL3MD5 = new CL3MD5(nArray, 17);
        } else {
            nArray = (int[])cL3MD5.obj;
        }
        nArray[0] = 19088743;
        nArray[1] = -1985229329;
        nArray[2] = -19088744;
        nArray[3] = 1985229328;
        nArray[4] = 0;
        return cL3MD5;
    }

    public static CL3MD5 md5CopyState(CL3MD5 cL3MD5) {
        CL3MD5 cL3MD52 = new CL3MD5(new int[21], 17);
        int[] nArray = (int[])cL3MD52.obj;
        int[] nArray2 = (int[])cL3MD5.obj;
        System.arraycopy((Object)nArray2, 0, (Object)nArray, 0, nArray2.length);
        return cL3MD52;
    }

    public static void md5(CL3MD5 cL3MD5, byte[] byArray, int n, int n2, byte[] byArray2, int n3) {
        int n4;
        int n5;
        int n6;
        int n7;
        int[] nArray;
        int[] nArray2 = null;
        int n8 = 0;
        int n9 = n2;
        int n10 = n;
        int n11 = 0;
        boolean bl = false;
        boolean bl2 = false;
        if (cL3MD5 != null) {
            nArray2 = (int[])cL3MD5.obj;
            nArray = nArray2;
            n7 = nArray2[0];
            n6 = nArray2[1];
            n5 = nArray2[2];
            n4 = nArray2[3];
            n11 = nArray2[4] % 4;
            n8 = 5 + nArray2[4] / 4 % 16;
            n2 += nArray2[4];
        } else {
            nArray = new int[21];
            n7 = 19088743;
            n6 = -1985229329;
            n5 = -19088744;
            n4 = 1985229328;
            n8 = 5;
        }
        do {
            int n12;
            int n13;
            if (n9 > 0 && n11 != 0) {
                n13 = n9 < 4 - n11 ? n9 : 4 - n11;
                int n14 = CL3MD5.lsbf(byArray, n, n13);
                nArray[n8] = nArray[n8] | (n14 <<= 8 * n11);
                if (n13 + n11 == 4) {
                    ++n8;
                }
                n += n13;
                n11 = 0;
            }
            while (n8 < 21 && n <= n10 + n9 - 4) {
                nArray[n8++] = CL3MD5.lsbf4(byArray, n);
                n += 4;
            }
            if (n8 < 21) {
                n13 = n10 + n9 - n;
                if (byArray2 == null) {
                    if (n13 == 0) break;
                    nArray[n8++] = CL3MD5.lsbf(byArray, n, n13);
                    break;
                }
                if (!bl2) {
                    if (n9 > 0) {
                        n12 = n2 % 4;
                        nArray[n8++] = n12 != 0 ? CL3MD5.lsbf(byArray, n, n12) | 128 << n12 * 8 : 128;
                    } else {
                        n12 = n2 % 4;
                        nArray[n8] = n12 != 0 ? nArray[n8] | 128 << n12 * 8 : 128;
                        ++n8;
                    }
                    if (n8 == 20) {
                        nArray[20] = 0;
                    }
                    bl2 = true;
                }
                if (n8 <= 19) {
                    while (n8 < 19) {
                        nArray[n8++] = 0;
                    }
                    nArray[19] = n2 << 3;
                    nArray[20] = n2 >>> 29;
                    bl = true;
                }
            }
            n12 = n7;
            int n15 = n4;
            int n16 = n5;
            int n17 = n6;
            int n18 = nArray[5];
            n7 += ((n5 ^ n4) & n6 ^ n4) + n18 + 2024041175;
            n7 = (n7 << 7 | n7 >>> 25) + n6;
            int n19 = nArray[6];
            n4 += ((n6 ^ n5) & n7 ^ n5) + n19 + 1454884840;
            n4 = (n4 << 12 | n4 >>> 20) + n7;
            int n20 = nArray[7];
            n5 += ((n7 ^ n6) & n4 ^ n6) + n20 + -613408732;
            n5 = (n5 << 17 | n5 >>> 15) + n4;
            int n21 = nArray[8];
            n6 += ((n4 ^ n7) & n5 ^ n7) + n21 + -288440895;
            n6 = (n6 << 22 | n6 >>> 10) + n5;
            int n22 = nArray[9];
            n7 += ((n5 ^ n4) & n6 ^ n4) + n22 + -1357939467;
            n7 = (n7 << 7 | n7 >>> 25) + n6;
            int n23 = nArray[10];
            n4 += ((n6 ^ n5) & n7 ^ n5) + n23 + 717653831;
            n4 = (n4 << 12 | n4 >>> 20) + n7;
            int n24 = nArray[11];
            n5 += ((n7 ^ n6) & n4 ^ n6) + n24 + 323367080;
            n5 = (n5 << 17 | n5 >>> 15) + n4;
            int n25 = nArray[12];
            n6 += ((n4 ^ n7) & n5 ^ n7) + n25 + 26560253;
            n6 = (n6 << 22 | n6 >>> 10) + n5;
            int n26 = nArray[13];
            n7 += ((n5 ^ n4) & n6 ^ n4) + n26 + -661094295;
            n7 = (n7 << 7 | n7 >>> 25) + n6;
            int n27 = nArray[14];
            n4 += ((n6 ^ n5) & n7 ^ n5) + n27 + -1342749557;
            n4 = (n4 << 12 | n4 >>> 20) + n7;
            int n28 = nArray[15];
            n5 += ((n7 ^ n6) & n4 ^ n6) + n28 + -1319370753;
            n5 = (n5 << 17 | n5 >>> 15) + n4;
            int n29 = nArray[16];
            n6 += ((n4 ^ n7) & n5 ^ n7) + n29 + -1093182327;
            n6 = (n6 << 22 | n6 >>> 10) + n5;
            int n30 = nArray[17];
            n7 += ((n5 ^ n4) & n6 ^ n4) + n30 + 571576427;
            n7 = (n7 << 7 | n7 >>> 25) + n6;
            int n31 = nArray[18];
            n4 += ((n6 ^ n5) & n7 ^ n5) + n31 + -1821271811;
            n4 = (n4 << 12 | n4 >>> 20) + n7;
            int n32 = nArray[19];
            n5 += ((n7 ^ n6) & n4 ^ n6) + n32 + -1908180570;
            n5 = (n5 << 17 | n5 >>> 15) + n4;
            int n33 = nArray[20];
            n6 += ((n4 ^ n7) & n5 ^ n7) + n33 + 554218569;
            n6 = (n6 << 22 | n6 >>> 10) + n5;
            n7 += ((n6 ^ n5) & n4 ^ n5) + n19 + 1646599926;
            n7 = (n7 << 5 | n7 >>> 27) + n6;
            n4 += ((n7 ^ n6) & n5 ^ n6) + n24 + 1085489344;
            n4 = (n4 << 9 | n4 >>> 23) + n7;
            n5 += ((n4 ^ n7) & n6 ^ n7) + n29 + 1364876838;
            n5 = (n5 << 14 | n5 >>> 18) + n4;
            n6 += ((n5 ^ n4) & n7 ^ n4) + n18 + -1429752087;
            n6 = (n6 << 20 | n6 >>> 12) + n5;
            n7 += ((n6 ^ n5) & n4 ^ n5) + n23 + 1561341910;
            n7 = (n7 << 5 | n7 >>> 27) + n6;
            n4 += ((n7 ^ n6) & n5 ^ n6) + n28 + 1393837058;
            n4 = (n4 << 9 | n4 >>> 23) + n7;
            n5 += ((n4 ^ n7) & n6 ^ n7) + n33 + -2115591720;
            n5 = (n5 << 14 | n5 >>> 18) + n4;
            n6 += ((n5 ^ n4) & n7 ^ n4) + n22 + -923020313;
            n6 = (n6 << 20 | n6 >>> 12) + n5;
            n7 += ((n6 ^ n5) & n4 ^ n5) + n27 + -422715103;
            n7 = (n7 << 5 | n7 >>> 27) + n6;
            n4 += ((n7 ^ n6) & n5 ^ n6) + n32 + -704170045;
            n4 = (n4 << 9 | n4 >>> 23) + n7;
            n5 += ((n4 ^ n7) & n6 ^ n7) + n21 + -2029136396;
            n5 = (n5 << 14 | n5 >>> 18) + n4;
            n6 += ((n5 ^ n4) & n7 ^ n4) + n26 + -317433275;
            n6 = (n6 << 20 | n6 >>> 12) + n5;
            n7 += ((n6 ^ n5) & n4 ^ n5) + n31 + 99214249;
            n7 = (n7 << 5 | n7 >>> 27) + n6;
            n4 += ((n7 ^ n6) & n5 ^ n6) + n20 + -123473924;
            n4 = (n4 << 9 | n4 >>> 23) + n7;
            n5 += ((n4 ^ n7) & n6 ^ n7) + n25 + -654151833;
            n5 = (n5 << 14 | n5 >>> 18) + n4;
            n6 += ((n5 ^ n4) & n7 ^ n4) + n30 + -1974719859;
            n6 = (n6 << 20 | n6 >>> 12) + n5;
            n7 += (n6 ^ n5 ^ n4) + n23 + 1111096063;
            n7 = (n7 << 4 | n7 >>> 28) + n6;
            n4 += (n7 ^ n6 ^ n5) + n26 + -2114555513;
            n4 = (n4 << 11 | n4 >>> 21) + n7;
            n5 += (n4 ^ n7 ^ n6) + n29 + 576822637;
            n5 = (n5 << 16 | n5 >>> 16) + n4;
            n6 += (n5 ^ n4 ^ n7) + n32 + 205055485;
            n6 = (n6 << 23 | n6 >>> 9) + n5;
            n7 += (n6 ^ n5 ^ n4) + n19 + 1156234916;
            n7 = (n7 << 4 | n7 >>> 28) + n6;
            n4 += (n7 ^ n6 ^ n5) + n22 + -1445994933;
            n4 = (n4 << 11 | n4 >>> 21) + n7;
            n5 += (n4 ^ n7 ^ n6) + n25 + 1615576054;
            n5 = (n5 << 16 | n5 >>> 16) + n4;
            n6 += (n5 ^ n4 ^ n7) + n28 + 1891418046;
            n6 = (n6 << 23 | n6 >>> 9) + n5;
            n7 += (n6 ^ n5 ^ n4) + n31 + -964781272;
            n7 = (n7 << 4 | n7 >>> 28) + n6;
            n4 += (n7 ^ n6 ^ n5) + n18 + -98065942;
            n4 = (n4 << 11 | n4 >>> 21) + n7;
            n5 += (n4 ^ n7 ^ n6) + n21 + -2060390444;
            n5 = (n5 << 16 | n5 >>> 16) + n4;
            n6 += (n5 ^ n4 ^ n7) + n24 + 85821444;
            n6 = (n6 << 23 | n6 >>> 9) + n5;
            n7 += (n6 ^ n5 ^ n4) + n27 + 969987289;
            n7 = (n7 << 4 | n7 >>> 28) + n6;
            n4 += (n7 ^ n6 ^ n5) + n30 + -442901530;
            n4 = (n4 << 11 | n4 >>> 21) + n7;
            n5 += (n4 ^ n7 ^ n6) + n33 + -126049761;
            n5 = (n5 << 16 | n5 >>> 16) + n4;
            n6 += (n5 ^ n4 ^ n7) + n20 + 1700179140;
            n6 = (n6 << 23 | n6 >>> 9) + n5;
            n7 += (n5 ^ (n6 | ~n4)) + n18 + 1143089652;
            n7 = (n7 << 6 | n7 >>> 26) + n6;
            n4 += (n6 ^ (n7 | ~n5)) + n25 + -1744885181;
            n4 = (n4 << 10 | n4 >>> 22) + n7;
            n5 += (n7 ^ (n4 | ~n6)) + n32 + -1490840405;
            n5 = (n5 << 15 | n5 >>> 17) + n4;
            n6 += (n4 ^ (n5 | ~n7)) + n23 + 966824956;
            n6 = (n6 << 21 | n6 >>> 11) + n5;
            n7 += (n5 ^ (n6 | ~n4)) + n30 + -1017554075;
            n7 = (n7 << 6 | n7 >>> 26) + n6;
            n4 += (n6 ^ (n7 | ~n5)) + n21 + -1832121201;
            n4 = (n4 << 10 | n4 >>> 22) + n7;
            n5 += (n7 ^ (n4 | ~n6)) + n28 + 2113204223;
            n5 = (n5 << 15 | n5 >>> 17) + n4;
            n6 += (n4 ^ (n5 | ~n7)) + n19 + -782400379;
            n6 = (n6 << 21 | n6 >>> 11) + n5;
            n7 += (n5 ^ (n6 | ~n4)) + n26 + 1333700719;
            n7 = (n7 << 6 | n7 >>> 26) + n6;
            n4 += (n6 ^ (n7 | ~n5)) + n33 + -521786114;
            n4 = (n4 << 10 | n4 >>> 22) + n7;
            n5 += (n7 ^ (n4 | ~n6)) + n24 + 339935651;
            n5 = (n5 << 15 | n5 >>> 17) + n4;
            n6 += (n4 ^ (n5 | ~n7)) + n31 + -1592719282;
            n6 = (n6 << 21 | n6 >>> 11) + n5;
            n7 += (n5 ^ (n6 | ~n4)) + n22 + -2105650185;
            n7 = (n7 << 6 | n7 >>> 26) + n6;
            n4 += (n6 ^ (n7 | ~n5)) + n29 + 905067197;
            n4 = (n4 << 10 | n4 >>> 22) + n7;
            n5 += (n7 ^ (n4 | ~n6)) + n20 + -1143810262;
            n5 = (n5 << 15 | n5 >>> 17) + n4;
            n6 += (n4 ^ (n5 | ~n7)) + n27 + -1848408341;
            n6 = (n6 << 21 | n6 >>> 11) + n5;
            n7 += n12;
            n6 += n17;
            n5 += n16;
            n4 += n15;
            n8 = 5;
        } while (!bl);
        if (byArray2 == null) {
            nArray2[0] = n7;
            nArray2[1] = n6;
            nArray2[2] = n5;
            nArray2[3] = n4;
            nArray2[4] = n2;
        } else {
            CL3MD5.lsbf4(n7, byArray2, n3);
            CL3MD5.lsbf4(n6, byArray2, n3 + 4);
            CL3MD5.lsbf4(n5, byArray2, n3 + 8);
            CL3MD5.lsbf4(n4, byArray2, n3 + 12);
        }
    }

    static final int lsbf4(byte[] byArray, int n) {
        return byArray[n] & 0xFF | (byArray[n + 1] & 0xFF) << 8 | (byArray[n + 2] & 0xFF) << 16 | byArray[n + 3] << 24;
    }

    static final void lsbf4(int n, byte[] byArray, int n2) {
        byArray[n2] = (byte)n;
        byArray[n2 + 1] = (byte)(n >>> 8);
        byArray[n2 + 2] = (byte)(n >>> 16);
        byArray[n2 + 3] = (byte)(n >>> 24);
    }

    static final int lsbf(byte[] byArray, int n, int n2) {
        int n3 = 0;
        do {
            n3 |= (byArray[n + --n2] & 0xFF) << n2 * 8;
        } while (n2 > 0);
        return n3;
    }
}

