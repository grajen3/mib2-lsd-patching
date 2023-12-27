/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreImpl.corecommon;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.online.coreImpl.corecommon.CoreServiceMappingTable;
import de.vw.mib.collections.ObjectIntOptHashMap;
import de.vw.mib.util.Util;

public final class CoreServiceFeatureFlagMap {
    ObjectIntOptHashMap _serviceIDToFeatureFlag;

    private void initialize() {
        this._serviceIDToFeatureFlag = new ObjectIntOptHashMap();
        this._serviceIDToFeatureFlag.put("owner_v1", ServiceManager.configManagerDiag.isFeatureFlagSet(184) ? 1 : 0);
        this._serviceIDToFeatureFlag.put("traffic-online_v1", ServiceManager.configManagerDiag.isFeatureFlagSet(195) ? 1 : 0);
        this._serviceIDToFeatureFlag.put("personalpoi_v1", ServiceManager.configManagerDiag.isFeatureFlagSet(191) ? 1 : 0);
        this._serviceIDToFeatureFlag.put("gasstations_v1", ServiceManager.configManagerDiag.isFeatureFlagSet(186) ? 1 : 0);
        this._serviceIDToFeatureFlag.put("parkinfo_v1", ServiceManager.configManagerDiag.isFeatureFlagSet(186) ? 1 : 0);
        this._serviceIDToFeatureFlag.put("fpi_v2", ServiceManager.configManagerDiag.isFeatureFlagSet(186) ? 1 : 0);
        this._serviceIDToFeatureFlag.put("poi_v2", ServiceManager.configManagerDiag.isFeatureFlagSet(192) ? 1 : 0);
        this._serviceIDToFeatureFlag.put("poivoice_v1", ServiceManager.configManagerDiag.isFeatureFlagSet(193) ? 1 : 0);
        this._serviceIDToFeatureFlag.put("poi-echarge", ServiceManager.configManagerDiag.isFeatureFlagSet(186) ? 1 : 0);
        this._serviceIDToFeatureFlag.put("zieleinspeisung_v2", ServiceManager.configManagerDiag.isFeatureFlagSet(185) ? 1 : 0);
        this._serviceIDToFeatureFlag.put("travelguide_v1", ServiceManager.configManagerDiag.isFeatureFlagSet(197) ? 1 : 0);
        this._serviceIDToFeatureFlag.put("menu_v2", ServiceManager.configManagerDiag.isFeatureFlagSet(183) ? 1 : 0);
        this._serviceIDToFeatureFlag.put("satellitemaps_v1", ServiceManager.configManagerDiag.isFeatureFlagSet(187) ? 1 : 0);
        this._serviceIDToFeatureFlag.put("streetview_v1", ServiceManager.configManagerDiag.isFeatureFlagSet(188) ? 1 : 0);
        this._serviceIDToFeatureFlag.put("traffic_minimap", ServiceManager.configManagerDiag.isFeatureFlagSet(196) ? 1 : 0);
        this._serviceIDToFeatureFlag.put("traffic_minimap", ServiceManager.configManagerDiag.isFeatureFlagSet(195) ? 1 : 0);
        this._serviceIDToFeatureFlag.put("tourimport_v1", ServiceManager.configManagerDiag.isFeatureFlagSet(194) ? 1 : 0);
        this._serviceIDToFeatureFlag.put("vehiclehealth_v1", ServiceManager.configManagerDiag.isFeatureFlagSet(199) ? 1 : 0);
        this._serviceIDToFeatureFlag.put("cc_breakdown_v2", ServiceManager.configManagerDiag.isFeatureFlagSet(190) ? 1 : 0);
        this._serviceIDToFeatureFlag.put("ccpoi_v1", ServiceManager.configManagerDiag.isFeatureFlagSet(190) ? 1 : 0);
        this._serviceIDToFeatureFlag.put("news_v2", ServiceManager.configManagerDiag.isFeatureFlagSet(183) ? 1 : 0);
        this._serviceIDToFeatureFlag.put("weather_v2", ServiceManager.configManagerDiag.isFeatureFlagSet(183) ? 1 : 0);
        this._serviceIDToFeatureFlag.put("gracenote_v1", ServiceManager.configManagerDiag.isFeatureFlagSet(86) ? 1 : 0);
        this._serviceIDToFeatureFlag.put("otacusession_v1", ServiceManager.configManagerDiag.isFeatureFlagSet(198) ? 1 : 0);
        this._serviceIDToFeatureFlag.put("otacupromotion_v1", ServiceManager.configManagerDiag.isFeatureFlagSet(198) ? 1 : 0);
        this._serviceIDToFeatureFlag.put("otacunav_v1", ServiceManager.configManagerDiag.isFeatureFlagSet(198) ? 1 : 0);
        this._serviceIDToFeatureFlag.put("otacuppoi_v1", ServiceManager.configManagerDiag.isFeatureFlagSet(191) ? 1 : 0);
        this._serviceIDToFeatureFlag.put("musicstreaming_v2", 1);
        this._serviceIDToFeatureFlag.put("dealerappoint_v1", 1);
        this._serviceIDToFeatureFlag.put("dwap", 1);
        this._serviceIDToFeatureFlag.put("geofence_v1", 1);
        this._serviceIDToFeatureFlag.put("infocall_v1", 1);
        this._serviceIDToFeatureFlag.put("license_v1", 1);
        this._serviceIDToFeatureFlag.put("rbatterycharge_v1", 1);
        this._serviceIDToFeatureFlag.put("rclima_v1", 1);
        this._serviceIDToFeatureFlag.put("rheating_v1", 1);
        this._serviceIDToFeatureFlag.put("rhonk_v1", 1);
        this._serviceIDToFeatureFlag.put("rlu_v1", 1);
        this._serviceIDToFeatureFlag.put("speedalert_v1", 1);
        this._serviceIDToFeatureFlag.put("timerprogramming_v1", 1);
        this._serviceIDToFeatureFlag.put("trip_statistic_v1", 1);
        this._serviceIDToFeatureFlag.put("updatetruststore", 1);
        this._serviceIDToFeatureFlag.put("vehicletelemetry_v1", 1);
        this._serviceIDToFeatureFlag.put("jobs_v1", 1);
        this._serviceIDToFeatureFlag.put("services_v1", 1);
        this._serviceIDToFeatureFlag.put("devicereset_v1", 1);
        this._serviceIDToFeatureFlag.put("primaryuser_v1", 1);
        this._serviceIDToFeatureFlag.put("vehicleusers_v1", 1);
        this._serviceIDToFeatureFlag.put("powerManagementConf_v1", 1);
        this._serviceIDToFeatureFlag.put("communicationConf_v1", 1);
        this._serviceIDToFeatureFlag.put("download-srv", 1);
        this._serviceIDToFeatureFlag.put("carfinder_v1", 1);
        this._serviceIDToFeatureFlag.put("ecall_v1", ServiceManager.configManagerDiag.isFeatureFlagSet(393) ? 1 : 0);
        this._serviceIDToFeatureFlag.put("onlineradiodata_v1", ServiceManager.configManagerDiag.isFeatureFlagSet(200) ? 1 : 0);
        this._serviceIDToFeatureFlag.put("hybridradiodata_v1", ServiceManager.configManagerDiag.isFeatureFlagSet(189) ? 1 : 0);
        this._serviceIDToFeatureFlag.put("hybridradiorange_v1", ServiceManager.configManagerDiag.isFeatureFlagSet(189) ? 1 : 0);
    }

    private ObjectIntOptHashMap getMap() {
        if (this._serviceIDToFeatureFlag == null) {
            this.initialize();
        }
        return this._serviceIDToFeatureFlag;
    }

    public boolean isValidService(String string) {
        return CoreServiceMappingTable.isValidService(string) && this.isFeatureFlagSetForService(string);
    }

    public boolean isFeatureFlagSetForService(String string) {
        if (!Util.isNullOrEmpty(string)) {
            return this.getMap().get(string) != 0;
        }
        return false;
    }
}

