/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.spellerx.util;

import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.map.MapConfiguration;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSetInput;
import de.vw.mib.asl.internal.navigation.spellerx.SpellerContext;
import de.vw.mib.asl.internal.navigation.spellerx.XSpellerTarget;
import de.vw.mib.asl.internal.navigation.spellerx.model.ModelUpdater;
import de.vw.mib.asl.internal.navigation.spellerx.util.HnrFlagsImpl;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.housenumber.transformer.NavigationLocationInputInputFieldHousenumberListInfoCollector;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueListElement;

public class FreeTextSubjectUtil {
    public void addCharToFreeTextSpellerData(XSpellerTarget xSpellerTarget, int n, int n2, String string) {
        xSpellerTarget.getSpellerContext().getActiveField().getSpellerData().setAvailableCharacters("\u0007");
        int n3 = xSpellerTarget.getSpellerContext().getActiveField().getSpellerData().getCursorPosition();
        xSpellerTarget.getSpellerContext().getActiveField().getSpellerData().setEnteredText(new StringBuffer(xSpellerTarget.getSpellerContext().getActiveField().getSpellerData().getEnteredText()).insert(n3, string).toString());
        xSpellerTarget.getSpellerContext().getActiveField().getSpellerData().setCursorPosition(n3 + 1);
        ModelUpdater.updateSpellerData(xSpellerTarget.getSpellerContext().getActiveField().getSpellerData(), xSpellerTarget.getSpellerContext().getActiveState());
        ServiceManager.aslPropertyManager.valueChangedBoolean(n, true);
        ServiceManager.aslPropertyManager.valueChangedBoolean(n2, true);
    }

    public void updateMap(XSpellerTarget xSpellerTarget, NavLocation navLocation) {
        xSpellerTarget.getLogger().makeError().append("MatchTextSubjectUtil.updateMap() called with location: ").append(navLocation);
        MapConfiguration mapConfiguration = new MapConfiguration(navLocation, 25, 0);
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainContentGotoLocation(3, mapConfiguration);
    }

    public boolean areCmdSetInputReturnValuesCorrect(CmdSetInput cmdSetInput) {
        if (cmdSetInput.liResult_ReturnCode != 0L) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Error in setInput in fieldActive state failed (returnCode=").append(cmdSetInput.liResult_ReturnCode).append(")");
            ServiceManager.logger.error(16384, stringBuffer.toString());
            ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().resetNaviContext(new StringBuffer("SetInput in fieldActive state failed: liResult=").append(cmdSetInput.liResult_ReturnCode).toString());
            return false;
        }
        if (cmdSetInput.liValueList_lispValueList == null || cmdSetInput.liValueList_lispValueList.list == null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Error in setInput: cmd.liValueList_lispValueList==null or cmd.liValueList_lispValueList.list == null");
            ServiceManager.logger.error(16384, stringBuffer.toString());
            return false;
        }
        return true;
    }

    public String makeStringWithoutSpaces(String string) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < string.length(); ++i2) {
            if (string.charAt(i2) == ' ') continue;
            stringBuffer.append(string.charAt(i2));
        }
        return stringBuffer.toString();
    }

    public void makeTraceComment(XSpellerTarget xSpellerTarget, String string) {
        if (xSpellerTarget.getLogger().isTraceEnabled()) {
            xSpellerTarget.getLogger().trace(string);
        }
    }

    public void printAvailableCriterions(XSpellerTarget xSpellerTarget, int[] nArray) {
        if (xSpellerTarget.getLogger().isTraceEnabled()) {
            ASLNavigationUtilFactory.getNavigationUtilApi().getExtLoggerHelper().appendCriteria(xSpellerTarget.getLogger().makeTrace().append("SPELLER> available criteria: "), nArray).log();
        }
    }

    public String getHouseNumberForEnteringZero(LIValueListElement[] lIValueListElementArray) {
        for (int i2 = 0; i2 < lIValueListElementArray.length; ++i2) {
            LIValueListElement lIValueListElement = lIValueListElementArray[i2];
            if (!lIValueListElement.houseNumberInZipCode) continue;
            return lIValueListElement.data;
        }
        return "";
    }

    public void updateHouseNumberSubTypeForNARAndEU(XSpellerTarget xSpellerTarget, int n, CmdSetInput cmdSetInput) {
        GenericASLList genericASLList = ListManager.getGenericASLList(3080);
        NavigationLocationInputInputFieldHousenumberListInfoCollector navigationLocationInputInputFieldHousenumberListInfoCollector = (NavigationLocationInputInputFieldHousenumberListInfoCollector)genericASLList.getRowItem(0);
        HnrFlagsImpl hnrFlagsImpl = new HnrFlagsImpl();
        switch (n) {
            case 1: {
                this.makeTraceComment(xSpellerTarget, new StringBuffer("FreeTEXTSUBJECTJUtil:handleCommandCmdSetInput: Unique housenumber has been found: ").append(cmdSetInput.liValueList_lispValueList).toString());
                ModelUpdater.updateNearestHousenumber("");
                navigationLocationInputInputFieldHousenumberListInfoCollector.navigation_locationinput_inputfield_housenumber_list_info_sub_type = 1;
                hnrFlagsImpl.setHousenumberUnique(true);
                break;
            }
            case 2: {
                this.makeTraceComment(xSpellerTarget, new StringBuffer("FreeTEXTSUBJECTJUtil:handleCommandCmdSetInput: No direct hnr match, suggesting alternative: ").append(cmdSetInput.liValueList_lispValueList.list[0].data).toString());
                String string = cmdSetInput.liValueList_lispValueList.list[0].data;
                if (cmdSetInput.lispUpdateSpellerResult_lispCurrentInput.equals("0")) {
                    string = this.getHouseNumberForEnteringZero(cmdSetInput.liValueList_lispValueList.list);
                }
                ModelUpdater.updateNearestHousenumber(string);
                navigationLocationInputInputFieldHousenumberListInfoCollector.navigation_locationinput_inputfield_housenumber_list_info_sub_type = 3;
                hnrFlagsImpl.setHousenumberAlternatives(true);
                break;
            }
            default: {
                navigationLocationInputInputFieldHousenumberListInfoCollector.navigation_locationinput_inputfield_housenumber_list_info_sub_type = 0;
                hnrFlagsImpl.setHousenumberNone(true);
                ServiceManager.logger.error(16384, "Freetext housenumber list length = 0 -> This should never happen!");
            }
        }
        if (SpellerContext.getActiveExtInterfaceField() != 0) {
            XSpellerTarget.changeExtInterfaceList(cmdSetInput.liValueList_lispValueList, cmdSetInput.liValueList_lispValueListCount, hnrFlagsImpl);
        }
        genericASLList.updateListItem(0, navigationLocationInputInputFieldHousenumberListInfoCollector);
    }

    public void updateActionResultPositively() {
        ModelUpdater.updateLocationInputInputFieldActionResult(true);
        ModelUpdater.updateLocationInputActionResult(true);
    }
}

