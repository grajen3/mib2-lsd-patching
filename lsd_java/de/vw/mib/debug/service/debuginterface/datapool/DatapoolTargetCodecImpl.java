/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.debuginterface.datapool;

import de.vw.mib.codec.ByteArrayReader;
import de.vw.mib.debug.service.debuginterface.datapool.DatapoolTargetCodec;
import de.vw.mib.debug.service.debuginterface.datapool.DatapoolTargetCodecListener;
import de.vw.mib.log4mib.BinaryMessage;

public class DatapoolTargetCodecImpl
implements DatapoolTargetCodec {
    public static final byte DATAPOOLMONITOR_GET_PROPERTY_VALUE;
    public static final byte DATAPOOLMONITOR_SET_PROPERTY_VALUE;
    public static final byte DATAPOOLMONITOR_RESULT_SETTING;
    public static final byte DATAPOOLMONITOR_RESULT_VALUE;

    @Override
    public void decode(byte[] byArray, DatapoolTargetCodecListener datapoolTargetCodecListener) {
        this.decode(new ByteArrayReader(byArray), datapoolTargetCodecListener);
    }

    @Override
    public void decode(ByteArrayReader byteArrayReader, DatapoolTargetCodecListener datapoolTargetCodecListener) {
        byte by = byteArrayReader.readByte();
        switch (by) {
            case 0: {
                datapoolTargetCodecListener.receiveGetPropertyValue(byteArrayReader.readInt(), byteArrayReader.readShort());
                break;
            }
            case 1: {
                datapoolTargetCodecListener.receiveSetPropertyValue(byteArrayReader.readInt(), byteArrayReader.readShort(), byteArrayReader.readString());
                break;
            }
            case 10: {
                boolean bl = byteArrayReader.readBoolean();
                String string = null;
                if (!bl) {
                    string = byteArrayReader.readString();
                }
                datapoolTargetCodecListener.datapoolUpdateResult(bl, string);
                break;
            }
            case 11: {
                datapoolTargetCodecListener.responseDatapoolPropertyValue(byteArrayReader.readLong(), byteArrayReader.readInt(), byteArrayReader.readString());
                break;
            }
        }
    }

    @Override
    public BinaryMessage responseDatapoolPropertyValue(BinaryMessage binaryMessage, long l, int n, String string) {
        binaryMessage.append((byte)11);
        binaryMessage.append(l);
        binaryMessage.append(n);
        binaryMessage.append(string);
        return binaryMessage;
    }

    public BinaryMessage responseDatapoolSettingResult(BinaryMessage binaryMessage, boolean bl, String string) {
        binaryMessage.append((byte)10);
        binaryMessage.append(bl);
        if (!bl) {
            binaryMessage.append(string);
        }
        return binaryMessage;
    }
}

