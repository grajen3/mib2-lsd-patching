/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.phone.bluetooth.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.phone.bluetooth.transformer.PhoneBluetoothBondingErrorCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class PhoneBluetoothBondingErrorTransformer
extends ItemTransformerAdapter {
    public static final int PHONE_BLUETOOTH_BONDING_ERROR_DEVICE_NAME_STRING;
    public static final int PHONE_BLUETOOTH_BONDING_ERROR_PROFILE_INTEGER;
    public static final int PHONE_BLUETOOTH_BONDING_ERROR__7_INTEGER;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[3];
        int n = 0;
        stringArray[n++] = TransformerUtil.getStringAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 6, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(2855);
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public boolean isColumnIdSupported(int n) {
        switch (n) {
            case 0: 
            case 1: 
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
            case 6: {
                return new Integer(this.getInt(n, object));
            }
            case 0: {
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
        PhoneBluetoothBondingErrorCollector phoneBluetoothBondingErrorCollector = (PhoneBluetoothBondingErrorCollector)object;
        switch (n) {
            case 1: {
                return phoneBluetoothBondingErrorCollector.phone_bluetooth_bonding_error_profile;
            }
            case 6: {
                return phoneBluetoothBondingErrorCollector.phone_bluetooth_bonding_error__7;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        PhoneBluetoothBondingErrorCollector phoneBluetoothBondingErrorCollector = (PhoneBluetoothBondingErrorCollector)object;
        switch (n) {
            case 0: {
                return phoneBluetoothBondingErrorCollector.phone_bluetooth_bonding_error_device_name;
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

