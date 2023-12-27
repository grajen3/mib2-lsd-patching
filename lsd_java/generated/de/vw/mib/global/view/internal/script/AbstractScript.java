/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.global.view.internal.script;

import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.view.internal.script.AbstractScriptWidget;
import org.dsi.ifc.global.ResourceLocator;

public class AbstractScript
extends AbstractScriptWidget {
    private static boolean[] outTempBoolean = new boolean[0];
    private static CharSequence[] outTempCharSequence = new CharSequence[0];
    private static Image[][] outTempImageArray = new Image[0][];
    private static Image[] outTempImage = new Image[0];
    private static int[] outTempInt = new int[0];
    private static int[][] outTempIntArray = new int[0][];
    private static CharSequence[][] outTempCharSequenceArray = new CharSequence[0][];
    private static Color[][] outTempColorArray = new Color[0][];
    private static boolean[][] outTempBooleanArray = new boolean[0][];
    private static float[] outTempFloat = new float[0];
    private static Color[] outTempColor = new Color[0];
    private static ResourceLocator[] outTempResourceLocator = new ResourceLocator[0];
    private static Insets[] outTempInsets = new Insets[0];

    static void setBooleanToOut(int n, boolean bl) {
        outTempBoolean = (boolean[])AbstractScript.resizeArray(outTempBoolean, n);
        AbstractScript.outTempBoolean[n] = bl;
    }

    public static boolean getBooleanToOut(int n) {
        if (n < 0 || n >= outTempBoolean.length) {
            return false;
        }
        return outTempBoolean[n];
    }

    static void setStringToOut(int n, CharSequence charSequence) {
        outTempCharSequence = (CharSequence[])AbstractScript.resizeArray(outTempCharSequence, n);
        AbstractScript.outTempCharSequence[n] = charSequence;
    }

    public static String getStringToOut(int n) {
        if (n < 0 || n >= outTempCharSequence.length) {
            return null;
        }
        return ((Object)outTempCharSequence[n]).toString();
    }

    static void setImageArrayToOut(int n, Image[] imageArray) {
        outTempImageArray = (Image[][])AbstractScript.resizeArray(outTempImageArray, n);
        AbstractScript.outTempImageArray[n] = imageArray;
    }

    public static Image[] getImageArrayToOut(int n) {
        if (n < 0 || n >= outTempImageArray.length) {
            return null;
        }
        return outTempImageArray[n];
    }

    static void setImageToOut(int n, Image image) {
        outTempImage = (Image[])AbstractScript.resizeArray(outTempImage, n);
        AbstractScript.outTempImage[n] = image;
    }

    public static Image getImageToOut(int n) {
        if (n < 0 || n >= outTempImage.length) {
            return null;
        }
        return outTempImage[n];
    }

    static void setIntToOut(int n, int n2) {
        outTempInt = (int[])AbstractScript.resizeArray(outTempInt, n);
        AbstractScript.outTempInt[n] = n2;
    }

    public static int getIntToOut(int n) {
        if (n < 0 || n >= outTempInt.length) {
            return 0;
        }
        return outTempInt[n];
    }

    static void setIntArrayToOut(int n, int[] nArray) {
        outTempIntArray = (int[][])AbstractScript.resizeArray(outTempIntArray, n);
        AbstractScript.outTempIntArray[n] = nArray;
    }

    public static int[] getIntArrayToOut(int n) {
        if (n < 0 || n >= outTempIntArray.length) {
            return null;
        }
        return outTempIntArray[n];
    }

    static void setStringArrayToOut(int n, CharSequence[] charSequenceArray) {
        outTempCharSequenceArray = (CharSequence[][])AbstractScript.resizeArray(outTempCharSequenceArray, n);
        AbstractScript.outTempCharSequenceArray[n] = charSequenceArray;
    }

    public static String[] getStringArrayToOut(int n) {
        if (n < 0 || n >= outTempCharSequenceArray.length) {
            return null;
        }
        String[] stringArray = new String[outTempCharSequenceArray[n].length];
        for (int i2 = 0; i2 < outTempCharSequenceArray[n].length; ++i2) {
            stringArray[i2] = ((Object)outTempCharSequenceArray[n][i2]).toString();
        }
        return stringArray;
    }

    static void setColorArrayToOut(int n, Color[] colorArray) {
        outTempColorArray = (Color[][])AbstractScript.resizeArray(outTempColorArray, n);
        AbstractScript.outTempColorArray[n] = colorArray;
    }

    public static Color[] getColorArrayToOut(int n) {
        if (n < 0 || n >= outTempColorArray.length) {
            return null;
        }
        return outTempColorArray[n];
    }

    static void setBooleanArrayToOut(int n, boolean[] blArray) {
        outTempBooleanArray = (boolean[][])AbstractScript.resizeArray(outTempBooleanArray, n);
        AbstractScript.outTempBooleanArray[n] = blArray;
    }

    public static boolean[] getBooleanArrayToOut(int n) {
        if (n < 0 || n >= outTempBooleanArray.length) {
            return null;
        }
        return outTempBooleanArray[n];
    }

    static void setFloatToOut(int n, float f2) {
        outTempFloat = (float[])AbstractScript.resizeArray(outTempFloat, n);
        AbstractScript.outTempFloat[n] = f2;
    }

    public static float getFloatToOut(int n) {
        if (n < 0 || n >= outTempFloat.length) {
            return 0.0f;
        }
        return outTempFloat[n];
    }

    static void setColorToOut(int n, Color color) {
        outTempColor = (Color[])AbstractScript.resizeArray(outTempColor, n);
        AbstractScript.outTempColor[n] = color;
    }

    public static Color getColorToOut(int n) {
        if (n < 0 || n >= outTempColor.length) {
            return null;
        }
        return outTempColor[n];
    }

    static void setResourceLocatorToOut(int n, ResourceLocator resourceLocator) {
        outTempResourceLocator = (ResourceLocator[])AbstractScript.resizeArray(outTempResourceLocator, n);
        AbstractScript.outTempResourceLocator[n] = resourceLocator;
    }

    public static ResourceLocator getResourceLocatorToOut(int n) {
        if (n < 0 || n >= outTempResourceLocator.length) {
            return null;
        }
        return outTempResourceLocator[n];
    }

    static void setInsetsToOut(int n, Insets insets) {
        outTempInsets = (Insets[])AbstractScript.resizeArray(outTempInsets, n);
        AbstractScript.outTempInsets[n] = insets;
    }

    public static Insets getInsetsToOut(int n) {
        if (n < 0 || n >= outTempInsets.length) {
            return null;
        }
        return outTempInsets[n];
    }
}

