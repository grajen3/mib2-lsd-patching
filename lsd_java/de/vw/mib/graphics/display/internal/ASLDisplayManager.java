/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.display.internal;

import de.vw.mib.asl.ASLDisplayManagerTarget;
import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.collections.ints.IntOptHashSet;
import de.vw.mib.collections.ints.IntSet;
import de.vw.mib.graphics.Dimension;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.display.DisplayPerformanceMetrics;
import de.vw.mib.graphics.display.internal.ASLDisplayManager$DisplayState;
import de.vw.mib.graphics.display.internal.AbstractDisplayManager;
import de.vw.mib.graphics.display.internal.ServiceManager;
import de.vw.mib.graphics.image.BufferImage;
import de.vw.mib.graphics.image.spi.NativeImage;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.log4mib.LoggerFactory;
import java.nio.ByteBuffer;

public final class ASLDisplayManager
extends AbstractDisplayManager {
    private final Logger logger;
    private static final IntSet DISPLAYABLE_CONTENT_WHITELIST = new IntOptHashSet(11);
    private final IntObjectMap displayStates;
    private final ASLDisplayManagerTarget displayManagerTarget;

    ASLDisplayManager(LoggerFactory loggerFactory, ASLDisplayManagerTarget aSLDisplayManagerTarget) {
        this.logger = loggerFactory.getLogger(256);
        if (aSLDisplayManagerTarget == null) {
            this.logger.error(1, "ASLDisplayManagerTarget service not registered");
            throw new IllegalStateException("ASLDisplayManagerTarget service not registered");
        }
        this.displayManagerTarget = aSLDisplayManagerTarget;
        this.displayStates = new IntObjectOptHashMap(1);
    }

    private ASLDisplayManager$DisplayState getDisplayState(int n) {
        ASLDisplayManager$DisplayState aSLDisplayManager$DisplayState = (ASLDisplayManager$DisplayState)this.displayStates.get(n);
        if (aSLDisplayManager$DisplayState == null) {
            aSLDisplayManager$DisplayState = new ASLDisplayManager$DisplayState(this, this.logger, n);
            this.displayStates.put(n, aSLDisplayManager$DisplayState);
        }
        return aSLDisplayManager$DisplayState;
    }

    @Override
    public IntSet getActiveDisplayables(int n) {
        ASLDisplayManager$DisplayState aSLDisplayManager$DisplayState = (ASLDisplayManager$DisplayState)this.displayStates.get(n);
        return aSLDisplayManager$DisplayState.displayablesActive;
    }

    @Override
    public void updateDisplay(int n) {
        ASLDisplayManager$DisplayState aSLDisplayManager$DisplayState = (ASLDisplayManager$DisplayState)this.displayStates.get(n);
        aSLDisplayManager$DisplayState.updateDisplay();
    }

    @Override
    public void enableDisplayable(int n, int n2) {
        ASLDisplayManager$DisplayState aSLDisplayManager$DisplayState = this.getDisplayState(n2);
        aSLDisplayManager$DisplayState.addDisplayable(n);
    }

    @Override
    public void disableDisplayable(int n, int n2) {
        ASLDisplayManager$DisplayState aSLDisplayManager$DisplayState = this.getDisplayState(n2);
        aSLDisplayManager$DisplayState.removeDisplayable(n);
    }

    @Override
    public Dimension getDisplayableExtents(int n, int n2) {
        Dimension dimension = this.displayManagerTarget.getExtents(n);
        if (this.logger.isTraceEnabled(1)) {
            LogMessage logMessage = this.logger.trace(1);
            logMessage.append("getDisplayableExtents(displayable=").append(n).append(",displayID=").append(n2).append(") = ").append(dimension).log();
        }
        return dimension;
    }

    @Override
    public void setDisplayableAlpha(int n, int n2, int n3) {
        ASLDisplayManager$DisplayState aSLDisplayManager$DisplayState = this.getDisplayState(n2);
        int n4 = n3 * 100 / 255;
        aSLDisplayManager$DisplayState.addUpdateOpacityRequest(n, n4);
    }

    @Override
    public void setDisplayable(int n, int n2, Rectangle rectangle, Rectangle rectangle2) {
        ASLDisplayManager$DisplayState aSLDisplayManager$DisplayState = this.getDisplayState(n2);
        aSLDisplayManager$DisplayState.addUpdateCroppingRequest(n, rectangle, rectangle2);
    }

    @Override
    public Object getNativeDisplayableHandle(int n, int n2) {
        return ServiceManager.displaySPI.getNativeDisplayableHandle(n, n2);
    }

    private static long getHashCode(int n, int n2) {
        HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();
        hashCodeBuilder.append(n);
        hashCodeBuilder.append(n2);
        hashCodeBuilder.append(ServiceManager.timerManager.getSystemTime());
        return hashCodeBuilder.longHashCode();
    }

    @Override
    public BufferImage getDisplayableContent(int n, int n2) {
        long l;
        LogMessage logMessage = this.logger.isTraceEnabled(1) ? this.logger.trace(1) : null;
        boolean bl = logMessage != null && this.logger.isTraceEnabled(128);
        BufferImage bufferImage = null;
        NativeImage nativeImage = null;
        long l2 = bl ? ServiceManager.timerManager.getSystemTimeMicros() : 0L;
        nativeImage = ServiceManager.displaySPI.getDisplayableContent(n, n2);
        long l3 = l = bl ? ServiceManager.timerManager.getSystemTimeMicros() : 0L;
        if (nativeImage != null) {
            long l4 = ASLDisplayManager.getHashCode(n, n2);
            bufferImage = new BufferImage(l4, nativeImage.getBuffer(), nativeImage.getFormat(), nativeImage.getWidth(), nativeImage.getHeight());
            if (logMessage != null) {
                logMessage.append("getDisplayableContent(displayID=").append(n).append(",displayable=").append(n2).append(") = ").append(bufferImage);
                if (bl) {
                    logMessage.append(": ").append(l - l2).append("\u00b5s");
                }
                logMessage.log();
            }
            this.updateAllocationStatistics(bufferImage, true);
        } else if (logMessage != null) {
            logMessage.append("getDisplayableContent(displayID=").append(n).append(",displayable=").append(n2).append(") = null");
            logMessage.log();
        }
        return bufferImage;
    }

    @Override
    public BufferImage getDisplayableContent(int n, int n2, int n3, int n4, int n5, int n6) {
        long l;
        LogMessage logMessage = this.logger.isTraceEnabled(1) ? this.logger.trace(1) : null;
        boolean bl = logMessage != null && this.logger.isTraceEnabled(128);
        BufferImage bufferImage = null;
        NativeImage nativeImage = null;
        long l2 = bl ? ServiceManager.timerManager.getSystemTimeMicros() : 0L;
        nativeImage = ServiceManager.displaySPI.getDisplayableContent(n, n2, n3, n4, n5, n6);
        long l3 = l = bl ? ServiceManager.timerManager.getSystemTimeMicros() : 0L;
        if (nativeImage != null) {
            long l4 = ASLDisplayManager.getHashCode(n, n2);
            bufferImage = new BufferImage(l4, nativeImage.getBuffer(), nativeImage.getFormat(), nativeImage.getWidth(), nativeImage.getHeight());
            if (logMessage != null) {
                logMessage.append("getDisplayableContent(displayID=").append(n).append(",displayable=").append(n2).append(",x=").append(n3).append(",y=").append(n4).append(",width=").append(n5).append(",height=").append(n6).append(") = ").append(bufferImage);
                if (bl) {
                    logMessage.append(": ").append(l - l2).append("\u00b5s");
                }
                logMessage.log();
            }
            this.updateAllocationStatistics(bufferImage, true);
        } else if (logMessage != null) {
            logMessage.append("getDisplayableContent(displayID=").append(n).append(",displayable=").append(n2).append(") = null");
            logMessage.log();
        }
        return bufferImage;
    }

    @Override
    public BufferImage getDisplayContent(int n) {
        long l;
        LogMessage logMessage = this.logger.isTraceEnabled(1) ? this.logger.trace(1) : null;
        boolean bl = logMessage != null && this.logger.isTraceEnabled(128);
        BufferImage bufferImage = null;
        NativeImage nativeImage = null;
        long l2 = bl ? ServiceManager.timerManager.getSystemTimeMicros() : 0L;
        nativeImage = ServiceManager.displaySPI.getDisplayContent(n);
        long l3 = l = bl ? ServiceManager.timerManager.getSystemTimeMicros() : 0L;
        if (nativeImage != null) {
            long l4 = ASLDisplayManager.getHashCode(n, -1);
            bufferImage = new BufferImage(l4, nativeImage.getBuffer(), nativeImage.getFormat(), nativeImage.getWidth(), nativeImage.getHeight());
            if (logMessage != null) {
                logMessage.append("getDisplayContent(displayID=").append(n).append(") = ").append(bufferImage);
                if (bl) {
                    logMessage.append(": ").append(l - l2).append("\u00b5s");
                }
                logMessage.log();
            }
            this.updateAllocationStatistics(bufferImage, true);
        } else if (logMessage != null) {
            logMessage.append("getDisplayContent(displayID=").append(n).append(") = null");
            logMessage.log();
        }
        return bufferImage;
    }

    private void updateAllocationStatistics(BufferImage bufferImage, boolean bl) {
        DisplayPerformanceMetrics displayPerformanceMetrics = this.getPerformanceMetrics();
        int n = bufferImage.getByteSize();
        displayPerformanceMetrics.allocatedDisplayableContents = displayPerformanceMetrics.allocatedDisplayableContents + (bl ? 1 : -1);
        displayPerformanceMetrics.allocatedDisplayableContentsSizeBytes = displayPerformanceMetrics.allocatedDisplayableContentsSizeBytes + (bl ? n : -n);
    }

    @Override
    public void releaseContent(BufferImage bufferImage) {
        ByteBuffer byteBuffer = bufferImage.getBuffer();
        this.updateAllocationStatistics(bufferImage, false);
        ServiceManager.displaySPI.releaseContent(byteBuffer);
        if (this.logger.isTraceEnabled(1)) {
            LogMessage logMessage = this.logger.trace(1);
            logMessage.append("releaseContent(image=").append(bufferImage).append(")").log();
        }
    }

    @Override
    public boolean isGetDisplayableContentSupported(int n) {
        return DISPLAYABLE_CONTENT_WHITELIST.contains(n);
    }

    static /* synthetic */ ASLDisplayManagerTarget access$000(ASLDisplayManager aSLDisplayManager) {
        return aSLDisplayManager.displayManagerTarget;
    }

    static {
        DISPLAYABLE_CONTENT_WHITELIST.add(19);
        DISPLAYABLE_CONTENT_WHITELIST.add(39);
        DISPLAYABLE_CONTENT_WHITELIST.add(50);
        DISPLAYABLE_CONTENT_WHITELIST.add(21);
        DISPLAYABLE_CONTENT_WHITELIST.add(23);
        DISPLAYABLE_CONTENT_WHITELIST.add(20);
        DISPLAYABLE_CONTENT_WHITELIST.add(22);
        DISPLAYABLE_CONTENT_WHITELIST.add(55);
        DISPLAYABLE_CONTENT_WHITELIST.add(51);
        DISPLAYABLE_CONTENT_WHITELIST.add(18);
        DISPLAYABLE_CONTENT_WHITELIST.add(39);
    }
}

