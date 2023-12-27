/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.locationinput.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.navigation.locationinput.transformer.NavigationLocationInputLocationCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class NavigationLocationInputLocationTransformer
extends ItemTransformerAdapter {
    public static final int NAVIGATION_LOCATIONINPUT_LOCATION_COUNTRY_STRING;
    public static final int NAVIGATION_LOCATIONINPUT_LOCATION_COUNTRY_CODE_STRING;
    public static final int NAVIGATION_LOCATIONINPUT_LOCATION_ISO_COUNTRY_CODE_STRING;
    public static final int NAVIGATION_LOCATIONINPUT_LOCATION_PROVINCE_STRING;
    public static final int NAVIGATION_LOCATIONINPUT_LOCATION_STATE_STRING;
    public static final int NAVIGATION_LOCATIONINPUT_LOCATION_CITY_STRING;
    public static final int NAVIGATION_LOCATIONINPUT_LOCATION_CITY_REFINEMENT_STRING;
    public static final int NAVIGATION_LOCATIONINPUT_LOCATION_POSTAL_CODE_STRING;
    public static final int NAVIGATION_LOCATIONINPUT_LOCATION_STREET_STRING;
    public static final int NAVIGATION_LOCATIONINPUT_LOCATION_STREET_REFINEMENT_STRING;
    public static final int NAVIGATION_LOCATIONINPUT_LOCATION_CROSSING_STRING;
    public static final int NAVIGATION_LOCATIONINPUT_LOCATION_HOUSENUMBER_STRING;
    public static final int NAVIGATION_LOCATIONINPUT_LOCATION_LON_DEGREE_INTEGER;
    public static final int NAVIGATION_LOCATIONINPUT_LOCATION_LON_MINUTES_INTEGER;
    public static final int NAVIGATION_LOCATIONINPUT_LOCATION_LON_SECONDS_INTEGER;
    public static final int NAVIGATION_LOCATIONINPUT_LOCATION_LAT_DEGREE_INTEGER;
    public static final int NAVIGATION_LOCATIONINPUT_LOCATION_LAT_MINUTES_INTEGER;
    public static final int NAVIGATION_LOCATIONINPUT_LOCATION_LAT_SECONDS_INTEGER;
    public static final int NAVIGATION_LOCATIONINPUT_LOCATION_TYPE_INTEGER;
    public static final int NAVIGATION_LOCATIONINPUT_LOCATION_EMPTY_BOOLEAN;
    public static final int NAVIGATION_LOCATIONINPUT_LOCATION_FULL_POSTAL_CODE_BOOLEAN;
    public static final int NAVIGATION_LOCATIONINPUT_LOCATION_POSTAL_CODE_SPELLED_BOOLEAN;
    public static final int NAVIGATION_LOCATIONINPUT_LOCATION_TOWN_ORDER_BOOLEAN;
    public static final int NAVIGATION_LOCATIONINPUT_LOCATION_POSTAL_CODE_NEEDED_BOOLEAN;
    public static final int NAVIGATION_LOCATIONINPUT_LOCATION_TOWN_REFINEMENT_NEEDED_BOOLEAN;
    public static final int NAVIGATION_LOCATIONINPUT_LOCATION_STREET_REFINEMENT_NEEDED_BOOLEAN;
    public static final int NAVIGATION_LOCATIONINPUT_LOCATION_RESOLVED_BOOLEAN;
    public static final int NAVIGATION_LOCATIONINPUT_LOCATION_GUIDEABLE_BOOLEAN;
    public static final int NAVIGATION_LOCATIONINPUT_LOCATION_ADDRESS_FORMAT_INTEGER;
    public static final int NAVIGATION_LOCATIONINPUT_LOCATION_CITY_CENTER_BOOLEAN;
    public static final int NAVIGATION_LOCATIONINPUT_LOCATION_COUNTRY_ICON_RESOURCE_LOCATOR;
    public static final int NAVIGATION_LOCATIONINPUT_LOCATION_ADDRESS_DETAILS_FOR_FIX_FORMATTER_FIX_FORMATTER_FIELD_DATA;
    public static final int NAVIGATION_LOCATIONINPUT_LOCATION_STOPOVER_INDEX_INTEGER;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[33];
        int n = 0;
        stringArray[n++] = TransformerUtil.getStringAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 29, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 32, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 8, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 9, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 10, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 11, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 12, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 13, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 14, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 15, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 16, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 17, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 18, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 19, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 20, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 21, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 22, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 23, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 24, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 25, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 26, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 27, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 28, object);
        stringArray[n++] = TransformerUtil.getFixFormatterFieldDataAsString(this, 30, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 31, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(2830);
    }

    @Override
    public int getColumnCount() {
        return 33;
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
            case 32: {
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
            case 29: 
            case 32: {
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
        NavigationLocationInputLocationCollector navigationLocationInputLocationCollector = (NavigationLocationInputLocationCollector)object;
        switch (n) {
            case 17: {
                return navigationLocationInputLocationCollector.navigation_locationinput_location_empty;
            }
            case 18: {
                return navigationLocationInputLocationCollector.navigation_locationinput_location_full_postal_code;
            }
            case 19: {
                return navigationLocationInputLocationCollector.navigation_locationinput_location_postal_code_spelled;
            }
            case 20: {
                return navigationLocationInputLocationCollector.navigation_locationinput_location_town_order;
            }
            case 21: {
                return navigationLocationInputLocationCollector.navigation_locationinput_location_postal_code_needed;
            }
            case 22: {
                return navigationLocationInputLocationCollector.navigation_locationinput_location_town_refinement_needed;
            }
            case 23: {
                return navigationLocationInputLocationCollector.navigation_locationinput_location_street_refinement_needed;
            }
            case 24: {
                return navigationLocationInputLocationCollector.navigation_locationinput_location_resolved;
            }
            case 25: {
                return navigationLocationInputLocationCollector.navigation_locationinput_location_guideable;
            }
            case 27: {
                return navigationLocationInputLocationCollector.navigation_locationinput_location_city_center;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        NavigationLocationInputLocationCollector navigationLocationInputLocationCollector = (NavigationLocationInputLocationCollector)object;
        switch (n) {
            case 10: {
                return navigationLocationInputLocationCollector.navigation_locationinput_location_lon_degree;
            }
            case 11: {
                return navigationLocationInputLocationCollector.navigation_locationinput_location_lon_minutes;
            }
            case 12: {
                return navigationLocationInputLocationCollector.navigation_locationinput_location_lon_seconds;
            }
            case 13: {
                return navigationLocationInputLocationCollector.navigation_locationinput_location_lat_degree;
            }
            case 14: {
                return navigationLocationInputLocationCollector.navigation_locationinput_location_lat_minutes;
            }
            case 15: {
                return navigationLocationInputLocationCollector.navigation_locationinput_location_lat_seconds;
            }
            case 16: {
                return navigationLocationInputLocationCollector.navigation_locationinput_location_type;
            }
            case 26: {
                return navigationLocationInputLocationCollector.navigation_locationinput_location_address_format;
            }
            case 31: {
                return navigationLocationInputLocationCollector.navigation_locationinput_location_stopover_index;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        NavigationLocationInputLocationCollector navigationLocationInputLocationCollector = (NavigationLocationInputLocationCollector)object;
        switch (n) {
            case 0: {
                return navigationLocationInputLocationCollector.navigation_locationinput_location_country;
            }
            case 29: {
                return navigationLocationInputLocationCollector.navigation_locationinput_location_country_code;
            }
            case 32: {
                return navigationLocationInputLocationCollector.navigation_locationinput_location_iso_country_code;
            }
            case 1: {
                return navigationLocationInputLocationCollector.navigation_locationinput_location_province;
            }
            case 2: {
                return navigationLocationInputLocationCollector.navigation_locationinput_location_state;
            }
            case 3: {
                return navigationLocationInputLocationCollector.navigation_locationinput_location_city;
            }
            case 4: {
                return navigationLocationInputLocationCollector.navigation_locationinput_location_city_refinement;
            }
            case 5: {
                return navigationLocationInputLocationCollector.navigation_locationinput_location_postal_code;
            }
            case 6: {
                return navigationLocationInputLocationCollector.navigation_locationinput_location_street;
            }
            case 7: {
                return navigationLocationInputLocationCollector.navigation_locationinput_location_street_refinement;
            }
            case 8: {
                return navigationLocationInputLocationCollector.navigation_locationinput_location_crossing;
            }
            case 9: {
                return navigationLocationInputLocationCollector.navigation_locationinput_location_housenumber;
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
        NavigationLocationInputLocationCollector navigationLocationInputLocationCollector = (NavigationLocationInputLocationCollector)object;
        switch (n) {
            case 28: {
                return navigationLocationInputLocationCollector.navigation_locationinput_location_country_icon;
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
        NavigationLocationInputLocationCollector navigationLocationInputLocationCollector = (NavigationLocationInputLocationCollector)object;
        switch (n) {
            case 30: {
                return navigationLocationInputLocationCollector.navigation_locationinput_location_address_details_for_fix_formatter;
            }
        }
        throw new IllegalArgumentException();
    }
}

