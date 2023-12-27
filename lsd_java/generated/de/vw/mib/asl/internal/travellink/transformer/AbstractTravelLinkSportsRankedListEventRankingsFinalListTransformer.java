/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.travellink.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;

public abstract class AbstractTravelLinkSportsRankedListEventRankingsFinalListTransformer
extends ItemTransformerAdapter {
    public static final int TRAVELLINK_SPORTS_RANKED_LIST_EVENT_RANKINGS_FINAL_LIST__NAME_STRING;
    public static final int TRAVELLINK_SPORTS_RANKED_LIST_EVENT_RANKINGS_FINAL_LIST__SPORTS_ID_INTEGER;
    public static final int TRAVELLINK_SPORTS_RANKED_LIST_EVENT_RANKINGS_FINAL_LIST__CAR_NUMBER_INTEGER;
    public static final int TRAVELLINK_SPORTS_RANKED_LIST_EVENT_RANKINGS_FINAL_LIST__LAPS_INTEGER;
    public static final int TRAVELLINK_SPORTS_RANKED_LIST_EVENT_RANKINGS_FINAL_LIST__BLOWS_INTEGER;
    public static final int TRAVELLINK_SPORTS_RANKED_LIST_EVENT_RANKINGS_FINAL_LIST__DIFFERENCE_INTEGER;
    public static final int TRAVELLINK_SPORTS_RANKED_LIST_EVENT_RANKINGS_FINAL_LIST__TEAM_STRING;
    public static final int TRAVELLINK_SPORTS_RANKED_LIST_EVENT_RANKINGS_FINAL_LIST__ICON_RESOURCE_LOCATOR;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[8];
        int n = 0;
        stringArray[n++] = TransformerUtil.getStringAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 6, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(-1086381312);
    }

    @Override
    public int getColumnCount() {
        return 8;
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
            case 7: {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(int n, Object object) {
        switch (n) {
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: {
                return new Integer(this.getInt(n, object));
            }
            case 0: 
            case 7: {
                return this.getString(n, object);
            }
            case 6: {
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

