/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mirrorlink.target;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.dsi.util.RuntimeGeneratedConstants;
import de.vw.mib.asl.internal.mirrorlink.sound.MirrorLinkAudioHandler;
import de.vw.mib.asl.internal.mirrorlink.target.MirrorLinkController;
import de.vw.mib.asl.internal.mirrorlink.target.MirrorLinkErrorHandler;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.util.Util;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.mirrorlink.Application;
import org.dsi.ifc.mirrorlink.DSIMirrorLink;
import org.dsi.ifc.mirrorlink.Device;
import org.dsi.ifc.mirrorlink.Notification;

public class MirrorLinkTarget
extends AbstractASLTarget
implements DSIServiceStateListener {
    private DSIMirrorLink dsiMirrorLink = null;
    private DSIListener dsiMirrorLinkListener = null;
    private boolean targetStarted = false;
    private boolean registered = false;
    private final String classname;
    final int[] OBSERVED_EVENTS = new int[]{513622272, 110969088, 530399488, 252263680, 118045952, 722025728, -993645312, 588537088, 605314304, 890526976, 907304192, 873749760, 957635840};
    final int[] DSI_MIRRORLINK_ATTR = new int[]{5, 10, 11, 3, 4, 1, 13, 6, 8, 9, 7, 12, 14, 5, 15, 16, 17, 18, 19, 20};
    private final MirrorLinkController mirrorLinkHandler = new MirrorLinkController(this);
    private final MirrorLinkAudioHandler mirrorLinkAudioHandler = new MirrorLinkAudioHandler(this);
    private final MirrorLinkErrorHandler mirrorLinkErrorHandler = new MirrorLinkErrorHandler(this);
    static /* synthetic */ Class class$org$dsi$ifc$mirrorlink$DSIMirrorLink;
    static /* synthetic */ Class class$org$dsi$ifc$mirrorlink$DSIMirrorLinkListener;

    public MirrorLinkTarget(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        this.classname = "MirrorLinkTarget";
    }

    private boolean initializeDSI() {
        if (this.isTraceEnabled()) {
            this.trace().append("MirrorLinkTarget").append(".initializeDSI()").log();
        }
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiMirrorLink = (DSIMirrorLink)dSIProxy.getService(this, class$org$dsi$ifc$mirrorlink$DSIMirrorLink == null ? (class$org$dsi$ifc$mirrorlink$DSIMirrorLink = MirrorLinkTarget.class$("org.dsi.ifc.mirrorlink.DSIMirrorLink")) : class$org$dsi$ifc$mirrorlink$DSIMirrorLink);
        this.dsiMirrorLinkListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$mirrorlink$DSIMirrorLinkListener == null ? (class$org$dsi$ifc$mirrorlink$DSIMirrorLinkListener = MirrorLinkTarget.class$("org.dsi.ifc.mirrorlink.DSIMirrorLinkListener")) : class$org$dsi$ifc$mirrorlink$DSIMirrorLinkListener);
        if (this.dsiMirrorLinkListener == null) {
            this.warn().append("MirrorLinkTarget").append(".initializeDSI() Invalid DSIMirrorLinkListener").log();
            return false;
        }
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$mirrorlink$DSIMirrorLinkListener == null ? (class$org$dsi$ifc$mirrorlink$DSIMirrorLinkListener = MirrorLinkTarget.class$("org.dsi.ifc.mirrorlink.DSIMirrorLinkListener")) : class$org$dsi$ifc$mirrorlink$DSIMirrorLinkListener, this.dsiMirrorLinkListener);
        if (this.dsiMirrorLink == null) {
            this.warn().append("MirrorLinkTarget").append(".initializeDSI() Invalid DSIMirrorLink").log();
            return false;
        }
        this.dsiMirrorLink.setNotification(this.DSI_MIRRORLINK_ATTR, this.dsiMirrorLinkListener);
        return true;
    }

    private void deInitializeDSI() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        dSIProxy.removeResponseListener(this, class$org$dsi$ifc$mirrorlink$DSIMirrorLinkListener == null ? (class$org$dsi$ifc$mirrorlink$DSIMirrorLinkListener = MirrorLinkTarget.class$("org.dsi.ifc.mirrorlink.DSIMirrorLinkListener")) : class$org$dsi$ifc$mirrorlink$DSIMirrorLinkListener, this.dsiMirrorLinkListener);
        this.dsiMirrorLink = null;
        this.dsiMirrorLinkListener = null;
    }

    MirrorLinkController getController() {
        return this.mirrorLinkHandler;
    }

    MirrorLinkAudioHandler getMirrorLinkAudioHandler() {
        return this.mirrorLinkAudioHandler;
    }

    public DSIMirrorLink getDSIMirrorLink() {
        if (this.dsiMirrorLink == null) {
            this.warn().append("MirrorLinkTarget").append(".getDSIMirrorLink() Invalid DSI instance").log();
        }
        return this.dsiMirrorLink;
    }

    public boolean isDSIAvailable() {
        boolean bl;
        boolean bl2 = bl = this.dsiMirrorLink != null && this.registered;
        if (!bl && this.isTraceEnabled()) {
            this.warn("MirrorLink DSI not available - call will be ignored!");
        }
        return bl;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        if (this.mirrorLinkHandler == null) {
            if (this.isTraceEnabled()) {
                this.warn().append("Target MirrorLink - got an event! Target is not fully started yet - event will be ignored: ").append(eventGeneric).log();
                return;
            }
        } else if (this.isTraceEnabled()) {
            this.trace().append("MirrorLinkTarget").append(".gotEvent() Target MirrorLink - got an event! Target is set, calling event handling.").log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                if (this.isTraceEnabled()) {
                    this.trace().append("MirrorLinkTarget").append(".gotEvent(POWER_ON)").log();
                }
                this.startup();
                break;
            }
            case 107: {
                if (this.isTraceEnabled()) {
                    this.trace().append("MirrorLinkTarget").append(".gotEvent(POWER_OFF)").log();
                }
                this.shutdown();
                break;
            }
            case 8: {
                if (!this.isTraceEnabled()) break;
                this.trace().append("MirrorLinkTarget").append(".gotEvent(NOTIFY_TARGET_REGISTERED)").log();
                break;
            }
            case 9: {
                if (!this.isTraceEnabled()) break;
                this.trace().append("MirrorLinkTarget").append(".gotEvent(NOTIFY_TARGET_UNREGISTERED)").log();
                break;
            }
            case 4300062: {
                if (this.isTraceEnabled()) {
                    this.trace().append("MirrorLinkTarget").append(".handle(ASLSystemServiceIds.RELOAD_PERSISTABLES)").log();
                }
                this.getController().handleServiceReloadPersistence();
                break;
            }
            case 4300063: {
                if (this.isTraceEnabled()) {
                    this.trace().append("MirrorLinkTarget").append(".handle(ASLSystemServiceIds.BT_THRESHOLD_EXCEEDED)").log();
                }
                this.getController().handleServiceThresholdExceeded(eventGeneric.getBoolean(0));
                break;
            }
            case 4300038: {
                if (this.isTraceEnabled()) {
                    this.trace().append("MirrorLinkTarget").append(".handle(ASLSystemServiceIds.DAYNIGHT_MODE)").log();
                }
                this.getController().handleServiceDayNightMode(eventGeneric.getBoolean(0));
                break;
            }
            case 3000004: {
                if (this.isTraceEnabled()) {
                    this.trace().append("MirrorLinkTarget").append(".handle(ASLMediaServiceIds.ASL_MEDIA_CURRENT_BTA_NAME)").log();
                }
                this.getController().handleServiceBluetoothAudioConnection((String)eventGeneric.getObject(0));
                break;
            }
            case 1073744466: {
                this.getController().handleAslApiCloseAllOpenApps();
                break;
            }
            case 1073744219: {
                if (this.isTraceEnabled()) {
                    this.trace().append("MirrorLinkTarget").append(".handle(CLOSE_MIRRORLINK ASL Dropdown event)").log();
                }
                this.getController().handleAslApiCloseMirrorLink();
                break;
            }
            case 1073744482: {
                this.getController().handleAslApiEnterAppModeView();
                break;
            }
            case 1073744484: {
                this.getController().handleAslApiEnterMirrorlinkContext();
                break;
            }
            case 1073744483: {
                this.getController().handleAslApiLeaveAppModeView();
                break;
            }
            case 1073744485: {
                this.getController().handleAslApiLeaveMirrorlinkContext();
                break;
            }
            case 1073744215: {
                if (this.isTraceEnabled()) {
                    this.trace().append("MirrorLinkTarget").append(".handle(SELECT_APP_LIST)").log();
                }
                this.getController().handleAslApiSelectAppList(eventGeneric.getInt(0));
                break;
            }
            case 1073744221: {
                this.getController().handleAslApiSelectDisplayOrientation(eventGeneric.getInt(0));
                break;
            }
            case 1073744220: {
                this.getController().handleAslApiSelectDisplayRotation(eventGeneric.getInt(0));
                break;
            }
            case 1074741829: {
                this.getController().handleAslApiSelectAppNotificationButton(eventGeneric.getInt(1));
                break;
            }
            case 1073744366: {
                this.getController().handleAslApiSelectOpenAppList(eventGeneric.getInt(0));
                break;
            }
            case 1073744566: {
                this.getController().handleAslApiSoftButtonSelected(eventGeneric.getInt(0), eventGeneric.getInt(1));
                break;
            }
            case 1073744477: {
                this.getController().handleAslApiSetIconCapability(eventGeneric.getInt(0), eventGeneric.getInt(1));
                break;
            }
            case 1074741828: {
                this.getController().handleAslApiToggleAllowAppPopup();
                break;
            }
            case 1073744216: {
                this.getController().handleAslApiToggleIsProximityModeActivated();
                break;
            }
            case 1073744368: {
                this.getController().handleAslApiToggleMirrorlinkActivation();
                break;
            }
            case 1073744369: {
                this.getController().handleAslApiToggleUpsideDownActivation();
                break;
            }
            case 1073744572: {
                this.getController().handleAslApiTouchEventGesture(eventGeneric.getInt(0), eventGeneric.getInt(1), eventGeneric.getInt(2), eventGeneric.getInt(3), eventGeneric.getInt(4), eventGeneric.getInt(5), eventGeneric.getInt(6));
                break;
            }
            case 1073744766: {
                if (this.isTraceEnabled()) {
                    this.trace().append("MirrorLinkTarget").append(".handle(SELECT_FULL_ACCESS)").log();
                }
                this.getController().handleAslApiSelectPhoneView();
                break;
            }
            case 1074741825: {
                if (this.isTraceEnabled()) {
                    this.trace().append("MirrorLinkTarget").append(".handle(CONTROLBAR visibility mode)").log();
                }
                this.getController().handleAslApiControlbarVisibilityMode();
                break;
            }
            case 4000007: {
                if (!this.isTraceEnabled()) break;
                this.trace().append("MirrorLinkTarget").append(".handle(ASLSoundServiceIds.ASL_SOUND_USERMUTE_IS_ACTIVE)").log();
                break;
            }
            case 4000015: {
                if (this.isTraceEnabled()) {
                    this.trace().append("MirrorLinkTarget").append(".handle(ASLSoundServiceIds.ASL_SOUND_AUDIO_CONNECTION_RELEASED)").log();
                }
                this.getController().handleSoundAudioConnectionReleased(eventGeneric.getInt(0));
                break;
            }
            case 100003: {
                if (this.isTraceEnabled()) {
                    this.trace().append("MirrorLinkTarget").append(".handle(EV_MIRRORLINK_SOUND_SET_CONNECTION_ANSWER)").append(" AudioSource=").append(eventGeneric.getInt(0)).log();
                }
                this.getController().handleSoundSetAudioConnectionResponse(eventGeneric.getInt(0), eventGeneric.getResult() == 0);
                break;
            }
            case 100004: {
                if (!this.isTraceEnabled()) break;
                this.trace().append("MirrorLinkTarget").append(".handle(EV_MIRRORLINK_SOUND_RELEASE_CONNECTION_ANSWER)").log();
                break;
            }
            case 4000043: {
                if (!this.mirrorLinkAudioHandler.isMirrorLinkAudioConnectionActive()) break;
                boolean bl = eventGeneric.getBoolean(0);
                if (!this.mirrorLinkAudioHandler.isMirrorLinkEntertainmentActive()) break;
                if (this.isTraceEnabled()) {
                    this.trace().append("MirrorLinkTarget").append(new StringBuffer().append(".handle(ASLSoundServiceIds.ASL_MIRRORLINK_AUDIBLE)-> entertainment mute handling for MirrorLink = ").append(bl).toString()).log();
                }
                if (!this.isDSIAvailable()) break;
                this.getDSIMirrorLink().requestAudioConnectionAudible(0, bl);
                break;
            }
            case 1400004: {
                if (this.isTraceEnabled()) {
                    this.trace().append("MirrorLinkTarget").append(".handle(ASLEntertainmentmanagerServiceIds.ACTIVATE_STARTUP)").log();
                }
                if (eventGeneric.getInt(0) != 9) break;
                this.mirrorLinkAudioHandler.handleAslApiEntertainmentAudioActivateStartup();
                break;
            }
            case 1400003: {
                if (this.isTraceEnabled()) {
                    this.trace().append("MirrorLinkTarget").append(".handle(ASLEntertainmentmanagerServiceIds.ACTIVATE)").log();
                }
                this.mirrorLinkAudioHandler.handleAslApiEntertainmentAudioActivate();
                break;
            }
            case 0x155CC5: {
                if (this.isTraceEnabled()) {
                    this.trace().append("MirrorLinkTarget").append(".handle(ASLEntertainmentmanagerServiceIds.DEACTIVATE)").log();
                }
                this.mirrorLinkAudioHandler.handleAslApiEntertainmentAudioDeactivate();
                this.getController().requestEntertainment = false;
                break;
            }
            case 1400006: {
                if (this.isTraceEnabled()) {
                    this.trace().append("MirrorLinkTarget").append(".handle(ASLEntertainmentmanagerServiceIds.CANCEL answer with canceled)").log();
                }
                this.mirrorLinkAudioHandler.handleAslApiEntertainmentAudioDeactivate();
                EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent(-1034152704);
                this.sendSafe(eventGeneric2);
                break;
            }
            case 1400013: {
                if (!this.isTraceEnabled()) break;
                this.trace().append("MirrorLinkTarget").append(".handle(ASLEntertainmentmanagerServiceIds.ACTIVATION_LOST)").log();
                break;
            }
            case 6100003: {
                if (this.isTraceEnabled()) {
                    this.trace().append("MirrorLinkTarget").append(".handle(ASL_SMARTPHONEINTEGRATION_CONNECTION_ESTABLISHED_MIRRORLINK)").log();
                }
                this.getController().handleAslApiASL_SMARTPHONEINTEGRATION_CONNECTION_ESTABLISHED_MIRRORLINK();
                break;
            }
            case 6100004: {
                if (this.isTraceEnabled()) {
                    this.trace().append("MirrorLinkTarget").append(".handle(ASL_SMARTPHONEINTEGRATION_CONNECTION_LOST_MIRRORLINK)").log();
                }
                this.getController().handleAslApiASL_SMARTPHONEINTEGRATION_CONNECTION_LOST_MIRRORLINK();
                break;
            }
            case 6100021: {
                if (this.isTraceEnabled()) {
                    this.trace().append("MirrorLinkTarget").append(".handle(ASL_SMARTPHONEINTEGRATION_CONNECTION_STARTED_MIRRORLINK)").log();
                }
                this.getController().handleAslApiASL_SMARTPHONEINTEGRATION_CONNECTION_STARTED_MIRRORLINK();
                break;
            }
            case 6100022: {
                if (this.isTraceEnabled()) {
                    this.trace().append("MirrorLinkTarget").append(".handle(ASL_SMARTPHONEINTEGRATION_CONNECTION_STOPPED_MIRRORLINK)").log();
                }
                this.getController().handleAslApiASL_SMARTPHONEINTEGRATION_CONNECTION_STOPPED_MIRRORLINK();
                break;
            }
            case 6100020: {
                if (this.isTraceEnabled()) {
                    this.trace().append("MirrorLinkTarget").append(".handle(ASL_SMARTPHONEINTEGRATION_MIRRORLINK_START_FACTORY_RESET)").log();
                }
                this.getController().handleServiceResetSettings();
                break;
            }
            case 6100025: {
                if (this.isTraceEnabled()) {
                    this.trace().append("MirrorLinkTarget").append(".handle(ASL_SMARTPHONEINTEGRATION_MFL_HK)").log();
                }
                this.getController().handleAslApiMflHardkey(eventGeneric.getInt(0));
                break;
            }
            case 3200001: {
                if (!this.isTraceEnabled()) break;
                this.trace().append("MirrorLinkTarget").append(".handle(ASL_MIRRORLINK_SERVICE_DEVICE_CONNECTED)").log();
                break;
            }
            case 100011: {
                if (this.isTraceEnabled()) {
                    this.trace().append("MirrorLinkTarget").append(".handle(EV_MIRRORLINK_REMOVE_OPEN_APP)").log();
                }
                this.getController().handleEvMirrorLinkRemoveOpenApp();
                break;
            }
            case 100020: {
                if (this.isTraceEnabled()) {
                    this.trace().append("MirrorLinkTarget").append(".handle( EV_MIRRORLINK_MFL_PREV_REPEAT )").log();
                }
                this.getController().handleEvMirrorLinkMflPrevRepeat();
                break;
            }
            case 100021: {
                if (this.isTraceEnabled()) {
                    this.trace().append("MirrorLinkTarget").append(".handle( EV_MIRRORLINK_MFL_NEXT_REPEAT )").log();
                }
                this.getController().handleEvMirrorLinkMflNextRepeat();
                break;
            }
            case 100030: {
                if (this.isTraceEnabled()) {
                    this.trace().append("MirrorLinkTarget").append(".handle( EV_MIRRORLINK_DEVELOPER_MODE )").log();
                }
                this.getController().handleEvMirrorLinkDeveloperMode();
                break;
            }
            default: {
                this.warn().append("Received unknown event: ").append(eventGeneric).log();
            }
        }
    }

    public void startup() {
        if (this.isTraceEnabled()) {
            this.trace().append("MirrorLinkTarget").append(".startup()").log();
        }
        ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$mirrorlink$DSIMirrorLink == null ? (class$org$dsi$ifc$mirrorlink$DSIMirrorLink = MirrorLinkTarget.class$("org.dsi.ifc.mirrorlink.DSIMirrorLink")) : class$org$dsi$ifc$mirrorlink$DSIMirrorLink, this);
        this.addObservers(this.OBSERVED_EVENTS);
        this.targetStarted = true;
        this.getController().initPersistence();
    }

    private void shutdown() {
        if (this.isTraceEnabled()) {
            this.trace().append("MirrorLinkTarget").append(".shutdown()").log();
        }
        if (this.targetStarted) {
            ServiceManager.dsiServiceLocator.removeServiceStateListener(class$org$dsi$ifc$mirrorlink$DSIMirrorLink == null ? (class$org$dsi$ifc$mirrorlink$DSIMirrorLink = MirrorLinkTarget.class$("org.dsi.ifc.mirrorlink.DSIMirrorLink")) : class$org$dsi$ifc$mirrorlink$DSIMirrorLink, this);
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
        return 4;
    }

    @Override
    public int getDefaultTargetId() {
        return 821891840;
    }

    @Override
    public void registered(String string, int n) {
        String string2 = string.intern();
        if (this.isTraceEnabled()) {
            this.trace().append("MirrorLinkTarget").append(".registered(").append(Util.isNullOrEmpty(string2) ? "<null>" : string).append(", ").append(n).append(")").log();
        }
        if (string2 == RuntimeGeneratedConstants.SERVICE_TS_NS[73] && this.initializeDSI()) {
            this.getController().registered();
            this.registered = true;
            this.getController().setupNotificationService();
            this.getController().handlePendingRequests();
        }
    }

    @Override
    public void unregistered(String string, int n) {
        String string2 = string.intern();
        if (this.isTraceEnabled()) {
            this.trace().append("MirrorLinkTarget").append(".unregistered(").append(Util.isNullOrEmpty(string2) ? "<null>" : string).append(", ").append(n).append(")").log();
        }
        if (string2 == RuntimeGeneratedConstants.SERVICE_TS_NS[73]) {
            this.deInitializeDSI();
            this.getController().unregistered();
            this.registered = false;
        }
    }

    public void dsiMirrorLinkResponseClientCapabilities(int n) {
        this.getController().handleDsiApiResponseClientCapabilities(n);
    }

    public void dsiMirrorLinkResponseAccessMode(int n, int n2) {
        this.getController().handleDsiApiResponseAccessMode(n, n2);
    }

    public void dsiMirrorLinkResponseDayNightMode(int n, int n2) {
        this.getController().handleDsiApiResponseDayNightMode(n, n2);
    }

    public void dsiMirrorLinkResponseUsableViewPort(int n, int n2, int n3, int n4, int n5) {
        this.getController().handleDsiApiResponseUsableViewPort(n, n2, n3, n4, n5);
    }

    public void dsiMirrorLinkResponseContextVisible(boolean bl, int n) {
        this.getController().handleDsiApiResponseContextVisible(bl, n);
    }

    public void dsiMirrorLinkResponseRotateScreen(int n, int n2) {
        this.getController().handleDsiApiResponseRotateScreen(n, n2);
    }

    public void dsiMirrorLinkResponseSoftKeyEvent(int n, int n2, int n3) {
        this.getController().handleDsiApiResponseSoftKeyEvent(n, n2, n3);
    }

    public void dsiMirrorLinkResponseLaunchApp(int n, int n2) {
        this.getController().handleDsiApiResponseLaunchApp(n, n2);
    }

    public void dsiMirrorLinkResponseTerminateApp(int n, int n2) {
        this.getController().handleDsiApiResponseTerminateApp(n, n2);
    }

    public void dsiMirrorLinkResponseAudioOption(int n, int n2) {
        this.getController().handleDsiApiResponseAudioOption(n, n2);
    }

    public void dsiMirrorLinkResponseAudioConnectionAudible(int n, boolean bl, int n2) {
        this.getController().handleDsiApiResponseAudioConnectionAudible(n, bl, n2);
    }

    public void dsiMirrorLinkResponseSendTouchEvents(int n) {
        this.getController().handleDsiApiResponseSendTouchEvents(n);
    }

    public void dsiMirrorLinkUpdateDiscoveredDevices(Device[] deviceArray, int n) {
        if (n == 1) {
            this.getController().handleDsiApiUpdateDiscoveredDevices(deviceArray);
        }
    }

    public void dsiMirrorLinkUpdateDeviceSoftKeys(int[] nArray, int n) {
        if (n == 1) {
            this.getController().handleDsiApiUpdateDeviceSoftKeys(nArray);
        }
    }

    public void dsiMirrorLinkUpdateDeviceStatus(int n, int n2) {
        if (n2 == 1) {
            this.getController().handleDsiApiUpdateDeviceStatus(n);
        }
    }

    public void dsiMirrorLinkUpdateApplicationStatus(int n, int n2, int n3, int n4) {
        if (n4 == 1) {
            this.getController().handleDsiApiUpdateApplicationStatus(n, n2, n3);
        }
    }

    public void dsiMirrorLinkUpdateScreenOrientation(int n, int n2) {
        if (n2 == 1) {
            this.getController().handleDsiApiUpdateScreenOrientation(n);
        }
    }

    public void dsiMirrorLinkUpdateScreenOrientationAvailable(boolean bl, int n) {
        if (n == 1) {
            this.getController().handleDsiApiUpdateScreenOrientationAvailable(bl);
        }
    }

    public void dsiMirrorLinkUpdateScreenRotationAvailable(boolean bl, int n) {
        if (n == 1) {
            this.getController().handleDsiApiUpdateScreenRotationAvailable(bl);
        }
    }

    public void dsiMirrorLinkUpdateAudioConnectionRequested(int n, boolean bl, int n2) {
        if (n2 == 1) {
            this.getController().handleDsiApiUpdateAudioConnectionRequested(n, bl);
        }
    }

    public void dsiMirrorLinkUpdateAvailableApplicationsList(int n, int n2) {
        if (n2 == 1) {
            this.getController().handleDsiApiUpdateAvailableApplicationsList(n);
        }
    }

    public void dsiMirrorLinkResponseAvailableApplicationsWindow(int n, Application[] applicationArray, int n2) {
        this.getController().handleDsiApiResponseAvailableApplicationsWindow(n, applicationArray, n2);
    }

    public void dsiMirrorLinkUpdateSingleApplicationMode(boolean bl, int n) {
        if (n == 1) {
            this.getController().handleDsiApiUpdateSingleApplicationMode(bl);
        }
    }

    public void dsiMirrorLinkResponseFactorySettings(int n) {
        this.getController().handleDsiApiResponseFactorySettings(n);
    }

    public void dsiMirrorLinkUpdatePhoneViewAvailable(boolean bl, int n) {
        if (n == 1) {
            this.getController().handleDsiApiUpdatePhoneViewAvailable(bl);
        }
    }

    public void dsiMirrorLinkResponsePhoneView(int n) {
        this.getController().handleDsiApiResponsePhoneView(n);
    }

    public void dsiMirrorLinkUpdateSWaPStatus(int n, int n2) {
        if (n2 == 1) {
            this.getController().handleDsiApiUpdateSWaPStatus(n);
        }
    }

    public void dsiMirrorLinkUpdateUncertifiedContent(boolean bl, int n) {
        if (n == 1) {
            this.getController().handleDsiApiUpdateUncertifiedContent(bl);
        }
    }

    public void dsiMirrorLinkUpdateLocationDataServicesEnabled(boolean bl, int n) {
        if (n == 1) {
            this.getController().handleDsiApiUpdateLocationDataServicesEnabled(bl);
        }
    }

    public void dsiMirrorLinkUpdateNotificationServiceEnabled(boolean bl, int n) {
        if (n == 1) {
            this.getController().handleDsiApiUpdateNotificationServiceEnabled(bl);
        }
    }

    public void dsiMirrorLinkUpdateShowNotification(Notification notification, int n) {
        if (n == 1) {
            this.getController().handleDsiApiUpdateShowNotification(notification);
        }
    }

    public void dsiMirrorLinkUpdateSwitchToClientNativeUI(int n) {
        if (n == 1) {
            this.getController().handleDsiApiUpdateSwitchToClientNativeUI();
        }
    }

    public void dsiMirrorLinkAsyncException(int n, String string, int n2) {
        this.mirrorLinkErrorHandler.asyncException(n, string, n2);
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

