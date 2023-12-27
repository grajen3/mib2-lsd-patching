/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.speechnavigation.controller.destinationinput.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.speechnavigation.controller.destinationinput.transformer.SpeechNavigationControllerDestinationInputLocationCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class SpeechNavigationControllerDestinationInputLocationTransformer
extends ItemTransformerAdapter {
    public static final int SPEECHNAVIGATION_CONTROLLER_DESTINATIONINPUT_LOCATION_COUNTRY_STRING;
    public static final int SPEECHNAVIGATION_CONTROLLER_DESTINATIONINPUT_LOCATION_COUNTRY_CODE_STRING;
    public static final int SPEECHNAVIGATION_CONTROLLER_DESTINATIONINPUT_LOCATION_PROVINCE_STRING;
    public static final int SPEECHNAVIGATION_CONTROLLER_DESTINATIONINPUT_LOCATION_STATE_STRING;
    public static final int SPEECHNAVIGATION_CONTROLLER_DESTINATIONINPUT_LOCATION_CITY_STRING;
    public static final int SPEECHNAVIGATION_CONTROLLER_DESTINATIONINPUT_LOCATION_POSTAL_CODE_STRING;
    public static final int SPEECHNAVIGATION_CONTROLLER_DESTINATIONINPUT_LOCATION_STREET_STRING;
    public static final int SPEECHNAVIGATION_CONTROLLER_DESTINATIONINPUT_LOCATION_CROSSING_STRING;
    public static final int SPEECHNAVIGATION_CONTROLLER_DESTINATIONINPUT_LOCATION_HOUSENUMBER_STRING;
    public static final int SPEECHNAVIGATION_CONTROLLER_DESTINATIONINPUT_LOCATION_PREFECTURE_STRING;
    public static final int SPEECHNAVIGATION_CONTROLLER_DESTINATIONINPUT_LOCATION_MUNICIPALITY_STRING;
    public static final int SPEECHNAVIGATION_CONTROLLER_DESTINATIONINPUT_LOCATION_PLACE_STRING;
    public static final int SPEECHNAVIGATION_CONTROLLER_DESTINATIONINPUT_LOCATION_CHOME_STRING;
    public static final int SPEECHNAVIGATION_CONTROLLER_DESTINATIONINPUT_LOCATION_FULL_POSTAL_CODE_BOOLEAN;
    public static final int SPEECHNAVIGATION_CONTROLLER_DESTINATIONINPUT_LOCATION_GUIDEABLE_BOOLEAN;
    public static final int SPEECHNAVIGATION_CONTROLLER_DESTINATIONINPUT_LOCATION_COUNTRY_ICON_RESOURCE_LOCATOR;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[16];
        int n = 0;
        stringArray[n++] = TransformerUtil.getStringAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 8, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 12, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 13, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 14, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 15, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 9, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 10, object);
        stringArray[n++] = TransformerUtil.getDeprecatedResourceLocatorAsString(this, 11, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(1560818688);
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
            case 9: 
            case 10: {
                return this.getBoolean(n, object);
            }
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 12: 
            case 13: 
            case 14: 
            case 15: {
                return this.getString(n, object);
            }
            case 11: {
                return this.getResourceLocator(n, object);
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        SpeechNavigationControllerDestinationInputLocationCollector speechNavigationControllerDestinationInputLocationCollector = (SpeechNavigationControllerDestinationInputLocationCollector)object;
        switch (n) {
            case 9: {
                return speechNavigationControllerDestinationInputLocationCollector.speechnavigation_controller_destinationinput_location_full_postal_code;
            }
            case 10: {
                return speechNavigationControllerDestinationInputLocationCollector.speechnavigation_controller_destinationinput_location_guideable;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        SpeechNavigationControllerDestinationInputLocationCollector speechNavigationControllerDestinationInputLocationCollector = (SpeechNavigationControllerDestinationInputLocationCollector)object;
        switch (n) {
            case 0: {
                return speechNavigationControllerDestinationInputLocationCollector.speechnavigation_controller_destinationinput_location_country;
            }
            case 1: {
                return speechNavigationControllerDestinationInputLocationCollector.speechnavigation_controller_destinationinput_location_country_code;
            }
            case 2: {
                return speechNavigationControllerDestinationInputLocationCollector.speechnavigation_controller_destinationinput_location_province;
            }
            case 3: {
                return speechNavigationControllerDestinationInputLocationCollector.speechnavigation_controller_destinationinput_location_state;
            }
            case 4: {
                return speechNavigationControllerDestinationInputLocationCollector.speechnavigation_controller_destinationinput_location_city;
            }
            case 5: {
                return speechNavigationControllerDestinationInputLocationCollector.speechnavigation_controller_destinationinput_location_postal_code;
            }
            case 6: {
                return speechNavigationControllerDestinationInputLocationCollector.speechnavigation_controller_destinationinput_location_street;
            }
            case 7: {
                return speechNavigationControllerDestinationInputLocationCollector.speechnavigation_controller_destinationinput_location_crossing;
            }
            case 8: {
                return speechNavigationControllerDestinationInputLocationCollector.speechnavigation_controller_destinationinput_location_housenumber;
            }
            case 12: {
                return speechNavigationControllerDestinationInputLocationCollector.speechnavigation_controller_destinationinput_location_prefecture;
            }
            case 13: {
                return speechNavigationControllerDestinationInputLocationCollector.speechnavigation_controller_destinationinput_location_municipality;
            }
            case 14: {
                return speechNavigationControllerDestinationInputLocationCollector.speechnavigation_controller_destinationinput_location_place;
            }
            case 15: {
                return speechNavigationControllerDestinationInputLocationCollector.speechnavigation_controller_destinationinput_location_chome;
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
        SpeechNavigationControllerDestinationInputLocationCollector speechNavigationControllerDestinationInputLocationCollector = (SpeechNavigationControllerDestinationInputLocationCollector)object;
        switch (n) {
            case 11: {
                return speechNavigationControllerDestinationInputLocationCollector.speechnavigation_controller_destinationinput_location_country_icon;
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

