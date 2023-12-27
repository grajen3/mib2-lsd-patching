/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.filebrowser.api.impl;

import de.vw.mib.asl.api.filebrowser.ASLFilebrowserAPI;
import de.vw.mib.asl.api.filebrowser.FilebrowserSession;
import de.vw.mib.asl.framework.internal.framework.id.PreRegisteredIds;
import de.vw.mib.asl.internal.filebrowser.api.impl.FilebrowserSessionImpl;

public class ASLFilebrowserAPIImpl
implements ASLFilebrowserAPI {
    @Override
    public FilebrowserSession getFilebrowserSession(int n) {
        return new FilebrowserSessionImpl(n);
    }

    static {
        PreRegisteredIds.addServiceOrObserverToArray(2, -1058336256, 1057030208);
        PreRegisteredIds.addServiceOrObserverToArray(2, -1058336256, 1107361856);
        PreRegisteredIds.addServiceOrObserverToArray(2, -1058336256, 0x44010040);
        PreRegisteredIds.addServiceOrObserverToArray(2, -1058336256, -1442250688);
        PreRegisteredIds.addServiceOrObserverToArray(2, -1058336256, 0x40010040);
        PreRegisteredIds.addServiceOrObserverToArray(2, -1058336256, 0x41010040);
        PreRegisteredIds.addServiceOrObserverToArray(2, -1058336256, 1157693504);
        PreRegisteredIds.addServiceOrObserverToArray(2, -1058336256, 1124139072);
        PreRegisteredIds.addServiceOrObserverToArray(2, -1058336256, 1174470720);
        PreRegisteredIds.addServiceOrObserverToArray(2, -1058336256, -284622784);
        PreRegisteredIds.addServiceOrObserverToArray(1, -1058336256, -1591400960);
        PreRegisteredIds.addServiceOrObserverToArray(1, -1058336256, -1423628800);
        PreRegisteredIds.addServiceOrObserverToArray(1, -1058336256, -1507514880);
        PreRegisteredIds.addServiceOrObserverToArray(1, -1058336256, -1524292096);
        PreRegisteredIds.addServiceOrObserverToArray(1, -1058336256, -1608178176);
        PreRegisteredIds.addServiceOrObserverToArray(1, -1058336256, -1557846528);
        PreRegisteredIds.addServiceOrObserverToArray(1, -1058336256, -1541069312);
        PreRegisteredIds.addServiceOrObserverToArray(1, -1058336256, -1574623744);
        PreRegisteredIds.addServiceOrObserverToArray(1, -1058336256, -1490737664);
        PreRegisteredIds.addServiceOrObserverToArray(1, -1058336256, -1473960448);
        PreRegisteredIds.addServiceOrObserverToArray(1, -1058336256, -1457183232);
        PreRegisteredIds.addServiceOrObserverToArray(1, -1058336256, -1289411072);
        PreRegisteredIds.addServiceOrObserverToArray(1, -1058336256, -1272633856);
        PreRegisteredIds.addServiceOrObserverToArray(1, -1058336256, -1239079424);
        PreRegisteredIds.addServiceOrObserverToArray(0, -1058336256, -1255856640);
        PreRegisteredIds.addServiceOrObserverToArray(2, -1058336256, -1027199744);
        PreRegisteredIds.addServiceOrObserverToArray(2, -1058336256, -1339742720);
        PreRegisteredIds.addServiceOrObserverToArray(2, -1058336256, -1306188288);
        PreRegisteredIds.addServiceOrObserverToArray(2, -1041559040, 1023737920);
        PreRegisteredIds.addServiceOrObserverToArray(2, -1041559040, 1711603776);
        PreRegisteredIds.addServiceOrObserverToArray(2, -1041559040, 1728380992);
        PreRegisteredIds.addServiceOrObserverToArray(1, -1041559040, -1390074368);
        PreRegisteredIds.addServiceOrObserverToArray(1, -1041559040, -1373297152);
        PreRegisteredIds.addServiceOrObserverToArray(0, -1041559040, -1339742720, true);
        PreRegisteredIds.addServiceOrObserverToArray(0, -1041559040, -1306188288);
        PreRegisteredIds.addServiceOrObserverToArray(0, -1041559040, -1322965504);
    }
}

