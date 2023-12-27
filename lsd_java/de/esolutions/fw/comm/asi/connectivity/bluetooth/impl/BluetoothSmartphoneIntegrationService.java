/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.bluetooth.impl;

import de.esolutions.fw.comm.asi.connectivity.bluetooth.BluetoothSmartphoneIntegrationS;
import de.esolutions.fw.comm.asi.connectivity.bluetooth.impl.BluetoothSmartphoneIntegrationReplyProxy;
import de.esolutions.fw.comm.core.AbstractService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class BluetoothSmartphoneIntegrationService
extends AbstractService {
    private static final CallContext context = CallContext.getContext("STUB.asi.connectivity.bluetooth.BluetoothSmartphoneIntegration");
    private BluetoothSmartphoneIntegrationS p_BluetoothSmartphoneIntegration;

    public BluetoothSmartphoneIntegrationService(int n, BluetoothSmartphoneIntegrationS bluetoothSmartphoneIntegrationS) {
        super(new ServiceInstanceID("abec271c-8352-4a6b-a4a5-a36dfd6f8f02", n, "63fedff0-a108-5360-bab1-6cc1456a6d8f", "asi.connectivity.bluetooth.BluetoothSmartphoneIntegration"));
        this.p_BluetoothSmartphoneIntegration = bluetoothSmartphoneIntegrationS;
    }

    @Override
    public IProxyFrontend createReplyProxy() {
        return new BluetoothSmartphoneIntegrationReplyProxy();
    }

    @Override
    public CallContext getCallContext() {
        return context;
    }

    @Override
    public void handleCallMethod(short s, IDeserializer iDeserializer, IProxyFrontend iProxyFrontend) {
        try {
            switch (s) {
                case 8: {
                    int n = iDeserializer.getEnum();
                    String[] stringArray = iDeserializer.getOptionalStringVarArray();
                    this.p_BluetoothSmartphoneIntegration.updateSmartphoneMode(n, stringArray, (BluetoothSmartphoneIntegrationReplyProxy)iProxyFrontend);
                    break;
                }
                case 3: {
                    this.p_BluetoothSmartphoneIntegration.requestLocalBluetoothAddress((BluetoothSmartphoneIntegrationReplyProxy)iProxyFrontend);
                    break;
                }
                case 4: {
                    String string = iDeserializer.getOptionalString();
                    this.p_BluetoothSmartphoneIntegration.requestPrepareConnect(string, (BluetoothSmartphoneIntegrationReplyProxy)iProxyFrontend);
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

