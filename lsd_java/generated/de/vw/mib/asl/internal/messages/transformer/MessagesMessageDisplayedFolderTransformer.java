/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.messages.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.messages.transformer.MessagesMessageDisplayedFolderCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class MessagesMessageDisplayedFolderTransformer
extends ItemTransformerAdapter {
    public static final int MESSAGES_DISPLAYED_FOLDER_LEVEL_INTEGER;
    public static final int MESSAGES_DISPLAYED_FOLDER_NAME_STRING;
    public static final int MESSAGES_DISPLAYED_FOLDER_TYPE_INTEGER;
    public static final int MESSAGES_DISPLAYED_FOLDER_TYPE__1_INTEGER;
    public static final int MESSAGES_DISPLAYED_FOLDER_UPDATED_BOOLEAN;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[5];
        int n = 0;
        stringArray[n++] = TransformerUtil.getIntAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 3, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(462);
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
            case 3: {
                return this.getBoolean(n, object);
            }
            case 0: 
            case 2: 
            case 4: {
                return new Integer(this.getInt(n, object));
            }
            case 1: {
                return this.getString(n, object);
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        MessagesMessageDisplayedFolderCollector messagesMessageDisplayedFolderCollector = (MessagesMessageDisplayedFolderCollector)object;
        switch (n) {
            case 3: {
                return messagesMessageDisplayedFolderCollector.messages_displayed_folder_updated;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        MessagesMessageDisplayedFolderCollector messagesMessageDisplayedFolderCollector = (MessagesMessageDisplayedFolderCollector)object;
        switch (n) {
            case 0: {
                return messagesMessageDisplayedFolderCollector.messages_displayed_folder_level;
            }
            case 2: {
                return messagesMessageDisplayedFolderCollector.messages_displayed_folder_type;
            }
            case 4: {
                return messagesMessageDisplayedFolderCollector.messages_displayed_folder_type__1;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        MessagesMessageDisplayedFolderCollector messagesMessageDisplayedFolderCollector = (MessagesMessageDisplayedFolderCollector)object;
        switch (n) {
            case 1: {
                return messagesMessageDisplayedFolderCollector.messages_displayed_folder_name;
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

