/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.vicsetc;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.navigation.guidance.NavigationGuidanceService;
import de.vw.mib.asl.api.navigation.map.INavigationPosInfo;
import de.vw.mib.asl.api.navigation.map.NavigationMapService;
import de.vw.mib.asl.api.navigation.traffic.NavigationTrafficService;
import de.vw.mib.asl.api.online.ASLOnlineFactory;
import de.vw.mib.asl.api.online.ASLOnlineServiceIdentifier;
import de.vw.mib.asl.api.speechengine.PromptEngine;
import de.vw.mib.asl.api.vicsetc.ASLVICSETCFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.util.StringUtil;
import de.vw.mib.asl.internal.vicsetc.NavigationGuidanceHandler;
import de.vw.mib.asl.internal.vicsetc.NavigationMapHandler;
import de.vw.mib.asl.internal.vicsetc.NavigationTrafficHandler;
import de.vw.mib.asl.internal.vicsetc.VicsDsrcHandler;
import de.vw.mib.asl.internal.vicsetc.VicsEmergencyHandler;
import de.vw.mib.asl.internal.vicsetc.VicsFmGraphicHandler;
import de.vw.mib.asl.internal.vicsetc.VicsFmTextHandler;
import de.vw.mib.asl.internal.vicsetc.VicsPopupHandler;
import de.vw.mib.asl.internal.vicsetc.VicsSetupHandler;
import de.vw.mib.asl.internal.vicsetc.VicsStateDsrc;
import de.vw.mib.asl.internal.vicsetc.VicsStateDsrcDetails;
import de.vw.mib.asl.internal.vicsetc.VicsStateEmergency;
import de.vw.mib.asl.internal.vicsetc.VicsStateEmergencyDetails;
import de.vw.mib.asl.internal.vicsetc.VicsStateFmGraphic;
import de.vw.mib.asl.internal.vicsetc.VicsStateFmGraphicDetails;
import de.vw.mib.asl.internal.vicsetc.VicsStateFmText;
import de.vw.mib.asl.internal.vicsetc.VicsStateMain;
import de.vw.mib.asl.internal.vicsetc.VicsStateSetup;
import de.vw.mib.asl.internal.vicsetc.VicsStateShortcut;
import de.vw.mib.asl.internal.vicsetc.VicsStateVenm;
import de.vw.mib.asl.internal.vicsetc.VicsTarget$1;
import de.vw.mib.asl.internal.vicsetc.VicsTarget$2;
import de.vw.mib.asl.internal.vicsetc.VicsTarget$3;
import de.vw.mib.asl.internal.vicsetc.VicsTrafficLists;
import de.vw.mib.asl.internal.vicsetc.VicsVenmHandler;
import de.vw.mib.asl.internal.vicsetc.api.impl.ASLVICSETCAPIImpl;
import de.vw.mib.asl.internal.vicsetc.datapool.ASLVicsEtcDatapool;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import generated.de.vw.mib.asl.internal.ListManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.Stack;
import org.dsi.ifc.asiatrafficinfomenu.DSIAsiaTrafficInfoMenu;
import org.dsi.ifc.asiatrafficinfomenu.ResourceInformation;
import org.dsi.ifc.asiatrafficinfomenu.TrafficInformation;
import org.dsi.ifc.asiatrafficinfomenu.TrafficMessage;
import org.dsi.ifc.base.DSIListener;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class VicsTarget
extends AbstractASLHsmTarget
implements DSIServiceStateListener {
    protected static final long GMT_PLUS_9_H_MILLIS;
    private DSIAsiaTrafficInfoMenu dsiAsiaTrafficInfoMenu;
    protected DSIListener dsiAsiaTrafficInfoMenuListener;
    protected NavigationMapService navMapService;
    protected NavigationTrafficService navTrafficService;
    protected NavigationGuidanceService navGuidanceService;
    protected TrafficInformation[] currentInfos = new TrafficInformation[0];
    protected VicsTrafficLists vicsTrafficLists = new VicsTrafficLists();
    protected TrafficMessage shortcutMessage;
    protected TrafficMessage selectedMessage;
    protected final Stack interruptStack = new Stack();
    protected final Stack venmMessageStack = new Stack();
    protected final VicsFmTextHandler fmTextHandler;
    protected final VicsFmGraphicHandler fmGraphicHandler;
    protected final VicsDsrcHandler dsrcHandler;
    protected final VicsEmergencyHandler emergencyHandler;
    protected final VicsSetupHandler setupHandler;
    protected final VicsPopupHandler popupHandler;
    protected final VicsVenmHandler venmHandler;
    protected final NavigationTrafficHandler navigationTrafficHandler;
    protected final NavigationMapHandler navigationMapHandler;
    protected final NavigationGuidanceHandler navigationGuidanceHandler;
    protected final VicsStateMain stateMain;
    protected final VicsStateSetup stateSetup;
    protected final VicsStateFmText stateFmText;
    protected final VicsStateFmGraphic stateFmGraphic;
    protected final VicsStateFmGraphicDetails stateFmGraphicDetails;
    protected final VicsStateDsrc stateDsrc;
    protected final VicsStateDsrcDetails stateDsrcDetails;
    protected final VicsStateEmergency stateEmergency;
    protected final VicsStateEmergencyDetails stateEmergencyDetails;
    protected final VicsStateShortcut stateShortcut;
    protected final VicsStateVenm stateVenm;
    protected final ASLVicsEtcDatapool vicsEtcDP;
    private boolean isInitDone = false;
    protected PromptEngine promptEngine;
    protected boolean popupWasShown = false;
    protected int transactionId = -1;
    protected String newLanguage = "";
    private static final int[] OBSERVER;
    static /* synthetic */ Class class$de$vw$mib$asl$api$speechengine$PromptEngine;
    static /* synthetic */ Class class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenu;
    static /* synthetic */ Class class$org$dsi$ifc$tmc$DSITmcOnRoute;
    static /* synthetic */ Class class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenuListener;

    public VicsTarget(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.traceMsg("start initializing target", this);
        this.vicsEtcDP = this.getVicsEtcDatapool();
        this.setupHandler = new VicsSetupHandler(this, ListManager.getGenericASLList(815420672));
        this.fmTextHandler = new VicsFmTextHandler(this, ListManager.getGenericASLList(328881408), ListManager.getGenericASLList(345658624));
        this.fmGraphicHandler = new VicsFmGraphicHandler(this, ListManager.getGenericASLList(1989825792));
        this.dsrcHandler = new VicsDsrcHandler(this, ListManager.getGenericASLList(2006603008));
        this.emergencyHandler = new VicsEmergencyHandler(this, ListManager.getGenericASLList(1973048576));
        this.popupHandler = new VicsPopupHandler(this);
        this.venmHandler = new VicsVenmHandler(this, ListManager.getGenericASLList(1419400448));
        this.navigationTrafficHandler = new NavigationTrafficHandler(this);
        this.navigationMapHandler = new NavigationMapHandler(this);
        this.navigationGuidanceHandler = new NavigationGuidanceHandler(this);
        ((ASLVICSETCAPIImpl)ASLVICSETCFactory.getVICSETCApi()).setVicsTarget(this);
        this.stateMain = new VicsStateMain(this, this.hsm, "stateMain", this.getWorkStateParent());
        this.stateSetup = new VicsStateSetup(this, this.hsm, "stateSetup", this.stateMain);
        this.stateFmText = new VicsStateFmText(this, this.hsm, "stateFmText", this.stateMain);
        this.stateFmGraphic = new VicsStateFmGraphic(this, this.hsm, "stateFmGraphic", this.stateMain);
        this.stateFmGraphicDetails = new VicsStateFmGraphicDetails(this, this.hsm, "stateFmGraphicDetails", this.stateFmGraphic);
        this.stateDsrc = new VicsStateDsrc(this, this.hsm, "stateDsrc", this.stateMain);
        this.stateDsrcDetails = new VicsStateDsrcDetails(this, this.hsm, "stateDsrcDetails", this.stateDsrc);
        this.stateEmergency = new VicsStateEmergency(this, this.hsm, "stateEmergency", this.stateMain);
        this.stateEmergencyDetails = new VicsStateEmergencyDetails(this, this.hsm, "stateEmergencyDetails", this.stateEmergency);
        this.stateShortcut = new VicsStateShortcut(this, this.hsm, "stateShortcut", this.stateMain);
        this.stateVenm = new VicsStateVenm(this, this.hsm, "stateVenm", this.stateMain);
        this.traceMsg("target initiliazed", this);
    }

    protected ASLVicsEtcDatapool getVicsEtcDatapool() {
        ASLVicsEtcDatapool aSLVicsEtcDatapool = null;
        try {
            aSLVicsEtcDatapool = ASLVicsEtcDatapool.getInstance();
        }
        catch (Exception exception) {
            this.error(new StringBuffer().append("An error occurred during initialization: ").append(exception.getMessage()).append("\nSetting VicsEtcDataPool to null").toString());
        }
        return aSLVicsEtcDatapool;
    }

    protected void initSpeechEngine() {
        this.traceMsg("try register speech engine.", this);
        BundleContext bundleContext = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getBundleContext();
        ServiceTracker serviceTracker = new ServiceTracker(bundleContext, (class$de$vw$mib$asl$api$speechengine$PromptEngine == null ? (class$de$vw$mib$asl$api$speechengine$PromptEngine = VicsTarget.class$("de.vw.mib.asl.api.speechengine.PromptEngine")) : class$de$vw$mib$asl$api$speechengine$PromptEngine).getName(), (ServiceTrackerCustomizer)new VicsTarget$1(this, bundleContext));
        serviceTracker.open();
        this.traceMsg("speech engine successfull registered.", this);
    }

    protected void traceMsg(String string, Object object) {
        if (this.isTraceEnabled()) {
            this.trace().append(object == null ? "VICS" : new StringBuffer().append(object.getClass().getName()).append(": ").toString()).append(string).append(" stack: ").append(this.venmMessageStack.size()).log();
        }
    }

    protected void traceResourceInformation(ResourceInformation resourceInformation) {
        if (resourceInformation != null && resourceInformation.resourceLocator != null) {
            String string = resourceInformation.resourceLocator.url;
            this.traceMsg(new StringBuffer().append("The resource path to the image is: ").append(string).toString(), this);
            if (string == null || string.length() == 0) {
                this.traceMsg("The ResourceLocator has no url.", this);
            } else {
                File file = new File(string);
                boolean bl = file.exists();
                boolean bl2 = bl ? file.canRead() : bl;
                this.traceMsg(new StringBuffer().append("The file exists: ").append(bl).append(" and is readable:").append(bl2).toString(), this);
            }
        }
    }

    protected void quitModelWaitState(int n, int n2) {
        this.traceMsg("quit model wait state.", this);
        ServiceManager.aslPropertyManager.valueChangedInteger(n, n2);
    }

    protected Object[] updateResourceInformationInList(ResourceInformation resourceInformation, Object[] objectArray) {
        Object[] objectArray2 = new Object[objectArray.length + 1];
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            objectArray2[i2] = objectArray[i2];
        }
        objectArray2[objectArray2.length - 1] = resourceInformation;
        return objectArray2;
    }

    protected boolean isMessageExpired(TrafficMessage trafficMessage, int n) {
        TrafficMessage[] trafficMessageArray = this.findMessagesForTrafficType(n);
        boolean bl = this.isMessageNotInMessageList(trafficMessage, trafficMessageArray);
        return bl;
    }

    protected boolean isVoiceMessageAvailable(ResourceInformation resourceInformation) {
        if (resourceInformation == null) {
            this.traceMsg("ResourceInformation was null.", this);
            return false;
        }
        return !StringUtil.isEmpty(resourceInformation.phoneticString);
    }

    protected boolean isMessageNotInMessageList(TrafficMessage trafficMessage, TrafficMessage[] trafficMessageArray) {
        boolean bl = true;
        if (trafficMessage == null) {
            this.traceMsg("Selected message was null.", this);
            return bl;
        }
        for (int i2 = 0; i2 < trafficMessageArray.length; ++i2) {
            TrafficMessage trafficMessage2 = trafficMessageArray[i2];
            if (trafficMessage2.getTrafficMessageID() != trafficMessage.getTrafficMessageID()) continue;
            bl = false;
        }
        this.traceMsg(new StringBuffer().append("Selected message with id: ").append(trafficMessage.trafficMessageID).append(" expired: ").append(bl).toString(), this);
        return bl;
    }

    protected boolean isSelectedMessageShortcut() {
        if (this.selectedMessage == null) {
            this.traceMsg("Selected message was null.", this);
            return false;
        }
        return this.vicsEtcDP.getShortcutMessageValue() != null && this.vicsEtcDP.getShortcutMessageValue().equals(this.selectedMessage.getValue());
    }

    protected boolean isMessageShortcut(TrafficMessage trafficMessage) {
        if (trafficMessage == null) {
            this.traceMsg("message was null.", this);
            return false;
        }
        return this.vicsEtcDP.getShortcutMessageValue() != null && this.vicsEtcDP.getShortcutMessageValue().equals(trafficMessage.getValue());
    }

    protected boolean isLanguageJP() {
        this.traceMsg(new StringBuffer().append("isLanguageJP() - language: ").append(this.newLanguage).toString(), this);
        return this.newLanguage.equals(Locale.JAPAN.toString());
    }

    protected TrafficMessage[] findMessagesForTrafficType(int n) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.currentInfos.length; ++i2) {
            TrafficInformation trafficInformation = this.currentInfos[i2];
            if (trafficInformation.getTrafficType() != n) continue;
            this.traceMsg("Messages found!", this);
            arrayList.addAll(Arrays.asList(trafficInformation.getTrafficMessages()));
        }
        TrafficMessage[] trafficMessageArray = new TrafficMessage[arrayList.size()];
        for (int i3 = 0; i3 < trafficMessageArray.length; ++i3) {
            trafficMessageArray[i3] = (TrafficMessage)arrayList.get(i3);
        }
        return trafficMessageArray;
    }

    protected boolean notfiyModelIfMessageExpired(int n, int n2) {
        if (this.selectedMessage == null) {
            this.traceMsg("Selected message was null.", this);
            VicsTarget.writeBooleanToDatapool(n, false);
            return false;
        }
        boolean bl = !this.isMessageExpired(this.selectedMessage, n2);
        this.traceMsg(new StringBuffer().append("the selected message ").append(this.selectedMessage).append(" is available: ").append(bl).toString(), this);
        VicsTarget.writeBooleanToDatapool(n, bl);
        return bl;
    }

    protected boolean notfiyModelIfShortcutMessageExpired(int n, int n2) {
        if (this.shortcutMessage == null) {
            this.traceMsg("Shortcut message was null.", this);
            return false;
        }
        boolean bl = !this.isMessageExpired(this.shortcutMessage, n2);
        this.traceMsg(new StringBuffer().append("the shortcut message ").append(this.shortcutMessage).append(" is available: ").append(bl).toString(), this);
        VicsTarget.writeBooleanToDatapool(n, bl);
        return bl;
    }

    protected void handleNoUserInteractionAndNotifyModelToReloadContext() {
        this.traceMsg("No user interaction since 30 seconds. Update the traffic messages.", this);
        this.vicsTrafficLists.updateTrafficMessages(this.currentInfos);
        HsmState hsmState = this.getHsm().getState();
        if (hsmState.equals(this.stateFmText)) {
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(597316864);
        } else if (hsmState.equals(this.stateFmGraphic) || hsmState.equals(this.stateFmGraphicDetails) || hsmState.equals(this.stateShortcut)) {
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(614094080);
        } else if (hsmState.equals(this.stateDsrc) || hsmState.equals(this.stateDsrcDetails)) {
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(630871296);
        } else if (hsmState.equals(this.stateEmergency) || hsmState.equals(this.stateEmergencyDetails)) {
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(647648512);
        }
    }

    protected void resetShortcutMessageIfExpired() {
        if (this.shortcutMessage != null && this.isMessageExpired(this.shortcutMessage, 3)) {
            this.shortcutMessage = null;
            VicsTarget.writeBooleanToDatapool(664425728, false);
        } else {
            VicsTarget.writeBooleanToDatapool(664425728, true);
        }
    }

    protected void initTarget() {
        this.traceMsg("try register observer and state listener for dsi.", this);
        if (!this.isInitDone) {
            this.isInitDone = true;
            this.initSpeechEngine();
            this.addObservers(OBSERVER);
            this.notifyLscRegisterNavi();
            ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenu == null ? (class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenu = VicsTarget.class$("org.dsi.ifc.asiatrafficinfomenu.DSIAsiaTrafficInfoMenu")) : class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenu, this);
            ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$tmc$DSITmcOnRoute == null ? (class$org$dsi$ifc$tmc$DSITmcOnRoute = VicsTarget.class$("org.dsi.ifc.tmc.DSITmcOnRoute")) : class$org$dsi$ifc$tmc$DSITmcOnRoute, this);
            if (this.dsiAsiaTrafficInfoMenu == null) {
                this.traceMsg("DSIAsiaTrafficInfoMenu not started by startup. Workaround is now starting DSIAsiaTrafficInfoMenu.", this);
                ServiceManager.dsiServiceAdmin.startService((class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenu == null ? (class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenu = VicsTarget.class$("org.dsi.ifc.asiatrafficinfomenu.DSIAsiaTrafficInfoMenu")) : class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenu).getName(), 0);
            }
            this.traceMsg("registration successfull.", this);
        }
    }

    @Override
    protected HsmState getDefaultState() {
        return this.stateMain;
    }

    @Override
    public int getSubClassifier() {
        return 16;
    }

    public void clickInMapResult(INavigationPosInfo[] iNavigationPosInfoArray) {
        this.traceMsg(new StringBuffer().append("Mapservice callback - clickInMapResult: ").append(iNavigationPosInfoArray).toString(), this);
    }

    public void handleMapServiceError(int n, int n2, int n3) {
        this.traceMsg(new StringBuffer().append("Mapservice callback - handleMapServiceError: ").append(n).append(", ").append(n2).append(", ").append(n3).toString(), this);
    }

    public void lockMapViewerResult(boolean bl) {
        this.traceMsg(new StringBuffer().append("Mapservice callback - lockMapViewerResult: ").append(bl).toString(), this);
    }

    public void updateGoToLocationMapReady() {
        this.traceMsg("Mapservice callback - updateGoToLocationMapReady", this);
    }

    public void updateMapLayerAvailable(int[] nArray) {
        this.traceMsg(new StringBuffer().append("Mapservice callback - updateMapLayerAvailable: ").append(nArray).toString(), this);
    }

    public void updateMapLayerVisible(int[] nArray) {
        this.traceMsg(new StringBuffer().append("Mapservice callback - updateMapLayerVisible: ").append(nArray).toString(), this);
    }

    public void updateMapPosition(INavigationLocation iNavigationLocation) {
        this.traceMsg(new StringBuffer().append("Mapservice callback - updateMapPosition: ").append(iNavigationLocation).toString(), this);
    }

    public void updateZoomLevel(int n, int n2) {
        this.traceMsg(new StringBuffer().append("Mapservice callback - updateZoomLevel: ").append(n).append(", ").append(n2).toString(), this);
    }

    public void updateZoomList(int[] nArray) {
        this.traceMsg(new StringBuffer().append("Mapservice callback - updateZoomList: ").append(nArray).toString(), this);
    }

    public void zoomInDone() {
        this.traceMsg("Mapservice callback - zoomInDone", this);
    }

    @Override
    public void registered(String string, int n) {
        this.traceMsg(new StringBuffer().append("Try to register to ").append(string).toString(), this);
        if (string.intern() == (class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenu == null ? (class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenu = VicsTarget.class$("org.dsi.ifc.asiatrafficinfomenu.DSIAsiaTrafficInfoMenu")) : class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenu).getName().intern()) {
            DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            this.dsiAsiaTrafficInfoMenu = (DSIAsiaTrafficInfoMenu)dSIProxy.getService(this, class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenu == null ? (class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenu = VicsTarget.class$("org.dsi.ifc.asiatrafficinfomenu.DSIAsiaTrafficInfoMenu")) : class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenu);
            this.dsiAsiaTrafficInfoMenuListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenuListener == null ? (class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenuListener = VicsTarget.class$("org.dsi.ifc.asiatrafficinfomenu.DSIAsiaTrafficInfoMenuListener")) : class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenuListener);
            dSIProxy.addResponseListener(this, class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenuListener == null ? (class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenuListener = VicsTarget.class$("org.dsi.ifc.asiatrafficinfomenu.DSIAsiaTrafficInfoMenuListener")) : class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenuListener, this.dsiAsiaTrafficInfoMenuListener);
            this.dsiAsiaTrafficInfoMenu.setNotification(this.dsiAsiaTrafficInfoMenuListener);
            this.traceMsg(new StringBuffer().append("Registered to ").append(string).toString(), this);
            this.initVicsSetup();
        }
    }

    @Override
    public void unregistered(String string, int n) {
        this.traceMsg(new StringBuffer().append("Try to unregister from ").append(string).toString(), this);
        try {
            DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            if (dSIProxy == null) {
                this.traceMsg("DSIProxy was null!", this);
                return;
            }
            if (string.intern() == (class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenu == null ? (class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenu = VicsTarget.class$("org.dsi.ifc.asiatrafficinfomenu.DSIAsiaTrafficInfoMenu")) : class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenu).getName().intern() && this.dsiAsiaTrafficInfoMenuListener != null) {
                dSIProxy.removeResponseListener(this, class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenuListener == null ? (class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenuListener = VicsTarget.class$("org.dsi.ifc.asiatrafficinfomenu.DSIAsiaTrafficInfoMenuListener")) : class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenuListener, this.dsiAsiaTrafficInfoMenuListener);
                this.dsiAsiaTrafficInfoMenuListener = null;
                this.traceMsg(new StringBuffer().append("Unregistered from ").append(string).toString(), this);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleDsiError(exception);
        }
    }

    private ASLOnlineServiceIdentifier createTrafficAslOnlineServiceIdentifier() {
        VicsTarget$2 vicsTarget$2 = new VicsTarget$2(this);
        return vicsTarget$2;
    }

    protected void doOnlineServiceRequest(EventGeneric eventGeneric) {
        ASLOnlineServiceIdentifier aSLOnlineServiceIdentifier = this.createTrafficAslOnlineServiceIdentifier();
        boolean bl = ASLOnlineFactory.getOnlineCoreServices().isServiceConfigured(aSLOnlineServiceIdentifier);
        this.traceMsg(new StringBuffer().append("doOnlineServiceRequest(appId=TRAFFICONLINE, configured= ").append(bl).toString(), this);
        if (bl) {
            ASLOnlineFactory.getOnlineCoreServices().checkOnlineServiceStatus(aSLOnlineServiceIdentifier, new VicsTarget$3(this));
        } else {
            this.handleServiceOnlineTrafficNotAvailable();
        }
    }

    private void initVicsSetup() {
        if (this.vicsEtcDP == null) {
            this.error("DataPool was null.");
            return;
        }
        this.dsiAsiaTrafficInfoMenu.setPrefectureSetting(this.vicsEtcDP.getPrefectureString(), this.vicsEtcDP.getStationSelectMode() == 0);
        if (this.isTraceEnabled()) {
            this.trace("initVicsSetup");
            this.trace(new StringBuffer().append("Prefecture string: ").append(this.vicsEtcDP.getPrefectureString()).toString());
            this.trace(new StringBuffer().append("Station selection mode: ").append(this.vicsEtcDP.getStationSelectMode()).toString());
        }
    }

    protected void handleServiceOnlineTrafficAvailable() {
        this.traceMsg("Service request was successfull switching online status to on.", this);
        VicsTarget.writeIntegerToDatapool(3, 0);
        this.vicsEtcDP.setTrafficOnline(true);
    }

    protected void handleServiceOnlineTrafficNotAvailable() {
        this.traceMsg("Service request was not successfull switching online status to off.", this);
        VicsTarget.writeIntegerToDatapool(3, 1);
        this.vicsEtcDP.setTrafficOnline(false);
    }

    protected void notifyLscRegisterNavi() {
        this.traceMsg("Notifying Bullhorn(LSC), that we are ready.", this);
        try {
            EventGeneric eventGeneric = ServiceManager.eventMain.getEventFactory().newEvent(this.getTargetId(), 5150, 1083965440);
            eventGeneric.setInt(0, 589896448);
            eventGeneric.setInt(1, 0);
            eventGeneric.setString(2, "");
            this.send(eventGeneric);
        }
        catch (GenericEventException genericEventException) {
            this.warn("Target Navigation - failed to notify LSC that navigation context is up.");
        }
    }

    protected void notifyLscDeregisterNavi() {
        this.traceMsg("notifyLscDeregisterNavi()", this);
        EventGeneric eventGeneric = ServiceManager.eventMain.getEventFactory().newEvent(this.getTargetId(), 5150, 1117519872);
        eventGeneric.setInt(0, 589896448);
        this.send(eventGeneric);
    }

    protected void finishManualLanguageChange(boolean bl) {
        this.traceMsg(new StringBuffer().append("Language Changed: Finishing manual language change. Success: ").append(new Boolean(bl).toString()).append(" to ").append(this.newLanguage).toString(), this);
        EventGeneric eventGeneric = ServiceManager.eventMain.getEventFactory().newEvent(this.getTargetId(), 5150, 1151074304);
        eventGeneric.setInt(0, this.transactionId);
        eventGeneric.setBoolean(1, bl);
        eventGeneric.setString(2, this.newLanguage);
        this.send(eventGeneric);
    }

    public HashSet requestResourceInformation(int n, Set set) {
        if (set == null) {
            return new HashSet();
        }
        HashSet hashSet = new HashSet(set);
        hashSet.add(new Integer(n));
        this.dsiAsiaTrafficInfoMenu.requestResourceInformation(n);
        return hashSet;
    }

    public void setPrefectureSetting(String string, boolean bl) {
        this.dsiAsiaTrafficInfoMenu.setPrefectureSetting(string, bl);
    }

    public void setProbeDataSetting(boolean bl) {
        this.dsiAsiaTrafficInfoMenu.setProbeDataSetting(bl);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        OBSERVER = new int[]{124998976, 477320512, 494097728, 510874944, 158553408, 1686861824, 426988864, 460543296, 443766080, 410211648, 393434432, 141776192, 1014191424, 24335680, 7558464, 930305344, 41112896, 544429376, 561206592, 527652160, 577983808, 594761024, 611538240, 947082560, 1081300288, 74667328, 326325568, 343102784, 980636992, 1114854720, 57890112, 661869888, 678647104, 745755968, 695424320, 712201536, 728978752, 963859776, 1098077504, 91444544, 762533184, 779310400, 846419264, 796087616, 812864832, 829642048, 997414208, 1131631936, 108221760, 359880000, 376657216, 1148409152, 896750912, 1064523072, 863196480, 879973696, 1030968640, 1215518016, 913528128, 1165186368, 1181963584, 92733696, 75956480, 155076864, 1134297088, 1198740800, 176619776, 193396992, 210174208, 226951424, 1670084608};
    }
}

