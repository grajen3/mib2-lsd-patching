/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.map.clickinmap.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.navigation.map.clickinmap.transformer.NavigationMapClickInMapClickInMapDataCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class NavigationMapClickInMapClickInMapDataTransformer
extends ItemTransformerAdapter {
    public static final int NAVIGATION_MAP_CLICKINMAP_CLICK_IN_MAP_ADDRESS_INFO_FOR_FIX_FORMATTER_FIX_FORMATTER_FIELD_DATA;
    public static final int NAVIGATION_MAP_CLICKINMAP_CLICK_IN_MAP_ELEMENT_ICON_RESOURCE_LOCATOR;
    public static final int NAVIGATION_MAP_CLICKINMAP_CLICK_IN_MAP_ELEMENT_NAME_STRING;
    public static final int NAVIGATION_MAP_CLICKINMAP_CLICK_IN_MAP_IS_STREET_VIEW_AVAILABLE_BOOLEAN;
    public static final int NAVIGATION_MAP_CLICKINMAP_CLICK_IN_MAP_ELEMENT_TYPE_INTEGER;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[5];
        int n = 0;
        stringArray[n++] = TransformerUtil.getFixFormatterFieldDataAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 4, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(-1896869888);
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
            case 4: {
                return new Integer(this.getInt(n, object));
            }
            case 2: {
                return this.getString(n, object);
            }
            case 1: {
                return this.getResourceLocator(n, object);
            }
            case 0: {
                return this.getFixFormatterFieldData(n, object);
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        NavigationMapClickInMapClickInMapDataCollector navigationMapClickInMapClickInMapDataCollector = (NavigationMapClickInMapClickInMapDataCollector)object;
        switch (n) {
            case 3: {
                return navigationMapClickInMapClickInMapDataCollector.navigation_map_clickinmap_click_in_map_is_street_view_available;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        NavigationMapClickInMapClickInMapDataCollector navigationMapClickInMapClickInMapDataCollector = (NavigationMapClickInMapClickInMapDataCollector)object;
        switch (n) {
            case 4: {
                return navigationMapClickInMapClickInMapDataCollector.navigation_map_clickinmap_click_in_map_element_type;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        NavigationMapClickInMapClickInMapDataCollector navigationMapClickInMapClickInMapDataCollector = (NavigationMapClickInMapClickInMapDataCollector)object;
        switch (n) {
            case 2: {
                return navigationMapClickInMapClickInMapDataCollector.navigation_map_clickinmap_click_in_map_element_name;
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
        NavigationMapClickInMapClickInMapDataCollector navigationMapClickInMapClickInMapDataCollector = (NavigationMapClickInMapClickInMapDataCollector)object;
        switch (n) {
            case 1: {
                return navigationMapClickInMapClickInMapDataCollector.navigation_map_clickinmap_click_in_map_element_icon;
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
        NavigationMapClickInMapClickInMapDataCollector navigationMapClickInMapClickInMapDataCollector = (NavigationMapClickInMapClickInMapDataCollector)object;
        switch (n) {
            case 0: {
                return navigationMapClickInMapClickInMapDataCollector.navigation_map_clickinmap_click_in_map_address_info_for_fix_formatter;
            }
        }
        throw new IllegalArgumentException();
    }
}

