/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.speechphone.data.contact.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;

public abstract class AbstractSpeechPhoneDataContactDialedNumbersListTransformer
extends ItemTransformerAdapter {
    public static final int SPEECHPHONE_DATA_CONTACT_DIALED_NUMBER_OBJECT_ID_LONG;
    public static final int SPEECHPHONE_DATA_CONTACT_DIALED_NUMBER_NAME_STRING;
    public static final int SPEECHPHONE_DATA_CONTACT_DIALED_NUMBER_NUMBER_STRING;
    public static final int SPEECHPHONE_DATA_CONTACT_DIALED_NUMBER_DATE_TIME_AVAILABLE_BOOLEAN;
    public static final int SPEECHPHONE_DATA_CONTACT_DIALED_NUMBER_KNOWN_NUMBER_BOOLEAN;
    public static final int SPEECHPHONE_DATA_CONTACT_DIALED_NUMBER_CONTACT_BOOLEAN;
    public static final int SPEECHPHONE_DATA_CONTACT_DIALED_NUMBER_HOURS_INTEGER;
    public static final int SPEECHPHONE_DATA_CONTACT_DIALED_NUMBER_MINUTES_INTEGER;
    public static final int SPEECHPHONE_DATA_CONTACT_DIALED_NUMBER_YEAR_INTEGER;
    public static final int SPEECHPHONE_DATA_CONTACT_DIALED_NUMBER_MONTH_INTEGER;
    public static final int SPEECHPHONE_DATA_CONTACT_DIALED_NUMBER_DAY_INTEGER;
    public static final int SPEECHPHONE_DATA_CONTACT_DIALED_NUMBER_PICTURE_RESOURCE_LOCATOR;
    public static final int SPEECHPHONE_DATA_CONTACT_DIALED_NUMBER_COMBINED_LOC_TYPE_INTEGER;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[13];
        int n = 0;
        stringArray[n++] = TransformerUtil.getLongAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 8, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 9, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 10, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 11, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 12, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(-1733739776);
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
            case 3: 
            case 4: 
            case 5: {
                return this.getBoolean(n, object);
            }
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 12: {
                return new Integer(this.getInt(n, object));
            }
            case 1: 
            case 2: {
                return this.getString(n, object);
            }
            case 11: {
                return this.getResourceLocator(n, object);
            }
            case 0: {
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

