/*
 * Decompiled with CFR 0.152.
 */
package javax.media.opengl;

import java.security.AccessController;
import javax.media.opengl.AbstractGraphicsConfiguration;
import javax.media.opengl.AbstractGraphicsDevice;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLCapabilitiesChooser;
import javax.media.opengl.GLContext;
import javax.media.opengl.GLDrawable;
import javax.media.opengl.GLDrawableFactory$1;
import javax.media.opengl.GLException;
import javax.media.opengl.GLPbuffer;

public abstract class GLDrawableFactory {
    private static GLDrawableFactory factory;

    protected GLDrawableFactory() {
    }

    public static GLDrawableFactory getFactory() {
        if (factory == null) {
            try {
                String string = (String)AccessController.doPrivileged(new GLDrawableFactory$1());
                String string2 = System.getProperty("os.name");
                String string3 = string2.toLowerCase();
                Class clazz = null;
                if (string != null) {
                    clazz = Class.forName(string);
                } else if (string3.startsWith("wind")) {
                    clazz = Class.forName("com.sun.opengl.impl.windows.WindowsGLDrawableFactory");
                } else if (string3.startsWith("qnx")) {
                    clazz = Class.forName("com.sun.opengl.impl.qnx.QNXGLDrawableFactory");
                } else {
                    throw new GLException(new StringBuffer().append("OS ").append(string2).append(" not yet supported").toString());
                }
                if (clazz == null) {
                    throw new GLException(new StringBuffer().append("OS ").append(string2).append(" not yet supported").toString());
                }
                factory = (GLDrawableFactory)clazz.newInstance();
            }
            catch (Exception exception) {
                throw new GLException(exception);
            }
        }
        return factory;
    }

    public abstract AbstractGraphicsConfiguration chooseGraphicsConfiguration(GLCapabilities gLCapabilities, GLCapabilitiesChooser gLCapabilitiesChooser, AbstractGraphicsDevice abstractGraphicsDevice) {
    }

    public abstract GLDrawable getGLDrawable(Object object, GLCapabilities gLCapabilities, GLCapabilitiesChooser gLCapabilitiesChooser) {
    }

    public abstract boolean canCreateGLPbuffer() {
    }

    public abstract GLPbuffer createGLPbuffer(GLCapabilities gLCapabilities, GLCapabilitiesChooser gLCapabilitiesChooser, int n, int n2, GLContext gLContext) {
    }

    public abstract GLContext createExternalGLContext() {
    }

    public abstract boolean canCreateExternalGLDrawable() {
    }

    public abstract GLDrawable createExternalGLDrawable() {
    }
}

