/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.gateway;

import de.vw.mib.asl.internal.navigation.AbstractResettableAslTarget;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdAddChar;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdCancelSpeller;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdDmLastDestinationsDeleteAll;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdDmLastDestinationsGet;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdGetLastCityHistoryEntry;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdGetLastStreetHistoryEntry;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdGetLocationDescriptionTransform;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdGetLocationFromLiValueListElement;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdGetMatchingNVC;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdHistoryAddLocation;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdLastCityHistoryAdd;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdLastStateHistoryAdd;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdLastStreetHistoryAdd;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdLiGetState;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdNavLocationToStream;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdPoiGetXt9LDBs;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdPoiSelectSelectionCriteria;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdPoiStartSpellerAlongRoute;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdPoiStartSpellerAlongRouteAdvanced;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdRequestValueListByListIndex;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdRestoreState;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdRmRouteAdd;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdRmRouteDelete;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSelectByCategoryUid;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSelectByMultipleCategoryUids;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSelectListItem;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSelectListItemByIdent;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSelectListItemPoi;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSetCountryForCityAndStreetHistory;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSetCurrentLD;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSetInput;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSetLiValueListWindowSize;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSetNVCRange;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdStartSpeller;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdStopSpeller;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdStreamToNavLocation;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdStripLocation;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdTransformAndStrip;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdTransformAndToStream;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdTryBestMatch;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdTryMatchLocation;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdUndoChar;
import de.vw.mib.asl.internal.navigation.gateway.command.NavGatewayListener;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;

public abstract class AbstractResettableNavGatewayTarget
extends AbstractResettableAslTarget
implements NavGatewayListener {
    public AbstractResettableNavGatewayTarget(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
    }

    public AbstractResettableNavGatewayTarget(GenericEvents genericEvents, int n) {
        super(genericEvents, n);
    }

    @Override
    public void handleCommandCmdStartSpeller(CmdStartSpeller cmdStartSpeller) {
        this.warn("CmdStartSpeller not handled");
    }

    @Override
    public void handleCommandCmdPoiStartSpellerAlongRoute(CmdPoiStartSpellerAlongRoute cmdPoiStartSpellerAlongRoute) {
        this.warn("CmdPoiStartSpellerAlongRoute not handled");
    }

    @Override
    public void handleCommandCmdStopSpeller(CmdStopSpeller cmdStopSpeller) {
        this.warn("CmdStopSpeller not handled");
    }

    @Override
    public void handleCommandCmdCancelSpeller(CmdCancelSpeller cmdCancelSpeller) {
        this.warn("CmdCancelSpeller not handled");
    }

    @Override
    public void handleCommandCmdAddChar(CmdAddChar cmdAddChar) {
        this.warn("CmdAddChar not handled");
    }

    @Override
    public void handleCommandCmdUndoChar(CmdUndoChar cmdUndoChar) {
        this.warn("CmdUndoChar not handled");
    }

    @Override
    public void handleCommandCmdSelectListItem(CmdSelectListItem cmdSelectListItem) {
        this.warn("CmdSelectListItem not handled");
    }

    @Override
    public void handleCommandCmdSelectListItemByIdent(CmdSelectListItemByIdent cmdSelectListItemByIdent) {
        this.warn("CmdSelectListItemByIdent not handled");
    }

    @Override
    public void handleCommandCmdSelectByCategoryUid(CmdSelectByCategoryUid cmdSelectByCategoryUid) {
        this.warn("CmdSelectByCategoryUid not handled");
    }

    @Override
    public void handleCommandCmdSelectByMultipleCategoryUids(CmdSelectByMultipleCategoryUids cmdSelectByMultipleCategoryUids) {
        this.warn("CmdSelectByMultipleCategoryUids not handled");
    }

    @Override
    public void handleCommandCmdSelectListItemPoi(CmdSelectListItemPoi cmdSelectListItemPoi) {
        this.warn("CmdSelectListItemPoi not handled");
    }

    @Override
    public void handleCommandCmdPoiSelectSelectionCriteria(CmdPoiSelectSelectionCriteria cmdPoiSelectSelectionCriteria) {
        this.warn("CmdPoiSelectSelectionCriteria not handled");
    }

    @Override
    public void handleCommandCmdRestoreState(CmdRestoreState cmdRestoreState) {
        this.warn("CmdRestoreState not handled");
    }

    @Override
    public void handleCommandCmdLiGetState(CmdLiGetState cmdLiGetState) {
        this.warn("CmdLiGetState not handled");
    }

    @Override
    public void handleCommandCmdSetInput(CmdSetInput cmdSetInput) {
        this.warn("CmdSetInput not handled");
    }

    @Override
    public void handleCommandCmdSetCurrentLD(CmdSetCurrentLD cmdSetCurrentLD) {
        this.warn("CmdSetCurrentLD not handled");
    }

    @Override
    public void handleCommandCmdTryBestMatch(CmdTryBestMatch cmdTryBestMatch) {
        this.warn("CmdTryBestMatch not handled");
    }

    @Override
    public void handleCommandCmdTryMatchLocation(CmdTryMatchLocation cmdTryMatchLocation) {
        this.warn("CmdTryMatchLocation not handled");
    }

    @Override
    public void handleCommandCmdRequestValueListByListIndex(CmdRequestValueListByListIndex cmdRequestValueListByListIndex) {
        this.warn("CmdRequestValueListByListIndex not handled");
    }

    @Override
    public void handleCommandCmdNavLocationToStream(CmdNavLocationToStream cmdNavLocationToStream) {
        this.warn("CmdNavLocationToStream not handled");
    }

    @Override
    public void handleCommandCmdStreamToNavLocation(CmdStreamToNavLocation cmdStreamToNavLocation) {
        this.warn("CmdStreamToNavLocation not handled");
    }

    @Override
    public void handleCommandCmdGetLocationDescriptionTransform(CmdGetLocationDescriptionTransform cmdGetLocationDescriptionTransform) {
        this.warn("CmdGetLocationDescriptionTransform not handled");
    }

    @Override
    public void handleCommandCmdStripLocation(CmdStripLocation cmdStripLocation) {
        this.warn("CmdStripLocation not handled");
    }

    @Override
    public void handleCommandCmdSetLiValueListWindowSize(CmdSetLiValueListWindowSize cmdSetLiValueListWindowSize) {
        this.warn("CmdSetLiValueListSize not Handled");
    }

    @Override
    public void handleCommandCmdGetMatchingNVC(CmdGetMatchingNVC cmdGetMatchingNVC) {
        this.warn("CmdGetMatchingNVC not Handled");
    }

    @Override
    public void handleCommandCmdSetNVCRange(CmdSetNVCRange cmdSetNVCRange) {
        this.warn("CmdSetNVCRange not Handled");
    }

    @Override
    public void handleCommandCmdTransformAndStrip(CmdTransformAndStrip cmdTransformAndStrip) {
        this.warn("CmdTransformAndStrip not Handled");
    }

    @Override
    public void handleCommandCmdPoiGetXt9LDBs(CmdPoiGetXt9LDBs cmdPoiGetXt9LDBs) {
        this.warn("CmdPoiGetXt9LDBs not Handled");
    }

    @Override
    public void handleCommandCmdGetLocationFromLiValueListElement(CmdGetLocationFromLiValueListElement cmdGetLocationFromLiValueListElement) {
        this.warn("CmdGetLocationFromLiValueListElement not Handled");
    }

    @Override
    public void handleCommandCmdDmLastDestinationsDeleteAll(CmdDmLastDestinationsDeleteAll cmdDmLastDestinationsDeleteAll) {
        this.warn("CmdDmLastDestinationsDeleteAll not Handled");
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
    }

    @Override
    public void handleCommandCmdDmLastDestinationsGet(CmdDmLastDestinationsGet cmdDmLastDestinationsGet) {
        this.warn("CmdDmLastDestinationsGet not Handled");
    }

    @Override
    public void handleCommandCmdLastCityHistoryAdd(CmdLastCityHistoryAdd cmdLastCityHistoryAdd) {
        this.warn("CmdLastCityHistoryAdd not Handled");
    }

    @Override
    public void handleCommandCmdLastStreetHistoryAdd(CmdLastStreetHistoryAdd cmdLastStreetHistoryAdd) {
        this.warn("CmdLastStreetHistoryAdd not Handled");
    }

    @Override
    public void handleCommandCmdSetCountryForCityAndStreetHistory(CmdSetCountryForCityAndStreetHistory cmdSetCountryForCityAndStreetHistory) {
        this.warn("CmdSetCountryForCityAndStreetHistory not Handled");
    }

    @Override
    public void handleCommandCmdGetLastCityHistoryEntry(CmdGetLastCityHistoryEntry cmdGetLastCityHistoryEntry) {
        this.warn("CmdGetLastCityHistoryEntry not Handled");
    }

    @Override
    public void handleCommandCmdRmRouteDelete(CmdRmRouteDelete cmdRmRouteDelete) {
        this.warn("CmdRmRouteDelete not Handled");
    }

    @Override
    public void handleCommandCmdRmRouteAdd(CmdRmRouteAdd cmdRmRouteAdd) {
        this.warn("CmdRmRouteAdd not Handled");
    }

    @Override
    public void handleCommandCmdGetLastStreetHistoryEntry(CmdGetLastStreetHistoryEntry cmdGetLastStreetHistoryEntry) {
        this.warn("CmdGetLastStreetHistoryEntry not Handled");
    }

    @Override
    public void handleCommandCmdHistoryAddLocation(CmdHistoryAddLocation cmdHistoryAddLocation) {
        this.warn("CmdHistoryAddLocation not Handled");
    }

    @Override
    public void handleCommandCmdTransformAndToStream(CmdTransformAndToStream cmdTransformAndToStream) {
        this.warn("CmdTransformAndToStream not Handled");
    }

    @Override
    public void handleCommandCmdPoiStartSpellerAlongRouteAdvanced(CmdPoiStartSpellerAlongRouteAdvanced cmdPoiStartSpellerAlongRouteAdvanced) {
        this.warn("CmdPoiStartSpellerAlongRouteAdvanced not Handled");
    }

    @Override
    public void handleCommandCmdLastStateHistoryAdd(CmdLastStateHistoryAdd cmdLastStateHistoryAdd) {
        this.warn("CmdLastStateHistoryAdd not Handled");
    }
}

