/*
 * Decompiled with CFR 0.152.
 */
import de.vw.mib.graphics.image.spi.NativeImageLoadingListener;

final class SPI_test$2
implements NativeImageLoadingListener {
    SPI_test$2() {
    }

    @Override
    public void imageLoadingProgress(int n, int n2, int n3, int n4) {
        System.out.println(new StringBuffer().append("performed ").append(n3).append(" of ").append(n4).append(" passes").toString());
    }
}

