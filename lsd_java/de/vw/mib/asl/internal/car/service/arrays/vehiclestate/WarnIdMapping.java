/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.service.arrays.vehiclestate;

import de.vw.mib.asl.internal.car.service.arrays.vehiclestate.WarnIdMapping$MappedWarnIdData;
import de.vw.mib.asl.internal.car.service.arrays.vehiclestate.WarnIdMapping$MappedWarnIdDataValue;
import de.vw.mib.configuration.ConfigurationManagerDiag;
import de.vw.mib.dynamicresourcedata.DynamicResourceData;
import de.vw.mib.dynamicresourcedata.DynamicResourceDataDescription;

class WarnIdMapping {
    private static final String COLUMN_INPUT_UNIQUE_WARN_ID;
    private static final String COLUMN_OUTPUT_ICON_IMAGE;
    private static final String COLUMN_OUTPUT_ICON_COLOR;
    private static final String COLUMN_OUTPUT_COMPONENT_ID;
    private static final String COLUMN_OUTPUT_COMPONENT_COLOR;
    private static final int COLUMN_NOT_FOUND_DEFAULT_VALUE;
    private static final int COLUMN_ORDER_ICON_IMAGE;
    private static final int COLUMN_ORDER_ICON_COLOR;
    private static final int COLUMN_ORDER_COMPONENT_ID;
    private static final int COLUMN_ORDER_COMPONENT_COLOR;
    private static final int COLUMN_NUMBER_OF_COLUMNS;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$car$service$arrays$vehiclestate$WarnIdMapping;

    WarnIdMapping() {
    }

    private ConfigurationManagerDiag getConfigurationManager() {
        return null;
    }

    private DynamicResourceDataDescription newVehicleIdsResourceDescription() {
        return null;
    }

    private static DynamicResourceData getVehicleResourceDataMap(DynamicResourceDataDescription dynamicResourceDataDescription) {
        dynamicResourceDataDescription.input("UniqueVehicleWarnId").output("VehicleWarnIconImage", -1).output("VehicleWarnIconColor", -1).output("VehicleWarnComponentId", -1).output("VehicleWarnComponentColor", -1);
        return dynamicResourceDataDescription.create();
    }

    protected WarnIdMapping$MappedWarnIdData mapWarnId(int n) {
        DynamicResourceData dynamicResourceData = WarnIdMapping.getVehicleResourceDataMap(this.newVehicleIdsResourceDescription());
        int[] nArray = WarnIdMapping.getVehicleResourceDataMap(this.newVehicleIdsResourceDescription()).map(new int[]{n});
        if (!$assertionsDisabled && nArray.length != 4) {
            throw new AssertionError();
        }
        String string = dynamicResourceData.mapImagePath(nArray[0]);
        int n2 = nArray[1];
        int n3 = nArray[2];
        int n4 = nArray[3];
        return new WarnIdMapping$MappedWarnIdDataValue(this, n, string, n2, n3, n4);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        $assertionsDisabled = !(class$de$vw$mib$asl$internal$car$service$arrays$vehiclestate$WarnIdMapping == null ? (class$de$vw$mib$asl$internal$car$service$arrays$vehiclestate$WarnIdMapping = WarnIdMapping.class$("de.vw.mib.asl.internal.car.service.arrays.vehiclestate.WarnIdMapping")) : class$de$vw$mib$asl$internal$car$service$arrays$vehiclestate$WarnIdMapping).desiredAssertionStatus();
    }
}

