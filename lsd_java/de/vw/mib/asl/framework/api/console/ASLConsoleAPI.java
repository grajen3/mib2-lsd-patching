/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.console;

import de.vw.mib.asl.framework.api.console.ASLConsoleContext;
import de.vw.mib.asl.framework.api.console.IInterpreter;

public interface ASLConsoleAPI {
    default public void addContext(ASLConsoleContext aSLConsoleContext) {
    }

    default public void addObject(String string, String string2, Object object) {
    }

    default public void addBuiltin(String string, Object object) {
    }

    default public void registerServiceConstants(String string, Class clazz) {
    }

    default public IInterpreter newInterpreter() {
    }
}

