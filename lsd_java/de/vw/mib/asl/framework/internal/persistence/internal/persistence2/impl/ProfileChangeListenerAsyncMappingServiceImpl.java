/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl;

import de.vw.mib.asl.framework.api.persistence2.GlobalProfileChangeListener;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.framework.api.persistence2.ProfileChangeListener;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.PersistableService;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.ProfileChangeListenerAsyncMappingService;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.dsi.DsiAwareProfileChangeListenerAdapter;
import de.vw.mib.asl.framework.internal.persistence.internal.servicesprovider.PersistenceServicesProvider;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.threads.AsyncServiceFactory;
import de.vw.mib.util.StringBuilder;
import java.util.HashMap;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;

public class ProfileChangeListenerAsyncMappingServiceImpl
implements ProfileChangeListenerAsyncMappingService {
    private final AsyncServiceFactory asyncServiceFactory;
    private final HashMap dsiAwareListener = new HashMap();
    private final Logger logger;
    private final PersistableService persistableService;
    private final HashMap sync2AsyncProfileListenerMap = new HashMap();
    static /* synthetic */ Class class$de$vw$mib$threads$AsyncServiceFactory;

    public ProfileChangeListenerAsyncMappingServiceImpl(PersistableService persistableService, BundleContext bundleContext, Logger logger) {
        this.checkConstructorArguments(persistableService, bundleContext, logger);
        this.persistableService = persistableService;
        this.asyncServiceFactory = this.retrieveAsyncServiceFactory(bundleContext);
        this.logger = logger;
    }

    @Override
    public void addGlobalProfileChangeListener(GlobalProfileChangeListener globalProfileChangeListener, int n) {
        this.checkArgumentsGlobalProfileChangeListener(globalProfileChangeListener);
        GlobalProfileChangeListener globalProfileChangeListener2 = (GlobalProfileChangeListener)this.createAsyncListener(globalProfileChangeListener);
        this.persistableService.addGlobalProfileChangeListener(globalProfileChangeListener2, n);
    }

    @Override
    public void addProfileChangeListener(PersistenceModule persistenceModule, ProfileChangeListener profileChangeListener) {
        this.checkArgumentsProfileChangeListener(persistenceModule, profileChangeListener);
        this.addDsiAwareListener(persistenceModule, profileChangeListener);
        ProfileChangeListener profileChangeListener2 = (ProfileChangeListener)this.createAsyncListener(profileChangeListener);
        this.persistableService.addProfileChangeListener(persistenceModule, profileChangeListener2);
        String string = profileChangeListener instanceof DsiAwareProfileChangeListenerAdapter ? ((DsiAwareProfileChangeListenerAdapter)profileChangeListener).toString() : super.getClass().getName();
        PersistenceServicesProvider.getPersistenceServices().getPersistenceTracing().registerListener(profileChangeListener2, string);
    }

    @Override
    public void removeGlobalProfileChangeListener(GlobalProfileChangeListener globalProfileChangeListener) {
        if (globalProfileChangeListener == null) {
            if (this.logger.isTraceEnabled(32)) {
                this.logger.trace(32, "[ProfileChangeListenerAsyncMappingServiceImpl] invalid removeGlobalProfileChangeListener call. GlobalProfileChangeListener was null.");
            }
            return;
        }
        if (this.sync2AsyncProfileListenerMap.containsKey(globalProfileChangeListener)) {
            GlobalProfileChangeListener globalProfileChangeListener2 = (GlobalProfileChangeListener)this.removeLocalAsyncListener(globalProfileChangeListener);
            this.persistableService.removeGlobalProfileChangeListener(globalProfileChangeListener2);
        }
    }

    @Override
    public void removeProfileChangeListener(PersistenceModule persistenceModule, ProfileChangeListener profileChangeListener) {
        if (persistenceModule == null || profileChangeListener == null) {
            if (this.logger.isTraceEnabled(32)) {
                LogMessage logMessage = this.logger.trace(32).append("[ProfileChangeListenerAsyncMappingServiceImpl] invalid removeProfileChangeListener call.");
                if (persistenceModule == null) {
                    logMessage = logMessage.append(" PersistenceModule was null.");
                }
                if (profileChangeListener == null) {
                    logMessage = logMessage.append(" ProfileChangeListener was null.");
                }
                logMessage.log();
            }
            return;
        }
        if (this.sync2AsyncProfileListenerMap.containsKey(profileChangeListener)) {
            ProfileChangeListener profileChangeListener2 = (ProfileChangeListener)this.removeLocalAsyncListener(profileChangeListener);
            this.persistableService.removeProfileChangeListener(persistenceModule, profileChangeListener2);
            this.removeDsiAwareListener(persistenceModule, profileChangeListener);
        }
    }

    private void addDsiAwareListener(PersistenceModule persistenceModule, ProfileChangeListener profileChangeListener) {
        if (profileChangeListener instanceof DsiAwareProfileChangeListenerAdapter) {
            if (this.dsiAwareListener.get(persistenceModule) != null) {
                throw new IllegalArgumentException("Only one DsiAwareListener is allowed per PersistenceModule.");
            }
            this.dsiAwareListener.put(persistenceModule, profileChangeListener);
        }
    }

    private void checkArgumentsGlobalProfileChangeListener(GlobalProfileChangeListener globalProfileChangeListener) {
        if (globalProfileChangeListener == null) {
            throw new IllegalArgumentException("GlobalProfileChangeListener must not be null");
        }
    }

    private void checkArgumentsProfileChangeListener(PersistenceModule persistenceModule, ProfileChangeListener profileChangeListener) {
        if (persistenceModule == null) {
            throw new IllegalArgumentException("PersistenceModule must not be null.");
        }
        if (profileChangeListener == null) {
            throw new IllegalArgumentException("ProfileChangeListener must not be null");
        }
    }

    private void checkConstructorArguments(PersistableService persistableService, BundleContext bundleContext, Logger logger) {
        if (persistableService == null) {
            throw new IllegalArgumentException("PersistenceService must not be null.");
        }
        if (bundleContext == null) {
            throw new IllegalArgumentException("BundleContext must not be null.");
        }
        if (logger == null) {
            throw new IllegalArgumentException("Logger must not be null.");
        }
    }

    private Object createAsyncListener(Object object) {
        if (this.sync2AsyncProfileListenerMap.containsKey(object)) {
            throw new IllegalArgumentException("You can not register same ProfileChangeListener twice.");
        }
        Object object2 = this.asyncServiceFactory.create(object);
        this.sync2AsyncProfileListenerMap.put(object, object2);
        return object2;
    }

    private void removeDsiAwareListener(PersistenceModule persistenceModule, ProfileChangeListener profileChangeListener) {
        if (profileChangeListener.equals(this.dsiAwareListener.get(persistenceModule))) {
            this.dsiAwareListener.remove(persistenceModule);
        }
    }

    private Object removeLocalAsyncListener(Object object) {
        Object object2 = this.sync2AsyncProfileListenerMap.get(object);
        this.sync2AsyncProfileListenerMap.remove(object);
        return object2;
    }

    private AsyncServiceFactory retrieveAsyncServiceFactory(BundleContext bundleContext) {
        String string = new StringBuilder().append("(").append("MIBThreadId").append("=").append(3).append(")").toString();
        ServiceReference[] serviceReferenceArray = null;
        try {
            serviceReferenceArray = bundleContext.getServiceReferences((class$de$vw$mib$threads$AsyncServiceFactory == null ? (class$de$vw$mib$threads$AsyncServiceFactory = ProfileChangeListenerAsyncMappingServiceImpl.class$("de.vw.mib.threads.AsyncServiceFactory")) : class$de$vw$mib$threads$AsyncServiceFactory).getName(), string);
        }
        catch (InvalidSyntaxException invalidSyntaxException) {
            throw new RuntimeException("Invalid filter.");
        }
        if (serviceReferenceArray == null || serviceReferenceArray.length != 1 || serviceReferenceArray[0] == null) {
            throw new RuntimeException("Could not find AsyncServiceFactory which is mandantory for the Persistence ASL.");
        }
        ServiceReference serviceReference = serviceReferenceArray[0];
        AsyncServiceFactory asyncServiceFactory = (AsyncServiceFactory)bundleContext.getService(serviceReference);
        return asyncServiceFactory;
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

