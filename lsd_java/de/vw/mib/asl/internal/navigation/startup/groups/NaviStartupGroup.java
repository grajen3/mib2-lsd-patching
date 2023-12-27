/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.startup.groups;

import de.vw.mib.asl.api.navigation.NavigationDefinitions;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.startup.groups.StartupGroup;
import de.vw.mib.asl.internal.navigation.startup.guards.Guard;
import de.vw.mib.asl.internal.navigation.startup.knowledge.KnowledgeBase;
import de.vw.mib.collections.ints.IntOptHashSet;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.Target;
import de.vw.mib.log4mib.LogMessage;
import edu.emory.mathcs.backport.java.util.Arrays;

public final class NaviStartupGroup
extends AbstractASLTarget
implements StartupGroup {
    public static final int TIMEOUT_IN_MILISECONDS;
    public static final String LOG_PREFIX;
    private final Guard guard;
    protected final KnowledgeBase knowledgeBase;
    private final String name;
    private final Target[] naviTargets;
    private int trafficLightState = -1;
    private int[] transitionResponseCollector;
    private int transitionResponseCounter = 0;
    private int transitionOldState = -1;
    private int transitionNewState = -1;
    protected final String taskHsm;
    IntOptHashSet responseIds = new IntOptHashSet();

    public NaviStartupGroup(int n, GenericEvents genericEvents, String string, Guard guard, Target[] targetArray, KnowledgeBase knowledgeBase, String string2) {
        super(genericEvents, n, string);
        this.taskHsm = string;
        this.guard = guard;
        this.knowledgeBase = knowledgeBase;
        this.naviTargets = targetArray;
        this.name = string2;
    }

    @Override
    public Target[] getGroupMembers() {
        return this.naviTargets;
    }

    @Override
    public void setTrafficLightState(int n) {
        this.trafficLightState = n;
    }

    @Override
    public int getTrafficLightState() {
        return this.trafficLightState;
    }

    @Override
    public void sendPowerOnSignal() {
        if (NavigationDefinitions.NAVI_LOGGER.isTraceEnabled(16384)) {
            LogMessage logMessage = NavigationDefinitions.NAVI_LOGGER.trace(16384);
            logMessage.append("NAVI-STARTUP: ").append("Sending POWER_ON in group '");
            logMessage.append(this.getName());
            logMessage.append("'");
            logMessage.log();
        }
        this.sendEventToAllMemberTargets(106, 0, 1, false);
    }

    @Override
    public void sendGreenToYellowSignal() {
        if (NavigationDefinitions.NAVI_LOGGER.isTraceEnabled(16384)) {
            LogMessage logMessage = NavigationDefinitions.NAVI_LOGGER.trace(16384);
            logMessage.append("NAVI-STARTUP: ").append("Sending NAVI_TARGET_PREPARE_OFF in group '");
            logMessage.append(this.getName());
            logMessage.append("'");
            logMessage.log();
        }
        this.sendEventToAllMemberTargets(-1970667264, 3, 2);
    }

    @Override
    public void sendYellowToRedSignal() {
        if (NavigationDefinitions.NAVI_LOGGER.isTraceEnabled(16384)) {
            LogMessage logMessage = NavigationDefinitions.NAVI_LOGGER.trace(16384);
            logMessage.append("NAVI-STARTUP: ").append("Sending NAVI_TARGET_GO_OFF in group '");
            logMessage.append(this.getName());
            logMessage.append("'");
            logMessage.log();
        }
        this.sendEventToAllMemberTargets(-2004221696, 2, 1);
    }

    @Override
    public void sendRedToYellowSignal() {
        if (NavigationDefinitions.NAVI_LOGGER.isTraceEnabled(16384)) {
            LogMessage logMessage = NavigationDefinitions.NAVI_LOGGER.trace(16384);
            logMessage.append("NAVI-STARTUP: ").append("Sending NAVI_TARGET_PREPARE_ON in group '");
            logMessage.append(this.getName());
            logMessage.append("'");
            logMessage.log();
        }
        this.sendEventToAllMemberTargets(-1953890048, 1, 2);
    }

    @Override
    public void sendYellowToGreenSignal() {
        if (NavigationDefinitions.NAVI_LOGGER.isTraceEnabled(16384)) {
            LogMessage logMessage = NavigationDefinitions.NAVI_LOGGER.trace(16384);
            logMessage.append("NAVI-STARTUP: ").append("Sending NAVI_TARGET_GO_ON in group '");
            logMessage.append(this.getName());
            logMessage.append("'");
            logMessage.log();
        }
        this.sendEventToAllMemberTargets(-1987444480, 2, 3);
    }

    private void sendEventToAllMemberTargets(int n, int n2, int n3) {
        this.sendEventToAllMemberTargets(n, n2, n3, true);
    }

    private void sendEventToAllMemberTargets(int n, int n2, int n3, boolean bl) {
        if (this.getTrafficLightState() == -2) {
            LogMessage logMessage = NavigationDefinitions.NAVI_LOGGER.error(16384);
            logMessage.append("NAVI-STARTUP: ").append("Can not start new transitions while in TRANSITION mode: '");
            logMessage.append(this.getName());
            logMessage.append("'");
            logMessage.log();
            return;
        }
        if (this.naviTargets == null || this.naviTargets.length == 0) {
            if (NavigationDefinitions.NAVI_LOGGER.isTraceEnabled(16384)) {
                LogMessage logMessage = NavigationDefinitions.NAVI_LOGGER.trace(16384);
                logMessage.append("NAVI-STARTUP: ").append("The following group has no members '");
                logMessage.append(this.getName());
                logMessage.append("' ");
                logMessage.append("Switching directly to state: ");
                logMessage.append(n3);
                logMessage.log();
            }
            this.setTrafficLightState(n3);
            this.knowledgeBase.notifyObserver();
            return;
        }
        if (bl) {
            this.setTrafficLightState(-2);
            this.transitionResponseCounter = 0;
            this.transitionResponseCollector = new int[this.naviTargets.length];
            this.setTransitionOldState(n2);
            this.setTransitionNewState(n3);
            this.startTimer(-1937112832, (long)0, false);
            if (this.isTraceEnabled()) {
                this.trace().append("NAVI-STARTUP: ").append("Starting timer: ").append(12000).log();
            }
        }
        this.responseIds.clear();
        for (int i2 = 0; i2 < this.naviTargets.length; ++i2) {
            Target target = this.naviTargets[i2];
            int n4 = target.getTargetId();
            this.responseIds.add(n4);
            this.sendNaviStartupEvent(n4, n, n2, n3);
        }
        if (!bl) {
            this.setTrafficLightState(n3);
            this.knowledgeBase.notifyObserver();
        }
    }

    private void handleTimeout() {
        LogMessage logMessage;
        if (this.getTrafficLightState() != -2) {
            logMessage = NavigationDefinitions.NAVI_LOGGER.error(16384);
            logMessage.append("NAVI-STARTUP: ").append("A timeout occured while >not< IN_TRANSITION in group '");
            logMessage.append(this.getName());
            logMessage.append("'");
            logMessage.log();
        }
        logMessage = NavigationDefinitions.NAVI_LOGGER.warn(16384);
        logMessage.append("NAVI-STARTUP: ").append("A timeout occured in group '");
        logMessage.append(this.getName());
        logMessage.append("'");
        logMessage.append("Responses till now are: ");
        logMessage.append(Arrays.toString(this.transitionResponseCollector));
        int[] nArray = new int[this.naviTargets.length];
        int n = 0;
        Arrays.sort(this.transitionResponseCollector);
        for (int i2 = 0; i2 < this.naviTargets.length; ++i2) {
            Target target = this.naviTargets[i2];
            int n2 = target.getTargetId();
            for (int i3 = 0; i3 < i2; ++i3) {
                if (this.naviTargets[i3].getTargetId() != n2) continue;
                NavigationDefinitions.NAVI_LOGGER.error(16384).append("target with same id: ").append(n2).log();
            }
            if (Arrays.binarySearch(this.transitionResponseCollector, n2) >= 0) continue;
            nArray[n++] = n2;
        }
        logMessage.append("Missing responses from targets:");
        logMessage.append(Arrays.toString(nArray));
        logMessage.log();
        logMessage = NavigationDefinitions.NAVI_LOGGER.warn(16384);
        logMessage.append("NAVI-STARTUP: ").append("Switching state from '");
        logMessage.append(this.getTransitionOldState());
        logMessage.append("' to '");
        logMessage.append(this.getTransitionNewState());
        logMessage.append("'");
        logMessage.log();
        this.stopTimer(-1937112832);
        this.setTrafficLightState(this.getTransitionNewState());
        this.knowledgeBase.notifyObserver();
    }

    private void sendNaviStartupEvent(int n, int n2, int n3, int n4) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.getTargetId(), n, n2);
        eventGeneric.setSenderEventId(n2);
        eventGeneric.setInt(0, n3);
        eventGeneric.setInt(1, n4);
        eventGeneric.setInt(2, n);
        this.send(eventGeneric);
    }

    @Override
    public Guard getGuard() {
        return this.guard;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 101004: {
                this.handleTimeout();
                break;
            }
            case 101003: {
                this.handleResponse(eventGeneric);
                break;
            }
            case 101001: {
                this.handleResponse(eventGeneric);
                break;
            }
            case 101002: {
                this.handleResponse(eventGeneric);
                break;
            }
            case 101000: {
                this.handleResponse(eventGeneric);
                break;
            }
        }
    }

    private void handleResponse(EventGeneric eventGeneric) {
        int n = eventGeneric.getSenderTargetId();
        int n2 = eventGeneric.getInt(0);
        int n3 = eventGeneric.getInt(1);
        if (this.getTrafficLightState() != -2) {
            if (NavigationDefinitions.NAVI_LOGGER.isTraceEnabled(16384)) {
                LogMessage logMessage = NavigationDefinitions.NAVI_LOGGER.trace(16384);
                logMessage.append("NAVI-STARTUP: ").append("Received response but was not IN_TRANSITION mode. Ignoring event.");
                logMessage.log();
            }
            return;
        }
        if (n2 != this.getTransitionOldState() || n3 != this.getTransitionNewState()) {
            if (NavigationDefinitions.NAVI_LOGGER.isTraceEnabled(16384)) {
                LogMessage logMessage = NavigationDefinitions.NAVI_LOGGER.trace(16384);
                logMessage.append("NAVI-STARTUP: ").append("Received response but event is from another (previous) transition. Ignoring event.");
                logMessage.log();
            }
            return;
        }
        this.transitionResponseCollector[this.transitionResponseCounter] = n;
        ++this.transitionResponseCounter;
        if (this.transitionResponseCounter == this.naviTargets.length || this.transitionResponseCounter == this.responseIds.size()) {
            if (NavigationDefinitions.NAVI_LOGGER.isTraceEnabled(16384)) {
                LogMessage logMessage = NavigationDefinitions.NAVI_LOGGER.trace(16384);
                logMessage.append("NAVI-STARTUP: ").append("Received all responses in group '");
                logMessage.append(this.getName());
                logMessage.append("' switching state from '");
                logMessage.append(n2);
                logMessage.append("' to '");
                logMessage.append(n3);
                logMessage.append("'");
                logMessage.append("Responses came in the following order");
                logMessage.append(Arrays.toString(this.transitionResponseCollector));
                logMessage.log();
            }
            this.stopTimer(-1937112832);
            this.setTrafficLightState(n3);
            this.knowledgeBase.notifyObserver();
        }
    }

    private void setTransitionOldState(int n) {
        this.transitionOldState = n;
    }

    @Override
    public int getTransitionOldState() {
        return this.transitionOldState;
    }

    private void setTransitionNewState(int n) {
        this.transitionNewState = n;
    }

    @Override
    public int getTransitionNewState() {
        return this.transitionNewState;
    }

    @Override
    public int getSubClassifier() {
        return 16384;
    }

    @Override
    public int getClassifier() {
        return 1;
    }

    @Override
    public String getName() {
        return this.name;
    }
}

