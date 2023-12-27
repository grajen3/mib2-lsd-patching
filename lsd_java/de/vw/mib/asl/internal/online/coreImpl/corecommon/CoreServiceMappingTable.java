/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreImpl.corecommon;

import de.vw.mib.asl.internal.online.coreImpl.corecommon.OnlineDataMapImpl;
import de.vw.mib.asl.internal.online.coreImpl.corecommon.collection.OnlineDataMap;
import de.vw.mib.collections.ObjectArrayList;
import de.vw.mib.collections.ObjectIntOptHashMap;
import de.vw.mib.collections.ObjectObjectOptHashMap;
import de.vw.mib.collections.ints.IntArrayList;
import de.vw.mib.collections.ints.IntIntOptHashMap;
import de.vw.mib.util.Util;
import java.util.Iterator;

public final class CoreServiceMappingTable {
    public static final String SERVICE_ID_1000_OWNER_VERIFICATION;
    public static final String SERVICE_ID_1001_TRAFFIC_ONLINE_V1;
    public static final String SERVICE_ID_1002_TRAFFIC_MINIMAP;
    public static final String SERVICE_ID_1003_PERSONALPOI_V1;
    public static final String SERVICE_ID_1004_POI_V2;
    public static final String SERVICE_ID_1005_PARKINFO_V1;
    public static final String SERVICE_ID_1006_FPI_V2;
    public static final String SERVICE_ID_1007_POI_ECHARGE;
    public static final String SERVICE_ID_1008_POIVOICE_V1;
    public static final String SERVICE_ID_1009_ZIELEINSPEISUNG_V2;
    public static final String SERVICE_ID_10010_TOURIMPORT_V1;
    public static final String SERVICE_ID_10011_CC_BREAKDOWN_V2;
    public static final String SERVICE_ID_10012_CCPOI_V1;
    public static final String SERVICE_ID_10013_STREETVIEW_V1;
    public static final String SERVICE_ID_10014_SATELLITEMAPS_V1;
    public static final String SERVICE_ID_10015_MENU_V2;
    public static final String SERVICE_ID_10016_GRACENOTE_V1;
    public static final String SERVICE_ID_10019_OTACUNAV_V1;
    public static final String SERVICE_ID_10020_OTACUPPOI_V1;
    public static final String SERVICE_ID_10021_DEALERAPPOINT_V1;
    public static final String SERVICE_ID_10022_DWAP;
    public static final String SERVICE_ID_10023_GEOFENCE_V1;
    public static final String SERVICE_ID_10024_INFOCALL_V1;
    public static final String SERVICE_ID_10026_RBATTERYCHARGE_V1;
    public static final String SERVICE_ID_10027_RCLIMA_V1;
    public static final String SERVICE_ID_10028_RHEATING_V1;
    public static final String SERVICE_ID_10029_RHONK_V1;
    public static final String SERVICE_ID_10030_RLU_V1;
    public static final String SERVICE_ID_10031_SPEEDALERT_V1;
    public static final String SERVICE_ID_10032_TIMERPROGRAMMING_V1;
    public static final String SERVICE_ID_10033_TRIP_STATISTIC_V1;
    public static final String SERVICE_ID_10035_VEHICLEHEALTH_V1;
    public static final String SERVICE_ID_10036_VEHICLETELEMETRY_V1;
    public static final String SERVICE_ID_10037_CARFINDER_V1;
    public static final String SERVICE_ID_10038_ECALL_V1;
    public static final String SERVICE_ID_10039_GASSTATIONS_V1;
    public static final String SERVICE_ID_10041_ONLINERADIODATA_V1;
    public static final String SERVICE_ID_10042_HYBRIDRADIODATA_V1;
    public static final String SERVICE_ID_10043_HYBRIDRADIORANGE_V1;
    public static final String SERVICE_ID_10044_INCAR_ENROLLMENT_V1;
    public static final String SERVICE_ID_10045_ONLINESPEECH_V1;
    public static final String SERVICE_ID_10046_WEATHER_V2;
    public static final String SERVICE_ID_10047_DATAPLAN_V1;
    public static final String SERVICE_ID_10048_CC_BREAKDOWNAUTOMATIC_V1;
    public static final String SERVICE_ID_10049_DAL_V1;
    public static final String SERVICE_ID_10050_VALETALERT_V1;
    public static final String SERVICE_ID_10051_UOTA_V1;
    public static final String SERVICE_ID_10052_NEWS_V2;
    public static final String SERVICE_ID_10053_ROUTING_V1;
    public static final String SERVICE_ID_10054_CITYMODELS_V1;
    public static final String SERVICE_ID_10055_MVSGEO_V1;
    public static final String SERVICE_ID_10056_DRIVEREFFICIENCY_V1;
    public static final String SERVICE_ID_10058_TIMEFENCE_V1;
    public static final String SERVICE_ID_10059_ATTERY;
    public static final String SERVICE_ID_10060_JOBS_V1;
    public static final String SERVICE_ID_10061_SERVICES_V1;
    public static final String SERVICE_ID_10062_DEVICERESET_V1;
    public static final String SERVICE_ID_10063_PRIMARYUSER_V1;
    public static final String SERVICE_ID_10064_VEHICLEUSERS_V1;
    public static final String SERVICE_ID_10065_POWERMANAGEMENTCONF_V1;
    public static final String SERVICE_ID_10066_COMMUNICATIONCONF_V1;
    public static final String SERVICE_ID_10067_DOWNLOADSERV_V1;
    public static final String SERVICE_ID_10069_ONLINERADIODETAILS_V1;
    public static final String SERVICE_ID_10070_TRAFFIC_ONLINE_V2;
    public static final String SERVICE_ID_10071_SATELLITEMAPS_V2;
    private static ObjectArrayList _onlineDataMap;
    private static ObjectIntOptHashMap _serviceIDToNumericID;
    private static ObjectObjectOptHashMap _serviceIDToServiceName;
    private static ObjectObjectOptHashMap _serviceIDToGroup;
    private static ObjectIntOptHashMap _serviceIDInvisible;
    private static IntIntOptHashMap _groupToCategory;

    public static String getServiceIDWithModelID(int n, int n2) {
        Iterator iterator = _onlineDataMap.iterator();
        while (iterator.hasNext()) {
            OnlineDataMap onlineDataMap = (OnlineDataMap)iterator.next();
            if (onlineDataMap.getServiceNumericID() != n) continue;
            if (onlineDataMap.getVersion() == n2) {
                return onlineDataMap.getServiceID();
            }
            if (n2 != 0 || onlineDataMap.getVersion() != 1) continue;
            return onlineDataMap.getServiceID();
        }
        return "";
    }

    public static String getServiceIDWithModelID(int n) {
        return CoreServiceMappingTable.getServiceIDWithModelID(n, 0);
    }

    public static int getModelIDWithServiceID(String string, int n) {
        return _serviceIDToNumericID.containsKey(string) ? _serviceIDToNumericID.get(string) : 0;
    }

    public static int getModelIDWithServiceID(String string) {
        return CoreServiceMappingTable.getModelIDWithServiceID(string, 0);
    }

    public static String getServiceNameWithServiceID(String string) {
        return _serviceIDToServiceName.containsKey(string) ? (String)_serviceIDToServiceName.get(string) : "";
    }

    public static String getServiceIDWithServiceName(String string) {
        return CoreServiceMappingTable.getServiceIDWithServiceName(string, 0);
    }

    public static String getServiceIDWithServiceName(String string, int n) {
        Iterator iterator = _onlineDataMap.iterator();
        while (iterator.hasNext()) {
            OnlineDataMap onlineDataMap = (OnlineDataMap)iterator.next();
            if (Util.isNullOrEmpty(string) || !onlineDataMap.getServiceName().equalsIgnoreCase(string)) continue;
            if (onlineDataMap.getVersion() == n) {
                return onlineDataMap.getServiceID();
            }
            if (n != 0 || onlineDataMap.getVersion() != 1) continue;
            return onlineDataMap.getServiceID();
        }
        return "";
    }

    public static boolean isServiceInvisible(String string) {
        return _serviceIDInvisible.containsKey(string) ? _serviceIDInvisible.get(string) > 0 : false;
    }

    public static boolean isValidService(String string) {
        return !Util.isNullOrEmpty(string) && _serviceIDToNumericID.containsKey(string);
    }

    public static int[] getGroupWithServiceID(String string) {
        int[] nArray;
        if (Util.isNullOrEmpty(string)) {
            int[] nArray2 = new int[1];
            nArray = nArray2;
            nArray2[0] = -1;
        } else {
            nArray = (int[])_serviceIDToGroup.get(string);
        }
        return nArray;
    }

    public static int[] getCategoriesWithServiceID(String string) {
        int[] nArray;
        int n;
        if (_serviceIDToGroup.containsKey(string) && (n = (nArray = (int[])_serviceIDToGroup.get(string)).length) > 0) {
            int[] nArray2 = new int[n];
            for (int i2 = 0; i2 < n; ++i2) {
                nArray2[i2] = _groupToCategory.get(nArray[i2]);
            }
            return nArray2;
        }
        return new int[0];
    }

    public static int getCategoryWithGroup(int n) {
        return n < 0 ? -1 : _groupToCategory.get(n);
    }

    public static int[] getGroupsWithCategory(int n) {
        IntArrayList intArrayList = new IntArrayList();
        if (!_groupToCategory.isEmpty()) {
            Iterator iterator = _groupToCategory.entryIterator();
            while (iterator.hasNext()) {
                int n2 = (Integer)iterator.next();
                int n3 = _groupToCategory.get(n2);
                if (n3 != n) continue;
                intArrayList.add(n2);
            }
        }
        return intArrayList.toArray(new int[intArrayList.size()]);
    }

    public static int convertToInternalResultType(int n) {
        int n2 = -1;
        switch (n) {
            case 0: {
                n2 = 0;
                break;
            }
            case 1: {
                n2 = 1;
                break;
            }
            case 2: {
                n2 = 2;
                break;
            }
            case 3: {
                n2 = 3;
                break;
            }
            case 4: {
                n2 = 4;
                break;
            }
            case 5: {
                n2 = 5;
                break;
            }
            case 6: {
                n2 = 6;
                break;
            }
            case 7: {
                n2 = 7;
                break;
            }
            case 8: {
                n2 = 8;
                break;
            }
            case 9: {
                n2 = 9;
                break;
            }
            case 10: {
                n2 = 10;
                break;
            }
            case 11: {
                n2 = 11;
                break;
            }
            case 12: {
                n2 = 12;
                break;
            }
            case 13: {
                n2 = 13;
                break;
            }
            case 14: {
                n2 = 14;
                break;
            }
            case 15: {
                n2 = 15;
                break;
            }
            case 16: {
                n2 = 16;
                break;
            }
            case 17: {
                n2 = 17;
                break;
            }
            case 18: {
                n2 = 18;
                break;
            }
            case 19: {
                n2 = 19;
                break;
            }
            case 20: {
                n2 = 20;
                break;
            }
            case 21: {
                n2 = 21;
                break;
            }
            case 22: {
                n2 = 22;
                break;
            }
            case 23: {
                n2 = 23;
                break;
            }
            case 24: {
                n2 = 24;
                break;
            }
            case 25: {
                n2 = 25;
                break;
            }
            case 26: {
                n2 = 26;
                break;
            }
            case 27: {
                n2 = 27;
                break;
            }
            case 28: {
                n2 = 28;
                break;
            }
            case 29: {
                n2 = 29;
                break;
            }
            case 30: {
                n2 = 30;
                break;
            }
            case 31: {
                n2 = 51;
                break;
            }
            case 32: {
                n2 = 52;
                break;
            }
            case 33: {
                n2 = 53;
                break;
            }
            case 34: {
                n2 = 54;
                break;
            }
            case 35: {
                n2 = 55;
                break;
            }
            case 36: {
                n2 = 56;
                break;
            }
            case 37: {
                n2 = 57;
                break;
            }
        }
        return n2;
    }

    public static int convertToInternalOwnerVerificationResult(int n) {
        int n2 = -1;
        switch (n) {
            case 0: {
                n2 = 0;
                break;
            }
            case 1: {
                n2 = 33;
                break;
            }
            case 7: {
                n2 = 38;
                break;
            }
            case 2: {
                n2 = 34;
                break;
            }
            case 3: 
            case 29: {
                n2 = 35;
                break;
            }
            case 4: {
                n2 = 36;
                break;
            }
            case 6: {
                n2 = 37;
                break;
            }
        }
        return n2;
    }

    public static int convertToExternalOwnerVerificationResult(int n) {
        int n2 = 3;
        switch (n) {
            case 0: {
                n2 = 0;
                break;
            }
            case 33: {
                n2 = 1;
                break;
            }
            case 38: {
                n2 = 6;
                break;
            }
            case 34: {
                n2 = 2;
                break;
            }
            case 35: {
                n2 = 3;
                break;
            }
            case 36: {
                n2 = 4;
                break;
            }
            case 37: {
                n2 = 5;
                break;
            }
        }
        return n2;
    }

    public static int convertDownloadResult(int n) {
        int n2 = -1;
        switch (n) {
            case 1: {
                n2 = 0;
                break;
            }
            case 9: {
                n2 = 47;
                break;
            }
            case 10: {
                n2 = 48;
                break;
            }
            case 11: {
                n2 = 49;
                break;
            }
            case 7: {
                n2 = 45;
                break;
            }
            case 2: {
                n2 = 40;
                break;
            }
            case 4: {
                n2 = 42;
                break;
            }
            case 5: {
                n2 = 43;
                break;
            }
            case 3: {
                n2 = 41;
                break;
            }
            case 6: {
                n2 = 44;
                break;
            }
            case 8: {
                n2 = 46;
                break;
            }
        }
        return n2;
    }

    public static int getInternalLicenseState(int n, int n2) {
        int n3 = 0;
        if (n2 == 1) {
            switch (n) {
                case 0: {
                    n3 = 3;
                    break;
                }
                case 1: {
                    n3 = 2;
                    break;
                }
                case 2: {
                    n3 = 1;
                    break;
                }
                case 3: {
                    n3 = 4;
                    break;
                }
                case 4: {
                    n3 = 5;
                    break;
                }
                case 5: {
                    n3 = 6;
                    break;
                }
            }
        } else {
            switch (n) {
                case 1: {
                    n3 = 1;
                    break;
                }
                case 2: {
                    n3 = 2;
                    break;
                }
                case 3: {
                    n3 = 3;
                    break;
                }
                case 4: {
                    n3 = 4;
                    break;
                }
                case 5: {
                    n3 = 5;
                    break;
                }
                case 6: {
                    n3 = 6;
                    break;
                }
                case 7: {
                    n3 = 7;
                    break;
                }
                case 8: {
                    n3 = 8;
                    break;
                }
                default: {
                    n3 = 3;
                }
            }
        }
        return n3;
    }

    public static int getOnlineUserTypeWithUserType(int n) {
        switch (n) {
            case 0: {
                return 1;
            }
            case 1: {
                return 2;
            }
        }
        return 0;
    }

    public static int[] getPrivacyGroup(int n) {
        IntArrayList intArrayList = new IntArrayList();
        if (Util.isBitSet(1, n)) {
            intArrayList.add(2);
        }
        if (Util.isBitSet(2, n)) {
            intArrayList.add(3);
        }
        if (Util.isBitSet(4, n)) {
            intArrayList.add(6);
        }
        if (Util.isBitSet(8, n)) {
            intArrayList.add(4);
        }
        if (Util.isBitSet(16, n)) {
            intArrayList.add(5);
        }
        intArrayList.add(0);
        return intArrayList.toArray(new int[intArrayList.size()]);
    }

    public static boolean isServiceStateAvailable(int n) {
        return n == 0 || n == 1;
    }

    static {
        _onlineDataMap = new ObjectArrayList();
        _serviceIDToNumericID = new ObjectIntOptHashMap();
        _serviceIDToServiceName = new ObjectObjectOptHashMap();
        _serviceIDToGroup = new ObjectObjectOptHashMap();
        _serviceIDInvisible = new ObjectIntOptHashMap();
        _groupToCategory = new IntIntOptHashMap();
        _onlineDataMap.add(new OnlineDataMapImpl("owner_v1", 0, "owner", new int[]{-1}, new int[]{0}, true, 1));
        _onlineDataMap.add(new OnlineDataMapImpl("traffic-online_v1", 1, "onlinetraffic", new int[]{0}, new int[]{0}, false, 1));
        _onlineDataMap.add(new OnlineDataMapImpl("traffic_minimap", 2, "traffic_minimap", new int[]{0}, new int[]{0}, false, 1));
        _onlineDataMap.add(new OnlineDataMapImpl("personalpoi_v1", 3, "personalpoi", new int[]{0}, new int[]{0}, false, 1));
        _onlineDataMap.add(new OnlineDataMapImpl("poi_v2", 4, "poi-search", new int[]{0}, new int[]{0}, false, 1));
        _onlineDataMap.add(new OnlineDataMapImpl("parkinfo_v1", 5, "parkinfo", new int[]{0}, new int[]{0}, false, 1));
        _onlineDataMap.add(new OnlineDataMapImpl("fpi_v2", 6, "poi_gasstations", new int[]{0}, new int[]{0}, false, 1));
        _onlineDataMap.add(new OnlineDataMapImpl("poi-echarge", 7, "poi-echarge", new int[]{0}, new int[]{0}, false, 1));
        _onlineDataMap.add(new OnlineDataMapImpl("poivoice_v1", 8, "poivoice", new int[]{0}, new int[]{0}, false, 1));
        _onlineDataMap.add(new OnlineDataMapImpl("zieleinspeisung_v2", 9, "destination-import", new int[]{0}, new int[]{0}, false, 1));
        _onlineDataMap.add(new OnlineDataMapImpl("tourimport_v1", 10, "tourimport", new int[]{0}, new int[]{0}, false, 1));
        _onlineDataMap.add(new OnlineDataMapImpl("cc_breakdown_v2", 11, "cc_breakdown", new int[]{1}, new int[]{0}, false, 1));
        _onlineDataMap.add(new OnlineDataMapImpl("ccpoi_v1", 12, "ccpoi", new int[]{0}, new int[]{0}, false, 1));
        _onlineDataMap.add(new OnlineDataMapImpl("streetview_v1", 13, "streetview", new int[]{0}, new int[]{0}, false, 1));
        _onlineDataMap.add(new OnlineDataMapImpl("satellitemaps_v1", 14, "satellitemaps", new int[]{0}, new int[]{0}, false, 1));
        _onlineDataMap.add(new OnlineDataMapImpl("menu_v2", 15, "menu", new int[]{0}, new int[]{0}, false, 1));
        _onlineDataMap.add(new OnlineDataMapImpl("gracenote_v1", 16, "gracenote", new int[]{0}, new int[]{0}, false, 1));
        _onlineDataMap.add(new OnlineDataMapImpl("otacunav_v1", 19, "otacunav", new int[]{0}, new int[]{0}, false, 1));
        _onlineDataMap.add(new OnlineDataMapImpl("otacuppoi_v1", 20, "otacuppoi", new int[]{0}, new int[]{0}, false, 1));
        _onlineDataMap.add(new OnlineDataMapImpl("dealerappoint_v1", 21, "dealerappoint", new int[]{1}, new int[]{0}, false, 1));
        _onlineDataMap.add(new OnlineDataMapImpl("dwap", 22, "dwap", new int[]{1}, new int[]{0}, false, 1));
        _onlineDataMap.add(new OnlineDataMapImpl("geofence_v1", 23, "geofence", new int[]{1}, new int[]{0}, false, 1));
        _onlineDataMap.add(new OnlineDataMapImpl("infocall_v1", 24, "infocall", new int[]{1}, new int[]{0}, false, 1));
        _onlineDataMap.add(new OnlineDataMapImpl("rbatterycharge_v1", 26, "rbatterycharge", new int[]{1}, new int[]{0}, false, 1));
        _onlineDataMap.add(new OnlineDataMapImpl("rclima_v1", 27, "rclima", new int[]{1}, new int[]{0}, false, 1));
        _onlineDataMap.add(new OnlineDataMapImpl("rheating_v1", 28, "rheating", new int[]{1}, new int[]{0}, false, 1));
        _onlineDataMap.add(new OnlineDataMapImpl("rhonk_v1", 29, "rhonk", new int[]{1}, new int[]{0}, false, 1));
        _onlineDataMap.add(new OnlineDataMapImpl("rlu_v1", 30, "rlu", new int[]{1}, new int[]{0}, false, 1));
        _onlineDataMap.add(new OnlineDataMapImpl("speedalert_v1", 31, "speedalert", new int[]{1}, new int[]{0}, false, 1));
        _onlineDataMap.add(new OnlineDataMapImpl("timerprogramming_v1", 32, "timerprogramming", new int[]{1}, new int[]{0}, false, 1));
        _onlineDataMap.add(new OnlineDataMapImpl("trip_statistic_v1", 33, "trip_statistic", new int[]{1}, new int[]{0}, false, 1));
        _onlineDataMap.add(new OnlineDataMapImpl("vehiclehealth_v1", 35, "vehiclehealth", new int[]{1}, new int[]{0}, false, 1));
        _onlineDataMap.add(new OnlineDataMapImpl("vehicletelemetry_v1", 36, "vehicletelemetry", new int[]{1}, new int[]{0}, false, 1));
        _onlineDataMap.add(new OnlineDataMapImpl("carfinder_v1", 37, "carfinder", new int[]{1}, new int[]{0}, false, 1));
        _onlineDataMap.add(new OnlineDataMapImpl("ecall_v1", 38, "ecall", new int[]{1}, new int[]{0}, false, 1));
        _onlineDataMap.add(new OnlineDataMapImpl("gasstations_v1", 39, "fpi", new int[]{0}, new int[]{0}, false, 1));
        _onlineDataMap.add(new OnlineDataMapImpl("onlineradiodata_v1", 41, "onlineradiodata", new int[]{0}, new int[]{0}, false, 1));
        _onlineDataMap.add(new OnlineDataMapImpl("hybridradiodata_v1", 42, "hybridradiostream", new int[]{0}, new int[]{0}, false, 1));
        _onlineDataMap.add(new OnlineDataMapImpl("hybridradiorange_v1", 43, "hybridradioapi", new int[]{0}, new int[]{0}, false, 1));
        _onlineDataMap.add(new OnlineDataMapImpl("incar_enrollment_v1", 44, "incarenrollment", new int[]{0}, new int[]{0}, false, 1));
        _onlineDataMap.add(new OnlineDataMapImpl("onlinespeech_v1", 45, "speechnews", new int[]{0}, new int[]{0}, false, 1));
        _onlineDataMap.add(new OnlineDataMapImpl("weather_v2", 46, "weather", new int[]{0}, new int[]{0}, false, 1));
        _onlineDataMap.add(new OnlineDataMapImpl("dataplan_v1", 47, "dataplan", new int[]{1}, new int[]{0}, false, 1));
        _onlineDataMap.add(new OnlineDataMapImpl("cc_breakdownAutomatic_v1", 48, "ccVreakdown", new int[]{1}, new int[]{0}, false, 1));
        _onlineDataMap.add(new OnlineDataMapImpl("dal_v1", 49, "dal", new int[]{1}, new int[]{0}, false, 1));
        _onlineDataMap.add(new OnlineDataMapImpl("valetalert_v1", 50, "valetalert", new int[]{1}, new int[]{0}, false, 1));
        _onlineDataMap.add(new OnlineDataMapImpl("uota_v1", 51, "ocuUota", new int[]{1}, new int[]{0}, false, 1));
        _onlineDataMap.add(new OnlineDataMapImpl("news_v2", 52, "news", new int[]{0}, new int[]{0}, false, 1));
        _onlineDataMap.add(new OnlineDataMapImpl("routing_v1", 53, "routing", new int[]{1}, new int[]{0}, false, 1));
        _onlineDataMap.add(new OnlineDataMapImpl("citymodels_v1", 54, "3dcitymodel", new int[]{0}, new int[]{0}, false, 1));
        _onlineDataMap.add(new OnlineDataMapImpl("mvsGeo_v1", 55, "mvsGeo", new int[]{1}, new int[]{0}, false, 1));
        _onlineDataMap.add(new OnlineDataMapImpl("driverefficiency_v1", 56, "driverefficiency", new int[]{1}, new int[]{0}, false, 1));
        _onlineDataMap.add(new OnlineDataMapImpl("timefence_v1", 58, "timefence", new int[]{1}, new int[]{0}, false, 1));
        _onlineDataMap.add(new OnlineDataMapImpl("attery", 0, "attery", new int[]{1}, new int[]{0}, false, 1));
        _onlineDataMap.add(new OnlineDataMapImpl("jobs_v1", 0, "jobs", new int[]{1}, new int[]{0}, true, 1));
        _onlineDataMap.add(new OnlineDataMapImpl("services_v1", 0, "services", new int[]{1}, new int[]{0}, true, 1));
        _onlineDataMap.add(new OnlineDataMapImpl("devicereset_v1", 0, "devicereset", new int[]{1}, new int[]{0}, true, 1));
        _onlineDataMap.add(new OnlineDataMapImpl("primaryuser_v1", 0, "primaryuser", new int[]{1}, new int[]{0}, true, 1));
        _onlineDataMap.add(new OnlineDataMapImpl("vehicleusers_v1", 0, "vehicleusers", new int[]{1}, new int[]{0}, true, 1));
        _onlineDataMap.add(new OnlineDataMapImpl("powerManagementConf_v1", 0, "powerManagementConf", new int[]{1}, new int[]{0}, true, 1));
        _onlineDataMap.add(new OnlineDataMapImpl("communicationConf_v1", 0, "communicationConf", new int[]{1}, new int[]{0}, true, 1));
        _onlineDataMap.add(new OnlineDataMapImpl("download-srv_v1", 0, "download-service", new int[]{1}, new int[]{0}, true, 1));
        _onlineDataMap.add(new OnlineDataMapImpl("traffic-online_v2", 1, "onlinetraffic", new int[]{0}, new int[]{0}, false, 2));
        _onlineDataMap.add(new OnlineDataMapImpl("satellitemaps_v2", 14, "satellitemaps", new int[]{0}, new int[]{0}, false, 2));
        _groupToCategory.put(-1, -1);
        _groupToCategory.put(0, 0);
        _groupToCategory.put(1, 0);
        _groupToCategory.put(2, 1);
        _groupToCategory.put(3, 1);
        _groupToCategory.put(4, 1);
        _groupToCategory.put(5, 1);
        _groupToCategory.put(6, 1);
        Iterator iterator = _onlineDataMap.iterator();
        while (iterator.hasNext()) {
            OnlineDataMap onlineDataMap = (OnlineDataMap)iterator.next();
            _serviceIDToNumericID.put(onlineDataMap.getServiceID(), onlineDataMap.getServiceNumericID());
            _serviceIDToServiceName.put(onlineDataMap.getServiceID(), onlineDataMap.getServiceName());
            _serviceIDToGroup.put(onlineDataMap.getServiceID(), onlineDataMap.getServiceGroup());
            _serviceIDInvisible.put(onlineDataMap.getServiceID(), onlineDataMap.isServiceInvisible() ? 1 : 0);
        }
    }
}

