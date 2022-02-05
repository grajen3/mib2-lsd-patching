/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.androidauto.target;

import de.vw.mib.asl.api.androidauto.ASLAndroidAutoFactory;
import de.vw.mib.asl.api.exboxm.ASLExboxmFactory;
import de.vw.mib.asl.api.exboxm.guidance.ExboxGuidanceManager;
import de.vw.mib.asl.api.navigation.ASLNavigationFactory;
import de.vw.mib.asl.api.navigation.ASLNavigationServices;
import de.vw.mib.asl.framework.api.displaymanagement.ASLDisplaymanagementFactory;
import de.vw.mib.asl.framework.api.displaymanagement.displayable.DisplayableService;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.dsi.util.RuntimeGeneratedConstants;
import de.vw.mib.asl.internal.androidauto.api.impl.ASLAndroidAutoExBoxServiceImpl;
import de.vw.mib.asl.internal.androidauto.api.impl.ExboxGuidanceListenerImpl;
import de.vw.mib.asl.internal.androidauto.target.ASLEventHandler;
import de.vw.mib.asl.internal.androidauto.target.ASLHandler;
import de.vw.mib.asl.internal.androidauto.target.AndroidAutoGlobalProperties;
import de.vw.mib.asl.internal.androidauto.target.AudioHandler;
import de.vw.mib.asl.internal.androidauto.target.DSIHandler;
import de.vw.mib.asl.internal.androidauto.target.DisplayableListener;
import de.vw.mib.asl.internal.androidauto.target.KeyHandler;
import de.vw.mib.asl.internal.androidauto.target.NavigationListener;
import de.vw.mib.asl.internal.androidauto.target.PopupHandler;
import de.vw.mib.asl.internal.androidauto.target.RequestHandler;
import de.vw.mib.asl.internal.androidauto.target.SpeechHandler;
import de.vw.mib.asl.internal.androidauto.target.StartupHandler;
import de.vw.mib.asl.internal.androidauto.target.TimerHandler;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.threads.AsyncServiceFactory;
import de.vw.mib.util.Util;
import org.dsi.ifc.androidauto2.CallState;
import org.dsi.ifc.androidauto2.DSIAndroidAuto2;
import org.dsi.ifc.androidauto2.PlaybackInfo;
import org.dsi.ifc.androidauto2.TelephonyState;
import org.dsi.ifc.androidauto2.TrackData;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.ResourceLocator;
import org.osgi.framework.ServiceReference;

public class AndroidAutoTarget
extends AbstractASLTarget
implements DSIServiceStateListener {
    private TimerHandler timerHandler;
    private ASLHandler aslHandler;
    private ASLEventHandler aslEventHandler;
    private DSIHandler dsihandler;
    private AudioHandler audioHandler;
    private AndroidAutoGlobalProperties properties;
    private StartupHandler startupHandler;
    private NavigationListener navigationListener;
    private RequestHandler requestHandler;
    private SpeechHandler speechHandler;
    private KeyHandler keyHandler;
    private PopupHandler popupHandler;
    private DisplayableListener displayableListener;
    private ASLNavigationServices navServices;
    private ExboxGuidanceListenerImpl exboxGuidanceListenerImpl;
    private DisplayableService dispService;
    private DSIAndroidAuto2 dsiAndroidAuto2;
    private DSIListener dsiAndroidAuto2Listener;
    private boolean targetStarted = false;
    boolean dsiSmartPhoneIntegrationAvailable = false;
    private /*final*/ String _classname;
    private ASLAndroidAutoExBoxServiceImpl apiImpl;
    /*final*/ int[] OBSERVED_EVENTS = new int[]{622091520, 638868736, 806640896, 823418112, 957635840, 755580160, 252263680, 403258624, 352926976, 118045952, 110969088};
    /*final*/ int[] DSI_ANDROIDAUTO2_ATTR = new int[]{1, 6, 2};
    static /* synthetic */ Class class$org$dsi$ifc$androidauto2$DSIAndroidAuto2;
    static /* synthetic */ Class class$org$dsi$ifc$androidauto2$DSIAndroidAuto2Listener;
    static /* synthetic */ Class class$de$vw$mib$threads$AsyncServiceFactory;
    static /* synthetic */ Class class$de$vw$mib$popup$PopupInformationHandler;

    public AndroidAutoTarget(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this._classname = "AndroidAutoTarget";
        if (this.isTraceEnabled()) {
            this.trace("Target AndroidAuto - Initialising Target AndroidAuto (1)!");
        }
        this.initHandler();
    }

    public AndroidAutoTarget(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        this._classname = "AndroidAutoTarget";
        if (this.isTraceEnabled()) {
            this.trace("Target AndroidAuto - Initialising Target AndroidAuto (2)!");
        }
        this.initHandler();
    }

    public AndroidAutoTarget(GenericEvents genericEvents, int n) {
        super(genericEvents, n);
        this._classname = "AndroidAutoTarget";
        if (this.isTraceEnabled()) {
            this.trace("Target AndroidAuto - Initialising Target AndroidAuto (3)!");
        }
        this.initHandler();
    }

    private void initHandler() {
        if (this.isTraceEnabled()) {
            this.trace("AndroidAutoTarget::initHandler()");
        }
        this.properties = new AndroidAutoGlobalProperties();
        this.startupHandler = new StartupHandler(this);
        this.audioHandler = new AudioHandler(this, this.properties, this.startupHandler);
        this.speechHandler = new SpeechHandler(this, ServiceManager.bundleContext, this.properties, this.startupHandler, this.audioHandler);
        this.requestHandler = new RequestHandler(this, this.properties, this.startupHandler, this.audioHandler, this.speechHandler);
        this.dsihandler = new DSIHandler(this, this.audioHandler, this.requestHandler);
        this.aslHandler = new ASLHandler(this, this.properties, this.startupHandler, this.audioHandler, this.speechHandler);
        this.aslEventHandler = new ASLEventHandler(this, this.audioHandler, this.aslHandler);
        this.popupHandler = new PopupHandler(this);
        this.displayableListener = new DisplayableListener(this, this.properties, this.startupHandler);
        this.keyHandler = new KeyHandler(this, this.properties, this.startupHandler, this.speechHandler);
        this.navigationListener = new NavigationListener(this, this.properties, this.startupHandler);
        this.timerHandler = new TimerHandler(this, this.audioHandler, this.requestHandler);
        ExboxGuidanceManager exboxGuidanceManager = ASLExboxmFactory.getExboxmApi().getExboxGuidanceManager();
        this.exboxGuidanceListenerImpl = new ExboxGuidanceListenerImpl(this.navigationListener, exboxGuidanceManager);
        this.requestHandler.initNavigationListener(this.navigationListener);
        this.aslHandler.initNavigationListener(this.navigationListener);
        this.audioHandler.initTimerHandler(this.timerHandler);
        this.requestHandler.initTimerHandler(this.timerHandler);
        this.aslHandler.initTimerHandler(this.timerHandler);
        this.requestHandler.initExBoxNavServices(this.exboxGuidanceListenerImpl);
    }

   // @Override
    public void gotEvent(EventGeneric eventGeneric) {
        if (this.aslEventHandler == null) {
            if (this.isTraceEnabled()) {
                this.warn("Target AndroidAuto - got an event! target is not fully startet yet - event will be ignored");
            }
        } else {
            if (this.isTraceEnabled()) {
                this.trace("Target AndroidAuto - got an event! target is set, call event handling");
            }
            this.aslEventHandler.handleEvent(eventGeneric);
        }
    }

    public void initializeDSI() {
        Object object;
        if (this.isTraceEnabled()) {
            object = this.trace();
            object.append("AndroidAutoTarget").append(".initializeDSI()").log();
        }
        object = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiAndroidAuto2 = (DSIAndroidAuto2)object.getService(this, class$org$dsi$ifc$androidauto2$DSIAndroidAuto2 == null ? (class$org$dsi$ifc$androidauto2$DSIAndroidAuto2 = AndroidAutoTarget.class$("org.dsi.ifc.androidauto2.DSIAndroidAuto2")) : class$org$dsi$ifc$androidauto2$DSIAndroidAuto2);
        if (this.isTraceEnabled()) {
            this.trace("Target AndroidAuto - createDSIListenerMethodAdapter! ");
        }
        this.dsiAndroidAuto2Listener = object.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$androidauto2$DSIAndroidAuto2Listener == null ? (class$org$dsi$ifc$androidauto2$DSIAndroidAuto2Listener = AndroidAutoTarget.class$("org.dsi.ifc.androidauto2.DSIAndroidAuto2Listener")) : class$org$dsi$ifc$androidauto2$DSIAndroidAuto2Listener);
        if (this.isTraceEnabled()) {
            this.trace("Target AndroidAuto - createDSIListenerMethodAdapter finished!");
        }
        if (this.isTraceEnabled()) {
            this.trace("Target AndroidAuto - Listener is set, now add response listener!");
        }
        object.addResponseListener(this, class$org$dsi$ifc$androidauto2$DSIAndroidAuto2Listener == null ? (class$org$dsi$ifc$androidauto2$DSIAndroidAuto2Listener = AndroidAutoTarget.class$("org.dsi.ifc.androidauto2.DSIAndroidAuto2Listener")) : class$org$dsi$ifc$androidauto2$DSIAndroidAuto2Listener, this.dsiAndroidAuto2Listener);
        if (this.isTraceEnabled()) {
            this.trace("Target AndroidAuto - service set, now set notification!");
        }
        this.dsiAndroidAuto2.setNotification(this.DSI_ANDROIDAUTO2_ATTR, this.dsiAndroidAuto2Listener);
    }

    private void deInitializeDSI() {
        if (this.dsiAndroidAuto2Listener != null) {
            DSIProxyFactory.getDSIProxyAPI().getDSIProxy().removeResponseListener(this, class$org$dsi$ifc$androidauto2$DSIAndroidAuto2Listener == null ? (class$org$dsi$ifc$androidauto2$DSIAndroidAuto2Listener = AndroidAutoTarget.class$("org.dsi.ifc.androidauto2.DSIAndroidAuto2Listener")) : class$org$dsi$ifc$androidauto2$DSIAndroidAuto2Listener, this.dsiAndroidAuto2Listener);
        }
        this.dsiAndroidAuto2Listener = null;
    }

    public DSIAndroidAuto2 getDSIAndroidAuto2() {
        if (!this.startupHandler.isDSI2Registered()) {
            this.warn().append("AndroidAutoTarget").append(".getDSIAndroidAuto2() Invalid DSI instance").log();
        }
        return this.dsiAndroidAuto2;
    }

    public void startup() {
        ServiceReference[] serviceReferenceArray;
        if (this.isTraceEnabled()) {
            serviceReferenceArray = this.trace();
            serviceReferenceArray.append("AndroidAutoTarget").append(".startup()").log();
        }
        DSIProxyFactory.getDSIProxyAPI().getDSIProxy().addServiceStateListener(class$org$dsi$ifc$androidauto2$DSIAndroidAuto2 == null ? (class$org$dsi$ifc$androidauto2$DSIAndroidAuto2 = AndroidAutoTarget.class$("org.dsi.ifc.androidauto2.DSIAndroidAuto2")) : class$org$dsi$ifc$androidauto2$DSIAndroidAuto2, this);
        this.addObservers(this.OBSERVED_EVENTS);
        this.targetStarted = true;
        serviceReferenceArray = ServiceManager.bundleContext.getServiceReferences((class$de$vw$mib$threads$AsyncServiceFactory == null ? (class$de$vw$mib$threads$AsyncServiceFactory = AndroidAutoTarget.class$("de.vw.mib.threads.AsyncServiceFactory")) : class$de$vw$mib$threads$AsyncServiceFactory).getName(), "(MIBThreadId=3)");
        AsyncServiceFactory asyncServiceFactory = (AsyncServiceFactory)ServiceManager.bundleContext.getService(serviceReferenceArray[0]);
        ServiceManager.bundleContext.registerService((class$de$vw$mib$popup$PopupInformationHandler == null ? (class$de$vw$mib$popup$PopupInformationHandler = AndroidAutoTarget.class$("de.vw.mib.popup.PopupInformationHandler")) : class$de$vw$mib$popup$PopupInformationHandler).getName(), asyncServiceFactory.create(this.popupHandler, new Class[]{class$de$vw$mib$popup$PopupInformationHandler == null ? (class$de$vw$mib$popup$PopupInformationHandler = AndroidAutoTarget.class$("de.vw.mib.popup.PopupInformationHandler")) : class$de$vw$mib$popup$PopupInformationHandler}), null);
        if (this.exboxGuidanceListenerImpl != null) {
            this.exboxGuidanceListenerImpl.startup();
        }
    }

    public void shutdown() {
        if (this.isTraceEnabled()) {
            this.trace().append("AndroidAutoTarget").append(".shutdown()").log();
        }
        if (this.targetStarted) {
            DSIProxyFactory.getDSIProxyAPI().getDSIProxy().removeServiceStateListener(class$org$dsi$ifc$androidauto2$DSIAndroidAuto2 == null ? (class$org$dsi$ifc$androidauto2$DSIAndroidAuto2 = AndroidAutoTarget.class$("org.dsi.ifc.androidauto2.DSIAndroidAuto2")) : class$org$dsi$ifc$androidauto2$DSIAndroidAuto2, this);
            this.removeObservers(this.OBSERVED_EVENTS);
            this.deInitializeDSI();
            this.targetStarted = false;
        }
        if (this.exboxGuidanceListenerImpl != null) {
            this.exboxGuidanceListenerImpl.shutdown();
        }
    }

   // @Override
    public int getClassifier() {
        return 1174437888;
    }

   // @Override
    public int getSubClassifier() {
        return 1;
    }

   // @Override
    public int getDefaultTargetId() {
        return -230549504;
    }

   // @Override
    public void registered(String string, int n) {
        String string2 = string.intern();
        if (this.isTraceEnabled()) {
            LogMessage logMessage = this.trace();
            logMessage.append("AndroidAutoTarget").append(".registered(").append(Util.isNullOrEmpty(string2) ? "<null>" : string).append(", ").append(n).append(")").log();
        }
        if (string2 == RuntimeGeneratedConstants.SERVICE_TS_NS[2]) {
            this.initializeDSI();
            this.audioHandler.registerTargetToEntertainmentManager();
            this.startupHandler.setDSI2Registered(true);
            this.navServices = ASLNavigationFactory.getNavigationApi().getASLNavigationServices(this.navigationListener);
            this.navigationListener.initNavServices(this.navServices);
            this.apiImpl = (ASLAndroidAutoExBoxServiceImpl)ASLAndroidAutoFactory.getAndroidAutoApi().getExBoxService();
            this.apiImpl.setTarget(this);
        }
        if (this.isTraceEnabled()) {
            this.trace(new StringBuffer().append("==> startuphandler.isDSI2Registered() = ").append(this.startupHandler.isDSI2Registered()).toString());
        }
        this.dispService = ASLDisplaymanagementFactory.getDisplaymanagementApi().getDisplayableService();
        this.trace(new StringBuffer().append("dispService           = ").append(this.dispService).toString());
        this.trace(new StringBuffer().append("displayableListener   = ").append(this.displayableListener).toString());
        if (this.dispService != null) {
            this.trace("TargetAndroidAutoDSI#dispService.addListener( displayableListener );");
            this.dispService.addListener(this.displayableListener);
        }
    }

   // @Override
    public void unregistered(String string, int n) {
        String string2 = string.intern();
        if (this.isTraceEnabled()) {
            LogMessage logMessage = this.trace();
            logMessage.append("AndroidAutoTarget").append(".unregistered(").append(Util.isNullOrEmpty(string2) ? "<null>" : string).append(", ").append(n).append(")").log();
        }
        if (string2 == RuntimeGeneratedConstants.SERVICE_TS_NS[2]) {
            this.deInitializeDSI();
            this.startupHandler.setDSI2Registered(false);
        }
        if (this.dispService != null) {
            this.trace("TargetAndroidAutoDSI#dispService.removeListener( displayableListener );");
            this.dispService.removeListener(this.displayableListener);
        }
    }

    public RequestHandler getRequestHandler() {
        return this.requestHandler;
    }

    public void dsiAndroidAuto2VideoFocusRequestNotification(int n, int n2) {
        if (this.isTraceEnabled()) {
            this.trace("TargetAndroidAuto2DSI#videoFocusRequestNotification called");
        }
        this.dsihandler.handleDsiAndroidAuto2VideoFocusRequestNotification(n, n2);
    }

    public void dsiAndroidAuto2VideoAvailable(boolean bl, int n) {
        if (this.isTraceEnabled()) {
            this.trace("TargetAndroidAuto2DSI#videoAvailable called");
        }
        this.dsihandler.handleDsiAndroidAuto2VideoAvailable(bl, n);
    }

    public void dsiAndroidAuto2AudioFocusRequestNotification(int n, int n2) {
        if (this.isTraceEnabled()) {
            this.trace("TargetAndroidAuto2DSI#audioFocusRequestNotification called");
        }
        this.dsihandler.handleDsiAndroidAuto2AudioFocusRequestNotification(n, n2);
    }

    public void dsiAndroidAuto2AudioAvailable(int n, boolean bl, int n2) {
        if (this.isTraceEnabled()) {
            this.trace("TargetAndroidAuto2DSI#audioAvailable called");
        }
        this.dsihandler.handleDsiAndroidAuto2AudioAvailable(n, bl, n2);
    }

    public void dsiAndroidAuto2VoiceSessionNotification(int n, int n2) {
        if (this.isTraceEnabled()) {
            this.trace("TargetAndroidAuto2DSI#voiceSessionNotification called");
        }
        this.dsihandler.handleDsiAndroidAuto2VoiceSessionNotification(n, n2);
    }

    public void dsiAndroidAuto2MicrophoneRequestNotification(int n, int n2) {
        if (this.isTraceEnabled()) {
            this.trace("TargetAndroidAuto2DSI#microphoneRequestNotification called");
        }
        this.dsihandler.handleDsiAndroidAuto2MicrophoneRequestNotification(n, n2);
    }

    public void dsiAndroidAuto2NavFocusRequestNotification(int n, int n2) {
        if (this.isTraceEnabled()) {
            this.trace("TargetAndroidAuto2DSI#navFocusRequestNotification called");
        }
        this.dsihandler.handleDsiAndroidAuto2NavFocusRequestNotification(n, n2);
    }

    public void dsiAndroidAuto2UpdateCallState(CallState[] callStateArray, int n) {
        if (this.isTraceEnabled()) {
            this.trace("TargetAndroidAuto2DSI#updateCallState called");
        }
    }

    public void dsiAndroidAuto2UpdateTelephonyState(TelephonyState telephonyState, int n) {
        if (this.isTraceEnabled()) {
            this.trace("TargetAndroidAuto2DSI#updateTelephonyState called");
        }
    }

    public void dsiAndroidAuto2UpdateNowPlayingData(TrackData trackData, int n) {
        if (this.isTraceEnabled()) {
            this.trace("TargetAndroidAuto2DSI#updateNowPlayingData called");
        }
    }

    public void dsiAndroidAuto2UpdatePlaybackState(PlaybackInfo playbackInfo, int n) {
        if (this.isTraceEnabled()) {
            this.trace("TargetAndroidAuto2DSI#updatePlaybackState called");
        }
    }

    public void dsiAndroidAuto2UpdatePlayposition(int n, int n2) {
        if (this.isTraceEnabled()) {
            this.trace("TargetAndroidAuto2DSI#updateServiceStatus called");
        }
    }

    public void dsiAndroidAuto2UpdateCoverArtUrl(ResourceLocator resourceLocator, int n) {
        if (this.isTraceEnabled()) {
            this.trace("TargetAndroidAuto2DSI#updateCoverArtUrl called");
        }
    }

    public void dsiAndroidAuto2UpdateNavigationNextTurnEvent(String string, int n, int n2, int n3, int n4, int n5) {
        if (this.isTraceEnabled()) {
            this.trace("TargetAndroidAuto2DSI#updateNavigationNextTurnEvent called");
        }
    }

    public void dsiAndroidAuto2UpdateNavigationNextTurnDistance(int n, int n2, int n3) {
        if (this.isTraceEnabled()) {
            this.trace("TargetAndroidAuto2DSI#updateNavigationNextTurnDistance called");
        }
    }

    public void dsiAndroidAuto2SetExternalDestination(double d2, double d3, String string, String string2) {
        if (this.isTraceEnabled()) {
            this.trace("TargetAndroidAuto2DSI#setExternalDestination called");
        }
    }

    public void dsiAndroidAuto2BluetoothPairingRequest(String string, int n) {
        if (this.isTraceEnabled()) {
            this.trace("TargetAndroidAuto2DSI#bluetoothPairingRequest called");
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

