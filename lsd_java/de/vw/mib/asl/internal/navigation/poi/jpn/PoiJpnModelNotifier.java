/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.jpn;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.navigation.poi.category.transformer.NavigationPOICategorySelectedItemCollector;
import java.util.ArrayList;

public class PoiJpnModelNotifier {
    static IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(16384, "PoiJpnModelNotifier");

    public void setLayer(int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(-1427107840, n);
    }

    public void setSelectedResult(NavigationPOICategorySelectedItemCollector navigationPOICategorySelectedItemCollector) {
        ListManager.getGenericASLList(-1393553408).updateListItem(0, navigationPOICategorySelectedItemCollector);
    }

    public void setResultList(ArrayList arrayList) {
        ListManager.getGenericASLList(-1410330624).updateList(arrayList.toArray());
    }

    public void quitModelWaitstate() {
        ServiceManager.aslPropertyManager.valueChangedBoolean(-1443885056, true);
    }

    static void printTrace(String string) {
        if (logger.isTraceEnabled()) {
            logger.makeTrace().append(string).log();
        }
    }
}

