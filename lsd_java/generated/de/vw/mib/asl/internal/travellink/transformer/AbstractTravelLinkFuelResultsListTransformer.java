/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.travellink.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;

public abstract class AbstractTravelLinkFuelResultsListTransformer
extends ItemTransformerAdapter {
    public static final int TRAVELLINK_FUEL_RESULTS_LIST__CURRENCY_INTEGER;
    public static final int TRAVELLINK_FUEL_RESULTS_LIST__ID_INTEGER;
    public static final int TRAVELLINK_FUEL_RESULTS_LIST__DIRECTION_INTEGER;
    public static final int TRAVELLINK_FUEL_RESULTS_LIST__DISTANCE_INTEGER;
    public static final int TRAVELLINK_FUEL_RESULTS_LIST__DIST_DIRECTION_TYPE_INTEGER;
    public static final int TRAVELLINK_FUEL_RESULTS_LIST__ICON_RESOURCE_LOCATOR;
    public static final int TRAVELLINK_FUEL_RESULTS_LIST__NAME_STRING;
    public static final int TRAVELLINK_FUEL_RESULTS_LIST__PRICE_INTEGER;
    public static final int TRAVELLINK_FUEL_RESULTS_LIST__PRICE_PERCENTIL_INTEGER;
    public static final int TRAVELLINK_FUEL_RESULTS_LIST__DISTANCE_AND_UNIT_STRING;
    public static final int TRAVELLINK_FUEL_RESULTS_LIST__PRICE_AND_CURRENCY_STRING;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[11];
        int n = 0;
        stringArray[n++] = TransformerUtil.getIntAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 8, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 9, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 10, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(-1757469952);
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
            case 7: 
            case 8: {
                return new Integer(this.getInt(n, object));
            }
            case 6: 
            case 9: 
            case 10: {
                return this.getString(n, object);
            }
            case 5: {
                return this.getResourceLocator(n, object);
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

