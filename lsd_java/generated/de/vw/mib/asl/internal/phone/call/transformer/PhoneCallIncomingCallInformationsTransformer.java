/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.phone.call.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.phone.call.transformer.PhoneCallIncomingCallInformationsCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class PhoneCallIncomingCallInformationsTransformer
extends ItemTransformerAdapter {
    public static final int PHONE_CALL_CARRIER_STATE__1_INTEGER;
    public static final int PHONE_CALL_INCOMING_CALL_FIRST_BUTTON_STATE_INTEGER;
    public static final int PHONE_CALL_INCOMING_CALL_NAME_STRING;
    public static final int PHONE_CALL_INCOMING_CALL_NUMBER_STRING;
    public static final int PHONE_CALL_INCOMING_CALL_PICTURE_RESOURCE_LOCATOR;
    public static final int PHONE_CALL_INCOMING_CALL_SECOND_BUTTON_STATE_INTEGER;
    public static final int PHONE_CALL_INCOMING_CALL_TYPE__1_INTEGER;
    public static final int PHONE_CALL_INCOMING_COMBINED_NUMBER_TYPE__1_INTEGER;
    public static final int PHONE_CALL_INCOMING_CALL_FIRST_BUTTON_AVAILABLE_BOOLEAN;
    public static final int PHONE_CALL_INCOMING_CALL_HANG_UP_BUTTON_AVAILABLE_BOOLEAN;
    public static final int PHONE_CALL_INCOMING_CALL_PICTURE_AVAILABLE_BOOLEAN;
    public static final int PHONE_CALL_INCOMING_CALL_SECOND_BUTTON_AVAILABLE_BOOLEAN;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[12];
        int n = 0;
        stringArray[n++] = TransformerUtil.getIntAsString(this, 11, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 13, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 9, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 14, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 8, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 12, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 7, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(1159);
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
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 11: 
            case 12: 
            case 13: 
            case 14: {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(int n, Object object) {
        switch (n) {
            case 5: 
            case 6: 
            case 7: 
            case 12: {
                return this.getBoolean(n, object);
            }
            case 8: 
            case 9: 
            case 11: 
            case 13: 
            case 14: {
                return new Integer(this.getInt(n, object));
            }
            case 0: 
            case 1: {
                return this.getString(n, object);
            }
            case 2: {
                return this.getResourceLocator(n, object);
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        PhoneCallIncomingCallInformationsCollector phoneCallIncomingCallInformationsCollector = (PhoneCallIncomingCallInformationsCollector)object;
        switch (n) {
            case 5: {
                return phoneCallIncomingCallInformationsCollector.phone_call_incoming_call_first_button_available;
            }
            case 12: {
                return phoneCallIncomingCallInformationsCollector.phone_call_incoming_call_hang_up_button_available;
            }
            case 6: {
                return phoneCallIncomingCallInformationsCollector.phone_call_incoming_call_picture_available;
            }
            case 7: {
                return phoneCallIncomingCallInformationsCollector.phone_call_incoming_call_second_button_available;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        PhoneCallIncomingCallInformationsCollector phoneCallIncomingCallInformationsCollector = (PhoneCallIncomingCallInformationsCollector)object;
        switch (n) {
            case 11: {
                return phoneCallIncomingCallInformationsCollector.phone_call_carrier_state__1;
            }
            case 13: {
                return phoneCallIncomingCallInformationsCollector.phone_call_incoming_call_first_button_state;
            }
            case 9: {
                return phoneCallIncomingCallInformationsCollector.phone_call_incoming_call_second_button_state;
            }
            case 14: {
                return phoneCallIncomingCallInformationsCollector.phone_call_incoming_call_type__1;
            }
            case 8: {
                return phoneCallIncomingCallInformationsCollector.phone_call_incoming_combined_number_type__1;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        PhoneCallIncomingCallInformationsCollector phoneCallIncomingCallInformationsCollector = (PhoneCallIncomingCallInformationsCollector)object;
        switch (n) {
            case 0: {
                return phoneCallIncomingCallInformationsCollector.phone_call_incoming_call_name;
            }
            case 1: {
                return phoneCallIncomingCallInformationsCollector.phone_call_incoming_call_number;
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
        PhoneCallIncomingCallInformationsCollector phoneCallIncomingCallInformationsCollector = (PhoneCallIncomingCallInformationsCollector)object;
        switch (n) {
            case 2: {
                return phoneCallIncomingCallInformationsCollector.phone_call_incoming_call_picture;
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

