/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.startup.groups;

import de.vw.mib.asl.internal.navigation.startup.guards.Guard;
import de.vw.mib.genericevents.Target;

public interface StartupGroup {
    default public void setTrafficLightState(int n) {
    }

    default public int getTrafficLightState() {
    }

    default public Target[] getGroupMembers() {
    }

    default public void sendGreenToYellowSignal() {
    }

    default public void sendYellowToRedSignal() {
    }

    default public void sendRedToYellowSignal() {
    }

    default public void sendYellowToGreenSignal() {
    }

    default public void sendPowerOnSignal() {
    }

    default public Guard getGuard() {
    }

    default public int getTransitionOldState() {
    }

    default public int getTransitionNewState() {
    }

    default public String getName() {
    }
}

