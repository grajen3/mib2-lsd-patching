/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.routeoptions;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
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
import de.vw.mib.asl.internal.navigation.routeoptions.PersistableRouteOptionsSetup;
import de.vw.mib.asl.internal.navigation.routeoptions.services.RouteOptionServices;
import de.vw.mib.asl.internal.navigation.routeoptions.transformer.VignetteCountryListCollector;
import de.vw.mib.asl.internal.navigation.routeoptions.variant.PersistableRouteOptionsAccessor;
import generated.de.vw.mib.asl.internal.ListManager;
import java.util.ArrayList;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;
import org.dsi.ifc.navigation.RouteOptions;

public class DSIVignetteList
implements NavGatewayListener {
    private IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(16384, super.getClass().toString());
    private VignetteCountryListCollector[] vignetteCountriesCollector = new VignetteCountryListCollector[0];
    private ArrayList completeVignetteCountryList = new ArrayList();

    public void deselectAll() {
        for (int i2 = 0; i2 < this.vignetteCountriesCollector.length; ++i2) {
            this.vignetteCountriesCollector[i2].isCountrySelected = false;
        }
    }

    public void toggleIndex(int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(" toggleIndex()");
        }
        if (this.vignetteCountriesCollector.length > n) {
            this.vignetteCountriesCollector[n].isCountrySelected = !this.vignetteCountriesCollector[n].isCountrySelected;
            PersistableRouteOptionsAccessor persistableRouteOptionsAccessor = RouteOptionServices.ROUTE_OPTIONS_PROVIDER.getPersistableRouteOptionsAccessor();
            persistableRouteOptionsAccessor.setSelectedVignetteCountries(PersistableRouteOptionsSetup.getInstance(), this.vignetteCountriesCollector);
            this.updateModel();
        }
    }

    private void updateModel() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(" updateModel()");
        }
        ListManager.getGenericASLList(960).updateList(this.vignetteCountriesCollector);
    }

    public void setRouteOptionSelections() {
        RouteOptions routeOptions;
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(" setRouteOptionSelections()");
        }
        if ((routeOptions = PersistableRouteOptionsSetup.getInstance().dsiRouteOptions.getRouteOptions()) != null) {
            if (routeOptions.vignetteCountryList != null) {
                for (int i2 = 0; i2 < this.vignetteCountriesCollector.length; ++i2) {
                    for (int i3 = 0; i3 < routeOptions.vignetteCountryList.length; ++i3) {
                        if (this.vignetteCountriesCollector[i2].countryID != routeOptions.vignetteCountryList[i3]) continue;
                        this.vignetteCountriesCollector[i2].isCountrySelected = true;
                    }
                }
            } else if (this.logger.isTraceEnabled()) {
                this.logger.trace(" RouteOptions.vignetteList == null");
            }
        } else if (this.logger.isTraceEnabled()) {
            this.logger.trace(" RouteOptions == null");
        }
        this.updateModel();
    }

    public void startDSISpeller() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(" startDSISpeller()");
        }
        this.completeVignetteCountryList = new ArrayList(10);
        new CmdCancelSpeller(this).execute();
        new CmdSetLiValueListWindowSize(this, -1).execute();
        new CmdStartSpeller(this, 129, true, true, true).execute();
    }

    @Override
    public void handleCommandCmdSetLiValueListWindowSize(CmdSetLiValueListWindowSize cmdSetLiValueListWindowSize) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(" handleCommandCmdSetLiValueListWindowSize()");
        }
        if (cmdSetLiValueListWindowSize.liResult_ReturnCode != 0L) {
            if (this.logger.isTraceEnabled()) {
                this.logger.error(" CmdSetLiValueListWindowSize failded.");
            }
            return;
        }
    }

    @Override
    public void handleCommandCmdStartSpeller(CmdStartSpeller cmdStartSpeller) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(" handleCommandCmdStartSpeller()");
        }
        if (cmdStartSpeller.liResult_ReturnCode != 0L) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace(" Result code not OK!");
            }
            return;
        }
        if (cmdStartSpeller.liValueList_lispValueListCount >= 0L && cmdStartSpeller.liValueList_lispValueListCount < 0) {
            if (cmdStartSpeller.liValueList_lispValueList != null && cmdStartSpeller.liValueList_lispValueList.list != null && cmdStartSpeller.liValueList_lispValueList.list.length > 0) {
                if ((long)cmdStartSpeller.liValueList_lispValueList.list.length != cmdStartSpeller.liValueList_lispValueListCount && this.logger.isTraceEnabled()) {
                    this.logger.trace(" Vignette list window is not equal to all available vignettes. Southside window seems to be to small.");
                }
                this.fillCompleteVignetteList(cmdStartSpeller.liValueList_lispValueList);
            }
        } else {
            this.logger.error(" Vigenette list: sanity check failded.");
        }
    }

    @Override
    public void handleCommandCmdRequestValueListByListIndex(CmdRequestValueListByListIndex cmdRequestValueListByListIndex) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(" handleCommandCmdRequestValueListByListIndex()");
        }
        if (cmdRequestValueListByListIndex.liResult_ReturnCode != 0L || cmdRequestValueListByListIndex.liValueList_lispValueList == null || cmdRequestValueListByListIndex.liValueList_lispValueList.list == null) {
            this.logger.error(" Vignette list:  handleCommandCmdRequestValueListByListIndex invalid result code or list null");
            return;
        }
        this.fillCompleteVignetteList(cmdRequestValueListByListIndex.liValueList_lispValueList);
    }

    private void fillCompleteVignetteList(LIValueList lIValueList) {
        int n;
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(" fillCompleteVignetteList()");
        }
        for (n = 0; n < lIValueList.list.length; ++n) {
            this.completeVignetteCountryList.add(lIValueList.list[n]);
        }
        if (lIValueList.hasNextPage) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace(" Vignette list:  Still windows left. Retrieving next one.)");
            }
            new CmdRequestValueListByListIndex(this, this.completeVignetteCountryList.size(), true).execute();
        } else {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace(" Vignette list:  All windows received. Filling ASL list..)");
            }
            this.vignetteCountriesCollector = new VignetteCountryListCollector[this.completeVignetteCountryList.size()];
            for (n = 0; n < this.completeVignetteCountryList.size(); ++n) {
                LIValueListElement lIValueListElement = (LIValueListElement)this.completeVignetteCountryList.get(n);
                this.vignetteCountriesCollector[n] = new VignetteCountryListCollector(lIValueListElement.getData(), lIValueListElement.listIndex, false);
            }
            this.setRouteOptionSelections();
        }
    }

    @Override
    public void handleCommandCmdDmLastDestinationsDeleteAll(CmdDmLastDestinationsDeleteAll cmdDmLastDestinationsDeleteAll) {
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
}

