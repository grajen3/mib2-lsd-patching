/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.tile.list;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioCurrentWaveband;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.amfm.AmFmFactory;
import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import de.vw.mib.asl.internal.radio.amfm.dsi.AmFmDsiApi;
import de.vw.mib.asl.internal.radio.amfm.lists.AmFmStationListAM;
import de.vw.mib.asl.internal.radio.amfm.lists.AmFmStationListFM;
import de.vw.mib.asl.internal.radio.amfm.presets.AmFmPreset;
import de.vw.mib.asl.internal.radio.amfm.presets.AmFmPresetApi;
import de.vw.mib.asl.internal.radio.amfm.presets.AmFmPresetList;
import de.vw.mib.asl.internal.radio.amfm.presets.SelectedStationHighlighting;
import de.vw.mib.asl.internal.radio.amfm.settings.AmfmRDSOption;
import de.vw.mib.asl.internal.radio.amfm.settings.AmfmScopeOfArrowKeys;
import de.vw.mib.asl.internal.radio.appadapter.ApiAppAdapterTunerTileL;
import de.vw.mib.asl.internal.radio.comparator.FrequencyHDComparatorChain;
import de.vw.mib.asl.internal.radio.dab.DabTunerState;
import de.vw.mib.asl.internal.radio.dab.main.DabMainApi;
import de.vw.mib.asl.internal.radio.dab.presets.DabPreset;
import de.vw.mib.asl.internal.radio.dab.presets.DabPresetApi;
import de.vw.mib.asl.internal.radio.presets.Preset;
import de.vw.mib.asl.internal.radio.radiodata.RadioDataApi;
import de.vw.mib.asl.internal.radio.radiodata.RadioDataSessionManager;
import de.vw.mib.asl.internal.radio.radiodata.StationLogoData;
import de.vw.mib.asl.internal.radio.sdars.helper.IChannelWalker;
import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import de.vw.mib.asl.internal.radio.sdars.presets.SatPreset;
import de.vw.mib.asl.internal.radio.transformer.TileListCollector;
import de.vw.mib.genericevents.EventGeneric;
import generated.de.vw.mib.asl.internal.ListManager;
import java.util.ArrayList;
import java.util.Arrays;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.FrequencyInfo;
import org.dsi.ifc.radio.ServiceInfo;
import org.dsi.ifc.sdars.StationInfo;

public final class TileStationList {
    private int currentListIndex = 0;
    public static final int INVALID_LIST_INDEX;
    private boolean isTileSVisible;
    private boolean isTileLVisible;
    private boolean stationSelectionByTiles = false;
    private boolean freezeTileList = false;
    private boolean updateTileList = false;

    public TileStationList() {
        this.setTileSVisible(false);
        this.setTileLVisible(false);
    }

    public TileListCollector[] initTiles() {
        try {
            this.freezeTileList = false;
            this.updateTileList = false;
            return this.createList();
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return null;
        }
    }

    public TileListCollector[] createList() {
        try {
            int n = AmfmScopeOfArrowKeys.get();
            if (null != ServiceManager.logger && ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("TileStationList - createList() - amfmArrowKeysScope = ").append(n).log();
            }
            ApiAppAdapterTunerTileL.setWaveband();
            if (1 == n) {
                return this.createStationList();
            }
            return this.createPresetList();
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return null;
        }
    }

    public TileListCollector[] createStationList() {
        try {
            int n = RadioCurrentWaveband.get();
            if (null != ServiceManager.logger && ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("TileStationList - createStationList() - waveband = ").append(n).log();
            }
            switch (n) {
                case 0: {
                    return this.createAmStationList();
                }
                case 1: {
                    return this.createFmStationList();
                }
                case 2: {
                    return this.createDabStationList();
                }
                case 3: {
                    return this.createSdarsStationList();
                }
            }
            ServiceManager.logger.error(128).append("TileStationList - createStationList() - waveband = ").append(n).log();
            return null;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return null;
        }
    }

    public TileListCollector[] createPresetList() {
        try {
            int n = RadioCurrentWaveband.get();
            if (null != ServiceManager.logger && ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("TileStationList - createPresetList() - waveband = ").append(n).log();
            }
            switch (n) {
                case 0: {
                    return this.createAmPresetList();
                }
                case 1: {
                    return this.createFmPresetList();
                }
                case 2: {
                    return this.createDabPresetList();
                }
                case 3: {
                    return this.createSdarsPresetList();
                }
            }
            ServiceManager.logger.error(128).append("TileStationList - createPresetList() - waveband = ").append(n).log();
            return null;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return null;
        }
    }

    public TileListCollector[] createAmPresetList() {
        try {
            Object[] objectArray;
            if (null != ServiceManager.logger && ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("TileStationList - createAmPresetList()").log();
            }
            AmFmStation amFmStation = RadioData.getAmfmDatabase().getSettingsPersistable().getCurrentAmStation();
            ArrayList arrayList = new ArrayList(0);
            int n = 1;
            AmFmPresetList amFmPresetList = AmFmPresetApi.getList(0);
            boolean bl = false;
            boolean bl2 = false;
            int n2 = AmFmPresetApi.getLastSelectedPresetIndex(0);
            this.currentListIndex = 0;
            if (null != amFmPresetList && null != (objectArray = amFmPresetList.getPresets())) {
                AmFmStation amFmStation2;
                int n3;
                if (null != amFmStation) {
                    for (n3 = 0; n3 < objectArray.length; ++n3) {
                        if (null == objectArray[n3] || ((AmFmPreset)objectArray[n3]).isEmpty() || null == (amFmStation2 = ((AmFmPreset)objectArray[n3]).getPresetStation()) || !amFmStation.match(amFmStation2, 0)) continue;
                        bl = true;
                        break;
                    }
                }
                for (n3 = 0; n3 < objectArray.length; ++n3) {
                    if (null == objectArray[n3] || ((AmFmPreset)objectArray[n3]).isEmpty()) continue;
                    amFmStation2 = ((AmFmPreset)objectArray[n3]).getPresetStation();
                    if (null != amFmStation2) {
                        if (bl && null != amFmStation && amFmStation.match(amFmStation2, 0)) {
                            if (n3 <= n2) {
                                this.currentListIndex = n - 1;
                            }
                            bl2 = true;
                        }
                        n = this.addAmStation(arrayList, amFmStation2, n, ((Preset)objectArray[n3]).getImage());
                    }
                    if (bl || n3 != n2 || null == amFmStation) continue;
                    this.currentListIndex = n - 1;
                    n = this.addAmStation(arrayList, amFmStation, n, null);
                    bl2 = true;
                }
            }
            if (!bl2 && null != amFmStation) {
                this.currentListIndex = n - 1;
                n = this.addAmStation(arrayList, amFmStation, n, null);
            }
            objectArray = (TileListCollector[])arrayList.toArray(new TileListCollector[arrayList.size()]);
            RadioServiceManager.getServiceManager().getApiGuiRadioTiles().updateTileLists((TileListCollector[])objectArray, this.currentListIndex);
            return objectArray;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return null;
        }
    }

    public int addAmStation(ArrayList arrayList, AmFmStation amFmStation, int n, ResourceLocator resourceLocator) {
        try {
            if (null != ServiceManager.logger && ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("TileStationList - addAmStation()").log();
            }
            if (null != arrayList && null != amFmStation) {
                TileListCollector tileListCollector = this.createAmCollector(amFmStation, n, resourceLocator);
                if (null != ServiceManager.logger && ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append(tileListCollector.toString()).log();
                }
                arrayList.add(tileListCollector);
                ++n;
            }
            return n;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return n;
        }
    }

    public TileListCollector createAmCollector(AmFmStation amFmStation, int n, ResourceLocator resourceLocator) {
        try {
            if (null != ServiceManager.logger && ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("TileStationList - createAmCollestor()").log();
            }
            TileListCollector tileListCollector = new TileListCollector();
            if (null == amFmStation) {
                return tileListCollector;
            }
            if (null == resourceLocator) {
                resourceLocator = ServiceManager.configManagerDiag.isFeatureFlagSet(2) ? AmFmFactory.getAslAmfmModelController().getAmFmStationArt(amFmStation) : AmFmPresetApi.getImage(amFmStation);
            }
            tileListCollector.mode = 0;
            tileListCollector.frequency = amFmStation.getFrequency();
            tileListCollector.subChannelId = amFmStation.getSubChannel();
            tileListCollector.listIndex = n;
            tileListCollector.piSid = amFmStation.getPi();
            tileListCollector.stationLogo = resourceLocator;
            tileListCollector.isRds = false;
            tileListCollector.isScrollingPs = amFmStation.isScrollingPS();
            tileListCollector.originalAmFmStationName = amFmStation.getStationName();
            tileListCollector.waveband = amFmStation.getWaveband();
            tileListCollector.amFmServiceId = amFmStation.getServiceId();
            tileListCollector.amFmShortNameHd = amFmStation.getShortNameHD();
            this.setAmStationName(amFmStation, tileListCollector);
            return tileListCollector;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return new TileListCollector();
        }
    }

    public TileListCollector[] createFmPresetList() {
        try {
            Object[] objectArray;
            if (null != ServiceManager.logger && ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("TileStationList - createFmPresetList()").log();
            }
            AmFmStation amFmStation = RadioData.getAmfmDatabase().getSettingsPersistable().getCurrentFmStation();
            ArrayList arrayList = new ArrayList(0);
            int n = 1;
            AmFmPresetList amFmPresetList = AmFmPresetApi.getList(1);
            boolean bl = false;
            boolean bl2 = false;
            int n2 = AmFmPresetApi.getLastSelectedPresetIndex(1);
            this.currentListIndex = 0;
            if (null != amFmPresetList && null != (objectArray = amFmPresetList.getPresets())) {
                AmFmStation amFmStation2;
                int n3;
                if (null != amFmStation) {
                    for (n3 = 0; n3 < objectArray.length; ++n3) {
                        if (null == objectArray[n3] || ((AmFmPreset)objectArray[n3]).isEmpty() || null == (amFmStation2 = ((AmFmPreset)objectArray[n3]).getPresetStation()) || !amFmStation.match(amFmStation2, 1)) continue;
                        bl = true;
                        break;
                    }
                }
                for (n3 = 0; n3 < objectArray.length; ++n3) {
                    if (null == objectArray[n3] || ((AmFmPreset)objectArray[n3]).isEmpty()) continue;
                    amFmStation2 = ((AmFmPreset)objectArray[n3]).getPresetStation();
                    if (null != amFmStation2) {
                        if (bl && null != amFmStation && amFmStation.match(amFmStation2, 1)) {
                            if (n3 <= n2) {
                                this.currentListIndex = n - 1;
                            }
                            bl2 = true;
                        }
                        n = this.addFmStation(arrayList, amFmStation2, n, ((Preset)objectArray[n3]).getImage());
                    }
                    if (bl || n3 != n2 || null == amFmStation) continue;
                    this.currentListIndex = n - 1;
                    n = this.addFmStation(arrayList, amFmStation, n, null);
                    bl2 = true;
                }
            }
            if (!bl2 && null != amFmStation) {
                this.currentListIndex = n - 1;
                n = this.addFmStation(arrayList, amFmStation, n, null);
            }
            objectArray = (TileListCollector[])arrayList.toArray(new TileListCollector[arrayList.size()]);
            RadioServiceManager.getServiceManager().getApiGuiRadioTiles().updateTileLists((TileListCollector[])objectArray, this.currentListIndex);
            return objectArray;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return null;
        }
    }

    public int addFmStation(ArrayList arrayList, AmFmStation amFmStation, int n, ResourceLocator resourceLocator) {
        try {
            if (null != ServiceManager.logger && ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("TileStationList - addFmStation()").log();
            }
            if (null != arrayList && null != amFmStation) {
                TileListCollector tileListCollector = this.createFmCollector(amFmStation, n, resourceLocator);
                if (null != ServiceManager.logger && ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append(tileListCollector.toString()).log();
                }
                arrayList.add(tileListCollector);
                ++n;
            }
            return n;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return n;
        }
    }

    public TileListCollector createFmCollector(AmFmStation amFmStation, int n, ResourceLocator resourceLocator) {
        try {
            if (null != ServiceManager.logger && ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("TileStationList - createFmCollector()").log();
            }
            TileListCollector tileListCollector = new TileListCollector();
            if (null == amFmStation) {
                return tileListCollector;
            }
            if (null == resourceLocator) {
                resourceLocator = this.getAmFmStationLogo(amFmStation);
            }
            tileListCollector.mode = 1;
            tileListCollector.frequency = amFmStation.getFrequency();
            tileListCollector.subChannelId = amFmStation.getSubChannel();
            tileListCollector.listIndex = n;
            tileListCollector.piSid = amFmStation.getPi();
            tileListCollector.stationLogo = resourceLocator;
            tileListCollector.isRds = amFmStation.isRds();
            tileListCollector.isScrollingPs = amFmStation.isScrollingPS();
            tileListCollector.originalAmFmStationName = amFmStation.getStationName();
            tileListCollector.waveband = amFmStation.getWaveband();
            tileListCollector.amFmServiceId = amFmStation.getServiceId();
            tileListCollector.amFmShortNameHd = amFmStation.getShortNameHD();
            tileListCollector.isHd = amFmStation.isHD();
            tileListCollector.stationName = this.getFmStationName(amFmStation, RadioDataSessionManager.getInstance().countryList.isDatabaseNameActivatedForPresets());
            return tileListCollector;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return new TileListCollector();
        }
    }

    public ResourceLocator getAmFmStationLogo(AmFmStation amFmStation) {
        try {
            if (null != ServiceManager.logger && ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("TileStationList - getAmFmStationLogo()").log();
            }
            if (null == amFmStation) {
                return null;
            }
            if (ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
                ResourceLocator resourceLocator = null;
                AmFmStation amFmStation2 = RadioData.getAmfmDatabase().getCurrentStation();
                if (null != amFmStation2 && amFmStation.match(amFmStation2, RadioCurrentWaveband.get())) {
                    if (this.isTileLVisible() || this.isTileSVisible()) {
                        resourceLocator = AmFmFactory.getAslAmfmModelController().getLogoForStationView();
                        if (resourceLocator != null) {
                            this.startTileCoverArtTimer();
                        }
                    } else {
                        this.stopTileCoverArtTimer();
                        resourceLocator = null;
                    }
                } else {
                    resourceLocator = AmFmFactory.getAslAmfmModelController().getAmFmStationArt(amFmStation);
                }
                return resourceLocator;
            }
            ResourceLocator resourceLocator = null;
            StationLogoData stationLogoData = null;
            resourceLocator = AmFmPresetApi.getImage(amFmStation);
            if (null == resourceLocator) {
                int n;
                int n2 = RadioDataSessionManager.getInstance().homeCountryCalc.getHomeCountry();
                stationLogoData = RadioDataApi.requestRadioFmStationDataFromHmiBuffer(amFmStation, n2);
                if (null != stationLogoData) {
                    if (stationLogoData.isResponseContainedMoreThanOneLogo()) {
                        return null;
                    }
                    resourceLocator = stationLogoData.getResourceLocator();
                }
                if (null == resourceLocator && null != (stationLogoData = RadioDataApi.requestRadioFmStationDataFromHmiBuffer(amFmStation, n = RadioDataSessionManager.getInstance().homeCountryCalc.getNeighboringCountry(n2, amFmStation.getPi()))) && !stationLogoData.isResponseContainedMoreThanOneLogo()) {
                    resourceLocator = stationLogoData.getResourceLocator();
                }
            }
            return resourceLocator;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return null;
        }
    }

    public ResourceLocator getDabStationLogo(ServiceInfo serviceInfo) {
        try {
            ResourceLocator resourceLocator;
            if (null != ServiceManager.logger && ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("TileStationList - getDabStationLogo()").log();
            }
            if (null == (resourceLocator = DabPresetApi.getImage(serviceInfo))) {
                resourceLocator = RadioDataApi.requestRadioDabStationLogoFromHmiBuffer(serviceInfo);
            }
            return resourceLocator;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return null;
        }
    }

    public TileListCollector[] createDabPresetList() {
        try {
            if (null != ServiceManager.logger && ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("TileStationList - createDabPresetList()").log();
            }
            ServiceInfo serviceInfo = RadioData.getDabDatabase().mTunerState.getCurrentService();
            ArrayList arrayList = new ArrayList(0);
            int n = 1;
            DabPreset[] dabPresetArray = DabPresetApi.getValidPresetStationList();
            boolean bl = false;
            boolean bl2 = false;
            int n2 = RadioData.getDabDatabase().mPersistable.getCurrentPresetIndexSelectedByHmi();
            this.currentListIndex = 0;
            if (null != dabPresetArray) {
                ServiceInfo serviceInfo2;
                int n3;
                if (null != serviceInfo) {
                    for (n3 = 0; n3 < dabPresetArray.length; ++n3) {
                        if (null == dabPresetArray[n3] || null == (serviceInfo2 = dabPresetArray[n3].getService()) || !DabTunerState.compare(serviceInfo2, serviceInfo)) continue;
                        bl = true;
                        break;
                    }
                }
                for (n3 = 0; n3 < dabPresetArray.length; ++n3) {
                    if (null == dabPresetArray[n3]) continue;
                    serviceInfo2 = dabPresetArray[n3].getService();
                    if (null != serviceInfo2) {
                        if (bl && null != serviceInfo && DabTunerState.compare(serviceInfo2, serviceInfo)) {
                            if (n3 <= n2) {
                                this.currentListIndex = n - 1;
                            }
                            bl2 = true;
                        }
                        n = this.addDabStation(arrayList, serviceInfo2, n, dabPresetArray[n3].getImage());
                    }
                    if (bl || n3 != n2 || null == serviceInfo) continue;
                    this.currentListIndex = n - 1;
                    n = this.addDabStation(arrayList, serviceInfo, n, null);
                    bl2 = true;
                }
            }
            if (!bl2 && null != serviceInfo) {
                this.currentListIndex = n - 1;
                n = this.addDabStation(arrayList, serviceInfo, n, null);
            }
            TileListCollector[] tileListCollectorArray = (TileListCollector[])arrayList.toArray(new TileListCollector[arrayList.size()]);
            RadioServiceManager.getServiceManager().getApiGuiRadioTiles().updateTileLists(tileListCollectorArray, this.currentListIndex);
            return tileListCollectorArray;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return null;
        }
    }

    public TileListCollector[] createSdarsPresetList() {
        try {
            if (null != ServiceManager.logger && ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("TileStationList - createSdarsPresetList()").log();
            }
            StationInfo stationInfo = SatDb.getInstance().getListApi().getSatListModel().getCurrentChannel();
            ArrayList arrayList = new ArrayList(0);
            int n = 1;
            SatPreset[] satPresetArray = SatDb.getInstance().getPresetApi().getSatPreset();
            boolean bl = false;
            boolean bl2 = false;
            int n2 = SatDb.getInstance().getPresetApi().getLastSelectedPresetIndex();
            this.currentListIndex = 0;
            if (null != satPresetArray) {
                StationInfo stationInfo2;
                int n3;
                if (null != stationInfo) {
                    for (n3 = 0; n3 < satPresetArray.length; ++n3) {
                        if (null == satPresetArray[n3] || null == (stationInfo2 = satPresetArray[n3].getStation()) || stationInfo2.getSID() != stationInfo.getSID()) continue;
                        bl = true;
                        break;
                    }
                }
                for (n3 = 0; n3 < satPresetArray.length; ++n3) {
                    if (null == satPresetArray[n3]) continue;
                    stationInfo2 = satPresetArray[n3].getStation();
                    if (null != stationInfo2) {
                        if (bl && null != stationInfo && stationInfo2.getSID() == stationInfo.getSID()) {
                            if (n3 <= n2) {
                                this.currentListIndex = n - 1;
                            }
                            bl2 = true;
                        }
                        n = this.addSdarsChannel(arrayList, stationInfo2, n, stationInfo2.getChannelArt());
                    }
                    if (bl || n3 != n2 || null == stationInfo) continue;
                    this.currentListIndex = n - 1;
                    n = this.addSdarsChannel(arrayList, stationInfo, n, null);
                    bl2 = true;
                }
            }
            if (!bl2 && null != stationInfo) {
                this.currentListIndex = n - 1;
                n = this.addSdarsChannel(arrayList, stationInfo, n, stationInfo.getChannelArt());
            }
            TileListCollector[] tileListCollectorArray = (TileListCollector[])arrayList.toArray(new TileListCollector[arrayList.size()]);
            RadioServiceManager.getServiceManager().getApiGuiRadioTiles().updateTileLists(tileListCollectorArray, this.currentListIndex);
            return tileListCollectorArray;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return null;
        }
    }

    public int addSdarsChannel(ArrayList arrayList, StationInfo stationInfo, int n, ResourceLocator resourceLocator) {
        try {
            if (null != ServiceManager.logger && ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("TileStationList - addSdarsChannel()").log();
            }
            if (null != arrayList && null != stationInfo) {
                TileListCollector tileListCollector = this.createSdarsCollector(stationInfo, n, resourceLocator);
                if (null != ServiceManager.logger && ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append(tileListCollector.toString()).log();
                }
                arrayList.add(tileListCollector);
                ++n;
            }
            return n;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return n;
        }
    }

    public TileListCollector createSdarsCollector(StationInfo stationInfo, int n, ResourceLocator resourceLocator) {
        try {
            if (null != ServiceManager.logger && ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("TileStationList - createSdarsCollector()").log();
            }
            TileListCollector tileListCollector = new TileListCollector();
            if (null == stationInfo) {
                return tileListCollector;
            }
            if (null == resourceLocator || resourceLocator.url.length() <= 0 || resourceLocator.id <= 0) {
                resourceLocator = SatDb.getInstance().getImageDb().getImage(stationInfo.sID);
            }
            tileListCollector.mode = 3;
            tileListCollector.listIndex = n;
            tileListCollector.stationLogo = resourceLocator;
            tileListCollector.sdarsStationNumber = stationInfo.getStationNumber();
            tileListCollector.sdarsSid = stationInfo.getSID();
            tileListCollector.stationName = stationInfo.getFullLabel();
            return tileListCollector;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return new TileListCollector();
        }
    }

    public int addDabStation(ArrayList arrayList, ServiceInfo serviceInfo, int n, ResourceLocator resourceLocator) {
        try {
            if (null != ServiceManager.logger && ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("TileStationList - addDabStation()").log();
            }
            if (null != arrayList && null != serviceInfo) {
                TileListCollector tileListCollector = this.createDabCollector(serviceInfo, n, resourceLocator);
                if (null != ServiceManager.logger && ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append(tileListCollector.toString()).log();
                }
                arrayList.add(tileListCollector);
                ++n;
            }
            return n;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return n;
        }
    }

    public TileListCollector createDabCollector(ServiceInfo serviceInfo, int n, ResourceLocator resourceLocator) {
        try {
            if (null != ServiceManager.logger && ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("TileStationList - createDabCollector()").log();
            }
            TileListCollector tileListCollector = new TileListCollector();
            if (null == serviceInfo) {
                return tileListCollector;
            }
            tileListCollector.mode = 2;
            tileListCollector.listIndex = n;
            String string = serviceInfo.getShortName();
            if (null == string) {
                string = "";
            }
            tileListCollector.stationName = string;
            String string2 = serviceInfo.getFullName();
            if (null == string2) {
                string2 = "";
            }
            tileListCollector.stationNameFull = string2;
            if (null == resourceLocator) {
                resourceLocator = this.getDabStationLogo(serviceInfo);
            }
            tileListCollector.stationLogo = resourceLocator;
            tileListCollector.ecc = serviceInfo.getEnsECC();
            tileListCollector.piSid = (int)serviceInfo.getSID();
            tileListCollector.ensId = serviceInfo.getEnsID();
            return tileListCollector;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return new TileListCollector();
        }
    }

    public void activateStationInRadioTileList(boolean bl, int n, int n2) {
        try {
            if (null != ServiceManager.logger && ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("TileStationList - activateStationInRadioTileList( ").append(bl).append(", ").append(n).append(" )").log();
            }
            Object[] objectArray = ListManager.getGenericASLList(n).getDSIObjects();
            boolean bl2 = false;
            if (null == objectArray || objectArray.length < 2) {
                return;
            }
            TileListCollector[] tileListCollectorArray = (TileListCollector[])objectArray;
            if (null == tileListCollectorArray || tileListCollectorArray.length < 2) {
                return;
            }
            if (-1 == n2) {
                if (bl) {
                    this.setNextIndex(tileListCollectorArray);
                } else {
                    this.setPreviousIndex(tileListCollectorArray);
                }
            } else {
                bl2 = this.setIndex(tileListCollectorArray, n2);
            }
            if (this.currentListIndex > -1 && this.currentListIndex < tileListCollectorArray.length && null != tileListCollectorArray[this.currentListIndex] && !bl2) {
                RadioServiceManager.getServiceManager().getApiGuiRadioTiles().updateFollowModeInTile(true);
                RadioServiceManager.getServiceManager().getApiGuiRadioTiles().updateIndexOfTileLists(this.currentListIndex);
                this.selectStation(tileListCollectorArray[this.currentListIndex]);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void setNextIndex(TileListCollector[] tileListCollectorArray) {
        if (null == tileListCollectorArray) {
            return;
        }
        ++this.currentListIndex;
        if (this.currentListIndex < 0 || this.currentListIndex >= tileListCollectorArray.length) {
            this.currentListIndex = 0;
        }
    }

    public void setPreviousIndex(TileListCollector[] tileListCollectorArray) {
        if (null == tileListCollectorArray) {
            return;
        }
        --this.currentListIndex;
        if (this.currentListIndex < 0 || this.currentListIndex >= tileListCollectorArray.length) {
            this.currentListIndex = tileListCollectorArray.length - 1;
        }
    }

    public boolean setIndex(TileListCollector[] tileListCollectorArray, int n) {
        boolean bl = true;
        if (null == tileListCollectorArray) {
            return bl;
        }
        bl = this.currentListIndex == n;
        this.currentListIndex = n;
        if (this.currentListIndex < 0 || this.currentListIndex >= tileListCollectorArray.length) {
            this.currentListIndex = 0;
        }
        return bl;
    }

    public void selectStation(TileListCollector tileListCollector) {
        try {
            if (null != ServiceManager.logger && ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("TileStationList - selectStation()").log();
            }
            if (null == tileListCollector) {
                return;
            }
            this.setStationSelectionByTiles(true);
            this.startFreezeTileListTimer();
            int n = RadioCurrentWaveband.get();
            switch (n) {
                case 0: {
                    if (tileListCollector.mode != 0) break;
                    AmFmStation amFmStation = new AmFmStation((int)tileListCollector.frequency, tileListCollector.piSid, tileListCollector.amFmServiceId, tileListCollector.stationName, tileListCollector.amFmShortNameHd, tileListCollector.isHd, tileListCollector.stationLogo, tileListCollector.isRds);
                    SelectedStationHighlighting.setStationSelectionIsActive(false, false);
                    AmFmDsiApi.selectStation(amFmStation);
                    SelectedStationHighlighting.setStationSelectionIsActive(true, false);
                    break;
                }
                case 1: {
                    if (tileListCollector.mode != 1) break;
                    AmFmStation amFmStation = new AmFmStation((int)tileListCollector.frequency, tileListCollector.piSid, tileListCollector.amFmServiceId, tileListCollector.stationName, tileListCollector.amFmShortNameHd, tileListCollector.isHd, tileListCollector.stationLogo, tileListCollector.isRds);
                    SelectedStationHighlighting.setStationSelectionIsActive(false, false);
                    AmFmDsiApi.selectStation(amFmStation);
                    SelectedStationHighlighting.setStationSelectionIsActive(true, false);
                    break;
                }
                case 2: {
                    if (tileListCollector.mode != 2) break;
                    ServiceInfo serviceInfo = new ServiceInfo(tileListCollector.ensId, tileListCollector.ecc, tileListCollector.piSid, tileListCollector.stationName, tileListCollector.stationNameFull, new byte[0], false, false);
                    if (ServiceManager.logger.isTraceEnabled(256)) {
                        ServiceManager.logger.trace(256).append("Tuning DAB Service from Tile - ").append(serviceInfo.toString()).log();
                    }
                    EnsembleInfo ensembleInfo = RadioData.getDabDatabase().mTunerState.getEnsembleById(serviceInfo.ensID, serviceInfo.ensECC);
                    FrequencyInfo frequencyInfo = null;
                    if (null != ensembleInfo) {
                        frequencyInfo = RadioData.getDabDatabase().mTunerState.getFrequencyByValue(ensembleInfo.frequencyValue);
                    }
                    RadioData.getDabDatabase().mTunerState.tuneService(serviceInfo, ensembleInfo);
                    DabMainApi.notifyCurrentStationInfo(frequencyInfo, ensembleInfo, serviceInfo, null);
                    break;
                }
                case 3: {
                    if (tileListCollector.mode != 3) break;
                    StationInfo stationInfo = SatDb.getInstance().getChannels().getChannelBySID(tileListCollector.sdarsSid);
                    SatDb.getInstance().getTuneHandler().tuneChannel(2, stationInfo, false);
                    break;
                }
                default: {
                    ServiceManager.logger.error(128).append("TileStationList - selectStation() - waveband = ").append(n).log();
                }
            }
            this.setStationSelectionByTiles(false);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void activateStationInRadioTileList(EventGeneric eventGeneric, int n) {
        try {
            if (null == eventGeneric || eventGeneric.getParamCount() < 1) {
                return;
            }
            int n2 = eventGeneric.getInt(0);
            this.activateStationInRadioTileList(false, n, n2);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public TileListCollector[] createAmStationList() {
        try {
            TileListCollector[] tileListCollectorArray;
            Object[] objectArray;
            if (null != ServiceManager.logger && ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("TileStationList - createAmStationList()").log();
            }
            AmFmStation amFmStation = RadioData.getAmfmDatabase().getSettingsPersistable().getCurrentAmStation();
            ArrayList arrayList = new ArrayList(0);
            AmFmStationListAM amFmStationListAM = RadioData.getAmfmDatabase().getAslStationListAM();
            this.currentListIndex = 0;
            if (null != amFmStation) {
                arrayList.add(amFmStation);
            }
            if (null != amFmStationListAM && null != (objectArray = amFmStationListAM.getListAsTreeSet())) {
                tileListCollectorArray = objectArray.iterator();
                if (null != objectArray) {
                    while (tileListCollectorArray.hasNext()) {
                        AmFmStation amFmStation2 = (AmFmStation)tileListCollectorArray.next();
                        if (null == amFmStation2 || null != amFmStation && amFmStation.match(amFmStation2, 0)) continue;
                        if (ServiceManager.configManagerDiag.isFeatureFlagSet(2) && RadioData.getAmfmDatabase().getSettingsPersistable().getAMHDFilter()) {
                            if (!amFmStation2.isHD()) continue;
                            arrayList.add(amFmStation2);
                            continue;
                        }
                        arrayList.add(amFmStation2);
                    }
                }
            }
            objectArray = (AmFmStation[])arrayList.toArray(new AmFmStation[arrayList.size()]);
            tileListCollectorArray = null;
            if (null != objectArray) {
                if (objectArray.length > 1) {
                    Arrays.sort(objectArray, FrequencyHDComparatorChain.INSTANCE);
                }
                tileListCollectorArray = new TileListCollector[objectArray.length];
                for (int i2 = 0; i2 < objectArray.length; ++i2) {
                    tileListCollectorArray[i2] = this.createAmCollector((AmFmStation)objectArray[i2], i2 + 1, null);
                    if (null != ServiceManager.logger && ServiceManager.logger.isTraceEnabled(128)) {
                        ServiceManager.logger.trace(128).append(tileListCollectorArray[i2].toString()).log();
                    }
                    if (null == objectArray[i2] || null == amFmStation || amFmStation.getFrequency() != ((AmFmStation)objectArray[i2]).getFrequency()) continue;
                    this.currentListIndex = i2;
                }
                RadioServiceManager.getServiceManager().getApiGuiRadioTiles().updateTileLists(tileListCollectorArray, this.currentListIndex);
            }
            return tileListCollectorArray;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return null;
        }
    }

    public TileListCollector[] createFmStationList() {
        try {
            TileListCollector[] tileListCollectorArray;
            Object[] objectArray;
            if (null != ServiceManager.logger && ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("TileStationList - createFmStationList()").log();
            }
            AmFmStation amFmStation = RadioData.getAmfmDatabase().getSettingsPersistable().getCurrentFmStation();
            ArrayList arrayList = new ArrayList(0);
            AmFmStationListFM amFmStationListFM = RadioData.getAmfmDatabase().getAslStationListFM();
            this.currentListIndex = 0;
            if (null != amFmStation) {
                arrayList.add(amFmStation);
            }
            if (null != amFmStationListFM && null != (objectArray = amFmStationListFM.getListAsTreeSet())) {
                tileListCollectorArray = objectArray.iterator();
                if (null != objectArray) {
                    while (tileListCollectorArray.hasNext()) {
                        AmFmStation amFmStation2 = (AmFmStation)tileListCollectorArray.next();
                        if (null == amFmStation2 || null != amFmStation && amFmStation.match(amFmStation2, 1)) continue;
                        if (ServiceManager.configManagerDiag.isFeatureFlagSet(2) && RadioData.getAmfmDatabase().getSettingsPersistable().getFMHDFilter()) {
                            if (!amFmStation2.isHD()) continue;
                            arrayList.add(amFmStation2);
                            continue;
                        }
                        arrayList.add(amFmStation2);
                    }
                }
            }
            objectArray = (AmFmStation[])arrayList.toArray(new AmFmStation[arrayList.size()]);
            tileListCollectorArray = null;
            if (null != objectArray) {
                if (objectArray.length > 1) {
                    Arrays.sort(objectArray, AmFmFactory.getInstanceEUStationListViewWalker().getFmComparator());
                }
                tileListCollectorArray = new TileListCollector[objectArray.length];
                for (int i2 = 0; i2 < objectArray.length; ++i2) {
                    tileListCollectorArray[i2] = this.createFmCollector((AmFmStation)objectArray[i2], i2 + 1, null);
                    if (null != ServiceManager.logger && ServiceManager.logger.isTraceEnabled(128)) {
                        ServiceManager.logger.trace(128).append(tileListCollectorArray[i2].toString()).log();
                    }
                    if (null == objectArray[i2] || null == amFmStation || amFmStation.getFrequency() != ((AmFmStation)objectArray[i2]).getFrequency() || amFmStation.getPi() != ((AmFmStation)objectArray[i2]).getPi() || amFmStation.getServiceId() != ((AmFmStation)objectArray[i2]).getServiceId()) continue;
                    this.currentListIndex = i2;
                }
                RadioServiceManager.getServiceManager().getApiGuiRadioTiles().updateTileLists(tileListCollectorArray, this.currentListIndex);
            }
            return tileListCollectorArray;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return null;
        }
    }

    public TileListCollector[] createDabStationList() {
        try {
            if (null != ServiceManager.logger && ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("TileStationList - createDabStationList()").log();
            }
            ServiceInfo serviceInfo = RadioData.getDabDatabase().mTunerState.getCurrentService();
            ArrayList arrayList = new ArrayList(0);
            ServiceInfo[] serviceInfoArray = RadioData.getDabDatabase().mTunerState.getServiceList();
            this.currentListIndex = 0;
            if (null != serviceInfo) {
                arrayList.add(serviceInfo);
            }
            if (null != serviceInfoArray) {
                for (int i2 = 0; i2 < serviceInfoArray.length; ++i2) {
                    if (null == serviceInfoArray[i2] || null != serviceInfo && DabTunerState.compare(serviceInfoArray[i2], serviceInfo)) continue;
                    arrayList.add(serviceInfoArray[i2]);
                }
            }
            Object[] objectArray = (ServiceInfo[])arrayList.toArray(new ServiceInfo[arrayList.size()]);
            TileListCollector[] tileListCollectorArray = null;
            if (null != objectArray) {
                if (objectArray.length > 1) {
                    Arrays.sort(objectArray, RadioServiceManager.getServiceManager().getTileServiceComparator());
                }
                tileListCollectorArray = new TileListCollector[objectArray.length];
                for (int i3 = 0; i3 < objectArray.length; ++i3) {
                    tileListCollectorArray[i3] = this.createDabCollector((ServiceInfo)objectArray[i3], i3 + 1, null);
                    if (null != ServiceManager.logger && ServiceManager.logger.isTraceEnabled(128)) {
                        ServiceManager.logger.trace(128).append(tileListCollectorArray[i3].toString()).log();
                    }
                    if (!DabTunerState.compare(serviceInfo, (ServiceInfo)objectArray[i3])) continue;
                    this.currentListIndex = i3;
                }
                if (null == serviceInfo && tileListCollectorArray.length > 0 && this.isTileSVisible()) {
                    this.selectStation(tileListCollectorArray[0]);
                }
                RadioServiceManager.getServiceManager().getApiGuiRadioTiles().updateTileLists(tileListCollectorArray, this.currentListIndex);
            }
            return tileListCollectorArray;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return null;
        }
    }

    public TileListCollector[] createSdarsStationList() {
        try {
            int n;
            if (null != ServiceManager.logger && ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("TileStationList - createSdarStationList()").log();
            }
            StationInfo stationInfo = SatDb.getInstance().getListApi().getSatListModel().getCurrentChannel();
            ArrayList arrayList = new ArrayList(0);
            this.currentListIndex = 0;
            StationInfo[] stationInfoArray = null;
            IChannelWalker iChannelWalker = SatDb.getInstance().getTileChannelWalker();
            boolean bl = false;
            if (iChannelWalker != null) {
                iChannelWalker.fill();
                stationInfoArray = iChannelWalker.getArray();
            }
            if (stationInfoArray != null && stationInfoArray.length > 0 && null != stationInfo) {
                for (n = 0; n < stationInfoArray.length; ++n) {
                    if (stationInfoArray[n] == null || stationInfoArray[n].sID != stationInfo.sID) continue;
                    bl = true;
                    break;
                }
            }
            if (!bl && iChannelWalker != null) {
                iChannelWalker.addElementAndReSort(stationInfo);
                stationInfoArray = iChannelWalker.getArray();
            }
            if (stationInfoArray != null && stationInfoArray.length > 0) {
                for (n = 0; n < stationInfoArray.length; ++n) {
                    if (stationInfoArray[n] == null) continue;
                    arrayList.add(stationInfoArray[n]);
                }
            }
            StationInfo[] stationInfoArray2 = (StationInfo[])arrayList.toArray(new StationInfo[arrayList.size()]);
            TileListCollector[] tileListCollectorArray = null;
            if (null != arrayList) {
                tileListCollectorArray = new TileListCollector[stationInfoArray2.length];
                for (int i2 = 0; i2 < stationInfoArray2.length; ++i2) {
                    tileListCollectorArray[i2] = this.createSdarsCollector(stationInfoArray2[i2], i2 + 1, null);
                    if (null == ServiceManager.logger || ServiceManager.logger.isTraceEnabled(128)) {
                        // empty if block
                    }
                    if (null == stationInfoArray2[i2] || null == stationInfo || stationInfo.getSID() != stationInfoArray2[i2].getSID()) continue;
                    this.currentListIndex = i2;
                }
                RadioServiceManager.getServiceManager().getApiGuiRadioTiles().updateTileLists(tileListCollectorArray, this.currentListIndex);
            }
            return tileListCollectorArray;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return null;
        }
    }

    public void updateSelectedSdarsChannel(StationInfo stationInfo, int n) {
        try {
            Object[] objectArray;
            if (null == stationInfo) {
                if (null != ServiceManager.logger) {
                    ServiceManager.logger.error(128).append("TileStationList - updateSelectedSdarsChannel() - null == newSdarsChannel").log();
                }
                return;
            }
            if (null != ServiceManager.logger && ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("TileStationList - updateSelectedSdarsChannel()").log();
            }
            if (null == (objectArray = ListManager.getGenericASLList(n).getDSIObjects()) || objectArray.length < 1) {
                return;
            }
            TileListCollector[] tileListCollectorArray = (TileListCollector[])objectArray;
            if (null == tileListCollectorArray || tileListCollectorArray.length < 1) {
                return;
            }
            if (this.currentListIndex < 0 || this.currentListIndex >= tileListCollectorArray.length) {
                return;
            }
            if (stationInfo.getSID() == tileListCollectorArray[this.currentListIndex].sdarsSid) {
                return;
            }
            boolean bl = false;
            for (int i2 = 0; i2 < tileListCollectorArray.length; ++i2) {
                if (null == tileListCollectorArray[i2] || stationInfo.getSID() != tileListCollectorArray[i2].sdarsSid) continue;
                this.currentListIndex = i2;
                bl = true;
                break;
            }
            if (bl) {
                RadioServiceManager.getServiceManager().getApiGuiRadioTiles().updateIndexOfTileLists(this.currentListIndex);
            } else {
                tileListCollectorArray[this.currentListIndex].sdarsSid = stationInfo.sID;
                tileListCollectorArray[this.currentListIndex].sdarsStationNumber = stationInfo.stationNumber;
                tileListCollectorArray[this.currentListIndex].stationLogo = SatDb.getInstance().getImageDb().getImage(stationInfo.sID);
                tileListCollectorArray[this.currentListIndex].stationName = stationInfo.getFullLabel();
                ListManager.getGenericASLList(n).updateListItem(this.currentListIndex, tileListCollectorArray[this.currentListIndex]);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void updateSelectedDabService(ServiceInfo serviceInfo, int n) {
        try {
            Object[] objectArray;
            if (null == serviceInfo) {
                if (null != ServiceManager.logger) {
                    ServiceManager.logger.error(128).append("TileStationList - updateSelectedDabService() - null == newDabService").log();
                }
                return;
            }
            if (null != ServiceManager.logger && ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("TileStationList - updateSelectedDabService()").log();
            }
            if (null == (objectArray = ListManager.getGenericASLList(n).getDSIObjects()) || objectArray.length < 1) {
                return;
            }
            TileListCollector[] tileListCollectorArray = (TileListCollector[])objectArray;
            if (null == tileListCollectorArray || tileListCollectorArray.length < 1) {
                return;
            }
            if (this.currentListIndex < 0 || this.currentListIndex >= tileListCollectorArray.length) {
                return;
            }
            boolean bl = false;
            if (null != tileListCollectorArray[this.currentListIndex] && null != serviceInfo && serviceInfo.getSID() == (long)tileListCollectorArray[this.currentListIndex].piSid && serviceInfo.getEnsID() == tileListCollectorArray[this.currentListIndex].ensId && serviceInfo.getEnsECC() == tileListCollectorArray[this.currentListIndex].ecc) {
                bl = true;
            } else {
                for (int i2 = 0; i2 < tileListCollectorArray.length; ++i2) {
                    if (null == tileListCollectorArray[i2] || null == serviceInfo || serviceInfo.getSID() != (long)tileListCollectorArray[i2].piSid || serviceInfo.getEnsID() != tileListCollectorArray[i2].ensId || serviceInfo.getEnsECC() != tileListCollectorArray[i2].ecc) continue;
                    this.currentListIndex = i2;
                    RadioServiceManager.getServiceManager().getApiGuiRadioTiles().updateIndexOfTileLists(this.currentListIndex);
                    bl = true;
                    break;
                }
            }
            if (bl) {
                if (null == tileListCollectorArray[this.currentListIndex].stationLogo) {
                    tileListCollectorArray[this.currentListIndex].stationLogo = this.getDabStationLogo(serviceInfo);
                    ListManager.getGenericASLList(n).updateListItem(this.currentListIndex, tileListCollectorArray[this.currentListIndex]);
                }
            } else {
                String string = serviceInfo.getShortName();
                if (null == string) {
                    string = "";
                }
                tileListCollectorArray[this.currentListIndex].stationName = string;
                String string2 = serviceInfo.getFullName();
                if (null == string2) {
                    string2 = "";
                }
                tileListCollectorArray[this.currentListIndex].stationNameFull = string2;
                tileListCollectorArray[this.currentListIndex].stationLogo = this.getDabStationLogo(serviceInfo);
                tileListCollectorArray[this.currentListIndex].ecc = serviceInfo.getEnsECC();
                tileListCollectorArray[this.currentListIndex].piSid = (int)serviceInfo.getSID();
                tileListCollectorArray[this.currentListIndex].ensId = serviceInfo.getEnsID();
                ListManager.getGenericASLList(n).updateListItem(this.currentListIndex, tileListCollectorArray[this.currentListIndex]);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void updateLogoForSelectedAmFmHdStation(ResourceLocator resourceLocator, int n) {
        try {
            Object[] objectArray;
            if (null != ServiceManager.logger && ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("TileStationList - updateLogoForSelectedAmFmStation()").log();
            }
            if (null == (objectArray = ListManager.getGenericASLList(n).getDSIObjects()) || objectArray.length < 1) {
                return;
            }
            TileListCollector[] tileListCollectorArray = (TileListCollector[])objectArray;
            if (null == tileListCollectorArray || tileListCollectorArray.length < 1) {
                return;
            }
            if (this.currentListIndex < 0 || this.currentListIndex >= tileListCollectorArray.length) {
                return;
            }
            tileListCollectorArray[this.currentListIndex].stationLogo = resourceLocator;
            if (null != ServiceManager.logger && ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("Active Tile Station - ").append("updated with logo - ").append(tileListCollectorArray[this.currentListIndex].stationLogo).log();
            }
            ListManager.getGenericASLList(n).updateListItem(this.currentListIndex, tileListCollectorArray[this.currentListIndex]);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void updateSelectedAmFmStation(AmFmStation amFmStation, int n) {
        try {
            int n2;
            Object[] objectArray;
            if (null == amFmStation) {
                if (null != ServiceManager.logger) {
                    ServiceManager.logger.error(128).append("TileStationList - updateSelectedStation() - null == newDsiStation").log();
                }
                return;
            }
            if (null != ServiceManager.logger && ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("TileStationList - updateSelectedStation()").log();
            }
            if (null == (objectArray = ListManager.getGenericASLList(n).getDSIObjects()) || objectArray.length < 1) {
                return;
            }
            TileListCollector[] tileListCollectorArray = (TileListCollector[])objectArray;
            if (null == tileListCollectorArray || tileListCollectorArray.length < 1) {
                return;
            }
            if (this.currentListIndex < 0 || this.currentListIndex >= tileListCollectorArray.length) {
                return;
            }
            boolean bl = false;
            if (!this.compareAmFmStationWithTileStation(amFmStation, tileListCollectorArray[this.currentListIndex])) {
                for (n2 = 0; n2 < tileListCollectorArray.length; ++n2) {
                    if (null == tileListCollectorArray[n2] || !this.compareAmFmStationWithTileStation(amFmStation, tileListCollectorArray[n2])) continue;
                    this.currentListIndex = n2;
                    RadioServiceManager.getServiceManager().getApiGuiRadioTiles().updateIndexOfTileLists(this.currentListIndex);
                    bl = true;
                    break;
                }
            } else {
                bl = true;
            }
            if (!bl) {
                tileListCollectorArray[this.currentListIndex].frequency = amFmStation.getFrequency();
                tileListCollectorArray[this.currentListIndex].subChannelId = amFmStation.getSubChannel();
                tileListCollectorArray[this.currentListIndex].piSid = amFmStation.getPi();
                tileListCollectorArray[this.currentListIndex].stationLogo = this.getAmFmStationLogo(amFmStation);
                tileListCollectorArray[this.currentListIndex].isRds = amFmStation.isRds();
                tileListCollectorArray[this.currentListIndex].isScrollingPs = amFmStation.isScrollingPS();
                tileListCollectorArray[this.currentListIndex].originalAmFmStationName = amFmStation.getStationName();
                tileListCollectorArray[this.currentListIndex].waveband = amFmStation.getWaveband();
                tileListCollectorArray[this.currentListIndex].amFmServiceId = amFmStation.getServiceId();
                tileListCollectorArray[this.currentListIndex].amFmShortNameHd = amFmStation.getShortNameHD();
            }
            if (null != tileListCollectorArray[this.currentListIndex]) {
                n2 = RadioCurrentWaveband.get();
                switch (n2) {
                    case 0: {
                        this.setAmStationName(amFmStation, tileListCollectorArray[this.currentListIndex]);
                        break;
                    }
                    case 1: {
                        tileListCollectorArray[this.currentListIndex].stationName = this.getFmStationName(amFmStation, RadioDataSessionManager.getInstance().countryList.isDatabaseNameActivatedForPresets());
                        break;
                    }
                    default: {
                        return;
                    }
                }
                tileListCollectorArray[this.currentListIndex].stationLogo = this.getAmFmStationLogo(amFmStation);
                if (null != ServiceManager.logger && ServiceManager.logger.isTraceEnabled(128)) {
                    ServiceManager.logger.trace(128).append("New Tile Station - ").append(amFmStation.toString()).append("updated with logo - ").append(tileListCollectorArray[this.currentListIndex].stationLogo).log();
                }
                ListManager.getGenericASLList(n).updateListItem(this.currentListIndex, tileListCollectorArray[this.currentListIndex]);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    private boolean compareAmFmStationWithTileStation(AmFmStation amFmStation, TileListCollector tileListCollector) {
        AmFmStation amFmStation2 = new AmFmStation();
        amFmStation2.setFrequency(tileListCollector.frequency);
        amFmStation2.setRDS(tileListCollector.isRds);
        amFmStation2.setPI(tileListCollector.piSid);
        amFmStation2.setName(tileListCollector.originalAmFmStationName);
        amFmStation2.setScrollingPs(tileListCollector.isScrollingPs);
        amFmStation2.setSubchannel(tileListCollector.subChannelId);
        amFmStation2.setServiceId(tileListCollector.amFmServiceId);
        return amFmStation.match(amFmStation2, RadioCurrentWaveband.get());
    }

    public String getFmStationName(AmFmStation amFmStation, boolean bl) {
        try {
            if (null != ServiceManager.logger && ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("TileStationList - setFmStationName()").log();
            }
            String string = "";
            if (null == amFmStation) {
                return string;
            }
            int n = amFmStation.getFrequency();
            if (null != ServiceManager.configManagerDiag && null != ServiceManager.fixFormat4Asl && ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
                string = amFmStation.isHD() ? (RadioData.getAmfmDatabase().hasSubServiceList(amFmStation) || amFmStation.getSubChannelCount() > 0 || amFmStation.getServiceId() > 1 ? ServiceManager.fixFormat4Asl.fmtRadioFrequencyFmNar(n, amFmStation.getSubChannel()) : ServiceManager.fixFormat4Asl.fmtRadioFrequencyFmNar(n, 0)) : ServiceManager.fixFormat4Asl.fmtRadioFrequencyFmNar(n, -1);
            } else {
                String string2 = RadioServiceManager.getServiceManager().getCorrectFmStationName(amFmStation);
                if (string2 != null && string2.length() > 1) {
                    if (null != ServiceManager.configManagerDiag && (ServiceManager.configManagerDiag.isFeatureFlagSet(423) || bl && RadioData.getAmfmDatabase().getSettingsPersistable().isAutoStoreLogoActive())) {
                        string = string2;
                    } else if (AmfmRDSOption.get()) {
                        string = string2;
                    } else if (null != ServiceManager.fixFormat4Asl) {
                        string = ServiceManager.fixFormat4Asl.fmtRadioFrequencyFmMhz(n, "");
                    }
                } else if (null != ServiceManager.fixFormat4Asl) {
                    string = ServiceManager.fixFormat4Asl.fmtRadioFrequencyFmMhz(n, "");
                }
            }
            return string;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return "";
        }
    }

    public void setAmStationName(AmFmStation amFmStation, TileListCollector tileListCollector) {
        try {
            if (null != ServiceManager.logger && ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("TileStationList - setAmStationName()").log();
            }
            if (null == amFmStation || null == tileListCollector) {
                return;
            }
            String string = AmFmFactory.getAslAmfmModelController().getAmStationName(amFmStation);
            if (string != null && string.length() > 1) {
                tileListCollector.stationName = string;
            } else if (null != ServiceManager.fixFormat4Asl) {
                int n = amFmStation.getFrequency();
                tileListCollector.stationName = null != ServiceManager.configManagerDiag && ServiceManager.configManagerDiag.isFeatureFlagSet(2) ? (amFmStation.isHD() ? (RadioData.getAmfmDatabase().hasSubServiceList(amFmStation) || amFmStation.getSubChannelCount() > 0 || amFmStation.getServiceId() > 1 ? ServiceManager.fixFormat4Asl.fmtRadioFrequencyAmNar(n, amFmStation.getSubChannel()) : ServiceManager.fixFormat4Asl.fmtRadioFrequencyAmNar(n, 0)) : ServiceManager.fixFormat4Asl.fmtRadioFrequencyAmNar(n, -1)) : ServiceManager.fixFormat4Asl.fmtRadioFrequencyAmKhz(n, "");
            }
            if (null == tileListCollector.stationName) {
                tileListCollector.stationName = "";
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public boolean isTileSVisible() {
        return this.isTileSVisible;
    }

    public void setTileSVisible(boolean bl) {
        this.isTileSVisible = bl;
        if (bl) {
            this.startUpdateTileListTimer();
        } else {
            RadioServiceManager.getServiceManager().getApiGuiRadioTiles().updateLoadStatusOfTileS(true);
            this.stopTileCoverArtTimer();
        }
    }

    public boolean isTileLVisible() {
        return this.isTileLVisible;
    }

    public void setTileLVisible(boolean bl) {
        this.isTileLVisible = bl;
        if (!this.isTileSVisible) {
            RadioServiceManager.getServiceManager().getApiGuiRadioTiles().updateLoadStatusOfTileS(true);
            this.stopTileCoverArtTimer();
        }
    }

    public void setFmDatabaseData(int n) {
        try {
            if (null != ServiceManager.logger && ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("TileStationList - setFmDatabaseData()").log();
            }
            if (RadioCurrentWaveband.isFm()) {
                AmFmStation amFmStation = new AmFmStation();
                Object[] objectArray = ListManager.getGenericASLList(n).getDSIObjects();
                if (null == objectArray || objectArray.length < 1) {
                    return;
                }
                TileListCollector[] tileListCollectorArray = (TileListCollector[])objectArray;
                if (null == tileListCollectorArray || tileListCollectorArray.length < 1) {
                    return;
                }
                for (int i2 = 0; i2 < tileListCollectorArray.length; ++i2) {
                    if (null == tileListCollectorArray[i2] || null != tileListCollectorArray[i2].stationLogo) continue;
                    amFmStation.setFrequency(tileListCollectorArray[i2].frequency);
                    amFmStation.setRDS(tileListCollectorArray[i2].isRds);
                    amFmStation.setPI(tileListCollectorArray[i2].piSid);
                    amFmStation.setName(tileListCollectorArray[i2].originalAmFmStationName);
                    amFmStation.setScrollingPs(tileListCollectorArray[i2].isScrollingPs);
                    amFmStation.setWaveband(tileListCollectorArray[i2].waveband);
                    amFmStation.setServiceId(tileListCollectorArray[i2].amFmServiceId);
                    amFmStation.setShortNameHD(tileListCollectorArray[i2].amFmShortNameHd);
                    ResourceLocator resourceLocator = this.getAmFmStationLogo(amFmStation);
                    if (null == resourceLocator) continue;
                    tileListCollectorArray[i2].stationLogo = resourceLocator;
                    ListManager.getGenericASLList(n).updateListItem(i2, tileListCollectorArray[i2]);
                }
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void setDabDatabaseData(int n) {
        try {
            if (null != ServiceManager.logger && ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("TileStationList - setDabDatabaseData()").log();
            }
            if (RadioCurrentWaveband.isDab()) {
                ServiceInfo serviceInfo = new ServiceInfo();
                Object[] objectArray = ListManager.getGenericASLList(n).getDSIObjects();
                if (null == objectArray || objectArray.length < 1) {
                    return;
                }
                TileListCollector[] tileListCollectorArray = (TileListCollector[])objectArray;
                if (null == tileListCollectorArray || tileListCollectorArray.length < 1) {
                    return;
                }
                for (int i2 = 0; i2 < tileListCollectorArray.length; ++i2) {
                    if (null == tileListCollectorArray[i2] || null != tileListCollectorArray[i2].stationLogo) continue;
                    serviceInfo.sID = tileListCollectorArray[i2].piSid;
                    serviceInfo.ensID = tileListCollectorArray[i2].ensId;
                    serviceInfo.ensECC = tileListCollectorArray[i2].ecc;
                    serviceInfo.shortName = tileListCollectorArray[i2].stationName;
                    serviceInfo.fullName = tileListCollectorArray[i2].stationNameFull;
                    ResourceLocator resourceLocator = this.getDabStationLogo(serviceInfo);
                    if (null == resourceLocator) continue;
                    tileListCollectorArray[i2].stationLogo = resourceLocator;
                    ListManager.getGenericASLList(n).updateListItem(i2, tileListCollectorArray[i2]);
                }
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public boolean isStationSelectionByTiles() {
        return this.stationSelectionByTiles;
    }

    public void setStationSelectionByTiles(boolean bl) {
        this.stationSelectionByTiles = bl;
    }

    public void startFreezeTileListTimer() {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("TileStationList - startFreezeTileListTimer()").log();
        }
        if (1 == AmfmScopeOfArrowKeys.get() && !RadioCurrentWaveband.isSdars()) {
            RadioServiceManager.getServiceManager().getRadioAmFMTarget().retriggerOrStartTimer(-1467547392, (long)0, false);
            this.freezeTileList = true;
        }
    }

    public void stopFreezeTileListTimer() {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("TileStationList - stopFreezeTileListTimer()").log();
        }
        RadioServiceManager.getServiceManager().getRadioAmFMTarget().stopTimer(-1467547392);
        this.freezeTileList = false;
    }

    public void startUpdateTileListTimer() {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("TileStationList - startUpdateTileListTimer()").log();
        }
        if (1 == AmfmScopeOfArrowKeys.get() && !RadioCurrentWaveband.isSdars()) {
            if (this.isTileListEmpty()) {
                ServiceManager.logger.info(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("TileStationList - startUpdateTileListTimer() 5sec SHORT_ON_EMPTY").log();
                RadioServiceManager.getServiceManager().getRadioAmFMTarget().retriggerOrStartTimer(-1450770176, (long)0, false);
            } else {
                RadioServiceManager.getServiceManager().getRadioAmFMTarget().retriggerOrStartTimer(-1450770176, (long)0, false);
            }
            this.updateTileList = false;
        }
    }

    private boolean isTileListEmpty() {
        Object[] objectArray = ListManager.getGenericASLList(1170613248).getDSIObjects();
        boolean bl = null == objectArray || objectArray.length < 1;
        return bl;
    }

    public void stopUpdateTileListTimer() {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("TileStationList - stopUpdateTileListTimer()").log();
        }
        RadioServiceManager.getServiceManager().getRadioAmFMTarget().stopTimer(-1450770176);
        this.updateTileList = false;
    }

    public void stopTileCoverArtTimer() {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("TileStationList - stopTileCoverArtTimer()").log();
        }
        RadioServiceManager.getServiceManager().getRadioAmFMTarget().stopTimer(-1433992960);
    }

    public void startTileCoverArtTimer() {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("TileStationList - startTileCoverArtTimer()").log();
        }
        RadioServiceManager.getServiceManager().getRadioAmFMTarget().retriggerOrStartTimer(-1433992960, (long)0, false);
    }

    public void reCreateTileList() {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("TileStationList - reCreateTileList()").log();
        }
        if (!this.freezeTileList && this.updateTileList && 1 == AmfmScopeOfArrowKeys.get()) {
            this.initTiles();
        }
        this.startUpdateTileListTimer();
    }

    public void freezeTileListTimerExpired() {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("TileStationList - freezeTileListTimerExpired()").log();
        }
        this.freezeTileList = false;
        this.reCreateTileList();
    }

    public void updatedTileListTimerExpired() {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_MAIN).append("TileStationList - updatedTileListTimerExpired()").log();
        }
        this.updateTileList = true;
        this.reCreateTileList();
    }
}

