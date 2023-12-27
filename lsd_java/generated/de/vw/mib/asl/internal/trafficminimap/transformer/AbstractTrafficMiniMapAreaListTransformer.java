/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.trafficminimap.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;

public abstract class AbstractTrafficMiniMapAreaListTransformer
extends ItemTransformerAdapter {
    public static final int TRAFFICMINIMAP_AREA_LIST_MAP_NAMES_STRING;
    public static final int TRAFFICMINIMAP_AREA_LIST_MAP_IDS_INTEGER;
    public static final int TRAFFICMINIMAP_AREA_LIST_MAP_GRAPHICS_RESOURCE_LOCATOR;
    public static final int TRAFFICMINIMAP_AREA_LIST_MAP_VALIDITY_BOOLEAN;
    public static final int TRAFFICMINIMAP_AREA_LIST_MAP_CONTENT_I_DS_LONG;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[5];
        int n = 0;
        stringArray[n++] = TransformerUtil.getStringAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getLongAsString(this, 4, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(-1847580160);
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
            case 3: {
                return this.getBoolean(n, object);
            }
            case 1: {
                return new Integer(this.getInt(n, object));
            }
            case 0: {
                return this.getString(n, object);
            }
            case 2: {
                return this.getResourceLocator(n, object);
            }
            case 4: {
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

