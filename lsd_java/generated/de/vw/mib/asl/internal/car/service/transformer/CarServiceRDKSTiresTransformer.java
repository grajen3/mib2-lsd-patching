/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.car.service.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.car.service.transformer.CarServiceRDKSTiresCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class CarServiceRDKSTiresTransformer
extends ItemTransformerAdapter {
    public static final int CAR_SERVICE_RDKS_TIRES_REQ_PRESSURE_FRONT_INTEGER;
    public static final int CAR_SERVICE_RDKS_TIRES_REQ_PRESSURE_FRONT_DECIMAL_INTEGER;
    public static final int CAR_SERVICE_RDKS_TIRES_REQ_PRESSURE_REAR_INTEGER;
    public static final int CAR_SERVICE_RDKS_TIRES_REQ_PRESSURE_REAR_DECIMAL_INTEGER;
    public static final int CAR_SERVICE_RDKS_TIRES_PRESSURE_FRONT_LEFT_INTEGER;
    public static final int CAR_SERVICE_RDKS_TIRES_PRESSURE_FRONT_LEFT_DECIMAL_INTEGER;
    public static final int CAR_SERVICE_RDKS_TIRES_PRESSURE_FRONT_RIGHT_INTEGER;
    public static final int CAR_SERVICE_RDKS_TIRES_PRESSURE_FRONT_RIGHT_DECIMAL_INTEGER;
    public static final int CAR_SERVICE_RDKS_TIRES_PRESSURE_REAR_LEFT_INTEGER;
    public static final int CAR_SERVICE_RDKS_TIRES_PRESSURE_REAR_LEFT_DECIMAL_INTEGER;
    public static final int CAR_SERVICE_RDKS_TIRES_PRESSURE_REAR_RIGHT_INTEGER;
    public static final int CAR_SERVICE_RDKS_TIRES_PRESSURE_REAR_RIGHT_DECIMAL_INTEGER;
    public static final int CAR_SERVICE_RDKS_TIRES_PRESSURE_UNIT_INTEGER;
    public static final int CAR_SERVICE_RDKS_TIRE_STATUS_FRONT_LEFT_INTEGER;
    public static final int CAR_SERVICE_RDKS_TIRE_STATUS_FRONT_RIGHT_INTEGER;
    public static final int CAR_SERVICE_RDKS_TIRE_STATUS_REAR_LEFT_INTEGER;
    public static final int CAR_SERVICE_RDKS_TIRE_STATUS_REAR_RIGHT_INTEGER;
    public static final int CAR_SERVICE_RDKS_TIRES_STATUS_COLLECTED_INTEGER;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[18];
        int n = 0;
        stringArray[n++] = TransformerUtil.getIntAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 8, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 9, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 10, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 11, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 12, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 13, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 14, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 15, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 16, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 17, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(10266);
    }

    @Override
    public int getColumnCount() {
        return 18;
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
            case 12: 
            case 13: 
            case 14: 
            case 15: 
            case 16: 
            case 17: {
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
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 14: 
            case 15: 
            case 16: 
            case 17: {
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
        CarServiceRDKSTiresCollector carServiceRDKSTiresCollector = (CarServiceRDKSTiresCollector)object;
        switch (n) {
            case 0: {
                return carServiceRDKSTiresCollector.car_service_rdks_tires_req_pressure_front;
            }
            case 1: {
                return carServiceRDKSTiresCollector.car_service_rdks_tires_req_pressure_front_decimal;
            }
            case 2: {
                return carServiceRDKSTiresCollector.car_service_rdks_tires_req_pressure_rear;
            }
            case 3: {
                return carServiceRDKSTiresCollector.car_service_rdks_tires_req_pressure_rear_decimal;
            }
            case 4: {
                return carServiceRDKSTiresCollector.car_service_rdks_tires_pressure_front_left;
            }
            case 5: {
                return carServiceRDKSTiresCollector.car_service_rdks_tires_pressure_front_left_decimal;
            }
            case 6: {
                return carServiceRDKSTiresCollector.car_service_rdks_tires_pressure_front_right;
            }
            case 7: {
                return carServiceRDKSTiresCollector.car_service_rdks_tires_pressure_front_right_decimal;
            }
            case 8: {
                return carServiceRDKSTiresCollector.car_service_rdks_tires_pressure_rear_left;
            }
            case 9: {
                return carServiceRDKSTiresCollector.car_service_rdks_tires_pressure_rear_left_decimal;
            }
            case 10: {
                return carServiceRDKSTiresCollector.car_service_rdks_tires_pressure_rear_right;
            }
            case 11: {
                return carServiceRDKSTiresCollector.car_service_rdks_tires_pressure_rear_right_decimal;
            }
            case 12: {
                return carServiceRDKSTiresCollector.car_service_rdks_tires_pressure_unit;
            }
            case 13: {
                return carServiceRDKSTiresCollector.car_service_rdks_tire_status_front_left;
            }
            case 14: {
                return carServiceRDKSTiresCollector.car_service_rdks_tire_status_front_right;
            }
            case 15: {
                return carServiceRDKSTiresCollector.car_service_rdks_tire_status_rear_left;
            }
            case 16: {
                return carServiceRDKSTiresCollector.car_service_rdks_tire_status_rear_right;
            }
            case 17: {
                return carServiceRDKSTiresCollector.car_service_rdks_tires_status_collected;
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

