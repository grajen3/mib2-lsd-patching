/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.has;

import de.vw.mib.has.HASList;
import de.vw.mib.has.HASListProperty;
import de.vw.mib.has.HASListRequest;

public interface HASListControl {
    default public HASListProperty getListProperty() {
    }

    default public void request(HASListRequest hASListRequest) {
    }

    default public HASList getStrategy() {
    }
}

