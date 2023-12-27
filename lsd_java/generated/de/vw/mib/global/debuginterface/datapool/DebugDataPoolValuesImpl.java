/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.global.debuginterface.datapool;

import de.vw.mib.debuginterface.datapool.DebugDataPoolValues;
import de.vw.mib.debuginterface.datapool.internal.AbstractDebugDataPoolValues;
import de.vw.mib.hmi.internal.ServiceManagerCommon;
import generated.de.vw.mib.global.debuginterface.datapool.DebugDataPoolValues0;
import generated.de.vw.mib.global.debuginterface.datapool.DebugDataPoolValues1000;
import generated.de.vw.mib.global.debuginterface.datapool.DebugDataPoolValues1500;
import generated.de.vw.mib.global.debuginterface.datapool.DebugDataPoolValues2000;
import generated.de.vw.mib.global.debuginterface.datapool.DebugDataPoolValues2500;
import generated.de.vw.mib.global.debuginterface.datapool.DebugDataPoolValues3000;
import generated.de.vw.mib.global.debuginterface.datapool.DebugDataPoolValues3500;
import generated.de.vw.mib.global.debuginterface.datapool.DebugDataPoolValues4000;
import generated.de.vw.mib.global.debuginterface.datapool.DebugDataPoolValues4500;
import generated.de.vw.mib.global.debuginterface.datapool.DebugDataPoolValues500;
import generated.de.vw.mib.global.debuginterface.datapool.DebugDataPoolValues5000;
import generated.de.vw.mib.global.debuginterface.datapool.DebugDataPoolValues5500;
import generated.de.vw.mib.global.debuginterface.datapool.DebugDataPoolValues6000;
import generated.de.vw.mib.global.debuginterface.datapool.DebugDataPoolValues6500;
import generated.de.vw.mib.global.debuginterface.datapool.DebugDataPoolValues7000;
import generated.de.vw.mib.global.debuginterface.datapool.DebugDataPoolValues7500;
import generated.de.vw.mib.global.debuginterface.datapool.DebugDataPoolValues8000;
import generated.de.vw.mib.global.debuginterface.datapool.DebugDataPoolValues8500;

public final class DebugDataPoolValuesImpl
implements DebugDataPoolValues {
    private final AbstractDebugDataPoolValues[] debugDataPoolValues = new AbstractDebugDataPoolValues[]{new DebugDataPoolValues0(ServiceManagerCommon.skinImagePool, ServiceManagerCommon.i18nDatapool, ServiceManagerCommon.dynamicListItemControlManager), new DebugDataPoolValues500(ServiceManagerCommon.skinImagePool, ServiceManagerCommon.i18nDatapool, ServiceManagerCommon.dynamicListItemControlManager), new DebugDataPoolValues1000(ServiceManagerCommon.skinImagePool, ServiceManagerCommon.i18nDatapool, ServiceManagerCommon.dynamicListItemControlManager), new DebugDataPoolValues1500(ServiceManagerCommon.skinImagePool, ServiceManagerCommon.i18nDatapool, ServiceManagerCommon.dynamicListItemControlManager), new DebugDataPoolValues2000(ServiceManagerCommon.skinImagePool, ServiceManagerCommon.i18nDatapool, ServiceManagerCommon.dynamicListItemControlManager), new DebugDataPoolValues2500(ServiceManagerCommon.skinImagePool, ServiceManagerCommon.i18nDatapool, ServiceManagerCommon.dynamicListItemControlManager), new DebugDataPoolValues3000(ServiceManagerCommon.skinImagePool, ServiceManagerCommon.i18nDatapool, ServiceManagerCommon.dynamicListItemControlManager), new DebugDataPoolValues3500(ServiceManagerCommon.skinImagePool, ServiceManagerCommon.i18nDatapool, ServiceManagerCommon.dynamicListItemControlManager), new DebugDataPoolValues4000(ServiceManagerCommon.skinImagePool, ServiceManagerCommon.i18nDatapool, ServiceManagerCommon.dynamicListItemControlManager), new DebugDataPoolValues4500(ServiceManagerCommon.skinImagePool, ServiceManagerCommon.i18nDatapool, ServiceManagerCommon.dynamicListItemControlManager), new DebugDataPoolValues5000(ServiceManagerCommon.skinImagePool, ServiceManagerCommon.i18nDatapool, ServiceManagerCommon.dynamicListItemControlManager), new DebugDataPoolValues5500(ServiceManagerCommon.skinImagePool, ServiceManagerCommon.i18nDatapool, ServiceManagerCommon.dynamicListItemControlManager), new DebugDataPoolValues6000(ServiceManagerCommon.skinImagePool, ServiceManagerCommon.i18nDatapool, ServiceManagerCommon.dynamicListItemControlManager), new DebugDataPoolValues6500(ServiceManagerCommon.skinImagePool, ServiceManagerCommon.i18nDatapool, ServiceManagerCommon.dynamicListItemControlManager), new DebugDataPoolValues7000(ServiceManagerCommon.skinImagePool, ServiceManagerCommon.i18nDatapool, ServiceManagerCommon.dynamicListItemControlManager), new DebugDataPoolValues7500(ServiceManagerCommon.skinImagePool, ServiceManagerCommon.i18nDatapool, ServiceManagerCommon.dynamicListItemControlManager), new DebugDataPoolValues8000(ServiceManagerCommon.skinImagePool, ServiceManagerCommon.i18nDatapool, ServiceManagerCommon.dynamicListItemControlManager), new DebugDataPoolValues8500(ServiceManagerCommon.skinImagePool, ServiceManagerCommon.i18nDatapool, ServiceManagerCommon.dynamicListItemControlManager)};

    @Override
    public String getValue(int n) {
        String string = null;
        for (int i2 = 0; string == null && i2 < this.debugDataPoolValues.length; ++i2) {
            string = this.debugDataPoolValues[i2].getValue(n);
        }
        return string != null ? string : "<Property value or target-id of property unknown>";
    }
}

