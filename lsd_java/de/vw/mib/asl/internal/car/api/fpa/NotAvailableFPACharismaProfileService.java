/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.api.fpa;

import de.vw.mib.asl.api.car.fpa.FPACharismaProfileFunctionAvailability;
import de.vw.mib.asl.api.car.fpa.FPACharismaProfileService;
import de.vw.mib.asl.api.car.fpa.FPACharismaProfileServiceListener;
import org.dsi.ifc.cardrivingcharacteristics.CharismaSetupTableWithOptionMask;
import org.dsi.ifc.cardrivingcharacteristics.CharismaSetupTableWithoutOptionMask;

public class NotAvailableFPACharismaProfileService
implements FPACharismaProfileService {
    @Override
    public int getProfileActive() {
        return 0;
    }

    @Override
    public void changeProfileActive(int n) {
    }

    @Override
    public int getFPAConfiguration() {
        return 0;
    }

    @Override
    public boolean isFPAExistent() {
        return false;
    }

    @Override
    public FPACharismaProfileFunctionAvailability getFPACharismaProfileFunctionAvailability() {
        return null;
    }

    @Override
    public CharismaSetupTableWithoutOptionMask[] getCharismaSetupTableWithoutOptionMask() {
        return null;
    }

    @Override
    public void changeCharismaSetupTableWithoutOptionMask(CharismaSetupTableWithoutOptionMask[] charismaSetupTableWithoutOptionMaskArray) {
    }

    @Override
    public CharismaSetupTableWithOptionMask[] getCharismaTableWithOptionMask() {
        return null;
    }

    @Override
    public void changeCharismaTableWithOptionMask(CharismaSetupTableWithOptionMask[] charismaSetupTableWithOptionMaskArray) {
    }

    public void addFPAServiceListener(FPACharismaProfileServiceListener fPACharismaProfileServiceListener) {
    }

    public void removeFPAServiceListener(FPACharismaProfileServiceListener fPACharismaProfileServiceListener) {
    }

    @Override
    public boolean[] getAvailableProfiles() {
        return null;
    }
}

