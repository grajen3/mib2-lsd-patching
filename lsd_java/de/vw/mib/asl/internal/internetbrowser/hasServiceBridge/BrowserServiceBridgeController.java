/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.internetbrowser.hasServiceBridge;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.internetbrowser.common.HASPropertyReceiver;
import de.vw.mib.asl.internal.internetbrowser.hasServiceBridge.ASLBrowserServiceBridgeImpl;
import de.vw.mib.asl.internal.internetbrowser.hasServiceBridge.BrowserServiceBridge;
import de.vw.mib.collections.ints.IntArrayList;
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.has.HAS;
import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASException;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.util.Util;
import generated.de.vw.mib.has.containers.AddressContainer;
import generated.de.vw.mib.has.containers.AmbientLightContainer;
import generated.de.vw.mib.has.containers.DisplayDimensionContainer;
import org.dsi.ifc.has.HASDataContainer;
import org.dsi.ifc.has.HASDataElement;

public class BrowserServiceBridgeController {
    private final Logger logger;
    private boolean hmiReady = false;
    private IntArrayList propertyIdList;
    private IntArrayList subscriptionList;
    private static HASPropertyReceiver hasHandler;
    private AddressContainer currentLocContainer;
    private AddressContainer destinationLocContainer;
    private DisplayDimensionContainer ddc;
    private String vinValue;
    private String rev;
    private String oemValue;
    private String unitDistValue;
    private String unitVeloValue;
    private String unitTempValue;
    private String unitPresValue;
    private String unitFuelValue;
    private String dateFormat;
    private String language;
    private int timeFormat;
    private int dayNightState;
    private int gmtOffsetValue;
    private int headingValue;
    private boolean drivingStateValue;
    private int guidanceStateValue;
    final String _classname = super.getClass().getName();

    public BrowserServiceBridgeController(Logger logger) {
        this.logger = logger;
    }

    private Logger getLogger() {
        if (this.logger == null) {
            return ServiceManager.logger2;
        }
        return this.logger;
    }

    public boolean isHmiReady() {
        return this.hmiReady;
    }

    private LogMessage trace() {
        return this.getLogger().trace(512);
    }

    private LogMessage warn() {
        return this.getLogger().warn(512);
    }

    private boolean isTraceEnabled() {
        return this.getLogger().isTraceEnabled(512);
    }

    public HASPropertyReceiver getHasHandler() {
        if (hasHandler == null) {
            hasHandler = new HASPropertyReceiver();
        }
        return hasHandler;
    }

    public void setHmiReady(boolean bl) {
        if (this.isTraceEnabled()) {
            this.warn().append("HAS state -> ").append(" HMI READY : ").append(bl).log();
        }
        this.hmiReady = bl;
        this.updateHASState(bl);
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
        if (this.isHmiReady() && BrowserServiceBridge.getDSIHASImpl() != null) {
            this.getPropertyIdList().add(n);
            BrowserServiceBridge.getDSIHASImpl().getPropertyRequest(n);
        } else {
            if (this.isTraceEnabled()) {
                this.warn().append("Request property failure -> ").append(" HMI READY : ").append(this.isHmiReady()).append(" DSIHASListenerImpl =  ").append(BrowserServiceBridge.getDSIHASImpl()).log();
            }
            try {
                this.sendPropertyResult(n, null, 17);
            }
            catch (HASException hASException) {
                this.getLogger().error(512, "EXCEPTION", hASException);
            }
        }
    }

    public void requestSubscribe(int n, int n2) {
        if (this.isHmiReady() && BrowserServiceBridge.getDSIHASImpl() != null) {
            if (this.getSubscriptionList().contains(n)) {
                if (this.isTraceEnabled()) {
                    this.warn().append("Request subscription  -> ").append(n).append(" Already Registered  ").log();
                }
            } else {
                this.getSubscriptionList().add(n);
                BrowserServiceBridge.getDSIHASImpl().subscribeRequest(n, n2);
                if (this.isTraceEnabled()) {
                    this.warn().append("Request subscription  -> ").append(n).append("not registered, try to subscribe  ").log();
                }
            }
        } else if (this.isTraceEnabled()) {
            this.warn().append("Request subscribe failure -> ").append(" HMI READY : ").append(this.isHmiReady()).append(" DSIHASListenerImpl =  ").append(BrowserServiceBridge.getDSIHASImpl()).log();
        }
    }

    public void requestUnsubscribe(boolean bl, int n) {
        if (this.isHmiReady() && BrowserServiceBridge.getDSIHASImpl() != null) {
            if (bl) {
                IntIterator intIterator = this.getSubscriptionList().iterator();
                while (intIterator.hasNext()) {
                    int n2 = intIterator.next();
                    this.getSubscriptionList().removeValue(n2);
                }
                BrowserServiceBridge.getDSIHASImpl().unsubscribeAllRequest();
            } else {
                if (this.getSubscriptionList().contains(n)) {
                    this.getSubscriptionList().removeValue(n);
                }
                BrowserServiceBridge.getDSIHASImpl().unsubscribeRequest(n);
            }
        } else if (this.isTraceEnabled()) {
            this.warn().append("Request unsubscribe failure -> ").append(" HMI READY : ").append(this.isHmiReady()).append(" DSIHASListenerImpl =  ").append(BrowserServiceBridge.getDSIHASImpl()).log();
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
                this.getLogger().error(512, "HAS-EXCEPTION", hASException);
            }
        }
    }

    public void updateSubscribe(int n, int n2) {
    }

    private void extractData(int n, HASDataContainer[] hASDataContainerArray, int n2) {
        if (null == hASDataContainerArray || 0 == hASDataContainerArray.length) {
            this.sendPropertyResult(n, null, n2);
        } else if (1 == hASDataContainerArray.length) {
            HASDataContainer hASDataContainer = hASDataContainerArray[0];
            if (-1 == hASDataContainer.getParentId()) {
                this.sendPropertyResult(n, hASDataContainer, n2);
            } else {
                if (this.isTraceEnabled()) {
                    this.getLogger().trace(512).append(" ROOT_PARENT_ID is not set for the container -> ").append(hASDataContainer.getParentId()).log();
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
    }

    private void sendContainerPropertyResult(int n, HASContainer hASContainer, int n2) {
        if (this.isTraceEnabled()) {
            this.getLogger().trace(512).append(" sendContainerPropertyResult -> propertyID = ").append(n).log();
        }
        switch (n) {
            case 1: {
                AddressContainer addressContainer = (AddressContainer)hASContainer;
                if (this.isTraceEnabled()) {
                    this.getLogger().trace(512).append(" Destiantion Container -> ").append(addressContainer != null ? addressContainer.toString() : "NULL").log();
                }
                this.updateCurrentLocation(addressContainer, n2);
                break;
            }
            case 8: {
                AddressContainer addressContainer = (AddressContainer)hASContainer;
                if (this.isTraceEnabled()) {
                    this.getLogger().trace(512).append(" Destiantion Container -> ").append(addressContainer != null ? addressContainer.toString() : "NULL").log();
                }
                this.updateDestinationLocation(addressContainer, n2);
                break;
            }
            case 12: {
                DisplayDimensionContainer displayDimensionContainer = (DisplayDimensionContainer)hASContainer;
                if (this.isTraceEnabled()) {
                    this.getLogger().trace(512).append(" DisplayDimension Container -> ").append(displayDimensionContainer != null ? displayDimensionContainer.toString() : "NULL").log();
                }
                this.updateMainDisplayDimension(displayDimensionContainer, n2);
                break;
            }
        }
    }

    private void sendPropertyResult(int n, HASDataContainer hASDataContainer, int n2) {
        switch (n) {
            case 1: {
                AddressContainer addressContainer = null;
                if (hASDataContainer != null) {
                    int n3 = hASDataContainer.getContainerId();
                    addressContainer = (AddressContainer)HAS.getInstance().getFactory().createContainerMarshaller(n3).unmarshal(hASDataContainer);
                }
                this.updateCurrentLocation(addressContainer, n2);
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
                if (this.isTraceEnabled()) {
                    this.getLogger().trace(512).append(" GMT Offset -> ").append(n4).log();
                }
                this.updateGMTOffset(n4, n2);
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
                if (this.isTraceEnabled()) {
                    this.getLogger().trace(512).append(" Driving State -> ").append(bl).log();
                }
                this.updateDrivingState(bl, n2);
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
                if (this.isTraceEnabled()) {
                    this.getLogger().trace(512).append(" Day Night State -> ").append(n5).log();
                }
                this.updateDayNightState(n5, n2);
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
                if (this.isTraceEnabled()) {
                    this.getLogger().trace(512).append(" Skin Info -> ").append(string != null ? string : "NULL").log();
                }
                this.getHasHandler().updateSkinInfo(string, n2);
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
                if (this.isTraceEnabled()) {
                    this.getLogger().trace(512).append(" Language Info -> ").append(string != null ? string : "NULL").log();
                }
                this.updateLanguageInfo(string, n2);
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
                if (this.isTraceEnabled()) {
                    this.getLogger().trace(512).append(" Guidance state -> ").append(n6).log();
                }
                this.updateGuidanceState(n6, n2);
                break;
            }
            case 8: {
                AddressContainer addressContainer = null;
                if (hASDataContainer != null) {
                    int n7 = hASDataContainer.getContainerId();
                    addressContainer = (AddressContainer)HAS.getInstance().getFactory().createContainerMarshaller(n7).unmarshal(hASDataContainer);
                }
                this.updateDestinationLocation(addressContainer, n2);
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
                if (this.isTraceEnabled()) {
                    this.getLogger().trace(512).append(" VehicleIdentificationNumber -> ").append(string != null ? string : "NULL").log();
                }
                this.updateVehicleIdentificationNumber(string, n2);
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
                if (this.isTraceEnabled()) {
                    this.getLogger().trace(512).append(" SoftwareRevision -> ").append(string != null ? string : "NULL").log();
                }
                this.updateSoftwareRevision(string, n2);
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
                if (this.isTraceEnabled()) {
                    this.getLogger().trace(512).append(" OriginalEquipmentManufacturer -> ").append(string != null ? string : "NULL").log();
                }
                this.updateOriginalEquipmentManufacturer(string, n2);
                break;
            }
            case 12: {
                DisplayDimensionContainer displayDimensionContainer = null;
                if (hASDataContainer != null) {
                    int n8 = hASDataContainer.getContainerId();
                    displayDimensionContainer = (DisplayDimensionContainer)HAS.getInstance().getFactory().createContainerMarshaller(n8).unmarshal(hASDataContainer);
                }
                this.updateMainDisplayDimension(displayDimensionContainer, n2);
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
                if (this.isTraceEnabled()) {
                    this.getLogger().trace(512).append(" UnitDistance -> ").append(string != null ? string : "NULL").log();
                }
                this.updateUnitDistance(string, n2);
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
                if (this.isTraceEnabled()) {
                    this.getLogger().trace(512).append(" UnitVelocity -> ").append(string != null ? string : "NULL").log();
                }
                this.updateUnitVelocity(string, n2);
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
                if (this.isTraceEnabled()) {
                    this.getLogger().trace(512).append(" UnitTemperature -> ").append(string != null ? string : "NULL").log();
                }
                this.updateUnitTemperature(string, n2);
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
                if (this.isTraceEnabled()) {
                    this.getLogger().trace(512).append(" UnitPressure -> ").append(string != null ? string : "NULL").log();
                }
                this.updateUnitPressure(string, n2);
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
                if (this.isTraceEnabled()) {
                    this.getLogger().trace(512).append(" UnitFuelConsumption -> ").append(string != null ? string : "NULL").log();
                }
                this.updateUnitFuelConsumption(string, n2);
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
                if (this.isTraceEnabled()) {
                    this.getLogger().trace(512).append(" FormatTime -> ").append(n9).log();
                }
                this.updateFormatTime(n9, n2);
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
                if (this.isTraceEnabled()) {
                    this.getLogger().trace(512).append(" Heading -> ").append(n10).log();
                }
                this.updateHeading(n10, n2);
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
                if (this.isTraceEnabled()) {
                    this.getLogger().trace(512).append(" FormatDate -> ").append(string != null ? string : "NULL").log();
                }
                this.updateFormatDate(string, n2);
                break;
            }
            case 59: {
                AmbientLightContainer ambientLightContainer = null;
                if (hASDataContainer != null) {
                    int n11 = hASDataContainer.getContainerId();
                    ambientLightContainer = (AmbientLightContainer)HAS.getInstance().getFactory().createContainerMarshaller(n11).unmarshal(hASDataContainer);
                }
                if (this.isTraceEnabled()) {
                    this.getLogger().trace(512).append(" Ambient Light -> ").append(ambientLightContainer.getColorSRGB() != null ? ambientLightContainer.getColorSRGB() : "NULL").log();
                }
                this.getHasHandler().updateAmbientLight(ambientLightContainer, n2);
                break;
            }
        }
    }

    public void registerContext4ServiceBridge() {
        ASLBrowserServiceBridgeImpl.registerProperty(59);
        ASLBrowserServiceBridgeImpl.registerProperty(4);
        ASLBrowserServiceBridgeImpl.registerProperty(19);
        ASLBrowserServiceBridgeImpl.registerProperty(18);
        ASLBrowserServiceBridgeImpl.registerProperty(8);
        ASLBrowserServiceBridgeImpl.registerProperty(6);
        ASLBrowserServiceBridgeImpl.registerProperty(1);
        ASLBrowserServiceBridgeImpl.registerProperty(12);
        ASLBrowserServiceBridgeImpl.registerProperty(11);
        ASLBrowserServiceBridgeImpl.registerProperty(10);
        ASLBrowserServiceBridgeImpl.registerProperty(5);
        ASLBrowserServiceBridgeImpl.registerProperty(13);
        ASLBrowserServiceBridgeImpl.registerProperty(17);
        ASLBrowserServiceBridgeImpl.registerProperty(16);
        ASLBrowserServiceBridgeImpl.registerProperty(15);
        ASLBrowserServiceBridgeImpl.registerProperty(14);
        ASLBrowserServiceBridgeImpl.registerProperty(9);
        if (this.isTraceEnabled()) {
            LogMessage logMessage = this.trace();
            logMessage.append(this._classname).append("register HAS Properties").log();
        }
    }

    public void updateCurrentLocation(AddressContainer addressContainer, int n) {
        if (n == 0) {
            this.setCurrentLocation(addressContainer);
        } else if (this.isTraceEnabled()) {
            LogMessage logMessage = this.warn();
            logMessage.append(this._classname).append(".updateCurrentLocation(AddressContainer,resultCode) Resultcode is not OK, therefore there is no valid location available").log();
        }
    }

    public void updateDayNightState(int n, int n2) {
        if (n2 == 0) {
            this.setDayNightState(n);
        } else if (this.isTraceEnabled()) {
            LogMessage logMessage = this.trace();
            logMessage.append(this._classname).append(".updateDayNightState(dayNightMode,resultCode ) Resultcode is not OK, therefore there is no day night state").log();
        }
    }

    public void updateDestinationLocation(AddressContainer addressContainer, int n) {
        if (n == 0) {
            this.setDestinationLocation(addressContainer);
        } else if (this.isTraceEnabled()) {
            LogMessage logMessage = this.warn();
            logMessage.append(this._classname).append(".updateDestinationLocation(AddressContainer,resultCode) Resultcode is not OK, therefore there is no valid location available").log();
        }
    }

    public void updateFormatDate(String string, int n) {
        if (n == 0) {
            this.setFormatDate(string);
        } else if (this.isTraceEnabled()) {
            LogMessage logMessage = this.trace();
            logMessage.append(this._classname).append(".updateFormatDate(formatDate,resultCode ) Resultcode is not OK, therefore there is no valid date format").log();
        }
    }

    public void updateFormatTime(int n, int n2) {
        if (n2 == 0) {
            this.setFormatTime(n);
        } else if (this.isTraceEnabled()) {
            LogMessage logMessage = this.trace();
            logMessage.append(this._classname).append(".updateFormatTime(formatTime,resultCode ) Resultcode is not OK, therefore there is no valid time format").log();
        }
    }

    public void updateHASState(boolean bl) {
        if (bl) {
            this.registerContext4ServiceBridge();
        }
    }

    public void updateLanguageInfo(String string, int n) {
        if (n == 0) {
            this.setLanguageInfo(string);
        } else if (this.isTraceEnabled()) {
            LogMessage logMessage = this.trace();
            logMessage.append(this._classname).append(".updateLanguageInfo(language,resultCode ) Resultcode is not OK, therefore there is no system language").log();
        }
    }

    public void updateMainDisplayDimension(DisplayDimensionContainer displayDimensionContainer, int n) {
        if (n == 0) {
            this.setMainDisplayDimension(displayDimensionContainer);
        } else if (this.isTraceEnabled()) {
            LogMessage logMessage = this.warn();
            logMessage.append(this._classname).append(".updateMainDisplayDimension(mainDisplayDimension,resultCode ) Resultcode is not OK, therefore there is no valid DisplayDimensionContainer").log();
        }
    }

    public void updateOriginalEquipmentManufacturer(String string, int n) {
        if (n == 0) {
            this.setOriginalEquipmentManufacturer(string);
        } else if (this.isTraceEnabled()) {
            LogMessage logMessage = this.warn();
            logMessage.append(this._classname).append(".updateOriginalEquipmentManufacturer(originalEquipmentManufacturer,resultCode) Resultcode is not OK, therefore there is no valid OEM").log();
        }
    }

    public void updateSoftwareRevision(String string, int n) {
        if (n == 0) {
            this.setSoftwareRevision(string);
        } else if (this.isTraceEnabled()) {
            LogMessage logMessage = this.trace();
            logMessage.append(this._classname).append(".updateSoftwareRevision(softwareRevision,resultCode) Resultcode is not OK, therefore there is no valid software revision").log();
        }
    }

    public void updateUnitDistance(String string, int n) {
        if (n == 0) {
            this.setUnitDistance(string);
        } else if (this.isTraceEnabled()) {
            LogMessage logMessage = this.warn();
            logMessage.append(this._classname).append(".updateUnitDistance(unitDistance,resultCode ) Resultcode is not OK, therefore there is no valid unit distance").log();
        }
    }

    public void updateUnitFuelConsumption(String string, int n) {
        if (n == 0) {
            this.setUnitFuelConsumption(string);
        } else if (this.isTraceEnabled()) {
            LogMessage logMessage = this.trace();
            logMessage.append(this._classname).append(".updateUnitFuelConsumption(unitFuelConsumption,resultCode ) Resultcode is not OK, therefore there is no valid unit fuel consumption").log();
        }
    }

    public void updateUnitPressure(String string, int n) {
        if (n == 0) {
            this.setUnitPressure(string);
        } else if (this.isTraceEnabled()) {
            LogMessage logMessage = this.warn();
            logMessage.append(this._classname).append(".updateUnitPressure(unitPressure,resultCode ) Resultcode is not OK, therefore there is no valid unit pressure").log();
        }
    }

    public void updateUnitTemperature(String string, int n) {
        if (n == 0) {
            this.setUnitTemperature(string);
        } else if (this.isTraceEnabled()) {
            LogMessage logMessage = this.warn();
            logMessage.append(this._classname).append(".updateUnitTemperature(unitTemperature,resultCode ) Resultcode is not OK, therefore there is no valid unit temperature").log();
        }
    }

    public void updateUnitVelocity(String string, int n) {
        if (n == 0) {
            this.setUnitVelocity(string);
        } else if (this.isTraceEnabled()) {
            LogMessage logMessage = this.trace();
            logMessage.append(this._classname).append(".updateUnitVelocity(unitVelocity,resultCode ) Resultcode is not OK, therefore there is no valid unit velocity").log();
        }
    }

    public void updateVehicleIdentificationNumber(String string, int n) {
        if (n == 0) {
            this.setVehicleIdentificationNumber(string);
        } else if (this.isTraceEnabled()) {
            LogMessage logMessage = this.warn();
            logMessage.append(this._classname).append(".updateVehicleIdentificationNumber(vehicleIdentificationNumber,resultCode) Resultcode is not OK, therefore there is no valid vin").log();
        }
    }

    private void updateGMTOffset(int n, int n2) {
        if (n2 == 0) {
            this.setGMTOffset(n);
        } else if (this.isTraceEnabled()) {
            LogMessage logMessage = this.warn();
            logMessage.append(this._classname).append(".updateGMTOffset(gmtOffset,resultCode) Resultcode is not OK, therefore there is no valid GMT Offset").log();
        }
    }

    private void updateHeading(int n, int n2) {
        if (n2 == 0) {
            this.setHeading(n);
        } else if (this.isTraceEnabled()) {
            LogMessage logMessage = this.warn();
            logMessage.append(this._classname).append(".updateHeading(heading,resultCode) Resultcode is not OK, therefore there is no valid heading information").log();
        }
    }

    private void updateDrivingState(boolean bl, int n) {
        if (n == 0) {
            this.setDrivingState(bl);
        } else if (this.isTraceEnabled()) {
            LogMessage logMessage = this.warn();
            logMessage.append(this._classname).append(".updateDrivingState(drivingState,resultCode) Resultcode is not OK, therefore there is no valid driving state").log();
        }
    }

    private void updateGuidanceState(int n, int n2) {
        if (n2 == 0) {
            this.setGuidanceState(n);
        } else if (this.isTraceEnabled()) {
            LogMessage logMessage = this.warn();
            logMessage.append(this._classname).append(".updateGuidanceState(guidanceState,resultCode) Resultcode is not OK, therefore there is no valid guidance state").log();
        }
    }

    private void setGuidanceState(int n) {
        this.guidanceStateValue = n;
    }

    public int getGuidanceState() {
        return this.guidanceStateValue;
    }

    private void setDrivingState(boolean bl) {
        this.drivingStateValue = bl;
    }

    public boolean getDrivingState() {
        return this.drivingStateValue;
    }

    private void setHeading(int n) {
        this.headingValue = n;
    }

    public int getHeading() {
        return this.headingValue;
    }

    private void setGMTOffset(int n) {
        this.gmtOffsetValue = n;
    }

    public int getGMTOffset() {
        return this.gmtOffsetValue;
    }

    private void setCurrentLocation(AddressContainer addressContainer) {
        this.currentLocContainer = addressContainer;
        if (this.currentLocContainer == null && this.isTraceEnabled()) {
            LogMessage logMessage = this.warn();
            logMessage.append(this._classname).append(".setCurrentLocation( AddressContainer) <> The address container is null therefor no valid location is available. Default 0.0").log();
        }
    }

    private void setDayNightState(int n) {
        this.dayNightState = n;
    }

    private void setDestinationLocation(AddressContainer addressContainer) {
        if (addressContainer != null) {
            this.destinationLocContainer = addressContainer;
        }
        if (this.isTraceEnabled()) {
            LogMessage logMessage = this.warn();
            logMessage.append(this._classname).append(".setDestinationLocation( AddressContainer) <> The address container is null therefor no valid location is available. Default 0.0").log();
        }
    }

    private void setFormatDate(String string) {
        if (!Util.isNullOrEmpty(string)) {
            this.dateFormat = string;
        } else if (this.isTraceEnabled()) {
            LogMessage logMessage = this.warn();
            logMessage.append(this._classname).append(".setFormatDate(formatDate ) the HAS Property for the date format is null or empty").append(this.dateFormat).log();
        }
    }

    private void setFormatTime(int n) {
        this.timeFormat = n;
    }

    private void setLanguageInfo(String string) {
        if (!Util.isNullOrEmpty(string)) {
            this.language = string;
        } else if (this.isTraceEnabled()) {
            LogMessage logMessage = this.warn();
            logMessage.append(this._classname).append(".setLanguageInfo(language ) the HAS Property for the system language is null or empty").append(this.language).log();
        }
    }

    private void setMainDisplayDimension(DisplayDimensionContainer displayDimensionContainer) {
        if (displayDimensionContainer != null) {
            this.ddc = displayDimensionContainer;
        } else if (this.isTraceEnabled()) {
            LogMessage logMessage = this.warn();
            logMessage.append(this._classname).append(".setMainDisplayDimension( mainDisplayDimension ) the HAS Property for the display dimension container is null ").log();
        }
    }

    private void setOriginalEquipmentManufacturer(String string) {
        if (!Util.isNullOrEmpty(string)) {
            this.oemValue = string;
        } else if (this.isTraceEnabled()) {
            LogMessage logMessage = this.warn();
            logMessage.append(this._classname).append(".setOriginalEquipmentManufacturer(originalEquipmentManufacturer) the HAS Property for the OEM is null or empty").log();
        }
    }

    private void setSoftwareRevision(String string) {
        if (!Util.isNullOrEmpty(string)) {
            this.rev = string;
        } else if (this.isTraceEnabled()) {
            LogMessage logMessage = this.warn();
            logMessage.append(this._classname).append(".setSoftwareRevision(softwareRevision) the HAS Property for the Software Revision is null or empty").log();
        }
    }

    private void setUnitDistance(String string) {
        if (!Util.isNullOrEmpty(string)) {
            this.unitDistValue = string;
        } else if (this.isTraceEnabled()) {
            LogMessage logMessage = this.warn();
            logMessage.append(this._classname).append(".setUnitDistance( unitDistance ) the HAS Property for the unit distance is null or empty").log();
        }
    }

    private void setUnitFuelConsumption(String string) {
        if (!Util.isNullOrEmpty(string)) {
            this.unitFuelValue = string;
        } else if (this.isTraceEnabled()) {
            LogMessage logMessage = this.warn();
            logMessage.append(this._classname).append(".setUnitFuelConsumption(unitFuelConsumption ) the HAS Property for the unit fuel consumption is null or empty").append(this.unitFuelValue).log();
        }
    }

    private void setUnitPressure(String string) {
        if (!Util.isNullOrEmpty(string)) {
            this.unitPresValue = string;
        } else if (this.isTraceEnabled()) {
            LogMessage logMessage = this.warn();
            logMessage.append(this._classname).append(".setUnitTemperature(unitTemperature ) the HAS Property for the unit pressure is null or empty").append(string).log();
        }
    }

    private void setUnitTemperature(String string) {
        if (!Util.isNullOrEmpty(string)) {
            this.unitTempValue = string;
        } else if (this.isTraceEnabled()) {
            LogMessage logMessage = this.warn();
            logMessage.append(this._classname).append(".setUnitTemperature(unitTemperature ) the HAS Property for the unit temperature is null or empty").append(string).log();
        }
    }

    private void setUnitVelocity(String string) {
        if (!Util.isNullOrEmpty(string)) {
            this.unitVeloValue = string;
        } else if (this.isTraceEnabled()) {
            LogMessage logMessage = this.warn();
            logMessage.append(this._classname).append(".setUntiVelocity( untiVelocity ) the HAS Property for the unit velocity is null or empty").log();
        }
    }

    private void setVehicleIdentificationNumber(String string) {
        if (!Util.isNullOrEmpty(string)) {
            this.vinValue = string;
        } else if (this.isTraceEnabled()) {
            LogMessage logMessage = this.warn();
            logMessage.append(this._classname).append(".setVehicleIdentificationNumber(vehicleIdentificationNumber) the HAS Property for the VIN is null or empty").log();
        }
    }

    public AddressContainer getCurrentLocation() {
        return this.currentLocContainer;
    }

    public int getDayNightState() {
        return this.dayNightState;
    }

    public AddressContainer getDestinationLocation() {
        if (this.destinationLocContainer != null && this.isTraceEnabled()) {
            LogMessage logMessage = this.trace();
            logMessage.append(this._classname).append(".getDestinationLocation() with Lat: ").append(this.destinationLocContainer.getLatitude()).append(" and Lon: ").append(this.destinationLocContainer.getLongitude()).log();
        }
        return this.destinationLocContainer;
    }

    public DisplayDimensionContainer getDisplayDimensionContainer() {
        if (this.isTraceEnabled()) {
            LogMessage logMessage = this.trace();
            logMessage.append(this._classname).append(new StringBuffer().append(" getDisplayDimensionContainer with X: ").append(this.ddc.getHorizontalResolution()).append(" and Y: ").append(this.ddc.getVerticalResolution()).toString()).log();
        }
        return this.ddc;
    }

    public String getFormatDate() {
        if (this.isTraceEnabled()) {
            LogMessage logMessage = this.trace();
            logMessage.append(this._classname).append(".getFormatDate: ").append(this.dateFormat).log();
        }
        return this.dateFormat;
    }

    public int getFormatTime() {
        return this.timeFormat;
    }

    public String getLanguageInfo() {
        return this.language;
    }

    public String getOriginalEquipmentManufacturer() {
        return this.oemValue;
    }

    public String getSorftwareRevision() {
        return this.rev;
    }

    public String getUnitDistance() {
        return this.unitDistValue;
    }

    public String getUnitFuelConsumption() {
        return this.unitFuelValue;
    }

    public String getUnitPressure() {
        return this.unitPresValue;
    }

    public String getUnitTemperature() {
        return this.unitTempValue;
    }

    public String getUnitVelocity() {
        return this.unitVeloValue;
    }

    public String getVehicleIdentificationNumber() {
        return this.vinValue;
    }
}

