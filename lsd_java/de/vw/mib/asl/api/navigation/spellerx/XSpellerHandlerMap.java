/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.spellerx;

import de.vw.mib.asl.api.navigation.locationinput.SpellerHandler;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.asl.IEvents;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.EventGeneric;

public final class XSpellerHandlerMap {
    public static final int SLOT_HANDLER_INDEX;
    private static IntObjectOptHashMap handlerMap;

    private XSpellerHandlerMap() {
    }

    public static void saveSpeller(SpellerHandler spellerHandler) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setObject(0, spellerHandler);
        eventGeneric.setReceiverEventId(IEvents.EV_SAVE_SPELLER_BY_HANDLER);
        eventGeneric.setReceiverTargetId(-1958013952);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }

    public static void addHandler(int n, int n2, SpellerHandler spellerHandler) {
        int n3 = n | n2 << 16;
        handlerMap.put(n3, spellerHandler);
    }

    public static SpellerHandler getHandler(int n) {
        SpellerHandler spellerHandler = null;
        Object object = handlerMap.get(n);
        if (object instanceof SpellerHandler) {
            spellerHandler = (SpellerHandler)object;
        }
        return spellerHandler;
    }

    public static SpellerHandler getHandler(int n, int n2) {
        int n3 = n | n2 << 16;
        return (SpellerHandler)handlerMap.get(n3);
    }

    static {
        handlerMap = new IntObjectOptHashMap();
    }
}

