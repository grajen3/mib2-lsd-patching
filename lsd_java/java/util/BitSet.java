/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import com.ibm.oti.util.Msg;
import java.io.Serializable;

public class BitSet
implements Serializable,
Cloneable {
    private static final long serialVersionUID;
    private long[] bits;
    private static final int ELM_SIZE;

    public BitSet() {
        this(64);
    }

    public BitSet(int n) {
        if (n < 0) {
            throw new NegativeArraySizeException();
        }
        this.bits = new long[n / 64 + (n % 64 > 0 ? 1 : 0)];
    }

    private BitSet(long[] lArray) {
        this.bits = lArray;
    }

    public Object clone() {
        try {
            BitSet bitSet = (BitSet)super.clone();
            bitSet.bits = (long[])this.bits.clone();
            return bitSet;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            return null;
        }
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof BitSet) {
            int n = this.bits.length;
            long[] lArray = ((BitSet)object).bits;
            int n2 = lArray.length;
            if (n <= n2) {
                int n3 = 0;
                while (n3 < n) {
                    if (this.bits[n3] != lArray[n3]) {
                        return false;
                    }
                    ++n3;
                }
                n3 = n;
                while (n3 < n2) {
                    if (lArray[n3] != 0L) {
                        return false;
                    }
                    ++n3;
                }
            } else {
                int n4 = 0;
                while (n4 < n2) {
                    if (this.bits[n4] != lArray[n4]) {
                        return false;
                    }
                    ++n4;
                }
                n4 = n2;
                while (n4 < n) {
                    if (this.bits[n4] != 0L) {
                        return false;
                    }
                    ++n4;
                }
            }
            return true;
        }
        return false;
    }

    private void growBits(int n) {
        long[] lArray = new long[++n / 64 + (n % 64 > 0 ? 1 : 0)];
        System.arraycopy((Object)this.bits, 0, (Object)lArray, 0, this.bits.length);
        this.bits = lArray;
    }

    public int hashCode() {
        int n = 0;
        int n2 = 0;
        int n3 = this.bits.length;
        while (n2 < n3) {
            n ^= this.bits[n2] * (long)(n2 + 1);
            ++n2;
        }
        return n >> 32 ^ n;
    }

    public boolean get(int n) {
        if (n >= 0) {
            if (n < this.bits.length * 64) {
                return (this.bits[n / 64] & 1L << n % 64) != 0L;
            }
            return false;
        }
        throw new IndexOutOfBoundsException(Msg.getString("K0006"));
    }

    public BitSet get(int n, int n2) {
        if (n >= 0 && n2 >= 0 && n2 >= n) {
            int n3 = this.bits.length * 64;
            if (n >= n3 || n == n2) {
                return new BitSet(0);
            }
            if (n2 > n3) {
                n2 = n3;
            }
            int n4 = n / 64;
            int n5 = (n2 - 1) / 64;
            long l = -1L << n % 64;
            long l2 = -1L >>> 64 - n2 % 64;
            if (n4 == n5) {
                long l3 = (this.bits[n4] & (l & l2)) >>> n % 64;
                return new BitSet(new long[]{l3});
            }
            long[] lArray = new long[n5 - n4 + 1];
            lArray[0] = this.bits[n4] & l;
            lArray[lArray.length - 1] = this.bits[n5] & l2;
            int n6 = 1;
            while (n6 < n5 - n4) {
                lArray[n6] = this.bits[n4 + n6];
                ++n6;
            }
            n6 = n % 64;
            if (n6 != 0) {
                int n7 = 0;
                while (n7 < lArray.length) {
                    lArray[n7] = lArray[n7] >>> n6;
                    if (n7 != lArray.length - 1) {
                        int n8 = n7;
                        lArray[n8] = lArray[n8] | lArray[n7 + 1] << 64 - n6;
                    }
                    ++n7;
                }
            }
            return new BitSet(lArray);
        }
        throw new IndexOutOfBoundsException(Msg.getString("K0006"));
    }

    public void set(int n) {
        if (n >= 0) {
            if (n >= this.bits.length * 64) {
                this.growBits(n);
            }
        } else {
            throw new IndexOutOfBoundsException(Msg.getString("K0006"));
        }
        int n2 = n / 64;
        this.bits[n2] = this.bits[n2] | 1L << n % 64;
    }

    public void set(int n, boolean bl) {
        if (bl) {
            this.set(n);
        } else {
            this.clear(n);
        }
    }

    public void set(int n, int n2) {
        if (n >= 0 && n2 >= 0 && n2 >= n) {
            if (n == n2) {
                return;
            }
            if (n2 >= this.bits.length * 64) {
                this.growBits(n2);
            }
            int n3 = n / 64;
            int n4 = (n2 - 1) / 64;
            long l = -1L << n % 64;
            long l2 = -1L >>> 64 - n2 % 64;
            if (n3 == n4) {
                int n5 = n3;
                this.bits[n5] = this.bits[n5] | l & l2;
            } else {
                int n6 = n3;
                this.bits[n6] = this.bits[n6] | l;
                int n7 = n4;
                this.bits[n7] = this.bits[n7] | l2;
                int n8 = n3 + 1;
                while (n8 < n4) {
                    int n9 = n8++;
                    this.bits[n9] = this.bits[n9] | 0xFFFFFFFFFFFFFFFFL;
                }
            }
        } else {
            throw new IndexOutOfBoundsException(Msg.getString("K0006"));
        }
    }

    public void set(int n, int n2, boolean bl) {
        if (bl) {
            this.set(n, n2);
        } else {
            this.clear(n, n2);
        }
    }

    public void clear() {
        int n = 0;
        while (n < this.bits.length) {
            this.bits[n] = 0L;
            ++n;
        }
    }

    public void clear(int n) {
        if (n >= 0) {
            if (n < this.bits.length * 64) {
                int n2 = n / 64;
                this.bits[n2] = this.bits[n2] & (1L << n % 64 ^ 0xFFFFFFFFFFFFFFFFL);
            }
        } else {
            throw new IndexOutOfBoundsException(Msg.getString("K0006"));
        }
    }

    public void clear(int n, int n2) {
        if (n >= 0 && n2 >= 0 && n2 >= n) {
            int n3 = this.bits.length * 64;
            if (n >= n3 || n == n2) {
                return;
            }
            if (n2 > n3) {
                n2 = n3;
            }
            int n4 = n / 64;
            int n5 = (n2 - 1) / 64;
            long l = -1L << n % 64;
            long l2 = -1L >>> 64 - n2 % 64;
            if (n4 == n5) {
                int n6 = n4;
                this.bits[n6] = this.bits[n6] & (l & l2 ^ 0xFFFFFFFFFFFFFFFFL);
            } else {
                int n7 = n4;
                this.bits[n7] = this.bits[n7] & (l ^ 0xFFFFFFFFFFFFFFFFL);
                int n8 = n5;
                this.bits[n8] = this.bits[n8] & (l2 ^ 0xFFFFFFFFFFFFFFFFL);
                int n9 = n4 + 1;
                while (n9 < n5) {
                    this.bits[n9] = 0L;
                    ++n9;
                }
            }
        } else {
            throw new IndexOutOfBoundsException(Msg.getString("K0006"));
        }
    }

    public void flip(int n) {
        if (n >= 0) {
            if (n >= this.bits.length * 64) {
                this.growBits(n);
            }
        } else {
            throw new IndexOutOfBoundsException(Msg.getString("K0006"));
        }
        int n2 = n / 64;
        this.bits[n2] = this.bits[n2] ^ 1L << n % 64;
    }

    public void flip(int n, int n2) {
        if (n >= 0 && n2 >= 0 && n2 >= n) {
            if (n == n2) {
                return;
            }
            if (n2 >= this.bits.length * 64) {
                this.growBits(n2);
            }
            int n3 = n / 64;
            int n4 = (n2 - 1) / 64;
            long l = -1L << n % 64;
            long l2 = -1L >>> 64 - n2 % 64;
            if (n3 == n4) {
                int n5 = n3;
                this.bits[n5] = this.bits[n5] ^ l & l2;
            } else {
                int n6 = n3;
                this.bits[n6] = this.bits[n6] ^ l;
                int n7 = n4;
                this.bits[n7] = this.bits[n7] ^ l2;
                int n8 = n3 + 1;
                while (n8 < n4) {
                    int n9 = n8++;
                    this.bits[n9] = this.bits[n9] ^ 0xFFFFFFFFFFFFFFFFL;
                }
            }
        } else {
            throw new IndexOutOfBoundsException(Msg.getString("K0006"));
        }
    }

    public boolean intersects(BitSet bitSet) {
        int n = this.bits.length;
        long[] lArray = bitSet.bits;
        int n2 = lArray.length;
        if (n <= n2) {
            int n3 = 0;
            while (n3 < n) {
                if ((this.bits[n3] & lArray[n3]) != 0L) {
                    return true;
                }
                ++n3;
            }
        } else {
            int n4 = 0;
            while (n4 < n2) {
                if ((this.bits[n4] & lArray[n4]) != 0L) {
                    return true;
                }
                ++n4;
            }
        }
        return false;
    }

    public void and(BitSet bitSet) {
        int n = this.bits.length;
        long[] lArray = bitSet.bits;
        int n2 = lArray.length;
        if (n <= n2) {
            int n3 = 0;
            while (n3 < n) {
                int n4 = n3;
                this.bits[n4] = this.bits[n4] & lArray[n3];
                ++n3;
            }
        } else {
            int n5 = 0;
            while (n5 < n2) {
                int n6 = n5;
                this.bits[n6] = this.bits[n6] & lArray[n5];
                ++n5;
            }
            n5 = n2;
            while (n5 < n) {
                this.bits[n5] = 0L;
                ++n5;
            }
        }
    }

    public void andNot(BitSet bitSet) {
        long[] lArray = bitSet.bits;
        int n = this.bits.length < lArray.length ? this.bits.length : lArray.length;
        int n2 = 0;
        while (n2 < n) {
            int n3 = n2;
            this.bits[n3] = this.bits[n3] & (lArray[n2] ^ 0xFFFFFFFFFFFFFFFFL);
            ++n2;
        }
    }

    public void or(BitSet bitSet) {
        int n = bitSet.length();
        int n2 = n / 64 + (n % 64 > 0 ? 1 : 0);
        if (n2 > this.bits.length) {
            this.growBits(n - 1);
        }
        long[] lArray = bitSet.bits;
        int n3 = 0;
        while (n3 < n2) {
            int n4 = n3;
            this.bits[n4] = this.bits[n4] | lArray[n3];
            ++n3;
        }
    }

    public void xor(BitSet bitSet) {
        int n = bitSet.length();
        int n2 = n / 64 + (n % 64 > 0 ? 1 : 0);
        if (n2 > this.bits.length) {
            this.growBits(n - 1);
        }
        long[] lArray = bitSet.bits;
        int n3 = 0;
        while (n3 < n2) {
            int n4 = n3;
            this.bits[n4] = this.bits[n4] ^ lArray[n3];
            ++n3;
        }
    }

    public int size() {
        return this.bits.length * 64;
    }

    public int length() {
        int n = this.bits.length - 1;
        while (n >= 0 && this.bits[n] == 0L) {
            --n;
        }
        if (n == -1) {
            return 0;
        }
        int n2 = 63;
        long l = this.bits[n];
        while ((l & 1L << n2) == 0L && n2 > 0) {
            --n2;
        }
        return n * 64 + n2 + 1;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(this.bits.length / 2);
        int n = 0;
        stringBuffer.append('{');
        boolean bl = false;
        int n2 = 0;
        while (n2 < this.bits.length) {
            if (this.bits[n2] == 0L) {
                n += 64;
            } else {
                int n3 = 0;
                while (n3 < 64) {
                    if ((this.bits[n2] & 1L << n3) != 0L) {
                        if (bl) {
                            stringBuffer.append(", ");
                        }
                        stringBuffer.append(n);
                        bl = true;
                    }
                    ++n;
                    ++n3;
                }
            }
            ++n2;
        }
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    public int nextSetBit(int n) {
        if (n >= 0) {
            int n2;
            if (n >= this.bits.length * 64) {
                return -1;
            }
            int n3 = n / 64;
            if (this.bits[n3] != 0L) {
                n2 = n % 64;
                while (n2 < 64) {
                    if ((this.bits[n3] & 1L << n2) != 0L) {
                        return n3 * 64 + n2;
                    }
                    ++n2;
                }
            }
            ++n3;
            while (n3 < this.bits.length && this.bits[n3] == 0L) {
                ++n3;
            }
            if (n3 == this.bits.length) {
                return -1;
            }
            n2 = 0;
            while (n2 < 64) {
                if ((this.bits[n3] & 1L << n2) != 0L) {
                    return n3 * 64 + n2;
                }
                ++n2;
            }
            return -1;
        }
        throw new IndexOutOfBoundsException(Msg.getString("K0006"));
    }

    public int nextClearBit(int n) {
        if (n >= 0) {
            int n2;
            int n3 = this.bits.length * 64;
            if (n >= n3) {
                return n;
            }
            int n4 = n / 64;
            if (this.bits[n4] != -1L) {
                n2 = n % 64;
                while (n2 < 64) {
                    if ((this.bits[n4] & 1L << n2) == 0L) {
                        return n4 * 64 + n2;
                    }
                    ++n2;
                }
            }
            ++n4;
            while (n4 < this.bits.length && this.bits[n4] == -1L) {
                ++n4;
            }
            if (n4 == this.bits.length) {
                return n3;
            }
            n2 = 0;
            while (n2 < 64) {
                if ((this.bits[n4] & 1L << n2) == 0L) {
                    return n4 * 64 + n2;
                }
                ++n2;
            }
            return n3;
        }
        throw new IndexOutOfBoundsException(Msg.getString("K0006"));
    }

    public boolean isEmpty() {
        int n = 0;
        while (n < this.bits.length) {
            if (this.bits[n] != 0L) {
                return false;
            }
            ++n;
        }
        return true;
    }

    public int cardinality() {
        int n = 0;
        int n2 = 0;
        while (n2 < this.bits.length) {
            long l = this.bits[n2];
            if (l != 0L) {
                int n3 = 0;
                while (n3 < 64) {
                    if ((l & 1L << n3) != 0L) {
                        ++n;
                    }
                    ++n3;
                }
            }
            ++n2;
        }
        return n;
    }
}

