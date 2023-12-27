/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.phone.ASLPhoneData;
import de.vw.mib.asl.internal.phone.HsmPhonePhoneAvailability;
import de.vw.mib.asl.internal.phone.HsmPhonePhoneAvailability$1;
import de.vw.mib.asl.internal.phone.util.DefaultDSIMobileEquipmentListener;
import de.vw.mib.asl.internal.phone.util.PhoneUtil;
import de.vw.mib.util.Util;
import org.dsi.ifc.telephoneng.ActivationStateStruct;
import org.dsi.ifc.telephoneng.PhoneInformation;

class HsmPhonePhoneAvailability$PrimaryAvailabilityListener
extends DefaultDSIMobileEquipmentListener {
    private final /* synthetic */ HsmPhonePhoneAvailability this$0;

    private HsmPhonePhoneAvailability$PrimaryAvailabilityListener(HsmPhonePhoneAvailability hsmPhonePhoneAvailability) {
        this.this$0 = hsmPhonePhoneAvailability;
    }

    @Override
    public void updateActivationState(ActivationStateStruct activationStateStruct, int n) {
        if (activationStateStruct.telActivationState == 12) {
            if (this.this$0.isTraceEnabled()) {
                this.this$0.trace().append("AS == RECONNECTING -> setting currentReconnectPhoneName as phone device name: ").append(HsmPhonePhoneAvailability.access$000(this.this$0)).log();
            }
            PhoneUtil.setDeviceName(HsmPhonePhoneAvailability.access$000(this.this$0));
        } else if (activationStateStruct.telActivationState != 7) {
            if (this.this$0.isTraceEnabled()) {
                this.this$0.trace().append("AS != RECONNECTING && AS != ATTACHED_NOT_READY -> setting currentPhoneDeviceName as phone device name: ").append(HsmPhonePhoneAvailability.access$100(this.this$0)).log();
            }
            PhoneUtil.setDeviceName(HsmPhonePhoneAvailability.access$100(this.this$0));
        }
        HsmPhonePhoneAvailability.access$200(this.this$0, activationStateStruct);
        if (activationStateStruct.telActivationState != 0) {
            if (!HsmPhonePhoneAvailability.access$300(this.this$0)) {
                HsmPhonePhoneAvailability.access$302(this.this$0, true);
                this.this$0.info("Setting phone domain available, as well as PhoneTileS... DOMAIN_AVAILABLE .");
                ServiceManager.aslPropertyManager.valueChangedInteger(1680, 1);
                ServiceManager.aslPropertyManager.valueChangedInteger(-43883008, 1);
            }
            HsmPhonePhoneAvailability.access$402(this.this$0, true);
            HsmPhonePhoneAvailability.access$500(this.this$0, activationStateStruct.telActivationState);
        }
        HsmPhonePhoneAvailability.access$600(this.this$0);
        HsmPhonePhoneAvailability.access$700(this.this$0);
    }

    @Override
    public void updatePhoneInformation(PhoneInformation phoneInformation, int n) {
        if (n == 1) {
            String string = "";
            if (!Util.isNullOrEmpty(phoneInformation.getMeFriendlyName())) {
                string = phoneInformation.getMeFriendlyName();
            } else if (HsmPhonePhoneAvailability.access$800(this.this$0) && !Util.isNullOrEmpty(phoneInformation.getSimId())) {
                ASLPhoneData.getInstance().SIMName = string = phoneInformation.getSimName() == null ? "" : phoneInformation.getSimName();
            }
            if (HsmPhonePhoneAvailability.access$900(this.this$0).getTelActivationState() != 12) {
                if (this.this$0.isTraceEnabled()) {
                    this.this$0.trace().append("updatePhoneInformation: AS != RECONNECTING -> setting primaryPhoneDeviceName as phone device name: ").append(string).log();
                }
                PhoneUtil.setDeviceName(string);
            }
            HsmPhonePhoneAvailability.access$102(this.this$0, string);
        }
    }

    /* synthetic */ HsmPhonePhoneAvailability$PrimaryAvailabilityListener(HsmPhonePhoneAvailability hsmPhonePhoneAvailability, HsmPhonePhoneAvailability$1 hsmPhonePhoneAvailability$1) {
        this(hsmPhonePhoneAvailability);
    }
}

