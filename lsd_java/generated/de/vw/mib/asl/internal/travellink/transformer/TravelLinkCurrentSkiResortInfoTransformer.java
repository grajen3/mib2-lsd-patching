/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.travellink.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.travellink.transformer.TravelLinkCurrentSkiResortInfoCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class TravelLinkCurrentSkiResortInfoTransformer
extends ItemTransformerAdapter {
    public static final int TRAVELLINK_CURRENT_SKI_RESORT_INFO__CURRENT_TEMP_INTEGER;
    public static final int TRAVELLINK_CURRENT_SKI_RESORT_INFO__GROOMING_INTEGER;
    public static final int TRAVELLINK_CURRENT_SKI_RESORT_INFO__MAX_NEW_SNOW_HEIGHT_INTEGER;
    public static final int TRAVELLINK_CURRENT_SKI_RESORT_INFO__MAX_OPEN_TRAILS_INTEGER;
    public static final int TRAVELLINK_CURRENT_SKI_RESORT_INFO__MAX_SNOW_HEIGHT_INTEGER;
    public static final int TRAVELLINK_CURRENT_SKI_RESORT_INFO__MAX_TEMP_INTEGER;
    public static final int TRAVELLINK_CURRENT_SKI_RESORT_INFO__MIN_NEW_SNOW_HEIGHT_INTEGER;
    public static final int TRAVELLINK_CURRENT_SKI_RESORT_INFO__MIN_OPEN_TRAILS_INTEGER;
    public static final int TRAVELLINK_CURRENT_SKI_RESORT_INFO__MIN_SNOW_HEIGHT_INTEGER;
    public static final int TRAVELLINK_CURRENT_SKI_RESORT_INFO__MIN_TEMP_INTEGER;
    public static final int TRAVELLINK_CURRENT_SKI_RESORT_INFO__NAME_STRING;
    public static final int TRAVELLINK_CURRENT_SKI_RESORT_INFO__NIGHT_SKIING_INTEGER;
    public static final int TRAVELLINK_CURRENT_SKI_RESORT_INFO__OPEN_LIFTS_INTEGER;
    public static final int TRAVELLINK_CURRENT_SKI_RESORT_INFO__RESORT_CLOSED_BOOLEAN;
    public static final int TRAVELLINK_CURRENT_SKI_RESORT_INFO__SNOWBOARDING_INTEGER;
    public static final int TRAVELLINK_CURRENT_SKI_RESORT_INFO__SNOW_CONDITION_INTEGER;
    public static final int TRAVELLINK_CURRENT_SKI_RESORT_INFO__SNOW_MAKING_INTEGER;
    public static final int TRAVELLINK_CURRENT_SKI_RESORT_INFO__STATE_ABBREVIATION_STRING;
    public static final int TRAVELLINK_CURRENT_SKI_RESORT_INFO__WEATHER_CONDITION_INTEGER;
    public static final int TRAVELLINK_CURRENT_SKI_RESORT_INFO__WIND_CONDITION_INTEGER;
    public static final int TRAVELLINK_CURRENT_SKI_RESORT_INFO__CURRENT_TEMP_STRING_STRING;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[21];
        int n = 0;
        stringArray[n++] = TransformerUtil.getIntAsString(this, 15, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 16, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 17, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 18, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 19, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 8, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 9, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 13, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 10, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 11, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 12, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 14, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 20, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(-2093014272);
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
            case 8: {
                return this.getBoolean(n, object);
            }
            case 0: 
            case 1: 
            case 2: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 9: 
            case 10: 
            case 12: 
            case 13: 
            case 14: 
            case 15: 
            case 16: 
            case 17: 
            case 18: 
            case 19: {
                return new Integer(this.getInt(n, object));
            }
            case 3: 
            case 11: 
            case 20: {
                return this.getString(n, object);
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        TravelLinkCurrentSkiResortInfoCollector travelLinkCurrentSkiResortInfoCollector = (TravelLinkCurrentSkiResortInfoCollector)object;
        switch (n) {
            case 8: {
                return travelLinkCurrentSkiResortInfoCollector.travellink_current_ski_resort_info__resort_closed;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        TravelLinkCurrentSkiResortInfoCollector travelLinkCurrentSkiResortInfoCollector = (TravelLinkCurrentSkiResortInfoCollector)object;
        switch (n) {
            case 15: {
                return travelLinkCurrentSkiResortInfoCollector.travellink_current_ski_resort_info__current_temp;
            }
            case 2: {
                return travelLinkCurrentSkiResortInfoCollector.travellink_current_ski_resort_info__grooming;
            }
            case 16: {
                return travelLinkCurrentSkiResortInfoCollector.travellink_current_ski_resort_info__max_new_snow_height;
            }
            case 5: {
                return travelLinkCurrentSkiResortInfoCollector.travellink_current_ski_resort_info__max_open_trails;
            }
            case 17: {
                return travelLinkCurrentSkiResortInfoCollector.travellink_current_ski_resort_info__max_snow_height;
            }
            case 0: {
                return travelLinkCurrentSkiResortInfoCollector.travellink_current_ski_resort_info__max_temp;
            }
            case 18: {
                return travelLinkCurrentSkiResortInfoCollector.travellink_current_ski_resort_info__min_new_snow_height;
            }
            case 6: {
                return travelLinkCurrentSkiResortInfoCollector.travellink_current_ski_resort_info__min_open_trails;
            }
            case 19: {
                return travelLinkCurrentSkiResortInfoCollector.travellink_current_ski_resort_info__min_snow_height;
            }
            case 1: {
                return travelLinkCurrentSkiResortInfoCollector.travellink_current_ski_resort_info__min_temp;
            }
            case 4: {
                return travelLinkCurrentSkiResortInfoCollector.travellink_current_ski_resort_info__night_skiing;
            }
            case 7: {
                return travelLinkCurrentSkiResortInfoCollector.travellink_current_ski_resort_info__open_lifts;
            }
            case 9: {
                return travelLinkCurrentSkiResortInfoCollector.travellink_current_ski_resort_info__snowboarding;
            }
            case 13: {
                return travelLinkCurrentSkiResortInfoCollector.travellink_current_ski_resort_info__snow_condition;
            }
            case 10: {
                return travelLinkCurrentSkiResortInfoCollector.travellink_current_ski_resort_info__snow_making;
            }
            case 12: {
                return travelLinkCurrentSkiResortInfoCollector.travellink_current_ski_resort_info__weather_condition;
            }
            case 14: {
                return travelLinkCurrentSkiResortInfoCollector.travellink_current_ski_resort_info__wind_condition;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        TravelLinkCurrentSkiResortInfoCollector travelLinkCurrentSkiResortInfoCollector = (TravelLinkCurrentSkiResortInfoCollector)object;
        switch (n) {
            case 3: {
                return travelLinkCurrentSkiResortInfoCollector.travellink_current_ski_resort_info__name;
            }
            case 11: {
                return travelLinkCurrentSkiResortInfoCollector.travellink_current_ski_resort_info__state_abbreviation;
            }
            case 20: {
                return travelLinkCurrentSkiResortInfoCollector.travellink_current_ski_resort_info__current_temp_string;
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

