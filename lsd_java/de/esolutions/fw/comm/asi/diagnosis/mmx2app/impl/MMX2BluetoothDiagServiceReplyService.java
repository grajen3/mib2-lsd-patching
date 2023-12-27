/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2BluetoothDiagServiceReply;
import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class MMX2BluetoothDiagServiceReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.asi.diagnosis.mmx2app.MMX2BluetoothDiagService");
    private static int dynamicHandle = 0;
    private MMX2BluetoothDiagServiceReply p_MMX2BluetoothDiagServiceReply;

    public MMX2BluetoothDiagServiceReplyService(MMX2BluetoothDiagServiceReply mMX2BluetoothDiagServiceReply) {
        super(new ServiceInstanceID("a2aba5f9-4aae-436e-802a-26bbd44eec8e", MMX2BluetoothDiagServiceReplyService.nextDynamicHandle(), "53cec102-0ba4-570c-9109-ebc8f698e1cf", "asi.diagnosis.mmx2app.MMX2BluetoothDiagService"));
        this.p_MMX2BluetoothDiagServiceReply = mMX2BluetoothDiagServiceReply;
    }

    private static synchronized int nextDynamicHandle() {
        int n = ++dynamicHandle;
        return n;
    }

    @Override
    public CallContext getCallContext() {
        return context;
    }

    @Override
    public void handleCallMethod(short s, IDeserializer iDeserializer, IProxyFrontend iProxyFrontend) {
        try {
            switch (s) {
                case 3: {
                    long l = iDeserializer.getUInt32();
                    this.p_MMX2BluetoothDiagServiceReply.requestBluetoothState(l);
                    break;
                }
                case 2: {
                    long l = iDeserializer.getUInt32();
                    this.p_MMX2BluetoothDiagServiceReply.requestBluetoothMAC(l);
                    break;
                }
                case 1: {
                    long l = iDeserializer.getUInt32();
                    this.p_MMX2BluetoothDiagServiceReply.requestBluetoothDevices(l);
                    break;
                }
                case 9: {
                    long l = iDeserializer.getUInt32();
                    short s2 = iDeserializer.getUInt8();
                    this.p_MMX2BluetoothDiagServiceReply.requestLastPairedBtDevices(l, s2);
                    break;
                }
                case 10: {
                    long l = iDeserializer.getUInt32();
                    this.p_MMX2BluetoothDiagServiceReply.requestPairedBtDevices(l);
                    break;
                }
                case 7: {
                    long l = iDeserializer.getUInt32();
                    this.p_MMX2BluetoothDiagServiceReply.requestConnectedBtDevices(l);
                    break;
                }
                case 6: {
                    long l = iDeserializer.getUInt32();
                    short s3 = iDeserializer.getUInt8();
                    this.p_MMX2BluetoothDiagServiceReply.requestConnectedBtDevice(l, s3);
                    break;
                }
                case 0: {
                    long l = iDeserializer.getUInt32();
                    int n = iDeserializer.getEnum();
                    this.p_MMX2BluetoothDiagServiceReply.requestAutoConnectBtHandset(l, n);
                    break;
                }
                case 34: {
                    long l = iDeserializer.getUInt32();
                    int n = iDeserializer.getEnum();
                    int n2 = iDeserializer.getEnum();
                    this.p_MMX2BluetoothDiagServiceReply.requestBtDeleteLinkKeys(l, n, n2);
                    break;
                }
                case 5: {
                    long l = iDeserializer.getUInt32();
                    short s4 = iDeserializer.getUInt8();
                    short s5 = iDeserializer.getUInt8();
                    this.p_MMX2BluetoothDiagServiceReply.requestBtDeviceSearch(l, s4, s5);
                    break;
                }
                case 8: {
                    long l = iDeserializer.getUInt32();
                    short s6 = iDeserializer.getUInt8();
                    short s7 = iDeserializer.getUInt8();
                    this.p_MMX2BluetoothDiagServiceReply.requestConnectionToLastBtDevice(l, s6, s7);
                    break;
                }
                default: {
                    throw new MethodException(new StringBuffer().append("Invalid Method Id ").append(s).toString());
                }
            }
        }
        catch (SerializerException serializerException) {
            throw new MethodException(new StringBuffer().append("Deserialization failed: method=").append(s).append(", error=").append(serializerException.getMessage()).toString());
        }
    }
}

