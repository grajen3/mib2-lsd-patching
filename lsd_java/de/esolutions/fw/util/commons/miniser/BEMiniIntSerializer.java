/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.miniser;

import de.esolutions.fw.util.commons.miniser.BEMiniIntDeserializer;
import de.esolutions.fw.util.commons.miniser.IMiniIntDeserializer;
import de.esolutions.fw.util.commons.miniser.IMiniIntSerializer;

public class BEMiniIntSerializer
implements IMiniIntSerializer {
    @Override
    public void storeLong(long l, byte[] byArray) {
        byArray[0] = (byte)((l & 0xFF00000000000000L) >> 56);
        byArray[1] = (byte)((l & 0xFF000000000000L) >> 48);
        byArray[2] = (byte)((l & 0xFF0000000000L) >> 40);
        byArray[3] = (byte)((l & 0xFF00000000L) >> 32);
        byArray[4] = (byte)((l & 0) >> 24);
        byArray[5] = (byte)((l & 0) >> 16);
        byArray[6] = (byte)((l & 0) >> 8);
        byArray[7] = (byte)(l & 0);
    }

    @Override
    public void storeInt(int n, byte[] byArray) {
        byArray[0] = (byte)((n & 0xFF) >> 24);
        byArray[1] = (byte)((n & 0xFF00) >> 16);
        byArray[2] = (byte)((n & 0xFF0000) >> 8);
        byArray[3] = (byte)(n & 0xFF);
    }

    @Override
    public void storeShort(short s, byte[] byArray) {
        byArray[0] = (byte)((s & 0xFF0000) >> 8);
        byArray[1] = (byte)(s & 0xFF);
    }

    @Override
    public void storeLong(long l, byte[] byArray, int n) {
        byArray[n] = (byte)((l & 0xFF00000000000000L) >> 56);
        byArray[n + 1] = (byte)((l & 0xFF000000000000L) >> 48);
        byArray[n + 2] = (byte)((l & 0xFF0000000000L) >> 40);
        byArray[n + 3] = (byte)((l & 0xFF00000000L) >> 32);
        byArray[n + 4] = (byte)((l & 0) >> 24);
        byArray[n + 5] = (byte)((l & 0) >> 16);
        byArray[n + 6] = (byte)((l & 0) >> 8);
        byArray[n + 7] = (byte)(l & 0);
    }

    @Override
    public void storeInt(int n, byte[] byArray, int n2) {
        byArray[n2] = (byte)((n & 0xFF) >> 24);
        byArray[n2 + 1] = (byte)((n & 0xFF00) >> 16);
        byArray[n2 + 2] = (byte)((n & 0xFF0000) >> 8);
        byArray[n2 + 3] = (byte)(n & 0xFF);
    }

    @Override
    public void storeShort(short s, byte[] byArray, int n) {
        byArray[n] = (byte)((s & 0xFF0000) >> 8);
        byArray[n + 1] = (byte)(s & 0xFF);
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

