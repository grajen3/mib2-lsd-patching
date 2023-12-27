/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.radio.sat.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.radio.sat.transformer.RadioSATRadioTextCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class RadioSATRadioTextTransformer
extends ItemTransformerAdapter {
    public static final int RADIO_SAT_RADIO_TEXT__ARTIST_NAME_STRING;
    public static final int RADIO_SAT_RADIO_TEXT__ARTIST_IN_SEEK_LIST_BOOLEAN;
    public static final int RADIO_SAT_RADIO_TEXT__SHORT_ARTIST_NAME_STRING;
    public static final int RADIO_SAT_RADIO_TEXT__ALBUM_NAME_STRING;
    public static final int RADIO_SAT_RADIO_TEXT__CATEGORY_NAME_STRING;
    public static final int RADIO_SAT_RADIO_TEXT__TITLE_NAME_STRING;
    public static final int RADIO_SAT_RADIO_TEXT__TITLE_IN_SEEK_LIST_BOOLEAN;
    public static final int RADIO_SAT_RADIO_TEXT__TEAM_A_IN_SEEK_LIST_BOOLEAN;
    public static final int RADIO_SAT_RADIO_TEXT__TEAM_B_IN_SEEK_LIST_BOOLEAN;
    public static final int RADIO_SAT_RADIO_TEXT__SHORT_TITLE_NAME_STRING;
    public static final int RADIO_SAT_RADIO_TEXT__TEAM_A_STRING;
    public static final int RADIO_SAT_RADIO_TEXT__SHORT_TEAM_A_STRING;
    public static final int RADIO_SAT_RADIO_TEXT__TEAM_B_STRING;
    public static final int RADIO_SAT_RADIO_TEXT__SHORT_TEAM_B_STRING;
    public static final int RADIO_SAT_RADIO_TEXT__SCORE_TEAM_A_STRING;
    public static final int RADIO_SAT_RADIO_TEXT__SCORE_TEAM_B_STRING;
    public static final int RADIO_SAT_RADIO_TEXT__SPORT_EVENT_BOOLEAN;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[17];
        int n = 0;
        stringArray[n++] = TransformerUtil.getStringAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 13, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 14, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 15, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 16, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 8, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 9, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 10, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 11, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 12, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(3962);
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
            case 12: 
            case 13: 
            case 14: 
            case 15: 
            case 16: {
                return this.getBoolean(n, object);
            }
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
                return this.getString(n, object);
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        RadioSATRadioTextCollector radioSATRadioTextCollector = (RadioSATRadioTextCollector)object;
        switch (n) {
            case 13: {
                return radioSATRadioTextCollector.radio_sat_radio_text__artist_in_seek_list;
            }
            case 14: {
                return radioSATRadioTextCollector.radio_sat_radio_text__title_in_seek_list;
            }
            case 15: {
                return radioSATRadioTextCollector.radio_sat_radio_text__team_a_in_seek_list;
            }
            case 16: {
                return radioSATRadioTextCollector.radio_sat_radio_text__team_b_in_seek_list;
            }
            case 12: {
                return radioSATRadioTextCollector.radio_sat_radio_text__sport_event;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        RadioSATRadioTextCollector radioSATRadioTextCollector = (RadioSATRadioTextCollector)object;
        switch (n) {
            case 0: {
                return radioSATRadioTextCollector.radio_sat_radio_text__artist_name;
            }
            case 1: {
                return radioSATRadioTextCollector.radio_sat_radio_text__short_artist_name;
            }
            case 2: {
                return radioSATRadioTextCollector.radio_sat_radio_text__album_name;
            }
            case 3: {
                return radioSATRadioTextCollector.radio_sat_radio_text__category_name;
            }
            case 4: {
                return radioSATRadioTextCollector.radio_sat_radio_text__title_name;
            }
            case 5: {
                return radioSATRadioTextCollector.radio_sat_radio_text__short_title_name;
            }
            case 6: {
                return radioSATRadioTextCollector.radio_sat_radio_text__team_a;
            }
            case 7: {
                return radioSATRadioTextCollector.radio_sat_radio_text__short_team_a;
            }
            case 8: {
                return radioSATRadioTextCollector.radio_sat_radio_text__team_b;
            }
            case 9: {
                return radioSATRadioTextCollector.radio_sat_radio_text__short_team_b;
            }
            case 10: {
                return radioSATRadioTextCollector.radio_sat_radio_text__score_team_a;
            }
            case 11: {
                return radioSATRadioTextCollector.radio_sat_radio_text__score_team_b;
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

