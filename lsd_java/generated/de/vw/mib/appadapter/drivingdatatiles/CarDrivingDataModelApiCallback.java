/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.appadapter.drivingdatatiles;

import de.vw.mib.app.appadapter.modelapi.ModelApiClient;

public class CarDrivingDataModelApiCallback
implements ModelApiClient {
    public static final int GET_BCMENU1_UNITS_CONSTANTS_ENUM_KM;
    public static final int GET_BCMENU1_UNITS_CONSTANTS_ENUM_MILES;
    public static final int GET_BCMENU1_UNITS_CONSTANTS_ENUM_H;
    public static final int GET_BCMENU1_UNITS_CONSTANTS_ENUM_KM_H;
    public static final int GET_BCMENU1_UNITS_CONSTANTS_ENUM_MPH;
    public static final int GET_BCMENU1_UNITS_CONSTANTS_ENUM_L_100KM;
    public static final int GET_BCMENU1_UNITS_CONSTANTS_ENUM_KM_L;
    public static final int GET_BCMENU1_UNITS_CONSTANTS_ENUM_MPG_US;
    public static final int GET_BCMENU1_UNITS_CONSTANTS_ENUM_MPG_UK;
    public static final int GET_BCMENU1_UNITS_CONSTANTS_ENUM_L_H;
    public static final int GET_BCMENU1_UNITS_CONSTANTS_ENUM_NONE;
    public static final int GET_BCMENU1_UNITS_CONSTANTS_ENUM_KG_100KM;
    public static final int GET_BCMENU1_UNITS_CONSTANTS_ENUM_KM_KG;
    public static final int GET_BCMENU1_UNITS_CONSTANTS_ENUM_M3_100KM;
    public static final int GET_BCMENU1_UNITS_CONSTANTS_ENUM_KM_M3;
    public static final int GET_BCMENU1_UNITS_CONSTANTS_ENUM_GALLON_H;
    public static final int GET_BCMENU1_UNITS_CONSTANTS_ENUM_KG_H;
    public static final int GET_BCMENU1_UNITS_CONSTANTS_ENUM_M3_H;
    public static final int GET_BCMENU1_UNITS_CONSTANTS_ENUM_MPLBS;
    public static final int GET_BCMENU1_UNITS_CONSTANTS_ENUM_LBS_H;
    public static final int GET_BCMENU1_UNITS_CONSTANTS_ENUM_MPY;
    public static final int GET_BCMENU1_UNITS_CONSTANTS_ENUM_Y3H;
    public static final int GET_BCMENU1_UNITS_CONSTANTS_ENUM_KWH_100KM;
    public static final int GET_BCMENU1_UNITS_CONSTANTS_ENUM_KM_KWH;
    public static final int GET_BCMENU1_UNITS_CONSTANTS_ENUM_KWH_M;
    public static final int GET_BCMENU1_UNITS_CONSTANTS_ENUM_M_KWH;
    public static final int GET_BCMENU1_UNITS_CONSTANTS_ENUM_KW;
    public static final int GET_BCMENU1_UNITS_CONSTANTS_ENUM_M_KG;
    public static final int GET_BCMENU1_UNITS_CONSTANTS_ENUM_M_M3;
    public static final int GET_BCMENU1_UNITS_CONSTANTS_ENUM_MPGE_US;
    public static final int GET_BCMENU2_UNITS_CONSTANTS_ENUM_KM;
    public static final int GET_BCMENU2_UNITS_CONSTANTS_ENUM_MILES;
    public static final int GET_BCMENU2_UNITS_CONSTANTS_ENUM_H;
    public static final int GET_BCMENU2_UNITS_CONSTANTS_ENUM_KM_H;
    public static final int GET_BCMENU2_UNITS_CONSTANTS_ENUM_MPH;
    public static final int GET_BCMENU2_UNITS_CONSTANTS_ENUM_L_100KM;
    public static final int GET_BCMENU2_UNITS_CONSTANTS_ENUM_KM_L;
    public static final int GET_BCMENU2_UNITS_CONSTANTS_ENUM_MPG_US;
    public static final int GET_BCMENU2_UNITS_CONSTANTS_ENUM_MPG_UK;
    public static final int GET_BCMENU2_UNITS_CONSTANTS_ENUM_L_H;
    public static final int GET_BCMENU2_UNITS_CONSTANTS_ENUM_NONE;
    public static final int GET_BCMENU2_UNITS_CONSTANTS_ENUM_KG_100KM;
    public static final int GET_BCMENU2_UNITS_CONSTANTS_ENUM_KM_KG;
    public static final int GET_BCMENU2_UNITS_CONSTANTS_ENUM_M3_100KM;
    public static final int GET_BCMENU2_UNITS_CONSTANTS_ENUM_KM_M3;
    public static final int GET_BCMENU2_UNITS_CONSTANTS_ENUM_GALLON_H;
    public static final int GET_BCMENU2_UNITS_CONSTANTS_ENUM_KG_H;
    public static final int GET_BCMENU2_UNITS_CONSTANTS_ENUM_M3_H;
    public static final int GET_BCMENU2_UNITS_CONSTANTS_ENUM_MPLBS;
    public static final int GET_BCMENU2_UNITS_CONSTANTS_ENUM_LBS_H;
    public static final int GET_BCMENU2_UNITS_CONSTANTS_ENUM_MPY;
    public static final int GET_BCMENU2_UNITS_CONSTANTS_ENUM_Y3H;
    public static final int GET_BCMENU2_UNITS_CONSTANTS_ENUM_KWH_100KM;
    public static final int GET_BCMENU2_UNITS_CONSTANTS_ENUM_KM_KWH;
    public static final int GET_BCMENU2_UNITS_CONSTANTS_ENUM_KWH_M;
    public static final int GET_BCMENU2_UNITS_CONSTANTS_ENUM_M_KWH;
    public static final int GET_BCMENU2_UNITS_CONSTANTS_ENUM_KW;
    public static final int GET_BCMENU2_UNITS_CONSTANTS_ENUM_M_KG;
    public static final int GET_BCMENU2_UNITS_CONSTANTS_ENUM_M_M3;
    public static final int GET_BCMENU2_UNITS_CONSTANTS_ENUM_MPGE_US;
    public static final int GET_BCMENU3_UNITS_CONSTANTS_ENUM_KM;
    public static final int GET_BCMENU3_UNITS_CONSTANTS_ENUM_MILES;
    public static final int GET_BCMENU3_UNITS_CONSTANTS_ENUM_H;
    public static final int GET_BCMENU3_UNITS_CONSTANTS_ENUM_KM_H;
    public static final int GET_BCMENU3_UNITS_CONSTANTS_ENUM_MPH;
    public static final int GET_BCMENU3_UNITS_CONSTANTS_ENUM_L_100KM;
    public static final int GET_BCMENU3_UNITS_CONSTANTS_ENUM_KM_L;
    public static final int GET_BCMENU3_UNITS_CONSTANTS_ENUM_MPG_US;
    public static final int GET_BCMENU3_UNITS_CONSTANTS_ENUM_MPG_UK;
    public static final int GET_BCMENU3_UNITS_CONSTANTS_ENUM_L_H;
    public static final int GET_BCMENU3_UNITS_CONSTANTS_ENUM_NONE;
    public static final int GET_BCMENU3_UNITS_CONSTANTS_ENUM_KG_100KM;
    public static final int GET_BCMENU3_UNITS_CONSTANTS_ENUM_KM_KG;
    public static final int GET_BCMENU3_UNITS_CONSTANTS_ENUM_M3_100KM;
    public static final int GET_BCMENU3_UNITS_CONSTANTS_ENUM_KM_M3;
    public static final int GET_BCMENU3_UNITS_CONSTANTS_ENUM_GALLON_H;
    public static final int GET_BCMENU3_UNITS_CONSTANTS_ENUM_KG_H;
    public static final int GET_BCMENU3_UNITS_CONSTANTS_ENUM_M3_H;
    public static final int GET_BCMENU3_UNITS_CONSTANTS_ENUM_MPLBS;
    public static final int GET_BCMENU3_UNITS_CONSTANTS_ENUM_LBS_H;
    public static final int GET_BCMENU3_UNITS_CONSTANTS_ENUM_MPY;
    public static final int GET_BCMENU3_UNITS_CONSTANTS_ENUM_Y3H;
    public static final int GET_BCMENU3_UNITS_CONSTANTS_ENUM_KWH_100KM;
    public static final int GET_BCMENU3_UNITS_CONSTANTS_ENUM_KM_KWH;
    public static final int GET_BCMENU3_UNITS_CONSTANTS_ENUM_KWH_M;
    public static final int GET_BCMENU3_UNITS_CONSTANTS_ENUM_M_KWH;
    public static final int GET_BCMENU3_UNITS_CONSTANTS_ENUM_KW;
    public static final int GET_BCMENU3_UNITS_CONSTANTS_ENUM_M_KG;
    public static final int GET_BCMENU3_UNITS_CONSTANTS_ENUM_M_M3;
    public static final int GET_BCMENU3_UNITS_CONSTANTS_ENUM_MPGE_US;
    public static final boolean GET_MODE_ENUM_BEV;
    public static final boolean GET_MODE_ENUM_PHEV;
    public static final int GET_PRIMARY_ENGINE_TYPE_ENUM_NONE;
    public static final int GET_PRIMARY_ENGINE_TYPE_ENUM_GASOLINE_DIESEL;
    public static final int GET_PRIMARY_ENGINE_TYPE_ENUM_CNG;
    public static final int GET_PRIMARY_ENGINE_TYPE_ENUM_ELECTRO;
    public static final int GET_PRIMARY_ENGINE_TYPE_ENUM_LPG;
    public static final int GET_SECONDARY_ENGINE_TYPE_ENUM_NONE;
    public static final int GET_SECONDARY_ENGINE_TYPE_ENUM_GASOLINE_DIESEL;
    public static final int GET_SECONDARY_ENGINE_TYPE_ENUM_CNG;
    public static final int GET_SECONDARY_ENGINE_TYPE_ENUM_ELECTRO;
    public static final int GET_SECONDARY_ENGINE_TYPE_ENUM_LPG;

    public void _update_getBCMenu1UnitsConstants(int n) {
    }

    public void _update_getBCMenu2UnitsConstants(int n) {
    }

    public void _update_getBCMenu3UnitsConstants(int n) {
    }

    public void _update_getMode(boolean bl) {
    }

    public void _update_getPrimaryEngineType(int n) {
    }

    public void _update_getSecondaryEngineType(int n) {
    }

    public void _update_getBCMenu1(int[] nArray, int[] nArray2, int[] nArray3) {
    }

    public void _update_getBCMenu2(int[] nArray, int[] nArray2, int[] nArray3) {
    }

    public void _update_getBCMenu3(int[] nArray, int[] nArray2, int[] nArray3) {
    }

    public void _update_getFunctionAvailabilities(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
    }
}

