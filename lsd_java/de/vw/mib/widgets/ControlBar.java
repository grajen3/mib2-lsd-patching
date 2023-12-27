/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.animations.KeyframeAnimation;
import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.properties.values.LayoutAttribs;
import de.vw.mib.widgets.AbstractList;
import de.vw.mib.widgets.controller.ControlBarController;
import de.vw.mib.widgets.interfaces.PushUpHandler;
import de.vw.mib.widgets.layout.ControlBarPushUpLayout;
import de.vw.mib.widgets.models.AbstractButtonModel;
import de.vw.mib.widgets.models.ControlBarModel;
import de.vw.mib.widgets.models.InactiveAreaModel;
import de.vw.mib.widgets.models.PushUpModel;
import de.vw.mib.widgets.models.StaticImageModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ControlBar
extends AbstractList
implements ControlBarModel,
PushUpHandler {
    private static final LayoutAttribs DEFAULT_LAYOUT = new LayoutAttribs();
    private InactiveAreaModel inactiveAreaRef;
    private PushUpModel[] pushUpRefs;
    private int[] pushUpRefsGroups;
    private WidgetModel currentActiveWidget;
    private LayoutAttribs[] layoutAttribsList;
    private int visibleButtonCount;
    private int visibleButtonIndex;
    private Image[] buttonBackgroundImages;
    static /* synthetic */ Class class$de$vw$mib$widgets$ui$ControlBarUI;

    @Override
    protected void reset() {
        super.reset();
        this.inactiveAreaRef = null;
        this.pushUpRefs = null;
        this.currentActiveWidget = null;
    }

    public void init(boolean bl, int n, Image image, boolean bl2, boolean bl3, Image[] imageArray, boolean bl4, StaticImageModel staticImageModel, boolean bl5, EasingParams[] easingParamsArray, boolean bl6, int n2, InactiveAreaModel inactiveAreaModel, boolean bl7, KeyframeAnimation[] keyframeAnimationArray, boolean bl8, LayoutAttribs layoutAttribs, LayoutAttribs[] layoutAttribsArray, boolean bl9, String string, PushUpModel[] pushUpModelArray, int[] nArray, int n3, Image image2, int n4, boolean bl10, int n5, int n6, Insets insets, boolean bl11, int n7, int n8, int n9, int n10, int n11) {
        super.init(bl, n, image, bl2, bl3, staticImageModel, bl5, easingParamsArray, bl6, n2, bl7, keyframeAnimationArray, bl8, layoutAttribs, string, n3, image2, n4, bl10, n5, n6, insets, bl11, n9, n10, n11);
        this.visibleButtonCount = n7;
        this.visibleButtonIndex = n8;
        this.buttonBackgroundImages = imageArray;
        this.inactiveAreaRef = inactiveAreaModel;
        this.pushUpRefs = pushUpModelArray;
        this.pushUpRefsGroups = nArray;
        this.layoutAttribsList = layoutAttribsArray;
        this.setInternalStateFlag(20, bl9);
        this.setInternalStateFlag(21, bl4);
        if (bl9) {
            this.setDistinctWidgetSizeMapping(false);
        }
    }

    public void init(boolean bl, int n, Image image, boolean bl2, boolean bl3, Image[] imageArray, boolean bl4, StaticImageModel staticImageModel, boolean bl5, EasingParams[] easingParamsArray, boolean bl6, int n2, InactiveAreaModel inactiveAreaModel, boolean bl7, KeyframeAnimation[] keyframeAnimationArray, boolean bl8, LayoutAttribs layoutAttribs, LayoutAttribs[] layoutAttribsArray, boolean bl9, String string, PushUpModel[] pushUpModelArray, int n3, Image image2, int n4, boolean bl10, int n5, int n6, Insets insets, boolean bl11, int n7, int n8, int n9, int n10, int n11) {
        super.init(bl, n, image, bl2, bl3, staticImageModel, bl5, easingParamsArray, bl6, n2, bl7, keyframeAnimationArray, bl8, layoutAttribs, string, n3, image2, n4, bl10, n5, n6, insets, bl11, n9, n10, n11);
        this.visibleButtonCount = n7;
        this.visibleButtonIndex = n8;
        this.buttonBackgroundImages = imageArray;
        this.inactiveAreaRef = inactiveAreaModel;
        this.pushUpRefs = pushUpModelArray;
        this.layoutAttribsList = layoutAttribsArray;
        this.setInternalStateFlag(20, bl9);
        this.setInternalStateFlag(21, bl4);
        if (bl9) {
            this.setDistinctWidgetSizeMapping(false);
        }
    }

    public void init(boolean bl, int n, Image image, boolean bl2, boolean bl3, Image[] imageArray, boolean bl4, StaticImageModel staticImageModel, boolean bl5, EasingParams[] easingParamsArray, boolean bl6, int n2, InactiveAreaModel inactiveAreaModel, boolean bl7, KeyframeAnimation[] keyframeAnimationArray, boolean bl8, LayoutAttribs layoutAttribs, LayoutAttribs[] layoutAttribsArray, boolean bl9, String string, PushUpModel[] pushUpModelArray, int n3, Image image2, int n4, boolean bl10, int n5, boolean bl11, int n6, Insets insets, boolean bl12, int n7, int n8, int n9, int n10, int n11) {
        this.init(bl, n, image, bl2, bl3, imageArray, bl4, staticImageModel, bl5, easingParamsArray, bl6, n2, inactiveAreaModel, bl7, keyframeAnimationArray, bl8, layoutAttribs, layoutAttribsArray, bl9, string, pushUpModelArray, n3, image2, n4, bl10, n5, n6, insets, bl12, n7, n8, n9, n10, n11);
    }

    @Override
    public void init(ViewModel viewModel) {
        super.init(viewModel);
        this.initPushups();
        this.set_activated(false);
        this.invalidateLayout();
    }

    private void initPushups() {
        PushUpModel[] pushUpModelArray = this.get_pushUpRefs();
        if (pushUpModelArray != null) {
            for (int i2 = 0; i2 < pushUpModelArray.length; ++i2) {
                boolean bl;
                if (null == pushUpModelArray[i2]) continue;
                boolean bl2 = bl = this.is_visible() && this.is_availableInVariant() && this.areParentsVisible();
                if (!bl) continue;
                pushUpModelArray[i2].setPushUpHandler(this);
            }
        }
    }

    @Override
    protected boolean arePropertyChangedListenerRequired() {
        return true;
    }

    @Override
    public void open(PushUpModel pushUpModel) {
        InactiveAreaModel inactiveAreaModel = this.get_inactiveAreaRef();
        if (inactiveAreaModel != null) {
            inactiveAreaModel.set_visible(true);
        }
        if (null != pushUpModel) {
            pushUpModel.set_visible(true);
            ControlBarPushUpLayout.adjustPushUpPosition(this, pushUpModel);
            ControlBarController controlBarController = (ControlBarController)this.getController();
            if (null != controlBarController) {
                this.setCurrentActiveWidget(pushUpModel);
                controlBarController.fire_pushUpOpened();
            }
        }
    }

    @Override
    public void close() {
        PushUpModel[] pushUpModelArray;
        InactiveAreaModel inactiveAreaModel = this.get_inactiveAreaRef();
        if (inactiveAreaModel != null) {
            inactiveAreaModel.set_visible(false);
        }
        if ((pushUpModelArray = this.get_pushUpRefs()) != null && pushUpModelArray.length > 0) {
            ControlBarController controlBarController;
            boolean bl = false;
            for (int i2 = 0; i2 < pushUpModelArray.length; ++i2) {
                PushUpModel pushUpModel = pushUpModelArray[i2];
                if (null == pushUpModel || !pushUpModel.is_visible()) continue;
                pushUpModel.set_visible(false);
                bl = true;
            }
            if (bl && null != (controlBarController = (ControlBarController)this.getController())) {
                controlBarController.fire_pushUpClosed();
            }
        }
        this.set_activated(false);
    }

    @Override
    public void close(PushUpModel pushUpModel) {
        ControlBarController controlBarController;
        InactiveAreaModel inactiveAreaModel = this.get_inactiveAreaRef();
        if (inactiveAreaModel != null) {
            inactiveAreaModel.set_visible(false);
        }
        boolean bl = false;
        if (null != pushUpModel && pushUpModel.is_visible()) {
            pushUpModel.set_visible(false);
            bl = true;
        }
        if (bl && null != (controlBarController = (ControlBarController)this.getController())) {
            controlBarController.fire_pushUpClosed();
        }
        this.set_activated(false);
    }

    @Override
    public Class[] getCompatibleUIClasses() {
        return new Class[]{class$de$vw$mib$widgets$ui$ControlBarUI == null ? (class$de$vw$mib$widgets$ui$ControlBarUI = ControlBar.class$("de.vw.mib.widgets.ui.ControlBarUI")) : class$de$vw$mib$widgets$ui$ControlBarUI};
    }

    @Override
    public final InactiveAreaModel get_inactiveAreaRef() {
        return this.inactiveAreaRef;
    }

    @Override
    public final void set_inactiveAreaRef(InactiveAreaModel inactiveAreaModel) {
        InactiveAreaModel inactiveAreaModel2 = this.inactiveAreaRef;
        if (inactiveAreaModel2 != inactiveAreaModel) {
            this.inactiveAreaRef = inactiveAreaModel;
            this.inactiveAreaRefChanged(inactiveAreaModel2);
            this.propertyChanged(27);
        }
    }

    @Override
    public boolean is_layoutAutomatically() {
        return this.getInternalStateFlag(20);
    }

    @Override
    public void set_layoutAutomatically(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(20);
        if (bl2 != bl) {
            this.setInternalStateFlag(20, bl);
            this.layoutAutomaticallyChanged(bl2);
            this.propertyChanged(28);
        }
    }

    @Override
    public LayoutAttribs[] get_layoutAttribsList() {
        return this.layoutAttribsList;
    }

    @Override
    public void set_layoutAttribsList(LayoutAttribs[] layoutAttribsArray) {
        Object[] objectArray = this.layoutAttribsList;
        if (objectArray == null || !Arrays.equals(objectArray, layoutAttribsArray)) {
            this.layoutAttribsList = layoutAttribsArray;
            this.layoutAttribsListChanged((LayoutAttribs[])objectArray);
            this.propertyChanged(29);
        }
    }

    @Override
    public final PushUpModel[] get_pushUpRefs() {
        return this.pushUpRefs;
    }

    @Override
    public final void set_pushUpRefs(PushUpModel[] pushUpModelArray) {
        PushUpModel[] pushUpModelArray2 = this.pushUpRefs;
        if (pushUpModelArray2 != pushUpModelArray) {
            this.pushUpRefs = pushUpModelArray;
            this.pushUpRefsChanged(pushUpModelArray2);
            this.propertyChanged(30);
        }
    }

    @Override
    public final int[] get_pushUpRefsGroups() {
        return this.pushUpRefsGroups;
    }

    @Override
    public final void set_pushUpRefsGroups(int[] nArray) {
        int[] nArray2 = this.pushUpRefsGroups;
        if (nArray2 != nArray) {
            this.pushUpRefsGroups = nArray;
            this.pushUpRefsGroupsChanged(nArray2);
            this.propertyChanged(31);
        }
    }

    @Override
    public void set_buttonResourceControlEnabled(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(21);
        if (bl2 != bl) {
            this.setInternalStateFlag(21, bl);
            this.buttonResourceControlEnabledChanged(bl2);
            this.propertyChanged(32);
        }
    }

    @Override
    public boolean is_buttonResourceControlEnabled() {
        return this.getInternalStateFlag(21);
    }

    @Override
    public void set_visibleButtonCount(int n) {
        int n2 = this.visibleButtonCount;
        if (n2 != n) {
            this.visibleButtonCount = n;
            this.visibleButtonCountChanged(n2);
            this.propertyChanged(33);
        }
    }

    @Override
    public int get_visibleButtonCount() {
        return this.visibleButtonCount;
    }

    @Override
    public void set_visibleButtonIndex(int n) {
        int n2 = this.visibleButtonIndex;
        if (n2 != n) {
            this.visibleButtonIndex = n;
            this.visibleButtonIndexChanged(n2);
            this.propertyChanged(34);
        }
    }

    @Override
    public int get_visibleButtonIndex() {
        return this.visibleButtonIndex;
    }

    @Override
    public void set_buttonBackgroundImages(Image[] imageArray) {
        Image[] imageArray2 = this.buttonBackgroundImages;
        if (imageArray2 != imageArray) {
            this.buttonBackgroundImages = imageArray;
            this.buttonBackgroundImagesChanged(imageArray2);
            this.propertyChanged(35);
        }
    }

    @Override
    public Image[] get_buttonBackgroundImages() {
        return this.buttonBackgroundImages;
    }

    @Override
    public List getActiveChildren() {
        WidgetModel[] widgetModelArray = this.getChildren();
        ArrayList arrayList = new ArrayList(widgetModelArray.length);
        for (int i2 = 0; i2 < widgetModelArray.length; ++i2) {
            if (null == widgetModelArray[i2].getController()) continue;
            arrayList.add(widgetModelArray[i2]);
        }
        return arrayList;
    }

    @Override
    public void setCurrentActiveWidget(WidgetModel widgetModel) {
        this.currentActiveWidget = widgetModel;
    }

    @Override
    public WidgetModel getCurrentActiveWidget() {
        return this.currentActiveWidget;
    }

    protected void backgroundRefChanged(StaticImageModel staticImageModel) {
    }

    protected void pushUpRefsChanged(PushUpModel[] pushUpModelArray) {
        this.initPushups();
    }

    protected void pushUpRefsGroupsChanged(int[] nArray) {
    }

    protected void buttonResourceControlEnabledChanged(boolean bl) {
        this.repaint();
    }

    protected void inactiveAreaRefChanged(InactiveAreaModel inactiveAreaModel) {
        InactiveAreaModel inactiveAreaModel2 = this.get_inactiveAreaRef();
        if (null != inactiveAreaModel2) {
            inactiveAreaModel2.setControlBarRef(this);
        }
    }

    @Override
    protected void childSelectionStateChanged(int n, boolean bl, boolean bl2) {
        if (bl && !bl2) {
            this.set_selectedIndex(n);
        }
    }

    protected void visibleButtonCountChanged(int n) {
    }

    protected void visibleButtonIndexChanged(int n) {
        if (LOGGER.isTraceEnabled(1)) {
            LOGGER.trace(1).append("ControlBar: '").append(this.getQualifiedName()).append("' layoutableIndexChanged:").append(this.visibleButtonIndex).log();
        }
    }

    protected void buttonBackgroundImagesChanged(Image[] imageArray) {
    }

    @Override
    public void selectedIndexChanged(int n) {
    }

    @Override
    protected void childVisibleStateChanged(int n, boolean bl, boolean bl2) {
        super.childVisibleStateChanged(n, bl, bl2);
        this.initPushups();
    }

    @Override
    protected void childEnabledStateChanged(int n, boolean bl, boolean bl2) {
        super.childEnabledStateChanged(n, bl, bl2);
        this.initPushups();
    }

    private void layoutAutomaticallyChanged(boolean bl) {
        this.setDistinctWidgetSizeMapping(bl);
        this.set_layoutAttribs(DEFAULT_LAYOUT);
        this.invalidateLayout();
        this.repaint();
    }

    private void layoutAttribsListChanged(LayoutAttribs[] layoutAttribsArray) {
        this.invalidateLayout();
        this.repaint();
    }

    @Override
    protected void visibleChanged(boolean bl) {
        if (!bl) {
            this.initPushups();
        }
        super.visibleChanged(bl);
    }

    @Override
    protected void parentVisibilityChanged(boolean bl) {
        if (!bl) {
            this.initPushups();
        }
        super.parentVisibilityChanged(bl);
    }

    private void updateLayoutAttribs() {
        if (this.is_layoutAutomatically()) {
            int n = this.getVisibleLayoutableChildCount();
            if (this.layoutAttribsList != null && n >= 0 && n < this.layoutAttribsList.length) {
                this.set_layoutAttribs(this.layoutAttribsList[n]);
            } else {
                LOGGER.error(1).append("ControlBar: '").append(this.getQualifiedName()).append("' - no layout available for ").append(n).append(" visible children.").log();
                this.set_layoutAttribs(DEFAULT_LAYOUT);
            }
        }
    }

    private void updateLayoutableBackgroundImages() {
        int n;
        this.set_visibleButtonCount(0);
        this.set_visibleButtonIndex(0);
        ArrayList arrayList = new ArrayList(10);
        this.getChildren(arrayList, 1);
        for (n = arrayList.size() - 1; n >= 0; --n) {
            WidgetModel widgetModel = (WidgetModel)arrayList.get(n);
            if (widgetModel instanceof AbstractButtonModel) continue;
            arrayList.remove(n);
        }
        n = arrayList.size();
        if (LOGGER.isTraceEnabled(1)) {
            LOGGER.trace(1).append("ControlBar: '").append(this.getQualifiedName()).append("' updateLayoutableBackgroundImages. Buttons:").append(arrayList.size()).log();
        }
        this.set_visibleButtonCount(n);
        for (int i2 = 0; i2 < n; ++i2) {
            this.updateButtonBackgroundImages(i2, arrayList);
        }
    }

    private void updateButtonBackgroundImages(int n, List list) {
        if (n < list.size()) {
            this.set_visibleButtonIndex(n);
            AbstractButtonModel abstractButtonModel = (AbstractButtonModel)list.get(this.visibleButtonIndex);
            if (LOGGER.isTraceEnabled(1)) {
                LOGGER.trace(1).append("ControlBar ").append(this.getQualifiedName()).append(" updating layoutableBackground for button ").append(this.visibleButtonIndex).append(" (").append(abstractButtonModel.getQualifiedName()).append(" )").log();
            }
            abstractButtonModel.set_imagesBackground(this.buttonBackgroundImages);
        } else {
            LOGGER.warn(1).append("ControlBar ").append(this.getQualifiedName()).append(" layoutableBackgroundImagesChanged with invalid index: ").append(this.visibleButtonIndex).append(" available are: ").append(list.size()).log();
        }
    }

    @Override
    public void validateLayout() {
        if (!this.isLayoutValid()) {
            this.updateLayoutAttribs();
            if (this.is_buttonResourceControlEnabled()) {
                this.updateLayoutableBackgroundImages();
            }
        }
        super.validateLayout();
    }

    @Override
    protected void updateCursor() {
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

