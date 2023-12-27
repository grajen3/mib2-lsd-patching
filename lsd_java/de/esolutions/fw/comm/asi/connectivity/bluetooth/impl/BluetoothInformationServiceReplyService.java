/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.bluetooth.impl;

import de.esolutions.fw.comm.asi.connectivity.bluetooth.BluetoothDevice;
import de.esolutions.fw.comm.asi.connectivity.bluetooth.BluetoothInformationServiceReply;
import de.esolutions.fw.comm.asi.connectivity.bluetooth.impl.BluetoothDeviceSerializer;
import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class BluetoothInformationServiceReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.asi.connectivity.bluetooth.BluetoothInformationService");
    private static int dynamicHandle = 0;
    private BluetoothInformationServiceReply p_BluetoothInformationServiceReply;

    public BluetoothInformationServiceReplyService(BluetoothInformationServiceReply bluetoothInformationServiceReply) {
        super(new ServiceInstanceID("0d9b5586-8f24-4a93-8c53-d5cdaef1e111", BluetoothInformationServiceReplyService.nextDynamicHandle(), "4a7a95f3-5ac7-5d3b-b84d-85008994e7bf", "asi.connectivity.bluetooth.BluetoothInformationService"));
        this.p_BluetoothInformationServiceReply = bluetoothInformationServiceReply;
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
                case 2: {
                    int n = iDeserializer.getEnum();
                    this.p_BluetoothInformationServiceReply.updateBluetoothState(n);
                    break;
                }
                case 1: {
                    BluetoothDevice[] bluetoothDeviceArray = BluetoothDeviceSerializer.getOptionalBluetoothDeviceVarArray(iDeserializer);
                    this.p_BluetoothInformationServiceReply.updateBluetoothDevices(bluetoothDeviceArray);
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

