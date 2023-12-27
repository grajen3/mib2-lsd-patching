/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.debuginterface.dsitester;

import de.vw.mib.codec.ByteArrayReader;
import de.vw.mib.codec.ByteArrayWriter;
import de.vw.mib.debug.service.debuginterface.dsitester.DsiTesterTargetCodec;
import de.vw.mib.debug.service.debuginterface.dsitester.DsiTesterTargetCodecListener;
import de.vw.mib.debug.service.debuginterface.dsitester.argumentcodec.DsiArgumentsCodec;
import de.vw.mib.log4mib.BinaryMessage;

public class DsiTesterTargetCodecImpl
implements DsiTesterTargetCodec {
    public static final byte DSI_TESTER_TARGET_PROXY_SERVICE_INV_EV_ID;
    public static final byte DSI_TESTER_TARGET_PROXY_RESPONSE_INV_EV_ID;
    public static final byte DSI_TESTER_TARGET_PROXY_NOTIFICATION_INV_EV_ID;
    public static final byte DSI_TESTER_TARGET_INVOCATION_RESULT;
    DsiArgumentsCodec argsCodec = new DsiArgumentsCodec();
    ByteArrayWriter argumentWriter = new ByteArrayWriter();

    @Override
    public BinaryMessage encodeSuccsessResponse(BinaryMessage binaryMessage, boolean bl, String string) {
        binaryMessage.append((byte)10);
        binaryMessage.append(bl);
        if (!bl) {
            binaryMessage.append(string);
        }
        return binaryMessage;
    }

    public void decode(byte[] byArray, DsiTesterTargetCodecListener dsiTesterTargetCodecListener) {
        this.decode(new ByteArrayReader(byArray), dsiTesterTargetCodecListener);
    }

    public void decode(ByteArrayReader byteArrayReader, DsiTesterTargetCodecListener dsiTesterTargetCodecListener) {
        byte by = byteArrayReader.readByte();
        switch (by) {
            case 0: 
            case 1: 
            case 2: {
                this.invokeReceived(by, byteArrayReader, dsiTesterTargetCodecListener);
                break;
            }
            case 10: {
                boolean bl = byteArrayReader.readBoolean();
                String string = null;
                if (!bl) {
                    string = byteArrayReader.readString();
                }
                dsiTesterTargetCodecListener.invokationResult(bl, string);
                break;
            }
        }
    }

    private void invokeReceived(byte by, ByteArrayReader byteArrayReader, DsiTesterTargetCodecListener dsiTesterTargetCodecListener) {
        String string = byteArrayReader.readString();
        int n = byteArrayReader.readInt();
        String string2 = byteArrayReader.readString();
        int n2 = byteArrayReader.readInt();
        Object[] objectArray = this.argsCodec.getArguments(n2, byteArrayReader);
        switch (by) {
            case 0: {
                dsiTesterTargetCodecListener.invokeServiceDecoded(string, n, string2, objectArray);
                break;
            }
            case 1: {
                dsiTesterTargetCodecListener.invokeResponseDecoded(string, n, string2, objectArray);
                break;
            }
            case 2: {
                dsiTesterTargetCodecListener.invokeNotificationDecoded(string, n, string2, objectArray);
                break;
            }
        }
    }
}

