/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.map.ss.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.navigation.map.ss.transformer.NavigationMapSSSymbolDataCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class NavigationMapSSSymbolDataTransformer
extends ItemTransformerAdapter {
    public static final int NAVIGATION_MAP_SS_SYMBOL_DATA_NEXT_STREET_STRING;
    public static final int NAVIGATION_MAP_SS_SYMBOL_DATA_NEXT_STREET_SIGN_POST_STRING;
    public static final int NAVIGATION_MAP_SS_SYMBOL_DATA_DISTANCE_INTEGER;
    public static final int NAVIGATION_MAP_SS_SYMBOL_DATA_DISTANCE_VISIBLE_BOOLEAN;
    public static final int NAVIGATION_MAP_SS_SYMBOL_DATA_STREET_STRING;
    public static final int NAVIGATION_MAP_SS_SYMBOL_DATA_DISTANCE_TO_NEXT_MANEUVRE_INTEGER;
    public static final int NAVIGATION_MAP_SS_SYMBOL_DATA_DISTANCE_TO_NEXT_MANEUVRE_IS_VISIBLE_BOOLEAN;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[7];
        int n = 0;
        stringArray[n++] = TransformerUtil.getStringAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 5, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(861);
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
            case 2: 
            case 5: {
                return this.getBoolean(n, object);
            }
            case 1: 
            case 4: {
                return new Integer(this.getInt(n, object));
            }
            case 0: 
            case 3: 
            case 6: {
                return this.getString(n, object);
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        NavigationMapSSSymbolDataCollector navigationMapSSSymbolDataCollector = (NavigationMapSSSymbolDataCollector)object;
        switch (n) {
            case 2: {
                return navigationMapSSSymbolDataCollector.navigation_map_ss_symbol_data_distance_visible;
            }
            case 5: {
                return navigationMapSSSymbolDataCollector.navigation_map_ss_symbol_data_distance_to_next_maneuvre_is_visible;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        NavigationMapSSSymbolDataCollector navigationMapSSSymbolDataCollector = (NavigationMapSSSymbolDataCollector)object;
        switch (n) {
            case 1: {
                return navigationMapSSSymbolDataCollector.navigation_map_ss_symbol_data_distance;
            }
            case 4: {
                return navigationMapSSSymbolDataCollector.navigation_map_ss_symbol_data_distance_to_next_maneuvre;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        NavigationMapSSSymbolDataCollector navigationMapSSSymbolDataCollector = (NavigationMapSSSymbolDataCollector)object;
        switch (n) {
            case 0: {
                return navigationMapSSSymbolDataCollector.navigation_map_ss_symbol_data_next_street;
            }
            case 6: {
                return navigationMapSSSymbolDataCollector.navigation_map_ss_symbol_data_next_street_sign_post;
            }
            case 3: {
                return navigationMapSSSymbolDataCollector.navigation_map_ss_symbol_data_street;
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

