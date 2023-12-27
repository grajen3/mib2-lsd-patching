/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.cio.app.framework;

import de.vw.mib.cio.CioIntent;
import de.vw.mib.cio.ContentInformationObject;

public interface ShowContentCio
extends CioIntent,
ContentInformationObject {
    default public String getContentId() {
    }

    default public String getScreenAreaId() {
    }
}

