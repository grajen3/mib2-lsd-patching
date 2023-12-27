/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.asl.service;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;

public class ASLNavigationServiceMainMapNotifierModel {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[ASLNavigationServiceMainMapNotifierModel]");

    public void notifyMainMapNotShownInABT() {
        this.logger.trace("notifyMapNotShownInABT()");
        AbstractASLHsmTarget.writeBooleanToDatapool(-1762652160, false);
    }

    protected void notifyMainMapShownInABT() {
        this.logger.trace("notifyMapShownInABT()");
        AbstractASLHsmTarget.writeBooleanToDatapool(-1762652160, true);
    }

    public void notifyMapSwitchButtonDisabled() {
        this.logger.trace("notifyMapSwitchButtonDisabled()");
        AbstractASLHsmTarget.writeBooleanToDatapool(-1779429376, false);
    }

    public void notifyMapSwitchButtonEnabled() {
        this.logger.trace("notifyMapSwitchButtonEnabled()");
        AbstractASLHsmTarget.writeBooleanToDatapool(-1779429376, true);
    }

    public void notifyOverviewZoomOff() {
        this.logger.trace("notifyOverviewZoomOff()");
        AbstractASLHsmTarget.writeBooleanToDatapool(876, false);
    }
}

