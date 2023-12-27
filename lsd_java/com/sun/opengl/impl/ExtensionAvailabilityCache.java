/*
 * Decompiled with CFR 0.152.
 */
package com.sun.opengl.impl;

import com.sun.opengl.impl.GLContextImpl;
import java.util.HashSet;
import java.util.StringTokenizer;
import javax.media.opengl.GL;

public final class ExtensionAvailabilityCache {
    private GLContextImpl context;
    private HashSet availableExtensionCache;

    ExtensionAvailabilityCache(GLContextImpl gLContextImpl) {
        this.context = gLContextImpl;
    }

    public boolean isExtensionAvailable(String string) {
        this.initAvailableExtensions();
        return this.availableExtensionCache.contains(string);
    }

    protected void initAvailableExtensions() {
        if (this.availableExtensionCache == null || this.availableExtensionCache.isEmpty()) {
            String string;
            GL gL = this.context.getGL();
            String string2 = new StringBuffer().append(gL.glGetString(7939)).append(" ").append(this.context.getPlatformExtensionsString()).toString();
            StringTokenizer stringTokenizer = new StringTokenizer(string2);
            this.availableExtensionCache = new HashSet(stringTokenizer.countTokens());
            while (stringTokenizer.hasMoreTokens()) {
                string = stringTokenizer.nextToken().trim();
                string = string.intern();
                this.availableExtensionCache.add(string);
            }
            string = gL.glGetString(7938);
            int n = 0;
            int n2 = 0;
            if (!string.startsWith("OpenGL ES ") || string.length() < 13) {
                System.err.println(new StringBuffer().append("glGetString(GL.GL_VERSION) has unsupported format (\"").append(string).append("\")").toString());
            }
            n = Integer.parseInt(string.substring(10, 11));
            n2 = Integer.parseInt(string.substring(12, 13));
            this.availableExtensionCache.add(new StringBuffer().append("GL_ES_VERSION_").append(n).append("_").append(n2).toString());
            if (n == 1 && n2 == 1) {
                this.availableExtensionCache.add("GL_ES_VERSION_1_0");
            }
            this.availableExtensionCache.add("<INTERNAL_DUMMY_PLACEHOLDER>");
        }
    }
}

