/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.phone.bluetooth.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import org.dsi.ifc.global.ResourceLocator;

public abstract class AbstractPhoneBluetoothBondingSearchResultTransformer
extends ItemTransformerAdapter {
    public static final int PHONE_BLUETOOTH_BONDING_SEARCH_FIRST_SUPPORTED_PROFILE_INTEGER;
    public static final int PHONE_BLUETOOTH_BONDING_SEARCH_NAME_STRING;
    public static final int PHONE_BLUETOOTH_BONDING_SEARCH_PROFILES_COUNT_INTEGER;
    public static final int PHONE_BLUETOOTH_BONDING_SEARCH_ALREADY_PAIRED_BOOLEAN;
    public static final int PHONE_BLUETOOTH_BONDING_SEARCH_FIRST_SUPPORTED_PROFILE_CONNECTED_BOOLEAN;
    public static final int PHONE_BLUETOOTH_BONDING_SEARCH_FIRST_SUPPORTED_PROFILE_TEMPORARY_AVAILABLE_BOOLEAN;
    public static final int PHONE_BLUETOOTH_BONDING_SEARCH_MEDIA_PROFILE_CONNECTED_BOOLEAN;
    public static final int PHONE_BLUETOOTH_BONDING_SEARCH_MEDIA_PROFILE_SUPPORTED_BOOLEAN;
    public static final int PHONE_BLUETOOTH_BONDING_SEARCH_OTHER_PROFILE_CONNECTED_BOOLEAN;
    public static final int PHONE_BLUETOOTH_BONDING_SEARCH_OTHER_PROFILE_SUPPORTED_BOOLEAN;
    public static final int PHONE_BLUETOOTH_BONDING_SEARCH_PHONE_PROFILE_CONNECTED_BOOLEAN;
    public static final int PHONE_BLUETOOTH_BONDING_SEARCH_PHONE_PROFILE_SUPPORTED_BOOLEAN;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[12];
        int n = 0;
        stringArray[n++] = TransformerUtil.getIntAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 8, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 9, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 10, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 11, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(1142);
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
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: {
                return this.getBoolean(n, object);
            }
            case 0: 
            case 2: {
                return new Integer(this.getInt(n, object));
            }
            case 1: {
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

