/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.radio.sat.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;

public abstract class AbstractRadioSATCategoryListSubItemInfoTransformer
extends ItemTransformerAdapter {
    public static final int RADIO_SAT_CATEGORY_LIST_SUB_ITEM_INFO__AUTOCOMPARE_STRING;
    public static final int RADIO_SAT_CATEGORY_LIST_SUB_ITEM_INFO__HAS_IMAGE_URL_BOOLEAN;
    public static final int RADIO_SAT_CATEGORY_LIST_SUB_ITEM_INFO__IMAGE_URL_RESOURCE_LOCATOR;
    public static final int RADIO_SAT_CATEGORY_LIST_SUB_ITEM_INFO__NAME_STRING;
    public static final int RADIO_SAT_CATEGORY_LIST_SUB_ITEM_INFO__SHORT_NAME_STRING;
    public static final int RADIO_SAT_CATEGORY_LIST_SUB_ITEM_INFO__SHORT_CATEGORY_STRING;
    public static final int RADIO_SAT_CATEGORY_LIST_SUB_ITEM_INFO__ID_LONG;
    public static final int RADIO_SAT_CATEGORY_LIST_SUB_ITEM_INFO__NUMBER_STRING;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[8];
        int n = 0;
        stringArray[n++] = TransformerUtil.getStringAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getLongAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 7, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(314975232);
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
            case 1: {
                return this.getBoolean(n, object);
            }
            case 0: 
            case 3: 
            case 4: 
            case 5: 
            case 7: {
                return this.getString(n, object);
            }
            case 2: {
                return this.getResourceLocator(n, object);
            }
            case 6: {
                return new Long(this.getLong(n, object));
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
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

