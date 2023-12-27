/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.phone.call.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;

public abstract class AbstractPhoneCallCallInformationsTransformer
extends ItemTransformerAdapter {
    public static final int PHONE_CALL_CALL_ID_INTEGER;
    public static final int PHONE_CALL_CARRIER_STATE_INTEGER;
    public static final int PHONE_CALL_COMBINED_NUMBER_TYPE__1_INTEGER;
    public static final int PHONE_CALL_DISCONNECTION_REASON_INTEGER;
    public static final int PHONE_CALL_DURATION_INTEGER;
    public static final int PHONE_CALL_DURATION_AUTO_REDIAL_STRING;
    public static final int PHONE_CALL_FIRST_BUTTON_STATE__1_INTEGER;
    public static final int PHONE_CALL_NAME_STRING;
    public static final int PHONE_CALL_NUMBER_STRING;
    public static final int PHONE_CALL_NUMBER_TYPE_INTEGER;
    public static final int PHONE_CALL_PICTURE_RESOURCE_LOCATOR;
    public static final int PHONE_CALL_SECOND_BUTTON_STATE__1_INTEGER;
    public static final int PHONE_CALL_STATE_INTEGER;
    public static final int PHONE_CALL_TIME_STAMP_INTEGER;
    public static final int PHONE_CALL_TYPE__1_INTEGER;
    public static final int PHONE_CALL_CONTACT_BOOLEAN;
    public static final int PHONE_CALL_FIRST_BUTTON_AVAILABLE_BOOLEAN;
    public static final int PHONE_CALL_HANG_UP_BUTTON_AVAILABLE_BOOLEAN;
    public static final int PHONE_CALL_PICTURE_AVAILABLE_BOOLEAN;
    public static final int PHONE_CALL_SECOND_BUTTON_AVAILABLE_BOOLEAN;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[20];
        int n = 0;
        stringArray[n++] = TransformerUtil.getIntAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 21, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 18, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 19, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 8, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 9, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 20, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 11, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 12, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 23, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 14, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 15, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 22, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 16, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 17, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(1158);
    }

    @Override
    public int getColumnCount() {
        return 20;
    }

    @Override
    public boolean isColumnIdSupported(int n) {
        switch (n) {
            case 0: 
            case 2: 
            case 3: 
            case 4: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 11: 
            case 12: 
            case 14: 
            case 15: 
            case 16: 
            case 17: 
            case 18: 
            case 19: 
            case 20: 
            case 21: 
            case 22: 
            case 23: {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(int n, Object object) {
        switch (n) {
            case 14: 
            case 15: 
            case 16: 
            case 17: 
            case 22: {
                return this.getBoolean(n, object);
            }
            case 0: 
            case 2: 
            case 3: 
            case 8: 
            case 11: 
            case 12: 
            case 18: 
            case 19: 
            case 20: 
            case 21: 
            case 23: {
                return new Integer(this.getInt(n, object));
            }
            case 4: 
            case 6: 
            case 7: {
                return this.getString(n, object);
            }
            case 9: {
                return this.getResourceLocator(n, object);
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

