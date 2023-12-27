/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.displaymanagement;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.api.infotainmentrecorder.ASLInfotainmentrecorderAPI;
import de.vw.mib.asl.api.navigation.ASLNavigationAPI;
import de.vw.mib.asl.api.system.ASLSystemAPI;
import de.vw.mib.asl.framework.api.displaymanagement.WritableHelper;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.internal.displaymanagement.DisplayTimer;
import de.vw.mib.asl.framework.internal.impl.displaymanagement.DisplayableServiceImpl;
import de.vw.mib.configuration.ConfigurationManagerDiag;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.perf.service.PerfService;
import de.vw.mib.threads.AsyncServiceFactory;
import de.vw.mib.timer.TimerManager;
import org.osgi.framework.BundleContext;

public interface DisplayManagementServices {
    default public AsyncServiceFactory getAslAsyncServiceFactory() {
    }

    default public ConfigurationManagerDiag getConfigurationManager() {
    }

    default public GenericEvents getGenericEvents() {
    }

    default public ASLInfotainmentrecorderAPI getAslInfotainmentrecorderApi() {
    }

    default public ASLNavigationAPI getAslNavigationApi() {
    }

    default public ASLSystemAPI getAslSystemApi() {
    }

    default public TimerManager getTimerManager() {
    }

    default public DSIProxy getDsiProxy() {
    }

    default public Logger getLogger() {
    }

    default public WritableHelper getWritableHelper() {
    }

    default public BundleContext getBundleContext() {
    }

    default public PerfService getPerfService() {
    }

    default public ASLPropertyManager getAslPropertyManager() {
    }

    default public DisplayTimer getDisplayTimer() {
    }

    default public DisplayableServiceImpl getDisplayableService() {
    }
}

