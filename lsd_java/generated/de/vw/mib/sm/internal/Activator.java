/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.sm.internal;

import de.vw.mib.activation.BundleActivatorExtension;
import de.vw.mib.app.framework.AppUIGateFactory;
import de.vw.mib.app.internal.AppSystemServicesImpl;
import de.vw.mib.appui.cio.CioVisualizationRegister;
import de.vw.mib.appui.dispatcher.internal.AppUiDispatcherActivator;
import de.vw.mib.error.ErrorHandler;
import de.vw.mib.event.dispatcher.ViewEventDispatcher;
import de.vw.mib.genericevents.EventFactory;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.hmi.HmiEventIdMap;
import de.vw.mib.hmi.internal.ServiceManagerCommon;
import de.vw.mib.sdfeaturecollectionmanager.SdFeatureCollectionManager;
import de.vw.mib.sdfeaturecollectionmanager.internal.NoPushNoPopSdFeatureCollectionManager;
import de.vw.mib.skin.SkinClassLoader;
import de.vw.mib.sm.internal.ServiceManagerStatemachine;
import de.vw.mib.sm.internal.SpecialEventIds;
import de.vw.mib.sm.internal.StatemachineManagerEventConsumerImpl;
import de.vw.mib.sm.internal.StatemachineManagerImpl;
import de.vw.mib.sm.internal.activity.EventReceiverTable$ReceiverColumn;
import de.vw.mib.sm.internal.activity.EventReceiverTableImpl;
import de.vw.mib.sm.internal.journal.NullSmJournal;
import de.vw.mib.sm.internal.journal.NumericInfoSmJournal;
import de.vw.mib.sm.internal.journal.TextualInfoSmJournal;
import de.vw.mib.sm.internal.journal.TraceSmJournal;
import de.vw.mib.sm.internal.statemachine.MainStatemachineOrder;
import de.vw.mib.sm.internal.statemachine.StatemachineDataFactoryImpl;
import de.vw.mib.sm.internal.statemachine.StatemachinesResDataAccess;
import de.vw.mib.sm.internal.statemachine.TopStatemachine;
import de.vw.mib.sm.internal.waitaphore.WaitaphoreWatcherImpl;
import de.vw.mib.timer.TimerManager;
import de.vw.mib.view.internal.GlobalViewHandlerRegister;
import de.vw.mib.view.internal.ViewHandlerServices;
import generated.de.vw.mib.global.appui.internal.HmiAppUIGateFactoryImpl;
import generated.de.vw.mib.global.sm.activity.GlobalActionHandlerImpl;
import generated.de.vw.mib.global.sm.internal.ActivityFactoryImpl;
import generated.de.vw.mib.global.sm.internal.DynamicStatemachineTriggerImpl;
import generated.de.vw.mib.global.sm.internal.StatemachineActivationGuardEvaluatorImpl;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;

public class Activator
implements BundleActivatorExtension,
ServiceListener {
    public static final int SM_CHECKSUM;
    private BundleContext bundleContext;
    private static final int DIRECT;
    private static final int INDIRECT;
    private int preloaded = 0;
    private int waitingListeners = 1;
    private CioVisualizationRegister cioVisualizationRegister;
    private GlobalViewHandlerRegister globalViewHandlerRegister;
    private SkinClassLoader skinClassLoader;
    private ViewEventDispatcher viewEventDispatcher;
    private ViewHandlerServices viewHandlerServices;
    private AppUIGateFactory appUigateFactory;
    static /* synthetic */ Class class$de$vw$mib$sm$StatemachineManager;
    static /* synthetic */ Class class$de$vw$mib$sm$StatemachineDiagnose;
    static /* synthetic */ Class class$de$vw$mib$event$consumer$StatemachineManagerEventConsumer;
    static /* synthetic */ Class class$de$vw$mib$appui$cio$CioVisualizationRegister;
    static /* synthetic */ Class class$de$vw$mib$appui$dispatcher$internal$AppUiDispatcherActivator;
    static /* synthetic */ Class class$de$vw$mib$app$framework$AppUIGateFactory;
    static /* synthetic */ Class class$generated$de$vw$mib$sm$internal$Activator;

    @Override
    public void preload(BundleContext bundleContext) {
        ServiceManagerStatemachine.sdFeatureCollectionManager = new NoPushNoPopSdFeatureCollectionManager();
        this.bundleContext = bundleContext;
        this.preloaded = this.preloaded == 2 ? 2 : 1;
        ServiceManagerStatemachine.hmiEventIdMap = (HmiEventIdMap)this.getService("de.vw.mib.hmi.HmiEventIdMap");
        ServiceManagerStatemachine.genericEvents = (GenericEvents)this.getService("de.vw.mib.genericevents.GenericEvents");
        ServiceManagerStatemachine.errorHandler = (ErrorHandler)this.getService("de.vw.mib.error.ErrorHandler");
        ServiceManagerStatemachine.eventFactory = (EventFactory)this.getService("de.vw.mib.genericevents.EventFactory");
        this.preloadSetup();
        this.bundleContext.registerService(new String[]{(class$de$vw$mib$sm$StatemachineManager == null ? (class$de$vw$mib$sm$StatemachineManager = Activator.class$("de.vw.mib.sm.StatemachineManager")) : class$de$vw$mib$sm$StatemachineManager).getName(), (class$de$vw$mib$sm$StatemachineDiagnose == null ? (class$de$vw$mib$sm$StatemachineDiagnose = Activator.class$("de.vw.mib.sm.StatemachineDiagnose")) : class$de$vw$mib$sm$StatemachineDiagnose).getName()}, (Object)ServiceManagerStatemachine.statemachineManager, null);
        this.bundleContext.registerService((class$de$vw$mib$event$consumer$StatemachineManagerEventConsumer == null ? (class$de$vw$mib$event$consumer$StatemachineManagerEventConsumer = Activator.class$("de.vw.mib.event.consumer.StatemachineManagerEventConsumer")) : class$de$vw$mib$event$consumer$StatemachineManagerEventConsumer).getName(), (Object)ServiceManagerStatemachine.statemachineManagerEventConsumer, null);
        String string = "(objectClass=de.vw.mib.sdfeaturecollectionmanager.SdFeatureCollectionManager)";
        this.bundleContext.addServiceListener(this, string);
        String string2 = null;
        ServiceReference[] serviceReferenceArray = this.bundleContext.getServiceReferences(string2, string);
        for (int i2 = 0; serviceReferenceArray != null && i2 < serviceReferenceArray.length; ++i2) {
            this.serviceChanged(new ServiceEvent(1, serviceReferenceArray[i2]));
        }
    }

    @Override
    public void serviceChanged(ServiceEvent serviceEvent) {
        Object object;
        if (1 == serviceEvent.getType() && (object = this.bundleContext.getService(serviceEvent.getServiceReference())) instanceof SdFeatureCollectionManager && ServiceManagerStatemachine.sdFeatureCollectionManager instanceof NoPushNoPopSdFeatureCollectionManager) {
            ServiceManagerStatemachine.sdFeatureCollectionManager = null;
        }
        if (1 == serviceEvent.getType() && (object = this.bundleContext.getService(serviceEvent.getServiceReference())) instanceof SdFeatureCollectionManager && ServiceManagerStatemachine.sdFeatureCollectionManager == null) {
            ServiceManagerStatemachine.sdFeatureCollectionManager = (SdFeatureCollectionManager)object;
            --this.waitingListeners;
            this.listenerPartialSetup(this.waitingListeners == 0);
        }
    }

    @Override
    public void start(BundleContext bundleContext) {
        if (bundleContext.getServiceReference((class$de$vw$mib$appui$cio$CioVisualizationRegister == null ? (class$de$vw$mib$appui$cio$CioVisualizationRegister = Activator.class$("de.vw.mib.appui.cio.CioVisualizationRegister")) : class$de$vw$mib$appui$cio$CioVisualizationRegister).getName()) == null) {
            ServiceManagerCommon.loggerFactory.getLogger(128).error(1).append("Not invoked activator: ").append(class$de$vw$mib$appui$dispatcher$internal$AppUiDispatcherActivator == null ? (class$de$vw$mib$appui$dispatcher$internal$AppUiDispatcherActivator = Activator.class$("de.vw.mib.appui.dispatcher.internal.AppUiDispatcherActivator")) : class$de$vw$mib$appui$dispatcher$internal$AppUiDispatcherActivator).log();
            new AppUiDispatcherActivator().start(bundleContext);
        }
        if (this.preloaded == 0) {
            this.preloaded = 2;
            this.preload(bundleContext);
        }
        this.cioVisualizationRegister = (CioVisualizationRegister)this.getService("de.vw.mib.appui.cio.CioVisualizationRegister");
        this.skinClassLoader = (SkinClassLoader)this.getService("de.vw.mib.skin.SkinClassLoader");
        this.globalViewHandlerRegister = (GlobalViewHandlerRegister)this.getService("de.vw.mib.view.internal.GlobalViewHandlerRegister");
        this.viewHandlerServices = (ViewHandlerServices)this.getService("de.vw.mib.view.internal.ViewHandlerServices");
        this.viewEventDispatcher = (ViewEventDispatcher)this.getService("de.vw.mib.event.dispatcher.ViewEventDispatcher");
        this.startSetup();
        this.bundleContext.registerService((class$de$vw$mib$app$framework$AppUIGateFactory == null ? (class$de$vw$mib$app$framework$AppUIGateFactory = Activator.class$("de.vw.mib.app.framework.AppUIGateFactory")) : class$de$vw$mib$app$framework$AppUIGateFactory).getName(), (Object)this.appUigateFactory, null);
    }

    @Override
    public void stop(BundleContext bundleContext) {
    }

    private void preloadSetup() {
        ServiceManagerStatemachine.smChecksum = 1082041982;
        ServiceManagerStatemachine.activityFactory = new ActivityFactoryImpl();
        StatemachineDataFactoryImpl statemachineDataFactoryImpl = new StatemachineDataFactoryImpl();
        ServiceManagerStatemachine.subStatemachineFactory = statemachineDataFactoryImpl;
        TopStatemachine[] topStatemachineArray = statemachineDataFactoryImpl.createStatemachines(this.preloaded == 2, new StatemachineActivationGuardEvaluatorImpl());
        MainStatemachineOrder mainStatemachineOrder = statemachineDataFactoryImpl.createMainStatemachineOrder();
        SpecialEventIds specialEventIds = new SpecialEventIds();
        specialEventIds.ddpActive = 2002816329;
        specialEventIds.ddpInactive = 2019593545;
        ServiceManagerStatemachine.statemachineManager = new StatemachineManagerImpl(topStatemachineArray, mainStatemachineOrder, specialEventIds);
        ServiceManagerStatemachine.statemachineManagerEventConsumer = new StatemachineManagerEventConsumerImpl();
        ServiceManagerStatemachine.eventReceiverTable = new EventReceiverTableImpl(5282);
        ServiceManagerStatemachine.dynamicStatemachineTrigger = new DynamicStatemachineTriggerImpl(topStatemachineArray);
        ServiceManagerStatemachine.globalActionHandler = new GlobalActionHandlerImpl();
        this.setupJournal(statemachineDataFactoryImpl.getDataAccess());
        ServiceManagerStatemachine.globalReceiverId = ServiceManagerStatemachine.eventReceiverTable.allocReceiverId();
        EventReceiverTable.ReceiverColumn receiverColumn = ServiceManagerStatemachine.eventReceiverTable.getReceiverColumn(ServiceManagerStatemachine.globalReceiverId);
        ServiceManagerStatemachine.dynamicStatemachineTrigger.registerTriggers(receiverColumn);
        ServiceManagerStatemachine.waitaphoreWatcher = new WaitaphoreWatcherImpl();
    }

    private void setupJournal(StatemachinesResDataAccess statemachinesResDataAccess) {
        if (Boolean.getBoolean("smjournal.noinfo")) {
            ServiceManagerStatemachine.journalEx = new NullSmJournal();
        } else if (Boolean.getBoolean("smjournal.textualinfo")) {
            int n = -1270114235;
            ServiceManagerStatemachine.journalEx = new TextualInfoSmJournal(class$generated$de$vw$mib$sm$internal$Activator == null ? (class$generated$de$vw$mib$sm$internal$Activator = Activator.class$("generated.de.vw.mib.sm.internal.Activator")) : class$generated$de$vw$mib$sm$internal$Activator, -1270114235, 1082041982, statemachinesResDataAccess);
        } else if (System.getProperty("smjournal.tracelog") != null) {
            TimerManager timerManager = (TimerManager)this.getService("de.vw.mib.timer.TimerManager");
            ServiceManagerStatemachine.journalEx = new TraceSmJournal(timerManager);
        } else {
            ServiceManagerStatemachine.journalEx = new NumericInfoSmJournal();
        }
    }

    private void startSetup() {
        AppSystemServicesImpl appSystemServicesImpl = new AppSystemServicesImpl(ServiceManagerCommon.loggerFactory, ServiceManagerCommon.statemachineEventDispatcher, ServiceManagerCommon.perfService, this.skinClassLoader, this.globalViewHandlerRegister, this.viewHandlerServices, this.cioVisualizationRegister, this.viewEventDispatcher);
        this.appUigateFactory = new HmiAppUIGateFactoryImpl(appSystemServicesImpl);
    }

    private void listenerPartialSetup(boolean bl) {
    }

    private Object getService(String string) {
        Object object;
        ServiceReference serviceReference = this.bundleContext.getServiceReference(string);
        if (serviceReference == null) {
            this.missingService(string);
        }
        if ((object = this.bundleContext.getService(serviceReference)) == null) {
            this.missingService(string);
        }
        return object;
    }

    private void missingService(String string) {
        throw new IllegalStateException(new StringBuffer().append("Service '").append(string).append("' not available.").toString());
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

