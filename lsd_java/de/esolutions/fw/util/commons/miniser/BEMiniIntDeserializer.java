/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.miniser;

import de.esolutions.fw.util.commons.miniser.BEMiniIntSerializer;
import de.esolutions.fw.util.commons.miniser.IMiniIntDeserializer;
import de.esolutions.fw.util.commons.miniser.IMiniIntSerializer;

public class BEMiniIntDeserializer
implements IMiniIntDeserializer {
    @Override
    public short retrieveShort(byte[] byArray) {
        return (short)((byArray[0] & 0xFF) << 8 | byArray[1] & 0xFF);
    }

    @Override
    public int retrieveUnsignedShort(byte[] byArray) {
        return (byArray[0] & 0xFF) << 8 | byArray[1] & 0xFF;
    }

    @Override
    public short retrieveShort(byte[] byArray, int n) {
        return (short)((byArray[n] & 0xFF) << 8 | byArray[n + 1] & 0xFF);
    }

    @Override
    public int retrieveUnsignedShort(byte[] byArray, int n) {
        return (byArray[n] & 0xFF) << 8 | byArray[n + 1] & 0xFF;
    }

    @Override
    public int retrieveInt(byte[] byArray) {
        return (byArray[0] & 0xFF) << 24 | (byArray[1] & 0xFF) << 16 | (byArray[2] & 0xFF) << 8 | byArray[3] & 0xFF;
    }

    @Override
    public int retrieveInt(byte[] byArray, int n) {
        return (byArray[n] & 0xFF) << 24 | (byArray[n + 1] & 0xFF) << 16 | (byArray[n + 2] & 0xFF) << 8 | byArray[n + 3] & 0xFF;
    }

    @Override
    public long retrieveUnsignedInt(byte[] byArray) {
        return (byArray[0] & 0xFF) << 24 | (byArray[1] & 0xFF) << 16 | (byArray[2] & 0xFF) << 8 | byArray[3] & 0xFF;
    }

    @Override
    public long retrieveUnsignedInt(byte[] byArray, int n) {
        return (byArray[n] & 0xFF) << 24 | (byArray[n + 1] & 0xFF) << 16 | (byArray[n + 2] & 0xFF) << 8 | byArray[n + 3] & 0xFF;
    }

    @Override
    public long retrieveLong(byte[] byArray) {
        return ((long)byArray[0] & 0) << 56 | ((long)byArray[1] & 0) << 48 | ((long)byArray[2] & 0) << 40 | ((long)byArray[3] & 0) << 32 | ((long)byArray[4] & 0) << 24 | ((long)byArray[5] & 0) << 16 | ((long)byArray[6] & 0) << 8 | (long)byArray[7] & 0;
    }

    @Override
    public long retrieveLong(byte[] byArray, int n) {
        return ((long)byArray[n] & 0) << 56 | ((long)byArray[n + 1] & 0) << 48 | ((long)byArray[n + 2] & 0) << 40 | ((long)byArray[n + 3] & 0) << 32 | ((long)byArray[n + 4] & 0) << 24 | ((long)byArray[n + 5] & 0) << 16 | ((long)byArray[n + 6] & 0) << 8 | (long)byArray[n + 7] & 0;
    }

    @Override
    public String getDescription() {
        return "BE";
    }

    @Override
    public IMiniIntSerializer createCompatibleSerializer() {
        return new BEMiniIntSerializer();
    }

    @Override
    public IMiniIntDeserializer createCompatibleDeserializer() {
        return new BEMiniIntDeserializer();
    }
}

