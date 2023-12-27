/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.global.view.internal;

import de.vw.mib.animation.animations.KeyframeAnimation;
import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Gradient;
import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.Point;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.font.FontAttribs;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.properties.values.LabeledIconValue;
import de.vw.mib.properties.values.LayoutAttribs;
import de.vw.mib.properties.values.SpellerData;
import de.vw.mib.widgets.AsiaSpeller;
import de.vw.mib.widgets.Button;
import de.vw.mib.widgets.Canvas;
import de.vw.mib.widgets.CarImage;
import de.vw.mib.widgets.CarStatus;
import de.vw.mib.widgets.Climate;
import de.vw.mib.widgets.Clock;
import de.vw.mib.widgets.ColorChooser;
import de.vw.mib.widgets.CommonImage;
import de.vw.mib.widgets.Compass;
import de.vw.mib.widgets.Container;
import de.vw.mib.widgets.ControlBar;
import de.vw.mib.widgets.DropDown;
import de.vw.mib.widgets.DropDownButton;
import de.vw.mib.widgets.DynamicImage;
import de.vw.mib.widgets.EnergyFlow;
import de.vw.mib.widgets.FlowList;
import de.vw.mib.widgets.GEMAdapter;
import de.vw.mib.widgets.GenericCarAdjuster;
import de.vw.mib.widgets.Guidance;
import de.vw.mib.widgets.InactiveArea;
import de.vw.mib.widgets.InputField;
import de.vw.mib.widgets.Instruments;
import de.vw.mib.widgets.Iris;
import de.vw.mib.widgets.LabeledIcon;
import de.vw.mib.widgets.LaneGuidance;
import de.vw.mib.widgets.ListItem;
import de.vw.mib.widgets.MeshWidget;
import de.vw.mib.widgets.OPS;
import de.vw.mib.widgets.ParticleSystem;
import de.vw.mib.widgets.PictureViewer;
import de.vw.mib.widgets.PopupView;
import de.vw.mib.widgets.PreviewLine;
import de.vw.mib.widgets.PureAir;
import de.vw.mib.widgets.PushUp;
import de.vw.mib.widgets.ReferenceWidget;
import de.vw.mib.widgets.RunnerWidget;
import de.vw.mib.widgets.Screen;
import de.vw.mib.widgets.ScreenArea;
import de.vw.mib.widgets.ScrollableText;
import de.vw.mib.widgets.Scrollbar;
import de.vw.mib.widgets.SequencedImage;
import de.vw.mib.widgets.Slider;
import de.vw.mib.widgets.Speller;
import de.vw.mib.widgets.SpellerButton;
import de.vw.mib.widgets.SpinLabel;
import de.vw.mib.widgets.StaticImage;
import de.vw.mib.widgets.Statistics;
import de.vw.mib.widgets.TextArea;
import de.vw.mib.widgets.ThresholdNotifier;
import de.vw.mib.widgets.TimerWidget;
import de.vw.mib.widgets.TouchArea;
import de.vw.mib.widgets.TransformContainer;
import de.vw.mib.widgets.View;
import de.vw.mib.widgets.WidgetList;
import de.vw.mib.widgets.interfaces.Adjustable;
import de.vw.mib.widgets.models.AbstractButtonModel;
import de.vw.mib.widgets.models.AbstractSpellerModel;
import de.vw.mib.widgets.models.ButtonModel;
import de.vw.mib.widgets.models.ContainerModel;
import de.vw.mib.widgets.models.DropDownModel;
import de.vw.mib.widgets.models.InactiveAreaModel;
import de.vw.mib.widgets.models.InputFieldModel;
import de.vw.mib.widgets.models.ListItemModel;
import de.vw.mib.widgets.models.PushUpModel;
import de.vw.mib.widgets.models.StaticImageModel;
import de.vw.mib.widgets.models.TemplateListModel;
import de.vw.mib.widgets.models.TextAreaModel;
import de.vw.mib.widgets.models.TouchAreaModel;
import de.vw.mib.widgets.models.WidgetListModel;
import de.vw.mib.widgets.models.WidgetModel;
import org.dsi.ifc.global.ResourceLocator;

public final class WidgetInit {
    public static void initAsiaSpeller(AsiaSpeller asiaSpeller, boolean bl, int n, int n2, String[] stringArray, int[] nArray, Image image, boolean bl2, boolean bl3, boolean bl4, int n3, int n4, int n5, int n6, int n7, Color[] colorArray, Image[] imageArray, int n8, EasingParams[] easingParamsArray, boolean bl5, int n9, boolean bl6, int[] nArray2, int[] nArray3, Image[] imageArray2, int n10, int n11, TouchAreaModel touchAreaModel, boolean bl7, ContainerModel[] containerModelArray, WidgetModel[] widgetModelArray, int n12, ContainerModel[] containerModelArray2, Image[] imageArray3, InactiveAreaModel inactiveAreaModel, String string, int n13, KeyframeAnimation[] keyframeAnimationArray, int n14, String[] stringArray2, boolean bl8, LayoutAttribs layoutAttribs, int[] nArray4, boolean[] blArray, int[] nArray5, ListItemModel[] listItemModelArray, TemplateListModel[] templateListModelArray, int n15, int n16, int n17, String string2, boolean bl9, boolean bl10, int n18, Image image2, int n19, boolean bl11, int n20, boolean bl12, SpellerData spellerData, Insets insets, int n21, int n22, boolean bl13, int n23, Insets insets2, boolean bl14, boolean bl15, int n24, boolean bl16, int n25, int n26) {
        asiaSpeller.init(bl, n, n2, stringArray, nArray, image, bl2, bl3, bl4, n3, n4, n5, n6, n7, colorArray, imageArray, n8, easingParamsArray, bl5, n9, bl6, nArray2, nArray3, imageArray2, n10, n11, touchAreaModel, bl7, containerModelArray, widgetModelArray, n12, containerModelArray2, imageArray3, inactiveAreaModel, string, n13, keyframeAnimationArray, n14, stringArray2, bl8, layoutAttribs, nArray4, blArray, nArray5, listItemModelArray, templateListModelArray, n15, n16, n17, string2, bl9, bl10, n18, image2, n19, bl11, n20, bl12, spellerData, insets, n21, n22, bl13, n23, insets2, bl14, bl15, n24, bl16, n25, n26);
    }

    public static void initButton(Button button, boolean bl, int n, Image image, boolean bl2, boolean bl3, int n2, Color[] colorArray, Color[] colorArray2, EasingParams[] easingParamsArray, EasingParams[] easingParamsArray2, boolean bl4, String string, Color[] colorArray3, int n3, StaticImageModel staticImageModel, StaticImageModel staticImageModel2, Image[] imageArray, Image[] imageArray2, Image[] imageArray3, Image[] imageArray4, Color[] colorArray4, StaticImageModel staticImageModel3, StaticImageModel staticImageModel4, boolean bl5, KeyframeAnimation[] keyframeAnimationArray, boolean bl6, LayoutAttribs layoutAttribs, String string2, boolean bl7, int n4, Image image2, int n5, boolean bl8, int n6, int n7, boolean bl9, int n8, int n9, int n10, int n11, TextAreaModel[] textAreaModelArray, TextAreaModel[] textAreaModelArray2, Color[] colorArray5, Color[] colorArray6, Insets insets, Point[] pointArray, boolean bl10, int n12, int n13, int n14) {
        button.init(bl, n, image, bl2, bl3, n2, colorArray, colorArray2, easingParamsArray, easingParamsArray2, bl4, string, colorArray3, n3, staticImageModel, staticImageModel2, imageArray, imageArray2, imageArray3, imageArray4, colorArray4, staticImageModel3, staticImageModel4, bl5, keyframeAnimationArray, bl6, layoutAttribs, string2, bl7, n4, image2, n5, bl8, n6, n7, bl9, n8, n9, n10, n11, textAreaModelArray, textAreaModelArray2, colorArray5, colorArray6, insets, pointArray, bl10, n12, n13, n14);
    }

    public static void initCanvas(Canvas canvas, boolean bl, boolean bl2, boolean bl3, int n, float f2, boolean bl4, boolean bl5, int n2, int n3, int n4, boolean bl6, int n5, int n6, int n7, EasingParams[] easingParamsArray, boolean bl7, int n8, boolean bl8, int n9, String string, int n10, int n11, boolean bl9, boolean bl10, int n12, int n13, Insets insets, Color color, Image image, int n14, int n15, int n16, int n17, int n18, boolean bl11, int n19, int n20, int n21) {
        canvas.init(bl, bl2, bl3, n, f2, bl4, bl5, n2, n3, n4, bl6, n5, n6, n7, easingParamsArray, bl7, n8, bl8, n9, string, n10, n11, bl9, bl10, n12, n13, insets, color, image, n14, n15, n16, n17, n18, bl11, n19, n20, n21);
    }

    public static void initCarImage(CarImage carImage, boolean bl, int n, boolean bl2, Color color, int n2, Color color2, boolean bl3, EasingParams[] easingParamsArray, boolean bl4, int n3, String string, int n4, boolean bl5, String string2, int n5, int n6, Insets insets, boolean bl6, int n7, int n8, int n9) {
        carImage.init(bl, n, bl2, color, n2, color2, bl3, easingParamsArray, bl4, n3, string, n4, bl5, string2, n5, n6, insets, bl6, n7, n8, n9);
    }

    public static void initCarStatus(CarStatus carStatus, boolean bl, int n, boolean bl2, EasingParams[] easingParamsArray, boolean bl3, Color[] colorArray, int[] nArray, int n2, boolean bl4, String string, boolean bl5, boolean bl6, int n3, Insets insets, boolean bl7, int n4, int n5, int n6) {
        carStatus.init(bl, n, bl2, easingParamsArray, bl3, colorArray, nArray, n2, bl4, string, bl5, bl6, n3, insets, bl7, n4, n5, n6);
    }

    public static void initClimate(Climate climate, boolean bl, int n, int n2, boolean bl2, boolean bl3, Color color, Color color2, Color color3, EasingParams[] easingParamsArray, boolean bl4, Color[] colorArray, boolean[] blArray, int n3, boolean[] blArray2, int[] nArray, int n4, boolean bl5, TemplateListModel templateListModel, String string, boolean bl6, int n5, Insets insets, boolean bl7, int n6, int n7, int n8) {
        climate.init(bl, n, n2, bl2, bl3, color, color2, color3, easingParamsArray, bl4, colorArray, blArray, n3, blArray2, nArray, n4, bl5, templateListModel, string, bl6, n5, insets, bl7, n6, n7, n8);
    }

    public static void initClock(Clock clock, boolean bl, int n, boolean bl2, Color color, int n2, Color color2, Image image, Color color3, Image image2, Color color4, Image image3, Color color5, Image image4, Color color6, Image image5, Color color7, boolean bl3, EasingParams[] easingParamsArray, boolean bl4, int n3, int n4, boolean bl5, int n5, String string, int n6, boolean bl6, int n7, Insets insets, boolean bl7, int n8, int n9, int n10) {
        clock.init(bl, n, bl2, color, n2, color2, image, color3, image2, color4, image3, color5, image4, color6, image5, color7, bl3, easingParamsArray, bl4, n3, n4, bl5, n5, string, n6, bl6, n7, insets, bl7, n8, n9, n10);
    }

    public static void initColorChooser(ColorChooser colorChooser, boolean bl, int n, Image image, boolean bl2, boolean bl3, ButtonModel[] buttonModelArray, int[] nArray, int n2, Color[] colorArray, Color[] colorArray2, EasingParams[] easingParamsArray, EasingParams[] easingParamsArray2, boolean bl4, Color[] colorArray3, int n3, StaticImageModel staticImageModel, StaticImageModel staticImageModel2, StaticImageModel staticImageModel3, Image[] imageArray, Image[] imageArray2, Image[] imageArray3, int n4, int n5, boolean bl5, KeyframeAnimation[] keyframeAnimationArray, boolean bl6, LayoutAttribs layoutAttribs, int n6, String string, Insets insets, int n7, Image image2, int n8, boolean bl7, boolean bl8, boolean bl9, int n9, int n10, int n11, Insets insets2, boolean bl10, int n12, boolean bl11, int n13, int n14) {
        colorChooser.init(bl, n, image, bl2, bl3, buttonModelArray, nArray, n2, colorArray, colorArray2, easingParamsArray, easingParamsArray2, bl4, colorArray3, n3, staticImageModel, staticImageModel2, staticImageModel3, imageArray, imageArray2, imageArray3, n4, n5, bl5, keyframeAnimationArray, bl6, layoutAttribs, n6, string, insets, n7, image2, n8, bl7, bl8, bl9, n9, n10, n11, insets2, bl10, n12, bl11, n13, n14);
    }

    public static void initCommonImage(CommonImage commonImage, boolean bl, int n, boolean bl2, Color color, int n2, Color color2, boolean bl3, EasingParams[] easingParamsArray, boolean bl4, int n3, String string, int n4, boolean bl5, String string2, int n5, int n6, Insets insets, boolean bl6, int n7, int n8, int n9) {
        commonImage.init(bl, n, bl2, color, n2, color2, bl3, easingParamsArray, bl4, n3, string, n4, bl5, string2, n5, n6, insets, bl6, n7, n8, n9);
    }

    public static void initCompass(Compass compass, boolean bl, int n, boolean bl2, Color color, int n2, Color color2, boolean bl3, int n3, EasingParams[] easingParamsArray, boolean bl4, int n4, int n5, boolean bl5, boolean bl6, String string, Image image, int n6, int n7, Insets insets, boolean bl7, int n8, int n9, int n10) {
        compass.init(bl, n, bl2, color, n2, color2, bl3, n3, easingParamsArray, bl4, n4, n5, bl5, bl6, string, image, n6, n7, insets, bl7, n8, n9, n10);
    }

    public static void initContainer(Container container, boolean bl, int n, Image image, boolean bl2, boolean bl3, EasingParams[] easingParamsArray, boolean bl4, int n2, KeyframeAnimation[] keyframeAnimationArray, boolean bl5, LayoutAttribs layoutAttribs, String string, int n3, Image image2, int n4, boolean bl6, int n5, Insets insets, boolean bl7, int n6, int n7, int n8) {
        container.init(bl, n, image, bl2, bl3, easingParamsArray, bl4, n2, keyframeAnimationArray, bl5, layoutAttribs, string, n3, image2, n4, bl6, n5, insets, bl7, n6, n7, n8);
    }

    public static void initControlBar(ControlBar controlBar, boolean bl, int n, Image image, boolean bl2, boolean bl3, Image[] imageArray, boolean bl4, StaticImageModel staticImageModel, boolean bl5, EasingParams[] easingParamsArray, boolean bl6, int n2, InactiveAreaModel inactiveAreaModel, boolean bl7, KeyframeAnimation[] keyframeAnimationArray, boolean bl8, LayoutAttribs layoutAttribs, LayoutAttribs[] layoutAttribsArray, boolean bl9, String string, PushUpModel[] pushUpModelArray, int[] nArray, int n3, Image image2, int n4, boolean bl10, int n5, int n6, Insets insets, boolean bl11, int n7, int n8, int n9, int n10, int n11) {
        controlBar.init(bl, n, image, bl2, bl3, imageArray, bl4, staticImageModel, bl5, easingParamsArray, bl6, n2, inactiveAreaModel, bl7, keyframeAnimationArray, bl8, layoutAttribs, layoutAttribsArray, bl9, string, pushUpModelArray, nArray, n3, image2, n4, bl10, n5, n6, insets, bl11, n7, n8, n9, n10, n11);
    }

    public static void initDropDown(DropDown dropDown, boolean bl, int n, Image image, boolean bl2, boolean bl3, boolean bl4, int n2, int n3, int n4, Color[] colorArray, Image[] imageArray, int n5, WidgetListModel widgetListModel, EasingParams[] easingParamsArray, boolean bl5, int[] nArray, int[] nArray2, Image[] imageArray2, int n6, int n7, KeyframeAnimation[] keyframeAnimationArray, boolean bl6, int n8, LayoutAttribs layoutAttribs, boolean bl7, String string, int n9, Image image2, int n10, boolean bl8, int n11, int n12, Insets insets, boolean bl9, int n13, int n14, int n15, int n16) {
        dropDown.init(bl, n, image, bl2, bl3, bl4, n2, n3, n4, colorArray, imageArray, n5, widgetListModel, easingParamsArray, bl5, nArray, nArray2, imageArray2, n6, n7, keyframeAnimationArray, bl6, n8, layoutAttribs, bl7, string, n9, image2, n10, bl8, n11, n12, insets, bl9, n13, n14, n15, n16);
    }

    public static void initDropDownButton(DropDownButton dropDownButton, boolean bl, int n, Image image, boolean bl2, boolean bl3, int n2, Color[] colorArray, Color[] colorArray2, boolean[] blArray, DropDownModel dropDownModel, EasingParams[] easingParamsArray, EasingParams[] easingParamsArray2, boolean bl4, String string, Color[] colorArray3, int n3, StaticImageModel staticImageModel, StaticImageModel staticImageModel2, Image[] imageArray, Image[] imageArray2, Image[] imageArray3, Image[] imageArray4, Color[] colorArray4, StaticImageModel staticImageModel3, StaticImageModel staticImageModel4, InactiveAreaModel inactiveAreaModel, boolean bl5, KeyframeAnimation[] keyframeAnimationArray, boolean bl6, LayoutAttribs layoutAttribs, String string2, boolean bl7, boolean bl8, int n4, Image image2, int n5, boolean bl9, int n6, int n7, boolean bl10, int n8, int n9, int n10, int n11, TextAreaModel[] textAreaModelArray, TextAreaModel[] textAreaModelArray2, Color[] colorArray5, Color[] colorArray6, Insets insets, Point[] pointArray, boolean bl11, int n12, int n13, int n14) {
        dropDownButton.init(bl, n, image, bl2, bl3, n2, colorArray, colorArray2, blArray, dropDownModel, easingParamsArray, easingParamsArray2, bl4, string, colorArray3, n3, staticImageModel, staticImageModel2, imageArray, imageArray2, imageArray3, imageArray4, colorArray4, staticImageModel3, staticImageModel4, inactiveAreaModel, bl5, keyframeAnimationArray, bl6, layoutAttribs, string2, bl7, bl8, n4, image2, n5, bl9, n6, n7, bl10, n8, n9, n10, n11, textAreaModelArray, textAreaModelArray2, colorArray5, colorArray6, insets, pointArray, bl11, n12, n13, n14);
    }

    public static void initDynamicImage(DynamicImage dynamicImage, boolean bl, int n, boolean bl2, Color color, int n2, Image image, Color color2, int n3, Insets insets, Color color3, Color color4, boolean bl3, Color color5, Color color6, EasingParams[] easingParamsArray, boolean bl4, int n4, Image image2, Image image3, Image image4, ResourceLocator resourceLocator, boolean bl5, String string, boolean bl6, int n5, Image image5, int n6, boolean bl7, int n7, boolean bl8, Insets insets2, int n8, int n9, boolean bl9, boolean bl10, int n10, int n11, int n12, int n13) {
        dynamicImage.init(bl, n, bl2, color, n2, image, color2, n3, insets, color3, color4, bl3, color5, color6, easingParamsArray, bl4, n4, image2, image3, image4, resourceLocator, bl5, string, bl6, n5, image5, n6, bl7, n7, bl8, insets2, n8, n9, bl9, bl10, n10, n11, n12, n13);
    }

    public static void initEnergyFlow(EnergyFlow energyFlow, boolean bl, int n, boolean bl2, int n2, int n3, int n4, EasingParams[] easingParamsArray, boolean bl3, Color[] colorArray, int n5, int[] nArray, int n6, boolean bl4, int n7, String string, int n8, int n9, Insets insets, boolean bl5, int n10, int n11, int n12) {
        energyFlow.init(bl, n, bl2, n2, n3, n4, easingParamsArray, bl3, colorArray, n5, nArray, n6, bl4, n7, string, n8, n9, insets, bl5, n10, n11, n12);
    }

    public static void initFlowList(FlowList flowList, int n, boolean bl, int n2, int n3, Image image, boolean bl2, boolean bl3, StaticImageModel staticImageModel, boolean bl4, int n4, boolean bl5, boolean bl6, EasingParams[] easingParamsArray, int n5, boolean bl7, int n6, int n7, int n8, ListItemModel[] listItemModelArray, boolean bl8, int n9, int n10, int n11, boolean bl9, int n12, boolean bl10, Point[] pointArray, KeyframeAnimation[] keyframeAnimationArray, boolean bl11, LayoutAttribs layoutAttribs, boolean bl12, int n13, WidgetModel widgetModel, boolean bl13, TextAreaModel textAreaModel, boolean bl14, int n14, boolean bl15, String string, boolean bl16, int n15, float f2, float f3, float f4, int n16, float f5, float[] fArray, float[] fArray2, float[] fArray3, int n17, int n18, boolean bl17, int n19, int n20, Image image2, int n21, boolean bl18, int n22, int n23, int n24, int n25, Insets insets, boolean bl19, int n26, int n27, int n28, int n29) {
        flowList.init(n, bl, n2, n3, image, bl2, bl3, staticImageModel, bl4, n4, bl5, bl6, easingParamsArray, n5, bl7, n6, n7, n8, listItemModelArray, bl8, n9, n10, n11, bl9, n12, bl10, pointArray, keyframeAnimationArray, bl11, layoutAttribs, bl12, n13, widgetModel, bl13, textAreaModel, bl14, n14, bl15, string, bl16, n15, f2, f3, f4, n16, f5, fArray, fArray2, fArray3, n17, n18, bl17, n19, n20, image2, n21, bl18, n22, n23, n24, n25, insets, bl19, n26, n27, n28, n29);
    }

    public static void initGEMAdapter(GEMAdapter gEMAdapter, boolean bl, int n, Image image, boolean bl2, float f2, boolean bl3, Color color, int n2, int n3, EasingParams[] easingParamsArray, boolean bl4, KeyframeAnimation[] keyframeAnimationArray, int n4, KeyframeAnimation[] keyframeAnimationArray2, boolean bl5, LayoutAttribs layoutAttribs, KeyframeAnimation[] keyframeAnimationArray3, String string, boolean bl6, float f3, float f4, float f5, float f6, float f7, float f8, int n5, int n6, Image image2, int n7, boolean bl7, boolean bl8, boolean bl9, float f9, float f10, float f11, float f12, float f13, float f14, int n8, int n9, Insets insets, int[] nArray, int n10, boolean bl10, int n11, int n12, int n13, int n14) {
        gEMAdapter.init(bl, n, image, bl2, f2, bl3, color, n2, n3, easingParamsArray, bl4, keyframeAnimationArray, n4, keyframeAnimationArray2, bl5, layoutAttribs, keyframeAnimationArray3, string, bl6, f3, f4, f5, f6, f7, f8, n5, n6, image2, n7, bl7, bl8, bl9, f9, f10, f11, f12, f13, f14, n8, n9, insets, nArray, n10, bl10, n11, n12, n13, n14);
    }

    public static void initGenericCarAdjuster(GenericCarAdjuster genericCarAdjuster, boolean bl, int n, boolean bl2, ButtonModel[] buttonModelArray, String string, int n2, EasingParams[] easingParamsArray, boolean bl3, boolean[] blArray, int[] nArray, Color[] colorArray, int n3, int[] nArray2, int[] nArray3, int n4, boolean bl4, String string2, int n5, Insets insets, boolean bl5, int n6, int n7, int n8) {
        genericCarAdjuster.init(bl, n, bl2, buttonModelArray, string, n2, easingParamsArray, bl3, blArray, nArray, colorArray, n3, nArray2, nArray3, n4, bl4, string2, n5, insets, bl5, n6, n7, n8);
    }

    public static void initGuidance(Guidance guidance, boolean bl, int n, boolean bl2, int n2, int n3, Image[] imageArray, Point[] pointArray, boolean bl3, Adjustable[] adjustableArray, EasingParams[] easingParamsArray, boolean bl4, int n4, boolean bl5, int n5, Color color, Image[] imageArray2, Point[] pointArray2, String string, String string2, Image[] imageArray3, Point[] pointArray3, int n6, Insets insets, boolean bl6, int n7, int n8, int n9, int n10, Image[] imageArray4, Point point) {
        guidance.init(bl, n, bl2, n2, n3, imageArray, pointArray, bl3, adjustableArray, easingParamsArray, bl4, n4, bl5, n5, color, imageArray2, pointArray2, string, string2, imageArray3, pointArray3, n6, insets, bl6, n7, n8, n9, n10, imageArray4, point);
    }

    public static void initInactiveArea(InactiveArea inactiveArea, boolean bl, int n, Image image, boolean bl2, boolean bl3, EasingParams[] easingParamsArray, boolean bl4, Rectangle rectangle, int n2, KeyframeAnimation[] keyframeAnimationArray, boolean bl5, LayoutAttribs layoutAttribs, String string, int n3, Image image2, int n4, boolean bl6, int n5, Insets insets, boolean bl7, int n6, int n7, int n8) {
        inactiveArea.init(bl, n, image, bl2, bl3, easingParamsArray, bl4, rectangle, n2, keyframeAnimationArray, bl5, layoutAttribs, string, n3, image2, n4, bl6, n5, insets, bl7, n6, n7, n8);
    }

    public static void initInputField(InputField inputField, boolean bl, int n, int n2, int n3, boolean bl2, int n4, int n5, int n6, Color color, Color color2, Color color3, Color color4, Color color5, Color color6, Color[] colorArray, Color[] colorArray2, Color color7, Image image, int n7, int n8, int n9, int n10, EasingParams[] easingParamsArray, boolean bl3, FontAttribs fontAttribs, int[] nArray, Color color8, int n11, boolean bl4, int n12, boolean bl5, String string, boolean bl6, boolean bl7, int n13, int n14, String string2, Insets insets, boolean bl8, boolean bl9, AbstractSpellerModel abstractSpellerModel, int n15, String string3, boolean bl10, Insets insets2, boolean bl11, int n16, int n17, int n18, int n19) {
        inputField.init(bl, n, n2, n3, bl2, n4, n5, n6, color, color2, color3, color4, color5, color6, colorArray, colorArray2, color7, image, n7, n8, n9, n10, easingParamsArray, bl3, fontAttribs, nArray, color8, n11, bl4, n12, bl5, string, bl6, bl7, n13, n14, string2, insets, bl8, bl9, abstractSpellerModel, n15, string3, bl10, insets2, bl11, n16, n17, n18, n19);
    }

    public static void initInstruments(Instruments instruments, boolean bl, int n, Image image, boolean bl2, float f2, boolean bl3, Color color, Image image2, int n2, int n3, EasingParams[] easingParamsArray, boolean bl4, Color color2, Image image3, int[] nArray, int n4, KeyframeAnimation[] keyframeAnimationArray, boolean bl5, LayoutAttribs layoutAttribs, int n5, String string, boolean bl6, float f3, float f4, float f5, Color[] colorArray, int n6, Image[] imageArray, float f6, float f7, float f8, int n7, int n8, int n9, Image image4, int n10, boolean bl7, float f9, float f10, float f11, int[] nArray2, int[] nArray3, Color[] colorArray2, Image[] imageArray2, int[] nArray4, int[] nArray5, float f12, float f13, float f14, int n11, Insets insets, int n12, int n13, int n14, int n15, int n16, boolean bl8, int[] nArray6, Image image5, int n17, int n18, int n19, int n20) {
        instruments.init(bl, n, image, bl2, f2, bl3, color, image2, n2, n3, easingParamsArray, bl4, color2, image3, nArray, n4, keyframeAnimationArray, bl5, layoutAttribs, n5, string, bl6, f3, f4, f5, colorArray, n6, imageArray, f6, f7, f8, n7, n8, n9, image4, n10, bl7, f9, f10, f11, nArray2, nArray3, colorArray2, imageArray2, nArray4, nArray5, f12, f13, f14, n11, insets, n12, n13, n14, n15, n16, bl8, nArray6, image5, n17, n18, n19, n20);
    }

    public static void initIris(Iris iris, int n, Image[] imageArray, boolean bl, int n2, int n3, Image image, boolean bl2, boolean bl3, EasingParams[] easingParamsArray, boolean bl4, float f2, int n4, int n5, Image[] imageArray2, Image image2, Color[] colorArray, int[] nArray, int[] nArray2, Image[] imageArray3, KeyframeAnimation[] keyframeAnimationArray, boolean bl5, LayoutAttribs layoutAttribs, int n6, int n7, String string, int n8, Image image3, int n9, boolean bl6, int n10, int n11, int n12, Insets insets, int[] nArray3, boolean bl7, int n13, int n14, int n15) {
        iris.init(n, imageArray, bl, n2, n3, image, bl2, bl3, easingParamsArray, bl4, f2, n4, n5, imageArray2, image2, colorArray, nArray, nArray2, imageArray3, keyframeAnimationArray, bl5, layoutAttribs, n6, n7, string, n8, image3, n9, bl6, n10, n11, n12, insets, nArray3, bl7, n13, n14, n15);
    }

    public static void initLabeledIcon(LabeledIcon labeledIcon, boolean bl, int n, boolean bl2, Color color, int n2, Image image, Color color2, int n3, Insets insets, Color color3, Color color4, boolean bl3, Color color5, Color color6, EasingParams[] easingParamsArray, boolean bl4, FontAttribs fontAttribs, int n4, Image image2, Image image3, Image image4, ResourceLocator resourceLocator, LabeledIconValue labeledIconValue, boolean bl5, int n5, String string, boolean bl6, int n6, Image image5, int n7, boolean bl7, int n8, Color color7, boolean bl8, Insets insets2, int n9, int n10, boolean bl9, boolean bl10, int n11, int n12, int n13, int n14) {
        labeledIcon.init(bl, n, bl2, color, n2, image, color2, n3, insets, color3, color4, bl3, color5, color6, easingParamsArray, bl4, fontAttribs, n4, image2, image3, image4, resourceLocator, labeledIconValue, bl5, n5, string, bl6, n6, image5, n7, bl7, n8, color7, bl8, insets2, n9, n10, bl9, bl10, n11, n12, n13, n14);
    }

    public static void initLaneGuidance(LaneGuidance laneGuidance, boolean bl, int n, boolean bl2, Color color, int n2, Color color2, boolean bl3, EasingParams[] easingParamsArray, boolean bl4, int n3, int[] nArray, Image[] imageArray, int[] nArray2, Image[] imageArray2, int[] nArray3, int[] nArray4, Image image, boolean bl5, String string, int n4, int n5, int n6, Insets insets, boolean bl6, int n7, int n8, int n9) {
        laneGuidance.init(bl, n, bl2, color, n2, color2, bl3, easingParamsArray, bl4, n3, nArray, imageArray, nArray2, imageArray2, nArray3, nArray4, image, bl5, string, n4, n5, n6, insets, bl6, n7, n8, n9);
    }

    public static void initListItem(ListItem listItem, boolean bl, AbstractButtonModel[] abstractButtonModelArray, int n, int n2, Image image, boolean bl2, float f2, boolean bl3, Insets insets, int n3, int n4, boolean bl4, Insets insets2, int n5, WidgetModel widgetModel, int n6, int n7, Insets insets3, WidgetModel widgetModel2, EasingParams[] easingParamsArray, WidgetModel[] widgetModelArray, boolean bl5, boolean[] blArray, int n8, KeyframeAnimation[] keyframeAnimationArray, boolean bl6, LayoutAttribs layoutAttribs, int n9, boolean bl7, String string, ContainerModel containerModel, TextAreaModel textAreaModel, long l, float f3, float f4, float f5, float f6, float f7, float f8, int n10, int n11, Image image2, int n12, boolean bl8, float f9, float f10, float f11, float f12, float f13, float f14, boolean bl9, AbstractButtonModel[] abstractButtonModelArray2, ListItemModel[] listItemModelArray, int n13, Insets insets4, boolean bl10, int n14, int n15, int n16, int n17) {
        listItem.init(bl, abstractButtonModelArray, n, n2, image, bl2, f2, bl3, insets, n3, n4, bl4, insets2, n5, widgetModel, n6, n7, insets3, widgetModel2, easingParamsArray, widgetModelArray, bl5, blArray, n8, keyframeAnimationArray, bl6, layoutAttribs, n9, bl7, string, containerModel, textAreaModel, l, f3, f4, f5, f6, f7, f8, n10, n11, image2, n12, bl8, f9, f10, f11, f12, f13, f14, bl9, abstractButtonModelArray2, listItemModelArray, n13, insets4, bl10, n14, n15, n16, n17);
    }

    public static void initMeshWidget(MeshWidget meshWidget, boolean bl, int n, boolean bl2, EasingParams[] easingParamsArray, boolean bl3, int n2, boolean bl4, String string, String string2, int n3, Insets insets, boolean bl5, int n4, int n5, int n6) {
        meshWidget.init(bl, n, bl2, easingParamsArray, bl3, n2, bl4, string, string2, n3, insets, bl5, n4, n5, n6);
    }

    public static void initOPS(OPS oPS, boolean bl, int n, ButtonModel[] buttonModelArray, int[] nArray, boolean bl2, int[] nArray2, boolean bl3, EasingParams[] easingParamsArray, boolean bl4, Color[] colorArray, int[] nArray3, int n2, boolean bl5, int[] nArray4, String string, int n3, int n4, Color[] colorArray2, int[] nArray5, Color[] colorArray3, int[] nArray6, int[] nArray7, Color[] colorArray4, int[] nArray8, boolean bl6, boolean bl7, boolean bl8, boolean bl9, boolean bl10, boolean bl11, boolean bl12, boolean bl13, boolean bl14, boolean bl15, boolean bl16, boolean bl17, int n5, Insets insets, int n6, boolean bl18, int n7, int n8, int n9, int n10) {
        oPS.init(bl, n, buttonModelArray, nArray, bl2, nArray2, bl3, easingParamsArray, bl4, colorArray, nArray3, n2, bl5, nArray4, string, n3, n4, colorArray2, nArray5, colorArray3, nArray6, nArray7, colorArray4, nArray8, bl6, bl7, bl8, bl9, bl10, bl11, bl12, bl13, bl14, bl15, bl16, bl17, n5, insets, n6, bl18, n7, n8, n9, n10);
    }

    public static void initParticleSystem(ParticleSystem particleSystem, boolean bl, int n, float f2, boolean bl2, float f3, EasingParams[] easingParamsArray, EasingParams easingParams, EasingParams easingParams2, EasingParams easingParams3, EasingParams easingParams4, EasingParams easingParams5, EasingParams easingParams6, EasingParams easingParams7, EasingParams easingParams8, EasingParams easingParams9, EasingParams easingParams10, EasingParams easingParams11, boolean bl3, float f4, float f5, int n2, boolean bl4, String string, float f6, float f7, float f8, Image image, Image image2, float f9, float f10, float f11, int n3, Color color, float f12, Insets insets, float f13, float f14, boolean bl5, int n4, int n5, int n6, float f15) {
        particleSystem.init(bl, n, f2, bl2, f3, easingParamsArray, easingParams, easingParams2, easingParams3, easingParams4, easingParams5, easingParams6, easingParams7, easingParams8, easingParams9, easingParams10, easingParams11, bl3, f4, f5, n2, bl4, string, f6, f7, f8, image, image2, f9, f10, f11, n3, color, f12, insets, f13, f14, bl5, n4, n5, n6, f15);
    }

    public static void initPictureViewer(PictureViewer pictureViewer, boolean bl, int n, boolean bl2, Color color, int n2, Image image, Color color2, int n3, Insets insets, Color color3, Color color4, boolean bl3, Color color5, Color color6, EasingParams[] easingParamsArray, boolean bl4, int n4, Image image2, Image image3, Image image4, ResourceLocator resourceLocator, boolean bl5, String string, boolean bl6, int n5, Image image5, int n6, boolean bl7, int n7, int n8, boolean bl8, int n9, boolean bl9, Insets insets2, int n10, int n11, int n12, int n13, boolean bl10, boolean bl11, int n14, int n15, int n16, int n17, int n18, int n19, int n20, int n21, int n22) {
        pictureViewer.init(bl, n, bl2, color, n2, image, color2, n3, insets, color3, color4, bl3, color5, color6, easingParamsArray, bl4, n4, image2, image3, image4, resourceLocator, bl5, string, bl6, n5, image5, n6, bl7, n7, n8, bl8, n9, bl9, insets2, n10, n11, n12, n13, bl10, bl11, n14, n15, n16, n17, n18, n19, n20, n21, n22);
    }

    public static void initPopupView(PopupView popupView, boolean bl, int n, Image image, boolean bl2, float f2, boolean bl3, Color color, int n2, int n3, Color[] colorArray, Image[] imageArray, int n4, int n5, int n6, EasingParams[] easingParamsArray, boolean bl4, KeyframeAnimation[] keyframeAnimationArray, int n7, KeyframeAnimation[] keyframeAnimationArray2, boolean bl5, LayoutAttribs layoutAttribs, KeyframeAnimation[] keyframeAnimationArray3, String string, boolean bl6, float f3, float f4, float f5, float f6, float f7, float f8, int n8, int n9, Image image2, int n10, boolean bl7, boolean bl8, boolean bl9, int n11, float f9, float f10, float f11, float f12, float f13, float f14, int n12, int n13, Insets insets, int[] nArray, int n14, boolean bl10, Rectangle rectangle, int n15, int n16, int n17, int n18, int n19) {
        popupView.init(bl, n, image, bl2, f2, bl3, color, n2, n3, colorArray, imageArray, n4, n5, n6, easingParamsArray, bl4, keyframeAnimationArray, n7, keyframeAnimationArray2, bl5, layoutAttribs, keyframeAnimationArray3, string, bl6, f3, f4, f5, f6, f7, f8, n8, n9, image2, n10, bl7, bl8, bl9, n11, f9, f10, f11, f12, f13, f14, n12, n13, insets, nArray, n14, bl10, rectangle, n15, n16, n17, n18, n19);
    }

    public static void initPreviewLine(PreviewLine previewLine, boolean bl, int n, Image image, boolean bl2, boolean bl3, int n2, int n3, Color[] colorArray, Image[] imageArray, int n4, int[] nArray, WidgetModel[] widgetModelArray, EasingParams[] easingParamsArray, boolean bl4, int[] nArray2, int[] nArray3, Image[] imageArray2, int n5, int n6, boolean bl5, InactiveAreaModel inactiveAreaModel, InputFieldModel inputFieldModel, KeyframeAnimation[] keyframeAnimationArray, boolean bl6, LayoutAttribs layoutAttribs, String string, int n7, Image image2, int n8, boolean bl7, int n9, Insets insets, boolean bl8, int n10, int n11, int n12) {
        previewLine.init(bl, n, image, bl2, bl3, n2, n3, colorArray, imageArray, n4, nArray, widgetModelArray, easingParamsArray, bl4, nArray2, nArray3, imageArray2, n5, n6, bl5, inactiveAreaModel, inputFieldModel, keyframeAnimationArray, bl6, layoutAttribs, string, n7, image2, n8, bl7, n9, insets, bl8, n10, n11, n12);
    }

    public static void initPureAir(PureAir pureAir, boolean bl, int n, int n2, boolean bl2, Color color, int n3, Color color2, boolean bl3, EasingParams[] easingParamsArray, boolean bl4, int n4, boolean bl5, String string, int n5, Insets insets, int n6, boolean bl6, int n7, int n8, int n9) {
        pureAir.init(bl, n, n2, bl2, color, n3, color2, bl3, easingParamsArray, bl4, n4, bl5, string, n5, insets, n6, bl6, n7, n8, n9);
    }

    public static void initPushUp(PushUp pushUp, boolean bl, int n, Image image, boolean bl2, boolean bl3, int n2, int n3, int n4, Color[] colorArray, Image[] imageArray, int n5, EasingParams[] easingParamsArray, boolean bl4, int[] nArray, int[] nArray2, Image[] imageArray2, int n6, int n7, KeyframeAnimation[] keyframeAnimationArray, boolean bl5, LayoutAttribs layoutAttribs, String string, int n8, Image image2, int n9, boolean bl6, int n10, int n11, Insets insets, boolean bl7, int n12, int n13, int n14) {
        pushUp.init(bl, n, image, bl2, bl3, n2, n3, n4, colorArray, imageArray, n5, easingParamsArray, bl4, nArray, nArray2, imageArray2, n6, n7, keyframeAnimationArray, bl5, layoutAttribs, string, n8, image2, n9, bl6, n10, n11, insets, bl7, n12, n13, n14);
    }

    public static void initReferenceWidget(ReferenceWidget referenceWidget, boolean bl, int n, Image image, boolean bl2, boolean bl3, EasingParams[] easingParamsArray, boolean bl4, boolean bl5, int n2, KeyframeAnimation[] keyframeAnimationArray, boolean bl6, LayoutAttribs layoutAttribs, String string, int n3, Image image2, int n4, boolean bl7, int n5, Insets insets, boolean bl8, int n6, int n7, int n8) {
        referenceWidget.init(bl, n, image, bl2, bl3, easingParamsArray, bl4, bl5, n2, keyframeAnimationArray, bl6, layoutAttribs, string, n3, image2, n4, bl7, n5, insets, bl8, n6, n7, n8);
    }

    public static void initRunnerWidget(RunnerWidget runnerWidget, boolean bl, int n, boolean bl2, EasingParams[] easingParamsArray, boolean bl3, int n2, boolean bl4, int n3, String string, Adjustable[] adjustableArray, int[] nArray, int n4, int n5, Insets insets, boolean bl5, int n6, int n7, int n8, int n9, boolean bl6, int n10, int n11, int n12) {
        runnerWidget.init(bl, n, bl2, easingParamsArray, bl3, n2, bl4, n3, string, adjustableArray, nArray, n4, n5, insets, bl5, n6, n7, n8, n9, bl6, n10, n11, n12);
    }

    public static void initScreen(Screen screen, boolean bl, int n, Image image, boolean bl2, float f2, boolean bl3, Color color, int n2, int n3, EasingParams[] easingParamsArray, boolean bl4, KeyframeAnimation[] keyframeAnimationArray, int n4, KeyframeAnimation[] keyframeAnimationArray2, boolean bl5, LayoutAttribs layoutAttribs, KeyframeAnimation[] keyframeAnimationArray3, String string, boolean bl6, float f3, float f4, float f5, float f6, float f7, float f8, int n5, int n6, Image image2, int n7, boolean bl7, boolean bl8, boolean bl9, float f9, float f10, float f11, float f12, float f13, float f14, int n8, int n9, Insets insets, int[] nArray, int n10, boolean bl10, int n11, int n12, int n13, int n14) {
        screen.init(bl, n, image, bl2, f2, bl3, color, n2, n3, easingParamsArray, bl4, keyframeAnimationArray, n4, keyframeAnimationArray2, bl5, layoutAttribs, keyframeAnimationArray3, string, bl6, f3, f4, f5, f6, f7, f8, n5, n6, image2, n7, bl7, bl8, bl9, f9, f10, f11, f12, f13, f14, n8, n9, insets, nArray, n10, bl10, n11, n12, n13, n14);
    }

    public static void initScreenArea(ScreenArea screenArea, boolean bl, int n, Image image, boolean bl2, float f2, boolean bl3, int n2, int n3, EasingParams[] easingParamsArray, boolean bl4, int n4, KeyframeAnimation[] keyframeAnimationArray, boolean bl5, LayoutAttribs layoutAttribs, String string, float f3, float f4, float f5, float f6, float f7, float f8, int n5, int n6, Image image2, int n7, boolean bl6, float f9, float f10, float f11, int n8, float f12, float f13, float f14, int n9, Insets insets, int n10, int[] nArray, int[] nArray2, boolean bl7, int n11, int n12, int n13, int n14) {
        screenArea.init(bl, n, image, bl2, f2, bl3, n2, n3, easingParamsArray, bl4, n4, keyframeAnimationArray, bl5, layoutAttribs, string, f3, f4, f5, f6, f7, f8, n5, n6, image2, n7, bl6, f9, f10, f11, n8, f12, f13, f14, n9, insets, n10, nArray, nArray2, bl7, n11, n12, n13, n14);
    }

    public static void initScrollableText(ScrollableText scrollableText, boolean bl, int n, int n2, boolean bl2, int n3, int n4, int n5, Color color, Color color2, Color color3, Color[] colorArray, Color[] colorArray2, Color color4, EasingParams[] easingParamsArray, boolean bl3, int n6, FontAttribs fontAttribs, int[] nArray, Color color5, int n7, boolean bl4, int n8, boolean bl5, int n9, String string, Insets insets, int[] nArray2, int n10, String string2, boolean bl6, Insets insets2, boolean bl7, int n11, int n12, int n13, int n14) {
        scrollableText.init(bl, n, n2, bl2, n3, n4, n5, color, color2, color3, colorArray, colorArray2, color4, easingParamsArray, bl3, n6, fontAttribs, nArray, color5, n7, bl4, n8, bl5, n9, string, insets, nArray2, n10, string2, bl6, insets2, bl7, n11, n12, n13, n14);
    }

    public static void initScrollbar(Scrollbar scrollbar, boolean bl, Adjustable adjustable, int n, Image image, boolean bl2, boolean bl3, Color[] colorArray, Color[] colorArray2, Color[] colorArray3, EasingParams[] easingParamsArray, EasingParams[] easingParamsArray2, boolean bl4, Color[] colorArray4, int n2, StaticImageModel staticImageModel, StaticImageModel staticImageModel2, Image[] imageArray, StaticImageModel staticImageModel3, Image[] imageArray2, Image[] imageArray3, boolean bl5, boolean bl6, KeyframeAnimation[] keyframeAnimationArray, boolean bl7, LayoutAttribs layoutAttribs, int n3, String string, int n4, int n5, int n6, int n7, int n8, Image image2, int n9, boolean bl8, int n10, boolean bl9, int n11, int n12, int n13, int n14, int n15, Insets insets, int n16, int n17, int n18, int n19, boolean bl10, int n20, boolean bl11, int n21, int n22) {
        scrollbar.init(bl, adjustable, n, image, bl2, bl3, colorArray, colorArray2, colorArray3, easingParamsArray, easingParamsArray2, bl4, colorArray4, n2, staticImageModel, staticImageModel2, imageArray, staticImageModel3, imageArray2, imageArray3, bl5, bl6, keyframeAnimationArray, bl7, layoutAttribs, n3, string, n4, n5, n6, n7, n8, image2, n9, bl8, n10, bl9, n11, n12, n13, n14, n15, insets, n16, n17, n18, n19, bl10, n20, bl11, n21, n22);
    }

    public static void initSequencedImage(SequencedImage sequencedImage, boolean bl, int n, boolean bl2, Color color, int n2, Color color2, boolean bl3, EasingParams[] easingParamsArray, boolean bl4, int n3, boolean bl5, String string, boolean bl6, Image[] imageArray, int n4, Insets insets, int n5, int n6, int n7, boolean bl7, int n8, int n9, int n10) {
        sequencedImage.init(bl, n, bl2, color, n2, color2, bl3, easingParamsArray, bl4, n3, bl5, string, bl6, imageArray, n4, insets, n5, n6, n7, bl7, n8, n9, n10);
    }

    public static void initSlider(Slider slider, boolean bl, int n, Image image, boolean bl2, boolean bl3, Color[] colorArray, Color[] colorArray2, Color[] colorArray3, Color[] colorArray4, EasingParams[] easingParamsArray, EasingParams[] easingParamsArray2, boolean bl4, int n2, Color[] colorArray5, int n3, StaticImageModel staticImageModel, StaticImageModel staticImageModel2, StaticImageModel[] staticImageModelArray, StaticImageModel staticImageModel3, Image[] imageArray, Image[] imageArray2, StaticImageModel staticImageModel4, int n4, int n5, Image[] imageArray3, Image[] imageArray4, Image[] imageArray5, Image[] imageArray6, boolean bl5, KeyframeAnimation[] keyframeAnimationArray, boolean bl6, LayoutAttribs layoutAttribs, String string, int n6, int n7, int n8, boolean bl7, int n9, Image image2, int n10, boolean bl8, boolean bl9, int n11, int n12, int n13, Insets insets, int n14, boolean bl10, boolean bl11, int n15, int n16, boolean bl12, int n17, boolean bl13, int n18, int n19) {
        slider.init(bl, n, image, bl2, bl3, colorArray, colorArray2, colorArray3, colorArray4, easingParamsArray, easingParamsArray2, bl4, n2, colorArray5, n3, staticImageModel, staticImageModel2, staticImageModelArray, staticImageModel3, imageArray, imageArray2, staticImageModel4, n4, n5, imageArray3, imageArray4, imageArray5, imageArray6, bl5, keyframeAnimationArray, bl6, layoutAttribs, string, n6, n7, n8, bl7, n9, image2, n10, bl8, bl9, n11, n12, n13, insets, n14, bl10, bl11, n15, n16, bl12, n17, bl13, n18, n19);
    }

    public static void initSpeller(Speller speller, boolean bl, int n, int n2, String[] stringArray, Image image, boolean bl2, boolean bl3, int n3, int n4, int n5, int n6, int n7, Color[] colorArray, Image[] imageArray, int n8, EasingParams[] easingParamsArray, boolean bl4, int[] nArray, int[] nArray2, Image[] imageArray2, int n9, int n10, Image[] imageArray3, InactiveAreaModel inactiveAreaModel, String string, KeyframeAnimation[] keyframeAnimationArray, int n11, int n12, ContainerModel containerModel, String[] stringArray2, boolean bl5, LayoutAttribs layoutAttribs, int n13, int n14, int n15, String string2, boolean bl6, int n16, Image image2, int n17, boolean bl7, int n18, boolean bl8, SpellerData spellerData, Insets insets, int n19, int n20, int n21, Insets insets2, boolean bl9, int n22, int n23, int n24) {
        speller.init(bl, n, n2, stringArray, image, bl2, bl3, n3, n4, n5, n6, n7, colorArray, imageArray, n8, easingParamsArray, bl4, nArray, nArray2, imageArray2, n9, n10, imageArray3, inactiveAreaModel, string, keyframeAnimationArray, n11, n12, containerModel, stringArray2, bl5, layoutAttribs, n13, n14, n15, string2, bl6, n16, image2, n17, bl7, n18, bl8, spellerData, insets, n19, n20, n21, insets2, bl9, n22, n23, n24);
    }

    public static void initSpellerButton(SpellerButton spellerButton, boolean bl, boolean bl2, int n, Image image, boolean bl3, boolean bl4, int n2, Color[] colorArray, Color[] colorArray2, EasingParams[] easingParamsArray, EasingParams[] easingParamsArray2, boolean bl5, String string, Color[] colorArray3, int n3, StaticImageModel staticImageModel, StaticImageModel staticImageModel2, Image[] imageArray, Image[] imageArray2, Image[] imageArray3, Image[] imageArray4, Image[] imageArray5, Color[] colorArray4, StaticImageModel staticImageModel3, StaticImageModel staticImageModel4, StaticImageModel staticImageModel5, boolean bl6, KeyframeAnimation[] keyframeAnimationArray, boolean bl7, LayoutAttribs layoutAttribs, String string2, boolean bl8, int n4, Image image2, int n5, boolean bl9, int n6, int n7, boolean bl10, int n8, int n9, int n10, int n11, int n12, String string3, TextAreaModel[] textAreaModelArray, TextAreaModel[] textAreaModelArray2, Color[] colorArray5, boolean bl11, Color[] colorArray6, Insets insets, Point[] pointArray, boolean bl12, int n13, int n14, int n15) {
        spellerButton.init(bl, bl2, n, image, bl3, bl4, n2, colorArray, colorArray2, easingParamsArray, easingParamsArray2, bl5, string, colorArray3, n3, staticImageModel, staticImageModel2, imageArray, imageArray2, imageArray3, imageArray4, imageArray5, colorArray4, staticImageModel3, staticImageModel4, staticImageModel5, bl6, keyframeAnimationArray, bl7, layoutAttribs, string2, bl8, n4, image2, n5, bl9, n6, n7, bl10, n8, n9, n10, n11, n12, string3, textAreaModelArray, textAreaModelArray2, colorArray5, bl11, colorArray6, insets, pointArray, bl12, n13, n14, n15);
    }

    public static void initSpinLabel(SpinLabel spinLabel, boolean bl, int n, int n2, boolean bl2, Image image, int n3, int n4, int n5, int n6, Color color, Color color2, Color color3, Color[] colorArray, Color[] colorArray2, Color color4, boolean bl3, EasingParams[] easingParamsArray, boolean bl4, FontAttribs fontAttribs, int[] nArray, Color color5, int n7, boolean bl5, int n8, boolean bl6, int n9, int n10, String string, Insets insets, int n11, Image image2, boolean bl7, int n12, String string2, boolean bl8, Insets insets2, String[] stringArray, boolean bl9, int n13, int n14, int n15, int n16) {
        spinLabel.init(bl, n, n2, bl2, image, n3, n4, n5, n6, color, color2, color3, colorArray, colorArray2, color4, bl3, easingParamsArray, bl4, fontAttribs, nArray, color5, n7, bl5, n8, bl6, n9, n10, string, insets, n11, image2, bl7, n12, string2, bl8, insets2, stringArray, bl9, n13, n14, n15, n16);
    }

    public static void initStaticImage(StaticImage staticImage, boolean bl, int n, boolean bl2, Color color, int n2, Color color2, boolean bl3, EasingParams[] easingParamsArray, boolean bl4, Color color3, int n3, boolean bl5, Gradient gradient, Color[] colorArray, int n4, Image image, boolean bl6, String string, int n5, Insets insets, boolean bl7, int n6, int n7, int n8) {
        staticImage.init(bl, n, bl2, color, n2, color2, bl3, easingParamsArray, bl4, color3, n3, bl5, gradient, colorArray, n4, image, bl6, string, n5, insets, bl7, n6, n7, n8);
    }

    public static void initStatistics(Statistics statistics, boolean bl, int n, boolean bl2, Image[] imageArray, int n2, Image image, EasingParams[] easingParamsArray, boolean bl3, Image[] imageArray2, Image[] imageArray3, int n3, boolean bl4, Image[] imageArray4, String string, int n4, Image[] imageArray5, float[] fArray, int[] nArray, int n5, int n6, Color[] colorArray, FontAttribs[] fontAttribsArray, int[] nArray2, Insets insets, int n7, int[] nArray3, Color[] colorArray2, int[] nArray4, boolean bl5, int n8, int n9, Image image2, int[] nArray5, int n10, int n11, int n12, Image image3, int[] nArray6, int n13, int n14) {
        statistics.init(bl, n, bl2, imageArray, n2, image, easingParamsArray, bl3, imageArray2, imageArray3, n3, bl4, imageArray4, string, n4, imageArray5, fArray, nArray, n5, n6, colorArray, fontAttribsArray, nArray2, insets, n7, nArray3, colorArray2, nArray4, bl5, n8, n9, image2, nArray5, n10, n11, n12, image3, nArray6, n13, n14);
    }

    public static void initTextArea(TextArea textArea, boolean bl, int n, int n2, int n3, boolean bl2, int n4, int n5, int n6, Color color, Color color2, Color color3, Color[] colorArray, Color[] colorArray2, Color color4, int n7, int n8, EasingParams[] easingParamsArray, boolean bl3, FontAttribs fontAttribs, int[] nArray, Color color5, int n9, boolean bl4, int n10, boolean bl5, int n11, int n12, String string, Insets insets, boolean bl6, boolean bl7, int n13, String string2, boolean bl8, Insets insets2, boolean bl9, int n14, int n15, int n16, int n17) {
        textArea.init(bl, n, n2, n3, bl2, n4, n5, n6, color, color2, color3, colorArray, colorArray2, color4, n7, n8, easingParamsArray, bl3, fontAttribs, nArray, color5, n9, bl4, n10, bl5, n11, n12, string, insets, bl6, bl7, n13, string2, bl8, insets2, bl9, n14, n15, n16, n17);
    }

    public static void initThresholdNotifier(ThresholdNotifier thresholdNotifier, boolean bl, int n, boolean bl2, EasingParams[] easingParamsArray, boolean bl3, int n2, boolean bl4, String string, int n3, Insets insets, int n4, int n5, int n6, boolean bl5, int n7, int n8, int n9) {
        thresholdNotifier.init(bl, n, bl2, easingParamsArray, bl3, n2, bl4, string, n3, insets, n4, n5, n6, bl5, n7, n8, n9);
    }

    public static void initTimerWidget(TimerWidget timerWidget, boolean bl, int n, boolean bl2, boolean bl3, int n2, int n3, EasingParams[] easingParamsArray, boolean bl4, int n4, boolean bl5, String string, int n5, boolean bl6, Insets insets, boolean bl7, int n6, int n7, int n8) {
        timerWidget.init(bl, n, bl2, bl3, n2, n3, easingParamsArray, bl4, n4, bl5, string, n5, bl6, insets, bl7, n6, n7, n8);
    }

    public static void initTouchArea(TouchArea touchArea, boolean bl, boolean bl2, boolean bl3, int n, boolean bl4, boolean bl5, boolean bl6, int n2, int n3, int n4, EasingParams[] easingParamsArray, boolean bl7, int n5, boolean bl8, int n6, String string, boolean bl9, int n7, int n8, Insets insets, Color color, Image image, int n9, int n10, int n11, int n12, int n13, boolean bl10, int n14, int n15, int n16) {
        touchArea.init(bl, bl2, bl3, n, bl4, bl5, bl6, n2, n3, n4, easingParamsArray, bl7, n5, bl8, n6, string, bl9, n7, n8, insets, color, image, n9, n10, n11, n12, n13, bl10, n14, n15, n16);
    }

    public static void initTransformContainer(TransformContainer transformContainer, boolean bl, int n, Image image, boolean bl2, float f2, boolean bl3, int n2, int n3, EasingParams[] easingParamsArray, boolean bl4, int n4, KeyframeAnimation[] keyframeAnimationArray, boolean bl5, LayoutAttribs layoutAttribs, String string, float f3, float f4, float f5, float f6, float f7, float f8, int n5, int n6, Image image2, int n7, boolean bl6, float f9, float f10, float f11, float f12, float f13, float f14, int n8, Insets insets, boolean bl7, int n9, int n10, int n11, int n12) {
        transformContainer.init(bl, n, image, bl2, f2, bl3, n2, n3, easingParamsArray, bl4, n4, keyframeAnimationArray, bl5, layoutAttribs, string, f3, f4, f5, f6, f7, f8, n5, n6, image2, n7, bl6, f9, f10, f11, f12, f13, f14, n8, insets, bl7, n9, n10, n11, n12);
    }

    public static void initView(View view, boolean bl, int n, Image image, boolean bl2, float f2, boolean bl3, Color color, int n2, int n3, EasingParams[] easingParamsArray, boolean bl4, KeyframeAnimation[] keyframeAnimationArray, int n4, KeyframeAnimation[] keyframeAnimationArray2, boolean bl5, LayoutAttribs layoutAttribs, KeyframeAnimation[] keyframeAnimationArray3, String string, boolean bl6, float f3, float f4, float f5, float f6, float f7, float f8, int n5, int n6, Image image2, int n7, boolean bl7, boolean bl8, boolean bl9, float f9, float f10, float f11, float f12, float f13, float f14, int n8, int n9, Insets insets, int[] nArray, int n10, boolean bl10, int n11, int n12, int n13, int n14) {
        view.init(bl, n, image, bl2, f2, bl3, color, n2, n3, easingParamsArray, bl4, keyframeAnimationArray, n4, keyframeAnimationArray2, bl5, layoutAttribs, keyframeAnimationArray3, string, bl6, f3, f4, f5, f6, f7, f8, n5, n6, image2, n7, bl7, bl8, bl9, f9, f10, f11, f12, f13, f14, n8, n9, insets, nArray, n10, bl10, n11, n12, n13, n14);
    }

    public static void initWidgetList(WidgetList widgetList, boolean bl, int n, int n2, int n3, int n4, int n5, Image image, boolean bl2, boolean bl3, int n6, boolean bl4, StaticImageModel staticImageModel, boolean bl5, boolean bl6, Image image2, Insets insets, boolean bl7, EasingParams[] easingParamsArray, boolean bl8, int n7, int n8, int n9, ListItemModel[] listItemModelArray, boolean bl9, int n10, int n11, int n12, boolean bl10, int n13, int n14, boolean bl11, Point[] pointArray, KeyframeAnimation[] keyframeAnimationArray, boolean bl12, LayoutAttribs layoutAttribs, boolean bl13, int n15, WidgetModel widgetModel, boolean bl14, TextAreaModel textAreaModel, boolean bl15, int n16, boolean bl16, String string, boolean bl17, int n17, Insets insets2, int n18, Image image3, int n19, boolean bl18, int n20, int n21, int n22, Image[] imageArray, Insets[] insetsArray, int n23, int n24, int n25, int n26, int n27, int n28, Insets insets3, boolean bl19, int n29, int n30, int n31) {
        widgetList.init(bl, n, n2, n3, n4, n5, image, bl2, bl3, n6, bl4, staticImageModel, bl5, bl6, image2, insets, bl7, easingParamsArray, bl8, n7, n8, n9, listItemModelArray, bl9, n10, n11, n12, bl10, n13, n14, bl11, pointArray, keyframeAnimationArray, bl12, layoutAttribs, bl13, n15, widgetModel, bl14, textAreaModel, bl15, n16, bl16, string, bl17, n17, insets2, n18, image3, n19, bl18, n20, n21, n22, imageArray, insetsArray, n23, n24, n25, n26, n27, n28, insets3, bl19, n29, n30, n31);
    }
}

