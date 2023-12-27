/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.setup.bluetooth;

import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetComponents;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.framework.speller.ASLAPISpellerBinding;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.dsi.util.RuntimeGeneratedConstants;
import de.vw.mib.asl.internal.phone.ASLPhoneData;
import de.vw.mib.asl.internal.phone.bluetooth.ConnectedDevice;
import de.vw.mib.asl.internal.phone.setup.bluetooth.TargetASLPhoneBluetoothSetup$Reset;
import de.vw.mib.asl.internal.phone.targets.abstracts.AbstractASLPhoneTarget;
import de.vw.mib.asl.internal.phone.util.PhoneUtil;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.util.Util;
import generated.de.vw.mib.asl.internal.ListManager;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.bluetooth.DSIBluetooth;
import org.dsi.ifc.bluetooth.TrustedDevice;

public class TargetASLPhoneBluetoothSetup
extends AbstractASLPhoneTarget {
    public static final String[] NEEDED_PHONE_DSIS = new String[]{RuntimeGeneratedConstants.SERVICE_TS_NS[8]};
    protected DSIBluetooth dsiBluetooth;
    protected DSIListener dsiBluetoothListener;
    private ASLAPISpellerBinding spellerHsmBTName;
    private String userFriendlyName;
    private boolean isA2DPSupported = false;
    private boolean isA2DPUpdatedActive = false;
    private boolean isA2DPEnablingResultOK = false;
    private boolean removeAuthRequestedForAll = false;
    private boolean alreadyRegistered = false;
    private FactoryResetCallback factoryResetCallback = null;
    static /* synthetic */ Class class$org$dsi$ifc$bluetooth$DSIBluetooth;
    static /* synthetic */ Class class$org$dsi$ifc$bluetooth$DSIBluetoothListener;

    public TargetASLPhoneBluetoothSetup(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getDefaultTargetId() {
        return 5260;
    }

    protected void init() {
        if (!this.alreadyRegistered) {
            DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            this.dsiBluetooth = (DSIBluetooth)dSIProxy.getService(this, class$org$dsi$ifc$bluetooth$DSIBluetooth == null ? (class$org$dsi$ifc$bluetooth$DSIBluetooth = TargetASLPhoneBluetoothSetup.class$("org.dsi.ifc.bluetooth.DSIBluetooth")) : class$org$dsi$ifc$bluetooth$DSIBluetooth);
            this.dsiBluetoothListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$bluetooth$DSIBluetoothListener == null ? (class$org$dsi$ifc$bluetooth$DSIBluetoothListener = TargetASLPhoneBluetoothSetup.class$("org.dsi.ifc.bluetooth.DSIBluetoothListener")) : class$org$dsi$ifc$bluetooth$DSIBluetoothListener);
            dSIProxy.addResponseListener(this, class$org$dsi$ifc$bluetooth$DSIBluetoothListener == null ? (class$org$dsi$ifc$bluetooth$DSIBluetoothListener = TargetASLPhoneBluetoothSetup.class$("org.dsi.ifc.bluetooth.DSIBluetoothListener")) : class$org$dsi$ifc$bluetooth$DSIBluetoothListener, this.dsiBluetoothListener);
            this.addObserver(-553451456);
            this.addObserver(-536674240);
            this.addObserver(-519897024);
            this.addObserver(-1005977536);
            this.addObserver(-967043776);
            this.addObserver(11034944);
            this.addObserver(-402456512);
            this.addObserver(-419233728);
            this.addObserver(-452788160);
            this.addObserver(-352124864);
            this.addObserver(-681831104);
            this.addObserver(-436010944);
            this.addObserver(-368902080);
            this.addObserver(-503119808);
            this.spellerHsmBTName = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLAPISpellerFactory().createSimpleCursor(1205, -681831104, -436010944, -368902080);
            ASLSystemFactory.getSystemApi().getFactoryResetService().addParticipant(new TargetASLPhoneBluetoothSetup$Reset(this, null), FactoryResetComponents.PHONE);
        }
        this.alreadyRegistered = true;
    }

    private void setNotification() {
        this.dsiBluetooth.setNotification(new int[]{16, 1, 9, 12}, this.dsiBluetoothListener);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.init();
                this.setNotification();
                break;
            }
            case 1073742817: {
                ConnectedDevice[] connectedDeviceArray = (ConnectedDevice[])ListManager.getGenericASLList(1204).getDSIObjects();
                int n = eventGeneric.getInt(0);
                ConnectedDevice connectedDevice = connectedDeviceArray[n];
                TrustedDevice trustedDevice = connectedDevice.device;
                ASLPhoneData.getInstance().selectedDeviceMAC = trustedDevice.deviceAddress;
                ASLPhoneData.getInstance().selectedDeviceName = trustedDevice.deviceName;
                TargetASLPhoneBluetoothSetup.writeStringToDatapool(1120, trustedDevice.deviceName);
                ListManager.getGenericASLList(1141).updateList(PhoneUtil.getProfilesFromServiceList(connectedDevice.device.offeredServiceTypes, trustedDevice.deviceAddress, ASLPhoneData.getInstance().deviceTypePairedDevicesFilter));
                AbstractASLHsmTarget.writeBooleanToDatapool(243537152, true);
                break;
            }
            case 1073742815: {
                this.removeAuthRequestedForAll = true;
                this.dsiBluetooth.requestRemoveAuthentication(null);
                break;
            }
            case 1073742816: {
                int n = eventGeneric.getInt(0);
                ConnectedDevice[] connectedDeviceArray = (ConnectedDevice[])ListManager.getGenericASLList(1204).getDSIObjects();
                this.removeAuthRequestedForAll = false;
                this.dsiBluetooth.requestRemoveAuthentication(connectedDeviceArray[n].device.deviceAddress);
                break;
            }
            case 1075141830: {
                int n = eventGeneric.getInt(0);
                this.dsiBluetooth.setAccessibleMode(this.convertVisibilityASL2DSI(n));
                break;
            }
            case 1080141824: {
                int n = eventGeneric.getInt(0);
                this.dsiBluetooth.setAccessibleMode(this.convertVisibilityASL2DSI(n));
                break;
            }
            case 1073744580: {
                ASLPhoneData.getInstance().deviceTypePairedDevicesFilter = eventGeneric.getInt(0);
                PhoneUtil.filterBluetoothPairedDeviceList();
                break;
            }
            case 1073742823: 
            case 1073742824: {
                this.spellerHsmBTName.initSpeller(this.userFriendlyName);
                break;
            }
            case 1073742827: {
                String string = this.spellerHsmBTName.getSpellerData().getEnteredText();
                this.dsiBluetooth.setUserFriendlyName(string);
                break;
            }
            case 1073742818: {
                boolean bl = eventGeneric.getBoolean(0);
                if (bl) {
                    this.isA2DPEnablingResultOK = false;
                    this.isA2DPSupported = false;
                    this.isA2DPUpdatedActive = false;
                }
                this.dsiBluetooth.requestSetA2DPUserSetting(bl);
                break;
            }
            case 1073742822: 
            case 1073742826: 
            case 1075141847: {
                this.spellerHsmBTName.handleEvent(eventGeneric);
                break;
            }
        }
    }

    private int convertVisibilityASL2DSI(int n) {
        switch (n) {
            case 0: {
                return 3;
            }
            case 1: {
                return 4;
            }
        }
        return -1;
    }

    private void sendA2DPEnabled() {
        if (this.isA2DPEnablingResultOK && this.isA2DPSupported && this.isA2DPUpdatedActive) {
            this.sendHMIEvent(485);
        }
    }

    public void dsiBluetoothUpdateAccessibleMode(int n, boolean bl, int n2) {
        TargetASLPhoneBluetoothSetup.writeIntegerToDatapool(-612166400, bl ? 1 : 0);
    }

    public void dsiBluetoothUpdateUserFriendlyName(String string, int n) {
        this.userFriendlyName = string;
        TargetASLPhoneBluetoothSetup.writeStringToDatapool(1199, this.userFriendlyName);
        TargetASLPhoneBluetoothSetup.writeStringToDatapool(298803456, this.userFriendlyName);
    }

    public void dsiBluetoothUpdateA2DPUserSetting(boolean bl, int n) {
        TargetASLPhoneBluetoothSetup.writeBooleanToDatapool(1202, bl);
        ASLPhoneData.getInstance().a2DPEnabled = bl;
        if (bl) {
            this.isA2DPUpdatedActive = true;
            this.sendA2DPEnabled();
        }
    }

    public void dsiBluetoothUpdateSupportedBTProfiles(int n, int n2) {
        ASLPhoneData.getInstance().supportedProfiles = n;
        TargetASLPhoneBluetoothSetup.writeBooleanToDatapool(-545057536, Util.isBitSet(4, n));
        if (Util.isBitSet(256, n)) {
            this.isA2DPSupported = true;
            this.sendA2DPEnabled();
        }
    }

    public void dsiBluetoothResponseRemoveAuthentication(String string, String string2, int n) {
        if (n == 0) {
            if (Util.isNullOrEmpty(string)) {
                this.sendHMIEvent(177);
            } else {
                this.sendHMIEvent(179);
            }
        } else if (Util.isNullOrEmpty(string)) {
            this.sendHMIEvent(176);
        } else {
            this.sendHMIEvent(178);
        }
    }

    public void dsiBluetoothResponseSetA2DPUserSetting(int n) {
        if (n == 0) {
            this.isA2DPEnablingResultOK = true;
            this.sendA2DPEnabled();
        } else {
            this.sendHMIEvent(486);
        }
    }

    public void dsiBluetoothResponseRestoreFactorySettings(int n) {
        ASLPhoneData.getInstance().isBTFactoryResetRequested = false;
        if (this.factoryResetCallback != null) {
            this.factoryResetCallback.notifyResetDone();
            this.factoryResetCallback = null;
        }
    }

    public void dsiBluetoothAsyncException(int n, String string, int n2) {
        if (n2 == 1014) {
            ASLPhoneData.getInstance().isBTFactoryResetRequested = false;
        } else if (n2 == 1010) {
            if (this.removeAuthRequestedForAll) {
                this.sendHMIEvent(176);
            } else {
                this.sendHMIEvent(178);
            }
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

    static /* synthetic */ FactoryResetCallback access$102(TargetASLPhoneBluetoothSetup targetASLPhoneBluetoothSetup, FactoryResetCallback factoryResetCallback) {
        targetASLPhoneBluetoothSetup.factoryResetCallback = factoryResetCallback;
        return targetASLPhoneBluetoothSetup.factoryResetCallback;
    }
}

