/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.spellerx.subjects;

import de.vw.mib.asl.api.navigation.ASLNavigationTruffelFactory;
import de.vw.mib.asl.api.navigation.locationinput.ISpellerContext;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdLiGetState;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSelectListItem;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSelectListItemByIdent;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSetCurrentLD;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSetInput;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSetLiValueListWindowSize;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdStartSpeller;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdStripLocation;
import de.vw.mib.asl.internal.navigation.spellerx.SpellerContext;
import de.vw.mib.asl.internal.navigation.spellerx.XSpellerTarget;
import de.vw.mib.asl.internal.navigation.spellerx.model.ModelListHandler;
import de.vw.mib.asl.internal.navigation.spellerx.model.ModelUpdater;
import de.vw.mib.asl.internal.navigation.spellerx.subjects.NavReflectionSubject;
import de.vw.mib.asl.internal.navigation.spellerx.util.FreeTextSubjectUtil;
import de.vw.mib.asl.internal.navigation.spellerx.util.GeneralSubjectUtil;
import de.vw.mib.asl.internal.navigation.spellerx.util.MatchTextSubjectUtil;
import org.dsi.ifc.global.NavLocation;

public class CommonFreeTextSubject
extends NavReflectionSubject {
    private int charEnteredConst;
    private int inputFieldReadyConst;
    private XSpellerTarget target;
    private ModelListHandler list;
    private ModelListHandler previewList;
    private int selectionCriterion;
    private boolean removeStreet;
    private boolean removeTown;
    private boolean removeZipCode;
    private FreeTextSubjectUtil ftsUtil = new FreeTextSubjectUtil();

    public CommonFreeTextSubject(XSpellerTarget xSpellerTarget, int n, int n2, ModelListHandler modelListHandler, ModelListHandler modelListHandler2, int n3, boolean bl, boolean bl2, boolean bl3) {
        super(xSpellerTarget);
        this.charEnteredConst = n;
        this.inputFieldReadyConst = n2;
        this.target = xSpellerTarget;
        this.list = modelListHandler;
        this.previewList = modelListHandler2;
        this.selectionCriterion = n3;
        this.removeStreet = bl3;
        this.removeTown = bl2;
        this.removeZipCode = bl;
    }

    public void evtHSM_ENTRY(ISpellerContext iSpellerContext) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(this.charEnteredConst, false);
        ServiceManager.aslPropertyManager.valueChangedBoolean(this.inputFieldReadyConst, false);
    }

    public void evtHSM_START(ISpellerContext iSpellerContext) {
        this.setShortValueListMode();
        new CmdStartSpeller(this, this.selectionCriterion, this.removeZipCode, this.removeTown, this.removeStreet).execute();
    }

    public void evtHSM_EXIT(ISpellerContext iSpellerContext) {
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(107);
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(83);
    }

    public void evtEV_SELECT_VIA_INDEX(ISpellerContext iSpellerContext, int n) {
        new FreeTextSubjectUtil().makeTraceComment(this.target, new StringBuffer("COMMONFREETEXTSUBJECT:evtEV_SELECT_VIA_INDEX: Selecting index: ").append(n).toString());
        this.evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_SELECT_MATCH(iSpellerContext, n);
    }

    public void evtEV_SELECT_VIA_ID(ISpellerContext iSpellerContext, String string) {
        this.ftsUtil.makeTraceComment(this.target, new StringBuffer().append("CHINAMATCHTEXTRSUBJECT: Received event evtEV_SELECT_VIA_ID with objectId:").append(string).toString());
        if (string != null) {
            this.list.freezeList();
            if (this.previewList != null) {
                this.previewList.freezeList();
            }
            new CmdLiGetState(this).execute();
            new CmdSelectListItemByIdent(this, string).execute();
        } else {
            this.target.getLogger().warn("CHINAMATCHTEXTRSUBJECT: objectId is null");
        }
    }

    public void evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_ADD_CHARACTER(ISpellerContext iSpellerContext, String string) {
        this.ftsUtil.addCharToFreeTextSpellerData(this.target, this.charEnteredConst, this.inputFieldReadyConst, string);
    }

    public void evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_SET_CURSOR_POSITION(ISpellerContext iSpellerContext, int n) {
        this.target.getSpellerContext().getActiveField().getSpellerData().setCursorPosition(n);
        ModelUpdater.updateSpellerData(this.target.getSpellerContext().getActiveField().getSpellerData(), this.target.getSpellerContext().getActiveState());
    }

    public void evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_UNDO_LAST_CHARACTERS(ISpellerContext iSpellerContext) {
        this.deleteChar();
    }

    public void evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_SELECT_MATCH(ISpellerContext iSpellerContext, int n) {
        this.list.freezeList();
        if (this.previewList != null) {
            this.previewList.freezeList();
        }
        new CmdSelectListItem(this, n).execute();
    }

    public void evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_SELECT_FIRST_MATCH(ISpellerContext iSpellerContext) {
        this.list.freezeList();
        if (this.previewList != null) {
            this.previewList.freezeList();
        }
        new CmdSelectListItem(this, 0).execute();
    }

    public void evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_SELECT_NOTHING(ISpellerContext iSpellerContext) {
        this.list.freezeList();
        ASLNavigationTruffelFactory.getNavigationTruffelApi().resetSHIELDHousenumber();
        if (this.previewList != null) {
            this.previewList.freezeList();
        }
        if (this.target.getLogger().isTraceEnabled()) {
            ASLNavigationUtilFactory.getNavigationUtilApi().getExtLoggerHelper().appendLocation(this.target.getLogger().makeTrace().append(" CommonFreeTextSubject.evtASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_SELECT_NOTHING -> stripping location: "), this.target.getSpellerContext().getLocation()).log();
        }
        new CmdStripLocation(this, this.target.getSpellerContext().getLocation(), 3).execute();
    }

    @Override
    public void handleCommandCmdSetLiValueListWindowSize(CmdSetLiValueListWindowSize cmdSetLiValueListWindowSize) {
        SpellerContext.useShortLiValueList = false;
        SpellerContext.useShortLiValueListHnr = true;
        if (this.target.getLogger().isTraceEnabled()) {
            this.target.getLogger().makeTrace().append("SetLiValueListSize for Hnr return code is: ").append(cmdSetLiValueListWindowSize.liResult_ReturnCode).append(" New window size is: ").append(cmdSetLiValueListWindowSize.getWindowSize()).log();
        }
    }

    @Override
    public void handleCommandCmdStartSpeller(CmdStartSpeller cmdStartSpeller) {
        if (cmdStartSpeller.liValueList_lispValueList != null) {
            this.list.updateItems(cmdStartSpeller.liValueList_lispValueList, cmdStartSpeller.liValueList_lispValueListCount, cmdStartSpeller.lispUpdateSpellerResult_lispCurrentInput);
        }
        if (ASLNavigationTruffelFactory.getNavigationTruffelApi() != null && !ASLNavigationTruffelFactory.getNavigationTruffelApi().getShieldHouseNumber().equals("") && ASLNavigationTruffelFactory.getNavigationTruffelApi().getNavLocation() != null && ASLNavigationTruffelFactory.getNavigationTruffelApi().getNavLocation().getCountry().length() > 0) {
            this.target.getSpellerContext().setLocation(ASLNavigationTruffelFactory.getNavigationTruffelApi().getNavLocation());
        }
        if (SpellerContext.getActiveExtInterfaceField() == 0 && ASLNavigationTruffelFactory.getNavigationTruffelApi() != null && ASLNavigationTruffelFactory.getNavigationTruffelApi().getShieldHouseNumber() != null && ASLNavigationTruffelFactory.getNavigationTruffelApi().getShieldHouseNumber().length() > 0) {
            this.ftsUtil.makeTraceComment(this.target, "COMMONFREETEXTSUBJ - Sending SLDE housenumber to southside");
            new CmdSetInput(this, ASLNavigationTruffelFactory.getNavigationTruffelApi().getShieldHouseNumber(), false).execute();
        } else {
            new MatchTextSubjectUtil().setCharsAndCursor(this.target, cmdStartSpeller);
            ModelUpdater.updateListCount((int)cmdStartSpeller.liValueList_lispValueListCount, this.selectionCriterion);
            ModelUpdater.updateSpellerData(this.target.getSpellerContext().getActiveField().getSpellerData(), this.target.getSpellerContext().getActiveState());
            ServiceManager.aslPropertyManager.valueChangedBoolean(this.inputFieldReadyConst, true);
            ModelUpdater.updateLocationInputActionResult(true);
            ModelUpdater.updateLocationInputInputFieldActionResult(true);
        }
    }

    @Override
    public void handleCommandCmdSelectListItem(CmdSelectListItem cmdSelectListItem) {
        NavLocation navLocation = cmdSelectListItem.liCurrentState_liCurrentLD;
        if (this.target.getLogger().isTraceEnabled()) {
            this.target.getLogger().makeTrace().append(" Selecting housenumber: ").append(navLocation.getHousenumber()).log();
        }
        this.target.getSpellerContext().setLocation(navLocation);
        ASLNavigationTruffelFactory.getNavigationTruffelApi().setShieldHouseNumber(navLocation.getHousenumber());
        ModelUpdater.updateLocation(navLocation, this.target);
        ModelUpdater.updateNextAvailableCriterions(cmdSelectListItem.liCurrentState_availableSelectionCriteria, navLocation, this.target);
        ModelUpdater.setHousenumberSpellerToUse(cmdSelectListItem.liCurrentState_usefulRefinementCriteria, this.target);
        if (SpellerContext.getActiveExtInterfaceField() != 0) {
            XSpellerTarget.changeExtLocation(navLocation, cmdSelectListItem.liCurrentState_availableSelectionCriteria, false);
        }
        new FreeTextSubjectUtil().updateMap(this.target, navLocation);
        new GeneralSubjectUtil().setOriginalLocation(this.target, navLocation, false);
        this.ftsUtil.printAvailableCriterions(this.target, cmdSelectListItem.liCurrentState_availableSelectionCriteria);
        ServiceManager.aslPropertyManager.valueChangedBoolean(this.inputFieldReadyConst, true);
        ModelUpdater.updateLocationInputInputFieldActionResult(true);
    }

    @Override
    public void handleCommandCmdSetInput(CmdSetInput cmdSetInput) {
        if (!this.ftsUtil.areCmdSetInputReturnValuesCorrect(cmdSetInput)) {
            return;
        }
        this.ftsUtil.updateHouseNumberSubTypeForNARAndEU(this.target, cmdSetInput.liValueList_lispValueList.list.length, cmdSetInput);
        this.target.getSpellerContext().getActiveField().getSpellerData().setEnteredText(cmdSetInput.lispUpdateSpellerResult_lispCurrentInput);
        this.target.getSpellerContext().getActiveField().getSpellerData().setCursorPosition(this.target.getSpellerContext().getActiveField().getSpellerData().getEnteredText().length());
        this.list.updateItems(cmdSetInput.liValueList_lispValueList, cmdSetInput.liValueList_lispValueListCount, cmdSetInput.lispUpdateSpellerResult_lispCurrentInput);
        this.ftsUtil.updateActionResultPositively();
    }

    @Override
    public void handleCommandCmdStripLocation(CmdStripLocation cmdStripLocation) {
        NavLocation navLocation = cmdStripLocation.liStripLocationResult_location;
        if (this.target.getLogger().isTraceEnabled()) {
            ASLNavigationUtilFactory.getNavigationUtilApi().getExtLoggerHelper().appendLocation(this.target.getLogger().makeTrace().append(" CommonFreeTextSubject.handleCommandCmdStripLocation -> stripped location: "), navLocation).log();
        }
        new GeneralSubjectUtil().setOriginalLocation(this.target, navLocation, false);
        ModelUpdater.updateLocationResolved(false);
        ASLNavigationUtilFactory.getNavigationUtilApi().getExtLoggerHelper().appendLocation(this.target.getLogger().makeTrace().append(" CommonFreeTextSubject.handleCommandCmdStripLocation -> sending liSetCurrentLD with location: "), navLocation).log();
        new CmdSetCurrentLD(this, navLocation).execute();
    }

    @Override
    public void handleCommandCmdSetCurrentLD(CmdSetCurrentLD cmdSetCurrentLD) {
        NavLocation navLocation = cmdSetCurrentLD.liCurrentState_liCurrentLD;
        if (this.target.getLogger().isTraceEnabled()) {
            ASLNavigationUtilFactory.getNavigationUtilApi().getExtLoggerHelper().appendLocation(this.target.getLogger().makeTrace().append(" CommonFreeTextSubject -> handleCommandCmdSetCurrentLD location: "), navLocation).log();
        }
        ModelUpdater.updateNextAvailableCriterions(cmdSetCurrentLD.liCurrentState_availableSelectionCriteria, navLocation, this.target);
        ModelUpdater.setHousenumberSpellerToUse(cmdSetCurrentLD.liCurrentState_usefulRefinementCriteria, this.target);
        ModelUpdater.updateLocation(navLocation, this.target);
        ModelUpdater.updateLocationResolved(true);
        this.ftsUtil.printAvailableCriterions(this.target, cmdSetCurrentLD.liCurrentState_availableSelectionCriteria);
        this.target.getSpellerContext().setLocation(navLocation);
        if (this.target.getSpellerContext().getActiveField() != null) {
            ModelUpdater.updateSpellerData(this.target.getSpellerContext().getActiveField().getSpellerData(), this.target.getSpellerContext().getActiveState());
        }
        ModelUpdater.updateLocationInputInputFieldActionResult(true);
    }

    private void deleteChar() {
        this.target.getSpellerContext().getActiveField().getSpellerData().setAvailableCharacters("\u0007");
        int n = this.target.getSpellerContext().getActiveField().getSpellerData().getCursorPosition();
        String string = this.target.getSpellerContext().getActiveField().getSpellerData().getEnteredText();
        String string2 = new StringBuffer(string).replace(n - 1, n, "").toString();
        this.target.getSpellerContext().getActiveField().getSpellerData().setEnteredText(string2);
        this.target.getSpellerContext().getActiveField().getSpellerData().setCursorPosition(n - 1);
        ModelUpdater.updateSpellerData(this.target.getSpellerContext().getActiveField().getSpellerData(), this.target.getSpellerContext().getActiveState());
        if (string2.length() > 0) {
            ServiceManager.aslPropertyManager.valueChangedBoolean(this.charEnteredConst, true);
        } else {
            ServiceManager.aslPropertyManager.valueChangedBoolean(this.charEnteredConst, false);
        }
        ServiceManager.aslPropertyManager.valueChangedBoolean(this.inputFieldReadyConst, true);
    }

    private void setShortValueListMode() {
        if (!SpellerContext.useShortLiValueListHnr) {
            if (this.target.getLogger().isTraceEnabled()) {
                this.target.getLogger().makeTrace().append("setShortValueListMode: Setting liValueListWindowSize = 2").log();
            }
            new CmdSetLiValueListWindowSize(this, 2).execute();
        }
    }
}

