/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.debuginterface.keypanel;

import de.vw.mib.codec.ByteArrayReader;
import de.vw.mib.debug.service.debuginterface.keypanel.KeypanelTargetCodec;
import de.vw.mib.debug.service.debuginterface.keypanel.KeypanelTargetCodecListener;
import de.vw.mib.log4mib.BinaryMessage;

public class KeypanelTargetCodecImpl
implements KeypanelTargetCodec {
    private static final byte TOUCH_PRESS;
    private static final byte ERROR_TOUCH_PRESS;
    private static final byte TOUCH_RELEASE;
    private static final byte ERROR_TOUCH_RELEASE;

    public BinaryMessage encodeErrorTouchPress(BinaryMessage binaryMessage, boolean bl, String string) {
        return this.writeErrorMessage(binaryMessage, (byte)2, bl, string);
    }

    public BinaryMessage encodeErrorTouchRelease(BinaryMessage binaryMessage, boolean bl, String string) {
        return this.writeErrorMessage(binaryMessage, (byte)4, bl, string);
    }

    private BinaryMessage writeErrorMessage(BinaryMessage binaryMessage, byte by, boolean bl, String string) {
        binaryMessage.append(by);
        binaryMessage.append(bl);
        if (bl) {
            binaryMessage.append(string);
        }
        return binaryMessage;
    }

    public void decode(byte[] byArray, KeypanelTargetCodecListener keypanelTargetCodecListener) {
        this.decode(new ByteArrayReader(byArray), keypanelTargetCodecListener);
    }

    public void decode(ByteArrayReader byteArrayReader, KeypanelTargetCodecListener keypanelTargetCodecListener) {
        byte by = byteArrayReader.readByte();
        switch (by) {
            case 1: {
                keypanelTargetCodecListener.gotTouchPress(byteArrayReader.readInt(), byteArrayReader.readInt());
                break;
            }
            case 3: {
                keypanelTargetCodecListener.gotTouchRelease(byteArrayReader.readInt(), byteArrayReader.readInt());
                break;
            }
        }
    }
}

