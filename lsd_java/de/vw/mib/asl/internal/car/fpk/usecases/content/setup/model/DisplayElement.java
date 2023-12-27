/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.fpk.usecases.content.setup.model;

import de.vw.mib.asl.internal.car.fpk.commons.AppLogger;
import org.dsi.ifc.carkombi.DCDisplayedAdditionalInfos;

public class DisplayElement {
    public static final int DC_DISPLAYED_ADDITIONALINFOS_INVALID;
    public static final int DC_DISPLAYED_ADDITIONALINFOS_1;
    public static final int DC_DISPLAYED_ADDITIONALINFOS_2;
    public long aslId;
    public int displayId;
    public int additionalInfo;
    public DCDisplayedAdditionalInfos displayedAdditionalInfos;
    public int elementId;

    public DisplayElement(long l, int n, DCDisplayedAdditionalInfos dCDisplayedAdditionalInfos, int n2) {
        if (dCDisplayedAdditionalInfos.isAdditionalInfo1() && dCDisplayedAdditionalInfos.isAdditionalInfo2()) {
            AppLogger.error(this, ".DisplayElement( .. ), displayedAdditionalInfos is invalid because the display area is ambiguous [1 and 2].");
        } else if (!dCDisplayedAdditionalInfos.isAdditionalInfo1() && !dCDisplayedAdditionalInfos.isAdditionalInfo2()) {
            AppLogger.error(this, ".DisplayElement( .. ), displayedAdditionalInfos is invalid because the display area is not set [ none ].");
        }
        this.aslId = l;
        this.displayId = n;
        this.additionalInfo = dCDisplayedAdditionalInfos.additionalInfo1 ? 1 : 2;
        this.elementId = n2;
    }

    public long getAslId() {
        return this.aslId;
    }
}

