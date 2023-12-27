/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.phone.contacts.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.phone.contacts.transformer.PhoneContactsSelectedContactCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class PhoneContactsSelectedContactTransformer
extends ItemTransformerAdapter {
    public static final int PHONE_CONTACTS_SELECTED_CONTACT_COMPANY_STRING;
    public static final int PHONE_CONTACTS_SELECTED_CONTACT_ENTRY_ID_LONG;
    public static final int PHONE_CONTACTS_SELECTED_CONTACT_NAME_STRING;
    public static final int PHONE_CONTACTS_SELECTED_CONTACT_PHONETICS_STRING;
    public static final int PHONE_CONTACTS_SELECTED_CONTACT_PICTURE_RESOURCE_LOCATOR;
    public static final int PHONE_CONTACTS_SELECTED_CONTACT_STORAGE_TYPE_INTEGER;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[6];
        int n = 0;
        stringArray[n++] = TransformerUtil.getStringAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getLongAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 4, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(1188);
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public boolean isColumnIdSupported(int n) {
        switch (n) {
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(int n, Object object) {
        switch (n) {
            case 4: {
                return new Integer(this.getInt(n, object));
            }
            case 0: 
            case 2: 
            case 5: {
                return this.getString(n, object);
            }
            case 3: {
                return this.getResourceLocator(n, object);
            }
            case 1: {
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
    public int getInt(int n, Object object) {
        PhoneContactsSelectedContactCollector phoneContactsSelectedContactCollector = (PhoneContactsSelectedContactCollector)object;
        switch (n) {
            case 4: {
                return phoneContactsSelectedContactCollector.phone_contacts_selected_contact_storage_type;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        PhoneContactsSelectedContactCollector phoneContactsSelectedContactCollector = (PhoneContactsSelectedContactCollector)object;
        switch (n) {
            case 0: {
                return phoneContactsSelectedContactCollector.phone_contacts_selected_contact_company;
            }
            case 2: {
                return phoneContactsSelectedContactCollector.phone_contacts_selected_contact_name;
            }
            case 5: {
                return phoneContactsSelectedContactCollector.phone_contacts_selected_contact_phonetics;
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
        PhoneContactsSelectedContactCollector phoneContactsSelectedContactCollector = (PhoneContactsSelectedContactCollector)object;
        switch (n) {
            case 3: {
                return phoneContactsSelectedContactCollector.phone_contacts_selected_contact_picture;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public long getLong(int n, Object object) {
        PhoneContactsSelectedContactCollector phoneContactsSelectedContactCollector = (PhoneContactsSelectedContactCollector)object;
        switch (n) {
            case 1: {
                return phoneContactsSelectedContactCollector.phone_contacts_selected_contact_entry_id;
            }
        }
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

