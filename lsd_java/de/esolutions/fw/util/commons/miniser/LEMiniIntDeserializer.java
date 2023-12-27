/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.miniser;

import de.esolutions.fw.util.commons.miniser.IMiniIntDeserializer;
import de.esolutions.fw.util.commons.miniser.IMiniIntSerializer;
import de.esolutions.fw.util.commons.miniser.LEMiniIntSerializer;

public class LEMiniIntDeserializer
implements IMiniIntDeserializer {
    @Override
    public short retrieveShort(byte[] byArray) {
        return (short)((byArray[1] & 0xFF) << 8 | byArray[0] & 0xFF);
    }

    @Override
    public short retrieveShort(byte[] byArray, int n) {
        return (short)((byArray[n + 1] & 0xFF) << 8 | byArray[n] & 0xFF);
    }

    @Override
    public int retrieveUnsignedShort(byte[] byArray) {
        return (byArray[1] & 0xFF) << 8 | byArray[0] & 0xFF;
    }

    @Override
    public int retrieveUnsignedShort(byte[] byArray, int n) {
        return (byArray[n + 1] & 0xFF) << 8 | byArray[n] & 0xFF;
    }

    @Override
    public int retrieveInt(byte[] byArray) {
        return (byArray[3] & 0xFF) << 24 | (byArray[2] & 0xFF) << 16 | (byArray[1] & 0xFF) << 8 | byArray[0] & 0xFF;
    }

    @Override
    public int retrieveInt(byte[] byArray, int n) {
        return (byArray[n + 3] & 0xFF) << 24 | (byArray[n + 2] & 0xFF) << 16 | (byArray[n + 1] & 0xFF) << 8 | byArray[n] & 0xFF;
    }

    @Override
    public long retrieveUnsignedInt(byte[] byArray) {
        return (byArray[3] & 0xFF) << 24 | (byArray[2] & 0xFF) << 16 | (byArray[1] & 0xFF) << 8 | byArray[0] & 0xFF;
    }

    @Override
    public long retrieveUnsignedInt(byte[] byArray, int n) {
        return (byArray[n + 3] & 0xFF) << 24 | (byArray[n + 2] & 0xFF) << 16 | (byArray[n + 1] & 0xFF) << 8 | byArray[n] & 0xFF;
    }

    @Override
    public long retrieveLong(byte[] byArray) {
        return ((long)byArray[7] & 0) << 56 | ((long)byArray[6] & 0) << 48 | ((long)byArray[5] & 0) << 40 | ((long)byArray[4] & 0) << 32 | ((long)byArray[3] & 0) << 24 | ((long)byArray[2] & 0) << 16 | ((long)byArray[1] & 0) << 8 | (long)byArray[0] & 0;
    }

    @Override
    public long retrieveLong(byte[] byArray, int n) {
        return ((long)byArray[n + 7] & 0) << 56 | ((long)byArray[n + 6] & 0) << 48 | ((long)byArray[n + 5] & 0) << 40 | ((long)byArray[n + 4] & 0) << 32 | ((long)byArray[n + 3] & 0) << 24 | ((long)byArray[n + 2] & 0) << 16 | ((long)byArray[n + 1] & 0) << 8 | (long)byArray[n] & 0;
    }

    @Override
    public String getDescription() {
        return "LE";
    }

    @Override
    public IMiniIntSerializer createCompatibleSerializer() {
        return new LEMiniIntSerializer();
    }

    @Override
    public IMiniIntDeserializer createCompatibleDeserializer() {
        return new LEMiniIntDeserializer();
    }
}

