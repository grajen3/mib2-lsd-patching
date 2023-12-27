/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.online;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.poi.online.OnlinePoiDataPool;
import de.vw.mib.properties.values.SpellerData;
import org.dsi.ifc.global.ResourceLocator;

final class OnlinePoiModelNotifier {
    OnlinePoiModelNotifier() {
    }

    void setSearchState(int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(3735, n);
    }

    void leaveWaitState() {
        ServiceManager.aslPropertyManager.valueChangedInteger(3722, 0);
    }

    void setSearchTerm(String string) {
        ServiceManager.aslPropertyManager.valueChangedString(3733, string);
    }

    void setProviderLogoOnlinePOI(ResourceLocator resourceLocator) {
        ServiceManager.aslPropertyManager.valueChangedResourceLocator(1257246720, resourceLocator);
        OnlinePoiDataPool.getInstance().setOnlineProviderLogoAvailable(resourceLocator != null);
    }

    void setProviderLogoDynamicPOI(ResourceLocator resourceLocator, int n) {
        ServiceManager.aslPropertyManager.valueChangedResourceLocator(1274023936, resourceLocator);
        OnlinePoiDataPool.getInstance().setDynamicProviderLogoAvailable(resourceLocator != null, n);
    }

    void setTotalResultCount(int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(3837, n);
    }

    void setProviderName(String string) {
        ServiceManager.aslPropertyManager.valueChangedString(3905, string);
    }

    void setPoiURL(String string) {
        ServiceManager.aslPropertyManager.valueChangedString(-34664448, string);
    }

    void setNextPageAvailable(boolean bl) {
        if (ServiceManager.logger.isTraceEnabled(512)) {
            ServiceManager.logger.trace(512, new StringBuffer().append("isNextPageAvailable: ").append(bl).toString());
        }
        ServiceManager.aslPropertyManager.valueChangedBoolean(3762, bl);
        ServiceManager.aslPropertyManager.valueChangedBoolean(-1745874944, bl);
    }

    void setPreviousPageAvailable(boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(3761, bl);
    }

    void setSearchSpellerData(SpellerData spellerData) {
        ServiceManager.aslPropertyManager.valueChangedSpellerData(3734, spellerData);
    }

    void updateSearchStatus(boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedInteger(2079330304, bl ? 1 : 0);
    }
}

