/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.targets;

import de.vw.mib.asl.api.media.IMediaConstants;
import de.vw.mib.asl.framework.api.diagnosis.config.Adaptation;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.dsi.DSIServiceLocator;
import de.vw.mib.asl.framework.internal.framework.dsi.util.RuntimeGeneratedConstants;
import de.vw.mib.asl.internal.devicehandling.DeviceHandlingTarget;
import de.vw.mib.asl.internal.media.accessor.MediaObjectAccessor;
import de.vw.mib.asl.internal.media.browser.MediaBrowserHelper;
import de.vw.mib.asl.internal.media.browser.bap.MediaBapBrowser;
import de.vw.mib.asl.internal.media.browser.bap.MediaHasBrowser;
import de.vw.mib.asl.internal.media.browser.coverflow.MediaCoverBrowser;
import de.vw.mib.asl.internal.media.browser.headunit.MediaMainBrowser;
import de.vw.mib.asl.internal.media.browser.headunit.MediaRecorderBrowser;
import de.vw.mib.asl.internal.media.browser.sds.MediaSpeechBrowser;
import de.vw.mib.asl.internal.media.clients.asi.ASIClient;
import de.vw.mib.asl.internal.media.common.AbstractMediaTarget;
import de.vw.mib.asl.internal.media.common.ResponseHandler;
import de.vw.mib.asl.internal.media.controller.MediaController;
import de.vw.mib.asl.internal.media.controller.OnlineMetaDataHandler;
import de.vw.mib.asl.internal.media.has.MediaHASTarget;
import de.vw.mib.asl.internal.media.playback.MediaVideoPlayer;
import de.vw.mib.asl.internal.media.recorder.MediaRecorder;
import de.vw.mib.asl.internal.media.settings.MediaSettings;
import de.vw.mib.asl.internal.media.sound.MediaAudioManager;
import de.vw.mib.asl.internal.media.sourcehandling.SourceHandlingPersistence;
import de.vw.mib.asl.internal.media.sourcehandling.target.MediaInternalSourceHandlingTarget;
import de.vw.mib.collections.ints.IntArrayList;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.util.Util;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.startup.DSIStartup;

public class TargetMediaStartup
extends AbstractMediaTarget
implements DSIServiceStateListener {
    private DSIStartup mDsiStartup;
    private DSIListener mDsiStartupListener;
    private boolean mRecoveryInProgress = false;
    private boolean mDSIMediaBaseAvailable = false;
    private boolean mDSIMediaPlayerAvailable = false;
    private static final int EV_DIAG_RECEIVE_ADAPT_DATA;
    private boolean mOnlineGraceNoteAvailable = false;
    public static final int BROWSER_MAIN_INSTANCE;
    public static final int BROWSER_COVER_INSTANCE;
    public static final int BROWSER_SPEECH_INSTANCE;
    public static final int BROWSER_BAP_INSTANCE;
    public static final int BROWSER_HAS_INSTANCE;
    public static final int BROWSER_RECORDER_INSTANCE;
    private static final int RQ_STARTUP_POWERON;
    private boolean powerOnCalled = false;
    private boolean poweredOn = false;
    private boolean registerDSICalled = false;
    private final IntArrayList startupAfterRecovery = new IntArrayList();
    static /* synthetic */ Class class$org$dsi$ifc$startup$DSIStartup;
    static /* synthetic */ Class class$org$dsi$ifc$startup$DSIStartupListener;
    static /* synthetic */ Class class$org$dsi$ifc$media$DSIMediaBase;
    static /* synthetic */ Class class$org$dsi$ifc$media$DSIMediaPlayer;
    static /* synthetic */ Class class$org$dsi$ifc$media$DSIMediaBrowser;
    static /* synthetic */ Class class$org$dsi$ifc$media$DSIMediaRecorder;
    static /* synthetic */ Class class$org$dsi$ifc$media$DSIMetadataService;

    public TargetMediaStartup(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getDefaultTargetId() {
        return 296686336;
    }

    @Override
    public int getClassifier() {
        return 1;
    }

    @Override
    public int getSubClassifier() {
        return 1024;
    }

    public void registerDSI() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.mDsiStartup = (DSIStartup)dSIProxy.getService(this, class$org$dsi$ifc$startup$DSIStartup == null ? (class$org$dsi$ifc$startup$DSIStartup = TargetMediaStartup.class$("org.dsi.ifc.startup.DSIStartup")) : class$org$dsi$ifc$startup$DSIStartup);
        this.mDsiStartupListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$startup$DSIStartupListener == null ? (class$org$dsi$ifc$startup$DSIStartupListener = TargetMediaStartup.class$("org.dsi.ifc.startup.DSIStartupListener")) : class$org$dsi$ifc$startup$DSIStartupListener);
        this.mDsiStartup.setNotification(3, this.mDsiStartupListener);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.info("MEDIA TARGETS ~ POWER_ON");
                ServiceManager.adaptionApi.requestConfigManagerPersAdaptation(this.getTargetId(), -1585053440);
                this.powerOnCalled = true;
                break;
            }
            case 100001: {
                int n = eventGeneric.getInt(2);
                long l = eventGeneric.getLong(3);
                if (eventGeneric.getResult() != 0 || n != -536825343 || l != 0) break;
                Adaptation adaptation = (Adaptation)eventGeneric.getObject(1);
                this.mOnlineGraceNoteAvailable = ServiceManager.configManagerDiag.isFeatureFlagSet(86) && adaptation.contains(143) && adaptation.contains(144) && adaptation.getBoolean(143) && adaptation.getBoolean(144);
                this.info(new StringBuffer().append("MEDIA TARGETS ~ OnlineGracenote: ").append(this.mOnlineGraceNoteAvailable).toString());
                if (!this.powerOnCalled || this.registerDSICalled) break;
                this.registerDSICalled = true;
                this.registerDSI();
                this.registerServiceListeners();
                break;
            }
        }
    }

    private void powerOn() {
        if (!this.poweredOn) {
            this.poweredOn = true;
            this.createTargets();
            if (this.isTraceEnabled()) {
                this.trace("MEDIA TARGETS ~ TargetMediaStartup -> POWERED ON");
            }
            EventGeneric eventGeneric = this.newEvent(279909120, -1366949632);
            eventGeneric.setObject(0, this);
            this.sendSafe(eventGeneric);
        }
        if (this.isRegisteredForResponse(601)) {
            this.fireResponse(true);
        }
    }

    private void createTargets() {
        GenericEvents genericEvents = ServiceManager.eventMain;
        String string = "hsmtask";
        if (MediaObjectAccessor.mMediaController == null) {
            MediaController mediaController;
            MediaObjectAccessor.mMediaController = mediaController = new MediaController(genericEvents, "hsmtask");
            mediaController.mStartup = this;
            this.startupTarget(279909120);
        }
        new DeviceHandlingTarget(genericEvents, "hsmtask");
        new MediaInternalSourceHandlingTarget(genericEvents, "hsmtask");
        new MediaAudioManager(genericEvents, "hsmtask");
        new MediaVideoPlayer(genericEvents, "hsmtask");
        new MediaSettings(genericEvents, "hsmtask");
        new MediaMainBrowser(genericEvents, "hsmtask", 0);
        new MediaSpeechBrowser(genericEvents, "hsmtask", 2);
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(386)) {
            new MediaBapBrowser(genericEvents, "hsmtask", 3);
        }
        new MediaHasBrowser(genericEvents, "hsmtask", 4);
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(48)) {
            new MediaCoverBrowser(genericEvents, "hsmtask", 1);
        }
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(83)) {
            new MediaRecorder(genericEvents, "hsmtask");
            new MediaRecorderBrowser(genericEvents, "hsmtask", 7);
        }
        new MediaHASTarget(genericEvents, "hsmtask");
        if (this.mOnlineGraceNoteAvailable) {
            new OnlineMetaDataHandler(genericEvents, "hsmtask");
        }
        new ASIClient();
    }

    private void registerServiceListeners() {
        DSIServiceLocator dSIServiceLocator = ServiceManager.dsiServiceLocator;
        dSIServiceLocator.addServiceStateListener(class$org$dsi$ifc$media$DSIMediaBase == null ? (class$org$dsi$ifc$media$DSIMediaBase = TargetMediaStartup.class$("org.dsi.ifc.media.DSIMediaBase")) : class$org$dsi$ifc$media$DSIMediaBase, this);
        dSIServiceLocator.addServiceStateListener(class$org$dsi$ifc$media$DSIMediaPlayer == null ? (class$org$dsi$ifc$media$DSIMediaPlayer = TargetMediaStartup.class$("org.dsi.ifc.media.DSIMediaPlayer")) : class$org$dsi$ifc$media$DSIMediaPlayer, this);
        dSIServiceLocator.addServiceStateListener(class$org$dsi$ifc$media$DSIMediaBrowser == null ? (class$org$dsi$ifc$media$DSIMediaBrowser = TargetMediaStartup.class$("org.dsi.ifc.media.DSIMediaBrowser")) : class$org$dsi$ifc$media$DSIMediaBrowser, 0, this);
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(386)) {
            dSIServiceLocator.addServiceStateListener(class$org$dsi$ifc$media$DSIMediaBrowser == null ? (class$org$dsi$ifc$media$DSIMediaBrowser = TargetMediaStartup.class$("org.dsi.ifc.media.DSIMediaBrowser")) : class$org$dsi$ifc$media$DSIMediaBrowser, 3, this);
        }
        dSIServiceLocator.addServiceStateListener(class$org$dsi$ifc$media$DSIMediaBrowser == null ? (class$org$dsi$ifc$media$DSIMediaBrowser = TargetMediaStartup.class$("org.dsi.ifc.media.DSIMediaBrowser")) : class$org$dsi$ifc$media$DSIMediaBrowser, 4, this);
        dSIServiceLocator.addServiceStateListener(class$org$dsi$ifc$media$DSIMediaBrowser == null ? (class$org$dsi$ifc$media$DSIMediaBrowser = TargetMediaStartup.class$("org.dsi.ifc.media.DSIMediaBrowser")) : class$org$dsi$ifc$media$DSIMediaBrowser, 2, this);
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(48)) {
            dSIServiceLocator.addServiceStateListener(class$org$dsi$ifc$media$DSIMediaBrowser == null ? (class$org$dsi$ifc$media$DSIMediaBrowser = TargetMediaStartup.class$("org.dsi.ifc.media.DSIMediaBrowser")) : class$org$dsi$ifc$media$DSIMediaBrowser, 1, this);
        }
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(83)) {
            dSIServiceLocator.addServiceStateListener(class$org$dsi$ifc$media$DSIMediaBrowser == null ? (class$org$dsi$ifc$media$DSIMediaBrowser = TargetMediaStartup.class$("org.dsi.ifc.media.DSIMediaBrowser")) : class$org$dsi$ifc$media$DSIMediaBrowser, 7, this);
            dSIServiceLocator.addServiceStateListener(class$org$dsi$ifc$media$DSIMediaRecorder == null ? (class$org$dsi$ifc$media$DSIMediaRecorder = TargetMediaStartup.class$("org.dsi.ifc.media.DSIMediaRecorder")) : class$org$dsi$ifc$media$DSIMediaRecorder, this);
            dSIServiceLocator.addServiceStateListener(class$org$dsi$ifc$media$DSIMetadataService == null ? (class$org$dsi$ifc$media$DSIMetadataService = TargetMediaStartup.class$("org.dsi.ifc.media.DSIMetadataService")) : class$org$dsi$ifc$media$DSIMetadataService, this);
        }
    }

    @Override
    public void registered(String string, int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("MEDIA TARGETS ~ Target startup DSI registered: ").append(string).append(", instance ").append(MediaBrowserHelper.getInstanceIdStr(n)).log();
        }
        try {
            if (string.equals(RuntimeGeneratedConstants.SERVICE_TS_NS[63])) {
                this.mDSIMediaBaseAvailable = true;
                this.startupBaseTargets();
            } else if (string.equals(RuntimeGeneratedConstants.SERVICE_TS_NS[66])) {
                this.mDSIMediaPlayerAvailable = true;
                this.startupBaseTargets();
            } else if (string.equals(RuntimeGeneratedConstants.SERVICE_TS_NS[67])) {
                this.startupTarget(363795200);
            } else if (string.equals(RuntimeGeneratedConstants.SERVICE_TS_NS[69]) && this.mOnlineGraceNoteAvailable) {
                this.startupTarget(514790144);
            } else if (string.equals(RuntimeGeneratedConstants.SERVICE_TS_NS[64])) {
                switch (n) {
                    case 0: {
                        this.startupTarget(397349632);
                        break;
                    }
                    case 3: {
                        this.startupTarget(414126848);
                        break;
                    }
                    case 4: {
                        this.startupTarget(481235712);
                        this.startupTarget(498012928);
                        break;
                    }
                    case 7: {
                        this.startupTarget(447681280);
                        break;
                    }
                    case 1: {
                        this.startupTarget(430904064);
                        break;
                    }
                    case 2: {
                        this.startupTarget(464458496);
                        break;
                    }
                }
            }
        }
        catch (Exception exception) {
            this.error().append("MEDIA TARGETS ~ Target startup triggered by '").append(string).append("' could not be executed").log();
        }
    }

    private void startupTarget(int n) {
        if (!this.mRecoveryInProgress) {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.getTargetId(), n, 106);
            this.sendSafe(eventGeneric);
        } else {
            this.trace().append("delaying startup of target ").append(n).append(" because recoveryInProgress.").log();
            this.startupAfterRecovery.add(n);
        }
    }

    private void startDelayedTargets() {
        if (this.mRecoveryInProgress) {
            throw new IllegalStateException("do not call startDelayedTargets while recoveryInProgress");
        }
        for (int i2 = 0; i2 < this.startupAfterRecovery.size(); ++i2) {
            this.startupTarget(this.startupAfterRecovery.get(i2));
        }
        this.startupAfterRecovery.clear();
    }

    private void startupBaseTargets() {
        if (this.mDSIMediaBaseAvailable && this.mDSIMediaPlayerAvailable) {
            this.powerOn();
            this.startupTarget(1957630720);
            this.startupTarget(347017984);
            this.startupTarget(330240768);
            this.startupTarget(380572416);
        }
    }

    @Override
    public void unregistered(String string, int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("MEDIA TARGETS ~ Target startup DSI unregistered: ").append(string).append(", instance ").append(MediaBrowserHelper.getInstanceIdStr(n)).log();
        }
        if (string.equals(RuntimeGeneratedConstants.SERVICE_TS_NS[63])) {
            this.mDSIMediaBaseAvailable = false;
            this.shutdownTarget(1957630720);
            this.shutdownTargets();
        } else if (string.equals(RuntimeGeneratedConstants.SERVICE_TS_NS[66])) {
            this.mDSIMediaPlayerAvailable = false;
            this.shutdownTargets();
        } else if (string.equals(RuntimeGeneratedConstants.SERVICE_TS_NS[67])) {
            this.shutdownTarget(363795200);
        } else if (string.equals(RuntimeGeneratedConstants.SERVICE_TS_NS[69]) && this.mOnlineGraceNoteAvailable) {
            this.shutdownTarget(514790144);
        } else if (string.equals(RuntimeGeneratedConstants.SERVICE_TS_NS[64])) {
            switch (n) {
                case 0: {
                    this.shutdownTarget(397349632);
                    break;
                }
                case 3: {
                    this.shutdownTarget(414126848);
                    break;
                }
                case 4: {
                    this.shutdownTarget(481235712);
                    break;
                }
                case 7: {
                    this.shutdownTarget(447681280);
                    break;
                }
                case 1: {
                    this.shutdownTarget(430904064);
                    break;
                }
                case 2: {
                    this.shutdownTarget(464458496);
                    break;
                }
            }
        }
    }

    private void shutdownTarget(int n) {
        this.sendSafe(ServiceManager.mGenericEventFactory.newEvent(this.getTargetId(), n, 107));
    }

    private void shutdownTargets() {
        if (this.mDSIMediaBaseAvailable && this.mDSIMediaPlayerAvailable) {
            this.shutdownTarget(330240768);
            this.shutdownTarget(380572416);
            this.shutdownTarget(347017984);
        }
    }

    public void dsiStartupUpdateDomainStatusMedia(int n, int n2) {
        if (this.isTraceEnabled()) {
            this.trace().append("MEDIA TARGETS ~ Domain Status Media: ").append(MediaBrowserHelper.getDomainStateStr(n)).log();
        }
        if (IMediaConstants.ESO) {
            if (n == 0 || n == 1) {
                if (!this.mRecoveryInProgress) {
                    SourceHandlingPersistence.getInstance().domainUnavailable();
                    MediaObjectAccessor.reset();
                    this.sendSafe(ServiceManager.mGenericEventFactory.newEvent(-1027199744));
                    this.mRecoveryInProgress = true;
                }
                if (n == 1) {
                    this.mDsiStartup.startDomain(3, 7825703);
                }
            } else if (this.mRecoveryInProgress && (n < 0 || n > 16)) {
                if (Util.isBitSet(8192, n)) {
                    this.info().append("MEDIA TARGETS ~ starting DSIMediaBase.").log();
                    ServiceManager.dsiServiceAdmin.startService((class$org$dsi$ifc$media$DSIMediaBase == null ? (class$org$dsi$ifc$media$DSIMediaBase = TargetMediaStartup.class$("org.dsi.ifc.media.DSIMediaBase")) : class$org$dsi$ifc$media$DSIMediaBase).getName(), 0);
                }
                if (Util.isBitSet(16384, n)) {
                    this.info().append("MEDIA TARGETS ~ starting DSIMediaPlayer.").log();
                    ServiceManager.dsiServiceAdmin.startService((class$org$dsi$ifc$media$DSIMediaPlayer == null ? (class$org$dsi$ifc$media$DSIMediaPlayer = TargetMediaStartup.class$("org.dsi.ifc.media.DSIMediaPlayer")) : class$org$dsi$ifc$media$DSIMediaPlayer).getName(), 0);
                }
                if (Util.isBitSet(1, n)) {
                    this.info().append("MEDIA TARGETS ~ starting DSIMediaRecorder.").log();
                    ServiceManager.dsiServiceAdmin.startService((class$org$dsi$ifc$media$DSIMediaRecorder == null ? (class$org$dsi$ifc$media$DSIMediaRecorder = TargetMediaStartup.class$("org.dsi.ifc.media.DSIMediaRecorder")) : class$org$dsi$ifc$media$DSIMediaRecorder).getName(), 0);
                }
                if (Util.isBitSet(2, n)) {
                    this.info().append("MEDIA TARGETS ~ starting DSIMediaBrowser instance 0 -> main browser.").log();
                    ServiceManager.dsiServiceAdmin.startService((class$org$dsi$ifc$media$DSIMediaBrowser == null ? (class$org$dsi$ifc$media$DSIMediaBrowser = TargetMediaStartup.class$("org.dsi.ifc.media.DSIMediaBrowser")) : class$org$dsi$ifc$media$DSIMediaBrowser).getName(), 0);
                    this.info().append("MEDIA TARGETS ~ starting DSIMediaBrowser instance 1 -> cover browser.").log();
                    ServiceManager.dsiServiceAdmin.startService((class$org$dsi$ifc$media$DSIMediaBrowser == null ? (class$org$dsi$ifc$media$DSIMediaBrowser = TargetMediaStartup.class$("org.dsi.ifc.media.DSIMediaBrowser")) : class$org$dsi$ifc$media$DSIMediaBrowser).getName(), 1);
                }
                if (Util.isBitSet(4, n)) {
                    this.info().append("MEDIA TARGETS ~ starting DSIMediaBrowser instance 2 -> speech browser.").log();
                    ServiceManager.dsiServiceAdmin.startService((class$org$dsi$ifc$media$DSIMediaBrowser == null ? (class$org$dsi$ifc$media$DSIMediaBrowser = TargetMediaStartup.class$("org.dsi.ifc.media.DSIMediaBrowser")) : class$org$dsi$ifc$media$DSIMediaBrowser).getName(), 2);
                    this.info().append("MEDIA TARGETS ~ starting DSIMediaBrowser instance 3 -> BAP browser.").log();
                    ServiceManager.dsiServiceAdmin.startService((class$org$dsi$ifc$media$DSIMediaBrowser == null ? (class$org$dsi$ifc$media$DSIMediaBrowser = TargetMediaStartup.class$("org.dsi.ifc.media.DSIMediaBrowser")) : class$org$dsi$ifc$media$DSIMediaBrowser).getName(), 3);
                    this.info().append("MEDIA TARGETS ~ starting DSIMediaBrowser instance 4 -> HAS browser.").log();
                    ServiceManager.dsiServiceAdmin.startService((class$org$dsi$ifc$media$DSIMediaBrowser == null ? (class$org$dsi$ifc$media$DSIMediaBrowser = TargetMediaStartup.class$("org.dsi.ifc.media.DSIMediaBrowser")) : class$org$dsi$ifc$media$DSIMediaBrowser).getName(), 4);
                }
                if (Util.isBitSet(8, n)) {
                    // empty if block
                }
                if (Util.isBitSet(16, n)) {
                    // empty if block
                }
                if (Util.isBitSet(32, n)) {
                    this.info().append("MEDIA TARGETS ~ starting DSIMediaBrowser instance 7 -> recorder browser.").log();
                    ServiceManager.dsiServiceAdmin.startService((class$org$dsi$ifc$media$DSIMediaBrowser == null ? (class$org$dsi$ifc$media$DSIMediaBrowser = TargetMediaStartup.class$("org.dsi.ifc.media.DSIMediaBrowser")) : class$org$dsi$ifc$media$DSIMediaBrowser).getName(), 7);
                }
                if (Util.isBitSet(8192, n) && Util.isBitSet(16384, n) && Util.isBitSet(2, n) && Util.isBitSet(4, n) && Util.isBitSet(32, n) && Util.isBitSet(1, n)) {
                    this.info().append("MEDIA TARGETS ~ Media domain state all needed bits set: Recovery finished!").log();
                    this.mRecoveryInProgress = false;
                    this.startDelayedTargets();
                    EventGeneric eventGeneric = this.newEvent(279909120, 59179264);
                    this.sendSafe(eventGeneric);
                }
            }
        }
    }

    public void rqPowerOn(ResponseHandler responseHandler) {
        this.registerForResponse(601, responseHandler);
        if (this.poweredOn) {
            this.fireResponse(true);
        }
    }

    @Override
    public int getComponentId() {
        throw new UnsupportedOperationException();
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

