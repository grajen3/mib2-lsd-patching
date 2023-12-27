/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.servicebridge;

import de.vw.mib.asl.api.online.servicebridge.ASLOnlineServiceBridgeFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.online.servicebridge.OnlineServiceBridge;
import de.vw.mib.collections.ints.IntArrayList;
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.has.HAS;
import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASException;
import generated.de.vw.mib.has.containers.AddressContainer;
import generated.de.vw.mib.has.containers.DisplayDimensionContainer;
import org.dsi.ifc.has.HASDataContainer;
import org.dsi.ifc.has.HASDataElement;

public class OnlineServiceBridgeController {
    private boolean hmiReady = false;
    private IntArrayList propertyIdList;
    private IntArrayList subscriptionList;

    public boolean isHmiReady() {
        return this.hmiReady;
    }

    public void setHmiReady(boolean bl) {
        if (ServiceManager.logger.isTraceEnabled(16384)) {
            ServiceManager.logger.warn(16384).append("HAS state -> ").append(" HMI READY : ").append(bl).log();
        }
        this.hmiReady = bl;
        if (ASLOnlineServiceBridgeFactory.isContextRegistered()) {
            ASLOnlineServiceBridgeFactory.getServiceBridgeResult().updateHASState(bl);
        }
    }

    private IntArrayList getPropertyIdList() {
        if (this.propertyIdList == null) {
            this.propertyIdList = new IntArrayList();
        }
        return this.propertyIdList;
    }

    private IntArrayList getSubscriptionList() {
        if (this.subscriptionList == null) {
            this.subscriptionList = new IntArrayList();
        }
        return this.subscriptionList;
    }

    public void requestProperty(int n) {
        if (this.isHmiReady() && OnlineServiceBridge.getDSIHASImpl() != null) {
            this.getPropertyIdList().add(n);
            OnlineServiceBridge.getDSIHASImpl().getPropertyRequest(n);
        } else {
            if (ServiceManager.logger.isTraceEnabled(16384)) {
                ServiceManager.logger.warn(16384).append("Request property failure -> ").append(" HMI READY : ").append(this.isHmiReady()).append(" DSIHASListenerImpl =  ").append(OnlineServiceBridge.getDSIHASImpl()).log();
            }
            try {
                this.sendPropertyResult(n, null, 17);
            }
            catch (HASException hASException) {
                ServiceManager.logger2.error(16384, "EXCEPTION", hASException);
            }
        }
    }

    public void requestSubscribe(int n, int n2) {
        if (this.isHmiReady() && OnlineServiceBridge.getDSIHASImpl() != null) {
            if (this.getSubscriptionList().contains(n)) {
                if (ServiceManager.logger.isTraceEnabled(16384)) {
                    ServiceManager.logger.warn(16384).append("Request subscription  -> ").append(n).append(" Already Registered  ").log();
                }
                ASLOnlineServiceBridgeFactory.getServiceBridgeResult().subscriptionResult(0);
            } else {
                this.getSubscriptionList().add(n);
                OnlineServiceBridge.getDSIHASImpl().subscribeRequest(n, n2);
            }
        } else if (ServiceManager.logger.isTraceEnabled(16384)) {
            ServiceManager.logger.warn(16384).append("Request subscribe failure -> ").append(" HMI READY : ").append(this.isHmiReady()).append(" DSIHASListenerImpl =  ").append(OnlineServiceBridge.getDSIHASImpl()).log();
        }
    }

    public void requestUnsubscribe(boolean bl, int n) {
        if (this.isHmiReady() && OnlineServiceBridge.getDSIHASImpl() != null) {
            if (bl) {
                IntIterator intIterator = this.getSubscriptionList().iterator();
                while (intIterator.hasNext()) {
                    int n2 = intIterator.next();
                    this.getSubscriptionList().removeValue(n2);
                }
                OnlineServiceBridge.getDSIHASImpl().unsubscribeAllRequest();
            } else {
                if (this.getSubscriptionList().contains(n)) {
                    this.getSubscriptionList().removeValue(n);
                }
                OnlineServiceBridge.getDSIHASImpl().unsubscribeRequest(n);
            }
        } else if (ServiceManager.logger.isTraceEnabled(16384)) {
            ServiceManager.logger.warn(16384).append("Request unsubscribe failure -> ").append(" HMI READY : ").append(this.isHmiReady()).append(" DSIHASListenerImpl =  ").append(OnlineServiceBridge.getDSIHASImpl()).log();
        }
    }

    public void requestAction(int n, HASContainer hASContainer) {
    }

    public void updateActionResult(int n, int n2, HASDataContainer[] hASDataContainerArray, int n3) {
    }

    public void updateProperty(int n, HASDataContainer[] hASDataContainerArray, int n2) {
        if (this.getPropertyIdList().contains(n) || this.getSubscriptionList().contains(n)) {
            this.getPropertyIdList().removeValue(n);
            try {
                this.extractData(n, hASDataContainerArray, n2);
            }
            catch (HASException hASException) {
                ServiceManager.logger2.error(16384, "HAS-EXCEPTION", hASException);
            }
        }
    }

    public void updateSubscribe(int n, int n2) {
    }

    private void extractData(int n, HASDataContainer[] hASDataContainerArray, int n2) {
        if (ASLOnlineServiceBridgeFactory.isContextRegistered()) {
            if (null == hASDataContainerArray || 0 == hASDataContainerArray.length) {
                this.sendPropertyResult(n, null, n2);
            } else if (1 == hASDataContainerArray.length) {
                HASDataContainer hASDataContainer = hASDataContainerArray[0];
                if (-1 == hASDataContainer.getParentId()) {
                    this.sendPropertyResult(n, hASDataContainer, n2);
                } else {
                    if (ServiceManager.logger.isTraceEnabled(16384)) {
                        ServiceManager.logger.trace(16384).append(" ROOT_PARENT_ID is not set for the container -> ").append(hASDataContainer.getParentId()).log();
                    }
                    this.sendPropertyResult(n, null, n2);
                }
            } else {
                HASContainer hASContainer;
                int n3;
                int n4;
                HASDataContainer hASDataContainer;
                int n5;
                HASContainer hASContainer2 = null;
                IntObjectOptHashMap intObjectOptHashMap = new IntObjectOptHashMap(hASDataContainerArray.length);
                for (n5 = 0; n5 < hASDataContainerArray.length; ++n5) {
                    hASDataContainer = hASDataContainerArray[n5];
                    n4 = hASDataContainer.getHierarchyId();
                    if (intObjectOptHashMap.containsKey(n4)) {
                        throw HASException.ambiguousHierarchyId(n4);
                    }
                    n3 = hASDataContainer.getContainerId();
                    hASContainer = HAS.getInstance().getFactory().createContainerMarshaller(n3).unmarshal(hASDataContainer);
                    intObjectOptHashMap.put(n4, hASContainer);
                }
                for (n5 = 0; n5 < hASDataContainerArray.length; ++n5) {
                    hASDataContainer = hASDataContainerArray[n5];
                    n4 = hASDataContainer.getHierarchyId();
                    n3 = hASDataContainer.getParentId();
                    hASContainer = (HASContainer)intObjectOptHashMap.get(n4);
                    if (-1 != hASDataContainer.getParentId()) {
                        HASContainer hASContainer3 = (HASContainer)intObjectOptHashMap.get(n3);
                        if (null == hASContainer3) {
                            throw HASException.incompleteContainerTree(n3);
                        }
                        HAS.getInstance().getFactory().createContainerMarshaller(hASContainer3.getContainerId()).addChild(hASContainer3, hASContainer);
                        continue;
                    }
                    if (null == hASContainer2) {
                        hASContainer2 = hASContainer;
                        continue;
                    }
                    throw HASException.ambiguousRootContainer();
                }
                if (null == hASContainer2 && null != hASDataContainerArray && 0 < hASDataContainerArray.length) {
                    throw HASException.missingRootContainer();
                }
                this.sendContainerPropertyResult(n, hASContainer2, n2);
            }
        } else if (ServiceManager.logger.isTraceEnabled(16384)) {
            ServiceManager.logger.warn(16384).append("CONTEXT is not registered for call back -> ").append(" ASLOnlineServiceBridgeFactory.isContextRegistered() : ").append(ASLOnlineServiceBridgeFactory.isContextRegistered()).log();
        }
    }

    private void sendContainerPropertyResult(int n, HASContainer hASContainer, int n2) {
        if (ServiceManager.logger.isTraceEnabled(16384)) {
            ServiceManager.logger.trace(16384).append(" sendContainerPropertyResult -> propertyID = ").append(n).log();
        }
        switch (n) {
            case 1: {
                AddressContainer addressContainer = (AddressContainer)hASContainer;
                if (ServiceManager.logger.isTraceEnabled(16384)) {
                    ServiceManager.logger.trace(16384).append(" Destiantion Container -> ").append(addressContainer != null ? addressContainer.toString() : "NULL").log();
                }
                ASLOnlineServiceBridgeFactory.getServiceBridgeResult().updateCurrentLocation(addressContainer, n2);
                break;
            }
            case 8: {
                AddressContainer addressContainer = (AddressContainer)hASContainer;
                if (ServiceManager.logger.isTraceEnabled(16384)) {
                    ServiceManager.logger.trace(16384).append(" Destiantion Container -> ").append(addressContainer != null ? addressContainer.toString() : "NULL").log();
                }
                ASLOnlineServiceBridgeFactory.getServiceBridgeResult().updateDestinationLocation(addressContainer, n2);
                break;
            }
            case 12: {
                DisplayDimensionContainer displayDimensionContainer = (DisplayDimensionContainer)hASContainer;
                if (ServiceManager.logger.isTraceEnabled(16384)) {
                    ServiceManager.logger.trace(16384).append(" DisplayDimension Container -> ").append(displayDimensionContainer != null ? displayDimensionContainer.toString() : "NULL").log();
                }
                ASLOnlineServiceBridgeFactory.getServiceBridgeResult().updateMainDisplayDimension(displayDimensionContainer, n2);
                break;
            }
        }
    }

    private void sendPropertyResult(int n, HASDataContainer hASDataContainer, int n2) {
        if (ServiceManager.logger.isTraceEnabled(16384)) {
            ServiceManager.logger.trace(16384).append(" sendPropertyResult -> propertyID = ").append(n).log();
        }
        switch (n) {
            case 1: {
                AddressContainer addressContainer = null;
                if (hASDataContainer != null) {
                    int n3 = hASDataContainer.getContainerId();
                    addressContainer = (AddressContainer)HAS.getInstance().getFactory().createContainerMarshaller(n3).unmarshal(hASDataContainer);
                }
                if (ServiceManager.logger.isTraceEnabled(16384)) {
                    ServiceManager.logger.trace(16384).append(" Destiantion Container -> ").append(addressContainer != null ? addressContainer.toString() : "NULL").log();
                }
                ASLOnlineServiceBridgeFactory.getServiceBridgeResult().updateCurrentLocation(addressContainer, n2);
                break;
            }
            case 2: {
                int n4 = 0;
                if (hASDataContainer != null) {
                    HASDataElement[] hASDataElementArray = hASDataContainer.getDataElements();
                    for (int i2 = 0; i2 < hASDataElementArray.length; ++i2) {
                        if (hASDataElementArray[i2].elementId != 11) continue;
                        n4 = (int)hASDataElementArray[i2].getNumericData();
                    }
                }
                if (ServiceManager.logger.isTraceEnabled(16384)) {
                    ServiceManager.logger.trace(16384).append(" GMT Offset -> ").append(n4).log();
                }
                ASLOnlineServiceBridgeFactory.getServiceBridgeResult().updateGMTOffset(n4, n2);
                break;
            }
            case 3: {
                boolean bl = false;
                if (hASDataContainer != null) {
                    HASDataElement[] hASDataElementArray = hASDataContainer.getDataElements();
                    for (int i3 = 0; i3 < hASDataElementArray.length; ++i3) {
                        if (hASDataElementArray[i3].elementId != 12) continue;
                        bl = hASDataElementArray[i3].getNumericData() != 0L;
                    }
                }
                if (ServiceManager.logger.isTraceEnabled(16384)) {
                    ServiceManager.logger.trace(16384).append(" Driving State -> ").append(bl).log();
                }
                ASLOnlineServiceBridgeFactory.getServiceBridgeResult().updateDrivingState(bl, n2);
                break;
            }
            case 4: {
                int n5 = 0;
                if (hASDataContainer != null) {
                    HASDataElement[] hASDataElementArray = hASDataContainer.getDataElements();
                    for (int i4 = 0; i4 < hASDataElementArray.length; ++i4) {
                        if (hASDataElementArray[i4].elementId != 13) continue;
                        n5 = (int)hASDataElementArray[i4].getNumericData();
                    }
                }
                if (ServiceManager.logger.isTraceEnabled(16384)) {
                    ServiceManager.logger.trace(16384).append(" Day Night State -> ").append(n5).log();
                }
                ASLOnlineServiceBridgeFactory.getServiceBridgeResult().updateDayNightState(n5, n2);
                break;
            }
            case 5: {
                String string = "";
                if (hASDataContainer != null) {
                    HASDataElement[] hASDataElementArray = hASDataContainer.getDataElements();
                    for (int i5 = 0; i5 < hASDataElementArray.length; ++i5) {
                        if (hASDataElementArray[i5].elementId != 14) continue;
                        string = hASDataElementArray[i5].getStringData();
                    }
                }
                if (ServiceManager.logger.isTraceEnabled(16384)) {
                    ServiceManager.logger.trace(16384).append(" Skin Info -> ").append(string != null ? string : "NULL").log();
                }
                ASLOnlineServiceBridgeFactory.getServiceBridgeResult().updateSkinInfo(string, n2);
                break;
            }
            case 6: {
                String string = "";
                if (hASDataContainer != null) {
                    HASDataElement[] hASDataElementArray = hASDataContainer.getDataElements();
                    for (int i6 = 0; i6 < hASDataElementArray.length; ++i6) {
                        if (hASDataElementArray[i6].elementId != 15) continue;
                        string = hASDataElementArray[i6].getStringData();
                    }
                }
                if (ServiceManager.logger.isTraceEnabled(16384)) {
                    ServiceManager.logger.trace(16384).append(" Language Info -> ").append(string != null ? string : "NULL").log();
                }
                ASLOnlineServiceBridgeFactory.getServiceBridgeResult().updateLanguageInfo(string, n2);
                break;
            }
            case 7: {
                int n6 = 0;
                if (hASDataContainer != null) {
                    HASDataElement[] hASDataElementArray = hASDataContainer.getDataElements();
                    for (int i7 = 0; i7 < hASDataElementArray.length; ++i7) {
                        if (hASDataElementArray[i7].elementId != 16) continue;
                        n6 = (int)hASDataElementArray[i7].getNumericData();
                    }
                }
                if (ServiceManager.logger.isTraceEnabled(16384)) {
                    ServiceManager.logger.trace(16384).append(" Guidance state -> ").append(n6).log();
                }
                ASLOnlineServiceBridgeFactory.getServiceBridgeResult().updateGuidanceState(n6, n2);
                break;
            }
            case 8: {
                AddressContainer addressContainer = null;
                if (hASDataContainer != null) {
                    int n7 = hASDataContainer.getContainerId();
                    addressContainer = (AddressContainer)HAS.getInstance().getFactory().createContainerMarshaller(n7).unmarshal(hASDataContainer);
                }
                ASLOnlineServiceBridgeFactory.getServiceBridgeResult().updateDestinationLocation(addressContainer, n2);
                break;
            }
            case 9: {
                String string = "";
                if (hASDataContainer != null) {
                    HASDataElement[] hASDataElementArray = hASDataContainer.getDataElements();
                    for (int i8 = 0; i8 < hASDataElementArray.length; ++i8) {
                        if (hASDataElementArray[i8].elementId != 22) continue;
                        string = hASDataElementArray[i8].getStringData();
                    }
                }
                if (ServiceManager.logger.isTraceEnabled(16384)) {
                    ServiceManager.logger.trace(16384).append(" VehicleIdentificationNumber -> ").append(string != null ? string : "NULL").log();
                }
                ASLOnlineServiceBridgeFactory.getServiceBridgeResult().updateVehicleIdentificationNumber(string, n2);
                break;
            }
            case 10: {
                String string = "";
                if (hASDataContainer != null) {
                    HASDataElement[] hASDataElementArray = hASDataContainer.getDataElements();
                    for (int i9 = 0; i9 < hASDataElementArray.length; ++i9) {
                        if (hASDataElementArray[i9].elementId != 23) continue;
                        string = hASDataElementArray[i9].getStringData();
                    }
                }
                if (ServiceManager.logger.isTraceEnabled(16384)) {
                    ServiceManager.logger.trace(16384).append(" SoftwareRevision -> ").append(string != null ? string : "NULL").log();
                }
                ASLOnlineServiceBridgeFactory.getServiceBridgeResult().updateSoftwareRevision(string, n2);
                break;
            }
            case 11: {
                String string = "";
                if (hASDataContainer != null) {
                    HASDataElement[] hASDataElementArray = hASDataContainer.getDataElements();
                    for (int i10 = 0; i10 < hASDataElementArray.length; ++i10) {
                        if (hASDataElementArray[i10].elementId != 23) continue;
                        string = hASDataElementArray[i10].getStringData();
                    }
                }
                if (ServiceManager.logger.isTraceEnabled(16384)) {
                    ServiceManager.logger.trace(16384).append(" OriginalEquipmentManufacturer -> ").append(string != null ? string : "NULL").log();
                }
                ASLOnlineServiceBridgeFactory.getServiceBridgeResult().updateOriginalEquipmentManufacturer(string, n2);
                break;
            }
            case 12: {
                DisplayDimensionContainer displayDimensionContainer = null;
                if (hASDataContainer != null) {
                    int n8 = hASDataContainer.getContainerId();
                    displayDimensionContainer = (DisplayDimensionContainer)HAS.getInstance().getFactory().createContainerMarshaller(n8).unmarshal(hASDataContainer);
                }
                ASLOnlineServiceBridgeFactory.getServiceBridgeResult().updateMainDisplayDimension(displayDimensionContainer, n2);
                break;
            }
            case 13: {
                String string = "";
                if (hASDataContainer != null) {
                    HASDataElement[] hASDataElementArray = hASDataContainer.getDataElements();
                    for (int i11 = 0; i11 < hASDataElementArray.length; ++i11) {
                        if (hASDataElementArray[i11].elementId != 27) continue;
                        string = hASDataElementArray[i11].getStringData();
                    }
                }
                if (ServiceManager.logger.isTraceEnabled(16384)) {
                    ServiceManager.logger.trace(16384).append(" UnitDistance -> ").append(string != null ? string : "NULL").log();
                }
                ASLOnlineServiceBridgeFactory.getServiceBridgeResult().updateUnitDistance(string, n2);
                break;
            }
            case 14: {
                String string = "";
                if (hASDataContainer != null) {
                    HASDataElement[] hASDataElementArray = hASDataContainer.getDataElements();
                    for (int i12 = 0; i12 < hASDataElementArray.length; ++i12) {
                        if (hASDataElementArray[i12].elementId != 28) continue;
                        string = hASDataElementArray[i12].getStringData();
                    }
                }
                if (ServiceManager.logger.isTraceEnabled(16384)) {
                    ServiceManager.logger.trace(16384).append(" UnitVelocity -> ").append(string != null ? string : "NULL").log();
                }
                ASLOnlineServiceBridgeFactory.getServiceBridgeResult().updateUnitVelocity(string, n2);
                break;
            }
            case 15: {
                String string = "";
                if (hASDataContainer != null) {
                    HASDataElement[] hASDataElementArray = hASDataContainer.getDataElements();
                    for (int i13 = 0; i13 < hASDataElementArray.length; ++i13) {
                        if (hASDataElementArray[i13].elementId != 29) continue;
                        string = hASDataElementArray[i13].getStringData();
                    }
                }
                if (ServiceManager.logger.isTraceEnabled(16384)) {
                    ServiceManager.logger.trace(16384).append(" UnitTemperature -> ").append(string != null ? string : "NULL").log();
                }
                ASLOnlineServiceBridgeFactory.getServiceBridgeResult().updateUnitTemperature(string, n2);
                break;
            }
            case 16: {
                String string = "";
                if (hASDataContainer != null) {
                    HASDataElement[] hASDataElementArray = hASDataContainer.getDataElements();
                    for (int i14 = 0; i14 < hASDataElementArray.length; ++i14) {
                        if (hASDataElementArray[i14].elementId != 30) continue;
                        string = hASDataElementArray[i14].getStringData();
                    }
                }
                if (ServiceManager.logger.isTraceEnabled(16384)) {
                    ServiceManager.logger.trace(16384).append(" UnitPressure -> ").append(string != null ? string : "NULL").log();
                }
                ASLOnlineServiceBridgeFactory.getServiceBridgeResult().updateUnitPressure(string, n2);
                break;
            }
            case 17: {
                String string = "";
                if (hASDataContainer != null) {
                    HASDataElement[] hASDataElementArray = hASDataContainer.getDataElements();
                    for (int i15 = 0; i15 < hASDataElementArray.length; ++i15) {
                        if (hASDataElementArray[i15].elementId != 31) continue;
                        string = hASDataElementArray[i15].getStringData();
                    }
                }
                if (ServiceManager.logger.isTraceEnabled(16384)) {
                    ServiceManager.logger.trace(16384).append(" UnitFuelConsumption -> ").append(string != null ? string : "NULL").log();
                }
                ASLOnlineServiceBridgeFactory.getServiceBridgeResult().updateUnitFuelConsumption(string, n2);
                break;
            }
            case 18: {
                int n9 = 0;
                if (hASDataContainer != null) {
                    HASDataElement[] hASDataElementArray = hASDataContainer.getDataElements();
                    for (int i16 = 0; i16 < hASDataElementArray.length; ++i16) {
                        if (hASDataElementArray[i16].elementId != 32) continue;
                        n9 = (int)hASDataElementArray[i16].getNumericData();
                    }
                }
                if (ServiceManager.logger.isTraceEnabled(16384)) {
                    ServiceManager.logger.trace(16384).append(" FormatTime -> ").append(n9).log();
                }
                ASLOnlineServiceBridgeFactory.getServiceBridgeResult().updateFormatTime(n9, n2);
                break;
            }
            case 20: {
                int n10 = 0;
                if (hASDataContainer != null) {
                    HASDataElement[] hASDataElementArray = hASDataContainer.getDataElements();
                    for (int i17 = 0; i17 < hASDataElementArray.length; ++i17) {
                        if (hASDataElementArray[i17].elementId != 20) continue;
                        n10 = (int)hASDataElementArray[i17].getNumericData();
                    }
                }
                if (ServiceManager.logger.isTraceEnabled(16384)) {
                    ServiceManager.logger.trace(16384).append(" Heading -> ").append(n10).log();
                }
                ASLOnlineServiceBridgeFactory.getServiceBridgeResult().updateHeading(n10, n2);
                break;
            }
            case 19: {
                String string = "";
                if (hASDataContainer != null) {
                    HASDataElement[] hASDataElementArray = hASDataContainer.getDataElements();
                    for (int i18 = 0; i18 < hASDataElementArray.length; ++i18) {
                        if (hASDataElementArray[i18].elementId != 33) continue;
                        string = hASDataElementArray[i18].getStringData();
                    }
                }
                if (ServiceManager.logger.isTraceEnabled(16384)) {
                    ServiceManager.logger.trace(16384).append(" FormatDate -> ").append(string != null ? string : "NULL").log();
                }
                ASLOnlineServiceBridgeFactory.getServiceBridgeResult().updateFormatDate(string, n2);
                break;
            }
        }
    }
}

