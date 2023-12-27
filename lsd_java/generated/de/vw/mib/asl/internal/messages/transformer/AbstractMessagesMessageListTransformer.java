/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.messages.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;

public abstract class AbstractMessagesMessageListTransformer
extends ItemTransformerAdapter {
    public static final int MESSAGES_MESSAGE_CONTACT_NAME_STRING;
    public static final int MESSAGES_MESSAGE_CONTACT_NUMBER_STRING;
    public static final int MESSAGES_MESSAGE_CONTACT_PICTURE_RESOURCE_LOCATOR;
    public static final int MESSAGES_MESSAGE_DAY_INTEGER;
    public static final int MESSAGES_MESSAGE_FOLDER_NAME_STRING;
    public static final int MESSAGES_MESSAGE_FOLDER_TYPE__1_INTEGER;
    public static final int MESSAGES_MESSAGE_HOURS_INTEGER;
    public static final int MESSAGES_MESSAGE_MINUTES_INTEGER;
    public static final int MESSAGES_MESSAGE_MONTH_INTEGER;
    public static final int MESSAGES_MESSAGE_SHORT_TEXT_STRING;
    public static final int MESSAGES_MESSAGE_TYPE_INTEGER;
    public static final int MESSAGES_MESSAGE_YEAR_INTEGER;
    public static final int MESSAGES_MESSAGE_BOOLEAN;
    public static final int MESSAGES_MESSAGE_CURRENTLY_BEING_SENT_BOOLEAN;
    public static final int MESSAGES_MESSAGE_DATE_TIME_AVAILABLE_BOOLEAN;
    public static final int MESSAGES_MESSAGE_DELETED_BOOLEAN;
    public static final int MESSAGES_MESSAGE_FROM_TODAY_BOOLEAN;
    public static final int MESSAGES_MESSAGE_MULTIPLE_RECIPIENTS_BOOLEAN;
    public static final int MESSAGES_MESSAGE_READABLE_BOOLEAN;
    public static final int MESSAGES_MESSAGE_READOUT_SUPPORTED_BOOLEAN;
    public static final int MESSAGES_MESSAGE_UNREAD_BOOLEAN;
    public static final int MESSAGES_MESSAGE_UNSENT_BOOLEAN;
    public static final int MESSAGES_MESSAGE_V_CARD_BOOLEAN;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[23];
        int n = 0;
        stringArray[n++] = TransformerUtil.getStringAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 20, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 8, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 9, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 10, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 11, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 12, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 13, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 14, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 15, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 16, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 21, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 19, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 22, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 17, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 18, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 23, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(463);
    }

    @Override
    public int getColumnCount() {
        return 23;
    }

    @Override
    public boolean isColumnIdSupported(int n) {
        switch (n) {
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: 
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
            case 12: 
            case 13: 
            case 14: 
            case 15: 
            case 16: 
            case 17: 
            case 18: 
            case 19: 
            case 21: 
            case 22: 
            case 23: {
                return this.getBoolean(n, object);
            }
            case 3: 
            case 6: 
            case 7: 
            case 8: 
            case 10: 
            case 11: 
            case 20: {
                return new Integer(this.getInt(n, object));
            }
            case 0: 
            case 1: 
            case 4: 
            case 9: {
                return this.getString(n, object);
            }
            case 2: {
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

