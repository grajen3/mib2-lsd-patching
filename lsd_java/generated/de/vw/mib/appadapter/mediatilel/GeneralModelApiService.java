/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.appadapter.mediatilel;

import de.vw.mib.app.appadapter.modelapi.ModelApiService;

public interface GeneralModelApiService
extends ModelApiService {
    public static final int SET_REPEAT_MODE_PARAM_MODE_ENUM_MODE_OFF;
    public static final int SET_REPEAT_MODE_PARAM_MODE_ENUM_MODE_FOLDER;
    public static final int SET_REPEAT_MODE_PARAM_MODE_ENUM_MODE_FILE;

    default public void _mda_activateMixMode() {
    }

    default public void _mda_activatePlayMoreLikeThis() {
    }

    default public void _mda_deactivateMixMode() {
    }

    default public void _mda_deactivatePlayMoreLikeThis() {
    }

    default public void _mda_setRepeatMode(int n) {
    }

    default public void _mda_setTrackToTime(int n) {
    }
}

