/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.poi.category.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.navigation.poi.category.transformer.NavigationPOICategorySelectedItemCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class NavigationPOICategorySelectedItemTransformer
extends ItemTransformerAdapter {
    public static final int NAVIGATION_POI_CATEGORY_SELECTED_ITEM_NAME_STRING;
    public static final int NAVIGATION_POI_CATEGORY_SELECTED_ITEM_REFINEABLE_BOOLEAN;
    public static final int NAVIGATION_POI_CATEGORY_SELECTED_ITEM_ICON_AVAILABLE_BOOLEAN;
    public static final int NAVIGATION_POI_CATEGORY_SELECTED_ITEM_ICON_INDEX_INTEGER;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[4];
        int n = 0;
        stringArray[n++] = TransformerUtil.getStringAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 3, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(-1393553408);
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public boolean isColumnIdSupported(int n) {
        switch (n) {
            case 0: 
            case 1: 
            case 2: 
            case 3: {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(int n, Object object) {
        switch (n) {
            case 1: 
            case 2: {
                return this.getBoolean(n, object);
            }
            case 3: {
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
        NavigationPOICategorySelectedItemCollector navigationPOICategorySelectedItemCollector = (NavigationPOICategorySelectedItemCollector)object;
        switch (n) {
            case 1: {
                return navigationPOICategorySelectedItemCollector.navigation_poi_category_selected_item_refineable;
            }
            case 2: {
                return navigationPOICategorySelectedItemCollector.navigation_poi_category_selected_item_icon_available;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        NavigationPOICategorySelectedItemCollector navigationPOICategorySelectedItemCollector = (NavigationPOICategorySelectedItemCollector)object;
        switch (n) {
            case 3: {
                return navigationPOICategorySelectedItemCollector.navigation_poi_category_selected_item_icon_index;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        NavigationPOICategorySelectedItemCollector navigationPOICategorySelectedItemCollector = (NavigationPOICategorySelectedItemCollector)object;
        switch (n) {
            case 0: {
                return navigationPOICategorySelectedItemCollector.navigation_poi_category_selected_item_name;
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

