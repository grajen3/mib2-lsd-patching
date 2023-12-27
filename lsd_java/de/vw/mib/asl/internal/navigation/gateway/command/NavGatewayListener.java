/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.gateway.command;

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

public interface NavGatewayListener {
    default public void handleCommandCmdStartSpeller(CmdStartSpeller cmdStartSpeller) {
    }

    default public void handleCommandCmdPoiStartSpellerAlongRoute(CmdPoiStartSpellerAlongRoute cmdPoiStartSpellerAlongRoute) {
    }

    default public void handleCommandCmdPoiStartSpellerAlongRouteAdvanced(CmdPoiStartSpellerAlongRouteAdvanced cmdPoiStartSpellerAlongRouteAdvanced) {
    }

    default public void handleCommandCmdStopSpeller(CmdStopSpeller cmdStopSpeller) {
    }

    default public void handleCommandCmdCancelSpeller(CmdCancelSpeller cmdCancelSpeller) {
    }

    default public void handleCommandCmdAddChar(CmdAddChar cmdAddChar) {
    }

    default public void handleCommandCmdUndoChar(CmdUndoChar cmdUndoChar) {
    }

    default public void handleCommandCmdSelectListItem(CmdSelectListItem cmdSelectListItem) {
    }

    default public void handleCommandCmdSelectListItemByIdent(CmdSelectListItemByIdent cmdSelectListItemByIdent) {
    }

    default public void handleCommandCmdSelectByCategoryUid(CmdSelectByCategoryUid cmdSelectByCategoryUid) {
    }

    default public void handleCommandCmdSelectByMultipleCategoryUids(CmdSelectByMultipleCategoryUids cmdSelectByMultipleCategoryUids) {
    }

    default public void handleCommandCmdSelectListItemPoi(CmdSelectListItemPoi cmdSelectListItemPoi) {
    }

    default public void handleCommandCmdPoiSelectSelectionCriteria(CmdPoiSelectSelectionCriteria cmdPoiSelectSelectionCriteria) {
    }

    default public void handleCommandCmdRestoreState(CmdRestoreState cmdRestoreState) {
    }

    default public void handleCommandCmdLiGetState(CmdLiGetState cmdLiGetState) {
    }

    default public void handleCommandCmdSetInput(CmdSetInput cmdSetInput) {
    }

    default public void handleCommandCmdSetCurrentLD(CmdSetCurrentLD cmdSetCurrentLD) {
    }

    default public void handleCommandCmdTryBestMatch(CmdTryBestMatch cmdTryBestMatch) {
    }

    default public void handleCommandCmdTryMatchLocation(CmdTryMatchLocation cmdTryMatchLocation) {
    }

    default public void handleCommandCmdRequestValueListByListIndex(CmdRequestValueListByListIndex cmdRequestValueListByListIndex) {
    }

    default public void handleCommandCmdDmLastDestinationsGet(CmdDmLastDestinationsGet cmdDmLastDestinationsGet) {
    }

    default public void handleCommandCmdLastCityHistoryAdd(CmdLastCityHistoryAdd cmdLastCityHistoryAdd) {
    }

    default public void handleCommandCmdLastStateHistoryAdd(CmdLastStateHistoryAdd cmdLastStateHistoryAdd) {
    }

    default public void handleCommandCmdLastStreetHistoryAdd(CmdLastStreetHistoryAdd cmdLastStreetHistoryAdd) {
    }

    default public void handleCommandCmdSetCountryForCityAndStreetHistory(CmdSetCountryForCityAndStreetHistory cmdSetCountryForCityAndStreetHistory) {
    }

    default public void handleCommandCmdNavLocationToStream(CmdNavLocationToStream cmdNavLocationToStream) {
    }

    default public void handleCommandCmdStreamToNavLocation(CmdStreamToNavLocation cmdStreamToNavLocation) {
    }

    default public void handleCommandCmdGetLocationDescriptionTransform(CmdGetLocationDescriptionTransform cmdGetLocationDescriptionTransform) {
    }

    default public void handleCommandCmdStripLocation(CmdStripLocation cmdStripLocation) {
    }

    default public void handleCommandCmdGetLastCityHistoryEntry(CmdGetLastCityHistoryEntry cmdGetLastCityHistoryEntry) {
    }

    default public void handleCommandCmdRmRouteDelete(CmdRmRouteDelete cmdRmRouteDelete) {
    }

    default public void handleCommandCmdRmRouteAdd(CmdRmRouteAdd cmdRmRouteAdd) {
    }

    default public void handleCommandCmdGetLastStreetHistoryEntry(CmdGetLastStreetHistoryEntry cmdGetLastStreetHistoryEntry) {
    }

    default public void handleCommandCmdSetLiValueListWindowSize(CmdSetLiValueListWindowSize cmdSetLiValueListWindowSize) {
    }

    default public void handleCommandCmdGetMatchingNVC(CmdGetMatchingNVC cmdGetMatchingNVC) {
    }

    default public void handleCommandCmdSetNVCRange(CmdSetNVCRange cmdSetNVCRange) {
    }

    default public void handleCommandCmdHistoryAddLocation(CmdHistoryAddLocation cmdHistoryAddLocation) {
    }

    default public void handleCommandCmdTransformAndStrip(CmdTransformAndStrip cmdTransformAndStrip) {
    }

    default public void handleCommandCmdPoiGetXt9LDBs(CmdPoiGetXt9LDBs cmdPoiGetXt9LDBs) {
    }

    default public void handleCommandCmdTransformAndToStream(CmdTransformAndToStream cmdTransformAndToStream) {
    }

    default public void handleCommandCmdGetLocationFromLiValueListElement(CmdGetLocationFromLiValueListElement cmdGetLocationFromLiValueListElement) {
    }

    default public void handleCommandCmdDmLastDestinationsDeleteAll(CmdDmLastDestinationsDeleteAll cmdDmLastDestinationsDeleteAll) {
    }
}

