/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.appadapter.climateseatmenu;

import de.vw.mib.app.appadapter.modelapi.ModelApiService;

public interface ExtraRearSeatClimateModelApiService
extends ModelApiService {
    public static final int HEATING_VALUE_CHANGED_PARAM_HEATING_ZONE_ENUM_LEFT;
    public static final int HEATING_VALUE_CHANGED_PARAM_HEATING_ZONE_ENUM_RIGHT;
    public static final int VENTILATION_VALUE_CHANGED_PARAM_VENTILATION_ZONE_ENUM_LEFT;
    public static final int VENTILATION_VALUE_CHANGED_PARAM_VENTILATION_ZONE_ENUM_RIGHT;

    default public void _mda_heatingValueChanged(int n, int n2) {
    }

    default public void _mda_ventilationValueChanged(int n, int n2) {
    }
}

