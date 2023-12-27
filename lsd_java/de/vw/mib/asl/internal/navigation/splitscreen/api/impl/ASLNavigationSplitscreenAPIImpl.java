/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.splitscreen.api.impl;

import de.vw.mib.asl.api.navigation.ASLNavigationEventFactory;
import de.vw.mib.asl.api.navigation.NavigationConfiguration;
import de.vw.mib.asl.api.navigation.NavigationDefinitions;
import de.vw.mib.asl.api.navigation.guidance.ASLNavigationGuidanceFactory;
import de.vw.mib.asl.api.navigation.splitscreen.ASLNavigationSplitscreenAPI;
import de.vw.mib.asl.api.navigation.startup.ASLNavigationContainer;
import de.vw.mib.asl.api.navigation.startup.ASLNavigationStartupFactory;
import de.vw.mib.asl.api.navigation.startup.NaviResettableAslHsmTargetDelegator;
import de.vw.mib.asl.api.navigation.startup.NaviResettableAslTargetDelegator;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.splitscreen.SplitScreenTargetHSM;
import de.vw.mib.asl.internal.navigation.splitscreen.Target10Plus0Box;
import de.vw.mib.asl.internal.navigation.splitscreen.Target3Plus1Box;
import de.vw.mib.asl.internal.navigation.splitscreen.TargetMotorwayInfo;
import de.vw.mib.asl.internal.navigation.splitscreen.overlays.OverlaysTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.log4mib.LogMessage;
import org.dsi.ifc.navigation.PosPosition;

public class ASLNavigationSplitscreenAPIImpl
implements ASLNavigationSplitscreenAPI,
ASLNavigationContainer {
    private IExtLogger LOGGER = null;

    public ASLNavigationSplitscreenAPIImpl() {
        ASLNavigationStartupFactory.getNavigationStartupApi().registerContainer(this);
    }

    @Override
    public void createTargets() {
        LogMessage logMessage;
        GenericEvents genericEvents = ServiceManager.eventMain;
        String string = "hsmtask";
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(162)) {
            ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(4, new NaviResettableAslTargetDelegator(new Target10Plus0Box(genericEvents, -1706355712, string), string));
        } else if (NavigationConfiguration.THREEPLUS1BOX_FEATURE_AVAILABLE) {
            ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(4, new NaviResettableAslTargetDelegator(new Target3Plus1Box(genericEvents, -2025122816, string), string));
        } else if (NavigationDefinitions.NAVI_LOGGER.isTraceEnabled(16384)) {
            logMessage = NavigationDefinitions.NAVI_LOGGER.trace(16384);
            logMessage.append("NAVI-STARTUP: ASL_NAVI_3PLUS1BOX target not started, because feature flag is disabled.");
            logMessage.log();
        }
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(58)) {
            ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(4, new NaviResettableAslTargetDelegator(new TargetMotorwayInfo(genericEvents, -1068821504, string), string));
        }
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(58)) {
            ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(3, new NaviResettableAslHsmTargetDelegator(new OverlaysTargetHSM(genericEvents, -1085598720, string), string));
        } else if (NavigationDefinitions.NAVI_LOGGER.isTraceEnabled(16384)) {
            logMessage = NavigationDefinitions.NAVI_LOGGER.trace(16384);
            logMessage.append("NAVI-STARTUP: ASL_NAVI_OVERLAYS_HSM target not started, because feature flag is disabled.");
            logMessage.log();
        }
        ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(3, new NaviResettableAslHsmTargetDelegator(new SplitScreenTargetHSM(genericEvents, 1900745728, string), string));
    }

    @Override
    public void sendEvSplitScreenManeuverviewActive(boolean bl) {
        this.getLOGGER().trace("sendEvSplitScreenManeuverviewActive()");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(828650752);
        eventGeneric.setBoolean(0, bl);
        ASLNavigationEventFactory.sendEventToService(eventGeneric);
    }

    private IExtLogger getLOGGER() {
        if (this.LOGGER == null) {
            this.LOGGER = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(16384, "[ASLNavigationSplitscreenAPIImpl]");
        }
        return this.LOGGER;
    }

    @Override
    public PosPosition getCurrentPosition() {
        return ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().getSoPosPosition();
    }

    @Override
    public void setSplitScreenContent(int n) {
        this.getLOGGER().trace("set splitscreen content from external interface");
        int n2 = ASLNavigationGuidanceFactory.getNavigationGuidanceApi().getGuidanceState();
        if (n2 == 1) {
            EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(956432448);
            eventGeneric.setInt(0, n);
            ASLNavigationEventFactory.sendEventToTarget(1900745728, 1900745728, eventGeneric);
            this.getLOGGER().trace("set splitscreen content guidance from external interface");
        } else if (n2 == 0) {
            EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(973209664);
            eventGeneric.setInt(0, n);
            ASLNavigationEventFactory.sendEventToTarget(1900745728, 1900745728, eventGeneric);
            this.getLOGGER().trace("set splitscreen content no guidance from external interface");
        }
    }
}

