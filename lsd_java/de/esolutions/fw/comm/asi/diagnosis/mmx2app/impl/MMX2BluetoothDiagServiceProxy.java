/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.bluetooth.sBluetoothDeviceName;
import de.esolutions.fw.comm.asi.diagnosis.bluetooth.sBluetoothDevices;
import de.esolutions.fw.comm.asi.diagnosis.bluetooth.sBluetoothMAC;
import de.esolutions.fw.comm.asi.diagnosis.bluetooth.sBluetoothState;
import de.esolutions.fw.comm.asi.diagnosis.bluetooth.sConnectedBtDevice;
import de.esolutions.fw.comm.asi.diagnosis.bluetooth.sConnectedBtDevices;
import de.esolutions.fw.comm.asi.diagnosis.bluetooth.sLastPairedBtDevices;
import de.esolutions.fw.comm.asi.diagnosis.bluetooth.sPairedBtDevices;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sClientResponseError;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sRoutineResponse;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2BluetoothDiagService;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2BluetoothDiagServiceC;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2BluetoothDiagServiceReply;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2BluetoothDiagServiceProxy$1;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2BluetoothDiagServiceProxy$10;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2BluetoothDiagServiceProxy$11;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2BluetoothDiagServiceProxy$2;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2BluetoothDiagServiceProxy$3;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2BluetoothDiagServiceProxy$4;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2BluetoothDiagServiceProxy$5;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2BluetoothDiagServiceProxy$6;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2BluetoothDiagServiceProxy$7;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2BluetoothDiagServiceProxy$8;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2BluetoothDiagServiceProxy$9;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2BluetoothDiagServiceReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class MMX2BluetoothDiagServiceProxy
implements MMX2BluetoothDiagService,
MMX2BluetoothDiagServiceC {
    private static final CallContext context = CallContext.getContext("PROXY.asi.diagnosis.mmx2app.MMX2BluetoothDiagService");
    private Proxy proxy;

    public MMX2BluetoothDiagServiceProxy(int n, MMX2BluetoothDiagServiceReply mMX2BluetoothDiagServiceReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("f669c772-a80d-457f-b9af-0eb44581d9e1", n, "95c41391-df54-5fea-80a5-0615f88b8b03", "asi.diagnosis.mmx2app.MMX2BluetoothDiagService");
        MMX2BluetoothDiagServiceReplyService mMX2BluetoothDiagServiceReplyService = new MMX2BluetoothDiagServiceReplyService(mMX2BluetoothDiagServiceReply);
        this.proxy = new Proxy(serviceInstanceID, mMX2BluetoothDiagServiceReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void responseErrorBluetooth(sClientResponseError sClientResponseError2) {
        MMX2BluetoothDiagServiceProxy$1 mMX2BluetoothDiagServiceProxy$1 = new MMX2BluetoothDiagServiceProxy$1(this, sClientResponseError2);
        this.proxy.remoteCallMethod((short)37, mMX2BluetoothDiagServiceProxy$1);
    }

    @Override
    public void responseBluetoothState(sBluetoothState sBluetoothState2) {
        MMX2BluetoothDiagServiceProxy$2 mMX2BluetoothDiagServiceProxy$2 = new MMX2BluetoothDiagServiceProxy$2(this, sBluetoothState2);
        this.proxy.remoteCallMethod((short)14, mMX2BluetoothDiagServiceProxy$2);
    }

    @Override
    public void responseBluetoothMAC(sBluetoothMAC sBluetoothMAC2) {
        MMX2BluetoothDiagServiceProxy$3 mMX2BluetoothDiagServiceProxy$3 = new MMX2BluetoothDiagServiceProxy$3(this, sBluetoothMAC2);
        this.proxy.remoteCallMethod((short)13, mMX2BluetoothDiagServiceProxy$3);
    }

    @Override
    public void responseBluetoothDevices(sBluetoothDevices sBluetoothDevices2) {
        MMX2BluetoothDiagServiceProxy$4 mMX2BluetoothDiagServiceProxy$4 = new MMX2BluetoothDiagServiceProxy$4(this, sBluetoothDevices2);
        this.proxy.remoteCallMethod((short)12, mMX2BluetoothDiagServiceProxy$4);
    }

    @Override
    public void responseLastPairedBtDevices(sLastPairedBtDevices sLastPairedBtDevices2) {
        MMX2BluetoothDiagServiceProxy$5 mMX2BluetoothDiagServiceProxy$5 = new MMX2BluetoothDiagServiceProxy$5(this, sLastPairedBtDevices2);
        this.proxy.remoteCallMethod((short)38, mMX2BluetoothDiagServiceProxy$5);
    }

    @Override
    public void responsePairedBtDevices(sPairedBtDevices sPairedBtDevices2) {
        MMX2BluetoothDiagServiceProxy$6 mMX2BluetoothDiagServiceProxy$6 = new MMX2BluetoothDiagServiceProxy$6(this, sPairedBtDevices2);
        this.proxy.remoteCallMethod((short)32, mMX2BluetoothDiagServiceProxy$6);
    }

    @Override
    public void responseConnectedBtDevices(sConnectedBtDevices sConnectedBtDevices2) {
        MMX2BluetoothDiagServiceProxy$7 mMX2BluetoothDiagServiceProxy$7 = new MMX2BluetoothDiagServiceProxy$7(this, sConnectedBtDevices2);
        this.proxy.remoteCallMethod((short)31, mMX2BluetoothDiagServiceProxy$7);
    }

    @Override
    public void responseConnectedBtDevice(sConnectedBtDevice sConnectedBtDevice2) {
        MMX2BluetoothDiagServiceProxy$8 mMX2BluetoothDiagServiceProxy$8 = new MMX2BluetoothDiagServiceProxy$8(this, sConnectedBtDevice2);
        this.proxy.remoteCallMethod((short)17, mMX2BluetoothDiagServiceProxy$8);
    }

    @Override
    public void responseAutoConnectBtHandset(sRoutineResponse sRoutineResponse2) {
        MMX2BluetoothDiagServiceProxy$9 mMX2BluetoothDiagServiceProxy$9 = new MMX2BluetoothDiagServiceProxy$9(this, sRoutineResponse2);
        this.proxy.remoteCallMethod((short)27, mMX2BluetoothDiagServiceProxy$9);
    }

    @Override
    public void responseBtDeleteLinkKeys(sRoutineResponse sRoutineResponse2) {
        MMX2BluetoothDiagServiceProxy$10 mMX2BluetoothDiagServiceProxy$10 = new MMX2BluetoothDiagServiceProxy$10(this, sRoutineResponse2);
        this.proxy.remoteCallMethod((short)28, mMX2BluetoothDiagServiceProxy$10);
    }

    @Override
    public void responseBtDeviceSearch(long l) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putUInt32(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)16, genericSerializable);
    }

    @Override
    public void responseBtDeviceSearchItem(sBluetoothDeviceName[] sBluetoothDeviceNameArray) {
        MMX2BluetoothDiagServiceProxy$11 mMX2BluetoothDiagServiceProxy$11 = new MMX2BluetoothDiagServiceProxy$11(this, sBluetoothDeviceNameArray);
        this.proxy.remoteCallMethod((short)36, mMX2BluetoothDiagServiceProxy$11);
    }

    @Override
    public void responseConnectionToLastBtDevice(long l) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putUInt32(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)19, genericSerializable);
    }
}

