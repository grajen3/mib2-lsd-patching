/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.travelguide;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.global.ResourceLocator;

public interface DSITravelGuide
extends DSIBase {
    public static final String VERSION;
    public static final int RESULTCODE_OK;
    public static final int RESULTCODE_ERROR;
    public static final int RESULTCODE_NOT_OPERABLE;
    public static final int RESULTCODE_UNSUPPORTED;
    public static final int FAILUREREASON_NONE;
    public static final int FAILUREREASON_UNSPECIFIED;
    public static final int FAILUREREASON_MEMORY_FULL;
    public static final int FAILUREREASON_DUPLICATE;
    public static final int WINDOWSTEP_CURRENT_PAGE;
    public static final int WINDOWSTEP_NEXT_PAGE;
    public static final int WINDOWSTEP_PREVIOUS_PAGE;
    public static final int WINDOWSTEP_FIRST_PAGE;
    public static final int WINDOWSTEP_GOTO_POSITION;
    public static final int LISTITEMSTATUS_AVAILABLE;
    public static final int LISTITEMSTATUS_DOWNLOADING;
    public static final int LISTITEMSTATUS_IMPORTING;
    public static final int LISTITEMSTATUS_UPDATING;
    public static final int ATTR_TRAVELGUIDEMEMORYLIST;
    public static final int ATTR_TRAVELGUIDEMEMORYLISTELEMENT;
    public static final int RT_IMPORTTRAVELGUIDE;
    public static final int RT_DELETETRAVELGUIDE;
    public static final int RP_IMPORTTRAVELGUIDERESULT;
    public static final int RP_DELETETRAVELGUIDERESULT;

    default public void importTravelGuide(ResourceLocator resourceLocator) {
    }

    default public void deleteTravelGuide(long l) {
    }
}

