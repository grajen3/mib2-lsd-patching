/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.models;

import de.vw.mib.widgets.gem.VWGEMController;
import de.vw.mib.widgets.models.ViewModel;

public interface GEMAdapterModel
extends ViewModel {
    public static final int PID_BASE;

    default public VWGEMController getGEMController() {
    }
}

