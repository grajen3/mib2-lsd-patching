/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.bap;

import de.vw.mib.asl.api.bap.dispatcher.BAPDispatcher;
import de.vw.mib.genericevents.EventFactory;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.log4mib.LoggerFactory;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class BAPInterfaceProvider {
    private static BAPDispatcher _bapDispatcher = null;
    private BundleContext _bundleContext;
    static /* synthetic */ Class class$de$vw$mib$genericevents$GenericEvents;
    static /* synthetic */ Class class$de$vw$mib$genericevents$EventFactory;
    static /* synthetic */ Class class$de$vw$mib$log4mib$LoggerFactory;

    public BAPInterfaceProvider(BundleContext bundleContext) {
        this._bundleContext = bundleContext;
    }

    public BAPDispatcher getBapDispatcher() {
        if (_bapDispatcher == null) {
            _bapDispatcher = this.createBapDispatcher();
        }
        return _bapDispatcher;
    }

    private BAPDispatcher createBapDispatcher() {
        BAPDispatcher bAPDispatcher;
        GenericEvents genericEvents = (GenericEvents)this.getService(class$de$vw$mib$genericevents$GenericEvents == null ? (class$de$vw$mib$genericevents$GenericEvents = BAPInterfaceProvider.class$("de.vw.mib.genericevents.GenericEvents")) : class$de$vw$mib$genericevents$GenericEvents);
        EventFactory eventFactory = (EventFactory)this.getService(class$de$vw$mib$genericevents$EventFactory == null ? (class$de$vw$mib$genericevents$EventFactory = BAPInterfaceProvider.class$("de.vw.mib.genericevents.EventFactory")) : class$de$vw$mib$genericevents$EventFactory);
        try {
            bAPDispatcher = (BAPDispatcher)Class.forName("de.vw.mib.bap.internal.dispatcher.BAPDispatcherTarget").newInstance();
            bAPDispatcher.initialize(genericEvents, eventFactory);
        }
        catch (Exception exception) {
            this.createLogger().error(1, "Could not create BAP dispatcher", exception);
            bAPDispatcher = null;
        }
        return bAPDispatcher;
    }

    private Logger createLogger() {
        Logger logger = null;
        LoggerFactory loggerFactory = (LoggerFactory)this.getService(class$de$vw$mib$log4mib$LoggerFactory == null ? (class$de$vw$mib$log4mib$LoggerFactory = BAPInterfaceProvider.class$("de.vw.mib.log4mib.LoggerFactory")) : class$de$vw$mib$log4mib$LoggerFactory);
        if (loggerFactory != null) {
            logger = loggerFactory.getLogger(2);
        }
        return logger;
    }

    private Object getService(Class clazz) {
        ServiceReference serviceReference = this._bundleContext.getServiceReference(clazz.getName());
        Object object = serviceReference != null ? this._bundleContext.getService(serviceReference) : null;
        return object;
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

