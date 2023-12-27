/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.setup.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.navigation.setup.transformer.NavigationSetupGasStationNoneOptionCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class NavigationSetupGasStationNoneOptionTransformer
extends ItemTransformerAdapter {
    public static final int NAVIGATION_SETUP_GAS_STATION_NONE_OPTION_SELECTED_BOOLEAN;
    public static final int NAVIGATION_SETUP_GAS_STATION_NONE_OPTION_ICON_RESOURCE_LOCATOR;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[2];
        int n = 0;
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 1, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(983);
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public boolean isColumnIdSupported(int n) {
        switch (n) {
            case 0: 
            case 1: {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(int n, Object object) {
        switch (n) {
            case 0: {
                return this.getBoolean(n, object);
            }
            case 1: {
                return this.getResourceLocator(n, object);
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        NavigationSetupGasStationNoneOptionCollector navigationSetupGasStationNoneOptionCollector = (NavigationSetupGasStationNoneOptionCollector)object;
        switch (n) {
            case 0: {
                return navigationSetupGasStationNoneOptionCollector.navigation_setup_gas_station_none_option_selected;
            }
        }
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
        NavigationSetupGasStationNoneOptionCollector navigationSetupGasStationNoneOptionCollector = (NavigationSetupGasStationNoneOptionCollector)object;
        switch (n) {
            case 1: {
                return navigationSetupGasStationNoneOptionCollector.navigation_setup_gas_station_none_option_icon;
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

