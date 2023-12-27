/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.map.duallistview.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.navigation.map.duallistview.transformer.NavigationMapDualListViewDualListViewIconsCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class NavigationMapDualListViewDualListViewIconsTransformer
extends ItemTransformerAdapter {
    public static final int NAVIGATION_MAP_DUALLISTVIEW_DUAL_LIST_VIEW_ICON1_RESOURCE_LOCATOR;
    public static final int NAVIGATION_MAP_DUALLISTVIEW_DUAL_LIST_VIEW_ICON2_RESOURCE_LOCATOR;
    public static final int NAVIGATION_MAP_DUALLISTVIEW_DUAL_LIST_VIEW_ICON3_RESOURCE_LOCATOR;
    public static final int NAVIGATION_MAP_DUALLISTVIEW_DUAL_LIST_VIEW_ICON4_RESOURCE_LOCATOR;
    public static final int NAVIGATION_MAP_DUALLISTVIEW_DUAL_LIST_VIEW_ICON5_RESOURCE_LOCATOR;
    public static final int NAVIGATION_MAP_DUALLISTVIEW_DUAL_LIST_VIEW_ICON6_RESOURCE_LOCATOR;
    public static final int NAVIGATION_MAP_DUALLISTVIEW_DUAL_LIST_VIEW_ICON_DEFAULT_RESOURCE_LOCATOR;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[7];
        int n = 0;
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 6, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(703598592);
    }

    @Override
    public int getColumnCount() {
        return 7;
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
            case 6: {
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
            case 5: 
            case 6: {
                return this.getResourceLocator(n, object);
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
        NavigationMapDualListViewDualListViewIconsCollector navigationMapDualListViewDualListViewIconsCollector = (NavigationMapDualListViewDualListViewIconsCollector)object;
        switch (n) {
            case 0: {
                return navigationMapDualListViewDualListViewIconsCollector.navigation_map_duallistview_dual_list_view_icon1;
            }
            case 1: {
                return navigationMapDualListViewDualListViewIconsCollector.navigation_map_duallistview_dual_list_view_icon2;
            }
            case 2: {
                return navigationMapDualListViewDualListViewIconsCollector.navigation_map_duallistview_dual_list_view_icon3;
            }
            case 3: {
                return navigationMapDualListViewDualListViewIconsCollector.navigation_map_duallistview_dual_list_view_icon4;
            }
            case 4: {
                return navigationMapDualListViewDualListViewIconsCollector.navigation_map_duallistview_dual_list_view_icon5;
            }
            case 5: {
                return navigationMapDualListViewDualListViewIconsCollector.navigation_map_duallistview_dual_list_view_icon6;
            }
            case 6: {
                return navigationMapDualListViewDualListViewIconsCollector.navigation_map_duallistview_dual_list_view_icon_default;
            }
        }
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

