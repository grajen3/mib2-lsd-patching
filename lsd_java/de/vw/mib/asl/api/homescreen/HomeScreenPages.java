/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.homescreen;

import de.vw.mib.asl.api.homescreen.HomeScreenPages$Page;
import de.vw.mib.asl.api.homescreen.HomescreenPageListener;

public interface HomeScreenPages {
    default public Page getActivePage() {
    }

    default public void activatePage(Page page) {
    }

    default public void addPageListener(HomescreenPageListener homescreenPageListener) {
    }
}

