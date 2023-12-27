/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.car.bordcomputer.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.car.bordcomputer.transformer.CarBordComputerEcoComfortConsumptionCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class CarBordComputerEcoComfortConsumptionTransformer
extends ItemTransformerAdapter {
    public static final int CAR_BORDCOMPUTER_ECO_COMFORT_CONSUMPTION_VALUE_INTEGER;
    public static final int CAR_BORDCOMPUTER_ECO_COMFORT_CONSUMPTION_UNIT_INTEGER;
    public static final int CAR_BORDCOMPUTER_ECO_COMFORT_CONSUMPTION_MAX_INTEGER;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[3];
        int n = 0;
        stringArray[n++] = TransformerUtil.getIntAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 2, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(10142);
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public boolean isColumnIdSupported(int n) {
        switch (n) {
            case 0: 
            case 1: 
            case 2: {
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
            case 2: {
                return new Integer(this.getInt(n, object));
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
        CarBordComputerEcoComfortConsumptionCollector carBordComputerEcoComfortConsumptionCollector = (CarBordComputerEcoComfortConsumptionCollector)object;
        switch (n) {
            case 0: {
                return carBordComputerEcoComfortConsumptionCollector.car_bordcomputer_eco_comfort_consumption_value;
            }
            case 1: {
                return carBordComputerEcoComfortConsumptionCollector.car_bordcomputer_eco_comfort_consumption_unit;
            }
            case 2: {
                return carBordComputerEcoComfortConsumptionCollector.car_bordcomputer_eco_comfort_consumption_max;
            }
        }
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

