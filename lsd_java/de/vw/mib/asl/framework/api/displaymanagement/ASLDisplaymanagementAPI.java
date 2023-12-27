/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.displaymanagement;

import de.vw.mib.asl.framework.api.displaymanagement.WritableHelper;
import de.vw.mib.asl.framework.api.displaymanagement.displayable.DisplayableService;

public interface ASLDisplaymanagementAPI {
    public static final int DISPLAY_DEFAULT;
    public static final int P_DISPLAYID;
    public static final int P_DISPLAYABLE;
    public static final int SET_DIMENSION;
    public static final int SET_DIMENSION_P_WIDTH;
    public static final int SET_DIMENSION_P_HEIGHT;
    public static final int SET_SCALE_MODE;
    public static final int SET_SCALE_MODE_P_ENUM;
    public static final int SET_POSITION_P_X;
    public static final int SET_POSITION_P_Y;
    public static final int SET_POSITION;

    default public boolean isInitialSwitchContextPending() {
    }

    default public WritableHelper createWritableHelperInstance() {
    }

    default public DisplayableService getDisplayableService() {
    }
}

