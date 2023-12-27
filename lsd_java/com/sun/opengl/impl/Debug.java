/*
 * Decompiled with CFR 0.152.
 */
package com.sun.opengl.impl;

import com.sun.opengl.impl.Debug$1;
import com.sun.opengl.impl.Debug$2;
import java.security.AccessController;

public class Debug {
    private static boolean verbose;
    private static boolean debugAll;

    public static boolean getBooleanProperty(String string) {
        Boolean bl = (Boolean)AccessController.doPrivileged(new Debug$1(string));
        return bl;
    }

    public static boolean isPropertyDefined(String string) {
        Boolean bl = (Boolean)AccessController.doPrivileged(new Debug$2(string));
        return bl;
    }

    public static boolean verbose() {
        return verbose;
    }

    public static boolean debugAll() {
        return debugAll;
    }

    public static boolean debug(String string) {
        return Debug.debugAll() || Debug.isPropertyDefined(new StringBuffer().append("jogl.debug.").append(string).toString());
    }

    static {
        Package package_;
        verbose = Debug.isPropertyDefined("jogl.verbose");
        debugAll = Debug.isPropertyDefined("jogl.debug");
        if (verbose && (package_ = Package.getPackage("javax.media.opengl")) != null) {
            System.err.println(new StringBuffer().append("JOGL specification version ").append(package_.getSpecificationVersion()).toString());
            System.err.println(new StringBuffer().append("JOGL implementation version ").append(package_.getImplementationVersion()).toString());
            System.err.println(new StringBuffer().append("JOGL implementation vendor ").append(package_.getImplementationVendor()).toString());
        }
    }
}

