/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechmedia.start;

import de.vw.mib.asl.api.speechengine.SpeechEngineMaster;
import de.vw.mib.asl.api.speechengine.config.settings.SpeechSettingsService;
import de.vw.mib.asl.api.speechengine.dialogmanager.DialogManager;
import de.vw.mib.asl.api.speechengine.result.ResultHandler;
import de.vw.mib.asl.api.speechengine.result.handling.ResultControllerRouter;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.framework.Services;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.speechmedia.action.Action;
import de.vw.mib.asl.internal.speechmedia.action.GenericAction;
import de.vw.mib.asl.internal.speechmedia.action.PagingAction;
import de.vw.mib.asl.internal.speechmedia.action.global.HelpMediaAction;
import de.vw.mib.asl.internal.speechmedia.action.global.MediaAction;
import de.vw.mib.asl.internal.speechmedia.action.global.PlaySimilarAction;
import de.vw.mib.asl.internal.speechmedia.action.global.RequestVisibilityAction;
import de.vw.mib.asl.internal.speechmedia.controller.AdjustmentController;
import de.vw.mib.asl.internal.speechmedia.controller.MainMenuRequestHandler;
import de.vw.mib.asl.internal.speechmedia.controller.MediaServiceController;
import de.vw.mib.asl.internal.speechmedia.controller.SlotController;
import de.vw.mib.asl.internal.speechmedia.controller.TeleprompterController;
import de.vw.mib.asl.internal.speechmedia.sources.controller.SelectAuxAction;
import de.vw.mib.asl.internal.speechmedia.sources.controller.SelectBtAction;
import de.vw.mib.asl.internal.speechmedia.sources.controller.SelectCdAction;
import de.vw.mib.asl.internal.speechmedia.sources.controller.SelectDvdAction;
import de.vw.mib.asl.internal.speechmedia.sources.controller.SelectJukeboxAction;
import de.vw.mib.asl.internal.speechmedia.sources.controller.SelectSdAction;
import de.vw.mib.asl.internal.speechmedia.sources.controller.SelectUsbAction;
import de.vw.mib.asl.internal.speechmedia.sources.controller.SelectWlanAction;
import de.vw.mib.asl.internal.speechmedia.sources.controller.SourceListController;
import de.vw.mib.asl.internal.speechmedia.start.SpeechMediaStartTarget$1;
import de.vw.mib.asl.internal.speechmedia.titles.controller.AlbumListController;
import de.vw.mib.asl.internal.speechmedia.titles.controller.ArtistListController;
import de.vw.mib.asl.internal.speechmedia.titles.controller.GenreListController;
import de.vw.mib.asl.internal.speechmedia.titles.controller.SelectTrackAction;
import de.vw.mib.asl.internal.speechmedia.titles.controller.TitleListController;
import de.vw.mib.asl.internal.speechmedia.utils.SpeechMediaLogger;
import de.vw.mib.asl.internal.speechmedia.utils.SpeechMediaServiceManager;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class SpeechMediaStartTarget
extends AbstractTarget {
    protected SpeechMediaLogger logger;
    protected BundleContext bundleContext;
    protected ResultControllerRouter registry;
    protected SpeechMediaServiceManager smServices;
    protected SpeechEngineMaster speechEngine;
    private ServiceTrackerCustomizer speechEngineTracker = new SpeechMediaStartTarget$1(this);
    static /* synthetic */ Class class$de$vw$mib$asl$api$speechengine$SpeechEngineMaster;
    static /* synthetic */ Class class$de$vw$mib$asl$api$speechengine$contexts$SpeechContext;

    public SpeechMediaStartTarget(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getDefaultTargetId() {
        return 853481472;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        int n = eventGeneric.getReceiverEventId();
        switch (n) {
            case 106: {
                this.onPowerOn();
                break;
            }
            default: {
                if (this.registry == null) break;
                this.registry.onEvent(eventGeneric);
            }
        }
    }

    private void onPowerOn() {
        Services services = ASLFrameworkFactory.getASLFrameworkAPI().getServices();
        this.bundleContext = services.getBundleContext();
        this.smServices = new SpeechMediaServiceManager(this.bundleContext, services);
        SpeechMediaLogger.setLogger(this.smServices.getLogger());
        this.logger = new SpeechMediaLogger("[SpeechMediaStartTarget] ");
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("SpeechMedia POWER_ON");
        }
        ServiceTracker serviceTracker = new ServiceTracker(this.bundleContext, (class$de$vw$mib$asl$api$speechengine$SpeechEngineMaster == null ? (class$de$vw$mib$asl$api$speechengine$SpeechEngineMaster = SpeechMediaStartTarget.class$("de.vw.mib.asl.api.speechengine.SpeechEngineMaster")) : class$de$vw$mib$asl$api$speechengine$SpeechEngineMaster).getName(), this.speechEngineTracker);
        serviceTracker.open();
    }

    protected void fireReady() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("fire event: SYSTEM_SPEECH_MEDIA_READY.");
        }
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-1300155904);
    }

    protected void registerControllers() {
        SlotController slotController = new SlotController(this.speechEngine.getSlotStateRouter());
        MediaServiceController mediaServiceController = new MediaServiceController(slotController, this.smServices);
        ResultHandler resultHandler = this.speechEngine.getResultHandler(3);
        this.registry = resultHandler.getResultControllerRegistry();
        MainMenuRequestHandler mainMenuRequestHandler = new MainMenuRequestHandler(mediaServiceController);
        this.bundleContext.registerService((class$de$vw$mib$asl$api$speechengine$contexts$SpeechContext == null ? (class$de$vw$mib$asl$api$speechengine$contexts$SpeechContext = SpeechMediaStartTarget.class$("de.vw.mib.asl.api.speechengine.contexts.SpeechContext")) : class$de$vw$mib$asl$api$speechengine$contexts$SpeechContext).getName(), (Object)mainMenuRequestHandler, null);
        SpeechSettingsService speechSettingsService = this.speechEngine.getSpeechConfigurator(3).getSpeechSettingsManager();
        this.registry.register(new TeleprompterController(speechSettingsService), -1520815552, 0);
        this.addObserver(-1520815552);
        DialogManager dialogManager = this.speechEngine.getDialogManager(3);
        AdjustmentController adjustmentController = new AdjustmentController(dialogManager);
        this.registry.register(adjustmentController, -900058560, 0);
        this.addObserver(-900058560);
        new PagingAction(this.registry);
        this.registerAction(new RequestVisibilityAction(this.smServices), 0);
        this.registerAction(new MediaAction(mediaServiceController));
        this.registerAction(new HelpMediaAction(mediaServiceController));
        this.registerAction(new SelectTrackAction(mediaServiceController, resultHandler));
        this.registerAction(new PlaySimilarAction(mediaServiceController));
        this.registerGenericAction(-1571147200, -1216269824);
        this.registerGenericAction(-1554369984, -1199492608);
        this.registerGenericAction(-1537592768, -1182715392);
        SourceListController sourceListController = new SourceListController(mediaServiceController, resultHandler.getResultItemRowNumberHandler());
        this.addObserver(-1353043392);
        this.registry.register(sourceListController, -1504038336);
        this.registry.register(new SelectAuxAction(resultHandler, mediaServiceController), -1336266176, 0);
        this.registry.register(new SelectBtAction(resultHandler, mediaServiceController), -1319488960, 0);
        this.registry.register(new SelectCdAction(resultHandler, mediaServiceController), -1302711744, 0);
        this.registry.register(new SelectDvdAction(resultHandler, mediaServiceController), -1285934528, 0);
        this.registry.register(new SelectJukeboxAction(resultHandler, mediaServiceController), -1269157312, 0);
        this.registry.register(new SelectSdAction(resultHandler, mediaServiceController), -1252380096, 0);
        this.registry.register(new SelectUsbAction(resultHandler, mediaServiceController), -1235602880, 0);
        this.registry.register(new SelectWlanAction(resultHandler, mediaServiceController), -1218825664, 0);
        this.addObserver(-1420152256);
        this.addObserver(-1168494016);
        this.addObserver(-1151716800);
        TitleListController titleListController = new TitleListController(mediaServiceController, resultHandler.getResultListHandler());
        this.registry.register(titleListController, -1403375040);
        ArtistListController artistListController = new ArtistListController(mediaServiceController, resultHandler.getResultListHandler());
        this.registry.register(artistListController, -983944640);
        AlbumListController albumListController = new AlbumListController(mediaServiceController, resultHandler.getResultListHandler());
        this.registry.register(albumListController, -1000721856);
        GenreListController genreListController = new GenreListController(mediaServiceController, resultHandler.getResultListHandler());
        this.registry.register(genreListController, -967167424);
    }

    private void registerGenericAction(int n, int n2) {
        GenericAction genericAction = new GenericAction(n2, n);
        this.registerAction(genericAction);
    }

    private void registerAction(Action action) {
        this.addObserver(action.getDownEvent());
        this.registry.register(action, action.getDownEvent());
        this.registry.register(action, action.getDownEvent());
    }

    private void registerAction(Action action, int n) {
        this.addObserver(action.getDownEvent());
        this.registry.register(action, action.getDownEvent(), n);
        this.registry.register(action, action.getDownEvent(), n);
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

