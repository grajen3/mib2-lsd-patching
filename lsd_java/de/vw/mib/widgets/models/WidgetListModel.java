/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.models;

import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.Point;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.widgets.models.TemplateListModel;

public interface WidgetListModel
extends TemplateListModel {
    public static final int PID_BASE;
    public static final int PID_ORIENTATION;
    public static final int PID_SPACING_VERTICAL;
    public static final int PID_SPACING_PAGE;
    public static final int PID_SPACING_HORIZONTAL;
    public static final int PID_SEPARATOR_MODE;
    public static final int PID_SEPARATOR_IMAGES;
    public static final int PID_SEPARATOR_INSETS;
    public static final int PID_SEPARATOR_IMAGE_MAIN;
    public static final int PID_SEPARATOR_IMAGE_SUB;
    public static final int PID_SEPARATOR_INSETS_MAIN;
    public static final int PID_SEPARATOR_INSETS_SUB;
    public static final int PID_SEPARATOR_OFFSET;
    public static final int PID_PADDING;
    public static final int PID_BROWSING_DIRECTION;
    public static final int PID_DROP_INDICATOR_IMAGE;
    public static final int PID_DROP_INDICATOR_INSETS;
    public static final int PID_ALPHA_DRAG_ITEM;
    public static final int PID_ALPHA_DRAG_ITEM_SOURCE;
    public static final int PID_ITEM_EXTENT;
    public static final int PID_SEPARATOR_ENABLED;
    public static final int PID_BROWSING_HIDE_SCROLL_BAR;
    public static final int PID_ALIGNMENT_PAGE;
    public static final int PID_COUNT_WIDGET_LIST;
    public static final int EASING_INDEX_BASE;
    public static final int EASING_INDEX_SCROLLING;
    public static final int EASING_INDEX_SNAP;
    public static final int EASING_INDEX_SNAP_BORDER;
    public static final int EASING_INDEX_SNAP_PAGEWISE;
    public static final int EASING_INDEX_EXPAND_MAIN;
    public static final int EASING_INDEX_EXPAND_SUB;
    public static final int EASING_INDEX_COLLAPSE_MAIN;
    public static final int EASING_INDEX_COLLAPSE_SUB;
    public static final int EASING_INDEX_EXPAND_ALPHA;
    public static final int EASING_INDEX_COLLAPSE_ALPHA;
    public static final int EASING_INDEX_PROXIMITY_ON;
    public static final int EASING_INDEX_PROXIMITY_OFF;
    public static final int EASING_INDEX_BROWSING;
    public static final int EASING_INDEX_ACTIVATED_ITEM_CHANGE;
    public static final int EASING_INDEX_PRESSED_ITEM_CHANGE;
    public static final int EASING_INDEX_COUNT_WIDGETLIST;
    public static final int SID_BASE;
    public static final int SID_BROWSING_HIDE_SCROLL_BAR;
    public static final int SID_COUNT_WIDGETLIST;
    public static final int ORIENTATION_VERTICAL;
    public static final int ORIENTATION_HORIZONTAL;
    public static final int ORIENTATION_VERTICAL_WRAP;
    public static final int ORIENTATION_HORIZONTAL_WRAP;
    public static final int ORIENTATION_VERTICAL_PAGE;
    public static final int ORIENTATION_HORIZONTAL_PAGE;
    public static final int ORIENTATION_VERTICAL_WRAP_PAGE;
    public static final int ORIENTATION_HORIZONTAL_WRAP_PAGE;
    public static final int ORIENTATION_ITEM_POINTS;
    public static final int ALIGNMENT_PAGE_TOP_LEFT;
    public static final int ALIGNMENT_PAGE_BOTTOM_RIGHT;
    public static final int ALIGNMENT_PAGE_CENTER;
    public static final int BROWSING_DIRECTION_NONE;
    public static final int BROWSING_DIRECTION_TOLEFT;
    public static final int BROWSING_DIRECTION_TORIGHT;
    public static final int SEPARATOR_MODE_DISABLED;
    public static final int SEPARATOR_MODE_ENABLED;
    public static final int SEPARATOR_MODE_LEADING;
    public static final int SEPARATOR_MODE_TRAILING;
    public static final int SEPARATOR_IMAGE_MAIN_STATIC;
    public static final int SEPARATOR_IMAGE_MAIN_DYNAMIC;
    public static final int SEPARATOR_IMAGE_SUB_STATIC;
    public static final int SEPARATOR_IMAGE_SUB_DYNAMIC;
    public static final int SEPARATOR_IMAGE_COUNT;
    public static final int SEPARATOR_INSETS_MAIN_STATIC;
    public static final int SEPARATOR_INSETS_MAIN_DYNAMIC;
    public static final int SEPARATOR_INSETS_SUB_STATIC;
    public static final int SEPARATOR_INSETS_SUB_DYNAMIC;
    public static final int SEPARATOR_INSETS_COUNT;

    default public int get_browsingDirection() {
    }

    default public void set_browsingDirection(int n) {
    }

    default public int get_orientation() {
    }

    default public void set_orientation(int n) {
    }

    default public int get_spacingVertical() {
    }

    default public void set_spacingVertical(int n) {
    }

    default public int get_spacingHorizontal() {
    }

    default public void set_spacingHorizontal(int n) {
    }

    default public int get_spacingPage() {
    }

    default public void set_spacingPage(int n) {
    }

    default public int get_alignmentPage() {
    }

    default public void set_alignmentPage(int n) {
    }

    default public int get_separatorMode() {
    }

    default public void set_separatorMode(int n) {
    }

    default public Image[] get_separatorImages() {
    }

    default public void set_separatorImages(Image[] imageArray) {
    }

    default public Insets[] get_separatorInsets() {
    }

    default public void set_separatorInsets(Insets[] insetsArray) {
    }

    default public int get_separatorOffset() {
    }

    default public void set_separatorOffset(int n) {
    }

    default public Insets get_padding() {
    }

    default public void set_padding(Insets insets) {
    }

    default public Image get_dropIndicatorImage() {
    }

    default public void set_dropIndicatorImage(Image image) {
    }

    default public Insets get_dropIndicatorInsets() {
    }

    default public void set_dropIndicatorInsets(Insets insets) {
    }

    default public int get_alphaDragItem() {
    }

    default public void set_alphaDragItem(int n) {
    }

    default public int get_alphaDragItemSource() {
    }

    default public void set_alphaDragItemSource(int n) {
    }

    default public int get_itemExtent() {
    }

    default public void set_itemExtent(int n) {
    }

    default public boolean is_browsingHideScrollBar() {
    }

    default public void set_browsingHideScrollBar(boolean bl) {
    }

    default public boolean isBrowsingTextureInvalid() {
    }

    default public boolean isBrowsingTextureDrawingEnabled() {
    }

    default public void activateBrowsing() {
    }

    default public int getItemPage(int n) {
    }

    default public void setItemPage(int n, int n2) {
    }

    default public int getItemX(int n) {
    }

    default public void setItemX(int n, int n2) {
    }

    default public int getItemY(int n) {
    }

    default public void setItemY(int n, int n2) {
    }

    default public int getItemWidth(int n) {
    }

    default public int getItemHeight(int n) {
    }

    default public int getLayoutIndexFirst() {
    }

    default public int getLayoutIndexLast() {
    }

    default public Rectangle getViewport() {
    }

    default public void setViewport(int n, int n2) {
    }

    default public void setViewportX(int n) {
    }

    default public void setViewportY(int n) {
    }

    default public int locationToIndex(Point point, int n) {
    }

    default public int locationToIndex(int n, int n2, int n3) {
    }

    default public boolean isSnapAnimationRunning() {
    }

    default public boolean isSnapAnimationStoppableByUser() {
    }

    default public void stopSnapAnimation() {
    }

    default public boolean isExpandAnimationRunning() {
    }

    default public void stopExpandAnimation() {
    }

    default public boolean isCollapseAnimationRunning() {
    }

    default public void stopCollapseAnimation() {
    }

    default public void stopExpandAndCollapseAnimation() {
    }

    default public boolean isBrowsingAnimationRunning() {
    }

    default public int getExpandIndexFirst() {
    }

    default public int getExpandIndexLast() {
    }

    default public int getCollapseIndexFirst() {
    }

    default public int getCollapseIndexLast() {
    }

    default public float getExpandAlpha() {
    }

    default public float getCollapseAlpha() {
    }

    default public boolean isProximityAnimationRunning() {
    }

    default public float getProximityAnimationValue() {
    }

    default public boolean isPressedAnimationRunning() {
    }

    default public float getPressedAnimationValue() {
    }

    default public boolean isActivatedAnimationRunning() {
    }

    default public float getActivatedAnimationValue() {
    }

    default public int getBrowsingPositionPrevContext() {
    }

    default public int getBrowsingPositionNextContext() {
    }

    default public boolean isViewportOutsideLower() {
    }

    default public boolean isViewportOutsideUpper() {
    }

    default public Point getDragPosition() {
    }

    default public void validateBrowsing() {
    }
}

