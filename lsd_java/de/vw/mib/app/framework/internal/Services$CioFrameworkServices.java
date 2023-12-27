/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.framework.internal;

import de.vw.mib.cio.CioDictionary;
import de.vw.mib.cio.CioDispatcher;
import de.vw.mib.cio.CioFactory;
import de.vw.mib.cio.app.framework.AppFrameworkCioFactory;

final class Services$CioFrameworkServices {
    private final AppFrameworkCioFactory appFrameworkCioFactory;
    private final CioDictionary cioDictionary;
    private final CioDispatcher cioDispatcher;
    private final CioFactory cioFactory;

    Services$CioFrameworkServices(AppFrameworkCioFactory appFrameworkCioFactory, CioDictionary cioDictionary, CioDispatcher cioDispatcher, CioFactory cioFactory) {
        this.appFrameworkCioFactory = appFrameworkCioFactory;
        this.cioDictionary = cioDictionary;
        this.cioDispatcher = cioDispatcher;
        this.cioFactory = cioFactory;
    }

    AppFrameworkCioFactory getAppFrameworkCioFactory() {
        return this.appFrameworkCioFactory;
    }

    CioDictionary getCioDictionary() {
        return this.cioDictionary;
    }

    CioDispatcher getCioDispatcher() {
        return this.cioDispatcher;
    }

    CioFactory getCioFactory() {
        return this.cioFactory;
    }
}

