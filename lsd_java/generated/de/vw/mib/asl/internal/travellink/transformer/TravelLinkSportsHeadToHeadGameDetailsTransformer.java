/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.travellink.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.travellink.transformer.TravelLinkSportsHeadToHeadGameDetailsCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class TravelLinkSportsHeadToHeadGameDetailsTransformer
extends ItemTransformerAdapter {
    public static final int TRAVELLINK_SPORTS_HEAD_TO_HEAD_GAME_DETAILS__COMMENT_STRING;
    public static final int TRAVELLINK_SPORTS_HEAD_TO_HEAD_GAME_DETAILS__DIVISION_LABEL_STRING;
    public static final int TRAVELLINK_SPORTS_HEAD_TO_HEAD_GAME_DETAILS__DIVISION_SCORE__LINE1_STRING;
    public static final int TRAVELLINK_SPORTS_HEAD_TO_HEAD_GAME_DETAILS__DIVISION_SCORE__LINE2_STRING;
    public static final int TRAVELLINK_SPORTS_HEAD_TO_HEAD_GAME_DETAILS__DIVISION_SCORE__LINE3_STRING;
    public static final int TRAVELLINK_SPORTS_HEAD_TO_HEAD_GAME_DETAILS__NAME_STRING;
    public static final int TRAVELLINK_SPORTS_HEAD_TO_HEAD_GAME_DETAILS__RUNNING_TIME__STRING_STRING;
    public static final int TRAVELLINK_SPORTS_HEAD_TO_HEAD_GAME_DETAILS__RUNNING_TIME_HOUR_INTEGER;
    public static final int TRAVELLINK_SPORTS_HEAD_TO_HEAD_GAME_DETAILS__RUNNING_TIME_MINUTE_INTEGER;
    public static final int TRAVELLINK_SPORTS_HEAD_TO_HEAD_GAME_DETAILS__RUNNING_TIME_SECOND_INTEGER;
    public static final int TRAVELLINK_SPORTS_HEAD_TO_HEAD_GAME_DETAILS__SCORE_A_INTEGER;
    public static final int TRAVELLINK_SPORTS_HEAD_TO_HEAD_GAME_DETAILS__SCORE_B_INTEGER;
    public static final int TRAVELLINK_SPORTS_HEAD_TO_HEAD_GAME_DETAILS__SCORE_TEAM_A__STRING_STRING;
    public static final int TRAVELLINK_SPORTS_HEAD_TO_HEAD_GAME_DETAILS__SCORE_TEAM_B__STRING_STRING;
    public static final int TRAVELLINK_SPORTS_HEAD_TO_HEAD_GAME_DETAILS__TEAM_A_STRING;
    public static final int TRAVELLINK_SPORTS_HEAD_TO_HEAD_GAME_DETAILS__STATUS_ID_INTEGER;
    public static final int TRAVELLINK_SPORTS_HEAD_TO_HEAD_GAME_DETAILS__TEAM_B_STRING;
    public static final int TRAVELLINK_SPORTS_HEAD_TO_HEAD_GAME_DETAILS__HOUR_INTEGER;
    public static final int TRAVELLINK_SPORTS_HEAD_TO_HEAD_GAME_DETAILS__MINUTE_INTEGER;
    public static final int TRAVELLINK_SPORTS_HEAD_TO_HEAD_GAME_DETAILS__DAY_INTEGER;
    public static final int TRAVELLINK_SPORTS_HEAD_TO_HEAD_GAME_DETAILS__MONTH_INTEGER;
    public static final int TRAVELLINK_SPORTS_HEAD_TO_HEAD_GAME_DETAILS__YEAR_INTEGER;
    public static final int TRAVELLINK_SPORTS_HEAD_TO_HEAD_GAME_DETAILS__DATE_AND_TIME_STRING;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[23];
        int n = 0;
        stringArray[n++] = TransformerUtil.getStringAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 9, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 12, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 13, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 14, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 15, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 10, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 11, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 16, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 8, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 17, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 18, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 19, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 20, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 21, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 22, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(-1036049664);
    }

    @Override
    public int getColumnCount() {
        return 23;
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
            case 21: 
            case 22: {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(int n, Object object) {
        switch (n) {
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 16: 
            case 17: 
            case 18: 
            case 19: 
            case 20: 
            case 21: {
                return new Integer(this.getInt(n, object));
            }
            case 0: 
            case 1: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 14: 
            case 15: 
            case 22: {
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
    public int getInt(int n, Object object) {
        TravelLinkSportsHeadToHeadGameDetailsCollector travelLinkSportsHeadToHeadGameDetailsCollector = (TravelLinkSportsHeadToHeadGameDetailsCollector)object;
        switch (n) {
            case 2: {
                return travelLinkSportsHeadToHeadGameDetailsCollector.travellink_sports_head_to_head_game_details__running_time_hour;
            }
            case 3: {
                return travelLinkSportsHeadToHeadGameDetailsCollector.travellink_sports_head_to_head_game_details__running_time_minute;
            }
            case 4: {
                return travelLinkSportsHeadToHeadGameDetailsCollector.travellink_sports_head_to_head_game_details__running_time_second;
            }
            case 5: {
                return travelLinkSportsHeadToHeadGameDetailsCollector.travellink_sports_head_to_head_game_details__score_a;
            }
            case 6: {
                return travelLinkSportsHeadToHeadGameDetailsCollector.travellink_sports_head_to_head_game_details__score_b;
            }
            case 16: {
                return travelLinkSportsHeadToHeadGameDetailsCollector.travellink_sports_head_to_head_game_details__status_id;
            }
            case 17: {
                return travelLinkSportsHeadToHeadGameDetailsCollector.travellink_sports_head_to_head_game_details__hour;
            }
            case 18: {
                return travelLinkSportsHeadToHeadGameDetailsCollector.travellink_sports_head_to_head_game_details__minute;
            }
            case 19: {
                return travelLinkSportsHeadToHeadGameDetailsCollector.travellink_sports_head_to_head_game_details__day;
            }
            case 20: {
                return travelLinkSportsHeadToHeadGameDetailsCollector.travellink_sports_head_to_head_game_details__month;
            }
            case 21: {
                return travelLinkSportsHeadToHeadGameDetailsCollector.travellink_sports_head_to_head_game_details__year;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        TravelLinkSportsHeadToHeadGameDetailsCollector travelLinkSportsHeadToHeadGameDetailsCollector = (TravelLinkSportsHeadToHeadGameDetailsCollector)object;
        switch (n) {
            case 0: {
                return travelLinkSportsHeadToHeadGameDetailsCollector.travellink_sports_head_to_head_game_details__comment;
            }
            case 9: {
                return travelLinkSportsHeadToHeadGameDetailsCollector.travellink_sports_head_to_head_game_details__division_label;
            }
            case 12: {
                return travelLinkSportsHeadToHeadGameDetailsCollector.travellink_sports_head_to_head_game_details__division_score__line1;
            }
            case 13: {
                return travelLinkSportsHeadToHeadGameDetailsCollector.travellink_sports_head_to_head_game_details__division_score__line2;
            }
            case 14: {
                return travelLinkSportsHeadToHeadGameDetailsCollector.travellink_sports_head_to_head_game_details__division_score__line3;
            }
            case 1: {
                return travelLinkSportsHeadToHeadGameDetailsCollector.travellink_sports_head_to_head_game_details__name;
            }
            case 15: {
                return travelLinkSportsHeadToHeadGameDetailsCollector.travellink_sports_head_to_head_game_details__running_time__string;
            }
            case 10: {
                return travelLinkSportsHeadToHeadGameDetailsCollector.travellink_sports_head_to_head_game_details__score_team_a__string;
            }
            case 11: {
                return travelLinkSportsHeadToHeadGameDetailsCollector.travellink_sports_head_to_head_game_details__score_team_b__string;
            }
            case 7: {
                return travelLinkSportsHeadToHeadGameDetailsCollector.travellink_sports_head_to_head_game_details__team_a;
            }
            case 8: {
                return travelLinkSportsHeadToHeadGameDetailsCollector.travellink_sports_head_to_head_game_details__team_b;
            }
            case 22: {
                return travelLinkSportsHeadToHeadGameDetailsCollector.travellink_sports_head_to_head_game_details__date_and_time;
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

