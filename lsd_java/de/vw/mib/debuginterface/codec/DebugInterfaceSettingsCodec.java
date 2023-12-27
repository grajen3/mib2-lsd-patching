/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debuginterface.codec;

import de.vw.mib.codec.ByteArrayReader;
import de.vw.mib.debuginterface.codec.DebugInterfaceSettingsCodecListener;

public class DebugInterfaceSettingsCodec {
    public void decode(byte[] byArray, DebugInterfaceSettingsCodecListener debugInterfaceSettingsCodecListener) {
        this.decode(new ByteArrayReader(byArray), debugInterfaceSettingsCodecListener);
    }

    public void decode(ByteArrayReader byteArrayReader, DebugInterfaceSettingsCodecListener debugInterfaceSettingsCodecListener) {
        debugInterfaceSettingsCodecListener.createAndRegisterDebugTarget(byteArrayReader.readInt());
    }
}

