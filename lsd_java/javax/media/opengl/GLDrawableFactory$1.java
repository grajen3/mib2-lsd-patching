/*
 * Decompiled with CFR 0.152.
 */
package javax.media.opengl;

import java.security.PrivilegedAction;

final class GLDrawableFactory$1
implements PrivilegedAction {
    GLDrawableFactory$1() {
    }

    @Override
    public Object run() {
        return System.getProperty("opengl.factory.class.name");
    }
}

