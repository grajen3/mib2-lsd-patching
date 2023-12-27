/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.bap;

import de.vw.mib.asl.api.bap.BAPInterfaceProvider;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.persistence.AslPersistenceSyncApi;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.internal.bap.BAPStartUpPQTarget$BapStartupState;
import de.vw.mib.bap.mqbpq.ServiceManager;
import de.vw.mib.bap.mqbpq.audiosd.controller.AudioSdTarget;
import de.vw.mib.bap.mqbpq.common.api.asl.audio.ASLSpeech;
import de.vw.mib.bap.mqbpq.navsd.controller.NavSdTarget;
import de.vw.mib.bap.stream.BitStreamTransformer;
import de.vw.mib.configuration.ConfigurationManager;
import de.vw.mib.datapool.ASLDatapool;
import de.vw.mib.event.dispatcher.SystemEventDispatcher;
import de.vw.mib.format.FixFormat;
import de.vw.mib.genericevents.EventFactory;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.ThreadSwitchingTarget;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.log4mib.LoggerFactory;
import java.util.ArrayList;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;

public class BAPStartUpPQTarget
extends AbstractASLHsmTarget
implements ServiceListener {
    private ArrayList bapLogicalControlUnits = null;
    protected final HsmState bapStartupState = new BAPStartUpPQTarget$BapStartupState(this, this.getHsm(), "Startup", super.getWorkStateParent());
    static /* synthetic */ Class class$de$vw$mib$log4mib$LoggerFactory;
    static /* synthetic */ Class class$de$vw$mib$genericevents$GenericEvents;
    static /* synthetic */ Class class$de$vw$mib$genericevents$EventFactory;
    static /* synthetic */ Class class$de$vw$mib$format$FixFormat4Bap;
    static /* synthetic */ Class class$de$vw$mib$datapool$ASLDatapool;
    static /* synthetic */ Class class$de$vw$mib$configuration$ConfigurationManager;
    static /* synthetic */ Class class$de$vw$mib$event$dispatcher$SystemEventDispatcher;
    static /* synthetic */ Class class$de$vw$mib$asl$framework$api$persistence$AslPersistenceSyncApi;
    static /* synthetic */ Class class$de$vw$mib$event$consumer$BAPSystemEventConsumer;

    public BAPStartUpPQTarget(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        this.initTarget();
    }

    @Override
    public int getDefaultTargetId() {
        return -1839720704;
    }

    public Logger getLogger() {
        if (ServiceManager.serviceManager.logger == null) {
            return ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger();
        }
        return ServiceManager.serviceManager.logger;
    }

    @Override
    protected HsmState getDefaultState() {
        return this.bapStartupState;
    }

    private void initTarget() {
        ServiceManager.createNewInstance();
        this.createLogger();
        this.createBitStreamTransformer();
        this.getServiceReferences();
        this.createBAPDispatcher();
        this.createBAPHandler();
        try {
            this.retrievePersistenceService();
        }
        catch (Exception exception) {
            this.getLogger().error(1, "BAPStartUpPQTarget cannot get PersistenceService!", exception);
        }
        try {
            this.retrieveThreadSwitchingTargetService();
        }
        catch (Exception exception) {
            this.getLogger().error(1, "BAPStartUpPQTarget cannot get ThreadSwitchingTarget!", exception);
        }
    }

    private void createLogger() {
        LoggerFactory loggerFactory = (LoggerFactory)this.getService(class$de$vw$mib$log4mib$LoggerFactory == null ? (class$de$vw$mib$log4mib$LoggerFactory = BAPStartUpPQTarget.class$("de.vw.mib.log4mib.LoggerFactory")) : class$de$vw$mib$log4mib$LoggerFactory);
        if (loggerFactory != null) {
            ServiceManager.serviceManager.logger = loggerFactory.getLogger(2);
        }
    }

    private void getServiceReferences() {
        ASLSpeech.init();
        ServiceManager.serviceManager.genericEvents = (GenericEvents)this.getService(class$de$vw$mib$genericevents$GenericEvents == null ? (class$de$vw$mib$genericevents$GenericEvents = BAPStartUpPQTarget.class$("de.vw.mib.genericevents.GenericEvents")) : class$de$vw$mib$genericevents$GenericEvents);
        ServiceManager.serviceManager.genericEventFactory = (EventFactory)this.getService(class$de$vw$mib$genericevents$EventFactory == null ? (class$de$vw$mib$genericevents$EventFactory = BAPStartUpPQTarget.class$("de.vw.mib.genericevents.EventFactory")) : class$de$vw$mib$genericevents$EventFactory);
        ServiceManager.serviceManager.fixFormat = (FixFormat)this.getService(class$de$vw$mib$format$FixFormat4Bap == null ? (class$de$vw$mib$format$FixFormat4Bap = BAPStartUpPQTarget.class$("de.vw.mib.format.FixFormat4Bap")) : class$de$vw$mib$format$FixFormat4Bap);
        ServiceManager.serviceManager.dataPool = (ASLDatapool)this.getService(class$de$vw$mib$datapool$ASLDatapool == null ? (class$de$vw$mib$datapool$ASLDatapool = BAPStartUpPQTarget.class$("de.vw.mib.datapool.ASLDatapool")) : class$de$vw$mib$datapool$ASLDatapool);
        ServiceManager.serviceManager.configurationManager = (ConfigurationManager)this.getService(class$de$vw$mib$configuration$ConfigurationManager == null ? (class$de$vw$mib$configuration$ConfigurationManager = BAPStartUpPQTarget.class$("de.vw.mib.configuration.ConfigurationManager")) : class$de$vw$mib$configuration$ConfigurationManager);
        ServiceManager.serviceManager.systemEventDispatcher = (SystemEventDispatcher)this.getService(class$de$vw$mib$event$dispatcher$SystemEventDispatcher == null ? (class$de$vw$mib$event$dispatcher$SystemEventDispatcher = BAPStartUpPQTarget.class$("de.vw.mib.event.dispatcher.SystemEventDispatcher")) : class$de$vw$mib$event$dispatcher$SystemEventDispatcher);
    }

    private Object getService(Class clazz) {
        ServiceReference serviceReference = this.getBundleContext().getServiceReference(clazz.getName());
        Object object = serviceReference != null ? this.getBundleContext().getService(serviceReference) : null;
        return object;
    }

    private Object getServiceOrRegisterForServiceChange(Class clazz) {
        Object object = this.getService(clazz);
        if (object == null) {
            this.logInfo(clazz.getName(), " service doesn't exist.");
            StringBuffer stringBuffer = new StringBuffer(100);
            stringBuffer.append("(").append("objectClass").append("=").append(clazz.getName()).append(")");
            String string = stringBuffer.toString();
            this.getBundleContext().addServiceListener(this, string);
        }
        return object;
    }

    private void logInfo(String string, String string2) {
        if (ServiceManager.serviceManager.logger != null) {
            ServiceManager.serviceManager.logger.info(1).append(string).append(string2).log();
        }
    }

    private void retrieveThreadSwitchingTargetService() {
        ServiceManager.serviceManager.threadSwitchingTarget = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLThreadSwitch();
    }

    private void retrievePersistenceService() {
        ServiceManager.serviceManager.persistence = (AslPersistenceSyncApi)this.getServiceOrRegisterForServiceChange(class$de$vw$mib$asl$framework$api$persistence$AslPersistenceSyncApi == null ? (class$de$vw$mib$asl$framework$api$persistence$AslPersistenceSyncApi = BAPStartUpPQTarget.class$("de.vw.mib.asl.framework.api.persistence.AslPersistenceSyncApi")) : class$de$vw$mib$asl$framework$api$persistence$AslPersistenceSyncApi);
        if (ServiceManager.serviceManager.persistence != null) {
            ServiceManager.serviceManager.bapDispatcher.informPersistenceAvailability();
        }
    }

    private void createBAPDispatcher() {
        ServiceManager.serviceManager.bapDispatcher = new BAPInterfaceProvider(this.getBundleContext()).getBapDispatcher();
        this.getBundleContext().registerService((class$de$vw$mib$event$consumer$BAPSystemEventConsumer == null ? (class$de$vw$mib$event$consumer$BAPSystemEventConsumer = BAPStartUpPQTarget.class$("de.vw.mib.event.consumer.BAPSystemEventConsumer")) : class$de$vw$mib$event$consumer$BAPSystemEventConsumer).getName(), (Object)ServiceManager.serviceManager.bapDispatcher, null);
    }

    private void startBAPDispatcher() {
        ServiceManager.serviceManager.bapDispatcher.registerLogicalControlUnits(this.bapLogicalControlUnits, false);
    }

    private void createBitStreamTransformer() {
        ServiceManager.serviceManager.bitStreamTransformer = new BitStreamTransformer();
    }

    private void createBAPHandler() {
        this.createBAPHandlerForMqbPq();
    }

    private void createAudioSDControlUnitPq() {
        this.bapLogicalControlUnits.add(new AudioSdTarget().getLogicalControlUnit());
    }

    private void createNavSDControlUnitPq() {
        this.bapLogicalControlUnits.add(new NavSdTarget().getLogicalControlUnit());
    }

    private void createBAPHandlerForMqbPq() {
        this.bapLogicalControlUnits = new ArrayList();
        this.createAudioSDControlUnitPq();
        if (ServiceManager.serviceManager.configurationManager.isFeatureFlagSet(367) || ServiceManager.serviceManager.configurationManager.isFeatureFlagSet(2)) {
            this.createNavSDControlUnitPq();
        }
    }

    private BundleContext getBundleContext() {
        return ASLFrameworkFactory.getASLFrameworkAPI().getServices().getBundleContext();
    }

    @Override
    public void serviceChanged(ServiceEvent serviceEvent) {
        Object object = this.getBundleContext().getService(serviceEvent.getServiceReference());
        if (ServiceManager.serviceManager.persistence == null && object instanceof AslPersistenceSyncApi) {
            ServiceManager.serviceManager.persistence = (AslPersistenceSyncApi)object;
            ServiceManager.serviceManager.bapDispatcher.informPersistenceAvailability();
        } else if (ServiceManager.serviceManager.threadSwitchingTarget == null && object instanceof ThreadSwitchingTarget) {
            ServiceManager.serviceManager.threadSwitchingTarget = (ThreadSwitchingTarget)object;
        }
        if (ServiceManager.serviceManager.persistence != null && ServiceManager.serviceManager.threadSwitchingTarget != null) {
            this.getBundleContext().removeServiceListener(this);
        }
    }

    static /* synthetic */ void access$000(BAPStartUpPQTarget bAPStartUpPQTarget) {
        bAPStartUpPQTarget.startBAPDispatcher();
    }

    static /* synthetic */ HsmState access$100(BAPStartUpPQTarget bAPStartUpPQTarget) {
        return bAPStartUpPQTarget.stateTop;
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

