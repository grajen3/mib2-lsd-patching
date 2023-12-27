/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.common;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.internal.list.ASLListManager;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.genericevents.GenericEvents;

public final class Framework {
    public static void fireUIEvent(int n) {
        ASLFrameworkFactory.getASLFrameworkAPI().getServices().getSystemEventDispatcher().createAndSubmitHMIEvent(n);
    }

    public static void fireEvent(int n) {
        Framework.fireEvent(n, null);
    }

    public static void fireEvent(int n, Object object) {
        GenericEvents genericEvents = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getGenericEvents();
        try {
            EventGeneric eventGeneric = genericEvents.getEventFactory().newEvent(n);
            if (object != null) {
                eventGeneric.setObject(0, object);
            }
            genericEvents.getEventDispatcher().send(eventGeneric);
        }
        catch (GenericEventException genericEventException) {
            AppLogger.error(new StringBuffer().append("Cannot send internal event: ").append(n).append(" - ").append(genericEventException.getMessage()).toString());
        }
    }

    public static void fireEvent(int n, boolean bl) {
        GenericEvents genericEvents = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getGenericEvents();
        try {
            EventGeneric eventGeneric = genericEvents.getEventFactory().newEvent(n);
            eventGeneric.setBoolean(0, bl);
            genericEvents.getEventDispatcher().send(eventGeneric);
        }
        catch (GenericEventException genericEventException) {
            AppLogger.error(new StringBuffer().append("Cannot send internal event: ").append(n).append(" - ").append(genericEventException.getMessage()).toString());
        }
    }

    public static void updateUIValue(int n, int n2) {
        ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLPropertyManager().valueChangedInteger(n, n2);
    }

    public static void updateUIValue(int n, String string) {
        ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLPropertyManager().valueChangedString(n, string);
    }

    public static void updateUIValue(int n, boolean bl) {
        ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLPropertyManager().valueChangedBoolean(n, bl);
    }

    public static ASLListManager getListManager() {
        return ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLListManager();
    }

    public static ASLPropertyManager getPropertyManager() {
        return ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLPropertyManager();
    }
}

