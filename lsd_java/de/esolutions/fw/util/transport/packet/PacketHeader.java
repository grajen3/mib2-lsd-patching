/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.packet;

import de.esolutions.fw.util.commons.miniser.BEMiniIntDeserializer;
import de.esolutions.fw.util.commons.miniser.BEMiniIntSerializer;

public class PacketHeader {
    public static final int SIZE;

    public static int decode(byte[] byArray) {
        BEMiniIntDeserializer bEMiniIntDeserializer = new BEMiniIntDeserializer();
        return bEMiniIntDeserializer.retrieveInt(byArray, 0);
    }

    public static byte[] encode(int n) {
        byte[] byArray = new byte[4];
        BEMiniIntSerializer bEMiniIntSerializer = new BEMiniIntSerializer();
        bEMiniIntSerializer.storeInt(n, byArray, 0);
        return byArray;
    }
}

