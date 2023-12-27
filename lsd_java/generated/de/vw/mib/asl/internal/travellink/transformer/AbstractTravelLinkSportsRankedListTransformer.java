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

public abstract class AbstractTravelLinkSportsRankedListTransformer
extends ItemTransformerAdapter {
    public static final int TRAVELLINK_SPORTS_RANKED_LIST__DAY_INTEGER;
    public static final int TRAVELLINK_SPORTS_RANKED_LIST__HOUR_INTEGER;
    public static final int TRAVELLINK_SPORTS_RANKED_LIST__ID_INTEGER;
    public static final int TRAVELLINK_SPORTS_RANKED_LIST__LOCATION_STRING;
    public static final int TRAVELLINK_SPORTS_RANKED_LIST__MINUTE_INTEGER;
    public static final int TRAVELLINK_SPORTS_RANKED_LIST__MONTH_INTEGER;
    public static final int TRAVELLINK_SPORTS_RANKED_LIST__NAME_STRING;
    public static final int TRAVELLINK_SPORTS_RANKED_LIST__SPORT_ID_INTEGER;
    public static final int TRAVELLINK_SPORTS_RANKED_LIST__STATUS_INTEGER;
    public static final int TRAVELLINK_SPORTS_RANKED_LIST__YEAR_INTEGER;
    public static final int TRAVELLINK_SPORTS_RANKED_LIST__STATUS_ID_INTEGER;
    public static final int TRAVELLINK_SPORTS_RANKED_LIST__FIELD_TYPE_STRING;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[12];
        int n = 0;
        stringArray[n++] = TransformerUtil.getIntAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 8, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 9, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 10, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 11, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(-1119935744);
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
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: {
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
            case 6: 
            case 7: 
            case 9: 
            case 10: {
                return new Integer(this.getInt(n, object));
            }
            case 5: 
            case 8: 
            case 11: {
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

