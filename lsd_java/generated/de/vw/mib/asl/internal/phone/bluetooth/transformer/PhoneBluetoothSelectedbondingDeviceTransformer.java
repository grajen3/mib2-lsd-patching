/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.phone.bluetooth.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.phone.bluetooth.transformer.PhoneBluetoothSelectedbondingDeviceCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class PhoneBluetoothSelectedbondingDeviceTransformer
extends ItemTransformerAdapter {
    public static final int PHONE_BLUETOOTH_SELECTED_DEVICE_CONNECTED_SIMAP_BOOLEAN;
    public static final int PHONE_BLUETOOTH_SELECTED_DEVICE_SIMAP_TEMPORARY_AVAILABLE_BOOLEAN;
    public static final int PHONE_BLUETOOTH_SELECTED_DEVICE_SUPPORT_HFP_BOOLEAN;
    public static final int PHONE_BLUETOOTH_SELECTED_DEVICE_SUPPORT_MAP1_BOOLEAN;
    public static final int PHONE_BLUETOOTH_SELECTED_DEVICE_SUPPORT_MAP2_BOOLEAN;
    public static final int PHONE_BLUETOOTH_SELECTED_DEVICE_SUPPORT_SIMAP_BOOLEAN;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[6];
        int n = 0;
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 5, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(1143);
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public boolean isColumnIdSupported(int n) {
        switch (n) {
            case 0: 
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
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: {
                return this.getBoolean(n, object);
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        PhoneBluetoothSelectedbondingDeviceCollector phoneBluetoothSelectedbondingDeviceCollector = (PhoneBluetoothSelectedbondingDeviceCollector)object;
        switch (n) {
            case 0: {
                return phoneBluetoothSelectedbondingDeviceCollector.phone_bluetooth_selected_device_connected_simap;
            }
            case 1: {
                return phoneBluetoothSelectedbondingDeviceCollector.phone_bluetooth_selected_device_simap_temporary_available;
            }
            case 2: {
                return phoneBluetoothSelectedbondingDeviceCollector.phone_bluetooth_selected_device_support_hfp;
            }
            case 3: {
                return phoneBluetoothSelectedbondingDeviceCollector.phone_bluetooth_selected_device_support_map1;
            }
            case 4: {
                return phoneBluetoothSelectedbondingDeviceCollector.phone_bluetooth_selected_device_support_map2;
            }
            case 5: {
                return phoneBluetoothSelectedbondingDeviceCollector.phone_bluetooth_selected_device_support_simap;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
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

