/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.memory.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.navigation.memory.transformer.NavigationMemoryDestinationDetailsCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class NavigationMemoryDestinationDetailsTransformer
extends ItemTransformerAdapter {
    public static final int NAVIGATION_MEMORY_DESTINATIONS_CITY_STRING;
    public static final int NAVIGATION_MEMORY_DESTINATIONS_CITY_REFINEMENT_STRING;
    public static final int NAVIGATION_MEMORY_DESTINATIONS_COUNTRY_STRING;
    public static final int NAVIGATION_MEMORY_DESTINATIONS_COUNTRY_CODE_STRING;
    public static final int NAVIGATION_MEMORY_DESTINATIONS_JUNCTION_STRING;
    public static final int NAVIGATION_MEMORY_DESTINATIONS_NAME_STRING;
    public static final int NAVIGATION_MEMORY_DESTINATIONS_NUMBER_STRING;
    public static final int NAVIGATION_MEMORY_DESTINATIONS_PHONE_NUMBER_STRING;
    public static final int NAVIGATION_MEMORY_DESTINATIONS_URL_STRING;
    public static final int NAVIGATION_MEMORY_DESTINATIONS_POI_CATEGORY_STRING;
    public static final int NAVIGATION_MEMORY_DESTINATIONS_POI_NAME_STRING;
    public static final int NAVIGATION_MEMORY_DESTINATIONS_POI_ICON_RESOURCE_LOCATOR;
    public static final int NAVIGATION_MEMORY_DESTINATIONS_STREET_STRING;
    public static final int NAVIGATION_MEMORY_DESTINATIONS_STREET_REFINEMENT_STRING;
    public static final int NAVIGATION_MEMORY_DESTINATIONS_TYPE_INTEGER;
    public static final int NAVIGATION_MEMORY_DESTINATIONS_ZIP_STRING;
    public static final int NAVIGATION_MEMORY_DESTINATIONS_LAT_DEGREE_INTEGER;
    public static final int NAVIGATION_MEMORY_DESTINATIONS_LAT_MINUTES_INTEGER;
    public static final int NAVIGATION_MEMORY_DESTINATIONS_LAT_SECONDS_INTEGER;
    public static final int NAVIGATION_MEMORY_DESTINATIONS_LON_DEGREE_INTEGER;
    public static final int NAVIGATION_MEMORY_DESTINATIONS_LON_MINUTES_INTEGER;
    public static final int NAVIGATION_MEMORY_DESTINATIONS_LON_SECONDS_INTEGER;
    public static final int NAVIGATION_MEMORY_DESTINATION_DETAILS_FOR_FIX_FORMATTER_FIX_FORMATTER_FIELD_DATA;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[23];
        int n = 0;
        stringArray[n++] = TransformerUtil.getStringAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 11, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 14, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 12, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 13, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 21, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 8, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 9, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 10, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 15, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 16, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 17, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 18, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 19, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 20, object);
        stringArray[n++] = TransformerUtil.getFixFormatterFieldDataAsString(this, 22, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(910);
    }

    @Override
    public int getColumnCount() {
        return 23;
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
            case 22: {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(int n, Object object) {
        switch (n) {
            case 9: 
            case 15: 
            case 16: 
            case 17: 
            case 18: 
            case 19: 
            case 20: {
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
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 14: {
                return this.getString(n, object);
            }
            case 21: {
                return this.getResourceLocator(n, object);
            }
            case 22: {
                return this.getFixFormatterFieldData(n, object);
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        NavigationMemoryDestinationDetailsCollector navigationMemoryDestinationDetailsCollector = (NavigationMemoryDestinationDetailsCollector)object;
        switch (n) {
            case 9: {
                return navigationMemoryDestinationDetailsCollector.navigation_memory_destinations_type;
            }
            case 15: {
                return navigationMemoryDestinationDetailsCollector.navigation_memory_destinations_lat_degree;
            }
            case 16: {
                return navigationMemoryDestinationDetailsCollector.navigation_memory_destinations_lat_minutes;
            }
            case 17: {
                return navigationMemoryDestinationDetailsCollector.navigation_memory_destinations_lat_seconds;
            }
            case 18: {
                return navigationMemoryDestinationDetailsCollector.navigation_memory_destinations_lon_degree;
            }
            case 19: {
                return navigationMemoryDestinationDetailsCollector.navigation_memory_destinations_lon_minutes;
            }
            case 20: {
                return navigationMemoryDestinationDetailsCollector.navigation_memory_destinations_lon_seconds;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        NavigationMemoryDestinationDetailsCollector navigationMemoryDestinationDetailsCollector = (NavigationMemoryDestinationDetailsCollector)object;
        switch (n) {
            case 0: {
                return navigationMemoryDestinationDetailsCollector.navigation_memory_destinations_city;
            }
            case 1: {
                return navigationMemoryDestinationDetailsCollector.navigation_memory_destinations_city_refinement;
            }
            case 2: {
                return navigationMemoryDestinationDetailsCollector.navigation_memory_destinations_country;
            }
            case 3: {
                return navigationMemoryDestinationDetailsCollector.navigation_memory_destinations_country_code;
            }
            case 4: {
                return navigationMemoryDestinationDetailsCollector.navigation_memory_destinations_junction;
            }
            case 5: {
                return navigationMemoryDestinationDetailsCollector.navigation_memory_destinations_name;
            }
            case 6: {
                return navigationMemoryDestinationDetailsCollector.navigation_memory_destinations_number;
            }
            case 11: {
                return navigationMemoryDestinationDetailsCollector.navigation_memory_destinations_phone_number;
            }
            case 14: {
                return navigationMemoryDestinationDetailsCollector.navigation_memory_destinations_url;
            }
            case 12: {
                return navigationMemoryDestinationDetailsCollector.navigation_memory_destinations_poi_category;
            }
            case 13: {
                return navigationMemoryDestinationDetailsCollector.navigation_memory_destinations_poi_name;
            }
            case 7: {
                return navigationMemoryDestinationDetailsCollector.navigation_memory_destinations_street;
            }
            case 8: {
                return navigationMemoryDestinationDetailsCollector.navigation_memory_destinations_street_refinement;
            }
            case 10: {
                return navigationMemoryDestinationDetailsCollector.navigation_memory_destinations_zip;
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
        NavigationMemoryDestinationDetailsCollector navigationMemoryDestinationDetailsCollector = (NavigationMemoryDestinationDetailsCollector)object;
        switch (n) {
            case 21: {
                return navigationMemoryDestinationDetailsCollector.navigation_memory_destinations_poi_icon;
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
        NavigationMemoryDestinationDetailsCollector navigationMemoryDestinationDetailsCollector = (NavigationMemoryDestinationDetailsCollector)object;
        switch (n) {
            case 22: {
                return navigationMemoryDestinationDetailsCollector.navigation_memory_destination_details_for_fix_formatter;
            }
        }
        throw new IllegalArgumentException();
    }
}

