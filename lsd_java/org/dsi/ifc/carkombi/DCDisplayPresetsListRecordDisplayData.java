/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carkombi;

import org.dsi.ifc.carkombi.DCAdditionalInfo;
import org.dsi.ifc.carkombi.DCMainItems;

public class DCDisplayPresetsListRecordDisplayData {
    public DCMainItems mainSelection;
    public DCAdditionalInfo additionalInfo1;
    public DCAdditionalInfo additionalInfo2;

    public DCDisplayPresetsListRecordDisplayData() {
        this.mainSelection = null;
        this.additionalInfo1 = null;
        this.additionalInfo2 = null;
    }

    public DCDisplayPresetsListRecordDisplayData(DCMainItems dCMainItems, DCAdditionalInfo dCAdditionalInfo, DCAdditionalInfo dCAdditionalInfo2) {
        this.mainSelection = dCMainItems;
        this.additionalInfo1 = dCAdditionalInfo;
        this.additionalInfo2 = dCAdditionalInfo2;
    }

    public DCMainItems getMainSelection() {
        return this.mainSelection;
    }

    public DCAdditionalInfo getAdditionalInfo1() {
        return this.additionalInfo1;
    }

    public DCAdditionalInfo getAdditionalInfo2() {
        return this.additionalInfo2;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(3150);
        stringBuffer.append("DCDisplayPresetsListRecordDisplayData");
        stringBuffer.append('(');
        stringBuffer.append("mainSelection");
        stringBuffer.append('=');
        stringBuffer.append(this.mainSelection);
        stringBuffer.append(',');
        stringBuffer.append("additionalInfo1");
        stringBuffer.append('=');
        stringBuffer.append(this.additionalInfo1);
        stringBuffer.append(',');
        stringBuffer.append("additionalInfo2");
        stringBuffer.append('=');
        stringBuffer.append(this.additionalInfo2);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

