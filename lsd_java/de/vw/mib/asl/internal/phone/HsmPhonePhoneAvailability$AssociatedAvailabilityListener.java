/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone;

import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.phone.HsmPhonePhoneAvailability;
import de.vw.mib.asl.internal.phone.HsmPhonePhoneAvailability$1;
import de.vw.mib.asl.internal.phone.util.DefaultDSIMobileEquipmentListener;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.util.Util;
import org.dsi.ifc.telephoneng.ActivationStateStruct;
import org.dsi.ifc.telephoneng.LockStateStruct;
import org.dsi.ifc.telephoneng.PhoneInformation;

class HsmPhonePhoneAvailability$AssociatedAvailabilityListener
extends DefaultDSIMobileEquipmentListener {
    private String currentAssociatedMacOrSimId = "";
    private final /* synthetic */ HsmPhonePhoneAvailability this$0;

    private HsmPhonePhoneAvailability$AssociatedAvailabilityListener(HsmPhonePhoneAvailability hsmPhonePhoneAvailability) {
        this.this$0 = hsmPhonePhoneAvailability;
    }

    @Override
    public void updateActivationState(ActivationStateStruct activationStateStruct, int n) {
        HsmPhonePhoneAvailability.access$1000(this.this$0, activationStateStruct);
        HsmPhonePhoneAvailability.access$1100(this.this$0, activationStateStruct.getTelActivationState());
        HsmPhonePhoneAvailability.access$700(this.this$0);
    }

    @Override
    public void updateLockState(LockStateStruct lockStateStruct, int n) {
        if (lockStateStruct.getTelLockState() == 3 && !HsmPhonePhoneAvailability.access$1200(this.this$0).equals(this.currentAssociatedMacOrSimId)) {
            HsmPhonePhoneAvailability.access$1202(this.this$0, this.currentAssociatedMacOrSimId);
            this.this$0.stopTimer(-1585053440);
            this.this$0.triggerObserver(302710848, null);
            if (this.this$0.isTraceEnabled()) {
                this.this$0.trace("Triggering automatic toggle due to PIN unlock is required but this SIM isn't primary!");
            }
        }
    }

    @Override
    public void updatePhoneInformation(PhoneInformation phoneInformation, int n) {
        if (n == 1) {
            if (!Util.isNullOrEmpty(phoneInformation.getMeFriendlyName())) {
                AbstractASLTarget.writeStringToDatapool(4011, phoneInformation.getMeFriendlyName());
                EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
                eventGeneric.setString(0, phoneInformation.getMeBtAddress());
                this.this$0.triggerObserver(-1444006400, eventGeneric);
                eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
                eventGeneric.setString(0, "");
                this.this$0.triggerObserver(-1410451968, eventGeneric);
                this.currentAssociatedMacOrSimId = phoneInformation.getMeBtAddress();
            } else if (HsmPhonePhoneAvailability.access$1300(this.this$0) && !Util.isNullOrEmpty(phoneInformation.getSimId())) {
                AbstractASLTarget.writeStringToDatapool(4011, Util.isNullOrEmpty(phoneInformation.getSimName()) ? "" : phoneInformation.getSimName());
                EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
                eventGeneric.setString(0, "");
                this.this$0.triggerObserver(-1444006400, eventGeneric);
                eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
                eventGeneric.setString(0, phoneInformation.getSimId());
                this.this$0.triggerObserver(-1410451968, eventGeneric);
                this.currentAssociatedMacOrSimId = phoneInformation.getSimId();
            } else {
                AbstractASLTarget.writeStringToDatapool(4011, "");
                EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
                eventGeneric.setString(0, "");
                this.this$0.triggerObserver(-1444006400, eventGeneric);
                eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
                eventGeneric.setString(0, "");
                this.this$0.triggerObserver(-1410451968, eventGeneric);
                this.currentAssociatedMacOrSimId = "";
            }
        } else {
            AbstractASLTarget.writeStringToDatapool(4011, "");
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
            eventGeneric.setString(0, "");
            this.this$0.triggerObserver(-1444006400, eventGeneric);
            eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
            eventGeneric.setString(0, "");
            this.this$0.triggerObserver(-1410451968, eventGeneric);
            this.currentAssociatedMacOrSimId = "";
        }
    }

    /* synthetic */ HsmPhonePhoneAvailability$AssociatedAvailabilityListener(HsmPhonePhoneAvailability hsmPhonePhoneAvailability, HsmPhonePhoneAvailability$1 hsmPhonePhoneAvailability$1) {
        this(hsmPhonePhoneAvailability);
    }
}

