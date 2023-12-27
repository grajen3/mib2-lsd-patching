/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.carplay.target;

import de.vw.mib.asl.api.carplay.ASLCarPlayFactory;
import de.vw.mib.asl.api.exboxm.ASLExboxmFactory;
import de.vw.mib.asl.api.exboxm.guidance.ExboxGuidanceManager;
import de.vw.mib.asl.api.navigation.ASLNavigationFactory;
import de.vw.mib.asl.api.navigation.ASLNavigationServices;
import de.vw.mib.asl.api.navigation.ASLNavigationServicesListener;
import de.vw.mib.asl.api.sound.ASLSoundFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.dsi.util.RuntimeGeneratedConstants;
import de.vw.mib.asl.internal.carplay.api.impl.ASLCarplayServicesImpl;
import de.vw.mib.asl.internal.carplay.audio.CarPlayAudiohandling;
import de.vw.mib.asl.internal.carplay.common.CarPlayGlobalProperies;
import de.vw.mib.asl.internal.carplay.common.CarPlayModeHandling;
import de.vw.mib.asl.internal.carplay.common.ExboxGuidanceListenerImpl;
import de.vw.mib.asl.internal.carplay.common.NavigationHandler;
import de.vw.mib.asl.internal.carplay.common.PopupHandler;
import de.vw.mib.asl.internal.carplay.speech.KeyHandler;
import de.vw.mib.asl.internal.carplay.speech.SpeechApplicant;
import de.vw.mib.asl.internal.carplay.target.ASLEventHandler;
import de.vw.mib.asl.internal.carplay.target.ASLHandler;
import de.vw.mib.asl.internal.carplay.target.DSIHandler;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.threads.AsyncServiceFactory;
import de.vw.mib.util.Util;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.carplay.AppState;
import org.dsi.ifc.carplay.CallState;
import org.dsi.ifc.carplay.DSICarplay;
import org.dsi.ifc.carplay.DeviceInfo;
import org.dsi.ifc.carplay.Resource;
import org.dsi.ifc.carplay.TelephonyState;
import org.osgi.framework.ServiceReference;

public class HsmTarget
extends AbstractASLTarget
implements DSIServiceStateListener {
    private ASLHandler aslhandler;
    private ASLEventHandler asleventhandler;
    private DSIHandler dsihandler;
    private CarPlayAudiohandling audiohandling;
    private CarPlayGlobalProperies properties;
    private CarPlayModeHandling modehandling;
    private KeyHandler keyhandler;
    private SpeechApplicant speechapplicant;
    private PopupHandler popuphandler;
    private DSICarplay dsiCarplay = null;
    private DSIListener dsiCarPlayListener = null;
    private ASLNavigationServicesListener navlistener = null;
    private ASLNavigationServices navServices = null;
    private ExboxGuidanceListenerImpl exboxGuidanceListenerImpl;
    private boolean targetStarted = false;
    boolean dsiSmartPhoneIntegrationAvailable = false;
    private final String _classname;
    private ASLCarplayServicesImpl clusterService;
    final int[] OBSERVED_EVENTS = new int[]{-2075192832, 513622272, -358858496, 554982656, 571759872, 773086464, 789863680, 118045952, 738802944, 957635840, 352926976, 110969088, -631499520, 991190272, 252263680, 1007967488, 1108630784, 1142185216};
    final int[] DSI_CARPLAY_ATTR = new int[]{8, 7, 8, 2, 9, 12};
    static /* synthetic */ Class class$org$dsi$ifc$carplay$DSICarplay;
    static /* synthetic */ Class class$org$dsi$ifc$carplay$DSICarplayListener;
    static /* synthetic */ Class class$de$vw$mib$threads$AsyncServiceFactory;
    static /* synthetic */ Class class$de$vw$mib$popup$PopupInformationHandler;

    public HsmTarget(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this._classname = "CARPLAY.HsmTarget";
        if (this.isTraceEnabled()) {
            this.trace("Target Carplay - Initialising Target Carplay (1)!");
        }
        this.initHandler();
    }

    public HsmTarget(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        this._classname = "CARPLAY.HsmTarget";
        if (this.isTraceEnabled()) {
            this.trace("Target Carplay - Initialising Target Carplay (2)!");
        }
        this.initHandler();
    }

    public HsmTarget(GenericEvents genericEvents, int n) {
        super(genericEvents, n);
        this._classname = "CARPLAY.HsmTarget";
        if (this.isTraceEnabled()) {
            this.trace("Target Carplay - Initialising Target Carplay (3)!");
        }
        this.initHandler();
    }

    private void initHandler() {
        this.properties = new CarPlayGlobalProperies(this);
        this.speechapplicant = new SpeechApplicant(ServiceManager.bundleContext, this, this.properties);
        this.keyhandler = new KeyHandler(this.speechapplicant, this, this.properties);
        this.navlistener = new NavigationHandler(this, this.properties);
        this.navServices = ASLNavigationFactory.getNavigationApi().getASLNavigationServices(this.navlistener);
        ExboxGuidanceManager exboxGuidanceManager = ASLExboxmFactory.getExboxmApi().getExboxGuidanceManager();
        this.exboxGuidanceListenerImpl = new ExboxGuidanceListenerImpl(this.navlistener, exboxGuidanceManager);
        this.audiohandling = new CarPlayAudiohandling(this, this.properties, this.speechapplicant);
        this.modehandling = new CarPlayModeHandling(this, this.properties, this.audiohandling, this.navServices, this.speechapplicant, this.exboxGuidanceListenerImpl);
        this.aslhandler = new ASLHandler(this, this.properties, this.speechapplicant, this.audiohandling, this.modehandling, this.speechapplicant);
        this.asleventhandler = new ASLEventHandler(this, this.aslhandler, this.audiohandling, this.properties);
        this.dsihandler = new DSIHandler(this, this.properties, this.modehandling, this.audiohandling);
        this.speechapplicant.setAudiohandling(this.audiohandling);
        this.speechapplicant.setASLHandler(this.aslhandler);
        this.popuphandler = new PopupHandler(this, this.properties, this.modehandling);
        this.asleventhandler.setPopupHandler(this.popuphandler);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        if (this.popuphandler == null) {
            if (this.isTraceEnabled()) {
                this.warn("Target Carplay - got an event! target is not fully startet yet - event will be ignored");
            }
        } else {
            if (this.isTraceEnabled()) {
                this.trace("Target Carplay - got an event! target is set, call event handling");
            }
            this.asleventhandler.gotEvent(eventGeneric);
        }
    }

    public void initializeDSI() {
        LogMessage logMessage;
        Object object;
        if (this.isTraceEnabled()) {
            object = this.trace();
            object.append("CARPLAY.HsmTarget").append(".initializeDSI()").log();
        }
        object = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiCarplay = (DSICarplay)object.getService(this, class$org$dsi$ifc$carplay$DSICarplay == null ? (class$org$dsi$ifc$carplay$DSICarplay = HsmTarget.class$("org.dsi.ifc.carplay.DSICarplay")) : class$org$dsi$ifc$carplay$DSICarplay);
        if (this.isTraceEnabled()) {
            this.trace("Target Carplay - createDSIListenerMethodAdapter! ");
        }
        this.dsiCarPlayListener = object.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$carplay$DSICarplayListener == null ? (class$org$dsi$ifc$carplay$DSICarplayListener = HsmTarget.class$("org.dsi.ifc.carplay.DSICarplayListener")) : class$org$dsi$ifc$carplay$DSICarplayListener);
        if (this.isTraceEnabled()) {
            this.trace("Target Carplay - createDSIListenerMethodAdapter finished!");
        }
        if (this.dsiCarPlayListener != null) {
            if (this.isTraceEnabled()) {
                this.trace("Target Carplay - Listener is set, now add response listener!");
            }
            object.addResponseListener(this, class$org$dsi$ifc$carplay$DSICarplayListener == null ? (class$org$dsi$ifc$carplay$DSICarplayListener = HsmTarget.class$("org.dsi.ifc.carplay.DSICarplayListener")) : class$org$dsi$ifc$carplay$DSICarplayListener, this.dsiCarPlayListener);
        } else {
            logMessage = this.warn();
            logMessage.append("CARPLAY.HsmTarget").append(".initializeDSI() Invalid DSICarPlay").log();
        }
        if (this.dsiCarplay != null) {
            if (this.isTraceEnabled()) {
                this.trace("Target Carplay - service set, now set notification!");
            }
            this.dsiCarplay.setNotification(this.DSI_CARPLAY_ATTR, this.dsiCarPlayListener);
        } else {
            logMessage = this.warn();
            logMessage.append("CARPLAY.HsmTarget").append(".initializeDSI() Invalid DSICarPlay").log();
        }
        this.clusterService = (ASLCarplayServicesImpl)ASLCarPlayFactory.getCarPlayApi().getServices();
        this.clusterService.setGlobalProperties(this.properties);
        this.clusterService.setTarget(this);
    }

    private void deInitializeDSI() {
        if (this.dsiCarPlayListener != null) {
            DSIProxyFactory.getDSIProxyAPI().getDSIProxy().removeResponseListener(this, class$org$dsi$ifc$carplay$DSICarplayListener == null ? (class$org$dsi$ifc$carplay$DSICarplayListener = HsmTarget.class$("org.dsi.ifc.carplay.DSICarplayListener")) : class$org$dsi$ifc$carplay$DSICarplayListener, this.dsiCarPlayListener);
            if (this.dsiCarplay != null) {
                // empty if block
            }
        }
        this.dsiCarplay = null;
        this.dsiCarPlayListener = null;
    }

    public DSICarplay getDSICarPlay() {
        if (this.dsiCarplay == null) {
            this.warn().append("CARPLAY.HsmTarget").append(".getDSICarplay() Invalid DSI instance").log();
        }
        return this.dsiCarplay;
    }

    public void startup() {
        ServiceReference[] serviceReferenceArray;
        if (this.isTraceEnabled()) {
            serviceReferenceArray = this.trace();
            serviceReferenceArray.append("CARPLAY.HsmTarget").append(".startup()").log();
        }
        this.properties.setRingtoneConnection(ASLSoundFactory.getSoundApi().getASLSoundServices().getConnectionCarPlayRingtone());
        DSIProxyFactory.getDSIProxyAPI().getDSIProxy().addServiceStateListener(class$org$dsi$ifc$carplay$DSICarplay == null ? (class$org$dsi$ifc$carplay$DSICarplay = HsmTarget.class$("org.dsi.ifc.carplay.DSICarplay")) : class$org$dsi$ifc$carplay$DSICarplay, this);
        this.addObservers(this.OBSERVED_EVENTS);
        this.targetStarted = true;
        ServiceManager.adaptionApi.requestConfigManagerPersCoding(this.getTargetId(), -1585053440);
        this.audiohandling.registerEntertainmentConnection();
        serviceReferenceArray = ServiceManager.bundleContext.getServiceReferences((class$de$vw$mib$threads$AsyncServiceFactory == null ? (class$de$vw$mib$threads$AsyncServiceFactory = HsmTarget.class$("de.vw.mib.threads.AsyncServiceFactory")) : class$de$vw$mib$threads$AsyncServiceFactory).getName(), "(MIBThreadId=3)");
        AsyncServiceFactory asyncServiceFactory = (AsyncServiceFactory)ServiceManager.bundleContext.getService(serviceReferenceArray[0]);
        ServiceManager.bundleContext.registerService((class$de$vw$mib$popup$PopupInformationHandler == null ? (class$de$vw$mib$popup$PopupInformationHandler = HsmTarget.class$("de.vw.mib.popup.PopupInformationHandler")) : class$de$vw$mib$popup$PopupInformationHandler).getName(), asyncServiceFactory.create(this.popuphandler, new Class[]{class$de$vw$mib$popup$PopupInformationHandler == null ? (class$de$vw$mib$popup$PopupInformationHandler = HsmTarget.class$("de.vw.mib.popup.PopupInformationHandler")) : class$de$vw$mib$popup$PopupInformationHandler}), null);
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(432)) {
            this.properties.setOemIconTitle("Volkswagen");
        } else if (ServiceManager.configManagerDiag.isFeatureFlagSet(353)) {
            this.properties.setOemIconTitle("SEAT");
        } else if (ServiceManager.configManagerDiag.isFeatureFlagSet(360)) {
            this.properties.setOemIconTitle("SKODA");
        } else {
            this.properties.setOemIconTitle("HMI");
        }
        if (this.exboxGuidanceListenerImpl != null) {
            this.exboxGuidanceListenerImpl.startup();
        }
    }

    public void shutdown() {
        if (this.isTraceEnabled()) {
            this.trace().append("CARPLAY.HsmTarget").append(".shutdown()").log();
        }
        if (this.targetStarted) {
            DSIProxyFactory.getDSIProxyAPI().getDSIProxy().removeServiceStateListener(class$org$dsi$ifc$carplay$DSICarplay == null ? (class$org$dsi$ifc$carplay$DSICarplay = HsmTarget.class$("org.dsi.ifc.carplay.DSICarplay")) : class$org$dsi$ifc$carplay$DSICarplay, this);
            this.removeObservers(this.OBSERVED_EVENTS);
            this.deInitializeDSI();
            this.targetStarted = false;
        }
        if (this.exboxGuidanceListenerImpl != null) {
            this.exboxGuidanceListenerImpl.shutdown();
        }
    }

    @Override
    public int getClassifier() {
        return 1174437888;
    }

    @Override
    public int getSubClassifier() {
        return 2;
    }

    @Override
    public int getDefaultTargetId() {
        return -755755264;
    }

    @Override
    public void registered(String string, int n) {
        String string2 = string.intern();
        if (this.isTraceEnabled()) {
            LogMessage logMessage = this.trace();
            logMessage.append("CARPLAY.HsmTarget").append(".registered(").append(Util.isNullOrEmpty(string2) ? "<null>" : string).append(", ").append(n).append(")").log();
        }
        if (string2 == RuntimeGeneratedConstants.SERVICE_TS_NS[27]) {
            this.initializeDSI();
            if (this.properties.getConnectionState() == 0) {
                this.properties.setConnectionState(2);
            } else if (this.properties.getConnectionState() == 1) {
                this.properties.setConnectionState(3);
                this.audiohandling.setAudioConnection(154, false);
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
            logMessage.append("CARPLAY.HsmTarget").append(".unregistered(").append(Util.isNullOrEmpty(string2) ? "<null>" : string).append(", ").append(n).append(")").log();
        }
        if (string2 == RuntimeGeneratedConstants.SERVICE_TS_NS[27]) {
            this.deInitializeDSI();
            if (this.properties.getConnectionState() == 3) {
                this.properties.setConnectionState(1);
            } else if (this.properties.getConnectionState() == 2) {
                this.properties.setConnectionState(0);
            }
        } else if (this.isTraceEnabled()) {
            this.trace("Carplay - unregistered - wrong behaviour!");
        }
    }

    public void dsiCarplayUpdateMode(Resource[] resourceArray, AppState[] appStateArray, int n) {
        if (n == 1) {
            this.dsihandler.handledsiCarPlayupdateMode(resourceArray, appStateArray);
        }
    }

    public void dsiCarplayUpdateDeviceInfo(DeviceInfo deviceInfo, int n) {
        if (n == 1) {
            this.dsihandler.handledsiCarPlayUpdateDeviceInfo();
        }
    }

    public void dsiCarplayUpdateCallState(CallState[] callStateArray, int n) {
        Object object;
        if (this.isTraceEnabled()) {
            object = this.trace();
            object.append("CARPLAY.HsmTarget").append(".dsiCarplayUpdateCallState()").log();
        }
        if (n == 1) {
            if (!this.dsihandler.handledsiUpdateCallState(callStateArray)) {
                return;
            }
            object = this.getEventFactory().newEvent(-2121442560);
            ((EventGeneric)object).setBoolean(0, !Util.isNullOrEmpty(callStateArray) && callStateArray[0].getStatus() != 0);
            this.triggerObserver(-2121442560, (EventGeneric)object);
        }
    }

    public void dsiCarplayUpdateTelephonyState(TelephonyState telephonyState, int n) {
        if (n == 1) {
            this.dsihandler.handleUpdateTelephonyState(telephonyState);
        }
    }

    public void dsiCarplayUpdateAnnouncementStatus(int n, int n2) {
        if (n2 == 1) {
            // empty if block
        }
    }

    public void dsiCarplayOemAppSelected() {
        this.dsihandler.handledsiCarPlayOemAppSelected();
    }

    public void dsiCarplayUpdateMainAudioType(int n, int n2) {
        if (this.isTraceEnabled()) {
            LogMessage logMessage = this.trace();
            logMessage.append("CARPLAY.HsmTarget").append(new StringBuffer().append(".dsiCarplayUpdateMainAudioType - audioType: ").append(n).toString()).log();
        }
        this.dsihandler.handledsiCarPlayUpdateMainAudioType(n);
    }

    public void dsiCarplayResponseModeChange(Resource[] resourceArray, AppState[] appStateArray, int n) {
        if (this.isTraceEnabled()) {
            LogMessage logMessage = this.trace();
            logMessage.append("CARPLAY.HsmTarget").append(".dsiCarplayResponseModeChange()").log();
        }
        if (n == 1) {
            this.dsihandler.handledsiCarPlayResponseModeChange(resourceArray, appStateArray);
        }
    }

    public void dsiCarplayDuckAudio(int n, double d2) {
        if (this.isTraceEnabled()) {
            LogMessage logMessage = this.trace();
            logMessage.append("CARPLAY.HsmTarget").append(".dsiCarplayDuckAudio()").log();
        }
        this.dsihandler.handledsiCarPlayDuckAudio(n, d2);
    }

    public void dsiCarplayUnduckAudio(int n) {
        this.dsihandler.handledsiCarPlayUnduckAudio(n);
        if (this.isTraceEnabled()) {
            LogMessage logMessage = this.trace();
            logMessage.append("CARPLAY.HsmTarget").append(".dsiCarplayUnduckAudio()").log();
        }
    }

    public ASLCarplayServicesImpl getClusterService() {
        return this.clusterService;
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

