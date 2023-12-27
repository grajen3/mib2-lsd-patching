/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.j9.bluez.crypto;

import com.ibm.j9.bluez.crypto.BigInteger;
import com.ibm.j9.bluez.crypto.CL3;
import com.ibm.j9.bluez.crypto.CL3Exception;
import java.util.Random;

public class RSACipher {
    private static final long P_HighNibbles;
    private static final long Q_HighNibbles;
    private static final long PERM;
    public static final int RSA_HASH_DATA;
    public static final int RSA_HASH_ALG;
    public static final int RSA_SCHEME;
    public static final int RSA_RAW;
    public static final int RSA_PKCS1;
    public static final int RSA_ISO9796;
    public static final int RSA_OAEP;
    public static final int RSA_PKCS1_MD2;
    public static final int RSA_PKCS1_SHA;
    public static final int RSA_PKCS1_MD5;
    protected static final byte[] HASH_DS;
    protected static final byte[] DIGEST_INFOS;
    public static final int T_RSA_PUBLIC_KEY;
    public static final int T_RSA_PRIVATE_KEY;

    static {
        byte[] byArray = new byte[8];
        byArray[1] = 16;
        byArray[2] = 16;
        byArray[3] = 20;
        byArray[4] = 32;
        byArray[5] = 48;
        byArray[6] = 64;
        byArray[7] = 36;
        HASH_DS = byArray;
        byte[] byArray2 = new byte[123];
        byArray2[1] = 104;
        byArray2[2] = 9;
        byArray2[3] = 28;
        byArray2[4] = 44;
        byArray2[5] = 64;
        byArray2[6] = 84;
        byArray2[7] = 8;
        byArray2[9] = 18;
        byArray2[10] = 48;
        byArray2[11] = 32;
        byArray2[12] = 48;
        byArray2[13] = 12;
        byArray2[14] = 6;
        byArray2[15] = 8;
        byArray2[16] = 42;
        byArray2[17] = -122;
        byArray2[18] = 72;
        byArray2[19] = -122;
        byArray2[20] = -9;
        byArray2[21] = 13;
        byArray2[22] = 2;
        byArray2[23] = 5;
        byArray2[24] = 5;
        byArray2[26] = 4;
        byArray2[27] = 16;
        byArray2[28] = 15;
        byArray2[29] = 48;
        byArray2[30] = 33;
        byArray2[31] = 48;
        byArray2[32] = 9;
        byArray2[33] = 6;
        byArray2[34] = 5;
        byArray2[35] = 43;
        byArray2[36] = 14;
        byArray2[37] = 3;
        byArray2[38] = 2;
        byArray2[39] = 26;
        byArray2[40] = 5;
        byArray2[42] = 4;
        byArray2[43] = 20;
        byArray2[44] = 19;
        byArray2[45] = 48;
        byArray2[46] = 49;
        byArray2[47] = 48;
        byArray2[48] = 13;
        byArray2[49] = 6;
        byArray2[50] = 9;
        byArray2[51] = 96;
        byArray2[52] = -122;
        byArray2[53] = 72;
        byArray2[54] = 1;
        byArray2[55] = 101;
        byArray2[56] = 3;
        byArray2[57] = 4;
        byArray2[58] = 2;
        byArray2[59] = 1;
        byArray2[60] = 5;
        byArray2[62] = 4;
        byArray2[63] = 32;
        byArray2[64] = 19;
        byArray2[65] = 48;
        byArray2[66] = 65;
        byArray2[67] = 48;
        byArray2[68] = 13;
        byArray2[69] = 6;
        byArray2[70] = 9;
        byArray2[71] = 96;
        byArray2[72] = -122;
        byArray2[73] = 72;
        byArray2[74] = 1;
        byArray2[75] = 101;
        byArray2[76] = 3;
        byArray2[77] = 4;
        byArray2[78] = 2;
        byArray2[79] = 2;
        byArray2[80] = 5;
        byArray2[82] = 4;
        byArray2[83] = 48;
        byArray2[84] = 19;
        byArray2[85] = 48;
        byArray2[86] = 81;
        byArray2[87] = 48;
        byArray2[88] = 13;
        byArray2[89] = 6;
        byArray2[90] = 9;
        byArray2[91] = 96;
        byArray2[92] = -122;
        byArray2[93] = 72;
        byArray2[94] = 1;
        byArray2[95] = 101;
        byArray2[96] = 3;
        byArray2[97] = 4;
        byArray2[98] = 2;
        byArray2[99] = 3;
        byArray2[100] = 5;
        byArray2[102] = 4;
        byArray2[103] = 64;
        byArray2[104] = 18;
        byArray2[105] = 48;
        byArray2[106] = 32;
        byArray2[107] = 48;
        byArray2[108] = 12;
        byArray2[109] = 6;
        byArray2[110] = 8;
        byArray2[111] = 42;
        byArray2[112] = -122;
        byArray2[113] = 72;
        byArray2[114] = -122;
        byArray2[115] = -9;
        byArray2[116] = 13;
        byArray2[117] = 2;
        byArray2[118] = 2;
        byArray2[119] = 5;
        byArray2[121] = 4;
        byArray2[122] = 16;
        DIGEST_INFOS = byArray2;
    }

    public static int rsaSign(CL3 cL3, int n, Object object, byte[] byArray, int n2, int n3, byte[] byArray2, int n4) {
        block12: {
            byte[] byArray3;
            int n5;
            BigInteger[] bigIntegerArray;
            block15: {
                int n6;
                block17: {
                    block16: {
                        int n7;
                        block13: {
                            block14: {
                                bigIntegerArray = (BigInteger[])cL3.obj;
                                n5 = (bigIntegerArray[0].bitLength() + 7) / 8;
                                byArray3 = new byte[n5];
                                if (n5 < 64) break block12;
                                if ((n & 0x1000) != 0) {
                                    int n8 = n3;
                                    n3 = HASH_DS[n & 7];
                                    RSACipher.digest(n, 0, byArray, n2, n8, byArray3, n5 - n3);
                                    byArray = byArray3;
                                    n2 = n5 - n3;
                                }
                                if (byArray != byArray3) {
                                    int n9 = n2;
                                    n2 = n5 - n3;
                                    System.arraycopy((Object)byArray, n9, (Object)byArray3, n2, n3);
                                }
                                if ((n6 = n & 0xE0) != 32) break block13;
                                n6 = n & 7;
                                if (n6 == 0) break block14;
                                if (n3 == 0 || HASH_DS[n6] != n3) break block12;
                                byte by = DIGEST_INFOS[n6];
                                if (by != 0) {
                                    byte by2 = DIGEST_INFOS[by];
                                    System.arraycopy((Object)DIGEST_INFOS, by + 1, (Object)byArray3, n2 -= by2, (int)by2);
                                }
                            }
                            if (n2 < 11) {
                                throw new CL3Exception(0x8000080);
                            }
                            byArray3[1] = 1;
                            byArray3[--n2] = 0;
                            while (--n2 > 1) {
                                byArray3[n2] = -1;
                            }
                            break block15;
                        }
                        if (n6 != 128) break block16;
                        byte[] byArray4 = new byte[20];
                        if ((n & 0x2000) != 0) {
                            n7 = byArray4.length;
                            CL3.rng(null, byArray4, 0, n7);
                        } else {
                            n7 = 0;
                        }
                        if (8 + n3 + n7 > n5) break block12;
                        int n10 = 0;
                        while (n10 < 8) {
                            byArray3[n10] = 0;
                            ++n10;
                        }
                        System.arraycopy((Object)byArray3, n2, (Object)byArray3, 8, n3);
                        System.arraycopy((Object)byArray4, 0, (Object)byArray3, 8 + n3, n7);
                        int n11 = n10 = 8 + n3 + n7;
                        n10 = n5 - 1 - HASH_DS[n & 7];
                        RSACipher.digest(n, 6, byArray3, 0, n11, byArray3, n10);
                        byArray3[n5 - 1] = -68;
                        n6 = n10 - n7;
                        System.arraycopy((Object)byArray4, 0, (Object)byArray3, n6, n7);
                        byArray3[--n6] = 1;
                        while (--n6 >= 0) {
                            byArray3[n6] = 0;
                        }
                        RSACipher.MGF1(byArray3, 0, n10, n10, n5 - n10 - 1);
                        byArray3[0] = (byte)(byArray3[0] & (1 << (bigIntegerArray[0].bitLength() - 1) % 8) - 1);
                        break block15;
                    }
                    if (n6 != 64) break block17;
                    n6 = bigIntegerArray[0].bitLength();
                    if (n3 * 16 > n6 + 4) break block12;
                    RSACipher.padISO9796(byArray3, n5, n3, n6);
                    break block15;
                }
                if (n6 != 0) break block12;
            }
            RSACipher.rsa(bigIntegerArray, RSACipher.isPrivateKey(cL3), n, byArray3, byArray2, n4, n5);
            return n5;
        }
        throw new CL3Exception(0x3000080);
    }

    public static int rsaDecrypt(CL3 cL3, int n, Object object, byte[] byArray, int n2, int n3, byte[] byArray2, int n4) {
        block6: {
            byte[] byArray3;
            int n5;
            block8: {
                int n6;
                block9: {
                    block7: {
                        BigInteger[] bigIntegerArray = (BigInteger[])cL3.obj;
                        n5 = (bigIntegerArray[0].bitLength() + 7) / 8;
                        byArray3 = new byte[n5];
                        n6 = n & 0xE0;
                        if (n6 != n || n3 != n5 || n5 < 64) break block6;
                        System.arraycopy((Object)byArray, n2, (Object)byArray3, 0, n3);
                        RSACipher.rsa(bigIntegerArray, RSACipher.isPrivateKey(cL3), 0, byArray3, byArray3, 0, n5);
                        if (n6 != 32) break block7;
                        n2 = 2;
                        while (n2 < n5 && byArray3[n2] != 0) {
                            ++n2;
                        }
                        if (byArray3[0] != 0 || byArray3[1] != 2 || n6 == n5 || ++n2 < 11) {
                            throw new CL3Exception(0x5000080);
                        }
                        break block8;
                    }
                    if (n6 != 96) break block9;
                    byte[] byArray4 = new byte[20];
                    RSACipher.MGF1(byArray3, 1, 20, 21, n5 - 21);
                    RSACipher.MGF1(byArray3, 21, n5 - 21, 1, 20);
                    CL3.sha(null, byArray4, 0, 0, byArray4, 0);
                    n2 = 41;
                    while (n2 < n5 && byArray3[n2] == 0) {
                        ++n2;
                    }
                    if (!RSACipher.cmp(byArray3, 21, byArray4, 0, 20) || n2 == n5 || byArray3[n2++] != 1 || byArray3[0] != 0) {
                        throw new CL3Exception(0x5000080);
                    }
                    break block8;
                }
                if (n6 == 0) {
                    n2 = 0;
                    while (n2 < n5 && byArray3[n2] == 0) {
                        ++n2;
                    }
                }
                break block6;
            }
            System.arraycopy((Object)byArray3, n2, (Object)byArray2, n4, n5 - n2);
            int n7 = n4 + n5 - 1;
            byArray2[n7] = (byte)(byArray2[n7] + 0);
            return n5 - n2;
        }
        throw new CL3Exception(0x3000080);
    }

    protected static void rsa(BigInteger[] bigIntegerArray, boolean bl, int n, byte[] byArray, byte[] byArray2, int n2, int n3) {
        BigInteger bigInteger = new BigInteger(1, byArray);
        if (bl) {
            BigInteger bigInteger2;
            if (bigIntegerArray[3].bitLength() == 0) {
                bigInteger = bigInteger.modPow(bigIntegerArray[2], bigIntegerArray[0]);
            } else {
                if (bigIntegerArray.length == 2) {
                    throw new CL3Exception(385876096);
                }
                BigInteger bigInteger3 = bigInteger.remainder(bigIntegerArray[3]).modPow(bigIntegerArray[5], bigIntegerArray[3]);
                BigInteger bigInteger4 = bigInteger.remainder(bigIntegerArray[4]).modPow(bigIntegerArray[6], bigIntegerArray[4]);
                bigInteger = bigInteger3.add(bigIntegerArray[3]).subtract(bigInteger4).multiply(bigIntegerArray[7]).remainder(bigIntegerArray[3]).multiply(bigIntegerArray[4]).add(bigInteger4);
            }
            if ((n & 0x40) != 0 && (bigInteger2 = bigIntegerArray[0].subtract(bigInteger)).compareTo(bigInteger) <= 0) {
                bigInteger = bigInteger2;
            }
        } else {
            bigInteger = bigInteger.modPow(bigIntegerArray[1], bigIntegerArray[0]);
            if ((n & 0x40) != 0 && (bigInteger.intValue() & 0xF) != 6) {
                bigInteger = bigIntegerArray[0].subtract(bigInteger);
            }
        }
        if ((n3 = (byArray = bigInteger.toByteArray()).length - n3) < 0) {
            do {
                byArray2[n2++] = 0;
            } while (++n3 < 0);
        }
        System.arraycopy((Object)byArray, n3, (Object)byArray2, n2, byArray.length - n3);
    }

    public static int rsaEncrypt(CL3 cL3, int n, Object object, byte[] byArray, int n2, int n3, byte[] byArray2, int n4) {
        block7: {
            byte[] byArray3;
            int n5;
            BigInteger[] bigIntegerArray;
            block9: {
                int n6;
                block10: {
                    block8: {
                        bigIntegerArray = (BigInteger[])cL3.obj;
                        n5 = (bigIntegerArray[0].bitLength() + 7) / 8;
                        byArray3 = new byte[n5];
                        n6 = n & 0xE0;
                        if (n6 != n || n3 > n5 || n5 < 64) break block7;
                        System.arraycopy((Object)byArray, n2, (Object)byArray3, n5 - n3, n3);
                        if (n6 != 32) break block8;
                        n6 = n5 - n3 - 1;
                        if (n6 < 10) {
                            throw new CL3Exception(0x8000080);
                        }
                        byArray3[0] = 0;
                        byArray3[n6] = 0;
                        byArray3[1] = 2;
                        CL3.rng(null, byArray3, 2, n6 - 3);
                        int n7 = CL3.msbf(byArray3, 2, 4) | 1;
                        while (--n6 > 1) {
                            if (byArray3[n6] != 0) continue;
                            n7 *= n7;
                            byArray3[n6] = (byte)n7;
                        }
                        break block9;
                    }
                    if (n6 != 96) break block10;
                    if (n3 + 20 + 20 + 2 > n5) {
                        throw new CL3Exception(0x8000080);
                    }
                    CL3.sha(null, byArray3, 0, 0, byArray3, 21);
                    byArray3[0] = 0;
                    n6 = n5 - n3 - 1;
                    byArray3[n6] = 1;
                    while (--n6 > 40) {
                        byArray3[n6] = 0;
                    }
                    CL3.rng(null, byArray3, 1, 20);
                    RSACipher.MGF1(byArray3, 21, n5 - 21, 1, 20);
                    RSACipher.MGF1(byArray3, 1, 20, 21, n5 - 21);
                    break block9;
                }
                if (n6 != 0) break block7;
            }
            RSACipher.rsa(bigIntegerArray, RSACipher.isPrivateKey(cL3), 0, byArray3, byArray2, n4, n5);
            return n5;
        }
        throw new CL3Exception(0x3000080);
    }

    public static boolean rsaVerify(CL3 cL3, int n, Object object, byte[] byArray, int n2, int n3, byte[] byArray2, int n4, int n5) {
        block19: {
            byte[] byArray3;
            block17: {
                int n6;
                int n7;
                block20: {
                    BigInteger[] bigIntegerArray;
                    block18: {
                        block16: {
                            byte by;
                            bigIntegerArray = (BigInteger[])cL3.obj;
                            n7 = (bigIntegerArray[0].bitLength() + 7) / 8;
                            if (n7 != n5) {
                                return false;
                            }
                            byArray3 = new byte[n7];
                            System.arraycopy((Object)byArray2, n4, (Object)byArray3, 0, n5);
                            n4 = 0;
                            n5 = n7;
                            RSACipher.rsa(bigIntegerArray, RSACipher.isPrivateKey(cL3), n, byArray3, byArray3, 0, n5);
                            if ((n & 0x1000) != 0) {
                                byArray = RSACipher.digest(n, 0, byArray, n2, n3, null, 0);
                                n2 = 0;
                                n3 = byArray.length;
                            }
                            if ((n6 = n & 0xE0) != 32) break block16;
                            n6 = 2;
                            while (n6 < n7 && byArray3[n6] == -1) {
                                if (byArray3[n6] != -1) {
                                    return false;
                                }
                                ++n6;
                            }
                            if (byArray3[0] != 0 || byArray3[1] != 1 || n6 == n7 || byArray3[n6] != 0 || ++n6 < 11) {
                                return false;
                            }
                            n4 = n6;
                            n5 = n7 - n6;
                            n6 = n & 7;
                            if (n6 != 0 && (by = DIGEST_INFOS[n6]) != 0) {
                                byte by2 = DIGEST_INFOS[by];
                                if (by2 + HASH_DS[n6] != n5 || !RSACipher.cmp(DIGEST_INFOS, by + 1, byArray3, n4, by2)) {
                                    return false;
                                }
                                n4 += by2;
                                n5 -= by2;
                            }
                            break block17;
                        }
                        if (n6 != 128) break block18;
                        byte by = HASH_DS[n & 7];
                        if (by >= 0) {
                            int n8 = n7 - by - 1;
                            RSACipher.MGF1(byArray3, 0, n8, n8, by);
                            byArray3[0] = (byte)(byArray3[0] & (1 << (bigIntegerArray[0].bitLength() - 1) % 8) - 1);
                            n8 = 0;
                            while (n8 < n7 && byArray3[n8] == 0) {
                                ++n8;
                            }
                            if (n8 == n7 || byArray3[n8++] != 1 || byArray3[n7 - 1] != -68) {
                                return false;
                            }
                            int n9 = n7 - n8 - 1 - by;
                            byte[] byArray4 = new byte[8 + n3 + n9];
                            System.arraycopy((Object)byArray, n2, (Object)byArray4, 8, n3);
                            System.arraycopy((Object)byArray3, n8, (Object)byArray4, 8 + n3, n9);
                            RSACipher.digest(n, 0, byArray4, 0, byArray4.length, byArray3, 0);
                            return RSACipher.cmp(byArray3, 0, byArray3, n7 - by - 1, by);
                        }
                        break block19;
                    }
                    if (n6 != 64) break block20;
                    n6 = bigIntegerArray[0].bitLength();
                    if (n3 * 16 > n6 + 4) break block19;
                    byte[] byArray5 = byArray;
                    byArray = new byte[n7];
                    System.arraycopy((Object)byArray5, n2, (Object)byArray, n7 - n3, n3);
                    RSACipher.padISO9796(byArray, n7, n3, n6);
                    n3 = n7;
                    break block17;
                }
                if (n6 != 0) break block19;
                n6 = n7 - n3 - 1;
                while (n6 >= 0) {
                    if (byArray3[n6] != 0) {
                        return false;
                    }
                    --n6;
                }
                n5 = n3;
                n4 += n7 - n5;
            }
            return n5 == n3 && RSACipher.cmp(byArray3, n4, byArray, n2, n3);
        }
        throw new CL3Exception(0x3000080);
    }

    public static int rsaDecryptSignature(CL3 cL3, int n, Object object, byte[] byArray, int n2, int n3, byte[] byArray2, int n4) {
        BigInteger[] bigIntegerArray = (BigInteger[])cL3.obj;
        int n5 = (bigIntegerArray[0].bitLength() + 7) / 8;
        if (n5 != n3) {
            return -1;
        }
        byte[] byArray3 = new byte[n5];
        System.arraycopy((Object)byArray, n2, (Object)byArray3, 0, n3);
        n2 = 0;
        n3 = n5;
        RSACipher.rsa(bigIntegerArray, RSACipher.isPrivateKey(cL3), n, byArray3, byArray3, 0, n3);
        int n6 = n & 0xE0;
        if (n6 == 32) {
            n6 = 2;
            while (n6 < n5 && byArray3[n6] == -1) {
                if (byArray3[n6] != -1) {
                    return -1;
                }
                ++n6;
            }
            if (byArray3[0] != 0 || byArray3[1] != 1 || n6 == n5 || byArray3[n6] != 0 || ++n6 < 11) {
                return -1;
            }
            n2 = n6;
            n3 = n5 - n6;
        }
        System.arraycopy((Object)byArray3, n2, (Object)byArray2, n4, n3);
        return 16;
    }

    public static CL3 rsaKeyGen(int n, byte[] byArray, Random random) {
        if (n % 16 != 0) {
            throw new CL3Exception(0x3000080);
        }
        BigInteger[] bigIntegerArray = new BigInteger[8];
        BigInteger bigInteger = BigInteger.valueOf(1);
        int n2 = n / 16;
        byte[] byArray2 = new byte[n2];
        BigInteger bigInteger2 = byArray == null ? BigInteger.valueOf(0x1000100) : new BigInteger(1, byArray);
        BigInteger bigInteger3 = null;
        BigInteger bigInteger4 = null;
        long l = -73301893889L;
        int n3 = -1;
        while (true) {
            if (random == null) {
                CL3.rng(null, byArray2, 0, n2);
            } else {
                random.nextBytes(byArray2);
            }
            if (n3 < 0) {
                n3 = byArray2[0] >> 2 & 0x3C;
            }
            byArray2[0] = (byte)((long)(byArray2[0] & 0xF) + (l >> n3 << 4));
            int n4 = n2 - 1;
            byArray2[n4] = (byte)(byArray2[n4] | 1);
            bigInteger3 = RSACipher.findPrime(new BigInteger(1, byArray2), false);
            if (bigInteger3.bitLength() > n2 * 8 || !bigInteger2.gcd(bigInteger3.subtract(bigInteger)).equals(bigInteger)) continue;
            if (bigInteger4 == null) {
                bigInteger4 = bigInteger3;
                l = -7296712466775684130L;
                continue;
            }
            bigIntegerArray[0] = bigInteger4.multiply(bigInteger3);
            if (bigIntegerArray[0].bitLength() == n) break;
        }
        BigInteger bigInteger5 = bigInteger2.modInverse(bigInteger4.subtract(bigInteger).multiply(bigInteger3.subtract(bigInteger)));
        bigIntegerArray[1] = bigInteger2;
        bigIntegerArray[2] = bigInteger5;
        bigIntegerArray[3] = bigInteger4;
        bigIntegerArray[4] = bigInteger3;
        bigIntegerArray[5] = bigInteger5.remainder(bigInteger4.subtract(bigInteger));
        bigIntegerArray[6] = bigInteger5.remainder(bigInteger3.subtract(bigInteger));
        bigIntegerArray[7] = bigInteger3.modInverse(bigInteger4);
        return new CL3(bigIntegerArray, 6);
    }

    protected static void MGF1(byte[] byArray, int n, int n2, int n3, int n4) {
        int n5;
        if (n2 > 5120) {
            throw new CL3Exception(385876096);
        }
        CL3 cL3 = CL3.shaInit(null);
        if (n4 >= 64) {
            n5 = n4 % 64;
            CL3.sha(cL3, byArray, n3, n4 - n5, null, 0);
            n3 += n4 - n5;
            n4 = n5;
        }
        byte[] byArray2 = new byte[84];
        System.arraycopy((Object)byArray, n3, (Object)byArray2, 0, n4);
        n5 = 0;
        while (n5 < 3) {
            byArray2[n4++] = 0;
            if (n4 == 64) {
                CL3.sha(cL3, byArray2, 0, 64, null, 0);
                n4 = 0;
            }
            ++n5;
        }
        if (n2 > 0) {
            byArray2[n4] = -1;
            block1: while (true) {
                int n6 = n4;
                byArray2[n6] = (byte)(byArray2[n6] + 1);
                CL3.sha(cL3, byArray2, 0, n4 + 1, byArray2, 64);
                n5 = 64;
                while (true) {
                    if (n5 >= 84) continue block1;
                    int n7 = n++;
                    byArray[n7] = (byte)(byArray[n7] ^ byArray2[n5]);
                    if (--n2 == 0) {
                        return;
                    }
                    ++n5;
                }
                break;
            }
        }
    }

    static final byte[] digest(int n, int n2, byte[] byArray, int n3, int n4, byte[] byArray2, int n5) {
        block9: {
            int n6 = n & 7;
            if ((n2 & 1 << n6) == 0) {
                byte by;
                byte by2 = HASH_DS[n6];
                if ((n & 0x4000) != 0 && (by = DIGEST_INFOS[n6]) != 0) {
                    if (byArray2 == null) {
                        byte by3 = by2;
                        by2 = DIGEST_INFOS[by];
                        byArray2 = new byte[by3 + by2];
                    }
                    System.arraycopy((Object)DIGEST_INFOS, by + 1, (Object)byArray2, n5, (int)by2);
                    n5 += by2;
                } else if (byArray2 == null) {
                    byArray2 = new byte[by2];
                }
                switch (n6) {
                    case 3: {
                        CL3.sha(null, byArray, n3, n4, byArray2, n5);
                        break;
                    }
                    case 2: {
                        CL3.md5(null, byArray, n3, n4, byArray2, n5);
                        break;
                    }
                    default: {
                        break block9;
                    }
                }
                return byArray2;
            }
        }
        throw new CL3Exception(0x3000080);
    }

    static void padISO9796(byte[] byArray, int n, int n2, int n3) {
        int n4 = -1;
        int n5 = n + -1;
        int n6 = -n;
        while (++n6 < 0) {
            if (n4 < 0) {
                n4 = byArray[n5 + n6 / 2 % n2] & 0xFF;
            }
            if ((n6 & 1) != 0) {
                byArray[n5 + n6] = (byte)(2064737499334935870L >> (n4 << 2 & 0x3C) & 0 | (2064737499334935870L >> (n4 >> 2 & 0x3C) & 0) << 4);
                continue;
            }
            byArray[n5 + n6] = (byte)n4;
            n4 = -1;
        }
        int n7 = n - 2 * n2;
        byArray[n7] = (byte)(byArray[n7] ^ 1);
        if ((n3 = (n3 - 1) % 8) > 0) {
            byArray[0] = (byte)(byArray[0] & (1 << n3) - 1);
        }
        byArray[0] = (byte)(byArray[0] | 1 << (n3 + 7) % 8);
        byArray[n5] = (byte)(byArray[n5] << 4 | 6);
    }

    static final boolean cmp(byte[] byArray, int n, byte[] byArray2, int n2, int n3) {
        while (--n3 >= 0) {
            if (byArray[n + n3] == byArray2[n2 + n3]) continue;
            return false;
        }
        return true;
    }

    public static byte[][] exportRSAKeyMaterial(CL3 cL3) {
        if (cL3.type != 6) {
            throw new CL3Exception();
        }
        byte[][] byArray = new byte[2][];
        BigInteger[] bigIntegerArray = (BigInteger[])cL3.obj;
        byArray[0] = bigIntegerArray[3].toByteArray();
        byArray[1] = bigIntegerArray[4].toByteArray();
        return byArray;
    }

    private static BigInteger findPrime(BigInteger bigInteger, boolean bl) {
        BigInteger bigInteger2;
        BigInteger bigInteger3 = BigInteger.valueOf(1);
        if (CL3.Pi == null) {
            CL3.smallPrimes();
        }
        int[] nArray = new int[512];
        int n = 0;
        while (n < 512) {
            nArray[n] = bigInteger.remainder(BigInteger.valueOf(CL3.Pi[n])).intValue();
            ++n;
        }
        int n2 = -2;
        block1: while (true) {
            int n3;
            BigInteger bigInteger4;
            n2 += 2;
            n = 0;
            while (n < 512) {
                if ((nArray[n] + n2) % CL3.Pi[n] == 0 || bl && (2 * (nArray[n] + n2) + 1) % CL3.Pi[n] == 0) continue block1;
                ++n;
            }
            bigInteger2 = bl ? bigInteger4.shiftLeft(1).add(bigInteger3) : bigInteger4;
            if (CL3.isProbablePrime(bigInteger2, n3 = (bigInteger4 = bigInteger.add(BigInteger.valueOf(n2))).bitLength() < 512 ? 80 : 12) && (bigInteger2 == bigInteger4 || CL3.isProbablePrime(bigInteger4, n3))) break;
        }
        return bigInteger2;
    }

    private static boolean isPrivateKey(CL3 cL3) {
        return cL3.type == 1 || cL3.type == 2 || cL3.type == 6;
    }
}

