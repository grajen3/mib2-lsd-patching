/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mirrorlink.target;

import de.vw.mib.asl.api.smartphoneintegration.ASLSmartphoneIntegrationAPI;
import de.vw.mib.asl.api.smartphoneintegration.ASLSmartphoneIntegrationFactory;
import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.list.ASLListDataUpdateListener;
import de.vw.mib.asl.internal.mirrorlink.helper.MirrorlinkHelper;
import de.vw.mib.asl.internal.mirrorlink.helper.MirrorlinkViewPort;
import de.vw.mib.asl.internal.mirrorlink.listener.ExternalAppsListener;
import de.vw.mib.asl.internal.mirrorlink.model.MirrorLinkHmiGetter;
import de.vw.mib.asl.internal.mirrorlink.persistence.MirrorLinkPersistence;
import de.vw.mib.asl.internal.mirrorlink.target.MirrorLinkController$1;
import de.vw.mib.asl.internal.mirrorlink.target.MirrorLinkTarget;
import de.vw.mib.asl.internal.mirrorlink.transformer.MirrorLinkAppListCollector;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.impl.ArrayUtils;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.util.Util;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.mirrorlink.transformer.MirrorlinkAppNotificationPopupInfoCollector;
import generated.de.vw.mib.asl.internal.mirrorlink.transformer.MirrorlinkCanvasDimensionCollector;
import org.dsi.ifc.mirrorlink.Action;
import org.dsi.ifc.mirrorlink.Application;
import org.dsi.ifc.mirrorlink.ClientCapabilities;
import org.dsi.ifc.mirrorlink.Device;
import org.dsi.ifc.mirrorlink.DisplayCapabilities;
import org.dsi.ifc.mirrorlink.Event;
import org.dsi.ifc.mirrorlink.IconCapabilities;
import org.dsi.ifc.mirrorlink.Notification;

class MirrorLinkController {
    private final String classname;
    private final MirrorLinkTarget target;
    private final MirrorLinkPersistence persistence;
    private final MirrorLinkHmiGetter hmiModel;
    private final MirrorlinkViewPort viewPort = new MirrorlinkViewPort();
    private final int numberOfSimultaneousEvents;
    private boolean drivingMode = false;
    private int selectAppIndexPending = -1;
    private int upsideDownRotation = 0;
    private DisplayCapabilities displayCapabilities = null;
    private IconCapabilities iconCapabilities = null;
    boolean requestEntertainment = false;
    private boolean inMirrorLinkContext = false;
    private int requestedAppId = -1;
    private boolean specialDeveloperValue = false;
    private boolean lastUncertifiedContent = false;
    private Event pressedEvent = null;
    private Event pressedEvent2 = null;
    private int lastGestureType = 0;
    private Event[] lastTouchEvents = null;
    private Device currentBTDevice = null;
    private boolean connectionEstablished = false;
    private Notification lastNotification;
    private Notification pendingNotification;
    private final byte[] sequence = new byte[]{1, 2, 2, 1, 2, 2, 1};
    private int index = 0;
    private boolean clientCapabilitiesPending = false;
    private ASLListDataUpdateListener appListListener = null;

    MirrorLinkController(MirrorLinkTarget mirrorLinkTarget) {
        this.classname = "MirrorLinkController";
        this.numberOfSimultaneousEvents = 2;
        ASLSmartphoneIntegrationAPI aSLSmartphoneIntegrationAPI = ASLSmartphoneIntegrationFactory.getSmartphoneIntegrationApi();
        if (this.displayCapabilities == null) {
            this.displayCapabilities = new DisplayCapabilities();
            this.displayCapabilities.screenHeightInPx = ServiceManager.configManagerDiag.getLayoutMirrorlinkCanvasDimensionHeight();
            this.displayCapabilities.screenWidthInPx = ServiceManager.configManagerDiag.getLayoutMirrorlinkCanvasDimensionWidth();
            this.displayCapabilities.screenWidthInMm = (int)((double)this.displayCapabilities.screenWidthInPx * aSLSmartphoneIntegrationAPI.getPixelDimensionWidth());
            this.displayCapabilities.screenHeightInMm = (int)((double)this.displayCapabilities.screenHeightInPx * aSLSmartphoneIntegrationAPI.getPixelDimensionHeight());
            this.displayCapabilities.screenPositionX = 0;
            this.displayCapabilities.screenPositionY = 0;
            this.displayCapabilities.displayDistanceToUser = 900;
        }
        this.target = mirrorLinkTarget;
        this.persistence = new MirrorLinkPersistence(this.getTarget());
        this.hmiModel = new MirrorLinkHmiGetter(this.getTarget());
        if (this.target.isTraceEnabled()) {
            this.target.trace(new StringBuffer().append("MirrorLinkController() - smiApi.getPixelDimensionWidth=").append(aSLSmartphoneIntegrationAPI.getPixelDimensionWidth()).append(", smiApi.getPixelDimensionHeight=").append(aSLSmartphoneIntegrationAPI.getPixelDimensionHeight()).toString());
        }
        MirrorlinkCanvasDimensionCollector mirrorlinkCanvasDimensionCollector = new MirrorlinkCanvasDimensionCollector();
        mirrorlinkCanvasDimensionCollector.mirrorlink_height = this.displayCapabilities.screenHeightInPx;
        mirrorlinkCanvasDimensionCollector.mirrorlink_width = this.displayCapabilities.screenWidthInPx;
        ListManager.getGenericASLList(1567166208).updateList(new MirrorlinkCanvasDimensionCollector[]{mirrorlinkCanvasDimensionCollector});
    }

    private MirrorLinkTarget getTarget() {
        return this.target;
    }

    private MirrorLinkPersistence getPersistence() {
        return this.persistence;
    }

    private MirrorLinkHmiGetter getHMIModel() {
        return this.hmiModel;
    }

    public boolean initPersistence() {
        boolean bl = false;
        if (this.persistence != null) {
            ServiceManager.persistence.registerSharedPersistable(this.persistence);
            boolean bl2 = ServiceManager.persistence.loadPersistable(this.persistence.getNamespace(), this.persistence.getKey(), this.persistence);
            if (!bl2) {
                this.persistence.markDirty(true);
            }
            bl = true;
        }
        return bl;
    }

    void registered() {
        this.getHMIModel().setMirrorLinkActive(this.getPersistence().isMirrorlinkActive());
        this.getHMIModel().setControlbarVisibilityMode(this.getPersistence().getControlbarVisibilityMode());
    }

    void unregistered() {
    }

    private void startDSIService() {
        if (this.iconCapabilities != null) {
            if (this.displayCapabilities != null) {
                Object object;
                if (this.target.isTraceEnabled()) {
                    object = ASLSmartphoneIntegrationFactory.getSmartphoneIntegrationApi();
                    this.target.trace(new StringBuffer().append("MirrorLinkController.startDSIService() - smiApi.getPixelDimensionWidth=").append(object.getPixelDimensionWidth()).append(", smiApi.getPixelDimensionHeight=").append(object.getPixelDimensionHeight()).toString());
                }
                if (this.getTarget().getDSIMirrorLink() != null) {
                    object = new ClientCapabilities(this.displayCapabilities, this.iconCapabilities, 2);
                    this.getTarget().getDSIMirrorLink().requestClientCapabilities((ClientCapabilities)object);
                    this.clientCapabilitiesPending = false;
                }
            } else {
                this.getTarget().warn().append("MirrorLinkController").append(".startDSIService( ) - displayCapabilities not available!").log();
            }
        } else {
            if (this.getTarget().isTraceEnabled()) {
                this.getTarget().trace().append("MirrorLinkController").append(".startDSIService( ) - iconCapabilities not available, send request to model and finish later").log();
            }
            this.clientCapabilitiesPending = true;
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(1651052288);
        }
    }

    void handlePendingRequests() {
        this.setAccessMode(this.drivingMode);
    }

    public void handleSoundSetAudioConnectionResponse(int n, boolean bl) {
        int n2;
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append("MirrorLinkController").append(".handleSoundSetAudioConnectionResponse(").append(n).append(", ").append(bl).append(")").log();
        }
        if ((n2 = this.getTarget().getMirrorLinkAudioHandler().getMirrorLinkAudioConnectionDSIFromAudioHMI(n)) != -1) {
            if (n == 240) {
                this.getTarget().getMirrorLinkAudioHandler().sendEntertainmentActivation(true);
            }
            if (bl) {
                if (this.getTarget().isDSIAvailable()) {
                    this.getTarget().getDSIMirrorLink().requestAudioConnectionAudible(n2, true);
                }
            } else {
                LogMessage logMessage = this.getTarget().warn();
                logMessage.append("MirrorLinkController").append(".handleSoundSetAudioConnectionResponse(").append(n).append(", ").append(bl).append(") Not succeeded").log();
            }
        }
    }

    public void handleSoundReleaseAudioConnectionResponse(int n, boolean bl) {
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append("MirrorLinkController").append(".handleSoundReleaseAudioConnectionResponse(").append(n).append(", ").append(bl).append(")").log();
        }
        int n2 = this.getTarget().getMirrorLinkAudioHandler().getMirrorLinkAudioConnectionDSIFromAudioHMI(n);
        if (n != 0 && n2 != -1) {
            if (n == 240) {
                this.getTarget().getMirrorLinkAudioHandler().sendEntertainmentActivation(false);
            }
            if (bl) {
                if (this.getTarget().isDSIAvailable()) {
                    this.getTarget().getDSIMirrorLink().requestAudioConnectionAudible(n2, false);
                }
            } else {
                LogMessage logMessage = this.getTarget().warn();
                logMessage.append("MirrorLinkController").append(".handleSoundReleaseAudioConnectionResponse(").append(n).append(", ").append(bl).append(") Not succeeded").log();
            }
        }
    }

    public void handleSoundAudioConnectionReleased(int n) {
        int n2;
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append("MirrorLinkController").append(".handleSoundAudioConnectionReleased(").append(n).append(")").log();
        }
        if ((n2 = this.getTarget().getMirrorLinkAudioHandler().getMirrorLinkAudioConnectionDSIFromAudioHMI(n)) != -1) {
            if (n == 240) {
                this.getTarget().getMirrorLinkAudioHandler().sendEntertainmentActivation(false);
            }
            if (this.getTarget().isDSIAvailable()) {
                this.getTarget().getDSIMirrorLink().requestAudioConnectionAudible(n2, false);
            }
        }
    }

    public void handleServiceBluetoothAudioConnection(String string) {
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append("MirrorLinkController").append(".handleServiceBluetoothAudioConnection(").append(string).append(")").log();
        }
    }

    public void handleServiceReloadPersistence() {
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append("MirrorLinkController").append(".handleReloadPersistence()").log();
        }
        if (this.getPersistence().isUpsideDownActive()) {
            this.upsideDownRotation = 3;
            this.rotateScreen(true);
        } else {
            this.upsideDownRotation = 1;
            this.rotateScreen(false);
        }
        this.setDisplayOrientation(this.getPersistence().getDisplayOrientation());
    }

    public void handleServiceResetSettings() {
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append("MirrorLinkController").append(".handleResetSettings()").log();
        }
        if (this.getPersistence() != null) {
            this.getPersistence().clear();
            this.getPersistence().markDirty(true);
            this.handleServiceReloadPersistence();
        }
        if (this.getTarget().isDSIAvailable()) {
            this.getTarget().getDSIMirrorLink().requestFactorySettings();
        }
        this.selectAppIndexPending = -1;
    }

    public void handleServiceThresholdExceeded(boolean bl) {
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append("MirrorLinkController").append(".handleServiceThresholdExceeded(").append(bl).append(")").log();
        }
        this.drivingMode = bl;
        this.setAccessMode(this.drivingMode);
    }

    private void setAccessMode(boolean bl) {
        LogMessage logMessage;
        if (this.getTarget().isTraceEnabled()) {
            logMessage = this.getTarget().trace();
            logMessage.append("MirrorLinkController").append(".setAccessMode(").append(bl).append(")").log();
        }
        if (this.getTarget().isDSIAvailable()) {
            if (!this.specialDeveloperValue) {
                this.getTarget().getDSIMirrorLink().requestAccessMode(bl ? 1 : 0);
            }
        } else if (this.getTarget().isTraceEnabled()) {
            logMessage = this.getTarget().warn();
            logMessage.append("MirrorLinkController").append(".setAccessMode() - DSI not available!").log();
        }
    }

    public void handleServiceDayNightMode(boolean bl) {
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append("MirrorLinkController").append(".handleServiceDayNightMode(").append(bl).append(")").log();
        }
        if (this.getTarget().isDSIAvailable()) {
            this.getTarget().getDSIMirrorLink().requestDayNightMode(!bl ? 0 : 1);
        }
    }

    public void handleAslApiSelectAppList(int n) {
        Object object;
        if (this.getTarget().isTraceEnabled()) {
            object = this.getTarget().trace();
            object.append("MirrorLinkController").append(".handleAslApiSelectAppList(").append(n).append(")").log();
        }
        if (n > -1) {
            object = this.getHMIModel().getApplicationCollector(n);
            if (object == null) {
                if (this.getTarget().isTraceEnabled()) {
                    LogMessage logMessage = this.getTarget().trace();
                    logMessage.append("MirrorLinkController").append(".handleAslApiSelectAppList - collector == null").log();
                }
                this.selectAppIndexPending = n;
            } else {
                this.getHMIModel().setCurrentSelectedAppState(0);
                this.selectAppIndexPending = -1;
                this.getHMIModel().setCurrentSelectedApplication(((MirrorLinkAppListCollector)object).getApplication());
                if (this.getTarget().isDSIAvailable()) {
                    if (this.getTarget().isTraceEnabled()) {
                        LogMessage logMessage = this.getTarget().trace();
                        logMessage.append("MirrorLinkController").append(".handleAslApiSelectAppList - request launch app").log();
                    }
                    this.setRequestedAppID(((MirrorLinkAppListCollector)object).getApplication().getAppID());
                    this.getTarget().getDSIMirrorLink().requestLaunchApp(((MirrorLinkAppListCollector)object).getApplication().getAppID());
                }
            }
        } else {
            object = this.getTarget().warn();
            object.append("MirrorLinkController").append(".handleAslApiSelectDevice(").append(n).append(") Invalid index").log();
        }
    }

    public void handleAslApiSelectOpenAppList(int n) {
        Object object;
        if (this.getTarget().isTraceEnabled()) {
            object = this.getTarget().trace();
            object.append("MirrorLinkController").append(".handleAslApiSelectOpenAppList(").append(n).append(")").log();
        }
        if (n > -1) {
            object = this.getHMIModel().getOpenApplicationCollector(n);
            if (object == null) {
                LogMessage logMessage = this.getTarget().warn();
                logMessage.append("MirrorLinkController").append(".handleAslApiSelectOpenAppList(").append(n).append(") No valid item").log();
            } else if (this.getTarget().isDSIAvailable()) {
                this.setRequestedAppID(((MirrorLinkAppListCollector)object).getApplication().appID);
                this.getTarget().getDSIMirrorLink().requestTerminateApp(((MirrorLinkAppListCollector)object).getApplication().appID);
            }
        } else {
            object = this.getTarget().warn();
            object.append("MirrorLinkController").append(".handleAslApiSelectOpenAppList(").append(n).append(") Invalid index").log();
        }
    }

    public void handleAslApiToggleIsProximityModeActivated() {
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append("MirrorLinkController").append(".handleAslApiToggleIsProximityModeActivated()").log();
        }
        this.getHMIModel().toggleProximityModeActivated();
    }

    public void handleAslApiCloseMirrorLink() {
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append("MirrorLinkController").append(".handleAslApiCloseMirrorLink()").log();
        }
        this.removeDevMode();
        if (this.requestEntertainment) {
            this.getTarget().getMirrorLinkAudioHandler().sendEntertainmentActivation(false);
        }
        this.requestEntertainment = false;
        if (this.connectionEstablished) {
            int n = 756309248;
            this.getTarget().sendSafe(ServiceManager.mGenericEventFactory.newEvent(756309248));
        }
    }

    public void handleAslApiCloseAllOpenApps() {
        Object[] objectArray;
        if (this.getTarget().isTraceEnabled()) {
            objectArray = this.getTarget().trace();
            objectArray.append("MirrorLinkController").append(".handleAslApiCloseAllOpenApps()").log();
        }
        if (!Util.isNullOrEmpty(objectArray = this.getHMIModel().getOpenApplications())) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                int n = ((Application)objectArray[i2]).getAppID();
                if (!this.getTarget().isDSIAvailable()) continue;
                this.getTarget().getDSIMirrorLink().requestTerminateApp(n);
            }
        }
        this.getHMIModel().closeAllOpenApps();
    }

    public void handleAslApiToggleMirrorlinkActivation() {
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append("MirrorLinkController").append(".handleAslApiToggleMirrorlinkActivation()").log();
        }
        this.getPersistence().toogleMirrorlinkActive();
        boolean bl = this.getPersistence().isMirrorlinkActive();
        this.getHMIModel().setMirrorLinkActive(bl);
        if (!bl) {
            int n = 756309248;
            this.getTarget().sendSafe(ServiceManager.mGenericEventFactory.newEvent(756309248));
        }
    }

    public void handleAslApiToggleUpsideDownActivation() {
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append("MirrorLinkController").append(".handleAslApiToggleUpsideDownActivation()").log();
        }
        this.getPersistence().toogleUpsideDownActive();
        if (this.getPersistence().isUpsideDownActive()) {
            this.upsideDownRotation = 3;
            this.rotateScreen(true);
        } else {
            this.upsideDownRotation = 1;
            this.rotateScreen(false);
        }
    }

    private void rotateScreen(boolean bl) {
        if (this.getTarget().isDSIAvailable()) {
            if (bl) {
                this.getTarget().getDSIMirrorLink().requestRotateScreen(1);
            } else {
                this.getTarget().getDSIMirrorLink().requestRotateScreen(0);
            }
        }
    }

    public void handleAslApiSelectDisplayRotation(int n) {
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append("MirrorLinkController").append(".handleAslApiSelectDisplayRotation(").append(n).append(")").log();
        }
        int n2 = 0;
        switch (n) {
            case 0: {
                n2 = 0;
                break;
            }
            case 1: {
                n2 = 1;
                break;
            }
            case 2: {
                n2 = 1;
                break;
            }
            case 3: {
                n2 = 1;
                break;
            }
            default: {
                LogMessage logMessage = this.getTarget().warn();
                logMessage.append("MirrorLinkController").append(".handleAslApiSelectDisplayRotation(").append(n).append(") Unknown rotation value.").log();
                return;
            }
        }
        if (this.getTarget().isDSIAvailable()) {
            this.getTarget().getDSIMirrorLink().requestRotateScreen(n2);
        }
    }

    public void handleAslApiSelectPhoneView() {
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append("MirrorLinkController").append(".handleAslApiSelectPhoneView(").append(")").log();
        }
        this.getHMIModel().setCurrentSelectedAppState(3);
        if (this.getTarget().isDSIAvailable()) {
            this.getTarget().getDSIMirrorLink().requestPhoneView();
        }
    }

    public void handleAslApiSelectDisplayOrientation(int n) {
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append("MirrorLinkController").append(".handleAslApiSelectDisplayOrientation(").append(n).append(")").log();
        }
        this.getPersistence().setDisplayOrientation(n);
        this.setDisplayOrientation(this.getPersistence().getDisplayOrientation());
    }

    private void setDisplayOrientation(int n) {
        int n2 = 0;
        switch (n) {
            case 0: {
                n2 = 0;
                break;
            }
            case 1: {
                n2 = 1;
                break;
            }
            default: {
                LogMessage logMessage = this.getTarget().warn();
                logMessage.append("MirrorLinkController").append(".handleAslApiSelectDisplayOrientation(").append(n).append(") Unknown orientation value.").log();
                return;
            }
        }
        if (this.getTarget().isDSIAvailable()) {
            this.getTarget().getDSIMirrorLink().requestChangeOrientation(n2);
            this.getHMIModel().setDisplayOrientation(n);
        }
    }

    public void handleAslApiEnterAppModeView() {
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append("MirrorLinkController").append(".handleAslApiEnterAppModeView()").log();
        }
        if (this.getTarget().isDSIAvailable()) {
            this.getTarget().getDSIMirrorLink().requestContextVisible(true);
        }
    }

    public void handleAslApiEnterMirrorlinkContext() {
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append("MirrorLinkController").append(".handleAslApiEnterMirrorlinkContext(), requestEntertainment=").append(this.requestEntertainment).log();
        }
        this.inMirrorLinkContext = true;
        if (this.getTarget().isDSIAvailable()) {
            this.getTarget().getDSIMirrorLink().requestContextSwitched(true);
        }
        if (this.requestEntertainment) {
            this.getTarget().getMirrorLinkAudioHandler().requestAudioConnection(0, true);
        }
    }

    public void handleAslApiLeaveAppModeView() {
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append("MirrorLinkController").append(".handleAslApiLeaveAppModeView()").log();
        }
        if (this.getTarget().isDSIAvailable()) {
            this.getTarget().getDSIMirrorLink().requestContextVisible(false);
        }
    }

    public void handleAslApiLeaveMirrorlinkContext() {
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append("MirrorLinkController").append(".handleAslApiLeaveMirrorlinkContext()").log();
        }
        this.inMirrorLinkContext = false;
        if (this.getTarget().isDSIAvailable()) {
            this.getTarget().getDSIMirrorLink().requestContextSwitched(false);
        }
    }

    public void handleAslApiSetIconCapability(int n, int n2) {
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append("MirrorLinkController").append(".handleAslApiSetIconCapability(").append(n).append(", ").append(n2).append(")").log();
        }
        if (this.iconCapabilities == null) {
            this.iconCapabilities = new IconCapabilities();
            this.iconCapabilities.iconWidth = n;
            this.iconCapabilities.iconHeight = n2;
            this.iconCapabilities.colourDepth = 8;
        }
        if (this.clientCapabilitiesPending) {
            this.startDSIService();
        }
    }

    public void handleAslApiSoftButtonSelected(int n, int n2) {
        int n3;
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append("MirrorLinkController").append(".handleAslApiSoftButtonSelected(").append(n).append(", ").append(n2).append(")").log();
        }
        if ((n3 = this.getHMIModel().getDSITypeFromHMIType(n)) > 0 && this.getTarget().isDSIAvailable()) {
            this.getTarget().getDSIMirrorLink().requestSoftKeyEvent(n3, n2 == 0 ? 0 : 1);
        }
    }

    private void setDevMode() {
        if (this.getTarget().isDSIAvailable()) {
            this.getTarget().getDSIMirrorLink().requestAccessMode(0);
            this.getHMIModel().setDisplayOff(false);
            this.getHMIModel().setSpeedLimitPassed(false);
            this.specialDeveloperValue = true;
            this.getPersistence().setDeveloperMode(this.specialDeveloperValue);
            this.getHMIModel().setDeveloperMode();
        }
    }

    public void removeDevMode() {
        this.specialDeveloperValue = false;
        this.getPersistence().setDeveloperMode(this.specialDeveloperValue);
        this.handleServiceThresholdExceeded(this.drivingMode);
        this.getHMIModel().setDisplayOff(this.lastUncertifiedContent);
    }

    public void handleAslApiTouchEventGesture(int n, int n2, int n3, int n4, int n5, int n6, int n7) {
        Event[] eventArray;
        String string;
        this.iddqd(n, n2, n7);
        switch (n7) {
            case 0: {
                string = "PRESSED";
                break;
            }
            case 1: {
                string = "RELEASED";
                break;
            }
            case 2: {
                string = "CLICKED";
                break;
            }
            case 3: {
                string = "DRAGGED";
                break;
            }
            case 4: {
                string = "ZOOMED";
                break;
            }
            default: {
                string = Integer.toString(n7);
            }
        }
        if (this.getTarget().isTraceEnabled()) {
            eventArray = this.getTarget().trace();
            eventArray.append("MirrorLinkController").append(".handleAslApiTouchEventGesture( posX = ").append(n).append(", posY = ").append(n2).append(", deltaX = ").append(n3).append(", deltaY = ").append(n4).append(", fingerDistance = ").append(n5).append(", fingerDistanceChange = ").append(n6).append(", ").append(string).append("(").append(n7).append(") )").log();
        }
        if (this.lastGestureType == 4) {
            if (n7 == 0) {
                this.pressedEvent = new Event(n, n2, 1, 255);
                this.lastGestureType = 0;
                return;
            }
            if (n7 == 3 || n7 == 2) {
                this.handleAslApiTouchEventGesture(n, n2, n3, n4, n5, n6, 1);
            }
            this.lastGestureType = 1;
        }
        eventArray = null;
        switch (n7) {
            case 0: {
                if (this.pressedEvent == null) {
                    this.pressedEvent = new Event(n, n2, 0, 255);
                    if (!this.getTarget().isDSIAvailable()) break;
                    eventArray = new Event[]{this.pressedEvent};
                    this.getTarget().getDSIMirrorLink().requestSendTouchEvents(eventArray, 0);
                    break;
                }
                if (this.pressedEvent2 == null) {
                    this.pressedEvent2 = new Event(n, n2, 1, 255);
                    if (!this.getTarget().isDSIAvailable()) break;
                    eventArray = new Event[]{this.pressedEvent2};
                    this.getTarget().getDSIMirrorLink().requestSendTouchEvents(eventArray, 0);
                    break;
                }
                if (!this.getTarget().isDSIAvailable()) break;
                if (this.getTarget().isTraceEnabled()) {
                    LogMessage logMessage = this.getTarget().trace();
                    logMessage.append("MirrorLinkController").append(".handleAslApiTouchEventGesture(").append(this.pressedEvent.getXPosition()).append(", ").append(this.pressedEvent.getYPosition()).append(", ").append(n3).append(", ").append(n4).append(", ").append(n5).append(", ").append(n6).append(", ").append(1).append(")").log();
                    logMessage = this.getTarget().trace();
                    logMessage.append("MirrorLinkController").append(".handleAslApiTouchEventGesture(").append(this.pressedEvent2.getXPosition()).append(", ").append(this.pressedEvent2.getYPosition()).append(", ").append(n3).append(", ").append(n4).append(", ").append(n5).append(", ").append(n6).append(", ").append(1).append(")").log();
                }
                eventArray = new Event[]{new Event(this.pressedEvent.getXPosition(), this.pressedEvent.getYPosition(), 0, 0), new Event(this.pressedEvent2.getYPosition(), this.pressedEvent2.getYPosition(), 1, 0)};
                this.pressedEvent2 = null;
                this.getTarget().getDSIMirrorLink().requestSendTouchEvents(eventArray, 0);
                this.pressedEvent = new Event(n, n2, 0, 255);
                eventArray = new Event[]{this.pressedEvent};
                this.getTarget().getDSIMirrorLink().requestSendTouchEvents(eventArray, 0);
                break;
            }
            case 1: {
                Event[] eventArray2;
                if (this.pressedEvent2 != null) {
                    eventArray2 = new Event[2];
                    eventArray = new Event[2];
                    eventArray2[0] = new Event(this.pressedEvent.getXPosition(), this.pressedEvent.getYPosition(), 0, 255);
                    eventArray[0] = new Event(this.pressedEvent.getXPosition(), this.pressedEvent.getYPosition(), 0, 0);
                    eventArray2[1] = new Event(this.pressedEvent2.getXPosition(), this.pressedEvent2.getYPosition(), 1, 255);
                    eventArray[1] = new Event(this.pressedEvent2.getXPosition(), this.pressedEvent2.getYPosition(), 1, 0);
                } else {
                    eventArray2 = new Event[1];
                    eventArray = new Event[1];
                    eventArray2[0] = new Event(n, n2, 0, 255);
                    eventArray[0] = new Event(n, n2, 0, 0);
                }
                if (this.getTarget().isDSIAvailable()) {
                    if (this.lastGestureType != 4 && !MirrorlinkHelper.compareTouchEventCoordinates(eventArray, this.lastTouchEvents)) {
                        this.getTarget().trace().append("MirrorLinkController").append(".handleAslApiTouchEventGesture() - Synthesize PRESSED");
                        this.getTarget().getDSIMirrorLink().requestSendTouchEvents(eventArray2, 0);
                    }
                    this.getTarget().getDSIMirrorLink().requestSendTouchEvents(eventArray, 0);
                }
                this.pressedEvent = null;
                this.pressedEvent2 = null;
                break;
            }
            case 2: {
                if (this.pressedEvent == null) {
                    this.pressedEvent = new Event(n, n2, 0, 255);
                    LogMessage logMessage = this.getTarget().warn();
                    logMessage.append("MirrorLinkController").append(".handleAslApiTouchEventGesture(").append(n).append(", ").append(n2).append(", ").append(n3).append(", ").append(n4).append(", ").append(n5).append(", ").append(n6).append(", ").append(n7).append(") Missing pressed event").log();
                    eventArray = new Event[]{this.pressedEvent};
                    if (this.getTarget().isDSIAvailable()) {
                        this.getTarget().getDSIMirrorLink().requestSendTouchEvents(eventArray, 0);
                    }
                }
                eventArray = new Event[]{new Event(n, n2, 0, 0)};
                if (this.getTarget().isDSIAvailable()) {
                    this.getTarget().getDSIMirrorLink().requestSendTouchEvents(eventArray, 0);
                }
                this.pressedEvent = null;
                this.pressedEvent2 = null;
                break;
            }
            case 3: {
                eventArray = new Event[]{new Event(n, n2, 0, 255)};
                if (this.getTarget().isDSIAvailable()) {
                    this.getTarget().getDSIMirrorLink().requestSendTouchEvents(eventArray, 0);
                }
                this.pressedEvent = null;
                this.pressedEvent2 = null;
                break;
            }
            case 4: {
                this.lastGestureType = 4;
                Event event = new Event();
                event.eventID = 0;
                event.xPosition = Math.min(Math.max(n - (n5 >> 1), 0), this.displayCapabilities.screenWidthInPx);
                event.yPosition = n2;
                event.pressureValue = 255;
                Event event2 = new Event();
                event2.eventID = 1;
                event2.xPosition = Math.min(Math.max(n + (n5 >> 1), 0), this.displayCapabilities.screenWidthInPx);
                event2.yPosition = n2;
                event2.pressureValue = 255;
                eventArray = new Event[]{event, event2};
                if (this.getTarget().isDSIAvailable()) {
                    this.getTarget().getDSIMirrorLink().requestSendTouchEvents(eventArray, -1);
                }
                this.pressedEvent = event;
                this.pressedEvent2 = event2;
                break;
            }
            default: {
                LogMessage logMessage = this.target.warn();
                logMessage.append("MirrorLinkController").append(".handleAslApiTouchEventGesture(").append(n).append(", ").append(n2).append(", ").append(n3).append(", ").append(n4).append(", ").append(n5).append(", ").append(n6).append(", ").append(n7).append(") Unknown touch gesture").log();
                break;
            }
        }
        this.lastTouchEvents = eventArray;
    }

    private void iddqd(int n, int n2, int n3) {
        byte by = this.getCorner(n, n2);
        if (by == -1) {
            this.index = 0;
            return;
        }
        if (n3 == 1 || n3 == 2) {
            if (by == this.sequence[this.index]) {
                ++this.index;
                if (this.index >= this.sequence.length) {
                    this.setDevMode();
                    this.index = 0;
                }
            } else {
                this.index = 0;
            }
        } else if (n3 == 4) {
            this.index = 0;
        }
    }

    private byte getCorner(int n, int n2) {
        int n3 = ServiceManager.configManagerDiag.getDisplayDefault(0);
        int n4 = ServiceManager.configManagerDiag.getDisplayDefault(1);
        int n5 = n4 / 4;
        if (n <= n5) {
            if (n2 <= n5) {
                return 1;
            }
            if (n2 > n4 - n5) {
                return 2;
            }
        } else if (n > n3 - n5) {
            if (n2 <= n5) {
                return 0;
            }
            if (n2 > n4 - n5) {
                return 3;
            }
        }
        return -1;
    }

    public void handleAslApiControlbarVisibilityMode() {
        this.getPersistence().toggleControlbarVisibilityMode();
        this.getHMIModel().setControlbarVisibilityMode(this.getPersistence().getControlbarVisibilityMode());
    }

    public void handleDsiApiResponseClientCapabilities(int n) {
        if (n == 0) {
            this.setDisplayOrientation(MirrorlinkHelper.convertDisplayOrientationAslGetter2lSetterValue(this.getPersistence().getDisplayOrientation()));
            if (this.getPersistence().isUpsideDownActive()) {
                this.upsideDownRotation = 3;
                this.rotateScreen(true);
            }
            if (this.getTarget().isDSIAvailable()) {
                this.getTarget().getDSIMirrorLink().requestAudioOption(0);
                this.getTarget().getDSIMirrorLink().requestUsableViewport(this.displayCapabilities.getScreenPositionX(), this.displayCapabilities.getScreenPositionY(), this.displayCapabilities.getScreenWidthInPx(), this.displayCapabilities.getScreenHeightInPx());
            }
        } else {
            LogMessage logMessage = this.getTarget().warn();
            logMessage.append("MirrorLinkController").append(".handleDsiApiResponseClientCapabilities(").append(n).append(") Request unsuccessfully finished.").log();
        }
    }

    public void handleDsiApiResponseAccessMode(int n, int n2) {
        LogMessage logMessage;
        if (this.getTarget().isTraceEnabled()) {
            logMessage = this.getTarget().trace();
            logMessage.append("MirrorLinkController").append(".handleDsiApiResponseAccessMode(").append(n).append(" , ").append(n2).append(" )").log();
        }
        if (n2 == 0) {
            switch (n) {
                case 0: {
                    this.getHMIModel().setSpeedLimitPassed(false);
                    break;
                }
                case 1: {
                    this.getHMIModel().setSpeedLimitPassed(true);
                    break;
                }
                default: {
                    logMessage = this.getTarget().warn();
                    logMessage.append("MirrorLinkController").append(".handleDsiApiResponseAccessMode(").append(n).append(", ").append(n2).append(") Unknown value.").log();
                    break;
                }
            }
        } else {
            logMessage = this.getTarget().warn();
            logMessage.append("MirrorLinkController").append(".handleDsiApiResponseAccessMode(").append(n).append(", ").append(n2).append(") Request unsuccessfully finished.").log();
        }
    }

    public void handleDsiApiResponseDayNightMode(int n, int n2) {
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append("MirrorLinkController").append(".handleDsiApiResponseDayNightMode(").append(n).append(", ").append(new StringBuffer().append(n2 == 0 ? "RESULT_OK" : "RESULT_ERROR").append(")").toString()).log();
        }
        if (n2 == 0) {
            switch (n) {
                case 0: {
                    break;
                }
                case 1: {
                    break;
                }
                default: {
                    LogMessage logMessage = this.getTarget().warn();
                    logMessage.append("MirrorLinkController").append(".handleDsiApiResponseDayNightMode(").append(n).append(", ").append(n2).append(") Unknown value.").log();
                    break;
                }
            }
        }
    }

    public void handleDsiApiResponseUsableViewPort(int n, int n2, int n3, int n4, int n5) {
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append("MirrorLinkController").append(".handleDsiApiResponseUsableViewPort(").append(n).append(", ").append(n2).append(", ").append(n3).append(", ").append(n4).append(", ").append(new StringBuffer().append(n5 == 0 ? "RESULT_OK" : "RESULT_ERROR").append(")").toString()).log();
        }
    }

    public void handleDsiApiResponseContextVisible(boolean bl, int n) {
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append("MirrorLinkController").append(new StringBuffer().append(".handleDsiApiResponseContextVisible(").append(bl).append(", ").append(n == 0 ? "RESULT_OK" : "RESULT_ERROR").append(")").toString()).log();
        }
    }

    public void handleDsiApiResponseRotateScreen(int n, int n2) {
        block10: {
            LogMessage logMessage;
            block9: {
                if (this.getTarget().isTraceEnabled()) {
                    logMessage = this.getTarget().trace();
                    logMessage.append("MirrorLinkController").append(".handleAslSetScaleMode(").append(n).append(", ").append(n2).append(")").log();
                }
                if (n2 != 0) break block9;
                switch (n) {
                    case 0: {
                        if (this.upsideDownRotation == 1) {
                            this.upsideDownRotation = 2;
                            this.rotateScreen(false);
                            break;
                        }
                        if (this.upsideDownRotation == 2) {
                            this.upsideDownRotation = 0;
                            this.getHMIModel().setUpsideDownActive(this.getPersistence().isUpsideDownActive());
                            break;
                        }
                        break block10;
                    }
                    case 1: {
                        if (this.upsideDownRotation == 3) {
                            this.upsideDownRotation = 4;
                            this.rotateScreen(true);
                            break;
                        }
                        if (this.upsideDownRotation == 4) {
                            this.upsideDownRotation = 0;
                            this.getHMIModel().setUpsideDownActive(this.getPersistence().isUpsideDownActive());
                            break;
                        }
                        break block10;
                    }
                    default: {
                        logMessage = this.getTarget().warn();
                        logMessage.append("MirrorLinkController").append(".handleDsiApiResponseRotateScreen(").append(n).append(", ").append(n2).append(") Unknown rotateDirection value.").log();
                        break;
                    }
                }
                break block10;
            }
            logMessage = this.getTarget().warn();
            logMessage.append("MirrorLinkController").append(".handleDsiApiResponseRotateScreen(").append(n).append(", ").append(n2).append(") Request unsuccessfully finished.").log();
        }
    }

    public void handleDsiApiResponseSoftKeyEvent(int n, int n2, int n3) {
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append("MirrorLinkController").append(".handleDsiApiResponseSoftKeyEvent(").append(n).append(", ").append(n2).append(", ").append(n3 == 0 ? "RESULT_OK" : "RESULT_ERROR").append(" )").log();
        }
    }

    public void handleDsiApiResponseLaunchApp(int n, int n2) {
        Object object;
        if (this.getTarget().isTraceEnabled()) {
            object = this.getTarget().trace();
            object.append("MirrorLinkController").append(new StringBuffer().append(".handleDsiApiResponseLaunchApp(").append(n).append(", ").append(n2).append(")").toString()).log();
        }
        this.setRequestedAppID(-1);
        if (n2 == 0) {
            object = this.getHMIModel().getApplication(n);
            if (object != null) {
                this.getHMIModel().addOpenApp((Application)object);
                if (this.drivingMode && ((Application)object).getCertType() == 1) {
                    this.getHMIModel().setCurrentSelectedAppState(3);
                    if (this.getTarget().isTraceEnabled()) {
                        LogMessage logMessage = this.getTarget().trace();
                        logMessage.append("MirrorLinkController").append(".handleDsiApiResponseLaunchApp(").append(n).append(n2).append("_drivingMode== true ").append("CERTTYPE_DRIVING").log();
                    }
                } else if (!this.drivingMode) {
                    this.getHMIModel().setCurrentSelectedAppState(3);
                    if (this.getTarget().isTraceEnabled()) {
                        LogMessage logMessage = this.getTarget().trace();
                        logMessage.append("MirrorLinkController").append(".handleDsiApiResponseLaunchApp(").append(n).append(n2).append("_drivingMode == false ").append("CERTTYPE_BASIC) || Constants.CERTTYPE_NONE").log();
                    }
                } else if (this.drivingMode && ((Application)object).getCertType() != 1) {
                    this.getHMIModel().setCurrentSelectedAppState(1);
                    if (this.getTarget().isTraceEnabled()) {
                        LogMessage logMessage = this.getTarget().trace();
                        logMessage.append("MirrorLinkController").append(".handleDsiApiResponseLaunchApp(").append(n).append(n2).append("_drivingMode== true ").append("NOT_CERTTYPE_DRIVING").log();
                    }
                } else {
                    this.getHMIModel().setCurrentSelectedAppState(2);
                    if (this.getTarget().isTraceEnabled()) {
                        LogMessage logMessage = this.getTarget().trace();
                        logMessage.append("MirrorLinkController").append(".handleDsiApiResponseLaunchApp(").append(n).append(n2).append(" Error ").log();
                    }
                }
            } else if (this.getTarget().isTraceEnabled()) {
                this.getTarget().trace().append("MirrorLinkController").append(".handleDsiApiResponseLaunchApp(").append(n).append(", ").append(n2).append(") Application instance not available. Launching anyway.").log();
            }
        } else {
            this.getHMIModel().setCurrentSelectedAppState(2);
            object = this.getTarget().warn();
            object.append("MirrorLinkController").append(".handleDsiApiResponseLaunchApp(").append(n).append(", ").append(n2).append(") Request unsuccessfully finished.").log();
        }
    }

    public void handleDsiApiResponseTerminateApp(int n, int n2) {
        Object object;
        if (this.getTarget().isTraceEnabled()) {
            object = this.getTarget().trace();
            object.append("MirrorLinkController").append(new StringBuffer().append(".handleDsiApiResponseTerminateApp(").append(n).append(", ").append(n2).append(")").toString()).log();
        }
        this.setRequestedAppID(-1);
        if (n2 == 0) {
            object = this.getHMIModel().getApplication(n);
            if (object != null) {
                this.getHMIModel().removeOpenApp((Application)object);
            } else {
                LogMessage logMessage = this.getTarget().warn();
                logMessage.append("MirrorLinkController").append(".handleDsiApiResponseTerminateApp(").append(n).append(", ").append(n2).append(") Applcation instance not available.").log();
            }
        } else {
            object = this.getTarget().warn();
            object.append("MirrorLinkController").append(".handleDsiApiResponseTerminateApp(").append(n).append(", ").append(n2).append(") Request unsuccessfully finished.").log();
            Application application = this.getHMIModel().getApplication(n);
            if (application != null) {
                this.getHMIModel().addOpenApp(application);
            }
        }
    }

    public void handleDsiApiResponseAudioOption(int n, int n2) {
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append("MirrorLinkController").append(".handleDsiApiResponseAudioOption(").append(n).append(", ").append(n2 == 0 ? "RESULT_OK" : "RESULT_ERROR").append(")").log();
        }
        if (n2 == 0) {
            // empty if block
        }
    }

    public void handleDsiApiResponseAudioConnectionAudible(int n, boolean bl, int n2) {
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append("MirrorLinkController").append(".handleDsiApiResponseAudioConnectionAudible(").append(n).append(", ").append(bl).append(", ").append(n2 == 0 ? "RESULT_OK" : "RESULT_ERROR").append(")").log();
        }
    }

    public void handleDsiApiResponseSendTouchEvents(int n) {
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append("MirrorLinkController").append(".handleDsiApiResponseSendTouchEvents(").append(n == 0 ? "RESULT_OK" : "RESULT_ERROR").append(")").log();
        }
    }

    public void handleDsiApiResponseAvailableApplicationsWindow(int n, Application[] applicationArray, int n2) {
        LogMessage logMessage;
        if (this.getTarget().isTraceEnabled()) {
            logMessage = this.getTarget().trace();
            logMessage.append("MirrorLinkController").append(".handleDsiApiResponseAvailableApplicationsWindow(").append(n).append(", ").append(ArrayUtils.asString(applicationArray)).append(", ").append(n2).append(")").log();
        }
        if (n2 == 0) {
            if (this.selectAppIndexPending != -1) {
                this.appListListener = new MirrorLinkController$1(this);
                this.getHMIModel().addASLListDataUpdateListener(this.appListListener);
            }
            this.getHMIModel().updateAvailableApplications(n, applicationArray);
        } else {
            logMessage = this.getTarget().warn();
            logMessage.append("MirrorLinkController").append("handleDsiApiResponseAvailableApplicationsWindow.(").append(n2).append(") Request unsuccessfully finished.").log();
        }
    }

    public void handleDsiApiResponseFactorySettings(int n) {
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append("MirrorLinkController").append(".handleDsiApiResponseFactorySettings(").append(n == 0 ? "RESULT_OK" : "RESULT_ERROR").append(")").log();
        }
    }

    public void handleDsiApiResponsePhoneView(int n) {
        if (n == 0) {
            this.getHMIModel().setPhoneViewModeActive(true);
        } else if (n == 8) {
            this.getHMIModel().setPhoneViewModeActive(false);
            this.getHMIModel().setCurrentSelectedAppState(2);
        } else {
            LogMessage logMessage = this.getTarget().warn();
            logMessage.append("MirrorLinkController").append(".handleDsiApiResponsePhoneView(").append(n).append(") Request unsuccessfully finished.").log();
        }
    }

    public void handleDsiApiUpdateDiscoveredDevices(Device[] deviceArray) {
        Object object;
        Object object2;
        if (this.getTarget().isTraceEnabled()) {
            object2 = this.getTarget().trace();
            if (deviceArray.length == 0) {
                object2.append("MirrorLinkController").append(".handleDsiApiUpdateDiscoveredDevices( dsiUpdateDevices=empty)").log();
            } else {
                object2 = this.getTarget().trace();
                object2.append("MirrorLinkController").append(".handleDsiApiUpdateDiscoveredDevices( dsiUpdateDevices=").append(this.printDeviceList(deviceArray)).append(")").log();
            }
        }
        if (deviceArray.length == 0) {
            return;
        }
        this.currentBTDevice = deviceArray[0];
        object2 = "";
        if (this.getTarget().isTraceEnabled()) {
            object = this.getTarget().trace();
            object.append(new StringBuffer().append("Device in the list -> ").append(this.currentBTDevice != null ? this.currentBTDevice.toString() : "NULL").append(")").toString()).log();
        }
        object2 = MirrorlinkHelper.getBTMACFromDeviceAddress(this.currentBTDevice);
        if (this.currentBTDevice != null && this.getTarget().isDSIAvailable()) {
            object = ServiceManager.mGenericEventFactory.newEvent(30683136);
            ((EventGeneric)object).setString(0, "");
            ((EventGeneric)object).setString(1, (String)object2);
            ServiceManager.eventMain.getEventDispatcher().sendSafe((EventGeneric)object);
        }
    }

    private String printDeviceList(Device[] deviceArray) {
        String string = null;
        if (!Util.isNullOrEmpty(deviceArray)) {
            for (int i2 = 0; i2 < deviceArray.length; ++i2) {
                string = Util.isNullOrEmpty(string) ? deviceArray[i2].toString() : new StringBuffer().append(string).append(deviceArray[i2].toString()).toString();
            }
        } else {
            string = "EMPTY";
        }
        return string;
    }

    public void handleDsiApiUpdateDeviceSoftKeys(int[] nArray) {
        this.getHMIModel().updateDeviceSoftKeys(nArray);
    }

    public void handleDsiApiUpdateApplicationStatus(int n, int n2, int n3) {
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append("MirrorLinkController").append(".handleDsiApiUpdateApplicationStatus(").append(n).append(", ").append(n2).append(", ").append(n3).append(")").log();
        }
        this.getHMIModel().updateApplicationStatus(n, n2, n3);
    }

    public void handleDsiApiUpdateDeviceStatus(int n) {
        LogMessage logMessage;
        if (this.getTarget().isTraceEnabled()) {
            logMessage = this.getTarget().trace();
            logMessage.append("MirrorLinkController").append(".handleDsiApiUpdateDeviceStatus(").append(n).append(")").log();
        }
        switch (n) {
            case 0: {
                if (this.getHMIModel().isDeviceLocked()) {
                    this.getHMIModel().setDeviceLocked(false);
                }
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(1533611776);
                break;
            }
            case 2: {
                this.getHMIModel().setDeviceLocked(true);
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(1365839616);
                break;
            }
            case 5: {
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(1416171264);
                break;
            }
            case 6: {
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(1432948480);
                break;
            }
            case 7: {
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(1449725696);
                break;
            }
            case 10: {
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(1399394048);
                break;
            }
            default: {
                logMessage = this.getTarget().warn();
                logMessage.append("MirrorLinkController").append(".handleDsiApiUpdateDeviceStatus(").append(n).append("): Unknown swap status").log();
                break;
            }
        }
    }

    public void handleDsiApiUpdateScreenOrientation(int n) {
        int n2 = 0;
        switch (n) {
            case 0: {
                n2 = 0;
                break;
            }
            case 1: {
                n2 = 1;
                break;
            }
        }
        this.getPersistence().setDisplayOrientation(n2);
        this.getHMIModel().setDisplayOrientation(n2);
    }

    public void handleDsiApiUpdateScreenOrientationAvailable(boolean bl) {
        this.getHMIModel().setDisplayOrientationAvailable(bl);
    }

    public void handleDsiApiUpdateScreenRotationAvailable(boolean bl) {
        this.getHMIModel().setScreenRotationAvailable(bl);
    }

    public void handleDsiApiUpdateAudioConnectionRequested(int n, boolean bl) {
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append("MirrorLinkController").append(".handleDsiApiUpdateAudioConnectionRequested(").append(new StringBuffer().append(n).append(", ").append(bl).toString()).append(") ").log();
        }
        if (bl) {
            if (n == 0) {
                this.requestEntertainment = true;
                this.getTarget().getMirrorLinkAudioHandler().entertainmentAudioSetVolumeRelease();
            }
            if (n != 0 || this.inMirrorLinkContext || this.getTarget().getMirrorLinkAudioHandler().isMirrorLinkAudioConnectionActive()) {
                this.getTarget().getMirrorLinkAudioHandler().requestAudioConnection(n, this.inMirrorLinkContext);
            }
        } else {
            if (n == 0) {
                this.requestEntertainment = false;
                this.getTarget().getMirrorLinkAudioHandler().entertainmentAudioSetVolumeLock();
            }
            this.getTarget().getMirrorLinkAudioHandler().releaseAudioConnection(n);
        }
    }

    public void handleDsiApiUpdateAvailableApplicationsList(int n) {
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append("MirrorLinkController").append(".handleDsiApiUpdateAvailableApplicationsList(").append(n).append(") ").log();
        }
        this.getHMIModel().updateAvailableApplicationsListSize(n);
        if (this.getPersistence().isDeveloperMode()) {
            this.getTarget().startTimer(-1098514176, (long)0, false);
        }
    }

    public void handleDsiApiUpdateSingleApplicationMode(boolean bl) {
        this.getHMIModel().setNoAppExist(bl);
    }

    public void handleDsiApiUpdatePhoneViewAvailable(boolean bl) {
        this.getHMIModel().setPhoneViewModeActive(bl);
    }

    public void handleDsiApiUpdateUncertifiedContent(boolean bl) {
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append("MirrorLinkController").append(". handleDsiApiUpdateUncertifiedContent(").append(bl).append(") ").log();
        }
        this.lastUncertifiedContent = bl;
        if (!this.specialDeveloperValue) {
            this.getHMIModel().setDisplayOff(bl);
        }
    }

    public void handleDsiApiUpdateSWaPStatus(int n) {
        LogMessage logMessage;
        if (this.getTarget().isTraceEnabled()) {
            logMessage = this.getTarget().trace();
            logMessage.append("MirrorLinkController").append(".handleDsiApiUpdateSWaPStatus(").append(n).append(")").log();
        }
        switch (n) {
            case 1: {
                ASLSystemFactory.getSystemApi().setSWaPStatusForApplication(1, true);
                break;
            }
            case 0: {
                ASLSystemFactory.getSystemApi().setSWaPStatusForApplication(1, false);
                break;
            }
            default: {
                logMessage = this.getTarget().warn();
                logMessage.append("MirrorLinkController").append(".handleDsiApiUpdateSWaPStatus(").append(n).append("): Unknown swap status").log();
                break;
            }
        }
    }

    public void handleDsiApiUpdateLocationDataServicesEnabled(boolean bl) {
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append("MirrorLinkController").append(".handleDsiApiUpdateLocationDataServicesEnabled( ").append(bl).append("  )").log();
        }
        this.getHMIModel().setLocationDataServicesEnabled(bl);
    }

    public void handleDsiApiUpdateNotificationServiceEnabled(boolean bl) {
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append("MirrorLinkController").append(".handleDsiApiUpdateNotificationServiceEnabled( ").append(bl).append("  )").log();
        }
        this.getHMIModel().setAppPopupEnabled(bl);
    }

    public void handleDsiApiUpdateShowNotification(Notification notification) {
        LogMessage logMessage;
        if (this.getTarget().isTraceEnabled()) {
            logMessage = this.getTarget().trace();
            logMessage.append("MirrorLinkController").append(".handleDsiApiUpdateShowNotification()").log();
        }
        if (this.lastNotification != null) {
            if (this.getTarget().isTraceEnabled()) {
                logMessage = this.getTarget().trace();
                logMessage.append("MirrorLinkController").append(".handleDsiApiUpdateShowNotification() - Request closing of current popup").log();
            }
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(1634275072);
            this.pendingNotification = notification;
        } else {
            this.showNotificationPopup(notification);
        }
    }

    private void showNotificationPopup(Notification notification) {
        if (notification.getAppId() == 0) {
            this.getTarget().trace().append("MirrorLinkController").append(new StringBuffer().append(".showNotificationPopup( id = ").append(notification.getNotiID()).append(" ) - Dummy notification, ignore").toString()).log();
            return;
        }
        if (notification.getActionList() == null || notification.getTitle() == null || notification.getNotiBody() == null) {
            this.getTarget().trace().append("MirrorLinkController").append(new StringBuffer().append(".showNotificationPopup( id = ").append(notification.getNotiID()).append(" ) - Malformed notification, ignore").toString()).log();
            return;
        }
        MirrorlinkAppNotificationPopupInfoCollector mirrorlinkAppNotificationPopupInfoCollector = new MirrorlinkAppNotificationPopupInfoCollector();
        this.lastNotification = notification;
        mirrorlinkAppNotificationPopupInfoCollector.mirrorlink_headertext = notification.getTitle();
        mirrorlinkAppNotificationPopupInfoCollector.mirrorlink_info_text = notification.getNotiBody();
        Action[] actionArray = notification.getActionList();
        mirrorlinkAppNotificationPopupInfoCollector.mirrorlink_available_action1 = false;
        mirrorlinkAppNotificationPopupInfoCollector.mirrorlink_available_action2 = false;
        mirrorlinkAppNotificationPopupInfoCollector.mirrorlink_text_action1 = "";
        mirrorlinkAppNotificationPopupInfoCollector.mirrorlink_text_action2 = "";
        if (actionArray.length >= 1) {
            mirrorlinkAppNotificationPopupInfoCollector.mirrorlink_available_action1 = true;
            mirrorlinkAppNotificationPopupInfoCollector.mirrorlink_text_action1 = actionArray[0].getActionName();
            if (actionArray.length >= 2) {
                mirrorlinkAppNotificationPopupInfoCollector.mirrorlink_available_action2 = true;
                mirrorlinkAppNotificationPopupInfoCollector.mirrorlink_text_action2 = actionArray[1].getActionName();
            }
        }
        ListManager.getGenericASLList(1550388992).updateListItem(0, mirrorlinkAppNotificationPopupInfoCollector);
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(1600720640);
    }

    public void handleDsiApiUpdateSwitchToClientNativeUI() {
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append("MirrorLinkController").append(".handleDsiApiUpdateSwitchToClientNativeUI()").log();
        }
        this.getHMIModel().returnToNativeUI();
    }

    public void setRequestedAppID(int n) {
        this.requestedAppId = n;
    }

    public int getRequestedAppID() {
        return this.requestedAppId;
    }

    public void handleAslApiASL_SMARTPHONEINTEGRATION_CONNECTION_ESTABLISHED_MIRRORLINK() {
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append("MirrorLinkController").append(".registered(").append("handleAslApiASL_SMARTPHONEINTEGRATION_CONNECTION_ESTABLISHED_MIRRORLINK").log();
        }
        this.getTarget().getMirrorLinkAudioHandler().registerAtEntertainmentManager();
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(1533611776);
        this.setDisplayOrientation(this.getPersistence().getDisplayOrientation());
        if (!this.getPersistence().isDeveloperMode() && this.specialDeveloperValue) {
            this.removeDevMode();
        }
        if (this.getPersistence().isDeveloperMode() && !this.specialDeveloperValue) {
            this.setDevMode();
        }
        this.requestEntertainment = false;
        this.startDSIService();
        this.connectionEstablished = true;
        ExternalAppsListener.getInstance(this.target).forceResend();
        this.setupNotificationService();
        this.setAccessMode(this.drivingMode);
    }

    public void handleAslApiASL_SMARTPHONEINTEGRATION_CONNECTION_STARTED_MIRRORLINK() {
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append("MirrorLinkController").append(".registered(").append("handleAslApiASL_SMARTPHONEINTEGRATION_CONNECTION_STARTED_MIRRORLINK").log();
        }
    }

    public void handleAslApiASL_SMARTPHONEINTEGRATION_CONNECTION_STOPPED_MIRRORLINK() {
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append("MirrorLinkController").append(".registered(").append("handleAslApiASL_SMARTPHONEINTEGRATION_CONNECTION_STOPPED_MIRRORLINK").log();
        }
    }

    public void handleAslApiASL_SMARTPHONEINTEGRATION_CONNECTION_LOST_MIRRORLINK() {
        Object object;
        if (this.getTarget().isTraceEnabled()) {
            object = this.getTarget().trace();
            object.append("MirrorLinkController").append(".registered(").append("handleAslApiASL_SMARTPHONEINTEGRATION_CONNECTION_LOST_MIRRORLINK").log();
        }
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(513);
        this.getTarget().getMirrorLinkAudioHandler().entertainmentAudioSetVolumeLock();
        this.getTarget().getMirrorLinkAudioHandler().entertainmentAudioDeactivate();
        this.requestEntertainment = false;
        this.getHMIModel().closeAllOpenApps();
        this.getHMIModel().resetAvailableApplicationsList();
        this.lastNotification = null;
        this.getHMIModel().reset();
        object = ServiceManager.mGenericEventFactory.newEvent(30683136);
        ((EventGeneric)object).setString(0, "");
        ((EventGeneric)object).setString(1, "");
        ServiceManager.eventMain.getEventDispatcher().sendSafe((EventGeneric)object);
        this.connectionEstablished = false;
    }

    public void handleAslApiMflHardkey(int n) {
        LogMessage logMessage;
        if (this.getTarget().isTraceEnabled()) {
            logMessage = this.getTarget().trace();
            logMessage.append("MirrorLinkController").append(".handleAslApiMflHardkey( ").append(n).append(" )").log();
        }
        switch (n) {
            case 0: {
                if (!this.getTarget().isDSIAvailable()) break;
                this.getTarget().getDSIMirrorLink().requestSoftKeyEvent(84148272, 0);
                this.getTarget().getDSIMirrorLink().requestSoftKeyEvent(84148272, 1);
                break;
            }
            case 1: {
                if (this.getTarget().isDSIAvailable()) {
                    this.getTarget().getDSIMirrorLink().requestSoftKeyEvent(0x3040030, 0);
                }
                this.getTarget().startTimer(-1249509120, (long)0, true);
                break;
            }
            case 2: {
                if (!this.getTarget().isDSIAvailable()) break;
                this.getTarget().getDSIMirrorLink().requestSoftKeyEvent(100925488, 0);
                this.getTarget().getDSIMirrorLink().requestSoftKeyEvent(100925488, 1);
                break;
            }
            case 3: {
                this.getTarget().stopTimer(-1266286336);
                if (!this.getTarget().isDSIAvailable()) break;
                this.getTarget().getDSIMirrorLink().requestSoftKeyEvent(0x4040030, 1);
                break;
            }
            case 4: {
                this.getTarget().stopTimer(-1249509120);
                if (!this.getTarget().isDSIAvailable()) break;
                this.getTarget().getDSIMirrorLink().requestSoftKeyEvent(0x3040030, 1);
                break;
            }
            case 5: {
                if (this.getTarget().isDSIAvailable()) {
                    this.getTarget().getDSIMirrorLink().requestSoftKeyEvent(0x4040030, 0);
                }
                this.getTarget().startTimer(-1266286336, (long)0, true);
                break;
            }
            default: {
                if (!this.getTarget().isTraceEnabled()) break;
                logMessage = this.getTarget().trace();
                logMessage.append("MirrorLinkController").append(".handleAslApiMflHardkey( unhandled HK: ").append(n).append(" )").log();
            }
        }
    }

    public void handleAslApiSelectAppNotificationButton(int n) {
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append("MirrorLinkController").append(".handleAslApiSelectAppNotificationButton( ").append(n).append(" )").log();
        }
        int n2 = this.lastNotification.getNotiID();
        Action[] actionArray = this.lastNotification.getActionList();
        switch (n) {
            case 0: {
                if (!this.getTarget().isDSIAvailable()) break;
                this.getTarget().getDSIMirrorLink().invokeNotiAction(n2, 0);
                break;
            }
            case 1: {
                if (this.getTarget().isDSIAvailable()) {
                    this.getTarget().getDSIMirrorLink().invokeNotiAction(n2, actionArray[0].getActionId());
                }
                if (!actionArray[0].isLaunchApp()) break;
                this.launchAppAndEnterContext(this.lastNotification.getAppId());
                break;
            }
            case 2: {
                if (this.getTarget().isDSIAvailable()) {
                    this.getTarget().getDSIMirrorLink().invokeNotiAction(n2, actionArray[1].getActionId());
                }
                if (!actionArray[1].isLaunchApp()) break;
                this.launchAppAndEnterContext(this.lastNotification.getAppId());
                break;
            }
        }
        this.lastNotification = null;
        if (this.pendingNotification != null) {
            this.showNotificationPopup(this.pendingNotification);
            this.pendingNotification = null;
        }
    }

    private void launchAppAndEnterContext(int n) {
        if (this.getTarget().isDSIAvailable()) {
            this.setRequestedAppID(n);
            this.getTarget().getDSIMirrorLink().requestLaunchApp(n);
            this.getTarget().sendSafe(ServiceManager.mGenericEventFactory.newEvent(1158962432));
        }
    }

    public void handleAslApiToggleAllowAppPopup() {
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append("MirrorLinkController").append(".handleAslApiToggleAllowAppPopup()").log();
        }
        this.getPersistence().toogleAppPopupEnabled();
        this.setupNotificationService();
    }

    void setupNotificationService() {
        if (this.getTarget().isDSIAvailable()) {
            this.getTarget().getDSIMirrorLink().requestNotificationServiceEnabled(this.getPersistence().getAppPopupEnabled(), 2, 15, 20, 30);
        }
    }

    public void handleEvMirrorLinkRemoveOpenApp() {
        this.getHMIModel().removeOpenAppsOnTimer();
    }

    public void handleEvMirrorLinkMflPrevRepeat() {
        if (this.getTarget().isDSIAvailable()) {
            this.getTarget().getDSIMirrorLink().requestSoftKeyEvent(0x4040030, 0);
        }
    }

    public void handleEvMirrorLinkMflNextRepeat() {
        if (this.getTarget().isDSIAvailable()) {
            this.getTarget().getDSIMirrorLink().requestSoftKeyEvent(0x3040030, 0);
        }
    }

    public void handleEvMirrorLinkDeveloperMode() {
        this.getHMIModel().setDeveloperMode();
    }

    static /* synthetic */ MirrorLinkTarget access$000(MirrorLinkController mirrorLinkController) {
        return mirrorLinkController.getTarget();
    }

    static /* synthetic */ ASLListDataUpdateListener access$100(MirrorLinkController mirrorLinkController) {
        return mirrorLinkController.appListListener;
    }

    static /* synthetic */ MirrorLinkHmiGetter access$200(MirrorLinkController mirrorLinkController) {
        return mirrorLinkController.getHMIModel();
    }

    static /* synthetic */ ASLListDataUpdateListener access$102(MirrorLinkController mirrorLinkController, ASLListDataUpdateListener aSLListDataUpdateListener) {
        mirrorLinkController.appListListener = aSLListDataUpdateListener;
        return mirrorLinkController.appListListener;
    }

    static /* synthetic */ int access$300(MirrorLinkController mirrorLinkController) {
        return mirrorLinkController.selectAppIndexPending;
    }
}

