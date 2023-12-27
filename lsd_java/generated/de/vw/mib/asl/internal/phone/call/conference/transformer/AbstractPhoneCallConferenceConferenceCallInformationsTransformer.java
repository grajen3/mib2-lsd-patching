/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.phone.call.conference.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;

public abstract class AbstractPhoneCallConferenceConferenceCallInformationsTransformer
extends ItemTransformerAdapter {
    public static final int PHONE_CALL_CONFERENCE_CALL_ID_INTEGER;
    public static final int PHONE_CALL_CONFERENCE_DISCONNECTION_REASON_INTEGER;
    public static final int PHONE_CALL_CONFERENCE_DURATION_INTEGER;
    public static final int PHONE_CALL_CONFERENCE_NAME_STRING;
    public static final int PHONE_CALL_CONFERENCE_NUMBER_STRING;
    public static final int PHONE_CALL_CONFERENCE_NUMBER_TYPE_INTEGER;
    public static final int PHONE_CALL_CONFERENCE_PICTURE_RESOURCE_LOCATOR;
    public static final int PHONE_CALL_CONFERENCE_STATE_INTEGER;
    public static final int PHONE_CALL_CONFERENCE_TIME_STAMP_INTEGER;
    public static final int PHONE_CALL_CONFERENCE_TYPE_INTEGER;
    public static final int PHONE_CALL_CONFERENCE_CONTACT_BOOLEAN;
    public static final int PHONE_CALL_CONFERENCE_REMOVE_AVAILABLE_BOOLEAN;
    public static final int PHONE_CALL_CONFERENCE_SPLIT_AVAILABLE_BOOLEAN;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[13];
        int n = 0;
        stringArray[n++] = TransformerUtil.getIntAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 11, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 12, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 8, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 9, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 10, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(1160);
    }

    @Override
    public int getColumnCount() {
        return 13;
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
            case 12: {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(int n, Object object) {
        switch (n) {
            case 8: 
            case 9: 
            case 10: {
                return this.getBoolean(n, object);
            }
            case 0: 
            case 1: 
            case 4: 
            case 6: 
            case 7: 
            case 11: 
            case 12: {
                return new Integer(this.getInt(n, object));
            }
            case 2: 
            case 3: {
                return this.getString(n, object);
            }
            case 5: {
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

