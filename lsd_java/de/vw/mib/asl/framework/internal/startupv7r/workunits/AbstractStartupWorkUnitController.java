/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.workunits;

import de.vw.mib.asl.framework.internal.startupv7r.AbstractStartupTask;
import de.vw.mib.asl.framework.internal.startupv7r.model.AbstractWorkUnit;
import de.vw.mib.log4mib.Logger;

public abstract class AbstractStartupWorkUnitController
extends AbstractStartupTask {
    public static final int INVALID;
    public static final int LISTENER_CONSTANT_FOR_DP_INVALID;
    static final int STARTUP_STEP_INIT;
    static final int STARTUP_STEP_0_CHECK_PRECEDING_WORK_UNITS;
    static final int STARTUP_STEP_1_ASL_COMPONENTS;
    static final int STARTUP_STEP_2_PERSISTENCE;
    static final int STARTUP_STEP_3_DOMAIN;
    static final int STARTUP_STEP_4_DSI;
    static final int STARTUP_STEP_5_ASL;
    static final int STARTUP_STEP_6_UPDATE_TO_HMI;
    static final int STARTUP_STEP_LAST_POSSIBILITY;
    static final int STARTUP_STEP_LAST_INVALID_POSSIBILITY;
    public static final int BITMASK_NONE;
    public static final int BITMASK_EXIT_CONDITION_LAM_AND_LUM_AND_KEYPRESS;
    public static final int BITMASK_EXIT_CONDITION_KEYPRESS;
    public static final int BITMASK_EXIT_CONDITION_RELEASE_DISPLAY_AFTER_SWDL_IN_SWDL_CASE;
    public static final int BITMASK_ENTRY_CONDITION_CHECK_TESTMODE_ALLOWED;
    public static final int BITMASK_ENTRY_CONDITION_ADB_CHECK_IF_ASIA_VARIANT_FOR_SPELLER;
    public static final int BITMASK_ENTRY_CONDITION_ALLOW_LSC_ON_SPECIAL_SITUATION_IN_STD;
    public static final int BITMASK_ENTRY_CONDITION_CHECK_ONLINE_SERVICES_ALLOWED;
    public static final int BITMASK_ENTRY_CONDITION_CHECK_NECESSARY_PHONE_DSIS;
    public static final int BITMASK_ENTRY_CONDITION_CHECK_FOR_PQ_MEDIA_BROWSERINSTANCE;
    public static final int BITMASK_ENTRY_CONDITION_CHECK_FOR_BEV_PHEV_OTHERWISE_SKIP;
    public static final int BITMASK_ENTRY_CONDITION_CHECK_KOMONAV_ALLOWED;
    public static final int BITMASK_ENTRY_CONDITION_CHECK_TVTUNER_ALLOWED;
    public static final int BITMASK_ENTRY_CONDITION_DO_NOT_USE_IF_KOMONAV_CODED;
    public static final int BITMASK_ENTRY_CONDITION_CHECK_IF_ONLINE_POIS_ALLOWED;
    public static final int BITMASK_ENTRY_CONDITION_CHECK_IF_ONLINE_CORE_SERVICES_ALLOWED;
    public static final int BITMASK_ENTRY_CONDITION_MARK_SWDL_RELEVANT;
    public static final int BITMASK_ENTRY_CONDITION_CHECK_FOR_PICTURESERVER_ALLOWED;
    public static final int BITMASK_ENTRY_CONDITION_SPECIAL_MARKER_IS_SDS_RESTART;
    public static final int BITMASK_ENTRY_CONDITION_SPECIAL_MARKER_IS_NAV_RESTART;
    public static final int BITMASK_ENTRY_CONDITION_SPECIAL_MARKER_IS_GEMMI_RESTART;
    public static final int BITMASK_ENTRY_CONDITION_SPECIAL_MARKER_IS_EXLAP_RESTART;

    public AbstractStartupWorkUnitController(Logger logger) {
        super(logger);
    }

    public abstract AbstractWorkUnit getModel() {
    }
}

