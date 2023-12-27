/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.bluetooth;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.framework.speller.ASLAPISpellerBinding;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.dsi.util.RuntimeGeneratedConstants;
import de.vw.mib.asl.internal.phone.ASLPhoneData;
import de.vw.mib.asl.internal.phone.targets.abstracts.AbstractASLPhoneTarget;
import de.vw.mib.asl.internal.phone.util.PhoneUtil;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.util.StringUtil;
import de.vw.mib.util.Util;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.bluetooth.DSIBluetooth;
import org.dsi.ifc.bluetooth.PasskeyStateStruct;

public class TargetASLPhoneBluetoothPasskey
extends AbstractASLPhoneTarget {
    public static final String[] NEEDED_PHONE_DSIS = new String[]{RuntimeGeneratedConstants.SERVICE_TS_NS[8]};
    protected DSIBluetooth dsiBluetooth;
    protected DSIListener bluetoothListener;
    private ASLAPISpellerBinding spellerHsm;
    String deviceAddressDisplayedPasskey;
    private PasskeyStateStruct passkeyStateStruct;
    private boolean isSSPJustWorksRequested = false;
    private boolean isBtBondingThresholdExceeded = false;
    private String passKey = "";
    private boolean alreadyRegistered = false;
    static /* synthetic */ Class class$org$dsi$ifc$bluetooth$DSIBluetooth;
    static /* synthetic */ Class class$org$dsi$ifc$bluetooth$DSIBluetoothListener;

    public TargetASLPhoneBluetoothPasskey(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getDefaultTargetId() {
        return 5258;
    }

    protected void init() {
        if (!this.alreadyRegistered) {
            DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            this.dsiBluetooth = (DSIBluetooth)dSIProxy.getService(this, class$org$dsi$ifc$bluetooth$DSIBluetooth == null ? (class$org$dsi$ifc$bluetooth$DSIBluetooth = TargetASLPhoneBluetoothPasskey.class$("org.dsi.ifc.bluetooth.DSIBluetooth")) : class$org$dsi$ifc$bluetooth$DSIBluetooth);
            this.bluetoothListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$bluetooth$DSIBluetoothListener == null ? (class$org$dsi$ifc$bluetooth$DSIBluetoothListener = TargetASLPhoneBluetoothPasskey.class$("org.dsi.ifc.bluetooth.DSIBluetoothListener")) : class$org$dsi$ifc$bluetooth$DSIBluetoothListener);
            dSIProxy.addResponseListener(this, class$org$dsi$ifc$bluetooth$DSIBluetoothListener == null ? (class$org$dsi$ifc$bluetooth$DSIBluetoothListener = TargetASLPhoneBluetoothPasskey.class$("org.dsi.ifc.bluetooth.DSIBluetoothListener")) : class$org$dsi$ifc$bluetooth$DSIBluetoothListener, this.bluetoothListener);
            this.addObserver(-1996292032);
            this.addObserver(-1962737600);
            this.addObserver(-1945960384);
            this.addObserver(-1895628736);
            this.addObserver(-1878851520);
            this.addObserver(-2080178112);
            this.addObserver(-2046623680);
            this.addObserver(-2029846464);
            this.addObserver(1879244864);
            this.addObserver(2063794240);
            this.addObserver(530399488);
            this.addObserver(-799271616);
            this.addObserver(-1979514816);
            this.addObserver(-1912405952);
            this.spellerHsm = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLAPISpellerFactory().createSimpleCursor(1144, -799271616, -1979514816, -1912405952);
        }
        this.alreadyRegistered = true;
    }

    private void setNotification() {
        this.dsiBluetooth.setNotification(7, this.bluetoothListener);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.init();
                this.setNotification();
                break;
            }
            case 1073742704: {
                if (!this.isSSPJustWorksRequested) break;
                this.submitPassKey("");
                break;
            }
            case 1073742715: {
                if (!this.isSSPJustWorksRequested) break;
                this.rejectPassKey("");
                break;
            }
            case 4300063: {
                this.isBtBondingThresholdExceeded = eventGeneric.getBoolean(0);
                if (this.isBtBondingThresholdExceeded || !ASLPhoneData.getInstance().isWaitingForPasskeyResponse || this.passKey.equals("")) break;
                this.submitPassKey(this.passKey);
                break;
            }
            case 1073742731: 
            case 1073742732: {
                this.spellerHsm.resetSpellerData();
                break;
            }
            case 1073742727: {
                this.submitPassKey(this.passkeyStateStruct.btPasskey);
                break;
            }
            case 1073742735: 
            case 1073742736: {
                String string = this.spellerHsm.getSpellerData().getEnteredText();
                this.submitPassKey(StringUtil.replaceAll(string, " ", ""));
                break;
            }
            case 3600020: {
                this.dsiBluetoothResponsePasskeyResponse(eventGeneric.getString(0), eventGeneric.getString(1), eventGeneric.getInt(2));
                break;
            }
            case 3600021: {
                this.rejectPassKey(this.passkeyStateStruct.getBtPasskey());
                break;
            }
            case 1073742730: 
            case 1073742734: 
            case 1075141840: {
                this.spellerHsm.handleEvent(eventGeneric);
                break;
            }
        }
    }

    private void handlePassKeyState() {
        String string = Util.isNullOrEmpty(this.passkeyStateStruct.btDeviceName) ? this.passkeyStateStruct.btDeviceAddress : this.passkeyStateStruct.btDeviceName;
        TargetASLPhoneBluetoothPasskey.writeStringToDatapool(1120, string);
        switch (this.passkeyStateStruct.btPasskeyState) {
            case 1: {
                TargetASLPhoneBluetoothPasskey.writeIntegerToDatapool(1125, 1);
                this.deviceAddressDisplayedPasskey = this.passkeyStateStruct.btDeviceAddress;
                if (!ASLPhoneData.getInstance().addressOfOngoingConnectionRequest.equals(this.passkeyStateStruct.btDeviceAddress)) {
                    ASLPhoneData.getInstance().isWaitingForPasskeyResponse = true;
                    EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-1813105152);
                    eventGeneric.setString(0, this.deviceAddressDisplayedPasskey);
                    eventGeneric.setString(1, this.passkeyStateStruct.btDeviceName);
                    this.send(eventGeneric);
                    break;
                }
                this.sendHMIEvent(131);
                break;
            }
            case 0: {
                TargetASLPhoneBluetoothPasskey.writeIntegerToDatapool(1125, 0);
                this.isSSPJustWorksRequested = false;
                ASLPhoneData.getInstance().isWaitingForPasskeyResponse = false;
                break;
            }
            case 4: {
                PhoneUtil.setBTBondingError(0, this.passkeyStateStruct.btDeviceAddress, this.passkeyStateStruct.btDeviceName, 4);
                this.sendHMIEvent(130);
                this.sendHMIEvent(133);
                ASLPhoneData.getInstance().isWaitingForPasskeyResponse = false;
                break;
            }
            case 5: {
                PhoneUtil.setBTBondingError(0, this.passkeyStateStruct.btDeviceAddress, this.passkeyStateStruct.btDeviceName, 3);
                this.sendHMIEvent(130);
                this.sendHMIEvent(133);
                this.isSSPJustWorksRequested = false;
                ASLPhoneData.getInstance().isWaitingForPasskeyResponse = false;
                break;
            }
            case 3: {
                PhoneUtil.setBTBondingError(0, this.passkeyStateStruct.btDeviceAddress, this.passkeyStateStruct.btDeviceName, 1);
                this.sendHMIEvent(130);
                this.sendHMIEvent(133);
                break;
            }
            case 2: {
                TargetASLPhoneBluetoothPasskey.writeIntegerToDatapool(1127, 0);
                if (!ASLPhoneData.getInstance().addressOfOngoingConnectionRequest.equals(this.passkeyStateStruct.btDeviceAddress)) {
                    this.sendHMIEvent(144);
                    if (this.isTraceEnabled()) {
                        this.trace().append("BLUETOOTH_EXTERNAL_REQUEST sent!").log();
                    }
                }
                this.displayPasskey();
                if (!this.isBtBondingThresholdExceeded) {
                    this.submitPassKey(this.passkeyStateStruct.getBtPasskey());
                    break;
                }
                ASLPhoneData.getInstance().isWaitingForPasskeyResponse = true;
                this.passKey = this.passkeyStateStruct.getBtPasskey();
                break;
            }
            case 7: {
                TargetASLPhoneBluetoothPasskey.writeIntegerToDatapool(1127, 1);
                this.deviceAddressDisplayedPasskey = this.passkeyStateStruct.btDeviceAddress;
                if (!ASLPhoneData.getInstance().addressOfOngoingConnectionRequest.equals(this.passkeyStateStruct.btDeviceAddress)) {
                    ASLPhoneData.getInstance().isWaitingForPasskeyResponse = true;
                    EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-1813105152);
                    eventGeneric.setString(0, this.deviceAddressDisplayedPasskey);
                    eventGeneric.setString(1, this.passkeyStateStruct.btDeviceName);
                    this.send(eventGeneric);
                    TargetASLPhoneBluetoothPasskey.writeIntegerToDatapool(1125, 2);
                    TargetASLPhoneBluetoothPasskey.writeStringToDatapool(1124, this.formatBluetoothPasskey(this.passkeyStateStruct.btPasskey));
                    break;
                }
                this.info("BLUETOOTH_EXTERNAL_REQUEST not sent to model (SSP_Show_and_Confirm) due to btDeviceAddress match!");
                ASLPhoneData.getInstance().isWaitingForPasskeyResponse = true;
                this.displayPasskey();
                break;
            }
            case 8: {
                TargetASLPhoneBluetoothPasskey.writeIntegerToDatapool(1127, 0);
                this.deviceAddressDisplayedPasskey = this.passkeyStateStruct.btDeviceAddress;
                TargetASLPhoneBluetoothPasskey.writeIntegerToDatapool(1125, 0);
                if (ASLPhoneData.getInstance().requestedService != 1) {
                    this.submitPassKey("");
                    TargetASLPhoneBluetoothPasskey.writeIntegerToDatapool(1125, 0);
                    this.sendHMIEvent(131);
                    break;
                }
                ASLPhoneData.getInstance().isWaitingForPasskeyResponse = true;
                this.sendHMIEvent(144);
                if (this.isTraceEnabled()) {
                    this.trace().append("BLUETOOTH_EXTERNAL_REQUEST sent!").log();
                }
                this.isSSPJustWorksRequested = true;
                break;
            }
            case 6: {
                TargetASLPhoneBluetoothPasskey.writeIntegerToDatapool(1127, 2);
                TargetASLPhoneBluetoothPasskey.writeIntegerToDatapool(1125, 2);
                TargetASLPhoneBluetoothPasskey.writeStringToDatapool(1124, this.formatBluetoothPasskey(this.passkeyStateStruct.btPasskey));
                this.deviceAddressDisplayedPasskey = this.passkeyStateStruct.btDeviceAddress;
                if (!ASLPhoneData.getInstance().addressOfOngoingConnectionRequest.equals(this.passkeyStateStruct.btDeviceAddress)) {
                    this.sendHMIEvent(144);
                    if (this.isTraceEnabled()) {
                        this.trace().append("BLUETOOTH_EXTERNAL_REQUEST sent!").log();
                    }
                    this.sendHMIEvent(131);
                    break;
                }
                this.displayPasskey();
                break;
            }
        }
    }

    private void displayPasskey() {
        TargetASLPhoneBluetoothPasskey.writeIntegerToDatapool(1125, 2);
        this.deviceAddressDisplayedPasskey = this.passkeyStateStruct.btDeviceAddress;
        TargetASLPhoneBluetoothPasskey.writeStringToDatapool(1124, this.formatBluetoothPasskey(this.passkeyStateStruct.btPasskey));
        this.sendHMIEvent(131);
    }

    private void submitPassKey(String string) {
        this.dsiBluetooth.requestPasskeyResponse(string, this.deviceAddressDisplayedPasskey, 1);
        ASLPhoneData.getInstance().isWaitingForPasskeyResponse = false;
        this.passKey = "";
        TargetASLPhoneBluetoothPasskey.writeStringToDatapool(1124, this.formatBluetoothPasskey(string));
    }

    private void rejectPassKey(String string) {
        this.dsiBluetooth.requestPasskeyResponse(string, this.deviceAddressDisplayedPasskey, 0);
        ASLPhoneData.getInstance().isWaitingForPasskeyResponse = false;
        this.passKey = "";
    }

    String formatBluetoothPasskey(String string) {
        if (string.length() == 16) {
            return new StringBuffer().append(string.substring(0, 4)).append(" ").append(string.substring(4, 8)).append(" ").append(string.substring(8, 12)).append(" ").append(string.substring(12, 16)).toString();
        }
        if (string.length() == 6) {
            return new StringBuffer().append(string.substring(0, 3)).append(" ").append(string.substring(3, 6)).toString();
        }
        return string;
    }

    public void dsiBluetoothUpdatePasskeyState(PasskeyStateStruct passkeyStateStruct, int n) {
        this.passkeyStateStruct = passkeyStateStruct;
        this.handlePassKeyState();
    }

    public void dsiBluetoothResponsePasskeyResponse(String string, String string2, int n) {
        PhoneUtil.setBTBondingError(0, string, string2, PhoneUtil.convertBTErrorCodesDSI2ASL(n));
        if (n != 0) {
            this.sendHMIEvent(130);
        } else {
            this.sendHMIEvent(138);
        }
    }

    public void dsiBluetoothAsyncException(int n, String string, int n2) {
        if (n2 == 1009) {
            this.dsiBluetoothResponsePasskeyResponse(this.passkeyStateStruct.btDeviceAddress, this.passkeyStateStruct.btDeviceName, 5);
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

