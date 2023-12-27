/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.tourmode.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;

public abstract class AbstractNavigationTourModeTourListTransformer
extends ItemTransformerAdapter {
    public static final int NAVIGATION_TOURMODE_TOUR_LIST_CITY_STRING;
    public static final int NAVIGATION_TOURMODE_TOUR_LIST_CITY_CENTER_STRING;
    public static final int NAVIGATION_TOURMODE_TOUR_LIST_CROSSING_STRING;
    public static final int NAVIGATION_TOURMODE_TOUR_LIST_DTD_INTEGER;
    public static final int NAVIGATION_TOURMODE_TOUR_LIST_ETAD_INTEGER;
    public static final int NAVIGATION_TOURMODE_TOUR_LIST_ETAH_INTEGER;
    public static final int NAVIGATION_TOURMODE_TOUR_LIST_ETAM_INTEGER;
    public static final int NAVIGATION_TOURMODE_TOUR_LIST_HNO_STRING;
    public static final int NAVIGATION_TOURMODE_TOUR_LIST_LAT_DEGREE_INTEGER;
    public static final int NAVIGATION_TOURMODE_TOUR_LIST_LAT_MIN_INTEGER;
    public static final int NAVIGATION_TOURMODE_TOUR_LIST_LAT_SEC_INTEGER;
    public static final int NAVIGATION_TOURMODE_TOUR_LIST_LON_DEGREE_INTEGER;
    public static final int NAVIGATION_TOURMODE_TOUR_LIST_LON_MIN_INTEGER;
    public static final int NAVIGATION_TOURMODE_TOUR_LIST_LON_SEC_INTEGER;
    public static final int NAVIGATION_TOURMODE_TOUR_LIST_POI_ICON_RESOURCE_LOCATOR;
    public static final int NAVIGATION_TOURMODE_TOUR_LIST_POI_NAME_STRING;
    public static final int NAVIGATION_TOURMODE_TOUR_LIST_STOPOVER_REACHED_BOOLEAN;
    public static final int NAVIGATION_TOURMODE_TOUR_LIST_STREET_STRING;
    public static final int NAVIGATION_TOURMODE_TOUR_LIST_TYPE_INTEGER;
    public static final int NAVIGATION_TOURMODE_TOUR_LIST_FIX_FORMATTER_ADDRESS_FIX_FORMATTER_FIELD_DATA;
    public static final int NAVIGATION_TOURMODE_TOUR_LIST_RUBBERBAND_DESTINATION_BOOLEAN;
    public static final int NAVIGATION_TOURMODE_TOUR_LIST_TOLL_LENGTH_INTEGER;
    public static final int NAVIGATION_TOURMODE_TOUR_LIST_TOLL_COST_INTEGER;
    public static final int NAVIGATION_TOURMODE_TOUR_LIST_TOLL_CURRENCY_INTEGER;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[24];
        int n = 0;
        stringArray[n++] = TransformerUtil.getStringAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 8, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 9, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 10, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 11, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 12, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 13, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 14, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 15, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 16, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 17, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 18, object);
        stringArray[n++] = TransformerUtil.getFixFormatterFieldDataAsString(this, 21, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 22, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 23, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 24, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 25, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(1006);
    }

    @Override
    public int getColumnCount() {
        return 24;
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
            case 21: 
            case 22: 
            case 23: 
            case 24: 
            case 25: {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(int n, Object object) {
        switch (n) {
            case 16: 
            case 22: {
                return this.getBoolean(n, object);
            }
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 18: 
            case 23: 
            case 24: 
            case 25: {
                return new Integer(this.getInt(n, object));
            }
            case 0: 
            case 1: 
            case 2: 
            case 7: 
            case 15: 
            case 17: {
                return this.getString(n, object);
            }
            case 14: {
                return this.getResourceLocator(n, object);
            }
            case 21: {
                return this.getFixFormatterFieldData(n, object);
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
}

