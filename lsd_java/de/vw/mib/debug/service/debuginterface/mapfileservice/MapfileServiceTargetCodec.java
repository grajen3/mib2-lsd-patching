/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.debuginterface.mapfileservice;

import de.vw.mib.codec.ByteArrayReader;
import de.vw.mib.debug.service.debuginterface.mapfileservice.MapFileServiceTargetCodecListener;
import de.vw.mib.log4mib.BinaryMessage;

public class MapfileServiceTargetCodec {
    private int requestSessionId;
    private static final byte GET_DEBUG_INFO_FILES_ARCHIVE;
    private static final byte GET_HMIEVENTMAP;
    private static final byte GET_DATAPOOLMAP;
    private static final byte RESPONSE_DEBUG_INFO_FILES_ARCHIVE;
    private static final byte RESPONSE_HMIEVENTMAP;
    private static final byte RESPONSE_DATAPOOLMAP;

    public BinaryMessage encodeResponseDebugInfoFiles(BinaryMessage binaryMessage, boolean bl) {
        binaryMessage.append((byte)20);
        binaryMessage.append(this.requestSessionId);
        binaryMessage.append(bl);
        return binaryMessage;
    }

    public BinaryMessage encodeResponseHMIEventMap(BinaryMessage binaryMessage, byte[] byArray) {
        binaryMessage.append((byte)27);
        binaryMessage.append(this.requestSessionId);
        binaryMessage.append(byArray);
        return binaryMessage;
    }

    public BinaryMessage encodeResponseDatapoolMap(BinaryMessage binaryMessage, byte[] byArray) {
        binaryMessage.append((byte)28);
        binaryMessage.append(this.requestSessionId);
        binaryMessage.append(byArray);
        return binaryMessage;
    }

    public void decode(ByteArrayReader byteArrayReader, MapFileServiceTargetCodecListener mapFileServiceTargetCodecListener) {
        byte by = byteArrayReader.readByte();
        switch (by) {
            case 0: {
                this.requestSessionId = byteArrayReader.readInt();
                mapFileServiceTargetCodecListener.getDebugInfoFiles(byteArrayReader.readInt(), byteArrayReader.readBoolean());
                break;
            }
            case 7: {
                this.requestSessionId = byteArrayReader.readInt();
                mapFileServiceTargetCodecListener.getHMIEventMap();
                break;
            }
            case 8: {
                this.requestSessionId = byteArrayReader.readInt();
                mapFileServiceTargetCodecListener.getDatapoolMap();
                break;
            }
        }
    }
}

