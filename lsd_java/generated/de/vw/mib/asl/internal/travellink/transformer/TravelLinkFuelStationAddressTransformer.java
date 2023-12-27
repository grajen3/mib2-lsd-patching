/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.travellink.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.travellink.transformer.TravelLinkFuelStationAddressCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class TravelLinkFuelStationAddressTransformer
extends ItemTransformerAdapter {
    public static final int TRAVELLINK_FUEL_STATION_ADDRESS__DIRECTION_INTEGER;
    public static final int TRAVELLINK_FUEL_STATION_ADDRESS__DISTANCE_INTEGER;
    public static final int TRAVELLINK_FUEL_STATION_ADDRESS__NAME_STRING;
    public static final int TRAVELLINK_FUEL_STATION_ADDRESS__ADDRESS_STRING;
    public static final int TRAVELLINK_FUEL_STATION_ADDRESS__ICON_RESOURCE_LOCATOR;
    public static final int TRAVELLINK_FUEL_STATION_ADDRESS__DISTANCE_AND_UNIT_STRING;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[6];
        int n = 0;
        stringArray[n++] = TransformerUtil.getIntAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 5, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(-415292672);
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
            case 0: 
            case 1: {
                return new Integer(this.getInt(n, object));
            }
            case 2: 
            case 3: 
            case 5: {
                return this.getString(n, object);
            }
            case 4: {
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
        TravelLinkFuelStationAddressCollector travelLinkFuelStationAddressCollector = (TravelLinkFuelStationAddressCollector)object;
        switch (n) {
            case 0: {
                return travelLinkFuelStationAddressCollector.travellink_fuel_station_address__direction;
            }
            case 1: {
                return travelLinkFuelStationAddressCollector.travellink_fuel_station_address__distance;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        TravelLinkFuelStationAddressCollector travelLinkFuelStationAddressCollector = (TravelLinkFuelStationAddressCollector)object;
        switch (n) {
            case 2: {
                return travelLinkFuelStationAddressCollector.travellink_fuel_station_address__name;
            }
            case 3: {
                return travelLinkFuelStationAddressCollector.travellink_fuel_station_address__address;
            }
            case 5: {
                return travelLinkFuelStationAddressCollector.travellink_fuel_station_address__distance_and_unit;
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
        TravelLinkFuelStationAddressCollector travelLinkFuelStationAddressCollector = (TravelLinkFuelStationAddressCollector)object;
        switch (n) {
            case 4: {
                return travelLinkFuelStationAddressCollector.travellink_fuel_station_address__icon;
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

