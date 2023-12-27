/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.phone.ASLPhoneData;
import de.vw.mib.asl.internal.phone.TargetASLPhoneGetter$NadListener;
import de.vw.mib.asl.internal.phone.TargetASLPhoneGetter$PrimaryListener;
import de.vw.mib.asl.internal.phone.contacts.PhoneSearchFetcher;
import de.vw.mib.asl.internal.phone.util.PhoneUtil;
import de.vw.mib.asl.internal.phone.util.TripleMobileEquipment;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.util.Util;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.bluetooth.DSIBluetooth;
import org.dsi.ifc.organizer.DSIAdbList;
import org.dsi.ifc.organizer.DataSet;
import org.dsi.ifc.telephoneng.DSIMobileEquipmentListener;
import org.dsi.ifc.telephoneng.RegisterStateStruct;
import org.dsi.ifc.telephoneng.ServiceProvider;

public class TargetASLPhoneGetter
extends TripleMobileEquipment {
    DSIAdbList dsiAdbList;
    DSIBluetooth dsiBluetooth;
    DSIListener dsiBluetoothListener;
    DSIListener dsiAdbListListener;
    private static final int SIGNAL_QUALITY_INVALID;
    private String networkProviderName;
    private String serviceProviderName;
    private boolean displayServiceProviderName = false;
    private int registerState = 0;
    private int networkType = 0;
    protected static final int BATTERYCHARGELEVEL_TIMER_INTERVAL;
    protected static final int EV_INTERNAL_BATTERYCHARGELEVEL_TIMER;
    protected static final int EV_INTERNAL_BATTERYCHARGELEVEL_TIMER_P0_BATTERYCHARGELEVEL_INT;
    private long tempEntryId = -1L;
    private boolean alreadyRegistered = false;
    static /* synthetic */ Class class$org$dsi$ifc$bluetooth$DSIBluetooth;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbList;
    static /* synthetic */ Class class$org$dsi$ifc$bluetooth$DSIBluetoothListener;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbListListener;

    public TargetASLPhoneGetter(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getDefaultTargetId() {
        return 5250;
    }

    protected void init() {
        if (!this.alreadyRegistered) {
            DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            this.dsiBluetooth = (DSIBluetooth)dSIProxy.getService(this, class$org$dsi$ifc$bluetooth$DSIBluetooth == null ? (class$org$dsi$ifc$bluetooth$DSIBluetooth = TargetASLPhoneGetter.class$("org.dsi.ifc.bluetooth.DSIBluetooth")) : class$org$dsi$ifc$bluetooth$DSIBluetooth);
            this.dsiAdbList = (DSIAdbList)dSIProxy.getService(this, class$org$dsi$ifc$organizer$DSIAdbList == null ? (class$org$dsi$ifc$organizer$DSIAdbList = TargetASLPhoneGetter.class$("org.dsi.ifc.organizer.DSIAdbList")) : class$org$dsi$ifc$organizer$DSIAdbList, 1);
            this.dsiBluetoothListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$bluetooth$DSIBluetoothListener == null ? (class$org$dsi$ifc$bluetooth$DSIBluetoothListener = TargetASLPhoneGetter.class$("org.dsi.ifc.bluetooth.DSIBluetoothListener")) : class$org$dsi$ifc$bluetooth$DSIBluetoothListener);
            this.dsiAdbListListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$organizer$DSIAdbListListener == null ? (class$org$dsi$ifc$organizer$DSIAdbListListener = TargetASLPhoneGetter.class$("org.dsi.ifc.organizer.DSIAdbListListener")) : class$org$dsi$ifc$organizer$DSIAdbListListener);
            dSIProxy.addResponseListener(this, class$org$dsi$ifc$organizer$DSIAdbListListener == null ? (class$org$dsi$ifc$organizer$DSIAdbListListener = TargetASLPhoneGetter.class$("org.dsi.ifc.organizer.DSIAdbListListener")) : class$org$dsi$ifc$organizer$DSIAdbListListener, 1, this.dsiAdbListListener);
            this.addObserver(-1628555776);
        }
        this.alreadyRegistered = true;
    }

    @Override
    protected int[] getMobileEquipmentNotification() {
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(73)) {
            return new int[]{24, 27, 7, 29, 32, 4};
        }
        return ASLPhoneData.EMPTY_NOTIFICATION;
    }

    @Override
    protected int[] getMobileEquipmentNadOnlyNotification() {
        return new int[]{22};
    }

    @Override
    protected void pendingTopologyChange(int[] nArray, int[] nArray2) {
        if (nArray != null && nArray[0] != nArray2[0]) {
            this.getPrimaryListener().updateBatteryChargeLevel(255, 1);
            this.getPrimaryListener().updateServiceProvider(new ServiceProvider(false, false, ""), 1);
            this.getPrimaryListener().updateRegisterState(new RegisterStateStruct(0, "", "", 1), 1);
        }
    }

    @Override
    protected int[] getMobileEquipmentHfpOnlyNotification() {
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(73)) {
            return ASLPhoneData.EMPTY_NOTIFICATION;
        }
        return new int[]{24, 27, 7};
    }

    private void setNotification() {
        this.dsiBluetooth.setNotification(new int[]{1}, this.dsiBluetoothListener);
    }

    @Override
    protected void powerOn() {
        this.init();
        this.setNotification();
    }

    @Override
    public void handleEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 3600016: {
                this.tempEntryId = eventGeneric.getLong(0);
                if (PhoneSearchFetcher.spellerHandle > -1) {
                    this.dsiAdbList.getSpellerViewWindow(PhoneSearchFetcher.spellerHandle, eventGeneric.getLong(0), 0, 1, 1);
                    break;
                }
                this.dsiAdbList.getViewWindow(eventGeneric.getLong(0), 0, 1, 1);
                break;
            }
            case 100000: {
                int n = eventGeneric.getInt(0);
                if (n != 255) {
                    int n2 = this.convertBatteryChargeLevel(n);
                    TargetASLPhoneGetter.writeIntegerToDatapool(-595389184, n2);
                    if (n == 0) {
                        this.sendHMIEvent(128);
                        TargetASLPhoneGetter.writeIntegerToDatapool(1099, 1);
                        break;
                    }
                    this.sendHMIEvent(129);
                    TargetASLPhoneGetter.writeIntegerToDatapool(1099, 0);
                    break;
                }
                TargetASLPhoneGetter.writeIntegerToDatapool(-595389184, 0);
                break;
            }
            case 1080441847: {
                TargetASLPhoneGetter.writeBooleanToDatapool(461640960, eventGeneric.getBoolean(0));
                break;
            }
            case 3600030: {
                TargetASLPhoneGetter.writeIntegerToDatapool(-595389184, 0);
                this.stopTimer(-1601830656);
                break;
            }
        }
    }

    private int convertSignalStrength(int n) {
        if (n == 0) {
            return 0;
        }
        if (n < 21) {
            return 1;
        }
        if (n < 41) {
            return 2;
        }
        if (n < 61) {
            return 3;
        }
        if (n < 81) {
            return 4;
        }
        if (n < 101) {
            return 5;
        }
        return n;
    }

    private int convertBatteryChargeLevel(int n) {
        switch (n) {
            case 0: {
                return 1;
            }
            case 1: {
                return 2;
            }
            case 2: {
                return 3;
            }
            case 3: {
                return 4;
            }
            case 4: {
                return 5;
            }
            case 5: {
                return 5;
            }
        }
        return 0;
    }

    public void dsiAdbListGetViewWindowResult(int n, DataSet[] dataSetArray, int n2) {
        if (n == 0) {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(5250, 5261, -1846659584);
            eventGeneric.setObject(0, dataSetArray[0]);
            this.send(eventGeneric);
        }
    }

    public void dsiAdbListGetSpellerViewWindowResult(int n, int n2, DataSet[] dataSetArray, int n3) {
        if (n == 0 && !Util.isNullOrEmpty(dataSetArray)) {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(5250, 5261, -1846659584);
            eventGeneric.setObject(0, dataSetArray[0]);
            this.send(eventGeneric);
        } else {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(5250, 5268, -956104640);
            this.send(eventGeneric);
            EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent(5250, 5250, -1863436800);
            eventGeneric2.setLong(0, this.tempEntryId);
            this.send(eventGeneric2);
        }
    }

    public void setNetworkName() {
        TargetASLPhoneGetter.writeStringToDatapool(1084, this.displayServiceProviderName ? this.serviceProviderName : this.networkProviderName);
        TargetASLPhoneGetter.writeStringToDatapool(-211655168, this.displayServiceProviderName ? this.serviceProviderName : this.networkProviderName);
    }

    private void updateNetworkType() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        if (this.registerState == 1 || this.registerState == 2) {
            TargetASLPhoneGetter.writeIntegerToDatapool(1086, PhoneUtil.convertNetworkTypeDSI2ASL(this.networkType));
            eventGeneric.setBoolean(0, this.networkType != 0);
        } else {
            eventGeneric.setBoolean(0, false);
            TargetASLPhoneGetter.writeIntegerToDatapool(1086, 0);
        }
        this.triggerObserver(-1511115264, eventGeneric);
    }

    @Override
    protected DSIMobileEquipmentListener createPrimaryListener() {
        return new TargetASLPhoneGetter$PrimaryListener(this, null);
    }

    @Override
    protected DSIMobileEquipmentListener createNadListener() {
        return new TargetASLPhoneGetter$NadListener(this, null);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ boolean access$000(TargetASLPhoneGetter targetASLPhoneGetter) {
        return targetASLPhoneGetter.isNadPrimary();
    }

    static /* synthetic */ int access$102(TargetASLPhoneGetter targetASLPhoneGetter, int n) {
        targetASLPhoneGetter.networkType = n;
        return targetASLPhoneGetter.networkType;
    }

    static /* synthetic */ void access$200(TargetASLPhoneGetter targetASLPhoneGetter) {
        targetASLPhoneGetter.updateNetworkType();
    }

    static /* synthetic */ boolean access$302(TargetASLPhoneGetter targetASLPhoneGetter, boolean bl) {
        targetASLPhoneGetter.displayServiceProviderName = bl;
        return targetASLPhoneGetter.displayServiceProviderName;
    }

    static /* synthetic */ String access$402(TargetASLPhoneGetter targetASLPhoneGetter, String string) {
        targetASLPhoneGetter.serviceProviderName = string;
        return targetASLPhoneGetter.serviceProviderName;
    }

    static /* synthetic */ int access$502(TargetASLPhoneGetter targetASLPhoneGetter, int n) {
        targetASLPhoneGetter.registerState = n;
        return targetASLPhoneGetter.registerState;
    }

    static /* synthetic */ String access$602(TargetASLPhoneGetter targetASLPhoneGetter, String string) {
        targetASLPhoneGetter.networkProviderName = string;
        return targetASLPhoneGetter.networkProviderName;
    }

    static /* synthetic */ int access$700(TargetASLPhoneGetter targetASLPhoneGetter, int n) {
        return targetASLPhoneGetter.convertSignalStrength(n);
    }
}

