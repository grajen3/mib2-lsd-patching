/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.spellerx.subjects;

import de.vw.mib.asl.framework.internal.framework.asl.AbstractReflectionSubject;
import de.vw.mib.asl.framework.internal.framework.asl.ApiHandler;
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

public class NavReflectionSubject
extends AbstractReflectionSubject
implements NavGatewayListener {
    public NavReflectionSubject(ApiHandler apiHandler) {
        super(apiHandler);
    }

    @Override
    public void handleCommandCmdStartSpeller(CmdStartSpeller cmdStartSpeller) {
    }

    @Override
    public void handleCommandCmdPoiStartSpellerAlongRoute(CmdPoiStartSpellerAlongRoute cmdPoiStartSpellerAlongRoute) {
    }

    @Override
    public void handleCommandCmdStopSpeller(CmdStopSpeller cmdStopSpeller) {
    }

    @Override
    public void handleCommandCmdCancelSpeller(CmdCancelSpeller cmdCancelSpeller) {
    }

    @Override
    public void handleCommandCmdAddChar(CmdAddChar cmdAddChar) {
    }

    @Override
    public void handleCommandCmdUndoChar(CmdUndoChar cmdUndoChar) {
    }

    @Override
    public void handleCommandCmdSelectListItem(CmdSelectListItem cmdSelectListItem) {
    }

    @Override
    public void handleCommandCmdSelectListItemByIdent(CmdSelectListItemByIdent cmdSelectListItemByIdent) {
    }

    @Override
    public void handleCommandCmdSelectByCategoryUid(CmdSelectByCategoryUid cmdSelectByCategoryUid) {
    }

    @Override
    public void handleCommandCmdSelectByMultipleCategoryUids(CmdSelectByMultipleCategoryUids cmdSelectByMultipleCategoryUids) {
    }

    @Override
    public void handleCommandCmdSelectListItemPoi(CmdSelectListItemPoi cmdSelectListItemPoi) {
    }

    @Override
    public void handleCommandCmdPoiSelectSelectionCriteria(CmdPoiSelectSelectionCriteria cmdPoiSelectSelectionCriteria) {
    }

    @Override
    public void handleCommandCmdRestoreState(CmdRestoreState cmdRestoreState) {
    }

    @Override
    public void handleCommandCmdLiGetState(CmdLiGetState cmdLiGetState) {
    }

    @Override
    public void handleCommandCmdSetInput(CmdSetInput cmdSetInput) {
    }

    @Override
    public void handleCommandCmdSetCurrentLD(CmdSetCurrentLD cmdSetCurrentLD) {
    }

    @Override
    public void handleCommandCmdTryBestMatch(CmdTryBestMatch cmdTryBestMatch) {
    }

    @Override
    public void handleCommandCmdRequestValueListByListIndex(CmdRequestValueListByListIndex cmdRequestValueListByListIndex) {
    }

    @Override
    public void handleCommandCmdDmLastDestinationsGet(CmdDmLastDestinationsGet cmdDmLastDestinationsGet) {
    }

    @Override
    public void handleCommandCmdLastCityHistoryAdd(CmdLastCityHistoryAdd cmdLastCityHistoryAdd) {
    }

    @Override
    public void handleCommandCmdLastStreetHistoryAdd(CmdLastStreetHistoryAdd cmdLastStreetHistoryAdd) {
    }

    @Override
    public void handleCommandCmdSetCountryForCityAndStreetHistory(CmdSetCountryForCityAndStreetHistory cmdSetCountryForCityAndStreetHistory) {
    }

    @Override
    public void handleCommandCmdNavLocationToStream(CmdNavLocationToStream cmdNavLocationToStream) {
    }

    @Override
    public void handleCommandCmdStreamToNavLocation(CmdStreamToNavLocation cmdStreamToNavLocation) {
    }

    @Override
    public void handleCommandCmdGetLocationDescriptionTransform(CmdGetLocationDescriptionTransform cmdGetLocationDescriptionTransform) {
    }

    @Override
    public void handleCommandCmdStripLocation(CmdStripLocation cmdStripLocation) {
    }

    @Override
    public void handleCommandCmdGetLastCityHistoryEntry(CmdGetLastCityHistoryEntry cmdGetLastCityHistoryEntry) {
    }

    @Override
    public void handleCommandCmdRmRouteDelete(CmdRmRouteDelete cmdRmRouteDelete) {
    }

    @Override
    public void handleCommandCmdRmRouteAdd(CmdRmRouteAdd cmdRmRouteAdd) {
    }

    @Override
    public void handleCommandCmdGetLastStreetHistoryEntry(CmdGetLastStreetHistoryEntry cmdGetLastStreetHistoryEntry) {
    }

    @Override
    public void handleCommandCmdSetLiValueListWindowSize(CmdSetLiValueListWindowSize cmdSetLiValueListWindowSize) {
    }

    @Override
    public void handleCommandCmdGetMatchingNVC(CmdGetMatchingNVC cmdGetMatchingNVC) {
    }

    @Override
    public void handleCommandCmdSetNVCRange(CmdSetNVCRange cmdSetNVCRange) {
    }

    @Override
    public void handleCommandCmdHistoryAddLocation(CmdHistoryAddLocation cmdHistoryAddLocation) {
    }

    @Override
    public void handleCommandCmdTransformAndStrip(CmdTransformAndStrip cmdTransformAndStrip) {
    }

    @Override
    public void handleCommandCmdPoiGetXt9LDBs(CmdPoiGetXt9LDBs cmdPoiGetXt9LDBs) {
    }

    @Override
    public void handleCommandCmdTransformAndToStream(CmdTransformAndToStream cmdTransformAndToStream) {
    }

    @Override
    public void handleCommandCmdTryMatchLocation(CmdTryMatchLocation cmdTryMatchLocation) {
    }

    @Override
    public void handleCommandCmdGetLocationFromLiValueListElement(CmdGetLocationFromLiValueListElement cmdGetLocationFromLiValueListElement) {
    }

    @Override
    public void handleCommandCmdLastStateHistoryAdd(CmdLastStateHistoryAdd cmdLastStateHistoryAdd) {
    }

    @Override
    public void handleCommandCmdPoiStartSpellerAlongRouteAdvanced(CmdPoiStartSpellerAlongRouteAdvanced cmdPoiStartSpellerAlongRouteAdvanced) {
    }

    @Override
    public void handleCommandCmdDmLastDestinationsDeleteAll(CmdDmLastDestinationsDeleteAll cmdDmLastDestinationsDeleteAll) {
    }
}

