/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.clients.browser.headunit;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.api.devicehandling.Device;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.media.sourcehandling.state.MediaCollector;
import generated.de.vw.mib.asl.internal.ListManager;

public class HeadunitBrowserActiveSource {
    private static final ASLPropertyManager DATA_POOL = ServiceManager.aslPropertyManager;

    public static void update(MediaCollector mediaCollector) {
        boolean bl = false;
        int n = 0;
        if (mediaCollector != null) {
            bl = mediaCollector.getMedium().getParent().getCurrentState().isMultiPartition();
            n = mediaCollector.getAslDeviceID();
            DATA_POOL.valueChangedBoolean(3625, bl);
            DATA_POOL.valueChangedInteger(10, n);
            if (mediaCollector != MediaCollector.EMPTY) {
                int n2 = 0;
                GenericASLList genericASLList = ListManager.getGenericASLList(2354);
                for (int i2 = 0; i2 < genericASLList.getItemCount(); ++i2) {
                    Object object = genericASLList.getRowItemCacheOnly(i2);
                    if (!genericASLList.isValidItem(object) || ((Device)object).getMainMedium().getParent().getCurrentInfo().getDeviceID() != mediaCollector.getDeviceID()) continue;
                    n2 = i2;
                    break;
                }
                DATA_POOL.valueChangedInteger(1029442560, n2);
            }
        } else {
            DATA_POOL.valueChangedInteger(10, 0);
        }
    }
}

