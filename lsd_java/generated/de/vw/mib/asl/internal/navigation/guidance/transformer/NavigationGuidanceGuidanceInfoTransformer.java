/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.guidance.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.navigation.guidance.transformer.NavigationGuidanceGuidanceInfoCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class NavigationGuidanceGuidanceInfoTransformer
extends ItemTransformerAdapter {
    public static final int NAVIGATION_GUIDANCE_GUIDANCE_INFO_ADD_INFO_STRING;
    public static final int NAVIGATION_GUIDANCE_GUIDANCE_INFO_CITY_STRING;
    public static final int NAVIGATION_GUIDANCE_GUIDANCE_INFO_CITY_REFINEMENT_STRING;
    public static final int NAVIGATION_GUIDANCE_GUIDANCE_INFO_COUNTRY_CODE_STRING;
    public static final int NAVIGATION_GUIDANCE_GUIDANCE_INFO_DTM_INTEGER;
    public static final int NAVIGATION_GUIDANCE_GUIDANCE_INFO_ETAD_INTEGER;
    public static final int NAVIGATION_GUIDANCE_GUIDANCE_INFO_ETAH_INTEGER;
    public static final int NAVIGATION_GUIDANCE_GUIDANCE_INFO_ETAM_INTEGER;
    public static final int NAVIGATION_GUIDANCE_GUIDANCE_INFO_HN_STRING;
    public static final int NAVIGATION_GUIDANCE_GUIDANCE_INFO_H_NOR_CROSSING_STRING;
    public static final int NAVIGATION_GUIDANCE_GUIDANCE_INFO_IS_FERRY_BOOLEAN;
    public static final int NAVIGATION_GUIDANCE_GUIDANCE_INFO_LENGTH_ON_HIGHWAYS_INTEGER;
    public static final int NAVIGATION_GUIDANCE_GUIDANCE_INFO_LENGTH_ON_TOLL_ROADS_INTEGER;
    public static final int NAVIGATION_GUIDANCE_GUIDANCE_INFO_NAME_STRING;
    public static final int NAVIGATION_GUIDANCE_GUIDANCE_INFO_POI_CATEGORY_STRING;
    public static final int NAVIGATION_GUIDANCE_GUIDANCE_INFO_POI_NAME_STRING;
    public static final int NAVIGATION_GUIDANCE_GUIDANCE_INFO_POI_PHONE_NUMBER_STRING;
    public static final int NAVIGATION_GUIDANCE_GUIDANCE_INFO_POI_URL_STRING;
    public static final int NAVIGATION_GUIDANCE_GUIDANCE_INFO_RTTH_INTEGER;
    public static final int NAVIGATION_GUIDANCE_GUIDANCE_INFO_RTTM_INTEGER;
    public static final int NAVIGATION_GUIDANCE_GUIDANCE_INFO_RTT_MILLISECONDS_INTEGER;
    public static final int NAVIGATION_GUIDANCE_GUIDANCE_INFOS_CROSSING_STRING;
    public static final int NAVIGATION_GUIDANCE_GUIDANCE_INFO_STREET_STRING;
    public static final int NAVIGATION_GUIDANCE_GUIDANCE_INFO_STREET_REFINEMENT_STRING;
    public static final int NAVIGATION_GUIDANCE_GUIDANCE_INFO_TYPE_INTEGER;
    public static final int NAVIGATION_GUIDANCE_GUIDANCE_INFO_ZIP_STRING;
    public static final int NAVIGATION_GUIDANCE_GUIDANCE_INFO_STOP_OVER_BOOLEAN;
    public static final int NAVIGATION_GUIDANCE_GUIDANCE_INFO_ICON_POI_RESOURCE_LOCATOR;
    public static final int NAVIGATION_GUIDANCE_CURRENT_DEST_DATA_LON_DEGREE_INTEGER;
    public static final int NAVIGATION_GUIDANCE_CURRENT_DEST_DATA_LON_MINUTES_INTEGER;
    public static final int NAVIGATION_GUIDANCE_CURRENT_DEST_DATA_LON_SECONDS_INTEGER;
    public static final int NAVIGATION_GUIDANCE_CURRENT_DEST_DATA_LAT_DEGREE_INTEGER;
    public static final int NAVIGATION_GUIDANCE_CURRENT_DEST_DATA_LAT_MINUTES_INTEGER;
    public static final int NAVIGATION_GUIDANCE_CURRENT_DEST_DATA_LAT_SECONDS_INTEGER;
    public static final int NAVIGATION_GUIDANCE_GUIDANCE_INFO_ADDRESS_FOR_FIX_FORMATTER_FIX_FORMATTER_FIELD_DATA;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[35];
        int n = 0;
        stringArray[n++] = TransformerUtil.getStringAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 9, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 10, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 11, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 12, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 13, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 8, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 16, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 14, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 15, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 17, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 22, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 23, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 27, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 28, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 18, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 19, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 24, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 20, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 21, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 26, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 29, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 30, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 31, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 32, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 33, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 34, object);
        stringArray[n++] = TransformerUtil.getFixFormatterFieldDataAsString(this, 35, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(827);
    }

    @Override
    public int getColumnCount() {
        return 35;
    }

    @Override
    public boolean isColumnIdSupported(int n) {
        switch (n) {
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 14: 
            case 15: 
            case 16: 
            case 17: 
            case 18: 
            case 19: 
            case 20: 
            case 21: 
            case 22: 
            case 23: 
            case 24: 
            case 26: 
            case 27: 
            case 28: 
            case 29: 
            case 30: 
            case 31: 
            case 32: 
            case 33: 
            case 34: 
            case 35: {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(int n, Object object) {
        switch (n) {
            case 16: 
            case 21: {
                return this.getBoolean(n, object);
            }
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 14: 
            case 15: 
            case 18: 
            case 19: 
            case 20: 
            case 24: 
            case 29: 
            case 30: 
            case 31: 
            case 32: 
            case 33: 
            case 34: {
                return new Integer(this.getInt(n, object));
            }
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 17: 
            case 22: 
            case 23: 
            case 27: 
            case 28: {
                return this.getString(n, object);
            }
            case 26: {
                return this.getResourceLocator(n, object);
            }
            case 35: {
                return this.getFixFormatterFieldData(n, object);
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        NavigationGuidanceGuidanceInfoCollector navigationGuidanceGuidanceInfoCollector = (NavigationGuidanceGuidanceInfoCollector)object;
        switch (n) {
            case 16: {
                return navigationGuidanceGuidanceInfoCollector.navigation_guidance_guidance_info_is_ferry;
            }
            case 21: {
                return navigationGuidanceGuidanceInfoCollector.navigation_guidance_guidance_info_stop_over;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        NavigationGuidanceGuidanceInfoCollector navigationGuidanceGuidanceInfoCollector = (NavigationGuidanceGuidanceInfoCollector)object;
        switch (n) {
            case 10: {
                return navigationGuidanceGuidanceInfoCollector.navigation_guidance_guidance_info_dtm;
            }
            case 11: {
                return navigationGuidanceGuidanceInfoCollector.navigation_guidance_guidance_info_etad;
            }
            case 12: {
                return navigationGuidanceGuidanceInfoCollector.navigation_guidance_guidance_info_etah;
            }
            case 13: {
                return navigationGuidanceGuidanceInfoCollector.navigation_guidance_guidance_info_etam;
            }
            case 14: {
                return navigationGuidanceGuidanceInfoCollector.navigation_guidance_guidance_info_length_on_highways;
            }
            case 15: {
                return navigationGuidanceGuidanceInfoCollector.navigation_guidance_guidance_info_length_on_toll_roads;
            }
            case 18: {
                return navigationGuidanceGuidanceInfoCollector.navigation_guidance_guidance_info_rtth;
            }
            case 19: {
                return navigationGuidanceGuidanceInfoCollector.navigation_guidance_guidance_info_rttm;
            }
            case 24: {
                return navigationGuidanceGuidanceInfoCollector.navigation_guidance_guidance_info_rtt_milliseconds;
            }
            case 20: {
                return navigationGuidanceGuidanceInfoCollector.navigation_guidance_guidance_info_type;
            }
            case 29: {
                return navigationGuidanceGuidanceInfoCollector.navigation_guidance_current_dest_data_lon_degree;
            }
            case 30: {
                return navigationGuidanceGuidanceInfoCollector.navigation_guidance_current_dest_data_lon_minutes;
            }
            case 31: {
                return navigationGuidanceGuidanceInfoCollector.navigation_guidance_current_dest_data_lon_seconds;
            }
            case 32: {
                return navigationGuidanceGuidanceInfoCollector.navigation_guidance_current_dest_data_lat_degree;
            }
            case 33: {
                return navigationGuidanceGuidanceInfoCollector.navigation_guidance_current_dest_data_lat_minutes;
            }
            case 34: {
                return navigationGuidanceGuidanceInfoCollector.navigation_guidance_current_dest_data_lat_seconds;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        NavigationGuidanceGuidanceInfoCollector navigationGuidanceGuidanceInfoCollector = (NavigationGuidanceGuidanceInfoCollector)object;
        switch (n) {
            case 0: {
                return navigationGuidanceGuidanceInfoCollector.navigation_guidance_guidance_info_add_info;
            }
            case 1: {
                return navigationGuidanceGuidanceInfoCollector.navigation_guidance_guidance_info_city;
            }
            case 2: {
                return navigationGuidanceGuidanceInfoCollector.navigation_guidance_guidance_info_city_refinement;
            }
            case 9: {
                return navigationGuidanceGuidanceInfoCollector.navigation_guidance_guidance_info_country_code;
            }
            case 6: {
                return navigationGuidanceGuidanceInfoCollector.navigation_guidance_guidance_info_hn;
            }
            case 8: {
                return navigationGuidanceGuidanceInfoCollector.navigation_guidance_guidance_info_h_nor_crossing;
            }
            case 17: {
                return navigationGuidanceGuidanceInfoCollector.navigation_guidance_guidance_info_name;
            }
            case 22: {
                return navigationGuidanceGuidanceInfoCollector.navigation_guidance_guidance_info_poi_category;
            }
            case 23: {
                return navigationGuidanceGuidanceInfoCollector.navigation_guidance_guidance_info_poi_name;
            }
            case 27: {
                return navigationGuidanceGuidanceInfoCollector.navigation_guidance_guidance_info_poi_phone_number;
            }
            case 28: {
                return navigationGuidanceGuidanceInfoCollector.navigation_guidance_guidance_info_poi_url;
            }
            case 7: {
                return navigationGuidanceGuidanceInfoCollector.navigation_guidance_guidance_infos_crossing;
            }
            case 4: {
                return navigationGuidanceGuidanceInfoCollector.navigation_guidance_guidance_info_street;
            }
            case 5: {
                return navigationGuidanceGuidanceInfoCollector.navigation_guidance_guidance_info_street_refinement;
            }
            case 3: {
                return navigationGuidanceGuidanceInfoCollector.navigation_guidance_guidance_info_zip;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean[] getFlagVector(int n, Object object) {
        throw new IllegalArgumentException();
    }

    @Override
    public int[] getIntegerVector(int n, Object object) {
        throw new IllegalArgumentException();
    }

    @Override
    public String[] getStringVector(int n, Object object) {
        throw new IllegalArgumentException();
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        NavigationGuidanceGuidanceInfoCollector navigationGuidanceGuidanceInfoCollector = (NavigationGuidanceGuidanceInfoCollector)object;
        switch (n) {
            case 26: {
                return navigationGuidanceGuidanceInfoCollector.navigation_guidance_guidance_info_icon_poi;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public long getLong(int n, Object object) {
        throw new IllegalArgumentException();
    }

    @Override
    public LabeledIconValue getLabeledIconValue(int n, Object object) {
        throw new IllegalArgumentException();
    }

    @Override
    public FixFormatterFieldData getFixFormatterFieldData(int n, Object object) {
        NavigationGuidanceGuidanceInfoCollector navigationGuidanceGuidanceInfoCollector = (NavigationGuidanceGuidanceInfoCollector)object;
        switch (n) {
            case 35: {
                return navigationGuidanceGuidanceInfoCollector.navigation_guidance_guidance_info_address_for_fix_formatter;
            }
        }
        throw new IllegalArgumentException();
    }
}

