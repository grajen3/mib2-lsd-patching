/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.speechnavigation.controller.onboardpois.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import org.dsi.ifc.global.ResourceLocator;

public abstract class AbstractSpeechNavigationControllerOnboardPOIsOnboardPOICategoriesTransformer
extends ItemTransformerAdapter {
    public static final int SPEECHNAVIGATION_CONTROLLER_ONBOARDPOIS_ONBOARD_POI_CATEGORY_OBJECT_ID_LONG;
    public static final int SPEECHNAVIGATION_CONTROLLER_ONBOARDPOIS_ONBOARD_POI_CAT_OBJECT_ID_LONG;
    public static final int SPEECHNAVIGATION_CONTROLLER_ONBOARDPOIS_ONBOARD_POI_CATEGORY_GROUP_SIZE_INTEGER;
    public static final int SPEECHNAVIGATION_CONTROLLER_ONBOARDPOIS_ONBOARD_POI_CAT_GROUP_SIZE_INTEGER;
    public static final int SPEECHNAVIGATION_CONTROLLER_ONBOARDPOIS_ONBOARD_POI_CATEGORY_NAME_STRING;
    public static final int SPEECHNAVIGATION_CONTROLLER_ONBOARDPOIS_ONBOARD_POI_CAT_NAME_STRING;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[6];
        int n = 0;
        stringArray[n++] = TransformerUtil.getDeprecatedLongAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getLongAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getDeprecatedIntAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getDeprecatedStringAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 5, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(1829254144);
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
            case 1: 
            case 4: {
                return new Integer(this.getInt(n, object));
            }
            case 2: 
            case 5: {
                return this.getString(n, object);
            }
            case 0: 
            case 3: {
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
    public ResourceLocator getResourceLocator(int n, Object object) {
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

