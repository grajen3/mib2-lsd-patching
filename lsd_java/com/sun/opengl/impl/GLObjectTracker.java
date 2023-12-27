/*
 * Decompiled with CFR 0.152.
 */
package com.sun.opengl.impl;

import com.sun.opengl.impl.Debug;
import com.sun.opengl.impl.GLContextImpl;
import com.sun.opengl.impl.GLObjectTracker$1;
import com.sun.opengl.impl.GLObjectTracker$2;
import com.sun.opengl.impl.GLObjectTracker$3;
import com.sun.opengl.impl.GLObjectTracker$4;
import com.sun.opengl.impl.GLObjectTracker$5;
import com.sun.opengl.impl.GLObjectTracker$6;
import com.sun.opengl.impl.GLObjectTracker$Deleter;
import com.sun.opengl.impl.GLObjectTracker$ObjectList;
import java.nio.IntBuffer;
import javax.media.opengl.GL;
import javax.media.opengl.GLContext;
import javax.media.opengl.GLException;

public class GLObjectTracker {
    private static final boolean DEBUG = Debug.debug("GLObjectTracker");
    private static final int BUFFERS;
    private static final int FRAMEBUFFERS;
    private static final int PROGRAM_OBJECTS;
    private static final int RENDERBUFFERS;
    private static final int SHADER_OBJECTS;
    private static final int TEXTURES;
    private static final int NUM_OBJECT_TYPES;
    private GLObjectTracker$ObjectList[] lists = new GLObjectTracker$ObjectList[6];
    private int refCount;
    private boolean dirty;

    public synchronized void addBuffers(int n, IntBuffer intBuffer) {
        this.add(this.getList(0), n, intBuffer);
    }

    public synchronized void addBuffers(int n, int[] nArray, int n2) {
        this.add(this.getList(0), n, nArray, n2);
    }

    public synchronized void addFramebuffers(int n, IntBuffer intBuffer) {
        this.add(this.getList(1), n, intBuffer);
    }

    public synchronized void addFramebuffers(int n, int[] nArray, int n2) {
        this.add(this.getList(1), n, nArray, n2);
    }

    public synchronized void addProgramObject(int n) {
        this.add(this.getList(2), n, 1);
    }

    public synchronized void addRenderbuffers(int n, IntBuffer intBuffer) {
        this.add(this.getList(3), n, intBuffer);
    }

    public synchronized void addRenderbuffers(int n, int[] nArray, int n2) {
        this.add(this.getList(3), n, nArray, n2);
    }

    public synchronized void addShaderObject(int n) {
        this.add(this.getList(4), n, 1);
    }

    public synchronized void addTextures(int n, IntBuffer intBuffer) {
        this.add(this.getList(5), n, intBuffer);
    }

    public synchronized void addTextures(int n, int[] nArray, int n2) {
        this.add(this.getList(5), n, nArray, n2);
    }

    public synchronized void removeBuffers(int n, IntBuffer intBuffer) {
        this.remove(this.getList(0), n, intBuffer);
    }

    public synchronized void removeBuffers(int n, int[] nArray, int n2) {
        this.remove(this.getList(0), n, nArray, n2);
    }

    public synchronized void removeFramebuffers(int n, IntBuffer intBuffer) {
        this.remove(this.getList(1), n, intBuffer);
    }

    public synchronized void removeFramebuffers(int n, int[] nArray, int n2) {
        this.remove(this.getList(1), n, nArray, n2);
    }

    public synchronized void removeProgramObject(int n) {
        this.remove(this.getList(2), n, 1);
    }

    public synchronized void removeRenderbuffers(int n, IntBuffer intBuffer) {
        this.remove(this.getList(3), n, intBuffer);
    }

    public synchronized void removeRenderbuffers(int n, int[] nArray, int n2) {
        this.remove(this.getList(3), n, nArray, n2);
    }

    public synchronized void removeShaderObject(int n) {
        this.remove(this.getList(4), n, 1);
    }

    public synchronized void removeTextures(int n, IntBuffer intBuffer) {
        this.remove(this.getList(5), n, intBuffer);
    }

    public synchronized void removeTextures(int n, int[] nArray, int n2) {
        this.remove(this.getList(5), n, nArray, n2);
    }

    public synchronized void transferAll(GLObjectTracker gLObjectTracker) {
        for (int i2 = 0; i2 < this.lists.length; ++i2) {
            this.getList(i2).addAll(gLObjectTracker.lists[i2]);
            if (gLObjectTracker.lists[i2] == null) continue;
            gLObjectTracker.lists[i2].clear();
        }
        this.dirty = true;
    }

    public synchronized void ref() {
        ++this.refCount;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void unref(GLObjectTracker gLObjectTracker) {
        boolean bl = false;
        Object object = this;
        synchronized (object) {
            if (--this.refCount == 0) {
                bl = true;
            }
        }
        if (bl) {
            Object object2;
            object = GLContext.getCurrent();
            if (object != null && object instanceof GLContextImpl) {
                object2 = (GLContextImpl)object;
                if (gLObjectTracker != null && gLObjectTracker == ((GLContextImpl)object2).getDeletedObjectTracker()) {
                    try {
                        this.delete(((GLContextImpl)object2).getGL());
                        return;
                    }
                    catch (GLException gLException) {
                        gLObjectTracker.transferAll(this);
                        throw gLException;
                    }
                }
            }
            if (DEBUG) {
                object2 = null;
                if (object == null) {
                    object2 = "current context was null";
                } else if (!(object instanceof GLContextImpl)) {
                    object2 = "current context was not a GLContextImpl";
                } else if (gLObjectTracker == null) {
                    object2 = "no current deletedObjectPool";
                } else if (gLObjectTracker != ((GLContextImpl)object).getDeletedObjectTracker()) {
                    object2 = "deletedObjectTracker didn't match";
                    if (((GLContextImpl)object).getDeletedObjectTracker() == null) {
                        object2 = new StringBuffer().append((String)object2).append(" (other was null)").toString();
                    }
                } else {
                    object2 = "unknown reason";
                }
                System.err.println(new StringBuffer().append("Deferred destruction of server-side OpenGL objects into ").append(gLObjectTracker).append(": ").append((String)object2).toString());
            }
            if (gLObjectTracker != null) {
                gLObjectTracker.transferAll(this);
            }
        }
    }

    public void clean(GL gL) {
        if (this.dirty) {
            try {
                this.delete(gL);
                this.dirty = false;
            }
            catch (GLException gLException) {
                // empty catch block
            }
        }
    }

    private void add(GLObjectTracker$ObjectList gLObjectTracker$ObjectList, int n, IntBuffer intBuffer) {
        int n2 = intBuffer.position();
        for (int i2 = 0; i2 < n; ++i2) {
            gLObjectTracker$ObjectList.add(intBuffer.get(n2 + i2));
        }
    }

    private void add(GLObjectTracker$ObjectList gLObjectTracker$ObjectList, int n, int[] nArray, int n2) {
        for (int i2 = 0; i2 < n; ++i2) {
            gLObjectTracker$ObjectList.add(nArray[i2 + n2]);
        }
    }

    private void add(GLObjectTracker$ObjectList gLObjectTracker$ObjectList, int n, int n2) {
        for (int i2 = 0; i2 < n2; ++i2) {
            gLObjectTracker$ObjectList.add(n + i2);
        }
    }

    private void remove(GLObjectTracker$ObjectList gLObjectTracker$ObjectList, int n, IntBuffer intBuffer) {
        int n2 = intBuffer.position();
        for (int i2 = 0; i2 < n; ++i2) {
            gLObjectTracker$ObjectList.remove(intBuffer.get(n2 + i2));
        }
    }

    private void remove(GLObjectTracker$ObjectList gLObjectTracker$ObjectList, int n, int[] nArray, int n2) {
        for (int i2 = 0; i2 < n; ++i2) {
            gLObjectTracker$ObjectList.remove(nArray[i2 + n2]);
        }
    }

    private void remove(GLObjectTracker$ObjectList gLObjectTracker$ObjectList, int n, int n2) {
        for (int i2 = 0; i2 < n2; ++i2) {
            gLObjectTracker$ObjectList.remove(n + i2);
        }
    }

    private GLObjectTracker$ObjectList getList(int n) {
        GLObjectTracker$ObjectList gLObjectTracker$ObjectList = this.lists[n];
        if (gLObjectTracker$ObjectList == null) {
            GLObjectTracker$Deleter gLObjectTracker$Deleter = null;
            String string = null;
            switch (n) {
                case 0: {
                    gLObjectTracker$Deleter = new GLObjectTracker$1(this);
                    string = "buffer";
                    break;
                }
                case 1: {
                    gLObjectTracker$Deleter = new GLObjectTracker$2(this);
                    string = "framebuffer";
                    break;
                }
                case 2: {
                    gLObjectTracker$Deleter = new GLObjectTracker$3(this);
                    string = "program object";
                    break;
                }
                case 3: {
                    gLObjectTracker$Deleter = new GLObjectTracker$4(this);
                    string = "renderbuffer";
                    break;
                }
                case 4: {
                    gLObjectTracker$Deleter = new GLObjectTracker$5(this);
                    string = "shader object";
                    break;
                }
                case 5: {
                    gLObjectTracker$Deleter = new GLObjectTracker$6(this);
                    string = "texture";
                    break;
                }
                default: {
                    throw new InternalError(new StringBuffer().append("Unexpected OpenGL object type ").append(n).toString());
                }
            }
            gLObjectTracker$ObjectList = new GLObjectTracker$ObjectList(gLObjectTracker$Deleter);
            gLObjectTracker$ObjectList.setName(string);
            this.lists[n] = gLObjectTracker$ObjectList;
        }
        return gLObjectTracker$ObjectList;
    }

    private void delete(GL gL) {
        for (int i2 = 0; i2 < this.lists.length; ++i2) {
            GLObjectTracker$ObjectList gLObjectTracker$ObjectList = this.lists[i2];
            if (gLObjectTracker$ObjectList == null) continue;
            gLObjectTracker$ObjectList.delete(gL);
            this.lists[i2] = null;
        }
    }

    static /* synthetic */ boolean access$000() {
        return DEBUG;
    }
}

