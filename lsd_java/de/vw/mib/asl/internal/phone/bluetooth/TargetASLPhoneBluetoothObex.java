/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.bluetooth;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.framework.speller.ASLAPISpellerBinding;
import de.vw.mib.asl.framework.internal.framework.dsi.util.RuntimeGeneratedConstants;
import de.vw.mib.asl.internal.phone.targets.abstracts.AbstractASLPhoneTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.bluetooth.DSIObexAuthentication;

public class TargetASLPhoneBluetoothObex
extends AbstractASLPhoneTarget {
    public static final String[] NEEDED_PHONE_DSIS = new String[]{RuntimeGeneratedConstants.SERVICE_TS_NS[9]};
    protected DSIObexAuthentication dsiObexAuthentication;
    private ASLAPISpellerBinding spellerPIN;
    private ASLAPISpellerBinding spellerUserId;
    private String userId;
    private int service;
    private boolean alreadyRegistered = false;
    static /* synthetic */ Class class$org$dsi$ifc$bluetooth$DSIObexAuthentication;
    static /* synthetic */ Class class$org$dsi$ifc$bluetooth$DSIObexAuthenticationListener;

    public TargetASLPhoneBluetoothObex(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getDefaultTargetId() {
        return 5266;
    }

    protected void init() {
        if (!this.alreadyRegistered) {
            DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            this.dsiObexAuthentication = (DSIObexAuthentication)dSIProxy.getService(this, class$org$dsi$ifc$bluetooth$DSIObexAuthentication == null ? (class$org$dsi$ifc$bluetooth$DSIObexAuthentication = TargetASLPhoneBluetoothObex.class$("org.dsi.ifc.bluetooth.DSIObexAuthentication")) : class$org$dsi$ifc$bluetooth$DSIObexAuthentication);
            DSIListener dSIListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$bluetooth$DSIObexAuthenticationListener == null ? (class$org$dsi$ifc$bluetooth$DSIObexAuthenticationListener = TargetASLPhoneBluetoothObex.class$("org.dsi.ifc.bluetooth.DSIObexAuthenticationListener")) : class$org$dsi$ifc$bluetooth$DSIObexAuthenticationListener);
            dSIProxy.addResponseListener(this, class$org$dsi$ifc$bluetooth$DSIObexAuthenticationListener == null ? (class$org$dsi$ifc$bluetooth$DSIObexAuthenticationListener = TargetASLPhoneBluetoothObex.class$("org.dsi.ifc.bluetooth.DSIObexAuthenticationListener")) : class$org$dsi$ifc$bluetooth$DSIObexAuthenticationListener, dSIListener);
            this.addObserver(-1862074304);
            this.addObserver(-1828519872);
            this.addObserver(-1811742656);
            this.addObserver(-1761411008);
            this.addObserver(-1744633792);
            this.addObserver(-1711079360);
            this.addObserver(-1694302144);
            this.addObserver(-1643970496);
            this.addObserver(-782494400);
            this.addObserver(-1845297088);
            this.addObserver(-1778188224);
            this.addObserver(-765717184);
            this.addObserver(-1727856576);
            this.addObserver(-1660747712);
            this.spellerPIN = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLAPISpellerFactory().createSimpleCursor(1145, -782494400, -1845297088, -1778188224);
            this.spellerUserId = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLAPISpellerFactory().createSimpleCursor(1146, -765717184, -1727856576, -1660747712);
        }
        this.alreadyRegistered = true;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.init();
                break;
            }
            case 1073742740: {
                this.spellerPIN.resetSpellerData();
                break;
            }
            case 1073742739: {
                this.spellerPIN.resetSpellerData();
                break;
            }
            case 1073742747: {
                this.spellerUserId.resetSpellerData();
                break;
            }
            case 1073742746: {
                this.spellerUserId.resetSpellerData();
                break;
            }
            case 1073742750: {
                this.userId = this.spellerUserId.getSpellerData().getEnteredText();
                break;
            }
            case 1073742743: {
                this.dsiObexAuthentication.setAuthenticationInfo(this.service, this.userId, this.spellerPIN.getSpellerData().getEnteredText());
                break;
            }
            case 1073742738: 
            case 1073742742: 
            case 1075141841: {
                this.spellerPIN.handleEvent(eventGeneric);
                break;
            }
            case 1073742745: 
            case 1073742749: 
            case 1075141842: {
                this.spellerUserId.handleEvent(eventGeneric);
                break;
            }
        }
    }

    public void dsiObexAuthenticationAuthenticationRequired(int n, boolean bl, String string) {
        this.service = n;
        if (!bl) {
            this.userId = "";
        }
        TargetASLPhoneBluetoothObex.writeBooleanToDatapool(1140, bl);
        TargetASLPhoneBluetoothObex.writeBooleanToDatapool(1136, true);
        this.sendHMIEvent(132);
    }

    public void dsiObexAuthenticationIndAuthentication(boolean bl) {
        if (bl) {
            this.sendHMIEvent(134);
        } else {
            this.sendHMIEvent(133);
        }
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

