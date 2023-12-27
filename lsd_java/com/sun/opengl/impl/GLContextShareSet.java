/*
 * Decompiled with CFR 0.152.
 */
package com.sun.opengl.impl;

import com.sun.opengl.impl.Debug;
import com.sun.opengl.impl.GLBufferSizeTracker;
import com.sun.opengl.impl.GLContextImpl;
import com.sun.opengl.impl.GLContextShareSet$ShareSet;
import com.sun.opengl.impl.GLObjectTracker;
import java.util.Map;
import java.util.WeakHashMap;
import javax.media.opengl.GLContext;

public class GLContextShareSet {
    private static boolean forceTracking;
    private static final boolean DEBUG;
    private static Map shareMap;
    private static Object dummyValue;
    static /* synthetic */ Class class$com$sun$opengl$impl$GLContextShareSet;
    static final /* synthetic */ boolean $assertionsDisabled;

    public static synchronized void registerSharing(GLContext gLContext, GLContext gLContext2) {
        if (gLContext == null || gLContext2 == null) {
            throw new IllegalArgumentException("Both share1 and share2 must be non-null");
        }
        GLContextShareSet$ShareSet gLContextShareSet$ShareSet = GLContextShareSet.entryFor(gLContext);
        if (gLContextShareSet$ShareSet == null) {
            gLContextShareSet$ShareSet = GLContextShareSet.entryFor(gLContext2);
        }
        if (gLContextShareSet$ShareSet == null) {
            gLContextShareSet$ShareSet = new GLContextShareSet$ShareSet(null);
        }
        gLContextShareSet$ShareSet.add(gLContext);
        gLContextShareSet$ShareSet.add(gLContext2);
        GLContextShareSet.addEntry(gLContext, gLContextShareSet$ShareSet);
        GLContextShareSet.addEntry(gLContext2, gLContextShareSet$ShareSet);
    }

    public static synchronized GLContext getShareContext(GLContext gLContext) {
        GLContextShareSet$ShareSet gLContextShareSet$ShareSet = GLContextShareSet.entryFor(gLContext);
        if (gLContextShareSet$ShareSet == null) {
            return null;
        }
        return gLContextShareSet$ShareSet.getCreatedShare(gLContext);
    }

    public static synchronized void contextCreated(GLContext gLContext) {
        GLContextShareSet$ShareSet gLContextShareSet$ShareSet = GLContextShareSet.entryFor(gLContext);
        if (gLContextShareSet$ShareSet != null) {
            gLContextShareSet$ShareSet.contextCreated(gLContext);
        }
    }

    public static synchronized void contextDestroyed(GLContext gLContext) {
        GLContextShareSet$ShareSet gLContextShareSet$ShareSet = GLContextShareSet.entryFor(gLContext);
        if (gLContextShareSet$ShareSet != null) {
            gLContextShareSet$ShareSet.contextDestroyed(gLContext);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void registerForObjectTracking(GLContext gLContext, GLContext gLContext2, GLContext gLContext3) {
        if (GLContextShareSet.isObjectTrackingEnabled() || GLContextShareSet.isObjectTrackingDebuggingEnabled()) {
            GLContextImpl gLContextImpl = null;
            GLContextImpl gLContextImpl2 = null;
            GLObjectTracker gLObjectTracker = null;
            Class clazz = class$com$sun$opengl$impl$GLContextShareSet == null ? (class$com$sun$opengl$impl$GLContextShareSet = GLContextShareSet.class$("com.sun.opengl.impl.GLContextShareSet")) : class$com$sun$opengl$impl$GLContextShareSet;
            synchronized (clazz) {
                if (gLContext2 == null) {
                    throw new IllegalArgumentException("new context must not be null");
                }
                if (gLContext != null && gLContext2 != null && GLContextShareSet.entryFor(gLContext) != GLContextShareSet.entryFor(gLContext2)) {
                    throw new IllegalArgumentException("old and new contexts must be able to share textures and display lists");
                }
                gLContextImpl = (GLContextImpl)gLContext;
                gLContextImpl2 = (GLContextImpl)gLContext2;
                GLObjectTracker gLObjectTracker2 = null;
                GLContextImpl gLContextImpl3 = (GLContextImpl)gLContext3;
                if (gLContextImpl3 != null) {
                    gLObjectTracker2 = gLContextImpl3.getDeletedObjectTracker();
                }
                if (gLObjectTracker2 == null) {
                    gLObjectTracker2 = new GLObjectTracker();
                    if (DEBUG) {
                        System.err.println(new StringBuffer().append("Created deletedObjectTracker ").append(gLObjectTracker2).append(" because ").append(gLContextImpl3 == null ? "shareImpl was null" : new StringBuffer().append("shareImpl's (").append(gLContextImpl3).append(") deletedObjectTracker was null").toString()).toString());
                    }
                    if (gLContextImpl3 != null) {
                        gLContextImpl3.setDeletedObjectTracker(gLObjectTracker2);
                        if (DEBUG) {
                            System.err.println(new StringBuffer().append("Set deletedObjectTracker ").append(gLObjectTracker2).append(" in shareImpl context ").append(gLContextImpl3).toString());
                        }
                    }
                }
                gLContextImpl2.setDeletedObjectTracker(gLObjectTracker2);
                if (DEBUG) {
                    System.err.println(new StringBuffer().append("Set deletedObjectTracker ").append(gLObjectTracker2).append(" in impl2 context ").append(gLContextImpl2).toString());
                }
            }
            clazz = class$com$sun$opengl$impl$GLContextShareSet == null ? (class$com$sun$opengl$impl$GLContextShareSet = GLContextShareSet.class$("com.sun.opengl.impl.GLContextShareSet")) : class$com$sun$opengl$impl$GLContextShareSet;
            synchronized (clazz) {
                if (gLContextImpl != null) {
                    gLObjectTracker = gLContextImpl.getObjectTracker();
                    if (!$assertionsDisabled && gLObjectTracker == null) {
                        throw new AssertionError((Object)"registerForObjectTracking was not called properly for the older context");
                    }
                }
                if (gLObjectTracker == null) {
                    gLObjectTracker = new GLObjectTracker();
                }
                gLContextImpl2.setObjectTracker(gLObjectTracker);
            }
        }
    }

    public static void registerForBufferObjectSharing(GLContext gLContext, GLContext gLContext2) {
        GLContextImpl gLContextImpl = (GLContextImpl)gLContext;
        GLContextImpl gLContextImpl2 = (GLContextImpl)gLContext2;
        GLBufferSizeTracker gLBufferSizeTracker = null;
        if (gLContextImpl != null) {
            gLBufferSizeTracker = gLContextImpl.getBufferSizeTracker();
            if (!$assertionsDisabled && gLBufferSizeTracker == null) {
                throw new AssertionError((Object)"registerForBufferObjectSharing was not called properly for the older context, or has a bug in it");
            }
        }
        if (gLBufferSizeTracker == null) {
            gLBufferSizeTracker = new GLBufferSizeTracker();
        }
        gLContextImpl2.setBufferSizeTracker(gLBufferSizeTracker);
    }

    private static GLContextShareSet$ShareSet entryFor(GLContext gLContext) {
        return (GLContextShareSet$ShareSet)shareMap.get(gLContext);
    }

    private static void addEntry(GLContext gLContext, GLContextShareSet$ShareSet gLContextShareSet$ShareSet) {
        if (shareMap.get(gLContext) == null) {
            shareMap.put(gLContext, gLContextShareSet$ShareSet);
        }
    }

    private static boolean isObjectTrackingEnabled() {
        return GLContextShareSet.isObjectTrackingDebuggingEnabled();
    }

    private static boolean isObjectTrackingDebuggingEnabled() {
        return forceTracking;
    }

    static /* synthetic */ Object access$000() {
        return dummyValue;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        $assertionsDisabled = !(class$com$sun$opengl$impl$GLContextShareSet == null ? (class$com$sun$opengl$impl$GLContextShareSet = GLContextShareSet.class$("com.sun.opengl.impl.GLContextShareSet")) : class$com$sun$opengl$impl$GLContextShareSet).desiredAssertionStatus();
        forceTracking = Debug.isPropertyDefined("jogl.glcontext.forcetracking");
        DEBUG = Debug.debug("GLContextShareSet");
        shareMap = new WeakHashMap();
        dummyValue = new Object();
    }
}

