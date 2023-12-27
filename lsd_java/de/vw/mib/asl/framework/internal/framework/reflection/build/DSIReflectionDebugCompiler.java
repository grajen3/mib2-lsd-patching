/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.vw.mib.asl.framework.internal.framework.build.AsmUtil
 *  de.vw.mib.asl.framework.internal.framework.build.CommonUtil
 */
package de.vw.mib.asl.framework.internal.framework.reflection.build;

import de.vw.mib.asl.framework.internal.framework.build.AsmUtil;
import de.vw.mib.asl.framework.internal.framework.build.CommonUtil;
import de.vw.mib.asl.framework.internal.framework.dsi.util.CompileGeneratedConstants;
import de.vw.mib.asl.framework.internal.framework.dsi.util.RuntimeGeneratedConstants;
import de.vw.mib.asl.framework.internal.framework.reflection.build.Compiler;
import de.vw.mib.asl.framework.internal.framework.reflection.build.LogUtils;
import de.vw.mib.asl.framework.internal.framework.reflection.dsi.DSIReflectionConfiguration;
import de.vw.mib.asl.framework.internal.framework.reflection.dsi.DSIReflectionFactory;
import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import java.io.File;
import java.lang.reflect.Method;
import java.util.Properties;

public final class DSIReflectionDebugCompiler
extends Compiler
implements CompileGeneratedConstants {
    private static final int ARGIDX_OUTPUT_DIR;
    private static final int ARGIDX_DEST_DIR;
    static /* synthetic */ Class class$de$vw$mib$asl$framework$internal$framework$reflection$build$Compiler;

    public static void main(String[] stringArray) {
        try {
            String string = DSIReflectionDebugCompiler.readArg(stringArray, 0);
            if (string == null || string.equals("")) {
                string = new StringBuffer().append(new File((class$de$vw$mib$asl$framework$internal$framework$reflection$build$Compiler == null ? (class$de$vw$mib$asl$framework$internal$framework$reflection$build$Compiler = DSIReflectionDebugCompiler.class$("de.vw.mib.asl.framework.internal.framework.reflection.build.Compiler")) : class$de$vw$mib$asl$framework$internal$framework$reflection$build$Compiler).getProtectionDomain().getCodeSource().getLocation().getFile()).getAbsolutePath()).append(File.separator).toString();
            } else if (!string.endsWith(File.separator)) {
                string = new StringBuffer().append(string).append(File.separator).toString();
            }
            String string2 = DSIReflectionDebugCompiler.readArg(stringArray, 1);
            if (string2 == null || string2.equals("")) {
                throw new RuntimeException("Could not execute DSI reflection debug compiler. The target directory was not set. ");
            }
            CommonUtil.mkdirs((File)new File(new StringBuffer().append(string).append(string2).toString()));
            DSIReflectionDebugCompiler.compile(new File(string), string2);
        }
        catch (RuntimeException runtimeException) {
            LogUtils.logError(runtimeException);
            throw runtimeException;
        }
        catch (Throwable throwable) {
            LogUtils.logError(throwable);
            throw new RuntimeException(throwable);
        }
    }

    public static void compile(File file, String string) {
        try {
            DSIReflectionConfiguration dSIReflectionConfiguration = new DSIReflectionConfiguration("de.vw.mib.asl.framework.internal.dsiproxy.lr.DSIRFCC");
            DSIReflectionFactory dSIReflectionFactory = new DSIReflectionFactory(dSIReflectionConfiguration);
            File file2 = new File(file, string);
            file2.mkdirs();
            Properties properties = new Properties();
            Properties properties2 = DSIReflectionDebugCompiler.createServicesNamesMap();
            properties.putAll(properties2);
            Properties properties3 = DSIReflectionDebugCompiler.createListenersNamesMap();
            properties.putAll(properties3);
            AsmUtil.save((Properties)properties, null, (File)file2, (String)"dsi-proxy-classesNames-dbgMap.properties");
            Properties properties4 = new Properties();
            Properties properties5 = DSIReflectionDebugCompiler.createServicesInstancesMap();
            properties4.putAll(properties5);
            Properties properties6 = DSIReflectionDebugCompiler.createListenersInstancesMap();
            properties4.putAll(properties6);
            AsmUtil.save((Properties)properties4, null, (File)file2, (String)"dsi-proxy-classesInstances-dbgMap.properties");
            Properties properties7 = new Properties();
            Properties properties8 = DSIReflectionDebugCompiler.createServicesMethodsNamesMap(dSIReflectionFactory);
            properties7.putAll(properties8);
            Properties properties9 = DSIReflectionDebugCompiler.createListenersMethodsNamesMap(dSIReflectionFactory);
            properties7.putAll(properties9);
            AsmUtil.save((Properties)properties7, null, (File)file2, (String)"dsi-proxy-methodsNames-dbgMap.properties");
            Properties properties10 = new Properties();
            Properties properties11 = DSIReflectionDebugCompiler.createServicesMethodsParametersClassesNamesMap(dSIReflectionFactory);
            properties10.putAll(properties11);
            Properties properties12 = DSIReflectionDebugCompiler.createListenersMethodsParametersClassesNamesMap(dSIReflectionFactory);
            properties10.putAll(properties12);
            AsmUtil.save((Properties)properties10, null, (File)file2, (String)"dsi-proxy-methodsParametersClassesNames-dbgMap.properties");
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    private static Properties createServicesNamesMap() {
        Properties properties = new Properties();
        for (int i2 = 0; i2 < RuntimeGeneratedConstants.SERVICE_TS_NS.length; ++i2) {
            String string = new StringBuffer().append("0.").append(i2).toString();
            properties.setProperty(string, RuntimeGeneratedConstants.SERVICE_TS_NS[i2]);
        }
        return properties;
    }

    private static Properties createListenersNamesMap() {
        Properties properties = new Properties();
        for (int i2 = 0; i2 < RuntimeGeneratedConstants.LISTENER_TS_NS.length; ++i2) {
            String string = new StringBuffer().append("1.").append(i2).toString();
            properties.setProperty(string, RuntimeGeneratedConstants.LISTENER_TS_NS[i2]);
        }
        return properties;
    }

    private static Properties createServicesInstancesMap() {
        Properties properties = new Properties();
        for (int i2 = 0; i2 < RuntimeGeneratedConstants.SERVICE_TS_NS.length; ++i2) {
            String string = new StringBuffer().append("0.").append(i2).toString();
            properties.setProperty(string, Integer.toString(RuntimeGeneratedConstants.INST_NMBS[i2]));
        }
        return properties;
    }

    private static Properties createListenersInstancesMap() {
        Properties properties = new Properties();
        for (int i2 = 0; i2 < RuntimeGeneratedConstants.LISTENER_TS_NS.length; ++i2) {
            String string = new StringBuffer().append("1.").append(i2).toString();
            properties.setProperty(string, Integer.toString(RuntimeGeneratedConstants.INST_NMBS[i2]));
        }
        return properties;
    }

    private static Properties createServicesMethodsNamesMap(DSIReflectionFactory dSIReflectionFactory) {
        Properties properties = new Properties();
        for (int i2 = 0; i2 < RuntimeGeneratedConstants.SERVICE_TS_NS.length; ++i2) {
            String string = RuntimeGeneratedConstants.SERVICE_TS_NS[i2];
            Method[] methodArray = DSIReflectionDebugCompiler.getClassLoader().loadClass(string).getMethods();
            MultipleMethodAccessibleObject multipleMethodAccessibleObject = dSIReflectionFactory.getServicesMmao(i2);
            for (int i3 = 0; i3 < methodArray.length; ++i3) {
                int n = multipleMethodAccessibleObject.getIndex(string, methodArray[i3].getName(), methodArray[i3].getParameterTypes());
                if (n == -1) continue;
                String string2 = new StringBuffer().append(string).append(".").append(n).toString();
                properties.setProperty(string2, methodArray[i3].getName());
            }
        }
        return properties;
    }

    private static Properties createListenersMethodsNamesMap(DSIReflectionFactory dSIReflectionFactory) {
        Properties properties = new Properties();
        for (int i2 = 0; i2 < RuntimeGeneratedConstants.LISTENER_TS_NS.length; ++i2) {
            String string = RuntimeGeneratedConstants.LISTENER_TS_NS[i2];
            Method[] methodArray = DSIReflectionDebugCompiler.getClassLoader().loadClass(string).getMethods();
            MultipleMethodAccessibleObject multipleMethodAccessibleObject = dSIReflectionFactory.getListenersMmao(i2);
            for (int i3 = 0; i3 < methodArray.length; ++i3) {
                int n = multipleMethodAccessibleObject.getIndex(string, methodArray[i3].getName(), methodArray[i3].getParameterTypes());
                if (n == -1) continue;
                String string2 = new StringBuffer().append(string).append(".").append(n).toString();
                properties.setProperty(string2, methodArray[i3].getName());
            }
        }
        return properties;
    }

    private static Properties createServicesMethodsParametersClassesNamesMap(DSIReflectionFactory dSIReflectionFactory) {
        Properties properties = new Properties();
        for (int i2 = 0; i2 < RuntimeGeneratedConstants.SERVICE_TS_NS.length; ++i2) {
            String string = RuntimeGeneratedConstants.SERVICE_TS_NS[i2];
            Method[] methodArray = DSIReflectionDebugCompiler.getClassLoader().loadClass(string).getMethods();
            MultipleMethodAccessibleObject multipleMethodAccessibleObject = dSIReflectionFactory.getServicesMmao(i2);
            for (int i3 = 0; i3 < methodArray.length; ++i3) {
                int n = multipleMethodAccessibleObject.getIndex(string, methodArray[i3].getName(), methodArray[i3].getParameterTypes());
                if (n == -1) continue;
                String string2 = new StringBuffer().append(string).append(".").append(n).toString();
                String string3 = "";
                Class[] classArray = methodArray[i3].getParameterTypes();
                for (int i4 = 0; i4 < classArray.length; ++i4) {
                    string3 = DSIReflectionDebugCompiler.addParameterClassName(string3, classArray[i4], i4, classArray.length);
                }
                properties.setProperty(string2, string3);
            }
        }
        return properties;
    }

    private static Properties createListenersMethodsParametersClassesNamesMap(DSIReflectionFactory dSIReflectionFactory) {
        Properties properties = new Properties();
        for (int i2 = 0; i2 < RuntimeGeneratedConstants.LISTENER_TS_NS.length; ++i2) {
            String string = RuntimeGeneratedConstants.LISTENER_TS_NS[i2];
            Method[] methodArray = DSIReflectionDebugCompiler.getClassLoader().loadClass(string).getMethods();
            MultipleMethodAccessibleObject multipleMethodAccessibleObject = dSIReflectionFactory.getListenersMmao(i2);
            for (int i3 = 0; i3 < methodArray.length; ++i3) {
                int n = multipleMethodAccessibleObject.getIndex(string, methodArray[i3].getName(), methodArray[i3].getParameterTypes());
                if (n == -1) continue;
                String string2 = new StringBuffer().append(string).append(".").append(n).toString();
                String string3 = "";
                Class[] classArray = methodArray[i3].getParameterTypes();
                for (int i4 = 0; i4 < classArray.length; ++i4) {
                    string3 = DSIReflectionDebugCompiler.addParameterClassName(string3, classArray[i4], i4, classArray.length);
                }
                properties.setProperty(string2, string3);
            }
        }
        return properties;
    }

    private DSIReflectionDebugCompiler() {
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

