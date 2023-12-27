/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.weather;

import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public final class StateTopWeather
extends AbstractHsmState {
    public StateTopWeather(Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        return null;
    }
}

