/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package java.math;

import com.ibm.oti.util.Msg;
import java.io.ObjectInputStream;
import java.io.ObjectInputStream$GetField;
import java.io.ObjectOutputStream;
import java.io.ObjectOutputStream$PutField;
import java.io.ObjectStreamField;
import java.util.Random;

public class BigInteger
extends Number
implements Comparable {
    private static final long serialVersionUID;
    private long[] data;
    private static final BigInteger NEGATIVE_ONE;
    public static final BigInteger ZERO;
    public static final BigInteger ONE;
    private static final ObjectStreamField[] serialPersistentFields;
    static /* synthetic */ Class class$0;

    static {
        NEGATIVE_ONE = new BigInteger(new long[]{-1L});
        ZERO = BigInteger.valueOf(0L);
        ONE = BigInteger.valueOf(1L);
        ObjectStreamField[] objectStreamFieldArray = new ObjectStreamField[6];
        objectStreamFieldArray[0] = new ObjectStreamField("bitCount", Integer.TYPE);
        objectStreamFieldArray[1] = new ObjectStreamField("bitLength", Integer.TYPE);
        objectStreamFieldArray[2] = new ObjectStreamField("firstNonzeroByteNum", Integer.TYPE);
        objectStreamFieldArray[3] = new ObjectStreamField("lowestSetBit", Integer.TYPE);
        Class clazz = class$0;
        if (clazz == null) {
            try {
                clazz = class$0 = Class.forName("[B");
            }
            catch (ClassNotFoundException classNotFoundException) {
                throw new NoClassDefFoundError(classNotFoundException.getMessage());
            }
        }
        objectStreamFieldArray[4] = new ObjectStreamField("magnitude", clazz);
        objectStreamFieldArray[5] = new ObjectStreamField("signum", Integer.TYPE);
        serialPersistentFields = objectStreamFieldArray;
    }

    private BigInteger(long[] lArray) {
        this.data = lArray;
    }

    public BigInteger(int n, Random random) {
        if (n < 0) {
            throw new IllegalArgumentException(Msg.getString("K040c"));
        }
        this.randomData(n, random);
    }

    public BigInteger(int n, int n2, Random random) {
        if (n < 2) {
            throw new ArithmeticException(Msg.getString("K0409"));
        }
        do {
            this.randomData(n, random);
            this.data[0] = this.data[0] | 1L;
        } while (!this.isProbablePrime(n2, random));
    }

    private void randomData(int n, Random random) {
        int n2 = (n + 64) / 64;
        this.data = new long[n2];
        int n3 = n % 64;
        if (n3 == 0) {
            if (n == 0) {
                return;
            }
            --n2;
            n3 = 64;
        }
        int n4 = 0;
        while (n4 < n2) {
            while ((this.data[n4] = random.nextLong()) == 0L) {
            }
            ++n4;
        }
        n4 = this.getHighestSetBit() % 64 + 1;
        if (n4 > n3) {
            int n5 = n2 - 1;
            this.data[n5] = this.data[n5] >>> n4 - n3;
        } else if (n4 < n3) {
            int n6 = n2 - 1;
            this.data[n6] = this.data[n6] << n3 - n4;
        }
        this.normalize();
    }

    private BigInteger normalize() {
        int n = this.data.length;
        while (n >= 2 && (this.data[n - 1] == 0L && this.data[n - 2] >= 0L || this.data[n - 1] == -1L && this.data[n - 2] < 0L)) {
            --n;
        }
        if (n < this.data.length) {
            long[] lArray = this.data;
            this.data = new long[n];
            System.arraycopy((Object)lArray, 0, (Object)this.data, 0, n);
        }
        return this;
    }

    /*
     * Handled unverifiable bytecode (illegal stack merge).
     */
    public BigInteger(byte[] byArray) {
        int n = byArray.length;
        if (n == 0) {
            throw new NumberFormatException(Msg.getString("K040e"));
        }
        int n2 = byArray[0] < 0 ? 0 : (int)0L;
        int n3 = n / 8 + 1;
        this.data = new long[n3];
        int n4 = 0;
        int n5 = n - 1;
        int n6 = 0;
        while (n5 >= 0) {
            int n7 = n4++;
            this.data[n7] = this.data[n7] | ((long)byArray[n5] & 0) << n6 * 8;
            if ((n6 = (n6 + 1) % 8) == 0) {
                // empty if block
            }
            --n5;
        }
        while (n4 < n3) {
            int n8 = n4++;
            this.data[n8] = this.data[n8] | n2 << n6 * 8;
            if ((n6 = (n6 + 1) % 8) != 0) continue;
        }
        this.normalize();
    }

    public BigInteger(int n, byte[] byArray) {
        this.fromBytes(n, byArray);
    }

    private void fromBytes(int n, byte[] byArray) {
        if (n == 0) {
            int n2 = byArray.length;
            while (--n2 >= 0) {
                if (byArray[n2] == 0) continue;
                throw new NumberFormatException(Msg.getString("K040f"));
            }
            this.data = BigInteger.ZERO.data;
        } else {
            if (n < -1 || n > 1) {
                throw new NumberFormatException(Msg.getString("K0410"));
            }
            int n3 = byArray.length == 0 ? 1 : (byArray.length + (byArray[0] < 0 ? 1 : 0)) / 8 + 1;
            this.data = new long[n3];
            int n4 = 0;
            int n5 = 0;
            int n6 = byArray.length;
            while (--n6 >= 0) {
                int n7 = n4++;
                this.data[n7] = this.data[n7] | ((long)byArray[n6] & 0) << n5 * 8;
                if ((n5 = (n5 + 1) % 8) != 0) continue;
            }
            this.normalize();
            if (n < 0) {
                this.data = com.ibm.oti.util.math.BigInteger.negImpl(this.data);
            }
        }
    }

    public byte[] toByteArray() {
        int n = this.data.length;
        int n2 = n * 8;
        byte[] byArray = new byte[n2--];
        int n3 = 0;
        while (n3 < n) {
            long l = this.data[n3];
            int n4 = 0;
            while (n4 < 8) {
                byArray[n2--] = (byte)l;
                l >>>= 8;
                ++n4;
            }
            ++n3;
        }
        n3 = 0;
        n *= 8;
        while (n3 <= n - 2 && (byArray[n3] == 0 && byArray[n3 + 1] >= 0 || byArray[n3] == -1 && byArray[n3 + 1] < 0)) {
            ++n3;
        }
        if (n3 > 0) {
            byte[] byArray2 = byArray;
            byArray = new byte[n - n3];
            System.arraycopy((Object)byArray2, n3, (Object)byArray, 0, n - n3);
        }
        return byArray;
    }

    public boolean isProbablePrime(int n) {
        return this.isProbablePrime(n, new Random());
    }

    private boolean isProbablePrime(int n, Random random) {
        if (n < 1) {
            return true;
        }
        BigInteger bigInteger = this.abs();
        if (bigInteger.data.length == 1) {
            if (bigInteger.data[0] == 1L) {
                return false;
            }
            if (bigInteger.data[0] == 0) {
                return true;
            }
        }
        if ((bigInteger.data[0] & 1L) == 0L) {
            return false;
        }
        int n2 = bigInteger.getHighestSetBit() + 1;
        if (n2 <= 3) {
            return true;
        }
        BigInteger bigInteger2 = bigInteger.subtract(ONE);
        int n3 = bigInteger2.getLowestSetBit();
        if (n3 == -1) {
            n3 = 0;
        }
        BigInteger bigInteger3 = bigInteger2.shiftRight(n3);
        int n4 = n / 2 + 1;
        int n5 = 0;
        while (n5 < n4) {
            BigInteger bigInteger4;
            while ((bigInteger4 = new BigInteger(n2 - 1, random)).equals(ZERO)) {
            }
            int n6 = 0;
            BigInteger bigInteger5 = bigInteger4.modPow(bigInteger3, bigInteger);
            while (true) {
                boolean bl = bigInteger5.equals(ONE);
                if (n6 == 0 && bl || bigInteger5.equals(bigInteger2)) break;
                if (n6 > 0 && bl) {
                    return false;
                }
                if (++n6 >= n3) {
                    return false;
                }
                bigInteger5 = bigInteger5.multiply(bigInteger5).mod(bigInteger);
            }
            ++n5;
        }
        return true;
    }

    public boolean equals(Object object) {
        if (!(object instanceof BigInteger)) {
            return false;
        }
        BigInteger bigInteger = (BigInteger)object;
        if (this.data.length != bigInteger.data.length) {
            return false;
        }
        int n = 0;
        while (n < this.data.length) {
            if (this.data[n] != bigInteger.data[n]) {
                return false;
            }
            ++n;
        }
        return true;
    }

    public int compareTo(BigInteger bigInteger) {
        boolean bl;
        int n = this.data.length;
        int n2 = bigInteger.data.length;
        boolean bl2 = this.data[n - 1] < 0L;
        boolean bl3 = bl = bigInteger.data[n2 - 1] < 0L;
        if (bl2 != bl) {
            return bl ? 1 : -1;
        }
        if (n != n2) {
            if (!bl2) {
                return n > n2 ? 1 : -1;
            }
            return n > n2 ? -1 : 1;
        }
        if (this.data[n - 1] != bigInteger.data[n - 1]) {
            return this.data[n - 1] > bigInteger.data[n - 1] ? 1 : -1;
        }
        int n3 = n - 2;
        while (n3 >= 0) {
            if (this.data[n3] != bigInteger.data[n3]) {
                boolean bl4;
                boolean bl5 = this.data[n3] < 0L;
                boolean bl6 = bl4 = bigInteger.data[n3] < 0L;
                if (bl5 == bl4) {
                    return this.data[n3] > bigInteger.data[n3] ? 1 : -1;
                }
                return bl5 ? 1 : -1;
            }
            --n3;
        }
        return 0;
    }

    @Override
    public int compareTo(Object object) {
        if (!(object instanceof BigInteger)) {
            throw new ClassCastException();
        }
        return this.compareTo((BigInteger)object);
    }

    @Override
    public int intValue() {
        return (int)this.data[0];
    }

    @Override
    public long longValue() {
        return this.data[0];
    }

    public static BigInteger valueOf(long l) {
        long[] lArray = new long[]{l};
        return new BigInteger(lArray);
    }

    public BigInteger add(BigInteger bigInteger) {
        return new BigInteger(com.ibm.oti.util.math.BigInteger.addImpl(this.data, bigInteger.data));
    }

    public BigInteger negate() {
        return new BigInteger(com.ibm.oti.util.math.BigInteger.negImpl(this.data));
    }

    public int signum() {
        if (this.data[this.data.length - 1] < 0L) {
            return -1;
        }
        if (this.data[this.data.length - 1] == 0L && this.data.length == 1) {
            return 0;
        }
        return 1;
    }

    public BigInteger abs() {
        if (this.data[this.data.length - 1] < 0L) {
            return this.negate();
        }
        return this;
    }

    public BigInteger pow(int n) {
        if (n < 0) {
            throw new ArithmeticException(Msg.getString("K040a"));
        }
        long[] lArray = this.data;
        long[] lArray2 = BigInteger.ONE.data;
        while (n != 0) {
            if ((n & 1) == 1) {
                lArray2 = com.ibm.oti.util.math.BigInteger.mulImpl(lArray2, lArray);
            }
            lArray = com.ibm.oti.util.math.BigInteger.mulImpl(lArray, lArray);
            n >>>= 1;
        }
        return new BigInteger(lArray2);
    }

    public BigInteger modPow(BigInteger bigInteger, BigInteger bigInteger2) {
        if (bigInteger2.signum() <= 0) {
            throw new ArithmeticException(Msg.getString("K0408"));
        }
        long[] lArray = this.data;
        if (bigInteger.signum() < 0) {
            bigInteger = bigInteger.negate();
            lArray = this.modInverse((BigInteger)bigInteger2).data;
        }
        long[] lArray2 = bigInteger.data;
        long[] lArray3 = bigInteger2.data;
        long[] lArray4 = BigInteger.ONE.data;
        int n = lArray2.length;
        if (n == 1 && lArray2[0] == 0L) {
            lArray4 = com.ibm.oti.util.math.BigInteger.remImpl(lArray4, lArray3);
        } else {
            int n2 = 0;
            while (n2 < n) {
                long l = lArray2[n2];
                int n3 = 0;
                while (n3 < 64) {
                    if ((l & 1L) == 1L) {
                        lArray4 = com.ibm.oti.util.math.BigInteger.remImpl(com.ibm.oti.util.math.BigInteger.mulImpl(lArray4, lArray), lArray3);
                    }
                    lArray = com.ibm.oti.util.math.BigInteger.remImpl(com.ibm.oti.util.math.BigInteger.mulImpl(lArray, lArray), lArray3);
                    l >>>= 1;
                    ++n3;
                }
                ++n2;
            }
        }
        if (lArray4[lArray4.length - 1] < 0L) {
            return new BigInteger(com.ibm.oti.util.math.BigInteger.addImpl(lArray4, lArray3));
        }
        return new BigInteger(lArray4);
    }

    public BigInteger gcd(BigInteger bigInteger) {
        long[] lArray;
        long[] lArray2;
        switch (this.signum()) {
            case 0: {
                return bigInteger.abs();
            }
            case -1: {
                lArray2 = com.ibm.oti.util.math.BigInteger.negImpl(this.data);
                break;
            }
            default: {
                lArray2 = this.data;
            }
        }
        switch (bigInteger.signum()) {
            case 0: {
                return this.abs();
            }
            case -1: {
                lArray = com.ibm.oti.util.math.BigInteger.negImpl(bigInteger.data);
                break;
            }
            default: {
                lArray = bigInteger.data;
            }
        }
        while (lArray2.length != 1 || lArray2[0] != 0L) {
            long[] lArray3 = com.ibm.oti.util.math.BigInteger.remImpl(lArray, lArray2);
            lArray = lArray2;
            lArray2 = lArray3;
        }
        return new BigInteger(lArray);
    }

    public BigInteger modInverse(BigInteger bigInteger) {
        if (bigInteger.compareTo(ZERO) > 0) {
            BigInteger bigInteger2;
            BigInteger bigInteger3 = ONE;
            BigInteger bigInteger4 = ZERO;
            BigInteger bigInteger5 = this;
            BigInteger bigInteger6 = bigInteger;
            do {
                bigInteger2 = bigInteger5.divide(bigInteger6);
                BigInteger bigInteger7 = bigInteger3;
                bigInteger3 = bigInteger4;
                bigInteger4 = bigInteger7.subtract(bigInteger2.multiply(bigInteger3));
            } while (!(bigInteger6 = bigInteger5.subtract(bigInteger2.multiply(bigInteger5 = bigInteger6))).equals(ZERO));
            if (bigInteger5.equals(NEGATIVE_ONE)) {
                bigInteger3 = bigInteger3.negate();
                bigInteger5 = ONE;
            }
            if (bigInteger5.equals(ONE)) {
                if (bigInteger3.compareTo(ZERO) < 0) {
                    return bigInteger3.add(bigInteger);
                }
                return bigInteger3;
            }
        }
        throw new ArithmeticException(Msg.getString("K0408"));
    }

    public int getLowestSetBit() {
        int n = 0;
        while (n < this.data.length) {
            if (this.data[n] != 0L) {
                long l = this.data[n];
                int n2 = 0;
                while (true) {
                    if ((l & 0) != 0L) {
                        int n3 = (int)(l & 0);
                        int n4 = n * 64 + n2 * 8;
                        while (true) {
                            if ((n3 & 1) != 0) {
                                return n4;
                            }
                            ++n4;
                            n3 >>>= 1;
                        }
                    }
                    ++n2;
                    l >>>= 8;
                }
            }
            ++n;
        }
        return -1;
    }

    private int getHighestSetBit() {
        int n = this.data.length - 1;
        while (n >= 0) {
            if (this.data[n] != 0L) {
                long l = this.data[n];
                int n2 = 7;
                while (true) {
                    if ((l & 0xFF00000000000000L) != 0L) {
                        int n3 = (int)(l >>> 56);
                        int n4 = n * 64 + n2 * 8 + 7;
                        while (true) {
                            if ((n3 & 0x80) != 0) {
                                return n4;
                            }
                            --n4;
                            n3 <<= 1;
                        }
                    }
                    --n2;
                    l <<= 8;
                }
            }
            --n;
        }
        return -1;
    }

    private int getHighestUnSetBit() {
        int n = this.data.length - 1;
        while (n >= 0) {
            if (this.data[n] != -1L) {
                long l = this.data[n];
                int n2 = 7;
                while (true) {
                    if ((l & 0xFF00000000000000L) != -72057594037927936L) {
                        int n3 = (int)(l >>> 56);
                        int n4 = n * 64 + n2 * 8 + 7;
                        while (true) {
                            if ((n3 & 0x80) != 128) {
                                return n4;
                            }
                            --n4;
                            n3 <<= 1;
                        }
                    }
                    --n2;
                    l <<= 8;
                }
            }
            --n;
        }
        return -1;
    }

    public BigInteger shiftRight(int n) {
        return new BigInteger(com.ibm.oti.util.math.BigInteger.shlImpl(this.data, -n));
    }

    public BigInteger shiftLeft(int n) {
        return new BigInteger(com.ibm.oti.util.math.BigInteger.shlImpl(this.data, n));
    }

    public BigInteger subtract(BigInteger bigInteger) {
        return new BigInteger(com.ibm.oti.util.math.BigInteger.subImpl(this.data, bigInteger.data));
    }

    public BigInteger multiply(BigInteger bigInteger) {
        return new BigInteger(com.ibm.oti.util.math.BigInteger.mulImpl(this.data, bigInteger.data));
    }

    final BigInteger multiplyByTen() {
        return this.shiftLeft(1).add(this.shiftLeft(3));
    }

    public BigInteger divide(BigInteger bigInteger) {
        if (bigInteger.data.length == 1 && bigInteger.data[0] == 0L) {
            throw new ArithmeticException(Msg.getString("K0407"));
        }
        return new BigInteger(com.ibm.oti.util.math.BigInteger.divImpl(this.data, bigInteger.data));
    }

    public BigInteger remainder(BigInteger bigInteger) {
        if (bigInteger.data.length == 1 && bigInteger.data[0] == 0L) {
            throw new ArithmeticException(Msg.getString("K0407"));
        }
        return new BigInteger(com.ibm.oti.util.math.BigInteger.remImpl(this.data, bigInteger.data));
    }

    public BigInteger mod(BigInteger bigInteger) {
        if (bigInteger.signum() <= 0) {
            throw new ArithmeticException(Msg.getString("K0408"));
        }
        BigInteger bigInteger2 = new BigInteger(com.ibm.oti.util.math.BigInteger.remImpl(this.data, bigInteger.data));
        if (bigInteger2.signum() == -1) {
            bigInteger2.data = com.ibm.oti.util.math.BigInteger.addImpl(bigInteger2.data, bigInteger.data);
        }
        return bigInteger2;
    }

    public BigInteger[] divideAndRemainder(BigInteger bigInteger) {
        if (bigInteger.data.length == 1 && bigInteger.data[0] == 0L) {
            throw new ArithmeticException(Msg.getString("K0407"));
        }
        BigInteger[] bigIntegerArray = new BigInteger[]{new BigInteger(com.ibm.oti.util.math.BigInteger.divImpl(this.data, bigInteger.data)), new BigInteger(com.ibm.oti.util.math.BigInteger.remImpl(this.data, bigInteger.data))};
        return bigIntegerArray;
    }

    public BigInteger(String string) {
        this(string, 10);
    }

    public BigInteger(String string, int n) {
        int n2 = string.length() - 1;
        if (n < 2 || n > 36) {
            throw new NumberFormatException(Msg.getString("K040d"));
        }
        if (n2 < 0) {
            throw new NumberFormatException(Msg.getString("K040e"));
        }
        this.data = BigInteger.ZERO.data;
        long[] lArray = new long[]{n};
        long[] lArray2 = new long[1];
        boolean bl = string.charAt(0) == '-';
        int n3 = bl ? 1 : 0;
        while (n3 <= n2) {
            int n4 = Character.digit(string.charAt(n3), n);
            if (n4 == -1) {
                throw new NumberFormatException(string);
            }
            this.data = com.ibm.oti.util.math.BigInteger.mulImpl(this.data, lArray);
            if (n4 != 0) {
                lArray2[0] = n4;
                this.data = com.ibm.oti.util.math.BigInteger.addImpl(this.data, lArray2);
            }
            ++n3;
        }
        this.normalize();
        if (bl) {
            this.data = com.ibm.oti.util.math.BigInteger.negImpl(this.data);
        }
    }

    public String toString() {
        return this.toString(10);
    }

    public String toString(int n) {
        int n2;
        BigInteger bigInteger;
        if (n < 2 || n > 36) {
            n = 10;
        }
        BigInteger bigInteger2 = BigInteger.valueOf(n);
        if (this.equals(ZERO)) {
            return "0";
        }
        boolean bl = this.signum() < 0;
        if (bl) {
            bigInteger = this.negate();
            n2 = 2;
        } else {
            bigInteger = this;
            n2 = 1;
        }
        BigInteger bigInteger3 = bigInteger;
        while (!(bigInteger3 = bigInteger3.divide(bigInteger2)).equals(ZERO)) {
            ++n2;
        }
        int n3 = n2;
        char[] cArray = new char[n3];
        do {
            BigInteger[] bigIntegerArray = bigInteger.divideAndRemainder(bigInteger2);
            bigInteger = bigIntegerArray[0];
            cArray[--n3] = Character.forDigit(bigIntegerArray[1].intValue(), n);
        } while (!bigInteger.equals(ZERO));
        if (bl) {
            cArray[0] = 45;
        }
        return new String(cArray, 0, n2);
    }

    public BigInteger max(BigInteger bigInteger) {
        return com.ibm.oti.util.math.BigInteger.compImpl(this.data, bigInteger.data) >= 0 ? this : bigInteger;
    }

    public BigInteger min(BigInteger bigInteger) {
        return com.ibm.oti.util.math.BigInteger.compImpl(this.data, bigInteger.data) <= 0 ? this : bigInteger;
    }

    public int hashCode() {
        long l = 0L;
        int n = this.data.length - 1;
        while (n >= 0) {
            l = l * 0 + this.data[n];
            --n;
        }
        return (int)(l ^ l >>> 32);
    }

    public boolean testBit(int n) {
        if (n < 0) {
            throw new ArithmeticException(Msg.getString("K0006"));
        }
        int n2 = n / 64;
        if (n2 >= this.data.length) {
            return this.signum() == -1;
        }
        int n3 = n % 64;
        return (this.data[n2] >> n3 & 1L) == 1L;
    }

    public BigInteger setBit(int n) {
        if (n < 0) {
            throw new ArithmeticException(Msg.getString("K0006"));
        }
        int n2 = n / 64;
        int n3 = n % 64;
        int n4 = this.data.length;
        int n5 = this.signum();
        if (n2 >= this.data.length) {
            if (n5 == -1) {
                return this;
            }
            n4 = n2 + (n3 == 63 ? 2 : 1);
        } else {
            if ((this.data[n2] >> n3 & 1L) == 1L) {
                return this;
            }
            if (n3 == 63 && n2 == this.data.length - 1 && n5 >= 0) {
                ++n4;
            }
        }
        long[] lArray = new long[n4];
        System.arraycopy((Object)this.data, 0, (Object)lArray, 0, this.data.length);
        int n6 = n2;
        lArray[n6] = lArray[n6] | 1L << n3;
        return new BigInteger(lArray).normalize();
    }

    public BigInteger clearBit(int n) {
        if (n < 0) {
            throw new ArithmeticException(Msg.getString("K0006"));
        }
        int n2 = n / 64;
        int n3 = n % 64;
        int n4 = this.data.length;
        int n5 = this.signum();
        if (n2 >= this.data.length) {
            if (n5 >= 0) {
                return this;
            }
            n4 = n2 + (n3 == 63 ? 2 : 1);
        } else {
            if ((this.data[n2] >> n3 & 1L) == 0L) {
                return this;
            }
            if (n3 == 63 && n2 == this.data.length - 1 && n5 < 0) {
                ++n4;
            }
        }
        long[] lArray = new long[n4];
        System.arraycopy((Object)this.data, 0, (Object)lArray, 0, this.data.length);
        long l = n5 < 0 ? -1 : 0;
        int n6 = this.data.length;
        while (n6 < n4) {
            lArray[n6] = l;
            ++n6;
        }
        int n7 = n2;
        lArray[n7] = lArray[n7] ^ 1L << n3;
        return new BigInteger(lArray).normalize();
    }

    public BigInteger flipBit(int n) {
        return this.testBit(n) ? this.clearBit(n) : this.setBit(n);
    }

    /*
     * Unable to fully structure code
     */
    public BigInteger and(BigInteger var1_1) {
        block6: {
            block5: {
                var2_2 = this.data;
                var5_4 = var2_2.length;
                var3_3 = var1_1.data;
                var6_5 = var3_3.length;
                if (var5_4 != var6_5) break block5;
                var4_6 = new long[var5_4];
                var7_7 = 0;
                while (var7_7 < var5_4) {
                    var4_6[var7_7] = var2_2[var7_7] & var3_3[var7_7];
                    ++var7_7;
                }
                break block6;
            }
            if (var5_4 < var6_5) {
                var7_8 = var2_2;
                var2_2 = var3_3;
                var3_3 = var7_8;
                var8_10 = var5_4;
                var5_4 = var6_5;
                var6_5 = var8_10;
            }
            var4_6 = new long[var5_4];
            var7_9 = 0;
            while (var7_9 < var6_5) {
                var4_6[var7_9] = var2_2[var7_9] & var3_3[var7_9];
                ++var7_9;
            }
            if (var3_3[var6_5 - 1] >= 0L) ** GOTO lbl35
            while (var7_9 < var5_4) {
                var4_6[var7_9] = var2_2[var7_9];
                ++var7_9;
            }
            break block6;
lbl-1000:
            // 1 sources

            {
                var4_6[var7_9] = 0L;
                ++var7_9;
lbl35:
                // 2 sources

                ** while (var7_9 < var5_4)
            }
        }
        return new BigInteger(var4_6).normalize();
    }

    /*
     * Unable to fully structure code
     */
    public BigInteger or(BigInteger var1_1) {
        block6: {
            block5: {
                var2_2 = this.data;
                var5_4 = var2_2.length;
                var3_3 = var1_1.data;
                var6_5 = var3_3.length;
                if (var5_4 != var6_5) break block5;
                var4_6 = new long[var5_4];
                var7_7 = 0;
                while (var7_7 < var5_4) {
                    var4_6[var7_7] = var2_2[var7_7] | var3_3[var7_7];
                    ++var7_7;
                }
                break block6;
            }
            if (var5_4 < var6_5) {
                var7_8 = var2_2;
                var2_2 = var3_3;
                var3_3 = var7_8;
                var8_10 = var5_4;
                var5_4 = var6_5;
                var6_5 = var8_10;
            }
            var4_6 = new long[var5_4];
            var7_9 = 0;
            while (var7_9 < var6_5) {
                var4_6[var7_9] = var2_2[var7_9] | var3_3[var7_9];
                ++var7_9;
            }
            if (var3_3[var6_5 - 1] >= 0L) ** GOTO lbl35
            while (var7_9 < var5_4) {
                var4_6[var7_9] = -1L;
                ++var7_9;
            }
            break block6;
lbl-1000:
            // 1 sources

            {
                var4_6[var7_9] = var2_2[var7_9];
                ++var7_9;
lbl35:
                // 2 sources

                ** while (var7_9 < var5_4)
            }
        }
        return new BigInteger(var4_6).normalize();
    }

    /*
     * Unable to fully structure code
     */
    public BigInteger xor(BigInteger var1_1) {
        block6: {
            block5: {
                var2_2 = this.data;
                var5_4 = var2_2.length;
                var3_3 = var1_1.data;
                var6_5 = var3_3.length;
                if (var5_4 != var6_5) break block5;
                var4_6 = new long[var5_4];
                var7_7 = 0;
                while (var7_7 < var5_4) {
                    var4_6[var7_7] = var2_2[var7_7] ^ var3_3[var7_7];
                    ++var7_7;
                }
                break block6;
            }
            if (var5_4 < var6_5) {
                var7_8 = var2_2;
                var2_2 = var3_3;
                var3_3 = var7_8;
                var8_10 = var5_4;
                var5_4 = var6_5;
                var6_5 = var8_10;
            }
            var4_6 = new long[var5_4];
            var7_9 = 0;
            while (var7_9 < var6_5) {
                var4_6[var7_9] = var2_2[var7_9] ^ var3_3[var7_9];
                ++var7_9;
            }
            if (var3_3[var6_5 - 1] >= 0L) ** GOTO lbl35
            while (var7_9 < var5_4) {
                var4_6[var7_9] = var2_2[var7_9] ^ -1L;
                ++var7_9;
            }
            break block6;
lbl-1000:
            // 1 sources

            {
                var4_6[var7_9] = var2_2[var7_9];
                ++var7_9;
lbl35:
                // 2 sources

                ** while (var7_9 < var5_4)
            }
        }
        return new BigInteger(var4_6).normalize();
    }

    public BigInteger not() {
        int n = this.data.length;
        long[] lArray = new long[n];
        int n2 = 0;
        while (n2 < n) {
            lArray[n2] = this.data[n2] ^ 0xFFFFFFFFFFFFFFFFL;
            ++n2;
        }
        return new BigInteger(lArray).normalize();
    }

    /*
     * Unable to fully structure code
     */
    public BigInteger andNot(BigInteger var1_1) {
        block8: {
            block9: {
                block7: {
                    var2_2 = this.data;
                    var5_4 = var2_2.length;
                    var3_3 = var1_1.data;
                    var6_5 = var3_3.length;
                    if (var5_4 != var6_5) break block7;
                    var4_6 = new long[var5_4];
                    var7_7 = 0;
                    while (var7_7 < var5_4) {
                        var4_6[var7_7] = var2_2[var7_7] & (var3_3[var7_7] ^ -1L);
                        ++var7_7;
                    }
                    break block8;
                }
                if (var5_4 >= var6_5) break block9;
                var4_6 = new long[var6_5];
                var7_8 = 0;
                while (var7_8 < var5_4) {
                    var4_6[var7_8] = (var3_3[var7_8] ^ -1L) & var2_2[var7_8];
                    ++var7_8;
                }
                if (var2_2[var5_4 - 1] >= 0L) ** GOTO lbl29
                while (var7_8 < var6_5) {
                    var4_6[var7_8] = var3_3[var7_8] ^ -1L;
                    ++var7_8;
                }
                break block8;
lbl-1000:
                // 1 sources

                {
                    var4_6[var7_8] = 0L;
                    ++var7_8;
lbl29:
                    // 2 sources

                    ** while (var7_8 < var6_5)
                }
lbl30:
                // 1 sources

                break block8;
            }
            var4_6 = new long[var5_4];
            var7_9 = 0;
            while (var7_9 < var6_5) {
                var4_6[var7_9] = var2_2[var7_9] & (var3_3[var7_9] ^ -1L);
                ++var7_9;
            }
            if (var3_3[var6_5 - 1] >= 0L) ** GOTO lbl46
            while (var7_9 < var5_4) {
                var4_6[var7_9] = 0L;
                ++var7_9;
            }
            break block8;
lbl-1000:
            // 1 sources

            {
                var4_6[var7_9] = var2_2[var7_9];
                ++var7_9;
lbl46:
                // 2 sources

                ** while (var7_9 < var5_4)
            }
        }
        return new BigInteger(var4_6).normalize();
    }

    public int bitLength() {
        int n = this.signum() >= 0 ? this.getHighestSetBit() : this.getHighestUnSetBit();
        return n + 1;
    }

    public int bitCount() {
        int n;
        long l;
        int n2 = this.signum();
        if (n2 == 0) {
            return 0;
        }
        int n3 = 0;
        if (n2 > 0) {
            l = 0L;
            n = 1;
        } else {
            l = -1L;
            n = 0;
        }
        int n4 = this.data.length;
        while (--n4 >= 0) {
            long l2 = this.data[n4];
            if (l2 == l) continue;
            int n5 = 0;
            while (n5 < 64) {
                if ((l2 & 1L) == (long)n) {
                    ++n3;
                }
                l2 >>>= 1;
                ++n5;
            }
        }
        return n3;
    }

    @Override
    public double doubleValue() {
        if (this.signum() > 0) {
            int n = this.bitLength();
            long l = n - 53 + 1075;
            if (l >= 0) {
                return Double.POSITIVE_INFINITY;
            }
            l <<= 52;
            long l2 = 0L;
            if (n < 53) {
                l2 = this.data[0] << 53 - n;
            } else if (n > 53) {
                l2 = this.shiftRight((int)(n - 53)).data[0];
                if (this.testBit(n - 54) && (this.getLowestSetBit() != n - 54 || (l2 & 1L) == 1L) && (++l2 & 0xFFFFFFFFFFFFFL) == 0L) {
                    if (l != 0x7FF0000000000000L) {
                        l2 >>= 1;
                        l += 0;
                    } else {
                        l2 = 0xFFFFFFFFFFFFFL;
                    }
                }
            } else {
                l2 = this.data[0];
            }
            l2 = l2 & 0xFFFFFFFFFFFFFL | l;
            return Double.longBitsToDouble((long)l2);
        }
        if (this.signum() < 0) {
            return -this.negate().doubleValue();
        }
        return 0.0;
    }

    @Override
    public float floatValue() {
        return (float)this.doubleValue();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        ObjectOutputStream$PutField objectOutputStream$PutField = objectOutputStream.putFields();
        objectOutputStream$PutField.put("bitCount", -1);
        objectOutputStream$PutField.put("bitLength", -1);
        objectOutputStream$PutField.put("firstNonzeroByteNum", -2);
        objectOutputStream$PutField.put("lowestSetBit", -2);
        int n = this.signum();
        byte[] byArray = n == -1 ? this.negate().toByteArray() : this.toByteArray();
        if (byArray[0] == 0) {
            byte[] byArray2 = new byte[byArray.length - 1];
            System.arraycopy((Object)byArray, 1, (Object)byArray2, 0, byArray2.length);
            byArray = byArray2;
        }
        objectOutputStream$PutField.put("magnitude", byArray);
        objectOutputStream$PutField.put("signum", n);
        objectOutputStream.writeFields();
    }

    private void readObject(ObjectInputStream objectInputStream) {
        ObjectInputStream$GetField objectInputStream$GetField = objectInputStream.readFields();
        byte[] byArray = (byte[])objectInputStream$GetField.get("magnitude", null);
        int n = objectInputStream$GetField.get("signum", 0);
        this.fromBytes(n, byArray);
    }
}

