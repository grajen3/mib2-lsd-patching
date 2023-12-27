/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carkombi;

import org.dsi.ifc.carkombi.SIAServiceAttributes;
import org.dsi.ifc.carkombi.SIAServiceTypes;

public class SIAHistoryListRecord {
    public int pos;
    public SIAServiceTypes serviceTypes;
    public SIAServiceAttributes serviceAttributes;
    public int year;
    public int month;
    public int day;
    public String orderCode;
    public int mileage;
    public int mileageUnit;
    public String dealerName;

    public SIAHistoryListRecord() {
        this.pos = 0;
        this.serviceTypes = null;
        this.serviceAttributes = null;
        this.year = 0;
        this.month = 0;
        this.day = 0;
        this.orderCode = null;
        this.mileage = 0;
        this.mileageUnit = 15;
        this.dealerName = null;
    }

    public SIAHistoryListRecord(int n, SIAServiceTypes sIAServiceTypes, SIAServiceAttributes sIAServiceAttributes, int n2, int n3, int n4, String string, int n5, int n6, String string2) {
        this.pos = n;
        this.serviceTypes = sIAServiceTypes;
        this.serviceAttributes = sIAServiceAttributes;
        this.year = n2;
        this.month = n3;
        this.day = n4;
        this.orderCode = string;
        this.mileage = n5;
        this.mileageUnit = n6;
        this.dealerName = string2;
    }

    public int getPos() {
        return this.pos;
    }

    public SIAServiceTypes getServiceTypes() {
        return this.serviceTypes;
    }

    public SIAServiceAttributes getServiceAttributes() {
        return this.serviceAttributes;
    }

    public int getYear() {
        return this.year;
    }

    public int getMonth() {
        return this.month;
    }

    public int getDay() {
        return this.day;
    }

    public String getOrderCode() {
        return this.orderCode;
    }

    public int getMileage() {
        return this.mileage;
    }

    public int getMileageUnit() {
        return this.mileageUnit;
    }

    public String getDealerName() {
        return this.dealerName;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(2500);
        stringBuffer.append("SIAHistoryListRecord");
        stringBuffer.append('(');
        stringBuffer.append("pos");
        stringBuffer.append('=');
        stringBuffer.append(this.pos);
        stringBuffer.append(',');
        stringBuffer.append("serviceTypes");
        stringBuffer.append('=');
        stringBuffer.append(this.serviceTypes);
        stringBuffer.append(',');
        stringBuffer.append("serviceAttributes");
        stringBuffer.append('=');
        stringBuffer.append(this.serviceAttributes);
        stringBuffer.append(',');
        stringBuffer.append("year");
        stringBuffer.append('=');
        stringBuffer.append(this.year);
        stringBuffer.append(',');
        stringBuffer.append("month");
        stringBuffer.append('=');
        stringBuffer.append(this.month);
        stringBuffer.append(',');
        stringBuffer.append("day");
        stringBuffer.append('=');
        stringBuffer.append(this.day);
        stringBuffer.append(',');
        stringBuffer.append("orderCode");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.orderCode);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("mileage");
        stringBuffer.append('=');
        stringBuffer.append(this.mileage);
        stringBuffer.append(',');
        stringBuffer.append("mileageUnit");
        stringBuffer.append('=');
        stringBuffer.append(this.mileageUnit);
        stringBuffer.append(',');
        stringBuffer.append("dealerName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.dealerName);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

