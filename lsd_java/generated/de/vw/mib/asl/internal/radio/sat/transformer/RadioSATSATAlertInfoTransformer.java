/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.radio.sat.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.radio.sat.transformer.RadioSATSATAlertInfoCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class RadioSATSATAlertInfoTransformer
extends ItemTransformerAdapter {
    public static final int RADIO_SAT_SAT_ALERT_INFO__ALBUM_NAME_STRING;
    public static final int RADIO_SAT_SAT_ALERT_INFO__ARTIST_NAME_STRING;
    public static final int RADIO_SAT_SAT_ALERT_INFO__CATEGORY_NAME_STRING;
    public static final int RADIO_SAT_SAT_ALERT_INFO__CHANNEL_NAME_STRING;
    public static final int RADIO_SAT_SAT_ALERT_INFO__CHANNEL_NUMBER_STRING;
    public static final int RADIO_SAT_SAT_ALERT_INFO__LOGO_RESOURCE_LOCATOR;
    public static final int RADIO_SAT_SAT_ALERT_INFO__TEAM_A_STRING;
    public static final int RADIO_SAT_SAT_ALERT_INFO__TEAM_B_STRING;
    public static final int RADIO_SAT_SAT_ALERT_INFO__TITLE_NAME_STRING;
    public static final int RADIO_SAT_SAT_ALERT_INFO__SPORT_PROGRAM_BOOLEAN;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[10];
        int n = 0;
        stringArray[n++] = TransformerUtil.getStringAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 8, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 9, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(1312);
    }

    @Override
    public int getColumnCount() {
        return 10;
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
            case 9: {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(int n, Object object) {
        switch (n) {
            case 9: {
                return this.getBoolean(n, object);
            }
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 6: 
            case 7: 
            case 8: {
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
        RadioSATSATAlertInfoCollector radioSATSATAlertInfoCollector = (RadioSATSATAlertInfoCollector)object;
        switch (n) {
            case 9: {
                return radioSATSATAlertInfoCollector.radio_sat_sat_alert_info__sport_program;
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
        RadioSATSATAlertInfoCollector radioSATSATAlertInfoCollector = (RadioSATSATAlertInfoCollector)object;
        switch (n) {
            case 0: {
                return radioSATSATAlertInfoCollector.radio_sat_sat_alert_info__album_name;
            }
            case 1: {
                return radioSATSATAlertInfoCollector.radio_sat_sat_alert_info__artist_name;
            }
            case 2: {
                return radioSATSATAlertInfoCollector.radio_sat_sat_alert_info__category_name;
            }
            case 3: {
                return radioSATSATAlertInfoCollector.radio_sat_sat_alert_info__channel_name;
            }
            case 4: {
                return radioSATSATAlertInfoCollector.radio_sat_sat_alert_info__channel_number;
            }
            case 6: {
                return radioSATSATAlertInfoCollector.radio_sat_sat_alert_info__team_a;
            }
            case 7: {
                return radioSATSATAlertInfoCollector.radio_sat_sat_alert_info__team_b;
            }
            case 8: {
                return radioSATSATAlertInfoCollector.radio_sat_sat_alert_info__title_name;
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
        RadioSATSATAlertInfoCollector radioSATSATAlertInfoCollector = (RadioSATSATAlertInfoCollector)object;
        switch (n) {
            case 5: {
                return radioSATSATAlertInfoCollector.radio_sat_sat_alert_info__logo;
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

