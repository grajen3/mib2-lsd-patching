/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.online;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.online.PortalADBEntry;

public interface DSIDestinationImportListener
extends DSIListener {
    default public void downloadAddressListResult(PortalADBEntry[] portalADBEntryArray, int n, int n2) {
    }

    default public void stopActionResult(int n) {
    }

    default public void updateEntries(int n, int n2) {
    }
}

