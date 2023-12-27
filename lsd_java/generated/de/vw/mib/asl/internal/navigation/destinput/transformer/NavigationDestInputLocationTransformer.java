/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.destinput.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.navigation.destinput.transformer.NavigationDestInputLocationCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class NavigationDestInputLocationTransformer
extends ItemTransformerAdapter {
    public static final int NAVIGATION_DESTINPUT_LOCATION_COUNTRY_STRING;
    public static final int NAVIGATION_DESTINPUT_LOCATION_COUNTRY_CODE_STRING;
    public static final int NAVIGATION_DESTINPUT_LOCATION_PROVINCE_STRING;
    public static final int NAVIGATION_DESTINPUT_LOCATION_STATE_STRING;
    public static final int NAVIGATION_DESTINPUT_LOCATION_CITY_STRING;
    public static final int NAVIGATION_DESTINPUT_LOCATION_CITY_REFINEMENT_STRING;
    public static final int NAVIGATION_DESTINPUT_LOCATION_POSTAL_CODE_STRING;
    public static final int NAVIGATION_DESTINPUT_LOCATION_STREET_STRING;
    public static final int NAVIGATION_DESTINPUT_LOCATION_STREET_REFINEMENT_STRING;
    public static final int NAVIGATION_DESTINPUT_LOCATION_CROSSING_STRING;
    public static final int NAVIGATION_DESTINPUT_LOCATION_HOUSENUMBER_STRING;
    public static final int NAVIGATION_DESTINPUT_LOCATION_LON_DEGREE_INTEGER;
    public static final int NAVIGATION_DESTINPUT_LOCATION_LON_MINUTES_INTEGER;
    public static final int NAVIGATION_DESTINPUT_LOCATION_LON_SECONDS_INTEGER;
    public static final int NAVIGATION_DESTINPUT_LOCATION_LAT_DEGREE_INTEGER;
    public static final int NAVIGATION_DESTINPUT_LOCATION_LAT_MINUTES_INTEGER;
    public static final int NAVIGATION_DESTINPUT_LOCATION_LAT_SECONDS_INTEGER;
    public static final int NAVIGATION_DESTINPUT_LOCATION_TYPE_INTEGER;
    public static final int NAVIGATION_DESTINPUT_LOCATION_EMPTY_BOOLEAN;
    public static final int NAVIGATION_DESTINPUT_LOCATION_FULL_POSTAL_CODE_BOOLEAN;
    public static final int NAVIGATION_DESTINPUT_LOCATION_POSTAL_CODE_SPELLED_BOOLEAN;
    public static final int NAVIGATION_DESTINPUT_LOCATION_TOWN_ORDER_BOOLEAN;
    public static final int NAVIGATION_DESTINPUT_LOCATION_POSTAL_CODE_NEEDED_BOOLEAN;
    public static final int NAVIGATION_DESTINPUT_LOCATION_TOWN_REFINEMENT_NEEDED_BOOLEAN;
    public static final int NAVIGATION_DESTINPUT_LOCATION_STREET_REFINEMENT_NEEDED_BOOLEAN;
    public static final int NAVIGATION_DESTINPUT_LOCATION_RESOLVED_BOOLEAN;
    public static final int NAVIGATION_DESTINPUT_LOCATION_GUIDEABLE_BOOLEAN;
    public static final int NAVIGATION_DESTINPUT_LOCATION_ADDRESS_FORMAT_INTEGER;
    public static final int NAVIGATION_DESTINPUT_LOCATION_CITY_CENTER_BOOLEAN;
    public static final int NAVIGATION_DESTINPUT_LOCATION_COUNTRY_ICON_RESOURCE_LOCATOR;
    public static final int NAVIGATION_DESTINPUT_LOCATION_ADDRESS_DETAILS_FOR_FIX_FORMATTER_FIX_FORMATTER_FIELD_DATA;
    public static final int NAVIGATION_DESTINPUT_LOCATION_STOPOVER_INDEX_INTEGER;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[32];
        int n = 0;
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 29, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 8, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 9, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 10, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 11, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 12, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 13, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 14, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 15, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 16, object);
        stringArray[n++] = TransformerUtil.getDeprecatedBooleanAsString(this, 17, object);
        stringArray[n++] = TransformerUtil.getDeprecatedBooleanAsString(this, 18, object);
        stringArray[n++] = TransformerUtil.getDeprecatedBooleanAsString(this, 19, object);
        stringArray[n++] = TransformerUtil.getDeprecatedBooleanAsString(this, 20, object);
        stringArray[n++] = TransformerUtil.getDeprecatedBooleanAsString(this, 21, object);
        stringArray[n++] = TransformerUtil.getDeprecatedBooleanAsString(this, 22, object);
        stringArray[n++] = TransformerUtil.getDeprecatedBooleanAsString(this, 23, object);
        stringArray[n++] = TransformerUtil.getDeprecatedBooleanAsString(this, 24, object);
        stringArray[n++] = TransformerUtil.getDeprecatedBooleanAsString(this, 25, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 26, object);
        stringArray[n++] = TransformerUtil.getDeprecatedBooleanAsString(this, 27, object);
        stringArray[n++] = TransformerUtil.getDeprecatedResourceLocatorAsString(this, 28, object);
        stringArray[n++] = TransformerUtil.getDeprecatedFixFormatterFieldDataAsString(this, 30, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 31, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(2826);
    }

    @Override
    public int getColumnCount() {
        return 32;
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
            case 31: {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(int n, Object object) {
        switch (n) {
            case 17: 
            case 18: 
            case 19: 
            case 20: 
            case 21: 
            case 22: 
            case 23: 
            case 24: 
            case 25: 
            case 27: {
                return this.getBoolean(n, object);
            }
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 14: 
            case 15: 
            case 16: 
            case 26: 
            case 31: {
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
            case 29: {
                return this.getString(n, object);
            }
            case 28: {
                return this.getResourceLocator(n, object);
            }
            case 30: {
                return this.getFixFormatterFieldData(n, object);
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        NavigationDestInputLocationCollector navigationDestInputLocationCollector = (NavigationDestInputLocationCollector)object;
        switch (n) {
            case 17: {
                return navigationDestInputLocationCollector.navigation_destinput_location_empty;
            }
            case 18: {
                return navigationDestInputLocationCollector.navigation_destinput_location_full_postal_code;
            }
            case 19: {
                return navigationDestInputLocationCollector.navigation_destinput_location_postal_code_spelled;
            }
            case 20: {
                return navigationDestInputLocationCollector.navigation_destinput_location_town_order;
            }
            case 21: {
                return navigationDestInputLocationCollector.navigation_destinput_location_postal_code_needed;
            }
            case 22: {
                return navigationDestInputLocationCollector.navigation_destinput_location_town_refinement_needed;
            }
            case 23: {
                return navigationDestInputLocationCollector.navigation_destinput_location_street_refinement_needed;
            }
            case 24: {
                return navigationDestInputLocationCollector.navigation_destinput_location_resolved;
            }
            case 25: {
                return navigationDestInputLocationCollector.navigation_destinput_location_guideable;
            }
            case 27: {
                return navigationDestInputLocationCollector.navigation_destinput_location_city_center;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        NavigationDestInputLocationCollector navigationDestInputLocationCollector = (NavigationDestInputLocationCollector)object;
        switch (n) {
            case 10: {
                return navigationDestInputLocationCollector.navigation_destinput_location_lon_degree;
            }
            case 11: {
                return navigationDestInputLocationCollector.navigation_destinput_location_lon_minutes;
            }
            case 12: {
                return navigationDestInputLocationCollector.navigation_destinput_location_lon_seconds;
            }
            case 13: {
                return navigationDestInputLocationCollector.navigation_destinput_location_lat_degree;
            }
            case 14: {
                return navigationDestInputLocationCollector.navigation_destinput_location_lat_minutes;
            }
            case 15: {
                return navigationDestInputLocationCollector.navigation_destinput_location_lat_seconds;
            }
            case 16: {
                return navigationDestInputLocationCollector.navigation_destinput_location_type;
            }
            case 26: {
                return navigationDestInputLocationCollector.navigation_destinput_location_address_format;
            }
            case 31: {
                return navigationDestInputLocationCollector.navigation_destinput_location_stopover_index;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        NavigationDestInputLocationCollector navigationDestInputLocationCollector = (NavigationDestInputLocationCollector)object;
        switch (n) {
            case 0: {
                return navigationDestInputLocationCollector.navigation_destinput_location_country;
            }
            case 29: {
                return navigationDestInputLocationCollector.navigation_destinput_location_country_code;
            }
            case 1: {
                return navigationDestInputLocationCollector.navigation_destinput_location_province;
            }
            case 2: {
                return navigationDestInputLocationCollector.navigation_destinput_location_state;
            }
            case 3: {
                return navigationDestInputLocationCollector.navigation_destinput_location_city;
            }
            case 4: {
                return navigationDestInputLocationCollector.navigation_destinput_location_city_refinement;
            }
            case 5: {
                return navigationDestInputLocationCollector.navigation_destinput_location_postal_code;
            }
            case 6: {
                return navigationDestInputLocationCollector.navigation_destinput_location_street;
            }
            case 7: {
                return navigationDestInputLocationCollector.navigation_destinput_location_street_refinement;
            }
            case 8: {
                return navigationDestInputLocationCollector.navigation_destinput_location_crossing;
            }
            case 9: {
                return navigationDestInputLocationCollector.navigation_destinput_location_housenumber;
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
        NavigationDestInputLocationCollector navigationDestInputLocationCollector = (NavigationDestInputLocationCollector)object;
        switch (n) {
            case 28: {
                return navigationDestInputLocationCollector.navigation_destinput_location_country_icon;
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
        NavigationDestInputLocationCollector navigationDestInputLocationCollector = (NavigationDestInputLocationCollector)object;
        switch (n) {
            case 30: {
                return navigationDestInputLocationCollector.navigation_destinput_location_address_details_for_fix_formatter;
            }
        }
        throw new IllegalArgumentException();
    }
}

