/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.car.parkassistence.ops.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.car.parkassistence.ops.transformer.CarParkAssistenceOPSSteeringInfoWheelRadiusCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class CarParkAssistenceOPSSteeringInfoWheelRadiusTransformer
extends ItemTransformerAdapter {
    public static final int CAR_PARKASSISTENCE_OPS_STEERING_INFO_WHEEL_RADIUS_REAR__1_INTEGER;
    public static final int CAR_PARKASSISTENCE_OPS_STEERING_INFO_WHEEL_RADIUS_FRONT__1_INTEGER;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[2];
        int n = 0;
        stringArray[n++] = TransformerUtil.getIntAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 1, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(10197);
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
            case 0: 
            case 1: {
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
        CarParkAssistenceOPSSteeringInfoWheelRadiusCollector carParkAssistenceOPSSteeringInfoWheelRadiusCollector = (CarParkAssistenceOPSSteeringInfoWheelRadiusCollector)object;
        switch (n) {
            case 0: {
                return carParkAssistenceOPSSteeringInfoWheelRadiusCollector.car_parkassistence_ops_steering_info_wheel_radius_rear__1;
            }
            case 1: {
                return carParkAssistenceOPSSteeringInfoWheelRadiusCollector.car_parkassistence_ops_steering_info_wheel_radius_front__1;
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

