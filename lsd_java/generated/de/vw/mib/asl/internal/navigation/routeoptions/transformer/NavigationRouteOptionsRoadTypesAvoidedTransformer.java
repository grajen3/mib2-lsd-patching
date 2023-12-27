/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.routeoptions.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.navigation.routeoptions.transformer.NavigationRouteOptionsRoadTypesAvoidedCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class NavigationRouteOptionsRoadTypesAvoidedTransformer
extends ItemTransformerAdapter {
    public static final int NAVIGATION_ROUTEOPTIONS_ROAD_TYPES_HIGHWAY_AVOIDED_BOOLEAN;
    public static final int NAVIGATION_ROUTEOPTIONS_ROAD_TYPES_TOLLROADS_AVOIDED_BOOLEAN;
    public static final int NAVIGATION_ROUTEOPTIONS_ROAD_TYPES_TRANSPORT_AVOIDED_BOOLEAN;
    public static final int NAVIGATION_ROUTEOPTIONS_ROAD_TYPES_TUNNEL_AVOIDED_BOOLEAN;
    public static final int NAVIGATION_ROUTEOPTIONS_ROAD_TYPES_VIGNETTE_AVOIDED_BOOLEAN;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[5];
        int n = 0;
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getBooleanAsString(this, 5, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(961);
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public boolean isColumnIdSupported(int n) {
        switch (n) {
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
            case 2: 
            case 3: 
            case 4: 
            case 5: {
                return this.getBoolean(n, object);
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        NavigationRouteOptionsRoadTypesAvoidedCollector navigationRouteOptionsRoadTypesAvoidedCollector = (NavigationRouteOptionsRoadTypesAvoidedCollector)object;
        switch (n) {
            case 1: {
                return navigationRouteOptionsRoadTypesAvoidedCollector.navigation_routeoptions_road_types_highway_avoided;
            }
            case 2: {
                return navigationRouteOptionsRoadTypesAvoidedCollector.navigation_routeoptions_road_types_tollroads_avoided;
            }
            case 3: {
                return navigationRouteOptionsRoadTypesAvoidedCollector.navigation_routeoptions_road_types_transport_avoided;
            }
            case 4: {
                return navigationRouteOptionsRoadTypesAvoidedCollector.navigation_routeoptions_road_types_tunnel_avoided;
            }
            case 5: {
                return navigationRouteOptionsRoadTypesAvoidedCollector.navigation_routeoptions_road_types_vignette_avoided;
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

