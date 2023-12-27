/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2BluetoothDiagServiceReply;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2BluetoothDiagServiceReplyProxy$1;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2BluetoothDiagServiceReplyProxy$10;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2BluetoothDiagServiceReplyProxy$11;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2BluetoothDiagServiceReplyProxy$2;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2BluetoothDiagServiceReplyProxy$3;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2BluetoothDiagServiceReplyProxy$4;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2BluetoothDiagServiceReplyProxy$5;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2BluetoothDiagServiceReplyProxy$6;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2BluetoothDiagServiceReplyProxy$7;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2BluetoothDiagServiceReplyProxy$8;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2BluetoothDiagServiceReplyProxy$9;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class MMX2BluetoothDiagServiceReplyProxy
implements MMX2BluetoothDiagServiceReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.diagnosis.mmx2app.MMX2BluetoothDiagService");
    private static final int INVALID_HANDLE;
    private Proxy proxy;

    public MMX2BluetoothDiagServiceReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("a2aba5f9-4aae-436e-802a-26bbd44eec8e", -1, "53cec102-0ba4-570c-9109-ebc8f698e1cf", "asi.diagnosis.mmx2app.MMX2BluetoothDiagService");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    @Override
    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void requestBluetoothState(long l) {
        MMX2BluetoothDiagServiceReplyProxy$1 mMX2BluetoothDiagServiceReplyProxy$1 = new MMX2BluetoothDiagServiceReplyProxy$1(this, l);
        this.proxy.remoteCallMethod((short)3, mMX2BluetoothDiagServiceReplyProxy$1);
    }

    @Override
    public void requestBluetoothMAC(long l) {
        MMX2BluetoothDiagServiceReplyProxy$2 mMX2BluetoothDiagServiceReplyProxy$2 = new MMX2BluetoothDiagServiceReplyProxy$2(this, l);
        this.proxy.remoteCallMethod((short)2, mMX2BluetoothDiagServiceReplyProxy$2);
    }

    @Override
    public void requestBluetoothDevices(long l) {
        MMX2BluetoothDiagServiceReplyProxy$3 mMX2BluetoothDiagServiceReplyProxy$3 = new MMX2BluetoothDiagServiceReplyProxy$3(this, l);
        this.proxy.remoteCallMethod((short)1, mMX2BluetoothDiagServiceReplyProxy$3);
    }

    @Override
    public void requestLastPairedBtDevices(long l, short s) {
        MMX2BluetoothDiagServiceReplyProxy$4 mMX2BluetoothDiagServiceReplyProxy$4 = new MMX2BluetoothDiagServiceReplyProxy$4(this, l, s);
        this.proxy.remoteCallMethod((short)9, mMX2BluetoothDiagServiceReplyProxy$4);
    }

    @Override
    public void requestPairedBtDevices(long l) {
        MMX2BluetoothDiagServiceReplyProxy$5 mMX2BluetoothDiagServiceReplyProxy$5 = new MMX2BluetoothDiagServiceReplyProxy$5(this, l);
        this.proxy.remoteCallMethod((short)10, mMX2BluetoothDiagServiceReplyProxy$5);
    }

    @Override
    public void requestConnectedBtDevices(long l) {
        MMX2BluetoothDiagServiceReplyProxy$6 mMX2BluetoothDiagServiceReplyProxy$6 = new MMX2BluetoothDiagServiceReplyProxy$6(this, l);
        this.proxy.remoteCallMethod((short)7, mMX2BluetoothDiagServiceReplyProxy$6);
    }

    @Override
    public void requestConnectedBtDevice(long l, short s) {
        MMX2BluetoothDiagServiceReplyProxy$7 mMX2BluetoothDiagServiceReplyProxy$7 = new MMX2BluetoothDiagServiceReplyProxy$7(this, l, s);
        this.proxy.remoteCallMethod((short)6, mMX2BluetoothDiagServiceReplyProxy$7);
    }

    @Override
    public void requestAutoConnectBtHandset(long l, int n) {
        MMX2BluetoothDiagServiceReplyProxy$8 mMX2BluetoothDiagServiceReplyProxy$8 = new MMX2BluetoothDiagServiceReplyProxy$8(this, l, n);
        this.proxy.remoteCallMethod((short)0, mMX2BluetoothDiagServiceReplyProxy$8);
    }

    @Override
    public void requestBtDeleteLinkKeys(long l, int n, int n2) {
        MMX2BluetoothDiagServiceReplyProxy$9 mMX2BluetoothDiagServiceReplyProxy$9 = new MMX2BluetoothDiagServiceReplyProxy$9(this, l, n, n2);
        this.proxy.remoteCallMethod((short)34, mMX2BluetoothDiagServiceReplyProxy$9);
    }

    @Override
    public void requestBtDeviceSearch(long l, short s, short s2) {
        MMX2BluetoothDiagServiceReplyProxy$10 mMX2BluetoothDiagServiceReplyProxy$10 = new MMX2BluetoothDiagServiceReplyProxy$10(this, l, s, s2);
        this.proxy.remoteCallMethod((short)5, mMX2BluetoothDiagServiceReplyProxy$10);
    }

    @Override
    public void requestConnectionToLastBtDevice(long l, short s, short s2) {
        MMX2BluetoothDiagServiceReplyProxy$11 mMX2BluetoothDiagServiceReplyProxy$11 = new MMX2BluetoothDiagServiceReplyProxy$11(this, l, s, s2);
        this.proxy.remoteCallMethod((short)8, mMX2BluetoothDiagServiceReplyProxy$11);
    }
}

