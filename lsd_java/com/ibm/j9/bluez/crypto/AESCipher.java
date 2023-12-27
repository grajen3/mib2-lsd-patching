/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.j9.bluez.crypto;

import com.ibm.j9.bluez.crypto.CL3;
import com.ibm.j9.bluez.crypto.CL3Exception;
import com.ibm.j9.bluez.crypto.CL3Key;

public class AESCipher {
    static final int[] AES_S;
    static final int[] AES_Si;
    static final byte[] AES_RCON;
    static final int[] AES_T1234;
    static final int[] AES_D1234;

    static {
        int n;
        AES_S = new int[256];
        AES_Si = new int[256];
        AES_RCON = new byte[30];
        AES_T1234 = new int[1024];
        AES_D1234 = new int[1024];
        int[] nArray = new int[256];
        int[] nArray2 = new int[256];
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        nArray[0] = 1;
        int n5 = 1;
        while (++n4 < 256) {
            if ((n5 ^= n5 << 1) >= 256) {
                n5 ^= 0x11B;
            }
            nArray[n4] = n5;
            nArray2[nArray[n4]] = n4;
        }
        nArray2[1] = 0;
        n4 = 0;
        while (n4 < 256) {
            n2 = 99;
            n3 = 248;
            int n6 = 128;
            n = 0;
            while (n < 8) {
                int n7 = n3 & (n4 <= 1 ? n4 : nArray[255 - nArray2[n4]]);
                while (n7 > 0) {
                    n2 ^= (n7 & 1) * n6;
                    n7 >>>= 1;
                }
                n3 = n3 >>> 1 | (n3 & 1) << 7;
                n6 >>>= 1;
                ++n;
            }
            AESCipher.AES_S[n4] = (short)n2;
            AESCipher.AES_Si[n2] = (short)n4;
            ++n4;
        }
        n4 = 0;
        while (n4 < 256) {
            n = 0;
            while (n < 8) {
                if (n % 4 == 0) {
                    if (n == 0) {
                        n5 = AES_S[n4];
                        n2 = 50397442;
                    } else {
                        n5 = AES_Si[n4];
                        n2 = 185403662;
                    }
                    n3 = nArray2[n5];
                }
                (n <= 3 ? AESCipher.AES_T1234 : AESCipher.AES_D1234)[(n & 3) * 256 + n4] = n5 == 0 ? 0 : nArray[(n3 + nArray2[n2 >>> 24]) % 255] << 24 | nArray[(n3 + nArray2[n2 >>> 16 & 0xFF]) % 255] << 16 | nArray[(n3 + nArray2[n2 >>> 8 & 0xFF]) % 255] << 8 | nArray[(n3 + nArray2[n2 & 0xFF]) % 255];
                n2 = n2 >>> 8 | n2 << 24;
                ++n;
            }
            ++n4;
        }
        AESCipher.AES_RCON[0] = 1;
        n5 = 1;
        n4 = 1;
        while (n4 < 30) {
            AESCipher.AES_RCON[n4++] = (byte)((n5 <<= 1) >= 256 ? (n5 = n5 ^ 0x11B) : n5);
        }
    }

    public static CL3Key aesKey(byte[] byArray, int n, int n2, int n3) {
        int n4;
        if (n3 != 16 && n3 != 24 && n3 != 32 || n2 != 16 && n2 != 24 && n2 != 32) {
            throw new CL3Exception(0x3000080);
        }
        int n5 = n2 / 4;
        int n6 = n4 * (((n4 = n3 / 4) > n5 ? n4 : n5) + 7);
        int[] nArray = new int[2 * n6 + 1];
        nArray[nArray.length - 1] = n3;
        int n7 = 0;
        while (n7 < n5) {
            nArray[n7] = CL3.msbf4(byArray, n + n7 * 4);
            ++n7;
        }
        int n8 = nArray[n7 - 1];
        n7 = n5;
        while (n7 < n6) {
            if (n7 % n5 == 0) {
                n8 = AES_S[n8 >>> 16 & 0xFF] << 24 ^ AES_S[n8 >>> 8 & 0xFF] << 16 ^ AES_S[n8 & 0xFF] << 8 ^ AES_S[n8 >>> 24] ^ AES_RCON[(n7 - n5) / n5] << 24;
            } else if (n5 > 6 && n7 % n5 == 4) {
                n8 = AES_S[n8 >>> 24] << 24 ^ AES_S[n8 >>> 16 & 0xFF] << 16 ^ AES_S[n8 >>> 8 & 0xFF] << 8 ^ AES_S[n8 & 0xFF];
            }
            nArray[n7] = n8 ^= nArray[n7 - n5];
            ++n7;
        }
        n8 = 0;
        while (--n7 >= 0) {
            int n9 = nArray[n7];
            nArray[n6 + n8] = n8 < n4 || n7 < n4 ? n9 : AES_D1234[AES_S[n9 >>> 24]] ^ AES_D1234[256 + AES_S[n9 >>> 16 & 0xFF]] ^ AES_D1234[512 + AES_S[n9 >>> 8 & 0xFF]] ^ AES_D1234[768 + AES_S[n9 & 0xFF]];
            ++n8;
        }
        return new CL3Key(nArray, 33);
    }

    public static void aes(CL3Key cL3Key, int n, byte[] byArray, int n2, byte[] byArray2, int n3, byte[] byArray3, int n4, int n5) {
        int n6;
        int n7;
        int n8;
        int n9;
        int n10;
        int n11;
        int n12;
        int n13;
        int n14;
        int[] nArray;
        int[] nArray2;
        int n15;
        int n16;
        int[] nArray3 = (int[])cL3Key.obj;
        int n17 = nArray3.length - 1;
        int n18 = nArray3[n17];
        if (n5 % n18 != 0) {
            throw new CL3Exception(0x3000080);
        }
        if (n == 0) {
            n16 = 0;
            n15 = n17 / 2 - n18;
            nArray2 = AES_S;
            nArray = AES_T1234;
            n14 = n2;
            n13 = 4;
            n12 = 8;
            n11 = 12;
            n10 = 16;
            n9 = 20;
            n8 = 24;
            n7 = 28;
            n6 = n17 / 2 - n18 / 4;
        } else {
            n16 = n17 / 2;
            n15 = n17 - n18;
            nArray2 = AES_Si;
            nArray = AES_D1234;
            n14 = n18 - 4;
            n3 += n14;
            n4 += n14;
            n14 += n2;
            n13 = -4;
            n12 = -8;
            n11 = -12;
            n10 = -16;
            n9 = -20;
            n8 = -24;
            n7 = -28;
            n6 = n17 - n18 / 4;
        }
        int n19 = 0;
        int n20 = 0;
        int n21 = 0;
        int n22 = 0;
        int n23 = 0;
        int n24 = 0;
        int n25 = 0;
        int n26 = 0;
        int n27 = 0;
        int n28 = 0;
        int n29 = 0;
        int n30 = 0;
        int n31 = 0;
        int n32 = 0;
        int n33 = 0;
        int n34 = 0;
        if (byArray != null) {
            n26 = CL3.msbf4(byArray, n14);
            n25 = CL3.msbf4(byArray, n14 + n13);
            n24 = CL3.msbf4(byArray, n14 + n12);
            n23 = CL3.msbf4(byArray, n14 + n11);
            if (n18 > 16) {
                n34 = CL3.msbf4(byArray, n14 + n10);
                n33 = CL3.msbf4(byArray, n14 + n9);
                if (n18 > 24) {
                    n32 = CL3.msbf4(byArray, n14 + n8);
                    n31 = CL3.msbf4(byArray, n14 + n7);
                }
            }
        }
        int n35 = 0;
        int n36 = 0;
        int n37 = 0;
        int n38 = 0;
        int n39 = 0;
        int n40 = 0;
        int n41 = 0;
        int n42 = 0;
        n5 += n3;
        while (n3 < n5) {
            int n43;
            int n44;
            int n45;
            int n46;
            int n47 = CL3.msbf4(byArray2, n3);
            int n48 = CL3.msbf4(byArray2, n3 + n13);
            int n49 = CL3.msbf4(byArray2, n3 + n12);
            int n50 = CL3.msbf4(byArray2, n3 + n11);
            if (n18 > 16) {
                n42 = CL3.msbf4(byArray2, n3 + n10);
                n41 = CL3.msbf4(byArray2, n3 + n9);
                if (n18 > 24) {
                    n40 = CL3.msbf4(byArray2, n3 + n8);
                    n39 = CL3.msbf4(byArray2, n3 + n7);
                }
            }
            n3 += n18;
            if (byArray != null) {
                if (n == 0) {
                    n47 ^= n26;
                    n48 ^= n25;
                    n49 ^= n24;
                    n50 ^= n23;
                    if (n18 > 16) {
                        n42 ^= n34;
                        n41 ^= n33;
                        n40 ^= n32;
                        n39 ^= n31;
                    }
                } else {
                    n22 = n26;
                    n21 = n25;
                    n20 = n24;
                    n19 = n23;
                    n26 = n47;
                    n25 = n48;
                    n24 = n49;
                    n23 = n50;
                    if (n18 > 16) {
                        n30 = n34;
                        n29 = n33;
                        n28 = n32;
                        n27 = n31;
                        n34 = n42;
                        n33 = n41;
                        n32 = n40;
                        n31 = n39;
                    }
                }
            }
            n17 = n16;
            if (n18 == 16) {
                n47 ^= nArray3[n17];
                n48 ^= nArray3[n17 + 1];
                n49 ^= nArray3[n17 + 2];
                n50 ^= nArray3[n17 + 3];
                do {
                    n46 = nArray3[n17 + 5];
                    n45 = nArray3[n17 + 6];
                    n44 = nArray3[n17 + 7];
                    n43 = nArray3[n17 + 4];
                    n46 ^= nArray[768 + (n47 & 0xFF)];
                    n45 ^= nArray[512 + (n47 >>> 8 & 0xFF)];
                    n44 ^= nArray[256 + (n47 >>> 16 & 0xFF)];
                    n43 ^= nArray[n47 >>> 24];
                    n45 ^= nArray[768 + (n48 & 0xFF)];
                    n44 ^= nArray[512 + (n48 >>> 8 & 0xFF)];
                    n43 ^= nArray[256 + (n48 >>> 16 & 0xFF)];
                    n46 ^= nArray[n48 >>> 24];
                    n44 ^= nArray[768 + (n49 & 0xFF)];
                    n43 ^= nArray[512 + (n49 >>> 8 & 0xFF)];
                    n46 ^= nArray[256 + (n49 >>> 16 & 0xFF)];
                    n45 ^= nArray[n49 >>> 24];
                    n43 ^= nArray[768 + (n50 & 0xFF)];
                    n46 ^= nArray[512 + (n50 >>> 8 & 0xFF)];
                    n45 ^= nArray[256 + (n50 >>> 16 & 0xFF)];
                    n44 ^= nArray[n50 >>> 24];
                    n48 = nArray3[n17 + 9];
                    n49 = nArray3[n17 + 10];
                    n50 = nArray3[n17 + 11];
                    n47 = nArray3[n17 + 8];
                    n48 ^= nArray[768 + (n43 & 0xFF)];
                    n49 ^= nArray[512 + (n43 >>> 8 & 0xFF)];
                    n50 ^= nArray[256 + (n43 >>> 16 & 0xFF)];
                    n47 ^= nArray[n43 >>> 24];
                    n49 ^= nArray[768 + (n46 & 0xFF)];
                    n50 ^= nArray[512 + (n46 >>> 8 & 0xFF)];
                    n47 ^= nArray[256 + (n46 >>> 16 & 0xFF)];
                    n48 ^= nArray[n46 >>> 24];
                    n50 ^= nArray[768 + (n45 & 0xFF)];
                    n47 ^= nArray[512 + (n45 >>> 8 & 0xFF)];
                    n48 ^= nArray[256 + (n45 >>> 16 & 0xFF)];
                    n49 ^= nArray[n45 >>> 24];
                    n47 ^= nArray[768 + (n44 & 0xFF)];
                    n48 ^= nArray[512 + (n44 >>> 8 & 0xFF)];
                    n49 ^= nArray[256 + (n44 >>> 16 & 0xFF)];
                    n50 ^= nArray[n44 >>> 24];
                } while ((n17 += 8) < n15);
                n46 = nArray3[n17 + 5];
                n45 = nArray3[n17 + 6];
                n44 = nArray3[n17 + 7];
                n43 = nArray3[n17 + 4];
                n46 ^= nArray[768 + (n47 & 0xFF)];
                n45 ^= nArray[512 + (n47 >>> 8 & 0xFF)];
                n44 ^= nArray[256 + (n47 >>> 16 & 0xFF)];
                n43 ^= nArray[n47 >>> 24];
                n45 ^= nArray[768 + (n48 & 0xFF)];
                n44 ^= nArray[512 + (n48 >>> 8 & 0xFF)];
                n43 ^= nArray[256 + (n48 >>> 16 & 0xFF)];
                n46 ^= nArray[n48 >>> 24];
                n44 ^= nArray[768 + (n49 & 0xFF)];
                n43 ^= nArray[512 + (n49 >>> 8 & 0xFF)];
                n46 ^= nArray[256 + (n49 >>> 16 & 0xFF)];
                n45 ^= nArray[n49 >>> 24];
                n47 = nArray2[(n43 ^= nArray[768 + (n50 & 0xFF)]) >>> 24] << 24 ^ nArray2[(n46 ^= nArray[512 + (n50 >>> 8 & 0xFF)]) >>> 16 & 0xFF] << 16 ^ nArray2[(n45 ^= nArray[256 + (n50 >>> 16 & 0xFF)]) >>> 8 & 0xFF] << 8 ^ nArray2[(n44 ^= nArray[n50 >>> 24]) & 0xFF] ^ nArray3[n17 + 8];
                n48 = nArray2[n46 >>> 24] << 24 ^ nArray2[n45 >>> 16 & 0xFF] << 16 ^ nArray2[n44 >>> 8 & 0xFF] << 8 ^ nArray2[n43 & 0xFF] ^ nArray3[n17 + 9];
                n49 = nArray2[n45 >>> 24] << 24 ^ nArray2[n44 >>> 16 & 0xFF] << 16 ^ nArray2[n43 >>> 8 & 0xFF] << 8 ^ nArray2[n46 & 0xFF] ^ nArray3[n17 + 10];
                n50 = nArray2[n44 >>> 24] << 24 ^ nArray2[n43 >>> 16 & 0xFF] << 16 ^ nArray2[n46 >>> 8 & 0xFF] << 8 ^ nArray2[n45 & 0xFF] ^ nArray3[n17 + 11];
            } else if (n18 == 24) {
                while (true) {
                    n43 = n47 ^ nArray3[n17];
                    n46 = n48 ^ nArray3[n17 + 1];
                    n45 = n49 ^ nArray3[n17 + 2];
                    n44 = n50 ^ nArray3[n17 + 3];
                    n38 = n42 ^ nArray3[n17 + 4];
                    n37 = n41 ^ nArray3[(n17 += 6) - 1];
                    if (n17 == n6) break;
                    n47 = nArray[n43 >>> 24] ^ nArray[256 + (n46 >>> 16 & 0xFF)] ^ nArray[512 + (n45 >>> 8 & 0xFF)] ^ nArray[768 + (n44 & 0xFF)];
                    n48 = nArray[n46 >>> 24] ^ nArray[256 + (n45 >>> 16 & 0xFF)] ^ nArray[512 + (n44 >>> 8 & 0xFF)] ^ nArray[768 + (n38 & 0xFF)];
                    n49 = nArray[n45 >>> 24] ^ nArray[256 + (n44 >>> 16 & 0xFF)] ^ nArray[512 + (n38 >>> 8 & 0xFF)] ^ nArray[768 + (n37 & 0xFF)];
                    n50 = nArray[n44 >>> 24] ^ nArray[256 + (n38 >>> 16 & 0xFF)] ^ nArray[512 + (n37 >>> 8 & 0xFF)] ^ nArray[768 + (n43 & 0xFF)];
                    n42 = nArray[n38 >>> 24] ^ nArray[256 + (n37 >>> 16 & 0xFF)] ^ nArray[512 + (n43 >>> 8 & 0xFF)] ^ nArray[768 + (n46 & 0xFF)];
                    n41 = nArray[n37 >>> 24] ^ nArray[256 + (n43 >>> 16 & 0xFF)] ^ nArray[512 + (n46 >>> 8 & 0xFF)] ^ nArray[768 + (n45 & 0xFF)];
                }
                n47 = nArray2[n43 >>> 24] << 24 ^ nArray2[n46 >>> 16 & 0xFF] << 16 ^ nArray2[n45 >>> 8 & 0xFF] << 8 ^ nArray2[n44 & 0xFF] ^ nArray3[n17];
                n48 = nArray2[n46 >>> 24] << 24 ^ nArray2[n45 >>> 16 & 0xFF] << 16 ^ nArray2[n44 >>> 8 & 0xFF] << 8 ^ nArray2[n38 & 0xFF] ^ nArray3[n17 + 1];
                n49 = nArray2[n45 >>> 24] << 24 ^ nArray2[n44 >>> 16 & 0xFF] << 16 ^ nArray2[n38 >>> 8 & 0xFF] << 8 ^ nArray2[n37 & 0xFF] ^ nArray3[n17 + 2];
                n50 = nArray2[n44 >>> 24] << 24 ^ nArray2[n38 >>> 16 & 0xFF] << 16 ^ nArray2[n37 >>> 8 & 0xFF] << 8 ^ nArray2[n43 & 0xFF] ^ nArray3[n17 + 3];
                n42 = nArray2[n38 >>> 24] << 24 ^ nArray2[n37 >>> 16 & 0xFF] << 16 ^ nArray2[n43 >>> 8 & 0xFF] << 8 ^ nArray2[n46 & 0xFF] ^ nArray3[n17 + 4];
                n41 = nArray2[n37 >>> 24] << 24 ^ nArray2[n43 >>> 16 & 0xFF] << 16 ^ nArray2[n46 >>> 8 & 0xFF] << 8 ^ nArray2[n45 & 0xFF] ^ nArray3[n17 + 5];
            } else {
                while (true) {
                    n43 = n47 ^ nArray3[n17];
                    n46 = n48 ^ nArray3[n17 + 1];
                    n45 = n49 ^ nArray3[n17 + 2];
                    n44 = n50 ^ nArray3[n17 + 3];
                    n38 = n42 ^ nArray3[n17 + 4];
                    n37 = n41 ^ nArray3[n17 + 5];
                    n36 = n40 ^ nArray3[n17 + 6];
                    n35 = n39 ^ nArray3[(n17 += 8) - 1];
                    if (n17 == n6) break;
                    n47 = nArray[n43 >>> 24] ^ nArray[256 + (n46 >>> 16 & 0xFF)] ^ nArray[512 + (n44 >>> 8 & 0xFF)] ^ nArray[768 + (n38 & 0xFF)];
                    n48 = nArray[n46 >>> 24] ^ nArray[256 + (n45 >>> 16 & 0xFF)] ^ nArray[512 + (n38 >>> 8 & 0xFF)] ^ nArray[768 + (n37 & 0xFF)];
                    n49 = nArray[n45 >>> 24] ^ nArray[256 + (n44 >>> 16 & 0xFF)] ^ nArray[512 + (n37 >>> 8 & 0xFF)] ^ nArray[768 + (n36 & 0xFF)];
                    n50 = nArray[n44 >>> 24] ^ nArray[256 + (n38 >>> 16 & 0xFF)] ^ nArray[512 + (n36 >>> 8 & 0xFF)] ^ nArray[768 + (n35 & 0xFF)];
                    n42 = nArray[n38 >>> 24] ^ nArray[256 + (n37 >>> 16 & 0xFF)] ^ nArray[512 + (n35 >>> 8 & 0xFF)] ^ nArray[768 + (n43 & 0xFF)];
                    n41 = nArray[n37 >>> 24] ^ nArray[256 + (n36 >>> 16 & 0xFF)] ^ nArray[512 + (n43 >>> 8 & 0xFF)] ^ nArray[768 + (n46 & 0xFF)];
                    n40 = nArray[n36 >>> 24] ^ nArray[256 + (n35 >>> 16 & 0xFF)] ^ nArray[512 + (n46 >>> 8 & 0xFF)] ^ nArray[768 + (n45 & 0xFF)];
                    n39 = nArray[n35 >>> 24] ^ nArray[256 + (n43 >>> 16 & 0xFF)] ^ nArray[512 + (n45 >>> 8 & 0xFF)] ^ nArray[768 + (n44 & 0xFF)];
                }
                n47 = nArray2[n43 >>> 24] << 24 ^ nArray2[n46 >>> 16 & 0xFF] << 16 ^ nArray2[n44 >>> 8 & 0xFF] << 8 ^ nArray2[n38 & 0xFF] ^ nArray3[n17];
                n48 = nArray2[n46 >>> 24] << 24 ^ nArray2[n45 >>> 16 & 0xFF] << 16 ^ nArray2[n38 >>> 8 & 0xFF] << 8 ^ nArray2[n37 & 0xFF] ^ nArray3[n17 + 1];
                n49 = nArray2[n45 >>> 24] << 24 ^ nArray2[n44 >>> 16 & 0xFF] << 16 ^ nArray2[n37 >>> 8 & 0xFF] << 8 ^ nArray2[n36 & 0xFF] ^ nArray3[n17 + 2];
                n50 = nArray2[n44 >>> 24] << 24 ^ nArray2[n38 >>> 16 & 0xFF] << 16 ^ nArray2[n36 >>> 8 & 0xFF] << 8 ^ nArray2[n35 & 0xFF] ^ nArray3[n17 + 3];
                n42 = nArray2[n38 >>> 24] << 24 ^ nArray2[n37 >>> 16 & 0xFF] << 16 ^ nArray2[n35 >>> 8 & 0xFF] << 8 ^ nArray2[n43 & 0xFF] ^ nArray3[n17 + 4];
                n41 = nArray2[n37 >>> 24] << 24 ^ nArray2[n36 >>> 16 & 0xFF] << 16 ^ nArray2[n43 >>> 8 & 0xFF] << 8 ^ nArray2[n46 & 0xFF] ^ nArray3[n17 + 5];
                n40 = nArray2[n36 >>> 24] << 24 ^ nArray2[n35 >>> 16 & 0xFF] << 16 ^ nArray2[n46 >>> 8 & 0xFF] << 8 ^ nArray2[n45 & 0xFF] ^ nArray3[n17 + 6];
                n39 = nArray2[n35 >>> 24] << 24 ^ nArray2[n43 >>> 16 & 0xFF] << 16 ^ nArray2[n45 >>> 8 & 0xFF] << 8 ^ nArray2[n44 & 0xFF] ^ nArray3[n17 + 7];
            }
            if (byArray != null) {
                if (n == 0) {
                    n26 = n47;
                    n25 = n48;
                    n24 = n49;
                    n23 = n50;
                    if (n18 > 16) {
                        n34 = n42;
                        n33 = n41;
                        n32 = n40;
                        n31 = n39;
                    }
                } else {
                    n47 ^= n22;
                    n48 ^= n21;
                    n49 ^= n20;
                    n50 ^= n19;
                    if (n18 > 16) {
                        n42 ^= n30;
                        n41 ^= n29;
                        n40 ^= n28;
                        n39 ^= n27;
                    }
                }
            }
            if (byArray3 == null) continue;
            CL3.msbf4(n47, byArray3, n4);
            CL3.msbf4(n48, byArray3, n4 + n13);
            CL3.msbf4(n49, byArray3, n4 + n12);
            CL3.msbf4(n50, byArray3, n4 + n11);
            if (n18 > 16) {
                CL3.msbf4(n42, byArray3, n4 + n10);
                CL3.msbf4(n41, byArray3, n4 + n9);
                if (n18 > 24) {
                    CL3.msbf4(n40, byArray3, n4 + n8);
                    CL3.msbf4(n39, byArray3, n4 + n7);
                }
            }
            n4 += n18;
        }
        if (byArray != null) {
            CL3.msbf4(n26, byArray, n14);
            CL3.msbf4(n25, byArray, n14 + n13);
            CL3.msbf4(n24, byArray, n14 + n12);
            CL3.msbf4(n23, byArray, n14 + n11);
            if (n18 > 16) {
                CL3.msbf4(n34, byArray, n14 + n10);
                CL3.msbf4(n33, byArray, n14 + n9);
                if (n18 > 24) {
                    CL3.msbf4(n32, byArray, n14 + n8);
                    CL3.msbf4(n31, byArray, n14 + n7);
                }
            }
        }
    }
}

