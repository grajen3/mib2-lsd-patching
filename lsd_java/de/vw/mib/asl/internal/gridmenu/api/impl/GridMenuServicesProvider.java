/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.gridmenu.api.impl;

import de.vw.mib.asl.internal.gridmenu.api.impl.GridMenuServices;
import de.vw.mib.asl.internal.impl.gridmenu.GridMenuServicesImpl;

public class GridMenuServicesProvider {
    private static GridMenuServices gridMenuServices;

    public static GridMenuServices getGridMenuServices() {
        if (gridMenuServices == null) {
            gridMenuServices = new GridMenuServicesImpl();
        }
        return gridMenuServices;
    }

    public static void setGridMenuServices(GridMenuServices gridMenuServices) {
        GridMenuServicesProvider.gridMenuServices = gridMenuServices;
    }
}

