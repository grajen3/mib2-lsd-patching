/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.framework.asl;

import de.vw.mib.asl.framework.internal.framework.asl.EventNameResolver;

public interface IEvents {
    public static final int EV_START_SPELLER_BY_HANDLER = EventNameResolver.makeNewEvent("EV_START_SPELLER_BY_HANDLER");
    public static final int EV_STRIP_BY_STRIP_ID = EventNameResolver.makeNewEvent("EV_STRIP_BY_STRIP_ID");
    public static final int EV_SAVE_SPELLER_BY_HANDLER = EventNameResolver.makeNewEvent("EV_SAVE_SPELLER_BY_HANDLER");
    public static final int EV_SET_INPUT = EventNameResolver.makeNewEvent("EV_SET_INPUT");
    public static final int EV_SELECT_VIA_ID = EventNameResolver.makeNewEvent("EV_SELECT_VIA_ID");
    public static final int EV_SELECT_VIA_INDEX = EventNameResolver.makeNewEvent("EV_SELECT_VIA_INDEX");
    public static final int EV_SET_CONTEXT_LOCATION = EventNameResolver.makeNewEvent("EV_SET_CONTEXT_LOCATION");
}

