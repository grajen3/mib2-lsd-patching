/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.fpa;

import de.vw.mib.asl.api.car.fpa.FPACharismaProfileFunctionAvailability;
import de.vw.mib.asl.api.car.fpa.FPACharismaProfileServiceListener;
import org.dsi.ifc.cardrivingcharacteristics.CharismaSetupTableWithOptionMask;
import org.dsi.ifc.cardrivingcharacteristics.CharismaSetupTableWithoutOptionMask;

public class FPACharismaProfileServiceListenerAdapter
implements FPACharismaProfileServiceListener {
    @Override
    public void updateActiveProfile(int n) {
    }

    @Override
    public void updateFPAConfiguration(int n) {
    }

    @Override
    public void updateFPAisExistent(boolean bl) {
    }

    @Override
    public void updateCharismaSetupTableWithoutOptionMask(CharismaSetupTableWithoutOptionMask[] charismaSetupTableWithoutOptionMaskArray) {
    }

    @Override
    public void updateCharismaSetupTableWithOptionMask(CharismaSetupTableWithOptionMask[] charismaSetupTableWithOptionMaskArray) {
    }

    @Override
    public void updateFPAServiceExisting(boolean bl) {
    }

    @Override
    public void updateFPAFunctionAvailability(FPACharismaProfileFunctionAvailability fPACharismaProfileFunctionAvailability) {
    }

    @Override
    public void updateAvailableProfiles(boolean[] blArray) {
    }
}

