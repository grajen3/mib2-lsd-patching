/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.startup;

public interface StartupWorkUnit {
    public static final int INVALID;
    public static final int STARTUP_STEP_INIT;
    public static final int STARTUP_STEP_0_CHECK_PRECEDING_WORK_UNITS;
    public static final int STARTUP_STEP_1_PERSISTENCE;
    public static final int STARTUP_STEP_2_DOMAIN;
    public static final int STARTUP_STEP_3_DSI;
    public static final int STARTUP_STEP_4_ASL;
    public static final int STARTUP_STEP_5_UPDATE_TO_HMI;
    public static final int BITMASK_NONE;
    public static final int BITMASK_EXIT_CONDITION_LAM_AND_LUM_AND_KEYPRESS;
    public static final int BITMASK_EXIT_CONDITION_KEYPRESS;
    public static final int BITMASK_EXIT_CONDITION_BT_NOT_CODED;
    public static final int BITMASK_EXIT_CONDITION_SWDL_SPECIAL_STARTUP;
    public static final int BITMASK_EXIT_CONDITION_CHECK_LAM_STATE_AND_START_IF_NECESSARY;
    public static final int BITMASK_EXIT_CONDITION_CHECK_FOR_RVC_OR_OPS_RUNNING;
    public static final int BITMASK_ENTRY_CONDITION_CHECK_TESTMODE_ALLOWED;
    public static final int BITMASK_ENTRY_CONDITION_ADB_CHECK_IF_ASIA_VARIANT_FOR_SPELLER;
    public static final int BITMASK_ENTRY_CONDITION_ALLOW_LSC_ON_SPECIAL_SITUATION_IN_STD;

    default public void doNextWorkStep() {
    }

    default public void doNextWorkStepAfterDomainCallback() {
    }

    default public void doNextWorkStepAfterDSICallback() {
    }

    default public void doNextWorkStepAfterASLCallback() {
    }

    default public void doNextWorkStepAfterPersistenceCallback() {
    }

    default public void setPersistenceReady() {
    }

    default public void doNextWorkStepForPrecondition(StartupWorkUnit startupWorkUnit) {
    }

    default public boolean wasCompletelyStartedAlready() {
    }

    default public StartupWorkUnit getPreconditionWorkUnit() {
    }

    default public void setNextWorkUnitInStandardOrder(StartupWorkUnit startupWorkUnit) {
    }

    default public void overridePreconditionWorkUnit(StartupWorkUnit startupWorkUnit) {
    }

    default public void setThisWorkunitLamSensitive() {
    }

    default public String getName() {
    }

    default public void callSpecialMethod() {
    }
}

