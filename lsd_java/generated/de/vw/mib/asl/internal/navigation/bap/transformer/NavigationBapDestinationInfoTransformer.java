/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.bap.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.navigation.bap.transformer.NavigationBapDestinationInfoCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class NavigationBapDestinationInfoTransformer
extends ItemTransformerAdapter {
    public static final int NAVIGATION_BAP_LATITUDE_INTEGER;
    public static final int NAVIGATION_BAP_LONGITUDE_INTEGER;
    public static final int NAVIGATION_BAP_STREET_STRING;
    public static final int NAVIGATION_BAP_TOWN_STRING;
    public static final int NAVIGATION_BAP_STATE_STRING;
    public static final int NAVIGATION_BAP_POSTAL_CODE_STRING;
    public static final int NAVIGATION_BAP_COUNTRY_STRING;
    public static final int NAVIGATION_BAP_POI_DESCRIPTION_STRING;
    public static final int NAVIGATION_BAP_POI_INTEGER;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[9];
        int n = 0;
        stringArray[n++] = TransformerUtil.getIntAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 6, object);
        stringArray[n++] = TransformerUtil.getStringAsString(this, 7, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 8, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(3799);
    }

    @Override
    public int getColumnCount() {
        return 9;
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
            case 8: {
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
            case 8: {
                return new Integer(this.getInt(n, object));
            }
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: {
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
        NavigationBapDestinationInfoCollector navigationBapDestinationInfoCollector = (NavigationBapDestinationInfoCollector)object;
        switch (n) {
            case 0: {
                return navigationBapDestinationInfoCollector.navigation_bap_latitude;
            }
            case 1: {
                return navigationBapDestinationInfoCollector.navigation_bap_longitude;
            }
            case 8: {
                return navigationBapDestinationInfoCollector.navigation_bap_poi;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        NavigationBapDestinationInfoCollector navigationBapDestinationInfoCollector = (NavigationBapDestinationInfoCollector)object;
        switch (n) {
            case 2: {
                return navigationBapDestinationInfoCollector.navigation_bap_street;
            }
            case 3: {
                return navigationBapDestinationInfoCollector.navigation_bap_town;
            }
            case 4: {
                return navigationBapDestinationInfoCollector.navigation_bap_state;
            }
            case 5: {
                return navigationBapDestinationInfoCollector.navigation_bap_postal_code;
            }
            case 6: {
                return navigationBapDestinationInfoCollector.navigation_bap_country;
            }
            case 7: {
                return navigationBapDestinationInfoCollector.navigation_bap_poi_description;
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

