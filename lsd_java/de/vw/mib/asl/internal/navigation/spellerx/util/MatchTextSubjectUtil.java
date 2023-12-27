/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.spellerx.util;

import de.vw.mib.asl.api.navigation.NavigationConfiguration;
import de.vw.mib.asl.api.navigation.locationinput.IHnrFlags;
import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.map.MapConfiguration;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.asl.IEvents;
import de.vw.mib.asl.framework.internal.framework.util.StringUtil;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdAbstractSpeller;
import de.vw.mib.asl.internal.navigation.spellerx.SpellerContext;
import de.vw.mib.asl.internal.navigation.spellerx.XSpellerTarget;
import de.vw.mib.asl.internal.navigation.spellerx.hwr.MatchTextSpellerFilterAdapter;
import de.vw.mib.asl.internal.navigation.spellerx.model.ModelListHandler;
import de.vw.mib.asl.internal.navigation.spellerx.model.ModelUpdater;
import de.vw.mib.asl.internal.navigation.spellerx.util.GeneralSubjectUtil;
import de.vw.mib.asl.internal.navigation.spellerx.util.HnrFlagsImpl;
import de.vw.mib.genericevents.EventGeneric;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;

public class MatchTextSubjectUtil {
    public void setCharsAndCursor(XSpellerTarget xSpellerTarget, CmdAbstractSpeller cmdAbstractSpeller) {
        if (cmdAbstractSpeller.lispUpdateSpellerResult_lispValidCharacters != null) {
            xSpellerTarget.getSpellerContext().getActiveField().getSpellerData().setAvailableCharacters(cmdAbstractSpeller.lispUpdateSpellerResult_lispValidCharacters);
            MatchTextSpellerFilterAdapter.globalChars = cmdAbstractSpeller.lispUpdateSpellerResult_lispValidCharacters;
        } else {
            xSpellerTarget.getLogger().makeError().append(" Cmd valid characters is null ").log();
        }
        if (cmdAbstractSpeller.lispUpdateSpellerResult_lispCurrentInput != null) {
            xSpellerTarget.getSpellerContext().getActiveField().getSpellerData().setEnteredText(cmdAbstractSpeller.lispUpdateSpellerResult_lispCurrentInput);
        } else {
            xSpellerTarget.getLogger().makeError().append(" Cmd lispUpdateSpellerResult_lispCurrentInput is null ").log();
        }
        xSpellerTarget.getSpellerContext().getActiveField().getSpellerData().setCursorPosition(xSpellerTarget.getSpellerContext().getActiveField().getSpellerData().getEnteredText().length());
    }

    public void printTraceMessage(XSpellerTarget xSpellerTarget, String string) {
        if (xSpellerTarget.getLogger().isTraceEnabled()) {
            xSpellerTarget.getLogger().makeTrace().append(string).log();
        }
    }

    public void printWarning(XSpellerTarget xSpellerTarget, String string) {
        xSpellerTarget.getLogger().makeWarn().append(string).log();
    }

    public void printAvailableCriterions(XSpellerTarget xSpellerTarget, int[] nArray) {
        if (xSpellerTarget.getLogger().isTraceEnabled()) {
            ASLNavigationUtilFactory.getNavigationUtilApi().getExtLoggerHelper().appendCriteria(xSpellerTarget.getLogger().makeTrace().append("SPELLER> available criteria: "), nArray).log();
        }
    }

    public void updateMap(XSpellerTarget xSpellerTarget, NavLocation navLocation) {
        xSpellerTarget.getLogger().makeError().append("MatchTextSubjectUtil.updateMap() called with location: ").append(navLocation);
        MapConfiguration mapConfiguration = new MapConfiguration(navLocation, 25, 0);
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainContentGotoLocation(3, mapConfiguration);
    }

    public void updateMapHKNav(XSpellerTarget xSpellerTarget, NavLocation navLocation) {
        xSpellerTarget.getLogger().makeError().append("MatchTextSubjectUtil.updateMap() called with location: ").append(navLocation);
        MapConfiguration mapConfiguration = new MapConfiguration(navLocation, 25, 0);
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainContentGotoLocation(37, mapConfiguration);
    }

    public void updateMapPhoneNumberList(XSpellerTarget xSpellerTarget, NavLocation navLocation) {
        xSpellerTarget.getLogger().makeError().append("MatchTextSubjectUtil.updateMap() called with location: ").append(navLocation);
        MapConfiguration mapConfiguration = new MapConfiguration(navLocation, 25, 0);
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainContentGotoLocation(38, mapConfiguration);
    }

    public void sendPositiveActionResults(XSpellerTarget xSpellerTarget) {
        ModelUpdater.updateLocationInputActionResult(true);
        ModelUpdater.updateLocationInputInputFieldActionResult(true);
    }

    public void handleSelectNothingEvent(XSpellerTarget xSpellerTarget) {
        if (SpellerContext.ACTIVE_STATE == 8) {
            if (NavigationConfiguration.LOCATIONINPUT_JPY_FEATURES_AVAILABLE) {
                this.sendStripEvent(2);
            } else {
                this.sendStripEvent(15);
            }
        } else if (SpellerContext.ACTIVE_STATE == 9) {
            this.sendStripEvent(15);
        } else if (SpellerContext.ACTIVE_STATE == 5) {
            new GeneralSubjectUtil().setOriginalLocation(xSpellerTarget, xSpellerTarget.getSpellerContext().getLocation(), false);
            if (NavigationConfiguration.LOCATIONINPUT_JPY_FEATURES_AVAILABLE) {
                this.sendStripEvent(3);
            } else {
                this.sendStripEvent(8);
            }
        } else if (SpellerContext.ACTIVE_STATE == 3 || SpellerContext.ACTIVE_STATE == 10) {
            new GeneralSubjectUtil().setOriginalLocation(xSpellerTarget, xSpellerTarget.getSpellerContext().getLocation(), true);
            if (NavigationConfiguration.LOCATIONINPUT_JPY_FEATURES_AVAILABLE) {
                this.sendStripEvent(21);
            } else {
                this.sendStripEvent(5);
            }
        } else if (SpellerContext.ACTIVE_STATE == 4) {
            new GeneralSubjectUtil().setOriginalLocation(xSpellerTarget, xSpellerTarget.getSpellerContext().getLocation(), true);
            this.sendStripEvent(3);
        } else if (SpellerContext.ACTIVE_STATE == 12) {
            new GeneralSubjectUtil().setOriginalLocation(xSpellerTarget, xSpellerTarget.getSpellerContext().getLocation(), true);
            this.sendStripEvent(25);
        } else if (SpellerContext.ACTIVE_STATE == 13) {
            new GeneralSubjectUtil().setOriginalLocation(xSpellerTarget, xSpellerTarget.getSpellerContext().getLocation(), true);
            this.sendStripEvent(25);
        } else if (SpellerContext.ACTIVE_STATE == 2) {
            new GeneralSubjectUtil().setOriginalLocation(xSpellerTarget, xSpellerTarget.getSpellerContext().getLocation(), true);
            this.sendStripEvent(25);
        } else {
            this.printWarning(xSpellerTarget, "evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_SELECT_NOTHING -> strip event not implemented for this case");
            ModelUpdater.updateLocationInputInputFieldActionResult(true);
        }
    }

    public void handleSelect(CmdAbstractSpeller cmdAbstractSpeller, XSpellerTarget xSpellerTarget, NavLocation navLocation, int[] nArray, int n, boolean bl) {
        if (cmdAbstractSpeller.liResult_ReturnCode != 0L) {
            xSpellerTarget.getLogger().makeError().append("handleSelect->ReturnCode NOK. ").log();
        }
        if (SpellerContext.getActiveExtInterfaceField() != 0) {
            XSpellerTarget.changeExtLocation(navLocation, nArray, false);
        }
        if (xSpellerTarget.getLogger().isTraceEnabled()) {
            xSpellerTarget.getLogger().makeTrace().append(" MatchTextSubjectUtil: Setting SpellerContext Location to: ").append(navLocation).log();
        }
        xSpellerTarget.getSpellerContext().setLocation(navLocation);
        ModelUpdater.updateLocation(navLocation, xSpellerTarget);
        if (SpellerContext.ACTIVE_STATE == 14) {
            this.updateMapPhoneNumberList(xSpellerTarget, navLocation);
        } else {
            this.updateMap(xSpellerTarget, navLocation);
        }
        new GeneralSubjectUtil().setOriginalLocation(xSpellerTarget, navLocation, false);
        ModelUpdater.updateNextAvailableCriterions(nArray, navLocation, xSpellerTarget);
        this.printAvailableCriterions(xSpellerTarget, nArray);
        if (n != 0) {
            ServiceManager.aslPropertyManager.valueChangedBoolean(n, true);
        }
        if (bl) {
            ModelUpdater.updateLocationInputInputFieldActionResult(true);
            ModelUpdater.updateLocationInputActionResult(true);
        }
    }

    private void sendStripEvent(int n) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setInt(0, n);
        eventGeneric.setReceiverEventId(IEvents.EV_STRIP_BY_STRIP_ID);
        eventGeneric.setReceiverTargetId(-1958013952);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }

    public void updateLists(XSpellerTarget xSpellerTarget, CmdAbstractSpeller cmdAbstractSpeller, ModelListHandler modelListHandler, ModelListHandler modelListHandler2) {
        if (cmdAbstractSpeller.liValueList_lispValueList != null) {
            modelListHandler.updateItems(cmdAbstractSpeller.liValueList_lispValueList, cmdAbstractSpeller.liValueList_lispValueListCount, cmdAbstractSpeller.lispUpdateSpellerResult_lispCurrentInput);
            if (modelListHandler2 != null) {
                modelListHandler2.updateItems(cmdAbstractSpeller.liValueList_lispValueList, cmdAbstractSpeller.liValueList_lispValueListCount, cmdAbstractSpeller.lispUpdateSpellerResult_lispCurrentInput);
            }
        } else {
            xSpellerTarget.getLogger().makeError().append("LiValueList is null for selectionCriterion: ").append(cmdAbstractSpeller.lispUpdateSpellerResult_lispCurrentSelectionCriterion).log();
        }
    }

    public void updateLists(XSpellerTarget xSpellerTarget, CmdAbstractSpeller cmdAbstractSpeller, ModelListHandler modelListHandler) {
        if (cmdAbstractSpeller.liValueList_lispValueList != null) {
            modelListHandler.updateItems(cmdAbstractSpeller.liValueList_lispValueList, cmdAbstractSpeller.liValueList_lispValueListCount, cmdAbstractSpeller.lispUpdateSpellerResult_lispCurrentInput);
        } else {
            xSpellerTarget.getLogger().makeError().append("LiValueList is null for selectionCriterion: ").append(cmdAbstractSpeller.lispUpdateSpellerResult_lispCurrentSelectionCriterion).log();
        }
    }

    public void printList(XSpellerTarget xSpellerTarget, LIValueListElement[] lIValueListElementArray) {
        for (int i2 = 0; i2 < lIValueListElementArray.length; ++i2) {
            LIValueListElement lIValueListElement = lIValueListElementArray[i2];
            StringBuffer stringBuffer = new StringBuffer("ArrayElement is : ").append(lIValueListElement).append("\n");
            this.printTraceMessage(xSpellerTarget, stringBuffer.toString());
        }
    }

    public IHnrFlags calculateHnrFlags(XSpellerTarget xSpellerTarget, CmdAbstractSpeller cmdAbstractSpeller) {
        HnrFlagsImpl hnrFlagsImpl = new HnrFlagsImpl();
        if (cmdAbstractSpeller.liValueList_lispValueList.list == null || cmdAbstractSpeller.liValueList_lispValueListCount == 0L) {
            StringBuffer stringBuffer = new StringBuffer("MatchTextSubjectUtil -> calculateHnrFlags -> no match at all, show crossings and nohousenumber: ");
            stringBuffer.append(cmdAbstractSpeller.liValueList_lispValueList.toString()).append(" List size is: ").append(cmdAbstractSpeller.liValueList_lispValueListCount);
            this.printTraceMessage(xSpellerTarget, stringBuffer.toString());
            hnrFlagsImpl.setHousenumberNone(true);
        } else if (cmdAbstractSpeller.liValueList_lispValueListCount == 1L && !this.isFirstValueListElementEmpty(cmdAbstractSpeller.liValueList_lispValueList)) {
            boolean bl = StringUtil.equalsIgnoreCase(cmdAbstractSpeller.lispUpdateSpellerResult_lispCurrentInput, cmdAbstractSpeller.liValueList_lispValueList.getList()[0].data);
            boolean bl2 = ServiceManager.configManagerDiag.isFeatureFlagSet(75);
            boolean bl3 = ServiceManager.configManagerDiag.isFeatureFlagSet(427);
            boolean bl4 = NavigationConfiguration.LOCATIONINPUT_CHN_FEATURES_AVAILABLE;
            if (bl4 || bl2 || bl3) {
                bl = true;
            }
            if (cmdAbstractSpeller.lispUpdateSpellerResult_lispIsFullMatch && bl) {
                StringBuffer stringBuffer = new StringBuffer("MatchTextSubjectUtil -> calculateHnrFlags -> direct match -> lispIsFullMatch: ");
                stringBuffer.append(cmdAbstractSpeller.liValueList_lispValueList.toString()).append(" List size is: ").append(cmdAbstractSpeller.liValueList_lispValueListCount);
                this.printTraceMessage(xSpellerTarget, stringBuffer.toString());
                hnrFlagsImpl.setHousenumberUnique(true);
            } else {
                StringBuffer stringBuffer = new StringBuffer("MatchTextSubjectUtil -> calculateHnrFlags -> no full match: ");
                stringBuffer.append(cmdAbstractSpeller.liValueList_lispValueList.toString()).append(" List size is: ").append(cmdAbstractSpeller.liValueList_lispValueListCount);
                this.printTraceMessage(xSpellerTarget, stringBuffer.toString());
                hnrFlagsImpl.setHousenumberAlternatives(true);
            }
        } else if (cmdAbstractSpeller.liValueList_lispValueListCount > 1L) {
            StringBuffer stringBuffer = new StringBuffer("MatchTextSubjectUtil -> calculateHnrFlags -> no direct match, show list: ");
            stringBuffer.append(cmdAbstractSpeller.liValueList_lispValueList.toString()).append(" List size is: ").append(cmdAbstractSpeller.liValueList_lispValueListCount);
            this.printTraceMessage(xSpellerTarget, stringBuffer.toString());
            hnrFlagsImpl.setHousenumberMatchesFound(true);
        }
        return hnrFlagsImpl;
    }

    private boolean isFirstValueListElementEmpty(LIValueList lIValueList) {
        if (lIValueList == null || lIValueList.list == null || lIValueList.list.length == 0) {
            return true;
        }
        LIValueListElement lIValueListElement = lIValueList.getList()[0];
        return lIValueListElement == null || lIValueListElement.data.equals("");
    }
}

