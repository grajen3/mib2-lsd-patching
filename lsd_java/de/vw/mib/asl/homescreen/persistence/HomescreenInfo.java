/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.homescreen.persistence;

import de.vw.mib.asl.framework.api.persistence2.Persistable;
import java.util.List;

public interface HomescreenInfo
extends Persistable {
    default public int getClockLayout() {
    }

    default public void setClockLayout(int n) {
    }

    default public List getTileContents() {
    }
}

