/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.sm;

import de.vw.mib.event.HMIEvent;
import de.vw.mib.sm.StatemachineDiagnose;

public interface StatemachineManager
extends StatemachineDiagnose {
    public static final int VIP_ABSENT;
    public static final int VIP_PRESENT;
    public static final int DRIVER_DISTRACTION_PREVENTION_DEACTIVATE;
    public static final int DRIVER_DISTRACTION_PREVENTION_ACTIVATE;

    default public void activatePopup(int n) {
    }

    default public void deactivatePopup(int n) {
    }

    default public void suspendPopup(int n) {
    }

    default public void resumePopup(int n) {
    }

    default public void focusGainedPopup(int n) {
    }

    default public void focusLostPopup(int n) {
    }

    default public void veryImportantPopup(int n) {
    }

    default public boolean consumeEvent(int n, HMIEvent hMIEvent) {
    }

    default public void setDriverDistractionPrevention(int n) {
    }
}

