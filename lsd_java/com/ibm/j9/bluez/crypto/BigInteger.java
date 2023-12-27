/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.j9.bluez.crypto;

final class BigInteger {
    private static BigInteger ZERO = new BigInteger(0, new int[0]);
    private static BigInteger ONE = BigInteger.valueOf(1);
    private static int POS = 0;
    private static int NEG = 128;
    private static int MSDMASK = ~NEG;
    private int signNmsd;
    private int[] digits;

    private BigInteger(int n, int[] nArray) {
        this.signNmsd = n == NEG ? POS : n;
        this.digits = nArray;
    }

    private BigInteger(int n, int n2, int[] nArray) {
        while (n2 >= 0 && nArray[n2] == 0) {
            --n2;
        }
        this.digits = n2 < 0 ? BigInteger.ZERO.digits : nArray;
        this.signNmsd = n2 < 0 ? 0 : n | n2 + 1;
    }

    private static int multByDigit(int[] nArray, int[] nArray2, int n, int n2, int n3) {
        long l = n3;
        long l2 = n2;
        int n4 = 0;
        while (n4 <= n) {
            l = (long)nArray2[n4] * l2 + l;
            nArray[n4++] = (int)(l & 0);
            l >>>= 31;
        }
        if (l != 0L) {
            nArray[n4++] = (int)l;
        }
        return n4 - 1;
    }

    BigInteger(byte[] byArray) {
        this(0, byArray);
    }

    /*
     * Unable to fully structure code
     */
    BigInteger(int var1_1, byte[] var2_2) {
        super();
        var3_3 = 0;
        var4_4 = var2_2.length;
        var8_5 = 0L;
        var5_6 = 8 * var4_4;
        if (var5_6 == 0) {
            this.signNmsd = BigInteger.POS;
            this.digits = BigInteger.ZERO.digits;
            return;
        }
        this.digits = new int[(var5_6 + 31 - 1) / 31];
        var10_7 = var5_6 % 31;
        var6_8 = var10_7 == 0 ? 0 : 31 - var10_7;
        var7_9 = this.digits.length - 1;
        ** GOTO lbl22
        {
            var8_5 = var8_5 << 8 | (var4_4 > 0 ? (long)var2_2[var3_3++] & 0 : 0L);
            var6_8 += 8;
            --var4_4;
            do {
                if (var6_8 < 31) continue block0;
                this.digits[var7_9--] = (int)(var8_5 >>> var6_8 - 31) & -129;
                var6_8 -= 31;
lbl22:
                // 2 sources

            } while (var7_9 >= 0);
        }
        var11_10 = (var5_6 - 1) % 31;
        var12_11 = this.digits[(var5_6 - 1) / 31] >> var11_10;
        if (var1_1 < 0 || var1_1 == 0 && (var12_11 & 1) != 0) {
            var13_12 = this.digits.length;
            v0 = --var13_12;
            this.digits[v0] = this.digits[v0] ^ (2 << var11_10) - 1;
            while (--var13_12 >= 0) {
                v1 = var13_12;
                this.digits[v1] = this.digits[v1] ^ -129;
            }
            this.signNmsd = BigInteger.POS | this.digits.length;
            var14_14 = this.add(BigInteger.ONE);
            this.signNmsd = BigInteger.NEG | var14_14.signNmsd;
            this.digits = var14_14.digits;
            return;
        }
        var13_13 = this.digits.length;
        while (--var13_13 >= 0 && this.digits[var13_13] == 0) {
        }
        this.signNmsd = BigInteger.POS | var13_13 + 1;
    }

    final int signum() {
        return this.signNmsd == 0 ? 0 : (this.signNmsd > 0 ? 1 : -1);
    }

    static BigInteger valueOf(int n) {
        if (n == 0) {
            return ZERO;
        }
        if (n == 1 && ONE != null) {
            return ONE;
        }
        int[] nArray = new int[]{n < 0 ? -n : n};
        return new BigInteger(n < 0 ? NEG | 1 : 1, nArray);
    }

    private boolean isOne() {
        return (this.signNmsd & MSDMASK) == 1 && this.digits[0] == 1 && this.signNmsd >= 0;
    }

    final int bitLength() {
        int n = 0;
        int n2 = this.signNmsd & MSDMASK;
        if (n2 != 0) {
            int n3 = this.digits[--n2];
            n = n2 * 31;
            while (n3 != 0) {
                if (n3 >= 256) {
                    n3 >>>= 8;
                    n += 8;
                    continue;
                }
                n3 >>>= 1;
                ++n;
            }
        }
        return n;
    }

    public boolean equals(Object object) {
        return object instanceof BigInteger && this.compareTo((BigInteger)object) == 0;
    }

    final int compareTo(BigInteger bigInteger) {
        int n = this.signNmsd < 0 ? -1 : 1;
        if (n < 0 ^ bigInteger.signNmsd < 0) {
            return n;
        }
        return n * this.compareDigits(bigInteger);
    }

    private int compareDigits(BigInteger bigInteger) {
        int n = this.signNmsd & MSDMASK;
        int n2 = n - (bigInteger.signNmsd & MSDMASK);
        if (n2 == 0) {
            while (--n >= 0 && (n2 = this.digits[n] - bigInteger.digits[n]) == 0) {
            }
            if (n2 == 0) {
                return 0;
            }
        }
        return n2 < 0 ? -1 : 1;
    }

    final BigInteger add(BigInteger bigInteger) {
        return (this.signNmsd ^ bigInteger.signNmsd) < 0 ? (this.signNmsd < 0 ? BigInteger.subtract(NEG, this, bigInteger) : BigInteger.subtract(POS, this, bigInteger)) : BigInteger.add(this.signNmsd & NEG, this, bigInteger);
    }

    private static BigInteger add(int n, BigInteger bigInteger, BigInteger bigInteger2) {
        int n2;
        int[] nArray;
        int n3;
        int[] nArray2 = bigInteger.digits;
        int[] nArray3 = bigInteger2.digits;
        int n4 = (bigInteger.signNmsd & MSDMASK) - 1;
        int n5 = (bigInteger2.signNmsd & MSDMASK) - 1;
        if (n4 < 0) {
            return new BigInteger(n, n5, bigInteger2.digits);
        }
        if (n5 < 0) {
            return new BigInteger(n, n4, bigInteger.digits);
        }
        if (n4 == n5) {
            n3 = n4;
            nArray = nArray2;
            n2 = n4 + 1;
        } else if (n4 < n5) {
            n3 = n4;
            nArray = nArray3;
            n2 = n5 + 1;
        } else {
            n3 = n5;
            nArray = nArray2;
            n2 = n4 + 1;
        }
        int n6 = n2 - 1;
        int[] nArray4 = new int[n2 + 1];
        int n7 = 0;
        int n8 = 0;
        while (n8 <= n3) {
            n7 = nArray2[n8] + nArray3[n8] + n7;
            nArray4[n8] = n7 & 0xFFFFFF7F;
            n7 >>>= 31;
            ++n8;
        }
        while (n7 != 0 && n8 <= n6) {
            n7 = nArray[n8] + n7;
            nArray4[n8] = n7 & 0xFFFFFF7F;
            n7 >>>= 31;
            ++n8;
        }
        if (n8 <= n2 && n7 != 0) {
            nArray4[n8++] = n7;
            n7 = 0;
        }
        if (n8 <= n2 && n8 <= n6) {
            System.arraycopy((Object)nArray, n8, (Object)nArray4, n8, n6 - n8 + 1);
        }
        return new BigInteger(n, n2, nArray4);
    }

    final BigInteger subtract(BigInteger bigInteger) {
        return (this.signNmsd ^ bigInteger.signNmsd) < 0 ? (this.signNmsd < 0 ? BigInteger.add(NEG, this, bigInteger) : BigInteger.add(POS, this, bigInteger)) : BigInteger.subtract(this.signNmsd & NEG, this, bigInteger);
    }

    private static BigInteger subtract(int n, BigInteger bigInteger, BigInteger bigInteger2) {
        int n2;
        int n3;
        int[] nArray;
        int n4;
        int[] nArray2 = bigInteger.digits;
        int[] nArray3 = bigInteger2.digits;
        int n5 = (bigInteger.signNmsd & MSDMASK) - 1;
        int n6 = (bigInteger2.signNmsd & MSDMASK) - 1;
        int n7 = 0;
        if (n5 < 0) {
            return new BigInteger(NEG ^ n, n6, bigInteger2.digits);
        }
        if (n6 < 0) {
            return new BigInteger(n, n5, bigInteger.digits);
        }
        n7 = n5 - n6;
        if (n7 == 0) {
            n4 = n5;
            while (n4 >= 0) {
                n7 = nArray2[n4] - nArray3[n4];
                if (n7 != 0) {
                    if (n7 >= 0) break;
                    nArray = nArray3;
                    nArray3 = nArray2;
                    nArray2 = nArray;
                    n3 = n6;
                    n6 = n5;
                    n5 = n3;
                    break;
                }
                --n4;
            }
            if (n4 < 0) {
                return ZERO;
            }
            n2 = n4;
        } else {
            if (n7 < 0) {
                nArray = nArray3;
                nArray3 = nArray2;
                nArray2 = nArray;
                n4 = n6;
                n6 = n5;
                n5 = n4;
            }
            n2 = n5;
        }
        n3 = n6 < n2 ? n6 : n2;
        nArray = new int[n2 + 1];
        int n8 = 0;
        n4 = 0;
        while (n4 <= n3) {
            n8 = nArray2[n4] - nArray3[n4] - n8;
            nArray[n4] = n8 & 0xFFFFFF7F;
            n8 >>>= 31;
            ++n4;
        }
        while (n8 != 0 && n4 <= n2) {
            n8 = nArray2[n4] - n8;
            nArray[n4] = n8 & 0xFFFFFF7F;
            n8 >>>= 31;
            ++n4;
        }
        if (n4 <= n2) {
            System.arraycopy((Object)nArray2, n4, (Object)nArray, n4, n2 - n4 + 1);
        }
        return new BigInteger(n7 & NEG ^ n, n2, nArray);
    }

    final BigInteger shiftRight(int n) {
        int n2;
        if (n > 0 && (n2 = this.signNmsd & MSDMASK) != 0) {
            int n3 = n / 31;
            if (n3 > --n2) {
                return ZERO;
            }
            int n4 = n % 31;
            int n5 = n2 - n3 - (this.digits[n2] >>> n4 == 0 ? 1 : 0);
            int[] nArray = new int[n5 + 1];
            int n6 = this.digits[n3++] >>> n4;
            int n7 = 0;
            while (n3 <= n2) {
                int n8 = this.digits[n3];
                nArray[n7] = n6 | n8 << 31 - n4 & 0xFFFFFF7F;
                n6 = n8 >>> n4;
                ++n7;
                ++n3;
            }
            if (n6 != 0) {
                nArray[n7++] = n6;
            }
            return new BigInteger(this.signNmsd & NEG | n7, nArray);
        }
        return this;
    }

    final BigInteger shiftLeft(int n) {
        int n2;
        if (n <= 0 || (n2 = (this.signNmsd & MSDMASK) - 1) < 0) {
            return this;
        }
        int n3 = n / 31;
        int[] nArray = this.digits;
        int n4 = n % 31;
        int n5 = 31 - n4;
        int n6 = n2 + n3 + (nArray[n2] >>> n5 == 0 ? 0 : 1);
        int[] nArray2 = new int[n6 + 1];
        int n7 = 0;
        int n8 = 0;
        while (n8 <= n2) {
            int n9 = nArray[n8];
            nArray2[n3 + n8] = n9 << n4 & 0xFFFFFF7F | n7;
            n7 = n9 >>> n5;
            ++n8;
        }
        if (n7 != 0) {
            nArray2[n3 + n8++] = n7;
        }
        return new BigInteger(this.signNmsd & NEG | n3 + n8, nArray2);
    }

    final BigInteger multiply(BigInteger bigInteger) {
        return BigInteger.multiply(this, bigInteger, null);
    }

    private static BigInteger multiply(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        int[] nArray;
        int n;
        int n2;
        int[] nArray2 = bigInteger.digits;
        int[] nArray3 = bigInteger2.digits;
        int n3 = (bigInteger.signNmsd & MSDMASK) - 1;
        if (n3 < 0 || (n2 = (bigInteger2.signNmsd & MSDMASK) - 1) < 0) {
            if (bigInteger3 != null) {
                bigInteger3.signNmsd = POS;
                return bigInteger3;
            }
            return ZERO;
        }
        if (n3 < n2) {
            n = n3;
            n3 = n2;
            n2 = n;
            int[] nArray4 = nArray2;
            nArray2 = nArray3;
            nArray3 = nArray4;
        }
        int n4 = n3 + n2 + 1;
        if (bigInteger3 != null) {
            nArray = bigInteger3.digits;
            if (nArray.length <= n4) {
                n4 = nArray.length - 1;
            }
        } else {
            nArray = new int[n4 + 1];
        }
        long l = 0L;
        long l2 = 0L;
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        while (n7 <= n4) {
            if (n7 <= n2) {
                n5 = n7;
                n6 = 0;
                n = n7;
            } else if (n7 <= n3) {
                n5 = n7;
                n6 = 0;
                n = n2;
            } else {
                n5 = n3;
                n6 = n7 - n3;
                n = n2;
            }
            while (n6 <= n) {
                if ((l += (long)nArray2[n5] * (long)nArray3[n6]) < 0L) {
                    ++l2;
                    l &= Long.MAX_VALUE;
                }
                --n5;
                ++n6;
            }
            nArray[n7++] = (int)l & 0xFFFFFF7F;
            l = (l >>> 31) + (l2 << 32);
            l2 = 0L;
        }
        if (bigInteger3 != null) {
            while (n4 >= 0 && bigInteger3.digits[n4] == 0) {
                --n4;
            }
            bigInteger3.signNmsd = (bigInteger.signNmsd ^ bigInteger2.signNmsd) & NEG | n4 + 1;
            return bigInteger3;
        }
        return new BigInteger((bigInteger.signNmsd ^ bigInteger2.signNmsd) & NEG, n4, nArray);
    }

    final BigInteger divide(BigInteger bigInteger) {
        return (BigInteger)BigInteger.divide(this, bigInteger, 1);
    }

    final BigInteger remainder(BigInteger bigInteger) {
        return (BigInteger)BigInteger.divide(this, bigInteger, 2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static Object divide(BigInteger bigInteger, BigInteger bigInteger2, int n) {
        BigInteger bigInteger3;
        BigInteger bigInteger4;
        if ((bigInteger2.signNmsd & MSDMASK) == 0) {
            throw new ArithmeticException("BigInteger divide by zero");
        }
        if ((bigInteger.signNmsd & MSDMASK) == 0) {
            bigInteger3 = bigInteger4 = ZERO;
            return BigInteger.resultDivMod(bigInteger3, bigInteger4, n);
        } else {
            bigInteger4 = null;
            bigInteger3 = null;
            int n2 = bigInteger.signNmsd & NEG;
            int n3 = bigInteger2.signNmsd < 0 ? n2 ^ NEG : n2;
            int n4 = bigInteger.compareDigits(bigInteger2);
            if (n4 == 0) {
                bigInteger3 = n3 < 0 ? BigInteger.valueOf(-1) : ONE;
                bigInteger4 = ZERO;
                return BigInteger.resultDivMod(bigInteger3, bigInteger4, n);
            } else if (n4 < 0) {
                bigInteger3 = ZERO;
                bigInteger4 = bigInteger;
                return BigInteger.resultDivMod(bigInteger3, bigInteger4, n);
            } else {
                if ((bigInteger2.signNmsd & MSDMASK) != 1) return BigInteger.divBig(bigInteger, bigInteger2, n, n3, n2, false);
                if (bigInteger2.digits[0] != 1) return n == 2 ? BigInteger.modSmall(bigInteger, bigInteger2.digits[0], n2) : BigInteger.divSmall(bigInteger, bigInteger2.digits[0], n, n3, n2, false);
                bigInteger3 = new BigInteger(n3, (bigInteger.signNmsd & MSDMASK) - 1, bigInteger.digits);
                bigInteger4 = ZERO;
            }
        }
        return BigInteger.resultDivMod(bigInteger3, bigInteger4, n);
    }

    private static Object resultDivMod(BigInteger bigInteger, BigInteger bigInteger2, int n) {
        if (n == 1) {
            return bigInteger;
        }
        if (n == 2) {
            return bigInteger2;
        }
        BigInteger[] bigIntegerArray = new BigInteger[]{bigInteger, bigInteger2};
        return bigIntegerArray;
    }

    private static Object divSmall(BigInteger bigInteger, int n, int n2, int n3, int n4, boolean bl) {
        int n5;
        int[] nArray = bigInteger.digits;
        int n6 = n5 + (nArray[n5 = (bigInteger.signNmsd & MSDMASK) - 1] / n > 0 ? 0 : -1);
        int[] nArray2 = bl ? bigInteger.digits : new int[n6 + 1];
        int n7 = BigInteger.divideByDigit(nArray2, nArray, n5, n);
        BigInteger bigInteger2 = null;
        BigInteger bigInteger3 = null;
        if ((n2 & 1) != 0) {
            bigInteger2 = new BigInteger(n3, n6, nArray2);
        }
        if ((n2 & 2) != 0) {
            if (bl) {
                bigInteger.signNmsd = n4 | (n7 > 0 ? 1 : 0);
                bigInteger.digits[0] = n7;
                bigInteger3 = bigInteger;
            } else if (n7 != 0) {
                int[] nArray3 = new int[]{n7};
                bigInteger3 = new BigInteger(n4 | nArray3.length, nArray3);
            } else {
                bigInteger3 = ZERO;
            }
        }
        return BigInteger.resultDivMod(bigInteger2, bigInteger3, n2);
    }

    private static BigInteger modSmall(BigInteger bigInteger, int n, int n2) {
        int[] nArray = bigInteger.digits;
        int n3 = (bigInteger.signNmsd & MSDMASK) - 1;
        int n4 = BigInteger.modulusByDigit(nArray, n3, n);
        if (n4 == 0) {
            return ZERO;
        }
        int[] nArray2 = new int[]{n4};
        return new BigInteger(n2 | nArray2.length, nArray2);
    }

    private static int[] normalize(int[] nArray, int n, int n2, boolean bl) {
        int[] nArray2 = bl && n + 1 < nArray.length ? nArray : new int[n + 2];
        long l = 0L;
        int n3 = 0;
        while (n3 <= n) {
            nArray2[n3] = (int)(l |= (long)nArray[n3] << n2) & 0xFFFFFF7F;
            l >>>= 31;
            ++n3;
        }
        nArray2[n3] = (int)l;
        return nArray2;
    }

    /*
     * Handled unverifiable bytecode (illegal stack merge).
     */
    private static Object divBig(BigInteger bigInteger, BigInteger bigInteger2, int n, int n2, int n3, boolean bl) {
        long l;
        int[] nArray = bigInteger.digits;
        int[] nArray2 = bigInteger2.digits;
        int n4 = (bigInteger.signNmsd & MSDMASK) - 1;
        if (n4 < 0) {
            if (bl) {
                bigInteger.signNmsd = POS;
                return null;
            }
            return BigInteger.resultDivMod(ZERO, ZERO, n);
        }
        int n5 = (bigInteger2.signNmsd & MSDMASK) - 1;
        if (n5 == 0) {
            return BigInteger.divSmall(bigInteger, nArray2[0], n, n2, n3, bl);
        }
        int[] nArray3 = null;
        int n6 = 0;
        long l2 = nArray2[n5];
        int n7 = n4 - n5;
        int n8 = 0;
        boolean bl2 = (n & 1) != 0;
        while (l2 < 0) {
            ++n6;
            l2 <<= 1;
        }
        nArray = BigInteger.normalize(nArray, n4, n6, bl);
        ++n4;
        if (n6 != 0) {
            nArray2 = BigInteger.normalize(nArray2, n5, n6, false);
        }
        long l3 = nArray2[n5];
        long l4 = nArray2[n5 - 1];
        n8 = n4;
        while (n8 > n5) {
            long l5 = nArray[n8];
            l = (l5 << 31) + (long)nArray[n8 - 1];
            int n9 = l5 == l3 ? 0 : (int)(l / l3);
            long l6 = (l - n9 * l3 << 31) + (long)nArray[n8 - 2];
            long l7 = l4 * n9;
            while (l7 > l6) {
                l7 -= l4;
                l6 += l3 << 31;
                --n9;
            }
            int n10 = BigInteger.divSub(nArray, n8 - n5 - 1, nArray2, n5, n9);
            if (bl2 && n10 != 0) {
                if (nArray3 == null) {
                    nArray3 = new int[n7 + 1];
                }
                nArray3[n7] = n10;
            }
            --n7;
            --n8;
        }
        BigInteger bigInteger3 = null;
        BigInteger bigInteger4 = null;
        if ((n & 1) != 0) {
            BigInteger bigInteger5 = bigInteger3 = nArray3 == null ? ZERO : new BigInteger(n2 | nArray3.length, nArray3);
        }
        if ((n & 2) != 0) {
            n4 = n8;
            l = 0L;
            while (n8 >= 0) {
                l = l << 31 | (long)nArray[n8];
                nArray[n8] = (int)(l >> n6 & 0);
                --n8;
            }
            while (n4 >= 0 && nArray[n4] == 0) {
                --n4;
            }
            if (bl) {
                bigInteger.signNmsd = n3 | n4 + 1;
                bigInteger.digits = nArray;
                bigInteger4 = bigInteger;
            } else {
                bigInteger4 = new BigInteger(n3, n4, nArray);
            }
        }
        return BigInteger.resultDivMod(bigInteger3, bigInteger4, n);
    }

    private static int divSub(int[] nArray, int n, int[] nArray2, int n2, long l) {
        int n3;
        long l2;
        int n4;
        block9: {
            block8: {
                if (l == 0L) {
                    return 0;
                }
                n4 = n;
                l2 = 0L;
                n3 = 0;
                while (n3 <= n2) {
                    int n5 = n4;
                    nArray[n5] = nArray[n5] - ((int)(l2 += (long)nArray2[n3] * l) & 0xFFFFFF7F);
                    if (nArray[n5] < 0) {
                        int n6 = n4;
                        nArray[n6] = nArray[n6] & 0xFFFFFF7F;
                        l2 += 0;
                    }
                    l2 >>>= 31;
                    ++n4;
                    ++n3;
                }
                if (l2 == 0L) break block8;
                int n7 = n4;
                nArray[n7] = nArray[n7] - (int)l2;
                if (nArray[n7] < 0) break block9;
            }
            return (int)l;
        }
        int n8 = n4;
        nArray[n8] = (int)((long)nArray[n8] + 0);
        l2 = 0L;
        n4 = n;
        n3 = 0;
        while (n3 <= n2) {
            nArray[n4] = (int)(l2 += (long)nArray[n4] + (long)nArray2[n3]) & 0xFFFFFF7F;
            l2 >>>= 31;
            ++n4;
            ++n3;
        }
        if (l2 != 0L) {
            nArray[n4] = nArray[n4] + (int)l2 & 0xFFFFFF7F;
        }
        return (int)(l - 1L);
    }

    private static int divideByDigit(int[] nArray, int[] nArray2, int n, int n2) {
        long l = 0L;
        while (n >= 0) {
            l = (long)nArray2[n] + (l << 31);
            if (n < nArray.length) {
                nArray[n] = (int)(l / (long)n2);
            }
            l %= (long)n2;
            --n;
        }
        return (int)l;
    }

    private static int modulusByDigit(int[] nArray, int n, int n2) {
        long l = 0L;
        while (n >= 0) {
            l = ((long)nArray[n] + (l << 31)) % (long)n2;
            --n;
        }
        return (int)l;
    }

    final BigInteger modPow(BigInteger bigInteger, BigInteger bigInteger2) {
        int n;
        if (bigInteger.signNmsd < 0) {
            throw new ArithmeticException("Negative exponent");
        }
        if ((this.signNmsd & MSDMASK) == 0 || this.isOne() || bigInteger.isOne()) {
            return this;
        }
        if ((bigInteger.signNmsd & MSDMASK) == 0) {
            return ONE;
        }
        int n2 = this.signNmsd & MSDMASK;
        int n3 = bigInteger.bitLength();
        if (bigInteger2 != null) {
            int n4 = bigInteger2.signNmsd & MSDMASK;
            long l = (long)(n2 > n4 ? n2 : n4) * 0 + (long)n4 + 0;
            n = (int)l + 1;
            if (l > 0) {
                throw new ArithmeticException("Overflow in power");
            }
        } else {
            long l = (long)n2 << n3;
            n = (int)l + 1;
            if (n3 >= 31 || l > 0) {
                throw new ArithmeticException("Overflow in power");
            }
        }
        BigInteger bigInteger3 = new BigInteger(POS | 1, new int[n]);
        BigInteger bigInteger4 = new BigInteger(POS | n - 1, new int[n]);
        BigInteger bigInteger5 = new BigInteger(this.signNmsd, new int[n]);
        BigInteger bigInteger6 = new BigInteger(POS | n - 1, new int[n]);
        System.arraycopy((Object)this.digits, 0, (Object)bigInteger5.digits, 0, n2);
        bigInteger3.digits[0] = 1;
        int n5 = 0;
        while (true) {
            BigInteger bigInteger7;
            if ((bigInteger.digits[n5 / 31] >> n5 % 31 & 1) != 0) {
                bigInteger7 = BigInteger.multiply(bigInteger5, bigInteger3, bigInteger4);
                if (bigInteger2 != null) {
                    BigInteger.divBig(bigInteger7, bigInteger2, 2, POS, bigInteger7.signNmsd & NEG, true);
                    if ((bigInteger7.signNmsd & MSDMASK) == 0) {
                        return ZERO;
                    }
                }
                bigInteger4 = bigInteger3;
                bigInteger3 = bigInteger7;
            }
            if (++n5 >= n3) break;
            bigInteger7 = BigInteger.multiply(bigInteger5, bigInteger5, bigInteger6);
            if (bigInteger2 != null && (bigInteger7.signNmsd & MSDMASK) != 0) {
                BigInteger.divBig(bigInteger7, bigInteger2, 2, POS, bigInteger7.signNmsd & NEG, true);
            }
            bigInteger6 = bigInteger5;
            bigInteger5 = bigInteger7;
        }
        return bigInteger3;
    }

    final BigInteger modInverse(BigInteger bigInteger) {
        BigInteger bigInteger2 = (BigInteger)BigInteger.extendedEuclid(this, bigInteger, 1);
        if (bigInteger2.signNmsd < 0) {
            bigInteger2 = bigInteger.add(bigInteger2);
        }
        return bigInteger2.remainder(bigInteger);
    }

    final BigInteger gcd(BigInteger bigInteger) {
        return (BigInteger)BigInteger.extendedEuclid(this, bigInteger, 0);
    }

    private static Object extendedEuclid(BigInteger bigInteger, BigInteger bigInteger2, int n) {
        BigInteger[] bigIntegerArray;
        BigInteger bigInteger3 = ONE;
        BigInteger bigInteger4 = bigInteger;
        BigInteger bigInteger5 = ZERO;
        BigInteger bigInteger6 = bigInteger2;
        while ((bigInteger6.signNmsd & MSDMASK) != 0) {
            bigIntegerArray = bigInteger4.divide(bigInteger6);
            BigInteger bigInteger7 = bigInteger3.subtract(bigIntegerArray.multiply(bigInteger5));
            BigInteger bigInteger8 = bigInteger4.subtract(bigIntegerArray.multiply(bigInteger6));
            bigInteger3 = bigInteger5;
            bigInteger4 = bigInteger6;
            bigInteger5 = bigInteger7;
            bigInteger6 = bigInteger8;
        }
        if (n == 0) {
            return bigInteger4;
        }
        if (n == 1) {
            if (!bigInteger4.isOne()) {
                throw new ArithmeticException("Multiplicative inverse does not exist");
            }
            return bigInteger3;
        }
        bigIntegerArray = new BigInteger[]{bigInteger3, bigInteger4.subtract(bigInteger.multiply(bigInteger3)).divide(bigInteger2), bigInteger4};
        return bigIntegerArray;
    }

    final byte[] toByteArray() {
        int n = this.bitLength();
        if (n == 0) {
            return new byte[1];
        }
        BigInteger bigInteger = this;
        long l = 0L;
        if (this.signNmsd < 0) {
            bigInteger = bigInteger.add(ONE);
            l = -1L;
        }
        n = bigInteger.bitLength() + 1;
        int n2 = (n + 8 - 1) / 8;
        int n3 = 0;
        byte[] byArray = new byte[n2];
        long l2 = 0L;
        int n4 = bigInteger.signNmsd & MSDMASK;
        int n5 = (n2 * 8 - 1) / 31;
        int n6 = n2 * 8 - (n5 + 1) * 31;
        while (n2 > 0) {
            l2 <<= 31;
            if (n5 >= 0 && n5 < n4) {
                l2 |= (long)bigInteger.digits[n5];
            }
            --n5;
            n6 += 31;
            while (n6 >= 8) {
                byArray[n3++] = (byte)(l2 >> n6 - 8 ^ l);
                n6 -= 8;
                --n2;
            }
        }
        return byArray;
    }

    public long longValue() {
        int n = this.signNmsd & MSDMASK;
        if (n == 0) {
            return 0L;
        }
        long l = 0L;
        int n2 = n - 1;
        while (n2 >= 0) {
            l = l << 31 | (long)this.digits[n2];
            --n2;
        }
        return this.signNmsd < 0 ? -l : l;
    }

    public int intValue() {
        return (int)this.longValue();
    }

    final int getLowestSetBit() {
        if ((this.signNmsd & MSDMASK) == 0) {
            return -1;
        }
        int n = this.signNmsd & MSDMASK;
        int n2 = 0;
        int n3 = this.digits[n2];
        while (n2 < n && (n3 = this.digits[n2]) == 0) {
            ++n2;
        }
        n2 *= 31;
        while ((n3 & 1) == 0) {
            n3 >>= 1;
            ++n2;
        }
        return n2;
    }
}

