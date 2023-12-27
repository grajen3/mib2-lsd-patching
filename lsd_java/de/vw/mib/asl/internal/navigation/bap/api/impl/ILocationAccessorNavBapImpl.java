/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.bap.api.impl;

import de.vw.mib.asl.api.navbap.ILocationAccessorNavBap;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import org.dsi.ifc.navigation.util.ILocationAccessor;

public class ILocationAccessorNavBapImpl
implements ILocationAccessorNavBap {
    private String town;
    private String zipCode;
    private String country;
    private String poiCategory;
    private int poiCategoryNumber;
    private String street;
    private String housenumber;
    private int latitude;
    private int longitude;
    private String state;

    public ILocationAccessorNavBapImpl(ILocationAccessor iLocationAccessor) {
        if (iLocationAccessor != null) {
            this.town = iLocationAccessor.getTown();
            this.zipCode = iLocationAccessor.getZipCode();
            this.country = iLocationAccessor.getZipCode();
            this.poiCategory = iLocationAccessor.getPoiCategory();
            this.poiCategoryNumber = iLocationAccessor.getPoiCategoryNumber();
            this.street = iLocationAccessor.getStreet();
            this.housenumber = iLocationAccessor.getHousenumber();
            this.latitude = iLocationAccessor.getLatitude();
            this.longitude = iLocationAccessor.getLongitude();
            this.state = iLocationAccessor.getState();
        } else {
            ServiceManager.logger.error(16384, "[ILocationAccessorNavBapImpl] accessor was null");
        }
    }

    @Override
    public String getTown() {
        return this.town;
    }

    @Override
    public String getZipCode() {
        return this.zipCode;
    }

    @Override
    public String getCountry() {
        return this.country;
    }

    @Override
    public String getPoiCategory() {
        return this.poiCategory;
    }

    @Override
    public int getPoiCategoryNumber() {
        return this.poiCategoryNumber;
    }

    @Override
    public String getStreet() {
        return this.street;
    }

    @Override
    public String getHousenumber() {
        return this.housenumber;
    }

    @Override
    public int getLatitude() {
        return this.latitude;
    }

    @Override
    public int getLongitude() {
        return this.longitude;
    }

    @Override
    public String getState() {
        return this.state;
    }
}

