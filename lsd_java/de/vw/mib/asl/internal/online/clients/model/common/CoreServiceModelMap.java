/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.clients.model.common;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.online.coreImpl.corecommon.CoreServiceMappingTable;
import de.vw.mib.log4mib.LogMessage;

public final class CoreServiceModelMap {
    public static final int INVALID_VALUE;
    public static final int RESULT_TYPE_PIN_VALIDATION;
    public static final int RESULT_TYPE_USER_VERIFICATION;
    public static final int RESULT_TYPE_SERVICE_STATUS;
    private static boolean _uotaServiceReady;

    public static int getServiceIDInteger(String string) {
        return CoreServiceMappingTable.getModelIDWithServiceID(string);
    }

    public static String getServiceIDString(int n) {
        return CoreServiceMappingTable.getServiceIDWithModelID(n);
    }

    public static int getModelLicenseState(int n) {
        int n2 = 1;
        switch (n) {
            case 1: {
                n2 = 1;
                break;
            }
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: {
                n2 = 0;
                break;
            }
            case 0: 
            case 8: {
                n2 = 2;
                break;
            }
        }
        return n2;
    }

    public static int convertToInternalOwnerVerificationResult(int n) {
        int n2 = 35;
        switch (n) {
            case 0: {
                n2 = 0;
                break;
            }
            case 1: {
                n2 = 33;
                break;
            }
            case 6: {
                n2 = 38;
                break;
            }
            case 2: {
                n2 = 34;
                break;
            }
            case 3: {
                n2 = 35;
                break;
            }
            case 4: {
                n2 = 36;
                break;
            }
            case 5: {
                n2 = 37;
                break;
            }
        }
        return n2;
    }

    public static int getModelResult(int n, int n2) {
        int n3 = -1;
        block0 : switch (n2) {
            case 0: {
                switch (n) {
                    case 0: {
                        n3 = 585;
                        break block0;
                    }
                    case 33: {
                        n3 = 584;
                        break block0;
                    }
                    case 34: {
                        n3 = 1593643776;
                        break block0;
                    }
                    case 35: {
                        n3 = 583;
                        break block0;
                    }
                    case 36: {
                        n3 = 1627198208;
                        break block0;
                    }
                    case 37: {
                        n3 = 1643975424;
                        break block0;
                    }
                    case 38: {
                        n3 = 1610420992;
                        break block0;
                    }
                }
                break;
            }
            case 1: {
                switch (n) {
                    case 0: {
                        n3 = 585;
                        break block0;
                    }
                    case 33: {
                        n3 = 584;
                        break block0;
                    }
                    case 34: {
                        n3 = 583;
                        break block0;
                    }
                    case 35: {
                        n3 = 583;
                        break block0;
                    }
                    case 36: {
                        n3 = 583;
                        break block0;
                    }
                    case 37: {
                        n3 = 583;
                        break block0;
                    }
                    case 38: {
                        n3 = 583;
                        break block0;
                    }
                }
                break;
            }
            case 2: {
                switch (n) {
                    case 0: {
                        n3 = 579;
                        break block0;
                    }
                    case 10: {
                        n3 = 577;
                        break block0;
                    }
                    case 11: {
                        n3 = 972886784;
                        break block0;
                    }
                    case 7: {
                        n3 = 577;
                        break block0;
                    }
                    case 23: {
                        n3 = 972886784;
                        break block0;
                    }
                    case 8: {
                        n3 = 577;
                        break block0;
                    }
                }
                break;
            }
        }
        return n3;
    }

    public static String getServiceIDWithPreCheckID(int n, int n2) {
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(".getServiceIDWithPreCheckID(").append(n).append(", ").append(n2).append(" )").log();
        }
        switch (n) {
            case 1: {
                return "traffic-online_v1";
            }
            case 2: {
                if (n2 == 1) {
                    return "traffic-online_v1";
                }
                return "traffic_minimap";
            }
            case 3: {
                if (CoreServiceModelMap.getUotAServiceReady()) {
                    if (n2 == 1) {
                        return "otacuppoi_v1";
                    }
                    return "personalpoi_v1";
                }
                return "";
            }
            case 4: {
                return "poi_v2";
            }
            case 5: {
                return "parkinfo_v1";
            }
            case 6: {
                return "fpi_v2";
            }
            case 7: {
                return "poi-echarge";
            }
            case 8: {
                return "poivoice_v1";
            }
            case 9: {
                return "zieleinspeisung_v2";
            }
            case 10: {
                return "tourimport_v1";
            }
            case 11: {
                return "cc_breakdown_v2";
            }
            case 12: {
                return "ccpoi_v1";
            }
            case 13: {
                return "streetview_v1";
            }
            case 14: {
                return "satellitemaps_v1";
            }
            case 15: {
                return "menu_v2";
            }
            case 16: {
                return "gracenote_v1";
            }
            case 19: {
                if (CoreServiceModelMap.getUotAServiceReady()) {
                    return "otacunav_v1";
                }
                return "";
            }
            case 20: {
                if (CoreServiceModelMap.getUotAServiceReady()) {
                    return "otacuppoi_v1";
                }
                return "";
            }
            case 21: {
                return "dealerappoint_v1";
            }
            case 22: {
                return "dwap";
            }
            case 23: {
                return "geofence_v1";
            }
            case 24: {
                return "infocall_v1";
            }
            case 26: {
                return "rbatterycharge_v1";
            }
            case 27: {
                return "rclima_v1";
            }
            case 28: {
                return "rheating_v1";
            }
            case 29: {
                return "rhonk_v1";
            }
            case 30: {
                return "rlu_v1";
            }
            case 31: {
                return "speedalert_v1";
            }
            case 32: {
                return "timerprogramming_v1";
            }
            case 33: {
                return "trip_statistic_v1";
            }
            case 35: {
                return "vehiclehealth_v1";
            }
            case 36: {
                return "vehicletelemetry_v1";
            }
            case 37: {
                return "carfinder_v1";
            }
            case 38: {
                return "ecall_v1";
            }
            case 39: {
                return "gasstations_v1";
            }
            case 41: {
                return "onlineradiodata_v1";
            }
            case 42: {
                return "hybridradiodata_v1";
            }
            case 43: {
                return "hybridradiorange_v1";
            }
            case 44: {
                return "incar_enrollment_v1";
            }
            case 45: {
                return "onlinespeech_v1";
            }
            case 46: {
                return "weather_v2";
            }
            case 47: {
                return "dataplan_v1";
            }
            case 48: {
                return "cc_breakdownAutomatic_v1";
            }
            case 49: {
                return "dal_v1";
            }
            case 50: {
                return "valetalert_v1";
            }
            case 51: {
                return "uota_v1";
            }
            case 52: {
                return "news_v2";
            }
            case 53: {
                return "routing_v1";
            }
            case 54: {
                return "citymodels_v1";
            }
            case 55: {
                return "mvsGeo_v1";
            }
            case 56: {
                return "driverefficiency_v1";
            }
            case 58: {
                return "timefence_v1";
            }
        }
        return CoreServiceModelMap.getServiceIDString(n);
    }

    public static void setUotAServiceReady(boolean bl) {
        _uotaServiceReady = bl;
    }

    public static boolean getUotAServiceReady() {
        return _uotaServiceReady;
    }

    public static int getCategoryWithGroup(int n) {
        return CoreServiceMappingTable.getCategoryWithGroup(n);
    }

    public static int getModelPackageID(int n) {
        switch (n) {
            case 0: {
                return 0;
            }
            case 1: {
                return 1;
            }
            case 2: {
                return 0;
            }
            case 3: {
                return 1;
            }
            case 4: {
                return 2;
            }
            case 5: {
                return 3;
            }
            case 6: {
                return 4;
            }
        }
        return 0;
    }
}

