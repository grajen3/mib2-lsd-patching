/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.careco;

import org.dsi.ifc.careco.BCmEListUpdateInfo;
import org.dsi.ifc.careco.StartStopListUpdateInfo;

public interface DSICarEcoC {
    default public void requestBCmEConsumerList(BCmEListUpdateInfo bCmEListUpdateInfo) {
    }

    default public void setBCmELiveTip(int n, boolean bl) {
    }

    default public void setBcmeSetFactoryDefault() {
    }

    default public void requestStartStopProhibitList(StartStopListUpdateInfo startStopListUpdateInfo) {
    }

    default public void requestStartStopRestartList(StartStopListUpdateInfo startStopListUpdateInfo) {
    }

    default public void requestStartStopRestartProhibitList(StartStopListUpdateInfo startStopListUpdateInfo) {
    }

    default public void requestBCmEConsumerListConsumption(BCmEListUpdateInfo bCmEListUpdateInfo) {
    }

    default public void requestBCmEConsumerListRange(BCmEListUpdateInfo bCmEListUpdateInfo) {
    }

    default public void setRDSetFactoryDefault() {
    }

    default public void setEASystem(boolean bl) {
    }

    default public void setEAPedalJerk(boolean bl) {
    }

    default public void setEASetFactoryDefault() {
    }

    default public void setEAFreeWheeling(boolean bl) {
    }

    default public void setEAStartStop(boolean bl) {
    }

    default public void setNotification(int[] nArray) {
    }

    default public void setNotification(int n) {
    }

    default public void setNotification() {
    }

    default public void clearNotification(int[] nArray) {
    }

    default public void clearNotification(int n) {
    }

    default public void clearNotification() {
    }

    default public void yySet(String string, String string2) {
    }
}

