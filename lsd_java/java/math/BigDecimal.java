/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package java.math;

import com.ibm.oti.util.Msg;
import java.math.BigInteger;

public class BigDecimal
extends Number
implements Comparable {
    private static final long serialVersionUID;
    public static final int ROUND_UP;
    public static final int ROUND_DOWN;
    public static final int ROUND_CEILING;
    public static final int ROUND_FLOOR;
    public static final int ROUND_HALF_UP;
    public static final int ROUND_HALF_DOWN;
    public static final int ROUND_HALF_EVEN;
    public static final int ROUND_UNNECESSARY;
    private static final BigInteger TEN;
    private static final BigInteger TWO;
    private static final BigDecimal ONE;
    private static final BigDecimal ZERO;
    private int scale;
    private BigInteger intVal;
    private transient int setCount = 0;
    private transient int getCount = 0;
    private transient int[] uArray = new int[64];
    private transient int firstK = 0;

    static {
        TEN = new BigInteger("10");
        TWO = BigInteger.valueOf(0);
        ONE = new BigDecimal(BigInteger.ONE, 0);
        ZERO = new BigDecimal(BigInteger.ZERO, 0);
    }

    public BigDecimal(BigInteger bigInteger) {
        this.intVal = bigInteger;
        this.scale = 0;
    }

    public BigDecimal(BigInteger bigInteger, int n) {
        if (n < 0) {
            throw new NumberFormatException(Msg.getString("K0051"));
        }
        this.intVal = bigInteger;
        this.scale = n;
    }

    public BigDecimal(double d2) {
        long l = Double.doubleToLongBits((double)d2);
        long l2 = (l & Long.MIN_VALUE) >> 63;
        long l3 = (l & 0x7FF0000000000000L) >> 52;
        long l4 = l & 0xFFFFFFFFFFFFFL;
        int n = 0;
        boolean bl = false;
        this.setCount = 0;
        this.getCount = 0;
        String string = l2 == 0L ? "" : "-";
        if (l3 == 0) {
            throw new NumberFormatException(Msg.getString("K040b"));
        }
        if (l3 == 0L) {
            if (l4 == 0L) {
                this.intVal = BigInteger.ZERO;
                this.scale = 0;
                bl = true;
            } else {
                n = (int)(l3 - 0 + 1L);
            }
        } else {
            l4 |= 0;
            n = (int)(l3 - 0);
        }
        if (!bl) {
            String string2 = new StringBuffer(String.valueOf(string)).append(this.freeFormat(n, l4)).toString();
            this.intVal = new BigInteger(string2.toString());
        }
    }

    public BigDecimal(String string) {
        int n;
        int n2;
        String string2 = string;
        if (string2.length() > 0 && string2.charAt(0) == '+') {
            string2 = string2.substring(1, string2.length());
        }
        if ((n2 = string2.indexOf(101, 0)) == -1) {
            n2 = string2.indexOf(69, 0);
        }
        String string3 = null;
        if (n2 >= 0) {
            string3 = new String(string2).substring(n2 + 1, string2.length());
            string2 = string2.substring(0, n2);
        }
        if ((n = string2.indexOf(46, 0)) == -1) {
            this.intVal = new BigInteger(string2);
            this.scale = 0;
        } else {
            int n3 = string2.length();
            String string4 = string2.substring(0, n);
            String string5 = string2.substring(n + 1, n3);
            this.intVal = new BigInteger(new StringBuffer(String.valueOf(string4)).append(string5).toString());
            this.scale = n3 - n - 1;
        }
        if (string3 != null) {
            if (string3.length() > 0 && string3.charAt(0) == '+' && (string3 = string3.substring(1, string3.length())).indexOf(45) >= 0) {
                throw new NumberFormatException(string);
            }
            Integer n4 = new Integer(string3);
            this.scale -= n4.intValue();
            while (this.scale < 0) {
                this.intVal = this.intVal.shiftLeft(1).add(this.intVal.shiftLeft(3));
                ++this.scale;
            }
        }
    }

    public BigDecimal abs() {
        return new BigDecimal(this.unscaledValue().abs(), this.scale());
    }

    public BigDecimal add(BigDecimal bigDecimal) {
        BigInteger bigInteger;
        int n;
        int n2 = bigDecimal.scale();
        BigInteger bigInteger2 = bigDecimal.unscaledValue();
        if (this.scale == n2) {
            return new BigDecimal(this.intVal.add(bigInteger2), this.scale);
        }
        int n3 = n = this.scale > n2 ? this.scale : n2;
        if (n == this.scale) {
            BigInteger bigInteger3 = TEN.pow(n - n2);
            bigInteger = this.intVal.add(bigInteger2.multiply(bigInteger3));
        } else {
            BigInteger bigInteger4 = TEN.pow(n - this.scale);
            bigInteger = bigInteger2.add(this.intVal.multiply(bigInteger4));
        }
        return new BigDecimal(bigInteger, n);
    }

    @Override
    public int compareTo(Object object) {
        if (!(object instanceof BigDecimal)) {
            throw new ClassCastException();
        }
        return this.compareTo((BigDecimal)object);
    }

    public int compareTo(BigDecimal bigDecimal) {
        BigDecimal bigDecimal2 = this.subtract(bigDecimal);
        return bigDecimal2.signum();
    }

    private String freeFormat(int n, long l) {
        char[] cArray = new char[309];
        int n2 = 0;
        int n3 = 0;
        this.digitGenerator(n, l);
        boolean bl = false;
        int n4 = this.getCount < this.setCount ? this.uArray[this.getCount] : -1;
        int n5 = this.firstK - this.getCount;
        ++this.getCount;
        if (n5 < 0) {
            bl = true;
            n3 = -n5 - 1;
        }
        while (true) {
            if (n5 >= 0) {
                if (n4 != -1) {
                    cArray[n2] = Character.forDigit(n4, 10);
                    ++n2;
                } else if (n5 >= -1) {
                    cArray[n2] = 48;
                    ++n2;
                }
                n4 = this.getCount < this.setCount ? this.uArray[this.getCount] : -1;
                n5 = this.firstK - this.getCount;
                ++this.getCount;
                continue;
            }
            if (n4 != -1) {
                cArray[n2] = Character.forDigit(n4, 10);
                ++n2;
                ++n3;
            }
            n4 = this.getCount < this.setCount ? this.uArray[this.getCount] : -1;
            n5 = this.firstK - this.getCount;
            ++this.getCount;
            if (n4 == -1 && n5 < -1) break;
        }
        if (n3 != 0 && !bl) {
            n3 = -n5 - 1;
        }
        this.scale = n3;
        return new String(cArray, 0, n2);
    }

    private void digitGenerator(int n, long l) {
        boolean bl;
        boolean bl2;
        BigInteger bigInteger;
        int n2;
        BigInteger bigInteger2;
        BigInteger bigInteger3 = BigInteger.valueOf(l).shiftLeft(Math.max(n, 0));
        BigInteger bigInteger4 = BigInteger.ZERO.setBit(Math.max(0, -n));
        BigInteger bigInteger5 = BigInteger.ZERO.setBit(Math.max(n, 0));
        BigInteger bigInteger6 = bigInteger5.abs();
        int n3 = 0;
        while ((bigInteger2 = bigInteger3.multiplyByTen()).compareTo(bigInteger4) < 0) {
            --n3;
            bigInteger3 = bigInteger2;
            bigInteger5 = bigInteger5.multiplyByTen();
            bigInteger6 = bigInteger6.multiplyByTen();
        }
        bigInteger2 = bigInteger3.shiftLeft(1).add(bigInteger6);
        while (bigInteger2.compareTo(bigInteger4.shiftLeft(1)) >= 0) {
            bigInteger4 = bigInteger4.multiplyByTen();
            ++n3;
        }
        this.firstK = n3 - 1;
        bigInteger2 = bigInteger4.shiftLeft(1);
        while (true) {
            --n3;
            BigInteger bigInteger7 = bigInteger3.multiplyByTen();
            int n4 = 0;
            int n5 = 3;
            while (n5 >= 0) {
                BigInteger bigInteger8 = bigInteger7.subtract(bigInteger4.shiftLeft(n5));
                if (bigInteger8.compareTo(BigInteger.ZERO) >= 0) {
                    bigInteger7 = bigInteger8;
                    n4 += 1 << n5;
                }
                --n5;
            }
            n2 = n4;
            bigInteger3 = bigInteger7;
            bigInteger5 = bigInteger5.multiplyByTen();
            bigInteger6 = bigInteger6.multiplyByTen();
            bigInteger = bigInteger3.shiftLeft(1);
            bl2 = bigInteger.compareTo(bigInteger5) < 0;
            boolean bl3 = bl = bigInteger.compareTo(bigInteger2.subtract(bigInteger6)) > 0;
            if (bl2 || bl) break;
            this.uArray[this.setCount] = n2;
            ++this.setCount;
        }
        if (bl2 && !bl) {
            this.uArray[this.setCount] = n2;
            ++this.setCount;
        } else if (bl && !bl2) {
            this.uArray[this.setCount] = n2 + 1;
            ++this.setCount;
        } else if (bigInteger.compareTo(bigInteger4) <= 0) {
            this.uArray[this.setCount] = n2;
            ++this.setCount;
        } else {
            this.uArray[this.setCount] = n2 + 1;
            ++this.setCount;
        }
    }

    public BigDecimal divide(BigDecimal bigDecimal, int n) {
        return this.divide(bigDecimal, this.scale, n);
    }

    /*
     * Unable to fully structure code
     */
    public BigDecimal divide(BigDecimal var1_1, int var2_2, int var3_3) {
        if (var2_2 < 0) {
            throw new ArithmeticException(Msg.getString("K0051"));
        }
        if (var3_3 < 0 || var3_3 > 7) {
            throw new IllegalArgumentException(Msg.getString("K0050"));
        }
        var6_4 = var1_1.scale();
        var7_5 = this.intVal.signum() * var1_1.intVal.signum();
        if (var6_4 < this.scale) {
            var8_6 = var1_1.movePointRight(this.scale);
            var4_8 = var8_6.abs().intVal;
            var5_9 = this.intVal.abs().divideAndRemainder(var4_8);
        } else {
            var4_8 = var1_1.abs().intVal;
            if (var6_4 > this.scale) {
                var8_6 = this.movePointRight(var6_4);
                var5_9 = var8_6.abs().intVal.divideAndRemainder(var4_8);
            } else {
                var5_9 = this.intVal.abs().divideAndRemainder(var4_8);
            }
        }
        var8_7 = var2_2;
        var9_10 = var5_9[1];
        var10_11 = new StringBuffer();
        if (var7_5 < 0) {
            var10_11.append('-');
        }
        var10_11.append(var5_9[0].toString());
        while (var8_7 >= 0 && !var5_9[1].equals(BigInteger.ZERO)) {
            var11_12 = var5_9[1].multiplyByTen();
            var5_9 = var11_12.divideAndRemainder(var4_8);
            if (var8_7 > 0) {
                var10_11.append(var5_9[0].toString());
            }
            if (var8_7 == 1) {
                var9_10 = var5_9[1];
            }
            --var8_7;
        }
        v0 = var11_13 = var8_7 < 0;
        if (!var11_13 || var3_3 != 7) ** GOTO lbl41
        throw new ArithmeticException(Msg.getString("K004f"));
lbl-1000:
        // 1 sources

        {
            var10_11.append('0');
lbl41:
            // 2 sources

            ** while (var8_7-- > 0)
        }
lbl42:
        // 1 sources

        var12_14 = new BigInteger(var10_11.toString());
        if (var11_13) {
            var12_14 = BigDecimal.roundValues(var12_14, var9_10, var5_9, var7_5, var3_3);
        }
        return new BigDecimal(var12_14, var2_2);
    }

    @Override
    public double doubleValue() {
        try {
            Double d2 = new Double(this.toString());
            return d2;
        }
        catch (NumberFormatException numberFormatException) {
            if (this.signum() == -1) {
                return Double.NEGATIVE_INFINITY;
            }
            return Double.POSITIVE_INFINITY;
        }
    }

    public boolean equals(Object object) {
        if (!(object instanceof BigDecimal)) {
            return false;
        }
        return this.unscaledValue().compareTo(((BigDecimal)object).unscaledValue()) == 0 && this.scale() == ((BigDecimal)object).scale();
    }

    @Override
    public float floatValue() {
        try {
            Float f2 = new Float(this.toString());
            return f2.floatValue();
        }
        catch (NumberFormatException numberFormatException) {
            if (this.signum() == -1) {
                return 33023;
            }
            return 32895;
        }
    }

    public int hashCode() {
        return this.intVal.hashCode() ^ this.scale;
    }

    @Override
    public int intValue() {
        BigInteger bigInteger = this.toBigInteger();
        return bigInteger.intValue();
    }

    @Override
    public long longValue() {
        BigInteger bigInteger = this.toBigInteger();
        return bigInteger.longValue();
    }

    public BigDecimal max(BigDecimal bigDecimal) {
        return this.compareTo(bigDecimal) > 0 ? this : bigDecimal;
    }

    public BigDecimal min(BigDecimal bigDecimal) {
        return this.compareTo(bigDecimal) >= 0 ? bigDecimal : this;
    }

    public BigDecimal movePointLeft(int n) {
        if (n < 0) {
            return this.movePointRight(-n);
        }
        return new BigDecimal(this.unscaledValue(), this.scale + n);
    }

    public BigDecimal movePointRight(int n) {
        if (n < 0) {
            return this.movePointLeft(-n);
        }
        if (this.scale - n < 0) {
            StringBuffer stringBuffer = new StringBuffer().append(this.intVal);
            int n2 = 0;
            while (n2 < n - this.scale) {
                stringBuffer.append("0");
                ++n2;
            }
            return new BigDecimal(new BigInteger(stringBuffer.toString()), 0);
        }
        return new BigDecimal(this.intVal, this.scale - n);
    }

    public BigDecimal multiply(BigDecimal bigDecimal) {
        BigInteger bigInteger = this.intVal.multiply(bigDecimal.unscaledValue());
        int n = this.scale() + bigDecimal.scale();
        return new BigDecimal(bigInteger, n);
    }

    public BigDecimal negate() {
        return new BigDecimal(this.intVal.negate(), this.scale);
    }

    public int scale() {
        return this.scale;
    }

    public BigDecimal setScale(int n) {
        return this.setScale(n, 7);
    }

    public BigDecimal setScale(int n, int n2) {
        if (n < 0) {
            throw new ArithmeticException(Msg.getString("K0051"));
        }
        if (n2 < 0 || n2 > 7) {
            throw new IllegalArgumentException(Msg.getString("K0050"));
        }
        if (this.scale < n) {
            StringBuffer stringBuffer = new StringBuffer("1");
            int n3 = 0;
            while (n3 < n - this.scale) {
                stringBuffer.append('0');
                ++n3;
            }
            BigInteger bigInteger = new BigInteger(stringBuffer.toString());
            BigInteger bigInteger2 = this.intVal.multiply(bigInteger);
            return new BigDecimal(bigInteger2, n);
        }
        if (this.scale > n) {
            BigInteger bigInteger = TEN.pow(this.scale - n);
            BigInteger[] bigIntegerArray = this.intVal.divideAndRemainder(bigInteger);
            if (!bigIntegerArray[1].equals(BigInteger.ZERO)) {
                if (n2 == 7) {
                    throw new ArithmeticException(Msg.getString("K004f"));
                }
                BigInteger[] bigIntegerArray2 = null;
                if (n2 >= 4) {
                    bigInteger = TEN.pow(this.scale - n - 1);
                    bigIntegerArray2 = bigIntegerArray[1].divideAndRemainder(bigInteger);
                    bigIntegerArray2[0] = bigIntegerArray2[0].abs();
                }
                bigIntegerArray[0] = BigDecimal.roundValues(bigIntegerArray[0], bigIntegerArray[1], bigIntegerArray2, this.intVal.signum(), n2);
            }
            return new BigDecimal(bigIntegerArray[0], n);
        }
        return this;
    }

    private static BigInteger roundValues(BigInteger bigInteger, BigInteger bigInteger2, BigInteger[] bigIntegerArray, int n, int n2) {
        switch (n2) {
            case 2: {
                if (n >= 0 && !bigInteger2.equals(BigInteger.ZERO)) {
                    return bigInteger.add(BigInteger.ONE);
                }
                return bigInteger;
            }
            case 1: {
                return bigInteger;
            }
            case 3: {
                if (n < 0 && !bigInteger2.equals(BigInteger.ZERO)) {
                    return bigInteger.add(BigInteger.ONE.negate());
                }
                return bigInteger;
            }
            case 5: {
                int n3 = bigIntegerArray[0].intValue();
                if (n3 > 5 || n3 == 5 && !bigIntegerArray[1].equals(BigInteger.ZERO)) {
                    if (n >= 0) {
                        return bigInteger.add(BigInteger.ONE);
                    }
                    return bigInteger.add(BigInteger.ONE.negate());
                }
                return bigInteger;
            }
            case 6: {
                int n4 = bigIntegerArray[0].intValue();
                if (n4 > 5 || n4 == 5 && !bigIntegerArray[1].equals(BigInteger.ZERO)) {
                    if (n >= 0) {
                        return bigInteger.add(BigInteger.ONE);
                    }
                    return bigInteger.add(BigInteger.ONE.negate());
                }
                if (n4 == 5) {
                    BigInteger bigInteger3 = bigInteger.mod(BigInteger.ONE.add(BigInteger.ONE));
                    if (bigInteger3.equals(BigInteger.ZERO)) {
                        return bigInteger;
                    }
                    if (n >= 0) {
                        return bigInteger.add(BigInteger.ONE);
                    }
                    return bigInteger.add(BigInteger.ONE.negate());
                }
                return bigInteger;
            }
            case 4: {
                if (bigIntegerArray[0].intValue() >= 5) {
                    if (n >= 0) {
                        return bigInteger.add(BigInteger.ONE);
                    }
                    return bigInteger.add(BigInteger.ONE.negate());
                }
                return bigInteger;
            }
            case 0: {
                if (!bigInteger2.equals(BigInteger.ZERO)) {
                    if (n >= 0) {
                        return bigInteger.add(BigInteger.ONE);
                    }
                    return bigInteger.add(BigInteger.ONE.negate());
                }
                return bigInteger;
            }
        }
        throw new IllegalArgumentException(Msg.getString("K0050"));
    }

    public int signum() {
        return this.intVal.signum();
    }

    public BigDecimal subtract(BigDecimal bigDecimal) {
        BigInteger bigInteger;
        int n;
        int n2 = bigDecimal.scale();
        BigInteger bigInteger2 = bigDecimal.unscaledValue();
        if (this.scale == n2) {
            BigInteger bigInteger3 = this.intVal.subtract(bigInteger2);
            if (bigInteger3.equals(BigInteger.ZERO)) {
                n2 = 0;
            }
            return new BigDecimal(bigInteger3, n2);
        }
        int n3 = n = this.scale > n2 ? this.scale : n2;
        if (n == this.scale) {
            BigInteger bigInteger4 = TEN.pow(n - n2);
            bigInteger = this.intVal.subtract(bigInteger2.multiply(bigInteger4));
        } else {
            BigInteger bigInteger5 = TEN.pow(n - this.scale);
            bigInteger = this.intVal.multiply(bigInteger5).subtract(bigInteger2);
        }
        if (bigInteger.equals(BigInteger.ZERO)) {
            n = 0;
        }
        return new BigDecimal(bigInteger, n);
    }

    public BigInteger toBigInteger() {
        BigInteger bigInteger = TEN.pow(this.scale);
        return this.intVal.divide(bigInteger);
    }

    public String toString() {
        String string = this.intVal.toString();
        int n = string.length();
        boolean bl = string.charAt(0) == '-';
        StringBuffer stringBuffer = new StringBuffer();
        if (this.scale >= (bl ? n - 1 : n)) {
            if (bl) {
                String string2;
                stringBuffer = new StringBuffer().append("-0.");
                string = string2 = new String(string).substring(1, n);
                n = string.length();
            } else {
                stringBuffer = new StringBuffer().append("0.");
            }
            int n2 = 0;
            while (n2 < this.scale - n) {
                stringBuffer = stringBuffer.append("0");
                ++n2;
            }
            stringBuffer = stringBuffer.append(string);
            return stringBuffer.toString();
        }
        String string3 = new String(string).substring(0, n - this.scale);
        if (this.scale == 0) {
            return string3;
        }
        String string4 = new String(string).substring(n - this.scale(), n);
        return new StringBuffer(String.valueOf(string3)).append(".").append(string4).toString();
    }

    public BigInteger unscaledValue() {
        return this.intVal;
    }

    public static BigDecimal valueOf(long l) {
        return new BigDecimal(BigInteger.valueOf(l), 0);
    }

    public static BigDecimal valueOf(long l, int n) {
        if (n < 0) {
            throw new NumberFormatException(Msg.getString("K0051"));
        }
        BigInteger bigInteger = BigInteger.valueOf(l);
        if (bigInteger == BigInteger.ZERO) {
            return ZERO;
        }
        if (bigInteger == BigInteger.ONE) {
            return ONE;
        }
        return new BigDecimal(bigInteger, n);
    }
}

