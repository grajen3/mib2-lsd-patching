/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.locationinput.api.impl;

import de.vw.mib.asl.api.navigation.NavigationConfiguration;
import de.vw.mib.asl.api.navigation.NavigationDefinitions;
import de.vw.mib.asl.api.navigation.locationinput.ASLNavigationLocationinputAPI;
import de.vw.mib.asl.api.navigation.locationinput.ILocationinputResultListener;
import de.vw.mib.asl.api.navigation.locationinput.IStartupState;
import de.vw.mib.asl.api.navigation.locationinput.SpellerHandler;
import de.vw.mib.asl.api.navigation.memory.SetHomeAddressToCcpCallback;
import de.vw.mib.asl.api.navigation.spellerx.XSpellerHandlerMap;
import de.vw.mib.asl.api.navigation.startup.ASLNavigationContainer;
import de.vw.mib.asl.api.navigation.startup.ASLNavigationStartupFactory;
import de.vw.mib.asl.api.navigation.startup.NaviTargetDelegator;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.asl.IEvents;
import de.vw.mib.asl.internal.navigation.speller.handler.DemoInputHandler;
import de.vw.mib.asl.internal.navigation.speller.handler.HomeInputHandler;
import de.vw.mib.asl.internal.navigation.speller.handler.MemoryInputHandler;
import de.vw.mib.asl.internal.navigation.spellerx.SpellerContext;
import de.vw.mib.asl.internal.navigation.spellerx.XSpellerTarget;
import de.vw.mib.asl.internal.navigation.spellerx.XSpellerTargetDecorator;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.log4mib.LogMessage;
import org.dsi.ifc.global.NavLocation;

public class ASLNavigationLocationinputAPIImpl
implements ASLNavigationLocationinputAPI,
ASLNavigationContainer {
    private IStartupState startupState;

    public ASLNavigationLocationinputAPIImpl() {
        ASLNavigationStartupFactory.getNavigationStartupApi().registerContainer(this);
    }

    @Override
    public void createTargets() {
        GenericEvents genericEvents = ServiceManager.eventMain;
        String string = "hsmtask";
        ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(4, new NaviTargetDelegator(new MemoryInputHandler(genericEvents, 1615533056, string), string));
        ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(4, new NaviTargetDelegator(new HomeInputHandler(genericEvents, 2018186240, string), string));
        ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(4, new NaviTargetDelegator(new DemoInputHandler(genericEvents, 1514869760, string), string));
        if (NavigationConfiguration.LOCATIONINPUT_FEATURE_AVAILABLE) {
            if (NavigationDefinitions.NAVI_LOGGER.isTraceEnabled(16384)) {
                LogMessage logMessage = NavigationDefinitions.NAVI_LOGGER.trace(16384);
                logMessage.append("NAVI-STARTUP: StartupGroupManager: Starting SPELLERX and TARGET_DECORATOR.");
                logMessage.log();
            }
            ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(4, new XSpellerTargetDecorator(genericEvents, -1958013952, string));
        } else if (NavigationDefinitions.NAVI_LOGGER.isTraceEnabled(16384)) {
            LogMessage logMessage = NavigationDefinitions.NAVI_LOGGER.trace(16384);
            logMessage.append("NAVI-STARTUP: ASL_NAVI_SPELLERX target not started, because feature flag is disabled.");
            logMessage.log();
        }
    }

    @Override
    public void addSpellerHandler(int n, int n2, SpellerHandler spellerHandler) {
        XSpellerHandlerMap.addHandler(n, n2, spellerHandler);
    }

    @Override
    public void startSpeller(SpellerHandler spellerHandler) {
        XSpellerTarget.startSpeller(spellerHandler);
    }

    @Override
    public void saveSpeller(SpellerHandler spellerHandler) {
        XSpellerHandlerMap.saveSpeller(spellerHandler);
    }

    @Override
    public void startInput(int n) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setInt(0, n);
        eventGeneric.setReceiverEventId(1096299776);
        eventGeneric.setReceiverTargetId(-1958013952);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }

    @Override
    public void setInput(int n, String string) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setInt(0, n);
        eventGeneric.setString(1, string);
        eventGeneric.setReceiverEventId(1113076992);
        eventGeneric.setReceiverTargetId(-1958013952);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }

    @Override
    public void selectEntryViaIndex(int n, int n2) {
        if (n2 == -1) {
            this.selectNothing(n);
        } else {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
            eventGeneric.setInt(0, n);
            eventGeneric.setInt(1, n2);
            eventGeneric.setReceiverEventId(1213740288);
            eventGeneric.setReceiverTargetId(-1958013952);
            ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
        }
    }

    @Override
    public void selectEntryViaId(int n, String string) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setInt(0, n);
        eventGeneric.setString(1, string);
        eventGeneric.setReceiverEventId(1146631424);
        eventGeneric.setReceiverTargetId(-1958013952);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }

    @Override
    public void selectNothing(int n) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setInt(0, n);
        eventGeneric.setReceiverEventId(1163408640);
        eventGeneric.setReceiverTargetId(-1958013952);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }

    @Override
    public void cancelInput(int n) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setInt(0, n);
        eventGeneric.setReceiverEventId(1180185856);
        eventGeneric.setReceiverTargetId(-1958013952);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }

    @Override
    public void setCurrentLocation(NavLocation navLocation) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setObject(0, navLocation);
        eventGeneric.setReceiverEventId(1196963072);
        eventGeneric.setReceiverTargetId(-1958013952);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }

    @Override
    public void registerListener(ILocationinputResultListener iLocationinputResultListener) {
        XSpellerTarget.registerListener(iLocationinputResultListener);
    }

    @Override
    public void unregisterListener(ILocationinputResultListener iLocationinputResultListener) {
        XSpellerTarget.unregisterListener(iLocationinputResultListener);
    }

    @Override
    public boolean isInputActive() {
        return XSpellerTarget.isExtInputActive();
    }

    @Override
    public int[] getCurrentSelectionCriteria() {
        return XSpellerTarget.getExtAvailableSelectionCriteria();
    }

    @Override
    public NavLocation getCurrentLocation() {
        return XSpellerTarget.getExtCurrentLocation();
    }

    @Override
    public void setHomeAddressToCcp(SetHomeAddressToCcpCallback setHomeAddressToCcpCallback) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setObject(0, setHomeAddressToCcpCallback);
        eventGeneric.setReceiverEventId(75956480);
        eventGeneric.setReceiverTargetId(2018186240);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }

    @Override
    public void setHomeAddressToCcp() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setReceiverEventId(92733696);
        eventGeneric.setReceiverTargetId(2018186240);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }

    @Override
    public void setHomeAddress(NavLocation navLocation) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setObject(0, navLocation);
        eventGeneric.setReceiverEventId(109510912);
        eventGeneric.setReceiverTargetId(2018186240);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }

    @Override
    public void setPointLocation(boolean bl) {
        SpellerContext.isPointLocation = bl;
    }

    @Override
    public void setSpellerContextLocation(NavLocation navLocation) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setObject(0, navLocation);
        eventGeneric.setReceiverEventId(IEvents.EV_SET_CONTEXT_LOCATION);
        eventGeneric.setReceiverTargetId(-1958013952);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }

    @Override
    public void requestStartupState(ILocationinputResultListener iLocationinputResultListener) {
        if (this.startupState != null) {
            iLocationinputResultListener.updateState(this.startupState.getNavLocation(), this.startupState.getAvailableSelectionCriteria(), this.startupState.isInputActive(), this.startupState.isFullPostalCode(), this.startupState.hasPointLocations());
        }
    }

    @Override
    public void setStartupState(IStartupState iStartupState) {
        this.startupState = iStartupState;
    }
}

