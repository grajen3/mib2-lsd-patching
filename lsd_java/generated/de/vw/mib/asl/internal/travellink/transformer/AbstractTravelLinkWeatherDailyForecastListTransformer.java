/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.travellink.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import org.dsi.ifc.global.ResourceLocator;

public abstract class AbstractTravelLinkWeatherDailyForecastListTransformer
extends ItemTransformerAdapter {
    public static final int TRAVELLINK_WEATHER_DAILY_FORECAST_LIST__CONDITION_INTEGER;
    public static final int TRAVELLINK_WEATHER_DAILY_FORECAST_LIST__DAY_INTEGER;
    public static final int TRAVELLINK_WEATHER_DAILY_FORECAST_LIST__MAX_TEMP_INTEGER;
    public static final int TRAVELLINK_WEATHER_DAILY_FORECAST_LIST__MAX_TEMP_AS_STRING_STRING;
    public static final int TRAVELLINK_WEATHER_DAILY_FORECAST_LIST__MAX_TEMP_STRING_STRING;
    public static final int TRAVELLINK_WEATHER_DAILY_FORECAST_LIST__MIN_TEMP_INTEGER;
    public static final int TRAVELLINK_WEATHER_DAILY_FORECAST_LIST__MIN_TEMP_AS_STRING_STRING;
    public static final int TRAVELLINK_WEATHER_DAILY_FORECAST_LIST__MIN_TEMP_STRING_STRING;
    public static final int TRAVELLINK_WEATHER_DAILY_FORECAST_LIST__MONTH_INTEGER;
    public static final int TRAVELLINK_WEATHER_DAILY_FORECAST_LIST__PRECIPITATION_PROBABILITY_INTEGER;
    public static final int TRAVELLINK_WEATHER_DAILY_FORECAST_LIST__PRECIPITATION_PROBABILITY_STRING_STRING;
    public static final int TRAVELLINK_WEATHER_DAILY_FORECAST_LIST__WEEK_DAY_INTEGER;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[12];
        int n = 0;
        stringArray[n++] = TransformerUtil.getIntAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 10, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 11, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 13, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 12, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 14, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 9, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 15, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 8, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(-2126568704);
    }

    @Override
    public int getColumnCount() {
        return 12;
    }

    @Override
    public boolean isColumnIdSupported(int n) {
        switch (n) {
            case 0: 
            case 1: 
            case 2: 
            case 5: 
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 14: 
            case 15: {
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
            case 5: 
            case 8: 
            case 9: 
            case 10: {
                return new Integer(this.getInt(n, object));
            }
            case 11: 
            case 12: 
            case 13: 
            case 14: 
            case 15: {
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

