/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.bap.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import org.dsi.ifc.global.ResourceLocator;

public abstract class AbstractNavigationBapAddressListTransformer
extends ItemTransformerAdapter {
    public static final int NAVIGATION_BAP_ADDRESS_LIST_ADDRESS_TYPE_INTEGER;
    public static final int NAVIGATION_BAP_ADDRESS_LIST_CONTACT_ENTRY_ID_LONG;
    public static final int NAVIGATION_BAP_ADDRESS_LIST_CITY_STRING;
    public static final int NAVIGATION_BAP_ADDRESS_LIST_COORDINATES_STRING;
    public static final int NAVIGATION_BAP_ADDRESS_LIST_COUNTRY_STRING;
    public static final int NAVIGATION_BAP_ADDRESS_LIST_ENTRY_POS_INTEGER;
    public static final int NAVIGATION_BAP_ADDRESS_LIST_FIRST_NAME_STRING;
    public static final int NAVIGATION_BAP_ADDRESS_LIST_LAST_NAME_STRING;
    public static final int NAVIGATION_BAP_ADDRESS_LIST_POI_DESCRIPTION_STRING;
    public static final int NAVIGATION_BAP_ADDRESS_LIST_POI_TYPE_INTEGER;
    public static final int NAVIGATION_BAP_ADDRESS_LIST_POSTAL_CODE_STRING;
    public static final int NAVIGATION_BAP_ADDRESS_LIST_REGION_STRING;
    public static final int NAVIGATION_BAP_ADDRESS_LIST_STREET_STRING;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[13];
        int n = 0;
        stringArray[n++] = TransformerUtil.getIntAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getLongAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 8, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 9, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 10, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 11, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 12, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(739);
    }

    @Override
    public int getColumnCount() {
        return 13;
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
            case 11: 
            case 12: {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(int n, Object object) {
        switch (n) {
            case 0: 
            case 5: 
            case 9: {
                return new Integer(this.getInt(n, object));
            }
            case 2: 
            case 3: 
            case 4: 
            case 6: 
            case 7: 
            case 8: 
            case 10: 
            case 11: 
            case 12: {
                return this.getString(n, object);
            }
            case 1: {
                return new Long(this.getLong(n, object));
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean getBoolean(int n, Object object) {
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
    public LabeledIconValue getLabeledIconValue(int n, Object object) {
        throw new IllegalArgumentException();
    }

    @Override
    public FixFormatterFieldData getFixFormatterFieldData(int n, Object object) {
        throw new IllegalArgumentException();
    }
}

