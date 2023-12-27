/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.list.impl;

import de.vw.mib.list.impl.HMIListDataFactoryImpl;
import de.vw.mib.list.impl.HMIListRegistryImpl;
import java.util.Dictionary;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator
implements BundleActivator {
    private ServiceRegistration srHMIListDataFactory;
    private ServiceRegistration srHMIListRegistry;
    static /* synthetic */ Class class$de$vw$mib$list$HMIListDataFactory;
    static /* synthetic */ Class class$de$vw$mib$list$HMIListRegistry;

    @Override
    public void start(BundleContext bundleContext) {
        HMIListDataFactoryImpl hMIListDataFactoryImpl = new HMIListDataFactoryImpl();
        this.srHMIListDataFactory = bundleContext.registerService((class$de$vw$mib$list$HMIListDataFactory == null ? (class$de$vw$mib$list$HMIListDataFactory = Activator.class$("de.vw.mib.list.HMIListDataFactory")) : class$de$vw$mib$list$HMIListDataFactory).getName(), (Object)hMIListDataFactoryImpl, (Dictionary)null);
        HMIListRegistryImpl hMIListRegistryImpl = new HMIListRegistryImpl();
        this.srHMIListRegistry = bundleContext.registerService((class$de$vw$mib$list$HMIListRegistry == null ? (class$de$vw$mib$list$HMIListRegistry = Activator.class$("de.vw.mib.list.HMIListRegistry")) : class$de$vw$mib$list$HMIListRegistry).getName(), (Object)hMIListRegistryImpl, (Dictionary)null);
    }

    @Override
    public void stop(BundleContext bundleContext) {
        if (null != this.srHMIListRegistry) {
            this.srHMIListRegistry.unregister();
            this.srHMIListRegistry = null;
        }
        if (null != this.srHMIListDataFactory) {
            this.srHMIListDataFactory.unregister();
            this.srHMIListDataFactory = null;
        }
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

