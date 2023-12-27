/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.appadapter.navinfotile;

import de.vw.mib.app.appadapter.modelapi.ModelApiService;

public interface GeneralModelApiService
extends ModelApiService {
    public static final int SET_CURRENT_PAGE_PARAM_CURRENT_PAGE_ENUM_COMPASS;
    public static final int SET_CURRENT_PAGE_PARAM_CURRENT_PAGE_ENUM_POSITION;
    public static final int SET_CURRENT_PAGE_PARAM_CURRENT_PAGE_ENUM_WPM;
    public static final int SET_CURRENT_PAGE_PARAM_CURRENT_PAGE_ENUM_MANEUVER;
    public static final int SET_CURRENT_PAGE_PARAM_CURRENT_PAGE_ENUM_PNAV;
    public static final int SET_CURRENT_PAGE_PARAM_CURRENT_PAGE_ENUM_NAVIGATION;
    public static final int SET_CURRENT_PAGE_PARAM_CURRENT_PAGE_ENUM_PERSISTED;
    public static final int SWITCH_TO_PARAM_CONTENT_ENUM_MAIN;
    public static final int SWITCH_TO_PARAM_CONTENT_ENUM_LOADING;

    default public void _mda_navInfoTileEntered() {
    }

    default public void _mda_setCurrentPage(int n) {
    }

    default public void _mda_switchTo(int n) {
    }
}

