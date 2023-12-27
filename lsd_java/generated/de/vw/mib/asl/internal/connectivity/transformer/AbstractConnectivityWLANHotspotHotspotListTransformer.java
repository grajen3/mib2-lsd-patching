/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.connectivity.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import org.dsi.ifc.global.ResourceLocator;

public abstract class AbstractConnectivityWLANHotspotHotspotListTransformer
extends ItemTransformerAdapter {
    public static final int CONNECTIVITY_WLAN_HOTSPOT_HOTSPOT_LIST_NAME_STRING;
    public static final int CONNECTIVITY_WLAN_HOTSPOT_HOTSPOT_LIST_SECURITY_LEVEL2_INTEGER;
    public static final int CONNECTIVITY_WLAN_HOTSPOT_HOTSPOT_LIST_SECURITY_LEVEL3_INTEGER;
    public static final int CONNECTIVITY_WLAN_HOTSPOT_HOTSPOT_LIST_TRUSTED_DEVICE_BOOLEAN;
    public static final int CONNECTIVITY_WLAN_HOTSPOT_HOTSPOT_LIST_SIGNAL_STRENGTH_INTEGER;
    public static final int CONNECTIVITY_WLAN_HOTSPOT_HOTSPOT_LIST_AVAILABLE_BOOLEAN;
    public static final int CONNECTIVITY_WLAN_HOTSPOT_HOTSPOT_LIST_WPS_AVAILABLE_BOOLEAN;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[7];
        int n = 0;
        stringArray[n++] = TransformerUtil.getStringAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 6, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(4004);
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public boolean isColumnIdSupported(int n) {
        switch (n) {
            case 0: 
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
            case 3: 
            case 4: 
            case 6: {
                return this.getBoolean(n, object);
            }
            case 2: 
            case 5: 
            case 7: {
                return new Integer(this.getInt(n, object));
            }
            case 0: {
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

