/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.cio.app.framework;

import de.vw.mib.cio.CioIntent;
import de.vw.mib.cio.ContentInformationObject;

public interface AppLifecycleCio
extends CioIntent,
ContentInformationObject {
    default public String getAppName() {
    }

    default public String getAppInstanceName() {
    }
}

