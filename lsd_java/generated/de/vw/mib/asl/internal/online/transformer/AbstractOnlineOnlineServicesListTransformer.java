/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.online.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import org.dsi.ifc.global.ResourceLocator;

public abstract class AbstractOnlineOnlineServicesListTransformer
extends ItemTransformerAdapter {
    public static final int ONLINE_ONLINE_SERVICES_LIST_NAME_INDEX_INTEGER;
    public static final int ONLINE_ONLINE_SERVICES_LIST_LICENSE_STATE_INDEX_INTEGER;
    public static final int ONLINE_ONLINE_SERVICES_LIST_ACTIVATION2_BOOLEAN;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[3];
        int n = 0;
        stringArray[n++] = TransformerUtil.getIntAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 3, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(4046);
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public boolean isColumnIdSupported(int n) {
        switch (n) {
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
            case 3: {
                return this.getBoolean(n, object);
            }
            case 4: 
            case 5: {
                return new Integer(this.getInt(n, object));
            }
        }
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

