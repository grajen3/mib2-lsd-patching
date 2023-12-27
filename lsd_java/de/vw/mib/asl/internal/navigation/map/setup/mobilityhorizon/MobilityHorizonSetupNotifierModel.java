/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.setup.mobilityhorizon;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;

public class MobilityHorizonSetupNotifierModel {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapViewerMobilityHorizonSetupNotifierModel]");

    public void notifyLocationTypeCombined() {
        this.logger.trace("notifyLocationTypeCombined()");
        AbstractASLHsmTarget.writeIntegerToDatapool(3587, 0);
    }

    public void notifyLocationTypeOneWay() {
        this.logger.trace("notifyLocationTypeOneWay()");
        AbstractASLHsmTarget.writeIntegerToDatapool(3587, 1);
    }

    public void notifyLocationTypeSafeReturn() {
        this.logger.trace("notifyLocationTypeSafeReturn()");
        AbstractASLHsmTarget.writeIntegerToDatapool(3587, 2);
    }

    public void notifyMobilityHorizonServiceAvailable() {
        this.logger.trace("notifyMobilityHorizonServiceAvailable()");
        AbstractASLHsmTarget.writeBooleanToDatapool(4174, true);
    }

    public void notifyMobilityHorizonServiceNotAvailable() {
        this.logger.trace("notifyMobilityHorizonServiceNotAvailable()");
        AbstractASLHsmTarget.writeBooleanToDatapool(4174, false);
    }
}

