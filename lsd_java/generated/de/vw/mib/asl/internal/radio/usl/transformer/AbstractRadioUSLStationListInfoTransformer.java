/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.radio.usl.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;

public abstract class AbstractRadioUSLStationListInfoTransformer
extends ItemTransformerAdapter {
    public static final int RADIO_USL_STATION_LIST_INFO__NAME_STRING;
    public static final int RADIO_USL_STATION_LIST_INFO__STATION_LOGO__2_RESOURCE_LOCATOR;
    public static final int RADIO_USL_STATION_LIST_INFO__STATION_LOGO__1_RESOURCE_LOCATOR;
    public static final int RADIO_USL_STATION_LIST_INFO__STATION_LOGO_RESOURCE_LOCATOR;
    public static final int RADIO_USL_STATION_LIST_INFO__IS_AVAILABLE_ON_THE_INTERNET_BOOLEAN;
    public static final int RADIO_USL_STATION_LIST_INFO__BEST_AVAILABLE_SOURCE_INTEGER;
    public static final int RADIO_USL_STATION_LIST_INFO__DAB_STATION_STATE_INTEGER;
    public static final int RADIO_USL_STATION_LIST_INFO__DAB_STATION_SUPPORTS_SLIDE_SHOW_BOOLEAN;
    public static final int RADIO_USL_STATION_LIST_INFO__STATION_IS_ON_PRESET_BOOLEAN;
    public static final int RADIO_USL_RADIO_DNS_CONNECTION_POSSIBLE_BOOLEAN;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[10];
        int n = 0;
        stringArray[n++] = TransformerUtil.getStringAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 8, object);
        stringArray[n++] = TransformerUtil.getDeprecatedResourceLocatorAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getDeprecatedResourceLocatorAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 9, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(1237722112);
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
            case 2: 
            case 5: 
            case 6: 
            case 9: {
                return this.getBoolean(n, object);
            }
            case 3: 
            case 4: {
                return new Integer(this.getInt(n, object));
            }
            case 0: {
                return this.getString(n, object);
            }
            case 1: 
            case 7: 
            case 8: {
                return this.getResourceLocator(n, object);
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

