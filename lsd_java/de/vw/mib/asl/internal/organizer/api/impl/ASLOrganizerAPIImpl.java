/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.organizer.api.impl;

import de.vw.mib.asl.api.organizer.ASLOrganizerAPI;
import de.vw.mib.asl.framework.internal.framework.id.PreRegisteredIds;
import de.vw.mib.asl.internal.organizer.util.OrganizerUtil;
import org.dsi.ifc.organizer.AdbEntry;

public class ASLOrganizerAPIImpl
implements ASLOrganizerAPI {
    @Override
    public AdbEntry createNewEntry() {
        return OrganizerUtil.createNewEntry();
    }

    static {
        PreRegisteredIds.addServiceOrObserverToArray(0, 5308, -429443840);
    }
}

