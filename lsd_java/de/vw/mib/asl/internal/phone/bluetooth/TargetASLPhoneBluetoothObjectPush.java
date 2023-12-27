/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.bluetooth;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.internal.framework.dsi.util.RuntimeGeneratedConstants;
import de.vw.mib.asl.internal.phone.targets.abstracts.AbstractASLPhoneTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.bluetooth.DSIObjectPush;

public class TargetASLPhoneBluetoothObjectPush
extends AbstractASLPhoneTarget {
    public static final String[] NEEDED_PHONE_DSIS = new String[]{RuntimeGeneratedConstants.SERVICE_TS_NS[10]};
    protected DSIObjectPush dsiObjectPush;
    protected DSIListener objectPushListener;
    String btDeviceAddressObjectPush;
    private boolean alreadyRegistered = false;
    static /* synthetic */ Class class$org$dsi$ifc$bluetooth$DSIObjectPush;
    static /* synthetic */ Class class$org$dsi$ifc$bluetooth$DSIObjectPushListener;

    public TargetASLPhoneBluetoothObjectPush(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getDefaultTargetId() {
        return 5267;
    }

    protected void init() {
        if (!this.alreadyRegistered) {
            DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            this.dsiObjectPush = (DSIObjectPush)dSIProxy.getService(this, class$org$dsi$ifc$bluetooth$DSIObjectPush == null ? (class$org$dsi$ifc$bluetooth$DSIObjectPush = TargetASLPhoneBluetoothObjectPush.class$("org.dsi.ifc.bluetooth.DSIObjectPush")) : class$org$dsi$ifc$bluetooth$DSIObjectPush);
            this.objectPushListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$bluetooth$DSIObjectPushListener == null ? (class$org$dsi$ifc$bluetooth$DSIObjectPushListener = TargetASLPhoneBluetoothObjectPush.class$("org.dsi.ifc.bluetooth.DSIObjectPushListener")) : class$org$dsi$ifc$bluetooth$DSIObjectPushListener);
        }
        this.alreadyRegistered = true;
    }

    private void setNotification() {
        this.dsiObjectPush.setNotification(1, this.objectPushListener);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.init();
                this.setNotification();
                break;
            }
        }
    }

    public void dsiObjectPushUpdateOPPIncomingObject(String string, String string2, int n, int n2) {
        this.btDeviceAddressObjectPush = string;
        this.dsiObjectPush.requestOPPAcceptObject(string, true);
        TargetASLPhoneBluetoothObjectPush.writeStringToDatapool(-410839808, string2);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

