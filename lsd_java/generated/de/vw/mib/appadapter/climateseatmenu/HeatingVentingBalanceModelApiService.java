/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.appadapter.climateseatmenu;

import de.vw.mib.app.appadapter.modelapi.ModelApiService;

public interface HeatingVentingBalanceModelApiService
extends ModelApiService {
    public static final int SET_SEAT_HEATING_PARAM_INCREASE_DECREASE_ENUM_DECREASE;
    public static final int SET_SEAT_HEATING_PARAM_INCREASE_DECREASE_ENUM_INCREASE;
    public static final int SET_SEAT_VENTING_PARAM_INCREASE_DECREASE_ENUM_DECREASE;
    public static final int SET_SEAT_VENTING_PARAM_INCREASE_DECREASE_ENUM_INCREASE;

    default public void _mda_changeSeatArmrest(int n) {
    }

    default public void _mda_changeSeatHeating(int n) {
    }

    default public void _mda_changeSeatVenting(int n) {
    }

    default public void _mda_setSeatHeating(int n) {
    }

    default public void _mda_setSeatVenting(int n) {
    }
}

