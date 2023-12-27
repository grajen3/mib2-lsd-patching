/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navinfotile.pnav.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;

public abstract class AbstractNavInfoTilePnavLikelyDestinationStaticListTransformer
extends ItemTransformerAdapter {
    public static final int NAVINFOTILE_PNAV_CALCULATION_STATE_STATIC_LIST_INTEGER;
    public static final int NAVINFOTILE_PNAV_CALCULATION_PROGRESS_STATIC_LIST_INTEGER;
    public static final int NAVINFOTILE_PNAV_LIKELIHOOD_STATIC_LIST_INTEGER;
    public static final int NAVINFOTILE_PNAV_DTD_STATIC_LIST_INTEGER;
    public static final int NAVINFOTILE_PNAV_RTT_STATIC_LIST_INTEGER;
    public static final int NAVINFOTILE_PNAV_TIME_DELAY_STATIC_LIST_INTEGER;
    public static final int NAVINFOTILE_PNAV_ROUTE_COLOR_STATIC_LIST_INTEGER;
    public static final int NAVINFOTILE_PNAV_ROUTE_COLOR_ICON_STATIC_LIST_RESOURCE_LOCATOR;
    public static final int NAVINFOTILE_PNAV_STREET_STATIC_LIST_STRING;
    public static final int NAVINFOTILE_PNAV_HOUSENUMBER_STATIC_LIST_STRING;
    public static final int NAVINFOTILE_PNAV_STREET_REFINEMENT_STATIC_LIST_STRING;
    public static final int NAVINFOTILE_PNAV_CITY_STATIC_LIST_STRING;
    public static final int NAVINFOTILE_PNAV_CITY_REFINEMENT_STATIC_LIST_STRING;
    public static final int NAVINFOTILE_PNAV_CROSS_STREET_STATIC_LIST_STRING;
    public static final int NAVINFOTILE_PNAV_LATITUDE_STATIC_LIST_INTEGER;
    public static final int NAVINFOTILE_PNAV_LONGITUDE_STATIC_LIST_INTEGER;
    public static final int NAVINFOTILE_PNAV_LIKELY_DESTINATION_ADDRESS_DATA_FOR_FIX_FORMATTER_STATIC_LIST_FIX_FORMATTER_FIELD_DATA;
    public static final int NAVINFOTILE_PNAV_DESTINATION_AVAILABLE_BOOLEAN;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[18];
        int n = 0;
        stringArray[n++] = TransformerUtil.getIntAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 8, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 9, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 10, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 11, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 12, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 13, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 14, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 15, object);
        stringArray[n++] = TransformerUtil.getFixFormatterFieldDataAsString(this, 16, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 17, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(724457984);
    }

    @Override
    public int getColumnCount() {
        return 18;
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
            case 17: {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(int n, Object object) {
        switch (n) {
            case 17: {
                return this.getBoolean(n, object);
            }
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 14: 
            case 15: {
                return new Integer(this.getInt(n, object));
            }
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 13: {
                return this.getString(n, object);
            }
            case 7: {
                return this.getResourceLocator(n, object);
            }
            case 16: {
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

