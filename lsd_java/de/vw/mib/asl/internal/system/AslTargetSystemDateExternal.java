/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system;

import de.vw.mib.asl.ASLTimeAndDateServiceTarget;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.system.SystemAccessor;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import org.dsi.ifc.cartimeunitslanguage.ClockDate;
import org.dsi.ifc.cartimeunitslanguage.ClockTime;

public final class AslTargetSystemDateExternal
extends AbstractASLTarget
implements ASLTimeAndDateServiceTarget {
    static /* synthetic */ Class class$de$vw$mib$asl$ASLTimeAndDateServiceTarget;

    public AslTargetSystemDateExternal(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
    }

    public AslTargetSystemDateExternal(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getSubClassifier() {
        return 2048;
    }

    @Override
    public int[] getCurrentDateAndTimeAsIntArray() {
        ClockDate clockDate = SystemAccessor.getDateTarget().getCurrentDate();
        ClockTime clockTime = SystemAccessor.getDateTarget().getCurrentTime();
        return new int[]{clockDate.year, clockDate.month, clockDate.day, clockTime.hours, clockTime.minutes, clockTime.seconds};
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                ServiceManager.bundleContext.registerService((class$de$vw$mib$asl$ASLTimeAndDateServiceTarget == null ? (class$de$vw$mib$asl$ASLTimeAndDateServiceTarget = AslTargetSystemDateExternal.class$("de.vw.mib.asl.ASLTimeAndDateServiceTarget")) : class$de$vw$mib$asl$ASLTimeAndDateServiceTarget).getName(), (Object)this, null);
                break;
            }
        }
    }

    @Override
    public int getDefaultTargetId() {
        return 5606;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

