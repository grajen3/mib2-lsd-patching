/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechtuner.start;

import de.vw.mib.asl.api.radio.amFm.AmFrequencyScale;
import de.vw.mib.asl.api.radio.amFm.FmFrequencyScale;
import de.vw.mib.asl.api.radio.sdars.SiriusSubscriptionState;
import de.vw.mib.asl.api.radio.speech.amfm.AslRadioAmFmFacade;
import de.vw.mib.asl.api.radio.speech.dab.AslRadioDabFacade;
import de.vw.mib.asl.api.radio.speech.sirius.AslRadioSiriusFacade;
import de.vw.mib.asl.api.speechengine.SpeechEngine;
import de.vw.mib.asl.api.speechengine.SpeechEngineMaster;
import de.vw.mib.asl.api.speechengine.result.ResultHandler;
import de.vw.mib.asl.api.speechengine.result.handling.ResultControllerRouter;
import de.vw.mib.asl.api.speechengine.result.handling.ResultItemHandler;
import de.vw.mib.asl.api.speechengine.result.handling.ResultListHandler;
import de.vw.mib.asl.api.speechengine.result.router.ModelEventConsumer;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.api.speechengine.slots.SlotUpdater;
import de.vw.mib.asl.framework.api.entertainmentmanager.EntertainmentManagerService;
import de.vw.mib.asl.framework.api.framework.component.ASLComponentAPICallback;
import de.vw.mib.asl.internal.speechtuner.behavior.listadjustment.ListAdjustmentHandler;
import de.vw.mib.asl.internal.speechtuner.behavior.problemhandling.EntertainmentSourceProblemHandler;
import de.vw.mib.asl.internal.speechtuner.behavior.problemhandling.StationListProblemHandler;
import de.vw.mib.asl.internal.speechtuner.behavior.problemhandling.TunerProblemHandler;
import de.vw.mib.asl.internal.speechtuner.communication.dialogstate.DialogStateHandler;
import de.vw.mib.asl.internal.speechtuner.communication.entertainmentmanager.EntertainmentSourceHandler;
import de.vw.mib.asl.internal.speechtuner.communication.mainmenu.MainMenuRequestHandler;
import de.vw.mib.asl.internal.speechtuner.communication.teleprompter.TeleprompterStateHandler;
import de.vw.mib.asl.internal.speechtuner.communication.tuner.AmFmInterfaceHandler;
import de.vw.mib.asl.internal.speechtuner.communication.tuner.DabInterfaceHandler;
import de.vw.mib.asl.internal.speechtuner.communication.tuner.SiriusInterfaceHandler;
import de.vw.mib.asl.internal.speechtuner.controller.BandChangeAction;
import de.vw.mib.asl.internal.speechtuner.controller.HelpForRadioAction;
import de.vw.mib.asl.internal.speechtuner.controller.HelpForSelectStationAction;
import de.vw.mib.asl.internal.speechtuner.controller.ListenToRadioAction;
import de.vw.mib.asl.internal.speechtuner.controller.RequestVisibilityAction;
import de.vw.mib.asl.internal.speechtuner.controller.SelectFrequencyAction;
import de.vw.mib.asl.internal.speechtuner.controller.SelectStationAction;
import de.vw.mib.asl.internal.speechtuner.controller.ShowRadioAction;
import de.vw.mib.asl.internal.speechtuner.controller.SimpleTunerHelpAction;
import de.vw.mib.asl.internal.speechtuner.controller.TunerAction;
import de.vw.mib.asl.internal.speechtuner.controller.lists.SelectDABServiceController;
import de.vw.mib.asl.internal.speechtuner.controller.lists.SelectFMStationController;
import de.vw.mib.asl.internal.speechtuner.controller.lists.SelectSiriusChannelController;
import de.vw.mib.asl.internal.speechtuner.controller.lists.TunerNbestListController;
import de.vw.mib.asl.internal.speechtuner.controller.resultitemhandler.SelectAMFrequencyController;
import de.vw.mib.asl.internal.speechtuner.controller.resultitemhandler.SelectAMHDFrequencyController;
import de.vw.mib.asl.internal.speechtuner.controller.resultitemhandler.SelectFMFrequencyController;
import de.vw.mib.asl.internal.speechtuner.controller.resultitemhandler.SelectFMHDFrequencyController;
import de.vw.mib.asl.internal.speechtuner.controller.resultitemhandler.TunerFrequencyController;
import de.vw.mib.asl.internal.speechtuner.slots.SpeechTunerSlotUpdater;
import de.vw.mib.asl.internal.speechtuner.start.SpeechTunerStartTarget$1;
import de.vw.mib.asl.internal.speechtuner.start.SpeechTunerStartTarget$2;
import de.vw.mib.asl.internal.speechtuner.start.SpeechTunerStartTarget$3;
import de.vw.mib.asl.internal.speechtuner.start.SpeechTunerStartTarget$4;
import de.vw.mib.asl.internal.speechtuner.utils.SpeechTunerLogger;
import de.vw.mib.asl.internal.speechtuner.utils.SpeechTunerServiceManager;
import de.vw.mib.asl.internal.speechtuner.utils.implementation.SpeechTunerServiceManagerImpl;
import de.vw.mib.cio.CioDictionary;
import de.vw.mib.cio.CioDispatcher;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class SpeechTunerStartTarget
extends AbstractTarget
implements ASLComponentAPICallback {
    private static final String LOGGER_PREFIX;
    protected SpeechTunerServiceManager serviceManager;
    protected SpeechTunerLogger logger;
    protected BundleContext bundleContext;
    protected ResultControllerRouter registry;
    protected ResultListHandler resultListHandler;
    protected ResultItemHandler resultItemHandler;
    protected TunerProblemHandler tunerProblemHandler;
    protected EntertainmentSourceProblemHandler entertainmentSourceProblemHandler;
    protected StationListProblemHandler stationListProblemHandler;
    protected SpeechEngine speechEngine;
    protected SpeechEngineMaster speechEngineMaster;
    protected CioDictionary cioDictionary;
    protected CioDispatcher cioDispatcher;
    protected TeleprompterStateHandler teleprompterStateHandler;
    protected DialogStateHandler dialogStateHandler;
    protected SpeechTunerSlotUpdater slotUpdater;
    protected ListAdjustmentHandler listAdjustmentHandler;
    protected EntertainmentSourceHandler entertainmentSourceHandler;
    protected AmFmInterfaceHandler amFmInterface;
    protected DabInterfaceHandler dabInterface;
    protected SiriusInterfaceHandler siriusInterface;
    private ServiceTrackerCustomizer speechEngineTracker = new SpeechTunerStartTarget$1(this);
    private ServiceTrackerCustomizer speechEngineMasterTracker = new SpeechTunerStartTarget$2(this);
    private ServiceTrackerCustomizer cioDictionaryTracker = new SpeechTunerStartTarget$3(this);
    private ServiceTrackerCustomizer cioDispatcherTracker = new SpeechTunerStartTarget$4(this);
    static /* synthetic */ Class class$de$vw$mib$asl$framework$api$entertainmentmanager$EntertainmentManagerService;
    static /* synthetic */ Class class$de$vw$mib$asl$api$radio$amFm$AmFrequencyScale;
    static /* synthetic */ Class class$de$vw$mib$asl$api$radio$amFm$FmFrequencyScale;
    static /* synthetic */ Class class$de$vw$mib$asl$api$radio$speech$amfm$AslRadioAmFmFacade;
    static /* synthetic */ Class class$de$vw$mib$asl$api$radio$speech$dab$AslRadioDabFacade;
    static /* synthetic */ Class class$de$vw$mib$asl$api$radio$sdars$SiriusSubscriptionState;
    static /* synthetic */ Class class$de$vw$mib$asl$api$radio$speech$sirius$AslRadioSiriusFacade;
    static /* synthetic */ Class class$de$vw$mib$asl$api$speechengine$SpeechEngine;
    static /* synthetic */ Class class$de$vw$mib$asl$api$speechengine$SpeechEngineMaster;
    static /* synthetic */ Class class$de$vw$mib$cio$CioDictionary;
    static /* synthetic */ Class class$de$vw$mib$cio$CioDispatcher;
    static /* synthetic */ Class class$de$vw$mib$asl$api$speechengine$contexts$SpeechContext;

    public SpeechTunerStartTarget() {
    }

    public SpeechTunerStartTarget(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getDefaultTargetId() {
        return 1378687232;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        int n = eventGeneric.getReceiverEventId();
        switch (n) {
            case 106: {
                this.onPowerOn();
                break;
            }
            case 1077541831: {
                this.teleprompterStateHandler.teleprompterButtonPressed();
                break;
            }
            default: {
                if (this.registry == null) break;
                this.registry.onEvent(eventGeneric);
            }
        }
        if (n != 8 && this.logger.isTraceEnabled()) {
            this.logger.trace(new StringBuffer().append("handled event ").append(n).toString());
        }
    }

    private void onPowerOn() {
        this.serviceManager = new SpeechTunerServiceManagerImpl();
        this.logger = this.serviceManager.createSpeechTunerLogger("[SpeechTunerStartTarget] ");
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("handle POWER_ON event");
        }
        this.entertainmentSourceHandler = new EntertainmentSourceHandler(this.serviceManager);
        this.serviceManager.getASLServices().getFeatureAvailabilityChecker().setEntertainmentSourceHandler(this.entertainmentSourceHandler);
        this.serviceManager.getASLServices().requestAPI(class$de$vw$mib$asl$framework$api$entertainmentmanager$EntertainmentManagerService == null ? (class$de$vw$mib$asl$framework$api$entertainmentmanager$EntertainmentManagerService = SpeechTunerStartTarget.class$("de.vw.mib.asl.framework.api.entertainmentmanager.EntertainmentManagerService")) : class$de$vw$mib$asl$framework$api$entertainmentmanager$EntertainmentManagerService, this);
        this.amFmInterface = new AmFmInterfaceHandler(this.serviceManager);
        this.serviceManager.getASLServices().requestAPI(class$de$vw$mib$asl$api$radio$amFm$AmFrequencyScale == null ? (class$de$vw$mib$asl$api$radio$amFm$AmFrequencyScale = SpeechTunerStartTarget.class$("de.vw.mib.asl.api.radio.amFm.AmFrequencyScale")) : class$de$vw$mib$asl$api$radio$amFm$AmFrequencyScale, this);
        this.serviceManager.getASLServices().requestAPI(class$de$vw$mib$asl$api$radio$amFm$FmFrequencyScale == null ? (class$de$vw$mib$asl$api$radio$amFm$FmFrequencyScale = SpeechTunerStartTarget.class$("de.vw.mib.asl.api.radio.amFm.FmFrequencyScale")) : class$de$vw$mib$asl$api$radio$amFm$FmFrequencyScale, this);
        this.serviceManager.getASLServices().requestAPI(class$de$vw$mib$asl$api$radio$speech$amfm$AslRadioAmFmFacade == null ? (class$de$vw$mib$asl$api$radio$speech$amfm$AslRadioAmFmFacade = SpeechTunerStartTarget.class$("de.vw.mib.asl.api.radio.speech.amfm.AslRadioAmFmFacade")) : class$de$vw$mib$asl$api$radio$speech$amfm$AslRadioAmFmFacade, this);
        this.dabInterface = new DabInterfaceHandler(this.serviceManager);
        this.serviceManager.getASLServices().requestAPI(class$de$vw$mib$asl$api$radio$speech$dab$AslRadioDabFacade == null ? (class$de$vw$mib$asl$api$radio$speech$dab$AslRadioDabFacade = SpeechTunerStartTarget.class$("de.vw.mib.asl.api.radio.speech.dab.AslRadioDabFacade")) : class$de$vw$mib$asl$api$radio$speech$dab$AslRadioDabFacade, this);
        this.siriusInterface = new SiriusInterfaceHandler(this.serviceManager);
        this.serviceManager.getASLServices().requestAPI(class$de$vw$mib$asl$api$radio$sdars$SiriusSubscriptionState == null ? (class$de$vw$mib$asl$api$radio$sdars$SiriusSubscriptionState = SpeechTunerStartTarget.class$("de.vw.mib.asl.api.radio.sdars.SiriusSubscriptionState")) : class$de$vw$mib$asl$api$radio$sdars$SiriusSubscriptionState, this);
        this.serviceManager.getASLServices().requestAPI(class$de$vw$mib$asl$api$radio$speech$sirius$AslRadioSiriusFacade == null ? (class$de$vw$mib$asl$api$radio$speech$sirius$AslRadioSiriusFacade = SpeechTunerStartTarget.class$("de.vw.mib.asl.api.radio.speech.sirius.AslRadioSiriusFacade")) : class$de$vw$mib$asl$api$radio$speech$sirius$AslRadioSiriusFacade, this);
        this.tunerProblemHandler = new TunerProblemHandler(this.serviceManager, this.entertainmentSourceHandler, this.amFmInterface);
        this.entertainmentSourceProblemHandler = new EntertainmentSourceProblemHandler(this.serviceManager, this.entertainmentSourceHandler, this.amFmInterface);
        this.stationListProblemHandler = new StationListProblemHandler(this.serviceManager, this.entertainmentSourceHandler, this.amFmInterface);
        this.addObserver(-939837120);
        this.addObserver(-1006945984);
        this.addObserver(-990168768);
        this.addObserver(-973391552);
        this.addObserver(-738510528);
        this.addObserver(-671401664);
        this.addObserver(-621070016);
        this.addObserver(-537183936);
        this.addObserver(-772064960);
        this.addObserver(-755287744);
        this.addObserver(-453297856);
        this.addObserver(-470075072);
        this.bundleContext = this.serviceManager.getBundleContext();
        ServiceTracker serviceTracker = new ServiceTracker(this.bundleContext, (class$de$vw$mib$asl$api$speechengine$SpeechEngine == null ? (class$de$vw$mib$asl$api$speechengine$SpeechEngine = SpeechTunerStartTarget.class$("de.vw.mib.asl.api.speechengine.SpeechEngine")) : class$de$vw$mib$asl$api$speechengine$SpeechEngine).getName(), this.speechEngineTracker);
        serviceTracker.open();
        ServiceTracker serviceTracker2 = new ServiceTracker(this.bundleContext, (class$de$vw$mib$asl$api$speechengine$SpeechEngineMaster == null ? (class$de$vw$mib$asl$api$speechengine$SpeechEngineMaster = SpeechTunerStartTarget.class$("de.vw.mib.asl.api.speechengine.SpeechEngineMaster")) : class$de$vw$mib$asl$api$speechengine$SpeechEngineMaster).getName(), this.speechEngineMasterTracker);
        serviceTracker2.open();
        ServiceTracker serviceTracker3 = new ServiceTracker(this.bundleContext, (class$de$vw$mib$cio$CioDictionary == null ? (class$de$vw$mib$cio$CioDictionary = SpeechTunerStartTarget.class$("de.vw.mib.cio.CioDictionary")) : class$de$vw$mib$cio$CioDictionary).getName(), this.cioDictionaryTracker);
        serviceTracker3.open();
        ServiceTracker serviceTracker4 = new ServiceTracker(this.bundleContext, (class$de$vw$mib$cio$CioDispatcher == null ? (class$de$vw$mib$cio$CioDispatcher = SpeechTunerStartTarget.class$("de.vw.mib.cio.CioDispatcher")) : class$de$vw$mib$cio$CioDispatcher).getName(), this.cioDispatcherTracker);
        serviceTracker4.open();
    }

    protected void fireReady() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("fire event SYSTEM_SPEECH_TUNER_READY");
        }
        this.serviceManager.getModelServices().sendEventToModel(-735954432);
    }

    protected void registerControllers() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("registering controllers");
        }
        ShowRadioAction showRadioAction = new ShowRadioAction(this.serviceManager, this.entertainmentSourceHandler, this.entertainmentSourceProblemHandler, this.dialogStateHandler);
        this.registerController((Object)showRadioAction, -1057277632);
        MainMenuRequestHandler mainMenuRequestHandler = new MainMenuRequestHandler(this.serviceManager, showRadioAction);
        this.bundleContext.registerService(new String[]{(class$de$vw$mib$asl$api$speechengine$contexts$SpeechContext == null ? (class$de$vw$mib$asl$api$speechengine$contexts$SpeechContext = SpeechTunerStartTarget.class$("de.vw.mib.asl.api.speechengine.contexts.SpeechContext")) : class$de$vw$mib$asl$api$speechengine$contexts$SpeechContext).getName()}, (Object)mainMenuRequestHandler, null);
        this.registry.register(this.listAdjustmentHandler, -453297856, 0);
        RequestVisibilityAction requestVisibilityAction = new RequestVisibilityAction(this.cioDictionary, this.cioDispatcher);
        this.registry.register(requestVisibilityAction, requestVisibilityAction.getDownEvent(), 0);
        this.registry.register(requestVisibilityAction, requestVisibilityAction.getDownEvent(), 0);
        this.registerController((Object)new HelpForRadioAction(this.serviceManager, this.entertainmentSourceHandler, this.entertainmentSourceProblemHandler, this.dialogStateHandler), -1023723200);
        this.registerController((Object)new SimpleTunerHelpAction(this.serviceManager, this.tunerProblemHandler, -517850624), -1006945984);
        this.registerController((Object)new SimpleTunerHelpAction(this.serviceManager, this.tunerProblemHandler, -501073408), -990168768);
        this.registerController((Object)new HelpForSelectStationAction(this.serviceManager, this.tunerProblemHandler), -973391552);
        this.registerController((Object)new ListenToRadioAction(this.serviceManager, this.entertainmentSourceHandler, this.entertainmentSourceProblemHandler, this.dialogStateHandler), -1040500416);
        SelectStationAction selectStationAction = new SelectStationAction(this.serviceManager, this.entertainmentSourceHandler, this.stationListProblemHandler, this.dialogStateHandler, this.amFmInterface, this.dabInterface, this.siriusInterface);
        this.registerController((Object)selectStationAction, -738510528);
        this.registerController((Object)new SelectFMStationController(this.serviceManager, this.entertainmentSourceHandler, this.stationListProblemHandler, this.dialogStateHandler, this.amFmInterface, this.resultListHandler, this.listAdjustmentHandler), -906282688);
        this.registerController((Object)new SelectDABServiceController(this.serviceManager, this.entertainmentSourceHandler, this.stationListProblemHandler, this.dialogStateHandler, this.dabInterface, this.resultListHandler, this.listAdjustmentHandler), -688178880);
        this.registerController((Object)new SelectSiriusChannelController(this.serviceManager, this.entertainmentSourceHandler, this.stationListProblemHandler, this.dialogStateHandler, this.siriusInterface, this.resultListHandler, this.listAdjustmentHandler), -520406720);
        this.registerController((Object)new SelectFrequencyAction(this.serviceManager, this.entertainmentSourceHandler, this.stationListProblemHandler, this.dialogStateHandler, this.dabInterface, this.siriusInterface), -671401664);
        this.registerController((Object)new SelectAMFrequencyController(this.serviceManager, this.entertainmentSourceHandler, this.entertainmentSourceProblemHandler, this.dialogStateHandler, this.amFmInterface, this.resultItemHandler), -654624448);
        this.registerController((Object)new SelectAMHDFrequencyController(this.serviceManager, this.entertainmentSourceHandler, this.entertainmentSourceProblemHandler, this.dialogStateHandler, this.amFmInterface, this.resultItemHandler), -503629504);
        this.registerController((Object)new SelectFMFrequencyController(this.serviceManager, this.entertainmentSourceHandler, this.entertainmentSourceProblemHandler, this.dialogStateHandler, this.amFmInterface, this.resultItemHandler), -637847232);
        this.registerController((Object)new SelectFMHDFrequencyController(this.serviceManager, this.entertainmentSourceHandler, this.entertainmentSourceProblemHandler, this.dialogStateHandler, this.amFmInterface, this.resultItemHandler), -486852288);
        this.registerController((Object)new BandChangeAction(this.serviceManager, this.entertainmentSourceHandler, this.entertainmentSourceProblemHandler, this.dialogStateHandler, this.amFmInterface, this.siriusInterface, selectStationAction), new int[]{-621070016, -604292800, -587515584, -570738368, -553961152});
    }

    private void registerController(Object object, int[] nArray) {
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            this.registerController(object, nArray[i2]);
        }
    }

    private void registerController(Object object, int n) {
        if (object instanceof TunerFrequencyController) {
            this.registry.register((RecognizedEventConsumer)object, n);
        } else if (object instanceof TunerAction || object instanceof TunerNbestListController) {
            this.registry.register((RecognizedEventConsumer)object, n);
            this.registry.register((ModelEventConsumer)object, n);
        } else {
            this.logger.warn("tried to register unsupported action or controller type");
        }
    }

    protected void checkServices() {
        if (this.speechEngine == null || this.speechEngineMaster == null || this.cioDictionary == null || this.cioDispatcher == null) {
            return;
        }
        ResultHandler resultHandler = this.speechEngine.getResultHandler(5);
        this.registry = resultHandler.getResultControllerRegistry();
        this.resultListHandler = resultHandler.getResultListHandler();
        this.resultItemHandler = resultHandler.getResultItemHandler();
        this.teleprompterStateHandler = new TeleprompterStateHandler(this.serviceManager, this.speechEngine.getTeleprompterManager());
        SlotUpdater slotUpdater = this.speechEngine.getSlotUpdater(5);
        this.slotUpdater = new SpeechTunerSlotUpdater(this.serviceManager, slotUpdater);
        this.amFmInterface.setSlotUpdater(this.slotUpdater);
        this.dabInterface.setSlotUpdater(this.slotUpdater);
        this.siriusInterface.setSlotUpdater(this.slotUpdater);
        this.dialogStateHandler = new DialogStateHandler(this.speechEngine.getDialogStateRouter());
        this.listAdjustmentHandler = new ListAdjustmentHandler(this.serviceManager, this.speechEngineMaster.getDialogManager(5));
        this.fireReady();
        this.registerControllers();
    }

    @Override
    public void registered(Class clazz, Object object) {
        if (clazz == (class$de$vw$mib$asl$api$radio$speech$amfm$AslRadioAmFmFacade == null ? (class$de$vw$mib$asl$api$radio$speech$amfm$AslRadioAmFmFacade = SpeechTunerStartTarget.class$("de.vw.mib.asl.api.radio.speech.amfm.AslRadioAmFmFacade")) : class$de$vw$mib$asl$api$radio$speech$amfm$AslRadioAmFmFacade)) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("found an ASL Radio AM/FM interface");
            }
            AslRadioAmFmFacade aslRadioAmFmFacade = (AslRadioAmFmFacade)object;
            this.amFmInterface.setAmFmRadio(aslRadioAmFmFacade);
        } else if (clazz == (class$de$vw$mib$asl$api$radio$amFm$AmFrequencyScale == null ? (class$de$vw$mib$asl$api$radio$amFm$AmFrequencyScale = SpeechTunerStartTarget.class$("de.vw.mib.asl.api.radio.amFm.AmFrequencyScale")) : class$de$vw$mib$asl$api$radio$amFm$AmFrequencyScale)) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("found an AmFrequencyScale service");
            }
            this.amFmInterface.setAmFrequencyScale((AmFrequencyScale)object);
        } else if (clazz == (class$de$vw$mib$asl$api$radio$amFm$FmFrequencyScale == null ? (class$de$vw$mib$asl$api$radio$amFm$FmFrequencyScale = SpeechTunerStartTarget.class$("de.vw.mib.asl.api.radio.amFm.FmFrequencyScale")) : class$de$vw$mib$asl$api$radio$amFm$FmFrequencyScale)) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("found an FmFrequencyScale service");
            }
            this.amFmInterface.setFmFrequencyScale((FmFrequencyScale)object);
        } else if (clazz == (class$de$vw$mib$asl$api$radio$speech$dab$AslRadioDabFacade == null ? (class$de$vw$mib$asl$api$radio$speech$dab$AslRadioDabFacade = SpeechTunerStartTarget.class$("de.vw.mib.asl.api.radio.speech.dab.AslRadioDabFacade")) : class$de$vw$mib$asl$api$radio$speech$dab$AslRadioDabFacade)) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("found an ASL Radio DAB interface");
            }
            AslRadioDabFacade aslRadioDabFacade = (AslRadioDabFacade)object;
            this.dabInterface.setDabRadio(aslRadioDabFacade);
        } else if (clazz == (class$de$vw$mib$asl$api$radio$speech$sirius$AslRadioSiriusFacade == null ? (class$de$vw$mib$asl$api$radio$speech$sirius$AslRadioSiriusFacade = SpeechTunerStartTarget.class$("de.vw.mib.asl.api.radio.speech.sirius.AslRadioSiriusFacade")) : class$de$vw$mib$asl$api$radio$speech$sirius$AslRadioSiriusFacade)) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("found an ASL Radio Sirius interface");
            }
            AslRadioSiriusFacade aslRadioSiriusFacade = (AslRadioSiriusFacade)object;
            this.siriusInterface.setSiriusRadio(aslRadioSiriusFacade);
        } else if (clazz == (class$de$vw$mib$asl$api$radio$sdars$SiriusSubscriptionState == null ? (class$de$vw$mib$asl$api$radio$sdars$SiriusSubscriptionState = SpeechTunerStartTarget.class$("de.vw.mib.asl.api.radio.sdars.SiriusSubscriptionState")) : class$de$vw$mib$asl$api$radio$sdars$SiriusSubscriptionState)) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("found a SiriusSubscriptionState service");
            }
            this.siriusInterface.setSubscriptionStateInterface((SiriusSubscriptionState)object);
        } else if (clazz == (class$de$vw$mib$asl$framework$api$entertainmentmanager$EntertainmentManagerService == null ? (class$de$vw$mib$asl$framework$api$entertainmentmanager$EntertainmentManagerService = SpeechTunerStartTarget.class$("de.vw.mib.asl.framework.api.entertainmentmanager.EntertainmentManagerService")) : class$de$vw$mib$asl$framework$api$entertainmentmanager$EntertainmentManagerService)) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("found an EntertainmentManager service");
            }
            EntertainmentManagerService entertainmentManagerService = (EntertainmentManagerService)object;
            this.entertainmentSourceHandler.setEntertainmentManager(entertainmentManagerService);
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

