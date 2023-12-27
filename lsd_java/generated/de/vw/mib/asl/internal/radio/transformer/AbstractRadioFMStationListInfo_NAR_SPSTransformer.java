/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.radio.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import org.dsi.ifc.global.ResourceLocator;

public abstract class AbstractRadioFMStationListInfo_NAR_SPSTransformer
extends ItemTransformerAdapter {
    public static final int RADIO_FM_STATION_LIST_INFO__NAR__SPS__HD_RECEPTION_STATE_INTEGER;
    public static final int RADIO_FM_STATION_LIST_INFO__NAR__SPS__IS_FAVORITE_BOOLEAN;
    public static final int RADIO_FM_STATION_LIST_INFO__NAR__SPS__FREQUENCY_INTEGER;
    public static final int RADIO_FM_STATION_LIST_INFO__NAR__SPS__CHANNEL_NR_INTEGER;
    public static final int RADIO_FM_STATION_LIST_INFO__NAR__SPS__NAME_STRING;
    public static final int RADIO_FM_STATION_LIST_INFO__NAR__SPS__CA_INFO_INTEGER;
    public static final int RADIO_FM_STATION_LIST_INFO__NAR__SPS__IS_CA_INFO_AVAILABLE_BOOLEAN;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[7];
        int n = 0;
        stringArray[n++] = TransformerUtil.getIntAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 5, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(3094);
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
            case 0: 
            case 5: {
                return this.getBoolean(n, object);
            }
            case 1: 
            case 4: 
            case 6: 
            case 7: {
                return new Integer(this.getInt(n, object));
            }
            case 2: {
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

