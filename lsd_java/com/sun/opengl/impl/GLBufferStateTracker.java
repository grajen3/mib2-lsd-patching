/*
 * Decompiled with CFR 0.152.
 */
package com.sun.opengl.impl;

import com.sun.opengl.impl.Debug;
import java.util.HashMap;
import java.util.Map;
import javax.media.opengl.GL;

public class GLBufferStateTracker {
    private static final boolean DEBUG = Debug.debug("GLBufferStateTracker");
    private static final Integer arrayBufferEnum = new Integer(-1836580864);
    private static final Integer elementArrayBufferEnum = new Integer(-1819803648);
    private static final Integer zero = new Integer(0);
    private Map bindingMap = new HashMap();
    private int[] bufTmp = new int[1];

    public GLBufferStateTracker() {
        this.bindingMap.put(arrayBufferEnum, zero);
        this.bindingMap.put(elementArrayBufferEnum, zero);
    }

    public void setBoundBufferObject(int n, int n2) {
        Integer n3 = GLBufferStateTracker.box(n);
        this.bindingMap.put(n3, GLBufferStateTracker.box(n2));
    }

    public int getBoundBufferObject(int n, GL gL) {
        Integer n2 = GLBufferStateTracker.box(n);
        Integer n3 = (Integer)this.bindingMap.get(n2);
        if (n3 == null) {
            boolean bl = true;
            int n4 = 0;
            switch (n) {
                case 34962: {
                    n4 = -1803026432;
                    break;
                }
                case 34963: {
                    n4 = -1786249216;
                    break;
                }
                default: {
                    bl = false;
                }
            }
            if (bl) {
                gL.glGetIntegerv(n4, this.bufTmp, 0);
                if (DEBUG) {
                    System.err.println(new StringBuffer().append("GLBufferStateTracker.getBoundBufferObject(): queried bound buffer ").append(this.bufTmp[0]).append(" for query target 0x").append(Integer.toHexString(n4)).toString());
                }
                this.setBoundBufferObject(n, this.bufTmp[0]);
                return this.getBoundBufferObject(n, gL);
            }
            return 0;
        }
        return n3;
    }

    public boolean isBoundBufferObjectKnown(int n) {
        return this.bindingMap.get(GLBufferStateTracker.box(n)) != null;
    }

    public void clearBufferObjectState() {
        this.bindingMap.clear();
    }

    private static Integer box(int n) {
        switch (n) {
            case 0: {
                return zero;
            }
            case 34962: {
                return arrayBufferEnum;
            }
            case 34963: {
                return elementArrayBufferEnum;
            }
        }
        return new Integer(n);
    }
}

