/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.microdoc.objectreader.MCFObjectReader
 *  com.microdoc.util.ObjectSwapper
 */
package de.eso.mib;

import com.microdoc.j9.xip.FileSPI;
import com.microdoc.objectreader.MCFObjectReader;
import com.microdoc.util.ObjectSwapper;
import com.sun.gluegen.runtime.BufferFactory;
import de.eso.mib.MIF;
import de.vw.mib.file.spi.ContentChunk;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.HashMap;

public class FileSPIImpl
implements de.vw.mib.file.spi.FileSPI {
    public static boolean CREATE_DEBUG_OUTPUT = false;
    public static String VW_ABS_PATH_PREFIX = null;
    private FileSPI spi = null;
    private static FileSPIImpl instance = null;
    int mcfCounter = 0;
    HashMap mcfmap = new HashMap();

    public FileSPIImpl() {
        this.spi = new FileSPI();
    }

    @Override
    public File getFileForRelativePath(String string) {
        if (CREATE_DEBUG_OUTPUT) {
            System.out.println(">>FileSPI::getFileForRelativePath");
        }
        return new File(new StringBuffer().append(VW_ABS_PATH_PREFIX).append(string).toString());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object[] readDataFromObjectSwapperFile(File file) {
        ObjectSwapper objectSwapper = new ObjectSwapper();
        try {
            objectSwapper.open(file);
            Object[] objectArray = objectSwapper.linkAll();
            return objectArray;
        }
        finally {
            try {
                objectSwapper.close();
            }
            catch (Exception exception) {}
        }
    }

    @Override
    public ClassLoader createClassLoader(URL[] uRLArray) {
        return this.spi.createClassLoader(uRLArray);
    }

    @Override
    public void destroyClassloader(ClassLoader classLoader) {
        this.spi.destroyClassloader(classLoader);
    }

    @Override
    public Class loadClass(ClassLoader classLoader, String string) {
        return this.spi.loadClass(classLoader, string);
    }

    @Override
    public void loadXIPContainer(ClassLoader classLoader, String string) {
        this.spi.loadXIPContainer(classLoader, string);
    }

    @Override
    public void unloadXIPContainer(ClassLoader classLoader, String string) {
        this.spi.unloadXIPContainer(classLoader, string);
    }

    @Override
    public String[] getLoadedXIPContainer(ClassLoader classLoader) {
        return this.spi.getLoadedXIPContainer(classLoader);
    }

    @Override
    public synchronized int openContentFile(String string, int n, boolean bl) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1);
        long l = MIF.openMCF(string, n, bl ? 1 : 0, byteBuffer);
        byte by = byteBuffer.get(0);
        if (by == 3) {
            throw new IllegalArgumentException(new StringBuffer().append("MCF file ").append(string).append("does not have contentVersion ").append(n).toString());
        }
        if (by != 0) {
            throw new IOException(new StringBuffer().append("MCF File error ").append(by).toString());
        }
        ++this.mcfCounter;
        this.mcfmap.put(new Integer(this.mcfCounter), new Long(l));
        return this.mcfCounter;
    }

    @Override
    public synchronized void closeContentFile(int n) {
        Long l = (Long)this.mcfmap.get(new Integer(n));
        if (l == null) {
            throw new IllegalArgumentException(new StringBuffer().append("contentFileID ").append(n).append(" not valid").toString());
        }
        MIF.closeMCF(l);
        this.mcfmap.remove(new Integer(n));
    }

    @Override
    public synchronized int[] getFilteredTOCFromContentFile(int n, int n2) {
        Long l = (Long)this.mcfmap.get(new Integer(n));
        if (l == null) {
            throw new IllegalArgumentException(new StringBuffer().append("contentFileID ").append(n).append(" not valid").toString());
        }
        int n3 = MIF.getChunkIDs(l, n2, 0, null);
        int[] nArray = new int[n3];
        MIF.getChunkIDs(l, n2, n3, nArray, 0);
        return nArray;
    }

    public synchronized int[] getChunkTypesFromContentFile(int n) {
        Long l = (Long)this.mcfmap.get(new Integer(n));
        if (l == null) {
            throw new IllegalArgumentException(new StringBuffer().append("contentFileID ").append(n).append(" not valid").toString());
        }
        int n2 = MIF.getChunkTypes(l, 0, null);
        int[] nArray = new int[n2];
        MIF.getChunkTypes(l, n2, nArray, 0);
        return nArray;
    }

    @Override
    public ContentChunk loadChunkFromContentFile(int n, int n2, int n3, boolean bl) {
        return this.loadChunkFromContentFile(n, n2, n3, bl, false);
    }

    public synchronized ContentChunk loadChunkFromContentFile(int n, int n2, int n3, boolean bl, boolean bl2) {
        Object object;
        Long l = (Long)this.mcfmap.get(new Integer(n));
        if (l == null) {
            throw new IllegalArgumentException(new StringBuffer().append("contentFileID ").append(n).append(" not valid").toString());
        }
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1);
        long l2 = MIF.loadChunk(l, n2, n3, byteBuffer);
        if (l2 == 0L) {
            byte by = byteBuffer.get(0);
            if (by == 1) {
                throw new IOException(new StringBuffer().append("Chunk id ").append(n3).append(" does not exist").toString());
            }
            throw new IOException(new StringBuffer().append("Chunk id ").append(n3).append(" cannot be read status ").append(by).toString());
        }
        IntBuffer intBuffer = ByteBuffer.allocateDirect(4).order(ByteOrder.nativeOrder()).asIntBuffer();
        ByteBuffer byteBuffer2 = MIF.getChunkData(l2, 1, intBuffer);
        ByteBuffer byteBuffer3 = MIF.getChunkData(l2, 0, intBuffer);
        MIF.releaseChunk(l2);
        if (byteBuffer2 != null && !bl2) {
            object = new byte[byteBuffer2.capacity()];
            byteBuffer2.get((byte[])object);
            byteBuffer2 = ByteBuffer.wrap(object);
            byteBuffer2.order(ByteOrder.nativeOrder());
        }
        if (byteBuffer3 == null) {
            if (bl) {
                byteBuffer3 = ByteBuffer.allocateDirect(0);
            } else {
                object = new byte[]{};
                byteBuffer3 = ByteBuffer.wrap(object);
            }
            byteBuffer3.order(ByteOrder.nativeOrder());
        } else if (!bl) {
            object = new byte[byteBuffer3.capacity()];
            byteBuffer3.get((byte[])object);
            byteBuffer3 = ByteBuffer.wrap(object);
            byteBuffer3.order(ByteOrder.nativeOrder());
        }
        object = new ContentChunk(n3, n2, byteBuffer2, byteBuffer3);
        return object;
    }

    @Override
    public void releaseChunk(ContentChunk contentChunk) {
        if (contentChunk == null) {
            return;
        }
        if (contentChunk.header != null) {
            BufferFactory.dispose(contentChunk.header);
        }
        if (contentChunk.data != null) {
            BufferFactory.dispose(contentChunk.data);
        }
    }

    @Override
    public Object[] loadObjectArrayFromContentFile(int n, int n2) {
        int n3 = 1329744449;
        ContentChunk contentChunk = this.loadChunkFromContentFile(n, n3, n2, true, true);
        if (contentChunk == null) {
            throw new IllegalArgumentException(new StringBuffer().append("Object array id ").append(n2).append(" does not exist").toString());
        }
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(contentChunk.getHeader().capacity() + contentChunk.getData().capacity()).order(ByteOrder.nativeOrder());
        byteBuffer.put(contentChunk.getHeader());
        byteBuffer.put(contentChunk.getData());
        byteBuffer.rewind();
        this.releaseChunk(contentChunk);
        Object[] objectArray = MCFObjectReader.linkAll((ByteBuffer)byteBuffer);
        BufferFactory.dispose(byteBuffer);
        return objectArray;
    }

    public static synchronized FileSPIImpl getInstance() {
        if (instance == null) {
            instance = new FileSPIImpl();
        }
        return instance;
    }

    static {
        System.loadLibrary("mifinator");
        VW_ABS_PATH_PREFIX = System.getProperty("spi.resourcepath");
        if (VW_ABS_PATH_PREFIX == null) {
            VW_ABS_PATH_PREFIX = new String("/eso/hmi/lsd/Resources/");
        } else if (!VW_ABS_PATH_PREFIX.endsWith("/")) {
            VW_ABS_PATH_PREFIX = new StringBuffer().append(VW_ABS_PATH_PREFIX).append("/").toString();
        }
    }
}

