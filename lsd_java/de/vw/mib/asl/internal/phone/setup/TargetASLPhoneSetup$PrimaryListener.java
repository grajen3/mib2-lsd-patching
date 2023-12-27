/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.setup;

import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.internal.phone.ASLPhoneData;
import de.vw.mib.asl.internal.phone.setup.TargetASLPhoneSetup;
import de.vw.mib.asl.internal.phone.setup.TargetASLPhoneSetup$1;
import de.vw.mib.asl.internal.phone.util.DefaultDSIMobileEquipmentListener;
import de.vw.mib.asl.internal.phone.util.PhoneUtil;
import org.dsi.ifc.telephoneng.SIMAliasInformation;

class TargetASLPhoneSetup$PrimaryListener
extends DefaultDSIMobileEquipmentListener {
    private final /* synthetic */ TargetASLPhoneSetup this$0;

    private TargetASLPhoneSetup$PrimaryListener(TargetASLPhoneSetup targetASLPhoneSetup) {
        this.this$0 = targetASLPhoneSetup;
    }

    @Override
    public void updatePhoneReminderSetting(boolean bl, int n) {
        AbstractASLTarget.writeBooleanToDatapool(1241, bl);
        ASLPhoneData.getInstance().phoneReminderSetting = bl;
    }

    @Override
    public void updateSIMPINRequired(boolean bl, int n) {
        AbstractASLTarget.writeBooleanToDatapool(1229, bl);
    }

    @Override
    public void updateAutomaticPinEntryActive(boolean bl, int n) {
        TargetASLPhoneSetup.access$102(this.this$0, bl);
        TargetASLPhoneSetup.access$200(this.this$0);
        AbstractASLTarget.writeBooleanToDatapool(1227, bl);
    }

    @Override
    public void responseUnlockOtherSIM(int n) {
        if (ASLPhoneData.getInstance().isToggleOtherPINrequested) {
            AbstractASLHsmTarget.writeIntegerToDatapool(1082, ASLPhoneData.getInstance().lockState);
            AbstractASLHsmTarget.writeIntegerToDatapool(332357888, ASLPhoneData.getInstance().lockState);
            AbstractASLHsmTarget.writeIntegerToDatapool(-228432384, ASLPhoneData.getInstance().lockState);
            this.this$0.sendHMIEvent(315580672);
            this.this$0.sendHMIEvent(-228432384);
            ASLPhoneData.getInstance().isToggleOtherPINrequested = false;
        }
        if (n == 0) {
            this.this$0.sendHMIEvent(524);
            if (this.this$0.isUnlockOtherPINrequested) {
                this.this$0.getNad().requestSetSIMAliases("PIN2", "PIN1");
            }
        } else if (n == 16) {
            this.this$0.sendHMIEvent(523);
        } else {
            this.this$0.sendHMIEvent(191);
        }
        this.this$0.isUnlockOtherPINrequested = false;
    }

    @Override
    public void responseUnlockSIM(int n) {
        if (n == 0) {
            this.this$0.sendHMIEvent(524);
        } else if (n == 16) {
            this.this$0.warn("PHONE_PIN_IDENTICAL_PROFILE_NOT_CHANGED: this case should never occur on requestUnlockSim!");
            this.this$0.sendHMIEvent(523);
        } else {
            this.this$0.sendHMIEvent(ASLPhoneData.getInstance().isPukUnlockRequested ? 193 : 191);
        }
    }

    @Override
    public void responseCheckSIMPINCode(int n) {
        if (n == 0) {
            AbstractASLTarget.writeIntegerToDatapool(1224, 0);
        } else {
            AbstractASLTarget.writeIntegerToDatapool(1224, 1);
        }
    }

    @Override
    public void responseChangeSIMCode(int n, int n2) {
        this.this$0.sendHMIEvent(n2 == 0 ? -763161344 : -779938560);
    }

    @Override
    public void updateSIMAliasInformation(SIMAliasInformation sIMAliasInformation, int n) {
        AbstractASLTarget.writeBooleanToDatapool(1230, true);
        AbstractASLTarget.writeStringToDatapool(3607, sIMAliasInformation.getActiveName());
        ASLPhoneData.getInstance().currentPIN = sIMAliasInformation.getActiveName();
        AbstractASLTarget.writeStringToDatapool(3608, sIMAliasInformation.getInactiveName());
        ASLPhoneData.getInstance().alternativePIN = sIMAliasInformation.getInactiveName();
        PhoneUtil.refreshPhoneSelectionList();
    }

    @Override
    public void updateOtherSIMAvailable(boolean bl, int n) {
        TargetASLPhoneSetup.access$302(this.this$0, bl);
        TargetASLPhoneSetup.access$200(this.this$0);
        AbstractASLTarget.writeBooleanToDatapool(3609, ASLPhoneData.getInstance().isOtherSIMAvailable);
        PhoneUtil.refreshPhoneSelectionList();
        if (bl && this.this$0.isUnlockOtherPINrequested) {
            this.this$0.getNad().requestSetSIMAliases("PIN2", "PIN1");
        }
        this.this$0.isUnlockOtherPINrequested = false;
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        if (n2 == 1032) {
            this.this$0.sendHMIEvent(191);
        } else if (n2 == 1016) {
            ASLPhoneData.getInstance().isAutomaticPinEntryPending = false;
        }
    }

    /* synthetic */ TargetASLPhoneSetup$PrimaryListener(TargetASLPhoneSetup targetASLPhoneSetup, TargetASLPhoneSetup$1 targetASLPhoneSetup$1) {
        this(targetASLPhoneSetup);
    }
}

