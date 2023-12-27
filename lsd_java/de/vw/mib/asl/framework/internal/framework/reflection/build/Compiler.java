/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.vw.mib.asl.framework.internal.framework.build.LightReflectionUtil
 *  org.apache.bcel.classfile.JavaClass
 *  org.apache.bcel.util.SyntheticRepository
 *  org.apache.commons.io.FileUtils
 *  org.objectweb.asm.Type
 *  org.objectweb.asm.commons.GeneratorAdapter
 */
package de.vw.mib.asl.framework.internal.framework.reflection.build;

import de.vw.mib.asl.framework.internal.framework.build.LightReflectionUtil;
import de.vw.mib.reflection.LightReflection;
import de.vw.mib.reflection.LightReflectionClassData;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.util.SyntheticRepository;
import org.apache.commons.io.FileUtils;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.GeneratorAdapter;

public class Compiler {
    public static final String CLASS_EXTENSION;
    private static final int CLASS_EXTENSION_LEN;
    public static final String CLASS_SUFFIX;
    public static final int CONST_ACCESS_FLAG;
    public static final Type STRING_TYPE;
    public static final String STRING_TYPE_DESCRIPTOR;
    public static final Type STRING_A_TYPE;
    public static final String STRING_A_TYPE_DESCRIPTOR;
    public static final String ZERO_STRING_A;
    public static final Type STRING_2A_TYPE;
    public static final String STRING_2A_TYPE_DESCRIPTOR;
    public static final String ZERO_STRING_2A;
    public static final Type STRING_3A_TYPE;
    public static final String STRING_3A_TYPE_DESCRIPTOR;
    public static final String ZERO_STRING_3A;
    public static final Type BYTE_TYPE;
    public static final String BYTE_TYPE_DESCRIPTOR;
    public static final Type BYTE_A_TYPE;
    public static final String BYTE_A_TYPE_DESCRIPTOR;
    public static final String ZERO_BYTE_A;
    public static final Type BYTE_2A_TYPE;
    public static final String BYTE_2A_TYPE_DESCRIPTOR;
    public static final Type SHORT_TYPE;
    public static final String SHORT_TYPE_DESCRIPTOR;
    public static final Type SHORT_A_TYPE;
    public static final String SHORT_A_TYPE_DESCRIPTOR;
    public static final String ZERO_SHORT_A;
    public static final Type INT_TYPE;
    public static final String INT_TYPE_DESCRIPTOR;
    public static final Type INT_A_TYPE;
    public static final String INT_A_TYPE_DESCRIPTOR;
    public static final String ZERO_INT_A;
    public static final Type INT_2A_TYPE;
    public static final String INT_2A_TYPE_DESCRIPTOR;
    public static final String ZERO_INT_2A;
    public static final Type INT_3A_TYPE;
    public static final String INT_3A_TYPE_DESCRIPTOR;
    public static final String ZERO_INT_3A;
    public static final Type OBJ_TYPE;
    public static final Type OBJ_A_TYPE;
    public static final String OBJ_A_TYPE_DESCRIPTOR;
    static /* synthetic */ Class class$java$lang$String;
    static /* synthetic */ Class array$Ljava$lang$String;
    static /* synthetic */ Class array$$Ljava$lang$String;
    static /* synthetic */ Class array$$$Ljava$lang$String;
    static /* synthetic */ Class array$B;
    static /* synthetic */ Class array$$B;
    static /* synthetic */ Class array$S;
    static /* synthetic */ Class array$I;
    static /* synthetic */ Class array$$I;
    static /* synthetic */ Class array$$$I;
    static /* synthetic */ Class class$java$lang$Object;
    static /* synthetic */ Class array$Ljava$lang$Object;
    static /* synthetic */ Class class$de$vw$mib$asl$framework$internal$framework$reflection$build$Compiler;

    protected static String readArg(String[] stringArray, int n) {
        return null != stringArray && n < stringArray.length ? stringArray[n] : null;
    }

    public static JavaClass[] retrieveDerivedClasses(File file, String string) {
        return Compiler.retrieveDerivedClasses(file, string, SyntheticRepository.getInstance());
    }

    public static JavaClass[] retrieveDerivedClasses(File file, String string, SyntheticRepository syntheticRepository) {
        JavaClass javaClass = syntheticRepository.loadClass(string);
        Collection collection = FileUtils.listFiles((File)file, (String[])new String[]{"class"}, (boolean)true);
        return Compiler.retrieveDerivedClasses(file, collection, javaClass, syntheticRepository);
    }

    private static JavaClass[] retrieveDerivedClasses(File file, Collection collection, JavaClass javaClass, SyntheticRepository syntheticRepository) {
        int n = file.getAbsolutePath().length();
        ArrayList arrayList = new ArrayList();
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            String string = Compiler.extractClassName((File)iterator.next(), n);
            try {
                JavaClass javaClass2 = syntheticRepository.loadClass(string);
                if (javaClass2.isAbstract() || !javaClass2.isPublic() && !javaClass2.isProtected() || !javaClass2.instanceOf(javaClass)) continue;
                arrayList.add(javaClass2);
            }
            catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
        return (JavaClass[])arrayList.toArray(new JavaClass[arrayList.size()]);
    }

    private static String extractClassName(File file, int n) {
        int n2;
        String string = file.getAbsolutePath();
        int n3 = string.length();
        for (n2 = n; n2 < n3 && string.charAt(n2) == File.separatorChar; ++n2) {
        }
        return string.substring(n2, n3 - CLASS_EXTENSION_LEN - 1).replace(File.separatorChar, '.');
    }

    public static Map retrieveDerivedClasses(File file, List list) {
        return Compiler.retrieveDerivedClasses(file, list, SyntheticRepository.getInstance());
    }

    private static Map retrieveDerivedClasses(File file, List list, SyntheticRepository syntheticRepository) {
        Collection collection = FileUtils.listFiles((File)file, (String[])new String[]{"class"}, (boolean)true);
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < list.size(); ++i2) {
            String string = (String)list.get(i2);
            JavaClass javaClass = syntheticRepository.loadClass(string);
            hashMap.put(string, Compiler.retrieveDerivedClasses(file, collection, javaClass, syntheticRepository));
        }
        return hashMap;
    }

    protected static String createConstructorAccessibleClass(String string, String string2, File file) {
        LightReflectionClassData lightReflectionClassData = LightReflection.createConstructorAccessibleClass(string, string2);
        LightReflectionUtil.save((LightReflectionClassData)lightReflectionClassData, (File)file);
        return lightReflectionClassData.getFullClassName();
    }

    protected static String createMethodAccessibleClass(String string, String string2, Method[] methodArray, File file) {
        LightReflectionClassData lightReflectionClassData = LightReflection.createMethodAccessibleClass(string, string2, methodArray);
        LightReflectionUtil.save((LightReflectionClassData)lightReflectionClassData, (File)file);
        return lightReflectionClassData.getFullClassName();
    }

    protected static String createMultipleConstructorAccessibleClass(String string, String[] stringArray, File file) {
        LightReflectionClassData lightReflectionClassData = LightReflection.createMultipleConstructorAccessibleClass(string, stringArray);
        LightReflectionUtil.save((LightReflectionClassData)lightReflectionClassData, (File)file);
        return lightReflectionClassData.getFullClassName();
    }

    protected static String createMultipleMethodAccessibleClass(String string, String[] stringArray, Method[] methodArray, File file) {
        LightReflectionClassData lightReflectionClassData = LightReflection.createMultipleMethodAccessibleClass(string, stringArray, methodArray);
        LightReflectionUtil.save((LightReflectionClassData)lightReflectionClassData, (File)file);
        return lightReflectionClassData.getFullClassName();
    }

    protected static String createProxyClass(String string, String[] stringArray, File file) {
        LightReflectionClassData lightReflectionClassData = LightReflection.createProxyClass(string, stringArray);
        LightReflectionUtil.save((LightReflectionClassData)lightReflectionClassData, (File)file);
        return lightReflectionClassData.getFullClassName();
    }

    protected static void push(GeneratorAdapter generatorAdapter, Type type, byte[] byArray) {
        if (null == byArray || 0 == byArray.length) {
            generatorAdapter.getStatic(type, "_ZBA", BYTE_A_TYPE);
        } else {
            generatorAdapter.push(byArray.length);
            generatorAdapter.newArray(BYTE_TYPE);
            for (int i2 = 0; i2 < byArray.length; ++i2) {
                generatorAdapter.dup();
                generatorAdapter.push(i2);
                generatorAdapter.push((int)byArray[i2]);
                generatorAdapter.arrayStore(BYTE_TYPE);
            }
        }
    }

    protected static void push(GeneratorAdapter generatorAdapter, Type type, byte[][] byArray) {
        generatorAdapter.push(byArray.length);
        generatorAdapter.newArray(BYTE_A_TYPE);
        for (int i2 = 0; i2 < byArray.length; ++i2) {
            generatorAdapter.dup();
            generatorAdapter.push(i2);
            Compiler.push(generatorAdapter, type, byArray[i2]);
            generatorAdapter.arrayStore(BYTE_A_TYPE);
        }
    }

    protected static void push(GeneratorAdapter generatorAdapter, Type type, short[] sArray) {
        if (null == sArray || 0 == sArray.length) {
            generatorAdapter.getStatic(type, "_ZSHA", SHORT_A_TYPE);
        } else {
            generatorAdapter.push(sArray.length);
            generatorAdapter.newArray(SHORT_TYPE);
            for (int i2 = 0; i2 < sArray.length; ++i2) {
                generatorAdapter.dup();
                generatorAdapter.push(i2);
                generatorAdapter.push((int)sArray[i2]);
                generatorAdapter.arrayStore(SHORT_TYPE);
            }
        }
    }

    protected static void push(GeneratorAdapter generatorAdapter, Type type, int[] nArray) {
        if (nArray == null || nArray.length == 0) {
            generatorAdapter.getStatic(type, "_ZIA", INT_A_TYPE);
        } else {
            generatorAdapter.push(nArray.length);
            generatorAdapter.newArray(INT_TYPE);
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                generatorAdapter.dup();
                generatorAdapter.push(i2);
                generatorAdapter.push(nArray[i2]);
                generatorAdapter.arrayStore(INT_TYPE);
            }
        }
    }

    protected static void push(GeneratorAdapter generatorAdapter, Type type, int[][] nArray) {
        if (nArray == null || nArray.length == 0 || Compiler.isEmpty(nArray)) {
            generatorAdapter.getStatic(type, "_ZI2A", INT_2A_TYPE);
        } else {
            generatorAdapter.push(nArray.length);
            generatorAdapter.newArray(INT_A_TYPE);
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                generatorAdapter.dup();
                generatorAdapter.push(i2);
                if (nArray[i2] == null || nArray[i2].length == 0) {
                    generatorAdapter.getStatic(type, "_ZIA", INT_A_TYPE);
                } else {
                    generatorAdapter.push(nArray[i2].length);
                    generatorAdapter.newArray(INT_TYPE);
                    for (int i3 = 0; i3 < nArray[i2].length; ++i3) {
                        generatorAdapter.dup();
                        generatorAdapter.push(i3);
                        generatorAdapter.push(nArray[i2][i3]);
                        generatorAdapter.arrayStore(INT_TYPE);
                    }
                }
                generatorAdapter.arrayStore(INT_A_TYPE);
            }
        }
    }

    protected static void push(GeneratorAdapter generatorAdapter, Type type, int[][][] nArray) {
        if (nArray == null || nArray.length == 0 || Compiler.isEmpty(nArray)) {
            generatorAdapter.getStatic(type, "_ZI3A", INT_3A_TYPE);
        } else {
            generatorAdapter.push(nArray.length);
            generatorAdapter.newArray(INT_2A_TYPE);
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                generatorAdapter.dup();
                generatorAdapter.push(i2);
                if (nArray[i2] == null || nArray[i2].length == 0 || Compiler.isEmpty(nArray[i2])) {
                    generatorAdapter.getStatic(type, "_ZI2A", INT_2A_TYPE);
                } else {
                    generatorAdapter.push(nArray[i2].length);
                    generatorAdapter.newArray(INT_A_TYPE);
                    for (int i3 = 0; i3 < nArray[i2].length; ++i3) {
                        generatorAdapter.dup();
                        generatorAdapter.push(i3);
                        if (nArray[i2][i3] == null || nArray[i2][i3].length == 0) {
                            generatorAdapter.getStatic(type, "_ZIA", INT_A_TYPE);
                        } else {
                            generatorAdapter.push(nArray[i2][i3].length);
                            generatorAdapter.newArray(INT_TYPE);
                            for (int i4 = 0; i4 < nArray[i2][i3].length; ++i4) {
                                generatorAdapter.dup();
                                generatorAdapter.push(i4);
                                generatorAdapter.push(nArray[i2][i3][i4]);
                                generatorAdapter.arrayStore(INT_TYPE);
                            }
                        }
                        generatorAdapter.arrayStore(INT_A_TYPE);
                    }
                }
                generatorAdapter.arrayStore(INT_2A_TYPE);
            }
        }
    }

    protected static void push(GeneratorAdapter generatorAdapter, Type type, String[] stringArray) {
        if (stringArray == null || stringArray.length == 0) {
            generatorAdapter.getStatic(type, "_ZSA", STRING_A_TYPE);
        } else {
            generatorAdapter.push(stringArray.length);
            generatorAdapter.newArray(STRING_TYPE);
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                generatorAdapter.dup();
                generatorAdapter.push(i2);
                generatorAdapter.push(stringArray[i2]);
                generatorAdapter.arrayStore(STRING_TYPE);
            }
        }
    }

    protected static void push(GeneratorAdapter generatorAdapter, Type type, String[][] stringArray) {
        if (stringArray == null || stringArray.length == 0 || Compiler.isEmpty(stringArray)) {
            generatorAdapter.getStatic(type, "_ZS2A", STRING_2A_TYPE);
        } else {
            generatorAdapter.push(stringArray.length);
            generatorAdapter.newArray(STRING_A_TYPE);
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                generatorAdapter.dup();
                generatorAdapter.push(i2);
                if (stringArray[i2] == null || stringArray[i2].length == 0) {
                    generatorAdapter.getStatic(type, "_ZSA", STRING_A_TYPE);
                } else {
                    generatorAdapter.push(stringArray[i2].length);
                    generatorAdapter.newArray(STRING_TYPE);
                    for (int i3 = 0; i3 < stringArray[i2].length; ++i3) {
                        generatorAdapter.dup();
                        generatorAdapter.push(i3);
                        generatorAdapter.push(stringArray[i2][i3]);
                        generatorAdapter.arrayStore(STRING_TYPE);
                    }
                }
                generatorAdapter.arrayStore(STRING_A_TYPE);
            }
        }
    }

    protected static void push(GeneratorAdapter generatorAdapter, Type type, String[][][] stringArray) {
        if (stringArray == null || stringArray.length == 0 || Compiler.isEmpty(stringArray)) {
            generatorAdapter.getStatic(type, "_ZS3A", STRING_3A_TYPE);
        } else {
            generatorAdapter.push(stringArray.length);
            generatorAdapter.newArray(STRING_2A_TYPE);
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                generatorAdapter.dup();
                generatorAdapter.push(i2);
                if (stringArray[i2] == null || stringArray[i2].length == 0 || Compiler.isEmpty(stringArray[i2])) {
                    generatorAdapter.getStatic(type, "_ZS2A", STRING_2A_TYPE);
                } else {
                    generatorAdapter.push(stringArray[i2].length);
                    generatorAdapter.newArray(STRING_A_TYPE);
                    for (int i3 = 0; i3 < stringArray[i2].length; ++i3) {
                        generatorAdapter.dup();
                        generatorAdapter.push(i3);
                        if (stringArray[i2][i3] == null || stringArray[i2][i3].length == 0) {
                            generatorAdapter.getStatic(type, "_ZSA", STRING_A_TYPE);
                        } else {
                            generatorAdapter.push(stringArray[i2][i3].length);
                            generatorAdapter.newArray(STRING_TYPE);
                            for (int i4 = 0; i4 < stringArray[i2][i3].length; ++i4) {
                                generatorAdapter.dup();
                                generatorAdapter.push(i4);
                                generatorAdapter.push(stringArray[i2][i3][i4]);
                                generatorAdapter.arrayStore(STRING_TYPE);
                            }
                        }
                        generatorAdapter.arrayStore(STRING_A_TYPE);
                    }
                }
                generatorAdapter.arrayStore(STRING_2A_TYPE);
            }
        }
    }

    protected static boolean isEmpty(int[][] nArray) {
        boolean bl = true;
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            if (nArray[i2] == null || nArray[i2].length <= 0) continue;
            bl = false;
            break;
        }
        return bl;
    }

    protected static boolean isEmpty(int[][][] nArray) {
        boolean bl = true;
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            if (Compiler.isEmpty(nArray[i2])) continue;
            bl = false;
            break;
        }
        return bl;
    }

    protected static boolean isEmpty(String[][] stringArray) {
        boolean bl = true;
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            if (stringArray[i2] == null || stringArray[i2].length <= 0) continue;
            bl = false;
            break;
        }
        return bl;
    }

    protected static boolean isEmpty(String[][][] stringArray) {
        boolean bl = true;
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            if (Compiler.isEmpty(stringArray[i2])) continue;
            bl = false;
            break;
        }
        return bl;
    }

    static ClassLoader getClassLoader() {
        ClassLoader classLoader = (class$de$vw$mib$asl$framework$internal$framework$reflection$build$Compiler == null ? (class$de$vw$mib$asl$framework$internal$framework$reflection$build$Compiler = Compiler.class$("de.vw.mib.asl.framework.internal.framework.reflection.build.Compiler")) : class$de$vw$mib$asl$framework$internal$framework$reflection$build$Compiler).getClassLoader();
        if (classLoader != null) {
            return classLoader;
        }
        classLoader = Thread.currentThread().getContextClassLoader();
        if (classLoader != null) {
            return classLoader;
        }
        throw new RuntimeException("Cannot determine classloader.");
    }

    static String addParameterClassName(String string, Class clazz, int n, int n2) {
        String string2 = clazz.isArray() ? new StringBuffer().append(string).append(clazz.getComponentType().getName()).append("[]").toString() : new StringBuffer().append(string).append(clazz.getName()).toString();
        if (n < n2 - 1) {
            string2 = new StringBuffer().append(string2).append(",").toString();
        }
        return string2;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        CLASS_EXTENSION_LEN = "class".length();
        STRING_TYPE = Type.getType((Class)(class$java$lang$String == null ? (class$java$lang$String = Compiler.class$("java.lang.String")) : class$java$lang$String));
        STRING_TYPE_DESCRIPTOR = STRING_TYPE.getDescriptor();
        STRING_A_TYPE = Type.getType((Class)(array$Ljava$lang$String == null ? (array$Ljava$lang$String = Compiler.class$("[Ljava.lang.String;")) : array$Ljava$lang$String));
        STRING_A_TYPE_DESCRIPTOR = STRING_A_TYPE.getDescriptor();
        STRING_2A_TYPE = Type.getType((Class)(array$$Ljava$lang$String == null ? (array$$Ljava$lang$String = Compiler.class$("[[Ljava.lang.String;")) : array$$Ljava$lang$String));
        STRING_2A_TYPE_DESCRIPTOR = STRING_2A_TYPE.getDescriptor();
        STRING_3A_TYPE = Type.getType((Class)(array$$$Ljava$lang$String == null ? (array$$$Ljava$lang$String = Compiler.class$("[[[Ljava.lang.String;")) : array$$$Ljava$lang$String));
        STRING_3A_TYPE_DESCRIPTOR = STRING_3A_TYPE.getDescriptor();
        BYTE_TYPE = Type.getType((Class)Byte.TYPE);
        BYTE_TYPE_DESCRIPTOR = BYTE_TYPE.getDescriptor();
        BYTE_A_TYPE = Type.getType((Class)(array$B == null ? (array$B = Compiler.class$("[B")) : array$B));
        BYTE_A_TYPE_DESCRIPTOR = BYTE_A_TYPE.getDescriptor();
        BYTE_2A_TYPE = Type.getType((Class)(array$$B == null ? (array$$B = Compiler.class$("[[B")) : array$$B));
        BYTE_2A_TYPE_DESCRIPTOR = BYTE_2A_TYPE.getDescriptor();
        SHORT_TYPE = Type.getType((Class)Short.TYPE);
        SHORT_TYPE_DESCRIPTOR = SHORT_TYPE.getDescriptor();
        SHORT_A_TYPE = Type.getType((Class)(array$S == null ? (array$S = Compiler.class$("[S")) : array$S));
        SHORT_A_TYPE_DESCRIPTOR = SHORT_A_TYPE.getDescriptor();
        INT_TYPE = Type.INT_TYPE;
        INT_TYPE_DESCRIPTOR = INT_TYPE.getDescriptor();
        INT_A_TYPE = Type.getType((Class)(array$I == null ? (array$I = Compiler.class$("[I")) : array$I));
        INT_A_TYPE_DESCRIPTOR = INT_A_TYPE.getDescriptor();
        INT_2A_TYPE = Type.getType((Class)(array$$I == null ? (array$$I = Compiler.class$("[[I")) : array$$I));
        INT_2A_TYPE_DESCRIPTOR = INT_2A_TYPE.getDescriptor();
        INT_3A_TYPE = Type.getType((Class)(array$$$I == null ? (array$$$I = Compiler.class$("[[[I")) : array$$$I));
        INT_3A_TYPE_DESCRIPTOR = INT_3A_TYPE.getDescriptor();
        OBJ_TYPE = Type.getType((Class)(class$java$lang$Object == null ? (class$java$lang$Object = Compiler.class$("java.lang.Object")) : class$java$lang$Object));
        OBJ_A_TYPE = Type.getType((Class)(array$Ljava$lang$Object == null ? (array$Ljava$lang$Object = Compiler.class$("[Ljava.lang.Object;")) : array$Ljava$lang$Object));
        OBJ_A_TYPE_DESCRIPTOR = OBJ_A_TYPE.getDescriptor();
    }
}

