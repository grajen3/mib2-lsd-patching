/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.poi;

public interface ASLNavigationPOISetter {
    public static final int CONTINUE_TO_DETAIL_VIEW;
    public static final int DESTINATION_ITEM_SET_AS_CURRENT_DEST;
    public static final int DETERMINE_TYPE_OF_CATEGORY;
    public static final int DETERMINE_TYPE_OF_CATEGORY__P0_UID__LONG;
    public static final int INIT_ALL_CATEGORY_LIST;
    public static final int INIT_SEARCH_AREA;
    public static final int INIT_SEARCH_AREA__P0_TYPE_OF_SEARCHAREA__INT;
    public static final int INIT_SEARCH_AREA__TYPE_OF_SEARCHAREA__C0_LAST;
    public static final int INIT_SEARCH_AREA__TYPE_OF_SEARCHAREA__C1_AROUND_MY_POSITION;
    public static final int INIT_SEARCH_AREA__TYPE_OF_SEARCHAREA__C2_POINT_IN_MAP;
    public static final int INIT_SEARCH_AREA__TYPE_OF_SEARCHAREA__C3_AROUND_DESTINATION;
    public static final int INIT_SEARCH_AREA__TYPE_OF_SEARCHAREA__C4_AROUND_STOPOVER;
    public static final int INIT_SEARCH_AREA__TYPE_OF_SEARCHAREA__C5_ALONG_THE_ROUTE;
    public static final int INIT_SEARCH_AREA__TYPE_OF_SEARCHAREA__C6_ADDRESS;
    public static final int INIT_SEARCH_AREA__TYPE_OF_SEARCHAREA__C7_GETADDRESS;
    public static final int INIT_SEARCH_AREA__TYPE_OF_SEARCHAREA__C8_PHONENUMBER;
    public static final int INIT_SEARCH_AREA__TYPE_OF_SEARCHAREA__C9_INSIDE_AREA;
    public static final int INIT_SEARCH_AREA__TYPE_OF_SEARCHAREA__C10_LAST_CHN;
    public static final int INIT_SEARCH_AREA__TYPE_OF_SEARCHAREA__C11_GETADDRESS_CHN;
    public static final int INIT_SEARCH_AREA__TYPE_OF_SEARCHAREA__C12_GETPOIADDRESS_CHN;
    public static final int INIT_SEARCH_AREA__TYPE_OF_SEARCHAREA__C13_INIT_CHN;
    public static final int INIT_SEARCH_AREA_SPELLER_X;
    public static final int INIT_SEARCH_AREA_SPELLER_X__P0_TYPE_OF_SEARCHAREA__INT;
    public static final int INIT_SEARCH_AREA_SPELLER_X__TYPE_OF_SEARCHAREA__C0_LAST;
    public static final int INIT_SEARCH_AREA_SPELLER_X__TYPE_OF_SEARCHAREA__C1_AROUND_MY_POSITION;
    public static final int INIT_SEARCH_AREA_SPELLER_X__TYPE_OF_SEARCHAREA__C2_POINT_IN_MAP;
    public static final int INIT_SEARCH_AREA_SPELLER_X__TYPE_OF_SEARCHAREA__C3_AROUND_DESTINATION;
    public static final int INIT_SEARCH_AREA_SPELLER_X__TYPE_OF_SEARCHAREA__C4_AROUND_STOPOVER;
    public static final int INIT_SEARCH_AREA_SPELLER_X__TYPE_OF_SEARCHAREA__C5_ALONG_THE_ROUTE;
    public static final int INIT_SEARCH_AREA_SPELLER_X__TYPE_OF_SEARCHAREA__C6_ADDRESS;
    public static final int INIT_SEARCH_AREA_SPELLER_X__TYPE_OF_SEARCHAREA__C7_GETADDRESS;
    public static final int INIT_SEARCH_AREA_SPELLER_X__TYPE_OF_SEARCHAREA__C8_PHONENUMBER;
    public static final int INIT_SEARCH_AREA_SPELLER_X__TYPE_OF_SEARCHAREA__C9_INSIDE_AREA;
    public static final int INIT_SEARCH_AREA_SPELLER_X__TYPE_OF_SEARCHAREA__C10_LAST_CHN;
    public static final int INIT_SEARCH_AREA_SPELLER_X__TYPE_OF_SEARCHAREA__C11_GETADDRESS_CHN;
    public static final int INIT_SEARCH_AREA_SPELLER_X__TYPE_OF_SEARCHAREA__C12_GETPOIADDRESS_CHN;
    public static final int INIT_SEARCH_AREA_SPELLER_X__TYPE_OF_SEARCHAREA__C13_INIT_CHN;
    public static final int LOAD_TOP_POI_ITEM_FUEL_STATION;
    public static final int PIT_STOP_ITEM_LOAD;
    public static final int PIT_STOP_ITEM_LOAD__P0_MAINITEMNUMBER__INT;
    public static final int PIT_STOP_ITEM_LOAD__MAINITEMNUMBER__C0_FIRST_ITEM;
    public static final int PIT_STOP_ITEM_LOAD__MAINITEMNUMBER__C1_SECOND_ITEM;
    public static final int PIT_STOP_ITEM_LOAD__MAINITEMNUMBER__C2_THIRD_ITEM;
    public static final int PIT_STOP_ITEM_LOAD__MAINITEMNUMBER__C3_FOURTH_ITEM;
    public static final int PIT_STOP_ITEM_LOAD__MAINITEMNUMBER__C4_FIFTH_ITEM;
    public static final int PREPARE_POI_LISTS;
    public static final int RESULT_SELECT_DETAILS;
    public static final int RESULT_SELECT_DETAILS__P0_LISTITEM__INT;
    public static final int RESULT_SELECT_NEXT_DETAILS;
    public static final int RESULT_SELECT_PREV_DETAILS;
    public static final int SAVE_ADDRESS;
    public static final int SEARCH_CATEGORY_LIST_LOAD_DATA_REQUEST;
    public static final int SEARCH_CATEGORY_SELECT_ALL_ELEMENT;
    public static final int SEARCH_CATEGORY_SELECT_CATEGORY_ELEMENT;
    public static final int SEARCH_CATEGORY_SELECT_CATEGORY_ELEMENT__P0_LISTITEM__INT;
    public static final int SEARCH_CATEGORY_SELECT_GROUP_ELEMENT;
    public static final int SEARCH_CATEGORY_SELECT_GROUP_ELEMENT__P0_LISTITEM__INT;
    public static final int SEARCH_CATEGORY_SELECT_GROUP_ELEMENT_CLOSE;
    public static final int SEARCH_RESULT_DETAIL_VIEW_CLOSE;
    public static final int SEARCH_SET_NAME;
    public static final int SEARCH_SET_NAME_DEL_CHAR;
    public static final int SEARCH_SET_NAME_SET_CHAR;
    public static final int SEARCH_SET_NAME_SET_CHAR__P0_CHARACTER__STRING;
    public static final int SEARCH_SET_NAME_SET_CURSOR_POSITION;
    public static final int SEARCH_SET_NAME_SET_CURSOR_POSITION__P0_VALUE__INT;
    public static final int SEARCH_SET_NAME_SET_STRING;
    public static final int SEARCH_SET_NAME_SET_STRING__P0_CHARACTER__STRING;
    public static final int START_POI_SEACH_WITH_CATEGORY_UID2;
    public static final int START_POI_SEACH_WITH_CATEGORY_UID2__P0_UID__LONG;
    public static final int START_POI_SEACH_WITH_CATEGORY_UID2__P1_LISTITEM__INT;
    public static final int START_POI_SEACH_WITH_CATEGORY_UID2__LISTITEM__C0_LAST;
    public static final int START_POI_SEACH_WITH_CATEGORY_UID2__LISTITEM__C1_AROUND_MY_POSITION;
    public static final int START_POI_SEACH_WITH_CATEGORY_UID2__LISTITEM__C2_POINT_IN_MAP;
    public static final int START_POI_SEACH_WITH_CATEGORY_UID2__LISTITEM__C3_AROUND_DESTINATION;
    public static final int START_POI_SEACH_WITH_CATEGORY_UID2__LISTITEM__C4_AROUND_STOPOVER;
    public static final int START_POI_SEACH_WITH_CATEGORY_UID2__LISTITEM__C5_ALONG_THE_ROUTE;
    public static final int START_POI_SEACH_WITH_CATEGORY_UID2__LISTITEM__C6_ADDRESS;
    public static final int START_POI_SEACH_WITH_CATEGORY_UID2__LISTITEM__C7_GETADDRESS;
    public static final int START_POI_SEACH_WITH_CATEGORY_UID2__LISTITEM__C8_PHONENUMBER;
    public static final int START_POI_SEACH_WITH_CATEGORY_UID2__LISTITEM__C9_INSIDE_AREA;
    public static final int START_POI_SEACH_WITH_CATEGORY_UID2__LISTITEM__C10_LAST_CHN;
    public static final int START_POI_SEACH_WITH_CATEGORY_UID2__LISTITEM__C11_GETADDRESS_CHN;
    public static final int START_POI_SEACH_WITH_CATEGORY_UID2__LISTITEM__C12_GETPOIADDRESS_CHN;
    public static final int START_POI_SEACH_WITH_CATEGORY_UID2__LISTITEM__C13_INIT_CHN;
    public static final int SEARCH_SPELLER_INIT;
    public static final int SEARCH_START;
    public static final int SEARCH_START_CATEGORY;
    public static final int SEARCH_START_CATEGORY__P0_UID__LONG;
    public static final int SEARCH_START_THESAURUS;
    public static final int SEARCH_STOP;
    public static final int SEARCH_VIEW_CLOSE;
    public static final int SELECT_LIST_ELEMENT;
    public static final int SELECT_LIST_ELEMENT__P0_VALUEMAINLIST__INT;
    public static final int SELECT_SEARCH_ELEMENT;
    public static final int SELECT_SEARCH_ELEMENT__P0_VALUEMAINLIST__INT;
    public static final int SELECT_SEARCH_ELEMENT__P1_VALUESUBLIST__INT;
    public static final int SELECT_SEARCH_ELEMENT_CLOSE;
    public static final int FIND_PO_IS;
    public static final int CLEAR_INPUT_FIELDS;
    public static final int INIT_POI_NAME_SPELLER;
    public static final int SAVE_POI_NAME__1;
    public static final int SAVE_POI_NAME__1__P0_POINAME__STRING;
    public static final int INIT_POI_CATEGORIES;
    public static final int SELECT_POI_CATEGORY__1;
    public static final int SELECT_POI_CATEGORY__1__P0_LISTITEM__INT;
    public static final int SELECT_ALL_GROUP_ELEMENTS;
    public static final int SELECT_ALL_CATEGORY_ELEMENTS;
    public static final int LOAD_CHARGING_STATIONS;
    public static final int LOAD_CHARGING_STATIONS__P0_GUIDANCE__BOOLEAN;
    public static final boolean LOAD_CHARGING_STATIONS__GUIDANCE__C0_OFF;
    public static final boolean LOAD_CHARGING_STATIONS__GUIDANCE__C1_ON;
    public static final int WAIT_FOR_CLICKED_STACK_LOAD_FINISHED;
    public static final int SEARCH_FUEL_STATIONS_PETROL;
    public static final int SEARCH_FUEL_STATIONS_DIESEL;
    public static final int SEARCH_FUEL_STATIONS_CNG;
    public static final int SEARCH_FUEL_STATIONS_LPG;
    public static final int SEARCH_SET_NAME_SET_CHAR_HWR;
    public static final int SEARCH_SET_NAME_SET_CHAR_HWR__P0_CHARACTER__STRING;
    public static final int SEARCH_SET_NAME_SET_CHAR_HWR__P1_CURSORPOSITION__INT;
    public static final int SEARCH_SET_NAME_SET_CHAR_HWR__P2_SELECTIONSTART__INT;
    public static final int SEARCH_SET_NAME_SET_CHAR_HWR__P3_SELECTIONEND__INT;
    public static final int SEARCH_SET_NAME_DEL_ALL_CHARS;
    public static final int SET_HWR_SPELLER_MODE_ENABLED;
    public static final int SET_HWR_SPELLER_MODE_ENABLED__P0_VALUE__BOOLEAN;
    public static final boolean SET_HWR_SPELLER_MODE_ENABLED__VALUE__C0_FALSE;
    public static final boolean SET_HWR_SPELLER_MODE_ENABLED__VALUE__C1_TRUE;
    public static final int SET_SPELLER_MODE;
    public static final int SET_SPELLER_MODE__P0_SPELLER_MODE__INT;
    public static final int SET_SPELLER_MODE__SPELLER_MODE__C0_DEFAULT;
    public static final int SET_SPELLER_MODE__SPELLER_MODE__C1_XT9;
    public static final int NAME_SPELLER_ENTERED;
    public static final int NAME_SPELLER_CANCELED;
    public static final int NAME_SPELLER_OK_PRESSED;
    public static final int NAME_SPELLER_OK_PRESSED__P0_STRING__STRING;
    public static final int SEARCH_SET_NAME_UPDATE_SEPARATORS;
    public static final int SEARCH_SET_NAME_UPDATE_SEPARATORS__P0_NAME__STRING;
    public static final int INIT_POI_SEARCH_BY_ONLINE_CATEGORY;
    public static final int INIT_POI_SEARCH_BY_ONLINE_CATEGORY__P0_CATEGORY__INT;
    public static final int INIT_POI_SEARCH_BY_ONLINE_CATEGORY__CATEGORY__C0_FUEL_STATION;
    public static final int INIT_POI_SEARCH_BY_ONLINE_CATEGORY__CATEGORY__C1_PARKING_LOT;
    public static final int INIT_ONLINE_POI_SEARCH_BY_CATEGORY;
    public static final int INIT_ONLINE_POI_SEARCH_BY_CATEGORY__P0_ID__INT;
    public static final int EXPAND_HWR_LIVE_SEARCH_PREVIEWLINE;
    public static final int SELECT_TOP_POI;
    public static final int SELECT_TOP_POI__P0_INDEX__INT;
    public static final int START_POI_SEARCH;
    public static final int START_POI_SEARCH__P0_USECASE__INT;
    public static final int START_POI_SEARCH__USECASE__C0_THESAURUS_ALONG_ROUTE;
    public static final int START_POI_SEARCH__USECASE__C1_POI_STACK_FROM_MAP;
    public static final int START_POI_SEARCH__USECASE__C2_SINGLE_POI_FROM_MAP;
    public static final int START_POI_SEARCH__USECASE__C3_TOP_POI_SELECTION;
    public static final int START_POI_SEARCH__USECASE__C4_FUEL_WARNING_PETROL;
    public static final int START_POI_SEARCH__USECASE__C5_FUEL_WARNING_DIESEL;
    public static final int START_POI_SEARCH__USECASE__C6_FUEL_WARNING_CNG;
    public static final int START_POI_SEARCH__USECASE__C7_FUEL_WARNING_LPG;
    public static final int START_POI_SEARCH__USECASE__C8_BATTERY_WARNING;
}

