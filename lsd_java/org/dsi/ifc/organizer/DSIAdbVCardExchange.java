/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.organizer;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.global.ResourceLocator;

public interface DSIAdbVCardExchange
extends DSIBase {
    public static final String VERSION;
    public static final int RT_IMPORTVCARD;
    public static final int RT_EXPORTVCARD;
    public static final int RT_EXPORTSPELLERVCARD;
    public static final int RT_CREATEVCARD;
    public static final int RT_PARSEVCARD;
    public static final int RT_REQUESTABORT;
    public static final int ATTR_EXPORTCOUNT;
    public static final int ATTR_IMPORTCOUNT;
    public static final int RP_IMPORTVCARDRESULT;
    public static final int RP_EXPORTVCARDRESULT;
    public static final int RP_EXPORTSPELLERVCARDRESULT;
    public static final int RP_CREATEVCARDRESULT;
    public static final int RP_PARSEVCARDRESULT;
    public static final int RP_RESPONSEABORT;

    default public void importVCard(ResourceLocator[] resourceLocatorArray, int n) {
    }

    default public void exportVCard(int n, String string, long[] lArray, int n2) {
    }

    default public void exportSpellerVCard(int n, int n2, String string, long[] lArray, int n3) {
    }

    default public void createVCard(int n, long[] lArray, int n2) {
    }

    default public void parseVCard(String string) {
    }

    default public void requestAbort(int n) {
    }
}

