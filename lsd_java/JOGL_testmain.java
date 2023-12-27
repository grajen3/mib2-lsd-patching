/*
 * Decompiled with CFR 0.152.
 */
import javax.media.opengl.GL;
import javax.media.opengl.GLContext;
import javax.media.opengl.GLDrawable;
import javax.media.opengl.GLDrawableFactory;

public abstract class JOGL_testmain {
    protected GLDrawable drawable;
    protected GLContext context;

    public void start() {
        this.init();
        int n = 1000;
        while (n-- > 0) {
            this.display();
            this.drawable.swapBuffers();
        }
    }

    public void init() {
        GLDrawableFactory gLDrawableFactory = GLDrawableFactory.getFactory();
        this.drawable = gLDrawableFactory.getGLDrawable(null, null, null);
        this.context = this.drawable.createContext(null);
        this.context.makeCurrent();
        GL gL = this.context.getGL();
        System.err.println(new StringBuffer().append("INIT GL IS: ").append(super.getClass().getName()).toString());
        System.err.println(new StringBuffer().append("GL_VENDOR: ").append(gL.glGetString(7936)).toString());
        System.err.println(new StringBuffer().append("GL_RENDERER: ").append(gL.glGetString(7937)).toString());
        System.err.println(new StringBuffer().append("GL_VERSION: ").append(gL.glGetString(7938)).toString());
        gL.setSwapInterval(1);
        this.initShadersAndProgram();
    }

    abstract boolean initShadersAndProgram() {
    }

    abstract void display() {
    }

    static {
        System.loadLibrary("mibhighvwspi");
    }
}

