/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.api.impl.ext;

import de.vw.mib.asl.api.navigation.ILocationWrapper;
import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.INavigationLocationHelper;
import de.vw.mib.properties.values.FixFormatterFieldData;
import org.dsi.ifc.global.NavLocation;

public class INavigationLocationImpl
implements INavigationLocation,
INavigationLocationHelper {
    private NavLocation realLocation;

    public INavigationLocationImpl(NavLocation navLocation) {
        this.realLocation = navLocation;
    }

    @Override
    public NavLocation getRealLocation() {
        return this.realLocation;
    }

    public String toString() {
        if (this.realLocation != null) {
            return this.realLocation.toString();
        }
        return super.toString();
    }

    @Override
    public String getCountry() {
        if (this.realLocation != null) {
            return this.realLocation.getCountry() != null ? this.realLocation.getCountry() : "";
        }
        return null;
    }

    @Override
    public String getTown() {
        if (this.realLocation != null) {
            return this.realLocation.getTown();
        }
        return null;
    }

    @Override
    public String getZipCode() {
        if (this.realLocation != null) {
            return this.realLocation.getZipCode();
        }
        return null;
    }

    @Override
    public String getStreet() {
        if (this.realLocation != null) {
            return this.realLocation.getStreet();
        }
        return null;
    }

    @Override
    public String getHousenumber() {
        if (this.realLocation != null) {
            return this.realLocation.getHousenumber();
        }
        return null;
    }

    @Override
    public String getJunction() {
        if (this.realLocation != null) {
            return this.realLocation.getJunction();
        }
        return null;
    }

    @Override
    public String getDistrict() {
        return "";
    }

    @Override
    public String getSubmunicipalTown() {
        return "";
    }

    @Override
    public String getPoiName() {
        if (this.realLocation != null) {
            return ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(this.realLocation).getPoiName();
        }
        return null;
    }

    @Override
    public String getState() {
        if (this.realLocation != null) {
            return ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(this.realLocation).getState();
        }
        return null;
    }

    @Override
    public String getVillage() {
        return "";
    }

    @Override
    public String getWard() {
        if (this.realLocation != null) {
            return ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(this.realLocation).getWard();
        }
        return "";
    }

    @Override
    public String getPlaceName() {
        if (this.realLocation != null) {
            return ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(this.realLocation).getPlace();
        }
        return "";
    }

    @Override
    public boolean isValid() {
        if (this.realLocation != null) {
            return this.realLocation.positionValid;
        }
        return false;
    }

    @Override
    public String getCountryAbbreviation() {
        if (this.realLocation != null) {
            return this.realLocation.countryAbbreviation != null ? this.realLocation.countryAbbreviation : "";
        }
        return null;
    }

    @Override
    public double getLatitude() {
        if (this.realLocation != null) {
            return ASLNavigationUtilFactory.getNavigationUtilApi().dsiToDecimal(this.realLocation.getLatitude());
        }
        return 0.0;
    }

    @Override
    public double getLongitude() {
        if (this.realLocation != null) {
            return ASLNavigationUtilFactory.getNavigationUtilApi().dsiToDecimal(this.realLocation.getLongitude());
        }
        return 0.0;
    }

    @Override
    public String getCity() {
        if (this.realLocation != null) {
            return ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(this.realLocation).getCity();
        }
        return "";
    }

    @Override
    public String getCityRefinement() {
        if (this.realLocation != null) {
            return ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(this.realLocation).getCityRefinement();
        }
        return null;
    }

    @Override
    public String getStreetRefinement() {
        if (this.realLocation != null) {
            return ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(this.realLocation).getStreetRefinement();
        }
        return null;
    }

    @Override
    public FixFormatterFieldData getLocationFormatter() {
        if (this.realLocation != null) {
            ILocationWrapper iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(this.realLocation);
            return ASLNavigationUtilFactory.getNavigationUtilApi().getLocationFormatter().prepareFixFormatterFieldData(iLocationWrapper);
        }
        return null;
    }

    @Override
    public String getPrefecture() {
        if (this.realLocation != null) {
            return ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(this.realLocation).getState();
        }
        return null;
    }

    @Override
    public String getMunicipality() {
        if (this.realLocation != null) {
            return ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(this.realLocation).getCity();
        }
        return "";
    }

    @Override
    public String getPlace() {
        if (this.realLocation != null) {
            return ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(this.realLocation).getPlace();
        }
        return "";
    }

    @Override
    public String getChome() {
        if (this.realLocation != null) {
            return ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(this.realLocation).getChome();
        }
        return "";
    }
}

