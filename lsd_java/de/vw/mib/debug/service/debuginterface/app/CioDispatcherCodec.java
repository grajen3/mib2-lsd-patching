/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.debuginterface.app;

import de.vw.mib.codec.ByteArrayReader;
import de.vw.mib.debug.service.debuginterface.app.CioDispatcherCodecListener;
import de.vw.mib.log4mib.BinaryMessage;

public interface CioDispatcherCodec {
    default public BinaryMessage responseCioDispached(BinaryMessage binaryMessage, boolean bl, String string) {
    }

    default public void decode(byte[] byArray, CioDispatcherCodecListener cioDispatcherCodecListener) {
    }

    default public void decode(ByteArrayReader byteArrayReader, CioDispatcherCodecListener cioDispatcherCodecListener) {
    }
}

