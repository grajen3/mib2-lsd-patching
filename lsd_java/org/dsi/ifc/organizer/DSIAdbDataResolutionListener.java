/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.organizer;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.organizer.DataSet;

public interface DSIAdbDataResolutionListener
extends DSIListener {
    default public void resolveMailAddressResult(int n, DataSet[] dataSetArray) {
    }

    default public void resolvePhoneNumbersResult(int n, DataSet[] dataSetArray) {
    }
}

