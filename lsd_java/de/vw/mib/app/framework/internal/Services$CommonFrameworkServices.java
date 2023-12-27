/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.framework.internal;

import de.vw.mib.asl.clientapi.ASLClientAPIRegistry;
import de.vw.mib.list.HMIListDataFactory;
import de.vw.mib.list.HMIListRegistry;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.log4mib.LoggerFactory;
import org.osgi.framework.BundleContext;

final class Services$CommonFrameworkServices {
    private final ASLClientAPIRegistry aslClientApiRegistry;
    private final BundleContext bundleContext;
    private final HMIListDataFactory hmiListDataFactory;
    private final HMIListRegistry hmiListRegistry;
    private final Logger logger;
    private final LoggerFactory loggerFactory;

    Services$CommonFrameworkServices(BundleContext bundleContext, LoggerFactory loggerFactory, ASLClientAPIRegistry aSLClientAPIRegistry, HMIListDataFactory hMIListDataFactory, HMIListRegistry hMIListRegistry) {
        this.bundleContext = bundleContext;
        this.loggerFactory = loggerFactory;
        this.aslClientApiRegistry = aSLClientAPIRegistry;
        this.hmiListDataFactory = hMIListDataFactory;
        this.hmiListRegistry = hMIListRegistry;
        this.logger = loggerFactory.getLogger(128);
    }

    public ASLClientAPIRegistry getAslClientApiRegistry() {
        return this.aslClientApiRegistry;
    }

    BundleContext getBundleContext() {
        return this.bundleContext;
    }

    HMIListDataFactory getHmiListDataFactory() {
        return this.hmiListDataFactory;
    }

    HMIListRegistry getHmiListRegistry() {
        return this.hmiListRegistry;
    }

    Logger getLogger() {
        return this.logger;
    }

    Logger getLogger(int n) {
        return this.loggerFactory.getLogger(n);
    }
}

