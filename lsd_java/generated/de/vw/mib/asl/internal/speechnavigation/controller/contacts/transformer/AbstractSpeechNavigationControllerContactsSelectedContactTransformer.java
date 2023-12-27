/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.speechnavigation.controller.contacts.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;

public abstract class AbstractSpeechNavigationControllerContactsSelectedContactTransformer
extends ItemTransformerAdapter {
    public static final int SPEECHNAVIGATION_CONTROLLER_CONTACTS_SELECTED_CONTACT_OBJECT_ID_LONG;
    public static final int SPEECHNAVIGATION_CONTROLLER_CONTACTS_SELECTED_CONTACT_NAME_STRING;
    public static final int SPEECHNAVIGATION_CONTROLLER_CONTACTS_SELECTED_CONTACT_PICTURE_RESOURCE_LOCATOR;
    public static final int SPEECHNAVIGATION_CONTROLLER_CONTACTS_SELECTED_CONTACT_ADDRESSES_COUNT_STATE_INTEGER;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[4];
        int n = 0;
        stringArray[n++] = TransformerUtil.getLongAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 3, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(1711813632);
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public boolean isColumnIdSupported(int n) {
        switch (n) {
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
                return new Integer(this.getInt(n, object));
            }
            case 1: {
                return this.getString(n, object);
            }
            case 2: {
                return this.getResourceLocator(n, object);
            }
            case 4: {
                return new Long(this.getLong(n, object));
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
    public LabeledIconValue getLabeledIconValue(int n, Object object) {
        throw new IllegalArgumentException();
    }

    @Override
    public FixFormatterFieldData getFixFormatterFieldData(int n, Object object) {
        throw new IllegalArgumentException();
    }
}

