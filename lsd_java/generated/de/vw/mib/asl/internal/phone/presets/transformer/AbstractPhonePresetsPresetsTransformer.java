/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.phone.presets.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;

public abstract class AbstractPhonePresetsPresetsTransformer
extends ItemTransformerAdapter {
    public static final int PHONE_PRESETS_COMBINED_NUMBER_TYPE__1_INTEGER;
    public static final int PHONE_PRESETS_DSI_NUMBER_TYPE_INTEGER;
    public static final int PHONE_PRESETS_ENTRY_ID_LONG;
    public static final int PHONE_PRESETS_NAME_STRING;
    public static final int PHONE_PRESETS_NUMBER_STRING;
    public static final int PHONE_PRESETS_PICTURE_RESOURCE_LOCATOR;
    public static final int PHONE_PRESETS_EMERGENCY_CALL_BOOLEAN;
    public static final int PHONE_PRESETS_EMPTY_BOOLEAN;
    public static final int PHONE_PRESETS_PICTURE_EMPTY_BOOLEAN;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[9];
        int n = 0;
        stringArray[n++] = TransformerUtil.getIntAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 9, object);
        stringArray[n++] = TransformerUtil.getLongAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 8, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 6, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(1194);
    }

    @Override
    public int getColumnCount() {
        return 9;
    }

    @Override
    public boolean isColumnIdSupported(int n) {
        switch (n) {
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
            case 5: 
            case 6: 
            case 8: {
                return this.getBoolean(n, object);
            }
            case 7: 
            case 9: {
                return new Integer(this.getInt(n, object));
            }
            case 2: 
            case 3: {
                return this.getString(n, object);
            }
            case 4: {
                return this.getResourceLocator(n, object);
            }
            case 1: {
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

