/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.fpa;

import de.vw.mib.asl.api.car.fpa.FPACharismaProfileFunctionAvailability;
import org.dsi.ifc.cardrivingcharacteristics.CharismaSetupTableWithOptionMask;
import org.dsi.ifc.cardrivingcharacteristics.CharismaSetupTableWithoutOptionMask;

public interface FPACharismaProfileService {
    public static final int CHARISMAPROFILES_COMFORT;
    public static final int CHARISMAPROFILES_NORMAL;
    public static final int CHARISMAPROFILES_DYNAMIC;
    public static final int CHARISMAPROFILES_OFFROAD_ALLROAD;
    public static final int CHARISMAPROFILES_EFFICIENCY;
    public static final int CHARISMAPROFILES_SPORT_RACE;
    public static final int CHARISMAPROFILES_INDIVIDUAL;
    public static final int CHARISMAPROFILES_RANGE;
    public static final int CHARISMAPROFILES_LIFT;
    public static final int CHARISMAPROFILES_OFFROADLEVEL2;
    public static final int CHARISMAPROFILES_OFFROADLEVEL3;
    public static final int CHARISMAPROFILES_OFFROADLEVEL4;
    public static final int CONFIG__C0_FPA;
    public static final int CONFIG__C1_FPA_DCC;
    public static final int CONFIG__C2_DCC;
    public static final int CONFIG__C3_OFFROAD;

    default public int getProfileActive() {
    }

    default public boolean[] getAvailableProfiles() {
    }

    default public void changeProfileActive(int n) {
    }

    default public int getFPAConfiguration() {
    }

    default public boolean isFPAExistent() {
    }

    default public FPACharismaProfileFunctionAvailability getFPACharismaProfileFunctionAvailability() {
    }

    default public CharismaSetupTableWithoutOptionMask[] getCharismaSetupTableWithoutOptionMask() {
    }

    default public void changeCharismaSetupTableWithoutOptionMask(CharismaSetupTableWithoutOptionMask[] charismaSetupTableWithoutOptionMaskArray) {
    }

    default public CharismaSetupTableWithOptionMask[] getCharismaTableWithOptionMask() {
    }

    default public void changeCharismaTableWithOptionMask(CharismaSetupTableWithOptionMask[] charismaSetupTableWithOptionMaskArray) {
    }
}

