/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.radio.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;

public abstract class AbstractRadioDABServiceListItemInfoTransformer
extends ItemTransformerAdapter {
    public static final int RADIO_DAB_SERVICE_LIST_ITEM_INFO__AUTOCOMPARE_STRING;
    public static final int RADIO_DAB_SERVICE_LIST_ITEM_INFO__SERVICE_SUPPORTS_SLIDESHOW_DATA_BOOLEAN;
    public static final int RADIO_DAB_SERVICE_LIST_ITEM_INFO__HAS_IMAGE_URL_BOOLEAN;
    public static final int RADIO_DAB_SERVICE_LIST_ITEM_INFO__IMAGE_URL_RESOURCE_LOCATOR;
    public static final int RADIO_DAB_SERVICE_LIST_ITEM_INFO__NAME_STRING;
    public static final int RADIO_DAB_SERVICE_LIST_ITEM_INFO__SERVICE_SHORT_NAME_STRING;
    public static final int RADIO_DAB_SERVICE_LIST_ITEM_INFO__SECUNDARY_SERVICE_NAME_STRING;
    public static final int RADIO_DAB_SERVICE_LIST_ITEM_INFO__ID_LONG;
    public static final int RADIO_DAB_SERVICE_LIST_ITEM_INFO__PTY_INTEGER;
    public static final int RADIO_DAB_SERVICE_LIST_ITEM_INFO__TP_BOOLEAN;
    public static final int RADIO_DAB_SERVICE_LIST_ITEM_INFO__SERVICE_STATE_INTEGER;
    public static final int RADIO_DAB_SERVICE_LIST_ITEM_INFO__ADDITIONAL_SERVICE_STATE_INTEGER;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[12];
        int n = 0;
        stringArray[n++] = TransformerUtil.getStringAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getLongAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 8, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 9, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 10, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 11, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(1459);
    }

    @Override
    public int getColumnCount() {
        return 12;
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
            case 11: {
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
            case 9: {
                return this.getBoolean(n, object);
            }
            case 8: 
            case 10: 
            case 11: {
                return new Integer(this.getInt(n, object));
            }
            case 0: 
            case 4: 
            case 5: 
            case 6: {
                return this.getString(n, object);
            }
            case 3: {
                return this.getResourceLocator(n, object);
            }
            case 7: {
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

