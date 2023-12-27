/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.speechphone.data.contact.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;

public abstract class AbstractSpeechPhoneDataContactContactListSelectedItemTransformer
extends ItemTransformerAdapter {
    public static final int SPEECHPHONE_DATA_CONTACT_CONTACT_SELECTED_ITEM_OBJECT_ID_LONG;
    public static final int SPEECHPHONE_DATA_CONTACT_CONTACT_SELECTED_ITEM_NUMBER_OF_SUB_ITEMS_INTEGER;
    public static final int SPEECHPHONE_DATA_CONTACT_CONTACT_SELECTED_ITEM_NAME_STRING;
    public static final int SPEECHPHONE_DATA_CONTACT_CONTACT_SELECTED_ITEM_COMBINED_LOC_TYPE_INTEGER;
    public static final int SPEECHPHONE_DATA_CONTACT_CONTACT_SELECTED_ITEM_NUMBER_STRING;
    public static final int SPEECHPHONE_DATA_CONTACT_CONTACT_SELECTED_ITEM_COUNT_OF_NUMBERS_INTEGER;
    public static final int SPEECHPHONE_DATA_CONTACT_CONTACT_SELECTED_ITEM_PICTURE_RESOURCE_LOCATOR;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[7];
        int n = 0;
        stringArray[n++] = TransformerUtil.getLongAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 5, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(-1985398016);
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
            case 3: 
            case 4: 
            case 5: 
            case 6: {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(int n, Object object) {
        switch (n) {
            case 1: 
            case 4: 
            case 6: {
                return new Integer(this.getInt(n, object));
            }
            case 2: 
            case 3: {
                return this.getString(n, object);
            }
            case 5: {
                return this.getResourceLocator(n, object);
            }
            case 0: {
                return new Long(this.getLong(n, object));
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean getBoolean(int n, Object object) {
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

