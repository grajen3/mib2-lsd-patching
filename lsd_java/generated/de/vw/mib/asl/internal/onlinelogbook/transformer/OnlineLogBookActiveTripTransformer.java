/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.onlinelogbook.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.onlinelogbook.transformer.OnlineLogBookActiveTripCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class OnlineLogBookActiveTripTransformer
extends ItemTransformerAdapter {
    public static final int ONLINELOGBOOK_ACTIVE_TRIP_INDEX_INTEGER;
    public static final int ONLINELOGBOOK_ACTIVE_TRIP_STATUS_INTEGER;
    public static final int ONLINELOGBOOK_ACTIVE_TRIP_START_TIME_YEAR_INTEGER;
    public static final int ONLINELOGBOOK_ACTIVE_TRIP_START_TIME_MONTH_INTEGER;
    public static final int ONLINELOGBOOK_ACTIVE_TRIP_START_TIME_DAY_INTEGER;
    public static final int ONLINELOGBOOK_ACTIVE_TRIP_START_TIME_HOUR_INTEGER;
    public static final int ONLINELOGBOOK_ACTIVE_TRIP_START_TIME_MINUTE_INTEGER;
    public static final int ONLINELOGBOOK_ACTIVE_TRIP_START_TIME_SECOND_INTEGER;
    public static final int ONLINELOGBOOK_ACTIVE_TRIP_MILEAGE_AT_START_INTEGER;
    public static final int ONLINELOGBOOK_ACTIVE_TRIP_MILEAGE_AT_STOP_INTEGER;
    public static final int ONLINELOGBOOK_ACTIVE_TRIP_MILEAGE_UNIT_INTEGER;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[11];
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
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(1410429184);
    }

    @Override
    public int getColumnCount() {
        return 11;
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
            case 10: {
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
            case 10: {
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
        OnlineLogBookActiveTripCollector onlineLogBookActiveTripCollector = (OnlineLogBookActiveTripCollector)object;
        switch (n) {
            case 0: {
                return onlineLogBookActiveTripCollector.onlinelogbook_active_trip_index;
            }
            case 1: {
                return onlineLogBookActiveTripCollector.onlinelogbook_active_trip_status;
            }
            case 2: {
                return onlineLogBookActiveTripCollector.onlinelogbook_active_trip_start_time_year;
            }
            case 3: {
                return onlineLogBookActiveTripCollector.onlinelogbook_active_trip_start_time_month;
            }
            case 4: {
                return onlineLogBookActiveTripCollector.onlinelogbook_active_trip_start_time_day;
            }
            case 5: {
                return onlineLogBookActiveTripCollector.onlinelogbook_active_trip_start_time_hour;
            }
            case 6: {
                return onlineLogBookActiveTripCollector.onlinelogbook_active_trip_start_time_minute;
            }
            case 7: {
                return onlineLogBookActiveTripCollector.onlinelogbook_active_trip_start_time_second;
            }
            case 8: {
                return onlineLogBookActiveTripCollector.onlinelogbook_active_trip_mileage_at_start;
            }
            case 9: {
                return onlineLogBookActiveTripCollector.onlinelogbook_active_trip_mileage_at_stop;
            }
            case 10: {
                return onlineLogBookActiveTripCollector.onlinelogbook_active_trip_mileage_unit;
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

