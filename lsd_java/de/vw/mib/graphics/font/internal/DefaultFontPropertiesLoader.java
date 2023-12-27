/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.font.internal;

import de.vw.mib.configuration.helper.FileHelper;
import de.vw.mib.graphics.font.internal.FontProperties;
import de.vw.mib.graphics.font.internal.FontPropertiesLoader;
import edu.emory.mathcs.backport.java.util.Arrays;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public final class DefaultFontPropertiesLoader
implements FontPropertiesLoader {
    private static final String FONT;
    private static final String ALTERNATIVE;
    private static final String COMPLEX_SCRIPT;
    private static final String NAME;
    private static final String LOCALE;
    private static final int RANGES_LIST_INITIAL_CAPACITY;
    private static final int FONT_LIST_INITIAL_CAPACITY;
    static /* synthetic */ Class array$$Ljava$lang$String;
    static /* synthetic */ Class array$$$C;
    static /* synthetic */ Class array$Ljava$lang$String;
    static /* synthetic */ Class array$$C;

    @Override
    public FontProperties openFontProperties(int n, File file, String[] stringArray) {
        File file2 = new File(file, "Font.properties");
        Properties properties = FileHelper.readPropertiesFromFile(file2.getAbsolutePath());
        try {
            String[] stringArray2 = DefaultFontPropertiesLoader.getMainFonts(properties, "Font.");
            String[] stringArray3 = new String[stringArray2.length];
            char[][][] cArrayArray = new char[stringArray2.length][][];
            String[][][] stringArray4 = new String[stringArray2.length][][];
            char[][][][] cArrayArray2 = new char[stringArray2.length][][][];
            for (int i2 = 0; i2 < stringArray2.length; ++i2) {
                ArrayList arrayList = new ArrayList(3);
                ArrayList arrayList2 = new ArrayList(10);
                DefaultFontPropertiesLoader.getLinkedFonts(properties, i2, "Font.", stringArray != null ? Arrays.asList(stringArray) : null, arrayList, arrayList2);
                stringArray3[i2] = DefaultFontPropertiesLoader.getComplexFont(properties, i2);
                cArrayArray[i2] = DefaultFontPropertiesLoader.getComplexScriptRanges(properties, i2);
                stringArray4[i2] = (String[][])Arrays.copyOf(arrayList.toArray(), arrayList.size(), array$$Ljava$lang$String == null ? DefaultFontPropertiesLoader.class$("[[Ljava.lang.String;") : array$$Ljava$lang$String);
                cArrayArray2[i2] = (char[][][])Arrays.copyOf(arrayList2.toArray(), arrayList2.size(), array$$$C == null ? DefaultFontPropertiesLoader.class$("[[[C") : array$$$C);
            }
            return new FontProperties(n, stringArray2, stringArray4, cArrayArray2, stringArray3, cArrayArray);
        }
        catch (Exception exception) {
            throw new IOException(new StringBuffer().append("Error reading the font linking properties file: ").append(exception.getMessage()).toString());
        }
    }

    private static String[] getMainFonts(Properties properties, String string) {
        ArrayList arrayList = new ArrayList(3);
        if (properties != null) {
            int n = 0;
            String string2 = properties.getProperty(new StringBuffer().append(string).append(n).append(".Name").toString());
            while (string2 != null) {
                arrayList.add(string2);
                string2 = properties.getProperty(new StringBuffer().append(string).append(++n).append(".Name").toString());
            }
        }
        return (String[])Arrays.copyOf(arrayList.toArray(), arrayList.size(), array$Ljava$lang$String == null ? (array$Ljava$lang$String = DefaultFontPropertiesLoader.class$("[Ljava.lang.String;")) : array$Ljava$lang$String);
    }

    private static String getComplexFont(Properties properties, int n) {
        if (properties != null) {
            String string = properties.getProperty(new StringBuffer().append("Font.").append(n).append(".ComplexScript").append(".Name").toString());
            return string;
        }
        return null;
    }

    private static char[][] getComplexScriptRanges(Properties properties, int n) {
        if (properties != null) {
            String string = properties.getProperty(new StringBuffer().append("Font.").append(n).append(".ComplexScript").append(".Ranges").toString());
            return string == null || string.length() == 0 ? (char[][])null : DefaultFontPropertiesLoader.convertRangesRaw(string);
        }
        return null;
    }

    private static void getLinkedFonts(Properties properties, int n, String string, List list, List list2, List list3) {
        list3.add(DefaultFontPropertiesLoader.getExclusionRanges(properties, n, -1, "Font."));
        int n2 = 0;
        String string2 = properties.getProperty(new StringBuffer().append(string).append(n).append(".Alternative.").append(n2).append(".Name").toString());
        String string3 = properties.getProperty(new StringBuffer().append(string).append(n).append(".Alternative.").append(n2).append(".Locale").toString(), "");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        while (string2 != null && string3 != null) {
            if (list == null || list.contains(string3)) {
                list2.add(new String[]{string2, string3});
                list3.add(DefaultFontPropertiesLoader.getExclusionRanges(properties, n, n2, string));
            } else {
                arrayList.add(new String[]{string2, string3});
                arrayList2.add(DefaultFontPropertiesLoader.getExclusionRanges(properties, n, n2, string));
            }
            string2 = properties.getProperty(new StringBuffer().append(string).append(n).append(".Alternative.").append(++n2).append(".Name").toString());
            string3 = properties.getProperty(new StringBuffer().append(string).append(n).append(".Alternative.").append(n2).append(".Locale").toString(), "");
        }
        list2.addAll(arrayList);
        list3.addAll(arrayList2);
    }

    private static char[][] getExclusionRanges(Properties properties, int n, int n2, String string) {
        String string2 = n2 == -1 ? properties.getProperty(new StringBuffer().append(string).append(n).append(".exclusionRanges").toString()) : properties.getProperty(new StringBuffer().append(string).append(n).append(".Alternative.").append(n2).append(".exclusionRanges").toString());
        if (string2 == null) {
            return null;
        }
        return DefaultFontPropertiesLoader.convertRangesRaw(string2);
    }

    private static char[][] convertRangesRaw(String string) {
        ArrayList arrayList = new ArrayList(10);
        int n = string.indexOf(44);
        while (n > 0) {
            String string2 = string.substring(0, n);
            arrayList.add(FontProperties.getRange(string2));
            string = string.substring(n + 1);
            n = string.indexOf(44);
        }
        if (string.length() > 0 && string.indexOf(45) > 0) {
            arrayList.add(FontProperties.getRange(string));
        }
        return (char[][])Arrays.copyOf(arrayList.toArray(), arrayList.size(), array$$C == null ? (array$$C = DefaultFontPropertiesLoader.class$("[[C")) : array$$C);
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

