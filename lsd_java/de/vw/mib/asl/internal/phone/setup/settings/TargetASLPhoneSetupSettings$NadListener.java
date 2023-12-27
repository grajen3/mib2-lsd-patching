/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.setup.settings;

import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.phone.ASLPhoneData;
import de.vw.mib.asl.internal.phone.setup.settings.TargetASLPhoneSetupSettings;
import de.vw.mib.asl.internal.phone.setup.settings.TargetASLPhoneSetupSettings$1;
import de.vw.mib.asl.internal.phone.setup.settings.TargetASLPhoneSetupSettings$ValetParkingListenerNAD;
import de.vw.mib.asl.internal.phone.util.DefaultDSIMobileEquipmentListener;
import de.vw.mib.genericevents.EventGeneric;
import org.dsi.ifc.telephoneng.ActivationStateStruct;

class TargetASLPhoneSetupSettings$NadListener
extends DefaultDSIMobileEquipmentListener {
    private final /* synthetic */ TargetASLPhoneSetupSettings this$0;

    private TargetASLPhoneSetupSettings$NadListener(TargetASLPhoneSetupSettings targetASLPhoneSetupSettings) {
        this.this$0 = targetASLPhoneSetupSettings;
    }

    @Override
    public void responseTelPower(int n) {
        if (TargetASLPhoneSetupSettings.access$200(this.this$0)) {
            if (n != 0) {
                this.this$0.sendHMIEvent(186);
            } else {
                EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.this$0.getTargetId(), 5251, -1568276224);
                this.this$0.sendSafe(eventGeneric);
            }
        } else if (n != 0) {
            this.this$0.sendHMIEvent(-645720832);
        }
        if (TargetASLPhoneSetupSettings.access$300(this.this$0) && ASLPhoneData.getInstance().nadState != 3) {
            TargetASLPhoneSetupSettings.access$400(this.this$0);
            TargetASLPhoneSetupSettings.access$302(this.this$0, false);
        }
        if (this.this$0.valetParkingCallback != null) {
            this.this$0.valetParkingCallback.notifyValetParkingTransitionFinished(true);
            this.this$0.valetParkingCallback = null;
        }
    }

    @Override
    public void updateActivationState(ActivationStateStruct activationStateStruct, int n) {
        TargetASLPhoneSetupSettings.access$002(this.this$0, activationStateStruct);
        if (this.this$0.valetParkingListener == null && activationStateStruct != null && (activationStateStruct.getTelPhoneModuleState() == 2 || activationStateStruct.getTelPhoneModuleState() == 3)) {
            this.this$0.valetParkingListener = new TargetASLPhoneSetupSettings$ValetParkingListenerNAD(this.this$0, null);
            this.this$0.valetParkingListener.notifyValetParkingStateChanged(ASLSystemFactory.getSystemApi().getValetParkingService().getCurrentValetParkingState(), null);
            ASLSystemFactory.getSystemApi().getValetParkingService().addListener(this.this$0.valetParkingListener);
        }
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        if (n2 == 1023) {
            this.responseTelPower(4);
        }
    }

    /* synthetic */ TargetASLPhoneSetupSettings$NadListener(TargetASLPhoneSetupSettings targetASLPhoneSetupSettings, TargetASLPhoneSetupSettings$1 targetASLPhoneSetupSettings$1) {
        this(targetASLPhoneSetupSettings);
    }
}

