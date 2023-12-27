/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.gateway;

import de.vw.mib.asl.framework.api.persistence.AbstractSharedPersistable;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdAddChar;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdCancelSpeller;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdDmLastDestinationsGet;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdGetLastCityHistoryEntry;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdGetLastStreetHistoryEntry;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdGetLocationDescriptionTransform;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdLastCityHistoryAdd;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdLastStreetHistoryAdd;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdLiGetState;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdNavLocationToStream;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdPoiSelectSelectionCriteria;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdPoiStartSpellerAlongRoute;
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
import de.vw.mib.asl.internal.navigation.gateway.command.CmdStartSpeller;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdStopSpeller;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdStreamToNavLocation;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdStripLocation;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdTryBestMatch;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdUndoChar;
import de.vw.mib.asl.internal.navigation.gateway.command.NavGatewayListener;

public abstract class AbstractSharedPoiPersistable
extends AbstractSharedPersistable
implements NavGatewayListener {
    private final String LOGGER_PREFIX;

    @Override
    public void handleCommandCmdLastCityHistoryAdd(CmdLastCityHistoryAdd cmdLastCityHistoryAdd) {
        this.warn("CmdLastCityHistoryAdd not handled");
    }

    @Override
    public void handleCommandCmdLastStreetHistoryAdd(CmdLastStreetHistoryAdd cmdLastStreetHistoryAdd) {
        this.warn("CmdLastStreetHistoryAdd not handled");
    }

    @Override
    public void handleCommandCmdSetCountryForCityAndStreetHistory(CmdSetCountryForCityAndStreetHistory cmdSetCountryForCityAndStreetHistory) {
        this.warn("CmdSetCountryForCityAndStreetHistory not handled");
    }

    protected AbstractSharedPoiPersistable(int n, long l) {
        super(n, l);
        this.LOGGER_PREFIX = "AbstractSharedPoiPersistable: ";
    }

    public void warn(String string) {
        ServiceManager.logger.trace(16384).append("AbstractSharedPoiPersistable: ").append(string).log();
    }

    public void error(String string) {
        ServiceManager.logger.error(16384).append("AbstractSharedPoiPersistable: ").append(string).log();
    }

    public void trace(String string) {
        if (ServiceManager.logger.isTraceEnabled(16384)) {
            ServiceManager.logger.trace(16384).append("AbstractSharedPoiPersistable: ").append(string).log();
        }
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
    public void handleCommandCmdRequestValueListByListIndex(CmdRequestValueListByListIndex cmdRequestValueListByListIndex) {
        this.warn("CmdRequestValueListByListIndex not handled");
    }

    @Override
    public void handleCommandCmdDmLastDestinationsGet(CmdDmLastDestinationsGet cmdDmLastDestinationsGet) {
        this.warn("CmdDmLastDestinationsGet not handled");
    }

    @Override
    public abstract void handleCommandCmdNavLocationToStream(CmdNavLocationToStream cmdNavLocationToStream) {
    }

    @Override
    public abstract void handleCommandCmdStreamToNavLocation(CmdStreamToNavLocation cmdStreamToNavLocation) {
    }

    @Override
    public void handleCommandCmdGetLocationDescriptionTransform(CmdGetLocationDescriptionTransform cmdGetLocationDescriptionTransform) {
        this.warn("CmdGetLocationDescriptionTransform not handled");
    }

    @Override
    public void handleCommandCmdGetLastCityHistoryEntry(CmdGetLastCityHistoryEntry cmdGetLastCityHistoryEntry) {
        this.warn("CmdGetLastCityHistoryEntry not handled");
    }

    @Override
    public void handleCommandCmdGetLastStreetHistoryEntry(CmdGetLastStreetHistoryEntry cmdGetLastStreetHistoryEntry) {
        this.warn("CmdGetLastStreetHistoryEntry not handled");
    }

    @Override
    public void handleCommandCmdStripLocation(CmdStripLocation cmdStripLocation) {
        this.warn("CmdStripLocation not handled");
    }

    @Override
    public void handleCommandCmdRmRouteDelete(CmdRmRouteDelete cmdRmRouteDelete) {
        this.warn("CmdRmRouteDelete not handled");
    }

    @Override
    public void handleCommandCmdRmRouteAdd(CmdRmRouteAdd cmdRmRouteAdd) {
        this.warn("CmdRmRouteAdd not handled");
    }

    @Override
    public void handleCommandCmdSetLiValueListWindowSize(CmdSetLiValueListWindowSize cmdSetLiValueListWindowSize) {
        this.warn("CmdSetLiValueListSize not Handled");
    }
}

