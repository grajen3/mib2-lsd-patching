/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.proximity.filter;

import de.vw.mib.asl.internal.system.proximity.ProximityServiceImpl;
import de.vw.mib.asl.internal.system.proximity.filter.AbstractProximityFilter;

public class EnablementProximityFilter
extends AbstractProximityFilter {
    public EnablementProximityFilter(ProximityServiceImpl proximityServiceImpl) {
        super(proximityServiceImpl);
    }

    public void enableProximity(boolean bl) {
        if (bl) {
            this.removeOverride();
        } else {
            this.installOverride(true);
        }
    }

    @Override
    public boolean isOverridingUserInteraction() {
        return false;
    }
}

