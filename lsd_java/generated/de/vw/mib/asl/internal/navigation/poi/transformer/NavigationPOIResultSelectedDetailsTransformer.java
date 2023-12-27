/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.poi.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.navigation.poi.transformer.NavigationPOIResultSelectedDetailsCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class NavigationPOIResultSelectedDetailsTransformer
extends ItemTransformerAdapter {
    public static final int NAVIGATION_POI_RESULT_SELECTED_DETAILS_CATEGORY_STRING;
    public static final int NAVIGATION_POI_RESULT_SELECTED_DETAILS_DETAIL_STRING;
    public static final int NAVIGATION_POI_RESULT_SELECTED_DETAILS_DISTANCE_INTEGER;
    public static final int NAVIGATION_POI_RESULT_SELECTED_DETAILS_PHONE_NUMBER_STRING;
    public static final int NAVIGATION_POI_RESULT_SELECTED_DETAILS_ICON_INDEX_INTEGER;
    public static final int NAVIGATION_POI_RESULT_SELECTED_DETAILS_SUB_ICON_INDEX_INTEGER;
    public static final int NAVIGATION_POI_RESULT_SELECTED_DETAILS_LATITUDE_INTEGER;
    public static final int NAVIGATION_POI_RESULT_SELECTED_DETAILS_LONGITUDE_INTEGER;
    public static final int NAVIGATION_POI_RESULT_SELECTED_DETAILS_CLASS_STRING;
    public static final int NAVIGATION_POI_RESULT_SELECTED_DETAILS_COUNTRY_STRING;
    public static final int NAVIGATION_POI_RESULT_SELECTED_DETAILS_PROVINCE_STRING;
    public static final int NAVIGATION_POI_RESULT_SELECTED_DETAILS_STATE_STRING;
    public static final int NAVIGATION_POI_RESULT_SELECTED_DETAILS_COUNTRY_CODE_STRING;
    public static final int NAVIGATION_POI_RESULT_SELECTED_DETAILS_CITY_STRING;
    public static final int NAVIGATION_POI_RESULT_SELECTED_DETAILS_CITY_CENTER_STRING;
    public static final int NAVIGATION_POI_RESULT_SELECTED_DETAILS_STREET_STRING;
    public static final int NAVIGATION_POI_RESULT_SELECTED_DETAILS_CROSSING_STRING;
    public static final int NAVIGATION_POI_RESULT_SELECTED_DETAILS_HOUSENUMBER_STRING;
    public static final int NAVIGATION_POI_RESULT_SELECTED_DETAILS_ZIP_STRING;
    public static final int NAVIGATION_POI_RESULT_SELECTED_DETAILS_MOTORWAY_EXIT_STRING;
    public static final int NAVIGATION_POI_RESULT_SELECTED_DETAILS_URL_STRING;
    public static final int NAVIGATION_POI_RESULT_SELECTED_DETAILS_HEADLINE_ICON_RESOURCE_LOCATOR;
    public static final int NAVIGATION_POI_RESULT_SELECTED_DETAILS_DIRECTION_ARROW_INDEX_INTEGER;
    public static final int NAVIGATION_POI_RESULT_SELECTED_DETAILS_CITY_REFINEMENT_STRING;
    public static final int NAVIGATION_POI_RESULT_SELECTED_STREET_REFINEMENT_STRING;
    public static final int NAVIGATION_POI_RESULT_SELECTED_DETAILS_NAME_STRING;
    public static final int NAVIGATION_POI_RESULT_SELECTED_DETAIL_ADDRESS_FOR_FIX_FORMATTER_FIX_FORMATTER_FIELD_DATA;
    public static final int NAVIGATION_POI_RESULT_SELECTED_DETAILS_PROVIDER_AVAILABLE_BOOLEAN;
    public static final int NAVIGATION_POI_RESULT_SELECTED_DETAILS_PROVIDER_STRING;
    public static final int NAVIGATION_POI_RESULT_SELECTED_DETAILS_PAYMENT_INTEGER;
    public static final int NAVIGATION_POI_RESULT_SELECTED_DETAILS_SUBSCRIPTION_INTEGER;
    public static final int NAVIGATION_POI_RESULT_SELECTED_DETAILS_ONSITEPAYMENT_AVAILABLE_BOOLEAN;
    public static final int NAVIGATION_POI_RESULT_SELECTED_DETAILS_ONSITEPAYMENT_STRING;
    public static final int NAVIGATION_POI_RESULT_SELECTED_DETAILS_ONSITEPAYMENT__ENUM_INTEGER;
    public static final int NAVIGATION_POI_RESULT_SELECTED_DETAILS_ACCESS_INTEGER;
    public static final int NAVIGATION_POI_RESULT_SELECTED_DETAILS_OPEN24H_INTEGER;
    public static final int NAVIGATION_POI_RESULT_SELECTED_DETAILS_CONNECTOR_COUNT_INTEGER;
    public static final int NAVIGATION_POI_RESULT_SELECTED_DETAILS_OUTSIDE_RANGE_BOOLEAN;
    public static final int NAVIGATION_POI_RESULT_SELECTED_DETAILS_INSIDE_RANGE_BOOLEAN;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[39];
        int n = 0;
        stringArray[n++] = TransformerUtil.getStringAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 8, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 9, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 24, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 25, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 10, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 11, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 12, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 13, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 14, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 15, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 16, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 17, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 18, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 19, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 20, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 21, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 22, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 23, object);
        stringArray[n++] = TransformerUtil.getFixFormatterFieldDataAsString(this, 26, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 27, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 28, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 29, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 30, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 31, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 32, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 33, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 34, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 35, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 36, object);
        stringArray[n++] = TransformerUtil.getDeprecatedBooleanAsString(this, 37, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 38, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(947);
    }

    @Override
    public int getColumnCount() {
        return 39;
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
            case 27: 
            case 28: 
            case 29: 
            case 30: 
            case 31: 
            case 32: 
            case 33: 
            case 34: 
            case 35: 
            case 36: 
            case 37: 
            case 38: {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(int n, Object object) {
        switch (n) {
            case 27: 
            case 31: 
            case 37: 
            case 38: {
                return this.getBoolean(n, object);
            }
            case 2: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 20: 
            case 29: 
            case 30: 
            case 33: 
            case 34: 
            case 35: 
            case 36: {
                return new Integer(this.getInt(n, object));
            }
            case 0: 
            case 1: 
            case 3: 
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
            case 21: 
            case 22: 
            case 23: 
            case 24: 
            case 25: 
            case 28: 
            case 32: {
                return this.getString(n, object);
            }
            case 19: {
                return this.getResourceLocator(n, object);
            }
            case 26: {
                return this.getFixFormatterFieldData(n, object);
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        NavigationPOIResultSelectedDetailsCollector navigationPOIResultSelectedDetailsCollector = (NavigationPOIResultSelectedDetailsCollector)object;
        switch (n) {
            case 27: {
                return navigationPOIResultSelectedDetailsCollector.navigation_poi_result_selected_details_provider_available;
            }
            case 31: {
                return navigationPOIResultSelectedDetailsCollector.navigation_poi_result_selected_details_onsitepayment_available;
            }
            case 37: {
                return navigationPOIResultSelectedDetailsCollector.navigation_poi_result_selected_details_outside_range;
            }
            case 38: {
                return navigationPOIResultSelectedDetailsCollector.navigation_poi_result_selected_details_inside_range;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        NavigationPOIResultSelectedDetailsCollector navigationPOIResultSelectedDetailsCollector = (NavigationPOIResultSelectedDetailsCollector)object;
        switch (n) {
            case 2: {
                return navigationPOIResultSelectedDetailsCollector.navigation_poi_result_selected_details_distance;
            }
            case 4: {
                return navigationPOIResultSelectedDetailsCollector.navigation_poi_result_selected_details_icon_index;
            }
            case 5: {
                return navigationPOIResultSelectedDetailsCollector.navigation_poi_result_selected_details_sub_icon_index;
            }
            case 6: {
                return navigationPOIResultSelectedDetailsCollector.navigation_poi_result_selected_details_latitude;
            }
            case 7: {
                return navigationPOIResultSelectedDetailsCollector.navigation_poi_result_selected_details_longitude;
            }
            case 20: {
                return navigationPOIResultSelectedDetailsCollector.navigation_poi_result_selected_details_direction_arrow_index;
            }
            case 29: {
                return navigationPOIResultSelectedDetailsCollector.navigation_poi_result_selected_details_payment;
            }
            case 30: {
                return navigationPOIResultSelectedDetailsCollector.navigation_poi_result_selected_details_subscription;
            }
            case 33: {
                return navigationPOIResultSelectedDetailsCollector.navigation_poi_result_selected_details_onsitepayment__enum;
            }
            case 34: {
                return navigationPOIResultSelectedDetailsCollector.navigation_poi_result_selected_details_access;
            }
            case 35: {
                return navigationPOIResultSelectedDetailsCollector.navigation_poi_result_selected_details_open24h;
            }
            case 36: {
                return navigationPOIResultSelectedDetailsCollector.navigation_poi_result_selected_details_connector_count;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        NavigationPOIResultSelectedDetailsCollector navigationPOIResultSelectedDetailsCollector = (NavigationPOIResultSelectedDetailsCollector)object;
        switch (n) {
            case 0: {
                return navigationPOIResultSelectedDetailsCollector.navigation_poi_result_selected_details_category;
            }
            case 1: {
                return navigationPOIResultSelectedDetailsCollector.navigation_poi_result_selected_details_detail;
            }
            case 3: {
                return navigationPOIResultSelectedDetailsCollector.navigation_poi_result_selected_details_phone_number;
            }
            case 8: {
                return navigationPOIResultSelectedDetailsCollector.navigation_poi_result_selected_details_class;
            }
            case 9: {
                return navigationPOIResultSelectedDetailsCollector.navigation_poi_result_selected_details_country;
            }
            case 24: {
                return navigationPOIResultSelectedDetailsCollector.navigation_poi_result_selected_details_province;
            }
            case 25: {
                return navigationPOIResultSelectedDetailsCollector.navigation_poi_result_selected_details_state;
            }
            case 10: {
                return navigationPOIResultSelectedDetailsCollector.navigation_poi_result_selected_details_country_code;
            }
            case 11: {
                return navigationPOIResultSelectedDetailsCollector.navigation_poi_result_selected_details_city;
            }
            case 12: {
                return navigationPOIResultSelectedDetailsCollector.navigation_poi_result_selected_details_city_center;
            }
            case 13: {
                return navigationPOIResultSelectedDetailsCollector.navigation_poi_result_selected_details_street;
            }
            case 14: {
                return navigationPOIResultSelectedDetailsCollector.navigation_poi_result_selected_details_crossing;
            }
            case 15: {
                return navigationPOIResultSelectedDetailsCollector.navigation_poi_result_selected_details_housenumber;
            }
            case 16: {
                return navigationPOIResultSelectedDetailsCollector.navigation_poi_result_selected_details_zip;
            }
            case 17: {
                return navigationPOIResultSelectedDetailsCollector.navigation_poi_result_selected_details_motorway_exit;
            }
            case 18: {
                return navigationPOIResultSelectedDetailsCollector.navigation_poi_result_selected_details_url;
            }
            case 21: {
                return navigationPOIResultSelectedDetailsCollector.navigation_poi_result_selected_details_city_refinement;
            }
            case 22: {
                return navigationPOIResultSelectedDetailsCollector.navigation_poi_result_selected_street_refinement;
            }
            case 23: {
                return navigationPOIResultSelectedDetailsCollector.navigation_poi_result_selected_details_name;
            }
            case 28: {
                return navigationPOIResultSelectedDetailsCollector.navigation_poi_result_selected_details_provider;
            }
            case 32: {
                return navigationPOIResultSelectedDetailsCollector.navigation_poi_result_selected_details_onsitepayment;
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
        NavigationPOIResultSelectedDetailsCollector navigationPOIResultSelectedDetailsCollector = (NavigationPOIResultSelectedDetailsCollector)object;
        switch (n) {
            case 19: {
                return navigationPOIResultSelectedDetailsCollector.navigation_poi_result_selected_details_headline_icon;
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
        NavigationPOIResultSelectedDetailsCollector navigationPOIResultSelectedDetailsCollector = (NavigationPOIResultSelectedDetailsCollector)object;
        switch (n) {
            case 26: {
                return navigationPOIResultSelectedDetailsCollector.navigation_poi_result_selected_detail_address_for_fix_formatter;
            }
        }
        throw new IllegalArgumentException();
    }
}

