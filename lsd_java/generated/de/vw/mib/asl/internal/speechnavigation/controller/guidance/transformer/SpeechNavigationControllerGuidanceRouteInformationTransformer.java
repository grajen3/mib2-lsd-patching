/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.speechnavigation.controller.guidance.transformer;

import de.vw.mib.asl.internal.list.impl.ItemTransformerAdapter;
import de.vw.mib.asl.internal.util.TransformerUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.ASLListColumns;
import generated.de.vw.mib.asl.internal.speechnavigation.controller.guidance.transformer.SpeechNavigationControllerGuidanceRouteInformationCollector;
import org.dsi.ifc.global.ResourceLocator;

public final class SpeechNavigationControllerGuidanceRouteInformationTransformer
extends ItemTransformerAdapter {
    public static final int SPEECHNAVIGATION_CONTROLLER_GUIDANCE_ROUTE_INFORMATION_DTD_INTEGER;
    public static final int SPEECHNAVIGATION_CONTROLLER_GUIDANCE_ROUTE_INFORMATION_ETAD_INTEGER;
    public static final int SPEECHNAVIGATION_CONTROLLER_GUIDANCE_ROUTE_INFORMATION_ETAH_INTEGER;
    public static final int SPEECHNAVIGATION_CONTROLLER_GUIDANCE_ROUTE_INFORMATION_ETAM_INTEGER;
    public static final int SPEECHNAVIGATION_CONTROLLER_GUIDANCE_ROUTE_INFORMATION_RTTH_INTEGER;
    public static final int SPEECHNAVIGATION_CONTROLLER_GUIDANCE_ROUTE_INFORMATION_RTTM_INTEGER;
    public static final int SPEECHNAVIGATION_CONTROLLER_GUIDANCE_ROUTE_INFORMATION_RTT_MILLISECONDS_INTEGER;
    public static final int LIST_ID;
    private static final int COLUMN_COUNT;

    @Override
    public String[] getRowValuesAsStrings(Object object) {
        String[] stringArray = new String[7];
        int n = 0;
        stringArray[n++] = TransformerUtil.getIntAsString(this, 0, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 1, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 2, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 3, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 4, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 5, object);
        stringArray[n++] = TransformerUtil.getIntAsString(this, 6, object);
        return stringArray;
    }

    @Override
    public int[] getColumnIds() {
        return ASLListColumns.getColumnsForASLList(1527264256);
    }

    @Override
    public int getColumnCount() {
        return 7;
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
            case 6: {
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
            case 4: 
            case 5: 
            case 6: {
                return new Integer(this.getInt(n, object));
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
        SpeechNavigationControllerGuidanceRouteInformationCollector speechNavigationControllerGuidanceRouteInformationCollector = (SpeechNavigationControllerGuidanceRouteInformationCollector)object;
        switch (n) {
            case 0: {
                return speechNavigationControllerGuidanceRouteInformationCollector.speechnavigation_controller_guidance_route_information_dtd;
            }
            case 1: {
                return speechNavigationControllerGuidanceRouteInformationCollector.speechnavigation_controller_guidance_route_information_etad;
            }
            case 2: {
                return speechNavigationControllerGuidanceRouteInformationCollector.speechnavigation_controller_guidance_route_information_etah;
            }
            case 3: {
                return speechNavigationControllerGuidanceRouteInformationCollector.speechnavigation_controller_guidance_route_information_etam;
            }
            case 4: {
                return speechNavigationControllerGuidanceRouteInformationCollector.speechnavigation_controller_guidance_route_information_rtth;
            }
            case 5: {
                return speechNavigationControllerGuidanceRouteInformationCollector.speechnavigation_controller_guidance_route_information_rttm;
            }
            case 6: {
                return speechNavigationControllerGuidanceRouteInformationCollector.speechnavigation_controller_guidance_route_information_rtt_milliseconds;
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

