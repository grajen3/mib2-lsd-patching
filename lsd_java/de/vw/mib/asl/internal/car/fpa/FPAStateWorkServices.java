/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.fpa;

import org.dsi.ifc.cardrivingcharacteristics.CharismaListUpdateInfo;
import org.dsi.ifc.cardrivingcharacteristics.CharismaSetupTableWithOptionMask;
import org.dsi.ifc.cardrivingcharacteristics.CharismaSetupTableWithoutOptionMask;

public interface FPAStateWorkServices {
    default public void requestCharismaListUpdate(CharismaListUpdateInfo charismaListUpdateInfo) {
    }

    default public void changeActiveProfile(int n) {
    }

    default public void updateActiveProfile(int n) {
    }

    default public void changeCharismaSetupTableWithoutOptionMask(int n, CharismaSetupTableWithoutOptionMask[] charismaSetupTableWithoutOptionMaskArray) {
    }

    default public void changeCharismaSetupTableWithOptionMask(int n, CharismaSetupTableWithOptionMask[] charismaSetupTableWithOptionMaskArray) {
    }

    default public boolean[] getAvailableProfiles() {
    }

    default public void updateAvailableProfiles(boolean[] blArray) {
    }
}

