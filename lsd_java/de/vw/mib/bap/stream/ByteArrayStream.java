/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.stream;

import de.vw.mib.bap.stream.BitStream;
import java.nio.BufferUnderflowException;

public class ByteArrayStream
implements BitStream {
    private static final int DEFAULT_SIZE;
    private static final int DEFAULT_INCREMENT;
    private static final int INT_BYTE_SIZE;
    private static final int BYTE_MASK;
    private static final int TRUE_INT_CONSTANT;
    private static final int FALSE_INT_CONSTANT;
    private int bitsCount;
    private int bytesCount;
    private int bitsLeftCount;
    private int bytesLeftCount;
    private byte[] bitsData;
    private int capacityIncrement;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$bap$stream$ByteArrayStream;

    public ByteArrayStream() {
        this(10, 5);
    }

    public ByteArrayStream(byte[] byArray) {
        if (!$assertionsDisabled && byArray == null) {
            throw new AssertionError((Object)"Bits data shouldn't be null");
        }
        if (!$assertionsDisabled && byArray.length == 0) {
            throw new AssertionError((Object)"Bits data shouldn't be empty");
        }
        this.bitsCount = byArray.length * 8 % 8;
        this.bytesCount = byArray.length;
        this.bitsData = byArray;
        this.capacityIncrement = 5;
        this.bytesLeftCount = 0;
        this.bitsLeftCount = 0;
    }

    public ByteArrayStream(int n, int n2) {
        this.bitsCount = 0;
        this.bytesCount = 0;
        this.bitsData = n <= 0 ? new byte[10] : new byte[n];
        this.capacityIncrement = n2 <= 0 ? 5 : n2;
    }

    @Override
    public void pushBoolean(boolean bl) {
        this.pushBits(1, bl ? (byte)1 : 0);
    }

    @Override
    public void pushByte(byte by) {
        this.pushBits(8, by);
    }

    @Override
    public void pushShort(short n) {
        int n2 = n;
        this.pushBits(8, (byte)(n2 & 0xFF));
        this.pushBits(8, (byte)((n2 >>>= 8) & 0xFF));
    }

    @Override
    public void pushInt(int n) {
        int n2 = n;
        for (int i2 = 0; i2 < 4; ++i2) {
            this.pushBits(8, (byte)(n2 & 0xFF));
            n2 >>>= 8;
        }
    }

    @Override
    public void pushBits(int n, int n2) {
        int n3;
        if (!($assertionsDisabled || n <= 32 && n > 0)) {
            throw new AssertionError((Object)"The bitsize should not be greater than 32");
        }
        int n4 = n - 8;
        for (n3 = n; n3 > 8; n3 -= 8) {
            byte by = (byte)(n2 >>> n4 & 0xFF);
            this.pushBits(8, by);
            n4 -= 8;
        }
        this.pushBits(n3, (byte)(n2 & 0xFF));
    }

    @Override
    public void resetBits(int n) {
        int n2;
        for (n2 = n; n2 > 8; n2 -= 8) {
            this.pushBits(8, (byte)0);
        }
        this.pushBits(n2, (byte)0);
    }

    @Override
    public void pushBytes(byte[] byArray) {
        this.ensureCapacity(byArray.length);
        int n = 8 - this.bitsCount;
        if (n == 0) {
            System.arraycopy((Object)byArray, 0, (Object)this.bitsData, this.bytesCount, byArray.length);
            this.bytesCount += byArray.length;
        } else {
            int n2 = byArray.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                this.pushBits(8, byArray[i2]);
            }
        }
    }

    private void pushBits(int n, byte by) {
        if (!($assertionsDisabled || n <= 8 && n >= 0)) {
            throw new AssertionError((Object)"The bitsize should not be greater than 8");
        }
        if (this.bytesCount == this.bitsData.length - 1) {
            this.grow(this.bitsData.length + this.capacityIncrement);
        }
        int n2 = 8 - this.bitsCount;
        int n3 = this.bytesCount;
        this.bitsData[n3] = (byte)(this.bitsData[n3] & 255 << n2);
        int n4 = by & 255 >>> 8 - n;
        if (n2 > n) {
            int n5 = this.bytesCount;
            this.bitsData[n5] = (byte)(this.bitsData[n5] | n4 << n2 - n);
            this.bitsCount += n;
        } else {
            this.bitsCount = n - n2;
            int n6 = this.bytesCount++;
            this.bitsData[n6] = (byte)(this.bitsData[n6] | n4 >>> this.bitsCount);
            this.bitsData[this.bytesCount] = (byte)(n4 << 8 - this.bitsCount);
        }
    }

    private void ensureCapacity(int n) {
        int n2 = this.bitsData.length - this.bytesCount;
        if (n2 <= n) {
            this.grow(this.bitsData.length + n / this.capacityIncrement * this.capacityIncrement + this.capacityIncrement);
        }
    }

    public byte[] toByteArray() {
        int n = this.size();
        byte[] byArray = new byte[n];
        System.arraycopy((Object)this.bitsData, 0, (Object)byArray, 0, n);
        return byArray;
    }

    public void reset() {
        this.bitsCount = 0;
        this.bytesCount = 0;
        this.bytesLeftCount = 0;
        this.bitsLeftCount = 0;
    }

    public void reset(byte[] byArray) {
        this.bitsCount = 0;
        this.bytesCount = byArray.length;
        this.bitsData = byArray;
        this.bytesLeftCount = 0;
        this.bitsLeftCount = 0;
    }

    public int size() {
        return this.bytesCount + (this.bitsCount != 0 ? 1 : 0);
    }

    @Override
    public int bitSize() {
        return this.bytesCount * 8 + this.bitsCount;
    }

    private void grow(int n) {
        if (!$assertionsDisabled && this.bytesCount >= n) {
            throw new AssertionError((Object)new StringBuffer().append("The new capacity should be greater than the old one ").append(this.bytesCount).append("< ").append(n).toString());
        }
        byte[] byArray = new byte[n];
        System.arraycopy((Object)this.bitsData, 0, (Object)byArray, 0, this.bytesCount + 1);
        this.bitsData = byArray;
    }

    private void checkForBufferUnderflow(int n) {
        if ((this.bitsData.length - this.bytesLeftCount) * 8 + this.bitsLeftCount < n) {
            throw new BufferUnderflowException();
        }
    }

    @Override
    public int popFrontBits(int n) {
        if (!($assertionsDisabled || n <= 32 && n > 0)) {
            throw new AssertionError((Object)"The bitsize should not be greater than 32");
        }
        this.checkForBufferUnderflow(n);
        int n2 = 0;
        int n3 = 8 - this.bitsLeftCount;
        if (n < n3) {
            n2 = (this.bitsData[this.bytesLeftCount] & 0xFF) << this.bitsLeftCount & 0xFF;
            n2 >>>= 8 - n;
            this.bitsLeftCount += n;
        } else if (n <= 8) {
            n2 = this.bitsData[this.bytesLeftCount++] & 0xFF & 255 >>> this.bitsLeftCount;
            this.bitsLeftCount = n - n3;
            if (this.bitsLeftCount > 0) {
                if (!$assertionsDisabled && this.bytesLeftCount > this.bitsData.length) {
                    throw new AssertionError((Object)"Buffer underrun");
                }
                n2 <<= this.bitsLeftCount;
                n2 |= (this.bitsData[this.bytesLeftCount] & 0xFF) >>> 8 - this.bitsLeftCount;
            }
        } else {
            int n4;
            for (n4 = n / 8; n4 > 0; --n4) {
                n2 <<= 8;
                n2 |= this.popFrontByteSafe();
            }
            n4 = n % 8;
            if (n4 > 0) {
                n2 <<= n4;
                n2 |= this.popFrontBits(n4);
            }
        }
        return n2;
    }

    @Override
    public void discardBits(int n) {
        if (!$assertionsDisabled && (n > 32 && (this.bytesCount - this.bytesLeftCount) * 8 - this.bitsLeftCount != n || n <= 0)) {
            throw new AssertionError((Object)"The bitsize should not be greater than 32");
        }
        this.checkForBufferUnderflow(n);
        int n2 = 8 - this.bitsLeftCount;
        if (n < n2) {
            this.bitsLeftCount += n;
        } else {
            this.bitsLeftCount = n - n2;
            this.bytesLeftCount += this.bitsLeftCount / 8 + 1;
            this.bitsLeftCount %= 8;
        }
    }

    @Override
    public boolean popFrontBoolean() {
        return this.popFrontBits(1) == 1;
    }

    @Override
    public int popFrontByte() {
        this.checkForBufferUnderflow(8);
        return this.popFrontByteSafe();
    }

    private int popFrontByteSafe() {
        int n;
        if (this.bitsLeftCount == 0) {
            n = this.bitsData[this.bytesLeftCount++] & 0xFF;
        } else {
            n = (this.bitsData[this.bytesLeftCount++] & 0xFF) << this.bitsLeftCount;
            n |= (this.bitsData[this.bytesLeftCount] & 0xFF) >> 8 - this.bitsLeftCount;
        }
        return n;
    }

    @Override
    public byte[] popFrontBytes(int n) {
        this.checkForBufferUnderflow(n * 8);
        byte[] byArray = new byte[n];
        if (this.bitsLeftCount == 0) {
            System.arraycopy((Object)this.bitsData, this.bytesLeftCount, (Object)byArray, 0, n);
            this.bytesLeftCount += n;
        } else {
            for (int i2 = 0; i2 < n; ++i2) {
                byArray[i2] = (byte)this.popFrontByteSafe();
            }
        }
        return byArray;
    }

    @Override
    public int popFrontInt() {
        byte[] byArray = this.popFrontBytes(4);
        int n = 0;
        for (int i2 = byArray.length - 1; i2 >= 0; --i2) {
            n <<= 8;
            n |= byArray[i2] & 0xFF;
        }
        return n;
    }

    @Override
    public int popFrontShort() {
        this.checkForBufferUnderflow(16);
        return this.popFrontByteSafe() | this.popFrontByteSafe() << 8;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        $assertionsDisabled = !(class$de$vw$mib$bap$stream$ByteArrayStream == null ? (class$de$vw$mib$bap$stream$ByteArrayStream = ByteArrayStream.class$("de.vw.mib.bap.stream.ByteArrayStream")) : class$de$vw$mib$bap$stream$ByteArrayStream).desiredAssertionStatus();
    }
}

