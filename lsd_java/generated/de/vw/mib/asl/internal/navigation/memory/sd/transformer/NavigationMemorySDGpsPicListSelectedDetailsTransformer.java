/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.memory.sd.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.navigation.memory.sd.transformer.NavigationMemorySDGpsPicListSelectedDetailsCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class NavigationMemorySDGpsPicListSelectedDetailsTransformer
extends ItemTransformerAdapter {
    public static final int NAVIGATION_MEMORY_SD_GPS_PIC_LIST_SELECTED_DETAILS_ADDRESS_STRING;
    public static final int NAVIGATION_MEMORY_SD_GPS_PIC_LIST_SELECTED_DETAILS_CITY_STRING;
    public static final int NAVIGATION_MEMORY_SD_GPS_PIC_LIST_SELECTED_DETAILS_CITY_REFINEMENT_STRING;
    public static final int NAVIGATION_MEMORY_SD_GPS_PIC_LIST_SELECTED_DETAILS_COUNTRY_STRING;
    public static final int NAVIGATION_MEMORY_SD_GPS_PIC_LIST_SELECTED_DETAILS_COUNTRY_CODE_STRING;
    public static final int NAVIGATION_MEMORY_SD_GPS_PIC_LIST_SELECTED_DETAILS_STREET_STRING;
    public static final int NAVIGATION_MEMORY_SD_GPS_PIC_LIST_SELECTED_DETAILS_STREET_REFINEMENT_STRING;
    public static final int NAVIGATION_MEMORY_SD_GPS_PIC_LIST_SELECTED_DETAILS_ZIP_STRING;
    public static final int NAVIGATION_MEMORY_SD_GPS_PIC_LIST_SELECTED_DETAILS_NUMBER_STRING;
    public static final int NAVIGATION_MEMORY_SD_GPS_PIC_LIST_SELECTED_DETAILS_JUNCTION_STRING;
    public static final int NAVIGATION_MEMORY_SD_GPS_PIC_LIST_SELECTED_DETAILS_TITLE_STRING;
    public static final int NAVIGATION_MEMORY_SD_GPS_PIC_LIST_SELECTED_DETAILS_IMAGE_STRING;
    public static final int NAVIGATION_MEMORY_SD_GPS_PIC_LIST_SELECTED_DETAILS_IMAGE_PATH_RESOURCE_LOCATOR;
    public static final int NAVIGATION_MEMORY_SD_GPS_PIC_LIST_SELECTED_DETAILS_COORDINATES_BOOLEAN;
    public static final int NAVIGATION_MEMORY_SD_GPS_PIC_LIST_SELECTED_DETAILS_PHONE_NUMBER_STRING;
    public static final int NAVIGATION_MEMORY_SD_GPS_PIC_LIST_SELECTED_DETAILS_URL_STRING;
    public static final int NAVIGATION_MEMORY_SD_GPS_PIC_LIST_SELECTED_DETAILS_POI_CATEGORY_STRING;
    public static final int NAVIGATION_MEMORY_SD_GPS_PIC_LIST_SELECTED_DETAILS_POI_NAME_STRING;
    public static final int NAVIGATION_MEMORY_SD_GPS_PIC_LIST_SELECTED_DETAILS_TYPE_INTEGER;
    public static final int NAVIGATION_MEMORY_SD_GPS_PIC_LIST_SELECTED_DETAILS_LAT_DEGREE_INTEGER;
    public static final int NAVIGATION_MEMORY_SD_GPS_PIC_LIST_SELECTED_DETAILS_LAT_MINUTES_INTEGER;
    public static final int NAVIGATION_MEMORY_SD_GPS_PIC_LIST_SELECTED_DETAILS_LAT_SECONDS_INTEGER;
    public static final int NAVIGATION_MEMORY_SD_GPS_PIC_LIST_SELECTED_DETAILS_LON_DEGREE_INTEGER;
    public static final int NAVIGATION_MEMORY_SD_GPS_PIC_LIST_SELECTED_DETAILS_LON_MINUTES_INTEGER;
    public static final int NAVIGATION_MEMORY_SD_GPS_PIC_LIST_SELECTED_DETAILS_LON_SECONDS_INTEGER;
    public static final int NAVIGATION_MEMORY_SD_V_GPS_PIC_LIST_SELECTED_DETAILS_INFO_STRING;
    public static final int NAVIGATION_MEMORY_SD_GPS_PIC_LIST_SELECTED_DETAILS_IS_GUIDABLE_BOOLEAN;
    public static final int NAVIGATION_MEMORY_SD_GPS_PIC_LIST_SELECTED_DETAILS_FOR_FIX_FORMATTER_FIX_FORMATTER_FIELD_DATA;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[28];
        int n = 0;
        stringArray[n++] = TransformerUtil.getStringAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 8, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 9, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 10, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 11, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 12, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 13, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 22, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 23, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 24, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 25, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 15, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 16, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 17, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 18, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 19, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 20, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 21, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 14, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 26, object);
        stringArray[n++] = TransformerUtil.getFixFormatterFieldDataAsString(this, 27, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(923);
    }

    @Override
    public int getColumnCount() {
        return 28;
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
            case 25: 
            case 26: 
            case 27: {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(int n, Object object) {
        switch (n) {
            case 13: 
            case 26: {
                return this.getBoolean(n, object);
            }
            case 15: 
            case 16: 
            case 17: 
            case 18: 
            case 19: 
            case 20: 
            case 21: {
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
            case 10: 
            case 11: 
            case 14: 
            case 22: 
            case 23: 
            case 24: 
            case 25: {
                return this.getString(n, object);
            }
            case 12: {
                return this.getResourceLocator(n, object);
            }
            case 27: {
                return this.getFixFormatterFieldData(n, object);
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        NavigationMemorySDGpsPicListSelectedDetailsCollector navigationMemorySDGpsPicListSelectedDetailsCollector = (NavigationMemorySDGpsPicListSelectedDetailsCollector)object;
        switch (n) {
            case 13: {
                return navigationMemorySDGpsPicListSelectedDetailsCollector.navigation_memory_sd_gps_pic_list_selected_details_coordinates;
            }
            case 26: {
                return navigationMemorySDGpsPicListSelectedDetailsCollector.navigation_memory_sd_gps_pic_list_selected_details_is_guidable;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        NavigationMemorySDGpsPicListSelectedDetailsCollector navigationMemorySDGpsPicListSelectedDetailsCollector = (NavigationMemorySDGpsPicListSelectedDetailsCollector)object;
        switch (n) {
            case 15: {
                return navigationMemorySDGpsPicListSelectedDetailsCollector.navigation_memory_sd_gps_pic_list_selected_details_type;
            }
            case 16: {
                return navigationMemorySDGpsPicListSelectedDetailsCollector.navigation_memory_sd_gps_pic_list_selected_details_lat_degree;
            }
            case 17: {
                return navigationMemorySDGpsPicListSelectedDetailsCollector.navigation_memory_sd_gps_pic_list_selected_details_lat_minutes;
            }
            case 18: {
                return navigationMemorySDGpsPicListSelectedDetailsCollector.navigation_memory_sd_gps_pic_list_selected_details_lat_seconds;
            }
            case 19: {
                return navigationMemorySDGpsPicListSelectedDetailsCollector.navigation_memory_sd_gps_pic_list_selected_details_lon_degree;
            }
            case 20: {
                return navigationMemorySDGpsPicListSelectedDetailsCollector.navigation_memory_sd_gps_pic_list_selected_details_lon_minutes;
            }
            case 21: {
                return navigationMemorySDGpsPicListSelectedDetailsCollector.navigation_memory_sd_gps_pic_list_selected_details_lon_seconds;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        NavigationMemorySDGpsPicListSelectedDetailsCollector navigationMemorySDGpsPicListSelectedDetailsCollector = (NavigationMemorySDGpsPicListSelectedDetailsCollector)object;
        switch (n) {
            case 0: {
                return navigationMemorySDGpsPicListSelectedDetailsCollector.navigation_memory_sd_gps_pic_list_selected_details_address;
            }
            case 1: {
                return navigationMemorySDGpsPicListSelectedDetailsCollector.navigation_memory_sd_gps_pic_list_selected_details_city;
            }
            case 2: {
                return navigationMemorySDGpsPicListSelectedDetailsCollector.navigation_memory_sd_gps_pic_list_selected_details_city_refinement;
            }
            case 3: {
                return navigationMemorySDGpsPicListSelectedDetailsCollector.navigation_memory_sd_gps_pic_list_selected_details_country;
            }
            case 4: {
                return navigationMemorySDGpsPicListSelectedDetailsCollector.navigation_memory_sd_gps_pic_list_selected_details_country_code;
            }
            case 5: {
                return navigationMemorySDGpsPicListSelectedDetailsCollector.navigation_memory_sd_gps_pic_list_selected_details_street;
            }
            case 6: {
                return navigationMemorySDGpsPicListSelectedDetailsCollector.navigation_memory_sd_gps_pic_list_selected_details_street_refinement;
            }
            case 7: {
                return navigationMemorySDGpsPicListSelectedDetailsCollector.navigation_memory_sd_gps_pic_list_selected_details_zip;
            }
            case 8: {
                return navigationMemorySDGpsPicListSelectedDetailsCollector.navigation_memory_sd_gps_pic_list_selected_details_number;
            }
            case 9: {
                return navigationMemorySDGpsPicListSelectedDetailsCollector.navigation_memory_sd_gps_pic_list_selected_details_junction;
            }
            case 10: {
                return navigationMemorySDGpsPicListSelectedDetailsCollector.navigation_memory_sd_gps_pic_list_selected_details_title;
            }
            case 11: {
                return navigationMemorySDGpsPicListSelectedDetailsCollector.navigation_memory_sd_gps_pic_list_selected_details_image;
            }
            case 22: {
                return navigationMemorySDGpsPicListSelectedDetailsCollector.navigation_memory_sd_gps_pic_list_selected_details_phone_number;
            }
            case 23: {
                return navigationMemorySDGpsPicListSelectedDetailsCollector.navigation_memory_sd_gps_pic_list_selected_details_url;
            }
            case 24: {
                return navigationMemorySDGpsPicListSelectedDetailsCollector.navigation_memory_sd_gps_pic_list_selected_details_poi_category;
            }
            case 25: {
                return navigationMemorySDGpsPicListSelectedDetailsCollector.navigation_memory_sd_gps_pic_list_selected_details_poi_name;
            }
            case 14: {
                return navigationMemorySDGpsPicListSelectedDetailsCollector.navigation_memory_sd_v_gps_pic_list_selected_details_info;
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
        NavigationMemorySDGpsPicListSelectedDetailsCollector navigationMemorySDGpsPicListSelectedDetailsCollector = (NavigationMemorySDGpsPicListSelectedDetailsCollector)object;
        switch (n) {
            case 12: {
                return navigationMemorySDGpsPicListSelectedDetailsCollector.navigation_memory_sd_gps_pic_list_selected_details_image_path;
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
        NavigationMemorySDGpsPicListSelectedDetailsCollector navigationMemorySDGpsPicListSelectedDetailsCollector = (NavigationMemorySDGpsPicListSelectedDetailsCollector)object;
        switch (n) {
            case 27: {
                return navigationMemorySDGpsPicListSelectedDetailsCollector.navigation_memory_sd_gps_pic_list_selected_details_for_fix_formatter;
            }
        }
        throw new IllegalArgumentException();
    }
}

