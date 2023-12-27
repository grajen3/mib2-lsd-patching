/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.map;

import org.dsi.ifc.global.NavLocationWgs84;

public class PoiListElement {
    public long poiUniqueId;
    public int criteriaNumber;
    public NavLocationWgs84 position;
    public String countryAbbreviation;

    public PoiListElement() {
        this.poiUniqueId = 0L;
        this.criteriaNumber = 0;
        this.position = null;
        this.countryAbbreviation = null;
    }

    public PoiListElement(long l, int n, NavLocationWgs84 navLocationWgs84, String string) {
        this.poiUniqueId = l;
        this.criteriaNumber = n;
        this.position = navLocationWgs84;
        this.countryAbbreviation = string;
    }

    public long getPoiUniqueId() {
        return this.poiUniqueId;
    }

    public int getCriteriaNumber() {
        return this.criteriaNumber;
    }

    public NavLocationWgs84 getPosition() {
        return this.position;
    }

    public String getCountryAbbreviation() {
        return this.countryAbbreviation;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1300);
        stringBuffer.append("PoiListElement");
        stringBuffer.append('(');
        stringBuffer.append("poiUniqueId");
        stringBuffer.append('=');
        stringBuffer.append(this.poiUniqueId);
        stringBuffer.append(',');
        stringBuffer.append("criteriaNumber");
        stringBuffer.append('=');
        stringBuffer.append(this.criteriaNumber);
        stringBuffer.append(',');
        stringBuffer.append("position");
        stringBuffer.append('=');
        stringBuffer.append(this.position);
        stringBuffer.append(',');
        stringBuffer.append("countryAbbreviation");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.countryAbbreviation);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

