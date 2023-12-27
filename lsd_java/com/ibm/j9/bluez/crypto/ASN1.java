/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.j9.bluez.crypto;

import com.ibm.j9.bluez.crypto.BigInteger;
import com.ibm.j9.bluez.crypto.CL3Exception;

public class ASN1 {
    public static final int BIGINT;
    public static final int BOOLEAN;
    public static final int OIDSTR;
    public static final int B8STR;
    public static final int B16STR;
    public static final int UTF8STR;
    private static final int ANYSTR;
    public static final int INTEGER;
    public static final int APPSPEC;
    public int mode;
    public byte[] data;
    public int tag;
    public int beg;
    public int len;
    public Object obj;

    public Object decodeObject() {
        if (this.mode == 7) {
            this.mode = this.tag == 30 ? 5 : (this.tag == 12 ? 6 : 4);
        }
        return ASN1.decodeObject(this.mode, this.data, this.beg, this.len);
    }

    /*
     * Unable to fully structure code
     */
    public static Object decodeObject(int var0, byte[] var1_1, int var2_2, int var3_3) {
        var4_4 = null;
        switch (var0) {
            case 3: {
                var5_5 = new StringBuffer(4 * var3_3);
                if (var3_3 > 0) {
                    var8_10 = var1_1[var2_2] & 255;
                    var5_5.append(var8_10 / 0);
                    var5_5.append('.');
                    var5_5.append(var8_10 % 0);
                    var7_11 = 1;
                    while (var7_11 < var3_3) {
                        var8_10 = 0L;
                        do {
                            var6_12 = var1_1[++var2_2];
                            var8_10 = var8_10 << 7 | (long)(var6_12 & 127);
                        } while (++var7_11 < var3_3 && var6_12 < 0);
                        var5_5.append('.');
                        var5_5.append(var8_10);
                    }
                }
                var4_4 = var5_5.toString();
                break;
            }
            case 2: {
                var4_4 = var1_1[var2_2] == 0 ? new Boolean(true) : new Boolean(false);
                break;
            }
            case 8: {
                var5_6 = 0;
                var3_3 += var2_2;
                while (var2_2 < var3_3) {
                    var5_6 = (var5_6 << 8) + (var1_1[var2_2++] & 255);
                }
                var4_4 = new Integer(var5_6);
                break;
            }
            case 1: {
                var5_7 = new byte[var3_3];
                System.arraycopy((Object)var1_1, var2_2, (Object)var5_7, 0, var3_3);
                var4_4 = new BigInteger(1, var5_7);
                break;
            }
            case 6: {
                var5_8 = new StringBuffer(var3_3);
                var3_3 += var2_2;
                while (var2_2 < var3_3) {
                    var6_13 = var1_1[var2_2];
                    if (var6_13 >= 224) {
                        var6_13 = (var6_13 & 15) << 12 | (var1_1[var2_2 + 1] & 63) << 6 | var1_1[var2_2 + 2] & 63;
                        var2_2 += 3;
                    } else if (var6_13 >= 192 && var6_13 <= 240) {
                        var6_13 = (var6_13 & 31) << 6 | var1_1[var2_2 + 1] & 63;
                        var2_2 += 2;
                    } else {
                        ++var2_2;
                    }
                    var5_8.append((char)var6_13);
                }
                var4_4 = var5_8.toString();
                break;
            }
            case 4: 
            case 5: {
                var5_9 = new StringBuffer(var3_3);
                var3_3 += var2_2;
                if (var0 != 4) ** GOTO lbl74
                while (var2_2 < var3_3) {
                    var5_9.append((char)(var1_1[var2_2++] & 255));
                }
                ** GOTO lbl75
lbl-1000:
                // 1 sources

                {
                    var5_9.append((char)((var1_1[var2_2] & 255) << 8 | var1_1[var2_2 + 1] & 255));
                    var2_2 += 2;
lbl74:
                    // 2 sources

                    ** while (var2_2 < var3_3)
                }
lbl75:
                // 2 sources

                var4_4 = var5_9.toString();
            }
        }
        return var4_4;
    }

    public int encodeObject(byte[] byArray, int n) {
        return ASN1.encodeObject(this.mode, this.obj, byArray, n);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int encodeObject(int n, Object object, byte[] byArray, int n2) {
        switch (n) {
            case 8: {
                int n3 = (Integer)object;
                int n4 = n2;
                while (n3 != 0) {
                    if (--n2 >= 0) {
                        byArray[n2] = (byte)n3;
                    }
                    n3 >>>= 8;
                }
                if (n2 != n4 && byArray[n2] >= 0 || --n2 < 0) return n2;
                byArray[n2] = 0;
                return n2;
            }
            case 1: {
                byte[] byArray2 = ((BigInteger)object).toByteArray();
                if ((n2 -= byArray2.length) < 0) return n2;
                System.arraycopy((Object)byArray2, 0, (Object)byArray, n2, byArray2.length);
                return n2;
            }
            case 2: {
                if (--n2 < 0) return n2;
                byArray[n2] = (Boolean)object != false ? -1 : 0;
                return n2;
            }
            case 3: {
                String string = (String)object;
                int n5 = 1;
                int n6 = 0;
                int n7 = string.length();
                while (--n7 >= 0) {
                    char c2 = string.charAt(n7);
                    if (c2 == '.') {
                        if (n5 == 1) throw new CL3Exception(0x3000080);
                        n5 = 0;
                        while (n6 > 0) {
                            if (--n2 >= 0) {
                                byArray[n2] = (byte)(n6 & 0x7F | n5);
                            }
                            n6 >>= 7;
                            n5 = 128;
                        }
                        n5 = 1;
                        continue;
                    }
                    if (c2 < '0' || c2 > '9') throw new CL3Exception(0x3000080);
                    n6 += n5 * (c2 - 48);
                    n5 *= 10;
                }
                int n8 = n2;
                byArray[n8] = (byte)(byArray[n8] + n6 * 40);
                return n2;
            }
            case 6: {
                String string = (String)object;
                int n9 = string.length();
                while (--n9 >= 0) {
                    int n10 = string.charAt(n9) & 0xFFFF0000;
                    if (n10 <= 127) {
                        if (--n2 < 0) continue;
                        byArray[n2] = (byte)n10;
                        continue;
                    }
                    if (n10 <= 2047) {
                        if ((n2 -= 2) >= 0) {
                            byArray[n2] = (byte)(0xC0 | n10 >> 6);
                        }
                        byArray[n2 + 1] = (byte)(0x80 | n10 & 0x3F);
                        continue;
                    }
                    if (n10 > -65536) continue;
                    if ((n2 -= 3) >= 0) {
                        byArray[n2] = (byte)(0xE0 | n10 >> 12);
                    }
                    byArray[n2 + 1] = (byte)(0x80 | n10 >> 6 & 0x3F);
                    byArray[n2 + 2] = (byte)(0x80 | n10 & 0x3F);
                }
                return n2;
            }
            case 4: 
            case 5: {
                String string = (String)object;
                int n11 = string.length();
                while (--n11 >= 0) {
                    char c3 = string.charAt(n11);
                    if (n == 5 && --n2 >= 0) {
                        byArray[n2] = (byte)(c3 >> 8);
                    }
                    if (--n2 < 0) continue;
                    byArray[n2] = (byte)c3;
                }
                return n2;
            }
        }
        return n2;
    }

    public void setData(byte[] byArray, int n, int n2) {
        this.data = byArray;
        this.beg = n;
        this.len = n2;
    }

    public ASN1(byte[] byArray) {
        this(byArray, 0, byArray.length);
    }

    public ASN1(byte[] byArray, int n, int n2) {
        this.setData(byArray, n, n2);
    }

    public ASN1(int n, Object object) {
        this.mode = n;
        this.obj = object;
    }

    public ASN1(int n) {
        this.mode = n;
    }

    public ASN1() {
        this.mode = 0;
    }

    public static String toHex(byte[] byArray, int n, int n2) {
        n2 = n2 < 0 ? byArray.length : n2 + n;
        StringBuffer stringBuffer = new StringBuffer(n2 * 2);
        while (n < n2) {
            stringBuffer.append("0123456789ABCDEF".charAt(byArray[n] >> 4 & 0xF));
            stringBuffer.append("0123456789ABCDEF".charAt(byArray[n++] & 0xF));
        }
        return stringBuffer.toString();
    }

    public static byte[] toByteArray(String string) {
        byte[] byArray = new byte[string.length() / 2];
        int n = 0;
        while (n < byArray.length) {
            byArray[n] = (byte)(ASN1.hexDigit(string.charAt(2 * n)) << 4 | ASN1.hexDigit(string.charAt(2 * n + 1)));
            ++n;
        }
        return byArray;
    }

    private static int hexDigit(int n) {
        if (n >= 48 && n <= 57) {
            return n - 48;
        }
        if (n >= 65 && n <= 70) {
            return n - 55;
        }
        if (n >= 97 && n <= 102) {
            return n - 87;
        }
        return -1;
    }

    private static int rdLen(byte[] byArray, int n, int n2, int[] nArray) {
        if (n2 == 0) {
            n2 = byArray.length;
        }
        if ((n += 2) <= n2) {
            int n3 = byArray[n - 1] & 0xFF;
            if (n3 == 128) {
                n3 = -n - 1;
            }
            if (n3 > 128) {
                int n4 = n;
                if ((n += n3 & 0x7F) <= n2) {
                    n3 = 0;
                    while (n4 < n) {
                        n3 = n3 << 8 | byArray[n4++] & 0xFF;
                    }
                }
            } else if (n + n3 <= n2) {
                if (nArray != null) {
                    nArray[0] = n;
                }
                return n + n3;
            }
        }
        throw new CL3Exception(352321664);
    }

    public static int cntElements(byte[] byArray, int n, int n2) {
        int n3 = 0;
        int n4 = n + n2;
        while (n < n4) {
            n = ASN1.rdLen(byArray, n, n4, null);
            ++n3;
        }
        return n3;
    }

    private static int format0(String string, int n, int n2, byte[] byArray, int n3, ASN1[] aSN1Array) {
        block44: {
            while (n2 >= n) {
                int n4;
                int n5;
                int n6;
                block46: {
                    block47: {
                        ASN1 aSN1;
                        block48: {
                            int n7;
                            int n8;
                            block45: {
                                int n9 = -1;
                                int n10 = -1;
                                n8 = -1;
                                n7 = 0;
                                n6 = 0;
                                n5 = 0;
                                char c2 = string.charAt(n2);
                                if (c2 == ')') {
                                    n9 = n2 - 1;
                                    n4 = 0;
                                    do {
                                        if ((c2 = string.charAt(n2--)) == ')') {
                                            ++n4;
                                        } else if (c2 == '(') {
                                            --n4;
                                        }
                                        if (n2 <= n) break block44;
                                    } while (n4 > 0);
                                    n10 = n2 + 2;
                                    c2 = string.charAt(n2);
                                } else {
                                    n9 = -1;
                                }
                                if (c2 == ']') {
                                    while (n2 >= n) {
                                        c2 = string.charAt(n2 - 1);
                                        if (c2 == '+') {
                                            n5 |= 1;
                                        } else if (c2 == '&') {
                                            n5 |= 8;
                                        } else if (c2 == 'b') {
                                            n7 = 2;
                                        } else if (c2 == 'j') {
                                            n7 = 8;
                                        } else if (c2 == 'i') {
                                            n7 = 1;
                                        } else if (c2 == 'o') {
                                            n7 = 3;
                                        } else if (c2 == 'a') {
                                            n7 = 4;
                                        } else if (c2 == 'w') {
                                            n7 = 5;
                                        } else {
                                            if (c2 != 'u') break;
                                            n7 = 6;
                                        }
                                        --n2;
                                    }
                                    n4 = 1;
                                    while (--n2 >= n && (c2 = string.charAt(n2)) >= '0' && c2 <= '9') {
                                        n8 = n4 * (c2 - 48);
                                        n4 *= 10;
                                    }
                                    if (n2 <= n || c2 != '[') break block44;
                                    c2 = string.charAt(--n2);
                                }
                                while (true) {
                                    if (c2 == '?') {
                                        n5 |= 4;
                                    } else if (c2 == '@') {
                                        n5 |= 2;
                                    } else if (c2 != ':') break;
                                    if (--n2 > n) {
                                        c2 = string.charAt(n2);
                                        continue;
                                    }
                                    break block44;
                                    break;
                                }
                                if (c2 == '*') {
                                    if (n8 < 0) break block44;
                                    n5 |= 0x10;
                                } else if (c2 == 'X') {
                                    if (n8 < 0) break block44;
                                    n6 = aSN1Array[n8] == null ? -1 : aSN1Array[n8].tag;
                                } else if (n2 <= n || (n6 = ASN1.hexDigit(c2) | ASN1.hexDigit(string.charAt(--n2)) << 4) < 0) break block44;
                                while (--n2 >= n && string.charAt(n2) == ' ') {
                                }
                                if ((n5 & 4) != 0 && (n8 < 0 || aSN1Array[n8] == null || ((n5 & 8) != 0 ? aSN1Array[n8].obj : (Object)aSN1Array[n8].data) == null)) continue;
                                n4 = n3--;
                                if (n10 < 0) break block45;
                                n8 = -1;
                                n3 = ASN1.format0(string, n10, n9, byArray, n3, aSN1Array);
                                break block46;
                            }
                            if (n8 < 0) break block47;
                            aSN1 = aSN1Array[n8];
                            if ((n5 & 8) == 0) break block48;
                            if (n7 != 0) {
                                aSN1.mode = n7;
                            } else if (aSN1.mode == 0) continue;
                            n3 = aSN1.encodeObject(byArray, n3);
                            break block46;
                        }
                        if (aSN1 == null || aSN1.data == null) continue;
                        if ((n5 & 1) != 0) {
                            aSN1.len = ASN1.rdLen(aSN1.data, aSN1.beg, 0, null) - aSN1.beg;
                        }
                        if ((n3 -= aSN1.len) < 0 || byArray == aSN1.data && n3 == aSN1.beg) break block46;
                        System.arraycopy((Object)aSN1.data, aSN1.beg, (Object)byArray, n3, aSN1.len);
                        break block46;
                    }
                    if (n5 != 0 || n3 < 0) continue;
                    byArray[n3] = (byte)n6;
                    continue;
                }
                if ((n5 & 0x11) != 0) continue;
                if ((n4 -= n3) >= 128) {
                    int n11 = 128;
                    while (n4 > 0) {
                        if (--n3 >= 0) {
                            byArray[n3] = (byte)n4;
                        }
                        n4 >>= 8;
                        ++n11;
                    }
                    n4 = n11;
                }
                if (--n3 >= 0) {
                    byArray[n3] = (byte)n4;
                }
                if (--n3 < 0) continue;
                byArray[n3] = (byte)n6;
            }
            return n3;
        }
        throw new CL3Exception(0x5000080);
    }

    public static int format(String string, byte[] byArray, int n, ASN1[] aSN1Array) {
        return ASN1.format0(string, 0, string.length() - 1, byArray, n < 0 ? byArray.length : n, aSN1Array);
    }

    private static int scanIndefinite(byte[] byArray, int n, byte[] byArray2, int[] nArray, int n2) {
        int n3 = 1;
        int n4 = nArray[0];
        while (n3 > 0) {
            if (n4 + 2 > n2) {
                throw new CL3Exception(352321664);
            }
            if (byArray2[n4] == 0 && byArray2[n4 + 1] == 0) {
                --n3;
                n4 += 2;
                continue;
            }
            if ((n4 = ASN1.rdLen(byArray2, n4, n2, nArray)) < 0) {
                n4 = nArray[0];
                ++n3;
                continue;
            }
            if (byArray == null) continue;
            System.arraycopy((Object)byArray2, nArray[0], (Object)byArray, n, n4 - nArray[0]);
            n += n4 - nArray[0];
        }
        nArray[0] = n4;
        return byArray == null ? n4 : n;
    }

    private static char getChar(String string, int n) {
        return n >= string.length() ? (char)'\u0000' : string.charAt(n);
    }

    private static int scan0(char c2, String string, int n, byte[] byArray, int n2, int n3, ASN1[] aSN1Array, int[] nArray) {
        block56: {
            block0: while (true) {
                char c3;
                int n4 = -1;
                int n5 = 0;
                ASN1 aSN1 = null;
                while ((c3 = ASN1.getChar(string, n++)) == ' ') {
                }
                if (c3 == '\u0000' || c3 == ')') {
                    if ((c3 ^ c2) != 0) break;
                    if (n2 == n3) {
                        return n;
                    }
                } else {
                    int n6;
                    int n7;
                    if (c3 == '*') {
                        n7 = -2;
                    } else if (c3 == 'X') {
                        n7 = -1;
                    } else {
                        n7 = ASN1.hexDigit(c3) << 4 | ASN1.hexDigit(ASN1.getChar(string, n++));
                        if (n7 < 0) break;
                    }
                    while (true) {
                        if ((c3 = ASN1.getChar(string, n++)) == '?') {
                            n5 |= 4;
                            continue;
                        }
                        if (c3 == '@') {
                            n5 |= 2;
                            continue;
                        }
                        if (c3 != ':') break;
                        n5 |= 0x20;
                    }
                    if (c3 == '[') {
                        n4 = 0;
                        while ((c3 = ASN1.getChar(string, n++)) >= '0' && c3 <= '9') {
                            n4 = n4 * 10 + c3 - 48;
                        }
                        aSN1 = aSN1Array[n4];
                        if (aSN1 == null) {
                            aSN1 = aSN1Array[n4] = new ASN1();
                        }
                        aSN1Array[n4].data = byArray;
                        while (true) {
                            if (c3 == '&') {
                                n5 |= 8;
                            } else if (c3 == '+') {
                                n5 |= 1;
                            } else {
                                if (c3 == ']') break;
                                if (c3 == 'b') {
                                    aSN1.mode = 2;
                                } else if (c3 == 'j') {
                                    aSN1.mode = 8;
                                } else if (c3 == 'i') {
                                    aSN1.mode = 1;
                                } else if (c3 == 'o') {
                                    aSN1.mode = 3;
                                } else if (c3 == 'a') {
                                    aSN1.mode = 4;
                                } else if (c3 == 'w') {
                                    aSN1.mode = 5;
                                } else if (c3 == 'u') {
                                    aSN1.mode = 6;
                                } else {
                                    if (c3 != 's') break block0;
                                    aSN1.mode = 7;
                                }
                            }
                            c3 = ASN1.getChar(string, n++);
                        }
                        c3 = ASN1.getChar(string, n++);
                    }
                    if (n7 == -2) {
                        if (c3 != c2) break;
                        if (aSN1 != null) {
                            aSN1.beg = n2;
                            aSN1.len = n3 - aSN1.beg;
                        }
                        return n;
                    }
                    if (c3 != '(') {
                        --n;
                    }
                    if (n3 != 0 && n2 + 1 > n3 || n7 != -1 && n7 != (byArray[n2] & 0xFF)) {
                        if ((n5 & 4) != 0) {
                            if (aSN1 != null) {
                                aSN1.data = null;
                                aSN1.beg = -1;
                                aSN1.len = -1;
                                aSN1.tag = -1;
                            }
                            if (c3 != '(') continue;
                            n6 = 0;
                            while (true) {
                                if (n6 < 0) continue block0;
                                if ((c3 = ASN1.getChar(string, n++)) == ')') {
                                    --n6;
                                    continue;
                                }
                                if (c3 == '(') {
                                    ++n6;
                                    continue;
                                }
                                if (c3 == '\u0000') break block0;
                            }
                        }
                    } else {
                        if (n7 == -1) {
                            n7 = byArray[n2] & 0xFF;
                        }
                        if ((n5 & 0x26) == 0 && aSN1 == null && c3 != '(') {
                            ++n2;
                            continue;
                        }
                        int n8 = n2;
                        if ((n2 = ASN1.rdLen(byArray, n2, n3, nArray)) < 0) {
                            if ((n5 & 2) != 0) {
                                if (c3 != '(') {
                                    n2 = ASN1.scanIndefinite(null, 0, byArray, nArray, n3);
                                    if (aSN1 == null) continue;
                                    aSN1.tag = n7;
                                    aSN1.beg = (n5 & 1) != 0 ? n8 : nArray[0];
                                    aSN1.len = n2 - aSN1.beg - 2;
                                    continue;
                                }
                                n6 = ASN1.scanIndefinite(byArray, n8, byArray, nArray, n3);
                                if (aSN1 != null) {
                                    aSN1.tag = n7;
                                    aSN1.beg = n8;
                                    aSN1.len = n6 - n8;
                                }
                                n2 = nArray[0];
                                n = ASN1.scan0(')', string, n, byArray, n8, n6, aSN1Array, nArray);
                                continue;
                            }
                        } else if (n2 <= n3) {
                            if (aSN1 != null) {
                                aSN1.tag = n7;
                                if ((n5 & 1) != 0) {
                                    aSN1.beg = n8;
                                    aSN1.len = n2 - aSN1.beg;
                                } else {
                                    aSN1.beg = nArray[0];
                                    aSN1.len = n2 - aSN1.beg;
                                }
                                if ((n5 & 8) != 0 && aSN1.mode != 0) {
                                    aSN1.obj = aSN1.decodeObject();
                                }
                            }
                            if (c3 != '(') continue;
                            n = ASN1.scan0(')', string, n, byArray, nArray[0], n2, aSN1Array, nArray);
                            continue;
                        }
                    }
                }
                break block56;
                break;
            }
            throw new CL3Exception(0x5000080);
        }
        throw new CL3Exception(352321664);
    }

    public static int scan(String string, byte[] byArray, int n, int n2, ASN1[] aSN1Array) {
        n2 = n2 < 0 ? ASN1.rdLen(byArray, n, 0, null) : (n2 += n);
        ASN1.scan0('\u0000', string, 0, byArray, n, n2, aSN1Array, new int[1]);
        return n2;
    }

    public int oidCRC() {
        int n = 0;
        int n2 = this.beg;
        int n3 = n2 + this.len;
        while (n2 < n3) {
            n = (n >>> 16) + n * 61 + (this.data[n2++] & 0xFF);
        }
        return n;
    }
}

