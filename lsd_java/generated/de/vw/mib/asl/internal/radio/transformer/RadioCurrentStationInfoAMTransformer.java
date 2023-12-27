/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.radio.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.radio.transformer.RadioCurrentStationInfoAMCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class RadioCurrentStationInfoAMTransformer
extends ItemTransformerAdapter {
    public static final int RADIO_CURRENT_STATION_INFO_AM__FREQUENCY_INTEGER;
    public static final int RADIO_CURRENT_STATION_INFO_AM__NAME_STRING;
    public static final int RADIO_CURRENT_STATION_INFO_AM__HD_AVAILABLE_BOOLEAN;
    public static final int RADIO_CURRENT_STATION_INFO_AM__AUTO_ASSIGNED_LOGO_RESOURCE_LOCATOR;
    public static final int RADIO_CURRENT_STATION_INFO_AM__MANUAL_ASSIGNED_LOGO_RESOURCE_LOCATOR;
    public static final int RADIO_CURRENT_STATION_INFO_AM__STORED_LOGO_STATE_INTEGER;
    public static final int RADIO_CURRENT_STATION_INFO_AM__SHORT_NAME_STRING;
    public static final int RADIO_CURRENT_STATION_INFO_AM__HD_CHANNEL_NUMBER_INTEGER;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[8];
        int n = 0;
        stringArray[n++] = TransformerUtil.getIntAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 4, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(1454);
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
            case 2: {
                return this.getBoolean(n, object);
            }
            case 0: 
            case 4: 
            case 7: {
                return new Integer(this.getInt(n, object));
            }
            case 1: 
            case 3: {
                return this.getString(n, object);
            }
            case 5: 
            case 6: {
                return this.getResourceLocator(n, object);
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        RadioCurrentStationInfoAMCollector radioCurrentStationInfoAMCollector = (RadioCurrentStationInfoAMCollector)object;
        switch (n) {
            case 2: {
                return radioCurrentStationInfoAMCollector.radio_current_station_info_am__hd_available;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        RadioCurrentStationInfoAMCollector radioCurrentStationInfoAMCollector = (RadioCurrentStationInfoAMCollector)object;
        switch (n) {
            case 0: {
                return radioCurrentStationInfoAMCollector.radio_current_station_info_am__frequency;
            }
            case 7: {
                return radioCurrentStationInfoAMCollector.radio_current_station_info_am__stored_logo_state;
            }
            case 4: {
                return radioCurrentStationInfoAMCollector.radio_current_station_info_am__hd_channel_number;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        RadioCurrentStationInfoAMCollector radioCurrentStationInfoAMCollector = (RadioCurrentStationInfoAMCollector)object;
        switch (n) {
            case 1: {
                return radioCurrentStationInfoAMCollector.radio_current_station_info_am__name;
            }
            case 3: {
                return radioCurrentStationInfoAMCollector.radio_current_station_info_am__short_name;
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
        RadioCurrentStationInfoAMCollector radioCurrentStationInfoAMCollector = (RadioCurrentStationInfoAMCollector)object;
        switch (n) {
            case 5: {
                return radioCurrentStationInfoAMCollector.radio_current_station_info_am__auto_assigned_logo;
            }
            case 6: {
                return radioCurrentStationInfoAMCollector.radio_current_station_info_am__manual_assigned_logo;
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

