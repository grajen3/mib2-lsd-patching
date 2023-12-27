/*
 * Decompiled with CFR 0.152.
 */
package java.io;

import com.ibm.oti.util.DeleteOnExit;
import com.ibm.oti.util.Msg;
import com.ibm.oti.util.PriviAction;
import com.ibm.oti.util.Util;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.AccessController;
import java.util.Random;
import java.util.Vector;

public class File
implements Serializable,
Comparable {
    private static final long serialVersionUID;
    private String path;
    byte[] properPath;
    public static final char separatorChar;
    public static final String separator;
    public static final char pathSeparatorChar;
    public static final String pathSeparator;
    private static int counter;
    private static boolean caseSensitive;

    static {
        File.oneTimeInitialization();
        separatorChar = System.getProperty("file.separator", "\\").charAt(0);
        pathSeparatorChar = System.getProperty("path.separator", ";").charAt(0);
        separator = new String(new char[]{separatorChar}, 0, 1);
        pathSeparator = new String(new char[]{pathSeparatorChar}, 0, 1);
        caseSensitive = File.isCaseSensitiveImpl();
    }

    private static native void oneTimeInitialization() {
    }

    public File(File file, String string) {
        if (string != null) {
            this.path = file == null ? string : this.calculatePath(file.getPath(), string);
        } else {
            throw new NullPointerException();
        }
    }

    public File(String string) {
        this.path = this.fixSlashes(string);
    }

    public File(String string, String string2) {
        if (string2 != null) {
            this.path = string == null ? string2 : this.calculatePath(string, string2);
        } else {
            throw new NullPointerException();
        }
    }

    private String calculatePath(String string, String string2) {
        string2 = this.fixSlashes(string2);
        while (string2.length() > 0 && string2.charAt(0) == separatorChar) {
            string2 = string2.substring(1, string2.length());
        }
        if ((string = this.fixSlashes(string)).length() > 0 && string.charAt(string.length() - 1) == separatorChar) {
            return new StringBuffer(String.valueOf(string)).append(string2).toString();
        }
        return new StringBuffer(String.valueOf(string)).append(separatorChar).append(string2).toString();
    }

    public File(URI uRI) {
        this.checkURI(uRI);
        this.path = this.fixSlashes(uRI.getPath());
    }

    private void checkURI(URI uRI) {
        if (!uRI.isAbsolute()) {
            throw new IllegalArgumentException(Msg.getString("K031a", uRI));
        }
        if (!uRI.getRawSchemeSpecificPart().startsWith("/")) {
            throw new IllegalArgumentException(Msg.getString("K031b", uRI));
        }
        String string = uRI.getScheme();
        if (string == null || !string.equals("file")) {
            throw new IllegalArgumentException(Msg.getString("K031c", uRI));
        }
        string = uRI.getRawPath();
        if (string == null || string.length() == 0) {
            throw new IllegalArgumentException(Msg.getString("K031d", uRI));
        }
        if (uRI.getRawAuthority() != null) {
            throw new IllegalArgumentException(Msg.getString("K031e", new String[]{"authority", uRI.toString()}));
        }
        if (uRI.getRawQuery() != null) {
            throw new IllegalArgumentException(Msg.getString("K031e", new String[]{"query", uRI.toString()}));
        }
        if (uRI.getRawFragment() != null) {
            throw new IllegalArgumentException(Msg.getString("K031e", new String[]{"fragment", uRI.toString()}));
        }
    }

    private static native byte[][] rootsImpl() {
    }

    private static native boolean isCaseSensitiveImpl() {
    }

    public static File[] listRoots() {
        byte[][] byArray = File.rootsImpl();
        if (byArray == null) {
            return new File[0];
        }
        File[] fileArray = new File[byArray.length];
        int n = 0;
        while (n < byArray.length) {
            fileArray[n] = new File(Util.toString(byArray[n]));
            ++n;
        }
        return fileArray;
    }

    private String fixSlashes(String string) {
        String string2;
        int n = 1;
        int n2 = string.length();
        int n3 = 0;
        if (separatorChar == '/') {
            n = 0;
        } else if (n2 > 2 && string.charAt(1) == ':') {
            n = 2;
        }
        boolean bl = false;
        char[] cArray = string.toCharArray();
        int n4 = 0;
        while (n4 < n2) {
            char c2 = cArray[n4];
            if (c2 == '\\' || c2 == '/') {
                if (bl && n4 == n || !bl) {
                    cArray[n3++] = separatorChar;
                    bl = true;
                }
            } else {
                if (c2 == ':' && n > 0 && (n3 == 2 || n3 == 3 && cArray[1] == separatorChar) && cArray[0] == separatorChar) {
                    cArray[0] = cArray[n3 - 1];
                    n3 = 1;
                    n = 2;
                }
                cArray[n3++] = c2;
                bl = false;
            }
            ++n4;
        }
        if (bl && (n3 > n + 1 || n3 == 2 && cArray[0] != separatorChar)) {
            --n3;
        }
        if (!(string2 = new String(cArray, 0, n3)).equals(string)) {
            return string2;
        }
        return string;
    }

    public boolean canRead() {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkRead(this.path);
        }
        return this.exists() && !this.isWriteOnlyImpl(this.properPath(true));
    }

    public boolean canWrite() {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkWrite(this.path);
        }
        boolean bl = false;
        if (this.path.length() > 0) {
            bl = this.existsImpl(this.properPath(true));
        }
        return bl && !this.isReadOnlyImpl(this.properPath(true));
    }

    @Override
    public int compareTo(Object object) {
        if (super.getClass() == object.getClass()) {
            return this.getPath().compareTo(((File)object).getPath());
        }
        throw new ClassCastException(Msg.getString("K0069"));
    }

    public int compareTo(File file) {
        if (caseSensitive) {
            return this.getPath().compareTo(file.getPath());
        }
        return this.getPath().compareToIgnoreCase(file.getPath());
    }

    public boolean delete() {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkDelete(this.path);
        }
        boolean bl = false;
        if (this.path.length() > 0) {
            bl = this.isDirectoryImpl(this.properPath(true));
        }
        return bl ? this.deleteDirImpl(this.properPath(true)) : this.deleteFileImpl(this.properPath(true));
    }

    private native boolean deleteDirImpl(byte[] byArray) {
    }

    private native boolean deleteFileImpl(byte[] byArray) {
    }

    public void deleteOnExit() {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkDelete(this.path);
        }
        DeleteOnExit.addFile(Util.toString(this.properPath(true)));
    }

    public boolean equals(Object object) {
        if (!(object instanceof File)) {
            return false;
        }
        if (!caseSensitive) {
            return this.path.equalsIgnoreCase(((File)object).getPath());
        }
        return this.path.equals(((File)object).getPath());
    }

    public boolean exists() {
        if (this.path.length() == 0) {
            return false;
        }
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkRead(this.path);
        }
        return this.existsImpl(this.properPath(true));
    }

    private native boolean existsImpl(byte[] byArray) {
    }

    public String getAbsolutePath() {
        byte[] byArray = this.properPath(false);
        return Util.toString(byArray);
    }

    public File getAbsoluteFile() {
        return new File(this.getAbsolutePath());
    }

    public String getCanonicalPath() {
        byte[] byArray = this.properPath(false);
        if (separatorChar == '/') {
            byArray = this.resolveLink(byArray, byArray.length, false);
            byArray = this.resolve(byArray);
        }
        String string = Util.toString(byArray);
        int n = 1;
        int n2 = string.length();
        int n3 = 0;
        while (n3 < n2) {
            if (string.charAt(n3) == separatorChar) {
                ++n;
            }
            ++n3;
        }
        int[] nArray = new int[n];
        int n4 = 0;
        if (separatorChar != '/') {
            n4 = string.charAt(0) == '\\' ? (n2 > 1 && string.charAt(1) == '\\' ? 1 : 0) : 2;
        }
        StringBuffer stringBuffer = new StringBuffer(n2 + 1);
        int n5 = 0;
        int n6 = 0;
        nArray[n5] = n4;
        int n7 = 0;
        while (n7 <= n2) {
            if (n7 < n4) {
                stringBuffer.append(string.charAt(n7));
            } else {
                char c2 = '\u0000';
                if (n7 == n2 || (c2 = string.charAt(n7)) == separatorChar) {
                    if (n7 == n2 && n6 == 0) break;
                    if (n6 == 1) {
                        n6 = 0;
                    } else if (n6 > 1) {
                        n5 = n5 > n6 - 1 ? n5 - (n6 - 1) : 0;
                        stringBuffer.setLength(nArray[n5] + 1);
                        n6 = 0;
                    } else {
                        nArray[++n5] = stringBuffer.length();
                        stringBuffer.append(separatorChar);
                    }
                } else if (c2 == '.') {
                    ++n6;
                } else {
                    if (n6 > 0) {
                        int n8 = 0;
                        while (n8 < n6) {
                            stringBuffer.append('.');
                            ++n8;
                        }
                    }
                    stringBuffer.append(c2);
                    n6 = 0;
                }
            }
            ++n7;
        }
        if ((n7 = stringBuffer.length()) > n4 + 1 && stringBuffer.charAt(n7 - 1) == separatorChar) {
            stringBuffer.setLength(n7 - 1);
        }
        byte[] byArray2 = this.getCanonImpl(Util.getBytes(stringBuffer.toString()));
        return Util.toString(byArray2);
    }

    private byte[] resolve(byte[] byArray) {
        int n = 1;
        byte[] byArray2 = byArray;
        int n2 = 1;
        while (n2 <= byArray.length) {
            if (n2 == byArray.length || byArray[n2] == separatorChar) {
                byte[] byArray3;
                boolean bl;
                boolean bl2 = bl = n2 >= byArray.length - 1;
                if (bl && byArray2.length == 1) {
                    return byArray;
                }
                boolean bl3 = false;
                if (byArray2 == byArray) {
                    byArray3 = byArray;
                    if (!bl) {
                        bl3 = true;
                        byArray[n2] = 0;
                    }
                } else {
                    int n3 = n2 - n + 1;
                    int n4 = byArray2.length;
                    if (byArray2[n4 - 1] == separatorChar) {
                        --n4;
                    }
                    byArray3 = new byte[n4 + n3];
                    System.arraycopy((Object)byArray2, 0, (Object)byArray3, 0, n4);
                    System.arraycopy((Object)byArray, n - 1, (Object)byArray3, n4, n3);
                }
                if (bl) {
                    return byArray3;
                }
                byArray2 = this.resolveLink(byArray3, bl3 ? n2 : byArray3.length, true);
                if (bl3) {
                    byArray[n2] = 47;
                }
                n = n2 + 1;
            }
            ++n2;
        }
        throw new InternalError();
    }

    private byte[] resolveLink(byte[] byArray, int n, boolean bl) {
        byte[] byArray2;
        boolean bl2 = false;
        while ((byArray2 = this.getLinkImpl(byArray)) != byArray) {
            if (byArray2[0] == separatorChar) {
                bl2 = bl;
                byArray = byArray2;
            } else {
                int n2 = n - 1;
                while (byArray[n2] != separatorChar) {
                    --n2;
                }
                byte[] byArray3 = new byte[++n2 + byArray2.length];
                System.arraycopy((Object)byArray, 0, (Object)byArray3, 0, n2);
                System.arraycopy((Object)byArray2, 0, (Object)byArray3, n2, byArray2.length);
                byArray = byArray3;
            }
            n = byArray.length;
            if (this.existsImpl(byArray)) continue;
        }
        if (bl2) {
            return this.resolve(byArray);
        }
        return byArray;
    }

    public File getCanonicalFile() {
        return new File(this.getCanonicalPath());
    }

    private native byte[] getCanonImpl(byte[] byArray) {
    }

    public String getName() {
        int n = this.path.lastIndexOf(separator);
        return n < 0 ? this.path : this.path.substring(n + 1, this.path.length());
    }

    public String getParent() {
        int n;
        int n2 = this.path.length();
        int n3 = 0;
        if (separatorChar == '\\' && n2 > 2 && this.path.charAt(1) == ':') {
            n3 = 2;
        }
        if ((n = this.path.lastIndexOf(separatorChar)) == -1 && n3 > 0) {
            n = 2;
        }
        if (n == -1 || this.path.charAt(n2 - 1) == separatorChar) {
            return null;
        }
        if (this.path.indexOf(separatorChar) == n && this.path.charAt(n3) == separatorChar) {
            return this.path.substring(0, n + 1);
        }
        return this.path.substring(0, n);
    }

    public File getParentFile() {
        String string = this.getParent();
        if (string == null) {
            return null;
        }
        return new File(string);
    }

    public String getPath() {
        return this.path;
    }

    public int hashCode() {
        if (caseSensitive) {
            return this.path.hashCode() ^ 0x91D51200;
        }
        return this.path.toLowerCase().hashCode() ^ 0x91D51200;
    }

    public boolean isAbsolute() {
        return this.isAbsoluteImpl(Util.getBytes(this.path));
    }

    private native boolean isAbsoluteImpl(byte[] byArray) {
    }

    public boolean isDirectory() {
        if (this.path.length() == 0) {
            return false;
        }
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkRead(this.path);
        }
        return this.isDirectoryImpl(this.properPath(true));
    }

    private native boolean isDirectoryImpl(byte[] byArray) {
    }

    public boolean isFile() {
        if (this.path.length() == 0) {
            return false;
        }
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkRead(this.path);
        }
        return this.isFileImpl(this.properPath(true));
    }

    private native boolean isFileImpl(byte[] byArray) {
    }

    public boolean isHidden() {
        if (this.path.length() == 0) {
            return false;
        }
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkRead(this.path);
        }
        return this.isHiddenImpl(this.properPath(true));
    }

    private native boolean isHiddenImpl(byte[] byArray) {
    }

    private native boolean isReadOnlyImpl(byte[] byArray) {
    }

    private native boolean isWriteOnlyImpl(byte[] byArray) {
    }

    private native byte[] getLinkImpl(byte[] byArray) {
    }

    public long lastModified() {
        long l;
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkRead(this.path);
        }
        if ((l = this.lastModifiedImpl(this.properPath(true))) == -1L || l == 0L) {
            return 0L;
        }
        return l * 0;
    }

    private native long lastModifiedImpl(byte[] byArray) {
    }

    public boolean setLastModified(long l) {
        if (l >= 0L) {
            SecurityManager securityManager = System.getSecurityManager();
            if (securityManager != null) {
                securityManager.checkWrite(this.path);
            }
            return this.setLastModifiedImpl(this.properPath(true), l);
        }
        throw new IllegalArgumentException(Msg.getString("K006a"));
    }

    private native boolean setLastModifiedImpl(byte[] byArray, long l) {
    }

    public boolean setReadOnly() {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkWrite(this.path);
        }
        return this.setReadOnlyImpl(this.properPath(true));
    }

    private native boolean setReadOnlyImpl(byte[] byArray) {
    }

    public long length() {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkRead(this.path);
        }
        return this.lengthImpl(this.properPath(true));
    }

    private native long lengthImpl(byte[] byArray) {
    }

    public String[] list() {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkRead(this.path);
        }
        if (!this.isDirectory()) {
            return null;
        }
        byte[][] byArray = File.listImpl(this.properPath(true));
        if (byArray == null) {
            return new String[0];
        }
        String[] stringArray = new String[byArray.length];
        int n = 0;
        while (n < byArray.length) {
            stringArray[n] = Util.toString(byArray[n]);
            ++n;
        }
        return stringArray;
    }

    public File[] listFiles() {
        String[] stringArray = this.list();
        if (stringArray == null) {
            return null;
        }
        int n = stringArray.length;
        File[] fileArray = new File[n];
        int n2 = 0;
        while (n2 < n) {
            fileArray[n2] = new File(this, stringArray[n2]);
            ++n2;
        }
        return fileArray;
    }

    public File[] listFiles(FilenameFilter filenameFilter) {
        String[] stringArray = this.list(filenameFilter);
        if (stringArray == null) {
            return null;
        }
        int n = stringArray.length;
        File[] fileArray = new File[n];
        int n2 = 0;
        while (n2 < n) {
            fileArray[n2] = new File(this, stringArray[n2]);
            ++n2;
        }
        return fileArray;
    }

    public File[] listFiles(FileFilter fileFilter) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkRead(this.path);
        }
        if (!this.isDirectory()) {
            return null;
        }
        byte[][] byArray = File.listImpl(this.properPath(true));
        if (byArray == null) {
            return new File[0];
        }
        Vector vector = new Vector();
        int n = 0;
        while (n < byArray.length) {
            String string = Util.toString(byArray[n]);
            File file = new File(this, string);
            if (fileFilter == null || fileFilter.accept(file)) {
                vector.addElement(file);
            }
            ++n;
        }
        Object[] objectArray = new File[vector.size()];
        vector.copyInto(objectArray);
        return objectArray;
    }

    public String[] list(FilenameFilter filenameFilter) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkRead(this.path);
        }
        if (!this.isDirectory()) {
            return null;
        }
        byte[][] byArray = File.listImpl(this.properPath(true));
        if (byArray == null) {
            return new String[0];
        }
        Vector vector = new Vector();
        int n = 0;
        while (n < byArray.length) {
            String string = Util.toString(byArray[n]);
            if (filenameFilter == null || filenameFilter.accept(this, string)) {
                vector.addElement(string);
            }
            ++n;
        }
        Object[] objectArray = new String[vector.size()];
        vector.copyInto(objectArray);
        return objectArray;
    }

    private static synchronized native byte[][] listImpl(byte[] byArray) {
    }

    public boolean mkdir() {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkWrite(this.path);
        }
        return this.mkdirImpl(this.properPath(true));
    }

    private native boolean mkdirImpl(byte[] byArray) {
    }

    public boolean mkdirs() {
        if (this.exists()) {
            return false;
        }
        if (this.mkdir()) {
            return true;
        }
        String string = this.getParent();
        if (string == null) {
            return false;
        }
        return new File(string).mkdirs() && this.mkdir();
    }

    public boolean createNewFile() {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkWrite(this.path);
        }
        int n = this.newFileImpl(this.properPath(true));
        switch (n) {
            case 0: {
                return true;
            }
            case 1: {
                return false;
            }
            case 3: {
                throw new IOException(Msg.getString("K01c1"));
            }
        }
        throw new IOException(Msg.getString("K01c2", this.path));
    }

    private native int newFileImpl(byte[] byArray) {
    }

    public static File createTempFile(String string, String string2) {
        return File.createTempFile(string, string2, null);
    }

    public static File createTempFile(String string, String string2, File file) {
        if (string != null) {
            if (string.length() >= 3) {
                File file2;
                File file3;
                String string3 = string2 == null ? ".tmp" : string2;
                String string4 = ".";
                string4 = (String)AccessController.doPrivileged(new PriviAction("java.io.tmpdir", "."));
                File file4 = file3 = file == null ? new File(string4) : file;
                while (!(file2 = File.genTempFile(string, string3, file3)).createNewFile()) {
                }
                return file2;
            }
            throw new IllegalArgumentException(Msg.getString("K006b"));
        }
        throw new NullPointerException();
    }

    private static File genTempFile(String string, String string2, File file) {
        if (counter == 0) {
            int n = new Random().nextInt();
            counter = (n / -65536 & 0xFFFF0000) + 10000;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(string);
        stringBuffer.append(counter++);
        stringBuffer.append(string2);
        return new File(file, stringBuffer.toString());
    }

    byte[] properPath(boolean bl) {
        if (this.properPath != null) {
            return this.properPath;
        }
        byte[] byArray = Util.getBytes(this.path);
        if (this.isAbsoluteImpl(byArray)) {
            this.properPath = byArray;
            return byArray;
        }
        String string = bl ? (String)AccessController.doPrivileged(new PriviAction("user.dir")) : System.getProperty("user.dir");
        this.properPath = File.properPathImpl(byArray);
        if (this.properPath != null) {
            return this.properPath;
        }
        if (this.path.length() == 0) {
            this.properPath = Util.getBytes(string);
            return this.properPath;
        }
        int n = string.length();
        if (this.path.charAt(0) == '\\') {
            if (n > 1 && string.charAt(1) == ':') {
                this.properPath = Util.getBytes(new StringBuffer(String.valueOf(string.substring(0, 2))).append(this.path).toString());
                return this.properPath;
            }
            if (n > 0 && string.charAt(n - 1) == separatorChar) {
                this.properPath = Util.getBytes(new StringBuffer(String.valueOf(string)).append(this.path.substring(1)).toString());
                return this.properPath;
            }
            this.properPath = Util.getBytes(new StringBuffer(String.valueOf(string)).append(this.path).toString());
            return this.properPath;
        }
        if (n > 0 && string.charAt(n - 1) == separatorChar) {
            this.properPath = Util.getBytes(new StringBuffer(String.valueOf(string)).append(this.path).toString());
            return this.properPath;
        }
        this.properPath = Util.getBytes(new StringBuffer(String.valueOf(string)).append(separator).append(this.path).toString());
        return this.properPath;
    }

    private static native byte[] properPathImpl(byte[] byArray) {
    }

    public boolean renameTo(File file) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkWrite(this.path);
            securityManager.checkWrite(file.path);
        }
        return this.renameToImpl(this.properPath(true), file.properPath(true));
    }

    private native boolean renameToImpl(byte[] byArray, byte[] byArray2) {
    }

    public String toString() {
        return this.path.toString();
    }

    public URI toURI() {
        String string = this.getAbsoluteName();
        try {
            if (!string.startsWith("/")) {
                return new URI("file", null, new StringBuffer(string.length() + 1).append('/').append(string).toString(), null, null);
            }
            if (string.startsWith("//")) {
                return new URI("file", string, null);
            }
            return new URI("file", null, string, null, null);
        }
        catch (URISyntaxException uRISyntaxException) {
            return null;
        }
    }

    public URL toURL() {
        String string = this.getAbsoluteName();
        if (!string.startsWith("/")) {
            return new URL("file", "", -1, new StringBuffer(string.length() + 1).append('/').append(string).toString(), null);
        }
        if (string.startsWith("//")) {
            return new URL(new StringBuffer("file:").append(string).toString());
        }
        return new URL("file", "", -1, string, null);
    }

    private String getAbsoluteName() {
        String string = this.getAbsolutePath();
        if (this.isDirectory() && string.charAt(string.length() - 1) != separatorChar) {
            string = new StringBuffer(string.length() + 1).append(string).append('/').toString();
        }
        if (separatorChar != '/') {
            string = string.replace(separatorChar, '/');
        }
        return string;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeChar(separatorChar);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        char c2 = objectInputStream.readChar();
        this.path = this.path.replace(c2, separatorChar);
    }
}

