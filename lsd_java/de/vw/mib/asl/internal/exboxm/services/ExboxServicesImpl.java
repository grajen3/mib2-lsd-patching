/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.exboxm.services;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.api.system.ASLSystemAPI;
import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetService;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkAPI;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.exboxm.services.ExboxServices;
import de.vw.mib.asl.internal.exboxm.services.ServiceFactory;
import de.vw.mib.asl.internal.exboxm.services.StartupService;
import de.vw.mib.asl.internal.exboxm.services.StartupServiceImpl;
import de.vw.mib.asl.internal.exboxm.state.ExboxStateService;
import de.vw.mib.genericevents.EventFactory;
import de.vw.mib.genericevents.ThreadSwitchingTarget;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.proximation.ProximityInstaller;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class ExboxServicesImpl
implements ExboxServices {
    private final Logger logger = ASLFrameworkFactory.getASLFrameworkAPI().getASL2Logger();
    private final StartupService startupService = new StartupServiceImpl(this.logger);
    private ProximityInstaller proximityInstaller;
    private final ExboxStateService exbboxStateService = ServiceFactory.createExboxStateService(this);
    static /* synthetic */ Class class$de$vw$mib$proximation$ProximityInstaller;

    ExboxServicesImpl() {
    }

    @Override
    public ASLFrameworkAPI getAslFrameworkApi() {
        return ASLFrameworkFactory.getASLFrameworkAPI();
    }

    @Override
    public ASLPropertyManager getAslPropertyManager() {
        return this.getAslFrameworkApi().getServices().getASLPropertyManager();
    }

    @Override
    public ASLSystemAPI getAslSystemApi() {
        return ASLSystemFactory.getSystemApi();
    }

    @Override
    public ThreadSwitchingTarget getAslThreadSwitchingTarget() {
        return this.getAslFrameworkApi().getServices().getASLThreadSwitch();
    }

    @Override
    public BundleContext getBundleContext() {
        return this.getAslFrameworkApi().getServices().getBundleContext();
    }

    @Override
    public DSIProxy getDSIProxy() {
        return DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
    }

    @Override
    public EventFactory getEventFactory() {
        return ServiceManager.mGenericEventFactory;
    }

    @Override
    public FactoryResetService getFactoryResetService() {
        return ASLSystemFactory.getSystemApi().getFactoryResetService();
    }

    @Override
    public StartupService getInternalStartupService() {
        return this.startupService;
    }

    @Override
    public Logger getLogger() {
        return this.logger;
    }

    @Override
    public ProximityInstaller getProximityInstaller() {
        if (this.proximityInstaller == null) {
            this.proximityInstaller = (ProximityInstaller)this.getOsgiService(this.getBundleContext(), class$de$vw$mib$proximation$ProximityInstaller == null ? (class$de$vw$mib$proximation$ProximityInstaller = ExboxServicesImpl.class$("de.vw.mib.proximation.ProximityInstaller")) : class$de$vw$mib$proximation$ProximityInstaller);
        }
        return this.proximityInstaller;
    }

    private Object getOsgiService(BundleContext bundleContext, Class clazz) {
        ServiceReference serviceReference = bundleContext.getServiceReference(clazz.getName());
        return bundleContext.getService(serviceReference);
    }

    @Override
    public ExboxStateService getExboxStateService() {
        return this.exbboxStateService;
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

