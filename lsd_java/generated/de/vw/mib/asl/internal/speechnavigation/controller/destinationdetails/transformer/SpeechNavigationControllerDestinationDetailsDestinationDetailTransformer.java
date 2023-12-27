/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.speechnavigation.controller.destinationdetails.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.speechnavigation.controller.destinationdetails.transformer.SpeechNavigationControllerDestinationDetailsDestinationDetailCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class SpeechNavigationControllerDestinationDetailsDestinationDetailTransformer
extends ItemTransformerAdapter {
    public static final int SPEECHNAVIGATION_CONTROLLER_DESTINATIONDETAILS_DETAIL_ADDRESS_FOR_FIX_FORMATTER_FIX_FORMATTER_FIELD_DATA;
    public static final int SPEECHNAVIGATION_CONTROLLER_DESTINATIONDETAILS_SHORT_ADDRESS_STRING;
    public static final int SPEECHNAVIGATION_CONTROLLER_DESTINATIONDETAILS_LONG_ADDRESS_STRING;
    public static final int SPEECHNAVIGATION_CONTROLLER_DESTINATIONDETAILS_LONG_ADDRESS_LINE1_STRING;
    public static final int SPEECHNAVIGATION_CONTROLLER_DESTINATIONDETAILS_LONG_ADDRESS_LINE2_STRING;
    public static final int SPEECHNAVIGATION_CONTROLLER_DESTINATIONDETAILS_DETAIL_CITY_STRING;
    public static final int SPEECHNAVIGATION_CONTROLLER_DESTINATIONDETAILS_DETAIL_STREET_STRING;
    public static final int SPEECHNAVIGATION_CONTROLLER_DESTINATIONDETAILS_DETAIL_HOUSE_NUMBER_STRING;
    public static final int SPEECHNAVIGATION_CONTROLLER_DESTINATIONDETAILS_DETAIL_CROSSING_STRING;
    public static final int SPEECHNAVIGATION_CONTROLLER_DESTINATIONDETAILS_DETAIL_ZIP_STRING;
    public static final int SPEECHNAVIGATION_CONTROLLER_DESTINATIONDETAILS_DETAIL_STATE_STRING;
    public static final int SPEECHNAVIGATION_CONTROLLER_DESTINATIONDETAILS_DETAIL_DISTRICT_STRING;
    public static final int SPEECHNAVIGATION_CONTROLLER_DESTINATIONDETAILS_DETAIL_TOWN_SHIP_STRING;
    public static final int SPEECHNAVIGATION_CONTROLLER_DESTINATIONDETAILS_DETAIL_PREFECTURE_STRING;
    public static final int SPEECHNAVIGATION_CONTROLLER_DESTINATIONDETAILS_DETAIL_MUNICIPALITY_STRING;
    public static final int SPEECHNAVIGATION_CONTROLLER_DESTINATIONDETAILS_DETAIL_PLACE_STRING;
    public static final int SPEECHNAVIGATION_CONTROLLER_DESTINATIONDETAILS_DETAIL_C_HOME_STRING;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[17];
        int n = 0;
        stringArray[n++] = TransformerUtil.getFixFormatterFieldDataAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 12, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 13, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 15, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 16, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 14, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 8, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 9, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 10, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 11, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(1544041472);
    }

    @Override
    public int getColumnCount() {
        return 17;
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
            case 15: 
            case 16: {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(int n, Object object) {
        switch (n) {
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
            case 15: 
            case 16: {
                return this.getString(n, object);
            }
            case 0: {
                return this.getFixFormatterFieldData(n, object);
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
        SpeechNavigationControllerDestinationDetailsDestinationDetailCollector speechNavigationControllerDestinationDetailsDestinationDetailCollector = (SpeechNavigationControllerDestinationDetailsDestinationDetailCollector)object;
        switch (n) {
            case 12: {
                return speechNavigationControllerDestinationDetailsDestinationDetailCollector.speechnavigation_controller_destinationdetails_short_address;
            }
            case 13: {
                return speechNavigationControllerDestinationDetailsDestinationDetailCollector.speechnavigation_controller_destinationdetails_long_address;
            }
            case 15: {
                return speechNavigationControllerDestinationDetailsDestinationDetailCollector.speechnavigation_controller_destinationdetails_long_address_line1;
            }
            case 16: {
                return speechNavigationControllerDestinationDetailsDestinationDetailCollector.speechnavigation_controller_destinationdetails_long_address_line2;
            }
            case 1: {
                return speechNavigationControllerDestinationDetailsDestinationDetailCollector.speechnavigation_controller_destinationdetails_detail_city;
            }
            case 2: {
                return speechNavigationControllerDestinationDetailsDestinationDetailCollector.speechnavigation_controller_destinationdetails_detail_street;
            }
            case 3: {
                return speechNavigationControllerDestinationDetailsDestinationDetailCollector.speechnavigation_controller_destinationdetails_detail_house_number;
            }
            case 14: {
                return speechNavigationControllerDestinationDetailsDestinationDetailCollector.speechnavigation_controller_destinationdetails_detail_crossing;
            }
            case 4: {
                return speechNavigationControllerDestinationDetailsDestinationDetailCollector.speechnavigation_controller_destinationdetails_detail_zip;
            }
            case 5: {
                return speechNavigationControllerDestinationDetailsDestinationDetailCollector.speechnavigation_controller_destinationdetails_detail_state;
            }
            case 6: {
                return speechNavigationControllerDestinationDetailsDestinationDetailCollector.speechnavigation_controller_destinationdetails_detail_district;
            }
            case 7: {
                return speechNavigationControllerDestinationDetailsDestinationDetailCollector.speechnavigation_controller_destinationdetails_detail_town_ship;
            }
            case 8: {
                return speechNavigationControllerDestinationDetailsDestinationDetailCollector.speechnavigation_controller_destinationdetails_detail_prefecture;
            }
            case 9: {
                return speechNavigationControllerDestinationDetailsDestinationDetailCollector.speechnavigation_controller_destinationdetails_detail_municipality;
            }
            case 10: {
                return speechNavigationControllerDestinationDetailsDestinationDetailCollector.speechnavigation_controller_destinationdetails_detail_place;
            }
            case 11: {
                return speechNavigationControllerDestinationDetailsDestinationDetailCollector.speechnavigation_controller_destinationdetails_detail_c_home;
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
        SpeechNavigationControllerDestinationDetailsDestinationDetailCollector speechNavigationControllerDestinationDetailsDestinationDetailCollector = (SpeechNavigationControllerDestinationDetailsDestinationDetailCollector)object;
        switch (n) {
            case 0: {
                return speechNavigationControllerDestinationDetailsDestinationDetailCollector.speechnavigation_controller_destinationdetails_detail_address_for_fix_formatter;
            }
        }
        throw new IllegalArgumentException();
    }
}

