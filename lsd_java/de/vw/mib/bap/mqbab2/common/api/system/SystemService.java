/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.system;

import de.vw.mib.bap.mqbab2.common.api.hmi.HMIEventListener;
import de.vw.mib.bap.mqbab2.common.api.system.SystemServiceListener;

public interface SystemService {
    default public void addSystemServiceListener(SystemServiceListener systemServiceListener, int[] nArray) {
    }

    default public void removeSystemServiceListener(SystemServiceListener systemServiceListener, int[] nArray) {
    }

    default public void addHMIEventListener(HMIEventListener hMIEventListener, int[] nArray) {
    }

    default public void removeHMIEventListener(HMIEventListener hMIEventListener, int[] nArray) {
    }

    default public int getCurrentDistanceUnit() {
    }

    default public int getSystemOnOffState() {
    }

    default public int getDayAndNightMode() {
    }

    default public int getSystemTimeFormat() {
    }

    default public int getNavigationDomainAvailable() {
    }

    default public int getPhoneDomainAvailable() {
    }

    default public int getAddressbookDomainAvailable() {
    }

    default public int getSpeechDomainAvailable() {
    }

    default public boolean isDABAvailable() {
    }

    default public boolean isAMAvailable() {
    }

    default public int getCurrentMainContext() {
    }

    default public int isComponentProtectionActive() {
    }

    default public boolean isArabicVariant() {
    }

    default public void setDayAndNightMode(int n) {
    }
}

