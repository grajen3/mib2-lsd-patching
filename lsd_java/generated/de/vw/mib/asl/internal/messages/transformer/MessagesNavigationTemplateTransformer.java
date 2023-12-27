/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.messages.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.messages.transformer.MessagesNavigationTemplateCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class MessagesNavigationTemplateTransformer
extends ItemTransformerAdapter {
    public static final int MESSAGES_CURRENT_STREET_STRING;
    public static final int MESSAGES_DESTINATION_CITY_STRING;
    public static final int MESSAGES_DESTINATION_ETAD_INTEGER;
    public static final int MESSAGES_DESTINATION_ETAH_INTEGER;
    public static final int MESSAGES_DESTINATION_ETAM_INTEGER;
    public static final int MESSAGES_CURRENT_STREET_AVAILABLE_BOOLEAN;
    public static final int MESSAGES_DESTINATION_CITY_AVAILABLE_BOOLEAN;
    public static final int MESSAGES_DESTINATION_ETA_AVAILABLE_BOOLEAN;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[8];
        int n = 0;
        stringArray[n++] = TransformerUtil.getStringAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 8, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 9, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 11, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(-1226699520);
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public boolean isColumnIdSupported(int n) {
        switch (n) {
            case 1: 
            case 2: 
            case 4: 
            case 5: 
            case 6: 
            case 8: 
            case 9: 
            case 11: {
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
            case 11: {
                return this.getBoolean(n, object);
            }
            case 4: 
            case 5: 
            case 6: {
                return new Integer(this.getInt(n, object));
            }
            case 1: 
            case 2: {
                return this.getString(n, object);
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        MessagesNavigationTemplateCollector messagesNavigationTemplateCollector = (MessagesNavigationTemplateCollector)object;
        switch (n) {
            case 8: {
                return messagesNavigationTemplateCollector.messages_current_street_available;
            }
            case 9: {
                return messagesNavigationTemplateCollector.messages_destination_city_available;
            }
            case 11: {
                return messagesNavigationTemplateCollector.messages_destination_eta_available;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        MessagesNavigationTemplateCollector messagesNavigationTemplateCollector = (MessagesNavigationTemplateCollector)object;
        switch (n) {
            case 4: {
                return messagesNavigationTemplateCollector.messages_destination_etad;
            }
            case 5: {
                return messagesNavigationTemplateCollector.messages_destination_etah;
            }
            case 6: {
                return messagesNavigationTemplateCollector.messages_destination_etam;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        MessagesNavigationTemplateCollector messagesNavigationTemplateCollector = (MessagesNavigationTemplateCollector)object;
        switch (n) {
            case 1: {
                return messagesNavigationTemplateCollector.messages_current_street;
            }
            case 2: {
                return messagesNavigationTemplateCollector.messages_destination_city;
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

