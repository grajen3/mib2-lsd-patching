/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.memory.transformer;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import generated.de.vw.mib.asl.internal.navigation.memory.transformer.AbstractNavigationMemoryDestMemFilteredListSlotListTransformer;
import org.dsi.ifc.organizer.AddressData;

public class NavigationMemoryDestMemFilteredListSlotListTransformer
extends AbstractNavigationMemoryDestMemFilteredListSlotListTransformer {
    @Override
    public String getString(int n, Object object) {
        if (n == 0) {
            int n2 = ServiceManager.configManagerDiag.getNaviCommonOptionDefault(1);
            return ServiceManager.fixFormat4Asl.fmtRulesetBasedString(10 + n2, ASLNavigationUtilFactory.getNavigationUtilApi().getLocationFormatter().prepareFixFormatterFieldData((AddressData)object, null, null));
        }
        throw new UnsupportedOperationException();
    }
}

