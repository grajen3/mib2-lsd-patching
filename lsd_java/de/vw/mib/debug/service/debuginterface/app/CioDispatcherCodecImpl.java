/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.debuginterface.app;

import de.vw.mib.codec.ByteArrayReader;
import de.vw.mib.debug.service.debuginterface.app.CioDispatcherCodec;
import de.vw.mib.debug.service.debuginterface.app.CioDispatcherCodecListener;
import de.vw.mib.log4mib.BinaryMessage;

public class CioDispatcherCodecImpl
implements CioDispatcherCodec {
    @Override
    public void decode(byte[] byArray, CioDispatcherCodecListener cioDispatcherCodecListener) {
        this.decode(new ByteArrayReader(byArray), cioDispatcherCodecListener);
    }

    @Override
    public void decode(ByteArrayReader byteArrayReader, CioDispatcherCodecListener cioDispatcherCodecListener) {
        byte by = byteArrayReader.readByte();
        switch (by) {
            case 0: {
                cioDispatcherCodecListener.dispatch(byteArrayReader.readLong());
                break;
            }
            case 2: {
                cioDispatcherCodecListener.dispatch(byteArrayReader.readString(), byteArrayReader.readString());
                break;
            }
            case 3: {
                cioDispatcherCodecListener.dispatchAll(byteArrayReader.readString(), byteArrayReader.readString());
                break;
            }
            case 1: {
                cioDispatcherCodecListener.dispatch(byteArrayReader.readString(), byteArrayReader.readString(), byteArrayReader.readString());
                break;
            }
        }
    }

    @Override
    public BinaryMessage responseCioDispached(BinaryMessage binaryMessage, boolean bl, String string) {
        binaryMessage.append((byte)10);
        binaryMessage.append(bl);
        binaryMessage.append(string);
        return binaryMessage;
    }
}

