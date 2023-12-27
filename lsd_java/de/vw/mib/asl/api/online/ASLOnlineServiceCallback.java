/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.online;

import de.vw.mib.asl.api.online.ASLOnlineServiceIdentifier;
import org.dsi.ifc.global.ResourceLocator;

public interface ASLOnlineServiceCallback {
    public static final int RESULT_UNKNOWN;
    public static final int RESULT_OK;
    public static final int RESULT_ERROR;
    public static final int RESULT_DEACTIVATED;

    default public void checkOnlineServiceStatusResponse(ASLOnlineServiceIdentifier aSLOnlineServiceIdentifier, int n) {
    }

    default public void getServiceURLResponse(ASLOnlineServiceIdentifier aSLOnlineServiceIdentifier, String string) {
    }

    default public void updateImageInfo(ResourceLocator resourceLocator) {
    }
}

