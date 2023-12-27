/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.proximity.component;

import de.vw.mib.asl.internal.system.SystemServices;
import de.vw.mib.asl.internal.system.proximity.ProximityServiceImpl;
import de.vw.mib.asl.internal.system.proximity.component.DefaultProximityUserInteractionComponent;

public class LongRunningProximityUserInteractionComponent
extends DefaultProximityUserInteractionComponent {
    private static final long TIMEOUT;

    public LongRunningProximityUserInteractionComponent(SystemServices systemServices, ProximityServiceImpl proximityServiceImpl) {
        super(systemServices, proximityServiceImpl);
    }

    @Override
    protected long getTimeout() {
        return 0;
    }
}

