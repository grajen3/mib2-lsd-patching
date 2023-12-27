/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreInterfaces.external;

import org.dsi.ifc.global.ResourceLocator;

public interface CoreServiceExternalListener {
    default public void getServiceURLResponse(String string, String string2, int n) {
    }

    default public void downloadImageResponse(String string, String string2, String string3, ResourceLocator resourceLocator, int n) {
    }

    default public void calculateSPinHashResponse(String string, String string2, String string3, String string4, int n, String string5, int n2) {
    }

    default public void setSPinResponse(String string, int n, int n2) {
    }
}

