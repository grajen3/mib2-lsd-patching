/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.global.view.internal;

import de.vw.mib.animation.animations.Keyframe;
import de.vw.mib.animation.animations.KeyframeAnimation;
import de.vw.mib.animation.animations.references.ValueReference;
import de.vw.mib.animation.animations.references.ValueReferenceMetric;
import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.datapool.ExtendedListItemControl;
import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Color4b;
import de.vw.mib.graphics.Gradient;
import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.Point;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.font.FontAttribs;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.list.ListItemControlListener;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import de.vw.mib.properties.values.LayoutAttribs;
import de.vw.mib.properties.values.SpellerData;
import de.vw.mib.view.internal.AbstractWithServicesViewHandler;
import de.vw.mib.view.internal.CloneData;
import de.vw.mib.widgets.animation.Animatable;
import de.vw.mib.widgets.event.AdjustmentListener;
import de.vw.mib.widgets.interfaces.Adjustable;
import de.vw.mib.widgets.interfaces.CompositeBackground;
import de.vw.mib.widgets.interfaces.Decoratable;
import de.vw.mib.widgets.interfaces.Draggable;
import de.vw.mib.widgets.interfaces.Focusable;
import de.vw.mib.widgets.interfaces.Glowable;
import de.vw.mib.widgets.interfaces.PushUpHandler;
import de.vw.mib.widgets.interfaces.WidgetCloneFactoryRegister;
import de.vw.mib.widgets.interfaces.WidgetCloneable;
import de.vw.mib.widgets.layout.Layoutable;
import de.vw.mib.widgets.log.Loggable;
import de.vw.mib.widgets.models.AbstractButtonModel;
import de.vw.mib.widgets.models.AbstractCarSpecificModel;
import de.vw.mib.widgets.models.AbstractImageModel;
import de.vw.mib.widgets.models.AbstractSliderModel;
import de.vw.mib.widgets.models.AbstractSpellerModel;
import de.vw.mib.widgets.models.AbstractTextModel;
import de.vw.mib.widgets.models.AsiaSpellerModel;
import de.vw.mib.widgets.models.BackgroundContainerModel;
import de.vw.mib.widgets.models.ButtonModel;
import de.vw.mib.widgets.models.CanvasModel;
import de.vw.mib.widgets.models.CarImageModel;
import de.vw.mib.widgets.models.CarStatusModel;
import de.vw.mib.widgets.models.ClimateModel;
import de.vw.mib.widgets.models.ClockModel;
import de.vw.mib.widgets.models.ColorChooserModel;
import de.vw.mib.widgets.models.CommonImageModel;
import de.vw.mib.widgets.models.CompassModel;
import de.vw.mib.widgets.models.ContainerModel;
import de.vw.mib.widgets.models.ControlBarModel;
import de.vw.mib.widgets.models.DropDownButtonModel;
import de.vw.mib.widgets.models.DropDownModel;
import de.vw.mib.widgets.models.DynamicImageModel;
import de.vw.mib.widgets.models.EnergyFlowModel;
import de.vw.mib.widgets.models.FlowListModel;
import de.vw.mib.widgets.models.GEMAdapterModel;
import de.vw.mib.widgets.models.GenericCarAdjusterModel;
import de.vw.mib.widgets.models.GuidanceModel;
import de.vw.mib.widgets.models.InactiveAreaModel;
import de.vw.mib.widgets.models.InputFieldModel;
import de.vw.mib.widgets.models.InstrumentsModel;
import de.vw.mib.widgets.models.IrisModel;
import de.vw.mib.widgets.models.LabeledIconModel;
import de.vw.mib.widgets.models.LaneGuidanceModel;
import de.vw.mib.widgets.models.ListItemModel;
import de.vw.mib.widgets.models.ListModel;
import de.vw.mib.widgets.models.MeshWidgetModel;
import de.vw.mib.widgets.models.OPSModel;
import de.vw.mib.widgets.models.ParticleSystemModel;
import de.vw.mib.widgets.models.PictureViewerModel;
import de.vw.mib.widgets.models.PopupViewModel;
import de.vw.mib.widgets.models.PreviewLineModel;
import de.vw.mib.widgets.models.PureAirModel;
import de.vw.mib.widgets.models.PushUpModel;
import de.vw.mib.widgets.models.ReferenceWidgetModel;
import de.vw.mib.widgets.models.RunnerWidgetModel;
import de.vw.mib.widgets.models.ScreenAreaModel;
import de.vw.mib.widgets.models.ScreenModel;
import de.vw.mib.widgets.models.ScrollableTextModel;
import de.vw.mib.widgets.models.ScrollbarModel;
import de.vw.mib.widgets.models.SequencedImageModel;
import de.vw.mib.widgets.models.SliderModel;
import de.vw.mib.widgets.models.SpellerButtonModel;
import de.vw.mib.widgets.models.SpellerModel;
import de.vw.mib.widgets.models.SpinLabelModel;
import de.vw.mib.widgets.models.StaticImageModel;
import de.vw.mib.widgets.models.StatisticsModel;
import de.vw.mib.widgets.models.TemplateListModel;
import de.vw.mib.widgets.models.TextAreaModel;
import de.vw.mib.widgets.models.ThresholdNotifierModel;
import de.vw.mib.widgets.models.TimerWidgetModel;
import de.vw.mib.widgets.models.TouchAreaModel;
import de.vw.mib.widgets.models.TransformContainerModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetListModel;
import de.vw.mib.widgets.models.WidgetModel;
import de.vw.mib.widgets.speller.PreviewLineChangedListener;
import java.lang.reflect.Array;
import org.dsi.ifc.global.ResourceLocator;

public abstract class ViewHandlerBase
extends AbstractWithServicesViewHandler {
    private static final AbstractButtonModel ABSTRACT_BUTTON_MODEL_FALLBACK = null;
    private static final AbstractCarSpecificModel ABSTRACT_CAR_SPECIFIC_MODEL_FALLBACK = null;
    private static final AbstractImageModel ABSTRACT_IMAGE_MODEL_FALLBACK = null;
    private static final AbstractSliderModel ABSTRACT_SLIDER_MODEL_FALLBACK = null;
    private static final AbstractSpellerModel ABSTRACT_SPELLER_MODEL_FALLBACK = null;
    private static final AbstractTextModel ABSTRACT_TEXT_MODEL_FALLBACK = null;
    private static final Adjustable ADJUSTABLE_FALLBACK = null;
    private static final AdjustmentListener ADJUSTMENT_LISTENER_FALLBACK = null;
    private static final Animatable ANIMATABLE_FALLBACK = null;
    private static final AsiaSpellerModel ASIA_SPELLER_MODEL_FALLBACK = null;
    private static final BackgroundContainerModel BACKGROUND_CONTAINER_MODEL_FALLBACK = null;
    private static final boolean BOOLEAN_FALLBACK;
    private static final boolean[] BOOLEAN_ARRAY_FALLBACK;
    private static final ButtonModel BUTTON_MODEL_FALLBACK;
    private static final CanvasModel CANVAS_MODEL_FALLBACK;
    private static final CarImageModel CAR_IMAGE_MODEL_FALLBACK;
    private static final CarStatusModel CAR_STATUS_MODEL_FALLBACK;
    private static final ClimateModel CLIMATE_MODEL_FALLBACK;
    private static final ClockModel CLOCK_MODEL_FALLBACK;
    private static final Color COLOR_FALLBACK;
    private static final ColorChooserModel COLOR_CHOOSER_MODEL_FALLBACK;
    private static final CommonImageModel COMMON_IMAGE_MODEL_FALLBACK;
    private static final CompassModel COMPASS_MODEL_FALLBACK;
    private static final CompositeBackground COMPOSITE_BACKGROUND_FALLBACK;
    private static final ContainerModel CONTAINER_MODEL_FALLBACK;
    private static final ControlBarModel CONTROL_BAR_MODEL_FALLBACK;
    private static final Decoratable DECORATABLE_FALLBACK;
    private static final Draggable DRAGGABLE_FALLBACK;
    private static final DropDownButtonModel DROP_DOWN_BUTTON_MODEL_FALLBACK;
    private static final DropDownModel DROP_DOWN_MODEL_FALLBACK;
    private static final DynamicImageModel DYNAMIC_IMAGE_MODEL_FALLBACK;
    private static final EasingParams EASING_PARAMS_FALLBACK;
    private static final EasingParams[] EASING_PARAMS_ARRAY_FALLBACK;
    private static final EnergyFlowModel ENERGY_FLOW_MODEL_FALLBACK;
    private static final FixFormatterFieldData FIX_FORMATTER_FIELD_DATA_FALLBACK;
    private static final float FLOAT_FALLBACK;
    private static final FlowListModel FLOW_LIST_MODEL_FALLBACK;
    private static final Focusable FOCUSABLE_FALLBACK;
    private static final FontAttribs FONT_ATTRIBS_FALLBACK;
    private static final GEMAdapterModel GEMADAPTER_MODEL_FALLBACK;
    private static final GenericCarAdjusterModel GENERIC_CAR_ADJUSTER_MODEL_FALLBACK;
    private static final Glowable GLOWABLE_FALLBACK;
    private static final Gradient GRADIENT_FALLBACK;
    private static final GuidanceModel GUIDANCE_MODEL_FALLBACK;
    private static final Image IMAGE_FALLBACK;
    private static final Image[] IMAGE_ARRAY_FALLBACK;
    private static final InactiveAreaModel INACTIVE_AREA_MODEL_FALLBACK;
    private static final InputFieldModel INPUT_FIELD_MODEL_FALLBACK;
    private static final Insets INSETS_FALLBACK;
    private static final InstrumentsModel INSTRUMENTS_MODEL_FALLBACK;
    private static final int INTEGER_FALLBACK;
    private static final int[] INTEGER_ARRAY_FALLBACK;
    private static final IrisModel IRIS_MODEL_FALLBACK;
    private static final Keyframe KEYFRAME_FALLBACK;
    private static final KeyframeAnimation KEYFRAME_ANIMATION_FALLBACK;
    private static final LabeledIconValue LABELED_ICON_FALLBACK;
    private static final LabeledIconModel LABELED_ICON_MODEL_FALLBACK;
    private static final LaneGuidanceModel LANE_GUIDANCE_MODEL_FALLBACK;
    private static final LayoutAttribs LAYOUT_ATTRIBS_FALLBACK;
    private static final Layoutable LAYOUTABLE_FALLBACK;
    private static final ListItemControlListener LIST_ITEM_CONTROL_LISTENER_FALLBACK;
    private static final ListItemModel LIST_ITEM_MODEL_FALLBACK;
    private static final ListModel LIST_MODEL_FALLBACK;
    private static final Loggable LOGGABLE_FALLBACK;
    private static final long LONG_FALLBACK;
    private static final MeshWidgetModel MESH_WIDGET_MODEL_FALLBACK;
    private static final OPSModel OPSMODEL_FALLBACK;
    private static final ParticleSystemModel PARTICLE_SYSTEM_MODEL_FALLBACK;
    private static final PictureViewerModel PICTURE_VIEWER_MODEL_FALLBACK;
    private static final Point POINT_FALLBACK;
    private static final PopupViewModel POPUP_VIEW_MODEL_FALLBACK;
    private static final PreviewLineChangedListener PREVIEW_LINE_CHANGED_LISTENER_FALLBACK;
    private static final PreviewLineModel PREVIEW_LINE_MODEL_FALLBACK;
    private static final PureAirModel PURE_AIR_MODEL_FALLBACK;
    private static final PushUpHandler PUSH_UP_HANDLER_FALLBACK;
    private static final PushUpModel PUSH_UP_MODEL_FALLBACK;
    private static final Rectangle RECTANGLE_FALLBACK;
    private static final ReferenceWidgetModel REFERENCE_WIDGET_MODEL_FALLBACK;
    private static final ResourceLocator RESOURCE_LOCATOR_FALLBACK;
    private static final RunnerWidgetModel RUNNER_WIDGET_MODEL_FALLBACK;
    private static final ScreenAreaModel SCREEN_AREA_MODEL_FALLBACK;
    private static final ScreenModel SCREEN_MODEL_FALLBACK;
    private static final ScrollableTextModel SCROLLABLE_TEXT_MODEL_FALLBACK;
    private static final ScrollbarModel SCROLLBAR_MODEL_FALLBACK;
    private static final SequencedImageModel SEQUENCED_IMAGE_MODEL_FALLBACK;
    private static final SliderModel SLIDER_MODEL_FALLBACK;
    private static final SpellerButtonModel SPELLER_BUTTON_MODEL_FALLBACK;
    private static final SpellerModel SPELLER_MODEL_FALLBACK;
    private static final SpinLabelModel SPIN_LABEL_MODEL_FALLBACK;
    private static final StaticImageModel STATIC_IMAGE_MODEL_FALLBACK;
    private static final StatisticsModel STATISTICS_MODEL_FALLBACK;
    private static final String STRING_FALLBACK;
    private static final String[] STRING_ARRAY_FALLBACK;
    private static final TemplateListModel TEMPLATE_LIST_MODEL_FALLBACK;
    private static final TextAreaModel TEXT_AREA_MODEL_FALLBACK;
    private static final ThresholdNotifierModel THRESHOLD_NOTIFIER_MODEL_FALLBACK;
    private static final TimerWidgetModel TIMER_WIDGET_MODEL_FALLBACK;
    private static final TouchAreaModel TOUCH_AREA_MODEL_FALLBACK;
    private static final TransformContainerModel TRANSFORM_CONTAINER_MODEL_FALLBACK;
    private static final ValueReference VALUE_REFERENCE_FALLBACK;
    private static final ValueReferenceMetric VALUE_REFERENCE_METRIC_FALLBACK;
    private static final ViewModel VIEW_MODEL_FALLBACK;
    private static final WidgetCloneFactoryRegister WIDGET_CLONE_FACTORY_REGISTER_FALLBACK;
    private static final WidgetCloneable WIDGET_CLONEABLE_FALLBACK;
    private static final WidgetListModel WIDGET_LIST_MODEL_FALLBACK;
    private static final WidgetModel WIDGET_MODEL_FALLBACK;

    protected boolean getBoolean(int n) {
        return this.services.getModelDatapool().getBoolean(n);
    }

    protected void setBoolean(int n, boolean bl) {
        this.services.getModelDatapool().setBoolean(n, bl);
    }

    protected FixFormatterFieldData getFixFormatterFieldData(int n) {
        return this.services.getModelDatapool().getFixFormatterFieldData(n);
    }

    protected void setFixFormatterFieldData(int n, FixFormatterFieldData fixFormatterFieldData) {
        this.services.getModelDatapool().setFixFormatterFieldData(n, fixFormatterFieldData);
    }

    protected boolean[] getFlagVector(int n) {
        return this.services.getModelDatapool().getFlagVector(n);
    }

    protected void setFlagVector(int n, boolean[] blArray) {
        this.services.getModelDatapool().setFlagVector(n, blArray);
    }

    protected float getFloat(int n) {
        return this.services.getModelDatapool().getFloat(n);
    }

    protected void setFloat(int n, float f2) {
        this.services.getModelDatapool().setFloat(n, f2);
    }

    protected int getInteger(int n) {
        return this.services.getModelDatapool().getInteger(n);
    }

    protected void setInteger(int n, int n2) {
        this.services.getModelDatapool().setInteger(n, n2);
    }

    protected int[] getIntegerVector(int n) {
        return this.services.getModelDatapool().getIntegerVector(n);
    }

    protected void setIntegerVector(int n, int[] nArray) {
        this.services.getModelDatapool().setIntegerVector(n, nArray);
    }

    protected long getLong(int n) {
        return this.services.getModelDatapool().getLong(n);
    }

    protected void setLong(int n, long l) {
        this.services.getModelDatapool().setLong(n, l);
    }

    protected ResourceLocator getResourceLocator(int n) {
        return this.services.getModelDatapool().getResourceLocator(n);
    }

    protected void setResourceLocator(int n, ResourceLocator resourceLocator) {
        this.services.getModelDatapool().setResourceLocator(n, resourceLocator);
    }

    protected SpellerData getSpellerData(int n) {
        return this.services.getModelDatapool().getSpellerData(n);
    }

    protected void setSpellerData(int n, SpellerData spellerData) {
        this.services.getModelDatapool().setSpellerData(n, spellerData);
    }

    protected String getString(int n) {
        return this.services.getModelDatapool().getString(n);
    }

    protected void setString(int n, String string) {
        this.services.getModelDatapool().setString(n, string);
    }

    protected String[] getStringVector(int n) {
        return this.services.getModelDatapool().getStringVector(n);
    }

    protected void setStringVector(int n, String[] stringArray) {
        this.services.getModelDatapool().setStringVector(n, stringArray);
    }

    protected Image[] getImageArray(int n) {
        return this.services.getSkinImagePool().getImageArray(n);
    }

    protected Image getImage(int n) {
        return this.services.getSkinImagePool().getImage(n);
    }

    protected EasingParams[] getEasingParamsArray(int n) {
        return this.services.getSkinAnimationPool().getEasingParamsArray(n);
    }

    protected KeyframeAnimation[] getKeyframeAnimationArray(int n) {
        return this.services.getSkinAnimationPool().getKeyframeAnimationArray(n);
    }

    protected boolean evalBoolean(int n) {
        return this.services.getGlobalExpressionEvaluator().evalBoolean(n);
    }

    protected short evalShort(int n) {
        return this.services.getGlobalExpressionEvaluator().evalShort(n);
    }

    protected int evalInt(int n) {
        return this.services.getGlobalExpressionEvaluator().evalInt(n);
    }

    protected long evalLong(int n) {
        return this.services.getGlobalExpressionEvaluator().evalLong(n);
    }

    protected float evalFloat(int n) {
        return this.services.getGlobalExpressionEvaluator().evalFloat(n);
    }

    protected double evalDouble(int n) {
        return this.services.getGlobalExpressionEvaluator().evalDouble(n);
    }

    protected String evalString(int n) {
        return this.services.getGlobalExpressionEvaluator().evalString(n);
    }

    protected Object evalObject(int n) {
        return this.services.getGlobalExpressionEvaluator().evalObject(n);
    }

    protected String getI18nString(int n) {
        return this.services.getI18nDatapool().getString(n);
    }

    protected String[] getI18nStrings(int n) {
        return this.services.getI18nDatapool().getStrings(n);
    }

    protected ExtendedListItemControl getDynamicListItemControl(int n) {
        return this.services.getDynamicListItemControlManager().getListItemControl(n);
    }

    protected ExtendedListItemControl getAppAdapterListItemControl(int n) {
        return this.appServices.getAppAdapterListItemControlManager().getListItemControl(n);
    }

    public boolean getInternBoolean(int n, CloneData cloneData) {
        throw new IllegalArgumentException("Unknown target type access from extern to view");
    }

    public float getInternFloat(int n, CloneData cloneData) {
        throw new IllegalArgumentException("Unknown target type access from extern to view");
    }

    public int getInternInt(int n, CloneData cloneData) {
        throw new IllegalArgumentException("Unknown target type access from extern to view");
    }

    public long getInternLong(int n, CloneData cloneData) {
        throw new IllegalArgumentException("Unknown target type access from extern to view");
    }

    public short getInternShort(int n, CloneData cloneData) {
        throw new IllegalArgumentException("Unknown target type access from extern to view");
    }

    public Object getInternObject(int n, CloneData cloneData) {
        throw new IllegalArgumentException("Unknown widget type access from extern to view");
    }

    public AbstractButtonModel at(AbstractButtonModel[] abstractButtonModelArray, int n) {
        try {
            return abstractButtonModelArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, abstractButtonModelArray, n, "null");
            return ABSTRACT_BUTTON_MODEL_FALLBACK;
        }
    }

    public AbstractCarSpecificModel at(AbstractCarSpecificModel[] abstractCarSpecificModelArray, int n) {
        try {
            return abstractCarSpecificModelArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, abstractCarSpecificModelArray, n, "null");
            return ABSTRACT_CAR_SPECIFIC_MODEL_FALLBACK;
        }
    }

    public AbstractImageModel at(AbstractImageModel[] abstractImageModelArray, int n) {
        try {
            return abstractImageModelArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, abstractImageModelArray, n, "null");
            return ABSTRACT_IMAGE_MODEL_FALLBACK;
        }
    }

    public AbstractSliderModel at(AbstractSliderModel[] abstractSliderModelArray, int n) {
        try {
            return abstractSliderModelArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, abstractSliderModelArray, n, "null");
            return ABSTRACT_SLIDER_MODEL_FALLBACK;
        }
    }

    public AbstractSpellerModel at(AbstractSpellerModel[] abstractSpellerModelArray, int n) {
        try {
            return abstractSpellerModelArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, abstractSpellerModelArray, n, "null");
            return ABSTRACT_SPELLER_MODEL_FALLBACK;
        }
    }

    public AbstractTextModel at(AbstractTextModel[] abstractTextModelArray, int n) {
        try {
            return abstractTextModelArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, abstractTextModelArray, n, "null");
            return ABSTRACT_TEXT_MODEL_FALLBACK;
        }
    }

    public Adjustable at(Adjustable[] adjustableArray, int n) {
        try {
            return adjustableArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, adjustableArray, n, "null");
            return ADJUSTABLE_FALLBACK;
        }
    }

    public AdjustmentListener at(AdjustmentListener[] adjustmentListenerArray, int n) {
        try {
            return adjustmentListenerArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, adjustmentListenerArray, n, "null");
            return ADJUSTMENT_LISTENER_FALLBACK;
        }
    }

    public Animatable at(Animatable[] animatableArray, int n) {
        try {
            return animatableArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, animatableArray, n, "null");
            return ANIMATABLE_FALLBACK;
        }
    }

    public AsiaSpellerModel at(AsiaSpellerModel[] asiaSpellerModelArray, int n) {
        try {
            return asiaSpellerModelArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, asiaSpellerModelArray, n, "null");
            return ASIA_SPELLER_MODEL_FALLBACK;
        }
    }

    public BackgroundContainerModel at(BackgroundContainerModel[] backgroundContainerModelArray, int n) {
        try {
            return backgroundContainerModelArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, backgroundContainerModelArray, n, "null");
            return BACKGROUND_CONTAINER_MODEL_FALLBACK;
        }
    }

    public boolean at(boolean[] blArray, int n) {
        try {
            return blArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, blArray, n, "false");
            return false;
        }
    }

    public boolean[] at(boolean[][] blArray, int n) {
        try {
            return blArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, blArray, n, "null");
            return BOOLEAN_ARRAY_FALLBACK;
        }
    }

    public ButtonModel at(ButtonModel[] buttonModelArray, int n) {
        try {
            return buttonModelArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, buttonModelArray, n, "null");
            return BUTTON_MODEL_FALLBACK;
        }
    }

    public CanvasModel at(CanvasModel[] canvasModelArray, int n) {
        try {
            return canvasModelArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, canvasModelArray, n, "null");
            return CANVAS_MODEL_FALLBACK;
        }
    }

    public CarImageModel at(CarImageModel[] carImageModelArray, int n) {
        try {
            return carImageModelArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, carImageModelArray, n, "null");
            return CAR_IMAGE_MODEL_FALLBACK;
        }
    }

    public CarStatusModel at(CarStatusModel[] carStatusModelArray, int n) {
        try {
            return carStatusModelArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, carStatusModelArray, n, "null");
            return CAR_STATUS_MODEL_FALLBACK;
        }
    }

    public ClimateModel at(ClimateModel[] climateModelArray, int n) {
        try {
            return climateModelArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, climateModelArray, n, "null");
            return CLIMATE_MODEL_FALLBACK;
        }
    }

    public ClockModel at(ClockModel[] clockModelArray, int n) {
        try {
            return clockModelArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, clockModelArray, n, "null");
            return CLOCK_MODEL_FALLBACK;
        }
    }

    public Color at(Color[] colorArray, int n) {
        try {
            return colorArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, colorArray, n, "new de.vw.mib.graphics.Color( new de.vw.mib.graphics.Color4b( 0xffffffff ) )");
            return COLOR_FALLBACK;
        }
    }

    public ColorChooserModel at(ColorChooserModel[] colorChooserModelArray, int n) {
        try {
            return colorChooserModelArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, colorChooserModelArray, n, "null");
            return COLOR_CHOOSER_MODEL_FALLBACK;
        }
    }

    public CommonImageModel at(CommonImageModel[] commonImageModelArray, int n) {
        try {
            return commonImageModelArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, commonImageModelArray, n, "null");
            return COMMON_IMAGE_MODEL_FALLBACK;
        }
    }

    public CompassModel at(CompassModel[] compassModelArray, int n) {
        try {
            return compassModelArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, compassModelArray, n, "null");
            return COMPASS_MODEL_FALLBACK;
        }
    }

    public CompositeBackground at(CompositeBackground[] compositeBackgroundArray, int n) {
        try {
            return compositeBackgroundArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, compositeBackgroundArray, n, "null");
            return COMPOSITE_BACKGROUND_FALLBACK;
        }
    }

    public ContainerModel at(ContainerModel[] containerModelArray, int n) {
        try {
            return containerModelArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, containerModelArray, n, "null");
            return CONTAINER_MODEL_FALLBACK;
        }
    }

    public ControlBarModel at(ControlBarModel[] controlBarModelArray, int n) {
        try {
            return controlBarModelArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, controlBarModelArray, n, "null");
            return CONTROL_BAR_MODEL_FALLBACK;
        }
    }

    public Decoratable at(Decoratable[] decoratableArray, int n) {
        try {
            return decoratableArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, decoratableArray, n, "null");
            return DECORATABLE_FALLBACK;
        }
    }

    public Draggable at(Draggable[] draggableArray, int n) {
        try {
            return draggableArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, draggableArray, n, "null");
            return DRAGGABLE_FALLBACK;
        }
    }

    public DropDownButtonModel at(DropDownButtonModel[] dropDownButtonModelArray, int n) {
        try {
            return dropDownButtonModelArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, dropDownButtonModelArray, n, "null");
            return DROP_DOWN_BUTTON_MODEL_FALLBACK;
        }
    }

    public DropDownModel at(DropDownModel[] dropDownModelArray, int n) {
        try {
            return dropDownModelArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, dropDownModelArray, n, "null");
            return DROP_DOWN_MODEL_FALLBACK;
        }
    }

    public DynamicImageModel at(DynamicImageModel[] dynamicImageModelArray, int n) {
        try {
            return dynamicImageModelArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, dynamicImageModelArray, n, "null");
            return DYNAMIC_IMAGE_MODEL_FALLBACK;
        }
    }

    public EasingParams at(EasingParams[] easingParamsArray, int n) {
        try {
            return easingParamsArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, easingParamsArray, n, "null");
            return EASING_PARAMS_FALLBACK;
        }
    }

    public EasingParams[] at(EasingParams[][] easingParamsArray, int n) {
        try {
            return easingParamsArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, easingParamsArray, n, "null");
            return EASING_PARAMS_ARRAY_FALLBACK;
        }
    }

    public EnergyFlowModel at(EnergyFlowModel[] energyFlowModelArray, int n) {
        try {
            return energyFlowModelArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, energyFlowModelArray, n, "null");
            return ENERGY_FLOW_MODEL_FALLBACK;
        }
    }

    public FixFormatterFieldData at(FixFormatterFieldData[] fixFormatterFieldDataArray, int n) {
        try {
            return fixFormatterFieldDataArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, fixFormatterFieldDataArray, n, "null");
            return FIX_FORMATTER_FIELD_DATA_FALLBACK;
        }
    }

    public float at(float[] fArray, int n) {
        try {
            return fArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, fArray, n, "0.0f");
            return 0.0f;
        }
    }

    public FlowListModel at(FlowListModel[] flowListModelArray, int n) {
        try {
            return flowListModelArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, flowListModelArray, n, "null");
            return FLOW_LIST_MODEL_FALLBACK;
        }
    }

    public Focusable at(Focusable[] focusableArray, int n) {
        try {
            return focusableArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, focusableArray, n, "null");
            return FOCUSABLE_FALLBACK;
        }
    }

    public FontAttribs at(FontAttribs[] fontAttribsArray, int n) {
        try {
            return fontAttribsArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, fontAttribsArray, n, "new de.vw.mib.graphics.font.FontAttribs()");
            return FONT_ATTRIBS_FALLBACK;
        }
    }

    public GEMAdapterModel at(GEMAdapterModel[] gEMAdapterModelArray, int n) {
        try {
            return gEMAdapterModelArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, gEMAdapterModelArray, n, "null");
            return GEMADAPTER_MODEL_FALLBACK;
        }
    }

    public GenericCarAdjusterModel at(GenericCarAdjusterModel[] genericCarAdjusterModelArray, int n) {
        try {
            return genericCarAdjusterModelArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, genericCarAdjusterModelArray, n, "null");
            return GENERIC_CAR_ADJUSTER_MODEL_FALLBACK;
        }
    }

    public Glowable at(Glowable[] glowableArray, int n) {
        try {
            return glowableArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, glowableArray, n, "null");
            return GLOWABLE_FALLBACK;
        }
    }

    public Gradient at(Gradient[] gradientArray, int n) {
        try {
            return gradientArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, gradientArray, n, "new de.vw.mib.graphics.Gradient()");
            return GRADIENT_FALLBACK;
        }
    }

    public GuidanceModel at(GuidanceModel[] guidanceModelArray, int n) {
        try {
            return guidanceModelArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, guidanceModelArray, n, "null");
            return GUIDANCE_MODEL_FALLBACK;
        }
    }

    public Image at(Image[] imageArray, int n) {
        try {
            return imageArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, imageArray, n, "null");
            return IMAGE_FALLBACK;
        }
    }

    public Image[] at(Image[][] imageArray, int n) {
        try {
            return imageArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, imageArray, n, "null");
            return IMAGE_ARRAY_FALLBACK;
        }
    }

    public InactiveAreaModel at(InactiveAreaModel[] inactiveAreaModelArray, int n) {
        try {
            return inactiveAreaModelArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, inactiveAreaModelArray, n, "null");
            return INACTIVE_AREA_MODEL_FALLBACK;
        }
    }

    public InputFieldModel at(InputFieldModel[] inputFieldModelArray, int n) {
        try {
            return inputFieldModelArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, inputFieldModelArray, n, "null");
            return INPUT_FIELD_MODEL_FALLBACK;
        }
    }

    public Insets at(Insets[] insetsArray, int n) {
        try {
            return insetsArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, insetsArray, n, "new de.vw.mib.graphics.Insets()");
            return INSETS_FALLBACK;
        }
    }

    public InstrumentsModel at(InstrumentsModel[] instrumentsModelArray, int n) {
        try {
            return instrumentsModelArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, instrumentsModelArray, n, "null");
            return INSTRUMENTS_MODEL_FALLBACK;
        }
    }

    public int at(int[] nArray, int n) {
        try {
            return nArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, nArray, n, "0");
            return 0;
        }
    }

    public int[] at(int[][] nArray, int n) {
        try {
            return nArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, nArray, n, "null");
            return INTEGER_ARRAY_FALLBACK;
        }
    }

    public IrisModel at(IrisModel[] irisModelArray, int n) {
        try {
            return irisModelArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, irisModelArray, n, "null");
            return IRIS_MODEL_FALLBACK;
        }
    }

    public Keyframe at(Keyframe[] keyframeArray, int n) {
        try {
            return keyframeArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, keyframeArray, n, "null");
            return KEYFRAME_FALLBACK;
        }
    }

    public KeyframeAnimation at(KeyframeAnimation[] keyframeAnimationArray, int n) {
        try {
            return keyframeAnimationArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, keyframeAnimationArray, n, "null");
            return KEYFRAME_ANIMATION_FALLBACK;
        }
    }

    public LabeledIconValue at(LabeledIconValue[] labeledIconValueArray, int n) {
        try {
            return labeledIconValueArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, labeledIconValueArray, n, "null");
            return LABELED_ICON_FALLBACK;
        }
    }

    public LabeledIconModel at(LabeledIconModel[] labeledIconModelArray, int n) {
        try {
            return labeledIconModelArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, labeledIconModelArray, n, "null");
            return LABELED_ICON_MODEL_FALLBACK;
        }
    }

    public LaneGuidanceModel at(LaneGuidanceModel[] laneGuidanceModelArray, int n) {
        try {
            return laneGuidanceModelArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, laneGuidanceModelArray, n, "null");
            return LANE_GUIDANCE_MODEL_FALLBACK;
        }
    }

    public LayoutAttribs at(LayoutAttribs[] layoutAttribsArray, int n) {
        try {
            return layoutAttribsArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, layoutAttribsArray, n, "new de.vw.mib.properties.values.LayoutAttribs()");
            return LAYOUT_ATTRIBS_FALLBACK;
        }
    }

    public Layoutable at(Layoutable[] layoutableArray, int n) {
        try {
            return layoutableArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, layoutableArray, n, "null");
            return LAYOUTABLE_FALLBACK;
        }
    }

    public ListItemControlListener at(ListItemControlListener[] listItemControlListenerArray, int n) {
        try {
            return listItemControlListenerArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, listItemControlListenerArray, n, "null");
            return LIST_ITEM_CONTROL_LISTENER_FALLBACK;
        }
    }

    public ListItemModel at(ListItemModel[] listItemModelArray, int n) {
        try {
            return listItemModelArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, listItemModelArray, n, "null");
            return LIST_ITEM_MODEL_FALLBACK;
        }
    }

    public ListModel at(ListModel[] listModelArray, int n) {
        try {
            return listModelArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, listModelArray, n, "null");
            return LIST_MODEL_FALLBACK;
        }
    }

    public Loggable at(Loggable[] loggableArray, int n) {
        try {
            return loggableArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, loggableArray, n, "null");
            return LOGGABLE_FALLBACK;
        }
    }

    public long at(long[] lArray, int n) {
        try {
            return lArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, lArray, n, "0l");
            return 0L;
        }
    }

    public MeshWidgetModel at(MeshWidgetModel[] meshWidgetModelArray, int n) {
        try {
            return meshWidgetModelArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, meshWidgetModelArray, n, "null");
            return MESH_WIDGET_MODEL_FALLBACK;
        }
    }

    public OPSModel at(OPSModel[] oPSModelArray, int n) {
        try {
            return oPSModelArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, oPSModelArray, n, "null");
            return OPSMODEL_FALLBACK;
        }
    }

    public ParticleSystemModel at(ParticleSystemModel[] particleSystemModelArray, int n) {
        try {
            return particleSystemModelArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, particleSystemModelArray, n, "null");
            return PARTICLE_SYSTEM_MODEL_FALLBACK;
        }
    }

    public PictureViewerModel at(PictureViewerModel[] pictureViewerModelArray, int n) {
        try {
            return pictureViewerModelArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, pictureViewerModelArray, n, "null");
            return PICTURE_VIEWER_MODEL_FALLBACK;
        }
    }

    public Point at(Point[] pointArray, int n) {
        try {
            return pointArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, pointArray, n, "new de.vw.mib.graphics.Point()");
            return POINT_FALLBACK;
        }
    }

    public PopupViewModel at(PopupViewModel[] popupViewModelArray, int n) {
        try {
            return popupViewModelArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, popupViewModelArray, n, "null");
            return POPUP_VIEW_MODEL_FALLBACK;
        }
    }

    public PreviewLineChangedListener at(PreviewLineChangedListener[] previewLineChangedListenerArray, int n) {
        try {
            return previewLineChangedListenerArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, previewLineChangedListenerArray, n, "null");
            return PREVIEW_LINE_CHANGED_LISTENER_FALLBACK;
        }
    }

    public PreviewLineModel at(PreviewLineModel[] previewLineModelArray, int n) {
        try {
            return previewLineModelArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, previewLineModelArray, n, "null");
            return PREVIEW_LINE_MODEL_FALLBACK;
        }
    }

    public PureAirModel at(PureAirModel[] pureAirModelArray, int n) {
        try {
            return pureAirModelArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, pureAirModelArray, n, "null");
            return PURE_AIR_MODEL_FALLBACK;
        }
    }

    public PushUpHandler at(PushUpHandler[] pushUpHandlerArray, int n) {
        try {
            return pushUpHandlerArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, pushUpHandlerArray, n, "null");
            return PUSH_UP_HANDLER_FALLBACK;
        }
    }

    public PushUpModel at(PushUpModel[] pushUpModelArray, int n) {
        try {
            return pushUpModelArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, pushUpModelArray, n, "null");
            return PUSH_UP_MODEL_FALLBACK;
        }
    }

    public Rectangle at(Rectangle[] rectangleArray, int n) {
        try {
            return rectangleArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, rectangleArray, n, "new de.vw.mib.graphics.Rectangle()");
            return RECTANGLE_FALLBACK;
        }
    }

    public ReferenceWidgetModel at(ReferenceWidgetModel[] referenceWidgetModelArray, int n) {
        try {
            return referenceWidgetModelArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, referenceWidgetModelArray, n, "null");
            return REFERENCE_WIDGET_MODEL_FALLBACK;
        }
    }

    public ResourceLocator at(ResourceLocator[] resourceLocatorArray, int n) {
        try {
            return resourceLocatorArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, resourceLocatorArray, n, "null");
            return RESOURCE_LOCATOR_FALLBACK;
        }
    }

    public RunnerWidgetModel at(RunnerWidgetModel[] runnerWidgetModelArray, int n) {
        try {
            return runnerWidgetModelArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, runnerWidgetModelArray, n, "null");
            return RUNNER_WIDGET_MODEL_FALLBACK;
        }
    }

    public ScreenAreaModel at(ScreenAreaModel[] screenAreaModelArray, int n) {
        try {
            return screenAreaModelArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, screenAreaModelArray, n, "null");
            return SCREEN_AREA_MODEL_FALLBACK;
        }
    }

    public ScreenModel at(ScreenModel[] screenModelArray, int n) {
        try {
            return screenModelArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, screenModelArray, n, "null");
            return SCREEN_MODEL_FALLBACK;
        }
    }

    public ScrollableTextModel at(ScrollableTextModel[] scrollableTextModelArray, int n) {
        try {
            return scrollableTextModelArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, scrollableTextModelArray, n, "null");
            return SCROLLABLE_TEXT_MODEL_FALLBACK;
        }
    }

    public ScrollbarModel at(ScrollbarModel[] scrollbarModelArray, int n) {
        try {
            return scrollbarModelArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, scrollbarModelArray, n, "null");
            return SCROLLBAR_MODEL_FALLBACK;
        }
    }

    public SequencedImageModel at(SequencedImageModel[] sequencedImageModelArray, int n) {
        try {
            return sequencedImageModelArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, sequencedImageModelArray, n, "null");
            return SEQUENCED_IMAGE_MODEL_FALLBACK;
        }
    }

    public SliderModel at(SliderModel[] sliderModelArray, int n) {
        try {
            return sliderModelArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, sliderModelArray, n, "null");
            return SLIDER_MODEL_FALLBACK;
        }
    }

    public SpellerButtonModel at(SpellerButtonModel[] spellerButtonModelArray, int n) {
        try {
            return spellerButtonModelArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, spellerButtonModelArray, n, "null");
            return SPELLER_BUTTON_MODEL_FALLBACK;
        }
    }

    public SpellerModel at(SpellerModel[] spellerModelArray, int n) {
        try {
            return spellerModelArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, spellerModelArray, n, "null");
            return SPELLER_MODEL_FALLBACK;
        }
    }

    public SpinLabelModel at(SpinLabelModel[] spinLabelModelArray, int n) {
        try {
            return spinLabelModelArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, spinLabelModelArray, n, "null");
            return SPIN_LABEL_MODEL_FALLBACK;
        }
    }

    public StaticImageModel at(StaticImageModel[] staticImageModelArray, int n) {
        try {
            return staticImageModelArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, staticImageModelArray, n, "null");
            return STATIC_IMAGE_MODEL_FALLBACK;
        }
    }

    public StatisticsModel at(StatisticsModel[] statisticsModelArray, int n) {
        try {
            return statisticsModelArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, statisticsModelArray, n, "null");
            return STATISTICS_MODEL_FALLBACK;
        }
    }

    public String at(String[] stringArray, int n) {
        try {
            return stringArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, stringArray, n, "\"\"");
            return "";
        }
    }

    public String[] at(String[][] stringArray, int n) {
        try {
            return stringArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, stringArray, n, "null");
            return STRING_ARRAY_FALLBACK;
        }
    }

    public TemplateListModel at(TemplateListModel[] templateListModelArray, int n) {
        try {
            return templateListModelArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, templateListModelArray, n, "null");
            return TEMPLATE_LIST_MODEL_FALLBACK;
        }
    }

    public TextAreaModel at(TextAreaModel[] textAreaModelArray, int n) {
        try {
            return textAreaModelArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, textAreaModelArray, n, "null");
            return TEXT_AREA_MODEL_FALLBACK;
        }
    }

    public ThresholdNotifierModel at(ThresholdNotifierModel[] thresholdNotifierModelArray, int n) {
        try {
            return thresholdNotifierModelArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, thresholdNotifierModelArray, n, "null");
            return THRESHOLD_NOTIFIER_MODEL_FALLBACK;
        }
    }

    public TimerWidgetModel at(TimerWidgetModel[] timerWidgetModelArray, int n) {
        try {
            return timerWidgetModelArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, timerWidgetModelArray, n, "null");
            return TIMER_WIDGET_MODEL_FALLBACK;
        }
    }

    public TouchAreaModel at(TouchAreaModel[] touchAreaModelArray, int n) {
        try {
            return touchAreaModelArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, touchAreaModelArray, n, "null");
            return TOUCH_AREA_MODEL_FALLBACK;
        }
    }

    public TransformContainerModel at(TransformContainerModel[] transformContainerModelArray, int n) {
        try {
            return transformContainerModelArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, transformContainerModelArray, n, "null");
            return TRANSFORM_CONTAINER_MODEL_FALLBACK;
        }
    }

    public ValueReference at(ValueReference[] valueReferenceArray, int n) {
        try {
            return valueReferenceArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, valueReferenceArray, n, "null");
            return VALUE_REFERENCE_FALLBACK;
        }
    }

    public ValueReferenceMetric at(ValueReferenceMetric[] valueReferenceMetricArray, int n) {
        try {
            return valueReferenceMetricArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, valueReferenceMetricArray, n, "null");
            return VALUE_REFERENCE_METRIC_FALLBACK;
        }
    }

    public ViewModel at(ViewModel[] viewModelArray, int n) {
        try {
            return viewModelArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, viewModelArray, n, "null");
            return VIEW_MODEL_FALLBACK;
        }
    }

    public WidgetCloneFactoryRegister at(WidgetCloneFactoryRegister[] widgetCloneFactoryRegisterArray, int n) {
        try {
            return widgetCloneFactoryRegisterArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, widgetCloneFactoryRegisterArray, n, "null");
            return WIDGET_CLONE_FACTORY_REGISTER_FALLBACK;
        }
    }

    public WidgetCloneable at(WidgetCloneable[] widgetCloneableArray, int n) {
        try {
            return widgetCloneableArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, widgetCloneableArray, n, "null");
            return WIDGET_CLONEABLE_FALLBACK;
        }
    }

    public WidgetListModel at(WidgetListModel[] widgetListModelArray, int n) {
        try {
            return widgetListModelArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, widgetListModelArray, n, "null");
            return WIDGET_LIST_MODEL_FALLBACK;
        }
    }

    public WidgetModel at(WidgetModel[] widgetModelArray, int n) {
        try {
            return widgetModelArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            this.fatalIOOB(indexOutOfBoundsException, widgetModelArray, n, "null");
            return WIDGET_MODEL_FALLBACK;
        }
    }

    private void fatalIOOB(IndexOutOfBoundsException indexOutOfBoundsException, Object object, int n, String string) {
        LogMessage logMessage = this.logger.fatal(2);
        logMessage.append("View: Index out of bound (index=");
        logMessage.append(n);
        logMessage.append(", range=0.");
        logMessage.append(Array.getLength(object));
        logMessage.append("): ");
        logMessage.append(indexOutOfBoundsException.getMessage());
        logMessage.attachThrowable(indexOutOfBoundsException);
        logMessage.log();
    }

    static {
        BOOLEAN_ARRAY_FALLBACK = null;
        BUTTON_MODEL_FALLBACK = null;
        CANVAS_MODEL_FALLBACK = null;
        CAR_IMAGE_MODEL_FALLBACK = null;
        CAR_STATUS_MODEL_FALLBACK = null;
        CLIMATE_MODEL_FALLBACK = null;
        CLOCK_MODEL_FALLBACK = null;
        COLOR_FALLBACK = new Color(new Color4b(-1));
        COLOR_CHOOSER_MODEL_FALLBACK = null;
        COMMON_IMAGE_MODEL_FALLBACK = null;
        COMPASS_MODEL_FALLBACK = null;
        COMPOSITE_BACKGROUND_FALLBACK = null;
        CONTAINER_MODEL_FALLBACK = null;
        CONTROL_BAR_MODEL_FALLBACK = null;
        DECORATABLE_FALLBACK = null;
        DRAGGABLE_FALLBACK = null;
        DROP_DOWN_BUTTON_MODEL_FALLBACK = null;
        DROP_DOWN_MODEL_FALLBACK = null;
        DYNAMIC_IMAGE_MODEL_FALLBACK = null;
        EASING_PARAMS_FALLBACK = null;
        EASING_PARAMS_ARRAY_FALLBACK = null;
        ENERGY_FLOW_MODEL_FALLBACK = null;
        FIX_FORMATTER_FIELD_DATA_FALLBACK = null;
        FLOW_LIST_MODEL_FALLBACK = null;
        FOCUSABLE_FALLBACK = null;
        FONT_ATTRIBS_FALLBACK = new FontAttribs();
        GEMADAPTER_MODEL_FALLBACK = null;
        GENERIC_CAR_ADJUSTER_MODEL_FALLBACK = null;
        GLOWABLE_FALLBACK = null;
        GRADIENT_FALLBACK = new Gradient();
        GUIDANCE_MODEL_FALLBACK = null;
        IMAGE_FALLBACK = null;
        IMAGE_ARRAY_FALLBACK = null;
        INACTIVE_AREA_MODEL_FALLBACK = null;
        INPUT_FIELD_MODEL_FALLBACK = null;
        INSETS_FALLBACK = new Insets();
        INSTRUMENTS_MODEL_FALLBACK = null;
        INTEGER_ARRAY_FALLBACK = null;
        IRIS_MODEL_FALLBACK = null;
        KEYFRAME_FALLBACK = null;
        KEYFRAME_ANIMATION_FALLBACK = null;
        LABELED_ICON_FALLBACK = null;
        LABELED_ICON_MODEL_FALLBACK = null;
        LANE_GUIDANCE_MODEL_FALLBACK = null;
        LAYOUT_ATTRIBS_FALLBACK = new LayoutAttribs();
        LAYOUTABLE_FALLBACK = null;
        LIST_ITEM_CONTROL_LISTENER_FALLBACK = null;
        LIST_ITEM_MODEL_FALLBACK = null;
        LIST_MODEL_FALLBACK = null;
        LOGGABLE_FALLBACK = null;
        MESH_WIDGET_MODEL_FALLBACK = null;
        OPSMODEL_FALLBACK = null;
        PARTICLE_SYSTEM_MODEL_FALLBACK = null;
        PICTURE_VIEWER_MODEL_FALLBACK = null;
        POINT_FALLBACK = new Point();
        POPUP_VIEW_MODEL_FALLBACK = null;
        PREVIEW_LINE_CHANGED_LISTENER_FALLBACK = null;
        PREVIEW_LINE_MODEL_FALLBACK = null;
        PURE_AIR_MODEL_FALLBACK = null;
        PUSH_UP_HANDLER_FALLBACK = null;
        PUSH_UP_MODEL_FALLBACK = null;
        RECTANGLE_FALLBACK = new Rectangle();
        REFERENCE_WIDGET_MODEL_FALLBACK = null;
        RESOURCE_LOCATOR_FALLBACK = null;
        RUNNER_WIDGET_MODEL_FALLBACK = null;
        SCREEN_AREA_MODEL_FALLBACK = null;
        SCREEN_MODEL_FALLBACK = null;
        SCROLLABLE_TEXT_MODEL_FALLBACK = null;
        SCROLLBAR_MODEL_FALLBACK = null;
        SEQUENCED_IMAGE_MODEL_FALLBACK = null;
        SLIDER_MODEL_FALLBACK = null;
        SPELLER_BUTTON_MODEL_FALLBACK = null;
        SPELLER_MODEL_FALLBACK = null;
        SPIN_LABEL_MODEL_FALLBACK = null;
        STATIC_IMAGE_MODEL_FALLBACK = null;
        STATISTICS_MODEL_FALLBACK = null;
        STRING_ARRAY_FALLBACK = null;
        TEMPLATE_LIST_MODEL_FALLBACK = null;
        TEXT_AREA_MODEL_FALLBACK = null;
        THRESHOLD_NOTIFIER_MODEL_FALLBACK = null;
        TIMER_WIDGET_MODEL_FALLBACK = null;
        TOUCH_AREA_MODEL_FALLBACK = null;
        TRANSFORM_CONTAINER_MODEL_FALLBACK = null;
        VALUE_REFERENCE_FALLBACK = null;
        VALUE_REFERENCE_METRIC_FALLBACK = null;
        VIEW_MODEL_FALLBACK = null;
        WIDGET_CLONE_FACTORY_REGISTER_FALLBACK = null;
        WIDGET_CLONEABLE_FALLBACK = null;
        WIDGET_LIST_MODEL_FALLBACK = null;
        WIDGET_MODEL_FALLBACK = null;
    }
}

