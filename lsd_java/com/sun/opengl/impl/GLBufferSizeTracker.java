/*
 * Decompiled with CFR 0.152.
 */
package com.sun.opengl.impl;

import com.sun.opengl.impl.Debug;
import com.sun.opengl.impl.GLBufferStateTracker;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.media.opengl.GL;
import javax.media.opengl.GLException;

public class GLBufferSizeTracker {
    private Map bufferSizeMap = Collections.synchronizedMap(new HashMap());
    private static final boolean DEBUG = Debug.debug("GLBufferSizeTracker");

    public void setBufferSize(GLBufferStateTracker gLBufferStateTracker, int n, GL gL, int n2) {
        int n3 = gLBufferStateTracker.getBoundBufferObject(n, gL);
        boolean bl = gLBufferStateTracker.isBoundBufferObjectKnown(n);
        if (bl) {
            if (n3 == 0) {
                throw new GLException(new StringBuffer().append("Error: no OpenGL buffer object appears to be bound to target 0x").append(Integer.toHexString(n)).toString());
            }
            this.bufferSizeMap.put(new Integer(n3), new Integer(n2));
        }
    }

    public int getBufferSize(GLBufferStateTracker gLBufferStateTracker, int n, GL gL) {
        int n2 = gLBufferStateTracker.getBoundBufferObject(n, gL);
        boolean bl = gLBufferStateTracker.isBoundBufferObjectKnown(n);
        if (bl) {
            if (n2 == 0) {
                throw new GLException(new StringBuffer().append("Error: no OpenGL buffer object appears to be bound to target 0x").append(Integer.toHexString(n)).toString());
            }
            Integer n3 = new Integer(n2);
            Integer n4 = (Integer)this.bufferSizeMap.get(n3);
            if (n4 == null) {
                int[] nArray = new int[1];
                gL.glGetBufferParameteriv(n, 1686568960, nArray, 0);
                if (nArray[0] == 0) {
                    throw new GLException("Error: buffer size returned by glGetBufferParameterivARB was zero; probably application error");
                }
                n4 = new Integer(nArray[0]);
                this.bufferSizeMap.put(n3, n4);
                if (DEBUG) {
                    System.err.println(new StringBuffer().append("GLBufferSizeTracker.getBufferSize(): made slow query to cache size ").append(nArray[0]).append(" for buffer ").append(n2).toString());
                }
            }
            return n4;
        }
        int[] nArray = new int[1];
        gL.glGetBufferParameteriv(n, 1686568960, nArray, 0);
        if (DEBUG) {
            System.err.println("GLBufferSizeTracker.getBufferSize(): no cached buffer information");
        }
        return nArray[0];
    }

    public void clearCachedBufferSizes() {
        this.bufferSizeMap.clear();
    }
}

