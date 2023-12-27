/*
 * Decompiled with CFR 0.152.
 */
package com.sun.opengl.impl;

import com.sun.opengl.impl.GLContextImpl;
import com.sun.opengl.impl.GLContextShareSet;
import com.sun.opengl.impl.GLContextShareSet$1;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import javax.media.opengl.GLContext;

class GLContextShareSet$ShareSet {
    private Map allShares = new WeakHashMap();
    private Map createdShares = new WeakHashMap();
    private Map destroyedShares = new WeakHashMap();
    static final /* synthetic */ boolean $assertionsDisabled;

    private GLContextShareSet$ShareSet() {
    }

    public void add(GLContext gLContext) {
        if (this.allShares.put(gLContext, GLContextShareSet.access$000()) == null) {
            if (((GLContextImpl)gLContext).isCreated()) {
                this.createdShares.put(gLContext, GLContextShareSet.access$000());
            } else {
                this.destroyedShares.put(gLContext, GLContextShareSet.access$000());
            }
        }
    }

    public GLContext getCreatedShare(GLContext gLContext) {
        Iterator iterator = this.createdShares.keySet().iterator();
        while (iterator.hasNext()) {
            GLContext gLContext2 = (GLContext)iterator.next();
            if (gLContext2 == gLContext) continue;
            return gLContext2;
        }
        return null;
    }

    public void contextCreated(GLContext gLContext) {
        Object object = this.destroyedShares.remove(gLContext);
        if (!$assertionsDisabled && object == null) {
            throw new AssertionError((Object)new StringBuffer().append("State of ShareSet corrupted; thought context ").append(gLContext).append(" should have been in destroyed set but wasn't").toString());
        }
        object = this.createdShares.put(gLContext, GLContextShareSet.access$000());
        if (!$assertionsDisabled && object != null) {
            throw new AssertionError((Object)new StringBuffer().append("State of ShareSet corrupted; thought context ").append(gLContext).append(" shouldn't have been in created set but was").toString());
        }
    }

    public void contextDestroyed(GLContext gLContext) {
        Object object = this.createdShares.remove(gLContext);
        if (!$assertionsDisabled && object == null) {
            throw new AssertionError((Object)new StringBuffer().append("State of ShareSet corrupted; thought context ").append(gLContext).append(" should have been in created set but wasn't").toString());
        }
        object = this.destroyedShares.put(gLContext, GLContextShareSet.access$000());
        if (!$assertionsDisabled && object != null) {
            throw new AssertionError((Object)new StringBuffer().append("State of ShareSet corrupted; thought context ").append(gLContext).append(" shouldn't have been in destroyed set but was").toString());
        }
    }

    /* synthetic */ GLContextShareSet$ShareSet(GLContextShareSet$1 gLContextShareSet$1) {
        this();
    }

    static {
        $assertionsDisabled = !(GLContextShareSet.class$com$sun$opengl$impl$GLContextShareSet == null ? (GLContextShareSet.class$com$sun$opengl$impl$GLContextShareSet = GLContextShareSet.class$("com.sun.opengl.impl.GLContextShareSet")) : GLContextShareSet.class$com$sun$opengl$impl$GLContextShareSet).desiredAssertionStatus();
    }
}

