/*
 * Decompiled with CFR 0.152.
 */
package javax.media.opengl;

import javax.media.opengl.GLException;

public class GLCapabilities
implements Cloneable {
    public static final boolean DEFAULT_DOUBLE_BUFFERED;
    public static final boolean DEFAULT_STEREO;
    public static final boolean DEFAULT_HARDWARE_ACCELERATED;
    public static final int DEFAULT_DEPTH_BITS;
    public static final int DEFAULT_STENCIL_BITS;
    public static final int DEFAULT_RED_BITS;
    public static final int DEFAULT_GREEN_BITS;
    public static final int DEFAULT_BLUE_BITS;
    public static final int DEFAULT_ALPHA_BITS;
    public static final int DEFAULT_ACCUM_RED_BITS;
    public static final int DEFAULT_ACCUM_GREEN_BITS;
    public static final int DEFAULT_ACCUM_BLUE_BITS;
    public static final int DEFAULT_ACCUM_ALPHA_BITS;
    public static final boolean DEFAULT_SAMPLE_BUFFERS;
    public static final int DEFAULT_NUM_SAMPLES;
    public static final boolean DEFAULT_PBUFFER_RENDER_TO_TEXTURE;
    public static final boolean DEFAULT_PBUFFER_RENDER_TO_TEXTURE_RECTANGLE;
    public static final boolean DEFAULT_PBUFFER_FLOATING_POINT_BUFFERS;
    private boolean doubleBuffered = true;
    private boolean stereo = false;
    private boolean hardwareAccelerated = true;
    private int depthBits = 16;
    private int stencilBits = 0;
    private int redBits = 8;
    private int greenBits = 8;
    private int blueBits = 8;
    private int alphaBits = 0;
    private int accumRedBits = 0;
    private int accumGreenBits = 0;
    private int accumBlueBits = 0;
    private int accumAlphaBits = 0;
    private boolean sampleBuffers = false;
    private int numSamples = 2;
    private boolean pbufferFloatingPointBuffers = false;
    private boolean pbufferRenderToTexture = false;
    private boolean pbufferRenderToTextureRectangle = false;

    public Object clone() {
        try {
            return super.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new GLException(cloneNotSupportedException);
        }
    }

    public boolean getDoubleBuffered() {
        return this.doubleBuffered;
    }

    public void setDoubleBuffered(boolean bl) {
        this.doubleBuffered = bl;
    }

    public boolean getStereo() {
        return this.stereo;
    }

    public void setStereo(boolean bl) {
        this.stereo = bl;
    }

    public boolean getHardwareAccelerated() {
        return this.hardwareAccelerated;
    }

    public void setHardwareAccelerated(boolean bl) {
        this.hardwareAccelerated = bl;
    }

    public int getDepthBits() {
        return this.depthBits;
    }

    public void setDepthBits(int n) {
        this.depthBits = n;
    }

    public int getStencilBits() {
        return this.stencilBits;
    }

    public void setStencilBits(int n) {
        this.stencilBits = n;
    }

    public int getRedBits() {
        return this.redBits;
    }

    public void setRedBits(int n) {
        this.redBits = n;
    }

    public int getGreenBits() {
        return this.greenBits;
    }

    public void setGreenBits(int n) {
        this.greenBits = n;
    }

    public int getBlueBits() {
        return this.blueBits;
    }

    public void setBlueBits(int n) {
        this.blueBits = n;
    }

    public int getAlphaBits() {
        return this.alphaBits;
    }

    public void setAlphaBits(int n) {
        this.alphaBits = n;
    }

    public int getAccumRedBits() {
        return this.accumRedBits;
    }

    public void setAccumRedBits(int n) {
        this.accumRedBits = n;
    }

    public int getAccumGreenBits() {
        return this.accumGreenBits;
    }

    public void setAccumGreenBits(int n) {
        this.accumGreenBits = n;
    }

    public int getAccumBlueBits() {
        return this.accumBlueBits;
    }

    public void setAccumBlueBits(int n) {
        this.accumBlueBits = n;
    }

    public int getAccumAlphaBits() {
        return this.accumAlphaBits;
    }

    public void setAccumAlphaBits(int n) {
        this.accumAlphaBits = n;
    }

    public void setSampleBuffers(boolean bl) {
        this.sampleBuffers = bl;
    }

    public boolean getSampleBuffers() {
        return this.sampleBuffers;
    }

    public void setNumSamples(int n) {
        this.numSamples = n;
    }

    public int getNumSamples() {
        return this.numSamples;
    }

    public void setPbufferFloatingPointBuffers(boolean bl) {
        this.pbufferFloatingPointBuffers = bl;
    }

    public boolean getPbufferFloatingPointBuffers() {
        return this.pbufferFloatingPointBuffers;
    }

    public void setPbufferRenderToTexture(boolean bl) {
        this.pbufferRenderToTexture = bl;
    }

    public boolean getPbufferRenderToTexture() {
        return this.pbufferRenderToTexture;
    }

    public void setPbufferRenderToTextureRectangle(boolean bl) {
        this.pbufferRenderToTextureRectangle = bl;
    }

    public boolean getPbufferRenderToTextureRectangle() {
        return this.pbufferRenderToTextureRectangle;
    }

    public String toString() {
        return new StringBuffer().append("GLCapabilities[DoubleBuffered: ").append(this.doubleBuffered).append(", Stereo: ").append(this.stereo).append(", HardwareAccelerated: ").append(this.hardwareAccelerated).append(", DepthBits: ").append(this.depthBits).append(", StencilBits: ").append(this.stencilBits).append(", Red: ").append(this.redBits).append(", Green: ").append(this.greenBits).append(", Blue: ").append(this.blueBits).append(", Alpha: ").append(this.alphaBits).append(", Red Accum: ").append(this.accumRedBits).append(", Green Accum: ").append(this.accumGreenBits).append(", Blue Accum: ").append(this.accumBlueBits).append(", Alpha Accum: ").append(this.accumAlphaBits).append(", Multisample: ").append(this.sampleBuffers).append(this.sampleBuffers ? new StringBuffer().append(", Num samples: ").append(this.numSamples).toString() : "").append(", pbufferRenderToTexture: ").append(this.pbufferRenderToTexture).append("]").toString();
    }
}

