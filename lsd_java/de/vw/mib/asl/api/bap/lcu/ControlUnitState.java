/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.bap.lcu;

import de.vw.mib.asl.api.bap.timer.TimerNotifier;
import org.dsi.ifc.bap.DSIBAPListener;

public interface ControlUnitState
extends DSIBAPListener {
    default public void initialize() {
    }

    default public void allDataPoolValuesAreValid() {
    }

    default public void hmiDatapoolValueChanged(int n, int n2) {
    }

    default public void languageChange(int n) {
    }

    default public void processHMIEvent(int n, int n2) {
    }

    default public void notifyTimer(int n, TimerNotifier timerNotifier, int n2) {
    }

    default public void sendBAPStageOutputValue(int n) {
    }

    default public void persistenceBecomeAvailable(int n) {
    }

    default public void transmitData(int n, int n2, Object object) {
    }
}

