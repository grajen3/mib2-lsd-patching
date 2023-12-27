/*
 * Decompiled with CFR 0.152.
 */
package java.lang;

import com.ibm.oti.util.PriviAction;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FilePermission;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.InetAddress;
import java.net.SocketPermission;
import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.Permission;
import java.security.SecurityPermission;
import java.util.PropertyPermission;
import java.util.StringTokenizer;

public class SecurityManager {
    private static volatile String[] securePackageList = new String[0];
    private static volatile String packageAccess;
    private PropertyPermission permissionToReadWriteAllProperties = new PropertyPermission("*", "read,write");
    static /* synthetic */ Class class$0;
    static /* synthetic */ Class class$1;

    public SecurityManager() {
        Class clazz;
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(RuntimePermission.permissionToCreateSecurityManager);
        }
        if ((clazz = class$0) == null) {
            try {
                clazz = class$0 = Class.forName("java.security.Security");
            }
            catch (ClassNotFoundException classNotFoundException) {
                throw new NoClassDefFoundError(classNotFoundException.getMessage());
            }
        }
    }

    public void checkAccept(String string, int n) {
        if (string == null) {
            throw new NullPointerException();
        }
        this.checkPermission(new SocketPermission(new StringBuffer(String.valueOf(string)).append(':').append(n).toString(), "accept"));
    }

    public void checkAccess(Thread thread) {
        ThreadGroup threadGroup = thread.getThreadGroup();
        if (threadGroup != null && threadGroup.parent == null) {
            this.checkPermission(RuntimePermission.permissionToModifyThread);
        }
    }

    public void checkAccess(ThreadGroup threadGroup) {
        if (threadGroup == null) {
            throw new NullPointerException();
        }
        if (threadGroup.parent == null) {
            this.checkPermission(RuntimePermission.permissionToModifyThreadGroup);
        }
    }

    public void checkConnect(String string, int n) {
        if (string == null) {
            throw new NullPointerException();
        }
        if (n > 0) {
            this.checkPermission(new SocketPermission(new StringBuffer(String.valueOf(string)).append(':').append(n).toString(), "connect"));
        } else {
            this.checkPermission(new SocketPermission(string, "resolve"));
        }
    }

    public void checkConnect(String string, int n, Object object) {
        if (n > 0) {
            this.checkPermission(new SocketPermission(new StringBuffer(String.valueOf(string)).append(':').append(n).toString(), "connect"), object);
        } else {
            this.checkPermission(new SocketPermission(string, "resolve"), object);
        }
    }

    public void checkCreateClassLoader() {
        this.checkPermission(RuntimePermission.permissionToCreateClassLoader);
    }

    public void checkDelete(String string) {
        this.checkPermission(new FilePermission(string, "delete"));
    }

    public void checkExec(String string) {
        this.checkPermission(new FilePermission(new File(string).isAbsolute() ? string : "<<ALL FILES>>", "execute"));
    }

    public void checkExit(int n) {
        this.checkPermission(RuntimePermission.permissionToExitVM);
    }

    public void checkLink(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        this.checkPermission(new RuntimePermission(new StringBuffer("loadLibrary.").append(string).toString()));
    }

    public void checkListen(int n) {
        if (n == 0) {
            this.checkPermission(new SocketPermission("localhost:1024-", "listen"));
        } else {
            this.checkPermission(new SocketPermission(new StringBuffer("localhost:").append(n).toString(), "listen"));
        }
    }

    public void checkMemberAccess(Class clazz, int n) {
        if (clazz == null) {
            throw new NullPointerException();
        }
        if (n == 0) {
            return;
        }
        if (ClassLoader.getStackClassLoader(3) == clazz.getClassLoaderImpl()) {
            return;
        }
        this.checkPermission(new RuntimePermission("accessDeclaredMembers"));
    }

    public void checkMulticast(InetAddress inetAddress) {
        this.checkPermission(new SocketPermission(inetAddress.getHostAddress(), "accept,connect"));
    }

    public void checkMulticast(InetAddress inetAddress, byte by) {
        this.checkPermission(new SocketPermission(inetAddress.getHostAddress(), "accept,connect"));
    }

    public void checkPackageAccess(String string) {
        String[] stringArray;
        if (string == null) {
            throw new NullPointerException();
        }
        String string2 = this.getSecurityProperty("package.access");
        if (string2 != packageAccess) {
            if (string2 != null) {
                StringTokenizer stringTokenizer = new StringTokenizer(string2, ", ");
                int n = 0;
                stringArray = new String[stringTokenizer.countTokens()];
                while (stringTokenizer.hasMoreTokens()) {
                    stringArray[n++] = stringTokenizer.nextToken();
                }
                packageAccess = string2;
            } else {
                stringArray = new String[]{};
            }
            securePackageList = stringArray;
        } else {
            stringArray = securePackageList;
        }
        int n = 0;
        while (n < stringArray.length) {
            if (string.startsWith(stringArray[n])) {
                this.checkPermission(new RuntimePermission(new StringBuffer("accessClassInPackage.").append(string).toString()));
                return;
            }
            ++n;
        }
    }

    public void checkPackageDefinition(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        String string2 = this.getSecurityProperty("package.definition");
        if (string2 != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(string2, ", ");
            while (stringTokenizer.hasMoreTokens()) {
                if (!string.startsWith(stringTokenizer.nextToken())) continue;
                this.checkPermission(new RuntimePermission(new StringBuffer("defineClassInPackage.").append(string).toString()));
                return;
            }
        }
    }

    private String getSecurityProperty(String string) {
        return (String)AccessController.doPrivileged(PriviAction.getSecurityProperty(string));
    }

    public void checkPropertiesAccess() {
        this.checkPermission(this.permissionToReadWriteAllProperties);
    }

    public void checkPropertyAccess(String string) {
        this.checkPermission(new PropertyPermission(string, "read"));
    }

    public void checkRead(FileDescriptor fileDescriptor) {
        if (fileDescriptor == null) {
            throw new NullPointerException();
        }
        this.checkPermission(RuntimePermission.permissionToReadFileDescriptor);
    }

    public void checkRead(String string) {
        this.checkPermission(new FilePermission(string, "read"));
    }

    public void checkRead(String string, Object object) {
        this.checkPermission(new FilePermission(string, "read"), object);
    }

    public void checkSecurityAccess(String string) {
        this.checkPermission(new SecurityPermission(string));
    }

    public void checkSetFactory() {
        this.checkPermission(RuntimePermission.permissionToSetFactory);
    }

    public boolean checkTopLevelWindow(Object object) {
        if (object == null) {
            throw new NullPointerException();
        }
        try {
            Class clazz = Class.forName("java.awt.AWTPermission");
            Class[] classArray = new Class[1];
            Class clazz2 = class$1;
            if (clazz2 == null) {
                try {
                    clazz2 = class$1 = Class.forName("java.lang.String");
                }
                catch (ClassNotFoundException classNotFoundException) {
                    throw new NoClassDefFoundError(classNotFoundException.getMessage());
                }
            }
            classArray[0] = clazz2;
            Class[] classArray2 = classArray;
            Constructor constructor = clazz.getConstructor(classArray2);
            Object[] objectArray = new Object[]{"showWindowWithoutWarningBanner"};
            Permission permission = (Permission)constructor.newInstance(objectArray);
            this.checkPermission(permission);
        }
        catch (Exception exception) {
            return false;
        }
        return true;
    }

    public void checkSystemClipboardAccess() {
        try {
            Class clazz = Class.forName("java.awt.AWTPermission");
            Class[] classArray = new Class[1];
            Class clazz2 = class$1;
            if (clazz2 == null) {
                try {
                    clazz2 = class$1 = Class.forName("java.lang.String");
                }
                catch (ClassNotFoundException classNotFoundException) {
                    throw new NoClassDefFoundError(classNotFoundException.getMessage());
                }
            }
            classArray[0] = clazz2;
            Class[] classArray2 = classArray;
            Constructor constructor = clazz.getConstructor(classArray2);
            Object[] objectArray = new Object[]{"accessClipboard"};
            Permission permission = (Permission)constructor.newInstance(objectArray);
            this.checkPermission(permission);
            return;
        }
        catch (ClassNotFoundException classNotFoundException) {
        }
        catch (NoSuchMethodException noSuchMethodException) {
        }
        catch (InstantiationException instantiationException) {
        }
        catch (IllegalAccessException illegalAccessException) {
        }
        catch (InvocationTargetException invocationTargetException) {}
        throw new SecurityException();
    }

    public void checkAwtEventQueueAccess() {
        try {
            Class clazz = Class.forName("java.awt.AWTPermission");
            Class[] classArray = new Class[1];
            Class clazz2 = class$1;
            if (clazz2 == null) {
                try {
                    clazz2 = class$1 = Class.forName("java.lang.String");
                }
                catch (ClassNotFoundException classNotFoundException) {
                    throw new NoClassDefFoundError(classNotFoundException.getMessage());
                }
            }
            classArray[0] = clazz2;
            Class[] classArray2 = classArray;
            Constructor constructor = clazz.getConstructor(classArray2);
            Object[] objectArray = new Object[]{"accessEventQueue"};
            Permission permission = (Permission)constructor.newInstance(objectArray);
            this.checkPermission(permission);
            return;
        }
        catch (ClassNotFoundException classNotFoundException) {
        }
        catch (NoSuchMethodException noSuchMethodException) {
        }
        catch (InstantiationException instantiationException) {
        }
        catch (IllegalAccessException illegalAccessException) {
        }
        catch (InvocationTargetException invocationTargetException) {}
        throw new SecurityException();
    }

    public void checkPrintJobAccess() {
        this.checkPermission(RuntimePermission.permissionToQueuePrintJob);
    }

    public void checkWrite(FileDescriptor fileDescriptor) {
        if (fileDescriptor == null) {
            throw new NullPointerException();
        }
        this.checkPermission(RuntimePermission.permissionToWriteFileDescriptor);
    }

    public void checkWrite(String string) {
        this.checkPermission(new FilePermission(string, "write"));
    }

    protected Class[] getClassContext() {
        return Class.getStackClasses(-1, false);
    }

    public ThreadGroup getThreadGroup() {
        return Thread.currentThread().getThreadGroup();
    }

    public Object getSecurityContext() {
        return AccessController.getContext();
    }

    public void checkPermission(Permission permission) {
        AccessController.checkPermission(permission);
    }

    public void checkPermission(Permission permission, Object object) {
        if (!(object instanceof AccessControlContext)) {
            throw new SecurityException();
        }
        ((AccessControlContext)object).checkPermission(permission);
    }
}

