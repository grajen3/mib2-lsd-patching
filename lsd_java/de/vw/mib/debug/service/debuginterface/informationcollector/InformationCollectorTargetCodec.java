/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.debuginterface.informationcollector;

import de.vw.mib.codec.ByteArrayReader;
import de.vw.mib.debug.service.debuginterface.informationcollector.InformationCollectorTargetCodecListener;
import de.vw.mib.log4mib.BinaryMessage;

public class InformationCollectorTargetCodec {
    private int requestSessionId;
    private static final byte GET_DEBUG_INFO_FILES_ARCHIVE;
    private static final byte GET_TARGETPROTOCOLVERSION;
    private static final byte GET_SKIN_SHORT_VERSION;
    private static final byte GET_LANGUAGE;
    private static final byte GET_VERSIONSTRING;
    private static final byte GET_BASEVERSIONSTRING;
    private static final byte IS_TESTINTERFACE_AVAILABLE;
    private static final byte GET_DSIVERSION;
    private static final byte GET_MU_PART_NUMBER;
    private static final byte GET_PART_NUMBER;
    private static final byte RESPONSE_DEBUG_INFO_FILES_ARCHIVE;
    private static final byte RESPONSE_TARGETPROTOCOLVERSION;
    private static final byte RESPONSE_SKIN_SHORT_VERSION;
    private static final byte RESPONSE_LANGUAGE;
    private static final byte RESPONSE_VERSIONSTRING;
    private static final byte RESPONSE_BASEVERSIONSTRING;
    private static final byte RESPONSE_TESTINTERFACE_AVAILABLE;
    private static final byte RESPONSE_DSIVERSION;
    private static final byte RESPONSE_MU_PART_NUMBER;
    private static final byte RESPONSE_PART_NUMBER;

    public BinaryMessage encodeResponseDebugInfoFiles(BinaryMessage binaryMessage, boolean bl) {
        binaryMessage.append((byte)20);
        binaryMessage.append(this.requestSessionId);
        binaryMessage.append(bl);
        return binaryMessage;
    }

    public BinaryMessage encodeResponseProtocolVersion(BinaryMessage binaryMessage, String string) {
        binaryMessage.append((byte)21);
        binaryMessage.append(this.requestSessionId);
        binaryMessage.append(string);
        return binaryMessage;
    }

    public BinaryMessage encodeResponseSkinVersion(BinaryMessage binaryMessage, String string) {
        binaryMessage.append((byte)22);
        binaryMessage.append(this.requestSessionId);
        binaryMessage.append(string);
        return binaryMessage;
    }

    public BinaryMessage encodeResponseLanguage(BinaryMessage binaryMessage, String string) {
        binaryMessage.append((byte)23);
        binaryMessage.append(this.requestSessionId);
        binaryMessage.append(string);
        return binaryMessage;
    }

    public BinaryMessage encodeResponseVersion(BinaryMessage binaryMessage, String string) {
        binaryMessage.append((byte)24);
        binaryMessage.append(this.requestSessionId);
        binaryMessage.append(string);
        return binaryMessage;
    }

    public BinaryMessage encodeResponseBaseVersion(BinaryMessage binaryMessage, String string) {
        binaryMessage.append((byte)25);
        binaryMessage.append(this.requestSessionId);
        binaryMessage.append(string);
        return binaryMessage;
    }

    public BinaryMessage encodeResponseTestInterfaceAvailable(BinaryMessage binaryMessage, boolean bl) {
        binaryMessage.append((byte)26);
        binaryMessage.append(this.requestSessionId);
        binaryMessage.append(bl);
        return binaryMessage;
    }

    public BinaryMessage encodeResponseDsiVersion(BinaryMessage binaryMessage, String string) {
        binaryMessage.append((byte)29);
        binaryMessage.append(this.requestSessionId);
        binaryMessage.append(string);
        return binaryMessage;
    }

    public BinaryMessage encodeSoftwareMUPartNumber(BinaryMessage binaryMessage, String string) {
        binaryMessage.append((byte)30);
        binaryMessage.append(this.requestSessionId);
        binaryMessage.append(string);
        return binaryMessage;
    }

    public BinaryMessage encodeResponsePartNumber(BinaryMessage binaryMessage, String string) {
        binaryMessage.append((byte)31);
        binaryMessage.append(this.requestSessionId);
        binaryMessage.append(string);
        return binaryMessage;
    }

    public void decode(ByteArrayReader byteArrayReader, InformationCollectorTargetCodecListener informationCollectorTargetCodecListener) {
        byte by = byteArrayReader.readByte();
        switch (by) {
            case 1: {
                this.requestSessionId = byteArrayReader.readInt();
                informationCollectorTargetCodecListener.getTargetProtocolVersion();
                break;
            }
            case 2: {
                this.requestSessionId = byteArrayReader.readInt();
                informationCollectorTargetCodecListener.getSkinShortVersion();
                break;
            }
            case 3: {
                this.requestSessionId = byteArrayReader.readInt();
                informationCollectorTargetCodecListener.getLanguage();
                break;
            }
            case 4: {
                this.requestSessionId = byteArrayReader.readInt();
                informationCollectorTargetCodecListener.getTargetVersion();
                break;
            }
            case 5: {
                this.requestSessionId = byteArrayReader.readInt();
                informationCollectorTargetCodecListener.getTargetBaseVersion();
                break;
            }
            case 6: {
                this.requestSessionId = byteArrayReader.readInt();
                informationCollectorTargetCodecListener.getTestInterfaceAvailable();
                break;
            }
            case 9: {
                this.requestSessionId = byteArrayReader.readInt();
                informationCollectorTargetCodecListener.getDSIVersion();
                break;
            }
            case 10: {
                this.requestSessionId = byteArrayReader.readInt();
                informationCollectorTargetCodecListener.getSoftwareMUPartNumber();
                break;
            }
            case 11: {
                this.requestSessionId = byteArrayReader.readInt();
                informationCollectorTargetCodecListener.getPartNumber();
                break;
            }
            case 0: {
                this.requestSessionId = byteArrayReader.readInt();
                informationCollectorTargetCodecListener.getDebugInfoFiles(byteArrayReader.readInt(), byteArrayReader.readBoolean());
                break;
            }
        }
    }
}

