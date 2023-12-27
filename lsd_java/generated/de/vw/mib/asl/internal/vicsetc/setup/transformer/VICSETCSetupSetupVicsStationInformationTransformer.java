/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.vicsetc.setup.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.vicsetc.setup.transformer.VICSETCSetupSetupVicsStationInformationCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class VICSETCSetupSetupVicsStationInformationTransformer
extends ItemTransformerAdapter {
    public static final int VICSETC_SETUP_SETUP_VICS_STATION_INFORMATION_RECEPTION_STATUS_INTEGER;
    public static final int VICSETC_SETUP_SETUP_VICS_STATION_INFORMATION_SELECTED_PREFECTURE_STRING;
    public static final int VICSETC_SETUP_SETUP_VICS_STATION_INFORMATION_RECEIVED_FREQUENCY_STRING;
    public static final int VICSETC_SETUP_SETUP_VICS_STATION_INFORMATION_ONLINE_VICS_STATUS_INTEGER;
    public static final int VICSETC_SETUP_SETUP_VICS_STATION_INFORMATION_RECEPTION_MODE_INTEGER;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[5];
        int n = 0;
        stringArray[n++] = TransformerUtil.getIntAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 4, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(798643456);
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public boolean isColumnIdSupported(int n) {
        switch (n) {
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(int n, Object object) {
        switch (n) {
            case 3: 
            case 4: 
            case 5: {
                return new Integer(this.getInt(n, object));
            }
            case 1: 
            case 2: {
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
        VICSETCSetupSetupVicsStationInformationCollector vICSETCSetupSetupVicsStationInformationCollector = (VICSETCSetupSetupVicsStationInformationCollector)object;
        switch (n) {
            case 5: {
                return vICSETCSetupSetupVicsStationInformationCollector.vicsetc_setup_setup_vics_station_information_reception_status;
            }
            case 3: {
                return vICSETCSetupSetupVicsStationInformationCollector.vicsetc_setup_setup_vics_station_information_online_vics_status;
            }
            case 4: {
                return vICSETCSetupSetupVicsStationInformationCollector.vicsetc_setup_setup_vics_station_information_reception_mode;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        VICSETCSetupSetupVicsStationInformationCollector vICSETCSetupSetupVicsStationInformationCollector = (VICSETCSetupSetupVicsStationInformationCollector)object;
        switch (n) {
            case 1: {
                return vICSETCSetupSetupVicsStationInformationCollector.vicsetc_setup_setup_vics_station_information_selected_prefecture;
            }
            case 2: {
                return vICSETCSetupSetupVicsStationInformationCollector.vicsetc_setup_setup_vics_station_information_received_frequency;
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

