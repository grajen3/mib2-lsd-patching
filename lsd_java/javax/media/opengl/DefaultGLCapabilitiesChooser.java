/*
 * Decompiled with CFR 0.152.
 */
package javax.media.opengl;

import com.sun.opengl.impl.Debug;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLCapabilitiesChooser;
import javax.media.opengl.GLException;

public class DefaultGLCapabilitiesChooser
implements GLCapabilitiesChooser {
    private static final boolean DEBUG = Debug.debug("DefaultGLCapabilitiesChooser");

    @Override
    public int chooseCapabilities(GLCapabilities gLCapabilities, GLCapabilities[] gLCapabilitiesArray, int n) {
        int n2;
        GLCapabilities gLCapabilities2;
        int n3;
        int n4;
        int n5;
        if (DEBUG) {
            System.err.println(new StringBuffer().append("Desired: ").append(gLCapabilities).toString());
            for (int i2 = 0; i2 < gLCapabilitiesArray.length; ++i2) {
                System.err.println(new StringBuffer().append("Available ").append(i2).append(": ").append(gLCapabilitiesArray[i2]).toString());
            }
            System.err.println(new StringBuffer().append("Window system's recommended choice: ").append(n).toString());
        }
        if (n >= 0 && n < gLCapabilitiesArray.length && gLCapabilitiesArray[n] != null) {
            if (DEBUG) {
                System.err.println(new StringBuffer().append("Choosing window system's recommended choice of ").append(n).toString());
                System.err.println(gLCapabilitiesArray[n]);
            }
            return n;
        }
        int[] nArray = new int[gLCapabilitiesArray.length];
        int n6 = -2123798529;
        int n7 = 1000;
        int n8 = 500;
        int n9 = 36;
        int n10 = 6;
        int n11 = 1;
        int n12 = 3;
        int n13 = 3;
        for (n5 = 0; n5 < nArray.length; ++n5) {
            nArray[n5] = n6;
        }
        for (n5 = 0; n5 < nArray.length; ++n5) {
            GLCapabilities gLCapabilities3 = gLCapabilitiesArray[n5];
            if (gLCapabilities3 == null || gLCapabilities.getStereo() != gLCapabilities3.getStereo() || gLCapabilities.getPbufferRenderToTexture() && !gLCapabilities3.getPbufferRenderToTexture()) continue;
            n4 = 0;
            n4 += n9 * (gLCapabilities3.getRedBits() + gLCapabilities3.getGreenBits() + gLCapabilities3.getBlueBits() + gLCapabilities3.getAlphaBits() - (gLCapabilities.getRedBits() + gLCapabilities.getGreenBits() + gLCapabilities.getBlueBits() + gLCapabilities.getAlphaBits()));
            n4 += n10 * DefaultGLCapabilitiesChooser.sign(n4) * Math.abs(gLCapabilities3.getDepthBits() - gLCapabilities.getDepthBits());
            n4 += n11 * DefaultGLCapabilitiesChooser.sign(n4) * Math.abs(gLCapabilities3.getAccumRedBits() + gLCapabilities3.getAccumGreenBits() + gLCapabilities3.getAccumBlueBits() + gLCapabilities3.getAccumAlphaBits() - (gLCapabilities.getAccumRedBits() + gLCapabilities.getAccumGreenBits() + gLCapabilities.getAccumBlueBits() + gLCapabilities.getAccumAlphaBits()));
            n4 += n12 * DefaultGLCapabilitiesChooser.sign(n4) * (gLCapabilities3.getStencilBits() - gLCapabilities.getStencilBits());
            if (gLCapabilities3.getDoubleBuffered() != gLCapabilities.getDoubleBuffered()) {
                n4 += DefaultGLCapabilitiesChooser.sign(n4) * n7;
            }
            if (gLCapabilities.getStencilBits() > 0 && gLCapabilities3.getStencilBits() == 0) {
                n4 += DefaultGLCapabilitiesChooser.sign(n4) * n8;
            }
            if (gLCapabilities.getSampleBuffers() != gLCapabilities3.getSampleBuffers() || gLCapabilities.getNumSamples() != gLCapabilities3.getNumSamples()) {
                n4 += DefaultGLCapabilitiesChooser.sign(n4) * n13;
            }
            nArray[n5] = n4;
        }
        n5 = 0;
        int n14 = 0;
        for (n4 = 0; n4 < nArray.length; ++n4) {
            n3 = nArray[n4];
            if (n3 == n6 || !(gLCapabilities2 = gLCapabilitiesArray[n4]).getHardwareAccelerated()) continue;
            n2 = Math.abs(n3);
            if (n5 != 0 && n2 <= n14) continue;
            n5 = 1;
            n14 = n2;
        }
        if (n5 != 0) {
            for (n4 = 0; n4 < nArray.length; ++n4) {
                n3 = nArray[n4];
                if (n3 == n6 || (gLCapabilities2 = gLCapabilitiesArray[n4]).getHardwareAccelerated()) continue;
                if (n3 <= 0) {
                    n3 -= n14;
                } else if (n3 > 0) {
                    n3 += n14;
                }
                nArray[n4] = n3;
            }
        }
        if (DEBUG) {
            System.err.print("Scores: [");
            for (n4 = 0; n4 < gLCapabilitiesArray.length; ++n4) {
                if (n4 > 0) {
                    System.err.print(",");
                }
                System.err.print(new StringBuffer().append(" ").append(nArray[n4]).toString());
            }
            System.err.println(" ]");
        }
        n4 = n6;
        n3 = -1;
        for (int i3 = 0; i3 < nArray.length; ++i3) {
            n2 = nArray[i3];
            if (n2 == n6 || n4 != n6 && (Math.abs(n2) >= Math.abs(n4) || DefaultGLCapabilitiesChooser.sign(n4) >= 0 && DefaultGLCapabilitiesChooser.sign(n2) <= 0)) continue;
            n4 = n2;
            n3 = i3;
        }
        if (n3 < 0) {
            throw new GLException("Unable to select one of the provided GLCapabilities");
        }
        if (DEBUG) {
            System.err.println(new StringBuffer().append("Chosen index: ").append(n3).toString());
            System.err.println("Chosen capabilities:");
            System.err.println(gLCapabilitiesArray[n3]);
        }
        return n3;
    }

    private static int sign(int n) {
        if (n < 0) {
            return -1;
        }
        return 1;
    }
}

