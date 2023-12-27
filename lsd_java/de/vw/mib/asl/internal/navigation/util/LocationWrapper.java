/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.util;

import de.vw.mib.asl.api.navigation.IEConnector;
import de.vw.mib.asl.api.navigation.ILocationWrapper;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.util.StringUtil;
import de.vw.mib.asl.internal.navigation.util.LocationWrapper$EConnector;
import de.vw.mib.asl.internal.navigation.util.NaviHelper;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.navigation.PosPosition;
import org.dsi.ifc.navigation.util.ILocationAccessor;
import org.dsi.ifc.navigation.util.ILocationAccessorFactory;

public class LocationWrapper
implements ILocationWrapper {
    private static final int LOCATION_TYPE_INVALID;
    private static final String EMPTY_STRING;
    private static final String MMI_OPENING_BRACKETS;
    private static final String MMI_CLOSING_BRACKETS;
    private static final String MMI_ESCAPED_OPENING_BRACKETS;
    private final ILocationAccessor accessor;
    private final ILocationAccessorFactory locationAccessorFactory;
    private int locationType = -2;
    private IEConnector[] eConnectors;

    public LocationWrapper() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.locationAccessorFactory = dSIProxy.getLocationAccessorFactory();
        if (this.locationAccessorFactory != null) {
            this.accessor = this.locationAccessorFactory.createLocationAccessorFromGeoPos(0, 0);
            this.accessor.removeAll();
        } else {
            ServiceManager.logger.error(16384, "LocationWrapper: Unable to retrieve the LocationAccessorFactory service.");
            this.accessor = null;
        }
        if (this.accessor == null) {
            ServiceManager.logger.error(16384, "LocationWrapper: Unable to create a LocationAccessor from the factory. NullPointerException ahead.");
        }
    }

    public LocationWrapper(NavLocation navLocation) {
        if (navLocation == null) {
            ServiceManager.logger.warn(16384, "LocationWrapper: Called constructor with location==null. This might lead to a NullPointerException.");
        }
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.locationAccessorFactory = dSIProxy.getLocationAccessorFactory();
        if (this.locationAccessorFactory != null) {
            this.accessor = this.locationAccessorFactory.fromLocation(navLocation);
        } else {
            ServiceManager.logger.error(16384, "LocationWrapper: Unable to retrieve the LocationAccessorFactory service.");
            this.accessor = null;
        }
        if (this.accessor == null) {
            ServiceManager.logger.error(16384, "LocationWrapper: Unable to create a LocationAccessor from the factory. NullPointerException ahead.");
        }
    }

    public LocationWrapper(int n, int n2) {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.locationAccessorFactory = dSIProxy.getLocationAccessorFactory();
        if (this.locationAccessorFactory != null) {
            this.accessor = this.locationAccessorFactory.createLocationAccessorFromGeoPos(n, n2);
        } else {
            ServiceManager.logger.error(16384, "LocationWrapper: Unable to retrieve the LocationAccessorFactory service.");
            this.accessor = null;
        }
        if (this.accessor == null) {
            ServiceManager.logger.error(16384, "LocationWrapper: Unable to create a LocationAccessor from the factory. NullPointerException ahead.");
        }
    }

    public LocationWrapper(PosPosition posPosition) {
        if (posPosition == null) {
            ServiceManager.logger.error(16384, "LocationWrapper: Called constructor with position==null. Using a default position (0,0) to prevent a NPE.");
            posPosition = new PosPosition();
            posPosition.latitude = 0;
            posPosition.longitude = 0;
        }
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.locationAccessorFactory = dSIProxy.getLocationAccessorFactory();
        if (this.locationAccessorFactory != null) {
            this.accessor = this.locationAccessorFactory.createLocationAccessorFromGeoPos(posPosition.getLatitude(), posPosition.getLongitude());
        } else {
            ServiceManager.logger.error(16384, "LocationWrapper: Unable to retrieve the LocationAccessorFactory service.");
            this.accessor = null;
        }
        if (this.accessor == null) {
            ServiceManager.logger.error(16384, "LocationWrapper: Unable to create a LocationAccessor from the factory. NullPointerException ahead.");
        }
    }

    public LocationWrapper(NavSegmentID navSegmentID) {
        if (navSegmentID == null) {
            ServiceManager.logger.warn(16384, "LocationWrapper: Called constructor with traceId==null. This might lead to a NullPointerException.");
        }
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.locationAccessorFactory = dSIProxy.getLocationAccessorFactory();
        if (this.locationAccessorFactory != null) {
            this.accessor = this.locationAccessorFactory.fromTraceId(navSegmentID);
        } else {
            ServiceManager.logger.error(16384, "LocationWrapper: Unable to retrieve the LocationAccessorFactory service.");
            this.accessor = null;
        }
        if (this.accessor == null) {
            ServiceManager.logger.error(16384, "LocationWrapper: Unable to create a LocationAccessor with a NavSegmentId from the factory. NullPointerException ahead.");
        }
    }

    @Override
    public NavLocation getLocation() {
        return this.locationAccessorFactory.toLocation(this.accessor);
    }

    @Override
    public void setLocation(NavLocation navLocation) {
        this.locationType = -2;
        this.eConnectors = null;
        this.accessor.setLocation(navLocation);
    }

    @Override
    public NavLocation getLocationCopy() {
        return this.locationAccessorFactory.toLocation(this.locationAccessorFactory.cloneLocationAccessor(this.accessor));
    }

    public ILocationAccessor getAccessor() {
        return this.locationAccessorFactory.cloneLocationAccessor(this.accessor);
    }

    @Override
    public String getCountry() {
        return this.isCountryAvailable() ? this.accessor.getCountry() : "";
    }

    @Override
    public boolean isCountryAvailable() {
        return this.accessor.getCountry() != null && this.accessor.getCountry().length() > 0;
    }

    @Override
    public String getCountryCode() {
        return this.isCountryCodeAvailable() ? this.accessor.getCountryAbbreviation() : "";
    }

    @Override
    public String getIsoCountryCode() {
        return this.isIsoCountryCodeAvailable() ? this.accessor.getCountryCode() : "";
    }

    @Override
    public boolean isIsoCountryCodeAvailable() {
        return this.accessor.getCountryCode() != null && this.accessor.getCountryCode().length() > 0;
    }

    @Override
    public boolean isCountryCodeAvailable() {
        return this.accessor.getCountryAbbreviation() != null && this.accessor.getCountryAbbreviation().length() > 0;
    }

    @Override
    public String getHousenumber() {
        return this.isHousenumberAvailable() ? this.accessor.getHousenumber() : "";
    }

    @Override
    public boolean isHousenumberAvailable() {
        return this.accessor.getHousenumber() != null && this.accessor.getHousenumber().length() > 0;
    }

    @Override
    public int getIconIndex() {
        return this.accessor.getIconIndex();
    }

    @Override
    public String getGpxName() {
        return this.isGPXNameAvailable() ? this.accessor.getGpxName() : "";
    }

    @Override
    public boolean isGPXNameAvailable() {
        return this.accessor.getGpxName() != null && this.accessor.getGpxName().length() > 0;
    }

    @Override
    public boolean isIconIndexAvailable() {
        return true;
    }

    @Override
    public int getCountryIconIndex() {
        try {
            return this.accessor.getCountryIconIndex();
        }
        catch (Throwable throwable) {
            ServiceManager.errorHandler.handleError(throwable);
            return 0;
        }
    }

    @Override
    public String getCrossing() {
        return this.isCrossingAvailable() ? this.accessor.getJunction() : "";
    }

    @Override
    public boolean isCrossingAvailable() {
        return this.accessor.getJunction() != null && this.accessor.getJunction().length() > 0;
    }

    @Override
    public int getLatitude() {
        return this.accessor.getLatitude();
    }

    @Override
    public int getLatitudeDegrees() {
        return (int)NaviHelper.getInstance().dsiToDegMinSec(this.accessor.getLatitude())[0];
    }

    @Override
    public int getLatitudeMinutes() {
        return (int)NaviHelper.getInstance().dsiToDegMinSec(this.accessor.getLatitude())[1];
    }

    @Override
    public int getLatitudeSeconds() {
        return (int)(NaviHelper.getInstance().dsiToDegMinSec(this.accessor.getLatitude())[2] * 10.0);
    }

    @Override
    public int getLongitude() {
        return this.accessor.getLongitude();
    }

    @Override
    public int getLongitudeDegrees() {
        return (int)NaviHelper.getInstance().dsiToDegMinSec(this.accessor.getLongitude())[0];
    }

    @Override
    public int getLongitudeMinutes() {
        return (int)NaviHelper.getInstance().dsiToDegMinSec(this.accessor.getLongitude())[1];
    }

    @Override
    public int getLongitudeSeconds() {
        return (int)(NaviHelper.getInstance().dsiToDegMinSec(this.accessor.getLongitude())[2] * 10.0);
    }

    @Override
    public boolean isGeoLocationAvailable() {
        return this.accessor.getLatitude() != 0 || this.accessor.getLongitude() != 0;
    }

    public String getMmiInternalData() {
        return this.accessor.getMmiInternalData();
    }

    @Override
    public void setMmiInternalDataValue(int n, String string) {
        int n2;
        String string2 = this.accessor.getMmiInternalData();
        if (string2 == null) {
            string2 = "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[[");
        stringBuffer.append(n);
        stringBuffer.append("]]=");
        int n3 = string2.indexOf(stringBuffer.toString());
        if (n3 >= 0) {
            n2 = string2.indexOf("[[", n3 + 1);
            string2 = n2 == -1 ? string2.substring(0, n3) : new StringBuffer().append(string2.substring(0, n3)).append(string2.substring(n2)).toString();
        }
        String string3 = string != null ? string : "";
        StringBuffer stringBuffer2 = new StringBuffer();
        do {
            if ((n2 = string3.indexOf("[[")) == -1) continue;
            stringBuffer2 = new StringBuffer();
            stringBuffer2.append(string3.substring(0, n2));
            stringBuffer2.append("[/[/");
            stringBuffer2.append(string3.substring(n2 + "[[".length()));
            string3 = stringBuffer2.toString();
        } while (n2 != -1);
        StringBuffer stringBuffer3 = new StringBuffer();
        stringBuffer3.append(string2);
        stringBuffer3.append("[[");
        stringBuffer3.append(n);
        stringBuffer3.append("]]=");
        stringBuffer3.append(string3);
        string2 = stringBuffer3.toString();
        this.accessor.setMmiInternalData(stringBuffer3.toString());
    }

    @Override
    public String getMmiInternalDataValue(int n) {
        String string = this.accessor.getMmiInternalData();
        if (string != null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("[[");
            stringBuffer.append(n);
            stringBuffer.append("]]=");
            String string2 = stringBuffer.toString();
            int n2 = string.indexOf(string2);
            if (n2 >= 0) {
                int n3;
                int n4 = string.indexOf("[[", n2 + 1);
                if (n4 == -1) {
                    n4 = string.length();
                }
                StringBuffer stringBuffer2 = new StringBuffer();
                String string3 = string.substring(n2 + string2.length(), n4);
                do {
                    if ((n3 = string3.indexOf("[/[/")) == -1) continue;
                    stringBuffer2 = new StringBuffer();
                    stringBuffer2.append(string3.substring(0, n3));
                    stringBuffer2.append("[[");
                    stringBuffer2.append(string3.substring(n3 + "[/[/".length()));
                    string3 = stringBuffer2.toString();
                } while (n3 != -1);
                return string3;
            }
        }
        return "";
    }

    @Override
    public boolean isMmiInternalDataAvailable() {
        return this.accessor.getMmiInternalData() != null && this.accessor.getMmiInternalData().length() > 0;
    }

    @Override
    public String getMotorWayExit() {
        return this.isMotorWayExitAvailable() ? this.accessor.getMotorWayExit() : "";
    }

    @Override
    public boolean isMotorWayExitAvailable() {
        return this.accessor.getMotorWayExit() != null && this.accessor.getMotorWayExit().length() > 0;
    }

    @Override
    public String getPhonenumber() {
        return this.isPhonenumberAvailable() ? this.getPhonenumberInternal() : "";
    }

    private String getPhonenumberInternal() {
        if (!StringUtil.isEmpty(this.accessor.getPhonenumber())) {
            return this.accessor.getPhonenumber();
        }
        String string = this.getMmiInternalDataValue(4);
        return string;
    }

    @Override
    public boolean isPhonenumberAvailable() {
        return !StringUtil.isEmpty(this.getPhonenumberInternal());
    }

    @Override
    public String getPoiCategory() {
        return this.isPoiCategoryAvailable() ? this.accessor.getPoiCategory() : "";
    }

    @Override
    public boolean isPoiCategoryAvailable() {
        return this.accessor.getPoiCategory() != null && this.accessor.getPoiCategory().length() > 0;
    }

    @Override
    public int getPoiCategoryNumber() {
        return this.accessor.getPoiCategoryNumber();
    }

    @Override
    public boolean isPoiCategoryNumberAvailable() {
        return true;
    }

    @Override
    public String getPoiClass() {
        return this.isPoiClassAvailable() ? this.accessor.getPoiClass() : "";
    }

    @Override
    public boolean isPoiClassAvailable() {
        return this.accessor.getPoiClass() != null && this.accessor.getPoiClass().length() > 0;
    }

    @Override
    public String getPoiName() {
        return this.isPoiNameAvailable() ? this.getPoiNameInternal() : "";
    }

    private String getPoiNameInternal() {
        return !StringUtil.isEmpty(this.accessor.getPoiName()) ? this.accessor.getPoiName() : this.getMmiInternalDataValue(3);
    }

    @Override
    public boolean isPoiNameAvailable() {
        return !StringUtil.isEmpty(this.getPoiNameInternal());
    }

    @Override
    public String getStreet() {
        return this.isStreetAvailable() ? this.accessor.getStreet() : "";
    }

    @Override
    public boolean isStreetAvailable() {
        return this.accessor.getStreet() != null && this.accessor.getStreet().length() > 0;
    }

    @Override
    public String getStreetRefinement() {
        return this.isStreetRefinementAvailable() ? this.accessor.getStreetRefinement() : "";
    }

    @Override
    public boolean isStreetRefinementAvailable() {
        return this.accessor.getStreetRefinement() != null && this.accessor.getStreetRefinement().length() > 0;
    }

    @Override
    public int getSubIconIndex() {
        return this.accessor.getSubIconIndex();
    }

    @Override
    public boolean isSubIconIndexAvailable() {
        return true;
    }

    @Override
    public String getCity() {
        return this.isCityAvailable() ? this.accessor.getTown() : "";
    }

    @Override
    public String getUnformattedTownName() {
        return this.accessor.getAdditionalLocationInformation(1);
    }

    @Override
    public boolean isCityAvailable() {
        return this.accessor.getTown() != null && this.accessor.getTown().length() > 0;
    }

    @Override
    public String getCityRefinement() {
        return this.isCityRefinementAvailable() ? this.accessor.getTownRefinement() : "";
    }

    @Override
    public boolean isCityRefinementAvailable() {
        return this.accessor.getTownRefinement() != null && this.accessor.getTownRefinement().length() > 0;
    }

    @Override
    public String getCityCenter() {
        return this.isCityCenterAvailable() ? this.accessor.getTowncenter() : "";
    }

    @Override
    public boolean isCityCenterAvailable() {
        return this.accessor.getTowncenter() != null && this.accessor.getTowncenter().length() > 0;
    }

    @Override
    public boolean isCityCenter() {
        return this.getLocationDSIType() == 0 && this.isCountryAvailable() && this.isCityAvailable() && !this.isStreetAvailable() && !this.isFullPostalCode();
    }

    @Override
    public int getLocationDSIType() {
        return this.accessor.getType();
    }

    @Override
    public int getLocationType() {
        if (this.locationType == -2) {
            if (this.isPoiNameAvailable()) {
                this.locationType = 3;
            } else if (this.isCityCenter()) {
                this.locationType = 1;
            } else if (this.isStreetAvailable()) {
                this.locationType = this.isCrossingAvailable() ? 2 : 1;
            } else if (this.isGeoLocationAvailable()) {
                this.locationType = 0;
            } else {
                ServiceManager.logger.warn(16384, "LocationWrapper: getLocationType=LOCATION_TYPE_UNKNOWN");
                this.locationType = -1;
            }
        }
        return this.locationType;
    }

    @Override
    public boolean isTypeAvailable() {
        return true;
    }

    @Override
    public String getURLAddress() {
        boolean bl = ServiceManager.configManagerDiag.getNaviLocationOptionDefaultBoolean(1);
        boolean bl2 = ServiceManager.configManagerDiag.isFeatureFlagSet(75);
        boolean bl3 = ServiceManager.configManagerDiag.isFeatureFlagSet(70);
        if (bl && bl3 && !bl2) {
            return "";
        }
        return this.isURLAddressAvailable() ? this.accessor.getURLAddress() : "";
    }

    @Override
    public boolean isURLAddressAvailable() {
        return this.accessor.getURLAddress() != null && this.accessor.getURLAddress().length() > 0;
    }

    @Override
    public String getPostalCode() {
        return this.isPostalCodeAvailable() ? this.accessor.getZipCode() : "";
    }

    @Override
    public boolean isPostalCodeAvailable() {
        return this.accessor.getZipCode() != null && this.accessor.getZipCode().length() > 0;
    }

    @Override
    public boolean isPostalCodeSpelled() {
        try {
            return this.accessor.isZipCodeSpelled();
        }
        catch (Throwable throwable) {
            ServiceManager.logger.error(16384, "Workaround for wrong POIFactory", throwable);
            return false;
        }
    }

    @Override
    public boolean isPostalCodeNeeded() {
        return this.accessor.isZipCodeNeededForRefinement();
    }

    @Override
    public boolean isCityRefinementNeeded() {
        return this.accessor.isTownRefinementNeededForRefinement();
    }

    @Override
    public boolean isNavigable() {
        return this.accessor.isNavigable();
    }

    @Override
    public boolean isParentOfPOIs() {
        return this.accessor.isParentOfPOIs();
    }

    @Override
    public boolean isFullPostalCode() {
        try {
            return this.accessor.isFullPostalCode();
        }
        catch (Throwable throwable) {
            ServiceManager.errorHandler.handleError(throwable);
            return false;
        }
    }

    @Override
    public boolean isProvinceAvailable() {
        return this.isStateAvailable();
    }

    @Override
    public String getProvince() {
        return this.getState();
    }

    @Override
    public boolean isProvinceAbbreviationAvailable() {
        return this.isStateAbbreviationAvailable();
    }

    @Override
    public String getProvinceAbbreviation() {
        return this.getStateAbbreviation();
    }

    @Override
    public boolean isStateAvailable() {
        try {
            return this.accessor.getState() != null && this.accessor.getState().length() > 0;
        }
        catch (Throwable throwable) {
            ServiceManager.errorHandler.handleError(throwable);
            return false;
        }
    }

    @Override
    public String getState() {
        return this.isStateAvailable() ? this.accessor.getState() : "";
    }

    @Override
    public String getPlace() {
        String string = this.accessor.getPlaceName();
        if (string == null) {
            string = "";
        }
        return string;
    }

    @Override
    public boolean isStateAbbreviationAvailable() {
        return this.accessor.getStateAbbreviation() != null && this.accessor.getStateAbbreviation().length() > 0;
    }

    @Override
    public String getStateAbbreviation() {
        return this.isStateAbbreviationAvailable() ? this.accessor.getStateAbbreviation() : "";
    }

    @Override
    public boolean isStateSpelled() {
        return this.accessor.isStateSpelled();
    }

    @Override
    public boolean isProvinceSpelled() {
        return this.isStateSpelled();
    }

    @Override
    public boolean isStreetNearbyAvailable() {
        return this.accessor.getStreetNearby() != null && this.accessor.getStreetNearby().length() > 0;
    }

    @Override
    public String getStreetNearby() {
        return this.isStreetNearbyAvailable() ? this.accessor.getStreetNearby() : "";
    }

    @Override
    public boolean isStreetBasename() {
        return this.accessor.isStreetBasename();
    }

    @Override
    public boolean isTownorder9() {
        return this.accessor.isTownOrder9();
    }

    @Override
    public String getChargingStationProvider() {
        return this.accessor.getAdditionalPoiAttributeString(0);
    }

    @Override
    public int getChargingStationAccess() {
        return this.accessor.getAdditionalPoiAttributeInt(4);
    }

    @Override
    public int getChargingStationOnSitePayment() {
        return this.accessor.getAdditionalPoiAttributeBoolean(3);
    }

    @Override
    public int getChargingStationOpen24h() {
        return this.accessor.getAdditionalPoiAttributeBoolean(5);
    }

    @Override
    public int getChargingStationPay() {
        return this.accessor.getAdditionalPoiAttributeBoolean(1);
    }

    @Override
    public int getChargingStationSubscription() {
        return this.accessor.getAdditionalPoiAttributeBoolean(2);
    }

    @Override
    public int getEConnectorCount() {
        return Math.max(this.accessor.getConnectorCount(), 0);
    }

    @Override
    public IEConnector[] getEConnectors() {
        if (this.eConnectors == null) {
            this.eConnectors = new LocationWrapper$EConnector[this.getEConnectorCount()];
            for (int i2 = 0; i2 < this.eConnectors.length; ++i2) {
                this.eConnectors[i2] = this.create(this.accessor, i2);
            }
        }
        return this.eConnectors;
    }

    private LocationWrapper$EConnector create(ILocationAccessor iLocationAccessor, int n) {
        if (iLocationAccessor != null && n >= 0 && n < this.getEConnectorCount()) {
            String string = iLocationAccessor.getConnectorAttributeString(0, n);
            String string2 = string == null || string.trim().equals("") ? iLocationAccessor.getConnectorAttributeString(1, n) : null;
            return new LocationWrapper$EConnector(this, string, string2, iLocationAccessor.getConnectorAttributeInt(6, n), iLocationAccessor.getConnectorAttributeString(4, n), iLocationAccessor.getConnectorAttributeString(2, n), iLocationAccessor.getConnectorAttributeFloat(5, n), iLocationAccessor.getConnectorAttributeInt(3, n));
        }
        return null;
    }

    @Override
    public String getWard() {
        String string = this.accessor.getWard();
        if (string == null) {
            string = "";
        }
        return string;
    }

    @Override
    public String getChome() {
        String string = this.accessor.getChome();
        if (string == null) {
            string = "";
        }
        return string;
    }

    @Override
    public String getMapCode() {
        String string = this.accessor.getMapCode();
        if (string == null) {
            string = "";
        }
        return string;
    }

    public boolean isMapcodeAvailable() {
        return this.accessor.getMapCode() != null && this.accessor.getMapCode().length() > 0;
    }
}

