/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.travellink.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.travellink.transformer.TravelLinkWeatherIsobarMapClickResultDetailsCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class TravelLinkWeatherIsobarMapClickResultDetailsTransformer
extends ItemTransformerAdapter {
    public static final int TRAVELLINK_WEATHER_ISOBAR_MAP_CLICK_RESULT_DETAILS__CATEGORY_INTEGER;
    public static final int TRAVELLINK_WEATHER_ISOBAR_MAP_CLICK_RESULT_DETAILS__COUNT_INTEGER;
    public static final int TRAVELLINK_WEATHER_ISOBAR_MAP_CLICK_RESULT_DETAILS__ICON_RESOURCE_LOCATOR;
    public static final int TRAVELLINK_WEATHER_ISOBAR_MAP_CLICK_RESULT_DETAILS__LAST_TRACKED_DATE_STRING;
    public static final int TRAVELLINK_WEATHER_ISOBAR_MAP_CLICK_RESULT_DETAILS__LAST_TRACKED_DAY_INTEGER;
    public static final int TRAVELLINK_WEATHER_ISOBAR_MAP_CLICK_RESULT_DETAILS__LAST_TRACKED_HOUR_INTEGER;
    public static final int TRAVELLINK_WEATHER_ISOBAR_MAP_CLICK_RESULT_DETAILS__LAST_TRACKED_MINUTE_INTEGER;
    public static final int TRAVELLINK_WEATHER_ISOBAR_MAP_CLICK_RESULT_DETAILS__LAST_TRACKED_MONTH_INTEGER;
    public static final int TRAVELLINK_WEATHER_ISOBAR_MAP_CLICK_RESULT_DETAILS__LAST_TRACKED_TIME_STRING;
    public static final int TRAVELLINK_WEATHER_ISOBAR_MAP_CLICK_RESULT_DETAILS__LAST_TRACKED_TIME_ZONE_STRING;
    public static final int TRAVELLINK_WEATHER_ISOBAR_MAP_CLICK_RESULT_DETAILS__LAST_TRACKED_WEEK_DAY_INTEGER;
    public static final int TRAVELLINK_WEATHER_ISOBAR_MAP_CLICK_RESULT_DETAILS__LOCATION_INVALID_BOOLEAN;
    public static final int TRAVELLINK_WEATHER_ISOBAR_MAP_CLICK_RESULT_DETAILS__LOCATION_LATITUDE_DEGREE_INTEGER;
    public static final int TRAVELLINK_WEATHER_ISOBAR_MAP_CLICK_RESULT_DETAILS__LOCATION_AS_STRING_STRING;
    public static final int TRAVELLINK_WEATHER_ISOBAR_MAP_CLICK_RESULT_DETAILS__LOCATION_LATITUDE_MINUTE_INTEGER;
    public static final int TRAVELLINK_WEATHER_ISOBAR_MAP_CLICK_RESULT_DETAILS__LOCATION_LATITUDE_SECOND_INTEGER;
    public static final int TRAVELLINK_WEATHER_ISOBAR_MAP_CLICK_RESULT_DETAILS__LOCATION_LONGITUDE_DEGREE_INTEGER;
    public static final int TRAVELLINK_WEATHER_ISOBAR_MAP_CLICK_RESULT_DETAILS__LOCATION_LONGITUDE_MINUTE_INTEGER;
    public static final int TRAVELLINK_WEATHER_ISOBAR_MAP_CLICK_RESULT_DETAILS__LOCATION_LONGITUDE_SECOND_INTEGER;
    public static final int TRAVELLINK_WEATHER_ISOBAR_MAP_CLICK_RESULT_DETAILS__MAX_SUSTAINED_INTEGER;
    public static final int TRAVELLINK_WEATHER_ISOBAR_MAP_CLICK_RESULT_DETAILS__MAX_SUSTAINED_STRING_STRING;
    public static final int TRAVELLINK_WEATHER_ISOBAR_MAP_CLICK_RESULT_DETAILS__MIN_PRESSURE_INTEGER;
    public static final int TRAVELLINK_WEATHER_ISOBAR_MAP_CLICK_RESULT_DETAILS__MIN_PRESSURE_STRING_STRING;
    public static final int TRAVELLINK_WEATHER_ISOBAR_MAP_CLICK_RESULT_DETAILS__MOVING_DIRECTION_INTEGER;
    public static final int TRAVELLINK_WEATHER_ISOBAR_MAP_CLICK_RESULT_DETAILS__NAME_STRING;
    public static final int TRAVELLINK_WEATHER_ISOBAR_MAP_CLICK_RESULT_DETAILS__SPEED_INTEGER;
    public static final int TRAVELLINK_WEATHER_ISOBAR_MAP_CLICK_RESULT_DETAILS__SPEED_STRING_STRING;
    public static final int TRAVELLINK_WEATHER_ISOBAR_MAP_CLICK_RESULT_DETAILS__STATUS_INTEGER;
    public static final int TRAVELLINK_WEATHER_ISOBAR_MAP_CLICK_RESULT_DETAILS__STORM_TYPE_INTEGER;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[29];
        int n = 0;
        stringArray[n++] = TransformerUtil.getIntAsString(this, 19, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 20, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 42, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 39, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 22, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 21, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 25, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 24, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 40, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 41, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 23, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 43, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 26, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 47, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 27, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 28, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 29, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 30, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 31, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 32, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 44, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 33, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 45, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 34, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 35, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 37, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 46, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 36, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 38, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(-1942019328);
    }

    @Override
    public int getColumnCount() {
        return 29;
    }

    @Override
    public boolean isColumnIdSupported(int n) {
        switch (n) {
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
            case 38: 
            case 39: 
            case 40: 
            case 41: 
            case 42: 
            case 43: 
            case 44: 
            case 45: 
            case 46: 
            case 47: {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(int n, Object object) {
        switch (n) {
            case 43: {
                return this.getBoolean(n, object);
            }
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
            case 36: 
            case 37: 
            case 38: {
                return new Integer(this.getInt(n, object));
            }
            case 35: 
            case 39: 
            case 40: 
            case 41: 
            case 44: 
            case 45: 
            case 46: 
            case 47: {
                return this.getString(n, object);
            }
            case 42: {
                return this.getResourceLocator(n, object);
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        TravelLinkWeatherIsobarMapClickResultDetailsCollector travelLinkWeatherIsobarMapClickResultDetailsCollector = (TravelLinkWeatherIsobarMapClickResultDetailsCollector)object;
        switch (n) {
            case 43: {
                return travelLinkWeatherIsobarMapClickResultDetailsCollector.travellink_weather_isobar_map_click_result_details__location_invalid;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        TravelLinkWeatherIsobarMapClickResultDetailsCollector travelLinkWeatherIsobarMapClickResultDetailsCollector = (TravelLinkWeatherIsobarMapClickResultDetailsCollector)object;
        switch (n) {
            case 19: {
                return travelLinkWeatherIsobarMapClickResultDetailsCollector.travellink_weather_isobar_map_click_result_details__category;
            }
            case 20: {
                return travelLinkWeatherIsobarMapClickResultDetailsCollector.travellink_weather_isobar_map_click_result_details__count;
            }
            case 22: {
                return travelLinkWeatherIsobarMapClickResultDetailsCollector.travellink_weather_isobar_map_click_result_details__last_tracked_day;
            }
            case 21: {
                return travelLinkWeatherIsobarMapClickResultDetailsCollector.travellink_weather_isobar_map_click_result_details__last_tracked_hour;
            }
            case 25: {
                return travelLinkWeatherIsobarMapClickResultDetailsCollector.travellink_weather_isobar_map_click_result_details__last_tracked_minute;
            }
            case 24: {
                return travelLinkWeatherIsobarMapClickResultDetailsCollector.travellink_weather_isobar_map_click_result_details__last_tracked_month;
            }
            case 23: {
                return travelLinkWeatherIsobarMapClickResultDetailsCollector.travellink_weather_isobar_map_click_result_details__last_tracked_week_day;
            }
            case 26: {
                return travelLinkWeatherIsobarMapClickResultDetailsCollector.travellink_weather_isobar_map_click_result_details__location_latitude_degree;
            }
            case 27: {
                return travelLinkWeatherIsobarMapClickResultDetailsCollector.travellink_weather_isobar_map_click_result_details__location_latitude_minute;
            }
            case 28: {
                return travelLinkWeatherIsobarMapClickResultDetailsCollector.travellink_weather_isobar_map_click_result_details__location_latitude_second;
            }
            case 29: {
                return travelLinkWeatherIsobarMapClickResultDetailsCollector.travellink_weather_isobar_map_click_result_details__location_longitude_degree;
            }
            case 30: {
                return travelLinkWeatherIsobarMapClickResultDetailsCollector.travellink_weather_isobar_map_click_result_details__location_longitude_minute;
            }
            case 31: {
                return travelLinkWeatherIsobarMapClickResultDetailsCollector.travellink_weather_isobar_map_click_result_details__location_longitude_second;
            }
            case 32: {
                return travelLinkWeatherIsobarMapClickResultDetailsCollector.travellink_weather_isobar_map_click_result_details__max_sustained;
            }
            case 33: {
                return travelLinkWeatherIsobarMapClickResultDetailsCollector.travellink_weather_isobar_map_click_result_details__min_pressure;
            }
            case 34: {
                return travelLinkWeatherIsobarMapClickResultDetailsCollector.travellink_weather_isobar_map_click_result_details__moving_direction;
            }
            case 37: {
                return travelLinkWeatherIsobarMapClickResultDetailsCollector.travellink_weather_isobar_map_click_result_details__speed;
            }
            case 36: {
                return travelLinkWeatherIsobarMapClickResultDetailsCollector.travellink_weather_isobar_map_click_result_details__status;
            }
            case 38: {
                return travelLinkWeatherIsobarMapClickResultDetailsCollector.travellink_weather_isobar_map_click_result_details__storm_type;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        TravelLinkWeatherIsobarMapClickResultDetailsCollector travelLinkWeatherIsobarMapClickResultDetailsCollector = (TravelLinkWeatherIsobarMapClickResultDetailsCollector)object;
        switch (n) {
            case 39: {
                return travelLinkWeatherIsobarMapClickResultDetailsCollector.travellink_weather_isobar_map_click_result_details__last_tracked_date;
            }
            case 40: {
                return travelLinkWeatherIsobarMapClickResultDetailsCollector.travellink_weather_isobar_map_click_result_details__last_tracked_time;
            }
            case 41: {
                return travelLinkWeatherIsobarMapClickResultDetailsCollector.travellink_weather_isobar_map_click_result_details__last_tracked_time_zone;
            }
            case 47: {
                return travelLinkWeatherIsobarMapClickResultDetailsCollector.travellink_weather_isobar_map_click_result_details__location_as_string;
            }
            case 44: {
                return travelLinkWeatherIsobarMapClickResultDetailsCollector.travellink_weather_isobar_map_click_result_details__max_sustained_string;
            }
            case 45: {
                return travelLinkWeatherIsobarMapClickResultDetailsCollector.travellink_weather_isobar_map_click_result_details__min_pressure_string;
            }
            case 35: {
                return travelLinkWeatherIsobarMapClickResultDetailsCollector.travellink_weather_isobar_map_click_result_details__name;
            }
            case 46: {
                return travelLinkWeatherIsobarMapClickResultDetailsCollector.travellink_weather_isobar_map_click_result_details__speed_string;
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
        TravelLinkWeatherIsobarMapClickResultDetailsCollector travelLinkWeatherIsobarMapClickResultDetailsCollector = (TravelLinkWeatherIsobarMapClickResultDetailsCollector)object;
        switch (n) {
            case 42: {
                return travelLinkWeatherIsobarMapClickResultDetailsCollector.travellink_weather_isobar_map_click_result_details__icon;
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
        throw new IllegalArgumentException();
    }
}

