/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.fpk.usecases.content.selection.model;

import org.dsi.ifc.carkombi.DCElementContentSelectionListRA1;

public class ContentSelection {
    private static int POS_0 = 0;
    private static int POS_1 = 1;
    protected DCElementContentSelectionListRA1 selectedElement;

    public ContentSelection(DCElementContentSelectionListRA1 dCElementContentSelectionListRA1) {
        this.selectedElement = dCElementContentSelectionListRA1;
    }

    public DCElementContentSelectionListRA1 getDCElementContentSelectionListRAX() {
        return this.selectedElement;
    }

    public int getElementContent() {
        return this.selectedElement.getElementContent();
    }

    public int getPos() {
        return this.selectedElement.getPos();
    }

    public int getDisplay() {
        return this.selectedElement.getDisplay();
    }

    public static int getPosByDisplayId(int n) {
        return n == 1 ? POS_0 : POS_1;
    }

    public int getAdditionalInfo() {
        return this.selectedElement.getAdditionalInfo();
    }

    public int getElement() {
        return this.selectedElement.getElement();
    }

    public String toString() {
        return this.selectedElement.toString();
    }
}

