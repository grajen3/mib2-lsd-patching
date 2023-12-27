/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.carlife;

import de.vw.mib.asl.api.navigation.ASLNavigationFactory;
import de.vw.mib.asl.api.navigation.ASLNavigationServices;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.dsi.util.RuntimeGeneratedConstants;
import de.vw.mib.asl.internal.carlife.ASLEventHandler;
import de.vw.mib.asl.internal.carlife.ASLHandler;
import de.vw.mib.asl.internal.carlife.DSIHandler;
import de.vw.mib.asl.internal.carlife.audio.CarLifeAudiohandling;
import de.vw.mib.asl.internal.carlife.common.CarLifeGlobalProperties;
import de.vw.mib.asl.internal.carlife.common.CarLifeModeHandling;
import de.vw.mib.asl.internal.carlife.common.NavigationHandler;
import de.vw.mib.asl.internal.carlife.common.PopupHandler;
import de.vw.mib.asl.internal.carlife.speech.KeyHandler;
import de.vw.mib.asl.internal.carlife.speech.SpeechApplicant;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.threads.AsyncServiceFactory;
import de.vw.mib.util.Util;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.carlife.AppState;
import org.dsi.ifc.carlife.CallState;
import org.dsi.ifc.carlife.DSICarlife;
import org.dsi.ifc.carlife.DeviceInfo;
import org.dsi.ifc.carlife.PlaybackInfo;
import org.dsi.ifc.carlife.PlaymodeInfo;
import org.dsi.ifc.carlife.Resource;
import org.dsi.ifc.carlife.TrackData;
import org.dsi.ifc.global.ResourceLocator;

public class CarlifeHSMTarget
extends AbstractASLTarget
implements DSIServiceStateListener {
    private ASLHandler aslhandler;
    private ASLEventHandler asleventhandler;
    private DSIHandler dsihandler;
    private CarLifeAudiohandling audiohandling;
    private CarLifeGlobalProperties properties;
    private CarLifeModeHandling modehandling;
    private KeyHandler keyhandler;
    private SpeechApplicant speechapplicant;
    private PopupHandler popuphandler;
    private DSICarlife dsiCarLife = null;
    private DSIListener dsiCarLifeListener = null;
    private NavigationHandler navlistener = null;
    private ASLNavigationServices navServices = null;
    private boolean targetStarted = false;
    boolean dsiSmartPhoneIntegrationAvailable = false;
    private final String _classname;
    final int[] OBSERVED_EVENTS = new int[]{-2075192832, 110969088, -2062263040, -2045485824, -2028708608, -2011931392, 991190272, 957635840, 1007967488, 839466240, 352926976, 118045952, 252263680, -631499520, -1000598272};
    final int[] DSI_CARLIFE_ATTR = new int[]{1, 8, 9};
    static /* synthetic */ Class class$org$dsi$ifc$carlife$DSICarlife;
    static /* synthetic */ Class class$org$dsi$ifc$carlife$DSICarlifeListener;
    static /* synthetic */ Class class$de$vw$mib$popup$PopupInformationHandler;

    public CarlifeHSMTarget(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this._classname = "CARLIFE.HsmTarget";
        if (this.isTraceEnabled()) {
            this.trace("Target Carlife - Initialising Target Carlife (1)!");
        }
        this.initHandler();
    }

    public CarlifeHSMTarget(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        this._classname = "CARLIFE.HsmTarget";
        if (this.isTraceEnabled()) {
            this.trace("Target Carlife - Initialising Target Carlife (2)!");
        }
        this.initHandler();
    }

    public CarlifeHSMTarget(GenericEvents genericEvents, int n) {
        super(genericEvents, n);
        this._classname = "CARLIFE.HsmTarget";
        if (this.isTraceEnabled()) {
            this.trace("Target Carlife - Initialising Target Carlife (3)!");
        }
        this.initHandler();
    }

    private void initHandler() {
        this.properties = new CarLifeGlobalProperties(this);
        this.speechapplicant = new SpeechApplicant(ASLFrameworkFactory.getASLFrameworkAPI().getServices().getBundleContext(), this, this.properties);
        this.keyhandler = new KeyHandler(this.speechapplicant, this, this.properties);
        this.navlistener = new NavigationHandler(this, this.properties);
        this.navServices = ASLNavigationFactory.getNavigationApi().getASLNavigationServices(this.navlistener);
        this.audiohandling = new CarLifeAudiohandling(this, this.properties, this.speechapplicant);
        this.modehandling = new CarLifeModeHandling(this, this.properties, this.audiohandling, this.navServices, this.speechapplicant);
        this.aslhandler = new ASLHandler(this, this.properties, this.speechapplicant, this.audiohandling, this.modehandling);
        this.asleventhandler = new ASLEventHandler(this, this.aslhandler, this.audiohandling, this.properties);
        this.dsihandler = new DSIHandler(this, this.properties, this.modehandling, this.aslhandler);
        this.speechapplicant.setAudiohandling(this.audiohandling);
        this.speechapplicant.setASLHandler(this.aslhandler);
        this.popuphandler = new PopupHandler(this, this.properties);
        this.asleventhandler.setPopupHandler(this.popuphandler);
        this.navlistener.setModeHandling(this.modehandling);
        this.audiohandling.setModeHandling(this.modehandling);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        if (this.popuphandler == null) {
            if (this.isTraceEnabled()) {
                this.warn("Target Carlife - got an event! target is not fully startet yet - event will be ignored");
            }
        } else {
            if (this.isTraceEnabled()) {
                this.trace("Target Carlife - got an event! target is set, call event handling");
            }
            this.asleventhandler.gotEvent(eventGeneric);
        }
    }

    public void initializeDSI() {
        LogMessage logMessage;
        Object object;
        if (this.isTraceEnabled()) {
            object = this.trace();
            object.append("CARLIFE.HsmTarget").append(".initializeDSI()").log();
        }
        object = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiCarLife = (DSICarlife)object.getService(this, class$org$dsi$ifc$carlife$DSICarlife == null ? (class$org$dsi$ifc$carlife$DSICarlife = CarlifeHSMTarget.class$("org.dsi.ifc.carlife.DSICarlife")) : class$org$dsi$ifc$carlife$DSICarlife);
        if (this.isTraceEnabled()) {
            this.trace("Target Carlife - createDSIListenerMethodAdapter! ");
        }
        this.dsiCarLifeListener = object.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$carlife$DSICarlifeListener == null ? (class$org$dsi$ifc$carlife$DSICarlifeListener = CarlifeHSMTarget.class$("org.dsi.ifc.carlife.DSICarlifeListener")) : class$org$dsi$ifc$carlife$DSICarlifeListener);
        if (this.isTraceEnabled()) {
            this.trace("Target Carlife - createDSIListenerMethodAdapter finished!");
        }
        if (this.dsiCarLifeListener != null) {
            if (this.isTraceEnabled()) {
                this.trace("Target Carlife - Listener is set, now add response listener!");
            }
            object.addResponseListener(this, class$org$dsi$ifc$carlife$DSICarlifeListener == null ? (class$org$dsi$ifc$carlife$DSICarlifeListener = CarlifeHSMTarget.class$("org.dsi.ifc.carlife.DSICarlifeListener")) : class$org$dsi$ifc$carlife$DSICarlifeListener, this.dsiCarLifeListener);
        } else {
            logMessage = this.warn();
            logMessage.append("CARLIFE.HsmTarget").append(".initializeDSI() Invalid DSICarLife").log();
        }
        if (this.dsiCarLife != null) {
            if (this.isTraceEnabled()) {
                this.trace("Target Carlife - service set, now set notification!");
            }
            this.dsiCarLife.setNotification(this.DSI_CARLIFE_ATTR, this.dsiCarLifeListener);
        } else {
            logMessage = this.warn();
            logMessage.append("CARLIFE.HsmTarget").append(".initializeDSI() Invalid DSICarLife").log();
        }
        this.properties.setDSIRegistered(true);
    }

    private void deInitializeDSI() {
        if (this.dsiCarLifeListener != null) {
            DSIProxyFactory.getDSIProxyAPI().getDSIProxy().removeResponseListener(this, class$org$dsi$ifc$carlife$DSICarlifeListener == null ? (class$org$dsi$ifc$carlife$DSICarlifeListener = CarlifeHSMTarget.class$("org.dsi.ifc.carlife.DSICarlifeListener")) : class$org$dsi$ifc$carlife$DSICarlifeListener, this.dsiCarLifeListener);
        }
        this.dsiCarLife = null;
        this.dsiCarLifeListener = null;
        this.properties.setDSIRegistered(false);
    }

    public DSICarlife getDSICarLife() {
        if (this.dsiCarLife == null) {
            this.warn().append("CARLIFE.HsmTarget").append(".getDSICarlife() Invalid DSI instance").log();
        }
        return this.dsiCarLife;
    }

    public void startup() {
        Object object;
        if (this.isTraceEnabled()) {
            object = this.trace();
            object.append("CARLIFE.HsmTarget").append(".startup()").log();
        }
        DSIProxyFactory.getDSIProxyAPI().getDSIProxy().addServiceStateListener(class$org$dsi$ifc$carlife$DSICarlife == null ? (class$org$dsi$ifc$carlife$DSICarlife = CarlifeHSMTarget.class$("org.dsi.ifc.carlife.DSICarlife")) : class$org$dsi$ifc$carlife$DSICarlife, this);
        this.addObservers(this.OBSERVED_EVENTS);
        this.targetStarted = true;
        this.audiohandling.registerEntertainmentConnection();
        object = ASLFrameworkFactory.getASLFrameworkAPI().getServices();
        AsyncServiceFactory asyncServiceFactory = object.getASLAsyncServiceFactory();
        object.getBundleContext().registerService((class$de$vw$mib$popup$PopupInformationHandler == null ? (class$de$vw$mib$popup$PopupInformationHandler = CarlifeHSMTarget.class$("de.vw.mib.popup.PopupInformationHandler")) : class$de$vw$mib$popup$PopupInformationHandler).getName(), asyncServiceFactory.create(this.popuphandler, new Class[]{class$de$vw$mib$popup$PopupInformationHandler == null ? (class$de$vw$mib$popup$PopupInformationHandler = CarlifeHSMTarget.class$("de.vw.mib.popup.PopupInformationHandler")) : class$de$vw$mib$popup$PopupInformationHandler}), null);
        if (object.getConfigurationManagerDiag().isFeatureFlagSet(432)) {
            this.properties.setOemIconTitle("Volkswagen");
        } else if (object.getConfigurationManagerDiag().isFeatureFlagSet(353)) {
            this.properties.setOemIconTitle("SEAT");
        } else if (object.getConfigurationManagerDiag().isFeatureFlagSet(360)) {
            this.properties.setOemIconTitle("SKODA");
        } else {
            this.properties.setOemIconTitle("HMI");
        }
    }

    public void shutdown() {
        if (this.isTraceEnabled()) {
            this.trace().append("CARLIFE.HsmTarget").append(".shutdown()").log();
        }
        if (this.targetStarted) {
            DSIProxyFactory.getDSIProxyAPI().getDSIProxy().removeServiceStateListener(class$org$dsi$ifc$carlife$DSICarlife == null ? (class$org$dsi$ifc$carlife$DSICarlife = CarlifeHSMTarget.class$("org.dsi.ifc.carlife.DSICarlife")) : class$org$dsi$ifc$carlife$DSICarlife, this);
            this.removeObservers(this.OBSERVED_EVENTS);
            this.deInitializeDSI();
            this.targetStarted = false;
        }
    }

    @Override
    public int getClassifier() {
        return 1174437888;
    }

    @Override
    public int getSubClassifier() {
        return 16;
    }

    @Override
    public int getDefaultTargetId() {
        return 38542592;
    }

    @Override
    public void registered(String string, int n) {
        String string2 = string.intern();
        if (this.isTraceEnabled()) {
            LogMessage logMessage = this.trace();
            logMessage.append("CARLIFE.HsmTarget").append(".registered(").append(Util.isNullOrEmpty(string2) ? "<null>" : string).append(", ").append(n).append(")").log();
        }
        if (string2 == RuntimeGeneratedConstants.SERVICE_TS_NS[24]) {
            this.initializeDSI();
            if (this.properties.getConnectionState() == 0) {
                this.properties.setConnectionState(2);
            } else if (this.properties.getConnectionState() == 1) {
                this.properties.setConnectionState(3);
                this.audiohandling.setAudioConnection(170, false);
                this.aslhandler.sendStartService();
                if (!this.speechapplicant.isRegistered()) {
                    this.speechapplicant.registerService();
                }
            }
        }
    }

    @Override
    public void unregistered(String string, int n) {
        String string2 = string.intern();
        if (this.isTraceEnabled()) {
            LogMessage logMessage = this.trace();
            logMessage.append("CARLIFE.HsmTarget").append(".unregistered(").append(Util.isNullOrEmpty(string2) ? "<null>" : string).append(", ").append(n).append(")").log();
        }
        if (string2 == RuntimeGeneratedConstants.SERVICE_TS_NS[24]) {
            this.deInitializeDSI();
            if (this.properties.getConnectionState() == 3) {
                this.properties.setConnectionState(1);
            } else if (this.properties.getConnectionState() == 2) {
                this.properties.setConnectionState(0);
            }
        } else if (this.isTraceEnabled()) {
            this.trace("Carlife - unregistered - wrong behaviour!");
        }
    }

    public void dsiCarlifeResponseSetMode(Resource[] resourceArray, AppState[] appStateArray) {
        this.dsihandler.handleDsiCarlifeResponseSetMode(resourceArray, appStateArray);
    }

    public void dsiCarlifeUpdateCallState(CallState callState, int n) {
        if (n == 1) {
            this.dsihandler.handleDsiCarlifeUpdateCallState(callState);
        }
    }

    public void dsiCarlifeUpdateNowPlayingData(TrackData trackData, int n) {
        if (n == 1) {
            this.dsihandler.handleDsiCarlifeUpdateNowPlayingData(trackData);
        }
    }

    public void dsiCarlifeUpdatePlaybackState(PlaybackInfo playbackInfo, int n) {
        if (n == 1) {
            this.dsihandler.handleDsiCarlifeUpdatePlaybackState(playbackInfo);
        }
    }

    public void dsiCarlifeUpdatePlaymodeState(PlaymodeInfo playmodeInfo, int n) {
        if (n == 1) {
            this.dsihandler.handleDsiCarlifeUpdatePlaymodeState(playmodeInfo);
        }
    }

    public void dsiCarlifeUpdatePlayposition(int n, int n2) {
        if (n2 == 1) {
            this.dsihandler.handleDsiCarlifeUpdatePlayposition(n);
        }
    }

    public void dsiCarlifeUpdateCoverArtUrl(ResourceLocator resourceLocator, int n) {
        if (n == 1) {
            this.dsihandler.handleDsiCarlifeUpdateCoverArtUrl(resourceLocator);
        }
    }

    public void dsiCarlifeUpdateNavigationNextTurnInfo(String string, int n, int n2, int n3, int n4, int n5) {
        if (n5 == 1) {
            this.dsihandler.handleDsiCarlifeUpdateNavigationNextTurnInfo(string, n, n2, n3, n4);
        }
    }

    public void dsiCarlifeUpdateDeviceInfo(DeviceInfo deviceInfo, int n) {
        if (n == 1) {
            this.dsihandler.handleDsiCarlifeUpdateDeviceInfo(deviceInfo);
        }
    }

    public void dsiCarlifeRequestModeChange(Resource[] resourceArray, AppState[] appStateArray) {
        this.dsihandler.handleDsiCarlifeRequestModeChange(resourceArray, appStateArray);
    }

    public void dsiCarlifeUpdateVideoAvailable(boolean bl, int n) {
        if (this.isTraceEnabled()) {
            LogMessage logMessage = this.trace();
            logMessage.append("CARLIFE.HsmTarget").append(".dsiCarLifeUpdateVideoAvailable()").log();
        }
        if (n == 1) {
            this.dsihandler.handledsiCarLifeUpdateVideoAvailable(bl);
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

