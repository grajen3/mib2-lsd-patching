/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.tvtuner.common;

import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.internal.tvtuner.common.TVTunerHelper;
import de.vw.mib.cio.CioDictionary;
import de.vw.mib.cio.CioDispatcher;
import de.vw.mib.cio.CioFactory;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class TVTunerCioHelper {
    private static BundleContext bundleContext = null;
    private static CioDictionary dictionary = null;
    private static CioDispatcher dispatcher = null;
    private static CioFactory factory = null;
    static /* synthetic */ Class class$de$vw$mib$cio$CioFactory;
    static /* synthetic */ Class class$de$vw$mib$cio$CioDictionary;
    static /* synthetic */ Class class$de$vw$mib$cio$CioDispatcher;

    public TVTunerCioHelper() {
        bundleContext = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getBundleContext();
    }

    public CioFactory getCioFactory() {
        if (factory == null && bundleContext != null) {
            ServiceReference serviceReference = bundleContext.getServiceReference((class$de$vw$mib$cio$CioFactory == null ? (class$de$vw$mib$cio$CioFactory = TVTunerCioHelper.class$("de.vw.mib.cio.CioFactory")) : class$de$vw$mib$cio$CioFactory).getName());
            if (serviceReference == null && TVTunerHelper.isTraceEnabled()) {
                TVTunerHelper.warn("Cio Factory not available");
            } else {
                factory = (CioFactory)bundleContext.getService(serviceReference);
            }
        }
        return factory;
    }

    public CioDictionary getCioDictionary() {
        if (dictionary == null && bundleContext != null) {
            ServiceReference serviceReference = bundleContext.getServiceReference((class$de$vw$mib$cio$CioDictionary == null ? (class$de$vw$mib$cio$CioDictionary = TVTunerCioHelper.class$("de.vw.mib.cio.CioDictionary")) : class$de$vw$mib$cio$CioDictionary).getName());
            if (serviceReference == null && TVTunerHelper.isTraceEnabled()) {
                TVTunerHelper.warn("Cio Dictonary not available");
            } else {
                dictionary = (CioDictionary)bundleContext.getService(serviceReference);
            }
        }
        return dictionary;
    }

    public CioDispatcher getCioDispatcher() {
        if (dispatcher == null && bundleContext != null) {
            ServiceReference serviceReference = bundleContext.getServiceReference((class$de$vw$mib$cio$CioDispatcher == null ? (class$de$vw$mib$cio$CioDispatcher = TVTunerCioHelper.class$("de.vw.mib.cio.CioDispatcher")) : class$de$vw$mib$cio$CioDispatcher).getName());
            if (serviceReference == null && TVTunerHelper.isTraceEnabled()) {
                TVTunerHelper.warn("Cio Dispatcher not available");
            } else {
                dispatcher = (CioDispatcher)bundleContext.getService(serviceReference);
            }
        }
        return dispatcher;
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

