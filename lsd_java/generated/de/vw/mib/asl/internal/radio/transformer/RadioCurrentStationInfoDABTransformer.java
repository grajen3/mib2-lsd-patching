/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.radio.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.radio.transformer.RadioCurrentStationInfoDABCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class RadioCurrentStationInfoDABTransformer
extends ItemTransformerAdapter {
    public static final int RADIO_CURRENT_STATION_INFO_DAB__AUTO_ASSIGNED_LOGO_STRING;
    public static final int RADIO_CURRENT_STATION_INFO_DAB__MANUAL_ASSIGNED_LOGO_RESOURCE_LOCATOR;
    public static final int RADIO_CURRENT_STATION_INFO_DAB__STORED_LOGO_STATE_INTEGER;
    public static final int RADIO_CURRENT_STATION_INFO_DAB__ENSEMBLE_NAME_STRING;
    public static final int RADIO_CURRENT_STATION_INFO_DAB__SECONDARY_SERVICE_NAME_STRING;
    public static final int RADIO_CURRENT_STATION_INFO_DAB__SECONDARY_SERVICE_SHORT_NAME_STRING;
    public static final int RADIO_CURRENT_STATION_INFO_DAB__SERVICE_PS_STRING;
    public static final int RADIO_CURRENT_STATION_INFO_DAB__SERVICE_SHORT_NAME_STRING;
    public static final int RADIO_CURRENT_STATION_INFO_DAB__FREQUENCY_INTEGER;
    public static final int RADIO_CURRENT_STATION_INFO_DAB__FREQUENCY_LABEL_STRING;
    public static final int RADIO_CURRENT_STATION_INFO_DAB__TP_AVAILABLE_BOOLEAN;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[11];
        int n = 0;
        stringArray[n++] = TransformerUtil.getStringAsString(this, 8, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 11, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 10, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 7, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(1455);
    }

    @Override
    public int getColumnCount() {
        return 11;
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
            case 7: {
                return this.getBoolean(n, object);
            }
            case 5: 
            case 10: {
                return new Integer(this.getInt(n, object));
            }
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 6: 
            case 8: {
                return this.getString(n, object);
            }
            case 11: {
                return this.getResourceLocator(n, object);
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        RadioCurrentStationInfoDABCollector radioCurrentStationInfoDABCollector = (RadioCurrentStationInfoDABCollector)object;
        switch (n) {
            case 7: {
                return radioCurrentStationInfoDABCollector.radio_current_station_info_dab__tp_available;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        RadioCurrentStationInfoDABCollector radioCurrentStationInfoDABCollector = (RadioCurrentStationInfoDABCollector)object;
        switch (n) {
            case 10: {
                return radioCurrentStationInfoDABCollector.radio_current_station_info_dab__stored_logo_state;
            }
            case 5: {
                return radioCurrentStationInfoDABCollector.radio_current_station_info_dab__frequency;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        RadioCurrentStationInfoDABCollector radioCurrentStationInfoDABCollector = (RadioCurrentStationInfoDABCollector)object;
        switch (n) {
            case 8: {
                return radioCurrentStationInfoDABCollector.radio_current_station_info_dab__auto_assigned_logo;
            }
            case 0: {
                return radioCurrentStationInfoDABCollector.radio_current_station_info_dab__ensemble_name;
            }
            case 1: {
                return radioCurrentStationInfoDABCollector.radio_current_station_info_dab__secondary_service_name;
            }
            case 2: {
                return radioCurrentStationInfoDABCollector.radio_current_station_info_dab__secondary_service_short_name;
            }
            case 3: {
                return radioCurrentStationInfoDABCollector.radio_current_station_info_dab__service_ps;
            }
            case 4: {
                return radioCurrentStationInfoDABCollector.radio_current_station_info_dab__service_short_name;
            }
            case 6: {
                return radioCurrentStationInfoDABCollector.radio_current_station_info_dab__frequency_label;
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
        RadioCurrentStationInfoDABCollector radioCurrentStationInfoDABCollector = (RadioCurrentStationInfoDABCollector)object;
        switch (n) {
            case 11: {
                return radioCurrentStationInfoDABCollector.radio_current_station_info_dab__manual_assigned_logo;
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

