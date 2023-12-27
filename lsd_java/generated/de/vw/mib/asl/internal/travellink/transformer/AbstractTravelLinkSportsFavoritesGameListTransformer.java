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

public abstract class AbstractTravelLinkSportsFavoritesGameListTransformer
extends ItemTransformerAdapter {
    public static final int TRAVELLINK_SPORTS_FAVORITES_GAME_LIST__ID_INTEGER;
    public static final int TRAVELLINK_SPORTS_FAVORITES_GAME_LIST__LONG_TEAM_NAME_A_STRING;
    public static final int TRAVELLINK_SPORTS_FAVORITES_GAME_LIST__LONG_TEAM_NAME_B_STRING;
    public static final int TRAVELLINK_SPORTS_FAVORITES_GAME_LIST__SCORE_TEAM_A_INTEGER;
    public static final int TRAVELLINK_SPORTS_FAVORITES_GAME_LIST__SCORE_TEAM_B_INTEGER;
    public static final int TRAVELLINK_SPORTS_FAVORITES_GAME_LIST__SHORT_TEAM_NAME_A_STRING;
    public static final int TRAVELLINK_SPORTS_FAVORITES_GAME_LIST__SHORT_TEAM_NAME_B_STRING;
    public static final int TRAVELLINK_SPORTS_FAVORITES_GAME_LIST__SPORT_ID_INTEGER;
    public static final int TRAVELLINK_SPORTS_FAVORITES_GAME_LIST__STATUS_ID_INTEGER;
    public static final int TRAVELLINK_SPORTS_FAVORITES_GAME_LIST__YEAR_INTEGER;
    public static final int TRAVELLINK_SPORTS_FAVORITES_GAME_LIST__MONTH_INTEGER;
    public static final int TRAVELLINK_SPORTS_FAVORITES_GAME_LIST__DAY_INTEGER;
    public static final int TRAVELLINK_SPORTS_FAVORITES_GAME_LIST__HOUR_INTEGER;
    public static final int TRAVELLINK_SPORTS_FAVORITES_GAME_LIST__MINUTE_INTEGER;
    public static final int TRAVELLINK_SPORTS_FAVORITES_GAME_LIST__DIVISION_LABEL_STRING;
    public static final int TRAVELLINK_SPORTS_FAVORITES_GAME_LIST__SCORE_TEAM_A__STRING_STRING;
    public static final int TRAVELLINK_SPORTS_FAVORITES_GAME_LIST__SCORE_TEAM_B__STRING_STRING;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[17];
        int n = 0;
        stringArray[n++] = TransformerUtil.getIntAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 8, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 9, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 10, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 11, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 12, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 13, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 14, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 15, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 16, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(-1187044608);
    }

    @Override
    public int getColumnCount() {
        return 17;
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
            case 16: {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(int n, Object object) {
        switch (n) {
            case 0: 
            case 3: 
            case 4: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 13: {
                return new Integer(this.getInt(n, object));
            }
            case 1: 
            case 2: 
            case 5: 
            case 6: 
            case 14: 
            case 15: 
            case 16: {
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

