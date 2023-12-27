/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.proximity.component;

import de.vw.mib.asl.internal.system.SystemServices;
import de.vw.mib.asl.internal.system.proximity.ProximityServiceImpl;
import de.vw.mib.asl.internal.system.proximity.component.AbstractProximityComponent;

public class DefaultProximityUserInteractionComponent
extends AbstractProximityComponent {
    public DefaultProximityUserInteractionComponent(SystemServices systemServices, ProximityServiceImpl proximityServiceImpl) {
        super(systemServices, proximityServiceImpl, PROXIMITY_COMPONENT_TYPE_USER_INTERACTION);
    }

    public void processUserInteraction() {
        this.installProximityValue(true);
        this.installProximityValue(false);
    }
}

