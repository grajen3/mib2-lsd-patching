/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.framework;

import de.vw.mib.asl.framework.api.framework.Services;
import de.vw.mib.asl.framework.api.framework.component.ASLComponentFactory;
import de.vw.mib.log4mib.Logger;

public interface ASLFrameworkAPI {
    default public Logger getASLLogger() {
    }

    default public Logger getASL2Logger() {
    }

    default public Services getServices() {
    }

    default public ASLComponentFactory getASLComponentFactory() {
    }
}

