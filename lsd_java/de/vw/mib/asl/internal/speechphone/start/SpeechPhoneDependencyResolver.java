/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.start;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.api.phone.PhoneService;
import de.vw.mib.asl.api.phone.services.callstack.CallstackService;
import de.vw.mib.asl.api.phone.services.contact.ContactDetailsService;
import de.vw.mib.asl.api.speechengine.SpeechEngineMaster;
import de.vw.mib.asl.api.speechengine.audio.AudioAccessor;
import de.vw.mib.asl.api.speechengine.dialogmanager.DialogBackstack;
import de.vw.mib.asl.api.speechengine.dialogmanager.DialogManager;
import de.vw.mib.asl.api.speechengine.messenger.dialog.DialogStateRouter;
import de.vw.mib.asl.api.speechengine.messenger.slot.SlotStateRouter;
import de.vw.mib.asl.api.speechengine.result.ResultHandler;
import de.vw.mib.asl.api.speechengine.result.handling.ResultControllerRouter;
import de.vw.mib.asl.api.speechengine.result.handling.ResultItemHandler;
import de.vw.mib.asl.api.speechengine.result.handling.ResultItemRowNumberHandler;
import de.vw.mib.asl.api.speechengine.result.handling.ResultListHandler;
import de.vw.mib.asl.api.speechengine.slots.SlotUpdater;
import de.vw.mib.asl.api.speechengine.teleprompter.TeleprompterManager;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.framework.Services;
import de.vw.mib.asl.framework.api.framework.component.ASLComponentRegistry;
import de.vw.mib.asl.internal.list.ASLListManager;
import de.vw.mib.asl.internal.speechphone.speechphone.start.SpeechPhoneComponentStarter;
import de.vw.mib.asl.internal.speechphone.speechphone.start.SpeechPhoneParameters;
import de.vw.mib.asl.internal.speechphone.start.SpeechPhoneDependencyResolver$1;
import de.vw.mib.asl.internal.speechphone.utils.SpeechPhoneClassifiedLogger;
import de.vw.mib.asl.internal.speechphone.utils.SpeechPhoneLogger2;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;
import de.vw.mib.cio.CioDictionary;
import de.vw.mib.cio.CioDispatcher;
import de.vw.mib.configuration.ConfigurationManager;
import de.vw.mib.event.dispatcher.SystemEventDispatcher;
import de.vw.mib.genericevents.EventDispatcherHSM;
import de.vw.mib.genericevents.EventFactory;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.ServiceRegister;
import de.vw.mib.log4mib.LoggerFactory;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class SpeechPhoneDependencyResolver
implements SpeechPhoneParameters {
    private final int clientId;
    private final String taskId;
    SpeechPhoneClassifiedLogger classifiedLogger;
    SpeechPhoneLogger2 logger;
    SpeechEngineMaster speechEngineMaster = null;
    ResultHandler resultHandler;
    BundleContext bundleContext;
    Services services;
    ASLComponentRegistry registry;
    PhoneService phoneService;
    ContactDetailsService contactDetailsService;
    CallstackService callstackService;
    ConfigurationManager configurationManager;
    CioDictionary cioDictionary;
    CioDispatcher cioDispatcher;
    static /* synthetic */ Class class$de$vw$mib$log4mib$LoggerFactory;
    static /* synthetic */ Class class$de$vw$mib$asl$api$speechengine$SpeechEngineMaster;
    static /* synthetic */ Class class$de$vw$mib$asl$api$phone$PhoneService;
    static /* synthetic */ Class class$de$vw$mib$asl$api$phone$services$contact$ContactDetailsService;
    static /* synthetic */ Class class$de$vw$mib$asl$api$phone$services$callstack$CallstackService;
    static /* synthetic */ Class class$de$vw$mib$configuration$ConfigurationManager;
    static /* synthetic */ Class class$de$vw$mib$cio$CioDictionary;
    static /* synthetic */ Class class$de$vw$mib$cio$CioDispatcher;

    public SpeechPhoneDependencyResolver(String string) {
        this.clientId = 4;
        this.taskId = string;
        this.services = ASLFrameworkFactory.getASLFrameworkAPI().getServices();
        this.registry = this.services.getASLComponentRegistry();
        this.bundleContext = this.services.getBundleContext();
        ServiceReference serviceReference = this.bundleContext.getServiceReference((class$de$vw$mib$log4mib$LoggerFactory == null ? (class$de$vw$mib$log4mib$LoggerFactory = SpeechPhoneDependencyResolver.class$("de.vw.mib.log4mib.LoggerFactory")) : class$de$vw$mib$log4mib$LoggerFactory).getName());
        if (serviceReference != null) {
            LoggerFactory loggerFactory = (LoggerFactory)this.bundleContext.getService(serviceReference);
            this.classifiedLogger = new SpeechPhoneClassifiedLogger(loggerFactory.getLogger(4096), 256);
            this.logger = new SpeechPhoneLogger2(this.classifiedLogger, "MessagingDependencyResolver");
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("found logger");
            }
            ServiceTracker serviceTracker = new ServiceTracker(this.bundleContext, (class$de$vw$mib$asl$api$speechengine$SpeechEngineMaster == null ? (class$de$vw$mib$asl$api$speechengine$SpeechEngineMaster = SpeechPhoneDependencyResolver.class$("de.vw.mib.asl.api.speechengine.SpeechEngineMaster")) : class$de$vw$mib$asl$api$speechengine$SpeechEngineMaster).getName(), (ServiceTrackerCustomizer)new SpeechPhoneDependencyResolver$1(this));
            serviceTracker.open();
        }
    }

    void activate() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("End resolving dependencies -> activation");
        }
        new SpeechPhoneComponentStarter().activate(this);
    }

    @Override
    public GenericEvents genericEvents() {
        return this.services.getGenericEvents();
    }

    @Override
    public String taskId() {
        return this.taskId;
    }

    @Override
    public SystemEventDispatcher systemEventDispatcher() {
        return this.services.getSystemEventDispatcher();
    }

    @Override
    public EventDispatcherHSM eventDispatcher() {
        return this.services.getGenericEvents().getEventDispatcher();
    }

    @Override
    public ServiceRegister serviceRegister() {
        return this.services.getGenericEvents().getServiceRegister();
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
    public ContactDetailsService contactDetailsService() {
        return this.contactDetailsService;
    }

    @Override
    public CallstackService callstackService() {
        return this.callstackService;
    }

    @Override
    public TeleprompterManager teleprompterManager() {
        return this.speechEngineMaster.getTeleprompterManager();
    }

    @Override
    public SlotStateRouter slotStateRouter() {
        return this.speechEngineMaster.getSlotStateRouter();
    }

    @Override
    public SlotUpdater slotUpdater() {
        return this.speechEngineMaster.getSlotUpdater(4);
    }

    @Override
    public AudioAccessor audioAccessor() {
        return this.speechEngineMaster.getAudioAccessor(4);
    }

    @Override
    public ResultControllerRouter resultControllerRouter() {
        return this.resultHandler.getResultControllerRegistry();
    }

    @Override
    public ResultItemHandler resultItemHandler() {
        return this.resultHandler.getResultItemHandler();
    }

    @Override
    public ResultListHandler resultListHandler() {
        return this.resultHandler.getResultListHandler();
    }

    @Override
    public ResultItemRowNumberHandler resultItemRowNumberHandler() {
        return this.resultHandler.getResultItemRowNumberHandler();
    }

    @Override
    public DialogStateRouter dialogStateRouter() {
        return this.speechEngineMaster.getDialogStateRouter();
    }

    @Override
    public DialogBackstack dialogBackstack() {
        return this.speechEngineMaster.getDialogBackstack(4);
    }

    @Override
    public AbstractClassifiedLogger classifiedLogger() {
        return this.classifiedLogger;
    }

    @Override
    public BundleContext bundleContext() {
        return this.bundleContext;
    }

    @Override
    public ASLListManager aslListManager() {
        return this.services.getASLListManager();
    }

    @Override
    public ConfigurationManager configurationManager() {
        return this.configurationManager;
    }

    @Override
    public EventFactory eventFactory() {
        return this.services.getEventFactory();
    }

    @Override
    public CioDictionary cioDictionary() {
        return this.cioDictionary;
    }

    @Override
    public CioDispatcher cioDispatcher() {
        return this.cioDispatcher;
    }

    @Override
    public DialogManager dialogManager() {
        return this.speechEngineMaster.getDialogManager(4);
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

