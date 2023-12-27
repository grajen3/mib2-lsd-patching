/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.startup;

import de.vw.mib.asl.api.navigation.ASLNavigationFactory;
import de.vw.mib.asl.api.navigation.ASLNavigationSldeFactory;
import de.vw.mib.asl.api.navigation.ASLNavigationTruffelFactory;
import de.vw.mib.asl.api.navigation.NavigationDefinitions;
import de.vw.mib.asl.api.navigation.bap.ASLNavigationBapFactory;
import de.vw.mib.asl.api.navigation.guidance.ASLNavigationGuidanceFactory;
import de.vw.mib.asl.api.navigation.locationinput.ASLNavigationLocationinputFactory;
import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.memory.ASLNavigationMemoryFactory;
import de.vw.mib.asl.api.navigation.onlineutil.ASLNavigationOnlineutilFactory;
import de.vw.mib.asl.api.navigation.poi.ASLNavigationPoiFactory;
import de.vw.mib.asl.api.navigation.splitscreen.ASLNavigationSplitscreenFactory;
import de.vw.mib.asl.api.navigation.startup.ASLNavigationStartupFactory;
import de.vw.mib.asl.api.navigation.traffic.ASLNavigationTrafficFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.startup.api.impl.ASLNavigationStartupGroups;
import de.vw.mib.asl.internal.navigation.startup.groups.NaviStartupGroup;
import de.vw.mib.asl.internal.navigation.startup.groups.StartupGroup;
import de.vw.mib.asl.internal.navigation.startup.guards.NaviGuardFramework;
import de.vw.mib.asl.internal.navigation.startup.guards.NaviGuardMap;
import de.vw.mib.asl.internal.navigation.startup.guards.NaviGuardPersistence;
import de.vw.mib.asl.internal.navigation.startup.guards.NaviGuardPoi;
import de.vw.mib.asl.internal.navigation.startup.guards.NaviGuardRemaining;
import de.vw.mib.asl.internal.navigation.startup.knowledge.KnowledgeBase;
import de.vw.mib.asl.internal.navigation.startup.knowledge.KnowledgeBaseObserver;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.Target;
import de.vw.mib.log4mib.LogMessage;

public class StartupGroupManager
implements KnowledgeBaseObserver {
    public static final int NAVI_GROUP_FRAMEWORK_INDEX;
    public static final int NAVI_GROUP_PERSISTENCE_INDEX;
    public static final int NAVI_GROUP_POI_INDEX;
    public static final int NAVI_GROUP_MAP_INDEX;
    public static final int NAVI_GROUP_REMAINING_INDEX;
    public static final int NUMBER_OF_NAVI_GROUPS;
    private StartupGroup[] groups;
    private final GenericEvents mEventContext;
    private final String taskHsm;

    public StartupGroupManager(KnowledgeBase knowledgeBase) {
        ASLNavigationStartupFactory.getNavigationStartupApi();
        ASLNavigationFactory.getNavigationApi();
        ASLNavigationUtilFactory.getNavigationUtilApi();
        ASLNavigationMapFactory.getNavigationMapApi();
        ASLNavigationMemoryFactory.getNavigationMemoryApi();
        ASLNavigationLocationinputFactory.getNavigationLocationinputApi();
        ASLNavigationTruffelFactory.getNavigationTruffelApi();
        ASLNavigationGuidanceFactory.getNavigationGuidanceApi();
        ASLNavigationBapFactory.getNavigationBapApi();
        ASLNavigationOnlineutilFactory.getNavigationOnlineutilApi();
        ASLNavigationPoiFactory.getNavigationPoiApi();
        ASLNavigationSplitscreenFactory.getNavigationSplitscreenApi();
        ASLNavigationTrafficFactory.getNavigationTrafficApi();
        ASLNavigationTruffelFactory.getNavigationTruffelApi();
        ASLNavigationSldeFactory.getNavigationSldeApi();
        knowledgeBase.registerObserver(this);
        this.mEventContext = ServiceManager.eventMain;
        this.taskHsm = "hsmtask";
        ASLNavigationStartupGroups.getInstance().createAllTargets();
        this.groups = new StartupGroup[5];
        this.groups[0] = new NaviStartupGroup(-1790241792, this.mEventContext, this.taskHsm, new NaviGuardFramework(), this.instanciateNaviGroupFrameworkTargets(), knowledgeBase, "Navi.Framework");
        this.groups[1] = new NaviStartupGroup(-1773464576, ServiceManager.eventMain, "hsmtask", new NaviGuardPersistence(), this.instanciateNaviGroupPersistenceTargets(), knowledgeBase, "Navi.Persistence");
        this.groups[2] = new NaviStartupGroup(-1723132928, ServiceManager.eventMain, "hsmtask", new NaviGuardPoi(), this.instanciateNaviGroupPoiTargets(), knowledgeBase, "Navi.Poi");
        this.groups[3] = new NaviStartupGroup(-1756687360, ServiceManager.eventMain, "hsmtask", new NaviGuardMap(), this.instanciateNaviGroupMapTargets(), knowledgeBase, "Navi.Map");
        this.groups[4] = new NaviStartupGroup(-1739910144, ServiceManager.eventMain, "hsmtask", new NaviGuardRemaining(), this.instanciateNaviGroupRemainingTargets(), knowledgeBase, "Navi.Remaining");
        knowledgeBase.setGroups(this.groups);
        for (int i2 = 0; i2 < this.groups.length; ++i2) {
            this.groups[i2].setTrafficLightState(0);
        }
        if (NavigationDefinitions.NAVI_LOGGER.isTraceEnabled(16384)) {
            LogMessage logMessage = NavigationDefinitions.NAVI_LOGGER.trace(16384);
            logMessage.append("NAVI-STARTUP: StartupGroupManager: All navi startup groups constructed and all targets instanciated.");
            logMessage.log();
        }
        knowledgeBase.notifyObserver();
        ServiceManager.aslPropertyManager.valueChangedBoolean(758, false);
        ServiceManager.aslPropertyManager.valueChangedInteger(757, 1);
        ServiceManager.aslPropertyManager.valueChangedInteger(1676, 0);
    }

    private Target[] instanciateNaviGroupPoiTargets() {
        return ASLNavigationStartupGroups.getInstance().getGroupTargets(2);
    }

    private Target[] instanciateNaviGroupFrameworkTargets() {
        return ASLNavigationStartupGroups.getInstance().getGroupTargets(0);
    }

    private Target[] instanciateNaviGroupMapTargets() {
        return ASLNavigationStartupGroups.getInstance().getGroupTargets(3);
    }

    private Target[] instanciateNaviGroupPersistenceTargets() {
        return ASLNavigationStartupGroups.getInstance().getGroupTargets(1);
    }

    private Target[] instanciateNaviGroupRemainingTargets() {
        return ASLNavigationStartupGroups.getInstance().getGroupTargets(4);
    }

    public Target[] getAllTargets() {
        int n = this.getOverallTargetCount() + 1;
        Target[] targetArray = new Target[n];
        targetArray[0] = ASLNavigationUtilFactory.getNavigationUtilApi().getTargetProfileChange();
        int n2 = 1;
        for (int i2 = 0; i2 < this.groups.length; ++i2) {
            Target[] targetArray2 = this.groups[i2].getGroupMembers();
            n2 = this.addTargetsFromIndex(targetArray, n2, targetArray2);
        }
        return targetArray;
    }

    private int addTargetsFromIndex(Target[] targetArray, int n, Target[] targetArray2) {
        for (int i2 = 0; i2 < targetArray2.length; ++i2) {
            targetArray[n] = targetArray2[i2];
            ++n;
        }
        return n;
    }

    private int getOverallTargetCount() {
        int n = 0;
        for (int i2 = 0; i2 < this.groups.length; ++i2) {
            n += this.groups[i2].getGroupMembers().length;
        }
        return n;
    }

    @Override
    public void changed(KnowledgeBase knowledgeBase) {
        block8: for (int i2 = 0; i2 < this.groups.length; ++i2) {
            StartupGroup startupGroup = this.groups[i2];
            switch (startupGroup.getTrafficLightState()) {
                case -2: {
                    if (!NavigationDefinitions.NAVI_LOGGER.isTraceEnabled(16384)) continue block8;
                    LogMessage logMessage = NavigationDefinitions.NAVI_LOGGER.trace(16384);
                    logMessage.append("NAVI-STARTUP: IN_TRANSITION doing nothing in group '");
                    logMessage.append(startupGroup.getName());
                    logMessage.append("'");
                    logMessage.log();
                    continue block8;
                }
                case -1: {
                    LogMessage logMessage = NavigationDefinitions.NAVI_LOGGER.error(16384);
                    logMessage.append("Group in STATE NOT_INSTANTIATED. This should never happen, because all groups start in INSTANCIATED state.");
                    logMessage.log();
                    continue block8;
                }
                case 0: {
                    if (!startupGroup.getGuard().checkRedToYellowGuard(knowledgeBase)) continue block8;
                    startupGroup.sendPowerOnSignal();
                    continue block8;
                }
                case 1: {
                    if (!startupGroup.getGuard().checkRedToYellowGuard(knowledgeBase)) continue block8;
                    startupGroup.sendRedToYellowSignal();
                    continue block8;
                }
                case 2: {
                    if (startupGroup.getGuard().checkYellowToGreenGuard(knowledgeBase)) {
                        startupGroup.sendYellowToGreenSignal();
                    }
                    if (!startupGroup.getGuard().checkYellowToRedGuard(knowledgeBase)) continue block8;
                    startupGroup.sendYellowToRedSignal();
                    continue block8;
                }
                case 3: {
                    if (!startupGroup.getGuard().checkGreenToYellowGuard(knowledgeBase)) continue block8;
                    startupGroup.sendGreenToYellowSignal();
                    continue block8;
                }
                default: {
                    LogMessage logMessage = NavigationDefinitions.NAVI_LOGGER.error(16384);
                    logMessage.append("NAVI-STARTUP: Invalid State: '");
                    logMessage.append(startupGroup.getTrafficLightState());
                    logMessage.append("'");
                    logMessage.log();
                    continue block8;
                }
            }
        }
    }
}

