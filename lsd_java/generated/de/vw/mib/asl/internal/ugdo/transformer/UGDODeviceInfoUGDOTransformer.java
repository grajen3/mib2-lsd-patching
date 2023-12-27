/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.ugdo.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.ugdo.transformer.UGDODeviceInfoUGDOCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class UGDODeviceInfoUGDOTransformer
extends ItemTransformerAdapter {
    public static final int UGDO_FUNCTION_IDUGDO_INTEGER;
    public static final int UGDO_FUNCTION_GROUP_ASSIGNMENT_UGDO_INTEGER_ARRAY;
    public static final int UGDO_FUNCTION_EXISTENCE_UGDO_FLAG_VECTOR;
    public static final int UGDO_FUNCTION_AVAILABILITY_UGDO_FLAG_VECTOR;
    public static final int UGDO_FUNCTION_AVAILABLE_REASON_UGDO_INTEGER_ARRAY;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[5];
        int n = 0;
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntegerVectorAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getDeprecatedFlagVectorAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getDeprecatedFlagVectorAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntegerVectorAsString(this, 4, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(-61265664);
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public boolean isColumnIdSupported(int n) {
        switch (n) {
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(int n, Object object) {
        switch (n) {
            case 0: {
                return new Integer(this.getInt(n, object));
            }
            case 2: 
            case 3: {
                return this.getFlagVector(n, object);
            }
            case 1: 
            case 4: {
                return this.getIntegerVector(n, object);
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
        UGDODeviceInfoUGDOCollector uGDODeviceInfoUGDOCollector = (UGDODeviceInfoUGDOCollector)object;
        switch (n) {
            case 0: {
                return uGDODeviceInfoUGDOCollector.ugdo_function_idugdo;
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
        UGDODeviceInfoUGDOCollector uGDODeviceInfoUGDOCollector = (UGDODeviceInfoUGDOCollector)object;
        switch (n) {
            case 2: {
                return uGDODeviceInfoUGDOCollector.ugdo_function_existence_ugdo;
            }
            case 3: {
                return uGDODeviceInfoUGDOCollector.ugdo_function_availability_ugdo;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int[] getIntegerVector(int n, Object object) {
        UGDODeviceInfoUGDOCollector uGDODeviceInfoUGDOCollector = (UGDODeviceInfoUGDOCollector)object;
        switch (n) {
            case 1: {
                return uGDODeviceInfoUGDOCollector.ugdo_function_group_assignment_ugdo;
            }
            case 4: {
                return uGDODeviceInfoUGDOCollector.ugdo_function_available_reason_ugdo;
            }
        }
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

