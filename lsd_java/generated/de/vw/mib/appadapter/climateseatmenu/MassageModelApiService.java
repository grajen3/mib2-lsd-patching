/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.appadapter.climateseatmenu;

import de.vw.mib.app.appadapter.modelapi.ModelApiService;

public interface MassageModelApiService
extends ModelApiService {
    public static final int CHANGE_SEAT_MASSAGE_INTENSITY_PARAM_CLIMATE_ZONE_ENUM_SEAT_ZONE_FRONT_LEFT;
    public static final int CHANGE_SEAT_MASSAGE_INTENSITY_PARAM_CLIMATE_ZONE_ENUM_SEAT_ZONE_FRONT_RIGHT;
    public static final int CHANGE_SEAT_MASSAGE_INTENSITY_PARAM_CLIMATE_ZONE_ENUM_SEAT_ZONE_REAR_LEFT;
    public static final int CHANGE_SEAT_MASSAGE_INTENSITY_PARAM_CLIMATE_ZONE_ENUM_SEAT_ZONE_REAR_RIGHT;
    public static final int SET_SEAT_MASSAGE_INTENSITY_PARAM_CLIMATE_ZONE_ENUM_SEAT_ZONE_FRONT_LEFT;
    public static final int SET_SEAT_MASSAGE_INTENSITY_PARAM_CLIMATE_ZONE_ENUM_SEAT_ZONE_FRONT_RIGHT;
    public static final int SET_SEAT_MASSAGE_INTENSITY_PARAM_CLIMATE_ZONE_ENUM_SEAT_ZONE_REAR_LEFT;
    public static final int SET_SEAT_MASSAGE_INTENSITY_PARAM_CLIMATE_ZONE_ENUM_SEAT_ZONE_REAR_RIGHT;
    public static final int SET_SEAT_MASSAGE_INTENSITY_PARAM_SEAT_MASSAGE_INTENSITY_ENUM_DECREASE;
    public static final int SET_SEAT_MASSAGE_INTENSITY_PARAM_SEAT_MASSAGE_INTENSITY_ENUM_INCREASE;
    public static final int SET_SEAT_MASSAGE_PROGRAM_PARAM_CLIMATE_ZONE_ENUM_SEAT_ZONE_FRONT_LEFT;
    public static final int SET_SEAT_MASSAGE_PROGRAM_PARAM_CLIMATE_ZONE_ENUM_SEAT_ZONE_FRONT_RIGHT;
    public static final int SET_SEAT_MASSAGE_PROGRAM_PARAM_CLIMATE_ZONE_ENUM_SEAT_ZONE_REAR_LEFT;
    public static final int SET_SEAT_MASSAGE_PROGRAM_PARAM_CLIMATE_ZONE_ENUM_SEAT_ZONE_REAR_RIGHT;
    public static final int SET_SEAT_ZONE_PARAM_SEAT_ZONE_ENUM_SEAT_ZONE_FRONT;
    public static final int SET_SEAT_ZONE_PARAM_SEAT_ZONE_ENUM_SEAT_ZONE_REAR_LEFT;
    public static final int SET_SEAT_ZONE_PARAM_SEAT_ZONE_ENUM_SEAT_ZONE_REAR_RIGHT;

    default public void _mda_changeSeatMassageIntensity(int n, int n2) {
    }

    default public void _mda_setSeatMassageIntensity(int n, int n2) {
    }

    default public void _mda_setSeatMassageProgram(int n, int n2) {
    }

    default public void _mda_setSeatZone(int n) {
    }
}

