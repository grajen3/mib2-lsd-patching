/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.fpk.usecases.content.selection.arrays;

import org.dsi.ifc.carkombi.DCElementContentSelectionListRA1;
import org.dsi.ifc.carkombi.DCElementContentSelectionListRA2;
import org.dsi.ifc.carkombi.DCElementContentSelectionListUpdateInfo;

public interface ContentSelectionDSIListener {
    default public void onServiceStateChanged(boolean bl) {
    }

    default public void dsiCarKombiUpdateDCElementContentSelectionListUpdateInfo(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, int[] nArray, int n) {
    }

    default public void dsiCarKombiUpdateDCElementContentSelectionListTotalNumberOfElements(int n, int n2) {
    }

    default public void dsiCarKombiResponseDCElementContentSelectionListRA1(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, DCElementContentSelectionListRA1[] dCElementContentSelectionListRA1Array) {
    }

    default public void dsiCarKombiResponseDCElementContentSelectionListRA2(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, DCElementContentSelectionListRA2[] dCElementContentSelectionListRA2Array) {
    }

    default public void dsiCarKombiResponseDCElementContentSelectionListRAF(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, int[] nArray) {
    }
}

