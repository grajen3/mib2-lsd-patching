/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.map.ss.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.navigation.map.ss.transformer.NavigationMapSSManeuverExitViewDataCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class NavigationMapSSManeuverExitViewDataTransformer
extends ItemTransformerAdapter {
    public static final int NAVIGATION_MAP_SS_MANEUVER_EXIT_VIEW_DATA_SYMBOL_ID_INTEGER;
    public static final int NAVIGATION_MAP_SS_MANEUVER_EXIT_VIEW_DATA_MANEUVER_MAIN_ELEMENT_INTEGER;
    public static final int NAVIGATION_MAP_SS_MANEUVER_EXIT_VIEW_DATA_MANEUVER_DIRECTION_INTEGER;
    public static final int NAVIGATION_MAP_SS_MANEUVER_EXIT_VIEW_DATA_STREET_NUMBER_STRING;
    public static final int NAVIGATION_MAP_SS_MANEUVER_EXIT_VIEW_DATA_STREET_STRING;
    public static final int NAVIGATION_MAP_SS_MANEUVER_EXIT_VIEW_DATA_STREET_SIGN_POST_STRING;
    public static final int NAVIGATION_MAP_SS_MANEUVER_EXIT_VIEW_DATA_DTM_INTEGER;
    public static final int NAVIGATION_MAP_SS_MANEUVER_EXIT_VIEW_DATA_RTTM_INTEGER;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[8];
        int n = 0;
        stringArray[n++] = TransformerUtil.getIntAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 4, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(863);
    }

    @Override
    public int getColumnCount() {
        return 8;
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
            case 0: 
            case 3: 
            case 4: 
            case 5: 
            case 6: {
                return new Integer(this.getInt(n, object));
            }
            case 1: 
            case 2: 
            case 7: {
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
        NavigationMapSSManeuverExitViewDataCollector navigationMapSSManeuverExitViewDataCollector = (NavigationMapSSManeuverExitViewDataCollector)object;
        switch (n) {
            case 0: {
                return navigationMapSSManeuverExitViewDataCollector.navigation_map_ss_maneuver_exit_view_data_symbol_id;
            }
            case 5: {
                return navigationMapSSManeuverExitViewDataCollector.navigation_map_ss_maneuver_exit_view_data_maneuver_main_element;
            }
            case 6: {
                return navigationMapSSManeuverExitViewDataCollector.navigation_map_ss_maneuver_exit_view_data_maneuver_direction;
            }
            case 3: {
                return navigationMapSSManeuverExitViewDataCollector.navigation_map_ss_maneuver_exit_view_data_dtm;
            }
            case 4: {
                return navigationMapSSManeuverExitViewDataCollector.navigation_map_ss_maneuver_exit_view_data_rttm;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        NavigationMapSSManeuverExitViewDataCollector navigationMapSSManeuverExitViewDataCollector = (NavigationMapSSManeuverExitViewDataCollector)object;
        switch (n) {
            case 1: {
                return navigationMapSSManeuverExitViewDataCollector.navigation_map_ss_maneuver_exit_view_data_street_number;
            }
            case 2: {
                return navigationMapSSManeuverExitViewDataCollector.navigation_map_ss_maneuver_exit_view_data_street;
            }
            case 7: {
                return navigationMapSSManeuverExitViewDataCollector.navigation_map_ss_maneuver_exit_view_data_street_sign_post;
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

