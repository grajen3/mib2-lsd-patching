/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.activators;

import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.startupv7r.StartupServiceManager;
import de.vw.mib.asl.framework.internal.startupv7r.activators.ASLBasicActivator;
import de.vw.mib.configuration.ConfigurationManagerDiag;
import de.vw.mib.framework4u.Framework4U;
import de.vw.mib.log4mib.LoggerFactory;
import org.osgi.framework.BundleContext;

public class ASLStdDelphiActivator
extends ASLBasicActivator {
    private static boolean preloadWasCalledAccidentally = false;
    static /* synthetic */ Class class$de$vw$mib$configuration$ConfigurationManager;
    static /* synthetic */ Class class$de$vw$mib$framework4u$Framework4U;
    static /* synthetic */ Class class$de$vw$mib$log4mib$LoggerFactory;

    @Override
    public void preload(BundleContext bundleContext) {
        preloadWasCalledAccidentally = true;
    }

    @Override
    public void start(BundleContext bundleContext) {
        ASLFactoryBase.bundleContext = bundleContext;
        ServiceManager.configManagerDiag = (ConfigurationManagerDiag)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$configuration$ConfigurationManager == null ? (class$de$vw$mib$configuration$ConfigurationManager = ASLStdDelphiActivator.class$("de.vw.mib.configuration.ConfigurationManager")) : class$de$vw$mib$configuration$ConfigurationManager).getName()));
        ServiceManager.framework4U = (Framework4U)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$framework4u$Framework4U == null ? (class$de$vw$mib$framework4u$Framework4U = ASLStdDelphiActivator.class$("de.vw.mib.framework4u.Framework4U")) : class$de$vw$mib$framework4u$Framework4U).getName()));
        ASLFactoryBase.logger = ServiceManager.logger = ((LoggerFactory)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$log4mib$LoggerFactory == null ? (class$de$vw$mib$log4mib$LoggerFactory = ASLStdDelphiActivator.class$("de.vw.mib.log4mib.LoggerFactory")) : class$de$vw$mib$log4mib$LoggerFactory).getName()))).getLogger(1);
        ASLFactoryBase.logger2 = ServiceManager.logger2 = ((LoggerFactory)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$log4mib$LoggerFactory == null ? (class$de$vw$mib$log4mib$LoggerFactory = ASLStdDelphiActivator.class$("de.vw.mib.log4mib.LoggerFactory")) : class$de$vw$mib$log4mib$LoggerFactory).getName()))).getLogger(32768);
        if (preloadWasCalledAccidentally) {
            ServiceManager.logger.error(1, "ASLStdDelphiActivator - preload was called but should not");
        }
        StartupServiceManager.isHighActivatorStarted = false;
        StartupServiceManager.setCurrentVariantInformation(3);
        super.preload(bundleContext);
        super.start(bundleContext);
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

