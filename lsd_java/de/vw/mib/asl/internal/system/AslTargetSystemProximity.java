/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system;

import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.internal.system.SystemAccessor;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;

public final class AslTargetSystemProximity
extends AbstractASLTarget {
    public AslTargetSystemProximity(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        SystemAccessor.setProximityTarget(this);
    }

    public AslTargetSystemProximity(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        SystemAccessor.setProximityTarget(this);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
    }

    @Override
    public int getSubClassifier() {
        return 2048;
    }

    @Override
    public int getDefaultTargetId() {
        return 5604;
    }
}

