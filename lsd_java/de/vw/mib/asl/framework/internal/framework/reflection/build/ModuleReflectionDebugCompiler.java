/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.vw.mib.asl.framework.internal.framework.build.AsmUtil
 *  de.vw.mib.asl.framework.internal.framework.build.CommonUtil
 *  org.apache.bcel.classfile.JavaClass
 */
package de.vw.mib.asl.framework.internal.framework.reflection.build;

import de.vw.mib.asl.framework.internal.framework.build.AsmUtil;
import de.vw.mib.asl.framework.internal.framework.build.CommonUtil;
import de.vw.mib.asl.framework.internal.framework.reflection.build.Compiler;
import de.vw.mib.asl.framework.internal.framework.reflection.build.LogUtils;
import de.vw.mib.asl.framework.internal.framework.reflection.module.ModuleReflectionConfiguration;
import de.vw.mib.asl.framework.internal.framework.reflection.module.ModuleReflectionFactory;
import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import java.io.File;
import java.lang.reflect.Method;
import java.util.Properties;
import org.apache.bcel.classfile.JavaClass;

public final class ModuleReflectionDebugCompiler
extends Compiler {
    private static final int ARGIDX_OUTPUT_DIR;
    private static final int ARGIDX_DEST_DIR;
    private static final int ARGIDX_TARGET_PACKAGE;
    static /* synthetic */ Class class$de$vw$mib$asl$framework$internal$framework$reflection$build$Compiler;
    static /* synthetic */ Class class$de$vw$mib$genericevents$Target;
    static /* synthetic */ Class class$de$vw$mib$genericevents$hsm$AbstractHsmState;

    public static void main(String[] stringArray) {
        try {
            String string = ModuleReflectionDebugCompiler.readArg(stringArray, 0);
            if (string == null || string.equals("")) {
                string = new StringBuffer().append(new File((class$de$vw$mib$asl$framework$internal$framework$reflection$build$Compiler == null ? (class$de$vw$mib$asl$framework$internal$framework$reflection$build$Compiler = ModuleReflectionDebugCompiler.class$("de.vw.mib.asl.framework.internal.framework.reflection.build.Compiler")) : class$de$vw$mib$asl$framework$internal$framework$reflection$build$Compiler).getProtectionDomain().getCodeSource().getLocation().getFile()).getAbsolutePath()).append(File.separator).toString();
            } else if (!string.endsWith(File.separator)) {
                string = new StringBuffer().append(string).append(File.separator).toString();
            }
            String string2 = ModuleReflectionDebugCompiler.readArg(stringArray, 1);
            if (string2 == null || string2.equals("")) {
                throw new RuntimeException("Could not execute module reflection debug compiler. The target directory was not set. ");
            }
            String string3 = ModuleReflectionDebugCompiler.readArg(stringArray, 2);
            if (string3 == null || string3.equals("")) {
                throw new RuntimeException("Could not execute module reflection debug compiler. The target package name was not set. ");
            }
            CommonUtil.mkdirs((File)new File(new StringBuffer().append(string).append(string2).toString()));
            ModuleReflectionDebugCompiler.compile(new File(string), string2, string3);
        }
        catch (RuntimeException runtimeException) {
            LogUtils.logError(runtimeException);
            throw runtimeException;
        }
        catch (Exception exception) {
            LogUtils.logError(exception);
            throw new RuntimeException(exception);
        }
    }

    public static void compile(File file, String string, String string2) {
        try {
            Class clazz = ModuleReflectionConfiguration.loadConfigurationClass(string2);
            ModuleReflectionConfiguration moduleReflectionConfiguration = ModuleReflectionConfiguration.create(clazz);
            ModuleReflectionFactory moduleReflectionFactory = new ModuleReflectionFactory(moduleReflectionConfiguration);
            File file2 = new File(file, string);
            Properties properties = new Properties();
            Properties properties2 = ModuleReflectionDebugCompiler.createTargetsMethodsNamesMap(file, moduleReflectionFactory);
            properties.putAll(properties2);
            Properties properties3 = ModuleReflectionDebugCompiler.createHsmStatesMethodsNamesMap(file, moduleReflectionFactory);
            properties.putAll(properties3);
            AsmUtil.save((Properties)properties, null, (File)file2, (String)"dsi-proxy-methodsNames-dbgMap.properties");
            Properties properties4 = new Properties();
            Properties properties5 = ModuleReflectionDebugCompiler.createTargetsMethodsParametersClassesNamesMap(file, moduleReflectionFactory);
            properties4.putAll(properties5);
            Properties properties6 = ModuleReflectionDebugCompiler.createHsmStatesMethodsParametersClassesNamesMap(file, moduleReflectionFactory);
            properties4.putAll(properties6);
            AsmUtil.save((Properties)properties4, null, (File)file2, (String)"dsi-proxy-methodsParametersClassesNames-dbgMap.properties");
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    private static Properties createTargetsMethodsNamesMap(File file, ModuleReflectionFactory moduleReflectionFactory) {
        JavaClass[] javaClassArray = ModuleReflectionDebugCompiler.retrieveDerivedClasses(file, (class$de$vw$mib$genericevents$Target == null ? (class$de$vw$mib$genericevents$Target = ModuleReflectionDebugCompiler.class$("de.vw.mib.genericevents.Target")) : class$de$vw$mib$genericevents$Target).getName());
        String[] stringArray = new String[javaClassArray.length];
        for (int i2 = 0; i2 < javaClassArray.length; ++i2) {
            stringArray[i2] = javaClassArray[i2].getClassName();
        }
        Properties properties = new Properties();
        for (int i3 = 0; i3 < stringArray.length; ++i3) {
            String string = stringArray[i3];
            Method[] methodArray = ModuleReflectionDebugCompiler.getClassLoader().loadClass(string).getMethods();
            MultipleMethodAccessibleObject multipleMethodAccessibleObject = moduleReflectionFactory.getTargetsMmao();
            for (int i4 = 0; i4 < methodArray.length; ++i4) {
                int n = multipleMethodAccessibleObject.getIndex(string, methodArray[i4].getName(), methodArray[i4].getParameterTypes());
                if (n == -1) continue;
                String string2 = new StringBuffer().append(string).append(".").append(n).toString();
                properties.setProperty(string2, methodArray[i4].getName());
            }
        }
        return properties;
    }

    private static Properties createHsmStatesMethodsNamesMap(File file, ModuleReflectionFactory moduleReflectionFactory) {
        JavaClass[] javaClassArray = ModuleReflectionDebugCompiler.retrieveDerivedClasses(file, (class$de$vw$mib$genericevents$hsm$AbstractHsmState == null ? (class$de$vw$mib$genericevents$hsm$AbstractHsmState = ModuleReflectionDebugCompiler.class$("de.vw.mib.genericevents.hsm.AbstractHsmState")) : class$de$vw$mib$genericevents$hsm$AbstractHsmState).getName());
        String[] stringArray = new String[javaClassArray.length];
        for (int i2 = 0; i2 < javaClassArray.length; ++i2) {
            stringArray[i2] = javaClassArray[i2].getClassName();
        }
        Properties properties = new Properties();
        for (int i3 = 0; i3 < stringArray.length; ++i3) {
            String string = stringArray[i3];
            Method[] methodArray = ModuleReflectionDebugCompiler.getClassLoader().loadClass(string).getMethods();
            MultipleMethodAccessibleObject multipleMethodAccessibleObject = moduleReflectionFactory.getHsmStatesMmao();
            for (int i4 = 0; i4 < methodArray.length; ++i4) {
                int n = multipleMethodAccessibleObject.getIndex(string, methodArray[i4].getName(), methodArray[i4].getParameterTypes());
                if (n == -1) continue;
                String string2 = new StringBuffer().append(string).append(".").append(n).toString();
                properties.setProperty(string2, methodArray[i4].getName());
            }
        }
        return properties;
    }

    private static Properties createTargetsMethodsParametersClassesNamesMap(File file, ModuleReflectionFactory moduleReflectionFactory) {
        JavaClass[] javaClassArray = ModuleReflectionDebugCompiler.retrieveDerivedClasses(file, (class$de$vw$mib$genericevents$Target == null ? (class$de$vw$mib$genericevents$Target = ModuleReflectionDebugCompiler.class$("de.vw.mib.genericevents.Target")) : class$de$vw$mib$genericevents$Target).getName());
        String[] stringArray = new String[javaClassArray.length];
        for (int i2 = 0; i2 < javaClassArray.length; ++i2) {
            stringArray[i2] = javaClassArray[i2].getClassName();
        }
        Properties properties = new Properties();
        for (int i3 = 0; i3 < stringArray.length; ++i3) {
            String string = stringArray[i3];
            Method[] methodArray = ModuleReflectionDebugCompiler.getClassLoader().loadClass(string).getMethods();
            MultipleMethodAccessibleObject multipleMethodAccessibleObject = moduleReflectionFactory.getTargetsMmao();
            for (int i4 = 0; i4 < methodArray.length; ++i4) {
                int n = multipleMethodAccessibleObject.getIndex(string, methodArray[i4].getName(), methodArray[i4].getParameterTypes());
                if (n == -1) continue;
                String string2 = new StringBuffer().append(string).append(".").append(n).toString();
                String string3 = "";
                Class[] classArray = methodArray[i4].getParameterTypes();
                for (int i5 = 0; i5 < classArray.length; ++i5) {
                    string3 = ModuleReflectionDebugCompiler.addParameterClassName(string3, classArray[i5], i5, classArray.length);
                }
                properties.setProperty(string2, string3);
            }
        }
        return properties;
    }

    private static Properties createHsmStatesMethodsParametersClassesNamesMap(File file, ModuleReflectionFactory moduleReflectionFactory) {
        JavaClass[] javaClassArray = ModuleReflectionDebugCompiler.retrieveDerivedClasses(file, (class$de$vw$mib$genericevents$hsm$AbstractHsmState == null ? (class$de$vw$mib$genericevents$hsm$AbstractHsmState = ModuleReflectionDebugCompiler.class$("de.vw.mib.genericevents.hsm.AbstractHsmState")) : class$de$vw$mib$genericevents$hsm$AbstractHsmState).getName());
        String[] stringArray = new String[javaClassArray.length];
        for (int i2 = 0; i2 < javaClassArray.length; ++i2) {
            stringArray[i2] = javaClassArray[i2].getClassName();
        }
        Properties properties = new Properties();
        for (int i3 = 0; i3 < stringArray.length; ++i3) {
            String string = stringArray[i3];
            Method[] methodArray = ModuleReflectionDebugCompiler.getClassLoader().loadClass(string).getMethods();
            MultipleMethodAccessibleObject multipleMethodAccessibleObject = moduleReflectionFactory.getHsmStatesMmao();
            for (int i4 = 0; i4 < methodArray.length; ++i4) {
                int n = multipleMethodAccessibleObject.getIndex(string, methodArray[i4].getName(), methodArray[i4].getParameterTypes());
                if (n == -1) continue;
                String string2 = new StringBuffer().append(string).append(".").append(n).toString();
                String string3 = "";
                Class[] classArray = methodArray[i4].getParameterTypes();
                for (int i5 = 0; i5 < classArray.length; ++i5) {
                    string3 = ModuleReflectionDebugCompiler.addParameterClassName(string3, classArray[i5], i5, classArray.length);
                }
                properties.setProperty(string2, string3);
            }
        }
        return properties;
    }

    private ModuleReflectionDebugCompiler() {
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

