/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.media;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.media.DSIMediaPlayerReply;
import de.esolutions.fw.comm.dsi.media.impl.DSIMediaPlayerProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.media.DSIMediaPlayer;
import org.osgi.framework.BundleContext;

public class DSIMediaPlayerProvider
extends AbstractProvider
implements DSIMediaPlayer {
    private static final int[] attributeIDs = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18};
    private DSIMediaPlayerProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$media$DSIMediaPlayer;

    public DSIMediaPlayerProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$media$DSIMediaPlayer == null ? (class$org$dsi$ifc$media$DSIMediaPlayer = DSIMediaPlayerProvider.class$("org.dsi.ifc.media.DSIMediaPlayer")) : class$org$dsi$ifc$media$DSIMediaPlayer).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSIMediaPlayerProxy(this.instance, (DSIMediaPlayerReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void setPlaybackMode(int n) {
        try {
            this.proxy.setPlaybackMode(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setVideoNorm(int n) {
        try {
            this.proxy.setVideoNorm(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setRating(long l, int n) {
        try {
            this.proxy.setRating(l, n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestCoverArt(long l) {
        try {
            this.proxy.requestCoverArt(l);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestFullyQualifiedName(long l) {
        try {
            this.proxy.requestFullyQualifiedName(l);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setEntry(long l, int n) {
        try {
            this.proxy.setEntry(l, n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void play() {
        try {
            this.proxy.play();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void resume() {
        try {
            this.proxy.resume();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void pause() {
        try {
            this.proxy.pause();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void stop() {
        try {
            this.proxy.stop();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void seek(int n, int n2) {
        try {
            this.proxy.seek(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void skip(int n, int n2) {
        try {
            this.proxy.skip(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setActiveMedia(long l, long l2, int n) {
        try {
            this.proxy.setActiveMedia(l, l2, n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestPlayView(long l, int n, int n2, int n3) {
        try {
            this.proxy.requestPlayView(l, n, n2, n3);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void executeMenuCmd(int n) {
        try {
            this.proxy.executeMenuCmd(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setVideoAngle(int n) {
        try {
            this.proxy.setVideoAngle(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAudioStream(int n) {
        try {
            this.proxy.setAudioStream(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setVideoFormat(int n) {
        try {
            this.proxy.setVideoFormat(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSubtitleLanguage(int n) {
        try {
            this.proxy.setSubtitleLanguage(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestDetailInfo(long l) {
        try {
            this.proxy.requestDetailInfo(l);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setPlaySelection(int n, long l, boolean bl) {
        try {
            this.proxy.setPlaySelection(n, l, bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setPlaySelectionAB(int n) {
        try {
            this.proxy.setPlaySelectionAB(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setPlaybackURL(String string) {
        try {
            this.proxy.setPlaybackURL(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setVideoRect(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        try {
            this.proxy.setVideoRect(n, n2, n3, n4, n5, n6, n7, n8);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void playSimilarEntry(long l, int n) {
        try {
            this.proxy.playSimilarEntry(l, n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void grantTempPMLRequest() {
        try {
            this.proxy.grantTempPMLRequest();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void denyTempPMLRequest() {
        try {
            this.proxy.denyTempPMLRequest();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestTouchEvent(int n, int n2, int n3) {
        try {
            this.proxy.requestTouchEvent(n, n2, n3);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setNotification(int[] nArray) {
        try {
            this.proxy.setNotification(nArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setNotification(int n) {
        try {
            this.proxy.setNotification(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setNotification() {
        try {
            this.proxy.setNotification();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void clearNotification(int[] nArray) {
        try {
            this.proxy.clearNotification(nArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void clearNotification(int n) {
        try {
            this.proxy.clearNotification(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void clearNotification() {
        try {
            this.proxy.clearNotification();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void yySet(String string, String string2) {
        try {
            this.proxy.yySet(string, string2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
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
}

