/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.phone.setup.call.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.phone.setup.call.transformer.PhoneSetupCallCallSettingsCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class PhoneSetupCallCallSettingsTransformer
extends ItemTransformerAdapter {
    public static final int PHONE_SETUP_CALL_CALL_SETTING_STATE_CALL_WAITING_INTEGER;
    public static final int PHONE_SETUP_CALL_CALL_SETTING_STATE_SEND_CALLING_ID__1_INTEGER;
    public static final int PHONE_SETUP_CALL_CALL_SETTING_AUTOMATIC_ACCEPT_CALL_ACTIVE_BOOLEAN;
    public static final int PHONE_SETUP_CALL_CALL_SETTING_AUTOMATIC_REDIAL_ACTIVE_BOOLEAN;
    public static final int PHONE_SETUP_CALL_CALL_SETTING_CALL_WAITING_AVAILABLE_BOOLEAN;
    public static final int PHONE_SETUP_CALL_CALL_SETTING_SEND_CALLING_ID_AVAILABLE_BOOLEAN;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[6];
        int n = 0;
        stringArray[n++] = TransformerUtil.getIntAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 5, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(1211);
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public boolean isColumnIdSupported(int n) {
        switch (n) {
            case 0: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(int n, Object object) {
        switch (n) {
            case 2: 
            case 3: 
            case 4: 
            case 5: {
                return this.getBoolean(n, object);
            }
            case 0: 
            case 6: {
                return new Integer(this.getInt(n, object));
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        PhoneSetupCallCallSettingsCollector phoneSetupCallCallSettingsCollector = (PhoneSetupCallCallSettingsCollector)object;
        switch (n) {
            case 2: {
                return phoneSetupCallCallSettingsCollector.phone_setup_call_call_setting_automatic_accept_call_active;
            }
            case 3: {
                return phoneSetupCallCallSettingsCollector.phone_setup_call_call_setting_automatic_redial_active;
            }
            case 4: {
                return phoneSetupCallCallSettingsCollector.phone_setup_call_call_setting_call_waiting_available;
            }
            case 5: {
                return phoneSetupCallCallSettingsCollector.phone_setup_call_call_setting_send_calling_id_available;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        PhoneSetupCallCallSettingsCollector phoneSetupCallCallSettingsCollector = (PhoneSetupCallCallSettingsCollector)object;
        switch (n) {
            case 0: {
                return phoneSetupCallCallSettingsCollector.phone_setup_call_call_setting_state_call_waiting;
            }
            case 6: {
                return phoneSetupCallCallSettingsCollector.phone_setup_call_call_setting_state_send_calling_id__1;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
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

