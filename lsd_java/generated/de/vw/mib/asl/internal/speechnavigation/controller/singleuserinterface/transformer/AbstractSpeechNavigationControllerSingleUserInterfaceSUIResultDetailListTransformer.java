/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.speechnavigation.controller.singleuserinterface.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;

public abstract class AbstractSpeechNavigationControllerSingleUserInterfaceSUIResultDetailListTransformer
extends ItemTransformerAdapter {
    public static final int SPEECHNAVIGATION_CONTROLLER_SINGLEUSERINTERFACE_SUI_RESULT_DETAIL_LIST_TYPE_INTEGER;
    public static final int SPEECHNAVIGATION_CONTROLLER_SINGLEUSERINTERFACE_SUI_RESULT_DETAIL_LIST_CITY_OBJECT_ID_STRING;
    public static final int SPEECHNAVIGATION_CONTROLLER_SINGLEUSERINTERFACE_SUI_RESULT_DETAIL_LIST_CITY_TITLE_STRING;
    public static final int SPEECHNAVIGATION_CONTROLLER_SINGLEUSERINTERFACE_SUI_RESULT_DETAIL_LIST_STREET_OBJECT_ID_STRING;
    public static final int SPEECHNAVIGATION_CONTROLLER_SINGLEUSERINTERFACE_SUI_RESULT_DETAIL_LIST_STREET_TITLE_STRING;
    public static final int SPEECHNAVIGATION_CONTROLLER_SINGLEUSERINTERFACE_SUI_RESULT_DETAIL_LIST_HOUSENUMBER_OBJECT_ID_STRING;
    public static final int SPEECHNAVIGATION_CONTROLLER_SINGLEUSERINTERFACE_SUI_RESULT_DETAIL_LIST_HOUSENUMBER_TITLE_STRING;
    public static final int SPEECHNAVIGATION_CONTROLLER_SINGLEUSERINTERFACE_SUI_RESULT_DETAIL_LIST_ONESHOT_PREFECTURE_OBJECT_ID_STRING;
    public static final int SPEECHNAVIGATION_CONTROLLER_SINGLEUSERINTERFACE_SUI_RESULT_DETAIL_LIST_ONESHOT_PREFECTURE_TITLE_STRING;
    public static final int SPEECHNAVIGATION_CONTROLLER_SINGLEUSERINTERFACE_SUI_RESULT_DETAIL_LIST_ONESHOT_MUNICIPALITY_OBJECT_ID_STRING;
    public static final int SPEECHNAVIGATION_CONTROLLER_SINGLEUSERINTERFACE_SUI_RESULT_DETAIL_LIST_ONESHOT_MUNICIPALITY_TITLE_STRING;
    public static final int SPEECHNAVIGATION_CONTROLLER_SINGLEUSERINTERFACE_SUI_RESULT_DETAIL_LIST_ONESHOT_PLACE_OBJECT_ID_STRING;
    public static final int SPEECHNAVIGATION_CONTROLLER_SINGLEUSERINTERFACE_SUI_RESULT_DETAIL_LIST_ONESHOT_PLACE_TITLE_STRING;
    public static final int SPEECHNAVIGATION_CONTROLLER_SINGLEUSERINTERFACE_SUI_RESULT_DETAIL_LIST_ONESHOT_CHOME_OBJECT_ID_STRING;
    public static final int SPEECHNAVIGATION_CONTROLLER_SINGLEUSERINTERFACE_SUI_RESULT_DETAIL_LIST_ONESHOT_CHOME_TITLE_STRING;
    public static final int SPEECHNAVIGATION_CONTROLLER_SINGLEUSERINTERFACE_SUI_RESULT_DETAIL_LIST_CONTACT_OBJECT_ID_LONG;
    public static final int SPEECHNAVIGATION_CONTROLLER_SINGLEUSERINTERFACE_SUI_RESULT_DETAIL_LIST_CONTACT_NAME_STRING;
    public static final int SPEECHNAVIGATION_CONTROLLER_SINGLEUSERINTERFACE_SUI_RESULT_DETAIL_LIST_CONTACT_PICTURE_RESOURCE_LOCATOR;
    public static final int SPEECHNAVIGATION_CONTROLLER_SINGLEUSERINTERFACE_SUI_RESULT_DETAIL_LIST_CONTACT_FIRST_ADDRESS_STRING;
    public static final int SPEECHNAVIGATION_CONTROLLER_SINGLEUSERINTERFACE_SUI_RESULT_DETAIL_LIST_CONTACT_FIRST_ADDRESS_MORE_STRING;
    public static final int SPEECHNAVIGATION_CONTROLLER_SINGLEUSERINTERFACE_SUI_RESULT_DETAIL_LIST_CONTACT_ADDRESSES_COUNT_STATE_INTEGER;
    public static final int SPEECHNAVIGATION_CONTROLLER_SINGLEUSERINTERFACE_SUI_RESULT_DETAIL_LIST_ONBOARD_POI_CAT_OBJECT_ID_LONG;
    public static final int SPEECHNAVIGATION_CONTROLLER_SINGLEUSERINTERFACE_SUI_RESULT_DETAIL_LIST_ONBOARD_POI_CAT_NAME_STRING;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[23];
        int n = 0;
        stringArray[n++] = TransformerUtil.getIntAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 15, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 16, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 17, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 18, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 19, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 20, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 21, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 22, object);
        stringArray[n++] = TransformerUtil.getLongAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 8, object);
        stringArray[n++] = TransformerUtil.getResourceLocatorAsString(this, 9, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 10, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 11, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 12, object);
        stringArray[n++] = TransformerUtil.getLongAsString(this, 13, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 14, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(-2130168832);
    }

    @Override
    public int getColumnCount() {
        return 23;
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
            case 16: 
            case 17: 
            case 18: 
            case 19: 
            case 20: 
            case 21: 
            case 22: {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(int n, Object object) {
        switch (n) {
            case 0: 
            case 12: {
                return new Integer(this.getInt(n, object));
            }
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 8: 
            case 10: 
            case 11: 
            case 14: 
            case 15: 
            case 16: 
            case 17: 
            case 18: 
            case 19: 
            case 20: 
            case 21: 
            case 22: {
                return this.getString(n, object);
            }
            case 9: {
                return this.getResourceLocator(n, object);
            }
            case 7: 
            case 13: {
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

