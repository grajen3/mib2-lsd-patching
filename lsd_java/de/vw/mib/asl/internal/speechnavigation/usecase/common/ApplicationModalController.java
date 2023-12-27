/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.common;

import de.vw.mib.asl.internal.speechnavigation.usecase.common.ModalController;

public interface ApplicationModalController
extends ModalController {
    default public void onWaypointModeActive() {
    }

    default public void onConfirmStopWaypointModeCommand() {
    }

    default public void onAbortStopWayPointModeCommand() {
    }

    default public void onSilentGuidanceActive() {
    }

    default public void onConfirmStopSilentGuidanceCommand() {
    }

    default public void onAbortStopSilentGuidanceCommand() {
    }

    default public void onRouteCalculationActive() {
    }

    default public void onConfirmStopRouteCalculationCommand() {
    }

    default public void onAbortStopRouteCalculationCommand() {
    }
}

