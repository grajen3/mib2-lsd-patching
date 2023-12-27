/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.onlineservices.transformer;

import de.vw.mib.asl.api.navigation.poi.online.IOnlinePoiListElement;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.online.ASLOnlineFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.util.StringUtil;
import de.vw.mib.asl.internal.navigation.poi.onlineservices.transformer.ResultListCollector$IconListener;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.properties.values.FixFormatterFieldData;
import generated.de.vw.mib.asl.internal.ListManager;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.online.PoiOnlineSearchValuelistElement;

public class ResultListCollector
extends PoiOnlineSearchValuelistElement
implements IOnlinePoiListElement {
    private int directionArrow;
    private int distance;
    private int index;
    ResourceLocator brandIcon;
    private boolean insideRange;
    private double longitudeDouble;
    private double latitudeDouble;
    ResultListCollector$IconListener iconListener;
    String serviceIdForCategory;
    private FixFormatterFieldData fieldData;
    private boolean updateList;
    private int addressType;
    private static Logger LOGGER = ServiceManager.logger;

    public ResultListCollector(PoiOnlineSearchValuelistElement poiOnlineSearchValuelistElement, int n, int n2, int n3, boolean bl, String string) {
        this(poiOnlineSearchValuelistElement, n, n2, n3, bl, string, true);
    }

    public ResultListCollector(PoiOnlineSearchValuelistElement poiOnlineSearchValuelistElement, int n, int n2, int n3, boolean bl, String string, boolean bl2) {
        this.updateList = bl2;
        this.city = poiOnlineSearchValuelistElement.getCity();
        this.country = poiOnlineSearchValuelistElement.getCountry();
        this.description = poiOnlineSearchValuelistElement.getDescription();
        this.latitude = poiOnlineSearchValuelistElement.getLatitude();
        this.longitude = poiOnlineSearchValuelistElement.getLongitude();
        this.name = poiOnlineSearchValuelistElement.getName();
        this.phone = poiOnlineSearchValuelistElement.getPhone();
        this.postal = poiOnlineSearchValuelistElement.getPostal();
        this.region = poiOnlineSearchValuelistElement.getRegion();
        this.statusurl = poiOnlineSearchValuelistElement.getStatusurl();
        this.street = poiOnlineSearchValuelistElement.getStreet();
        this.type = poiOnlineSearchValuelistElement.getType();
        this.url = poiOnlineSearchValuelistElement.getUrl();
        this.additionalData = poiOnlineSearchValuelistElement.getAdditionalData();
        this.directionArrow = n2;
        this.distance = n3;
        this.index = n;
        this.insideRange = bl;
        this.imageUrl = poiOnlineSearchValuelistElement.getImageUrl();
        this.category = poiOnlineSearchValuelistElement.getCategory();
        this.latitudeDouble = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().dsiToDecimal(poiOnlineSearchValuelistElement.getLatitude());
        this.longitudeDouble = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().dsiToDecimal(poiOnlineSearchValuelistElement.getLongitude());
        this.serviceIdForCategory = string;
        if (!StringUtil.isEmpty(this.imageUrl)) {
            this.iconListener = new ResultListCollector$IconListener(this, this, n);
            this.brandIcon = ASLOnlineFactory.getOnlineCoreServices().getOnlineImage(0, string, 3, this.imageUrl, null, this.iconListener);
            if (this.brandIcon != null && bl2) {
                ListManager.getGenericASLList(3748).updateListItem(n, this);
            }
        }
    }

    public int getDirectionArrow() {
        return this.directionArrow;
    }

    @Override
    public int getDistance() {
        return this.distance;
    }

    public ResourceLocator getIcon() {
        return this.brandIcon;
    }

    public boolean isInsideRange() {
        return this.insideRange;
    }

    public void updateProviderLogo(ResourceLocator resourceLocator, int n) {
    }

    void setBrandIcon(ResourceLocator resourceLocator) {
        this.brandIcon = resourceLocator;
    }

    @Override
    public String getPoiName() {
        return this.name;
    }

    @Override
    public int getIndex() {
        return this.index;
    }

    @Override
    public int getDirectionIndex() {
        return this.directionArrow;
    }

    @Override
    public double getLongitudeDouble() {
        return this.longitudeDouble;
    }

    @Override
    public double getLatitudeDouble() {
        return this.latitudeDouble;
    }

    @Override
    public String getPhone() {
        return this.phone;
    }

    public FixFormatterFieldData getFixFormatterFieldData() {
        return this.fieldData;
    }

    public void setFixFormatterFieldData(FixFormatterFieldData fixFormatterFieldData) {
        this.fieldData = fixFormatterFieldData;
    }

    public int getAddressType() {
        return this.addressType;
    }

    public void setAddressType(int n) {
        this.addressType = n;
    }

    public void setToUpdateList() {
        this.updateList = true;
    }

    static /* synthetic */ Logger access$000() {
        return LOGGER;
    }

    static /* synthetic */ boolean access$100(ResultListCollector resultListCollector) {
        return resultListCollector.updateList;
    }
}

