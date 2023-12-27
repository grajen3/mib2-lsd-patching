/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.online.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.online.transformer.OnlineOnlineOCUUpdateCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class OnlineOnlineOCUUpdateTransformer
extends ItemTransformerAdapter {
    public static final int ONLINE_ONLINE_OCU_UPDATE_NAME_STRING;
    public static final int ONLINE_ONLINE_OCU_UPDATE_CUSTOMER_NAME_STRING;
    public static final int ONLINE_ONLINE_OCU_UPDATE_DURATION_STRING;
    public static final int ONLINE_ONLINE_OCU_UPDATE_DISCLAIMER_TEXT_STRING;
    public static final int ONLINE_ONLINE_OCU_UPDATE_VIN_STRING;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[5];
        int n = 0;
        stringArray[n++] = TransformerUtil.getStringAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 4, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(1778193152);
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public boolean isColumnIdSupported(int n) {
        switch (n) {
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: {
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
            case 4: {
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
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        OnlineOnlineOCUUpdateCollector onlineOnlineOCUUpdateCollector = (OnlineOnlineOCUUpdateCollector)object;
        switch (n) {
            case 0: {
                return onlineOnlineOCUUpdateCollector.online_online_ocu_update_name;
            }
            case 1: {
                return onlineOnlineOCUUpdateCollector.online_online_ocu_update_customer_name;
            }
            case 2: {
                return onlineOnlineOCUUpdateCollector.online_online_ocu_update_duration;
            }
            case 3: {
                return onlineOnlineOCUUpdateCollector.online_online_ocu_update_disclaimer_text;
            }
            case 4: {
                return onlineOnlineOCUUpdateCollector.online_online_ocu_update_vin;
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

