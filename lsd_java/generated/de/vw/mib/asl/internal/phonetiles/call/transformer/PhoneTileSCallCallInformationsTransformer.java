/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.phonetiles.call.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.phonetiles.call.transformer.PhoneTileSCallCallInformationsCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class PhoneTileSCallCallInformationsTransformer
extends ItemTransformerAdapter {
    public static final int PHONETILES_CALL_CARRIER_STATE_INTEGER;
    public static final int PHONETILES_CALL_COMBINED_NUMBER_TYPE_INTEGER;
    public static final int PHONETILES_CALL_DISCONNECTION_REASON_INTEGER;
    public static final int PHONETILES_CALL_DURATION_INTEGER;
    public static final int PHONETILES_CALL_DURATION_AUTO_REDIAL_STRING;
    public static final int PHONETILES_CALL_FIRST_BUTTON_STATE_INTEGER;
    public static final int PHONETILES_CALL_NAME_STRING;
    public static final int PHONETILES_CALL_NUMBER_STRING;
    public static final int PHONETILES_CALL_PICTURE_RESOURCE_LOCATOR;
    public static final int PHONETILES_CALL_SECOND_BUTTON_STATE_INTEGER;
    public static final int PHONETILES_CALL_STATE_INTEGER;
    public static final int PHONETILES_CALL_TYPE_INTEGER;
    public static final int PHONETILES_CALL_FIRST_BUTTON_AVAILABLE_BOOLEAN;
    public static final int PHONETILES_CALL_HANG_UP_BUTTON_AVAILABLE_BOOLEAN;
    public static final int PHONETILES_CALL_PICTURE_AVAILABLE_BOOLEAN;
    public static final int PHONETILES_CALL_SECOND_BUTTON_AVAILABLE_BOOLEAN;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[16];
        int n = 0;
        stringArray[n++] = TransformerUtil.getIntAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 8, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 9, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 10, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 11, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 12, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 13, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 14, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 15, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(-127769088);
    }

    @Override
    public int getColumnCount() {
        return 16;
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
            case 12: 
            case 13: 
            case 14: 
            case 15: {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(int n, Object object) {
        switch (n) {
            case 12: 
            case 13: 
            case 14: 
            case 15: {
                return this.getBoolean(n, object);
            }
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 5: 
            case 9: 
            case 10: 
            case 11: {
                return new Integer(this.getInt(n, object));
            }
            case 4: 
            case 6: 
            case 7: {
                return this.getString(n, object);
            }
            case 8: {
                return this.getResourceLocator(n, object);
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        PhoneTileSCallCallInformationsCollector phoneTileSCallCallInformationsCollector = (PhoneTileSCallCallInformationsCollector)object;
        switch (n) {
            case 12: {
                return phoneTileSCallCallInformationsCollector.phonetiles_call_first_button_available;
            }
            case 13: {
                return phoneTileSCallCallInformationsCollector.phonetiles_call_hang_up_button_available;
            }
            case 14: {
                return phoneTileSCallCallInformationsCollector.phonetiles_call_picture_available;
            }
            case 15: {
                return phoneTileSCallCallInformationsCollector.phonetiles_call_second_button_available;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        PhoneTileSCallCallInformationsCollector phoneTileSCallCallInformationsCollector = (PhoneTileSCallCallInformationsCollector)object;
        switch (n) {
            case 0: {
                return phoneTileSCallCallInformationsCollector.phonetiles_call_carrier_state;
            }
            case 1: {
                return phoneTileSCallCallInformationsCollector.phonetiles_call_combined_number_type;
            }
            case 2: {
                return phoneTileSCallCallInformationsCollector.phonetiles_call_disconnection_reason;
            }
            case 3: {
                return phoneTileSCallCallInformationsCollector.phonetiles_call_duration;
            }
            case 5: {
                return phoneTileSCallCallInformationsCollector.phonetiles_call_first_button_state;
            }
            case 9: {
                return phoneTileSCallCallInformationsCollector.phonetiles_call_second_button_state;
            }
            case 10: {
                return phoneTileSCallCallInformationsCollector.phonetiles_call_state;
            }
            case 11: {
                return phoneTileSCallCallInformationsCollector.phonetiles_call_type;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        PhoneTileSCallCallInformationsCollector phoneTileSCallCallInformationsCollector = (PhoneTileSCallCallInformationsCollector)object;
        switch (n) {
            case 4: {
                return phoneTileSCallCallInformationsCollector.phonetiles_call_duration_auto_redial;
            }
            case 6: {
                return phoneTileSCallCallInformationsCollector.phonetiles_call_name;
            }
            case 7: {
                return phoneTileSCallCallInformationsCollector.phonetiles_call_number;
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
        PhoneTileSCallCallInformationsCollector phoneTileSCallCallInformationsCollector = (PhoneTileSCallCallInformationsCollector)object;
        switch (n) {
            case 8: {
                return phoneTileSCallCallInformationsCollector.phonetiles_call_picture;
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

