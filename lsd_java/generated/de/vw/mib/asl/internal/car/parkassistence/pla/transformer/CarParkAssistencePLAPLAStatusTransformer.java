/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.car.parkassistence.pla.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.car.parkassistence.pla.transformer.CarParkAssistencePLAPLAStatusCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class CarParkAssistencePLAPLAStatusTransformer
extends ItemTransformerAdapter {
    public static final int CAR_PARKASSISTENCE_PLA_PLA_FRONT_LEFT_BOOLEAN;
    public static final int CAR_PARKASSISTENCE_PLA_PLA_SIDE_LEFT_BOOLEAN;
    public static final int CAR_PARKASSISTENCE_PLA_PLA_BACK_LEFT_BOOLEAN;
    public static final int CAR_PARKASSISTENCE_PLA_PLA_FRONT_RIGHT_BOOLEAN;
    public static final int CAR_PARKASSISTENCE_PLA_PLA_SIDE_RIGHT_BOOLEAN;
    public static final int CAR_PARKASSISTENCE_PLA_PLA_BACK_RIGHT_BOOLEAN;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[6];
        int n = 0;
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 5, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(10809);
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
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: {
                return this.getBoolean(n, object);
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        CarParkAssistencePLAPLAStatusCollector carParkAssistencePLAPLAStatusCollector = (CarParkAssistencePLAPLAStatusCollector)object;
        switch (n) {
            case 0: {
                return carParkAssistencePLAPLAStatusCollector.car_parkassistence_pla_pla_front_left;
            }
            case 1: {
                return carParkAssistencePLAPLAStatusCollector.car_parkassistence_pla_pla_side_left;
            }
            case 2: {
                return carParkAssistencePLAPLAStatusCollector.car_parkassistence_pla_pla_back_left;
            }
            case 3: {
                return carParkAssistencePLAPLAStatusCollector.car_parkassistence_pla_pla_front_right;
            }
            case 4: {
                return carParkAssistencePLAPLAStatusCollector.car_parkassistence_pla_pla_side_right;
            }
            case 5: {
                return carParkAssistencePLAPLAStatusCollector.car_parkassistence_pla_pla_back_right;
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

