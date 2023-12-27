/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.globalgoodbye.services;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.event.dispatcher.SystemEventDispatcher;
import de.vw.mib.genericevents.EventFactory;
import de.vw.mib.log4mib.Logger;

public interface GlobalGoodByeServices {
    default public Logger getLogger() {
    }

    default public EventFactory getEventFactory() {
    }

    default public SystemEventDispatcher getSystemEventDispatcher() {
    }

    default public ASLPropertyManager getAslPropertyManager() {
    }
}

