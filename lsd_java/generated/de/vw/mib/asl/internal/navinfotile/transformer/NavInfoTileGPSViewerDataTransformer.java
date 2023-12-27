/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navinfotile.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.navinfotile.transformer.NavInfoTileGPSViewerDataCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class NavInfoTileGPSViewerDataTransformer
extends ItemTransformerAdapter {
    public static final int NAVINFOTILE_GPS_VIEWER_DATA_CITY_STRING;
    public static final int NAVINFOTILE_GPS_VIEWER_DATA_CITY_REFINEMENT_STRING;
    public static final int NAVINFOTILE_GPS_VIEWER_DATA_STREET_STRING;
    public static final int NAVINFOTILE_GPS_VIEWER_DATA_STREET_REFINEMENT_STRING;
    public static final int NAVINFOTILE_GPS_VIEWER_DATA_HOUSE_NUMBER_STRING;
    public static final int NAVINFOTILE_GPS_VIEWER_DATA_LAT_DEGREE_INTEGER;
    public static final int NAVINFOTILE_GPS_VIEWER_DATA_LAT_MINUTES_INTEGER;
    public static final int NAVINFOTILE_GPS_VIEWER_DATA_LAT_SECONDS_INTEGER;
    public static final int NAVINFOTILE_GPS_VIEWER_DATA_LON_DEGREE_INTEGER;
    public static final int NAVINFOTILE_GPS_VIEWER_DATA_LON_MINUTES_INTEGER;
    public static final int NAVINFOTILE_GPS_VIEWER_DATA_LON_SECONDS_INTEGER;
    public static final int NAVINFOTILE_GPS_VIEWER_DATA_ALTITUDE_INTEGER;
    public static final int NAVINFOTILE_GPS_VIEWER_DATA_NORTH_DIRECTION_INTEGER;
    public static final int NAVINFOTILE_GPS_VIEWER_DATA_SPEED_INTEGER;
    public static final int NAVINFOTILE_GPS_VIEWER_DATA_GPS_STATUS_INTEGER;
    public static final int NAVINFOTILE_GPS_VIEWER_DATA_SATELLITES_INTEGER;
    public static final int NAVINFOTILE_GPS_VIEWER_DATA_VISIBLE_SATELLITES_INTEGER;
    public static final int NAVINFOTILE_GPS_VIEWER_DATA_TRACKED_SATELLITES_INTEGER;
    public static final int NAVINFOTILE_GPS_VIEWER_DATA_USED_SATELLITES_INTEGER;
    public static final int NAVINFOTILE_GPS_VIEWER_DATA_HDOPVDOP_STRING;
    public static final int NAVINFOTILE_GPS_VIEWER_DATA_ADDRESS_FOR_FIX_FORMATTER_FIX_FORMATTER_FIELD_DATA;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[21];
        int n = 0;
        stringArray[n++] = TransformerUtil.getStringAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 4, object);
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
        stringArray[n++] = TransformerUtil.getStringAsString(this, 19, object);
        stringArray[n++] = TransformerUtil.getFixFormatterFieldDataAsString(this, 20, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(-231908864);
    }

    @Override
    public int getColumnCount() {
        return 21;
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
            case 20: {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(int n, Object object) {
        switch (n) {
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
            case 18: {
                return new Integer(this.getInt(n, object));
            }
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 19: {
                return this.getString(n, object);
            }
            case 20: {
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
        NavInfoTileGPSViewerDataCollector navInfoTileGPSViewerDataCollector = (NavInfoTileGPSViewerDataCollector)object;
        switch (n) {
            case 5: {
                return navInfoTileGPSViewerDataCollector.navinfotile_gps_viewer_data_lat_degree;
            }
            case 6: {
                return navInfoTileGPSViewerDataCollector.navinfotile_gps_viewer_data_lat_minutes;
            }
            case 7: {
                return navInfoTileGPSViewerDataCollector.navinfotile_gps_viewer_data_lat_seconds;
            }
            case 8: {
                return navInfoTileGPSViewerDataCollector.navinfotile_gps_viewer_data_lon_degree;
            }
            case 9: {
                return navInfoTileGPSViewerDataCollector.navinfotile_gps_viewer_data_lon_minutes;
            }
            case 10: {
                return navInfoTileGPSViewerDataCollector.navinfotile_gps_viewer_data_lon_seconds;
            }
            case 11: {
                return navInfoTileGPSViewerDataCollector.navinfotile_gps_viewer_data_altitude;
            }
            case 12: {
                return navInfoTileGPSViewerDataCollector.navinfotile_gps_viewer_data_north_direction;
            }
            case 13: {
                return navInfoTileGPSViewerDataCollector.navinfotile_gps_viewer_data_speed;
            }
            case 14: {
                return navInfoTileGPSViewerDataCollector.navinfotile_gps_viewer_data_gps_status;
            }
            case 15: {
                return navInfoTileGPSViewerDataCollector.navinfotile_gps_viewer_data_satellites;
            }
            case 16: {
                return navInfoTileGPSViewerDataCollector.navinfotile_gps_viewer_data_visible_satellites;
            }
            case 17: {
                return navInfoTileGPSViewerDataCollector.navinfotile_gps_viewer_data_tracked_satellites;
            }
            case 18: {
                return navInfoTileGPSViewerDataCollector.navinfotile_gps_viewer_data_used_satellites;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        NavInfoTileGPSViewerDataCollector navInfoTileGPSViewerDataCollector = (NavInfoTileGPSViewerDataCollector)object;
        switch (n) {
            case 0: {
                return navInfoTileGPSViewerDataCollector.navinfotile_gps_viewer_data_city;
            }
            case 1: {
                return navInfoTileGPSViewerDataCollector.navinfotile_gps_viewer_data_city_refinement;
            }
            case 2: {
                return navInfoTileGPSViewerDataCollector.navinfotile_gps_viewer_data_street;
            }
            case 3: {
                return navInfoTileGPSViewerDataCollector.navinfotile_gps_viewer_data_street_refinement;
            }
            case 4: {
                return navInfoTileGPSViewerDataCollector.navinfotile_gps_viewer_data_house_number;
            }
            case 19: {
                return navInfoTileGPSViewerDataCollector.navinfotile_gps_viewer_data_hdopvdop;
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
        NavInfoTileGPSViewerDataCollector navInfoTileGPSViewerDataCollector = (NavInfoTileGPSViewerDataCollector)object;
        switch (n) {
            case 20: {
                return navInfoTileGPSViewerDataCollector.navinfotile_gps_viewer_data_address_for_fix_formatter;
            }
        }
        throw new IllegalArgumentException();
    }
}

