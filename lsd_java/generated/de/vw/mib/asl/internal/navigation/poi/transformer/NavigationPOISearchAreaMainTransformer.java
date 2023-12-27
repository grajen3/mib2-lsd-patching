/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.poi.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.navigation.poi.transformer.NavigationPOISearchAreaMainCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class NavigationPOISearchAreaMainTransformer
extends ItemTransformerAdapter {
    public static final int NAVIGATION_POI_SEARCH_AREA_MAIN_CURRENT_DEST_CITY_STRING;
    public static final int NAVIGATION_POI_SEARCH_AREA_MAIN_CURRENT_DEST_STREET_STRING;
    public static final int NAVIGATION_POI_SEARCH_AREA_MAIN_CURRENT_STOPOVER_CITY_STRING;
    public static final int NAVIGATION_POI_SEARCH_AREA_MAIN_CURRENT_STOPOVER_STREET_STRING;
    public static final int NAVIGATION_POI_SEARCH_AREA_MAIN_CCP_CITY_STRING;
    public static final int NAVIGATION_POI_SEARCH_AREA_MAIN_CCP_STREET_STRING;
    public static final int NAVIGATION_POI_SEARCH_AREA_MAIN_ROUTE_STARTING_CITY_STRING;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[7];
        int n = 0;
        stringArray[n++] = TransformerUtil.getStringAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 6, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(951);
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
        NavigationPOISearchAreaMainCollector navigationPOISearchAreaMainCollector = (NavigationPOISearchAreaMainCollector)object;
        switch (n) {
            case 0: {
                return navigationPOISearchAreaMainCollector.navigation_poi_search_area_main_current_dest_city;
            }
            case 1: {
                return navigationPOISearchAreaMainCollector.navigation_poi_search_area_main_current_dest_street;
            }
            case 2: {
                return navigationPOISearchAreaMainCollector.navigation_poi_search_area_main_current_stopover_city;
            }
            case 3: {
                return navigationPOISearchAreaMainCollector.navigation_poi_search_area_main_current_stopover_street;
            }
            case 4: {
                return navigationPOISearchAreaMainCollector.navigation_poi_search_area_main_ccp_city;
            }
            case 5: {
                return navigationPOISearchAreaMainCollector.navigation_poi_search_area_main_ccp_street;
            }
            case 6: {
                return navigationPOISearchAreaMainCollector.navigation_poi_search_area_main_route_starting_city;
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

