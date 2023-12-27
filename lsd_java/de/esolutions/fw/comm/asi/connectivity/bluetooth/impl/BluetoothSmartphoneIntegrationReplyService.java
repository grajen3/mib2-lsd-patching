/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.bluetooth.impl;

import de.esolutions.fw.comm.asi.connectivity.bluetooth.BluetoothSmartphoneIntegrationReply;
import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class BluetoothSmartphoneIntegrationReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.asi.connectivity.bluetooth.BluetoothSmartphoneIntegration");
    private static int dynamicHandle = 0;
    private BluetoothSmartphoneIntegrationReply p_BluetoothSmartphoneIntegrationReply;

    public BluetoothSmartphoneIntegrationReplyService(BluetoothSmartphoneIntegrationReply bluetoothSmartphoneIntegrationReply) {
        super(new ServiceInstanceID("e89f426d-df36-46c9-b54d-712527c0309a", BluetoothSmartphoneIntegrationReplyService.nextDynamicHandle(), "fa60e661-b204-58e6-937d-484b8a10b0e4", "asi.connectivity.bluetooth.BluetoothSmartphoneIntegration"));
        this.p_BluetoothSmartphoneIntegrationReply = bluetoothSmartphoneIntegrationReply;
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
                case 5: {
                    String string = iDeserializer.getOptionalString();
                    this.p_BluetoothSmartphoneIntegrationReply.responseLocalBluetoothAddress(string);
                    break;
                }
                case 10: {
                    int n = iDeserializer.getEnum();
                    this.p_BluetoothSmartphoneIntegrationReply.updateSpiBtState(n);
                    break;
                }
                case 6: {
                    String string = iDeserializer.getOptionalString();
                    boolean bl = iDeserializer.getBool();
                    boolean bl2 = iDeserializer.getBool();
                    this.p_BluetoothSmartphoneIntegrationReply.responsePrepareConnect(string, bl, bl2);
                    break;
                }
                case 2: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_BluetoothSmartphoneIntegrationReply.reportSharedSecret(string, string2);
                    break;
                }
                case 1: {
                    String string = iDeserializer.getOptionalString();
                    boolean bl = iDeserializer.getBool();
                    this.p_BluetoothSmartphoneIntegrationReply.reportParingSuccess(string, bl);
                    break;
                }
                case 0: {
                    String string = iDeserializer.getOptionalString();
                    boolean bl = iDeserializer.getBool();
                    this.p_BluetoothSmartphoneIntegrationReply.reportConnectionEstablished(string, bl);
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

