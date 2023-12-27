/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.fpa;

import de.vw.mib.asl.api.car.fpa.FPACharismaProfileFunctionAvailability;
import org.dsi.ifc.cardrivingcharacteristics.CharismaSetupTableWithOptionMask;
import org.dsi.ifc.cardrivingcharacteristics.CharismaSetupTableWithoutOptionMask;

public interface FPACharismaProfileServiceListener {
    default public void updateActiveProfile(int n) {
    }

    default public void updateFPAConfiguration(int n) {
    }

    default public void updateFPAisExistent(boolean bl) {
    }

    default public void updateFPAFunctionAvailability(FPACharismaProfileFunctionAvailability fPACharismaProfileFunctionAvailability) {
    }

    default public void updateCharismaSetupTableWithoutOptionMask(CharismaSetupTableWithoutOptionMask[] charismaSetupTableWithoutOptionMaskArray) {
    }

    default public void updateCharismaSetupTableWithOptionMask(CharismaSetupTableWithOptionMask[] charismaSetupTableWithOptionMaskArray) {
    }

    default public void updateFPAServiceExisting(boolean bl) {
    }

    default public void updateAvailableProfiles(boolean[] blArray) {
    }
}

