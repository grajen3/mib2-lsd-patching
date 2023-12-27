/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.pnav.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.navigation.pnav.transformer.NavigationPnavTextAreaContentCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class NavigationPnavTextAreaContentTransformer
extends ItemTransformerAdapter {
    public static final int NAVIGATION_PNAV_TEXT_AREA_TEXT_STRING;
    public static final int NAVIGATION_PNAV_TEXT_AREA_VISIBLE_BOOLEAN;
    public static final int NAVIGATION_PNAV_TEXT_AREA_POSITION_X_INTEGER;
    public static final int NAVIGATION_PNAV_TEXT_AREA_POSITION_Y_INTEGER;
    public static final int NAVIGATION_PNAV_TEXT_AREA_DIMENSION_WIDTH_INTEGER;
    public static final int NAVIGATION_PNAV_TEXT_AREA_DIMENSION_HEIGHT_INTEGER;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[6];
        int n = 0;
        stringArray[n++] = TransformerUtil.getStringAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 5, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(2499);
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public boolean isColumnIdSupported(int n) {
        switch (n) {
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(int n, Object object) {
        switch (n) {
            case 1: {
                return this.getBoolean(n, object);
            }
            case 2: 
            case 3: 
            case 4: 
            case 5: {
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
        NavigationPnavTextAreaContentCollector navigationPnavTextAreaContentCollector = (NavigationPnavTextAreaContentCollector)object;
        switch (n) {
            case 1: {
                return navigationPnavTextAreaContentCollector.navigation_pnav_text_area_visible;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        NavigationPnavTextAreaContentCollector navigationPnavTextAreaContentCollector = (NavigationPnavTextAreaContentCollector)object;
        switch (n) {
            case 2: {
                return navigationPnavTextAreaContentCollector.navigation_pnav_text_area_position_x;
            }
            case 3: {
                return navigationPnavTextAreaContentCollector.navigation_pnav_text_area_position_y;
            }
            case 4: {
                return navigationPnavTextAreaContentCollector.navigation_pnav_text_area_dimension_width;
            }
            case 5: {
                return navigationPnavTextAreaContentCollector.navigation_pnav_text_area_dimension_height;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        NavigationPnavTextAreaContentCollector navigationPnavTextAreaContentCollector = (NavigationPnavTextAreaContentCollector)object;
        switch (n) {
            case 0: {
                return navigationPnavTextAreaContentCollector.navigation_pnav_text_area_text;
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

