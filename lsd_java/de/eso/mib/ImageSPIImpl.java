/*
 * Decompiled with CFR 0.152.
 */
package de.eso.mib;

import com.sun.gluegen.runtime.BufferFactory;
import com.sun.gluegen.runtime.StructAccessor;
import de.eso.mib.FileSPIImpl;
import de.eso.mib.ImageHeaderInfo;
import de.eso.mib.ImageInfo;
import de.eso.mib.MIF;
import de.eso.mib.MIFImageInfo;
import de.eso.mib.SPI;
import de.eso.mib.StateInfo;
import de.vw.mib.file.spi.ContentChunk;
import de.vw.mib.graphics.image.spi.ImageSPI;
import de.vw.mib.graphics.image.spi.NativeImage;
import de.vw.mib.graphics.image.spi.NativeImageHeader;
import de.vw.mib.graphics.image.spi.NativeImageLoadingListener;
import de.vw.mib.graphics.image.spi.NativeInvalidImageFormatException;
import de.vw.mib.graphics.image.spi.NativeUnsupportedImageTypeException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import org.dsi.ifc.global.ResourceLocator;

public class ImageSPIImpl
implements ImageSPI {
    public static boolean CREATE_DEBUG_OUTPUT = false;
    public static boolean FAKE_MODE = false;
    public static boolean CREATE_FUNCTION_TRACES = false;
    public static boolean USE_MCF = true;
    public static String VW_RESOURCE_PATH_PREFIX = null;
    public static String VW_RESOURCE_PATH_PREFIX_2 = new String("/Images/");
    public static final int HAS_EXIF;
    public static final int HAS_THUMBNAIL;
    private int MIF_currentSkin = -1;
    private boolean renderthreadidtaken = false;
    private HashMap mifNames = new HashMap();
    private HashMap openMCFs = new HashMap();
    private static int NLBL_DIMS;
    int EXIF_IFD_0 = 0;
    int EXIF_IFD_1 = 1;
    int EXIF_IFD_EXIF = 2;
    int EXIF_IFD_GPS = 3;
    static /* synthetic */ Class class$de$eso$mib$SPI;

    public synchronized void initNative() {
        SPI.init_native();
        if (!FAKE_MODE) {
            SPI.imagespi_init();
            SPI.image_set_nlbl_dims(NLBL_DIMS);
        }
    }

    public synchronized void uninitNative() {
        if (!FAKE_MODE) {
            SPI.imagespi_deinit();
        }
        SPI.uninit_native();
    }

    public void setMultiImageFileForSkin(int n, String string) {
        if (USE_MCF) {
            int n2 = string.indexOf(".mif");
            String string2 = null;
            string2 = n2 != -1 ? new StringBuffer().append(string.substring(0, n2)).append(".mcf").toString() : string;
            this.setContentFileForSkin(n, string2);
        } else {
            this.mifNames.put(new Integer(n), string);
            if (this.MIF_currentSkin == n) {
                this.MIF_currentSkin = -2;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void setContentFileForSkin(int n, String string) {
        if (USE_MCF) {
            HashMap hashMap = this.openMCFs;
            synchronized (hashMap) {
                Integer n2 = (Integer)this.openMCFs.get(new Integer(n));
                if (n2 != null) {
                    try {
                        FileSPIImpl.getInstance().closeContentFile(n2);
                    }
                    catch (IOException iOException) {
                        // empty catch block
                    }
                }
                try {
                    int n3 = FileSPIImpl.getInstance().openContentFile(new StringBuffer().append(VW_RESOURCE_PATH_PREFIX).append(n).append("/").append(string).toString(), -1, false);
                    this.openMCFs.put(new Integer(n), new Integer(n3));
                }
                catch (IOException iOException) {
                    throw new IllegalArgumentException(new StringBuffer().append("Cannot set MCF ").append(string).append(" for skin ").append(n).toString());
                }
            }
        }
        int n4 = string.indexOf(".mcf");
        String string2 = null;
        string2 = n4 != -1 ? new StringBuffer().append(string.substring(0, n4)).append(".mif").toString() : string;
        this.setMultiImageFileForSkin(n, string2);
    }

    @Override
    public synchronized NativeImage loadImageFromSkin(int n, int n2) {
        ByteBuffer byteBuffer;
        Object object;
        if (CREATE_FUNCTION_TRACES) {
            System.out.println(new StringBuffer().append("eso::ImageSPI loadImageFromSkin enter ").append(n).append(" ").append(n2).toString());
        }
        if (FAKE_MODE) {
            ByteBuffer byteBuffer2 = ByteBuffer.allocateDirect(3840);
            byteBuffer2.rewind();
            int n3 = 3840;
            for (int i2 = 0; i2 < n3; ++i2) {
                byteBuffer2.put(i2, (byte)-16);
            }
            byteBuffer2.rewind();
            return new NativeImage(byteBuffer2, 40, 24, 7);
        }
        if (USE_MCF) {
            int n4;
            Integer n5;
            if (!this.renderthreadidtaken) {
                SPI.image_save_threadid();
                this.renderthreadidtaken = true;
            }
            if ((n5 = (Integer)this.openMCFs.get(new Integer(n))) == null) {
                n4 = FileSPIImpl.getInstance().openContentFile(new StringBuffer().append(VW_RESOURCE_PATH_PREFIX).append(n).append("/").append("images.mcf").toString(), -1, false);
                this.openMCFs.put(new Integer(n), new Integer(n4));
            } else {
                n4 = n5;
            }
            int n6 = 1229801248;
            ContentChunk contentChunk = FileSPIImpl.getInstance().loadChunkFromContentFile(n4, n6, n2, true, true);
            if (contentChunk == null) {
                throw new IllegalArgumentException(new StringBuffer().append("Image id ").append(n2).append(" does not exist").toString());
            }
            StructAccessor structAccessor = new StructAccessor(contentChunk.getHeader());
            short s = structAccessor.getShortAt(0);
            short s2 = structAccessor.getShortAt(1);
            short s3 = structAccessor.getShortAt(2);
            byte by = structAccessor.getByteAt(6);
            NativeImage nativeImage = new NativeImage(contentChunk.getData(), s, s2, s3, by == 2);
            if (CREATE_FUNCTION_TRACES) {
                System.out.println("eso::ImageSPI loadImageFromSkin exit");
            }
            return nativeImage;
        }
        if (this.MIF_currentSkin == -1) {
            SPI.image_save_threadid();
            this.renderthreadidtaken = true;
            try {
                System.loadLibrary("mifinator");
            }
            catch (Exception exception) {
                throw new IOException("Cannot load mifinator or one of its dependent libraries");
            }
        }
        if (this.MIF_currentSkin != n) {
            this.MIF_currentSkin = n;
            MIF.closeMIF();
            object = (String)this.mifNames.get(new Integer(n));
            if (object == null) {
                object = "images.mif";
            }
            if (MIF.openMIF(new StringBuffer().append(VW_RESOURCE_PATH_PREFIX).append(n).append("/").append((String)object).toString()) <= 0) {
                System.out.println(new StringBuffer().append("ImageSPI::loadImageFromSkin: cannot find ").append(VW_RESOURCE_PATH_PREFIX).append(n).append("/").append((String)object).toString());
                throw new IOException("cannot open images.mif");
            }
        }
        if ((byteBuffer = MIF.getImage(n2, (MIFImageInfo)(object = MIFImageInfo.create()))) == null) {
            switch (((MIFImageInfo)object).state()) {
                case -1: {
                    throw new IllegalArgumentException("Invalid image id");
                }
                case -2: {
                    throw new IOException("Out of memory");
                }
            }
        }
        int n7 = 0;
        switch (((MIFImageInfo)object).format()) {
            case 1: {
                n7 = 4096;
                break;
            }
            case 3: {
                n7 = 4355;
                break;
            }
            case 4: {
                n7 = 4356;
            }
        }
        NativeImage nativeImage = new NativeImage(byteBuffer, ((MIFImageInfo)object).width(), ((MIFImageInfo)object).height(), n7);
        if (CREATE_FUNCTION_TRACES) {
            System.out.println("eso::ImageSPI loadImageFromSkin exit");
        }
        return nativeImage;
    }

    @Override
    public NativeImage loadImageFromSkin(int n, String string) {
        if (CREATE_FUNCTION_TRACES) {
            System.out.println(new StringBuffer().append("eso::ImageSPI loadImageFromSkin enter ").append(n).append(" ").append(string).toString());
        }
        string = new StringBuffer().append(VW_RESOURCE_PATH_PREFIX).append(n).append(VW_RESOURCE_PATH_PREFIX_2).append(string).toString();
        if (CREATE_DEBUG_OUTPUT) {
            System.out.println(new StringBuffer().append(">>loadImageFromSkin( ").append(string).append(" )").toString());
        }
        if (!this.renderthreadidtaken) {
            if (!FAKE_MODE) {
                SPI.image_save_threadid();
            }
            this.renderthreadidtaken = true;
        }
        NativeImage nativeImage = this.loadImageFromFile(string, 1, null);
        if (CREATE_FUNCTION_TRACES) {
            System.out.println("eso::ImageSPI loadImageFromSkin exit");
        }
        return nativeImage;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public NativeImageHeader getImageHeaderFromFile(int n) {
        if (CREATE_FUNCTION_TRACES) {
            System.out.println(new StringBuffer().append("eso::ImageSPI getImageHeaderFromFile enter ").append(n).toString());
        }
        if (FAKE_MODE) {
            return new NativeImageHeader(4, 40, 24, 4, 3840, false, false);
        }
        if (CREATE_DEBUG_OUTPUT) {
            System.out.println(new StringBuffer().append(">>getImageHeaderFromFile( ").append(n).append(" )").toString());
        }
        ImageHeaderInfo imageHeaderInfo = ImageHeaderInfo.create();
        Object object = class$de$eso$mib$SPI == null ? (class$de$eso$mib$SPI = ImageSPIImpl.class$("de.eso.mib.SPI")) : class$de$eso$mib$SPI;
        synchronized (object) {
            SPI.image_header_get_from_id(n, imageHeaderInfo);
        }
        if (CREATE_DEBUG_OUTPUT && imageHeaderInfo.state() != 0) {
            System.out.println(new StringBuffer().append(">>getImageHeaderFromFile returned state ").append(imageHeaderInfo.state()).toString());
        }
        if (CREATE_FUNCTION_TRACES && imageHeaderInfo.state() != 0) {
            System.out.println("eso::ImageSPI getImageHeaderFromFile throw exception");
        }
        this.raiseException(imageHeaderInfo.state(), String.valueOf(n));
        object = new NativeImageHeader(imageHeaderInfo.type(), imageHeaderInfo.width(), imageHeaderInfo.height(), imageHeaderInfo.depth(), imageHeaderInfo.size(), (imageHeaderInfo.attribs() & 1) != 0, (imageHeaderInfo.attribs() & 2) != 0);
        if (CREATE_FUNCTION_TRACES) {
            System.out.println("eso::ImageSPI getImageHeaderFromFile exit");
        }
        return object;
    }

    public NativeImageHeader getImageHeaderFromFile(String string) {
        if (CREATE_FUNCTION_TRACES) {
            System.out.println(new StringBuffer().append("eso::ImageSPI getImageHeaderFromFile enter ").append(string).toString());
        }
        if (FAKE_MODE) {
            return new NativeImageHeader(4, 400, 240, 4, 14419200, false, false);
        }
        string = string.replace('\\', '/');
        if (CREATE_DEBUG_OUTPUT) {
            System.out.println(new StringBuffer().append(">>getImageHeaderFromFile( ").append(string).append(" )").toString());
        }
        ImageHeaderInfo imageHeaderInfo = ImageHeaderInfo.create();
        SPI.image_header_get(string, imageHeaderInfo);
        if (CREATE_DEBUG_OUTPUT && imageHeaderInfo.state() != 0) {
            System.out.println(new StringBuffer().append(">>getImageHeaderFromFile returned state ").append(imageHeaderInfo.state()).toString());
        }
        if (CREATE_FUNCTION_TRACES && imageHeaderInfo.state() != 0) {
            System.out.println("eso::ImageSPI getImageHeaderFromFile throw exception");
        }
        this.raiseException(imageHeaderInfo.state(), string);
        NativeImageHeader nativeImageHeader = new NativeImageHeader(imageHeaderInfo.type(), imageHeaderInfo.width(), imageHeaderInfo.height(), imageHeaderInfo.depth(), imageHeaderInfo.size(), (imageHeaderInfo.attribs() & 1) != 0, (imageHeaderInfo.attribs() & 2) != 0);
        if (CREATE_FUNCTION_TRACES) {
            System.out.println("eso::ImageSPI getImageHeaderFromFile exit");
        }
        return nativeImageHeader;
    }

    @Override
    public NativeImageHeader getImageHeaderFromResource(ResourceLocator resourceLocator) {
        if (!resourceLocator.isIntResource()) {
            return this.getImageHeaderFromFile(resourceLocator.getUrl());
        }
        return this.getImageHeaderFromFile(resourceLocator.getId());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public NativeImage loadImageFromFile(int n, int n2, NativeImageLoadingListener nativeImageLoadingListener) {
        if (CREATE_FUNCTION_TRACES) {
            System.out.println(new StringBuffer().append("eso::ImageSPI loadImageFromFile enter ").append(n).append(" ").append(n2).toString());
        }
        ImageInfo imageInfo = ImageInfo.create();
        ByteBuffer byteBuffer = null;
        if (FAKE_MODE) {
            ByteBuffer byteBuffer2 = ByteBuffer.allocateDirect(3840);
            byteBuffer2.rewind();
            int n3 = 3840;
            for (int i2 = 0; i2 < n3; ++i2) {
                byteBuffer2.put(i2, (byte)-16);
            }
            byteBuffer2.rewind();
            return new NativeImage(byteBuffer2, 40, 24, 7);
        }
        Object object = class$de$eso$mib$SPI == null ? (class$de$eso$mib$SPI = ImageSPIImpl.class$("de.eso.mib.SPI")) : class$de$eso$mib$SPI;
        synchronized (object) {
            byteBuffer = SPI.image_load_from_id(n, imageInfo);
        }
        if (CREATE_DEBUG_OUTPUT) {
            System.out.println(new StringBuffer().append("loadImageFromFile: state=").append(imageInfo.state()).toString());
        }
        if (CREATE_FUNCTION_TRACES && imageInfo.state() < 0) {
            System.out.println("eso::ImageSPI loadImageFromFile throw exception");
        }
        this.raiseException(imageInfo.state(), String.valueOf(n));
        if (byteBuffer == null) {
            throw new IOException();
        }
        byteBuffer.rewind();
        if (CREATE_DEBUG_OUTPUT) {
            System.out.println(new StringBuffer().append(">>loadImageFromFile format=").append(imageInfo.format()).toString());
            System.out.println(new StringBuffer().append(">>loadImageFromFile w,h=").append(imageInfo.width()).append(",").append(imageInfo.height()).toString());
            System.out.println(new StringBuffer().append(">>loadImageFromFile buf.size=").append(byteBuffer.capacity()).toString());
        }
        object = new NativeImage(byteBuffer, imageInfo.width(), imageInfo.height(), imageInfo.format(), imageInfo.opaque() == 1);
        if (CREATE_FUNCTION_TRACES) {
            System.out.println("eso::ImageSPI loadImageFromFile exit");
        }
        return object;
    }

    public NativeImage loadImageFromFile(String string, int n, NativeImageLoadingListener nativeImageLoadingListener) {
        if (CREATE_FUNCTION_TRACES) {
            System.out.println(new StringBuffer().append("eso::ImageSPI loadImageFromFile enter ").append(string).append(" ").append(n).toString());
        }
        if (FAKE_MODE) {
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(14419200);
            byteBuffer.rewind();
            int n2 = 14419200;
            for (int i2 = 0; i2 < n2; ++i2) {
                byteBuffer.put(i2, (byte)-128);
            }
            byteBuffer.rewind();
            return new NativeImage(byteBuffer, 400, 240, 7);
        }
        string = string.replace('\\', '/');
        if (CREATE_DEBUG_OUTPUT) {
            System.out.println(new StringBuffer().append(">>loadImageFromFile( ").append(string).append(", ").append(n).append(" )").toString());
        }
        ImageInfo imageInfo = ImageInfo.create();
        ByteBuffer byteBuffer = null;
        byteBuffer = SPI.image_load(string, n, imageInfo, nativeImageLoadingListener);
        if (CREATE_DEBUG_OUTPUT) {
            System.out.println(new StringBuffer().append("loadImageFromFile: state=").append(imageInfo.state()).toString());
        }
        if (CREATE_FUNCTION_TRACES && imageInfo.state() < 0) {
            System.out.println("eso::ImageSPI loadImageFromFile throw exception");
        }
        this.raiseException(imageInfo.state(), string);
        if (byteBuffer == null) {
            throw new IOException();
        }
        byteBuffer.rewind();
        if (CREATE_DEBUG_OUTPUT) {
            System.out.println(new StringBuffer().append(">>loadImageFromFile format=").append(imageInfo.format()).toString());
            System.out.println(new StringBuffer().append(">>loadImageFromFile w,h=").append(imageInfo.width()).append(",").append(imageInfo.height()).toString());
            System.out.println(new StringBuffer().append(">>loadImageFromFile buf.size=").append(byteBuffer.capacity()).toString());
        }
        NativeImage nativeImage = new NativeImage(byteBuffer, imageInfo.width(), imageInfo.height(), imageInfo.format(), imageInfo.opaque() == 1);
        if (CREATE_FUNCTION_TRACES) {
            System.out.println("eso::ImageSPI loadImageFromFile exit");
        }
        return nativeImage;
    }

    @Override
    public NativeImage loadImageFromResource(ResourceLocator resourceLocator, int n, NativeImageLoadingListener nativeImageLoadingListener) {
        if (!resourceLocator.isIntResource()) {
            return this.loadImageFromFile(resourceLocator.getUrl(), n, nativeImageLoadingListener);
        }
        return this.loadImageFromFile(resourceLocator.getId(), n, nativeImageLoadingListener);
    }

    public NativeImage loadImageRegionFromFile(int n, int n2, int n3, int n4, int n5, NativeImageLoadingListener nativeImageLoadingListener) {
        System.out.println("ImageSPI::loadImageRegionFromFile with int fileId NOT IMPLEMENTED");
        return null;
    }

    public NativeImage loadImageRegionFromFile(String string, int n, int n2, int n3, int n4, NativeImageLoadingListener nativeImageLoadingListener) {
        if (CREATE_FUNCTION_TRACES) {
            System.out.println(new StringBuffer().append("eso::ImageSPI loadImageRegionFromFile enter ").append(string).append(" ").append(n).append(" ").append(n2).append(" ").append(n3).append(" ").append(n4).toString());
        }
        NativeImage nativeImage = this.loadImageFromFile(string, 1, nativeImageLoadingListener);
        int n5 = 1;
        switch (nativeImage.getFormat()) {
            case 4096: {
                n5 = 1;
                break;
            }
            case 4097: 
            case 4098: 
            case 4352: 
            case 4354: {
                n5 = 2;
                break;
            }
            case 4355: {
                n5 = 3;
                break;
            }
            case 4356: {
                n5 = 4;
            }
        }
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(n3 * n4 * n5);
        byteBuffer.rewind();
        ByteBuffer byteBuffer2 = nativeImage.getBuffer();
        for (int i2 = 0; i2 < n4; ++i2) {
            for (int i3 = 0; i3 < n3 * n5; ++i3) {
                byteBuffer.put(i2 * n3 * n5 + i3, byteBuffer2.get((i2 + n2) * nativeImage.getWidth() * n5 + (i3 + n)));
            }
        }
        NativeImage nativeImage2 = new NativeImage(byteBuffer, n3, n4, nativeImage.getFormat(), nativeImage.isOpaque());
        if (CREATE_FUNCTION_TRACES) {
            System.out.println("eso::ImageSPI loadImageRegionFromFile exit");
        }
        return nativeImage2;
    }

    @Override
    public NativeImage loadImageRegionFromResource(ResourceLocator resourceLocator, int n, int n2, int n3, int n4, NativeImageLoadingListener nativeImageLoadingListener) {
        if (!resourceLocator.isIntResource()) {
            return this.loadImageRegionFromFile(resourceLocator.getUrl(), n, n2, n3, n4, nativeImageLoadingListener);
        }
        return this.loadImageRegionFromFile(resourceLocator.getId(), n, n2, n3, n4, nativeImageLoadingListener);
    }

    public NativeImage loadThumbnailImageFromFile(int n) {
        System.out.println("ImageSPI::loadThumbnailImageFromFile with int fileId NOT IMPLEMENTED");
        return null;
    }

    public NativeImage loadThumbnailImageFromFile(String string) {
        if (CREATE_FUNCTION_TRACES) {
            System.out.println(new StringBuffer().append("eso::ImageSPI loadTHumbnailImageFromFile enter ").append(string).toString());
        }
        if (FAKE_MODE) {
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(3840);
            byteBuffer.rewind();
            int n = 3840;
            for (int i2 = 0; i2 < n; ++i2) {
                byteBuffer.put(i2, (byte)-16);
            }
            byteBuffer.rewind();
            return new NativeImage(byteBuffer, 40, 24, 7);
        }
        ImageInfo imageInfo = ImageInfo.create();
        ByteBuffer byteBuffer = null;
        byteBuffer = SPI.image_thumbnail_load(string, imageInfo);
        if (CREATE_DEBUG_OUTPUT) {
            System.out.println(new StringBuffer().append("loadThumbnailImageFromFile: state=").append(imageInfo.state()).toString());
        }
        if (CREATE_FUNCTION_TRACES && imageInfo.state() < 0) {
            System.out.println("eso::ImageSPI loadImageFromFile throw exception");
        }
        this.raiseException(imageInfo.state(), string);
        if (byteBuffer == null) {
            throw new IOException();
        }
        byteBuffer.rewind();
        if (CREATE_DEBUG_OUTPUT) {
            System.out.println(new StringBuffer().append(">>loadThumbnailImageFromFile format=").append(imageInfo.format()).toString());
            System.out.println(new StringBuffer().append(">>loadThumbnailImageFromFile w,h=").append(imageInfo.width()).append(",").append(imageInfo.height()).toString());
            System.out.println(new StringBuffer().append(">>loadThumbnailImageFromFile buf.size=").append(byteBuffer.capacity()).toString());
        }
        NativeImage nativeImage = new NativeImage(byteBuffer, imageInfo.width(), imageInfo.height(), imageInfo.format(), imageInfo.opaque() == 1);
        if (CREATE_FUNCTION_TRACES) {
            System.out.println("eso::ImageSPI loadThumbnailImageFromFile exit");
        }
        return nativeImage;
    }

    @Override
    public NativeImage loadThumbnailImageFromResource(ResourceLocator resourceLocator) {
        if (!resourceLocator.isIntResource()) {
            return this.loadThumbnailImageFromFile(resourceLocator.getUrl());
        }
        return this.loadThumbnailImageFromFile(resourceLocator.getId());
    }

    public Map getExifFromFile(int n) {
        System.out.println("ImageSPI::getExifFromFile with int fileId NOT IMPLEMENTED");
        return null;
    }

    public Map getExifFromFile(String string) {
        if (CREATE_FUNCTION_TRACES) {
            System.out.println(new StringBuffer().append("eso::ImageSPI getExifFromFile enter ").append(string).toString());
        }
        HashMap hashMap = new HashMap();
        if (FAKE_MODE) {
            return hashMap;
        }
        StateInfo stateInfo = StateInfo.create();
        SPI.exif_data_get(string, hashMap, stateInfo, this.EXIF_IFD_0, null);
        this.raiseException(stateInfo.state(), string);
        SPI.exif_data_get(string, hashMap, stateInfo, this.EXIF_IFD_1, null);
        this.raiseException(stateInfo.state(), string);
        SPI.exif_data_get(string, hashMap, stateInfo, this.EXIF_IFD_EXIF, null);
        this.raiseException(stateInfo.state(), string);
        SPI.exif_data_get(string, hashMap, stateInfo, this.EXIF_IFD_GPS, null);
        this.raiseException(stateInfo.state(), string);
        if (CREATE_FUNCTION_TRACES) {
            System.out.println("eso::ImageSPI getExifFromFile exit");
        }
        return hashMap;
    }

    public Map getExifFromFile(String string, int n, int[] nArray) {
        if (CREATE_FUNCTION_TRACES) {
            System.out.println(new StringBuffer().append("eso::ImageSPI getExifFromFile enter ").append(string).toString());
        }
        HashMap hashMap = new HashMap();
        if (FAKE_MODE) {
            return hashMap;
        }
        StateInfo stateInfo = StateInfo.create();
        SPI.exif_data_get(string, hashMap, stateInfo, n, nArray);
        this.raiseException(stateInfo.state(), string);
        if (CREATE_FUNCTION_TRACES) {
            System.out.println("eso::ImageSPI getExifFromFile exit");
        }
        return hashMap;
    }

    public Map getExifFromResource(ResourceLocator resourceLocator) {
        if (!resourceLocator.isIntResource()) {
            return this.getExifFromFile(resourceLocator.getUrl());
        }
        return this.getExifFromFile(resourceLocator.getId());
    }

    @Override
    public Map getExifTagsFromResource(ResourceLocator resourceLocator, int n, int[] nArray) {
        if (!resourceLocator.isIntResource()) {
            return this.getExifFromFile(resourceLocator.getUrl(), n, nArray);
        }
        return this.getExifFromFile(resourceLocator.getId());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void saveImageToFile(String string, int n, NativeImage nativeImage) {
        if (CREATE_FUNCTION_TRACES) {
            System.out.println(new StringBuffer().append("eso::ImageSPI saveImageToFile enter ").append(string).append(" ").append(n).toString());
        }
        if (FAKE_MODE) {
            return;
        }
        ByteBuffer byteBuffer = null;
        byteBuffer = nativeImage.getBuffer();
        StateInfo stateInfo = StateInfo.create();
        Class clazz = class$de$eso$mib$SPI == null ? (class$de$eso$mib$SPI = ImageSPIImpl.class$("de.eso.mib.SPI")) : class$de$eso$mib$SPI;
        synchronized (clazz) {
            SPI.image_save_to_file(string, n, nativeImage.getWidth(), nativeImage.getHeight(), nativeImage.getFormat(), byteBuffer, stateInfo);
        }
        this.raiseException(stateInfo.state(), string);
        if (CREATE_FUNCTION_TRACES) {
            System.out.println("eso::ImageSPI saveImageToFile exit");
        }
    }

    @Override
    public void releaseImage(ByteBuffer byteBuffer) {
        BufferFactory.dispose(byteBuffer);
    }

    private void raiseException(int n, String string) {
        switch (n) {
            case 0: {
                break;
            }
            case -2: {
                throw new IllegalArgumentException();
            }
            case -3: {
                throw new FileNotFoundException(string);
            }
            case -4: {
                throw new IOException();
            }
            case -5: {
                throw new NativeInvalidImageFormatException();
            }
            case -6: {
                throw new NativeUnsupportedImageTypeException();
            }
            case -9: {
                throw new IllegalArgumentException();
            }
            case -10: {
                throw new IOException("Out of memory");
            }
        }
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
        NLBL_DIMS = 4096;
        System.loadLibrary("mibhighvwspi");
        CREATE_FUNCTION_TRACES = Boolean.getBoolean("spi.trace.image");
        VW_RESOURCE_PATH_PREFIX = System.getProperty("spi.resourcepath");
        if (VW_RESOURCE_PATH_PREFIX == null) {
            VW_RESOURCE_PATH_PREFIX = new String("/eso/hmi/lsd/Resources/skin");
        } else {
            if (!VW_RESOURCE_PATH_PREFIX.endsWith("/")) {
                VW_RESOURCE_PATH_PREFIX = new StringBuffer().append(VW_RESOURCE_PATH_PREFIX).append("/").toString();
            }
            VW_RESOURCE_PATH_PREFIX = new StringBuffer().append(VW_RESOURCE_PATH_PREFIX).append("skin").toString();
        }
        try {
            NLBL_DIMS = Integer.parseInt(System.getProperty("spi.image.nlbldims"));
        }
        catch (Exception exception) {
            // empty catch block
        }
        USE_MCF = !Boolean.getBoolean("spi.image.useMIF");
    }
}

