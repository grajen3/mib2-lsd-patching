/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.framework.assembly;

import de.vw.mib.app.framework.assembly.AppDefinitionData;
import de.vw.mib.app.framework.assembly.CioFilterData;
import de.vw.mib.app.framework.assembly.CioIntentClassData;
import de.vw.mib.app.framework.assembly.ScreenAreaData;

public interface AppDefinitionDataProvider {
    default public AppDefinitionData getDesktopAppDefinitionData() {
    }

    default public CioFilterData[] getCioFilters() {
    }

    default public CioIntentClassData[] getCioIntentClasses() {
    }

    default public ScreenAreaData[] getDesktopAppScreenAreas() {
    }
}

