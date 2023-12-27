/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.travellink.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.travellink.transformer.TravelLinkAddressCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class TravelLinkAddressTransformer
extends ItemTransformerAdapter {
    public static final int TRAVELLINK_ADDRESS__CITY_STRING;
    public static final int TRAVELLINK_ADDRESS__DIRECTION_INTEGER;
    public static final int TRAVELLINK_ADDRESS__DISTANCE_INTEGER;
    public static final int TRAVELLINK_ADDRESS__NAME_STRING;
    public static final int TRAVELLINK_ADDRESS__PHONE_STRING;
    public static final int TRAVELLINK_ADDRESS__STATE_ABBREVIATION_STRING;
    public static final int TRAVELLINK_ADDRESS__STREET_NAME_STRING;
    public static final int TRAVELLINK_ADDRESS__STREET_NUMBER_STRING;
    public static final int TRAVELLINK_ADDRESS__ICON_RESOURCE_LOCATOR;
    public static final int TRAVELLINK_ADDRESS__ZIP_STRING;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[10];
        int n = 0;
        stringArray[n++] = TransformerUtil.getStringAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 9, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 8, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(-1019272448);
    }

    @Override
    public int getColumnCount() {
        return 10;
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
            case 9: {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(int n, Object object) {
        switch (n) {
            case 1: 
            case 2: {
                return new Integer(this.getInt(n, object));
            }
            case 0: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: {
                return this.getString(n, object);
            }
            case 9: {
                return this.getResourceLocator(n, object);
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
        TravelLinkAddressCollector travelLinkAddressCollector = (TravelLinkAddressCollector)object;
        switch (n) {
            case 1: {
                return travelLinkAddressCollector.travellink_address__direction;
            }
            case 2: {
                return travelLinkAddressCollector.travellink_address__distance;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        TravelLinkAddressCollector travelLinkAddressCollector = (TravelLinkAddressCollector)object;
        switch (n) {
            case 0: {
                return travelLinkAddressCollector.travellink_address__city;
            }
            case 3: {
                return travelLinkAddressCollector.travellink_address__name;
            }
            case 4: {
                return travelLinkAddressCollector.travellink_address__phone;
            }
            case 5: {
                return travelLinkAddressCollector.travellink_address__state_abbreviation;
            }
            case 6: {
                return travelLinkAddressCollector.travellink_address__street_name;
            }
            case 7: {
                return travelLinkAddressCollector.travellink_address__street_number;
            }
            case 8: {
                return travelLinkAddressCollector.travellink_address__zip;
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
        TravelLinkAddressCollector travelLinkAddressCollector = (TravelLinkAddressCollector)object;
        switch (n) {
            case 9: {
                return travelLinkAddressCollector.travellink_address__icon;
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

