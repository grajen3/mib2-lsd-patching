/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.phone.call.dial.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.phone.call.dial.transformer.PhoneCallDialLastDialedNumberInformationsCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class PhoneCallDialLastDialedNumberInformationsTransformer
extends ItemTransformerAdapter {
    public static final int PHONE_CALL_DIAL_LAST_DIALED_COMBINED_NUMBER_TYPE_INTEGER;
    public static final int PHONE_CALL_DIAL_LAST_DIALED_CONTACT_ENTRY_ID_LONG;
    public static final int PHONE_CALL_DIAL_LAST_DIALED_CONTACT_NAME_STRING;
    public static final int PHONE_CALL_DIAL_LAST_DIALED_DSI_NUMBER_TYPE_INTEGER;
    public static final int PHONE_CALL_DIAL_LAST_DIALED_NUMBER__1_STRING;
    public static final int PHONE_CALL_DIAL_LAST_DIALED_NUMBER_LOCATION_UNIQUE__1_BOOLEAN;
    public static final int PHONE_CALL_DIAL_LAST_DIALED_NUMBER_TYPE_UNIQUE__1_BOOLEAN;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[7];
        int n = 0;
        stringArray[n++] = TransformerUtil.getIntAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getLongAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 8, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 7, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(2565);
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public boolean isColumnIdSupported(int n) {
        switch (n) {
            case 0: 
            case 1: 
            case 2: 
            case 3: 
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
            case 6: 
            case 7: {
                return this.getBoolean(n, object);
            }
            case 0: 
            case 8: {
                return new Integer(this.getInt(n, object));
            }
            case 2: 
            case 3: {
                return this.getString(n, object);
            }
            case 1: {
                return new Long(this.getLong(n, object));
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        PhoneCallDialLastDialedNumberInformationsCollector phoneCallDialLastDialedNumberInformationsCollector = (PhoneCallDialLastDialedNumberInformationsCollector)object;
        switch (n) {
            case 6: {
                return phoneCallDialLastDialedNumberInformationsCollector.phone_call_dial_last_dialed_number_location_unique__1;
            }
            case 7: {
                return phoneCallDialLastDialedNumberInformationsCollector.phone_call_dial_last_dialed_number_type_unique__1;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        PhoneCallDialLastDialedNumberInformationsCollector phoneCallDialLastDialedNumberInformationsCollector = (PhoneCallDialLastDialedNumberInformationsCollector)object;
        switch (n) {
            case 0: {
                return phoneCallDialLastDialedNumberInformationsCollector.phone_call_dial_last_dialed_combined_number_type;
            }
            case 8: {
                return phoneCallDialLastDialedNumberInformationsCollector.phone_call_dial_last_dialed_dsi_number_type;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        PhoneCallDialLastDialedNumberInformationsCollector phoneCallDialLastDialedNumberInformationsCollector = (PhoneCallDialLastDialedNumberInformationsCollector)object;
        switch (n) {
            case 2: {
                return phoneCallDialLastDialedNumberInformationsCollector.phone_call_dial_last_dialed_contact_name;
            }
            case 3: {
                return phoneCallDialLastDialedNumberInformationsCollector.phone_call_dial_last_dialed_number__1;
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
        PhoneCallDialLastDialedNumberInformationsCollector phoneCallDialLastDialedNumberInformationsCollector = (PhoneCallDialLastDialedNumberInformationsCollector)object;
        switch (n) {
            case 1: {
                return phoneCallDialLastDialedNumberInformationsCollector.phone_call_dial_last_dialed_contact_entry_id;
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

