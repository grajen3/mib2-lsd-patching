/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.travellink.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;

public abstract class AbstractTravelLinkMoviesResultsListTransformer
extends ItemTransformerAdapter {
    public static final int TRAVELLINK_MOVIES_RESULTS_LIST__ID_INTEGER;
    public static final int TRAVELLINK_MOVIES_RESULTS_LIST__DIRECTION_INTEGER;
    public static final int TRAVELLINK_MOVIES_RESULTS_LIST__DISTANCE_INTEGER;
    public static final int TRAVELLINK_MOVIES_RESULTS_LIST__DIST_DIRECTION_TYPE_INTEGER;
    public static final int TRAVELLINK_MOVIES_RESULTS_LIST__ICON_RESOURCE_LOCATOR;
    public static final int TRAVELLINK_MOVIES_RESULTS_LIST__NAME_STRING;
    public static final int TRAVELLINK_MOVIES_RESULTS_LIST__TIME_AVAILABLE1_BOOLEAN;
    public static final int TRAVELLINK_MOVIES_RESULTS_LIST__TIME_AVAILABLE2_BOOLEAN;
    public static final int TRAVELLINK_MOVIES_RESULTS_LIST__TIME_AVAILABLE3_BOOLEAN;
    public static final int TRAVELLINK_MOVIES_RESULTS_LIST__TIME_HOUR1_INTEGER;
    public static final int TRAVELLINK_MOVIES_RESULTS_LIST__TIME_HOUR2_INTEGER;
    public static final int TRAVELLINK_MOVIES_RESULTS_LIST__TIME_HOUR3_INTEGER;
    public static final int TRAVELLINK_MOVIES_RESULTS_LIST__TIME_MINUTE1_INTEGER;
    public static final int TRAVELLINK_MOVIES_RESULTS_LIST__TIME_MINUTE2_INTEGER;
    public static final int TRAVELLINK_MOVIES_RESULTS_LIST__TIME_MINUTE3_INTEGER;
    public static final int TRAVELLINK_MOVIES_RESULTS_LIST__TIME_ZONE_ABBREVIATION1_STRING;
    public static final int TRAVELLINK_MOVIES_RESULTS_LIST__TIME_ZONE_ABBREVIATION2_STRING;
    public static final int TRAVELLINK_MOVIES_RESULTS_LIST__TIME_ZONE_ABBREVIATION3_STRING;
    public static final int TRAVELLINK_MOVIES_RESULTS_LIST__DISTANCE_AND_UNIT_STRING;
    public static final int TRAVELLINK_MOVIES_RESULTS_LIST__TIME1_STRING;
    public static final int TRAVELLINK_MOVIES_RESULTS_LIST__TIME2_STRING;
    public static final int TRAVELLINK_MOVIES_RESULTS_LIST__TIME3_STRING;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[22];
        int n = 0;
        stringArray[n++] = TransformerUtil.getIntAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 8, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 9, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 10, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 11, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 12, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 13, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 14, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 15, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 16, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 17, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 18, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 19, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 20, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 21, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(-1338039552);
    }

    @Override
    public int getColumnCount() {
        return 22;
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
            case 21: {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(int n, Object object) {
        switch (n) {
            case 6: 
            case 7: 
            case 8: {
                return this.getBoolean(n, object);
            }
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 14: {
                return new Integer(this.getInt(n, object));
            }
            case 5: 
            case 15: 
            case 16: 
            case 17: 
            case 18: 
            case 19: 
            case 20: 
            case 21: {
                return this.getString(n, object);
            }
            case 4: {
                return this.getResourceLocator(n, object);
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

