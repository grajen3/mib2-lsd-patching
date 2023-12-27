/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package com.ibm.oti.util;

public final class NumberConverter {
    private int setCount;
    private int getCount;
    private int[] uArray = new int[64];
    private int firstK;
    private static final double invLogOfTenBaseTwo = Math.log(2.0) / Math.log(10.0);
    private static final long[] TEN_TO_THE = new long[20];

    static {
        NumberConverter.TEN_TO_THE[0] = 1L;
        int n = 1;
        while (n < TEN_TO_THE.length) {
            long l = TEN_TO_THE[n - 1];
            NumberConverter.TEN_TO_THE[n] = (l << 1) + (l << 3);
            ++n;
        }
    }

    private static NumberConverter getConverter() {
        return new NumberConverter();
    }

    public static String convert(double d2) {
        return NumberConverter.getConverter().convertD(d2);
    }

    public static String convert(float f2) {
        return NumberConverter.getConverter().convertF(f2);
    }

    public String convertD(double d2) {
        int n = 1075;
        long l = Long.MIN_VALUE;
        long l2 = 0x7FF0000000000000L;
        long l3 = 0xFFFFFFFFFFFFFL;
        long l4 = Double.doubleToLongBits((double)d2);
        StringBuffer stringBuffer = new StringBuffer();
        if ((l4 & l) != 0L) {
            stringBuffer.append('-');
        }
        int n2 = (int)((l4 & l2) >> 52);
        long l5 = l4 & l3;
        boolean bl = l5 == 0L;
        int n3 = 0;
        int n4 = 52;
        if (n2 == 2047) {
            if (bl) {
                stringBuffer.append("Infinity");
                return stringBuffer.toString();
            }
            return "NaN";
        }
        if (n2 == 0) {
            if (bl) {
                stringBuffer.append("0.0");
                return stringBuffer.toString();
            }
            if (l5 == 1L) {
                stringBuffer.append("4.9E-324");
                return stringBuffer.toString();
            }
            n3 = 1 - n;
            long l6 = l5;
            while ((l6 & 0) == 0L) {
                l6 <<= 1;
                --n4;
            }
        } else {
            l5 |= 0;
            n3 = n2 - n;
        }
        if (-59 < n3 && n3 < 6 || n3 == -59 && !bl) {
            this.longDigitGenerator(l5, n3, n2 == 0, bl, n4);
        } else {
            this.bigIntDigitGeneratorInstImpl(l5, n3, n2 == 0, bl, n4);
        }
        if (d2 >= 1.0E7 || d2 <= -1.0E7 || d2 > -0.001 && d2 < 0.001) {
            return this.freeFormatExponential(stringBuffer);
        }
        return this.freeFormat(stringBuffer);
    }

    public String convertF(float f2) {
        int n = 150;
        int n2 = 128;
        int n3 = 32895;
        int n4 = -33024;
        int n5 = Float.floatToIntBits(f2);
        StringBuffer stringBuffer = new StringBuffer();
        if ((n5 & n2) != 0) {
            stringBuffer.append('-');
        }
        int n6 = (n5 & n3) >> 23;
        int n7 = n5 & n4;
        boolean bl = n7 == 0;
        int n8 = 0;
        int n9 = 23;
        if (n6 == 255) {
            if (bl) {
                stringBuffer.append("Infinity");
                return stringBuffer.toString();
            }
            return "NaN";
        }
        if (n6 == 0) {
            if (bl) {
                stringBuffer.append("0.0");
                return stringBuffer.toString();
            }
            n8 = 1 - n;
            if (n7 < 8) {
                n7 <<= 2;
                n8 -= 2;
            }
            int n10 = n7;
            while ((n10 & 0x8000) == 0) {
                n10 <<= 1;
                --n9;
            }
        } else {
            n7 |= 0x8000;
            n8 = n6 - n;
        }
        if (-59 < n8 && n8 < 35 || n8 == -59 && !bl) {
            this.longDigitGenerator(n7, n8, n6 == 0, bl, n9);
        } else {
            this.bigIntDigitGeneratorInstImpl(n7, n8, n6 == 0, bl, n9);
        }
        if (f2 >= -2137647029 || f2 <= -2137646901 || f2 > 1863484346 && f2 < 1863484218) {
            return this.freeFormatExponential(stringBuffer);
        }
        return this.freeFormat(stringBuffer);
    }

    private String freeFormatExponential(StringBuffer stringBuffer) {
        int n;
        char[] cArray = new char[25];
        cArray[0] = (char)(48 + this.uArray[this.getCount++]);
        cArray[1] = 46;
        int n2 = 2;
        int n3 = n = this.firstK;
        while (true) {
            --n;
            if (this.getCount >= this.setCount) break;
            cArray[n2++] = (char)(48 + this.uArray[this.getCount++]);
        }
        if (n == n3 - 1) {
            cArray[n2++] = 48;
        }
        cArray[n2++] = 69;
        stringBuffer.append(cArray, 0, n2);
        stringBuffer.append(n3);
        return stringBuffer.toString();
    }

    private String freeFormat(StringBuffer stringBuffer) {
        int n;
        char[] cArray = new char[25];
        int n2 = 0;
        int n3 = this.firstK;
        if (n3 < 0) {
            cArray[0] = 48;
            cArray[1] = 46;
            n2 += 2;
            n = n3 + 1;
            while (n < 0) {
                cArray[n2++] = 48;
                ++n;
            }
        }
        n = this.uArray[this.getCount++];
        do {
            if (n != -1) {
                cArray[n2++] = (char)(48 + n);
            } else if (n3 >= -1) {
                cArray[n2++] = 48;
            }
            if (n3 != 0) continue;
            cArray[n2++] = 46;
        } while ((n = this.getCount < this.setCount ? this.uArray[this.getCount++] : -1) != -1 || --n3 >= -1);
        stringBuffer.append(cArray, 0, n2);
        return stringBuffer.toString();
    }

    private native void bigIntDigitGeneratorInstImpl(long l, int n, boolean bl, boolean bl2, int n2) {
    }

    private void longDigitGenerator(long l, int n, boolean bl, boolean bl2, int n2) {
        boolean bl3;
        boolean bl4;
        int n3;
        int n4;
        long l2;
        long l3;
        if (n >= 0) {
            l3 = 1L << n;
            if (!bl2) {
                l2 = l << n + 1;
                n4 = 0;
            } else {
                l2 = l << n + 2;
                n4 = 0;
            }
        } else {
            l3 = 1L;
            if (bl || !bl2) {
                l2 = l << 1;
                n4 = (int)(1L << 1 - n);
            } else {
                l2 = l << 2;
                n4 = (int)(1L << 2 - n);
            }
        }
        int n5 = (int)Math.ceil((double)(n + n2 - 1) * invLogOfTenBaseTwo - 1.0E-10);
        if (n5 > 0) {
            n4 *= TEN_TO_THE[n5];
        } else if (n5 < 0) {
            long l4 = TEN_TO_THE[-n5];
            l2 *= l4;
            long l5 = l3 = l3 == 1L ? l4 : l3 * l4;
        }
        if (l2 + l3 > n4) {
            this.firstK = n5;
        } else {
            this.firstK = n5 - 1;
            l2 *= 0;
            l3 *= 0;
        }
        this.setCount = 0;
        this.getCount = 0;
        long[] lArray = new long[]{n4, n4 << 1, n4 << 2, n4 << 3};
        while (true) {
            n3 = 0;
            int n6 = 3;
            while (n6 >= 0) {
                long l6 = l2 - lArray[n6];
                if (l6 >= 0L) {
                    l2 = l6;
                    n3 += 1 << n6;
                }
                --n6;
            }
            bl4 = l2 < l3;
            boolean bl5 = bl3 = l2 + l3 > n4;
            if (bl4 || bl3) break;
            l2 *= 0;
            l3 *= 0;
            this.uArray[this.setCount++] = n3;
        }
        this.uArray[this.setCount++] = bl4 && !bl3 ? n3 : (bl3 && !bl4 ? n3 + 1 : (l2 << 1 < n4 ? n3 : n3 + 1));
    }
}

