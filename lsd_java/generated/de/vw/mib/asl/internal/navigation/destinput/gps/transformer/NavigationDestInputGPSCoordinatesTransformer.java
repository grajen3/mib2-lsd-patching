/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.destinput.gps.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.navigation.destinput.gps.transformer.NavigationDestInputGPSCoordinatesCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class NavigationDestInputGPSCoordinatesTransformer
extends ItemTransformerAdapter {
    public static final int NAVIGATION_DESTINPUT_GPS_COORDINATES_LAT_DEGREE_INTEGER;
    public static final int NAVIGATION_DESTINPUT_GPS_COORDINATES_LAT_DEGREE_ONE_INTEGER;
    public static final int NAVIGATION_DESTINPUT_GPS_COORDINATES_LAT_DEGREE_TEN_INTEGER;
    public static final int NAVIGATION_DESTINPUT_GPS_COORDINATES_LAT_HEMISPHERE_INTEGER;
    public static final int NAVIGATION_DESTINPUT_GPS_COORDINATES_LAT_MIN_INTEGER;
    public static final int NAVIGATION_DESTINPUT_GPS_COORDINATES_LAT_MIN_ONE_INTEGER;
    public static final int NAVIGATION_DESTINPUT_GPS_COORDINATES_LAT_MIN_TEN_INTEGER;
    public static final int NAVIGATION_DESTINPUT_GPS_COORDINATES_LAT_SEC_INTEGER;
    public static final int NAVIGATION_DESTINPUT_GPS_COORDINATES_LAT_SEC_ONE_INTEGER;
    public static final int NAVIGATION_DESTINPUT_GPS_COORDINATES_LAT_SEC_TEN_INTEGER;
    public static final int NAVIGATION_DESTINPUT_GPS_COORDINATES_LAT_SEC_TENTH_INTEGER;
    public static final int NAVIGATION_DESTINPUT_GPS_COORDINATES_LON_DEGREE_INTEGER;
    public static final int NAVIGATION_DESTINPUT_GPS_COORDINATES_LON_DEGREE_HUNDRED_INTEGER;
    public static final int NAVIGATION_DESTINPUT_GPS_COORDINATES_LON_DEGREE_ONE_INTEGER;
    public static final int NAVIGATION_DESTINPUT_GPS_COORDINATES_LON_DEGREE_TEN_INTEGER;
    public static final int NAVIGATION_DESTINPUT_GPS_COORDINATES_LON_HEMISPHERE_INTEGER;
    public static final int NAVIGATION_DESTINPUT_GPS_COORDINATES_LON_MIN_INTEGER;
    public static final int NAVIGATION_DESTINPUT_GPS_COORDINATES_LON_MIN_ONE_INTEGER;
    public static final int NAVIGATION_DESTINPUT_GPS_COORDINATES_LON_MIN_TEN_INTEGER;
    public static final int NAVIGATION_DESTINPUT_GPS_COORDINATES_LON_SEC_INTEGER;
    public static final int NAVIGATION_DESTINPUT_GPS_COORDINATES_LON_SEC_ONE_INTEGER;
    public static final int NAVIGATION_DESTINPUT_GPS_COORDINATES_LON_SEC_TEN_INTEGER;
    public static final int NAVIGATION_DESTINPUT_GPS_COORDINATES_LON_SEC_TENTH_INTEGER;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[23];
        int n = 0;
        stringArray[n++] = TransformerUtil.getIntAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 8, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 9, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 10, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 11, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 12, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 13, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 14, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 15, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 16, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 17, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 18, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 19, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 20, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 21, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 22, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(3558);
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
                return new Integer(this.getInt(n, object));
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
        NavigationDestInputGPSCoordinatesCollector navigationDestInputGPSCoordinatesCollector = (NavigationDestInputGPSCoordinatesCollector)object;
        switch (n) {
            case 0: {
                return navigationDestInputGPSCoordinatesCollector.navigation_destinput_gps_coordinates_lat_degree;
            }
            case 1: {
                return navigationDestInputGPSCoordinatesCollector.navigation_destinput_gps_coordinates_lat_degree_one;
            }
            case 2: {
                return navigationDestInputGPSCoordinatesCollector.navigation_destinput_gps_coordinates_lat_degree_ten;
            }
            case 3: {
                return navigationDestInputGPSCoordinatesCollector.navigation_destinput_gps_coordinates_lat_hemisphere;
            }
            case 4: {
                return navigationDestInputGPSCoordinatesCollector.navigation_destinput_gps_coordinates_lat_min;
            }
            case 5: {
                return navigationDestInputGPSCoordinatesCollector.navigation_destinput_gps_coordinates_lat_min_one;
            }
            case 6: {
                return navigationDestInputGPSCoordinatesCollector.navigation_destinput_gps_coordinates_lat_min_ten;
            }
            case 7: {
                return navigationDestInputGPSCoordinatesCollector.navigation_destinput_gps_coordinates_lat_sec;
            }
            case 8: {
                return navigationDestInputGPSCoordinatesCollector.navigation_destinput_gps_coordinates_lat_sec_one;
            }
            case 9: {
                return navigationDestInputGPSCoordinatesCollector.navigation_destinput_gps_coordinates_lat_sec_ten;
            }
            case 10: {
                return navigationDestInputGPSCoordinatesCollector.navigation_destinput_gps_coordinates_lat_sec_tenth;
            }
            case 11: {
                return navigationDestInputGPSCoordinatesCollector.navigation_destinput_gps_coordinates_lon_degree;
            }
            case 12: {
                return navigationDestInputGPSCoordinatesCollector.navigation_destinput_gps_coordinates_lon_degree_hundred;
            }
            case 13: {
                return navigationDestInputGPSCoordinatesCollector.navigation_destinput_gps_coordinates_lon_degree_one;
            }
            case 14: {
                return navigationDestInputGPSCoordinatesCollector.navigation_destinput_gps_coordinates_lon_degree_ten;
            }
            case 15: {
                return navigationDestInputGPSCoordinatesCollector.navigation_destinput_gps_coordinates_lon_hemisphere;
            }
            case 16: {
                return navigationDestInputGPSCoordinatesCollector.navigation_destinput_gps_coordinates_lon_min;
            }
            case 17: {
                return navigationDestInputGPSCoordinatesCollector.navigation_destinput_gps_coordinates_lon_min_one;
            }
            case 18: {
                return navigationDestInputGPSCoordinatesCollector.navigation_destinput_gps_coordinates_lon_min_ten;
            }
            case 19: {
                return navigationDestInputGPSCoordinatesCollector.navigation_destinput_gps_coordinates_lon_sec;
            }
            case 20: {
                return navigationDestInputGPSCoordinatesCollector.navigation_destinput_gps_coordinates_lon_sec_one;
            }
            case 21: {
                return navigationDestInputGPSCoordinatesCollector.navigation_destinput_gps_coordinates_lon_sec_ten;
            }
            case 22: {
                return navigationDestInputGPSCoordinatesCollector.navigation_destinput_gps_coordinates_lon_sec_tenth;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
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

