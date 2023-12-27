/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.proximity.filter;

import de.vw.mib.asl.internal.system.proximity.ProximityServiceImpl;
import de.vw.mib.asl.internal.system.proximity.filter.AbstractProximityFilter;

public class PauseProximityFilter
extends AbstractProximityFilter {
    public PauseProximityFilter(ProximityServiceImpl proximityServiceImpl) {
        super(proximityServiceImpl);
    }

    public void pause(boolean bl) {
        this.installOverride(bl);
    }

    public void resume() {
        this.removeOverride();
    }

    @Override
    public boolean isOverridingUserInteraction() {
        return true;
    }
}

