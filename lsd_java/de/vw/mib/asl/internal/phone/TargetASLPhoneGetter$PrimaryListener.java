/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone;

import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.phone.ASLPhoneData;
import de.vw.mib.asl.internal.phone.TargetASLPhoneGetter;
import de.vw.mib.asl.internal.phone.TargetASLPhoneGetter$1;
import de.vw.mib.asl.internal.phone.util.DefaultDSIMobileEquipmentListener;
import de.vw.mib.asl.internal.phone.util.PhoneUtil;
import de.vw.mib.genericevents.EventGeneric;
import org.dsi.ifc.telephoneng.RegisterStateStruct;
import org.dsi.ifc.telephoneng.ServiceProvider;

class TargetASLPhoneGetter$PrimaryListener
extends DefaultDSIMobileEquipmentListener {
    private final /* synthetic */ TargetASLPhoneGetter this$0;

    private TargetASLPhoneGetter$PrimaryListener(TargetASLPhoneGetter targetASLPhoneGetter) {
        this.this$0 = targetASLPhoneGetter;
    }

    @Override
    public void updateServiceProvider(ServiceProvider serviceProvider, int n) {
        if (serviceProvider.displayConditionServiceProviderName) {
            TargetASLPhoneGetter.access$302(this.this$0, true);
            TargetASLPhoneGetter.access$402(this.this$0, serviceProvider.telServiceProviderName);
        } else {
            TargetASLPhoneGetter.access$302(this.this$0, false);
            TargetASLPhoneGetter.access$402(this.this$0, "");
        }
        this.this$0.setNetworkName();
    }

    @Override
    public void updateRegisterState(RegisterStateStruct registerStateStruct, int n) {
        TargetASLPhoneGetter.access$502(this.this$0, registerStateStruct.getTelRegisterState());
        TargetASLPhoneGetter.access$200(this.this$0);
        AbstractASLTarget.writeIntegerToDatapool(1085, PhoneUtil.convertRegisterStateDSI2ASL(registerStateStruct.telRegisterState));
        ASLPhoneData.getInstance().roaming = registerStateStruct.getTelRegisterState() == 2;
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setBoolean(0, ASLPhoneData.getInstance().roaming);
        this.this$0.triggerObserver(-1527892480, eventGeneric);
        TargetASLPhoneGetter.access$602(this.this$0, registerStateStruct.getTelLongProviderName());
        this.this$0.setNetworkName();
        AbstractASLTarget.writeBooleanToDatapool(1196, registerStateStruct.telRegMode == 1);
        this.this$0.sendSafe(ServiceManager.mGenericEventFactory.newEvent(5250, 1922634752, -1930545664));
        EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric2.setBoolean(0, registerStateStruct.getTelRegisterState() == 1 || registerStateStruct.getTelRegisterState() == 2);
        this.this$0.triggerObserver(-1494338048, eventGeneric2);
    }

    @Override
    public void updateBatteryChargeLevel(int n, int n2) {
        this.this$0.stopTimer(-1601830656);
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.this$0.getTargetId(), this.this$0.getTargetId(), -1601830656);
        eventGeneric.setInt(0, n);
        this.this$0.retriggerOrStartTimer(eventGeneric, (long)0, false);
    }

    @Override
    public void updateSignalQuality(int n, int n2) {
        if (n == 255) {
            AbstractASLTarget.writeBooleanToDatapool(1097, false);
        } else {
            int n3 = TargetASLPhoneGetter.access$700(this.this$0, n);
            AbstractASLTarget.writeBooleanToDatapool(1097, true);
            AbstractASLTarget.writeIntegerToDatapool(1087, n3);
        }
    }

    @Override
    public void updateOptimizationMode(int n, int n2) {
        int n3;
        switch (n) {
            case 3: {
                n3 = 2;
                break;
            }
            case 2: {
                n3 = 1;
                break;
            }
            default: {
                n3 = 0;
            }
        }
        AbstractASLTarget.writeIntegerToDatapool(1216, n3);
    }

    /* synthetic */ TargetASLPhoneGetter$PrimaryListener(TargetASLPhoneGetter targetASLPhoneGetter, TargetASLPhoneGetter$1 targetASLPhoneGetter$1) {
        this(targetASLPhoneGetter);
    }
}

