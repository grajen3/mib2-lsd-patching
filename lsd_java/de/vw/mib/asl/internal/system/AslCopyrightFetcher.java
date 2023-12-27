/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.list.ASLCachedWindowList;
import de.vw.mib.asl.internal.list.ASLListElementFetcher;
import de.vw.mib.asl.internal.list.impl.ASLListItemDummyCacheImpl;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.system.AslTargetSystemGeneral;
import de.vw.mib.file.FileManager;
import generated.de.vw.mib.asl.internal.ListManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import org.osgi.framework.BundleContext;

final class AslCopyrightFetcher
implements ASLListElementFetcher {
    private static final String LOGGING_DELIM;
    AslTargetSystemGeneral myTarget;
    private int[] filePointers = null;
    private int totalLineCount = 0;
    private static final int WINDOW_SIZE;
    private static final int WINDOW_FETCH_OFFSET;
    private static final int WINDOW_FETCH_LIMIT;
    private static final boolean USE_FULL_LISTSIZE_INITIALLY;
    private int maxFetchedWindow = 0;
    private int maxListSize = 0;
    private RandomAccessFile raf = null;
    private GenericASLList copyrightList = null;
    static /* synthetic */ Class class$de$vw$mib$file$FileManager;

    AslCopyrightFetcher(AslTargetSystemGeneral aslTargetSystemGeneral) {
        this.myTarget = aslTargetSystemGeneral;
        if (this.myTarget.isTraceEnabled()) {
            this.myTarget.trace().append("[AslCopyrightFetcher] ").append("Constructor (enter)! loading index file").log();
        }
        this.readFromSwapper();
        File file = new File(this.myTarget.copyrightPath);
        if (file.exists()) {
            try {
                int n;
                this.raf = new RandomAccessFile(file, "r");
                this.copyrightList = ListManager.getGenericASLList(3495);
                this.copyrightList.disableWindowing();
                this.copyrightList.enableWindowing(new ASLListItemDummyCacheImpl(), this, 20, 1);
                this.maxListSize = n = this.totalLineCount;
                this.maxFetchedWindow = this.maxListSize / 20;
                if (this.myTarget.isTraceEnabled()) {
                    this.myTarget.trace().append("[AslCopyrightFetcher] ").append("Set Copyrightlist to initial size: ").append(n).log();
                }
                this.copyrightList.setSize(n);
            }
            catch (FileNotFoundException fileNotFoundException) {
                this.myTarget.error(fileNotFoundException);
            }
        } else {
            this.myTarget.error().append("[AslCopyrightFetcher] ").append("File ").append(this.myTarget.copyrightPath).append(" does not exist!").log();
        }
        if (this.myTarget.isTraceEnabled()) {
            this.myTarget.trace().append("[AslCopyrightFetcher] ").append("Constructor (exit)").log();
        }
    }

    @Override
    public void fetchItems(ASLCachedWindowList aSLCachedWindowList, int n, int n2) {
        if (this.myTarget.isTraceEnabled()) {
            this.myTarget.trace().append("[AslCopyrightFetcher] ").append("fetchItems index ").append(n).log();
        }
        Object[] objectArray = this.getWindow(n, n2);
        aSLCachedWindowList.updateListItems(n, objectArray);
    }

    @Override
    public void fetchNextPage(ASLCachedWindowList aSLCachedWindowList, Object object, int n, int n2) {
        this.fetchItems(aSLCachedWindowList, n, n2);
    }

    @Override
    public void fetchPreviousPage(ASLCachedWindowList aSLCachedWindowList, Object object, int n, int n2) {
        this.fetchItems(aSLCachedWindowList, n, n2);
    }

    void close() {
        if (this.copyrightList != null) {
            this.copyrightList.setSize(0);
        }
        if (this.raf != null) {
            try {
                this.raf.close();
            }
            catch (IOException iOException) {
                this.myTarget.error(iOException);
            }
        }
        this.filePointers = null;
        this.totalLineCount = 0;
    }

    private void readFromSwapper() {
        BundleContext bundleContext = ServiceManager.bundleContext;
        FileManager fileManager = (FileManager)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$file$FileManager == null ? (class$de$vw$mib$file$FileManager = AslCopyrightFetcher.class$("de.vw.mib.file.FileManager")) : class$de$vw$mib$file$FileManager).getName()));
        if (fileManager == null) {
            this.myTarget.error().append("[AslCopyrightFetcher] ").append("Service 'de.vw.mib.file.spi.FileManager' not available.").log();
        } else {
            File file = new File(this.myTarget.copyrightIndexPath);
            if (file.exists()) {
                try {
                    Object[] objectArray = fileManager.readDataFromObjectSwapperFile(file);
                    this.filePointers = (int[])objectArray[0];
                    this.totalLineCount = this.filePointers[this.filePointers.length - 1];
                    if (this.myTarget.isTraceEnabled()) {
                        this.myTarget.trace().append("[AslCopyrightFetcher] ").append("readFromSwapper:  number of windows read: ").append(this.filePointers.length - 1).log();
                        this.myTarget.trace().append("[AslCopyrightFetcher] ").append("readFromSwapper:  total number of lines: ").append(this.totalLineCount).log();
                    }
                }
                catch (IOException iOException) {
                    this.myTarget.error(iOException);
                }
            } else {
                this.myTarget.error().append("[AslCopyrightFetcher] ").append("File ").append(this.myTarget.copyrightIndexPath).append(" does not exist!").log();
            }
        }
    }

    private String[] getWindow(int n, int n2) {
        String[] stringArray = new String[n2];
        if (this.raf != null) {
            try {
                if (n > this.totalLineCount - n2) {
                    this.myTarget.error().append("[AslCopyrightFetcher] ").append("getWindow linenumber too high: ").append(n).log();
                } else {
                    String string;
                    this.raf.seek(this.filePointers[n / 20]);
                    for (int i2 = 0; i2 < n2 && (string = this.raf.readLine()) != null; ++i2) {
                        stringArray[i2] = string;
                    }
                }
            }
            catch (IOException iOException) {
                this.myTarget.error(iOException);
            }
        }
        return stringArray;
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

