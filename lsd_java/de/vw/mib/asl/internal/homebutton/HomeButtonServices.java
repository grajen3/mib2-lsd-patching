/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.homebutton;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.api.homescreen.HomeScreenPages;
import de.vw.mib.asl.api.system.input.UserInteractionLockService;
import de.vw.mib.cio.CioDictionary;
import de.vw.mib.cio.CioDispatcher;
import de.vw.mib.genericevents.EventDispatcherHSM;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.ServiceRegister;
import de.vw.mib.log4mib.Logger;

public interface HomeButtonServices {
    default public ServiceRegister getServiceRegister() {
    }

    default public GenericEvents getGenericEvents() {
    }

    default public EventDispatcherHSM getEventDispatcher() {
    }

    default public Logger getLogger() {
    }

    default public CioDictionary getCioDictionary() {
    }

    default public CioDispatcher getCioDispatcher() {
    }

    default public UserInteractionLockService getUserInteractionLockService() {
    }

    default public HomeScreenPages getHomeScreenPages() {
    }

    default public ASLPropertyManager getAslPropertyManager() {
    }
}

