/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.locationinput;

import de.vw.mib.properties.values.FixFormatterFieldData;
import org.dsi.ifc.global.ResourceLocator;

public interface ASLNavigationLocationInputPropertyManager {
    public static final int NEXT_REFINEMENTS__NEXT_REFINEMENTS_POSTAL_CODE_AVAILABLE;
    public static final boolean NEXT_REFINEMENTS__NEXT_REFINEMENTS_POSTAL_CODE_AVAILABLE__DEFAULT_VALUE;
    public static final boolean NEXT_REFINEMENTS__NEXT_REFINEMENTS_POSTAL_CODE_AVAILABLE__C0_FALSE;
    public static final boolean NEXT_REFINEMENTS__NEXT_REFINEMENTS_POSTAL_CODE_AVAILABLE__C1_TRUE;
    public static final int NEXT_REFINEMENTS__NEXT_REFINEMENTS_CITY_AVAILABLE;
    public static final boolean NEXT_REFINEMENTS__NEXT_REFINEMENTS_CITY_AVAILABLE__DEFAULT_VALUE;
    public static final boolean NEXT_REFINEMENTS__NEXT_REFINEMENTS_CITY_AVAILABLE__C0_FALSE;
    public static final boolean NEXT_REFINEMENTS__NEXT_REFINEMENTS_CITY_AVAILABLE__C1_TRUE;
    public static final int NEXT_REFINEMENTS__NEXT_REFINEMENTS_STREET_AVAILABLE;
    public static final boolean NEXT_REFINEMENTS__NEXT_REFINEMENTS_STREET_AVAILABLE__DEFAULT_VALUE;
    public static final boolean NEXT_REFINEMENTS__NEXT_REFINEMENTS_STREET_AVAILABLE__C0_FALSE;
    public static final boolean NEXT_REFINEMENTS__NEXT_REFINEMENTS_STREET_AVAILABLE__C1_TRUE;
    public static final int NEXT_REFINEMENTS__NEXT_REFINEMENTS_STREET_DISAMBIGUATION_AVAILABLE;
    public static final boolean NEXT_REFINEMENTS__NEXT_REFINEMENTS_STREET_DISAMBIGUATION_AVAILABLE__DEFAULT_VALUE;
    public static final boolean NEXT_REFINEMENTS__NEXT_REFINEMENTS_STREET_DISAMBIGUATION_AVAILABLE__C0_FALSE;
    public static final boolean NEXT_REFINEMENTS__NEXT_REFINEMENTS_STREET_DISAMBIGUATION_AVAILABLE__C1_TRUE;
    public static final int NEXT_REFINEMENTS__NEXT_REFINEMENTS_STREET_WITH_BN_AVAILABLE;
    public static final boolean NEXT_REFINEMENTS__NEXT_REFINEMENTS_STREET_WITH_BN_AVAILABLE__DEFAULT_VALUE;
    public static final boolean NEXT_REFINEMENTS__NEXT_REFINEMENTS_STREET_WITH_BN_AVAILABLE__C0_FALSE;
    public static final boolean NEXT_REFINEMENTS__NEXT_REFINEMENTS_STREET_WITH_BN_AVAILABLE__C1_TRUE;
    public static final int NEXT_REFINEMENTS__NEXT_REFINEMENTS_HOUSENUMBER_AVAILABLE;
    public static final boolean NEXT_REFINEMENTS__NEXT_REFINEMENTS_HOUSENUMBER_AVAILABLE__DEFAULT_VALUE;
    public static final boolean NEXT_REFINEMENTS__NEXT_REFINEMENTS_HOUSENUMBER_AVAILABLE__C0_FALSE;
    public static final boolean NEXT_REFINEMENTS__NEXT_REFINEMENTS_HOUSENUMBER_AVAILABLE__C1_TRUE;
    public static final int NEXT_REFINEMENTS__NEXT_REFINEMENTS_HOUSENUMBER_ALTERNATIVE_AVAILABLE;
    public static final boolean NEXT_REFINEMENTS__NEXT_REFINEMENTS_HOUSENUMBER_ALTERNATIVE_AVAILABLE__DEFAULT_VALUE;
    public static final boolean NEXT_REFINEMENTS__NEXT_REFINEMENTS_HOUSENUMBER_ALTERNATIVE_AVAILABLE__C0_FALSE;
    public static final boolean NEXT_REFINEMENTS__NEXT_REFINEMENTS_HOUSENUMBER_ALTERNATIVE_AVAILABLE__C1_TRUE;
    public static final int NEXT_REFINEMENTS__NEXT_REFINEMENTS_HOUSENUMBER_MATCH_OR_ALTERNATIVE_AVAILABLE;
    public static final boolean NEXT_REFINEMENTS__NEXT_REFINEMENTS_HOUSENUMBER_MATCH_OR_ALTERNATIVE_AVAILABLE__DEFAULT_VALUE;
    public static final boolean NEXT_REFINEMENTS__NEXT_REFINEMENTS_HOUSENUMBER_MATCH_OR_ALTERNATIVE_AVAILABLE__C0_FALSE;
    public static final boolean NEXT_REFINEMENTS__NEXT_REFINEMENTS_HOUSENUMBER_MATCH_OR_ALTERNATIVE_AVAILABLE__C1_TRUE;
    public static final int NEXT_REFINEMENTS__NEXT_REFINEMENTS_CROSSING_AVAILABLE;
    public static final boolean NEXT_REFINEMENTS__NEXT_REFINEMENTS_CROSSING_AVAILABLE__DEFAULT_VALUE;
    public static final boolean NEXT_REFINEMENTS__NEXT_REFINEMENTS_CROSSING_AVAILABLE__C0_FALSE;
    public static final boolean NEXT_REFINEMENTS__NEXT_REFINEMENTS_CROSSING_AVAILABLE__C1_TRUE;
    public static final int NEXT_REFINEMENTS__NEXT_REFINEMENTS_STATE_AVAILABLE;
    public static final boolean NEXT_REFINEMENTS__NEXT_REFINEMENTS_STATE_AVAILABLE__DEFAULT_VALUE;
    public static final boolean NEXT_REFINEMENTS__NEXT_REFINEMENTS_STATE_AVAILABLE__C0_FALSE;
    public static final boolean NEXT_REFINEMENTS__NEXT_REFINEMENTS_STATE_AVAILABLE__C1_TRUE;
    public static final int NEXT_REFINEMENTS__NEXT_REFINEMENTS_STATE_NEEDED;
    public static final boolean NEXT_REFINEMENTS__NEXT_REFINEMENTS_STATE_NEEDED__DEFAULT_VALUE;
    public static final boolean NEXT_REFINEMENTS__NEXT_REFINEMENTS_STATE_NEEDED__C0_FALSE;
    public static final boolean NEXT_REFINEMENTS__NEXT_REFINEMENTS_STATE_NEEDED__C1_TRUE;
    public static final int NEXT_REFINEMENTS__NEXT_REFINEMENTS_PROVINCE_AVAILABLE;
    public static final boolean NEXT_REFINEMENTS__NEXT_REFINEMENTS_PROVINCE_AVAILABLE__DEFAULT_VALUE;
    public static final boolean NEXT_REFINEMENTS__NEXT_REFINEMENTS_PROVINCE_AVAILABLE__C0_FALSE;
    public static final boolean NEXT_REFINEMENTS__NEXT_REFINEMENTS_PROVINCE_AVAILABLE__C1_TRUE;
    public static final int NEXT_REFINEMENTS__NEXT_REFINEMENTS_PROVINCE_NEEDED;
    public static final boolean NEXT_REFINEMENTS__NEXT_REFINEMENTS_PROVINCE_NEEDED__DEFAULT_VALUE;
    public static final boolean NEXT_REFINEMENTS__NEXT_REFINEMENTS_PROVINCE_NEEDED__C0_FALSE;
    public static final boolean NEXT_REFINEMENTS__NEXT_REFINEMENTS_PROVINCE_NEEDED__C1_TRUE;
    public static final int NEXT_REFINEMENTS__NEXT_REFINEMENTS_PHONENUMBER_AVAILABLE;
    public static final boolean NEXT_REFINEMENTS__NEXT_REFINEMENTS_PHONENUMBER_AVAILABLE__DEFAULT_VALUE;
    public static final boolean NEXT_REFINEMENTS__NEXT_REFINEMENTS_PHONENUMBER_AVAILABLE__C0_FALSE;
    public static final boolean NEXT_REFINEMENTS__NEXT_REFINEMENTS_PHONENUMBER_AVAILABLE__C1_TRUE;
    public static final int NEXT_REFINEMENTS__NEXT_REFINEMENTS_MAPCODE_AVAILABLE;
    public static final boolean NEXT_REFINEMENTS__NEXT_REFINEMENTS_MAPCODE_AVAILABLE__DEFAULT_VALUE;
    public static final boolean NEXT_REFINEMENTS__NEXT_REFINEMENTS_MAPCODE_AVAILABLE__C0_FALSE;
    public static final boolean NEXT_REFINEMENTS__NEXT_REFINEMENTS_MAPCODE_AVAILABLE__C1_TRUE;
    public static final int LOCATION__LOCATION_COUNTRY;
    public static final String LOCATION__LOCATION_COUNTRY__DEFAULT_VALUE;
    public static final int LOCATION__LOCATION_COUNTRY_CODE;
    public static final String LOCATION__LOCATION_COUNTRY_CODE__DEFAULT_VALUE;
    public static final int LOCATION__LOCATION_ISO_COUNTRY_CODE;
    public static final String LOCATION__LOCATION_ISO_COUNTRY_CODE__DEFAULT_VALUE;
    public static final int LOCATION__LOCATION_PROVINCE;
    public static final String LOCATION__LOCATION_PROVINCE__DEFAULT_VALUE;
    public static final int LOCATION__LOCATION_STATE;
    public static final String LOCATION__LOCATION_STATE__DEFAULT_VALUE;
    public static final int LOCATION__LOCATION_CITY;
    public static final String LOCATION__LOCATION_CITY__DEFAULT_VALUE;
    public static final int LOCATION__LOCATION_CITY_REFINEMENT;
    public static final String LOCATION__LOCATION_CITY_REFINEMENT__DEFAULT_VALUE;
    public static final int LOCATION__LOCATION_POSTAL_CODE;
    public static final String LOCATION__LOCATION_POSTAL_CODE__DEFAULT_VALUE;
    public static final int LOCATION__LOCATION_STREET;
    public static final String LOCATION__LOCATION_STREET__DEFAULT_VALUE;
    public static final int LOCATION__LOCATION_STREET_REFINEMENT;
    public static final String LOCATION__LOCATION_STREET_REFINEMENT__DEFAULT_VALUE;
    public static final int LOCATION__LOCATION_CROSSING;
    public static final String LOCATION__LOCATION_CROSSING__DEFAULT_VALUE;
    public static final int LOCATION__LOCATION_HOUSENUMBER;
    public static final String LOCATION__LOCATION_HOUSENUMBER__DEFAULT_VALUE;
    public static final int LOCATION__LOCATION_LON_DEGREE;
    public static final int LOCATION__LOCATION_LON_DEGREE__DEFAULT_VALUE;
    public static final int LOCATION__LOCATION_LON_MINUTES;
    public static final int LOCATION__LOCATION_LON_MINUTES__DEFAULT_VALUE;
    public static final int LOCATION__LOCATION_LON_SECONDS;
    public static final int LOCATION__LOCATION_LON_SECONDS__DEFAULT_VALUE;
    public static final int LOCATION__LOCATION_LON_SECONDS__MIN_VALUE;
    public static final int LOCATION__LOCATION_LAT_DEGREE;
    public static final int LOCATION__LOCATION_LAT_DEGREE__DEFAULT_VALUE;
    public static final int LOCATION__LOCATION_LAT_MINUTES;
    public static final int LOCATION__LOCATION_LAT_MINUTES__DEFAULT_VALUE;
    public static final int LOCATION__LOCATION_LAT_SECONDS;
    public static final int LOCATION__LOCATION_LAT_SECONDS__DEFAULT_VALUE;
    public static final int LOCATION__LOCATION_TYPE;
    public static final int LOCATION__LOCATION_TYPE__DEFAULT_VALUE;
    public static final int LOCATION__LOCATION_TYPE__C0_ADDRESS;
    public static final int LOCATION__LOCATION_TYPE__C1_GEOCOORDINATES;
    public static final int LOCATION__LOCATION_TYPE__C2_UNUSED;
    public static final int LOCATION__LOCATION_EMPTY;
    public static final boolean LOCATION__LOCATION_EMPTY__DEFAULT_VALUE;
    public static final boolean LOCATION__LOCATION_EMPTY__C0_FALSE;
    public static final boolean LOCATION__LOCATION_EMPTY__C1_TRUE;
    public static final int LOCATION__LOCATION_FULL_POSTAL_CODE;
    public static final boolean LOCATION__LOCATION_FULL_POSTAL_CODE__DEFAULT_VALUE;
    public static final boolean LOCATION__LOCATION_FULL_POSTAL_CODE__C0_FALSE;
    public static final boolean LOCATION__LOCATION_FULL_POSTAL_CODE__C1_TRUE;
    public static final int LOCATION__LOCATION_POSTAL_CODE_SPELLED;
    public static final boolean LOCATION__LOCATION_POSTAL_CODE_SPELLED__DEFAULT_VALUE;
    public static final boolean LOCATION__LOCATION_POSTAL_CODE_SPELLED__C0_FALSE;
    public static final boolean LOCATION__LOCATION_POSTAL_CODE_SPELLED__C1_TRUE;
    public static final int LOCATION__LOCATION_TOWN_ORDER;
    public static final boolean LOCATION__LOCATION_TOWN_ORDER__DEFAULT_VALUE;
    public static final boolean LOCATION__LOCATION_TOWN_ORDER__C0_FALSE;
    public static final boolean LOCATION__LOCATION_TOWN_ORDER__C1_TRUE;
    public static final int LOCATION__LOCATION_POSTAL_CODE_NEEDED;
    public static final boolean LOCATION__LOCATION_POSTAL_CODE_NEEDED__DEFAULT_VALUE;
    public static final boolean LOCATION__LOCATION_POSTAL_CODE_NEEDED__C0_FALSE;
    public static final boolean LOCATION__LOCATION_POSTAL_CODE_NEEDED__C1_TRUE;
    public static final int LOCATION__LOCATION_TOWN_REFINEMENT_NEEDED;
    public static final boolean LOCATION__LOCATION_TOWN_REFINEMENT_NEEDED__DEFAULT_VALUE;
    public static final boolean LOCATION__LOCATION_TOWN_REFINEMENT_NEEDED__C0_FALSE;
    public static final boolean LOCATION__LOCATION_TOWN_REFINEMENT_NEEDED__C1_TRUE;
    public static final int LOCATION__LOCATION_STREET_REFINEMENT_NEEDED;
    public static final boolean LOCATION__LOCATION_STREET_REFINEMENT_NEEDED__DEFAULT_VALUE;
    public static final boolean LOCATION__LOCATION_STREET_REFINEMENT_NEEDED__C0_FALSE;
    public static final boolean LOCATION__LOCATION_STREET_REFINEMENT_NEEDED__C1_TRUE;
    public static final int LOCATION__LOCATION_RESOLVED;
    public static final boolean LOCATION__LOCATION_RESOLVED__DEFAULT_VALUE;
    public static final boolean LOCATION__LOCATION_RESOLVED__C0_FALSE;
    public static final boolean LOCATION__LOCATION_RESOLVED__C1_TRUE;
    public static final int LOCATION__LOCATION_GUIDEABLE;
    public static final boolean LOCATION__LOCATION_GUIDEABLE__DEFAULT_VALUE;
    public static final boolean LOCATION__LOCATION_GUIDEABLE__C0_FALSE;
    public static final boolean LOCATION__LOCATION_GUIDEABLE__C1_TRUE;
    public static final int LOCATION__LOCATION_ADDRESS_FORMAT;
    public static final int LOCATION__LOCATION_ADDRESS_FORMAT__DEFAULT_VALUE;
    public static final int LOCATION__LOCATION_ADDRESS_FORMAT__C0_DEFAULT_ADDRESS_NAR;
    public static final int LOCATION__LOCATION_ADDRESS_FORMAT__C1_CITYCENTER_NAR;
    public static final int LOCATION__LOCATION_ADDRESS_FORMAT__C2_INTERSECTION_NAR;
    public static final int LOCATION__LOCATION_ADDRESS_FORMAT__C3_UNKNOWN;
    public static final int LOCATION__LOCATION_CITY_CENTER;
    public static final boolean LOCATION__LOCATION_CITY_CENTER__DEFAULT_VALUE;
    public static final boolean LOCATION__LOCATION_CITY_CENTER__C0_FALSE;
    public static final boolean LOCATION__LOCATION_CITY_CENTER__C1_TRUE;
    public static final int LOCATION__LOCATION_COUNTRY_ICON;
    public static final ResourceLocator LOCATION__LOCATION_COUNTRY_ICON__DEFAULT_VALUE;
    public static final int LOCATION__LOCATION_ADDRESS_DETAILS_FOR_FIX_FORMATTER;
    public static final FixFormatterFieldData LOCATION__LOCATION_ADDRESS_DETAILS_FOR_FIX_FORMATTER__DEFAULT_VALUE;
    public static final int LOCATION__LOCATION_STOPOVER_INDEX;
    public static final int LOCATION__LOCATION_STOPOVER_INDEX__DEFAULT_VALUE;
    public static final int ACTION_RESULT;
    public static final int ACTION_RESULT__DEFAULT_VALUE;
    public static final int ACTION_RESULT__C0_OK;
    public static final int ACTION_RESULT__C1_ERROR;
    public static final int PREPARED_FIELD;
    public static final int PREPARED_FIELD__DEFAULT_VALUE;
    public static final int PREPARED_FIELD__C0_COUNTRY;
    public static final int PREPARED_FIELD__C1_CITY;
    public static final int PREPARED_FIELD__C2_ZIP;
    public static final int PREPARED_FIELD__C3_STREET;
    public static final int PREPARED_FIELD__C4_HNO;
    public static final int PREPARED_FIELD__C5_CROSS;
    public static final int PREPARED_FIELD__C6_STREET_DISAMBIGUATION;
    public static final int PREPARED_FIELD__C7_PROVINCE;
    public static final int PREPARED_FIELD__C8_STATE;
    public static final int PREPARED_FIELD__C9_NONE;
    public static final int INITIALIZATION_STATE;
    public static final int INITIALIZATION_STATE__DEFAULT_VALUE;
    public static final int INITIALIZATION_STATE__C0_HOME;
    public static final int INITIALIZATION_STATE__C1_DEMO;
    public static final int INITIALIZATION_STATE__C2_LAST_DEST;
    public static final int INITIALIZATION_STATE__C3_LOCATION_INPUT;
    public static final int INITIALIZATION_STATE__C4_POI;
    public static final int INITIALIZATION_STATE__C5_MAP_INPUT;
    public static final int INITIALIZATION_STATE__C6_DEST_MEM;
    public static final int INITIALIZATION_STATE__C7_NONE;
    public static final int INITIALIZATION_STATE__C8_EXTERNAL_LOCATION;
    public static final int INITIALIZATION_STATE__C9_WPM_LOCATION;
    public static final int INITIALIZATION_STATE__C10_POI_ONLINE;
    public static final int INITIALIZATION_STATE__C11_TOURMODE;
    public static final int INITIALIZATION_STATE__C12_INTERNETBROWSER;
    public static final int INITIALIZATION_STATE__C13_CLICK_IN_MAP;
    public static final int INITIALIZATION_STATE__C14_SLDE;
    public static final int WAIT_FOR_ABORT_RECOGNITION;
    public static final boolean WAIT_FOR_ABORT_RECOGNITION__DEFAULT_VALUE;
    public static final boolean WAIT_FOR_ABORT_RECOGNITION__C0_FALSE;
    public static final boolean WAIT_FOR_ABORT_RECOGNITION__C1_TRUE;
    public static final int LAST_INPUT_MODE;
    public static final int LAST_INPUT_MODE__DEFAULT_VALUE;
    public static final int LAST_INPUT_MODE__C0_SLDE;
    public static final int LAST_INPUT_MODE__C1_NDF;

    static {
        LOCATION__LOCATION_COUNTRY_ICON__DEFAULT_VALUE = null;
        LOCATION__LOCATION_ADDRESS_DETAILS_FOR_FIX_FORMATTER__DEFAULT_VALUE = null;
    }
}
