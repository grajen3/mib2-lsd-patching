/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.traffic.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import generated.de.vw.mib.asl.internal.ASLListColumns;

public abstract class AbstractNavigationTrafficTMCOverviewSubListTransformer
extends ItemTransformerAdapter {
    public static final int NAVIGATION_TRAFFIC_TMC_OVERVIEW_SUB_LIST_EVENT0_STRING;
    public static final int NAVIGATION_TRAFFIC_TMC_OVERVIEW_SUB_LIST_ICON_RESOURCE_LOCATOR;
    public static final int NAVIGATION_TRAFFIC_TMC_OVERVIEW_SUB_LIST_LABELED_ICONS_LABELED_ICON;
    public static final int NAVIGATION_TRAFFIC_TMC_OVERVIEW_SUB_LIST_ELEMENT_DETAILS_FOR_FIX_FORMATTER_FIX_FORMATTER_FIELD_DATA;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[4];
        int n = 0;
        stringArray[n++] = TransformerUtil.getStringAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getLabeledIconValueAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getFixFormatterFieldDataAsString(this, 10, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(1018);
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public boolean isColumnIdSupported(int n) {
        switch (n) {
            case 0: 
            case 5: 
            case 6: 
            case 10: {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(int n, Object object) {
        switch (n) {
            case 0: {
                return this.getString(n, object);
            }
            case 5: {
                return this.getResourceLocator(n, object);
            }
            case 6: {
                return this.getLabeledIconValue(n, object);
            }
            case 10: {
                return this.getFixFormatterFieldData(n, object);
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
    public long getLong(int n, Object object) {
        throw new IllegalArgumentException();
    }
}

