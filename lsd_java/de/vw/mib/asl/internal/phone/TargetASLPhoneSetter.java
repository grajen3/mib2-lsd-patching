/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone;

import de.vw.mib.asl.api.carplay.ASLCarPlayFactory;
import de.vw.mib.asl.api.phone.PhonePersistence;
import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetComponents;
import de.vw.mib.asl.api.system.valetparking.ValetParkingCallback;
import de.vw.mib.asl.api.system.valetparking.ValetParkingListener;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.phone.ASLPhoneData;
import de.vw.mib.asl.internal.phone.HsmPhonePhoneAvailability;
import de.vw.mib.asl.internal.phone.TargetASLPhoneSetter$1;
import de.vw.mib.asl.internal.phone.TargetASLPhoneSetter$Reset;
import de.vw.mib.asl.internal.phone.TargetASLPhoneSetter$ValetParkingListenerBT;
import de.vw.mib.asl.internal.phone.util.TripleMobileEquipment;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import edu.emory.mathcs.backport.java.util.Arrays;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.bluetooth.DSIBluetooth;
import org.dsi.ifc.telephoneng.DSIMobileEquipmentTopology;

public class TargetASLPhoneSetter
extends TripleMobileEquipment {
    DSIMobileEquipmentTopology dsiMobileEquipmentTopology;
    DSIBluetooth dsiBluetooth;
    DSIListener dsiMobileEquipmentTopologyListener;
    DSIListener dsiBluetoothListener;
    ValetParkingListener valetParkingListener;
    ValetParkingCallback valetParkingCallback;
    private static final int EV_INTERNAL_DIAL_SPELLER_TIMEOUT_COUNTDOWN;
    private static final int DIAL_SPELLER_TIMER_INTERVAL;
    int dialSpellerTimeout;
    static boolean isToggleOngoing;
    private boolean alreadyRegistered = false;
    private boolean btToBeRestored;
    private boolean disableNadAfterBtOff;
    private int[] usage;
    private int[] slots;
    private int btState;
    static /* synthetic */ Class class$org$dsi$ifc$telephoneng$DSIMobileEquipmentTopology;
    static /* synthetic */ Class class$org$dsi$ifc$bluetooth$DSIBluetooth;
    static /* synthetic */ Class class$org$dsi$ifc$telephoneng$DSIMobileEquipmentTopologyListener;
    static /* synthetic */ Class class$org$dsi$ifc$bluetooth$DSIBluetoothListener;

    public TargetASLPhoneSetter(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getDefaultTargetId() {
        return 5252;
    }

    protected void init() {
        if (!this.alreadyRegistered) {
            DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            this.dsiMobileEquipmentTopology = (DSIMobileEquipmentTopology)dSIProxy.getService(this, class$org$dsi$ifc$telephoneng$DSIMobileEquipmentTopology == null ? (class$org$dsi$ifc$telephoneng$DSIMobileEquipmentTopology = TargetASLPhoneSetter.class$("org.dsi.ifc.telephoneng.DSIMobileEquipmentTopology")) : class$org$dsi$ifc$telephoneng$DSIMobileEquipmentTopology);
            this.dsiBluetooth = (DSIBluetooth)dSIProxy.getService(this, class$org$dsi$ifc$bluetooth$DSIBluetooth == null ? (class$org$dsi$ifc$bluetooth$DSIBluetooth = TargetASLPhoneSetter.class$("org.dsi.ifc.bluetooth.DSIBluetooth")) : class$org$dsi$ifc$bluetooth$DSIBluetooth);
            this.dsiMobileEquipmentTopologyListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$telephoneng$DSIMobileEquipmentTopologyListener == null ? (class$org$dsi$ifc$telephoneng$DSIMobileEquipmentTopologyListener = TargetASLPhoneSetter.class$("org.dsi.ifc.telephoneng.DSIMobileEquipmentTopologyListener")) : class$org$dsi$ifc$telephoneng$DSIMobileEquipmentTopologyListener);
            this.dsiBluetoothListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$bluetooth$DSIBluetoothListener == null ? (class$org$dsi$ifc$bluetooth$DSIBluetoothListener = TargetASLPhoneSetter.class$("org.dsi.ifc.bluetooth.DSIBluetoothListener")) : class$org$dsi$ifc$bluetooth$DSIBluetoothListener);
            this.dsiBluetooth.setNotification(3, this.dsiBluetoothListener);
            dSIProxy.addResponseListener(this, class$org$dsi$ifc$telephoneng$DSIMobileEquipmentTopologyListener == null ? (class$org$dsi$ifc$telephoneng$DSIMobileEquipmentTopologyListener = TargetASLPhoneSetter.class$("org.dsi.ifc.telephoneng.DSIMobileEquipmentTopologyListener")) : class$org$dsi$ifc$telephoneng$DSIMobileEquipmentTopologyListener, this.dsiMobileEquipmentTopologyListener);
            dSIProxy.addResponseListener(this, class$org$dsi$ifc$bluetooth$DSIBluetoothListener == null ? (class$org$dsi$ifc$bluetooth$DSIBluetoothListener = TargetASLPhoneSetter.class$("org.dsi.ifc.bluetooth.DSIBluetoothListener")) : class$org$dsi$ifc$bluetooth$DSIBluetoothListener, this.dsiBluetoothListener);
            this.dsiMobileEquipmentTopology.setNotification(2, this.dsiMobileEquipmentTopologyListener);
            this.addObserver(-2096955328);
            this.addObserver(-1157431232);
            this.addObserver(-1140654016);
            this.addObserver(302710848);
            this.addObserver(822804544);
            this.addObserver(1510802240);
            this.addObserver(1426916160);
            this.addObserver(1443693376);
            this.registerService(-1678887424, true);
            this.registerService(-1561446912, true);
            this.registerService(-1343343104, true);
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(1083965440);
            eventGeneric.setInt(0, this.getTargetId());
            eventGeneric.setInt(1, 8);
            eventGeneric.setString(2, "NO_LANGUAGE");
            eventGeneric.setString(3, "de.vw.mib.asl.internal.phone.TargetASLPhoneSetter");
            ASLCarPlayFactory.getCarPlayApi().getServices().registerListener(new TargetASLPhoneSetter$1(this));
            ASLSystemFactory.getSystemApi().getFactoryResetService().addParticipant(new TargetASLPhoneSetter$Reset(this, null), FactoryResetComponents.ONLINE);
        }
        this.alreadyRegistered = true;
    }

    @Override
    protected void powerOn() {
        this.init();
        ServiceManager.aslPropertyManager.valueChangedBoolean(1865679616, PhonePersistence.getInstance().isWizardStateCompleted());
    }

    @Override
    public void handleEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 6100002: {
                this.setCarPlayConnected(false);
                break;
            }
            case 6100001: {
                this.setCarPlayConnected(true);
                break;
            }
            case 6100006: {
                this.setAndroidAutoConnected(false);
                break;
            }
            case 6100005: {
                this.setAndroidAutoConnected(true);
                break;
            }
            case 3600034: {
                boolean bl = eventGeneric.getBoolean(0);
                if (bl) break;
                this.switchPhoneFunctionalityOff();
                break;
            }
            case 3600047: {
                this.switchPhoneFunctionalityOn();
                break;
            }
            case 3600027: 
            case 1073742723: {
                boolean bl = eventGeneric.getBoolean(0);
                this.switchBTState(bl);
                break;
            }
            case 1073742779: {
                this.dialSpellerTimeout = eventGeneric.getInt(0) / 1000;
                this.startTimer(-863567616, (long)0, true);
                break;
            }
            case 1073742780: {
                this.stopTimer(-863567616);
                break;
            }
            case 100300: {
                --this.dialSpellerTimeout;
                if (this.dialSpellerTimeout != 0) break;
                this.stopTimer(-863567616);
                this.sendHMIEvent(157);
                break;
            }
            case 40003: {
                String string = eventGeneric.getString(1);
                if (this.getPrimary() != null) {
                    this.getPrimary().requestSetLanguage(string);
                }
                EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent(1151074304);
                eventGeneric2.setInt(0, eventGeneric.getInt(0));
                eventGeneric2.setBoolean(1, true);
                eventGeneric2.setString(2, string);
                break;
            }
            case 1073744658: {
                this.requestTopologyChange(this.togglePrioritized());
                break;
            }
            case 1073941850: {
                boolean bl = eventGeneric.getBoolean(0);
                this.setNadMode(!bl);
                break;
            }
            case 1073744689: {
                boolean bl = eventGeneric.getBoolean(0);
                this.setNadMode(bl);
                break;
            }
            case 1073941845: {
                boolean bl = eventGeneric.getBoolean(0);
                TargetASLPhoneSetter.writeBooleanToDatapool(1865679616, bl);
                PhonePersistence.getInstance().setWizardStateCompleted(bl);
                break;
            }
            case 1073941846: {
                TargetASLPhoneSetter.writeBooleanToDatapool(1882456832, eventGeneric.getBoolean(0));
                break;
            }
        }
    }

    private void resetOnlineSettings() {
        boolean bl = false;
        TargetASLPhoneSetter.writeBooleanToDatapool(1865679616, false);
        PhonePersistence.getInstance().setWizardStateCompleted(false);
    }

    private void switchPhoneFunctionalityOn() {
        if (ASLPhoneData.getInstance().btState != 5 && ASLPhoneData.getInstance().btState != 2 && (this.btToBeRestored && ASLPhoneData.getInstance().btState == 1 || ASLPhoneData.getInstance().btState == 4)) {
            this.switchBTState(true);
            this.btToBeRestored = false;
        }
    }

    private void switchPhoneFunctionalityOff() {
        if (ASLPhoneData.getInstance().btState == 0 || ASLPhoneData.getInstance().btState == 3) {
            this.switchBTState(false);
            this.disableNadAfterBtOff = true;
            this.btToBeRestored = true;
        } else {
            this.disableNAD();
        }
    }

    private void disableNAD() {
        this.triggerObserver(-1326565888, null);
    }

    private void requestTopologyChange(int[] nArray) {
        if (this.isTraceEnabled()) {
            this.trace().append("TargetASLPhoneSetter.requestTopologyChange(): from ").append(Arrays.toString(this.slots)).append(" to ").append(Arrays.toString(nArray)).append(", isToggleOngoing=").append(isToggleOngoing).log();
        }
        if (!isToggleOngoing) {
            isToggleOngoing = true;
            this.dsiMobileEquipmentTopology.requestChangeTopology(nArray);
        }
    }

    private void switchBTState(boolean bl) {
        this.dsiBluetooth.requestSwitchBTState(bl ? 0 : 1);
        ASLPhoneData.getInstance().isBTSwitchOffRequested = !bl;
    }

    private void setNadMode(boolean bl) {
        this.requestNadMode(bl ? 2 : 1, false);
        ASLPhoneData.persistence.setConnectedSimDataOnlyStateDifferentThanAdaptationDefault(bl ^ !ASLPhoneData.getInstance().defaultSimCardModeVoice);
    }

    private void setCarPlayConnected(boolean bl) {
        ASLPhoneData.getInstance().carPlayConnected = bl;
        AbstractASLHsmTarget.writeBooleanToDatapool(-243067648, bl);
        AbstractASLHsmTarget.writeBooleanToDatapool(-161323520, bl);
        AbstractASLHsmTarget.writeBooleanToDatapool(-276622080, bl);
        AbstractASLHsmTarget.writeBooleanToDatapool(-194877952, bl);
        AbstractASLHsmTarget.writeBooleanToDatapool(-159181568, bl);
        if (bl && ServiceManager.configManagerDiag.isFeatureFlagSet(73)) {
            if (ASLPhoneData.getInstance().internalSIMConnected) {
                ASLPhoneData.persistence.setConnectedSimDataOnlyStateDifferentThanAdaptationDefault(ASLPhoneData.getInstance().defaultSimCardModeVoice);
            }
            if (ASLPhoneData.getInstance().nadMode != 2 && ASLPhoneData.getInstance().internalSIMConnected) {
                this.sendHMIEvent(-461171456);
            }
        }
    }

    private void setAndroidAutoConnected(boolean bl) {
        ASLPhoneData.getInstance().androidAutoConnected = bl;
        AbstractASLHsmTarget.writeBooleanToDatapool(-243067648, false);
        AbstractASLHsmTarget.writeBooleanToDatapool(-161323520, false);
        AbstractASLHsmTarget.writeBooleanToDatapool(-276622080, bl);
        AbstractASLHsmTarget.writeBooleanToDatapool(-194877952, bl);
        AbstractASLHsmTarget.writeBooleanToDatapool(-175958784, bl);
        if (bl && ServiceManager.configManagerDiag.isFeatureFlagSet(73)) {
            ASLPhoneData.persistence.setConnectedSimDataOnlyStateDifferentThanAdaptationDefault(ASLPhoneData.getInstance().defaultSimCardModeVoice);
            if (ASLPhoneData.getInstance().nadMode != 2 && ASLPhoneData.getInstance().internalSIMConnected) {
                this.sendHMIEvent(-461171456);
            } else if (ASLPhoneData.getInstance().rSapConnected) {
                this.sendHMIEvent(-427617024);
            }
        }
    }

    private void requestNadMode(int n, boolean bl) {
        switch (n) {
            case 2: {
                this.requestTopologyChange(this.nadToThird());
                break;
            }
            case 1: {
                this.requestTopologyChange(this.primaryNad());
                break;
            }
            default: {
                this.warn("Illegal NAD mode: ", n);
            }
        }
    }

    public void dsiBluetoothUpdateBTState(int n, int n2) {
        this.btState = n;
        if (this.valetParkingListener == null && (n == 0 || n == 1)) {
            this.valetParkingListener = new TargetASLPhoneSetter$ValetParkingListenerBT(this, null);
            this.valetParkingListener.notifyValetParkingStateChanged(ASLSystemFactory.getSystemApi().getValetParkingService().getCurrentValetParkingState(), null);
            ASLSystemFactory.getSystemApi().getValetParkingService().addListener(this.valetParkingListener);
        }
    }

    public void dsiBluetoothResponseSwitchBTState(int n) {
        ASLPhoneData.getInstance().isBTSwitchOffRequested = false;
        switch (n) {
            case 0: {
                if (HsmPhonePhoneAvailability.btIsOnAndPossiblySwitchedOff) {
                    this.sendHMIEvent(142);
                    break;
                }
                this.sendHMIEvent(140);
                break;
            }
            default: {
                if (HsmPhonePhoneAvailability.btIsOnAndPossiblySwitchedOff) {
                    this.sendHMIEvent(141);
                    break;
                }
                this.sendHMIEvent(143);
            }
        }
        if (this.disableNadAfterBtOff) {
            this.disableNAD();
            this.disableNadAfterBtOff = false;
        }
        if (this.valetParkingCallback != null) {
            this.valetParkingCallback.notifyValetParkingTransitionFinished(true);
            this.valetParkingCallback = null;
        }
    }

    public void dsiMobileEquipmentTopologyResponseChangeTopology(int n) {
        isToggleOngoing = false;
    }

    public void dsiBluetoothAsyncException(int n, String string, int n2) {
        if (n2 == 1012) {
            ASLPhoneData.getInstance().isBTSwitchOffRequested = false;
        }
    }

    public void dsiMobileEquipmentTopologyAsyncException(int n, String string, int n2) {
        isToggleOngoing = false;
    }

    public void dsiMobileEquipmentTopologyUpdateUsage(int[] nArray, int n) {
        if (n == 1) {
            this.usage = nArray;
            this.dsiMobileEquipmentTopology.setNotification(1, this.dsiMobileEquipmentTopologyListener);
        }
    }

    public void dsiMobileEquipmentTopologyUpdateTopology(int[] nArray, int n) {
        this.slots = nArray;
        if (n == 1 && nArray != null && nArray[0] != -2) {
            isToggleOngoing = false;
        }
        boolean bl = nArray[0] >= 0 && this.usage[nArray[0]] == 0;
        boolean bl2 = nArray[1] >= 0 && this.usage[nArray[1]] == 0;
        ASLPhoneData.getInstance().nadPrimary = bl;
        ASLPhoneData.getInstance().nadSecondary = bl2;
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-1477560832);
        eventGeneric.setBoolean(0, bl);
        this.triggerObserver(-1477560832, eventGeneric);
    }

    private int[] togglePrioritized() {
        int n;
        int n2 = 0;
        int n3 = 0;
        for (int i2 = 0; i2 < Math.min(this.usage.length, 2); ++i2) {
            if (this.slots[i2] < 0 || this.usage[this.slots[i2]] != 1 && (ASLPhoneData.getInstance().nadEnabledPhone != 1 || this.usage[this.slots[i2]] != 0)) continue;
            ++n3;
            n2 += this.slots[i2];
        }
        if (n3 == 1) {
            if (this.usage[this.slots[0]] == 1 || ASLPhoneData.getInstance().nadEnabledPhone == 1 && this.usage[this.slots[0]] == 0) {
                this.info(new StringBuffer().append("Request toggle prioritized while ").append(n3).append(" phones connected, which is primary. Do nothing.").toString());
                return this.slots;
            }
            if (this.usage[this.slots[1]] == 1 || ASLPhoneData.getInstance().nadEnabledPhone == 1 && this.usage[this.slots[1]] == 0) {
                this.info("Request toggle prioritized while only 1 phone connected, which is associated. Make it primary.");
                return new int[]{this.slots[1], this.slots[0], this.slots[2]};
            }
            this.warn("Request toggle prioritized while only 1 phone connected, which is neither primary nor associated! Do nothing.");
            return this.slots;
        }
        if (n3 != 2) {
            this.warn(new StringBuffer().append("Request toggle prioritized while ").append(n3).append(" phones connected!").toString());
            return this.slots;
        }
        int[] nArray = new int[this.slots.length];
        for (n = 0; n < this.slots.length; ++n) {
            nArray[n] = this.slots[n];
        }
        for (n = 0; n < Math.min(this.usage.length, 2); ++n) {
            if (this.slots[n] < 0 || this.usage[nArray[n]] != 1 && (ASLPhoneData.getInstance().nadEnabledPhone != 1 || this.usage[nArray[n]] != 0)) continue;
            nArray[n] = n2 - nArray[n];
        }
        if (this.isTraceEnabled()) {
            this.trace().append("togglePrioritized ").append(Arrays.toString(this.slots)).append(" -> ").append(Arrays.toString(nArray)).append(" with usage=").append(Arrays.toString(this.usage)).log();
        }
        return nArray;
    }

    private int[] primaryNad() {
        if (this.usage[this.slots[0]] == 0) {
            this.trace("TargetASLPhoneSetter.primaryNad(): NAD is already primary!");
            return this.slots;
        }
        int[] nArray = new int[this.usage.length];
        Arrays.fill(nArray, -1);
        nArray[0] = this.getTopologyUsage().getNad();
        nArray[1] = this.slots[0];
        return nArray;
    }

    private int[] nadToThird() {
        if (this.slots[2] >= 0 && this.usage[this.slots[2]] == 0) {
            this.trace("TargetASLPhoneSetter.nadToThird(): NAD is already third!");
            return this.slots;
        }
        int[] nArray = new int[this.usage.length];
        Arrays.fill(nArray, -1);
        nArray[nArray.length - 1] = this.getTopologyUsage().getNad();
        nArray[0] = this.getTopologyUsage().getHfp1();
        nArray[1] = this.getTopologyUsage().getHfp2();
        return nArray;
    }

    @Override
    protected int[] getMobileEquipmentNotification() {
        return ASLPhoneData.EMPTY_NOTIFICATION;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ int access$100(TargetASLPhoneSetter targetASLPhoneSetter) {
        return targetASLPhoneSetter.btState;
    }

    static /* synthetic */ void access$200(TargetASLPhoneSetter targetASLPhoneSetter, boolean bl) {
        targetASLPhoneSetter.switchBTState(bl);
    }

    static /* synthetic */ void access$400(TargetASLPhoneSetter targetASLPhoneSetter) {
        targetASLPhoneSetter.resetOnlineSettings();
    }

    static {
        isToggleOngoing = false;
    }
}

