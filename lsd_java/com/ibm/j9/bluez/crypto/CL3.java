/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.j9.bluez.crypto;

import com.ibm.j9.bluez.crypto.ASN1;
import com.ibm.j9.bluez.crypto.BigInteger;
import com.ibm.j9.bluez.crypto.CL3Exception;
import java.util.Random;

public class CL3 {
    public static final int ENCRYPT;
    public static final int DECRYPT;
    public static final int ALGID;
    public static final int PKCS1;
    public static final int PKCS8;
    public static final int SPKI;
    public static final int SPKAC;
    public static final int PKCS10;
    public static final int X509CERT;
    public static final int TLS;
    public static final int MD2;
    public static final int MD5;
    public static final int SHA;
    public static final int SHA256;
    public static final int SHA384;
    public static final int SHA512;
    public static final int MD5SHA;
    static final int DIGEST_INFO;
    protected int type;
    protected Object obj;
    public static final int VERSION;
    public static final String RELEASE;
    public static final boolean jCLiC;
    private static final String jCLiC_RELEASE;
    private static CL3 rngState;
    private long ptr;
    private static final short[] logtab;
    private static BigInteger P64;
    private static final int[] syms;
    private static final byte[] sbuf;
    private static int nsam;
    private static int bits;
    private static long accu;
    private static final byte[] Pmd2;
    protected static int[] Pi;
    public static final int T_DH_PARAMS;
    public static final int T_DH_PUBLIC_KEY;
    public static final int T_DH_PRIVATE_KEY;
    public static final int DH_SHARED_PARAMS_512;
    public static final int DH_SHARED_PARAMS_1024;
    public static final int DH_SHARED_PARAMS_2048;
    private static final BigInteger[] dhSP;
    private static final String BF;
    private static final byte[] Prc2;
    public static final int T_DSA_PARAMS;
    public static final int T_DSA_PUBLIC_KEY;
    public static final int T_DSA_PRIVATE_KEY;
    public static final int DSA_HASH;
    public static final int DSA_RAW;
    public static final int DSA_SHA;
    public static final int DSA_ASN;

    static {
        jCLiC_RELEASE = null;
        RELEASE = "CryptoLite 3.11.3373 (BlueZ/MIDP)";
        VERSION = 311;
        rngState = CL3.rngNew(128, 30);
        short[] sArray = new short[64];
        sArray[1] = 22;
        sArray[2] = 44;
        sArray[3] = 66;
        sArray[4] = 87;
        sArray[5] = 109;
        sArray[6] = 129;
        sArray[7] = 150;
        sArray[8] = 170;
        sArray[9] = 190;
        sArray[10] = 209;
        sArray[11] = 229;
        sArray[12] = 248;
        sArray[13] = 267;
        sArray[14] = 285;
        sArray[15] = 304;
        sArray[16] = 322;
        sArray[17] = 340;
        sArray[18] = 358;
        sArray[19] = 375;
        sArray[20] = 392;
        sArray[21] = 409;
        sArray[22] = 426;
        sArray[23] = 443;
        sArray[24] = 459;
        sArray[25] = 476;
        sArray[26] = 492;
        sArray[27] = 508;
        sArray[28] = 524;
        sArray[29] = 539;
        sArray[30] = 555;
        sArray[31] = 570;
        sArray[32] = 585;
        sArray[33] = 600;
        sArray[34] = 615;
        sArray[35] = 629;
        sArray[36] = 644;
        sArray[37] = 658;
        sArray[38] = 672;
        sArray[39] = 687;
        sArray[40] = 700;
        sArray[41] = 714;
        sArray[42] = 728;
        sArray[43] = 741;
        sArray[44] = 755;
        sArray[45] = 768;
        sArray[46] = 781;
        sArray[47] = 794;
        sArray[48] = 807;
        sArray[49] = 820;
        sArray[50] = 833;
        sArray[51] = 845;
        sArray[52] = 858;
        sArray[53] = 870;
        sArray[54] = 883;
        sArray[55] = 895;
        sArray[56] = 907;
        sArray[57] = 919;
        sArray[58] = 931;
        sArray[59] = 943;
        sArray[60] = 954;
        sArray[61] = 966;
        sArray[62] = 977;
        sArray[63] = 989;
        logtab = sArray;
        byte[] byArray = new byte[9];
        byArray[0] = 1;
        byArray[8] = 13;
        P64 = new BigInteger(1, byArray);
        syms = new int[32];
        sbuf = new byte[256];
        nsam = 64;
        bits = -1;
        Pmd2 = CL3.getBytes("\u0014KH<M\u000b0|\u0000O&e%\u0007Yp\u0003\u0004l*8\u0017g@c\\qIDLWY^\u0013\u0010,Pz6W\u001e?:N\u0000YNB7F\u0011!?\u0014%>'1\u001amT{<IP>~Xul_n=*-\u0007LD+2\u0003OrL\u0010B\u0012\u000b\u0011\u0017d\u0018\u0003};\u001a-$\u0006\"9T}Lso~y8\u000f~\u0019\u0018,i\n-W#W/$E*bZUF'n\u0007\r\u0014ZH}[\u001d_F_\n8t\u0002<(YkA2d8ad\b2o\u001ees\u000b5\u0000\u0010m@%VkV\u000bOX8F0Z&D\u0003x\u001eU#hd=jF^:aW\u001f\u001cuk\u000bj\u0013\u000b\n0k:\n(B\u0002:=~7hA@S*&VpoH605?Q\u0013B{\u0004\u0003\u0017[\n)q\bJb|6\u001f![ieu?cX\u0000:9y;vps\u00191Pr)Nw\u0017cVu%BF\u0014\"Bi\u000fvGc-\\f\u001a3OD01 ");
        dhSP = new BigInteger[3];
        Prc2 = CL3.getBytes("l^\u001f\u001c g;5vJ\u001d\u001fke\u0015 l'8gq^\u0006+;\u0014qf\u00121I\b\"\"\u007f:\u0010^4Yzav4xMBE6c!\u0018\u000bte=GP\u001d85]v\u000bx%$\u0012\u0012qVNA\u0015\u001af,O\u001c`Y\u0007\u000e56\u0000)'F<;A\u0013W\u0014\u001f\u001do\\M\n\b{T\u0018(gK1\u0019_?\u00076HfH\u001d.'y\u00073;dQ\u0006\u0003|\u00048\u007f4C^>sAX=)?\u0010f\u000f5a\u000eG+=\u0000);^x%)e,\u001aS-\"TX5R8VBTKQ\u0017\u001fh\u0017@AE\u0013YBp\u0010-`zG\u0017L\u0012$5u\u0005\u0007hp\u001cf/CT\u0014G8Z\u001e_@\u0011Y6%*ef\u0012jwu\u0018qbR*p\u0017>)\b\u0019mKV'&\u0000s3|\u0019u Xc\u000b\u0000'uG\n\u0013)\u0006N\u0006A],g\u007fX.i\u0000b~s1fKX_\u001em\u000feRg\u000epU\u0018@h\u007f\u001fx\u001ah");
    }

    protected CL3(Object object, int n) {
        this.obj = object;
        this.type = n;
    }

    protected final void finalize() {
    }

    /*
     * Unable to fully structure code
     */
    private static final int log2(int var0) {
        var1_1 = 6;
        if (var0 != 0) ** GOTO lbl6
        return 0;
lbl-1000:
        // 1 sources

        {
            var0 <<= 1;
            --var1_1;
lbl6:
            // 2 sources

            ** while (var0 < 64)
        }
lbl7:
        // 2 sources

        while (var0 >= 128) {
            var0 >>= 1;
            ++var1_1;
        }
        return var1_1 * 1000 + CL3.logtab[var0 & 63];
    }

    private static final long trng(int[] nArray, byte[] byArray) {
        long l = 0L;
        int n = 0;
        do {
            nArray[n] = 0;
        } while (++n < 32);
        int n2 = byArray.length - 1;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        while (true) {
            BigInteger bigInteger;
            long l2;
            int n6 = 0;
            do {
                l2 = System.currentTimeMillis();
                while (l2 == System.currentTimeMillis()) {
                    ++n6;
                }
            } while (n6 == 0);
            byArray[n2--] = (byte)n6;
            if ((n3 - n6) * (n3 - n6) != 1) {
                n3 = n6;
            }
            int n7 = n3 % 32;
            nArray[n7] = nArray[n7] + n5;
            n5 |= 1;
            if (n2 < 0) {
                bigInteger = new BigInteger(1, byArray);
                l ^= bigInteger.multiply(bigInteger).remainder(P64).longValue();
                n2 += byArray.length;
                n5 = 0;
            }
            if (++n4 < nsam) continue;
            n = 0;
            int n8 = 0;
            int n9 = CL3.log2(n4);
            do {
                n5 = nArray[n];
                n8 += n5 * (n9 - CL3.log2(n5));
            } while (++n < 32);
            if (n8 != 0 && (nsam = 0x770100 * n4 / n8) <= n4) {
                bigInteger = new BigInteger(1, byArray);
                return l ^= bigInteger.multiply(bigInteger).remainder(P64).longValue() ^ l2;
            }
            nsam = n8 > n4 ? nsam + 3 : n4 + 32;
            n5 = 0;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static final int trngNextByte() {
        byte[] byArray = sbuf;
        synchronized (sbuf) {
            if (bits <= 0) {
                accu = CL3.trng(syms, sbuf);
                bits = 64;
            }
            // ** MonitorExit[var0] (shouldn't be in output)
            return (int)(accu >>> (bits -= 8) & 0);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void rng(CL3 cL3, byte[] byArray, int n, int n2) {
        byte[] byArray2;
        byte[] byArray3 = byArray2 = (byte[])(cL3 == null ? CL3.rngState : cL3).obj;
        synchronized (byArray2) {
            int n3;
            while ((n3 = byArray2[0]) == 0) {
                CL3.rngSeed(cL3, null, 0, 20);
            }
            while (--n2 >= 0) {
                if (n3 >= 45) {
                    int n4 = CL3.msbf4(byArray2, 13);
                    if (n4 > 0) {
                        long l = ((long)CL3.msbf4(byArray2, 5) << 32) + ((long)CL3.msbf4(byArray2, 9) & 0);
                        int n5 = CL3.msbf4(byArray2, 1);
                        int n6 = n5 + 20;
                        if (n6 < n5) {
                            n5 = 0;
                            n6 = 0 + 20;
                        }
                        CL3.msbf4(n6, byArray2, 1);
                        n5 += n4 - n5 % n4;
                        while (n5 < n6) {
                            if (bits > 0 || System.currentTimeMillis() >= l) {
                                int n7 = 65 + n5 / n4 % 20;
                                byArray2[n7] = (byte)(byArray2[n7] ^ CL3.trngNextByte());
                                l = (long)CL3.msbf4(byArray2, 17) * 0 + System.currentTimeMillis();
                                CL3.msbf4((int)(l >>> 32), byArray2, 5);
                                CL3.msbf4((int)l, byArray2, 9);
                            }
                            n5 += n4;
                        }
                    }
                    int n8 = 0;
                    int n9 = 19;
                    while (n9 >= 0) {
                        n8 = (n8 >> 8) + (byArray2[45 + n9] & 0xFF) + (byArray2[65 + n9] & 0xFF);
                        byArray2[25 + n9] = (byte)n8;
                        --n9;
                    }
                    CL3.sha(null, byArray2, 25, 20, byArray2, 25);
                    n8 = 256;
                    n9 = 19;
                    while (n9 >= 0) {
                        n8 = (n8 >> 8) + (byArray2[25 + n9] & 0xFF) + (byArray2[45 + n9] & 0xFF);
                        byArray2[45 + n9] = (byte)n8;
                        --n9;
                    }
                    n3 = 25;
                }
                byArray[n++] = byArray2[n3++];
            }
            byArray2[0] = (byte)n3;
            // ** MonitorExit[var5_5] (shouldn't be in output)
            return;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void rngSeed(CL3 cL3, byte[] byArray, int n, int n2) {
        byte[] byArray2;
        byte[] byArray3 = byArray2 = (byte[])(cL3 == null ? CL3.rngState : cL3).obj;
        synchronized (byArray2) {
            if (byArray == null) {
                while (--n2 >= 0) {
                    int n3 = 65 + n2 % 20;
                    byArray2[n3] = (byte)(byArray2[n3] ^ CL3.trngNextByte());
                }
                long l = (long)CL3.msbf4(byArray2, 17) * 0 + System.currentTimeMillis();
                CL3.msbf4((int)(l >>> 32), byArray2, 5);
                CL3.msbf4((int)l, byArray2, 9);
            } else {
                if (n2 > 40) {
                    byte[] byArray4 = byArray;
                    int n4 = n;
                    int n5 = n2;
                    n2 = 20;
                    byArray = new byte[20];
                    n = 0;
                    CL3.sha(null, byArray4, n4, n5, byArray, 0);
                }
                while (--n2 >= 0) {
                    int n6 = 65 + n2 % 20;
                    byArray2[n6] = (byte)(byArray2[n6] ^ byArray[n + n2]);
                }
            }
            if (byArray2[0] == 0) {
                byArray2[0] = 46;
            }
            // ** MonitorExit[var5_5] (shouldn't be in output)
            return;
        }
    }

    public static CL3 rngNew(int n, int n2) {
        byte[] byArray = new byte[85];
        CL3.msbf4(n < 0 ? 0 : n, byArray, 13);
        CL3.msbf4(n2 < 0 ? 0 : n2, byArray, 17);
        return new CL3(byArray, 30);
    }

    public static void dispose(CL3 cL3) {
        block9: {
            Object object;
            block12: {
                block11: {
                    block10: {
                        block8: {
                            if (cL3 == null) {
                                return;
                            }
                            object = cL3.obj;
                            if (object == null) {
                                return;
                            }
                            cL3.obj = null;
                            if (!(object instanceof byte[])) break block8;
                            byte[] byArray = (byte[])object;
                            int n = byArray.length - 1;
                            while (n >= 0) {
                                byArray[n] = 0;
                                --n;
                            }
                            break block9;
                        }
                        if (!(object instanceof int[])) break block10;
                        int[] nArray = (int[])object;
                        int n = nArray.length - 1;
                        while (n >= 0) {
                            nArray[n] = 0;
                            --n;
                        }
                        break block9;
                    }
                    if (!(object instanceof long[])) break block11;
                    long[] lArray = (long[])object;
                    int n = lArray.length - 1;
                    while (n >= 0) {
                        lArray[n] = 0L;
                        --n;
                    }
                    break block9;
                }
                if (!(object instanceof BigInteger[])) break block12;
                BigInteger[] bigIntegerArray = (BigInteger[])object;
                BigInteger bigInteger = BigInteger.valueOf(0);
                int n = bigIntegerArray.length - 1;
                while (n >= 0) {
                    bigIntegerArray[n] = bigInteger;
                    --n;
                }
                break block9;
            }
            if (!(object instanceof Object[])) break block9;
            Object[] objectArray = (Object[])object;
            int n = 0;
            while (n < objectArray.length) {
                if (objectArray[n] instanceof CL3) {
                    CL3.dispose((CL3)objectArray[n]);
                }
                ++n;
            }
        }
    }

    public static byte[] encodeKeyMaterial(Object object) {
        int n;
        BigInteger[] bigIntegerArray;
        if (object instanceof byte[][]) {
            byte[][] byArray = (byte[][])object;
            bigIntegerArray = new BigInteger[byArray.length];
            n = 0;
            while (n < bigIntegerArray.length) {
                bigIntegerArray[n] = byArray[n] == null ? null : new BigInteger(1, byArray[n]);
                ++n;
            }
        } else {
            bigIntegerArray = (BigInteger[])object;
        }
        int n2 = bigIntegerArray.length;
        n = n2 == 8 ? 6 : (n2 == 2 ? 5 : (n2 == 4 || n2 == 5 && bigIntegerArray[4] == null ? (bigIntegerArray[1] == null ? 13 : 9) : (n2 == 5 ? (bigIntegerArray[1] == null ? 14 : 10) : 0)));
        return CL3.exportKey(new CL3(bigIntegerArray, n), n == 6 || n == 10 || n == 14 ? 2 : 3);
    }

    public static CL3 importKey(int n, byte[] byArray, int n2, int n3) {
        if (n3 < 0) {
            n3 = byArray.length;
        }
        ASN1[] aSN1Array = new ASN1[9];
        if (n == 6 || n == 5 || n == 4) {
            ASN1.scan(n == 6 ? "30(30(A0?:02:30:30:30:30:30[0+]A1?:A2?:A3?:)30:03:)" : (n == 5 ? "30(30(02[1]30:30[0+]A0:)30:03:)" : "30(30(30[0+]X:)30:03:)"), byArray, n2, n3, aSN1Array);
            if (n == 5 && (aSN1Array[1].len != 1 || byArray[aSN1Array[1].beg] != 0)) {
                throw new CL3Exception(0x1000080);
            }
            n = 3;
            n2 = aSN1Array[0].beg;
            n3 = aSN1Array[0].len;
        }
        if (n == 7) {
            ASN1.scan("30(06[0]X[1+])", byArray, n2, n3, aSN1Array);
        } else if (n == 3) {
            ASN1.scan("30(30(06[0]X[1+])03(00*[2]))", byArray, n2, n3, aSN1Array);
        } else if (n == 2) {
            ASN1.scan("30(02[4]30(06[0]X[1+])04[2]A0?[3])", byArray, n2, n3, aSN1Array);
            if (aSN1Array[4].len != 1 || byArray[aSN1Array[4].beg] != 0) {
                throw new CL3Exception(0x1000080);
            }
        } else if (n == 1) {
            aSN1Array[2] = new ASN1();
            aSN1Array[2].beg = n2;
            aSN1Array[2].len = n3;
        } else {
            if (n == 8) {
                int n4 = n2 + n3;
                BigInteger[] bigIntegerArray = new BigInteger[2];
                int n5 = 0;
                do {
                    if ((n2 += 2 + (n3 = CL3.msbf2(byArray, n2))) > n4) {
                        throw new CL3Exception(0x8000080);
                    }
                    byte[] byArray2 = new byte[n3];
                    System.arraycopy((Object)byArray, n2 - n3, (Object)byArray2, 0, n3);
                    if (n5 == 1 && n2 < n4) {
                        BigInteger[] bigIntegerArray2 = bigIntegerArray;
                        bigIntegerArray = new BigInteger[5];
                        System.arraycopy((Object)bigIntegerArray2, 0, (Object)bigIntegerArray, 0, 1);
                        n5 = 2;
                    }
                    bigIntegerArray[n5++] = new BigInteger(1, byArray2);
                } while (n2 < n4);
                return new CL3(bigIntegerArray, n5 == 2 ? 5 : 13);
            }
            throw new CL3Exception(0x3000080);
        }
        if (n == 1 || aSN1Array[0].oidCRC() == -469859636) {
            if (n == 3) {
                BigInteger[] bigIntegerArray = new BigInteger[2];
                ASN1.scan("30(02[0&i]02[1&i])", byArray, aSN1Array[2].beg, aSN1Array[2].len, aSN1Array);
                bigIntegerArray[0] = (BigInteger)aSN1Array[0].obj;
                bigIntegerArray[1] = (BigInteger)aSN1Array[1].obj;
                return new CL3(bigIntegerArray, 5);
            }
            if (n == 1 || n == 2) {
                ASN1.scan("30(02[0]02[1&i]02[2&i]02[3&i]02[4&i]02[5&i]02[6&i]02[7&i]02[8&i])", byArray, aSN1Array[2].beg, aSN1Array[2].len, aSN1Array);
                if (aSN1Array[0].len != 1 || byArray[aSN1Array[0].beg] != 0) {
                    throw new CL3Exception(0x1000080);
                }
                BigInteger[] bigIntegerArray = new BigInteger[8];
                int n6 = 0;
                while (n6 < 8) {
                    bigIntegerArray[n6] = (BigInteger)aSN1Array[1 + n6].obj;
                    ++n6;
                }
                return new CL3(bigIntegerArray, 6);
            }
        } else {
            int n7 = aSN1Array[0].oidCRC();
            if (n7 == 1316158055 || n7 == 1577026252) {
                if (n != 2 && n != 3 && n != 7) {
                    throw new CL3Exception(0x3000080);
                }
                ASN1.scan(n7 == 1316158055 ? "30(02[4&i]02[5&i]02[6&i])" : "30(02[4&i]02[6&i])", byArray, aSN1Array[1].beg, aSN1Array[1].len, aSN1Array);
                if (n != 7) {
                    ASN1.scan("02[7&i]", byArray, aSN1Array[2].beg, aSN1Array[2].len, aSN1Array);
                }
                int n8 = 12;
                BigInteger[] bigIntegerArray = new BigInteger[5];
                bigIntegerArray[0] = (BigInteger)aSN1Array[4].obj;
                int n9 = bigIntegerArray[0].bitLength();
                if (n9 % 64 != 0 || n9 < 512) {
                    throw new CL3Exception(0x8000080);
                }
                if (n7 == 1316158055) {
                    bigIntegerArray[1] = (BigInteger)aSN1Array[5].obj;
                    n8 = 8;
                }
                bigIntegerArray[2] = (BigInteger)aSN1Array[6].obj;
                if (n == 2) {
                    bigIntegerArray[4] = (BigInteger)aSN1Array[7].obj;
                    bigIntegerArray[3] = bigIntegerArray[2].modPow(bigIntegerArray[4], bigIntegerArray[0]);
                    n8 += 2;
                } else if (n == 3) {
                    bigIntegerArray[3] = (BigInteger)aSN1Array[7].obj;
                    ++n8;
                }
                return new CL3(bigIntegerArray, n8);
            }
            throw new CL3Exception(0x2000080);
        }
        throw new CL3Exception(0x3000080);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static byte[] exportKey(CL3 cL3, int n) {
        if (!(cL3.obj instanceof BigInteger[])) throw new CL3Exception(0xC000080);
        BigInteger[] bigIntegerArray = (BigInteger[])cL3.obj;
        int n2 = bigIntegerArray.length;
        ASN1[] aSN1Array = new ASN1[9];
        int n3 = 0;
        int n4 = 0;
        while (n4 < n2) {
            if (bigIntegerArray[n4] != null) {
                aSN1Array[n4] = new ASN1(1, bigIntegerArray[n4]);
                n3 += bigIntegerArray[n4].bitLength();
            }
            ++n4;
        }
        byte[] byArray = new byte[n2 * n3 / 8 + 128];
        if (n == 8) {
            if (cL3.type != 5 && cL3.type != 6 && cL3.type != 13 && cL3.type != 14) {
                throw new CL3Exception(0x3000080);
            }
            n4 = bigIntegerArray.length == 5 ? 602931200 : 3841;
            n3 = byArray.length;
            do {
                byte[] byArray2 = bigIntegerArray[n4 & 0xF].toByteArray();
                int n5 = n3;
                System.arraycopy((Object)byArray2, 0, (Object)byArray, n3 -= byArray2.length, byArray2.length);
                if (byArray[n3] == 0) {
                    ++n3;
                }
                CL3.msbf2(n5 - n3, byArray, n3 -= 2);
            } while ((n4 >>= 4) != 15);
        } else {
            if (n != 3 && n != 1 && n != 2 && n != 7 || n == 1 && n2 != 8 || (n == 2 || n == 1) && n2 != 8 && n2 != 5) {
                throw new CL3Exception(0x3000080);
            }
            if (n2 == 8 || n2 == 2) {
                aSN1Array[8] = new ASN1(3, "1.2.840.113549.1.1.1");
                n3 = ASN1.format(n == 3 ? "30(30(06[8&]0500)03(00 30(02[0&]02[1&])))" : (n == 1 ? "30(02010002[0&]02[1&]02[2&]02[3&]02[4&]02[5&]02[6&]02[7&])" : "30(02010030(06[8&]0500)04(30(02010002[0&]02[1&]02[2&]02[3&]02[4&]02[5&]02[6&]02[7&])))"), byArray, -1, aSN1Array);
            } else {
                if (n2 != 5) throw new CL3Exception(0x3000080);
                aSN1Array[8] = new ASN1(3, bigIntegerArray[1] != null ? "1.2.840.10040.4.1" : "1.2.840.113549.1.3.1");
                n3 = ASN1.format(n == 2 ? "30(020100 30(06[8&]30(02[0&]02?[1&]02[2&]))04(02[4&]))" : (n == 3 ? "30(30(06[8&]30(02[0&]02?[1&]02[2&]))03(00 02[3&]))" : "30(06[8&]30(02[0&]02?[1&]02[2&]))"), byArray, -1, aSN1Array);
            }
        }
        byte[] byArray3 = new byte[byArray.length - n3];
        System.arraycopy((Object)byArray, n3, (Object)byArray3, 0, byArray3.length);
        return byArray3;
    }

    public static final int getSize(CL3 cL3) {
        if (cL3.obj instanceof BigInteger[]) {
            return (((BigInteger[])cL3.obj)[0].bitLength() + 7) / 8;
        }
        throw new CL3Exception(0x3000080);
    }

    static final int msbf(byte[] byArray, int n, int n2) {
        int n3 = 0;
        do {
            n3 |= (byArray[n++] & 0xFF) << --n2 * 8;
        } while (n2 > 0);
        return n3;
    }

    static final int msbf2(byte[] byArray, int n) {
        return (byArray[n] & 0xFF) << 8 | byArray[n + 1] & 0xFF;
    }

    static final void msbf(int n, byte[] byArray, int n2, int n3) {
        do {
            byArray[n2++] = (byte)(n >>> --n3 * 8);
        } while (n3 > 0);
    }

    static final void lsbf2(int n, byte[] byArray, int n2) {
        byArray[n2] = (byte)n;
        byArray[n2 + 1] = (byte)(n >>> 8);
    }

    static final void msbf2(int n, byte[] byArray, int n2) {
        byArray[n2] = (byte)(n >>> 8);
        byArray[n2 + 1] = (byte)n;
    }

    static final int msbf4(byte[] byArray, int n) {
        return byArray[n] << 24 | (byArray[n + 1] & 0xFF) << 16 | (byArray[n + 2] & 0xFF) << 8 | byArray[n + 3] & 0xFF;
    }

    static final void msbf4(int n, byte[] byArray, int n2) {
        byArray[n2] = (byte)(n >>> 24);
        byArray[n2 + 1] = (byte)(n >>> 16);
        byArray[n2 + 2] = (byte)(n >>> 8);
        byArray[n2 + 3] = (byte)n;
    }

    static final int lsbf(byte[] byArray, int n, int n2) {
        int n3 = 0;
        do {
            n3 |= (byArray[n + --n2] & 0xFF) << n2 * 8;
        } while (n2 > 0);
        return n3;
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

    static final byte[] getBytes(String string) {
        int n = string.length();
        byte[] byArray = new byte[n * 7 / 8];
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        do {
            n5 = (n5 << 7) + string.charAt(n3);
            if ((n4 += 7) < 8) continue;
            byArray[n2++] = (byte)(n5 >> (n4 -= 8));
        } while (++n3 < n);
        return byArray;
    }

    public static CL3 md2Init(CL3 cL3) {
        if (cL3 == null) {
            cL3 = new CL3(new byte[64], 16);
        } else {
            int n = 63;
            byte[] byArray = (byte[])cL3.obj;
            do {
                byArray[n] = 0;
            } while (--n >= 0);
        }
        return cL3;
    }

    public static void md2(CL3 cL3, byte[] byArray, int n, int n2, byte[] byArray2, int n3) {
        if (byArray2 == null && (n2 &= 0xFFFFFFF0) == 0) {
            return;
        }
        byte[] byArray3 = Pmd2;
        byte[] byArray4 = cL3 == null ? new byte[64] : (byte[])cL3.obj;
        int n4 = 0;
        n2 += n;
        do {
            int n5;
            int n6 = n;
            int n7 = 16;
            if ((n += 16) > n2) {
                if (n4 == 0) {
                    n4 = n - n2;
                    n7 = n5 = n2 - n6;
                    do {
                        byArray4[16 + n5] = (byte)n4;
                    } while (++n5 < 16);
                } else {
                    byArray = byArray4;
                    n6 = 48;
                    n4 = 48;
                }
            }
            System.arraycopy((Object)byArray, n6, (Object)byArray4, 16, n7);
            n5 = 0;
            int n8 = byArray4[63] & 0xFF;
            do {
                int n9 = byArray4[16 + n5] & 0xFF;
                int n10 = 48 + n5;
                byte by = (byte)(byArray4[n10] ^ byArray3[n9 ^ n8]);
                byArray4[n10] = by;
                n8 = by & 0xFF;
                byArray4[32 + n5] = (byte)(byArray4[n5] ^ n9);
            } while (++n5 < 16);
            n8 = 0;
            n5 = 0;
            do {
                n7 = 0;
                do {
                    int n11 = n7 + 2;
                    int n12 = n7 + 1;
                    int n13 = n7;
                    byte by = (byte)(byArray4[n13] ^ byArray3[n8]);
                    byArray4[n13] = by;
                    byte by2 = (byte)(byArray4[n12] ^ byArray3[by & 0xFF]);
                    byArray4[n12] = by2;
                    byte by3 = (byte)(byArray4[n11] ^ byArray3[by2 & 0xFF]);
                    byArray4[n11] = by3;
                    n8 = by3 & 0xFF;
                } while ((n7 += 3) < 48);
                n8 = n8 + n5 & 0xFF;
            } while (++n5 < 18);
        } while (n < n2 || byArray2 != null && n4 != 48);
        if (byArray2 != null) {
            System.arraycopy((Object)byArray4, 0, (Object)byArray2, n3, 16);
        }
    }

    public static CL3 md5CopyState(CL3 cL3) {
        CL3 cL32 = new CL3(new int[21], 17);
        int[] nArray = (int[])cL32.obj;
        int[] nArray2 = (int[])cL3.obj;
        System.arraycopy((Object)nArray2, 0, (Object)nArray, 0, nArray2.length);
        return cL32;
    }

    public static CL3 md5Init(CL3 cL3) {
        int[] nArray;
        if (cL3 == null) {
            nArray = new int[21];
            cL3 = new CL3(nArray, 17);
        } else {
            nArray = (int[])cL3.obj;
        }
        nArray[0] = 19088743;
        nArray[1] = -1985229329;
        nArray[2] = -19088744;
        nArray[3] = 1985229328;
        nArray[4] = 0;
        return cL3;
    }

    public static void md5(CL3 cL3, byte[] byArray, int n, int n2, byte[] byArray2, int n3) {
        int n4;
        int n5;
        int n6;
        int n7;
        int[] nArray;
        int[] nArray2 = null;
        int n8 = n + (n2 & 0xFFFFFFFC);
        boolean bl = false;
        boolean bl2 = false;
        if (cL3 != null) {
            nArray2 = (int[])cL3.obj;
            nArray = nArray2;
            n7 = nArray2[0];
            n6 = nArray2[1];
            n5 = nArray2[2];
            n4 = nArray2[3];
            n2 += nArray2[4];
        } else {
            nArray = new int[21];
            n7 = 19088743;
            n6 = -1985229329;
            n5 = -19088744;
            n4 = 1985229328;
        }
        do {
            int n9;
            int n10 = 5;
            while (n10 < 21 && n < n8) {
                nArray[n10++] = CL3.lsbf4(byArray, n);
                n += 4;
            }
            if (n10 < 21) {
                if (byArray2 == null) break;
                if (!bl2) {
                    n9 = n2 % 4;
                    int n11 = nArray[n10++] = n9 != 0 ? CL3.lsbf(byArray, n, n9) | 128 << n9 * 8 : 128;
                    if (n10 == 20) {
                        nArray[20] = 0;
                    }
                    bl2 = true;
                }
                if (n10 <= 19) {
                    while (n10 < 19) {
                        nArray[n10++] = 0;
                    }
                    nArray[19] = n2 << 3;
                    nArray[20] = n2 >>> 29;
                    bl = true;
                }
            }
            n9 = n7;
            int n12 = n4;
            int n13 = n5;
            int n14 = n6;
            int n15 = nArray[5];
            n7 += ((n5 ^ n4) & n6 ^ n4) + n15 + 2024041175;
            n7 = (n7 << 7 | n7 >>> 25) + n6;
            int n16 = nArray[6];
            n4 += ((n6 ^ n5) & n7 ^ n5) + n16 + 1454884840;
            n4 = (n4 << 12 | n4 >>> 20) + n7;
            int n17 = nArray[7];
            n5 += ((n7 ^ n6) & n4 ^ n6) + n17 + -613408732;
            n5 = (n5 << 17 | n5 >>> 15) + n4;
            int n18 = nArray[8];
            n6 += ((n4 ^ n7) & n5 ^ n7) + n18 + -288440895;
            n6 = (n6 << 22 | n6 >>> 10) + n5;
            int n19 = nArray[9];
            n7 += ((n5 ^ n4) & n6 ^ n4) + n19 + -1357939467;
            n7 = (n7 << 7 | n7 >>> 25) + n6;
            int n20 = nArray[10];
            n4 += ((n6 ^ n5) & n7 ^ n5) + n20 + 717653831;
            n4 = (n4 << 12 | n4 >>> 20) + n7;
            int n21 = nArray[11];
            n5 += ((n7 ^ n6) & n4 ^ n6) + n21 + 323367080;
            n5 = (n5 << 17 | n5 >>> 15) + n4;
            int n22 = nArray[12];
            n6 += ((n4 ^ n7) & n5 ^ n7) + n22 + 26560253;
            n6 = (n6 << 22 | n6 >>> 10) + n5;
            int n23 = nArray[13];
            n7 += ((n5 ^ n4) & n6 ^ n4) + n23 + -661094295;
            n7 = (n7 << 7 | n7 >>> 25) + n6;
            int n24 = nArray[14];
            n4 += ((n6 ^ n5) & n7 ^ n5) + n24 + -1342749557;
            n4 = (n4 << 12 | n4 >>> 20) + n7;
            int n25 = nArray[15];
            n5 += ((n7 ^ n6) & n4 ^ n6) + n25 + -1319370753;
            n5 = (n5 << 17 | n5 >>> 15) + n4;
            int n26 = nArray[16];
            n6 += ((n4 ^ n7) & n5 ^ n7) + n26 + -1093182327;
            n6 = (n6 << 22 | n6 >>> 10) + n5;
            int n27 = nArray[17];
            n7 += ((n5 ^ n4) & n6 ^ n4) + n27 + 571576427;
            n7 = (n7 << 7 | n7 >>> 25) + n6;
            int n28 = nArray[18];
            n4 += ((n6 ^ n5) & n7 ^ n5) + n28 + -1821271811;
            n4 = (n4 << 12 | n4 >>> 20) + n7;
            int n29 = nArray[19];
            n5 += ((n7 ^ n6) & n4 ^ n6) + n29 + -1908180570;
            n5 = (n5 << 17 | n5 >>> 15) + n4;
            int n30 = nArray[20];
            n6 += ((n4 ^ n7) & n5 ^ n7) + n30 + 554218569;
            n6 = (n6 << 22 | n6 >>> 10) + n5;
            n7 += ((n6 ^ n5) & n4 ^ n5) + n16 + 1646599926;
            n7 = (n7 << 5 | n7 >>> 27) + n6;
            n4 += ((n7 ^ n6) & n5 ^ n6) + n21 + 1085489344;
            n4 = (n4 << 9 | n4 >>> 23) + n7;
            n5 += ((n4 ^ n7) & n6 ^ n7) + n26 + 1364876838;
            n5 = (n5 << 14 | n5 >>> 18) + n4;
            n6 += ((n5 ^ n4) & n7 ^ n4) + n15 + -1429752087;
            n6 = (n6 << 20 | n6 >>> 12) + n5;
            n7 += ((n6 ^ n5) & n4 ^ n5) + n20 + 1561341910;
            n7 = (n7 << 5 | n7 >>> 27) + n6;
            n4 += ((n7 ^ n6) & n5 ^ n6) + n25 + 1393837058;
            n4 = (n4 << 9 | n4 >>> 23) + n7;
            n5 += ((n4 ^ n7) & n6 ^ n7) + n30 + -2115591720;
            n5 = (n5 << 14 | n5 >>> 18) + n4;
            n6 += ((n5 ^ n4) & n7 ^ n4) + n19 + -923020313;
            n6 = (n6 << 20 | n6 >>> 12) + n5;
            n7 += ((n6 ^ n5) & n4 ^ n5) + n24 + -422715103;
            n7 = (n7 << 5 | n7 >>> 27) + n6;
            n4 += ((n7 ^ n6) & n5 ^ n6) + n29 + -704170045;
            n4 = (n4 << 9 | n4 >>> 23) + n7;
            n5 += ((n4 ^ n7) & n6 ^ n7) + n18 + -2029136396;
            n5 = (n5 << 14 | n5 >>> 18) + n4;
            n6 += ((n5 ^ n4) & n7 ^ n4) + n23 + -317433275;
            n6 = (n6 << 20 | n6 >>> 12) + n5;
            n7 += ((n6 ^ n5) & n4 ^ n5) + n28 + 99214249;
            n7 = (n7 << 5 | n7 >>> 27) + n6;
            n4 += ((n7 ^ n6) & n5 ^ n6) + n17 + -123473924;
            n4 = (n4 << 9 | n4 >>> 23) + n7;
            n5 += ((n4 ^ n7) & n6 ^ n7) + n22 + -654151833;
            n5 = (n5 << 14 | n5 >>> 18) + n4;
            n6 += ((n5 ^ n4) & n7 ^ n4) + n27 + -1974719859;
            n6 = (n6 << 20 | n6 >>> 12) + n5;
            n7 += (n6 ^ n5 ^ n4) + n20 + 1111096063;
            n7 = (n7 << 4 | n7 >>> 28) + n6;
            n4 += (n7 ^ n6 ^ n5) + n23 + -2114555513;
            n4 = (n4 << 11 | n4 >>> 21) + n7;
            n5 += (n4 ^ n7 ^ n6) + n26 + 576822637;
            n5 = (n5 << 16 | n5 >>> 16) + n4;
            n6 += (n5 ^ n4 ^ n7) + n29 + 205055485;
            n6 = (n6 << 23 | n6 >>> 9) + n5;
            n7 += (n6 ^ n5 ^ n4) + n16 + 1156234916;
            n7 = (n7 << 4 | n7 >>> 28) + n6;
            n4 += (n7 ^ n6 ^ n5) + n19 + -1445994933;
            n4 = (n4 << 11 | n4 >>> 21) + n7;
            n5 += (n4 ^ n7 ^ n6) + n22 + 1615576054;
            n5 = (n5 << 16 | n5 >>> 16) + n4;
            n6 += (n5 ^ n4 ^ n7) + n25 + 1891418046;
            n6 = (n6 << 23 | n6 >>> 9) + n5;
            n7 += (n6 ^ n5 ^ n4) + n28 + -964781272;
            n7 = (n7 << 4 | n7 >>> 28) + n6;
            n4 += (n7 ^ n6 ^ n5) + n15 + -98065942;
            n4 = (n4 << 11 | n4 >>> 21) + n7;
            n5 += (n4 ^ n7 ^ n6) + n18 + -2060390444;
            n5 = (n5 << 16 | n5 >>> 16) + n4;
            n6 += (n5 ^ n4 ^ n7) + n21 + 85821444;
            n6 = (n6 << 23 | n6 >>> 9) + n5;
            n7 += (n6 ^ n5 ^ n4) + n24 + 969987289;
            n7 = (n7 << 4 | n7 >>> 28) + n6;
            n4 += (n7 ^ n6 ^ n5) + n27 + -442901530;
            n4 = (n4 << 11 | n4 >>> 21) + n7;
            n5 += (n4 ^ n7 ^ n6) + n30 + -126049761;
            n5 = (n5 << 16 | n5 >>> 16) + n4;
            n6 += (n5 ^ n4 ^ n7) + n17 + 1700179140;
            n6 = (n6 << 23 | n6 >>> 9) + n5;
            n7 += (n5 ^ (n6 | ~n4)) + n15 + 1143089652;
            n7 = (n7 << 6 | n7 >>> 26) + n6;
            n4 += (n6 ^ (n7 | ~n5)) + n22 + -1744885181;
            n4 = (n4 << 10 | n4 >>> 22) + n7;
            n5 += (n7 ^ (n4 | ~n6)) + n29 + -1490840405;
            n5 = (n5 << 15 | n5 >>> 17) + n4;
            n6 += (n4 ^ (n5 | ~n7)) + n20 + 966824956;
            n6 = (n6 << 21 | n6 >>> 11) + n5;
            n7 += (n5 ^ (n6 | ~n4)) + n27 + -1017554075;
            n7 = (n7 << 6 | n7 >>> 26) + n6;
            n4 += (n6 ^ (n7 | ~n5)) + n18 + -1832121201;
            n4 = (n4 << 10 | n4 >>> 22) + n7;
            n5 += (n7 ^ (n4 | ~n6)) + n25 + 2113204223;
            n5 = (n5 << 15 | n5 >>> 17) + n4;
            n6 += (n4 ^ (n5 | ~n7)) + n16 + -782400379;
            n6 = (n6 << 21 | n6 >>> 11) + n5;
            n7 += (n5 ^ (n6 | ~n4)) + n23 + 1333700719;
            n7 = (n7 << 6 | n7 >>> 26) + n6;
            n4 += (n6 ^ (n7 | ~n5)) + n30 + -521786114;
            n4 = (n4 << 10 | n4 >>> 22) + n7;
            n5 += (n7 ^ (n4 | ~n6)) + n21 + 339935651;
            n5 = (n5 << 15 | n5 >>> 17) + n4;
            n6 += (n4 ^ (n5 | ~n7)) + n28 + -1592719282;
            n6 = (n6 << 21 | n6 >>> 11) + n5;
            n7 += (n5 ^ (n6 | ~n4)) + n19 + -2105650185;
            n7 = (n7 << 6 | n7 >>> 26) + n6;
            n4 += (n6 ^ (n7 | ~n5)) + n26 + 905067197;
            n4 = (n4 << 10 | n4 >>> 22) + n7;
            n5 += (n7 ^ (n4 | ~n6)) + n17 + -1143810262;
            n5 = (n5 << 15 | n5 >>> 17) + n4;
            n6 += (n4 ^ (n5 | ~n7)) + n24 + -1848408341;
            n6 = (n6 << 21 | n6 >>> 11) + n5;
            n7 += n9;
            n6 += n14;
            n5 += n13;
            n4 += n12;
        } while (!bl);
        if (byArray2 == null) {
            nArray2[0] = n7;
            nArray2[1] = n6;
            nArray2[2] = n5;
            nArray2[3] = n4;
            nArray2[4] = n2;
        } else {
            CL3.lsbf4(n7, byArray2, n3);
            CL3.lsbf4(n6, byArray2, n3 + 4);
            CL3.lsbf4(n5, byArray2, n3 + 8);
            CL3.lsbf4(n4, byArray2, n3 + 12);
        }
    }

    public static CL3 shaInit(CL3 cL3) {
        int[] nArray;
        if (cL3 == null) {
            nArray = new int[86];
            cL3 = new CL3(nArray, 18);
        } else {
            nArray = (int[])cL3.obj;
        }
        nArray[80] = 19088743;
        nArray[81] = -1985229329;
        nArray[82] = -19088744;
        nArray[83] = 1985229328;
        nArray[84] = -253635901;
        nArray[85] = 0;
        return cL3;
    }

    public static void sha(CL3 cL3, byte[] byArray, int n, int n2, byte[] byArray2, int n3) {
        int n4;
        int n5;
        int n6;
        int n7;
        int n8;
        int n9;
        int n10;
        int n11;
        int n12;
        int n13;
        int[] nArray;
        int[] nArray2;
        int n14 = n + (n2 & 0xFFFFFFFC);
        int n15 = 0;
        if (cL3 != null) {
            nArray = nArray2 = (int[])cL3.obj;
            n12 = n13 = nArray2[80];
            n10 = n11 = nArray2[81];
            n8 = n9 = nArray2[82];
            n6 = n7 = nArray2[83];
            n4 = n5 = nArray2[84];
            n2 += nArray2[85];
        } else {
            nArray2 = null;
            nArray = new int[80];
            n13 = 19088743;
            n12 = 19088743;
            n11 = -1985229329;
            n10 = -1985229329;
            n9 = -19088744;
            n8 = -19088744;
            n7 = 1985229328;
            n6 = 1985229328;
            n5 = -253635901;
            n4 = -253635901;
        }
        while (true) {
            int n16;
            int n17 = 0;
            while (n17 < 16 && n < n14) {
                nArray[n17++] = CL3.msbf4(byArray, n);
                n += 4;
            }
            if (n17 < 16) {
                if (n15 < 0) {
                    CL3.msbf4(n12, byArray2, n3);
                    CL3.msbf4(n10, byArray2, n3 + 4);
                    CL3.msbf4(n8, byArray2, n3 + 8);
                    CL3.msbf4(n6, byArray2, n3 + 12);
                    CL3.msbf4(n4, byArray2, n3 + 16);
                    return;
                }
                if (n15 == 0) {
                    if (byArray2 == null) {
                        nArray2[80] = n12;
                        nArray2[81] = n10;
                        nArray2[82] = n8;
                        nArray2[83] = n6;
                        nArray2[84] = n4;
                        nArray2[85] = n2 & 0xFFFFFFC0;
                        return;
                    }
                    n15 = 1;
                    n16 = 128;
                    n14 = n2 % 4;
                    if (n14 != 0) {
                        do {
                            n16 = n16 >>> 8 | byArray[--n14 + n] << 24;
                        } while (n14 > 0);
                    }
                    nArray[15] = 0;
                    nArray[n17++] = n16;
                }
                if (n17 <= 14) {
                    while (n17 < 14) {
                        nArray[n17++] = 0;
                    }
                    nArray[14] = n2 >>> 29;
                    nArray[15] = n2 << 3;
                    n15 = -1;
                }
                n17 = 16;
            }
            do {
                n16 = nArray[n17 - 3] ^ nArray[n17 - 8] ^ nArray[n17 - 14] ^ nArray[n17 - 16];
                nArray[n17] = n16 << 1 | n16 >>> 31;
            } while (++n17 < 80);
            n4 += -1720090022 + nArray[0] + (n12 << 5 | n12 >>> 27) + ((n8 ^ n6) & n10 ^ n6);
            n10 = n10 << 30 | n10 >>> 2;
            n6 += -1720090022 + nArray[1] + (n4 << 5 | n4 >>> 27) + ((n10 ^ n8) & n12 ^ n8);
            n12 = n12 << 30 | n12 >>> 2;
            n8 += -1720090022 + nArray[2] + (n6 << 5 | n6 >>> 27) + ((n12 ^ n10) & n4 ^ n10);
            n4 = n4 << 30 | n4 >>> 2;
            n10 += -1720090022 + nArray[3] + (n8 << 5 | n8 >>> 27) + ((n4 ^ n12) & n6 ^ n12);
            n6 = n6 << 30 | n6 >>> 2;
            n12 += -1720090022 + nArray[4] + (n10 << 5 | n10 >>> 27) + ((n6 ^ n4) & n8 ^ n4);
            n8 = n8 << 30 | n8 >>> 2;
            n4 += -1720090022 + nArray[5] + (n12 << 5 | n12 >>> 27) + ((n8 ^ n6) & n10 ^ n6);
            n10 = n10 << 30 | n10 >>> 2;
            n6 += -1720090022 + nArray[6] + (n4 << 5 | n4 >>> 27) + ((n10 ^ n8) & n12 ^ n8);
            n12 = n12 << 30 | n12 >>> 2;
            n8 += -1720090022 + nArray[7] + (n6 << 5 | n6 >>> 27) + ((n12 ^ n10) & n4 ^ n10);
            n4 = n4 << 30 | n4 >>> 2;
            n10 += -1720090022 + nArray[8] + (n8 << 5 | n8 >>> 27) + ((n4 ^ n12) & n6 ^ n12);
            n6 = n6 << 30 | n6 >>> 2;
            n12 += -1720090022 + nArray[9] + (n10 << 5 | n10 >>> 27) + ((n6 ^ n4) & n8 ^ n4);
            n8 = n8 << 30 | n8 >>> 2;
            n4 += -1720090022 + nArray[10] + (n12 << 5 | n12 >>> 27) + ((n8 ^ n6) & n10 ^ n6);
            n10 = n10 << 30 | n10 >>> 2;
            n6 += -1720090022 + nArray[11] + (n4 << 5 | n4 >>> 27) + ((n10 ^ n8) & n12 ^ n8);
            n12 = n12 << 30 | n12 >>> 2;
            n8 += -1720090022 + nArray[12] + (n6 << 5 | n6 >>> 27) + ((n12 ^ n10) & n4 ^ n10);
            n4 = n4 << 30 | n4 >>> 2;
            n10 += -1720090022 + nArray[13] + (n8 << 5 | n8 >>> 27) + ((n4 ^ n12) & n6 ^ n12);
            n6 = n6 << 30 | n6 >>> 2;
            n12 += -1720090022 + nArray[14] + (n10 << 5 | n10 >>> 27) + ((n6 ^ n4) & n8 ^ n4);
            n8 = n8 << 30 | n8 >>> 2;
            n4 += -1720090022 + nArray[15] + (n12 << 5 | n12 >>> 27) + ((n8 ^ n6) & n10 ^ n6);
            n10 = n10 << 30 | n10 >>> 2;
            n6 += -1720090022 + nArray[16] + (n4 << 5 | n4 >>> 27) + ((n10 ^ n8) & n12 ^ n8);
            n12 = n12 << 30 | n12 >>> 2;
            n8 += -1720090022 + nArray[17] + (n6 << 5 | n6 >>> 27) + ((n12 ^ n10) & n4 ^ n10);
            n4 = n4 << 30 | n4 >>> 2;
            n10 += -1720090022 + nArray[18] + (n8 << 5 | n8 >>> 27) + ((n4 ^ n12) & n6 ^ n12);
            n6 = n6 << 30 | n6 >>> 2;
            n12 += -1720090022 + nArray[19] + (n10 << 5 | n10 >>> 27) + ((n6 ^ n4) & n8 ^ n4);
            n8 = n8 << 30 | n8 >>> 2;
            n4 += -1578378898 + nArray[20] + (n12 << 5 | n12 >>> 27) + (n10 ^ n8 ^ n6);
            n10 = n10 << 30 | n10 >>> 2;
            n6 += -1578378898 + nArray[21] + (n4 << 5 | n4 >>> 27) + (n12 ^ n10 ^ n8);
            n12 = n12 << 30 | n12 >>> 2;
            n8 += -1578378898 + nArray[22] + (n6 << 5 | n6 >>> 27) + (n4 ^ n12 ^ n10);
            n4 = n4 << 30 | n4 >>> 2;
            n10 += -1578378898 + nArray[23] + (n8 << 5 | n8 >>> 27) + (n6 ^ n4 ^ n12);
            n6 = n6 << 30 | n6 >>> 2;
            n12 += -1578378898 + nArray[24] + (n10 << 5 | n10 >>> 27) + (n8 ^ n6 ^ n4);
            n8 = n8 << 30 | n8 >>> 2;
            n4 += -1578378898 + nArray[25] + (n12 << 5 | n12 >>> 27) + (n10 ^ n8 ^ n6);
            n10 = n10 << 30 | n10 >>> 2;
            n6 += -1578378898 + nArray[26] + (n4 << 5 | n4 >>> 27) + (n12 ^ n10 ^ n8);
            n12 = n12 << 30 | n12 >>> 2;
            n8 += -1578378898 + nArray[27] + (n6 << 5 | n6 >>> 27) + (n4 ^ n12 ^ n10);
            n4 = n4 << 30 | n4 >>> 2;
            n10 += -1578378898 + nArray[28] + (n8 << 5 | n8 >>> 27) + (n6 ^ n4 ^ n12);
            n6 = n6 << 30 | n6 >>> 2;
            n12 += -1578378898 + nArray[29] + (n10 << 5 | n10 >>> 27) + (n8 ^ n6 ^ n4);
            n8 = n8 << 30 | n8 >>> 2;
            n4 += -1578378898 + nArray[30] + (n12 << 5 | n12 >>> 27) + (n10 ^ n8 ^ n6);
            n10 = n10 << 30 | n10 >>> 2;
            n6 += -1578378898 + nArray[31] + (n4 << 5 | n4 >>> 27) + (n12 ^ n10 ^ n8);
            n12 = n12 << 30 | n12 >>> 2;
            n8 += -1578378898 + nArray[32] + (n6 << 5 | n6 >>> 27) + (n4 ^ n12 ^ n10);
            n4 = n4 << 30 | n4 >>> 2;
            n10 += -1578378898 + nArray[33] + (n8 << 5 | n8 >>> 27) + (n6 ^ n4 ^ n12);
            n6 = n6 << 30 | n6 >>> 2;
            n12 += -1578378898 + nArray[34] + (n10 << 5 | n10 >>> 27) + (n8 ^ n6 ^ n4);
            n8 = n8 << 30 | n8 >>> 2;
            n4 += -1578378898 + nArray[35] + (n12 << 5 | n12 >>> 27) + (n10 ^ n8 ^ n6);
            n10 = n10 << 30 | n10 >>> 2;
            n6 += -1578378898 + nArray[36] + (n4 << 5 | n4 >>> 27) + (n12 ^ n10 ^ n8);
            n12 = n12 << 30 | n12 >>> 2;
            n8 += -1578378898 + nArray[37] + (n6 << 5 | n6 >>> 27) + (n4 ^ n12 ^ n10);
            n4 = n4 << 30 | n4 >>> 2;
            n10 += -1578378898 + nArray[38] + (n8 << 5 | n8 >>> 27) + (n6 ^ n4 ^ n12);
            n6 = n6 << 30 | n6 >>> 2;
            n12 += -1578378898 + nArray[39] + (n10 << 5 | n10 >>> 27) + (n8 ^ n6 ^ n4);
            n8 = n8 << 30 | n8 >>> 2;
            n4 += -591651953 + nArray[40] + (n12 << 5 | n12 >>> 27) + ((n10 ^ n6) & (n8 ^ n6) ^ n6);
            n10 = n10 << 30 | n10 >>> 2;
            n6 += -591651953 + nArray[41] + (n4 << 5 | n4 >>> 27) + ((n12 ^ n8) & (n10 ^ n8) ^ n8);
            n12 = n12 << 30 | n12 >>> 2;
            n8 += -591651953 + nArray[42] + (n6 << 5 | n6 >>> 27) + ((n4 ^ n10) & (n12 ^ n10) ^ n10);
            n4 = n4 << 30 | n4 >>> 2;
            n10 += -591651953 + nArray[43] + (n8 << 5 | n8 >>> 27) + ((n6 ^ n12) & (n4 ^ n12) ^ n12);
            n6 = n6 << 30 | n6 >>> 2;
            n12 += -591651953 + nArray[44] + (n10 << 5 | n10 >>> 27) + ((n8 ^ n4) & (n6 ^ n4) ^ n4);
            n8 = n8 << 30 | n8 >>> 2;
            n4 += -591651953 + nArray[45] + (n12 << 5 | n12 >>> 27) + ((n10 ^ n6) & (n8 ^ n6) ^ n6);
            n10 = n10 << 30 | n10 >>> 2;
            n6 += -591651953 + nArray[46] + (n4 << 5 | n4 >>> 27) + ((n12 ^ n8) & (n10 ^ n8) ^ n8);
            n12 = n12 << 30 | n12 >>> 2;
            n8 += -591651953 + nArray[47] + (n6 << 5 | n6 >>> 27) + ((n4 ^ n10) & (n12 ^ n10) ^ n10);
            n4 = n4 << 30 | n4 >>> 2;
            n10 += -591651953 + nArray[48] + (n8 << 5 | n8 >>> 27) + ((n6 ^ n12) & (n4 ^ n12) ^ n12);
            n6 = n6 << 30 | n6 >>> 2;
            n12 += -591651953 + nArray[49] + (n10 << 5 | n10 >>> 27) + ((n8 ^ n4) & (n6 ^ n4) ^ n4);
            n8 = n8 << 30 | n8 >>> 2;
            n4 += -591651953 + nArray[50] + (n12 << 5 | n12 >>> 27) + ((n10 ^ n6) & (n8 ^ n6) ^ n6);
            n10 = n10 << 30 | n10 >>> 2;
            n6 += -591651953 + nArray[51] + (n4 << 5 | n4 >>> 27) + ((n12 ^ n8) & (n10 ^ n8) ^ n8);
            n12 = n12 << 30 | n12 >>> 2;
            n8 += -591651953 + nArray[52] + (n6 << 5 | n6 >>> 27) + ((n4 ^ n10) & (n12 ^ n10) ^ n10);
            n4 = n4 << 30 | n4 >>> 2;
            n10 += -591651953 + nArray[53] + (n8 << 5 | n8 >>> 27) + ((n6 ^ n12) & (n4 ^ n12) ^ n12);
            n6 = n6 << 30 | n6 >>> 2;
            n12 += -591651953 + nArray[54] + (n10 << 5 | n10 >>> 27) + ((n8 ^ n4) & (n6 ^ n4) ^ n4);
            n8 = n8 << 30 | n8 >>> 2;
            n4 += -591651953 + nArray[55] + (n12 << 5 | n12 >>> 27) + ((n10 ^ n6) & (n8 ^ n6) ^ n6);
            n10 = n10 << 30 | n10 >>> 2;
            n6 += -591651953 + nArray[56] + (n4 << 5 | n4 >>> 27) + ((n12 ^ n8) & (n10 ^ n8) ^ n8);
            n12 = n12 << 30 | n12 >>> 2;
            n8 += -591651953 + nArray[57] + (n6 << 5 | n6 >>> 27) + ((n4 ^ n10) & (n12 ^ n10) ^ n10);
            n4 = n4 << 30 | n4 >>> 2;
            n10 += -591651953 + nArray[58] + (n8 << 5 | n8 >>> 27) + ((n6 ^ n12) & (n4 ^ n12) ^ n12);
            n6 = n6 << 30 | n6 >>> 2;
            n12 += -591651953 + nArray[59] + (n10 << 5 | n10 >>> 27) + ((n8 ^ n4) & (n6 ^ n4) ^ n4);
            n8 = n8 << 30 | n8 >>> 2;
            n4 += -691969334 + nArray[60] + (n12 << 5 | n12 >>> 27) + (n10 ^ n8 ^ n6);
            n10 = n10 << 30 | n10 >>> 2;
            n6 += -691969334 + nArray[61] + (n4 << 5 | n4 >>> 27) + (n12 ^ n10 ^ n8);
            n12 = n12 << 30 | n12 >>> 2;
            n8 += -691969334 + nArray[62] + (n6 << 5 | n6 >>> 27) + (n4 ^ n12 ^ n10);
            n4 = n4 << 30 | n4 >>> 2;
            n10 += -691969334 + nArray[63] + (n8 << 5 | n8 >>> 27) + (n6 ^ n4 ^ n12);
            n6 = n6 << 30 | n6 >>> 2;
            n12 += -691969334 + nArray[64] + (n10 << 5 | n10 >>> 27) + (n8 ^ n6 ^ n4);
            n8 = n8 << 30 | n8 >>> 2;
            n4 += -691969334 + nArray[65] + (n12 << 5 | n12 >>> 27) + (n10 ^ n8 ^ n6);
            n10 = n10 << 30 | n10 >>> 2;
            n6 += -691969334 + nArray[66] + (n4 << 5 | n4 >>> 27) + (n12 ^ n10 ^ n8);
            n12 = n12 << 30 | n12 >>> 2;
            n8 += -691969334 + nArray[67] + (n6 << 5 | n6 >>> 27) + (n4 ^ n12 ^ n10);
            n4 = n4 << 30 | n4 >>> 2;
            n10 += -691969334 + nArray[68] + (n8 << 5 | n8 >>> 27) + (n6 ^ n4 ^ n12);
            n6 = n6 << 30 | n6 >>> 2;
            n12 += -691969334 + nArray[69] + (n10 << 5 | n10 >>> 27) + (n8 ^ n6 ^ n4);
            n8 = n8 << 30 | n8 >>> 2;
            n4 += -691969334 + nArray[70] + (n12 << 5 | n12 >>> 27) + (n10 ^ n8 ^ n6);
            n10 = n10 << 30 | n10 >>> 2;
            n6 += -691969334 + nArray[71] + (n4 << 5 | n4 >>> 27) + (n12 ^ n10 ^ n8);
            n12 = n12 << 30 | n12 >>> 2;
            n8 += -691969334 + nArray[72] + (n6 << 5 | n6 >>> 27) + (n4 ^ n12 ^ n10);
            n4 = n4 << 30 | n4 >>> 2;
            n10 += -691969334 + nArray[73] + (n8 << 5 | n8 >>> 27) + (n6 ^ n4 ^ n12);
            n6 = n6 << 30 | n6 >>> 2;
            n12 += -691969334 + nArray[74] + (n10 << 5 | n10 >>> 27) + (n8 ^ n6 ^ n4);
            n8 = n8 << 30 | n8 >>> 2;
            n4 += -691969334 + nArray[75] + (n12 << 5 | n12 >>> 27) + (n10 ^ n8 ^ n6);
            n10 = n10 << 30 | n10 >>> 2;
            n6 += -691969334 + nArray[76] + (n4 << 5 | n4 >>> 27) + (n12 ^ n10 ^ n8);
            n12 = n12 << 30 | n12 >>> 2;
            n8 += -691969334 + nArray[77] + (n6 << 5 | n6 >>> 27) + (n4 ^ n12 ^ n10);
            n4 = n4 << 30 | n4 >>> 2;
            n10 += -691969334 + nArray[78] + (n8 << 5 | n8 >>> 27) + (n6 ^ n4 ^ n12);
            n6 = n6 << 30 | n6 >>> 2;
            n12 += -691969334 + nArray[79] + (n10 << 5 | n10 >>> 27) + (n8 ^ n6 ^ n4);
            n8 = n8 << 30 | n8 >>> 2;
            n13 += n12;
            n12 = n13;
            n11 += n10;
            n10 = n11;
            n9 += n8;
            n8 = n9;
            n7 += n6;
            n6 = n7;
            n5 += n4;
            n4 = n5;
        }
    }

    public static void smallPrimes() {
        int[] nArray = new int[512];
        int[] nArray2 = new int[512];
        int n = 3;
        int n2 = 0;
        while (n2 < 512) {
            boolean bl = true;
            int n3 = 0;
            while (n3 < n2) {
                nArray[n3] = (nArray[n3] + 2) % nArray2[n3];
                if (nArray[n3] == 0) {
                    bl = false;
                }
                ++n3;
            }
            if (bl) {
                nArray2[n2++] = n;
            }
            n += 2;
        }
        Pi = nArray2;
    }

    protected static boolean isProbablePrime(BigInteger bigInteger, int n) {
        BigInteger bigInteger2 = BigInteger.valueOf(1);
        BigInteger bigInteger3 = bigInteger.subtract(bigInteger2);
        int n2 = (bigInteger.bitLength() + 7) / 8;
        byte[] byArray = new byte[n2];
        n = n < 2 ? 1 : (n + 1) / 2;
        int n3 = 0;
        BigInteger bigInteger4 = bigInteger.subtract(bigInteger2);
        n3 = bigInteger4.getLowestSetBit();
        if (n3 < 1) {
            throw new CL3Exception(0x3000080);
        }
        if (n3 > 0) {
            bigInteger4 = bigInteger4.shiftRight(n3);
        }
        block0: while (--n >= 0) {
            BigInteger bigInteger5;
            do {
                CL3.rng(null, byArray, 0, n2);
            } while ((bigInteger5 = new BigInteger(1, byArray).remainder(bigInteger)).compareTo(bigInteger2) <= 0);
            bigInteger5 = bigInteger5.modPow(bigInteger4, bigInteger);
            int n4 = 0;
            while (true) {
                if (bigInteger5.equals(bigInteger2)) {
                    if (n4 == 0) continue block0;
                    return false;
                }
                if (bigInteger5.equals(bigInteger3)) continue block0;
                if (++n4 >= n3) {
                    return false;
                }
                bigInteger5 = bigInteger5.multiply(bigInteger5).remainder(bigInteger);
            }
        }
        return true;
    }

    public static int dh(CL3 cL3, byte[] byArray, int n, int n2, byte[] byArray2, int n3) {
        BigInteger bigInteger;
        int n4;
        block8: {
            BigInteger[] bigIntegerArray;
            block9: {
                block6: {
                    block7: {
                        bigIntegerArray = (BigInteger[])cL3.obj;
                        n4 = (bigIntegerArray[0].bitLength() + 7) / 8;
                        if (byArray != null) break block6;
                        if (bigIntegerArray[3] == null) break block7;
                        bigInteger = bigIntegerArray[3];
                        break block8;
                    }
                    bigInteger = bigIntegerArray[2];
                    break block9;
                }
                if (n != 0 || n2 != byArray.length) {
                    byte[] byArray3 = byArray;
                    byArray = new byte[n2];
                    System.arraycopy((Object)byArray3, n, (Object)byArray, 0, n2);
                }
                bigInteger = new BigInteger(1, byArray);
            }
            bigInteger = bigInteger.modPow(bigIntegerArray[4], bigIntegerArray[0]);
            if (byArray == null) {
                bigIntegerArray[3] = bigInteger;
            }
        }
        byArray = bigInteger.toByteArray();
        n2 = byArray.length - n4;
        if (n2 != 0) {
            if (n2 < 0) {
                do {
                    byArray2[n3++] = 0;
                } while (++n2 < 0);
            } else {
                n2 = 1;
            }
        }
        System.arraycopy((Object)byArray, n2, (Object)byArray2, n3, byArray.length - n2);
        return n4;
    }

    private static BigInteger[] dhSharedParam(int n) {
        int n2;
        int n3;
        int n4;
        BigInteger[] bigIntegerArray = new BigInteger[5];
        if (n == -1) {
            n4 = 460062464;
            n3 = 0;
            n2 = 64;
        } else if (n == -2) {
            n4 = 659681024;
            n3 = 1;
            n2 = 128;
        } else if (n == -3) {
            n4 = -279125504;
            n3 = 2;
            n2 = 256;
        } else {
            throw new CL3Exception(0x3000080);
        }
        bigIntegerArray[0] = dhSP[n3];
        if (bigIntegerArray[0] == null) {
            byte[] byArray = new byte[n2];
            int n5 = n2 - 4;
            while (n5 >= 0) {
                byArray[n5] = -1;
                --n5;
            }
            CL3.msbf(n4, byArray, n2 - 3, 3);
            bigIntegerArray[0] = CL3.dhSP[n3] = new BigInteger(1, byArray);
        }
        bigIntegerArray[2] = BigInteger.valueOf(7);
        return bigIntegerArray;
    }

    public static CL3 dhImportParams(byte[] byArray, byte[] byArray2) {
        BigInteger[] bigIntegerArray = new BigInteger[]{new BigInteger(byArray), null, new BigInteger(byArray2)};
        return new CL3(bigIntegerArray, 12);
    }

    public static CL3 dhParamGen(int n, Random random) {
        if (n < 0) {
            return new CL3(CL3.dhSharedParam(n), 12);
        }
        CL3 cL3 = CL3.dsaParamGen(n, null, random);
        ((BigInteger[])cL3.obj)[1] = null;
        cL3.type = 12;
        return cL3;
    }

    public static CL3 dhKeyGen(CL3 cL3, int n, int n2, Random random) {
        BigInteger[] bigIntegerArray;
        CL3 cL32;
        if (cL3 == null) {
            cL32 = CL3.dhParamGen(n, random);
            CL3.dhParamGen(n, random).type = 14;
            bigIntegerArray = (BigInteger[])cL32.obj;
        } else {
            BigInteger[] bigIntegerArray2 = (BigInteger[])cL3.obj;
            bigIntegerArray = new BigInteger[5];
            cL32 = new CL3(bigIntegerArray, 14);
            bigIntegerArray[0] = bigIntegerArray2[0];
            bigIntegerArray[2] = bigIntegerArray2[2];
        }
        int n3 = n2 / 8;
        byte[] byArray = new byte[n3];
        CL3.rng(null, byArray, 0, n3);
        bigIntegerArray[4] = new BigInteger(1, byArray);
        bigIntegerArray[3] = bigIntegerArray[2].modPow(bigIntegerArray[4], bigIntegerArray[0]);
        return cL32;
    }

    /*
     * Unable to fully structure code
     */
    public static CL3 dsaParamGen(int var0, byte[] var1_1, Random var2_2) {
        if (var0 < 512 || var0 % 64 != 0) {
            throw new CL3Exception(0x3000080);
        }
        var3_3 = -1;
        var4_4 = var1_1;
        if (var1_1 == null) {
            var4_4 = new byte[24];
        } else {
            var3_3 = CL3.msbf(var1_1, 0, 4);
        }
        var5_5 = CL3.shaInit(null);
        var6_6 = var0 / 8;
        var7_7 = (var0 + 159) / 160;
        var8_8 = new byte[var7_7 * 20];
        var9_9 = new byte[20];
        var13_10 = BigInteger.valueOf(1);
        var14_11 = new BigInteger[5];
        block0: while (true) {
            if (var3_3 < 0) {
                if (var3_3 != -2) {
                    if (var2_2 == null) {
                        CL3.rng(null, var4_4, 4, 20);
                    } else {
                        var19_19 = new byte[20];
                        var2_2.nextBytes(var19_19);
                        System.arraycopy((Object)var19_19, 0, (Object)var4_4, 4, 20);
                    }
                }
                var3_3 = -1;
            }
            while (true) {
                var16_16 = 0;
                var15_15 = 0;
                while (var15_15 < 20) {
                    if (var4_4[var15_15 + 4] != 0) {
                        var17_17 = var4_4[var15_15 + 4] & 255;
                        if (var17_17 >= 128) {
                            --var15_15;
                            break;
                        }
                        var16_16 = 1;
                        while ((var17_17 & var16_16) != var17_17) {
                            var16_16 = (var16_16 << 1) + 1;
                        }
                        break;
                    }
                    ++var15_15;
                }
                if (var15_15 >= 16) continue block0;
                CL3.dsaRandom(var5_5, var4_4, 0, var15_15, var16_16, var9_9, 0);
                CL3.dsaRandom(var5_5, var4_4, 1, var15_15, var16_16, var8_8, 0);
                var17_17 = 0;
                while (var17_17 < 20) {
                    v0 = var17_17;
                    var9_9[v0] = (byte)(var9_9[v0] ^ var8_8[var17_17]);
                    ++var17_17;
                }
                var9_9[0] = (byte)(var9_9[0] | 128);
                var9_9[19] = (byte)(var9_9[19] | 1);
                var11_13 = new BigInteger(1, var9_9);
                if (var1_1 == null || CL3.isProbablePrime(var11_13, 80)) break;
                if (var3_3 >= 0) {
                    throw new CL3Exception(0x5000080);
                }
                CL3.dsaRandom(var5_5, var4_4, 1, var15_15, var16_16, var4_4, 4);
            }
            var19_20 = 2 + (var3_3 < 0 ? 0 : var3_3 * var7_7);
            var18_18 = -1;
            while (true) {
                if (++var18_18 < 4096) ** break;
                continue block0;
                var20_23 = (var7_7 - 1) * 20;
                var21_24 = 0;
                while (var20_23 >= 0) {
                    CL3.dsaRandom(var5_5, var4_4, var19_20 + var21_24, var15_15, var16_16, var8_8, var20_23);
                    var20_23 -= 20;
                    ++var21_24;
                }
                var17_17 = var8_8.length - var6_6;
                var8_8[var17_17] = (byte)(var8_8[var17_17] | 128);
                while (--var17_17 >= 0) {
                    var8_8[var17_17] = 0;
                }
                var10_12 = new BigInteger(1, var8_8);
                var14_11[1] = var11_13;
                var14_11[0] = var10_12 = var10_12.subtract(var10_12.remainder(var14_11[1].shiftLeft(1))).add(var13_10);
                var12_14 = var10_12.divide(var11_13);
                if (var10_12.bitLength() == var0) {
                    if (var1_1 == null) {
                        CL3.findPrime2(var14_11, var12_14, var0);
                        break block0;
                    }
                    if (CL3.isProbablePrime(var10_12, 80)) break block0;
                }
                if (var3_3 >= 0) {
                    throw new CL3Exception(0x5000080);
                }
                var19_20 += var7_7;
            }
            break;
        }
        if (var3_3 < 0 && var1_1 != null) {
            CL3.msbf(var18_18, var1_1, 0, 4);
            System.arraycopy((Object)var4_4, 4, (Object)var1_1, 4, 20);
        }
        if (var2_2 == null) {
            CL3.rng(null, var9_9, 0, 20);
        } else {
            var19_21 = new byte[20];
            var2_2.nextBytes(var19_21);
            System.arraycopy((Object)var19_21, 0, (Object)var9_9, 0, 20);
        }
        var9_9[19] = (byte)(var9_9[19] | 2);
        var19_22 = new BigInteger(1, var9_9);
        do {
            var19_22 = var19_22.add(var13_10);
            var14_11[2] = var19_22.modPow(var12_14, var14_11[0]);
        } while (var14_11[2].equals(var13_10));
        return new CL3(var14_11, 8);
    }

    public static byte[] dhGetPrivateKey(CL3 cL3) {
        BigInteger[] bigIntegerArray = (BigInteger[])cL3.obj;
        return bigIntegerArray[4].toByteArray();
    }

    public static byte[] dhGetPublicKey(CL3 cL3) {
        BigInteger[] bigIntegerArray = (BigInteger[])cL3.obj;
        return bigIntegerArray[3].toByteArray();
    }

    public static byte[] dhGetBaseGenerator(CL3 cL3) {
        BigInteger[] bigIntegerArray = (BigInteger[])cL3.obj;
        return bigIntegerArray[2].toByteArray();
    }

    public static byte[] dhGetModulus(CL3 cL3) {
        BigInteger[] bigIntegerArray = (BigInteger[])cL3.obj;
        return bigIntegerArray[0].toByteArray();
    }

    public static CL3 dhGetPublicKeyFromComponents(byte[] byArray, byte[] byArray2, byte[] byArray3) {
        BigInteger[] bigIntegerArray = new BigInteger[]{new BigInteger(1, byArray2), null, new BigInteger(1, byArray), new BigInteger(1, byArray3), null};
        return new CL3(bigIntegerArray, 14);
    }

    public static CL3 dhGetPrivateKeyFromComponents(byte[] byArray, byte[] byArray2, byte[] byArray3) {
        BigInteger[] bigIntegerArray = new BigInteger[5];
        bigIntegerArray[0] = new BigInteger(1, byArray2);
        bigIntegerArray[1] = null;
        bigIntegerArray[2] = new BigInteger(1, byArray);
        bigIntegerArray[4] = new BigInteger(1, byArray3);
        bigIntegerArray[3] = bigIntegerArray[2].modPow(bigIntegerArray[4], bigIntegerArray[0]);
        return new CL3(bigIntegerArray, 14);
    }

    private static void dsaRandom(CL3 cL3, byte[] byArray, int n, int n2, int n3, byte[] byArray2, int n4) {
        int n5 = 0;
        int n6 = 19;
        do {
            byArray2[n4 + n6] = (byte)(n5 += (byArray[n6 + 4] & 0xFF) + (n & 0xFF));
            n >>>= 8;
            n5 >>= 8;
        } while (--n6 >= 0);
        if (n2 >= 0) {
            int n7 = n4 + n2;
            byArray2[n7] = (byte)(byArray2[n7] & n3);
        }
        if (byArray != byArray2) {
            CL3.sha(CL3.shaInit(cL3), byArray2, n4, 20, byArray2, n4);
        }
    }

    private static void findPrime2(BigInteger[] bigIntegerArray, BigInteger bigInteger, int n) {
        BigInteger bigInteger2 = bigIntegerArray[1];
        if (Pi == null) {
            CL3.smallPrimes();
        }
        int[] nArray = new int[512];
        int[] nArray2 = new int[512];
        int n2 = 0;
        while (n2 < 512) {
            BigInteger bigInteger3 = BigInteger.valueOf(Pi[n2]);
            nArray[n2] = bigInteger2.remainder(bigInteger3).intValue();
            nArray2[n2] = bigInteger.remainder(bigInteger3).intValue();
            ++n2;
        }
        BigInteger bigInteger4 = BigInteger.valueOf(1);
        BigInteger.valueOf(2);
        int n3 = -2;
        int n4 = 0;
        block1: while ((n3 += 2) != -2 || n4 == 0) {
            int n5 = 0;
            while ((nArray[n5] + n3) % Pi[n5] != 0 && ((nArray[n5] + n3) * nArray2[n5] + 1) % Pi[n5] != 0) {
                if (++n5 < 512) continue;
                if ((bigInteger2 = bigInteger2.add(BigInteger.valueOf(n3 - n4))).bitLength() > 160) break block1;
                n4 = n3;
                if (!CL3.isProbablePrime(bigInteger2, 80)) continue block1;
                BigInteger bigInteger5 = bigInteger2.multiply(bigInteger).add(bigInteger4);
                if (bigInteger5.bitLength() > n) break block1;
                if (!CL3.isProbablePrime(bigInteger5, 12)) continue block1;
                bigIntegerArray[1] = bigInteger2;
                bigIntegerArray[0] = bigInteger5;
                return;
            }
        }
        throw new CL3Exception(0x8000080);
    }

    static final int[] getInts(String string) {
        int n = string.length();
        int[] nArray = new int[n * 7 / 32];
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        do {
            char c2 = string.charAt(n3);
            if ((n4 += 7) >= 32) {
                nArray[n2++] = n5 << 39 - n4 | c2 >> (n4 -= 32);
                n5 = c2;
                continue;
            }
            n5 = (n5 << 7) + c2;
        } while (++n3 < n);
        return nArray;
    }

    public static CL3 blowfishKey(byte[] byArray, int n, int n2) {
        int n3;
        int n4;
        int n5 = 0;
        int[] nArray = CL3.getInts("\u0012\u000fm(D\u0016F\biDc\u0018Q8\u0006p9Q\u0014@I`D)OL:\u0000A;u\u0018v\u0013MHJ\u0014P!s\u000e\u001a\u0001\u001b^|T33fNH1Y@V\n6|Kq!]\u001fa\u001a[-U\u000e\t\u000bdBm.f\u0012y}Fz\u0013\b.M\u0018om5B\u007fue[h\u0006[{=cC/vZDgtZt|H\u0011>\u0012c~2$Pf({\u001cEYw\u0004\u0000>.\u0014\u0016\u001d|\u000b\u0018m\u0012\u0006abW'\u001a4EGzGtIO/`lUi\u000f9#VeCF\u0017M, BTW9vTR\u00078%Rfk\u001c\u00185'\u0012WI@\u0013bt6\u0002\u0019!A\u0005x2H\u0017Hbq[\u001c;qgNr``\u001d\u0006\u0001fdx\u001d\u000bX\u0007Q#v\\*w`o&\u0014Y\u001dq/\u0017vJV\u0002qAf*I>:RVW\u0014+R\u0013\u0006\u0013\u000fP\u0014 \u00159#K(U+\b-VLbph\u0011 z\u0019j\nR\r/>\u001c]\u0019\u001dO\\\u0014\bXm{a(W)bW.AAGmN.\u000fBi\\\u001e&\u001eWuW#\u001b0IO.\u001eF%\u001c\u0004Q\u0015C\u001dg8z\"0k%n5|%\u007fP\u001b3\n\u0004\u0019\u001b\u00070\tf>d\u001aLE\u0010|V\u0018\u000b^d\u0000eoB\u0017+^L\u0015k1n\tD0\u0017-J\u001bD\bq\u0013t\u0007'\u0016V1!vk?g\u0003z\u0010G\u0012p-\t\u0002R!\u0004\u0000#'\u0011p%'CyZxCF4\u0010^nK24g\u0006'\f\u001a^N\u0011p5\u00144\r\u0016a(/4%Az9\"VQ\u0019hmnx-X\u0013=\u000e|KQo`P?>e)E\u0007be\u000eN5p\u000bYMJ,OP$\u0018:\u0011\fw!C\u0014+>?4>a\u0014\\\u0019n\u0016^_8\rw.b\u000bA\u0010\u001ch\u0001R\u0012>V`ZTdvNTb\u001b\u000fnp0o}_9\u0010S0\u0011toPkI\u001a\u0000PI\u0011[\u0007zZ4OG\u0001\u001b\u0003Tn,L\u00022\u001b=I:GNcmho=|?r@56<S\u00079;3A=\u00020\u0000kV\u0006RO[\u0010\u0013v\u0006\u0011<\\O0C\u0016Q\u0011Fh}[uss1'5\tN6.Ym%l7[?E\b~60JK\u0019H\n\u0015\t///!\u001bw\u000f \u0004o\fi/k\u0018\u001e(\u0003F%d]O\u0001KT\u0015h\\CP\u001fR\u0005Wg\u001bNOw[*^8\u000bhi@2\u00055T\u0010\u0006\u0019\u0000,9\u001e,yy\u0017}{\u000fhyHu\u0017SxmLD/Aqj\u0016o\u007f,\u0016XT^P\u000f2\u0015P*JV2\u001em?/i\u000e\u000e`)L/4Ax\u0001_A'KE=o\u0014oF(\u0003(:X]_\u000bZ;=*\nQv\u0014\u001f_|\u001d1N2c#\tu+MR[\u0013l\u0017<Rc\u0011a\u007fhk[G@# \b>GYGtC\u0003\\\u0012_K+0[QiVs%\u001f\u0011s6|\u0011,]\u00149\u0013<%~ry\u0007\u0007;rm)\u00197qME{\tP9n&\u001bQo\u00102[#3]\u0018\u0001h\u001fSoq/b\u001fZ%;=R6]\u0010Hf\u001d*l9bkIu4\r\u0004;#PWqd^\u00048x[\u0017cNY%^\u001fvq>~!\u0011-I\bD.\u0002)\u00007`\u001c'k+j\u0003\"\u001fC\u000e49\u007f\fFg(`k%ry\b1>\u0007\u0005n~ST[~E@Cz\u000f\u0016AL\u0007m-w' 1,yuYhO\n34T\u0013|\u000fhOA7>1\u00078\u000eJ[(lEKz\u0013\u001a\u0001\u0015;A2<cL(!\r\u0005\u000e~54@e;m?(6\u001d(Bz~sS.?WMWC\u000f3t&AV Fz:py|I\u0000\t!bi\u0001c3/\bM\u0000\u0005m/8p+dF!Z7p\u0004n#e+\u000e\"\u001d,wtjSc\u0002CDv+%\u001b|@}-h@.-g\u000b\u0003\u0013\u0000nf\u0014W\u001f)\br\u0003\u0016B9fJ lhrn)v\u0014TRC5\b\u0001%\u001a)J\"]0=.?^&xn!-A$; <g \u0000\u0011:7m*q_$?rK;\r2P72\u0015[\u0018lR\u000f\u001esy[?f@);\u000b\u0005+\u0019\n;\u00015;)Oct\u0010Ei\u000f\u00197! vR-tptm62J\u00136u\u0004KXAI\u0018G-7)V\u0004M\u001f>}N;L\u000bD?[23;\u0015(cES\u001a\u000b\u007fjf\"IYBXg\\\u0011IX\u0005%:B)BM\u00012\u0013 9\u0003\u0003Qx~TL&K4\u0014uJkGy\u001aiO\\\u007fVPtS@??P0zS%SG\u001b`%.p)Mi\u0002\r\u00048:df\u001c\u000bSF\u0001\u0007YEp%Pk\u001fOW.~$y\u0017\f\u0005\r6SBBh?M0E\u0015\u0003E\u0006[g\n0-) \u0007\u001bO@x q\u007f^W\u0017\u0011gj\u0013XW\u000b<W\u000b\u0001k47x\u0014\u0001@o@8\u001f\u0002\u0000@\u000b\u001f~\\\fzFGK+Rd%A^K\r`$C=hd\"?KrR/{%\u0006$;LEu#@'./\u0016\u00027a6[LEUl4M<{Z=%\ba#\u0003z\u0000\u0018;YHcOTG(y\u0003b\u001c33\u0013_(\u001c/\u0019 \u0017:\b`}3\u0018SJHYa\u001em\\B\rt\u00104\u0007v\u0005\u0001\u0017re`%\u0010\u0012%oGJYs09/\u0015xM?=\u001a;G{\u0019\u0018 !3EkB-f<~.*DN!y9Vq\u0012\u0014\u0003-o\u001a?\u0004fao%B\u001c0t\u00046B{d~5<tRoXg1ul\u001d6pQoiF\t!YXF&\u000f%o\u000e\u0006\bs\u0010W2\bnPg39\u0013\u0005:\u000b\u0004T\u0014j\fTeb\u0014*\t \u0000\u0004\u0013\u001d9\u001bW\u000e\u007fq\u001e\b\f)e,\u0006Xwk\u0017b\u0011Ll\b5+<:z\u001e\u001dV<\bF\u00075I\u0012J\ty#|nl_c{}'W+y0<\u0015\u001e\u001bPn\u001a\u0015ajt[v\u001809<\n-\u000fE+\u001b\\?g\u000e\u0013GP7hRen.3\u001e8t\u001f\u0000\u001f\":e\u0013\u001b\u0010%\u0017\u0013\u0019\u0017Dp!351BPuj)bu\u001e\u0014_aq&\u001e\u0005\u000b>O\u0017]\u001d'\u001b\u0007%3hdr&\u0007F8'K\u0001$#SB\u001eq\u0018JmkV\u007fMnV\f>fqo\bY-\u0019wHAl/s>D\u0003\f\u007fJ\u00183\u0016w_>6\u0016TV*`C\u00054*s\u0000\u0017;\u001d%\u0007vey)lUo>k+6q>\b\u0015\u0010mE\u0002H\u001dBpv7(w+\u0006>\u0015\b\u0004yJACVa^e@3'x=*\u0001Xy{+M9\u0010&\u001c\u0014#NV=\u001e\u0005ru-pS]LC/\f\u0006\u00112O\u001cUW\u0015;\u0017N\bn2\"cjxf{pe(\u00046MeJZ]T\b\u0006Bhd<\u0015-\u00163\f{SU`\b7\u000f<m(\u000b\fakz\u0004f+wL_L#kvQx\u001bb\u0013)?\fZw\b{25xYP\u0012@CFXA'\u000ff\u000fuRmv~Bx,.S\u0015?V\t%\rHN&\u001cn\u0007C\u007fFX$4[\u001b3\u0005:j2qA)\u000flR\u001cFmpb(,:~.yS\r\u007fu?E\u000ek\u0007\\|\u001e\u001ckTPS3h2-|4\u0010A:\u0014\u0010\u000fB>\u0002\u0017]b[(u*_+6l'E?,Z?!G!=\b.{*w52Sg1j\u0007\u001a!\u0002v\u0003gLz\r\u0005&q|DZ\u001dT=@XJ\f{\nCr-c$d7r\u0011\u0003P08{5\r~\u0015\u00120m\u001c[R$GB\"A54Je\u0005\u0004Vwp\u000542HNE\f+\u000bPG\u0002\u0007\u0000\u000b\u0004\u00144T\f*}=!m7h>\u0011On\u0006\tMepI#27r\u0007,_v<-B\u0011o6|o\rk\u001c_9h` !>*>9n27)@x\u0004\u00103x(']\u000e~a*alefZK&O*bC\u0000l\u0012h\t+~ \u0001<Vr<D=\u000bX4)R\t}jY`Ppz=Im\\{=\u0018A+\bfYk}SgFg!P\u0018\\!QJq\u001f\u000e\u001b\u0003i#q\u001ex[?r\u0000T|!scv\u0003j+McOJ{8\u001d7oi\u001eVM\t$\u0005\u0001w{\u0013\u0004adQR)\u001a\u0010\"R\u0007]l\u0002j=wO#,]TQ\u0000\r\r  Hq\u0019H\u001eFR\u000eoT[T\u0000\u0006\r<<9{\u000bRr\"\u0015\f\u0014\u0010SnK|.\u0010@&e?AlZk\u0011W\\\u001eMnMM \u0017Q7{`'X\u0003^epW}1[P\u0018rpP$[V'YU?SJ\u00074%#yU<P*4((\u001e\u0004U\u0018\u0010St\u0005\u000b\u0010mW&lm}Z\u001bA#\u000b.H4@\r\u0000v\u0002H'Pc=dy\u007f}\"t!uXeV\u0019`\u0003\u001e^M5ZUN\u000f\u001f\u001a3:\u007fYN<(s\u0014\u0003,TB\u0010?Sc.gg\u0005\\{G\u001d=,v\u0012'\"c\\OknK6F\nb5\rL1u8r{\u0011i]z:7+4\u0019IPAs}y'A\u0003w{\u0005=)mGzg\u0017\"P\njei\u0011\u0015\u0013U*3QhA\u0003Fa\u007ff]&oPK%)5-!O<PE3%F2R)1f<\u001dYNL*%\u0015Gs\t\u0017r^z\u001fCI\u0001$b|~~\u001d\u0000\u0010\u0010N/8 \u00171*p\n(\u00168r\\\bU\u0011dc\u001b$$F\u0004&?cCpm`\u001fsIw\u0010 Ax=\u0000G<i\u000bXC8.2/T==,o\u0001Qy/\u0018\u0018z\u0004\"52\t/7AQ@*N\u0018\u001b\u007fG\"F\u001f1[\u00030pJiB\u00018&)u=LOhrZ\u0018\bUV#Jx\u00063tKB;\u0012\u0002l.uzr\"BlT w\u001at\rLwN d0[\"{J\u001a\u0001\u0013a\u000b\u0015[e\u001fV#t\u0010bss\u001e_\u0002Q\u0013#7aoTGk\u0007\u001d~I~3t4<\n#Xh\u0019I;~t\u001d\u001bmj_Sq}\u001bj\u0002-c\u0002Ckn~\u0013\u0011_\u0005\u0019[7\u001aa\\3m*\u00106YeC9\u001dKT\u001dw\u001a\u000e@\u0013b)\u0006qy@\u0007~G5\u001cCr&H?Z\u000b3\u001es\u007f^;6}N(\u0012\u001cx/2\u0015/(w1\u0019>\u0010Q-k$G\\Qs?;\u000eznY\\r.Ys\u0002\u0015Kf\u0000&q%~BqDZh!+4|3(V;\t\u001d)Lc`]q\u000e\u001aB$\u0011^o\u0012(y`j\roLK}Xj\u0001S, \u0018\br]_QtK=l8\\\u001c\u001e%\bB\u000b\u0016!!\u0010N\rY\u0006;\rm-/T*2+ltvj\r(/oW~L!Ida\u007fS[d\u0001/p{p\u0010f\u0003awx0\u0000l\u0004nG{\u0003#=G\u0001}AnEW\u0001\u001as7s\u0019\u0003!\u001af?\u0000zVqX \b\u00189p\u0000^/]t\u0005=z{hW\t\nT2\n3?,\u000bL\u0014rci\u000fy7?Z\u0017Qio\u001c!q\u001bn\t&f|py\u000b\u001c9i4:|JT7s39=:df\f,;_B!\r sf\"_JxHfrf\u001c Z\u0015n\bfU+\u0011d@[ded\u0017,pnp .@#(1\u0012\u000eW%&=7?F6n\u0005'8\t3\u000b!\u001a\u000e\u0010dF\u0019z\u000b!x\b\u0013p_#\t)M\u0000J\u001d7?B\u0001Udz\u001d\u0005i4M}\u0006\rr\u0007J\r\u000f\u000b'97m jsH\u001b}!q3S4~5~R(\u0004+`\r\u001c\r\u0003}(\u0000+.\u0010\u001bfh\ts/D0Nw\u001faH\u001c\u001b\u0001\u0018\u00060j\u0000k/@.z\u00140\u001eX7\u0000\u0000`,*F\rcuD\u0011s'Zr\u0019cTc)p[Y&\u000b\u0004\u0016\u001a.y>rZ!<[7]?cvCN,G.fx\u0017H\t%_\u0000\u0018Aed\n\u001e_\u0012'a\u0012\rc9\u0017n$lvr\u001a`VvM\u001czq|vU\nW@#y%Zv\u0007WfM\u001b-\u0007q\u0003e\u0007==10y_\n\u0014\u0014)Y6\u0014\"3c?+GsU\\\u0014v\u0010l*_s[\\6 oWM\fFI\u0013\u000e\u0004\u00123C_(r\u0001@\u0000p\u000eG\u001cq_'zzsu<\u0013\\nZbK#5eAO\u001e'hft\u0016N\u0004' &7I]{*\u0011G'7p{L+V\u0016G\u000fl8\u0003\b{[c\u00036Y\u0006C\u0010\"lMk\ryT67-\ntE,_<J\u001bO\u001c5\rmR2R8,BL\u001fxw\u0011Q]sw*s\u0005\u0007)M\u00027\f)\u001cn{:Mi\fPV%$nEy=c\u0002(?-/AT-(fL>|3E\u001aC;D,\u0004'\u00058!I\u0005o5\u0014<\u0003U'\u001e-\u0005\u0012\u0007@0nS>K)\u001b\u000frE*\u000bS\u00117V\u0014\tT/M\u001ct:pRu\u0019,\u001b^U1:8r\u007f?'w)={#x\u0011^i;~A%L\u0003I)\nav\b0\u00066\ts+'3w\u0016'iH?+)qS/\u0017\u0016<\u0016}H\bW\u000b(eZZah\u0002}S\u001f:\u001cy{,|>K%\u0001||KOV|W\tZk-49\u0016Q\u000f*3@)V\u001c<\u0001M\u0017LGX+\u001f^lOu\u001bt4xHi vWf>\u001aV1%r\u0013\u0017\n\u000f\u0005x\u0006#m:X\n_<X\u001cDqtkh`T\nmj\"\u001eFmh\u0007!0I V'B{CugBSdA/\"KIc.e$t\u0007\u0015\u0006gvll<c\u0010}>Yc\u001bv&n<c\u0017)O2(XU?_(\r,4A\"W#elPQ;D8 Vgq+f\u0014,|e6$_&z\u0002u\t`a\\G\rsUC\n& |d='TC\u0005{\u001f\u001eye\t\u0007\u001cd;Swc\u0015\"mc?0e\u0013j\u0019\u0011^)Z,A\u001f\u001a\u0001\"W\u0002\u0002\rk6d$4a%_h$\u000e!3,s$0)HE`7+\u0006f{\u001e\u001c\u00102\u0015e]{o]\rV\u0011T\u00063$\u0001?ZvN\u001do;\"5\u001fG%O}\n>\u001aBHKeS\u001bU9:YjGiI\u0004]c,a\u0015:~<7Qz)_\u0011FT\u0017W3jv\tn\u001b{\u0013L7\u0003P\u001c\rFyk1\u001a_pr\u000b\u001c5u\u001bu:@ 2a\u0004uSEL\u001a4HfP\u0004+/B86\u0000!\"+\u0018\u001d\u0007 kD~iN7(\t\u0006y|w\u0002\u001aH\u00158\u0010\u00044\u001d%In\"?aB\u00150,<y\u0019\u007f9;\u001d\u001e%3\"\u0014K=P\"\u0007\u001e\nG\u001cy%Kf,M^@\u001f]2<\u0001f!}<ct>lx\u0004#CPz\u0015,8j!\u0007$u\t{lk!Zo2zPVhp\u0003\u001cpe,4DlgF~&\u0017g\u0002b+'}seM]\u0007u]N^-(g~'lQ3K|\\D,\ny_BP>#|8frA)\u0017ueIX9k4sWBT\u0019\u000b\u0011\u0015jQQ[0 uw\f\nj\u0006\u0004\u001a%\u0003\u0017\u0016\u0003R\u0010\\\u000ec8\u001c\u0016L6g4dbA>\u0019\u001e\u001d\u0016$|?\u0015\u00198\u001a9\u0016\u007f' \u001a\nq\u0017\u000fH<\u001b\u0005\u001d\b\u0014]\fi\fboN\u0012\u0006\rl2l7fY|67\u0019\u0017K\\`[=\u000e\u000fq|#^*34T\u000f6[\t\u000e9Dygs'gs<,\u0018XY_R`t\u000b\u0004GtX_7lE\u0019zH~5=\u0018dv\u0011du\u0003)E-Lf@UO\u0004\u0005DZ:zvVpXm\u0017D4N<fz,bI 7\u0014NA\u0018PH\u0006n\u001c2X)fc1wS\u0013h(\n\"x:\u00006\u000fd{M25%\u001fuE(\u0007@\u00172-\u007fD5^t^g\bIR\u0005Y\u0001\u0000\"\u0015[\u0017O>3.ia-&\u0011\u001f0\u0002d\u0007\u000f&8Uo,\u0002*\u001e[p]\u000e\u0004\tg]\rN;\u001duz\u000e\u0014@u0\u0018\u0010\\_y\u001d\nt#;\u0007U+s0&>5'pe\u0011B.\u0000_8T0\u0003C59\u001an_\u0007s\u0010j>\r\u001a2s= \u001fB$Rn\b\u0011fOmif\tK\u001cwq\u0016jx~\u007fF:a\\\\`");
        n5 = 0;
        int n6 = -1;
        do {
            n4 = 0;
            n3 = 0;
            do {
                n6 = (n6 + 1) % n2;
                n3 = n3 << 8 | byArray[n + n6] & 0xFF;
            } while (++n4 < 4);
            int n7 = n5++;
            nArray[n7] = nArray[n7] ^ n3;
        } while (n5 < 18);
        n6 = 0;
        n4 = 0;
        n3 = 0;
        do {
            n3 ^= nArray[0];
            n5 = 1;
            do {
                n3 ^= (nArray[18 + ((n4 ^= (nArray[18 + (n3 >>> 24)] + nArray[274 + (n3 >>> 16 & 0xFF)] ^ nArray[530 + (n3 >>> 8 & 0xFF)]) + nArray[786 + (n3 & 0xFF)] ^ nArray[n5]) >>> 24)] + nArray[274 + (n4 >>> 16 & 0xFF)] ^ nArray[530 + (n4 >>> 8 & 0xFF)]) + nArray[786 + (n4 & 0xFF)] ^ nArray[n5 + 1];
            } while ((n5 += 2) < 16);
            int n8 = n3;
            nArray[n6] = n3 = n4 ^ nArray[17];
            nArray[n6 + 1] = n4 = n8;
        } while ((n6 += 2) < 1042);
        return new CL3(nArray, 33);
    }

    public static void blowfish(CL3 cL3, int n, byte[] byArray, int n2, byte[] byArray2, int n3, byte[] byArray3, int n4, int n5) {
        int[] nArray = (int[])cL3.obj;
        int n6 = 0;
        int n7 = 0;
        int n8 = 0;
        int n9 = 0;
        int n10 = nArray[0];
        int n11 = nArray[17];
        if (byArray != null) {
            n6 = CL3.msbf4(byArray, n2);
            n7 = CL3.msbf4(byArray, n2 + 4);
        }
        n5 += n3;
        while (n3 < n5) {
            int n12;
            int n13 = CL3.msbf4(byArray2, n3);
            int n14 = CL3.msbf4(byArray2, n3 + 4);
            n3 += 8;
            if (byArray != null) {
                if (n == 0) {
                    n13 ^= n6;
                    n14 ^= n7;
                } else {
                    n8 = n13;
                    n9 = n14;
                }
            }
            if (n == 0) {
                n13 ^= n10;
                n12 = 1;
                do {
                    n13 ^= nArray[n12 + 1] ^ (nArray[18 + ((n14 ^= nArray[n12] ^ (nArray[18 + (n13 >>> 24)] + nArray[274 + (n13 >>> 16 & 0xFF)] ^ nArray[530 + (n13 >>> 8 & 0xFF)]) + nArray[786 + (n13 & 0xFF)]) >>> 24)] + nArray[274 + (n14 >>> 16 & 0xFF)] ^ nArray[530 + (n14 >>> 8 & 0xFF)]) + nArray[786 + (n14 & 0xFF)];
                } while ((n12 += 2) < 16);
                n14 ^= n11;
            } else {
                n13 ^= n11;
                n12 = 16;
                do {
                    n13 ^= nArray[n12 - 1] ^ (nArray[18 + ((n14 ^= nArray[n12] ^ (nArray[18 + (n13 >>> 24)] + nArray[274 + (n13 >>> 16 & 0xFF)] ^ nArray[530 + (n13 >>> 8 & 0xFF)]) + nArray[786 + (n13 & 0xFF)]) >>> 24)] + nArray[274 + (n14 >>> 16 & 0xFF)] ^ nArray[530 + (n14 >>> 8 & 0xFF)]) + nArray[786 + (n14 & 0xFF)];
                } while ((n12 -= 2) > 0);
                n14 ^= n10;
            }
            if (byArray != null) {
                if (n == 0) {
                    n7 = n14;
                    n6 = n13;
                } else {
                    n13 ^= n7;
                    n14 ^= n6;
                    n6 = n9;
                    n7 = n8;
                }
            }
            if (byArray3 == null) continue;
            CL3.msbf4(n14, byArray3, n4);
            CL3.msbf4(n13, byArray3, n4 + 4);
            n4 += 8;
        }
        if (byArray != null) {
            CL3.msbf4(n6, byArray, n2);
            CL3.msbf4(n7, byArray, n2 + 4);
        }
    }

    public static CL3 rc2Key(byte[] byArray, int n, int n2, int n3) {
        int[] nArray = new int[64];
        byte[] byArray2 = new byte[128];
        int n4 = (n3 + 7) / 8;
        System.arraycopy((Object)byArray, n, (Object)byArray2, 0, n2);
        int n5 = n2;
        do {
            byArray2[n5] = Prc2[byArray2[n5 - 1] + byArray2[n5 - n2] & 0xFF];
        } while (++n5 < 128);
        byArray2[128 - n4] = Prc2[byArray2[128 - n4] & 255 % (1 << 8 + n3 - 8 * n4)];
        n5 = 127 - n4;
        do {
            byArray2[n5] = Prc2[(byArray2[n5 + 1] ^ byArray2[n5 + n4]) & 0xFF];
        } while (--n5 >= 0);
        n5 = 0;
        do {
            nArray[n5 / 2] = (byArray2[n5] & 0xFF) + 256 * (byArray2[n5 + 1] & 0xFF);
        } while ((n5 += 2) < 128);
        return new CL3(nArray, 34);
    }

    public static void rc2(CL3 cL3, int n, byte[] byArray, int n2, byte[] byArray2, int n3, byte[] byArray3, int n4, int n5) {
        int n6 = 0;
        int n7 = 0;
        int n8 = 0;
        int n9 = 0;
        int n10 = 0;
        int n11 = 0;
        int n12 = 0;
        int n13 = 0;
        int[] nArray = (int[])cL3.obj;
        if (byArray != null) {
            n6 = CL3.lsbf(byArray, n2 + 0, 2);
            n7 = CL3.lsbf(byArray, n2 + 2, 2);
            n8 = CL3.lsbf(byArray, n2 + 4, 2);
            n9 = CL3.lsbf(byArray, n2 + 6, 2);
        }
        n5 += n3;
        while (n3 < n5) {
            int n14;
            int n15;
            int n16;
            int n17 = byArray2[n3] & 0xFF | (byArray2[n3 + 1] & 0xFF) << 8;
            int n18 = byArray2[n3 + 2] & 0xFF | (byArray2[n3 + 3] & 0xFF) << 8;
            int n19 = byArray2[n3 + 4] & 0xFF | (byArray2[n3 + 5] & 0xFF) << 8;
            int n20 = byArray2[n3 + 6] & 0xFF | (byArray2[n3 + 7] & 0xFF) << 8;
            n3 += 8;
            if (n == 0) {
                if (byArray != null) {
                    n17 ^= n6;
                    n18 ^= n7;
                    n19 ^= n8;
                    n20 ^= n9;
                }
                n16 = 0;
                n15 = 0;
                n14 = 2;
                while (true) {
                    n17 += nArray[n15] + (n20 & n19) + (~n20 & n18);
                    n17 = n17 << 1 | (n17 & 0xFFFF0000) >>> 15;
                    n18 += nArray[n15 + 1] + (n17 & n20) + (~n17 & n19);
                    n18 = n18 << 2 | (n18 & 0xFFFF0000) >>> 14;
                    n19 += nArray[n15 + 2] + (n18 & n17) + (~n18 & n20);
                    n19 = n19 << 3 | (n19 & 0xFFFF0000) >>> 13;
                    n20 += nArray[n15 + 3] + (n19 & n18) + (~n19 & n17);
                    n20 = n20 << 5 | (n20 & 0xFFFF0000) >>> 11;
                    n15 += 4;
                    if ((n16 += n14) < 10) continue;
                    n16 -= 11;
                    if (n15 == 64) break;
                    n19 += nArray[(n18 += nArray[(n17 += nArray[n20 & 0x3F]) & 0x3F]) & 0x3F];
                    n20 += nArray[n19 & 0x3F];
                }
                if (byArray != null) {
                    n6 = n17;
                    n7 = n18;
                    n8 = n19;
                    n9 = n20;
                }
            } else {
                if (byArray != null) {
                    n10 = n17;
                    n11 = n18;
                    n12 = n19;
                    n13 = n20;
                }
                n15 = 63;
                n16 = 0;
                n14 = 2;
                while (true) {
                    n20 = (n20 << 11 | (n20 & 0xFFFF0000) >>> 5) - nArray[n15] - ((n19 & n18) + (~n19 & n17));
                    n19 = (n19 << 13 | (n19 & 0xFFFF0000) >>> 3) - nArray[n15 - 1] - ((n18 & n17) + (~n18 & n20));
                    n18 = (n18 << 14 | (n18 & 0xFFFF0000) >>> 2) - nArray[n15 - 2] - ((n17 & n20) + (~n17 & n19));
                    n17 = (n17 << 15 | (n17 & 0xFFFF0000) >>> 1) - nArray[n15 - 3] - ((n20 & n19) + (~n20 & n18));
                    n15 -= 4;
                    if ((n16 += n14) < 10) continue;
                    n16 -= 11;
                    if (n15 < 0) break;
                    n20 -= nArray[n19 & 0x3F];
                    n19 -= nArray[n18 & 0x3F];
                    n18 -= nArray[n17 & 0x3F];
                    n17 -= nArray[n20 & 0x3F];
                }
                if (byArray != null) {
                    n17 ^= n6;
                    n18 ^= n7;
                    n19 ^= n8;
                    n20 ^= n9;
                    n6 = n10;
                    n7 = n11;
                    n8 = n12;
                    n9 = n13;
                }
            }
            if (byArray3 == null) continue;
            CL3.lsbf2(n17, byArray3, n4);
            CL3.lsbf2(n18, byArray3, n4 + 2);
            CL3.lsbf2(n19, byArray3, n4 + 4);
            CL3.lsbf2(n20, byArray3, n4 + 6);
            n4 += 8;
        }
        if (byArray != null) {
            CL3.lsbf2(n6, byArray, n2 + 0);
            CL3.lsbf2(n7, byArray, n2 + 2);
            CL3.lsbf2(n8, byArray, n2 + 4);
            CL3.lsbf2(n9, byArray, n2 + 6);
        }
    }

    public static int dsaSign(CL3 cL3, int n, Object object, byte[] byArray, int n2, int n3, byte[] byArray2, int n4) {
        BigInteger bigInteger;
        BigInteger[] bigIntegerArray = (BigInteger[])cL3.obj;
        if ((n & 3) == 1) {
            byte[] byArray3 = byArray;
            int n5 = n2;
            int n6 = n3;
            n3 = 20;
            byArray = new byte[20];
            n2 = 0;
            CL3.sha(null, byArray3, n5, n6, byArray, 0);
        } else {
            if ((n & 3) != 0 || n3 != 20) {
                throw new CL3Exception(0x3000080);
            }
            byte[] byArray4 = byArray;
            byArray = new byte[20];
            System.arraycopy((Object)byArray4, n2, (Object)byArray, 0, 20);
        }
        BigInteger bigInteger2 = new BigInteger(1, byArray);
        do {
            CL3.rng(null, byArray, 0, 20);
            byArray[0] = (byte)(byArray[0] & 0x7F);
        } while ((bigInteger = new BigInteger(1, byArray)).signum() == 0);
        BigInteger bigInteger3 = bigIntegerArray[2].modPow(bigInteger, bigIntegerArray[0]).remainder(bigIntegerArray[1]);
        BigInteger bigInteger4 = bigInteger.modInverse(bigIntegerArray[1]).multiply(bigIntegerArray[4].multiply(bigInteger3).add(bigInteger2)).remainder(bigIntegerArray[1]);
        byte[] byArray5 = bigInteger3.toByteArray();
        byte[] byArray6 = bigInteger4.toByteArray();
        if ((n & 4) == 0) {
            int n7 = 39;
            int n8 = byArray6.length;
            do {
                if (n7 == 19) {
                    byArray6 = byArray5;
                    n8 = byArray5.length;
                }
                byte by = byArray2[n4 + n7] = --n8 < 0 ? (byte)0 : byArray6[n8];
            } while (--n7 >= 0);
            return 40;
        }
        byArray2[n4] = 48;
        int n9 = byArray5.length;
        n3 = 6 + n9 + byArray6.length;
        byArray2[n4 + 1] = (byte)(n3 - 2);
        n4 += 4;
        while (true) {
            byte by = (byte)n9;
            byArray2[n4 - 1] = by;
            System.arraycopy((Object)byArray5, 0, (Object)byArray2, n4, (int)by);
            byArray2[n4 - 2] = 2;
            n4 += 2 + n9;
            if (byArray5 == byArray6) {
                return n3;
            }
            byArray5 = byArray6;
            n9 = byArray6.length;
        }
    }

    public static boolean dsaVerify(CL3 cL3, int n, Object object, byte[] byArray, int n2, int n3, byte[] byArray2, int n4, int n5) {
        Object object2;
        BigInteger[] bigIntegerArray = (BigInteger[])cL3.obj;
        byte[] byArray3 = new byte[20];
        BigInteger bigInteger = null;
        BigInteger bigInteger2 = null;
        int n6 = 0;
        while (true) {
            byte by;
            if ((n & 4) == 0) {
                object2 = byArray3;
                System.arraycopy((Object)byArray2, n4 + n6, (Object)byArray3, 0, 20);
            } else if (byArray2[n4 += 2] == 2 && (by = byArray2[n4 + 1]) > 0) {
                object2 = by == 20 ? byArray3 : new byte[by];
                System.arraycopy((Object)byArray2, n4 + 2, object2, 0, (int)by);
                n4 += by;
            } else {
                return false;
            }
            bigInteger = new BigInteger(1, (byte[])object2);
            if (n6 != 0) break;
            bigInteger2 = bigInteger;
            n6 += 20;
        }
        if ((n & 3) == 1) {
            CL3.sha(null, byArray, n2, n3, byArray3, 0);
        } else {
            if ((n & 3) != 0 || n3 != 20) {
                throw new CL3Exception(0x3000080);
            }
            System.arraycopy((Object)byArray, n2, (Object)byArray3, 0, 20);
        }
        BigInteger bigInteger3 = bigInteger.modInverse(bigIntegerArray[1]);
        BigInteger bigInteger4 = new BigInteger(1, byArray3).multiply(bigInteger3).remainder(bigIntegerArray[1]);
        object2 = bigInteger2.multiply(bigInteger3).remainder(bigIntegerArray[1]);
        bigInteger = bigIntegerArray[2].modPow(bigInteger4, bigIntegerArray[0]).multiply(bigIntegerArray[3].modPow((BigInteger)object2, bigIntegerArray[0])).remainder(bigIntegerArray[0]).remainder(bigIntegerArray[1]);
        return bigInteger.equals(bigInteger2);
    }

    public static CL3 dsaKeyGen(CL3 cL3, int n) {
        BigInteger[] bigIntegerArray;
        CL3 cL32;
        if (cL3 == null) {
            cL32 = CL3.dsaParamGen(n, null, null);
            cL32.type = 10;
            bigIntegerArray = (BigInteger[])cL32.obj;
        } else {
            bigIntegerArray = new BigInteger[5];
            cL32 = new CL3(bigIntegerArray, 10);
            System.arraycopy((Object)((BigInteger[])cL3.obj), 0, (Object)bigIntegerArray, 0, 5);
        }
        byte[] byArray = new byte[20];
        CL3.rng(null, byArray, 0, 20);
        bigIntegerArray[4] = new BigInteger(1, byArray);
        bigIntegerArray[3] = bigIntegerArray[2].modPow(bigIntegerArray[4], bigIntegerArray[0]);
        return cL32;
    }
}

