/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.radio.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.radio.transformer.RadioCurrentStationInfoFMCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class RadioCurrentStationInfoFMTransformer
extends ItemTransformerAdapter {
    public static final int RADIO_CURRENT_STATION_INFO_FM__AUTO_ASSIGNED_LOGO_STRING;
    public static final int RADIO_CURRENT_STATION_INFO_FM__MANUAL_ASSIGNED_LOGO_RESOURCE_LOCATOR;
    public static final int RADIO_CURRENT_STATION_INFO_FM__STORED_LOGO_STATE_INTEGER;
    public static final int RADIO_CURRENT_STATION_INFO_FM__FREQUENCY_INTEGER;
    public static final int RADIO_CURRENT_STATION_INFO_FM__TA_TP_AVAILABLE_BOOLEAN;
    public static final int RADIO_CURRENT_STATION_INFO_FM__HD_AVAILABLE_BOOLEAN;
    public static final int RADIO_CURRENT_STATION_INFO_FM__TMC_AVAILABLE_BOOLEAN;
    public static final int RADIO_CURRENT_STATION_INFO_FM__NAME_STRING;
    public static final int RADIO_CURRENT_STATION_INFO_FM__SHORT_STATION_NAME_STRING;
    public static final int RADIO_CURRENT_STATION_INFO_FM__HD_CHANNEL_NUMBER_INTEGER;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[10];
        int n = 0;
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getDeprecatedResourceLocatorAsString(this, 10, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 9, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getDeprecatedBooleanAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getDeprecatedBooleanAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 6, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(1456);
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
            case 1: 
            case 2: 
            case 3: {
                return this.getBoolean(n, object);
            }
            case 0: 
            case 6: 
            case 9: {
                return new Integer(this.getInt(n, object));
            }
            case 4: 
            case 5: 
            case 7: {
                return this.getString(n, object);
            }
            case 10: {
                return this.getResourceLocator(n, object);
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        RadioCurrentStationInfoFMCollector radioCurrentStationInfoFMCollector = (RadioCurrentStationInfoFMCollector)object;
        switch (n) {
            case 1: {
                return radioCurrentStationInfoFMCollector.radio_current_station_info_fm__ta_tp_available;
            }
            case 2: {
                return radioCurrentStationInfoFMCollector.radio_current_station_info_fm__hd_available;
            }
            case 3: {
                return radioCurrentStationInfoFMCollector.radio_current_station_info_fm__tmc_available;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        RadioCurrentStationInfoFMCollector radioCurrentStationInfoFMCollector = (RadioCurrentStationInfoFMCollector)object;
        switch (n) {
            case 9: {
                return radioCurrentStationInfoFMCollector.radio_current_station_info_fm__stored_logo_state;
            }
            case 0: {
                return radioCurrentStationInfoFMCollector.radio_current_station_info_fm__frequency;
            }
            case 6: {
                return radioCurrentStationInfoFMCollector.radio_current_station_info_fm__hd_channel_number;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        RadioCurrentStationInfoFMCollector radioCurrentStationInfoFMCollector = (RadioCurrentStationInfoFMCollector)object;
        switch (n) {
            case 7: {
                return radioCurrentStationInfoFMCollector.radio_current_station_info_fm__auto_assigned_logo;
            }
            case 4: {
                return radioCurrentStationInfoFMCollector.radio_current_station_info_fm__name;
            }
            case 5: {
                return radioCurrentStationInfoFMCollector.radio_current_station_info_fm__short_station_name;
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
        RadioCurrentStationInfoFMCollector radioCurrentStationInfoFMCollector = (RadioCurrentStationInfoFMCollector)object;
        switch (n) {
            case 10: {
                return radioCurrentStationInfoFMCollector.radio_current_station_info_fm__manual_assigned_logo;
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

