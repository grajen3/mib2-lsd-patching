/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.modelapi;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.modelapi.ListRowData;
import org.dsi.ifc.modelapi.NBestResultEntry;

public interface DSIModelAPI
extends DSIBase {
    public static final String VERSION;
    public static final int STATE_HMI_STATE_NAV_ENTER;
    public static final int STATE_HMI_STATE_NAV_EXIT;
    public static final int STATE_HMI_STATE_HK_RETURN;
    public static final int STATE_HMI_STATE_HK_SETUP;
    public static final int STATE_HMI_STATE_INFO_ENTER;
    public static final int STATE_HMI_STATE_INFO_EXIT;
    public static final int STATE_HMI_STATE_ANNOUNCEMENT_ENTER;
    public static final int STATE_HMI_STATE_ANNOUNCEMENT_EXIT;
    public static final int STATE_HMI_STATE_NAV_SETUP_ENTER;
    public static final int STATE_HMI_STATE_NAV_SETUP_EXIT;
    public static final int STATE_HMI_STATE_INFO_SETUP_ENTER;
    public static final int STATE_HMI_STATE_INFO_SETUP_EXIT;
    public static final int STATE_HMI_STATE_TRAFFIC_ENTER;
    public static final int STATE_HMI_STATE_TRAFFIC_EXIT;
    public static final int STATE_HMI_STATE_REMOTE_NAV_ASIA_ENTER;
    public static final int STATE_HMI_STATE_REMOTE_NAV_ASIA_EXIT;
    public static final int CONTEXTID_HMI_CONTEXT_NAVI;
    public static final int CONTEXTID_HMI_CONTEXT_INFO;
    public static final int CONTEXTID_HMI_CONTEXT_NAVI_SETUP;
    public static final int CONTEXTID_HMI_CONTEXT_INFO_SETUP;
    public static final int CONTEXTID_HMI_CONTEXT_TRAFFIC;
    public static final int CONTEXTID_HMI_CONTEXT_TEL;
    public static final int RT_POPUPREMOVED;
    public static final int RT_HMISTATE;
    public static final int RT_KEYTYPED;
    public static final int RT_INCREMENT;
    public static final int RT_DECREMENT;
    public static final int RT_TEXTCHANGED;
    public static final int RT_ITEMSELECTED;
    public static final int RT_ITEMFOCUSED;
    public static final int RT_FILLLISTBUFFERATSTART;
    public static final int RT_FILLLISTBUFFERATEND;
    public static final int RT_TEXTCHANGEDFREETEXTSPELLER;
    public static final int RT_SCREENHIDDEN;
    public static final int RT_SCREENVISIBLE;
    public static final int RT_TOUCHPADMOVEMENT;
    public static final int RT_VALIDATECHARACTERS;
    public static final int RT_TOUCHSCREENPRESSED;
    public static final int RT_TOUCHSCREENLONGPRESSED;
    public static final int RT_TOUCHSCREENMOVED;
    public static final int RT_TOUCHSCREENRELEASED;
    public static final int RT_INPUTMODECHANGED;
    public static final int RT_SDSSESSIONENDED;
    public static final int RT_SDSSESSIONSTARTED;
    public static final int RT_SDSRULEFIRED;
    public static final int RT_SDSRULEFIREDNBEST;
    public static final int RT_ITEMDRAG;
    public static final int RT_ITEMSELECTEDCOLUMN;
    public static final int RT_TOUCHSCREENZOOM;
    public static final int RT_SDSRULEFIREDONESHOT;
    public static final int RT_SDSPROMPTFINISHED;
    public static final int RT_LISTDATACHANGED;
    public static final int RT_ADDSPELLERSTROKE;
    public static final int RT_GETVALIDHANZICHARSWINDOW;
    public static final int RT_SETPOIVIEWPORTDATA;
    public static final int RT_RESPONSESTATEMACHINECONTROL;
    public static final int RP_VALIDATECHARACTERSRESULT;
    public static final int RP_GETVALIDHANZICHARSWINDOWRESULT;
    public static final int IN_SHOWSCREEN;
    public static final int IN_SHOWINFOSCREEN;
    public static final int IN_SHOWPOPUP;
    public static final int IN_REMOVEPOPUP;
    public static final int IN_SETVISIBLE;
    public static final int IN_SETLABEL;
    public static final int IN_SETMODELENABLED;
    public static final int IN_SETCHOICEVALUE;
    public static final int IN_SETTEXTFIELD;
    public static final int IN_SETRANGELIMITS;
    public static final int IN_SETRANGEVALUE;
    public static final int IN_SETTEXT;
    public static final int IN_SETMATCHSPELLERDATA;
    public static final int IN_SETMATCHCOUNT;
    public static final int IN_SETMETRICSINVALID;
    public static final int IN_SETMETRICSVALUE;
    public static final int IN_SETLISTDATA;
    public static final int IN_SETSELECTED;
    public static final int IN_SETSLIDINGLISTDATA;
    public static final int IN_FILLLISTBUFFERATSTART;
    public static final int IN_FILLLISTBUFFERATEND;
    public static final int IN_SETRGIDATA;
    public static final int IN_FILLSLIDINGLISTROW;
    public static final int IN_SWITCHCONTEXT;
    public static final int IN_SETMODELPRESSED;
    public static final int IN_SHOWSETUPSCREEN;
    public static final int IN_SHOWINFOSETUPSCREEN;
    public static final int IN_TRIGGERSDCOMPONENT;
    public static final int IN_SHOWTRAFFICSCREEN;
    public static final int IN_REMOVESINGLEPOPUP;
    public static final int IN_SETSUBLISTDATA;
    public static final int IN_SETSLIDINGSUBLISTDATA;
    public static final int IN_SETFMTTIME;
    public static final int IN_SETFMTDATE;
    public static final int IN_SETFMTRTT;
    public static final int IN_SETFMTDISTANCE;
    public static final int IN_SETFMTALTITUDE;
    public static final int IN_SETFMTRADIOFREQUENCY;
    public static final int IN_SETFMTORIENTATION;
    public static final int IN_SETFMTGEOCOORDINATESLONGITUDE;
    public static final int IN_SETFMTGEOCOORDINATESLATITUDE;
    public static final int IN_SETSLIDINGLISTSIZE;
    public static final int IN_SETDYNAMICIMAGE;
    public static final int IN_SETSDSDYNAMICVALUE;
    public static final int IN_SETSDSDYNAMICOBJECTID;
    public static final int IN_REQUESTSTATEMACHINECONTROL;
    public static final int IN_DDSHANDLED;
    public static final int IN_SETSLIDINGLISTDATAWITHINITIALCURSORPOS;

    default public void popupRemoved(int n) {
    }

    default public void hmiState(int n) {
    }

    default public void keyTyped(int n) {
    }

    default public void increment(int n, int n2) {
    }

    default public void decrement(int n, int n2) {
    }

    default public void textChanged(int n, String string, String string2) {
    }

    default public void itemSelected(int n, long l) {
    }

    default public void itemFocused(int n, long l) {
    }

    default public void itemDrag(int n, long l, long l2) {
    }

    default public void itemSelectedColumn(int n, long l, int n2) {
    }

    default public void fillListBufferAtStart(int n, long l, int n2) {
    }

    default public void fillListBufferAtEnd(int n, long l, int n2) {
    }

    default public void textChangedFreeTextSpeller(int n, String string, String string2, String string3, String string4) {
    }

    default public void screenHidden(int n) {
    }

    default public void screenVisible(int n) {
    }

    default public void touchPadMovement(int n, int n2, int n3) {
    }

    default public void validateCharacters(int n, String string) {
    }

    default public void touchScreenPressed(int n, int n2, int n3) {
    }

    default public void touchScreenLongPressed(int n, int n2) {
    }

    default public void touchScreenMoved(int n, int n2, int n3, int n4, int n5) {
    }

    default public void touchScreenReleased(int n, int n2, int n3) {
    }

    default public void touchScreenZoom(int n, int n2, int n3, int n4, int n5) {
    }

    default public void inputModeChanged(int n, int n2) {
    }

    default public void sdsSessionEnded() {
    }

    default public void sdsSessionStarted() {
    }

    default public void sdsRuleFired(int n) {
    }

    default public void sdsRuleFiredNBest(int n, NBestResultEntry nBestResultEntry) {
    }

    default public void sdsRuleFiredOneShot(int n, NBestResultEntry[] nBestResultEntryArray) {
    }

    default public void sdsPromptFinished() {
    }

    default public void listDataChanged(int n, ListRowData[] listRowDataArray) {
    }

    default public void setPOIViewPortData(int n, ListRowData[] listRowDataArray, int n2, double[] dArray) {
    }

    default public void addSpellerStroke(int n, String string, String string2) {
    }

    default public void getValidHanziCharsWindow(int n, int n2, int n3) {
    }

    default public void responseStateMachineControl() {
    }
}

