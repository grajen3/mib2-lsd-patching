/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.messages.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.messages.transformer.MessagesSelectedMessageCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class MessagesSelectedMessageTransformer
extends ItemTransformerAdapter {
    public static final int MESSAGES_SELECTED_EMBEDDED_V_CARD_NAME_STRING;
    public static final int MESSAGES_SELECTED_NAME_STRING;
    public static final int MESSAGES_SELECTED_NUMBER_STRING;
    public static final int MESSAGES_SELECTED_NUMBER_OF_MESSAGES_INTEGER;
    public static final int MESSAGES_SELECTED_NUMBER_OF_SIGNS_INTEGER;
    public static final int MESSAGES_SELECTED_PICTURE_RESOURCE_LOCATOR;
    public static final int MESSAGES_SELECTED_TEXT_STRING;
    public static final int MESSAGES_SELECTED_ADDRESS_AVAILABLE_BOOLEAN;
    public static final int MESSAGES_SELECTED_EMAIL_ADDRESSES_AVAILABLE_BOOLEAN;
    public static final int MESSAGES_SELECTED_EMBEDDED_V_CARD_BOOLEAN;
    public static final int MESSAGES_SELECTED_MULTIPLE_NUMBERS_AVAILABLE_BOOLEAN;
    public static final int MESSAGES_SELECTED_PHONE_NUMBERS_AVAILABLE_BOOLEAN;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[12];
        int n = 0;
        stringArray[n++] = TransformerUtil.getStringAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getDeprecatedBooleanAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getDeprecatedBooleanAsString(this, 11, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 8, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 9, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 10, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(465);
    }

    @Override
    public int getColumnCount() {
        return 12;
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
            case 11: {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(int n, Object object) {
        switch (n) {
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: {
                return this.getBoolean(n, object);
            }
            case 3: 
            case 4: {
                return new Integer(this.getInt(n, object));
            }
            case 0: 
            case 1: 
            case 2: 
            case 6: {
                return this.getString(n, object);
            }
            case 5: {
                return this.getResourceLocator(n, object);
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        MessagesSelectedMessageCollector messagesSelectedMessageCollector = (MessagesSelectedMessageCollector)object;
        switch (n) {
            case 7: {
                return messagesSelectedMessageCollector.messages_selected_address_available;
            }
            case 11: {
                return messagesSelectedMessageCollector.messages_selected_email_addresses_available;
            }
            case 8: {
                return messagesSelectedMessageCollector.messages_selected_embedded_v_card;
            }
            case 9: {
                return messagesSelectedMessageCollector.messages_selected_multiple_numbers_available;
            }
            case 10: {
                return messagesSelectedMessageCollector.messages_selected_phone_numbers_available;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        MessagesSelectedMessageCollector messagesSelectedMessageCollector = (MessagesSelectedMessageCollector)object;
        switch (n) {
            case 3: {
                return messagesSelectedMessageCollector.messages_selected_number_of_messages;
            }
            case 4: {
                return messagesSelectedMessageCollector.messages_selected_number_of_signs;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        MessagesSelectedMessageCollector messagesSelectedMessageCollector = (MessagesSelectedMessageCollector)object;
        switch (n) {
            case 0: {
                return messagesSelectedMessageCollector.messages_selected_embedded_v_card_name;
            }
            case 1: {
                return messagesSelectedMessageCollector.messages_selected_name;
            }
            case 2: {
                return messagesSelectedMessageCollector.messages_selected_number;
            }
            case 6: {
                return messagesSelectedMessageCollector.messages_selected_text;
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
    public ResourceLocator getResourceLocator(int n, Object object) {
        MessagesSelectedMessageCollector messagesSelectedMessageCollector = (MessagesSelectedMessageCollector)object;
        switch (n) {
            case 5: {
                return messagesSelectedMessageCollector.messages_selected_picture;
            }
        }
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

