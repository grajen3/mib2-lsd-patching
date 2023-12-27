/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.borderchange.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.navigation.borderchange.transformer.NavigationBorderChangeNewCountryCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class NavigationBorderChangeNewCountryTransformer
extends ItemTransformerAdapter {
    public static final int NAVIGATION_BORDERCHANGE_BORDER_CROSSING_INFO_BOOLEAN;
    public static final int NAVIGATION_BORDERCHANGE_NEW_COUNTRY_COUNTRY_NAME_STRING;
    public static final int NAVIGATION_BORDERCHANGE_NEW_COUNTRY_COUNTRY_CODE_STRING;
    public static final int NAVIGATION_BORDERCHANGE_NEW_COUNTRY_COUNTRY_FLAG_RESOURCE_LOCATOR;
    public static final int NAVIGATION_BORDERCHANGE_BORDER_CROSS_INFO_SPEED_UNIT_INTEGER;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[5];
        int n = 0;
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 4, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(760);
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
            case 0: {
                return this.getBoolean(n, object);
            }
            case 4: {
                return new Integer(this.getInt(n, object));
            }
            case 1: 
            case 2: {
                return this.getString(n, object);
            }
            case 3: {
                return this.getResourceLocator(n, object);
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        NavigationBorderChangeNewCountryCollector navigationBorderChangeNewCountryCollector = (NavigationBorderChangeNewCountryCollector)object;
        switch (n) {
            case 0: {
                return navigationBorderChangeNewCountryCollector.navigation_borderchange_border_crossing_info;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        NavigationBorderChangeNewCountryCollector navigationBorderChangeNewCountryCollector = (NavigationBorderChangeNewCountryCollector)object;
        switch (n) {
            case 4: {
                return navigationBorderChangeNewCountryCollector.navigation_borderchange_border_cross_info_speed_unit;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        NavigationBorderChangeNewCountryCollector navigationBorderChangeNewCountryCollector = (NavigationBorderChangeNewCountryCollector)object;
        switch (n) {
            case 1: {
                return navigationBorderChangeNewCountryCollector.navigation_borderchange_new_country_country_name;
            }
            case 2: {
                return navigationBorderChangeNewCountryCollector.navigation_borderchange_new_country_country_code;
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
        NavigationBorderChangeNewCountryCollector navigationBorderChangeNewCountryCollector = (NavigationBorderChangeNewCountryCollector)object;
        switch (n) {
            case 3: {
                return navigationBorderChangeNewCountryCollector.navigation_borderchange_new_country_country_flag;
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

