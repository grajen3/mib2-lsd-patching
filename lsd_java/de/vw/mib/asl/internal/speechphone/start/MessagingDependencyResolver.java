/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.start;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.ASLTimeAndDateServiceTarget;
import de.vw.mib.asl.api.messages.services.available.MessageAvailableService;
import de.vw.mib.asl.api.messages.services.detail.MessageDetailService;
import de.vw.mib.asl.api.messages.services.status.MessagesStatusService;
import de.vw.mib.asl.api.phone.PhoneService;
import de.vw.mib.asl.api.speechengine.SpeechEngine;
import de.vw.mib.asl.api.speechengine.result.handling.ResultControllerRouter;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.framework.Services;
import de.vw.mib.asl.framework.api.framework.component.ASLComponentRegistry;
import de.vw.mib.asl.internal.speechphone.messages2.MessagingComponentStarter;
import de.vw.mib.asl.internal.speechphone.messages2.start.MessagingParameters;
import de.vw.mib.asl.internal.speechphone.start.MessagingDependencyResolver$1;
import de.vw.mib.asl.internal.speechphone.utils.SpeechPhoneClassifiedLogger;
import de.vw.mib.asl.internal.speechphone.utils.SpeechPhoneLogger2;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;
import de.vw.mib.configuration.ConfigurationManager;
import de.vw.mib.event.dispatcher.SystemEventDispatcher;
import de.vw.mib.genericevents.EventDispatcherHSM;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.ServiceRegister;
import de.vw.mib.genericevents.ThreadSwitchingTarget;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.timer.TimerManager;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class MessagingDependencyResolver
implements MessagingParameters {
    SpeechPhoneClassifiedLogger classifiedLogger;
    SpeechPhoneLogger2 logger;
    SpeechEngine speechEngine = null;
    BundleContext bundleContext;
    Services services;
    ASLComponentRegistry registry;
    ConfigurationManager configurationManager;
    PhoneService phoneService;
    MessageAvailableService messageAvailableService;
    MessagesStatusService messagesStatusService;
    MessageDetailService messageDetailService;
    ThreadSwitchingTarget threadSwitchingTarget;
    private final String taskId;
    ASLTimeAndDateServiceTarget aslTimeAndDateServiceTarget;
    static /* synthetic */ Class class$de$vw$mib$log4mib$LoggerFactory;
    static /* synthetic */ Class class$de$vw$mib$asl$api$speechengine$SpeechEngine;
    static /* synthetic */ Class class$de$vw$mib$asl$api$phone$PhoneService;
    static /* synthetic */ Class class$de$vw$mib$asl$api$messages$services$available$MessageAvailableService;
    static /* synthetic */ Class class$de$vw$mib$asl$api$messages$services$status$MessagesStatusService;
    static /* synthetic */ Class class$de$vw$mib$asl$api$messages$services$detail$MessageDetailService;
    static /* synthetic */ Class class$de$vw$mib$configuration$ConfigurationManager;
    static /* synthetic */ Class class$de$vw$mib$genericevents$ThreadSwitchingTarget;
    static /* synthetic */ Class class$de$vw$mib$asl$ASLTimeAndDateServiceTarget;

    public MessagingDependencyResolver(String string) {
        this.taskId = string;
        this.services = ASLFrameworkFactory.getASLFrameworkAPI().getServices();
        this.registry = this.services.getASLComponentRegistry();
        this.bundleContext = this.services.getBundleContext();
        ServiceReference serviceReference = this.bundleContext.getServiceReference((class$de$vw$mib$log4mib$LoggerFactory == null ? (class$de$vw$mib$log4mib$LoggerFactory = MessagingDependencyResolver.class$("de.vw.mib.log4mib.LoggerFactory")) : class$de$vw$mib$log4mib$LoggerFactory).getName());
        if (serviceReference != null) {
            LoggerFactory loggerFactory = (LoggerFactory)this.bundleContext.getService(serviceReference);
            this.classifiedLogger = new SpeechPhoneClassifiedLogger(loggerFactory.getLogger(4096), 256);
            this.logger = new SpeechPhoneLogger2(this.classifiedLogger, "MessagingDependencyResolver");
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("found logger");
            }
            ServiceTracker serviceTracker = new ServiceTracker(this.bundleContext, (class$de$vw$mib$asl$api$speechengine$SpeechEngine == null ? (class$de$vw$mib$asl$api$speechengine$SpeechEngine = MessagingDependencyResolver.class$("de.vw.mib.asl.api.speechengine.SpeechEngine")) : class$de$vw$mib$asl$api$speechengine$SpeechEngine).getName(), (ServiceTrackerCustomizer)new MessagingDependencyResolver$1(this));
            serviceTracker.open();
        }
    }

    void activate() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("End resolving dependencies -> activation");
        }
        new MessagingComponentStarter().activate(this);
    }

    @Override
    public GenericEvents genericEvents() {
        return this.services.getGenericEvents();
    }

    @Override
    public SystemEventDispatcher systemEventDispatcher() {
        return this.services.getSystemEventDispatcher();
    }

    @Override
    public ASLPropertyManager aslPropertyManager() {
        return this.services.getASLPropertyManager();
    }

    @Override
    public PhoneService phoneService() {
        return this.phoneService;
    }

    @Override
    public MessagesStatusService messagesStatusService() {
        return this.messagesStatusService;
    }

    @Override
    public MessageAvailableService messageAvailableService() {
        return this.messageAvailableService;
    }

    @Override
    public MessageDetailService messageDetailService() {
        return this.messageDetailService;
    }

    @Override
    public TimerManager timerManager() {
        return this.services.getTimerManager();
    }

    @Override
    public String taskId() {
        return this.taskId;
    }

    @Override
    public ThreadSwitchingTarget threadSwitchingTarget() {
        return this.threadSwitchingTarget;
    }

    @Override
    public EventDispatcherHSM eventDispatcher() {
        return this.services.getGenericEvents().getEventDispatcher();
    }

    @Override
    public ResultControllerRouter resultControllerRouter() {
        return this.speechEngine.getResultHandler(4).getResultControllerRegistry();
    }

    @Override
    public ServiceRegister serviceRegister() {
        return this.services.getGenericEvents().getServiceRegister();
    }

    @Override
    public AbstractClassifiedLogger classifiedLogger() {
        return this.classifiedLogger;
    }

    @Override
    public ASLTimeAndDateServiceTarget aslTimeAndDateServiceTarget() {
        return this.aslTimeAndDateServiceTarget;
    }

    @Override
    public ConfigurationManager configurationManager() {
        return this.configurationManager;
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

