/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.car.service.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import org.dsi.ifc.global.ResourceLocator;

public abstract class AbstractCarServiceVehicleStatusWarningTransformer
extends ItemTransformerAdapter {
    public static final int CAR_SERVICE_VEHICLE_STATUS_WARNING_LIST_INTEGER;
    public static final int CAR_SERVICE_VEHICLE_STATUS_WARNING_LIST__DYN_VALUE_STRING;
    public static final int CAR_SERVICE_VEHICLE_STATUS_WARNING_LIST__ALT_TEXT_STRING;
    public static final int CAR_SERVICE_VEHICLE_STATUS_WARNING_LISTICON_STRING;
    public static final int CAR_SERVICE_VEHICLE_STATUS_WARNING_LISTICONCOLOR_INTEGER;
    public static final int CAR_SERVICE_VEHICLE_STATUS_WARNING_LISTCOMPONENTCOLOR_INTEGER;
    public static final int CAR_SERVICE_VEHICLE_STATUS_WARNING_LISTCOMPONENT_INTEGER;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[7];
        int n = 0;
        stringArray[n++] = TransformerUtil.getIntAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 8, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 9, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 10, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 11, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(10271);
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public boolean isColumnIdSupported(int n) {
        switch (n) {
            case 0: 
            case 1: 
            case 3: 
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
            case 0: 
            case 9: 
            case 10: 
            case 11: {
                return new Integer(this.getInt(n, object));
            }
            case 1: 
            case 3: 
            case 8: {
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

