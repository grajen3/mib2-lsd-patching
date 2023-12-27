/*
 * Decompiled with CFR 0.152.
 */
import de.vw.mib.graphics.image.spi.NativeImageLoadingListener;

class JOGL_textest$1
implements NativeImageLoadingListener {
    private final /* synthetic */ JOGL_textest this$0;

    JOGL_textest$1(JOGL_textest jOGL_textest) {
        this.this$0 = jOGL_textest;
    }

    @Override
    public void imageLoadingProgress(int n, int n2, int n3, int n4) {
        System.out.println(new StringBuffer().append("performed ").append(n3).append(" of ").append(n4).append(" passes").toString());
    }
}

