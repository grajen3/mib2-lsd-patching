/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.setup;

import de.vw.mib.asl.api.navigation.poi.ASLNavigationPoiFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.AbstractResettableAslTarget;
import de.vw.mib.asl.internal.navigation.gateway.INavGateway;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.log4mib.LogMessage;
import java.util.HashMap;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navigation.DSINavigation;

public class TargetHandleLsc
extends AbstractResettableAslTarget
implements DSIServiceStateListener {
    private EventGeneric blockedPrepareOnEvent = null;
    private String languageToChangeToOnStartup = "";
    private boolean naviSwitchedOffFromBullhorn = false;
    private static final int[] OBSERVERS = new int[]{1134297088};
    private static final int[] ATTRIBUTES_NAVIGATION = new int[]{56, 6};
    private DSINavigation navigationService;
    protected DSIListener navigationListener;
    private boolean isManualLanguageChangeActive = false;
    private int transactionId;
    private String newLanguage;
    private boolean registeringForDsiUpdatesOngoing = false;
    private boolean isServiceStateListenerAdded = false;
    private String updatedLanguage = "";
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigationListener;

    public TargetHandleLsc(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
    }

    @Override
    public int getSubClassifier() {
        return 16384;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 8: {
                this.trace("Target Navigation.TargetHandleLsc entered NOTIFY_TARGET_REGISTERED.");
                break;
            }
            case 101003: {
                this.trace("Target Navigation.TargetHandleLsc entered NAVI_TARGET_PREPARE_ON.");
                if (this.isServiceStateListenerAdded) break;
                this.isServiceStateListenerAdded = true;
                ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = TargetHandleLsc.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation, this);
                break;
            }
            case 101001: {
                this.trace("Target Navigation.TargetHandleLsc entered NAVI_TARGET_GO_ON.");
                this.addObservers(OBSERVERS);
                break;
            }
            case 40003: {
                if (this.isTraceEnabled()) {
                    this.info("Target Handle-LSC entered LSCTNG_CHANGE_LANGUAGE.");
                }
                this.transactionId = eventGeneric.getInt(0);
                this.newLanguage = eventGeneric.getString(1);
                this.handleLscRequest(this.newLanguage);
                break;
            }
            default: {
                if (!this.isTraceEnabled()) break;
                this.info(new StringBuffer().append("Target Handle-LSC entered DEFAULT event with ID: ").append(eventGeneric.getReceiverEventId()).toString());
            }
        }
    }

    @Override
    public void registered(String string, int n) {
        if (string.intern() == (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = TargetHandleLsc.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName().intern() && !this.isFirstStartupDone) {
            this.isFirstStartupDone = true;
            if (this.isTraceEnabled()) {
                this.trace().append("TargetHandleLsc tries to register to ").append(string).append("...").log();
            }
            this.registeringForDsiUpdatesOngoing = true;
            this.initDsiNavigation();
            if (this.isTraceEnabled()) {
                this.trace().append("TargetHandleLsc registered to ").append(string).log();
            }
        }
    }

    private void initDsiNavigation() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.navigationService = (DSINavigation)dSIProxy.getService(this, class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = TargetHandleLsc.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation);
        this.navigationListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = TargetHandleLsc.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener);
        this.navigationService.setNotification(ATTRIBUTES_NAVIGATION, this.navigationListener);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = TargetHandleLsc.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, this.navigationListener);
        this.registerService(1239495424);
    }

    @Override
    public void unregistered(String string, int n) {
        if (string.intern() == (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = TargetHandleLsc.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName().intern()) {
            if (this.isTraceEnabled()) {
                this.trace().append("TargetHandleLsc tries to unregister from ").append(string).append("...").log();
            }
            try {
                DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
                if (dSIProxy == null) {
                    this.trace().append("DSIProxy was null!");
                    return;
                }
                this.unregisterDSINavigation(string, dSIProxy);
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleDsiError(exception);
            }
        }
    }

    private void unregisterDSINavigation(String string, DSIProxy dSIProxy) {
        this.unregisterService(1239495424);
        this.registeringForDsiUpdatesOngoing = false;
        if (this.navigationListener != null) {
            dSIProxy.removeResponseListener(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = TargetHandleLsc.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, this.navigationListener);
            this.navigationListener = null;
            this.traceUnregisterDone(string);
        }
    }

    private void traceUnregisterDone(String string) {
        if (this.isTraceEnabled()) {
            this.trace().append("TargetHandleLsc unregistered from ").append(string).log();
        }
    }

    public void dsiNavigationUpdateLanguage(String string, int n) {
        this.info(new StringBuffer().append("Target Handle-LSC entered DSINAVIGATION_UPDATELANGUAGE - ").append(string).toString());
        if (n == 1) {
            this.updatedLanguage = string;
            ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setTopPoisHaveBeenLoadedSuccessfully(false);
        }
    }

    public void dsiNavigationUpdateEtcLanguageLoadStatus(int n, int n2) {
        this.info(new StringBuffer().append("Target Handle-LSC entered DSINAVIGATION_UPDATEETCLANGUAGELOADSTATUS - ").append(n).toString());
        if (n2 == 1) {
            switch (n) {
                case 3: {
                    this.error("It is not allowed, that a navi language change fails. Compare DSI OPL point #198");
                    break;
                }
                case 2: {
                    if (this.registeringForDsiUpdatesOngoing) {
                        this.trace("First SUCCESS update after registering. Initial southside language change is done.");
                        this.registeringForDsiUpdatesOngoing = false;
                        this.setLanguageForFirstTime();
                        break;
                    }
                    this.languageChangeFinished(this.languageToChangeToOnStartup);
                    break;
                }
            }
        }
    }

    private void handleLscRequest(String string) {
        String string2 = ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().getLanguage();
        if (this.isTraceEnabled()) {
            LogMessage logMessage = this.trace();
            logMessage.append("Trying to change language from ").append(string2).append(" to ").append(string);
            logMessage.log();
        }
        if (this.naviSwitchedOffFromBullhorn && !string.equals("")) {
            this.error("navi was switched off from bullhorn switching it on again");
            ServiceManager.aslPropertyManager.valueChangedInteger(1676, 1);
            this.naviSwitchedOffFromBullhorn = false;
        }
        if (string.equals("")) {
            this.error("Bullhorn signals LSC error. Switching navi northside off.");
            ServiceManager.aslPropertyManager.valueChangedInteger(1676, 2);
            this.naviSwitchedOffFromBullhorn = true;
            return;
        }
        if (string2.equals("")) {
            this.error("Bullhorn wants to set the language, but Navi-Southside has not updated the language yet.");
        }
        if (string.equals(string2)) {
            if (this.isTraceEnabled()) {
                this.info("Bullhorn wants to set the language to the same language, which is currently set. Doing nothing");
            }
            this.finishManualLanguageChange(true);
            return;
        }
        if (this.isManualLanguageChangeActive) {
            this.error().append("LSCTNG wants to set the language while a language change to ").append(string2).append(" is active. Doing nothing.").log();
            return;
        }
        this.isManualLanguageChangeActive = true;
        if (!this.setNaviLanguage(string)) {
            this.finishManualLanguageChange(false);
        }
    }

    private boolean setNaviLanguage(String string) {
        INavGateway iNavGateway = ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway();
        String string2 = ServiceManager.configManagerDiag.getDefaultLanguage();
        boolean bl = false;
        if (iNavGateway.isAvailableLanguagesValid()) {
            String[] stringArray = iNavGateway.getAvailableLanguages();
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                if (string.equals(stringArray[i2])) {
                    this.navigationService.setLanguage(string);
                    return true;
                }
                if (!string2.equals(stringArray[i2])) continue;
                bl = true;
            }
            this.trace().append("The language is not available: ").append(string).append(" defaultFound: ").append(bl).append(" defaultLanguage: ").append(string2).log();
            if (bl) {
                this.navigationService.setLanguage(string2);
                return true;
            }
        } else {
            this.error("Navi TargetHandleLsc: Language change occured, but DSINavigationListener#updateAvailableLanguages was not yet updated.");
        }
        return false;
    }

    private void finishManualLanguageChange(boolean bl) {
        if (this.isTraceEnabled()) {
            this.trace("Language Changed: Finishing manual language change. Success: ", new Boolean(bl).toString());
        }
        this.isManualLanguageChangeActive = false;
        EventGeneric eventGeneric = ServiceManager.eventMain.getEventFactory().newEvent(this.getTargetId(), 5150, 1151074304);
        eventGeneric.setInt(0, this.transactionId);
        eventGeneric.setBoolean(1, bl);
        eventGeneric.setString(2, this.newLanguage);
        this.send(eventGeneric);
        ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().resetNavigationModel();
        this.trace("Language Changed: Dispose of any calculated but unselected routes (3 route) or routes currently being calculated.");
        if (!ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().isRgActive()) {
            this.trace("Language Changed: RG not yet active -- STOP.");
            EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent(0x24020040);
            eventGeneric2.setSenderEventId(1917522944);
            this.send(eventGeneric2);
        } else {
            this.trace("Language Changed: RG ACTIVE -- NO STOP.");
        }
    }

    private void languageChangeFinished(String string) {
        if (this.blockedPrepareOnEvent != null && string.equals(this.languageToChangeToOnStartup)) {
            this.trace("The first language change is finished. Language is: ", string);
            this.sendBack(this.blockedPrepareOnEvent);
            this.blockedPrepareOnEvent = null;
        }
        if (this.isManualLanguageChangeActive) {
            this.trace("dsiNavigationUpdateLanguage came, while a manual language change was active.");
            this.notifyPoiTarget();
            this.notifyNavOnlineServiceTargets();
            this.finishManualLanguageChange(true);
        } else {
            this.trace("dsiNavigationUpdateLanguage came, but no manual language change was active.");
        }
    }

    private void notifyNavOnlineServiceTargets() {
        this.triggerObserver(1239495424, null);
    }

    private void setLanguageForFirstTime() {
        this.languageToChangeToOnStartup = ServiceManager.configManagerDiag.getCurrentGuiLanguage();
        this.info(new StringBuffer().append("Setting Navi Language for the first time: ").append(this.languageToChangeToOnStartup).append(" ").append(this.updatedLanguage).toString());
        if (this.languageToChangeToOnStartup.equals(this.updatedLanguage)) {
            try {
                this.languageChangeFinished(this.languageToChangeToOnStartup);
            }
            catch (GenericEventException genericEventException) {
                ServiceManager.errorHandler.handleError(genericEventException);
            }
        } else {
            this.navigationService.setLanguage(this.languageToChangeToOnStartup);
        }
    }

    private void notifyPoiTarget() {
        this.trace("STARTPOISPELLER because of language change");
        ASLNavigationPoiFactory.getNavigationPoiApi().reloadTopPois(this.getTargetId());
    }

    @Override
    public void reset(HashMap hashMap) {
        boolean bl = this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = TargetHandleLsc.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName(), 0);
        if (bl) {
            if (this.isTraceEnabled()) {
                this.trace("TargetHandleLsc: resetting values after DSI restart");
            }
            this.initLocalVariables();
            this.initDsiNavigation();
            this.reinitDsiNavigationSettings();
        } else if (this.isTraceEnabled()) {
            this.trace("TargetHandleLsc: no reset necessary because restarted DSI(s) is/are not used in target");
        }
    }

    private void reinitDsiNavigationSettings() {
        String string = ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().getLanguage();
        this.setNaviLanguage(string);
    }

    private void initLocalVariables() {
        this.updatedLanguage = "";
        this.isManualLanguageChangeActive = false;
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

