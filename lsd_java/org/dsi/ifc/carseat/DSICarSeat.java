/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carseat;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.carseat.MassageData;
import org.dsi.ifc.carseat.SeatAdjustment;
import org.dsi.ifc.carseat.SeatContent;
import org.dsi.ifc.carseat.SeatPneumaticContent;
import org.dsi.ifc.carseat.SeatSpecialPosition;
import org.dsi.ifc.carseat.SwitcherDataBackForward;
import org.dsi.ifc.carseat.SwitcherDataUpDown;

public interface DSICarSeat
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_SEATVIEWOPTIONS;
    public static final int ATTR_SEATRADIOKEYAUTOMATIC;
    public static final int ATTR_SEATSPECIALPOSITION;
    public static final int ATTR_SEATFRONTLEFTSTOPBUTTON;
    public static final int ATTR_SEATFRONTRIGHTSTOPBUTTON;
    public static final int ATTR_SEATCODRIVERSETTINGSFROMDRIVER;
    public static final int ATTR_SEATCODRIVERSETTINGSFROMREAR;
    public static final int ATTR_SEATMASSAGEDATA1RL;
    public static final int ATTR_SEATMASSAGEDATA1RR;
    public static final int ATTR_SEATSWITCHERDATAUP1RL;
    public static final int ATTR_SEATSWITCHERDATADOWN1RL;
    public static final int ATTR_SEATSWITCHERDATAFORWARD1RL;
    public static final int ATTR_SEATSWITCHERDATABACK1RL;
    public static final int ATTR_SEATSWITCHERDATAUP1RR;
    public static final int ATTR_SEATSWITCHERDATADOWN1RR;
    public static final int ATTR_SEATSWITCHERDATAFORWARD1RR;
    public static final int ATTR_SEATSWITCHERDATABACK1RR;
    public static final int ATTR_SEATCONTENT;
    public static final int ATTR_SEATEASYENTRYFRONTLEFT;
    public static final int ATTR_SEATEASYENTRYFRONTRIGHT;
    public static final int ATTR_SEATEASYENTRYREARLEFT;
    public static final int ATTR_SEATEASYENTRYREARRIGHT;
    public static final int ATTR_SEATPNEUMATICVIEWOPTIONS;
    public static final int ATTR_SEATPNEUMATICCODRIVERSETTINGSFROMDRIVER;
    public static final int ATTR_SEATPNEUMATICMASSAGEDATA1RL;
    public static final int ATTR_SEATPNEUMATICMASSAGEDATA1RR;
    public static final int ATTR_SEATPNEUMATICSWITCHERDATAUP1RL;
    public static final int ATTR_SEATPNEUMATICSWITCHERDATADOWN1RL;
    public static final int ATTR_SEATPNEUMATICSWITCHERDATAFORWARD1RL;
    public static final int ATTR_SEATPNEUMATICSWITCHERDATABACK1RL;
    public static final int ATTR_SEATPNEUMATICSWITCHERDATAUP1RR;
    public static final int ATTR_SEATPNEUMATICSWITCHERDATADOWN1RR;
    public static final int ATTR_SEATPNEUMATICSWITCHERDATAFORWARD1RR;
    public static final int ATTR_SEATPNEUMATICSWITCHERDATABACK1RR;
    public static final int ATTR_SEATPNEUMATICCONTENT;
    public static final int ATTR_SEATREARLEFTSTOPBUTTON;
    public static final int ATTR_SEATREARRIGHTSTOPBUTTON;
    public static final int ATTR_SEATMASSAGEDATA2RL;
    public static final int ATTR_SEATMASSAGEDATA2RR;
    public static final int ATTR_SEATSWITCHERDATAUP2RL;
    public static final int ATTR_SEATSWITCHERDATADOWN2RL;
    public static final int ATTR_SEATSWITCHERDATAFORWARD2RL;
    public static final int ATTR_SEATSWITCHERDATABACK2RL;
    public static final int ATTR_SEATSWITCHERDATAUP2RR;
    public static final int ATTR_SEATSWITCHERDATADOWN2RR;
    public static final int ATTR_SEATSWITCHERDATAFORWARD2RR;
    public static final int ATTR_SEATSWITCHERDATABACK2RR;
    public static final int ATTR_SEATADJUSTMENT1RL;
    public static final int ATTR_SEATADJUSTMENT1RR;
    public static final int ATTR_SEATADJUSTMENT2RL;
    public static final int ATTR_SEATADJUSTMENT2RR;
    public static final int ATTR_SEATSPECIALPOSITIONREARCODRIVER;
    public static final int ATTR_SEATCODRIVERSETTINGSFROMREARACTIVATION;
    public static final int ATTR_SEATRESTSEATSTATUS;
    public static final int ATTR_SEATFOLDHEADRESTREARDRIVER;
    public static final int ATTR_SEATFOLDHEADRESTREARCODRIVER;
    public static final int ATTR_SEATPREMIUMMASSAGEDATA1RL;
    public static final int ATTR_SEATPREMIUMMASSAGEDATA1RR;
    public static final int ATTR_SEATPREMIUMMASSAGEDATA2RL;
    public static final int ATTR_SEATPREMIUMMASSAGEDATA2RR;
    public static final int ATTR_SEATPREMIUMMASSAGESWITCHER1RL;
    public static final int ATTR_SEATPREMIUMMASSAGESWITCHER1RR;
    public static final int ATTR_SEATPREMIUMMASSAGESWITCHER2RL;
    public static final int ATTR_SEATPREMIUMMASSAGESWITCHER2RR;
    public static final int ATTR_SEATMASSAGESWITCHER1RL;
    public static final int ATTR_SEATMASSAGESWITCHER1RR;
    public static final int ATTR_SEATMASSAGESWITCHER2RL;
    public static final int ATTR_SEATMASSAGESWITCHER2RR;
    public static final int SEATSPECIALPOSITIONS_NONE;
    public static final int SEATSPECIALPOSITIONS_COMFORTVIEW;
    public static final int SEATSPECIALPOSITIONS_SEATSYMMETRY;
    public static final int SEATSPECIALPOSITIONS_NORMALPOSITION;
    public static final int SEATSPECIALPOSITIONS_RELAXPOSITION;
    public static final int SEATSPECIALPOSITIONS_BUSINESSPOSITION;
    public static final int MEMORYDETAIL_MEMORY_NONE;
    public static final int MEMORYDETAIL_ON_OFF_MEMORY_BLOCKED;
    public static final int MEMORYDETAIL_ON_OFF_MEMORY_NOT_BLOCKED;
    public static final int MEMORYDETAIL_SET_PRESS_PROGRAM;
    public static final int MEMORYDETAIL_SET_PRESS_ON_OFF;
    public static final int MEMORYDETAIL_PROGRAM_PRESS_ON_OFF;
    public static final int MEMORYDETAIL_PROGRAM_PRESS_SET;
    public static final int MEMORYDETAIL_PROGRAM_PRESS_PROGRAM;
    public static final int MEMORYDETAIL_RADIOKEY_PRESS_PROGRAM;
    public static final int SEATPOSITION_NO_SEAT;
    public static final int SEATPOSITION_SEAT_1RL;
    public static final int SEATPOSITION_SEAT_1RR;
    public static final int SEATPOSITION_SEAT_2RL;
    public static final int SEATPOSITION_SEAT_2RR;
    public static final int SEATPOSITION_SEAT_3RL;
    public static final int SEATPOSITION_SEAT_3RR;
    public static final int SEATCONTENT_NONE;
    public static final int SEATCONTENT_GURTHOEHE;
    public static final int SEATCONTENT_LEHNENKOPF;
    public static final int SEATCONTENT_LORDOSE;
    public static final int SEATCONTENT_SEITENWANGEN;
    public static final int SEATCONTENT_SITZTIEFE;
    public static final int SEATCONTENT_MASSAGE;
    public static final int SEATCONTENT_MEMORY;
    public static final int SEATCONTENT_LEHNENWANGEN;
    public static final int SEATCONTENT_SITZWANGEN;
    public static final int SEATCONTENT_MENU;
    public static final int SEATPNEUMATICCONTENT_NONE;
    public static final int SEATPNEUMATICCONTENT_GURTHOEHE;
    public static final int SEATPNEUMATICCONTENT_LEHNENKOPF;
    public static final int SEATPNEUMATICCONTENT_LORDOSE;
    public static final int SEATPNEUMATICCONTENT_SEITENWANGEN;
    public static final int SEATPNEUMATICCONTENT_SITZTIEFE;
    public static final int SEATPNEUMATICCONTENT_MASSAGE;
    public static final int SEATADJUSTMENTPOSITION_NONE;
    public static final int SEATADJUSTMENTPOSITION_INCREASE;
    public static final int SEATADJUSTMENTPOSITION_DECREASE;
    public static final int RESTSEATSTATUSMESSAGE_NONE;
    public static final int RESTSEATSTATUSMESSAGE_CODRIVERSEAT_AT_RESTSEAT_POSITION;
    public static final int RESTSEATSTATUSMESSAGE_DISPLAY_DOWN;
    public static final int RESTSEATSTATUSMESSAGE_DISPLAY_OR_RESTSEAT_MOVING;
    public static final int RT_SETSEATRADIOKEYAUTOMATIC;
    public static final int RT_SETSEATCODRIVERSETTINGSFROMREAR;
    public static final int RT_SETSEATCODRIVERSETTINGSFROMDRIVER;
    public static final int RT_SETSEATEASYENTRYFRONTLEFT;
    public static final int RT_SETSEATEASYENTRYFRONTRIGHT;
    public static final int RT_SETSEATEASYENTRYREARLEFT;
    public static final int RT_SETSEATEASYENTRYREARRIGHT;
    public static final int RT_SETSEATSPECIALPOSITION;
    public static final int RT_SHOWSEATPOPUP;
    public static final int RT_CANCELSEATPOPUP;
    public static final int RT_SETSEATHMIISREADY;
    public static final int RT_SHOWSEATPNEUMATICPOPUP;
    public static final int RT_CANCELSEATPNEUMATICPOPUP;
    public static final int RT_SETSEATPNEUMATICCODRIVERSETTINGSFROMDRIVER;
    public static final int RT_SETSEATSETFACTORYDEFAULT;
    public static final int RT_SETSEATPNEUMATICSETFACTORYDEFAULT;
    public static final int RT_STARTSEATMOVEREARSEATDISPLAY;
    public static final int RT_ABORTSEATMOVEREARSEATDISPLAY;
    public static final int RT_SETSEATMASSAGEDATA;
    public static final int RT_SETSEATSWITCHERDATAUP;
    public static final int RT_SETSEATSWITCHERDATADOWN;
    public static final int RT_SETSEATSWITCHERDATAFORWARD;
    public static final int RT_SETSEATSWITCHERDATABACK;
    public static final int RT_SETSEATADJUSTMENT;
    public static final int RT_SETSEATSPECIALPOSITIONREARCODRIVER;
    public static final int RT_STARTSEATDELETESPECIALPOSITION;
    public static final int RT_SETSEATCODRIVERSETTINGSFROMREARACTIVATION;
    public static final int RT_SETSEATFOLDHEADRESTREARDRIVER;
    public static final int RT_SETSEATFOLDHEADRESTREARCODRIVER;
    public static final int RT_SETSEATSTOPBUTTON;
    public static final int RT_SETSEATPREMIUMMASSAGEDATA;
    public static final int RT_SETSEATPREMIUMMASSAGESWITCHER;
    public static final int RT_SETSEATMASSAGESWITCHER;
    public static final int RP_REQUESTSEATPOPUP;
    public static final int RP_ACKNOWLEDGESEATPOPUP;
    public static final int RP_REQUESTSEATPNEUMATICPOPUP;
    public static final int RP_ACKNOWLEDGESEATPNEUMATICPOPUP;
    public static final int RP_ACKNOWLEDGESEATSETFACTORYDEFAULT;
    public static final int RP_ACKNOWLEDGESEATPNEUMATICSETFACTORYDEFAULT;
    public static final int RP_ACKNOWLEDGESEATDELETESPECIALPOSITION;
    public static final int RP_ACKNOWLEDGESEATMOVEREARSEATDISPLAY;

    default public void setSeatRadioKeyAutomatic(boolean bl) {
    }

    default public void setSeatCodriverSettingsFromRear(boolean bl) {
    }

    default public void setSeatCodriverSettingsFromDriver(boolean bl) {
    }

    default public void setSeatEasyEntryFrontLeft(boolean bl) {
    }

    default public void setSeatEasyEntryFrontRight(boolean bl) {
    }

    default public void setSeatEasyEntryRearLeft(boolean bl) {
    }

    default public void setSeatEasyEntryRearRight(boolean bl) {
    }

    default public void setSeatSpecialPosition(SeatSpecialPosition seatSpecialPosition) {
    }

    default public void setSeatSpecialPositionRearCoDriver(SeatSpecialPosition seatSpecialPosition) {
    }

    default public void showSeatPopup(SeatContent seatContent) {
    }

    default public void cancelSeatPopup(SeatContent seatContent, int n) {
    }

    default public void setSeatHMIIsReady(boolean bl) {
    }

    default public void setSeatPneumaticCodriverSettingsFromDriver(boolean bl) {
    }

    default public void showSeatPneumaticPopup(SeatPneumaticContent seatPneumaticContent) {
    }

    default public void cancelSeatPneumaticPopup(SeatPneumaticContent seatPneumaticContent, int n) {
    }

    default public void setSeatSetFactoryDefault() {
    }

    default public void setSeatPneumaticSetFactoryDefault() {
    }

    default public void startSeatMoveRearSeatDisplay() {
    }

    default public void abortSeatMoveRearSeatDisplay() {
    }

    default public void setSeatMassageData(int n, MassageData massageData) {
    }

    default public void setSeatSwitcherDataUp(int n, SwitcherDataUpDown switcherDataUpDown) {
    }

    default public void setSeatSwitcherDataDown(int n, SwitcherDataUpDown switcherDataUpDown) {
    }

    default public void setSeatSwitcherDataForward(int n, SwitcherDataBackForward switcherDataBackForward) {
    }

    default public void setSeatSwitcherDataBack(int n, SwitcherDataBackForward switcherDataBackForward) {
    }

    default public void setSeatAdjustment(int n, SeatAdjustment seatAdjustment) {
    }

    default public void startSeatDeleteSpecialPosition(boolean bl, boolean bl2) {
    }

    default public void setSeatCoDriverSettingsFromRearActivation(boolean bl) {
    }

    default public void setSeatFoldHeadRestRearDriver(boolean bl) {
    }

    default public void setSeatFoldHeadRestRearCoDriver(boolean bl) {
    }

    default public void setSeatStopButton(int n, boolean bl) {
    }

    default public void setSeatPremiumMassageData(int n, MassageData massageData) {
    }

    default public void setSeatPremiumMassageSwitcher(int n, boolean bl) {
    }

    default public void setSeatMassageSwitcher(int n, boolean bl) {
    }
}

