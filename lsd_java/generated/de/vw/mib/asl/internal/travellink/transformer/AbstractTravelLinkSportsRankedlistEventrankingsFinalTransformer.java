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

public abstract class AbstractTravelLinkSportsRankedlistEventrankingsFinalTransformer
extends ItemTransformerAdapter {
    public static final int TRAVELLINK_SPORTS_RANKEDLIST_EVENTRANKINGS_FINAL__RANK_INTEGER;
    public static final int TRAVELLINK_SPORTS_RANKEDLIST_EVENTRANKINGS_FINAL__WINNER_BOOLEAN;
    public static final int TRAVELLINK_SPORTS_RANKEDLIST_EVENTRANKINGS_FINAL__STRING_UPPER_LEFT_STRING;
    public static final int TRAVELLINK_SPORTS_RANKEDLIST_EVENTRANKINGS_FINAL__STRING_LOWER_LEFT_STRING;
    public static final int TRAVELLINK_SPORTS_RANKEDLIST_EVENTRANKINGS_FINAL__STRING_UPPER_RIGHT_STRING;
    public static final int TRAVELLINK_SPORTS_RANKEDLIST_EVENTRANKINGS_FINAL__STRING_LOWER_RIGHT_STRING;
    public static final int TRAVELLINK_SPORTS_RANKEDLIST_EVENTRANKINGS_FINAL__RANK_AS_STRING_STRING;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[7];
        int n = 0;
        stringArray[n++] = TransformerUtil.getIntAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 6, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(-734059776);
    }

    @Override
    public int getColumnCount() {
        return 7;
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
            case 6: {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(int n, Object object) {
        switch (n) {
            case 1: {
                return this.getBoolean(n, object);
            }
            case 0: {
                return new Integer(this.getInt(n, object));
            }
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: {
                return this.getString(n, object);
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

