/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.common.controller;

import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.bap.mqbpq.ServiceManager;
import de.vw.mib.bap.mqbpq.common.controller.ArabicVariantChecker$1;
import de.vw.mib.bap.mqbpq.common.controller.GenericFunctionControlUnit;
import de.vw.mib.datapool.ASLDatapoolObserver;
import de.vw.mib.genericevents.ThreadSwitchingTarget;

class ArabicVariantChecker
implements ASLDatapoolObserver {
    private GenericFunctionControlUnit _functionControlUnit;

    public ArabicVariantChecker(GenericFunctionControlUnit genericFunctionControlUnit) {
        this._functionControlUnit = genericFunctionControlUnit;
    }

    public void initialize() {
        ServiceManager.serviceManager.dataPool.registerObserver(3568, this);
        this.datapoolValueChanged(0);
    }

    public void uninitialize() {
        ServiceManager.serviceManager.dataPool.unregisterObserver(3568, this);
    }

    private boolean isArabic() {
        return ServiceManager.serviceManager.dataPool.getBoolean(3568, false);
    }

    protected void switchToArabic() {
        this._functionControlUnit.setArabic(true);
    }

    @Override
    public void datapoolValueChanged(int n) {
        if (this.isArabic()) {
            ThreadSwitchingTarget threadSwitchingTarget = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLThreadSwitch();
            if (threadSwitchingTarget.isThreadChangeNecessary()) {
                ServiceManager.serviceManager.threadSwitchingTarget.enqueue(new ArabicVariantChecker$1(this));
            } else {
                this.switchToArabic();
            }
            this.uninitialize();
        }
    }
}

