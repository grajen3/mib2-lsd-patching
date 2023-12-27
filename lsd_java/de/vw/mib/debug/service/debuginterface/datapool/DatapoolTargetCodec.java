/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.debuginterface.datapool;

import de.vw.mib.codec.ByteArrayReader;
import de.vw.mib.debug.service.debuginterface.datapool.DatapoolTargetCodecListener;
import de.vw.mib.log4mib.BinaryMessage;

public interface DatapoolTargetCodec {
    default public BinaryMessage responseDatapoolPropertyValue(BinaryMessage binaryMessage, long l, int n, String string) {
    }

    default public void decode(byte[] byArray, DatapoolTargetCodecListener datapoolTargetCodecListener) {
    }

    default public void decode(ByteArrayReader byteArrayReader, DatapoolTargetCodecListener datapoolTargetCodecListener) {
    }
}

