/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.calendar;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.global.ResourceLocator;

public interface DSICalendarExchange
extends DSIBase {
    public static final String VERSION;
    public static final int RT_PARSEICAL;
    public static final int RT_PARSEICALDIRECTORY;
    public static final int RT_EXPORTICAL;
    public static final int RT_IMPORTICAL;
    public static final int RT_ABORTEXPORT;
    public static final int RP_PARSEICALRESULT;
    public static final int RP_PARSEICALDIRECTORYRESULT;
    public static final int RP_EXPORTICALRESULT;
    public static final int RP_FINISHEXPORTRESULT;
    public static final int RESULTTYPE_OK;
    public static final int RESULTTYPE_ERROR;

    default public void parseICal(String string) {
    }

    default public void parseICalDirectory(String string) {
    }

    default public void exportICal(int n, int n2, long[] lArray, int n3) {
    }

    default public void importICal(ResourceLocator[] resourceLocatorArray) {
    }

    default public void abortExport() {
    }
}

