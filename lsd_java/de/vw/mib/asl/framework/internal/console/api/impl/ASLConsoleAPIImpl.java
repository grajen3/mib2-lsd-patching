/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.console.api.impl;

import de.vw.mib.asl.framework.api.console.ASLConsoleAPI;
import de.vw.mib.asl.framework.api.console.ASLConsoleContext;
import de.vw.mib.asl.framework.api.console.ASLConsoleFactory;
import de.vw.mib.asl.framework.api.console.IInterpreter;

public class ASLConsoleAPIImpl
implements ASLConsoleAPI {
    private static ASLConsoleAPI realAPI;

    @Override
    public void addContext(ASLConsoleContext aSLConsoleContext) {
        if (realAPI != null) {
            realAPI.addContext(aSLConsoleContext);
        }
    }

    @Override
    public void addObject(String string, String string2, Object object) {
        if (realAPI != null) {
            realAPI.addObject(string, string2, object);
        }
    }

    @Override
    public void addBuiltin(String string, Object object) {
        if (realAPI != null) {
            realAPI.addBuiltin(string, object);
        }
    }

    @Override
    public void registerServiceConstants(String string, Class clazz) {
        if (realAPI != null) {
            realAPI.registerServiceConstants(string, clazz);
        }
    }

    @Override
    public IInterpreter newInterpreter() {
        if (realAPI != null) {
            return realAPI.newInterpreter();
        }
        return null;
    }

    static {
        ASLConsoleFactory.getConsoleApi();
        try {
            realAPI = (ASLConsoleAPI)Class.forName("de.vw.mib.asl.framework.internal.console.py.ASLConsoleAPIImpl2").getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        }
        catch (Exception exception) {
            realAPI = null;
        }
    }
}

