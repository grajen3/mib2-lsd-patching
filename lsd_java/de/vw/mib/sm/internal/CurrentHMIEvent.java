/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.sm.internal;

import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.event.HMIEvent;
import de.vw.mib.sm.internal.ServiceManagerStatemachine;

public class CurrentHMIEvent {
    private static HMIEvent instance;
    public static short compactId;
    static /* synthetic */ Class class$de$vw$mib$event$HMIEvent;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$sm$internal$CurrentHMIEvent;

    public static void set(HMIEvent hMIEvent) {
        instance = hMIEvent;
        compactId = ServiceManagerStatemachine.hmiEventIdMap.getCompactEventId(CurrentHMIEvent.publicId());
    }

    public static void reset() {
        instance = null;
        compactId = (short)-1;
    }

    public static HMIEvent getEventAs(Class clazz) {
        if (!$assertionsDisabled && !(class$de$vw$mib$event$HMIEvent == null ? (class$de$vw$mib$event$HMIEvent = CurrentHMIEvent.class$("de.vw.mib.event.HMIEvent")) : class$de$vw$mib$event$HMIEvent).isAssignableFrom(clazz)) {
            throw new AssertionError();
        }
        return clazz.isInstance(instance) ? instance : null;
    }

    public static int publicId() {
        return instance == null ? -1 : instance.getId();
    }

    public static String className() {
        return instance == null ? "null" : super.getClass().getName();
    }

    public static boolean isForAppInstance(AppDefinition appDefinition) {
        CurrentHMIEvent.checkInstance();
        AppDefinition appDefinition2 = instance.getReceiver();
        return appDefinition2 == null || appDefinition2 == appDefinition;
    }

    public static boolean isConsumed() {
        CurrentHMIEvent.checkInstance();
        return instance.isConsumed();
    }

    public static void consume() {
        CurrentHMIEvent.checkInstance();
        instance.setConsumed(true);
    }

    public static boolean checkAndConsume(int n, boolean bl) {
        CurrentHMIEvent.checkInstance();
        if (!instance.isConsumed() && n == instance.getId()) {
            if (bl) {
                instance.setConsumed(true);
            }
            return true;
        }
        return false;
    }

    private static void checkInstance() {
        if (instance == null) {
            throw new IllegalStateException("Current HMI event not set.");
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        $assertionsDisabled = !(class$de$vw$mib$sm$internal$CurrentHMIEvent == null ? (class$de$vw$mib$sm$internal$CurrentHMIEvent = CurrentHMIEvent.class$("de.vw.mib.sm.internal.CurrentHMIEvent")) : class$de$vw$mib$sm$internal$CurrentHMIEvent).desiredAssertionStatus();
        instance = null;
        compactId = (short)-1;
    }
}

