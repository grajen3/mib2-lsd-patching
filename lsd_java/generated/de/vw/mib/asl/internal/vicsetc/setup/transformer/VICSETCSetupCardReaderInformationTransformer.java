/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.vicsetc.setup.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.vicsetc.setup.transformer.VICSETCSetupCardReaderInformationCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class VICSETCSetupCardReaderInformationTransformer
extends ItemTransformerAdapter {
    public static final int VICSETC_SETUP_CARD_READER_INFORMATION_MESSAGE_TYPE_NAME_STRING;
    public static final int VICSETC_SETUP_CARD_READER_INFORMATION_MESSAGE_MANUFACTURER_NAME_STRING;
    public static final int VICSETC_SETUP_CARD_READER_INFORMATION_IDENTIFICATION_NUMBER_STRING;
    public static final int VICSETC_SETUP_CARD_READER_INFORMATION_MESSAGE_REGISTERED_NAME_STRING;
    public static final int VICSETC_SETUP_CARD_READER_INFORMATION_MESSAGE_SERIAL_PRODUCTION_NUMBER_STRING;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[5];
        int n = 0;
        stringArray[n++] = TransformerUtil.getStringAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 4, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(530208000);
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
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: {
                return this.getString(n, object);
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
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        VICSETCSetupCardReaderInformationCollector vICSETCSetupCardReaderInformationCollector = (VICSETCSetupCardReaderInformationCollector)object;
        switch (n) {
            case 0: {
                return vICSETCSetupCardReaderInformationCollector.vicsetc_setup_card_reader_information_message_type_name;
            }
            case 1: {
                return vICSETCSetupCardReaderInformationCollector.vicsetc_setup_card_reader_information_message_manufacturer_name;
            }
            case 2: {
                return vICSETCSetupCardReaderInformationCollector.vicsetc_setup_card_reader_information_identification_number;
            }
            case 3: {
                return vICSETCSetupCardReaderInformationCollector.vicsetc_setup_card_reader_information_message_registered_name;
            }
            case 4: {
                return vICSETCSetupCardReaderInformationCollector.vicsetc_setup_card_reader_information_message_serial_production_number;
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

