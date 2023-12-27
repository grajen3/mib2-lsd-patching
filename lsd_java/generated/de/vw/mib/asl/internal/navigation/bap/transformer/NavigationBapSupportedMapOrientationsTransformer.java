/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.bap.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.navigation.bap.transformer.NavigationBapSupportedMapOrientationsCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class NavigationBapSupportedMapOrientationsTransformer
extends ItemTransformerAdapter {
    public static final int NAVIGATION_BAP_AUTOMATIC_ORIENTATION_SUPPORTED_BOOLEAN;
    public static final int NAVIGATION_BAP_NORTH_ORIENTATION_SUPPORTED_BOOLEAN;
    public static final int NAVIGATION_BAP_DIRECTION_OF_TRAVEL_SUPPORTED_BOOLEAN;
    public static final int NAVIGATION_BAP_MAP_ORIENTATION_CAN_BE_MODIFIED_BOOLEAN;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[4];
        int n = 0;
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 3, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(3797);
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
            case 0: 
            case 1: 
            case 2: 
            case 3: {
                return this.getBoolean(n, object);
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        NavigationBapSupportedMapOrientationsCollector navigationBapSupportedMapOrientationsCollector = (NavigationBapSupportedMapOrientationsCollector)object;
        switch (n) {
            case 0: {
                return navigationBapSupportedMapOrientationsCollector.navigation_bap_automatic_orientation_supported;
            }
            case 1: {
                return navigationBapSupportedMapOrientationsCollector.navigation_bap_north_orientation_supported;
            }
            case 2: {
                return navigationBapSupportedMapOrientationsCollector.navigation_bap_direction_of_travel_supported;
            }
            case 3: {
                return navigationBapSupportedMapOrientationsCollector.navigation_bap_map_orientation_can_be_modified;
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

