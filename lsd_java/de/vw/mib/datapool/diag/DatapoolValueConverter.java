/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.datapool.diag;

import de.vw.mib.datapool.diag.DatapoolValueConversionException;
import de.vw.mib.graphics.Gradient;
import de.vw.mib.properties.values.LabeledIconValue;
import de.vw.mib.properties.values.SpellerData;
import edu.emory.mathcs.backport.java.util.Arrays;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.iconhandling.TextRenderingInfo;

public final class DatapoolValueConverter {
    public static final String PROPERTY_NULL;
    public static final String UNKNOWN_PROPERTY;
    private static final String ARRAY_COMPONENT_SEPARATORS;
    private static final String BOOLEAN_ARRAY_PREFIX;
    private static final String INTEGER_ARRAY_PREFIX;
    private static final String STRING_ARRAY_PREFIX;
    private static final String LABELED_ICON_VALUE_PREFIX;
    private static final String RESOURCE_LOCATOR_PREFIX;
    private static final String SPELLER_DATA_PREFIX;
    private static final String GRADIANT_DATA_PREFIX;
    private static final String GRADIANT_DATA_ARRAY_PREFIX;
    private static final String TEXT_RENDERING_INFO_PREFIX;
    private static final String NULL;
    static /* synthetic */ Class class$java$lang$String;
    static /* synthetic */ Class class$de$vw$mib$graphics$Gradient;

    public static boolean asBoolean(String string) {
        if (string == null) {
            throw new DatapoolValueConversionException("value string is null");
        }
        return Boolean.valueOf(string);
    }

    public static float asFloat(String string) {
        if (string == null) {
            throw new DatapoolValueConversionException("value string is null");
        }
        try {
            return Float.parseFloat(string);
        }
        catch (NumberFormatException numberFormatException) {
            throw new DatapoolValueConversionException("couldn't parse value string");
        }
    }

    public static int asInt(String string) {
        if (string == null) {
            throw new DatapoolValueConversionException("value string is null");
        }
        try {
            return Integer.parseInt(string);
        }
        catch (NumberFormatException numberFormatException) {
            throw new DatapoolValueConversionException("couldn't parse value string");
        }
    }

    public static long asLong(String string) {
        if (string == null) {
            throw new DatapoolValueConversionException("value string is null");
        }
        try {
            return Long.parseLong(string);
        }
        catch (NumberFormatException numberFormatException) {
            throw new DatapoolValueConversionException("couldn't parse value string");
        }
    }

    public static Object asObject(String string) {
        if ("\u0001null\u0001".equals(string)) {
            return null;
        }
        if (string.startsWith("boolean[") && string.endsWith("]")) {
            string = string.substring("boolean[".length(), string.length() - 1);
            StringTokenizer stringTokenizer = new StringTokenizer(string, ", ");
            int n = stringTokenizer.countTokens();
            boolean[] blArray = new boolean[n];
            for (int i2 = 0; i2 < n; ++i2) {
                blArray[i2] = Boolean.valueOf(stringTokenizer.nextToken());
            }
            return blArray;
        }
        if (string.startsWith("int[")) {
            string = string.substring("int[".length(), string.length() - 1);
            StringTokenizer stringTokenizer = new StringTokenizer(string, ", ");
            int n = stringTokenizer.countTokens();
            int[] nArray = new int[n];
            for (int i3 = 0; i3 < n; ++i3) {
                try {
                    nArray[i3] = Integer.parseInt(stringTokenizer.nextToken());
                    continue;
                }
                catch (NumberFormatException numberFormatException) {
                    throw new DatapoolValueConversionException("couldn't convert int array value string to int array");
                }
            }
            return nArray;
        }
        if (string.startsWith("String[")) {
            string = string.substring("String[".length(), string.length() - 1);
            return DatapoolValueConverter.parseStringArray(string);
        }
        if (string.startsWith("SpellerData(")) {
            return DatapoolValueConverter.parseSpellerData(string);
        }
        if (string.startsWith("Gradient(")) {
            return DatapoolValueConverter.parseGradiantData(string);
        }
        if (string.startsWith("Gradient[")) {
            string = string.substring("Gradient[".length(), string.length() - 1);
            ArrayList arrayList = DatapoolValueConverter.splitGradientVectorObjects(string);
            int n = arrayList.size();
            Gradient[] gradientArray = new Gradient[n];
            Iterator iterator = arrayList.iterator();
            for (int i4 = 0; i4 < n; ++i4) {
                try {
                    gradientArray[i4] = DatapoolValueConverter.parseGradiantData((String)iterator.next());
                    continue;
                }
                catch (NumberFormatException numberFormatException) {
                    throw new DatapoolValueConversionException("couldn't convert int array value string to int array");
                }
            }
            return gradientArray;
        }
        if (string.startsWith("ResourceLocator(")) {
            return DatapoolValueConverter.parseResourceLocator(string);
        }
        if (string.startsWith("LabeledIconValue(")) {
            return DatapoolValueConverter.parseLabeledIconValue(string);
        }
        throw new DatapoolValueConversionException("the value string doesn't match any supported dataype");
    }

    private static ArrayList splitGradientVectorObjects(String string) {
        ArrayList arrayList = new ArrayList();
        int n = -1;
        while ((n = string.indexOf("),")) > -1) {
            arrayList.add(string.substring(0, n + 1));
            string = string.substring(n + 2);
        }
        arrayList.add(string);
        return arrayList;
    }

    public static String asString(String string) {
        if ("\u0001null\u0001".equals(string)) {
            return null;
        }
        return string;
    }

    public static String asValueString(boolean bl) {
        return String.valueOf(bl);
    }

    public static String asValueString(boolean[] blArray) {
        if (blArray == null) {
            return "\u0001null\u0001";
        }
        return new StringBuffer().append("boolean").append(Arrays.toString(blArray)).toString();
    }

    public static String asValueString(float f2) {
        return String.valueOf(f2);
    }

    public static String asValueString(int n) {
        return String.valueOf(n);
    }

    public static String asValueString(int[] nArray) {
        if (nArray == null) {
            return "\u0001null\u0001";
        }
        return new StringBuffer().append("int").append(Arrays.toString(nArray)).toString();
    }

    public static String asValueString(String[] stringArray) {
        if (stringArray == null) {
            return "\u0001null\u0001";
        }
        StringBuffer stringBuffer = new StringBuffer(500);
        stringBuffer.append("String[");
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            if (i2 > 0) {
                stringBuffer.append(",");
            }
            stringBuffer.append(DatapoolValueConverter.stringToValueString(stringArray[i2]));
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public static String asValueString(long l) {
        return String.valueOf(l);
    }

    public static String asValueString(Object object) {
        if (object == null) {
            return "\u0001null\u0001";
        }
        if (object.getClass().isArray()) {
            if (object.getClass().getComponentType().equals(Boolean.TYPE)) {
                return DatapoolValueConverter.asValueString((boolean[])object);
            }
            if (object.getClass().getComponentType().equals(Integer.TYPE)) {
                return DatapoolValueConverter.asValueString((int[])object);
            }
            if (object.getClass().getComponentType().equals(class$java$lang$String == null ? (class$java$lang$String = DatapoolValueConverter.class$("java.lang.String")) : class$java$lang$String)) {
                return DatapoolValueConverter.asValueString((String[])object);
            }
            if (object.getClass().getComponentType().equals(class$de$vw$mib$graphics$Gradient == null ? (class$de$vw$mib$graphics$Gradient = DatapoolValueConverter.class$("de.vw.mib.graphics.Gradient")) : class$de$vw$mib$graphics$Gradient)) {
                return DatapoolValueConverter.gradiantArrayAsValueString((Gradient[])object);
            }
        } else if (object.getClass().equals(class$de$vw$mib$graphics$Gradient == null ? (class$de$vw$mib$graphics$Gradient = DatapoolValueConverter.class$("de.vw.mib.graphics.Gradient")) : class$de$vw$mib$graphics$Gradient)) {
            return DatapoolValueConverter.gradiantAsValueString((Gradient)object);
        }
        return object.toString();
    }

    private static String gradiantArrayAsValueString(Gradient[] gradientArray) {
        if (gradientArray == null) {
            return "null";
        }
        StringBuffer stringBuffer = new StringBuffer(256);
        stringBuffer.append("Gradient[");
        if (gradientArray.length == 0) {
            stringBuffer.append(0);
            stringBuffer.append("]");
            return stringBuffer.toString();
        }
        DatapoolValueConverter.gradiantAsValueString(gradientArray[0], stringBuffer);
        for (int i2 = 1; i2 < gradientArray.length; ++i2) {
            stringBuffer.append(",");
            DatapoolValueConverter.gradiantAsValueString(gradientArray[i2], stringBuffer);
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    private static String gradiantAsValueString(Gradient gradient) {
        StringBuffer stringBuffer = new StringBuffer(256);
        DatapoolValueConverter.gradiantAsValueString(gradient, stringBuffer);
        return stringBuffer.toString();
    }

    private static void gradiantAsValueString(Gradient gradient, StringBuffer stringBuffer) {
        stringBuffer.append("Gradient(");
        stringBuffer.append("Scale=").append(gradient.isScale()).append(",");
        stringBuffer.append("GradientType=").append(gradient.getGradientType()).append(",");
        stringBuffer.append("CenterPositionType=").append(gradient.getCenterPositionType()).append(",");
        stringBuffer.append("BlendMode=").append(gradient.getBlendMode()).append(",");
        stringBuffer.append("CenterX=").append(gradient.getCenterX()).append(",");
        stringBuffer.append("CenterY=").append(gradient.getCenterY()).append(",");
        stringBuffer.append("Rotation=").append(gradient.getRotation()).append(",");
        stringBuffer.append("ColorPositions=[");
        float[] fArray = gradient.getColorPositions();
        DatapoolValueConverter.writeFloatArray(stringBuffer, fArray);
        stringBuffer.append("],");
        stringBuffer.append("ColorTransitions=[");
        fArray = gradient.getColorTransitions();
        DatapoolValueConverter.writeFloatArray(stringBuffer, fArray);
        stringBuffer.append("]").append(")");
    }

    private static void writeFloatArray(StringBuffer stringBuffer, float[] fArray) {
        if (fArray != null && fArray.length > 0) {
            stringBuffer.append(fArray[0]);
            for (int i2 = 1; i2 < fArray.length; ++i2) {
                stringBuffer.append(",").append(fArray[i2]);
            }
        }
    }

    private static String getParameterFromValueString(StringBuffer stringBuffer, String string, String string2) {
        int n = stringBuffer.lastIndexOf(string);
        int n2 = stringBuffer.lastIndexOf(string2);
        String string3 = stringBuffer.substring(n + string.length(), n2);
        stringBuffer.delete(n, n2 + string2.length());
        return string3;
    }

    private static LabeledIconValue parseLabeledIconValue(String string) {
        StringBuffer stringBuffer = new StringBuffer(string);
        stringBuffer.delete(0, "LabeledIconValue(".length());
        String string2 = DatapoolValueConverter.getParameterFromValueString(stringBuffer, "textRenderingInfo=", ")");
        TextRenderingInfo textRenderingInfo = DatapoolValueConverter.parseTextRenderingInfo(string2);
        string2 = DatapoolValueConverter.getParameterFromValueString(stringBuffer, "resouceLocator=", ",");
        ResourceLocator resourceLocator = DatapoolValueConverter.parseResourceLocator(string2);
        String string3 = string2 = DatapoolValueConverter.getParameterFromValueString(stringBuffer, "text='", "',");
        return new LabeledIconValue(string3, resourceLocator, textRenderingInfo);
    }

    private static ResourceLocator parseResourceLocator(String string) {
        StringBuffer stringBuffer = new StringBuffer(string);
        stringBuffer.delete(0, "ResourceLocator(".length());
        if (stringBuffer.indexOf("Integer") > 0) {
            String string2 = DatapoolValueConverter.getParameterFromValueString(stringBuffer, "Type isInteger; Value=", ")");
            int n = Integer.parseInt(string2);
            return new ResourceLocator(n);
        }
        if (stringBuffer.indexOf("URL") > 0) {
            String string3 = DatapoolValueConverter.getParameterFromValueString(stringBuffer, "Type isURL; Value=", ")");
            return new ResourceLocator(string3);
        }
        return null;
    }

    private static SpellerData parseSpellerData(String string) {
        StringBuffer stringBuffer = new StringBuffer(string);
        stringBuffer.delete(0, "SpellerData(".length());
        String string2 = DatapoolValueConverter.getParameterFromValueString(stringBuffer, "wordDatabaseNames=[", "])");
        String[] stringArray = DatapoolValueConverter.parseStringArray(string2);
        string2 = DatapoolValueConverter.getParameterFromValueString(stringBuffer, "selectionEnd=", ",");
        int n = Integer.parseInt(string2);
        string2 = DatapoolValueConverter.getParameterFromValueString(stringBuffer, "selectionStart=", ",");
        int n2 = Integer.parseInt(string2);
        string2 = DatapoolValueConverter.getParameterFromValueString(stringBuffer, "cursorPosition=", ",");
        int n3 = Integer.parseInt(string2);
        string2 = DatapoolValueConverter.getParameterFromValueString(stringBuffer, "matchCount=", ",");
        int n4 = Integer.parseInt(string2);
        String string3 = string2 = DatapoolValueConverter.getParameterFromValueString(stringBuffer, "matchCompletion='", "',");
        String string4 = string2 = DatapoolValueConverter.getParameterFromValueString(stringBuffer, "matchText='", "',");
        String string5 = string2 = DatapoolValueConverter.getParameterFromValueString(stringBuffer, "enteredText='", "',");
        String string6 = string2 = DatapoolValueConverter.getParameterFromValueString(stringBuffer, "unavailableCharacters='", "',");
        String string7 = string2 = DatapoolValueConverter.getParameterFromValueString(stringBuffer, "availableCharacters='", "',");
        SpellerData spellerData = new SpellerData();
        spellerData.setAvailableCharacters(string7);
        spellerData.setCursorPosition(n3);
        spellerData.setEnteredText(string5);
        spellerData.setMatchCompletion(string3);
        spellerData.setMatchCount(n4);
        spellerData.setMatchText(string4);
        spellerData.setSelectionEnd(n);
        spellerData.setSelectionStart(n2);
        spellerData.setUnavailableCharacters(string6);
        spellerData.setWordDatabaseNames(stringArray);
        return spellerData;
    }

    private static Gradient parseGradiantData(String string) {
        StringBuffer stringBuffer = new StringBuffer(string);
        stringBuffer.delete(0, "Gradient(".length());
        String string2 = DatapoolValueConverter.getParameterFromValueString(stringBuffer, "ColorTransitions=[", "])");
        float[] fArray = DatapoolValueConverter.parseFloatArray(string2);
        string2 = DatapoolValueConverter.getParameterFromValueString(stringBuffer, "ColorPositions=[", "],");
        float[] fArray2 = DatapoolValueConverter.parseFloatArray(string2);
        string2 = DatapoolValueConverter.getParameterFromValueString(stringBuffer, "Rotation=", ",");
        float f2 = Float.parseFloat(string2);
        string2 = DatapoolValueConverter.getParameterFromValueString(stringBuffer, "CenterY=", ",");
        int n = Integer.parseInt(string2);
        string2 = DatapoolValueConverter.getParameterFromValueString(stringBuffer, "CenterX=", ",");
        int n2 = Integer.parseInt(string2);
        string2 = DatapoolValueConverter.getParameterFromValueString(stringBuffer, "BlendMode=", ",");
        int n3 = Integer.parseInt(string2);
        string2 = DatapoolValueConverter.getParameterFromValueString(stringBuffer, "CenterPositionType=", ",");
        int n4 = Integer.parseInt(string2);
        string2 = DatapoolValueConverter.getParameterFromValueString(stringBuffer, "GradientType=", ",");
        int n5 = Integer.parseInt(string2);
        string2 = DatapoolValueConverter.getParameterFromValueString(stringBuffer, "Scale=", ",");
        boolean bl = string2.equals("true");
        return new Gradient(n5, n4, n3, bl, n2, n, f2, fArray2, fArray);
    }

    private static float[] parseFloatArray(String string) {
        StringTokenizer stringTokenizer = new StringTokenizer(string, ", ");
        int n = stringTokenizer.countTokens();
        float[] fArray = new float[n];
        for (int i2 = 0; i2 < n; ++i2) {
            try {
                fArray[i2] = Float.parseFloat(stringTokenizer.nextToken());
                continue;
            }
            catch (IllegalArgumentException illegalArgumentException) {
                throw new DatapoolValueConversionException("couldn't convert String array value string to String array");
            }
        }
        return fArray;
    }

    private static String[] parseStringArray(String string) {
        StringTokenizer stringTokenizer = new StringTokenizer(string, ", ");
        int n = stringTokenizer.countTokens();
        String[] stringArray = new String[n];
        for (int i2 = 0; i2 < n; ++i2) {
            try {
                stringArray[i2] = DatapoolValueConverter.valueStringToString(stringTokenizer.nextToken());
                continue;
            }
            catch (IllegalArgumentException illegalArgumentException) {
                throw new DatapoolValueConversionException("couldn't convert String array value string to String array");
            }
        }
        return stringArray;
    }

    private static TextRenderingInfo parseTextRenderingInfo(String string) {
        StringBuffer stringBuffer = new StringBuffer(string);
        stringBuffer.delete(0, "TextRenderingInfo(".length());
        String string2 = DatapoolValueConverter.getParameterFromValueString(stringBuffer, "deltaY=", ")");
        int n = Integer.parseInt(string2);
        string2 = DatapoolValueConverter.getParameterFromValueString(stringBuffer, "deltaX=", ",");
        int n2 = Integer.parseInt(string2);
        string2 = DatapoolValueConverter.getParameterFromValueString(stringBuffer, "fontColor=", ",");
        int n3 = Integer.parseInt(string2);
        string2 = DatapoolValueConverter.getParameterFromValueString(stringBuffer, "fontSize=", ",");
        int n4 = Integer.parseInt(string2);
        string2 = DatapoolValueConverter.getParameterFromValueString(stringBuffer, "fontReference=", ",");
        int n5 = Integer.parseInt(string2);
        return new TextRenderingInfo(n5, n4, n3, n2, n);
    }

    private static String stringToValueString(String string) {
        if (string == null) {
            return "null";
        }
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append('\'');
        block5: for (int i2 = 0; i2 < string.length(); ++i2) {
            char c2 = string.charAt(i2);
            switch (c2) {
                case ',': {
                    stringBuffer.append("\\.");
                    continue block5;
                }
                case '\'': {
                    stringBuffer.append("\\\"");
                    continue block5;
                }
                case '\\': {
                    stringBuffer.append("\\\\");
                    continue block5;
                }
                default: {
                    stringBuffer.append(c2);
                }
            }
        }
        stringBuffer.append('\'');
        return stringBuffer.toString();
    }

    private static String valueStringToString(String string) {
        if ("null".equals(string)) {
            return null;
        }
        if (!string.startsWith("'") || !string.endsWith("'")) {
            throw new IllegalArgumentException("Strings must start and end with a single quote character");
        }
        StringBuffer stringBuffer = new StringBuffer(100);
        boolean bl = false;
        for (int i2 = 1; i2 < string.length() - 1; ++i2) {
            char c2 = string.charAt(i2);
            if (bl) {
                switch (c2) {
                    case '.': {
                        stringBuffer.append(',');
                        break;
                    }
                    case '\"': {
                        stringBuffer.append('\'');
                        break;
                    }
                    case '\\': {
                        stringBuffer.append('\\');
                        break;
                    }
                    default: {
                        throw new IllegalArgumentException(new StringBuffer().append("Invalid character (").append(c2).append(") after escape character").toString());
                    }
                }
                bl = false;
                continue;
            }
            if (c2 == '\\') {
                bl = true;
                continue;
            }
            stringBuffer.append(c2);
        }
        if (bl) {
            throw new IllegalArgumentException("String ends before escape sequence has been completed");
        }
        return stringBuffer.toString();
    }

    private DatapoolValueConverter() {
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

