/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.radio.sat.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.radio.sat.transformer.RadioSATCurrentChannelInfoCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class RadioSATCurrentChannelInfoTransformer
extends ItemTransformerAdapter {
    public static final int RADIO_SAT_CURRENT_CHANNEL_INFO__ARTIST_NAME_STRING;
    public static final int RADIO_SAT_CURRENT_CHANNEL_INFO__SHORT_ARTIST_NAME_STRING;
    public static final int RADIO_SAT_CURRENT_CHANNEL_INFO__ALBUM_NAME_STRING;
    public static final int RADIO_SAT_CURRENT_CHANNEL_INFO__CATEGORY_NAME_STRING;
    public static final int RADIO_SAT_CURRENT_CHANNEL_INFO__LOGO_RESOURCE_LOCATOR;
    public static final int RADIO_SAT_CURRENT_CHANNEL_INFO__NAME_STRING;
    public static final int RADIO_SAT_CURRENT_CHANNEL_INFO__NUMBER_INTEGER;
    public static final int RADIO_SAT_CURRENT_CHANNEL_INFO__STATUS_INTEGER;
    public static final int RADIO_SAT_CURRENT_CHANNEL_INFO__TITLE_NAME_STRING;
    public static final int RADIO_SAT_CURRENT_CHANNEL_INFO__SHORT_NAME_STRING;
    public static final int RADIO_SAT_CURRENT_CHANNEL_INFO__SHORT_TITLE_NAME_STRING;
    public static final int RADIO_SAT_CURRENT_CHANNEL_INFO__TEAM_A_STRING;
    public static final int RADIO_SAT_CURRENT_CHANNEL_INFO__SHORT_TEAM_A_STRING;
    public static final int RADIO_SAT_CURRENT_CHANNEL_INFO__TEAM_B_STRING;
    public static final int RADIO_SAT_CURRENT_CHANNEL_INFO__SHORT_TEAM_B_STRING;
    public static final int RADIO_SAT_CURRENT_CHANNEL_INFO__SCORE_TEAM_A_STRING;
    public static final int RADIO_SAT_CURRENT_CHANNEL_INFO__SCORE_TEAM_B_STRING;
    public static final int RADIO_SAT_CURRENT_CHANNEL_INFO__SPORT_EVENT_BOOLEAN;
    public static final int RADIO_SAT_CURRENT_CHANNEL_INFO__CHANNEL000INFORMATION_STRING;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[19];
        int n = 0;
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 8, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 18, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 9, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 10, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 11, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 12, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 13, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 14, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 15, object);
        stringArray[n++] = TransformerUtil.getDeprecatedBooleanAsString(this, 16, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 17, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(1308);
    }

    @Override
    public int getColumnCount() {
        return 19;
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
            case 18: {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(int n, Object object) {
        switch (n) {
            case 16: {
                return this.getBoolean(n, object);
            }
            case 6: 
            case 7: {
                return new Integer(this.getInt(n, object));
            }
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 5: 
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 14: 
            case 15: 
            case 17: 
            case 18: {
                return this.getString(n, object);
            }
            case 4: {
                return this.getResourceLocator(n, object);
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        RadioSATCurrentChannelInfoCollector radioSATCurrentChannelInfoCollector = (RadioSATCurrentChannelInfoCollector)object;
        switch (n) {
            case 16: {
                return radioSATCurrentChannelInfoCollector.radio_sat_current_channel_info__sport_event;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        RadioSATCurrentChannelInfoCollector radioSATCurrentChannelInfoCollector = (RadioSATCurrentChannelInfoCollector)object;
        switch (n) {
            case 6: {
                return radioSATCurrentChannelInfoCollector.radio_sat_current_channel_info__number;
            }
            case 7: {
                return radioSATCurrentChannelInfoCollector.radio_sat_current_channel_info__status;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        RadioSATCurrentChannelInfoCollector radioSATCurrentChannelInfoCollector = (RadioSATCurrentChannelInfoCollector)object;
        switch (n) {
            case 0: {
                return radioSATCurrentChannelInfoCollector.radio_sat_current_channel_info__artist_name;
            }
            case 1: {
                return radioSATCurrentChannelInfoCollector.radio_sat_current_channel_info__short_artist_name;
            }
            case 2: {
                return radioSATCurrentChannelInfoCollector.radio_sat_current_channel_info__album_name;
            }
            case 3: {
                return radioSATCurrentChannelInfoCollector.radio_sat_current_channel_info__category_name;
            }
            case 5: {
                return radioSATCurrentChannelInfoCollector.radio_sat_current_channel_info__name;
            }
            case 8: {
                return radioSATCurrentChannelInfoCollector.radio_sat_current_channel_info__title_name;
            }
            case 18: {
                return radioSATCurrentChannelInfoCollector.radio_sat_current_channel_info__short_name;
            }
            case 9: {
                return radioSATCurrentChannelInfoCollector.radio_sat_current_channel_info__short_title_name;
            }
            case 10: {
                return radioSATCurrentChannelInfoCollector.radio_sat_current_channel_info__team_a;
            }
            case 11: {
                return radioSATCurrentChannelInfoCollector.radio_sat_current_channel_info__short_team_a;
            }
            case 12: {
                return radioSATCurrentChannelInfoCollector.radio_sat_current_channel_info__team_b;
            }
            case 13: {
                return radioSATCurrentChannelInfoCollector.radio_sat_current_channel_info__short_team_b;
            }
            case 14: {
                return radioSATCurrentChannelInfoCollector.radio_sat_current_channel_info__score_team_a;
            }
            case 15: {
                return radioSATCurrentChannelInfoCollector.radio_sat_current_channel_info__score_team_b;
            }
            case 17: {
                return radioSATCurrentChannelInfoCollector.radio_sat_current_channel_info__channel000information;
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
        RadioSATCurrentChannelInfoCollector radioSATCurrentChannelInfoCollector = (RadioSATCurrentChannelInfoCollector)object;
        switch (n) {
            case 4: {
                return radioSATCurrentChannelInfoCollector.radio_sat_current_channel_info__logo;
            }
        }
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

