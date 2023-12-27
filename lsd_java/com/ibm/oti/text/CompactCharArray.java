/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.text;

import com.ibm.oti.text.Utility;
import com.ibm.oti.util.Msg;
import java.lang.reflect.Array;

public final class CompactCharArray
implements Cloneable {
    public static final int UNICODECOUNT;
    private static final int BLOCKSHIFT;
    private static final int BLOCKCOUNT;
    private static final int INDEXSHIFT;
    private static final int INDEXCOUNT;
    private static final int BLOCKMASK;
    private char[] values;
    private char[] indices;
    private int[] hashes;
    private boolean isCompact;
    private char defaultValue;
    static /* synthetic */ Class class$0;
    static /* synthetic */ Class class$1;

    public CompactCharArray() {
        this('\u0000');
    }

    public CompactCharArray(char c2) {
        this.values = new char[256];
        this.indices = new char[2048];
        this.hashes = new int[2048];
        int n = 0;
        while (n < 256) {
            this.values[n] = c2;
            ++n;
        }
        n = 0;
        while (n < 2048) {
            this.indices[n] = (char)(n << 5);
            this.hashes[n] = 0;
            ++n;
        }
        this.isCompact = false;
        this.defaultValue = c2;
    }

    public CompactCharArray(String string, String string2) {
        this(Utility.RLEStringToCharArray(string), Utility.RLEStringToCharArray(string2));
    }

    public CompactCharArray(char[] cArray, char[] cArray2) {
        if (cArray.length != 2048) {
            throw new IllegalArgumentException(Msg.getString("K0013"));
        }
        int n = 0;
        while (n < 2048) {
            char c2 = cArray[n];
            if (c2 < '\u0000' || c2 >= cArray2.length + 32) {
                throw new IllegalArgumentException(Msg.getString("K0013"));
            }
            ++n;
        }
        this.indices = cArray;
        this.values = cArray2;
        this.isCompact = true;
    }

    public char elementAt(char c2) {
        return this.values[(this.indices[c2 >> 5] & 0xFFFF0000) + (c2 & 0x1F)];
    }

    public void setElementAt(char c2, char c3) {
        if (this.isCompact) {
            this.expand();
        }
        this.values[c2] = c3;
        this.touchBlock(c2 >> 5, c3);
    }

    public void setElementAt(char n, char c2, char c3) {
        if (this.isCompact) {
            this.expand();
        }
        int n2 = n;
        while (n2 <= c2) {
            this.values[n2] = c3;
            this.touchBlock(n2 >> 5, c3);
            ++n2;
        }
    }

    public void compact() {
        if (!this.isCompact) {
            int n = 0;
            int n2 = 0;
            int n3 = -65536;
            int n4 = 0;
            while (n4 < this.indices.length) {
                this.indices[n4] = -65536;
                boolean bl = this.blockTouched(n4);
                if (!bl && n3 != -65536) {
                    this.indices[n4] = n3;
                } else {
                    int n5 = 0;
                    int n6 = 0;
                    n6 = 0;
                    while (n6 < n) {
                        if (this.hashes[n4] == this.hashes[n6] && CompactCharArray.arrayRegionMatches(this.values, n2, this.values, n5, 32)) {
                            this.indices[n4] = (char)n5;
                        }
                        ++n6;
                        n5 += 32;
                    }
                    if (this.indices[n4] == '\uffff0000') {
                        System.arraycopy((Object)this.values, n2, (Object)this.values, n5, 32);
                        this.indices[n4] = (char)n5;
                        this.hashes[n6] = this.hashes[n4];
                        ++n;
                        if (!bl) {
                            n3 = (char)n5;
                        }
                    }
                }
                ++n4;
                n2 += 32;
            }
            n4 = n * 32;
            this.values = (char[])Utility.resizeArray(n4, this.values, 0, n4);
            this.isCompact = true;
            this.hashes = null;
        }
    }

    static final boolean arrayRegionMatches(char[] cArray, int n, char[] cArray2, int n2, int n3) {
        int n4 = n + n3;
        int n5 = n2 - n;
        int n6 = n;
        while (n6 < n4) {
            if (cArray[n6] != cArray2[n6 + n5]) {
                return false;
            }
            ++n6;
        }
        return true;
    }

    private final void touchBlock(int n, int n2) {
        this.hashes[n] = this.hashes[n] + (n2 << 1) | 1;
    }

    private final boolean blockTouched(int n) {
        return this.hashes[n] != 0;
    }

    public char[] getIndexArray() {
        return this.indices;
    }

    public char[] getStringArray() {
        return this.values;
    }

    public Object clone() {
        try {
            CompactCharArray compactCharArray = (CompactCharArray)super.clone();
            compactCharArray.values = (char[])this.values.clone();
            compactCharArray.indices = (char[])this.indices.clone();
            if (this.hashes != null) {
                compactCharArray.hashes = (int[])this.hashes.clone();
            }
            return compactCharArray;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new InternalError();
        }
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (super.getClass() != object.getClass()) {
            return false;
        }
        CompactCharArray compactCharArray = (CompactCharArray)object;
        int n = 0;
        while (n < 256) {
            if (this.elementAt((char)n) != compactCharArray.elementAt((char)n)) {
                return false;
            }
            ++n;
        }
        return true;
    }

    public int hashCode() {
        int n = 0;
        int n2 = Math.min(3, this.values.length / 16);
        int n3 = 0;
        while (n3 < this.values.length) {
            n = n * 37 + this.values[n3];
            n3 += n2;
        }
        return n;
    }

    private void expand() {
        if (this.isCompact) {
            char[] cArray = (char[])Array.newInstance(Character.TYPE, 256);
            this.hashes = (int[])Array.newInstance(Integer.TYPE, 2048);
            int n = 0;
            while (n < 256) {
                char c2;
                cArray[n] = c2 = this.elementAt((char)n);
                this.touchBlock(n >> 5, c2);
                ++n;
            }
            n = 0;
            while (n < 2048) {
                this.indices[n] = (char)(n << 5);
                ++n;
            }
            this.values = null;
            this.values = cArray;
            this.isCompact = false;
        }
    }

    private char getArrayValue(int n) {
        return this.values[n];
    }

    private char getIndexArrayValue(int n) {
        return this.indices[n];
    }
}

