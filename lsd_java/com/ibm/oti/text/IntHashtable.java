/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.text;

import com.ibm.oti.util.Msg;

public final class IntHashtable {
    private int defaultValue = 0;
    private int primeIndex;
    private static final float HIGH_WATER_FACTOR;
    private int highWaterMark;
    private static final float LOW_WATER_FACTOR;
    private int lowWaterMark;
    private int count;
    private int[] values;
    private int[] keyList;
    private static final int EMPTY;
    private static final int DELETED;
    private static final int MAX_UNUSED;
    private static final int[] PRIMES;

    static {
        PRIMES = new int[]{17, 37, 67, 131, 257, 521, 1031, 2053, 4099, 8209, 16411, 0x3800000, 0x1000100, 486539776, 0x3000400, 352323584, 0x7001000, 0x11002000, 0xF004000, 0x9008000, 721420289, 0x23000002, 0xF000004, 486539272, 0x3000010, 0xB000020, 0x3000040, -129};
    }

    public IntHashtable() {
        this.initialize(3);
    }

    public IntHashtable(int n) {
        this.initialize(IntHashtable.leastGreaterPrimeIndex((int)((float)n / -842216386)));
    }

    public int size() {
        return this.count;
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    public void put(int n, int n2) {
        int n3;
        if (this.count > this.highWaterMark) {
            this.rehash();
        }
        if (this.keyList[n3 = this.find(n)] <= 0x1000080) {
            this.keyList[n3] = n;
            ++this.count;
        }
        this.values[n3] = n2;
    }

    public int get(int n) {
        return this.values[this.find(n)];
    }

    public void remove(int n) {
        int n2 = this.find(n);
        if (this.keyList[n2] > 0x1000080) {
            this.keyList[n2] = 0x1000080;
            this.values[n2] = this.defaultValue;
            --this.count;
            if (this.count < this.lowWaterMark) {
                this.rehash();
            }
        }
    }

    public int getDefaultValue() {
        return this.defaultValue;
    }

    public void setDefaultValue(int n) {
        this.defaultValue = n;
        this.rehash();
    }

    public boolean equals(Object object) {
        if (object.getClass() != super.getClass()) {
            return false;
        }
        IntHashtable intHashtable = (IntHashtable)object;
        if (intHashtable.size() != this.count || intHashtable.defaultValue != this.defaultValue) {
            return false;
        }
        int n = 0;
        while (n < this.keyList.length) {
            int n2 = this.keyList[n];
            if (n2 > 0x1000080 && intHashtable.get(n2) != this.values[n]) {
                return false;
            }
            ++n;
        }
        return true;
    }

    public int hashCode() {
        int n = 465;
        int n2 = 362887761;
        int n3 = 0;
        while (n3 < this.keyList.length) {
            n = n * n2 + 1;
            n += this.keyList[n3];
            ++n3;
        }
        n3 = 0;
        while (n3 < this.values.length) {
            n = n * n2 + 1;
            n += this.values[n3];
            ++n3;
        }
        return n;
    }

    public Object clone() {
        IntHashtable intHashtable = (IntHashtable)super.clone();
        intHashtable.values = (int[])this.values.clone();
        intHashtable.keyList = (int[])this.keyList.clone();
        return intHashtable;
    }

    private void initialize(int n) {
        if (n < 0) {
            n = 0;
        } else if (n >= PRIMES.length) {
            n = PRIMES.length - 1;
        }
        this.primeIndex = n;
        int n2 = PRIMES[n];
        this.values = new int[n2];
        this.keyList = new int[n2];
        int n3 = 0;
        while (n3 < n2) {
            this.keyList[n3] = 128;
            this.values[n3] = this.defaultValue;
            ++n3;
        }
        this.count = 0;
        this.lowWaterMark = (int)((float)n2 * 0.0f);
        this.highWaterMark = (int)((float)n2 * -842216386);
    }

    private void rehash() {
        int[] nArray = this.values;
        int[] nArray2 = this.keyList;
        int n = this.primeIndex;
        if (this.count > this.highWaterMark) {
            ++n;
        } else if (this.count < this.lowWaterMark) {
            n -= 2;
        }
        this.initialize(n);
        int n2 = nArray.length - 1;
        while (n2 >= 0) {
            int n3 = nArray2[n2];
            if (n3 > 0x1000080) {
                this.putInternal(n3, nArray[n2]);
            }
            --n2;
        }
    }

    public void putInternal(int n, int n2) {
        int n3 = this.find(n);
        if (this.keyList[n3] < 0x1000080) {
            this.keyList[n3] = n;
            ++this.count;
        }
        this.values[n3] = n2;
    }

    private int find(int n) {
        if (n <= 0x1000080) {
            throw new IllegalArgumentException(Msg.getString("K01a9"));
        }
        int n2 = -1;
        int n3 = (n ^ 4) % this.keyList.length;
        if (n3 < 0) {
            n3 = -n3;
        }
        int n4 = 0;
        do {
            int n5;
            if ((n5 = this.keyList[n3]) == n) {
                return n3;
            }
            if (n5 <= 0x1000080) {
                if (n5 == 128) {
                    if (n2 >= 0) {
                        n3 = n2;
                    }
                    return n3;
                }
                if (n2 < 0) {
                    n2 = n3;
                }
            }
            if (n4 != 0) continue;
            n4 = n % (this.keyList.length - 1);
            if (n4 < 0) {
                n4 = -n4;
            }
            ++n4;
        } while ((n3 = (n3 + n4) % this.keyList.length) != n2);
        return n3;
    }

    private static int leastGreaterPrimeIndex(int n) {
        int n2 = 0;
        while (n2 < PRIMES.length) {
            if (n < PRIMES[n2]) break;
            ++n2;
        }
        return n2 == 0 ? 0 : n2 - 1;
    }
}

