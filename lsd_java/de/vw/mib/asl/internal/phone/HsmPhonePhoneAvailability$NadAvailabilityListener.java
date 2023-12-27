/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone;

import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.phone.ASLPhoneData;
import de.vw.mib.asl.internal.phone.HsmPhonePhoneAvailability;
import de.vw.mib.asl.internal.phone.HsmPhonePhoneAvailability$1;
import de.vw.mib.asl.internal.phone.TargetASLPhoneSetter;
import de.vw.mib.asl.internal.phone.util.DefaultDSIMobileEquipmentListener;
import de.vw.mib.asl.internal.phone.util.PhoneUtil;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.util.Util;
import org.dsi.ifc.telephoneng.ActivationStateStruct;
import org.dsi.ifc.telephoneng.LockStateStruct;
import org.dsi.ifc.telephoneng.PhoneInformation;

class HsmPhonePhoneAvailability$NadAvailabilityListener
extends DefaultDSIMobileEquipmentListener {
    private boolean asAttachedNotReady = false;
    private final /* synthetic */ HsmPhonePhoneAvailability this$0;

    private HsmPhonePhoneAvailability$NadAvailabilityListener(HsmPhonePhoneAvailability hsmPhonePhoneAvailability) {
        this.this$0 = hsmPhonePhoneAvailability;
    }

    @Override
    public void updatePhoneInformation(PhoneInformation phoneInformation, int n) {
        if (n == 1) {
            if (TargetASLPhoneSetter.isToggleOngoing) {
                this.this$0.trace(new StringBuffer().append("HsmPhonePhoneAvailability.NadAvailabilityListener.updatePhoneInformation(PhoneInformation, int) toggleOngoing, continuing anyway.").append(ASLPhoneData.getInstance().nadMode).toString());
            }
            HsmPhonePhoneAvailability.access$1400(this.this$0, phoneInformation);
        }
        if (Util.isNullOrEmpty(phoneInformation.getMeBtAddress()) && Util.isNullOrEmpty(phoneInformation.getSimId())) {
            HsmPhonePhoneAvailability.access$1202(this.this$0, "");
        }
    }

    @Override
    public void updateActivationState(ActivationStateStruct activationStateStruct, int n) {
        ASLPhoneData.getInstance().rSapConnected = HsmPhonePhoneAvailability.access$1500(this.this$0) && activationStateStruct.getTelMode() == 2;
        AbstractASLTarget.writeBooleanToDatapool(176428288, HsmPhonePhoneAvailability.access$1600(this.this$0) && activationStateStruct.getTelMode() == 0);
        AbstractASLTarget.writeBooleanToDatapool(193205504, HsmPhonePhoneAvailability.access$1700(this.this$0) && activationStateStruct.getTelMode() == 0);
        int n2 = ASLPhoneData.getInstance().telModeNad;
        HsmPhonePhoneAvailability.access$1802(this.this$0, activationStateStruct);
        AbstractASLTarget.writeIntegerToDatapool(1089, activationStateStruct.telMode == 0 ? 0 : 1);
        ASLPhoneData.getInstance().internalSIMConnected = activationStateStruct.telMode == 0 && HsmPhonePhoneAvailability.access$1900(this.this$0);
        ASLPhoneData.getInstance().nadState = activationStateStruct.telPhoneModuleState;
        ASLPhoneData.getInstance().telModeNad = activationStateStruct.getTelMode();
        ASLPhoneData.getInstance().activationStateNad = activationStateStruct;
        PhoneUtil.enablePINSettings();
        PhoneUtil.setNetworkingAvailable();
        HsmPhonePhoneAvailability.access$2000(this.this$0, n2);
        PhoneUtil.refreshPhoneSelectionList();
        PhoneUtil.setNADFeatures(activationStateStruct.getTelActivationState() == 5 || activationStateStruct.getTelActivationState() == 2);
        HsmPhonePhoneAvailability.access$600(this.this$0);
        ASLPhoneData.getInstance().nadEnabledIndependent = HsmPhonePhoneAvailability.access$1800((HsmPhonePhoneAvailability)this.this$0).telPhoneModuleState == 2 ? 1 : 0;
        boolean bl = HsmPhonePhoneAvailability.access$1800((HsmPhonePhoneAvailability)this.this$0).telPhoneModuleState == 2 || HsmPhonePhoneAvailability.access$1800((HsmPhonePhoneAvailability)this.this$0).telPhoneModuleState == 3 || HsmPhonePhoneAvailability.access$1800((HsmPhonePhoneAvailability)this.this$0).telPhoneModuleState == 8 || HsmPhonePhoneAvailability.access$1800((HsmPhonePhoneAvailability)this.this$0).telPhoneModuleState == 7;
        AbstractASLTarget.writeBooleanToDatapool(1093, bl);
        if (activationStateStruct.telActivationState == 7) {
            this.asAttachedNotReady = true;
        } else if (this.asAttachedNotReady) {
            if (HsmPhonePhoneAvailability.access$2100(this.this$0) != null) {
                this.checkLockStateAndNadMode(HsmPhonePhoneAvailability.access$2100(this.this$0), ASLPhoneData.getInstance().nadMode);
            }
            this.asAttachedNotReady = false;
        }
        HsmPhonePhoneAvailability.access$700(this.this$0);
    }

    @Override
    public void updateLockState(LockStateStruct lockStateStruct, int n) {
        HsmPhonePhoneAvailability.access$2102(this.this$0, lockStateStruct);
        this.checkLockStateAndNadMode(lockStateStruct, ASLPhoneData.getInstance().nadMode);
        HsmPhonePhoneAvailability.access$2200(this.this$0);
    }

    @Override
    public void responseSetAutomaticPinEntryActive(int n) {
        ASLPhoneData.getInstance().isAutomaticPinEntryPending = false;
    }

    private void checkLockStateAndNadMode(LockStateStruct lockStateStruct, int n) {
        if (this.this$0.isTraceEnabled()) {
            this.this$0.trace().append("checkLockStateAndNadMode: ").append(lockStateStruct.getTelLockState()).append(", nadMode: ").append(n).append(", NAD ActivationState:").append(HsmPhonePhoneAvailability.access$1800(this.this$0).getTelActivationState()).append(", isToggleOtherPINrequested: ").append(ASLPhoneData.getInstance().isToggleOtherPINrequested).append(", nadPrimary: ").append(HsmPhonePhoneAvailability.access$2300(this.this$0)).log();
        }
        HsmPhonePhoneAvailability.access$2400(this.this$0);
        if (!ASLPhoneData.getInstance().isToggleOtherPINrequested && HsmPhonePhoneAvailability.access$1800(this.this$0).getTelActivationState() != 7) {
            if (n == 1 && HsmPhonePhoneAvailability.access$2500(this.this$0) && HsmPhonePhoneAvailability.access$2600(HsmPhonePhoneAvailability.access$1800(this.this$0))) {
                AbstractASLHsmTarget.writeIntegerToDatapool(1082, lockStateStruct.telLockState);
                AbstractASLHsmTarget.writeIntegerToDatapool(332357888, lockStateStruct.telLockState);
                AbstractASLHsmTarget.writeIntegerToDatapool(-228432384, lockStateStruct.telLockState);
            } else {
                AbstractASLHsmTarget.writeIntegerToDatapool(1082, 2);
                AbstractASLHsmTarget.writeIntegerToDatapool(332357888, 2);
                AbstractASLHsmTarget.writeIntegerToDatapool(-228432384, 2);
            }
            this.this$0.sendHMIEvent(315580672);
            this.this$0.sendHMIEvent(-228432384);
        }
        HsmPhonePhoneAvailability.access$600(this.this$0);
        ASLPhoneData.getInstance().nadLockState = lockStateStruct.getTelLockState();
        PhoneUtil.setNetworkingAvailable();
        HsmPhonePhoneAvailability.access$2700(this.this$0);
        this.triggerAslPhoneNadLockState(lockStateStruct, n);
    }

    private void triggerAslPhoneNadLockState(LockStateStruct lockStateStruct, int n) {
        EventGeneric eventGeneric = ServiceManager.eventMain.getEventFactory().newEvent(-1460783616);
        eventGeneric.setInt(0, 0);
        if (HsmPhonePhoneAvailability.access$2800(this.this$0) && lockStateStruct != null) {
            switch (lockStateStruct.getTelLockState()) {
                case 0: 
                case 2: {
                    eventGeneric.setInt(0, 1);
                    break;
                }
                case 3: {
                    eventGeneric.setInt(0, 2);
                    break;
                }
                case 5: {
                    eventGeneric.setInt(0, 3);
                    break;
                }
            }
        }
        this.this$0.triggerObserver(-1460783616, eventGeneric);
    }

    @Override
    public void updateNADMode(int n, int n2) {
        if (n2 != 1) {
            return;
        }
        ASLPhoneData.getInstance().nadMode = n;
        boolean bl = n == 2;
        AbstractASLTarget.writeBooleanToDatapool(4033, ServiceManager.configManagerDiag.isFeatureFlagSet(73) && bl);
        AbstractASLTarget.writeBooleanToDatapool(1949565696, !bl);
        if (HsmPhonePhoneAvailability.access$2100(this.this$0) != null) {
            this.checkLockStateAndNadMode(HsmPhonePhoneAvailability.access$2100(this.this$0), n);
        } else {
            this.this$0.warn("Nad Mode updated, but no lock state set yet!");
        }
    }

    /* synthetic */ HsmPhonePhoneAvailability$NadAvailabilityListener(HsmPhonePhoneAvailability hsmPhonePhoneAvailability, HsmPhonePhoneAvailability$1 hsmPhonePhoneAvailability$1) {
        this(hsmPhonePhoneAvailability);
    }
}

