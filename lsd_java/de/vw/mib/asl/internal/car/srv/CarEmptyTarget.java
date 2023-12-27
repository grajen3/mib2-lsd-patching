/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.srv;

import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.Target;

public abstract class CarEmptyTarget
implements Target {
    @Override
    public GenericEvents getMainObject() {
        return null;
    }

    @Override
    public int getTargetId() {
        return 0;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
    }

    @Override
    public void setTargetId(int n) {
    }
}

