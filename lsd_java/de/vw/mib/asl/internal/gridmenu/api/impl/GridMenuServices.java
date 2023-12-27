/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.gridmenu.api.impl;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.api.system.ASLSystemAPI;
import de.vw.mib.asl.gridmenu.persistence.GridMenuPersistenceService;
import de.vw.mib.asl.internal.list.ASLListManager;
import de.vw.mib.cio.CioDictionary;
import de.vw.mib.cio.CioDispatcher;
import de.vw.mib.configuration.ConfigurationManagerDiag;
import de.vw.mib.debug.screenshot.ScreenshotProvider;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.ServiceRegister;
import de.vw.mib.log4mib.Logger;

public interface GridMenuServices {
    default public ASLListManager getAslListManager() {
    }

    default public ASLPropertyManager getASLPropertyManager() {
    }

    default public CioDictionary getCioDictionary() {
    }

    default public CioDispatcher getCioDispatcher() {
    }

    default public ConfigurationManagerDiag getConfigurationManager() {
    }

    default public GenericEvents getGenericEvents() {
    }

    default public Logger getLogger() {
    }

    default public GridMenuPersistenceService getPersistenceService() {
    }

    default public ScreenshotProvider getScreenshotProvider() {
    }

    default public ServiceRegister getServiceRegister() {
    }

    default public ASLSystemAPI getSystemAPI() {
    }
}

