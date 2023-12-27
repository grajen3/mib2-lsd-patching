/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.displaymanagement.displayable;

import de.vw.mib.asl.framework.api.displaymanagement.displayable.DisplayableServiceListener;

public interface DisplayableService {
    public static final int DISPLAYABLE_HMI;
    public static final int DISPLAYABLE_REAR_VIEW_CAMERA;
    public static final int DISPLAYABLE_MAP;
    public static final int DISPLAYABLE_EXTERNAL_SMARTPHONE;

    default public boolean isDisplayableShown(int n) {
    }

    default public void addListener(DisplayableServiceListener displayableServiceListener) {
    }

    default public void removeListener(DisplayableServiceListener displayableServiceListener) {
    }
}

