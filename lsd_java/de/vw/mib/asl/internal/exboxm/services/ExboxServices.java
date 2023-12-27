/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.exboxm.services;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.api.system.ASLSystemAPI;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetService;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkAPI;
import de.vw.mib.asl.internal.exboxm.services.StartupService;
import de.vw.mib.asl.internal.exboxm.state.ExboxStateService;
import de.vw.mib.genericevents.EventFactory;
import de.vw.mib.genericevents.ThreadSwitchingTarget;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.proximation.ProximityInstaller;
import org.osgi.framework.BundleContext;

public interface ExboxServices {
    default public ASLFrameworkAPI getAslFrameworkApi() {
    }

    default public ASLPropertyManager getAslPropertyManager() {
    }

    default public ASLSystemAPI getAslSystemApi() {
    }

    default public ThreadSwitchingTarget getAslThreadSwitchingTarget() {
    }

    default public BundleContext getBundleContext() {
    }

    default public DSIProxy getDSIProxy() {
    }

    default public EventFactory getEventFactory() {
    }

    default public FactoryResetService getFactoryResetService() {
    }

    default public StartupService getInternalStartupService() {
    }

    default public Logger getLogger() {
    }

    default public ProximityInstaller getProximityInstaller() {
    }

    default public ExboxStateService getExboxStateService() {
    }
}

