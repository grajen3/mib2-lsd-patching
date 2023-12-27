/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.appadapter.drivingdatatiles;

import de.vw.mib.app.appadapter.modelapi.ModelApiService;

public interface CarDrivingDataModelApiService
extends ModelApiService {
    public static final int SET_CURRENT_PAGE_PARAM_CURRENT_PAGE_ENUM_SINCE_START;
    public static final int SET_CURRENT_PAGE_PARAM_CURRENT_PAGE_ENUM_SINCE_LONGTERM;
    public static final int SET_CURRENT_PAGE_PARAM_CURRENT_PAGE_ENUM_SINCE_REFUELING;

    default public void _mda_setCurrentPage(int n) {
    }

    default public void _mda_setFullScreenDrivingData() {
    }
}

