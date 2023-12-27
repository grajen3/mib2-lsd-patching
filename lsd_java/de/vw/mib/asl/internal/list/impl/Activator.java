/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.list.impl;

import de.vw.mib.asl.internal.list.impl.ASLListFactoryImpl;
import de.vw.mib.asl.internal.list.impl.Activator$ServicesImpl;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceRegistryImpl;
import de.vw.mib.log4mib.LogMessage;
import java.util.Dictionary;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator
implements BundleActivator {
    private BundleContext context;
    private Activator$ServicesImpl services;
    private ServiceRegistration listFactoryRegistration;
    private ServiceRegistration deviceRegistryRegistration;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$list$ASLListFactory;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$registry$ASLDeviceRegistry;
    static /* synthetic */ Class class$de$vw$mib$log4mib$LoggerFactory;
    static /* synthetic */ Class class$de$vw$mib$timer$TimerManager;
    static /* synthetic */ Class class$de$vw$mib$genericevents$ThreadSwitchingTarget;

    @Override
    public void start(BundleContext bundleContext) {
        this.context = bundleContext;
        this.services = new Activator$ServicesImpl(this, this.context);
        this.services.open();
        LogMessage logMessage = this.services.getASLListLog().info();
        if (null != logMessage) {
            logMessage.append("Activator started.").log();
        }
        ASLListFactoryImpl aSLListFactoryImpl = new ASLListFactoryImpl(this.services);
        this.listFactoryRegistration = bundleContext.registerService((class$de$vw$mib$asl$internal$list$ASLListFactory == null ? (class$de$vw$mib$asl$internal$list$ASLListFactory = Activator.class$("de.vw.mib.asl.internal.list.ASLListFactory")) : class$de$vw$mib$asl$internal$list$ASLListFactory).getName(), (Object)aSLListFactoryImpl, (Dictionary)null);
        ASLDeviceRegistryImpl aSLDeviceRegistryImpl = new ASLDeviceRegistryImpl(aSLListFactoryImpl);
        this.deviceRegistryRegistration = bundleContext.registerService((class$de$vw$mib$asl$internal$registry$ASLDeviceRegistry == null ? (class$de$vw$mib$asl$internal$registry$ASLDeviceRegistry = Activator.class$("de.vw.mib.asl.internal.registry.ASLDeviceRegistry")) : class$de$vw$mib$asl$internal$registry$ASLDeviceRegistry).getName(), (Object)aSLDeviceRegistryImpl, (Dictionary)null);
    }

    @Override
    public void stop(BundleContext bundleContext) {
        LogMessage logMessage;
        if (null != this.deviceRegistryRegistration) {
            this.deviceRegistryRegistration.unregister();
            this.deviceRegistryRegistration = null;
        }
        if (null != this.listFactoryRegistration) {
            this.listFactoryRegistration.unregister();
            this.listFactoryRegistration = null;
        }
        if (null != (logMessage = this.services.getASLListLog().info())) {
            logMessage.append("Activator stopped.").log();
        }
        this.services.close();
        this.services = null;
        this.context = null;
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

