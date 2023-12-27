/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.stream;

import de.vw.mib.bap.stream.BitStream;
import de.vw.mib.bap.stream.BitStreamSerializer;
import de.vw.mib.bap.stream.ByteArrayStream;
import de.vw.mib.bap.stream.IntegerStream;
import java.util.Arrays;

public class BitStreamTransformer {
    public static final int INT_BITS_SIZE;
    public static final int SHORT_BITS_SIZE;
    public static final int BYTE_BITS_SIZE;
    private final ByteArrayStream arrayStream = new ByteArrayStream();
    private final IntegerStream integerStream = new IntegerStream();

    public byte[] toByteArray(BitStreamSerializer bitStreamSerializer) {
        this.arrayStream.reset();
        bitStreamSerializer.serialize(this.arrayStream);
        return this.arrayStream.toByteArray();
    }

    public void fromArray(BitStreamSerializer bitStreamSerializer, byte[] byArray) {
        this.arrayStream.reset(byArray);
        bitStreamSerializer.deserialize(this.arrayStream);
    }

    public int toInteger(BitStreamSerializer bitStreamSerializer, int n) {
        this.integerStream.reset(0, n);
        bitStreamSerializer.serialize(this.integerStream);
        return this.integerStream.toInteger();
    }

    public void fromInteger(BitStreamSerializer bitStreamSerializer, int n, int n2) {
        this.integerStream.reset(n, n2);
        bitStreamSerializer.deserialize(this.integerStream);
    }

    public BitStream bitStreamForValue(int n, int n2) {
        this.integerStream.reset(n, n2);
        return this.integerStream;
    }

    public BitStream bitStreamForValue(byte[] byArray) {
        this.arrayStream.reset(byArray);
        return this.arrayStream;
    }

    public boolean equal(BitStreamSerializer bitStreamSerializer, BitStreamSerializer bitStreamSerializer2) {
        return Arrays.equals(this.toByteArray(bitStreamSerializer), this.toByteArray(bitStreamSerializer2));
    }

    public static BitStream newBitStreamForValue(int n, int n2) {
        return new IntegerStream(n, n2);
    }

    public static BitStream newBitStreamForValue(byte[] byArray) {
        return new ByteArrayStream(byArray);
    }
}

