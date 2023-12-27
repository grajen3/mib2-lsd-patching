/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.travellink.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.travellink.transformer.TravelLinkCurrentWeatherReportCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class TravelLinkCurrentWeatherReportTransformer
extends ItemTransformerAdapter {
    public static final int TRAVELLINK_CURRENT_WEATHER_REPORT__AIR_QUALITY_INTEGER;
    public static final int TRAVELLINK_CURRENT_WEATHER_REPORT__CLOUD_COVER_INTEGER;
    public static final int TRAVELLINK_CURRENT_WEATHER_REPORT__CONDITION_INTEGER;
    public static final int TRAVELLINK_CURRENT_WEATHER_REPORT__CURRENT_TEMP_INTEGER;
    public static final int TRAVELLINK_CURRENT_WEATHER_REPORT__CURRENT_TEMP_AS_STRING_STRING;
    public static final int TRAVELLINK_CURRENT_WEATHER_REPORT__HUMIDITY_INTEGER;
    public static final int TRAVELLINK_CURRENT_WEATHER_REPORT__HUMIDITY_AS_STRING_STRING;
    public static final int TRAVELLINK_CURRENT_WEATHER_REPORT__MAX_TEMP_INTEGER;
    public static final int TRAVELLINK_CURRENT_WEATHER_REPORT__MIN_TEMP_INTEGER;
    public static final int TRAVELLINK_CURRENT_WEATHER_REPORT__POLLEN_COUNT_INTEGER;
    public static final int TRAVELLINK_CURRENT_WEATHER_REPORT__PRECIPITATION_PROBABILITY_INTEGER;
    public static final int TRAVELLINK_CURRENT_WEATHER_REPORT__PRECIPITATION_PROBABILITY_AS_STRING_STRING;
    public static final int TRAVELLINK_CURRENT_WEATHER_REPORT__PRECIPITATION_RANGE_AS_STRING_STRING;
    public static final int TRAVELLINK_CURRENT_WEATHER_REPORT__PRECIPITATION_RANGE_MAX_INTEGER;
    public static final int TRAVELLINK_CURRENT_WEATHER_REPORT__PRECIPITATION_RANGE_MIN_INTEGER;
    public static final int TRAVELLINK_CURRENT_WEATHER_REPORT__PRECIPITATION_TYPE_INTEGER;
    public static final int TRAVELLINK_CURRENT_WEATHER_REPORT__UV_RISK_INTEGER;
    public static final int TRAVELLINK_CURRENT_WEATHER_REPORT__UV_RISK__MIN_MAX_STRING;
    public static final int TRAVELLINK_CURRENT_WEATHER_REPORT__WIND_DIRECTION_INTEGER;
    public static final int TRAVELLINK_CURRENT_WEATHER_REPORT__WIND_SPEED_INTEGER;
    public static final int TRAVELLINK_CURRENT_WEATHER_REPORT__WIND_SPEED_AS_STRING_STRING;
    public static final int TRAVELLINK_CURRENT_WEATHER_REPORT__WIND_SPEED_UNIT_AS_STRING_STRING;
    public static final int TRAVELLINK_CURRENT_WEATHER_REPORT__POLLEN_COUNT_NUMBER_STRING;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[23];
        int n = 0;
        stringArray[n++] = TransformerUtil.getIntAsString(this, 8, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 9, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 10, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 13, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 14, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 15, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 11, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 16, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 17, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 20, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 12, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 21, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 18, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 19, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 22, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(2134844160);
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
            case 20: {
                return new Integer(this.getInt(n, object));
            }
            case 14: 
            case 15: 
            case 16: 
            case 17: 
            case 18: 
            case 19: 
            case 21: 
            case 22: {
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
        TravelLinkCurrentWeatherReportCollector travelLinkCurrentWeatherReportCollector = (TravelLinkCurrentWeatherReportCollector)object;
        switch (n) {
            case 8: {
                return travelLinkCurrentWeatherReportCollector.travellink_current_weather_report__air_quality;
            }
            case 9: {
                return travelLinkCurrentWeatherReportCollector.travellink_current_weather_report__cloud_cover;
            }
            case 10: {
                return travelLinkCurrentWeatherReportCollector.travellink_current_weather_report__condition;
            }
            case 13: {
                return travelLinkCurrentWeatherReportCollector.travellink_current_weather_report__current_temp;
            }
            case 0: {
                return travelLinkCurrentWeatherReportCollector.travellink_current_weather_report__humidity;
            }
            case 1: {
                return travelLinkCurrentWeatherReportCollector.travellink_current_weather_report__max_temp;
            }
            case 2: {
                return travelLinkCurrentWeatherReportCollector.travellink_current_weather_report__min_temp;
            }
            case 11: {
                return travelLinkCurrentWeatherReportCollector.travellink_current_weather_report__pollen_count;
            }
            case 5: {
                return travelLinkCurrentWeatherReportCollector.travellink_current_weather_report__precipitation_probability;
            }
            case 6: {
                return travelLinkCurrentWeatherReportCollector.travellink_current_weather_report__precipitation_range_max;
            }
            case 7: {
                return travelLinkCurrentWeatherReportCollector.travellink_current_weather_report__precipitation_range_min;
            }
            case 20: {
                return travelLinkCurrentWeatherReportCollector.travellink_current_weather_report__precipitation_type;
            }
            case 12: {
                return travelLinkCurrentWeatherReportCollector.travellink_current_weather_report__uv_risk;
            }
            case 3: {
                return travelLinkCurrentWeatherReportCollector.travellink_current_weather_report__wind_direction;
            }
            case 4: {
                return travelLinkCurrentWeatherReportCollector.travellink_current_weather_report__wind_speed;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        TravelLinkCurrentWeatherReportCollector travelLinkCurrentWeatherReportCollector = (TravelLinkCurrentWeatherReportCollector)object;
        switch (n) {
            case 14: {
                return travelLinkCurrentWeatherReportCollector.travellink_current_weather_report__current_temp_as_string;
            }
            case 15: {
                return travelLinkCurrentWeatherReportCollector.travellink_current_weather_report__humidity_as_string;
            }
            case 16: {
                return travelLinkCurrentWeatherReportCollector.travellink_current_weather_report__precipitation_probability_as_string;
            }
            case 17: {
                return travelLinkCurrentWeatherReportCollector.travellink_current_weather_report__precipitation_range_as_string;
            }
            case 21: {
                return travelLinkCurrentWeatherReportCollector.travellink_current_weather_report__uv_risk__min_max;
            }
            case 18: {
                return travelLinkCurrentWeatherReportCollector.travellink_current_weather_report__wind_speed_as_string;
            }
            case 19: {
                return travelLinkCurrentWeatherReportCollector.travellink_current_weather_report__wind_speed_unit_as_string;
            }
            case 22: {
                return travelLinkCurrentWeatherReportCollector.travellink_current_weather_report__pollen_count_number;
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

