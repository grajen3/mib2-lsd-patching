/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.phone.callstacks.missedcalls.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;

public abstract class AbstractPhoneCallstacksMissedCallsMissedCallsTransformer
extends ItemTransformerAdapter {
    public static final int PHONE_CALLSTACKS_MISSEDCALLS_CALLSTACK_ENTRY_ID_LONG;
    public static final int PHONE_CALLSTACKS_MISSEDCALLS_CALL_TYPE_INTEGER;
    public static final int PHONE_CALLSTACKS_MISSEDCALLS_COMBINED_NUMBER_TYPE__1_INTEGER;
    public static final int PHONE_CALLSTACKS_MISSEDCALLS_DAY_INTEGER;
    public static final int PHONE_CALLSTACKS_MISSEDCALLS_DSI_NUMBER_TYPE_INTEGER;
    public static final int PHONE_CALLSTACKS_MISSEDCALLS_ENTRY_ID_LONG;
    public static final int PHONE_CALLSTACKS_MISSEDCALLS_ENTRY_TYPE_INTEGER;
    public static final int PHONE_CALLSTACKS_MISSEDCALLS_HOURS_INTEGER;
    public static final int PHONE_CALLSTACKS_MISSEDCALLS_MINUTES_INTEGER;
    public static final int PHONE_CALLSTACKS_MISSEDCALLS_MONTH_INTEGER;
    public static final int PHONE_CALLSTACKS_MISSEDCALLS_NAME_STRING;
    public static final int PHONE_CALLSTACKS_MISSEDCALLS_NUMBER_STRING;
    public static final int PHONE_CALLSTACKS_MISSEDCALLS_PICTURE_RESOURCE_LOCATOR;
    public static final int PHONE_CALLSTACKS_MISSEDCALLS_YEAR_INTEGER;
    public static final int PHONE_CALLSTACKS_MISSEDCALLS_CONTACT_BOOLEAN;
    public static final int PHONE_CALLSTACKS_MISSEDCALLS_DATE_TIME_AVAILABLE_BOOLEAN;
    public static final int PHONE_CALLSTACKS_MISSEDCALLS_DELETABLE_BOOLEAN;
    public static final int PHONE_CALLSTACKS_MISSEDCALLS_FROM_TODAY_BOOLEAN;
    public static final int PHONE_CALLSTACKS_MISSEDCALLS_MULTIPLE_NUMBERS_AVAILABLE_BOOLEAN;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[19];
        int n = 0;
        stringArray[n++] = TransformerUtil.getLongAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 18, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 19, object);
        stringArray[n++] = TransformerUtil.getLongAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 8, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 9, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 10, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 11, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 12, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 13, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 14, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 15, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 16, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 17, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(1172);
    }

    @Override
    public int getColumnCount() {
        return 19;
    }

    @Override
    public boolean isColumnIdSupported(int n) {
        switch (n) {
            case 0: 
            case 1: 
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
            case 17: 
            case 18: 
            case 19: {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(int n, Object object) {
        switch (n) {
            case 13: 
            case 14: 
            case 15: 
            case 16: 
            case 17: {
                return this.getBoolean(n, object);
            }
            case 1: 
            case 3: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 12: 
            case 18: 
            case 19: {
                return new Integer(this.getInt(n, object));
            }
            case 9: 
            case 10: {
                return this.getString(n, object);
            }
            case 11: {
                return this.getResourceLocator(n, object);
            }
            case 0: 
            case 4: {
                return new Long(this.getLong(n, object));
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
    public LabeledIconValue getLabeledIconValue(int n, Object object) {
        throw new IllegalArgumentException();
    }

    @Override
    public FixFormatterFieldData getFixFormatterFieldData(int n, Object object) {
        throw new IllegalArgumentException();
    }
}

