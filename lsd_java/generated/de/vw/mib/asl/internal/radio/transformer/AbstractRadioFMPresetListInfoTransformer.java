/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.radio.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;

public abstract class AbstractRadioFMPresetListInfoTransformer
extends ItemTransformerAdapter {
    public static final int RADIO_FM_PRESET_LIST_INFO__ATTRIBUTES_INTEGER;
    public static final int RADIO_FM_PRESET_LIST_INFO__AUTO_STORED_IMAGE_STRING;
    public static final int RADIO_FM_PRESET_LIST_INFO__FREQUENCY_INTEGER;
    public static final int RADIO_FM_PRESET_LIST_INFO__HD_STATION_NR_INTEGER;
    public static final int RADIO_FM_PRESET_LIST_INFO__IS_ELEMENT_STORED_BOOLEAN;
    public static final int RADIO_FM_PRESET_LIST_INFO__ID_LONG;
    public static final int RADIO_FM_PRESET_LIST_INFO__IMAGE_LIST_RESOURCE_LOCATOR;
    public static final int RADIO_FM_PRESET_LIST_INFO__NAME_STRING;
    public static final int RADIO_FM_PRESET_LIST_INFO__STORED_LOGO_STATE_INTEGER;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[9];
        int n = 0;
        stringArray[n++] = TransformerUtil.getIntAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 9, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getLongAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 8, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 10, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(1461);
    }

    @Override
    public int getColumnCount() {
        return 9;
    }

    @Override
    public boolean isColumnIdSupported(int n) {
        switch (n) {
            case 0: 
            case 1: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 8: 
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
            case 4: {
                return this.getBoolean(n, object);
            }
            case 0: 
            case 1: 
            case 3: 
            case 10: {
                return new Integer(this.getInt(n, object));
            }
            case 8: 
            case 9: {
                return this.getString(n, object);
            }
            case 6: {
                return this.getResourceLocator(n, object);
            }
            case 5: {
                return new Long(this.getLong(n, object));
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
    public LabeledIconValue getLabeledIconValue(int n, Object object) {
        throw new IllegalArgumentException();
    }

    @Override
    public FixFormatterFieldData getFixFormatterFieldData(int n, Object object) {
        throw new IllegalArgumentException();
    }
}

