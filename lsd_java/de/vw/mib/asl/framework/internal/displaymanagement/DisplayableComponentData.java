/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.displaymanagement;

public class DisplayableComponentData {
    private int cachedBrightness = -65536;
    private int cachedColor = -65536;
    private int cachedContrast = -65536;
    private int cachedTint = -65536;
    private final int displayableComponentId;

    public DisplayableComponentData(int n) {
        this.displayableComponentId = n;
    }

    public int getCachedBrightness() {
        return this.cachedBrightness;
    }

    public int getCachedColor() {
        return this.cachedColor;
    }

    public int getCachedContrast() {
        return this.cachedContrast;
    }

    public int getCachedTint() {
        return this.cachedTint;
    }

    public int getDisplayableComponentId() {
        return this.displayableComponentId;
    }

    public boolean isCachedBrightnessSet() {
        return this.cachedBrightness != -65536;
    }

    public boolean isCachedColorSet() {
        return this.cachedColor != -65536;
    }

    public boolean isCachedContrastSet() {
        return this.cachedContrast != -65536;
    }

    public boolean isCachedTintSet() {
        return this.cachedTint != -65536;
    }

    public boolean isDisplayableComponentIDSet() {
        return this.displayableComponentId != -1;
    }

    public boolean isRearViewCamDisplayableComponent() {
        return this.displayableComponentId == 17;
    }

    public boolean isVideoOrTvDisplayableComponent() {
        return this.internalIsDisplayableVideoOrTvComponent(this.displayableComponentId);
    }

    public boolean isVideoOrTvDisplayableComponent(int n) {
        return this.internalIsDisplayableVideoOrTvComponent(n);
    }

    public void setCachedBrightness(int n) {
        this.cachedBrightness = n;
    }

    public void setCachedColor(int n) {
        this.cachedColor = n;
    }

    public void setCachedContrast(int n) {
        this.cachedContrast = n;
    }

    public void setCachedTint(int n) {
        this.cachedTint = n;
    }

    public void unsetCachedBrightness() {
        this.cachedBrightness = -65536;
    }

    private boolean internalIsDisplayableVideoOrTvComponent(int n) {
        return n == 27 || n == 43 || n == 26 || n == 29;
    }

    void unsetCachedTint() {
        this.setCachedTint(-65536);
    }

    void unsetCachedContrast() {
        this.setCachedContrast(-65536);
    }

    void unsetCachedColor() {
        this.setCachedColor(-65536);
    }
}

