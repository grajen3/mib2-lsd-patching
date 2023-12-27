/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.bluetooth.impl;

import de.esolutions.fw.comm.asi.connectivity.bluetooth.BluetoothInformationServiceS;
import de.esolutions.fw.comm.asi.connectivity.bluetooth.impl.BluetoothInformationServiceReplyProxy;
import de.esolutions.fw.comm.core.AbstractService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;

public class BluetoothInformationServiceService
extends AbstractService {
    private static final CallContext context = CallContext.getContext("STUB.asi.connectivity.bluetooth.BluetoothInformationService");
    private BluetoothInformationServiceS p_BluetoothInformationService;

    public BluetoothInformationServiceService(int n, BluetoothInformationServiceS bluetoothInformationServiceS) {
        super(new ServiceInstanceID("133c937f-bbad-4723-a502-4020cab96d54", n, "392292c0-0162-518b-a406-7ae6e893e978", "asi.connectivity.bluetooth.BluetoothInformationService"));
        this.p_BluetoothInformationService = bluetoothInformationServiceS;
    }

    @Override
    public IProxyFrontend createReplyProxy() {
        return new BluetoothInformationServiceReplyProxy();
    }

    @Override
    public CallContext getCallContext() {
        return context;
    }

    @Override
    public void handleCallMethod(short s, IDeserializer iDeserializer, IProxyFrontend iProxyFrontend) {
        switch (s) {
            default: 
        }
        throw new MethodException(new StringBuffer().append("Invalid Method Id ").append(s).toString());
    }
}

