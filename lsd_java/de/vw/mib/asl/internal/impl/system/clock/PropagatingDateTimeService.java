/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.system.clock;

import de.vw.mib.asl.api.system.clock.DateTimeService;
import org.dsi.ifc.cartimeunitslanguage.ClockDate;
import org.dsi.ifc.cartimeunitslanguage.ClockTime;

public interface PropagatingDateTimeService
extends DateTimeService {
    default public void applyCurrentDate(ClockDate clockDate) {
    }

    default public void applyCurrentTime(ClockTime clockTime) {
    }
}

