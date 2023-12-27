/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.smartphoneintegration.target;

import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetParticipant;
import de.vw.mib.asl.internal.smartphoneintegration.common.SmartPhoneIntegrationGlobalProperyAccessor;
import de.vw.mib.asl.internal.smartphoneintegration.target.FactoryReset;
import de.vw.mib.asl.internal.smartphoneintegration.target.HsmTarget;

class FactoryReset$1
implements FactoryResetParticipant {
    private final /* synthetic */ HsmTarget val$target;
    private final /* synthetic */ FactoryReset this$0;

    FactoryReset$1(FactoryReset factoryReset, HsmTarget hsmTarget) {
        this.this$0 = factoryReset;
        this.val$target = hsmTarget;
    }

    @Override
    public long getTimeout() {
        return 0;
    }

    @Override
    public void reset(FactoryResetCallback factoryResetCallback, int n) {
        if (this.this$0.getTarget().isTraceEnabled()) {
            this.this$0.getTarget().trace().append(this.this$0.classname).append(".handle(reset) conn method=").append(SmartPhoneIntegrationGlobalProperyAccessor.getInstance().getCurrentConnectedDevice() != null ? new StringBuffer().append(SmartPhoneIntegrationGlobalProperyAccessor.getInstance().getCurrentConnectedDevice().getSelectedConnectionMethod()).append("").toString() : "none").log();
        }
        this.this$0.getTarget().getPersistence().clear();
        if (SmartPhoneIntegrationGlobalProperyAccessor.getInstance().getCurrentConnectedDevice() != null && SmartPhoneIntegrationGlobalProperyAccessor.getInstance().getCurrentConnectedDevice().getSelectedConnectionMethod() != 1) {
            this.this$0.getGlobal().setMirrorlinkFactoryReset(true);
        } else {
            this.val$target.triggerObserver(873749760, null);
            this.val$target.getDSISmartphoneIntegration().disconnectDevice(SmartPhoneIntegrationGlobalProperyAccessor.getInstance().getCurrentConnectedDevice().getDeviceID());
        }
        this.this$0.getTarget().getDSISmartphoneIntegration().requestFactorySettings(1);
        factoryResetCallback.notifyResetDone();
    }
}

