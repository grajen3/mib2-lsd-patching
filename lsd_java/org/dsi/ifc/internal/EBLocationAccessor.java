/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.internal;

import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationDescriptor;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.internal.ChargingStation;
import org.dsi.ifc.internal.LocationHelper;
import org.dsi.ifc.internal.PhonemeParser;
import org.dsi.ifc.navigation.PhonemeData;
import org.dsi.ifc.navigation.util.ILocationAccessor;

public class EBLocationAccessor
implements ILocationAccessor {
    private static final String VERSION;
    private ChargingStation m_ChargingStation = null;
    private LocationHelper m_Helper = null;
    private PhonemeParser m_PhonemeParser = null;

    public NavLocationDescriptor cloneLocationDescriptor(NavLocationDescriptor navLocationDescriptor) {
        return new NavLocationDescriptor(navLocationDescriptor.getSelectionCriterion(), navLocationDescriptor.getData());
    }

    public EBLocationAccessor(NavLocation navLocation) {
        this.setLocation(navLocation);
    }

    public EBLocationAccessor(EBLocationAccessor eBLocationAccessor) {
        this.setLocation(eBLocationAccessor.getLocation());
    }

    public EBLocationAccessor(int n, int n2) {
        NavLocation navLocation = new NavLocation();
        navLocation.latitude = n;
        navLocation.longitude = n2;
        navLocation.altitude = 0;
        navLocation.positionValid = n != 0 || n2 != 0;
        this.setLocation(navLocation);
    }

    public EBLocationAccessor(NavSegmentID navSegmentID) {
        NavLocation navLocation = new NavLocation();
        navLocation.positionValid = false;
        this.setLocation(navLocation);
        this.m_Helper.addProprietaryData(281, String.valueOf(navSegmentID.elements[0]));
    }

    public EBLocationAccessor(String string) {
        NavLocation navLocation = new NavLocation();
        navLocation.positionValid = false;
        navLocation.country = string;
        this.setLocation(navLocation);
    }

    @Override
    public void setLocation(NavLocation navLocation) {
        if (navLocation == null) {
            navLocation = new NavLocation();
            navLocation.positionValid = false;
        }
        this.init(navLocation);
    }

    private void init(NavLocation navLocation) {
        if (null == this.m_Helper) {
            this.m_Helper = new LocationHelper(navLocation);
        } else {
            this.m_Helper.setLocation(navLocation);
        }
        if (null == this.m_ChargingStation) {
            this.m_ChargingStation = new ChargingStation(this.m_Helper);
        }
        if (null == this.m_PhonemeParser) {
            this.m_PhonemeParser = new PhonemeParser(this.m_Helper);
        }
    }

    public NavLocation getLocation() {
        if (null != this.m_Helper) {
            return this.m_Helper.getLocation();
        }
        return null;
    }

    @Override
    public final int getAdditionalFlags() {
        int n = this.m_Helper.getValueForInternalType(1);
        if (n == -1) {
            n = 0;
        }
        return n;
    }

    @Override
    public final String getCountry() {
        return this.getLocation().getCountry();
    }

    @Override
    public final String getCountryAbbreviation() {
        return this.getLocation().getCountryAbbreviation();
    }

    @Override
    public final String getHousenumber() {
        return this.getLocation().getHousenumber();
    }

    @Override
    public final int getIconIndex() {
        return this.m_Helper.getValueOfSelectionCriterion(520);
    }

    @Override
    public final String getJunction() {
        return this.getLocation().getJunction();
    }

    @Override
    public final int getLatitude() {
        if (this.getLocation().isPositionValid()) {
            return this.getLocation().getLatitude();
        }
        return 0;
    }

    @Override
    public final int getLongitude() {
        if (this.getLocation().isPositionValid()) {
            return this.getLocation().getLongitude();
        }
        return 0;
    }

    @Override
    public final String getMmiInternalData() {
        return this.m_Helper.getDataOfSelectionCriterion(768);
    }

    @Override
    public final String getMotorWayExit() {
        return "";
    }

    @Override
    public final String getPhonenumber() {
        return this.m_Helper.getDataOfSelectionCriterion(8);
    }

    @Override
    public final String getPoiCategory() {
        return this.m_Helper.getDataOfSelectionCriterion(0x2800000);
    }

    @Override
    public final int getPoiCategoryNumber() {
        return this.m_Helper.getValueOfSelectionCriterion(4096);
    }

    @Override
    public final String getPoiClass() {
        return this.m_Helper.getDataOfSelectionCriterion(0x1800000);
    }

    @Override
    public final String getPoiName() {
        return this.m_Helper.getDataOfSelectionCriterion(4097);
    }

    @Override
    public final String getStreet() {
        return this.getLocation().getStreet();
    }

    @Override
    public final String getStreetRefinement() {
        return this.getLocation().getStreetRefinement();
    }

    @Override
    public final int getSubIconIndex() {
        return this.m_Helper.getValueOfSelectionCriterion(282);
    }

    @Override
    public final String getTown() {
        return this.getLocation().getTown();
    }

    @Override
    public final String getTowncenter() {
        return this.getLocation().getTowncenter();
    }

    @Override
    public final String getTownRefinement() {
        return this.getLocation().getTownRefinement();
    }

    @Override
    public final int getType() {
        if (this.getPoiName().length() > 0) {
            return 1;
        }
        if (this.m_Helper.isFlagSet(5)) {
            return 2;
        }
        return 0;
    }

    @Override
    public final String getURLAddress() {
        return this.m_Helper.getDataOfSelectionCriterion(128);
    }

    @Override
    public final String getZipCode() {
        return this.getLocation().getZipCode();
    }

    @Override
    public final boolean isNavigable() {
        return this.getLocation().isPositionValid();
    }

    @Override
    public final void removeAll() {
        this.m_Helper.clearLocation();
    }

    @Override
    public void setMmiInternalData(String string) {
        this.m_Helper.addProprietaryData(768, string);
    }

    @Override
    public boolean isParentOfPOIs() {
        return this.m_Helper.isFlagSet(1001);
    }

    @Override
    public String getTownOriginalName() {
        boolean bl;
        String string = "";
        int n = Integer.parseInt(this.m_Helper.getDataForInternalType(2009));
        String string2 = this.m_Helper.getDataForInternalType(2001);
        String string3 = this.m_Helper.getDataForInternalType(2010);
        boolean bl2 = n == 6 || n == 7 || n == 8 || n == 9;
        boolean bl3 = bl = n == 11 || n == 12 || n == 13 || n == 14;
        if (bl2) {
            string = string2;
        } else if (bl) {
            string = string3;
        }
        return string;
    }

    @Override
    public boolean isTownOrder9() {
        return (this.getAdditionalFlags() & 0x80) == 128;
    }

    @Override
    public boolean isTownRefinementNeededForRefinement() {
        return (this.getAdditionalFlags() & 0x10) == 16;
    }

    @Override
    public boolean isZipCodeNeededForRefinement() {
        return (this.getAdditionalFlags() & 0x20) == 32;
    }

    @Override
    public boolean isZipCodeSpelled() {
        return (this.getAdditionalFlags() & 0x40) == 64;
    }

    public boolean isPOI24h() {
        return (this.getAdditionalFlags() & 1) == 1;
    }

    public boolean isPOIDiesel() {
        return (this.getAdditionalFlags() & 8) == 8;
    }

    @Override
    public String getState() {
        return this.m_Helper.getDataForInternalType(2002);
    }

    @Override
    public String getStateAbbreviation() {
        return this.m_Helper.getDataForInternalType(2003);
    }

    @Override
    public String getStreetNearby() {
        return "";
    }

    @Override
    public boolean isFullPostalCode() {
        return (this.getAdditionalFlags() & 8) == 8;
    }

    @Override
    public boolean isStateSpelled() {
        return (this.getAdditionalFlags() & 4) == 4;
    }

    @Override
    public boolean isStreetBasename() {
        return (this.getAdditionalFlags() & 0x10) == 16;
    }

    @Override
    public int getCountryIconIndex() {
        int n = this.m_Helper.getValueForInternalType(2005);
        if (n < 0) {
            n = 0;
        }
        return n;
    }

    @Override
    public int getAdditionalPoiAttributeBoolean(int n) {
        int n2 = -1;
        try {
            switch (n) {
                case 1: {
                    n2 = this.m_ChargingStation.getPay();
                    break;
                }
                case 2: {
                    n2 = this.m_ChargingStation.getSubscription();
                    break;
                }
                case 3: {
                    n2 = this.m_ChargingStation.getOnSitePayment();
                    break;
                }
                case 5: {
                    n2 = this.isPOI24h() ? 1 : 0;
                    break;
                }
                default: {
                    System.out.println(new StringBuffer().append("getAdditionalPoiAttributeBoolean invalid key: ").append(n).toString());
                    break;
                }
            }
        }
        catch (Exception exception) {
            System.out.print(exception);
        }
        return n2;
    }

    @Override
    public String getAdditionalPoiAttributeString(int n) {
        String string = "";
        try {
            switch (n) {
                case 0: {
                    string = this.m_ChargingStation.getProvider();
                    break;
                }
                case 6: {
                    string = this.m_Helper.getDataOfSelectionCriterion(1282);
                    break;
                }
                default: {
                    System.out.println(new StringBuffer().append("getAdditionalPoiAttributeString invalid key: ").append(n).toString());
                    break;
                }
            }
        }
        catch (Exception exception) {
            System.out.print(exception);
        }
        return string;
    }

    @Override
    public int getAdditionalPoiAttributeInt(int n) {
        int n2 = -1;
        try {
            switch (n) {
                case 4: {
                    n2 = this.m_ChargingStation.getAccess();
                    break;
                }
                case 5: {
                    n2 = this.isPOI24h() ? 1 : 0;
                    break;
                }
                default: {
                    System.out.println(new StringBuffer().append("getAdditionalPoiAttributeInt invalid key: ").append(n).toString());
                    break;
                }
            }
        }
        catch (Exception exception) {
            System.out.print(exception);
        }
        return n2;
    }

    @Override
    public float getAdditionalPoiAttributeFloat(int n) {
        int n2 = 32959;
        try {
            switch (n) {
                default: 
            }
            System.out.println(new StringBuffer().append("getAdditionalPoiAttributeFloat invalid key: ").append(n).toString());
        }
        catch (Exception exception) {
            System.out.print(exception);
        }
        return n2;
    }

    @Override
    public int getConnectorCount() {
        int n = -1;
        try {
            n = this.m_ChargingStation.getNoOfConnectorTypes();
        }
        catch (Exception exception) {
            System.out.print(exception);
        }
        return n;
    }

    @Override
    public int getConnectorAttributeBoolean(int n, int n2) {
        int n3 = -1;
        try {
            switch (n) {
                default: 
            }
            System.out.println(new StringBuffer().append("getConnectorAttributeFloat invalid key: ").append(n).toString());
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            System.out.println(new StringBuffer().append("ConnectorType Index invalid: ").append(indexOutOfBoundsException.getMessage()).toString());
        }
        return n3;
    }

    @Override
    public float getConnectorAttributeFloat(int n, int n2) {
        int n3 = 32959;
        try {
            switch (n) {
                case 5: {
                    n3 = (int)this.m_ChargingStation.getConnector((int)n2).powerOutput;
                    break;
                }
                default: {
                    System.out.println(new StringBuffer().append("getConnectorAttributeFloat invalid key: ").append(n).toString());
                    break;
                }
            }
        }
        catch (Exception exception) {
            System.out.print(exception);
        }
        return n3;
    }

    @Override
    public String getConnectorAttributeString(int n, int n2) {
        String string = "";
        try {
            switch (n) {
                case 0: {
                    string = this.m_ChargingStation.getConnector((int)n2).chargeMode;
                    break;
                }
                case 1: {
                    string = this.m_ChargingStation.getConnector((int)n2).chargeLevel;
                    break;
                }
                case 2: {
                    string = this.m_ChargingStation.getConnector((int)n2).name;
                    break;
                }
                case 4: {
                    string = this.m_ChargingStation.getConnector((int)n2).fuseProtection;
                    break;
                }
                default: {
                    System.out.println(new StringBuffer().append("getConnectorAttributeString invalid key: ").append(n).toString());
                    break;
                }
            }
        }
        catch (Exception exception) {
            System.out.print(exception);
        }
        return string;
    }

    @Override
    public int getConnectorAttributeInt(int n, int n2) {
        int n3 = -1;
        try {
            switch (n) {
                case 6: {
                    n3 = this.m_ChargingStation.getConnector((int)n2).countAvailable;
                    break;
                }
                case 3: {
                    n3 = this.m_ChargingStation.getConnector((int)n2).type;
                    break;
                }
                default: {
                    System.out.println(new StringBuffer().append("getConnectorAttributeInt invalid key: ").append(n).toString());
                    break;
                }
            }
        }
        catch (Exception exception) {
            System.out.print(exception);
        }
        return n3;
    }

    @Override
    public boolean getIsPicNavLocation() {
        return false;
    }

    @Override
    public PhonemeData getPhoneme(int n) {
        PhonemeData phonemeData = null;
        boolean bl = this.isTownOrder9();
        switch (n) {
            case 0: {
                phonemeData = this.m_PhonemeParser.getCountryPhoneme();
                break;
            }
            case 1: {
                phonemeData = this.m_PhonemeParser.getStatePhoneme();
                break;
            }
            case 4: 
            case 6: {
                phonemeData = this.m_PhonemeParser.getSuburbPhoneme();
                break;
            }
            case 5: {
                phonemeData = this.m_PhonemeParser.getStreetPhoneme();
                break;
            }
            case 7: {
                phonemeData = this.m_PhonemeParser.getJunctionPhoneme();
                break;
            }
            case 2: {
                if (bl) {
                    phonemeData = this.m_PhonemeParser.getSuburbPhoneme();
                    break;
                }
                phonemeData = this.m_PhonemeParser.getCityPhoneme();
                break;
            }
            case 3: {
                if (bl) {
                    phonemeData = this.m_PhonemeParser.getCityPhoneme();
                    break;
                }
                phonemeData = this.m_PhonemeParser.getStatePhoneme();
                break;
            }
            case 8: {
                phonemeData = this.m_PhonemeParser.getPOIPhoneme();
                break;
            }
        }
        return phonemeData;
    }

    @Override
    public void setIsPicNavLocation(boolean bl) {
    }

    @Override
    public String getCountryCode() {
        return this.m_Helper.getDataForInternalType(2072);
    }

    @Override
    public int[] getIconDecoratorInformation() {
        return null;
    }

    @Override
    public int getStreetIconId() {
        return 0;
    }

    @Override
    public String getStreetIconText() {
        return null;
    }

    @Override
    public String getChome() {
        return null;
    }

    @Override
    public String getDistrict() {
        return null;
    }

    @Override
    public String getMapCode() {
        return null;
    }

    @Override
    public boolean isLocationDisambiguationPossible() {
        return false;
    }

    @Override
    public boolean isLocationInCityState() {
        return false;
    }

    @Override
    public String getGpxName() {
        return this.m_Helper.getDataForInternalType(2073);
    }

    @Override
    public String getAdditionalLocationInformation(int n) {
        String string = "";
        switch (n) {
            case 1: {
                String string2 = this.m_Helper.getDataForInternalType(2009);
                if (string2 != "") {
                    int n2 = Integer.parseInt(string2);
                    string = this.m_Helper.getTownByDestinationType(n2);
                }
                if (string != "" || (string = this.m_Helper.getTownByDestinationType(11)) != "") break;
                string = this.m_Helper.getTownByDestinationType(6);
                break;
            }
        }
        return string;
    }

    @Override
    public String getVillage() {
        return null;
    }

    @Override
    public String getSubmunicipalTown() {
        return null;
    }

    @Override
    public String getPlaceName() {
        return null;
    }

    @Override
    public String getWard() {
        return null;
    }

    @Override
    public boolean getAdditionalFlagStatus(int n) {
        return false;
    }

    @Override
    public NavSegmentID getTraceID() {
        return null;
    }
}

