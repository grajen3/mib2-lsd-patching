/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.messages.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.messages.transformer.MessagesEditedMessageCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class MessagesEditedMessageTransformer
extends ItemTransformerAdapter {
    public static final int MESSAGES_EDITED_EMBEDDED_V_CARD_NAME_STRING;
    public static final int MESSAGES_EDITED_NAME_STRING;
    public static final int MESSAGES_EDITED_NUMBER_STRING;
    public static final int MESSAGES_EDITED_NUMBER_OF_MESSAGES_INTEGER;
    public static final int MESSAGES_EDITED_NUMBER_OF_SIGNS_INTEGER;
    public static final int MESSAGES_EDITED_PICTURE_RESOURCE_LOCATOR;
    public static final int MESSAGES_EDITED_TEXT_STRING;
    public static final int MESSAGES_EDITED_EMBEDDED_V_CARD_BOOLEAN;
    public static final int MESSAGES_EDITED_MULTIPLE_NUMBERS_AVAILABLE_BOOLEAN;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[9];
        int n = 0;
        stringArray[n++] = TransformerUtil.getStringAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 8, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(4037);
    }

    @Override
    public int getColumnCount() {
        return 9;
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
            case 8: {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(int n, Object object) {
        switch (n) {
            case 7: 
            case 8: {
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
        MessagesEditedMessageCollector messagesEditedMessageCollector = (MessagesEditedMessageCollector)object;
        switch (n) {
            case 7: {
                return messagesEditedMessageCollector.messages_edited_embedded_v_card;
            }
            case 8: {
                return messagesEditedMessageCollector.messages_edited_multiple_numbers_available;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        MessagesEditedMessageCollector messagesEditedMessageCollector = (MessagesEditedMessageCollector)object;
        switch (n) {
            case 3: {
                return messagesEditedMessageCollector.messages_edited_number_of_messages;
            }
            case 4: {
                return messagesEditedMessageCollector.messages_edited_number_of_signs;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        MessagesEditedMessageCollector messagesEditedMessageCollector = (MessagesEditedMessageCollector)object;
        switch (n) {
            case 0: {
                return messagesEditedMessageCollector.messages_edited_embedded_v_card_name;
            }
            case 1: {
                return messagesEditedMessageCollector.messages_edited_name;
            }
            case 2: {
                return messagesEditedMessageCollector.messages_edited_number;
            }
            case 6: {
                return messagesEditedMessageCollector.messages_edited_text;
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
        MessagesEditedMessageCollector messagesEditedMessageCollector = (MessagesEditedMessageCollector)object;
        switch (n) {
            case 5: {
                return messagesEditedMessageCollector.messages_edited_picture;
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

