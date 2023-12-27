/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.appadapter.car;

import de.vw.mib.app.appadapter.modelapi.ModelApiService;

public interface GesturesModelApiService
extends ModelApiService {
    public static final int SHOW_SPACE_GESTURE_AVAILABLE_ANIMATION_PARAM_STATUS_ENUM_OFF;
    public static final int SHOW_SPACE_GESTURE_AVAILABLE_ANIMATION_PARAM_STATUS_ENUM_ON;
    public static final int SHOW_SPACE_GESTURE_REGISTERED_ANIMATION_PARAM_DIRECTION_ENUM_LEFT_TO_RIGHT;
    public static final int SHOW_SPACE_GESTURE_REGISTERED_ANIMATION_PARAM_DIRECTION_ENUM_RIGHT_TO_LEFT;
    public static final boolean SHOW_SPACE_GESTURE_REGISTERED_ANIMATION_PARAM_STATUS_ENUM_FAILURE;
    public static final boolean SHOW_SPACE_GESTURE_REGISTERED_ANIMATION_PARAM_STATUS_ENUM_SUCCESS;

    default public void _mda_showSpaceGestureAvailableAnimation(int n) {
    }

    default public void _mda_showSpaceGestureRegisteredAnimation(int n, boolean bl) {
    }
}

