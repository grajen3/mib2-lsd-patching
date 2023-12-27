/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.image;

import de.vw.mib.cache.Cacheable;
import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.graphics.Referenceable;
import de.vw.mib.graphics.image.ImageFormat;
import de.vw.mib.util.StringBuilder;
import java.nio.ByteBuffer;

public final class BufferImage
implements Cacheable,
Referenceable {
    private static HashCodeBuilder hcb;
    private long id;
    private ByteBuffer buffer;
    private int width;
    private int height;
    private int imageFormat;
    private boolean opaque;
    private int hashCode;
    private boolean hashCodeValid;
    private int references;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$graphics$image$BufferImage;

    public BufferImage(long l, ByteBuffer byteBuffer, int n, int n2, int n3, boolean bl) {
        if (!($assertionsDisabled || n2 >= 0 && n3 >= 0)) {
            throw new AssertionError((Object)"Width and height must be nonnegative");
        }
        this.id = l;
        this.buffer = byteBuffer;
        this.width = n2;
        this.height = n3;
        this.imageFormat = n;
        this.opaque = bl;
        this.hashCodeValid = false;
        this.references = 1;
    }

    public BufferImage(long l, ByteBuffer byteBuffer, int n, int n2, int n3) {
        this(l, byteBuffer, n, n2, n3, false);
    }

    public int hashCode() {
        if (!this.hashCodeValid) {
            if (hcb == null) {
                hcb = new HashCodeBuilder();
            }
            hcb.reset();
            if (this.id != 0L) {
                hcb.append(this.id);
            } else {
                hcb.append(this.buffer);
            }
            hcb.append(this.width);
            hcb.append(this.height);
            hcb.append(this.imageFormat);
            this.hashCode = hcb.hashCode();
            this.hashCodeValid = true;
        }
        return this.hashCode;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object != null && super.getClass() == object.getClass()) {
            return this.hashCode() == ((BufferImage)object).hashCode();
        }
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[id=0x").append(Long.toHexString(this.id));
        stringBuilder.append(",width=").append(this.width);
        stringBuilder.append(",height=").append(this.height);
        stringBuilder.append(",imageFormat=0x").append(Integer.toHexString(this.imageFormat));
        stringBuilder.append(",opaque=").append(this.opaque);
        stringBuilder.append(",size=").append(this.getByteSize());
        stringBuilder.append(",references=").append(this.references);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public void dispose() {
        if (!$assertionsDisabled && this.references <= 0) {
            throw new AssertionError((Object)"BufferImage.dispose(): Reference count <= 0");
        }
        if (--this.references == 0 && this.buffer != null) {
            this.buffer = null;
        }
    }

    public long getId() {
        return this.id;
    }

    public ByteBuffer getBuffer() {
        return this.buffer;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public int getImageFormat() {
        return this.imageFormat;
    }

    public boolean isOpaque() {
        return this.opaque;
    }

    public int getSize() {
        return this.getByteSize();
    }

    @Override
    public int getByteSize() {
        return ImageFormat.getImageSize(this.imageFormat, this.width, this.height);
    }

    public boolean hasAlpha() {
        switch (this.imageFormat) {
            case 4097: 
            case 4353: 
            case 4354: 
            case 4356: {
                return true;
            }
            case 4096: 
            case 4352: 
            case 4355: {
                return false;
            }
        }
        throw new IllegalStateException("Invalid image format");
    }

    @Override
    public boolean isReferenced() {
        return this.references > 1;
    }

    @Override
    public void reference() {
        if (!$assertionsDisabled && this.buffer == null) {
            throw new AssertionError((Object)"BufferImage already disposed");
        }
        ++this.references;
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
        $assertionsDisabled = !(class$de$vw$mib$graphics$image$BufferImage == null ? (class$de$vw$mib$graphics$image$BufferImage = BufferImage.class$("de.vw.mib.graphics.image.BufferImage")) : class$de$vw$mib$graphics$image$BufferImage).desiredAssertionStatus();
    }
}

