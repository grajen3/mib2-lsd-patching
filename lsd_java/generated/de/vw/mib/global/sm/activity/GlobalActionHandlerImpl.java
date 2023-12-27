/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.global.sm.activity;

import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.sm.internal.activity.GlobalActionHandler;
import generated.de.vw.mib.global.datapool.SkinDataPool;
import generated.de.vw.mib.global.sm.internal.activity.StatemachineHandlerBase;

public final class GlobalActionHandlerImpl
extends StatemachineHandlerBase
implements GlobalActionHandler {
    public static final int NO_ACTION_ID;
    public static final int GAC_CAR_SETUP_AMBIANCE_SETTINGS_SET_SLIDERTO_VISIBLE;
    public static final int GAC_MEDIA_SET_PROPERTIES_FOR_MEDIA_MINIPLAYERS;
    public static final int GAC_MEDIA_BROWSER_SET_ITEM_VISIBILITY_SET_PARENT_INDES_SETTINGS;
    public static final int GAC_NAV_ROUTE_CALC_RESET_PROGRESS_STATES_FOR_ALL_ROUTES;
    public static final int GAC_NAV_MAP_LAYOUT_SET_CONTENT_MAIN_MAP_OVERVIEW;
    public static final int GAC_NAV_MAP_LAYOUT_SET_CARSUR_POSITION;
    public static final int GAC_NAV_MAP_LAYOUT_CARSUR_POSITIONS_25D3DHEADING;
    public static final int GAC_NAV_MAP_LAYOUT_CARSUR_POSITIONS_2D_NORTH;
    public static final int GAC_NAV_MAP_LAYOUT_CARSUR_POSITIONS_2D_HEADING;
    public static final int GAC_NAV_MAP_LAYOUT_CONTENT_MAIN_MAP_OVERVIEW_NO_SS;
    public static final int GAC_NAV_MAP_LAYOUT_CONTENT_MAIN_MAP_OVERVIEW_SS;
    public static final int GAC_NAV_MAP_LAYOUT_CONTENT_MAIN_MAP_DEFAULT_NO_SS;
    public static final int GAC_NAV_MAP_LAYOUT_CONTENT_MAIN_MAP_DEFAULT_SS;
    public static final int GAC_NAV_MAP_LAYOUT_SET_CONTENT_MAIN_MAP_DEFAULT;
    public static final int GAC_NAV_MAP_LAYOUT_HOT_POINT_POSITIONS_NO_SS;
    public static final int GAC_NAV_MAP_LAYOUT_HOT_POINT_POSITIONS_SS;
    public static final int GAC_NAV_MAP_LAYOUT_HOT_POINT_POSITION_2D_NORTH;
    public static final int GAC_NAV_MAP_LAYOUT_SET_HOT_POINT_POSITION_2D_NORTH;
    public static final int GAC_NAV_MAP_LAYOUT_SET_HOT_POINT_POSITION_2D_HEADING;
    public static final int GAC_NAV_MAP_LAYOUT_HOT_POINT_POSITION_2D_HEADING;
    public static final int GAC_NAV_MAP_LAYOUT_SET_HOT_POINT_POSITION;
    public static final int GAC_NAV_MAP_LAYOUT_SET_HOT_POINT_POSITION_25D_HEADING;
    public static final int GAC_NAV_MAP_LAYOUT_HOT_POINT_POSITION_25D_HEADING;
    public static final int GAC_NAV_MAP_LAYOUT_SET_CARSUR_POSITION_2D_NORTH;
    public static final int GAC_NAV_MAP_LAYOUT_SET_HOT_POINT_POSITION_NO_SS;
    public static final int GAC_NAV_MAP_LAYOUT_SET_HOT_POINT_POSITION_SS;
    public static final int GAC_NAV_MAP_LAYOUT_CARSUR_POSITIONS_NO_SS;
    public static final int GAC_NAV_MAP_LAYOUT_CARSUR_POSITIONS_SS;
    public static final int GAC_NAV_MAP_LAYOUT_SET_CARSUR_POSITION_2D_HEADING;
    public static final int GAC_NAV_MAIN_MAP_MACRO_PUSH_UP_VIEW_2D;
    public static final int GAC_NAV_MAIN_MAP_MACRO_BTN_HEADING;
    public static final int GAC_NAV_MAIN_MAP_MACRO_BTN_CCP;
    public static final int GAC_NAV_MAIN_MAP_MACRO_BTN_ROCKET;
    public static final int GAC_NAV_MAP_LAYOUT_SET_PERSPECTIVE;
    public static final int GAC_NAV_MAP_LAYOUT_SET_CONTENT_MAIN_MAP_RANGEVIEW;
    public static final int GAC_NAV_MAP_LAYOUT_SET_CARSUR_POSITION_25D3D_HEADING;
    public static final int GAC_NAV_MAP_LAYOUT_SET_CONTENT_MAIN_MAP_RESTORE_NO_SS;
    public static final int GAC_NAV_MAP_LAYOUT_CONTENT_MAIN_MAP_RANGEVIEW_NO_SS;
    public static final int GAC_NAV_MAP_LAYOUT_CONTENT_MAIN_MAP_RANGEVIEW_SS;
    public static final int GAC_NAV_MAP_LAYOUT_SET_CONTENT_MAIN_MAP_RESTORE_SS;
    public static final int GAC_NAV_MAP_LAYOUT_HOT_POINT_POSITION_RANGE_VIEW;
    public static final int GAC_NAV_MAP_LAYOUT_SET_HOT_POINT_POSITION_WITH_RANGE_VIEW;
    public static final int GAC_NAV_MAP_LAYOUT_HOT_POINT_POSITION_RANGE_VIEW_NO_SS;
    public static final int GAC_NAV_MAP_LAYOUT_HOT_POINT_POSITION_RANGE_VIEW_SS;
    public static final int GAC_NAV_MAP_LAYOUT_SAVE_MAIN_MAP_SETTINGS_TO_MODEL;
    public static final int GAC_NAV_MAP_LAYOUT_RESTORE_MAIN_MAP_SETTINGS_FROM_MODEL;
    public static final int GAC_NAV_MAP_LAYOUT_HOT_POINT_POSITIONS_GUIDANCE_NO_SS;
    public static final int GAC_NAV_MAP_LAYOUT_HOT_POINT_POSITIONS_NO_GUIDANCE_NO_SS;
    public static final int GAC_NAV_MAP_LAYOUT_HOT_POINT_POSITIONS_NO_GUIDANCE_SS;
    public static final int GAC_NAV_MAP_LAYOUT_HOT_POINT_POSITIONS_GUIDANCE_SS;
    public static final int GAC_NAV_MAP_VISIBILITY_SHOW_MAP_IN_ABTTEMPORARILY;
    public static final int GAC_NAV_MAP_VISIBILITY_SWITCH_MAP_BACK_TO_COMBI;
    public static final int GAC_NAV_MAP_VISIBILITY_LEAVE_MAP_VIEW_TO_NAV_MAIN_DUE_TO_MAP_IN_FPK;
    public static final int GAC_NAV_REENTER_DEST_INPUT_FOR_VICINITY;
    public static final int GAC_NAV_NEW_DEST_DETAIL_BROWSER_PARAMS;
    public static final int GAC_NAV_POI_INITSEARCHAREA_SET_PARAM_TO_LAST;
    public static final int GAC_NAV_POI_ONLINESERVICES_INITSEARCHAREA_SET_PARAM_TO_LAST;
    public static final int GAC_SOUND_ICC_HANDLING_ACTIVATE;
    public static final int GAC_SOUND_ICC_HANDLING_DEACTIVATE;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$generated$de$vw$mib$global$sm$activity$GlobalActionHandlerImpl;

    @Override
    public void handleGlobalAction(int n) {
        switch (n) {
            case 1: {
                this.setBoolean(30716, false);
                this.setBoolean(24958, true);
                break;
            }
            case 2: {
                this.setString(-842465280, this.getLicValue(58, 1, 0, ""));
                if (!this.evalBoolean(73)) {
                    if (this.getLicValue(58, 1, 0, "").equals("filterCriteria.artists")) {
                        this.setString(-842465280, this.getI18nString(2227));
                    }
                    if (this.getLicValue(58, 1, 0, "").equals("filterCriteria.unknownArtist")) {
                        this.setString(-842465280, this.getI18nString(2230));
                    }
                    if (this.getLicValue(58, 1, 0, "").equals("filterCriteria.unknownArtists")) {
                        this.setString(-842465280, this.getI18nString(2231));
                    }
                    if (this.getLicValue(58, 1, 0, "").equals("filterCriteria.variousArtists")) {
                        this.setString(-842465280, this.getI18nString(2232));
                    }
                }
                if (this.evalBoolean(73)) {
                    this.setString(-842465280, this.getString(395640832));
                }
                this.setString(-2071330816, this.getLicValue(58, 0, 0, ""));
                if (!this.evalBoolean(73)) {
                    if (this.getLicValue(58, 0, 0, "").equals("filterCriteria.albums")) {
                        this.setString(-2071330816, this.getI18nString(2226));
                    }
                    if (this.getLicValue(58, 0, 0, "").equals("filterCriteria.unknownAlbum")) {
                        this.setString(-2071330816, this.getI18nString(2228));
                    }
                    if (this.getLicValue(58, 0, 0, "").equals("filterCriteria.unknownAlbums")) {
                        this.setString(-2071330816, this.getI18nString(2229));
                    }
                }
                if (this.evalBoolean(73)) {
                    this.setString(-2071330816, "");
                }
                if (this.evalBoolean(71)) {
                    this.setBoolean(26774, true);
                    this.setBoolean(1847329024, false);
                }
                if (this.evalBoolean(71)) break;
                this.setBoolean(1847329024, true);
                this.setBoolean(26774, false);
                break;
            }
            case 3: {
                if (this.getInteger(-787939072) == 0) {
                    this.setBoolean(1173749760, true);
                }
                if (this.getInteger(-787939072) != 0) {
                    this.setBoolean(1173749760, false);
                }
                if (this.getInteger(-787939072) == 2) {
                    this.setBoolean(0xCBB0000, true);
                }
                if (this.getInteger(-787939072) != 2) {
                    this.setBoolean(0xCBB0000, false);
                }
                if (this.getInteger(-787939072) == 3) {
                    this.setBoolean(1678049536, true);
                }
                if (this.getInteger(-787939072) != 3) {
                    this.setBoolean(1678049536, false);
                }
                if (this.getInteger(-787939072) == 1) {
                    this.setBoolean(32244, true);
                }
                if (this.getInteger(-787939072) != 1) {
                    this.setBoolean(32244, false);
                }
                if (this.getBoolean(535101440) && this.getInteger(-787939072) == 0) {
                    this.setInteger(-976289792, this.getInteger(29914));
                }
                if (this.getInteger(-787939072) != 2 && this.getInteger(-787939072) != 3 && this.getInteger(-787939072) != 0) break;
                this.setBoolean(535101440, false);
                break;
            }
            case 4: {
                this.setInteger(732758016, 0);
                this.setInteger(-920256256, 0);
                this.setInteger(970588160, 0);
                break;
            }
            case 5: {
                this.setInteger(-740032512, 0);
                this.handleGlobalAction(10);
                if (this.evalBoolean(25)) {
                    this.handleGlobalAction(11);
                }
                EventGeneric eventGeneric = GlobalActionHandlerImpl.newEvent();
                eventGeneric.setInt(0, this.getInteger(-740032512));
                eventGeneric.setInt(1, this.getInteger(2028666880));
                eventGeneric.setInt(2, this.getInteger(2011889664));
                eventGeneric.setInt(3, this.getInteger(28460));
                eventGeneric.setInt(4, this.getInteger(69599488));
                this.triggerObserver(771883072, eventGeneric);
                break;
            }
            case 6: {
                this.handleGlobalAction(8);
                if (this.getInteger(-1765670912) == 1) {
                    this.handleGlobalAction(9);
                }
                if (this.getInteger(-1765670912) > 1) {
                    this.handleGlobalAction(7);
                }
                EventGeneric eventGeneric = GlobalActionHandlerImpl.newEvent();
                eventGeneric.setInt(0, this.getInteger(-993067008));
                eventGeneric.setInt(1, this.getInteger(-1026621440));
                this.triggerObserver(1325531200, eventGeneric);
                break;
            }
            case 7: {
                this.setInteger(-993067008, SkinDataPool.getInteger(95));
                this.setInteger(-1026621440, SkinDataPool.getInteger(96));
                if (this.evalBoolean(25)) {
                    this.setInteger(-993067008, SkinDataPool.getInteger(97));
                }
                if (!this.evalBoolean(25)) break;
                this.setInteger(-1026621440, SkinDataPool.getInteger(98));
                break;
            }
            case 8: {
                this.setInteger(-993067008, SkinDataPool.getInteger(103));
                this.setInteger(-1026621440, SkinDataPool.getInteger(104));
                if (this.evalBoolean(25)) {
                    this.setInteger(-993067008, SkinDataPool.getInteger(105));
                }
                if (!this.evalBoolean(25)) break;
                this.setInteger(-1026621440, SkinDataPool.getInteger(106));
                break;
            }
            case 9: {
                this.setInteger(-993067008, SkinDataPool.getInteger(99));
                this.setInteger(-1026621440, SkinDataPool.getInteger(100));
                if (this.evalBoolean(25)) {
                    this.setInteger(-993067008, SkinDataPool.getInteger(101));
                }
                if (!this.evalBoolean(25)) break;
                this.setInteger(-1026621440, SkinDataPool.getInteger(102));
                break;
            }
            case 10: {
                this.setInteger(2028666880, SkinDataPool.getInteger(71));
                this.setInteger(2011889664, SkinDataPool.getInteger(72));
                this.setInteger(28460, SkinDataPool.getInteger(69));
                this.setInteger(69599488, SkinDataPool.getInteger(70));
                break;
            }
            case 11: {
                this.setInteger(2028666880, SkinDataPool.getInteger(75));
                this.setInteger(2011889664, SkinDataPool.getInteger(76));
                this.setInteger(28460, SkinDataPool.getInteger(73));
                this.setInteger(69599488, SkinDataPool.getInteger(74));
                break;
            }
            case 12: {
                this.setInteger(2028666880, 0);
                this.setInteger(2011889664, SkinDataPool.getInteger(64));
                this.setInteger(28460, SkinDataPool.getInteger(63));
                this.setInteger(69599488, SkinDataPool.getInteger(62));
                break;
            }
            case 13: {
                this.setInteger(2028666880, SkinDataPool.getInteger(86));
                this.setInteger(2011889664, SkinDataPool.getInteger(64));
                this.setInteger(69599488, SkinDataPool.getInteger(85));
                this.setInteger(28460, SkinDataPool.getInteger(63));
                break;
            }
            case 14: {
                this.setInteger(-740032512, 0);
                this.handleGlobalAction(12);
                if (this.evalBoolean(25)) {
                    this.handleGlobalAction(13);
                }
                if (this.getInteger(-1765670912) == 2 || this.getInteger(-1765670912) == 3 || this.getInteger(-1765670912) == 4) {
                    this.setInteger(28460, SkinDataPool.getInteger(57));
                }
                EventGeneric eventGeneric = GlobalActionHandlerImpl.newEvent();
                eventGeneric.setInt(0, this.getInteger(-740032512));
                eventGeneric.setInt(1, this.getInteger(2028666880));
                eventGeneric.setInt(2, this.getInteger(2011889664));
                eventGeneric.setInt(3, this.getInteger(28460));
                eventGeneric.setInt(4, this.getInteger(69599488));
                this.triggerObserver(771883072, eventGeneric);
                break;
            }
            case 15: {
                this.handleGlobalAction(48);
                if (this.getInteger(388038912) != 1) break;
                this.handleGlobalAction(47);
                break;
            }
            case 16: {
                this.handleGlobalAction(49);
                if (this.getInteger(388038912) != 1) break;
                this.handleGlobalAction(50);
                break;
            }
            case 17: {
                this.setInteger(21308, SkinDataPool.getInteger(103));
                this.setInteger(21307, SkinDataPool.getInteger(104));
                if (this.evalBoolean(25)) {
                    this.setInteger(21308, SkinDataPool.getInteger(105));
                }
                if (!this.evalBoolean(25)) break;
                this.setInteger(21307, SkinDataPool.getInteger(106));
                break;
            }
            case 18: {
                this.handleGlobalAction(17);
                EventGeneric eventGeneric = GlobalActionHandlerImpl.newEvent();
                eventGeneric.setInt(0, this.getInteger(21308));
                eventGeneric.setInt(1, this.getInteger(21307));
                this.triggerObserver(420151360, eventGeneric);
                break;
            }
            case 19: {
                this.handleGlobalAction(20);
                EventGeneric eventGeneric = GlobalActionHandlerImpl.newEvent();
                eventGeneric.setInt(0, this.getInteger(21308));
                eventGeneric.setInt(1, this.getInteger(21307));
                this.triggerObserver(420151360, eventGeneric);
                break;
            }
            case 20: {
                this.setInteger(21308, SkinDataPool.getInteger(99));
                this.setInteger(21307, SkinDataPool.getInteger(100));
                if (this.evalBoolean(25)) {
                    this.setInteger(21308, SkinDataPool.getInteger(101));
                }
                if (!this.evalBoolean(25)) break;
                this.setInteger(21307, SkinDataPool.getInteger(102));
                break;
            }
            case 21: {
                if (!this.evalBoolean(25)) {
                    this.handleGlobalAction(15);
                }
                if (this.evalBoolean(25)) {
                    this.handleGlobalAction(16);
                }
                EventGeneric eventGeneric = GlobalActionHandlerImpl.newEvent();
                eventGeneric.setInt(0, this.getInteger(21308));
                eventGeneric.setInt(1, this.getInteger(21307));
                this.triggerObserver(420151360, eventGeneric);
                break;
            }
            case 22: {
                this.handleGlobalAction(23);
                EventGeneric eventGeneric = GlobalActionHandlerImpl.newEvent();
                eventGeneric.setInt(0, this.getInteger(21308));
                eventGeneric.setInt(1, this.getInteger(21307));
                this.triggerObserver(420151360, eventGeneric);
                break;
            }
            case 23: {
                this.setInteger(21308, SkinDataPool.getInteger(95));
                this.setInteger(21307, SkinDataPool.getInteger(96));
                if (this.evalBoolean(25)) {
                    this.setInteger(21308, SkinDataPool.getInteger(97));
                }
                if (!this.evalBoolean(25)) break;
                this.setInteger(21307, SkinDataPool.getInteger(98));
                break;
            }
            case 24: {
                this.handleGlobalAction(8);
                EventGeneric eventGeneric = GlobalActionHandlerImpl.newEvent();
                eventGeneric.setInt(0, this.getInteger(-993067008));
                eventGeneric.setInt(1, this.getInteger(-1026621440));
                this.triggerObserver(1325531200, eventGeneric);
                break;
            }
            case 25: {
                this.handleGlobalAction(15);
                if (this.getBoolean(-1902575616)) {
                    this.handleGlobalAction(43);
                }
                EventGeneric eventGeneric = GlobalActionHandlerImpl.newEvent();
                eventGeneric.setInt(0, this.getInteger(21308));
                eventGeneric.setInt(1, this.getInteger(21307));
                this.triggerObserver(420151360, eventGeneric);
                break;
            }
            case 26: {
                this.handleGlobalAction(16);
                if (this.getBoolean(-1902575616)) {
                    this.handleGlobalAction(44);
                }
                EventGeneric eventGeneric = GlobalActionHandlerImpl.newEvent();
                eventGeneric.setInt(0, this.getInteger(21308));
                eventGeneric.setInt(1, this.getInteger(21307));
                this.triggerObserver(420151360, eventGeneric);
                break;
            }
            case 27: {
                this.setInteger(-993067008, SkinDataPool.getInteger(103));
                this.setInteger(-1026621440, SkinDataPool.getInteger(104));
                if (this.getInteger(-1765670912) == 1) {
                    this.setInteger(-993067008, SkinDataPool.getInteger(99));
                }
                if (this.getInteger(-1765670912) == 1) {
                    this.setInteger(-1026621440, SkinDataPool.getInteger(100));
                }
                if (this.getInteger(-1765670912) > 1) {
                    this.setInteger(-993067008, SkinDataPool.getInteger(95));
                }
                if (this.getInteger(-1765670912) <= 1) break;
                this.setInteger(-1026621440, SkinDataPool.getInteger(96));
                break;
            }
            case 28: {
                this.setInteger(-993067008, SkinDataPool.getInteger(105));
                this.setInteger(-1026621440, SkinDataPool.getInteger(106));
                if (this.getInteger(-1765670912) == 1) {
                    this.setInteger(-993067008, SkinDataPool.getInteger(101));
                }
                if (this.getInteger(-1765670912) == 1) {
                    this.setInteger(-1026621440, SkinDataPool.getInteger(102));
                }
                if (this.getInteger(-1765670912) > 1) {
                    this.setInteger(-993067008, SkinDataPool.getInteger(97));
                }
                if (this.getInteger(-1765670912) <= 1) break;
                this.setInteger(-1026621440, SkinDataPool.getInteger(98));
                break;
            }
            case 29: {
                this.handleGlobalAction(9);
                EventGeneric eventGeneric = GlobalActionHandlerImpl.newEvent();
                eventGeneric.setInt(0, this.getInteger(-993067008));
                eventGeneric.setInt(1, this.getInteger(-1026621440));
                this.triggerObserver(1325531200, eventGeneric);
                break;
            }
            case 30: {
                EventGeneric eventGeneric;
                this.setBoolean(-268697600, false);
                if (this.getBoolean(-1902575616)) {
                    eventGeneric = GlobalActionHandlerImpl.newEvent();
                    eventGeneric.setBoolean(0, this.getBoolean(-268697600));
                    this.triggerObserver(201982016, eventGeneric);
                }
                this.handleGlobalAction(14);
                this.handleGlobalAction(8);
                if (this.getInteger(298385408) == 1 && (this.getInteger(14126) < 10000 || this.getBoolean(10154) || this.getBoolean(-1902575616))) {
                    this.handleGlobalAction(9);
                }
                eventGeneric = GlobalActionHandlerImpl.newEvent();
                eventGeneric.setInt(0, this.getInteger(-993067008));
                eventGeneric.setInt(1, this.getInteger(-1026621440));
                this.triggerObserver(1325531200, eventGeneric);
                this.handleGlobalAction(17);
                if (this.getInteger(298385408) == 1 && (this.getInteger(14126) < 10000 || this.getBoolean(10154) || this.getBoolean(-1902575616))) {
                    this.handleGlobalAction(20);
                }
                eventGeneric = GlobalActionHandlerImpl.newEvent();
                eventGeneric.setInt(0, this.getInteger(21308));
                eventGeneric.setInt(1, this.getInteger(21307));
                this.triggerObserver(420151360, eventGeneric);
                this.setInteger(-1259470848, 0);
                if (this.getInteger(298385408) == 1 && (this.getInteger(14126) < 10000 || this.getBoolean(10154) || this.getBoolean(-1902575616))) {
                    this.setInteger(-1259470848, 1);
                }
                if (this.getInteger(298385408) == 1 && !this.getBoolean(10154) && this.getInteger(14126) >= 10000 && !this.getBoolean(-1902575616)) {
                    this.setBoolean(548208640, true);
                }
                if (!this.getBoolean(-1098448896) || this.getBoolean(10154) || this.getBoolean(1944846336) || this.getBoolean(-1902575616)) {
                    this.triggerObserver(1224867904);
                }
                if (this.getBoolean(-1098448896) && !this.getBoolean(10154) && !this.getBoolean(1944846336) && !this.getBoolean(-1902575616)) {
                    this.triggerObserver(1191313472);
                }
                eventGeneric = GlobalActionHandlerImpl.newEvent();
                eventGeneric.setInt(0, this.getInteger(-1259470848));
                this.triggerObserver(822214720, eventGeneric);
                this.setInteger(298385408, this.getInteger(-1259470848));
                break;
            }
            case 31: {
                EventGeneric eventGeneric;
                this.handleGlobalAction(8);
                if (this.getInteger(-1765670912) == 0) {
                    this.handleGlobalAction(9);
                }
                if (!this.getBoolean(-1098448896)) {
                    eventGeneric = GlobalActionHandlerImpl.newEvent();
                    eventGeneric.setInt(0, this.getInteger(-993067008));
                    eventGeneric.setInt(1, this.getInteger(-1026621440));
                    this.triggerObserver(1325531200, eventGeneric);
                }
                this.handleGlobalAction(17);
                if (this.getInteger(-1765670912) == 0) {
                    this.handleGlobalAction(20);
                }
                if (!this.getBoolean(-1098448896)) {
                    eventGeneric = GlobalActionHandlerImpl.newEvent();
                    eventGeneric.setInt(0, this.getInteger(21308));
                    eventGeneric.setInt(1, this.getInteger(21307));
                    this.triggerObserver(420151360, eventGeneric);
                }
                this.setInteger(298385408, this.getInteger(-1765670912));
                this.setInteger(-1259470848, 0);
                if (this.getInteger(298385408) == 0) {
                    this.setInteger(-1259470848, 1);
                }
                if (!this.getBoolean(-1098448896) || this.getBoolean(10154) || this.getBoolean(1944846336) || this.getBoolean(-1902575616)) {
                    this.triggerObserver(1224867904);
                }
                if (this.getBoolean(-1098448896)) {
                    this.triggerObserver(1191313472);
                }
                eventGeneric = GlobalActionHandlerImpl.newEvent();
                eventGeneric.setInt(0, this.getInteger(-1259470848));
                this.triggerObserver(822214720, eventGeneric);
                this.setInteger(298385408, this.getInteger(-1259470848));
                break;
            }
            case 32: {
                this.handleGlobalAction(6);
                this.handleGlobalAction(21);
                this.setInteger(-1259470848, 0);
                if (this.getInteger(-1765670912) == 1) {
                    this.setInteger(-1259470848, 1);
                }
                if (this.getInteger(-1765670912) == 2) {
                    this.setInteger(-1259470848, 2);
                }
                if (this.getInteger(-1765670912) == 3) {
                    this.setInteger(-1259470848, 3);
                }
                if (this.getInteger(-1765670912) == 4) {
                    this.setInteger(-1259470848, 4);
                }
                EventGeneric eventGeneric = GlobalActionHandlerImpl.newEvent();
                eventGeneric.setInt(0, this.getInteger(-1259470848));
                this.triggerObserver(822214720, eventGeneric);
                this.triggerObserver(1224867904);
                break;
            }
            case 33: {
                this.triggerObserver(1375862848);
                break;
            }
            case 34: {
                this.setInteger(-1259470848, 0);
                if (this.getInteger(-1765670912) == 1) {
                    this.setInteger(-1259470848, 1);
                }
                if (this.getInteger(-1765670912) == 2) {
                    this.setInteger(-1259470848, 2);
                }
                if (this.getInteger(-1765670912) == 3) {
                    this.setInteger(-1259470848, 3);
                }
                if (this.getInteger(-1765670912) == 4) {
                    this.setInteger(-1259470848, 4);
                }
                EventGeneric eventGeneric = GlobalActionHandlerImpl.newEvent();
                eventGeneric.setInt(0, this.getInteger(-1259470848));
                this.triggerObserver(822214720, eventGeneric);
                break;
            }
            case 35: {
                this.setInteger(-740032512, 0);
                this.handleGlobalAction(38);
                if (this.evalBoolean(25)) {
                    this.handleGlobalAction(39);
                }
                EventGeneric eventGeneric = GlobalActionHandlerImpl.newEvent();
                eventGeneric.setInt(0, this.getInteger(-740032512));
                eventGeneric.setInt(1, this.getInteger(2028666880));
                eventGeneric.setInt(2, this.getInteger(2011889664));
                eventGeneric.setInt(3, this.getInteger(28460));
                eventGeneric.setInt(4, this.getInteger(69599488));
                this.triggerObserver(771883072, eventGeneric);
                break;
            }
            case 36: {
                this.handleGlobalAction(7);
                EventGeneric eventGeneric = GlobalActionHandlerImpl.newEvent();
                eventGeneric.setInt(0, this.getInteger(-993067008));
                eventGeneric.setInt(1, this.getInteger(-1026621440));
                this.triggerObserver(1325531200, eventGeneric);
                break;
            }
            case 37: {
                this.setInteger(-740032512, 0);
                this.handleGlobalAction(12);
                if (this.getInteger(-1765670912) == 2 || this.getInteger(-1765670912) == 3 || this.getInteger(-1765670912) == 4) {
                    this.setInteger(28460, SkinDataPool.getInteger(57));
                }
                if (this.getBoolean(10154) && this.getInteger(388038912) == 1) {
                    this.handleGlobalAction(10);
                }
                if (this.getBoolean(-1902575616)) {
                    this.handleGlobalAction(38);
                }
                EventGeneric eventGeneric = GlobalActionHandlerImpl.newEvent();
                eventGeneric.setInt(0, this.getInteger(-740032512));
                eventGeneric.setInt(1, this.getInteger(2028666880));
                eventGeneric.setInt(2, this.getInteger(2011889664));
                eventGeneric.setInt(3, this.getInteger(28460));
                eventGeneric.setInt(4, this.getInteger(69599488));
                this.triggerObserver(771883072, eventGeneric);
                break;
            }
            case 38: {
                this.setInteger(2028666880, SkinDataPool.getInteger(83));
                this.setInteger(2011889664, SkinDataPool.getInteger(84));
                this.setInteger(28460, SkinDataPool.getInteger(81));
                this.setInteger(69599488, SkinDataPool.getInteger(82));
                if (!this.getBoolean(471990528)) {
                    this.setInteger(2028666880, SkinDataPool.getInteger(67));
                }
                if (!this.getBoolean(471990528)) {
                    this.setInteger(2011889664, SkinDataPool.getInteger(68));
                }
                if (!this.getBoolean(471990528)) {
                    this.setInteger(28460, SkinDataPool.getInteger(65));
                }
                if (this.getBoolean(471990528)) break;
                this.setInteger(69599488, SkinDataPool.getInteger(66));
                break;
            }
            case 39: {
                this.setInteger(2028666880, SkinDataPool.getInteger(93));
                this.setInteger(2011889664, SkinDataPool.getInteger(94));
                this.setInteger(28460, SkinDataPool.getInteger(91));
                this.setInteger(69599488, SkinDataPool.getInteger(92));
                if (!this.getBoolean(471990528)) {
                    this.setInteger(2028666880, SkinDataPool.getInteger(89));
                }
                if (!this.getBoolean(471990528)) {
                    this.setInteger(2011889664, SkinDataPool.getInteger(90));
                }
                if (!this.getBoolean(471990528)) {
                    this.setInteger(28460, SkinDataPool.getInteger(87));
                }
                if (this.getBoolean(471990528)) break;
                this.setInteger(69599488, SkinDataPool.getInteger(88));
                break;
            }
            case 40: {
                this.setInteger(-740032512, 0);
                this.handleGlobalAction(13);
                if (this.getInteger(-1765670912) == 2 || this.getInteger(-1765670912) == 3 || this.getInteger(-1765670912) == 4) {
                    this.setInteger(28460, SkinDataPool.getInteger(57));
                }
                if (this.getBoolean(10154) && this.getInteger(388038912) == 1) {
                    this.handleGlobalAction(11);
                }
                if (this.getBoolean(-1902575616)) {
                    this.handleGlobalAction(39);
                }
                EventGeneric eventGeneric = GlobalActionHandlerImpl.newEvent();
                eventGeneric.setInt(0, this.getInteger(-740032512));
                eventGeneric.setInt(1, this.getInteger(2028666880));
                eventGeneric.setInt(2, this.getInteger(2011889664));
                eventGeneric.setInt(3, this.getInteger(28460));
                eventGeneric.setInt(4, this.getInteger(69599488));
                this.triggerObserver(771883072, eventGeneric);
                break;
            }
            case 41: {
                this.setInteger(21308, SkinDataPool.getInteger(107));
                this.setInteger(21307, SkinDataPool.getInteger(108));
                if (this.evalBoolean(25)) {
                    this.setInteger(21308, SkinDataPool.getInteger(115));
                }
                if (!this.evalBoolean(25)) break;
                this.setInteger(21307, SkinDataPool.getInteger(116));
                break;
            }
            case 42: {
                if (!this.evalBoolean(25)) {
                    this.handleGlobalAction(15);
                }
                if (this.evalBoolean(25)) {
                    this.handleGlobalAction(16);
                }
                if (this.getBoolean(-1902575616) || this.getBoolean(-218824704)) {
                    this.handleGlobalAction(41);
                }
                EventGeneric eventGeneric = GlobalActionHandlerImpl.newEvent();
                eventGeneric.setInt(0, this.getInteger(21308));
                eventGeneric.setInt(1, this.getInteger(21307));
                this.triggerObserver(420151360, eventGeneric);
                break;
            }
            case 43: {
                this.setInteger(21308, SkinDataPool.getInteger(107));
                this.setInteger(21307, SkinDataPool.getInteger(108));
                break;
            }
            case 44: {
                this.setInteger(21308, SkinDataPool.getInteger(115));
                this.setInteger(21307, SkinDataPool.getInteger(116));
                break;
            }
            case 45: {
                this.setBoolean(-218824704, false);
                if (this.getBoolean(-1902575616)) {
                    this.setBoolean(-218824704, true);
                }
                this.setBoolean(520683776, false);
                if (this.getBoolean(1974468608) || this.getBoolean(1501626368)) {
                    this.setBoolean(520683776, true);
                }
                this.setBoolean(638779648, false);
                if (this.getBoolean(-1098448896)) {
                    this.setBoolean(638779648, true);
                }
                this.setInteger(1889599488, this.getInteger(-1765670912));
                break;
            }
            case 46: {
                EventGeneric eventGeneric;
                if (!this.getBoolean(-218824704)) {
                    this.setInteger(-740032512, 0);
                    this.handleGlobalAction(12);
                    if (this.getBoolean(520683776)) {
                        this.handleGlobalAction(13);
                    }
                    if (this.getInteger(1889599488) != 0 && this.getInteger(1889599488) != 1 && this.getInteger(1889599488) != 2) {
                        this.setInteger(28460, SkinDataPool.getInteger(57));
                    }
                    eventGeneric = GlobalActionHandlerImpl.newEvent();
                    eventGeneric.setInt(0, this.getInteger(-740032512));
                    eventGeneric.setInt(1, this.getInteger(2028666880));
                    eventGeneric.setInt(2, this.getInteger(2011889664));
                    eventGeneric.setInt(3, this.getInteger(28460));
                    eventGeneric.setInt(4, this.getInteger(69599488));
                    this.triggerObserver(771883072, eventGeneric);
                }
                if (this.getBoolean(-218824704)) {
                    this.handleGlobalAction(35);
                }
                if (!this.getBoolean(638779648) && !this.getBoolean(-218824704)) {
                    this.setInteger(-993067008, SkinDataPool.getInteger(103));
                    this.setInteger(-1026621440, SkinDataPool.getInteger(104));
                    if (this.getBoolean(520683776)) {
                        this.setInteger(-993067008, SkinDataPool.getInteger(105));
                    }
                    if (this.getBoolean(520683776)) {
                        this.setInteger(-1026621440, SkinDataPool.getInteger(106));
                    }
                    if (this.getInteger(1889599488) == 1) {
                        this.setInteger(-993067008, SkinDataPool.getInteger(99));
                        this.setInteger(-1026621440, SkinDataPool.getInteger(100));
                        if (this.getBoolean(520683776)) {
                            this.setInteger(-993067008, SkinDataPool.getInteger(101));
                        }
                        if (this.getBoolean(520683776)) {
                            this.setInteger(-1026621440, SkinDataPool.getInteger(102));
                        }
                    }
                    if (this.getInteger(1889599488) > 1) {
                        this.setInteger(-993067008, SkinDataPool.getInteger(95));
                        this.setInteger(-1026621440, SkinDataPool.getInteger(96));
                        if (this.getBoolean(520683776)) {
                            this.setInteger(-993067008, SkinDataPool.getInteger(97));
                        }
                        if (this.getBoolean(520683776)) {
                            this.setInteger(-1026621440, SkinDataPool.getInteger(98));
                        }
                    }
                    eventGeneric = GlobalActionHandlerImpl.newEvent();
                    eventGeneric.setInt(0, this.getInteger(-993067008));
                    eventGeneric.setInt(1, this.getInteger(-1026621440));
                    this.triggerObserver(1325531200, eventGeneric);
                }
                this.setInteger(21308, SkinDataPool.getInteger(103));
                this.setInteger(21307, SkinDataPool.getInteger(104));
                if (this.getInteger(1889599488) == 1) {
                    this.setInteger(21308, SkinDataPool.getInteger(99));
                }
                if (this.getInteger(1889599488) == 1) {
                    this.setInteger(21307, SkinDataPool.getInteger(100));
                }
                if (this.getInteger(1889599488) > 1) {
                    this.setInteger(21308, SkinDataPool.getInteger(95));
                }
                if (this.getInteger(1889599488) > 1) {
                    this.setInteger(21307, SkinDataPool.getInteger(96));
                }
                if (this.getBoolean(520683776)) {
                    this.setInteger(21308, SkinDataPool.getInteger(105));
                    this.setInteger(21307, SkinDataPool.getInteger(106));
                    if (this.getInteger(1889599488) == 1) {
                        this.setInteger(21308, SkinDataPool.getInteger(101));
                    }
                    if (this.getInteger(1889599488) == 1) {
                        this.setInteger(21307, SkinDataPool.getInteger(102));
                    }
                    if (this.getInteger(1889599488) > 1) {
                        this.setInteger(21308, SkinDataPool.getInteger(97));
                    }
                    if (this.getInteger(1889599488) > 1) {
                        this.setInteger(21307, SkinDataPool.getInteger(98));
                    }
                }
                if (this.getBoolean(-218824704)) {
                    this.setInteger(21308, SkinDataPool.getInteger(107));
                    this.setInteger(21307, SkinDataPool.getInteger(108));
                    if (this.getBoolean(520683776)) {
                        this.setInteger(21308, SkinDataPool.getInteger(115));
                    }
                    if (this.getBoolean(520683776)) {
                        this.setInteger(21307, SkinDataPool.getInteger(116));
                    }
                }
                eventGeneric = GlobalActionHandlerImpl.newEvent();
                eventGeneric.setInt(0, this.getInteger(21308));
                eventGeneric.setInt(1, this.getInteger(21307));
                this.triggerObserver(420151360, eventGeneric);
                if (!this.getBoolean(-218824704)) {
                    this.setInteger(-1259470848, 0);
                    if (this.getInteger(1889599488) == 1) {
                        this.setInteger(-1259470848, 1);
                    }
                    if (this.getInteger(1889599488) == 2) {
                        this.setInteger(-1259470848, 2);
                    }
                    if (this.getInteger(1889599488) == 3) {
                        this.setInteger(-1259470848, 3);
                    }
                    if (this.getInteger(1889599488) == 4) {
                        this.setInteger(-1259470848, 4);
                    }
                    eventGeneric = GlobalActionHandlerImpl.newEvent();
                    eventGeneric.setInt(0, this.getInteger(-1259470848));
                    this.triggerObserver(822214720, eventGeneric);
                }
                if (!this.getBoolean(638779648) && !this.getBoolean(-218824704)) {
                    this.triggerObserver(1224867904);
                }
                if (!this.getBoolean(-218824704) && this.getBoolean(638779648)) {
                    this.triggerObserver(1191313472);
                }
                this.setBoolean(-268697600, true);
                if (!this.getBoolean(-218824704)) break;
                eventGeneric = GlobalActionHandlerImpl.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(-268697600));
                this.triggerObserver(201982016, eventGeneric);
                break;
            }
            case 47: {
                this.setInteger(21308, SkinDataPool.getInteger(103));
                this.setInteger(21307, SkinDataPool.getInteger(104));
                if (this.getInteger(-1765670912) == 1) {
                    this.setInteger(21308, SkinDataPool.getInteger(99));
                }
                if (this.getInteger(-1765670912) == 1) {
                    this.setInteger(21307, SkinDataPool.getInteger(100));
                }
                if (this.getInteger(-1765670912) > 1) {
                    this.setInteger(21308, SkinDataPool.getInteger(95));
                }
                if (this.getInteger(-1765670912) > 1) {
                    this.setInteger(21307, SkinDataPool.getInteger(96));
                }
                if (this.getBoolean(10154) || this.getBoolean(1944846336)) {
                    this.setInteger(21308, SkinDataPool.getInteger(103));
                }
                if (!this.getBoolean(10154) && !this.getBoolean(1944846336)) break;
                this.setInteger(21307, SkinDataPool.getInteger(104));
                break;
            }
            case 48: {
                this.setInteger(21308, SkinDataPool.getInteger(103));
                this.setInteger(21307, SkinDataPool.getInteger(104));
                if (this.getInteger(-1765670912) == 1) {
                    this.setInteger(21308, SkinDataPool.getInteger(99));
                }
                if (this.getInteger(-1765670912) == 1) {
                    this.setInteger(21307, SkinDataPool.getInteger(100));
                }
                if (this.getInteger(-1765670912) > 1) {
                    this.setInteger(21308, SkinDataPool.getInteger(95));
                }
                if (this.getInteger(-1765670912) <= 1) break;
                this.setInteger(21307, SkinDataPool.getInteger(96));
                break;
            }
            case 49: {
                this.setInteger(21308, SkinDataPool.getInteger(105));
                this.setInteger(21307, SkinDataPool.getInteger(106));
                if (this.getInteger(-1765670912) == 1) {
                    this.setInteger(21308, SkinDataPool.getInteger(101));
                }
                if (this.getInteger(-1765670912) == 1) {
                    this.setInteger(21307, SkinDataPool.getInteger(102));
                }
                if (this.getInteger(-1765670912) > 1) {
                    this.setInteger(21308, SkinDataPool.getInteger(97));
                }
                if (this.getInteger(-1765670912) <= 1) break;
                this.setInteger(21307, SkinDataPool.getInteger(98));
                break;
            }
            case 50: {
                this.setInteger(21308, SkinDataPool.getInteger(105));
                this.setInteger(21307, SkinDataPool.getInteger(106));
                if (this.getInteger(-1765670912) == 1) {
                    this.setInteger(21308, SkinDataPool.getInteger(101));
                }
                if (this.getInteger(-1765670912) == 1) {
                    this.setInteger(21307, SkinDataPool.getInteger(102));
                }
                if (this.getInteger(-1765670912) > 1) {
                    this.setInteger(21308, SkinDataPool.getInteger(97));
                }
                if (this.getInteger(-1765670912) > 1) {
                    this.setInteger(21307, SkinDataPool.getInteger(98));
                }
                if (this.getBoolean(1944846336) || this.getBoolean(10154)) {
                    this.setInteger(21308, SkinDataPool.getInteger(105));
                }
                if (!this.getBoolean(1944846336) && !this.getBoolean(10154)) break;
                this.setInteger(21307, SkinDataPool.getInteger(106));
                break;
            }
            case 51: {
                this.triggerObserver(1405685824);
                this.setBoolean(1989935104, true);
                this.setBoolean(481886208, true);
                EventGeneric eventGeneric = GlobalActionHandlerImpl.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(481886208));
                this.triggerObserver(2026442816, eventGeneric);
                break;
            }
            case 52: {
                this.triggerObserver(1405685824);
                this.setBoolean(1989935104, false);
                this.setBoolean(481886208, false);
                EventGeneric eventGeneric = GlobalActionHandlerImpl.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(481886208));
                this.triggerObserver(2026442816, eventGeneric);
                break;
            }
            case 53: {
                this.setInteger(65142784, 6);
                GlobalActionHandlerImpl.fireHMIEvent(ANY, BROADCAST, 1398836553);
                this.setBoolean(1989935104, false);
                this.setBoolean(481886208, false);
                EventGeneric eventGeneric = GlobalActionHandlerImpl.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(481886208));
                this.triggerObserver(2026442816, eventGeneric);
                break;
            }
            case 54: {
                this.setInteger(27798, 2);
                if (this.getInteger(-1576533760) == 0) {
                    this.setInteger(-1260191744, 8);
                }
                if (this.getInteger(-1576533760) == 1 && (this.getInteger(1877868544) == 0 || this.getInteger(1877868544) == 3)) {
                    this.setInteger(-1260191744, 9);
                }
                if (this.getInteger(-1576533760) == 1 && (this.getInteger(1877868544) == 1 || this.getInteger(1877868544) == 2 || this.getInteger(1877868544) == 4)) {
                    this.setInteger(-1260191744, 14);
                }
                this.setInteger(65142784, 10);
                GlobalActionHandlerImpl.fireHMIEvent(ANY, BROADCAST, 1398836553);
                break;
            }
            case 55: {
                this.setBoolean(16065, true);
                this.setInteger(1728119040, 0);
                this.setInteger(19179, 2);
                this.setInteger(-1869283328, 49);
                this.setString(-1608646400, this.getLicValue(1777340416, 6, 0, ""));
                this.setString(-1881669632, this.getLicValue(1777340416, 3, 0, ""));
                break;
            }
            case 56: {
                this.setInteger(-276365312, 0);
                break;
            }
            case 57: {
                this.setInteger(1032257536, 0);
                break;
            }
            case 58: {
                this.setBoolean(11087, true);
                this.setInteger(22221, 0);
                this.setInteger(29077, 0);
                this.setInteger(149880832, 12);
                EventGeneric eventGeneric = GlobalActionHandlerImpl.newEvent();
                eventGeneric.setInt(0, this.getInteger(149880832));
                this.triggerObserver(-352059328, eventGeneric);
                break;
            }
            case 59: {
                if (this.getInteger(22221) == -1) break;
                this.setBoolean(11087, false);
                this.setInteger(22221, -1);
                this.setInteger(29077, -1);
                this.setInteger(149880832, 0);
                EventGeneric eventGeneric = GlobalActionHandlerImpl.newEvent();
                eventGeneric.setInt(0, this.getInteger(149880832));
                this.triggerObserver(-352059328, eventGeneric);
                break;
            }
            default: {
                if (!$assertionsDisabled && n != 0) {
                    throw new AssertionError((Object)"Never call this method with an unknown id.");
                }
                break;
            }
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        $assertionsDisabled = !(class$generated$de$vw$mib$global$sm$activity$GlobalActionHandlerImpl == null ? (class$generated$de$vw$mib$global$sm$activity$GlobalActionHandlerImpl = GlobalActionHandlerImpl.class$("generated.de.vw.mib.global.sm.activity.GlobalActionHandlerImpl")) : class$generated$de$vw$mib$global$sm$activity$GlobalActionHandlerImpl).desiredAssertionStatus();
    }
}

