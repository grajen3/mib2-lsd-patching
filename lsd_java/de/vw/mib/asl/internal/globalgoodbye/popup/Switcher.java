/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.globalgoodbye.popup;

import de.vw.mib.event.dispatcher.SystemEventDispatcher;
import de.vw.mib.hmi.utils.Preconditions;

public class Switcher {
    private final SystemEventDispatcher systemEventDispatcher;
    static /* synthetic */ Class class$de$vw$mib$event$dispatcher$SystemEventDispatcher;

    public Switcher(SystemEventDispatcher systemEventDispatcher) {
        Preconditions.checkNotNull(systemEventDispatcher, new StringBuffer().append("The given instance of class ").append((class$de$vw$mib$event$dispatcher$SystemEventDispatcher == null ? (class$de$vw$mib$event$dispatcher$SystemEventDispatcher = Switcher.class$("de.vw.mib.event.dispatcher.SystemEventDispatcher")) : class$de$vw$mib$event$dispatcher$SystemEventDispatcher).getName()).append(" must not be null!").toString());
        this.systemEventDispatcher = systemEventDispatcher;
    }

    void activate() {
        this.systemEventDispatcher.createAndSubmitHMIEvent(-785680640);
    }

    void deactivate() {
        this.systemEventDispatcher.createAndSubmitHMIEvent(-768903424);
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

