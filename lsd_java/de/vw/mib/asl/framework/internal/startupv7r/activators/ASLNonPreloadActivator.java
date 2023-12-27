/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.activators;

import de.vw.mib.asl.framework.internal.startupv7r.activators.ASLHighEsolutionsActivator;
import de.vw.mib.log4mib.LoggerFactory;
import org.osgi.framework.BundleContext;

public class ASLNonPreloadActivator
extends ASLHighEsolutionsActivator {
    static /* synthetic */ Class class$de$vw$mib$log4mib$LoggerFactory;

    @Override
    public void start(BundleContext bundleContext) {
        ((LoggerFactory)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$log4mib$LoggerFactory == null ? (class$de$vw$mib$log4mib$LoggerFactory = ASLNonPreloadActivator.class$("de.vw.mib.log4mib.LoggerFactory")) : class$de$vw$mib$log4mib$LoggerFactory).getName()))).getLogger(1).error(1, "Obsolete NonPreloadActivator was called in SOP2 Version - Rerouting to ASLHighEsolutionsActivator");
        super.start(bundleContext);
    }

    @Override
    public void stop(BundleContext bundleContext) {
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

