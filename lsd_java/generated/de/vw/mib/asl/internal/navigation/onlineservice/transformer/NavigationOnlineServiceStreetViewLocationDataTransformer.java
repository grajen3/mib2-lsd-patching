/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.onlineservice.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.navigation.onlineservice.transformer.NavigationOnlineServiceStreetViewLocationDataCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class NavigationOnlineServiceStreetViewLocationDataTransformer
extends ItemTransformerAdapter {
    public static final int NAVIGATION_ONLINESERVICE_STREET_VIEW_LOCATION_DATA_CITY_STRING;
    public static final int NAVIGATION_ONLINESERVICE_STREET_VIEW_LOCATION_DATA_CITY_REFINEMENT_STRING;
    public static final int NAVIGATION_ONLINESERVICE_STREET_VIEW_LOCATION_DATA_STREET_STRING;
    public static final int NAVIGATION_ONLINESERVICE_STREET_VIEW_LOCATION_DATA_STREET_REFINEMENT_STRING;
    public static final int NAVIGATION_ONLINESERVICE_STREET_VIEW_LOCATION_LON_DEGREE_INTEGER;
    public static final int NAVIGATION_ONLINESERVICE_STREET_VIEW_LOCATION_LON_MINUTES_INTEGER;
    public static final int NAVIGATION_ONLINESERVICE_STREET_VIEW_LOCATION_LON_SECONDS_INTEGER;
    public static final int NAVIGATION_ONLINESERVICE_STREET_VIEW_LOCATION_LAT_DEGREE_INTEGER;
    public static final int NAVIGATION_ONLINESERVICE_STREET_VIEW_LOCATION_LAT_MINUTES_INTEGER;
    public static final int NAVIGATION_ONLINESERVICE_STREET_VIEW_LOCATION_LAT_SECONDS_INTEGER;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[10];
        int n = 0;
        stringArray[n++] = TransformerUtil.getStringAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 8, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 9, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(3775);
    }

    @Override
    public int getColumnCount() {
        return 10;
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
            case 9: {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(int n, Object object) {
        switch (n) {
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: {
                return new Integer(this.getInt(n, object));
            }
            case 0: 
            case 1: 
            case 2: 
            case 3: {
                return this.getString(n, object);
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
        NavigationOnlineServiceStreetViewLocationDataCollector navigationOnlineServiceStreetViewLocationDataCollector = (NavigationOnlineServiceStreetViewLocationDataCollector)object;
        switch (n) {
            case 4: {
                return navigationOnlineServiceStreetViewLocationDataCollector.navigation_onlineservice_street_view_location_lon_degree;
            }
            case 5: {
                return navigationOnlineServiceStreetViewLocationDataCollector.navigation_onlineservice_street_view_location_lon_minutes;
            }
            case 6: {
                return navigationOnlineServiceStreetViewLocationDataCollector.navigation_onlineservice_street_view_location_lon_seconds;
            }
            case 7: {
                return navigationOnlineServiceStreetViewLocationDataCollector.navigation_onlineservice_street_view_location_lat_degree;
            }
            case 8: {
                return navigationOnlineServiceStreetViewLocationDataCollector.navigation_onlineservice_street_view_location_lat_minutes;
            }
            case 9: {
                return navigationOnlineServiceStreetViewLocationDataCollector.navigation_onlineservice_street_view_location_lat_seconds;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        NavigationOnlineServiceStreetViewLocationDataCollector navigationOnlineServiceStreetViewLocationDataCollector = (NavigationOnlineServiceStreetViewLocationDataCollector)object;
        switch (n) {
            case 0: {
                return navigationOnlineServiceStreetViewLocationDataCollector.navigation_onlineservice_street_view_location_data_city;
            }
            case 1: {
                return navigationOnlineServiceStreetViewLocationDataCollector.navigation_onlineservice_street_view_location_data_city_refinement;
            }
            case 2: {
                return navigationOnlineServiceStreetViewLocationDataCollector.navigation_onlineservice_street_view_location_data_street;
            }
            case 3: {
                return navigationOnlineServiceStreetViewLocationDataCollector.navigation_onlineservice_street_view_location_data_street_refinement;
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
        throw new IllegalArgumentException();
    }
}

