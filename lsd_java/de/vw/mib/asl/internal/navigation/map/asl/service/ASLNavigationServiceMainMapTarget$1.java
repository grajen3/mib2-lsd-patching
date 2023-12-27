/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.asl.service;

import de.vw.mib.asl.api.navigation.ASLNavigationServicesListener;
import de.vw.mib.asl.internal.navigation.map.asl.service.ASLNavigationServiceMainMapEvents;
import de.vw.mib.asl.internal.navigation.map.asl.service.ASLNavigationServiceMainMapTarget;

class ASLNavigationServiceMainMapTarget$1
implements ASLNavigationServicesListener {
    private final /* synthetic */ ASLNavigationServiceMainMapTarget this$0;

    ASLNavigationServiceMainMapTarget$1(ASLNavigationServiceMainMapTarget aSLNavigationServiceMainMapTarget) {
        this.this$0 = aSLNavigationServiceMainMapTarget;
    }

    @Override
    public void updateServiceAvailable(boolean bl) {
        if (bl) {
            return;
        }
        this.this$0.LOGGER.warn("ASLNavigationServicesListener.updateServiceAvailable(false) - Nav Domain not Available");
        ASLNavigationServiceMainMapEvents.sendEventServiceError(this.this$0.getClientTarget(), 7);
    }

    @Override
    public void updateGuidanceActive(boolean bl) {
    }

    @Override
    public void updateContactCapacity(int n) {
    }

    @Override
    public void importContactResult(int n) {
    }
}

