/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.destinput.destlist.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import org.dsi.ifc.global.ResourceLocator;

public abstract class AbstractNavigationDestInputDestListDestinationListAllTransformer
extends ItemTransformerAdapter {
    public static final int NAVIGATION_DESTINPUT_DESTLIST_DESTINATION_LIST_CITY_STRING;
    public static final int NAVIGATION_DESTINPUT_DESTLIST_DESTINATION_LIST_STREET_STRING;
    public static final int NAVIGATION_DESTINPUT_DESTLIST_DESTINATION_LIST_CROSSING_STRING;
    public static final int NAVIGATION_DESTINPUT_DESTLIST_DESTINATION_LIST_HNO_STRING;
    public static final int NAVIGATION_DESTINPUT_DESTLIST_DESTINATION_LIST_LAT_DEGREE_INTEGER;
    public static final int NAVIGATION_DESTINPUT_DESTLIST_DESTINATION_LIST_LAT_MIN_INTEGER;
    public static final int NAVIGATION_DESTINPUT_DESTLIST_DESTINATION_LIST_LAT_SEC_INTEGER;
    public static final int NAVIGATION_DESTINPUT_DESTLIST_DESTINATION_LIST_LON_DEGREE_INTEGER;
    public static final int NAVIGATION_DESTINPUT_DESTLIST_DESTINATION_LIST_LON_MIN_INTEGER;
    public static final int NAVIGATION_DESTINPUT_DESTLIST_DESTINATION_LIST_LON_SEC_INTEGER;
    public static final int NAVIGATION_DESTINPUT_DESTLIST_DESTINATION_LIST_POI_NAME_STRING;
    public static final int NAVIGATION_DESTINPUT_DESTLIST_DESTINATION_LIST_LOCATION_TYPE_INTEGER;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[12];
        int n = 0;
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 8, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 9, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 10, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 11, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(3009);
    }

    @Override
    public int getColumnCount() {
        return 12;
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
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(int n, Object object) {
        switch (n) {
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 11: {
                return new Integer(this.getInt(n, object));
            }
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 10: {
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

