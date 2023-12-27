/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.global.view.internal;

import de.vw.mib.view.internal.WidgetAnimator;
import de.vw.mib.widgets.models.AsiaSpellerModel;
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
import de.vw.mib.widgets.models.TextAreaModel;
import de.vw.mib.widgets.models.ThresholdNotifierModel;
import de.vw.mib.widgets.models.TimerWidgetModel;
import de.vw.mib.widgets.models.TouchAreaModel;
import de.vw.mib.widgets.models.TransformContainerModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetListModel;
import de.vw.mib.widgets.models.WidgetModel;

public final class WidgetAnimatorImpl
implements WidgetAnimator {
    @Override
    public void setAnimatableFloatValue(WidgetModel widgetModel, int n, int n2, float f2) {
        switch (n) {
            case 3: {
                WidgetAnimatorImpl.setAnimateFloatCanvas((CanvasModel)widgetModel, n2, f2);
                break;
            }
            case 17: {
                WidgetAnimatorImpl.setAnimateFloatFlowList((FlowListModel)widgetModel, n2, f2);
                break;
            }
            case 18: {
                WidgetAnimatorImpl.setAnimateFloatGEMAdapter((GEMAdapterModel)widgetModel, n2, f2);
                break;
            }
            case 23: {
                WidgetAnimatorImpl.setAnimateFloatInstruments((InstrumentsModel)widgetModel, n2, f2);
                break;
            }
            case 24: {
                WidgetAnimatorImpl.setAnimateFloatIris((IrisModel)widgetModel, n2, f2);
                break;
            }
            case 27: {
                WidgetAnimatorImpl.setAnimateFloatListItem((ListItemModel)widgetModel, n2, f2);
                break;
            }
            case 30: {
                WidgetAnimatorImpl.setAnimateFloatParticleSystem((ParticleSystemModel)widgetModel, n2, f2);
                break;
            }
            case 32: {
                WidgetAnimatorImpl.setAnimateFloatPopupView((PopupViewModel)widgetModel, n2, f2);
                break;
            }
            case 38: {
                WidgetAnimatorImpl.setAnimateFloatScreen((ScreenModel)widgetModel, n2, f2);
                break;
            }
            case 39: {
                WidgetAnimatorImpl.setAnimateFloatScreenArea((ScreenAreaModel)widgetModel, n2, f2);
                break;
            }
            case 53: {
                WidgetAnimatorImpl.setAnimateFloatTransformContainer((TransformContainerModel)widgetModel, n2, f2);
                break;
            }
            case 54: {
                WidgetAnimatorImpl.setAnimateFloatView((ViewModel)widgetModel, n2, f2);
                break;
            }
        }
    }

    @Override
    public float getAnimatableFloatValue(WidgetModel widgetModel, int n, int n2) {
        switch (n) {
            case 3: {
                return WidgetAnimatorImpl.getAnimateFloatCanvas((CanvasModel)widgetModel, n2);
            }
            case 17: {
                return WidgetAnimatorImpl.getAnimateFloatFlowList((FlowListModel)widgetModel, n2);
            }
            case 18: {
                return WidgetAnimatorImpl.getAnimateFloatGEMAdapter((GEMAdapterModel)widgetModel, n2);
            }
            case 23: {
                return WidgetAnimatorImpl.getAnimateFloatInstruments((InstrumentsModel)widgetModel, n2);
            }
            case 24: {
                return WidgetAnimatorImpl.getAnimateFloatIris((IrisModel)widgetModel, n2);
            }
            case 27: {
                return WidgetAnimatorImpl.getAnimateFloatListItem((ListItemModel)widgetModel, n2);
            }
            case 30: {
                return WidgetAnimatorImpl.getAnimateFloatParticleSystem((ParticleSystemModel)widgetModel, n2);
            }
            case 32: {
                return WidgetAnimatorImpl.getAnimateFloatPopupView((PopupViewModel)widgetModel, n2);
            }
            case 38: {
                return WidgetAnimatorImpl.getAnimateFloatScreen((ScreenModel)widgetModel, n2);
            }
            case 39: {
                return WidgetAnimatorImpl.getAnimateFloatScreenArea((ScreenAreaModel)widgetModel, n2);
            }
            case 53: {
                return WidgetAnimatorImpl.getAnimateFloatTransformContainer((TransformContainerModel)widgetModel, n2);
            }
            case 54: {
                return WidgetAnimatorImpl.getAnimateFloatView((ViewModel)widgetModel, n2);
            }
        }
        return 0.0f;
    }

    private static void setAnimateFloatCanvas(CanvasModel canvasModel, int n, float f2) {
        switch (n) {
            case 0: {
                canvasModel.set_aspectratio(f2);
                break;
            }
        }
    }

    private static float getAnimateFloatCanvas(CanvasModel canvasModel, int n) {
        switch (n) {
            case 0: {
                return canvasModel.get_aspectratio();
            }
        }
        return 0.0f;
    }

    private static void setAnimateFloatFlowList(FlowListModel flowListModel, int n, float f2) {
        switch (n) {
            case 0: {
                flowListModel.set_outlineAcceleration(f2);
                break;
            }
            case 1: {
                flowListModel.set_outlineCenterPosition(f2);
                break;
            }
            case 2: {
                flowListModel.set_outlineDebounce(f2);
                break;
            }
            case 3: {
                flowListModel.set_outlineOffset(f2);
                break;
            }
        }
    }

    private static float getAnimateFloatFlowList(FlowListModel flowListModel, int n) {
        switch (n) {
            case 0: {
                return flowListModel.get_outlineAcceleration();
            }
            case 1: {
                return flowListModel.get_outlineCenterPosition();
            }
            case 2: {
                return flowListModel.get_outlineDebounce();
            }
            case 3: {
                return flowListModel.get_outlineOffset();
            }
        }
        return 0.0f;
    }

    private static void setAnimateFloatGEMAdapter(GEMAdapterModel gEMAdapterModel, int n, float f2) {
        switch (n) {
            case 0: {
                gEMAdapterModel.set_alphaImageRotation(f2);
                break;
            }
            case 1: {
                gEMAdapterModel.set_pivotX(f2);
                break;
            }
            case 2: {
                gEMAdapterModel.set_pivotY(f2);
                break;
            }
            case 3: {
                gEMAdapterModel.set_pivotZ(f2);
                break;
            }
            case 4: {
                gEMAdapterModel.set_projectionFar(f2);
                break;
            }
            case 5: {
                gEMAdapterModel.set_projectionFOV(f2);
                break;
            }
            case 6: {
                gEMAdapterModel.set_projectionNear(f2);
                break;
            }
            case 7: {
                gEMAdapterModel.set_rotationX(f2);
                break;
            }
            case 8: {
                gEMAdapterModel.set_rotationY(f2);
                break;
            }
            case 9: {
                gEMAdapterModel.set_rotationZ(f2);
                break;
            }
            case 10: {
                gEMAdapterModel.set_scalingX(f2);
                break;
            }
            case 11: {
                gEMAdapterModel.set_scalingY(f2);
                break;
            }
            case 12: {
                gEMAdapterModel.set_scalingZ(f2);
                break;
            }
        }
    }

    private static float getAnimateFloatGEMAdapter(GEMAdapterModel gEMAdapterModel, int n) {
        switch (n) {
            case 0: {
                return gEMAdapterModel.get_alphaImageRotation();
            }
            case 1: {
                return gEMAdapterModel.get_pivotX();
            }
            case 2: {
                return gEMAdapterModel.get_pivotY();
            }
            case 3: {
                return gEMAdapterModel.get_pivotZ();
            }
            case 4: {
                return gEMAdapterModel.get_projectionFar();
            }
            case 5: {
                return gEMAdapterModel.get_projectionFOV();
            }
            case 6: {
                return gEMAdapterModel.get_projectionNear();
            }
            case 7: {
                return gEMAdapterModel.get_rotationX();
            }
            case 8: {
                return gEMAdapterModel.get_rotationY();
            }
            case 9: {
                return gEMAdapterModel.get_rotationZ();
            }
            case 10: {
                return gEMAdapterModel.get_scalingX();
            }
            case 11: {
                return gEMAdapterModel.get_scalingY();
            }
            case 12: {
                return gEMAdapterModel.get_scalingZ();
            }
        }
        return 0.0f;
    }

    private static void setAnimateFloatInstruments(InstrumentsModel instrumentsModel, int n, float f2) {
        switch (n) {
            case 0: {
                instrumentsModel.set_alphaImageRotation(f2);
                break;
            }
            case 1: {
                instrumentsModel.set_pivotX(f2);
                break;
            }
            case 2: {
                instrumentsModel.set_pivotY(f2);
                break;
            }
            case 3: {
                instrumentsModel.set_pivotZ(f2);
                break;
            }
            case 4: {
                instrumentsModel.set_projectionFar(f2);
                break;
            }
            case 5: {
                instrumentsModel.set_projectionFOV(f2);
                break;
            }
            case 6: {
                instrumentsModel.set_projectionNear(f2);
                break;
            }
            case 7: {
                instrumentsModel.set_rotationX(f2);
                break;
            }
            case 8: {
                instrumentsModel.set_rotationY(f2);
                break;
            }
            case 9: {
                instrumentsModel.set_rotationZ(f2);
                break;
            }
            case 10: {
                instrumentsModel.set_scalingX(f2);
                break;
            }
            case 11: {
                instrumentsModel.set_scalingY(f2);
                break;
            }
            case 12: {
                instrumentsModel.set_scalingZ(f2);
                break;
            }
        }
    }

    private static float getAnimateFloatInstruments(InstrumentsModel instrumentsModel, int n) {
        switch (n) {
            case 0: {
                return instrumentsModel.get_alphaImageRotation();
            }
            case 1: {
                return instrumentsModel.get_pivotX();
            }
            case 2: {
                return instrumentsModel.get_pivotY();
            }
            case 3: {
                return instrumentsModel.get_pivotZ();
            }
            case 4: {
                return instrumentsModel.get_projectionFar();
            }
            case 5: {
                return instrumentsModel.get_projectionFOV();
            }
            case 6: {
                return instrumentsModel.get_projectionNear();
            }
            case 7: {
                return instrumentsModel.get_rotationX();
            }
            case 8: {
                return instrumentsModel.get_rotationY();
            }
            case 9: {
                return instrumentsModel.get_rotationZ();
            }
            case 10: {
                return instrumentsModel.get_scalingX();
            }
            case 11: {
                return instrumentsModel.get_scalingY();
            }
            case 12: {
                return instrumentsModel.get_scalingZ();
            }
        }
        return 0.0f;
    }

    private static void setAnimateFloatIris(IrisModel irisModel, int n, float f2) {
        switch (n) {
            case 0: {
                irisModel.set_enterAnimationProgress(f2);
                break;
            }
        }
    }

    private static float getAnimateFloatIris(IrisModel irisModel, int n) {
        switch (n) {
            case 0: {
                return irisModel.get_enterAnimationProgress();
            }
        }
        return 0.0f;
    }

    private static void setAnimateFloatListItem(ListItemModel listItemModel, int n, float f2) {
        switch (n) {
            case 0: {
                listItemModel.set_alphaImageRotation(f2);
                break;
            }
            case 1: {
                listItemModel.set_pivotX(f2);
                break;
            }
            case 2: {
                listItemModel.set_pivotY(f2);
                break;
            }
            case 3: {
                listItemModel.set_pivotZ(f2);
                break;
            }
            case 4: {
                listItemModel.set_projectionFar(f2);
                break;
            }
            case 5: {
                listItemModel.set_projectionFOV(f2);
                break;
            }
            case 6: {
                listItemModel.set_projectionNear(f2);
                break;
            }
            case 7: {
                listItemModel.set_rotationX(f2);
                break;
            }
            case 8: {
                listItemModel.set_rotationY(f2);
                break;
            }
            case 9: {
                listItemModel.set_rotationZ(f2);
                break;
            }
            case 10: {
                listItemModel.set_scalingX(f2);
                break;
            }
            case 11: {
                listItemModel.set_scalingY(f2);
                break;
            }
            case 12: {
                listItemModel.set_scalingZ(f2);
                break;
            }
        }
    }

    private static float getAnimateFloatListItem(ListItemModel listItemModel, int n) {
        switch (n) {
            case 0: {
                return listItemModel.get_alphaImageRotation();
            }
            case 1: {
                return listItemModel.get_pivotX();
            }
            case 2: {
                return listItemModel.get_pivotY();
            }
            case 3: {
                return listItemModel.get_pivotZ();
            }
            case 4: {
                return listItemModel.get_projectionFar();
            }
            case 5: {
                return listItemModel.get_projectionFOV();
            }
            case 6: {
                return listItemModel.get_projectionNear();
            }
            case 7: {
                return listItemModel.get_rotationX();
            }
            case 8: {
                return listItemModel.get_rotationY();
            }
            case 9: {
                return listItemModel.get_rotationZ();
            }
            case 10: {
                return listItemModel.get_scalingX();
            }
            case 11: {
                return listItemModel.get_scalingY();
            }
            case 12: {
                return listItemModel.get_scalingZ();
            }
        }
        return 0.0f;
    }

    private static void setAnimateFloatParticleSystem(ParticleSystemModel particleSystemModel, int n, float f2) {
        switch (n) {
            case 0: {
                particleSystemModel.set_amplitude(f2);
                break;
            }
            case 1: {
                particleSystemModel.set_blurIntensity(f2);
                break;
            }
            case 2: {
                particleSystemModel.set_gapX(f2);
                break;
            }
            case 3: {
                particleSystemModel.set_gapY(f2);
                break;
            }
            case 4: {
                particleSystemModel.set_particleAlpha(f2);
                break;
            }
            case 5: {
                particleSystemModel.set_particleScale(f2);
                break;
            }
            case 6: {
                particleSystemModel.set_projectionFOV(f2);
                break;
            }
            case 7: {
                particleSystemModel.set_rotateX(f2);
                break;
            }
            case 8: {
                particleSystemModel.set_rotateY(f2);
                break;
            }
            case 9: {
                particleSystemModel.set_rotateZ(f2);
                break;
            }
            case 10: {
                particleSystemModel.set_tintIntensity(f2);
                break;
            }
            case 11: {
                particleSystemModel.set_vanishX(f2);
                break;
            }
            case 12: {
                particleSystemModel.set_vanishY(f2);
                break;
            }
            case 13: {
                particleSystemModel.set_z(f2);
                break;
            }
        }
    }

    private static float getAnimateFloatParticleSystem(ParticleSystemModel particleSystemModel, int n) {
        switch (n) {
            case 0: {
                return particleSystemModel.get_amplitude();
            }
            case 1: {
                return particleSystemModel.get_blurIntensity();
            }
            case 2: {
                return particleSystemModel.get_gapX();
            }
            case 3: {
                return particleSystemModel.get_gapY();
            }
            case 4: {
                return particleSystemModel.get_particleAlpha();
            }
            case 5: {
                return particleSystemModel.get_particleScale();
            }
            case 6: {
                return particleSystemModel.get_projectionFOV();
            }
            case 7: {
                return particleSystemModel.get_rotateX();
            }
            case 8: {
                return particleSystemModel.get_rotateY();
            }
            case 9: {
                return particleSystemModel.get_rotateZ();
            }
            case 10: {
                return particleSystemModel.get_tintIntensity();
            }
            case 11: {
                return particleSystemModel.get_vanishX();
            }
            case 12: {
                return particleSystemModel.get_vanishY();
            }
            case 13: {
                return particleSystemModel.get_z();
            }
        }
        return 0.0f;
    }

    private static void setAnimateFloatPopupView(PopupViewModel popupViewModel, int n, float f2) {
        switch (n) {
            case 0: {
                popupViewModel.set_alphaImageRotation(f2);
                break;
            }
            case 1: {
                popupViewModel.set_pivotX(f2);
                break;
            }
            case 2: {
                popupViewModel.set_pivotY(f2);
                break;
            }
            case 3: {
                popupViewModel.set_pivotZ(f2);
                break;
            }
            case 4: {
                popupViewModel.set_projectionFar(f2);
                break;
            }
            case 5: {
                popupViewModel.set_projectionFOV(f2);
                break;
            }
            case 6: {
                popupViewModel.set_projectionNear(f2);
                break;
            }
            case 7: {
                popupViewModel.set_rotationX(f2);
                break;
            }
            case 8: {
                popupViewModel.set_rotationY(f2);
                break;
            }
            case 9: {
                popupViewModel.set_rotationZ(f2);
                break;
            }
            case 10: {
                popupViewModel.set_scalingX(f2);
                break;
            }
            case 11: {
                popupViewModel.set_scalingY(f2);
                break;
            }
            case 12: {
                popupViewModel.set_scalingZ(f2);
                break;
            }
        }
    }

    private static float getAnimateFloatPopupView(PopupViewModel popupViewModel, int n) {
        switch (n) {
            case 0: {
                return popupViewModel.get_alphaImageRotation();
            }
            case 1: {
                return popupViewModel.get_pivotX();
            }
            case 2: {
                return popupViewModel.get_pivotY();
            }
            case 3: {
                return popupViewModel.get_pivotZ();
            }
            case 4: {
                return popupViewModel.get_projectionFar();
            }
            case 5: {
                return popupViewModel.get_projectionFOV();
            }
            case 6: {
                return popupViewModel.get_projectionNear();
            }
            case 7: {
                return popupViewModel.get_rotationX();
            }
            case 8: {
                return popupViewModel.get_rotationY();
            }
            case 9: {
                return popupViewModel.get_rotationZ();
            }
            case 10: {
                return popupViewModel.get_scalingX();
            }
            case 11: {
                return popupViewModel.get_scalingY();
            }
            case 12: {
                return popupViewModel.get_scalingZ();
            }
        }
        return 0.0f;
    }

    private static void setAnimateFloatScreen(ScreenModel screenModel, int n, float f2) {
        switch (n) {
            case 0: {
                screenModel.set_alphaImageRotation(f2);
                break;
            }
            case 1: {
                screenModel.set_pivotX(f2);
                break;
            }
            case 2: {
                screenModel.set_pivotY(f2);
                break;
            }
            case 3: {
                screenModel.set_pivotZ(f2);
                break;
            }
            case 4: {
                screenModel.set_projectionFar(f2);
                break;
            }
            case 5: {
                screenModel.set_projectionFOV(f2);
                break;
            }
            case 6: {
                screenModel.set_projectionNear(f2);
                break;
            }
            case 7: {
                screenModel.set_rotationX(f2);
                break;
            }
            case 8: {
                screenModel.set_rotationY(f2);
                break;
            }
            case 9: {
                screenModel.set_rotationZ(f2);
                break;
            }
            case 10: {
                screenModel.set_scalingX(f2);
                break;
            }
            case 11: {
                screenModel.set_scalingY(f2);
                break;
            }
            case 12: {
                screenModel.set_scalingZ(f2);
                break;
            }
        }
    }

    private static float getAnimateFloatScreen(ScreenModel screenModel, int n) {
        switch (n) {
            case 0: {
                return screenModel.get_alphaImageRotation();
            }
            case 1: {
                return screenModel.get_pivotX();
            }
            case 2: {
                return screenModel.get_pivotY();
            }
            case 3: {
                return screenModel.get_pivotZ();
            }
            case 4: {
                return screenModel.get_projectionFar();
            }
            case 5: {
                return screenModel.get_projectionFOV();
            }
            case 6: {
                return screenModel.get_projectionNear();
            }
            case 7: {
                return screenModel.get_rotationX();
            }
            case 8: {
                return screenModel.get_rotationY();
            }
            case 9: {
                return screenModel.get_rotationZ();
            }
            case 10: {
                return screenModel.get_scalingX();
            }
            case 11: {
                return screenModel.get_scalingY();
            }
            case 12: {
                return screenModel.get_scalingZ();
            }
        }
        return 0.0f;
    }

    private static void setAnimateFloatScreenArea(ScreenAreaModel screenAreaModel, int n, float f2) {
        switch (n) {
            case 0: {
                screenAreaModel.set_alphaImageRotation(f2);
                break;
            }
            case 1: {
                screenAreaModel.set_pivotX(f2);
                break;
            }
            case 2: {
                screenAreaModel.set_pivotY(f2);
                break;
            }
            case 3: {
                screenAreaModel.set_pivotZ(f2);
                break;
            }
            case 4: {
                screenAreaModel.set_projectionFar(f2);
                break;
            }
            case 5: {
                screenAreaModel.set_projectionFOV(f2);
                break;
            }
            case 6: {
                screenAreaModel.set_projectionNear(f2);
                break;
            }
            case 7: {
                screenAreaModel.set_rotationX(f2);
                break;
            }
            case 8: {
                screenAreaModel.set_rotationY(f2);
                break;
            }
            case 9: {
                screenAreaModel.set_rotationZ(f2);
                break;
            }
            case 10: {
                screenAreaModel.set_scalingX(f2);
                break;
            }
            case 11: {
                screenAreaModel.set_scalingY(f2);
                break;
            }
            case 12: {
                screenAreaModel.set_scalingZ(f2);
                break;
            }
        }
    }

    private static float getAnimateFloatScreenArea(ScreenAreaModel screenAreaModel, int n) {
        switch (n) {
            case 0: {
                return screenAreaModel.get_alphaImageRotation();
            }
            case 1: {
                return screenAreaModel.get_pivotX();
            }
            case 2: {
                return screenAreaModel.get_pivotY();
            }
            case 3: {
                return screenAreaModel.get_pivotZ();
            }
            case 4: {
                return screenAreaModel.get_projectionFar();
            }
            case 5: {
                return screenAreaModel.get_projectionFOV();
            }
            case 6: {
                return screenAreaModel.get_projectionNear();
            }
            case 7: {
                return screenAreaModel.get_rotationX();
            }
            case 8: {
                return screenAreaModel.get_rotationY();
            }
            case 9: {
                return screenAreaModel.get_rotationZ();
            }
            case 10: {
                return screenAreaModel.get_scalingX();
            }
            case 11: {
                return screenAreaModel.get_scalingY();
            }
            case 12: {
                return screenAreaModel.get_scalingZ();
            }
        }
        return 0.0f;
    }

    private static void setAnimateFloatTransformContainer(TransformContainerModel transformContainerModel, int n, float f2) {
        switch (n) {
            case 0: {
                transformContainerModel.set_alphaImageRotation(f2);
                break;
            }
            case 1: {
                transformContainerModel.set_pivotX(f2);
                break;
            }
            case 2: {
                transformContainerModel.set_pivotY(f2);
                break;
            }
            case 3: {
                transformContainerModel.set_pivotZ(f2);
                break;
            }
            case 4: {
                transformContainerModel.set_projectionFar(f2);
                break;
            }
            case 5: {
                transformContainerModel.set_projectionFOV(f2);
                break;
            }
            case 6: {
                transformContainerModel.set_projectionNear(f2);
                break;
            }
            case 7: {
                transformContainerModel.set_rotationX(f2);
                break;
            }
            case 8: {
                transformContainerModel.set_rotationY(f2);
                break;
            }
            case 9: {
                transformContainerModel.set_rotationZ(f2);
                break;
            }
            case 10: {
                transformContainerModel.set_scalingX(f2);
                break;
            }
            case 11: {
                transformContainerModel.set_scalingY(f2);
                break;
            }
            case 12: {
                transformContainerModel.set_scalingZ(f2);
                break;
            }
        }
    }

    private static float getAnimateFloatTransformContainer(TransformContainerModel transformContainerModel, int n) {
        switch (n) {
            case 0: {
                return transformContainerModel.get_alphaImageRotation();
            }
            case 1: {
                return transformContainerModel.get_pivotX();
            }
            case 2: {
                return transformContainerModel.get_pivotY();
            }
            case 3: {
                return transformContainerModel.get_pivotZ();
            }
            case 4: {
                return transformContainerModel.get_projectionFar();
            }
            case 5: {
                return transformContainerModel.get_projectionFOV();
            }
            case 6: {
                return transformContainerModel.get_projectionNear();
            }
            case 7: {
                return transformContainerModel.get_rotationX();
            }
            case 8: {
                return transformContainerModel.get_rotationY();
            }
            case 9: {
                return transformContainerModel.get_rotationZ();
            }
            case 10: {
                return transformContainerModel.get_scalingX();
            }
            case 11: {
                return transformContainerModel.get_scalingY();
            }
            case 12: {
                return transformContainerModel.get_scalingZ();
            }
        }
        return 0.0f;
    }

    private static void setAnimateFloatView(ViewModel viewModel, int n, float f2) {
        switch (n) {
            case 0: {
                viewModel.set_alphaImageRotation(f2);
                break;
            }
            case 1: {
                viewModel.set_pivotX(f2);
                break;
            }
            case 2: {
                viewModel.set_pivotY(f2);
                break;
            }
            case 3: {
                viewModel.set_pivotZ(f2);
                break;
            }
            case 4: {
                viewModel.set_projectionFar(f2);
                break;
            }
            case 5: {
                viewModel.set_projectionFOV(f2);
                break;
            }
            case 6: {
                viewModel.set_projectionNear(f2);
                break;
            }
            case 7: {
                viewModel.set_rotationX(f2);
                break;
            }
            case 8: {
                viewModel.set_rotationY(f2);
                break;
            }
            case 9: {
                viewModel.set_rotationZ(f2);
                break;
            }
            case 10: {
                viewModel.set_scalingX(f2);
                break;
            }
            case 11: {
                viewModel.set_scalingY(f2);
                break;
            }
            case 12: {
                viewModel.set_scalingZ(f2);
                break;
            }
        }
    }

    private static float getAnimateFloatView(ViewModel viewModel, int n) {
        switch (n) {
            case 0: {
                return viewModel.get_alphaImageRotation();
            }
            case 1: {
                return viewModel.get_pivotX();
            }
            case 2: {
                return viewModel.get_pivotY();
            }
            case 3: {
                return viewModel.get_pivotZ();
            }
            case 4: {
                return viewModel.get_projectionFar();
            }
            case 5: {
                return viewModel.get_projectionFOV();
            }
            case 6: {
                return viewModel.get_projectionNear();
            }
            case 7: {
                return viewModel.get_rotationX();
            }
            case 8: {
                return viewModel.get_rotationY();
            }
            case 9: {
                return viewModel.get_rotationZ();
            }
            case 10: {
                return viewModel.get_scalingX();
            }
            case 11: {
                return viewModel.get_scalingY();
            }
            case 12: {
                return viewModel.get_scalingZ();
            }
        }
        return 0.0f;
    }

    @Override
    public void setAnimatableIntValue(WidgetModel widgetModel, int n, int n2, int n3) {
        switch (n) {
            case 1: {
                WidgetAnimatorImpl.setAnimateIntAsiaSpeller((AsiaSpellerModel)widgetModel, n2, n3);
                break;
            }
            case 2: {
                WidgetAnimatorImpl.setAnimateIntButton((ButtonModel)widgetModel, n2, n3);
                break;
            }
            case 3: {
                WidgetAnimatorImpl.setAnimateIntCanvas((CanvasModel)widgetModel, n2, n3);
                break;
            }
            case 4: {
                WidgetAnimatorImpl.setAnimateIntCarImage((CarImageModel)widgetModel, n2, n3);
                break;
            }
            case 5: {
                WidgetAnimatorImpl.setAnimateIntCarStatus((CarStatusModel)widgetModel, n2, n3);
                break;
            }
            case 6: {
                WidgetAnimatorImpl.setAnimateIntClimate((ClimateModel)widgetModel, n2, n3);
                break;
            }
            case 7: {
                WidgetAnimatorImpl.setAnimateIntClock((ClockModel)widgetModel, n2, n3);
                break;
            }
            case 8: {
                WidgetAnimatorImpl.setAnimateIntColorChooser((ColorChooserModel)widgetModel, n2, n3);
                break;
            }
            case 9: {
                WidgetAnimatorImpl.setAnimateIntCommonImage((CommonImageModel)widgetModel, n2, n3);
                break;
            }
            case 10: {
                WidgetAnimatorImpl.setAnimateIntCompass((CompassModel)widgetModel, n2, n3);
                break;
            }
            case 11: {
                WidgetAnimatorImpl.setAnimateIntContainer((ContainerModel)widgetModel, n2, n3);
                break;
            }
            case 12: {
                WidgetAnimatorImpl.setAnimateIntControlBar((ControlBarModel)widgetModel, n2, n3);
                break;
            }
            case 13: {
                WidgetAnimatorImpl.setAnimateIntDropDown((DropDownModel)widgetModel, n2, n3);
                break;
            }
            case 14: {
                WidgetAnimatorImpl.setAnimateIntDropDownButton((DropDownButtonModel)widgetModel, n2, n3);
                break;
            }
            case 15: {
                WidgetAnimatorImpl.setAnimateIntDynamicImage((DynamicImageModel)widgetModel, n2, n3);
                break;
            }
            case 16: {
                WidgetAnimatorImpl.setAnimateIntEnergyFlow((EnergyFlowModel)widgetModel, n2, n3);
                break;
            }
            case 17: {
                WidgetAnimatorImpl.setAnimateIntFlowList((FlowListModel)widgetModel, n2, n3);
                break;
            }
            case 18: {
                WidgetAnimatorImpl.setAnimateIntGEMAdapter((GEMAdapterModel)widgetModel, n2, n3);
                break;
            }
            case 19: {
                WidgetAnimatorImpl.setAnimateIntGenericCarAdjuster((GenericCarAdjusterModel)widgetModel, n2, n3);
                break;
            }
            case 20: {
                WidgetAnimatorImpl.setAnimateIntGuidance((GuidanceModel)widgetModel, n2, n3);
                break;
            }
            case 21: {
                WidgetAnimatorImpl.setAnimateIntInactiveArea((InactiveAreaModel)widgetModel, n2, n3);
                break;
            }
            case 22: {
                WidgetAnimatorImpl.setAnimateIntInputField((InputFieldModel)widgetModel, n2, n3);
                break;
            }
            case 23: {
                WidgetAnimatorImpl.setAnimateIntInstruments((InstrumentsModel)widgetModel, n2, n3);
                break;
            }
            case 24: {
                WidgetAnimatorImpl.setAnimateIntIris((IrisModel)widgetModel, n2, n3);
                break;
            }
            case 25: {
                WidgetAnimatorImpl.setAnimateIntLabeledIcon((LabeledIconModel)widgetModel, n2, n3);
                break;
            }
            case 26: {
                WidgetAnimatorImpl.setAnimateIntLaneGuidance((LaneGuidanceModel)widgetModel, n2, n3);
                break;
            }
            case 27: {
                WidgetAnimatorImpl.setAnimateIntListItem((ListItemModel)widgetModel, n2, n3);
                break;
            }
            case 28: {
                WidgetAnimatorImpl.setAnimateIntMeshWidget((MeshWidgetModel)widgetModel, n2, n3);
                break;
            }
            case 29: {
                WidgetAnimatorImpl.setAnimateIntOPS((OPSModel)widgetModel, n2, n3);
                break;
            }
            case 30: {
                WidgetAnimatorImpl.setAnimateIntParticleSystem((ParticleSystemModel)widgetModel, n2, n3);
                break;
            }
            case 31: {
                WidgetAnimatorImpl.setAnimateIntPictureViewer((PictureViewerModel)widgetModel, n2, n3);
                break;
            }
            case 32: {
                WidgetAnimatorImpl.setAnimateIntPopupView((PopupViewModel)widgetModel, n2, n3);
                break;
            }
            case 33: {
                WidgetAnimatorImpl.setAnimateIntPreviewLine((PreviewLineModel)widgetModel, n2, n3);
                break;
            }
            case 34: {
                WidgetAnimatorImpl.setAnimateIntPureAir((PureAirModel)widgetModel, n2, n3);
                break;
            }
            case 35: {
                WidgetAnimatorImpl.setAnimateIntPushUp((PushUpModel)widgetModel, n2, n3);
                break;
            }
            case 36: {
                WidgetAnimatorImpl.setAnimateIntReferenceWidget((ReferenceWidgetModel)widgetModel, n2, n3);
                break;
            }
            case 37: {
                WidgetAnimatorImpl.setAnimateIntRunnerWidget((RunnerWidgetModel)widgetModel, n2, n3);
                break;
            }
            case 38: {
                WidgetAnimatorImpl.setAnimateIntScreen((ScreenModel)widgetModel, n2, n3);
                break;
            }
            case 39: {
                WidgetAnimatorImpl.setAnimateIntScreenArea((ScreenAreaModel)widgetModel, n2, n3);
                break;
            }
            case 40: {
                WidgetAnimatorImpl.setAnimateIntScrollableText((ScrollableTextModel)widgetModel, n2, n3);
                break;
            }
            case 41: {
                WidgetAnimatorImpl.setAnimateIntScrollbar((ScrollbarModel)widgetModel, n2, n3);
                break;
            }
            case 42: {
                WidgetAnimatorImpl.setAnimateIntSequencedImage((SequencedImageModel)widgetModel, n2, n3);
                break;
            }
            case 43: {
                WidgetAnimatorImpl.setAnimateIntSlider((SliderModel)widgetModel, n2, n3);
                break;
            }
            case 44: {
                WidgetAnimatorImpl.setAnimateIntSpeller((SpellerModel)widgetModel, n2, n3);
                break;
            }
            case 45: {
                WidgetAnimatorImpl.setAnimateIntSpellerButton((SpellerButtonModel)widgetModel, n2, n3);
                break;
            }
            case 46: {
                WidgetAnimatorImpl.setAnimateIntSpinLabel((SpinLabelModel)widgetModel, n2, n3);
                break;
            }
            case 47: {
                WidgetAnimatorImpl.setAnimateIntStaticImage((StaticImageModel)widgetModel, n2, n3);
                break;
            }
            case 48: {
                WidgetAnimatorImpl.setAnimateIntStatistics((StatisticsModel)widgetModel, n2, n3);
                break;
            }
            case 49: {
                WidgetAnimatorImpl.setAnimateIntTextArea((TextAreaModel)widgetModel, n2, n3);
                break;
            }
            case 50: {
                WidgetAnimatorImpl.setAnimateIntThresholdNotifier((ThresholdNotifierModel)widgetModel, n2, n3);
                break;
            }
            case 51: {
                WidgetAnimatorImpl.setAnimateIntTimerWidget((TimerWidgetModel)widgetModel, n2, n3);
                break;
            }
            case 52: {
                WidgetAnimatorImpl.setAnimateIntTouchArea((TouchAreaModel)widgetModel, n2, n3);
                break;
            }
            case 53: {
                WidgetAnimatorImpl.setAnimateIntTransformContainer((TransformContainerModel)widgetModel, n2, n3);
                break;
            }
            case 54: {
                WidgetAnimatorImpl.setAnimateIntView((ViewModel)widgetModel, n2, n3);
                break;
            }
            case 55: {
                WidgetAnimatorImpl.setAnimateIntWidgetList((WidgetListModel)widgetModel, n2, n3);
                break;
            }
        }
    }

    @Override
    public int getAnimatableIntValue(WidgetModel widgetModel, int n, int n2) {
        switch (n) {
            case 1: {
                return WidgetAnimatorImpl.getAnimateIntAsiaSpeller((AsiaSpellerModel)widgetModel, n2);
            }
            case 2: {
                return WidgetAnimatorImpl.getAnimateIntButton((ButtonModel)widgetModel, n2);
            }
            case 3: {
                return WidgetAnimatorImpl.getAnimateIntCanvas((CanvasModel)widgetModel, n2);
            }
            case 4: {
                return WidgetAnimatorImpl.getAnimateIntCarImage((CarImageModel)widgetModel, n2);
            }
            case 5: {
                return WidgetAnimatorImpl.getAnimateIntCarStatus((CarStatusModel)widgetModel, n2);
            }
            case 6: {
                return WidgetAnimatorImpl.getAnimateIntClimate((ClimateModel)widgetModel, n2);
            }
            case 7: {
                return WidgetAnimatorImpl.getAnimateIntClock((ClockModel)widgetModel, n2);
            }
            case 8: {
                return WidgetAnimatorImpl.getAnimateIntColorChooser((ColorChooserModel)widgetModel, n2);
            }
            case 9: {
                return WidgetAnimatorImpl.getAnimateIntCommonImage((CommonImageModel)widgetModel, n2);
            }
            case 10: {
                return WidgetAnimatorImpl.getAnimateIntCompass((CompassModel)widgetModel, n2);
            }
            case 11: {
                return WidgetAnimatorImpl.getAnimateIntContainer((ContainerModel)widgetModel, n2);
            }
            case 12: {
                return WidgetAnimatorImpl.getAnimateIntControlBar((ControlBarModel)widgetModel, n2);
            }
            case 13: {
                return WidgetAnimatorImpl.getAnimateIntDropDown((DropDownModel)widgetModel, n2);
            }
            case 14: {
                return WidgetAnimatorImpl.getAnimateIntDropDownButton((DropDownButtonModel)widgetModel, n2);
            }
            case 15: {
                return WidgetAnimatorImpl.getAnimateIntDynamicImage((DynamicImageModel)widgetModel, n2);
            }
            case 16: {
                return WidgetAnimatorImpl.getAnimateIntEnergyFlow((EnergyFlowModel)widgetModel, n2);
            }
            case 17: {
                return WidgetAnimatorImpl.getAnimateIntFlowList((FlowListModel)widgetModel, n2);
            }
            case 18: {
                return WidgetAnimatorImpl.getAnimateIntGEMAdapter((GEMAdapterModel)widgetModel, n2);
            }
            case 19: {
                return WidgetAnimatorImpl.getAnimateIntGenericCarAdjuster((GenericCarAdjusterModel)widgetModel, n2);
            }
            case 20: {
                return WidgetAnimatorImpl.getAnimateIntGuidance((GuidanceModel)widgetModel, n2);
            }
            case 21: {
                return WidgetAnimatorImpl.getAnimateIntInactiveArea((InactiveAreaModel)widgetModel, n2);
            }
            case 22: {
                return WidgetAnimatorImpl.getAnimateIntInputField((InputFieldModel)widgetModel, n2);
            }
            case 23: {
                return WidgetAnimatorImpl.getAnimateIntInstruments((InstrumentsModel)widgetModel, n2);
            }
            case 24: {
                return WidgetAnimatorImpl.getAnimateIntIris((IrisModel)widgetModel, n2);
            }
            case 25: {
                return WidgetAnimatorImpl.getAnimateIntLabeledIcon((LabeledIconModel)widgetModel, n2);
            }
            case 26: {
                return WidgetAnimatorImpl.getAnimateIntLaneGuidance((LaneGuidanceModel)widgetModel, n2);
            }
            case 27: {
                return WidgetAnimatorImpl.getAnimateIntListItem((ListItemModel)widgetModel, n2);
            }
            case 28: {
                return WidgetAnimatorImpl.getAnimateIntMeshWidget((MeshWidgetModel)widgetModel, n2);
            }
            case 29: {
                return WidgetAnimatorImpl.getAnimateIntOPS((OPSModel)widgetModel, n2);
            }
            case 30: {
                return WidgetAnimatorImpl.getAnimateIntParticleSystem((ParticleSystemModel)widgetModel, n2);
            }
            case 31: {
                return WidgetAnimatorImpl.getAnimateIntPictureViewer((PictureViewerModel)widgetModel, n2);
            }
            case 32: {
                return WidgetAnimatorImpl.getAnimateIntPopupView((PopupViewModel)widgetModel, n2);
            }
            case 33: {
                return WidgetAnimatorImpl.getAnimateIntPreviewLine((PreviewLineModel)widgetModel, n2);
            }
            case 34: {
                return WidgetAnimatorImpl.getAnimateIntPureAir((PureAirModel)widgetModel, n2);
            }
            case 35: {
                return WidgetAnimatorImpl.getAnimateIntPushUp((PushUpModel)widgetModel, n2);
            }
            case 36: {
                return WidgetAnimatorImpl.getAnimateIntReferenceWidget((ReferenceWidgetModel)widgetModel, n2);
            }
            case 37: {
                return WidgetAnimatorImpl.getAnimateIntRunnerWidget((RunnerWidgetModel)widgetModel, n2);
            }
            case 38: {
                return WidgetAnimatorImpl.getAnimateIntScreen((ScreenModel)widgetModel, n2);
            }
            case 39: {
                return WidgetAnimatorImpl.getAnimateIntScreenArea((ScreenAreaModel)widgetModel, n2);
            }
            case 40: {
                return WidgetAnimatorImpl.getAnimateIntScrollableText((ScrollableTextModel)widgetModel, n2);
            }
            case 41: {
                return WidgetAnimatorImpl.getAnimateIntScrollbar((ScrollbarModel)widgetModel, n2);
            }
            case 42: {
                return WidgetAnimatorImpl.getAnimateIntSequencedImage((SequencedImageModel)widgetModel, n2);
            }
            case 43: {
                return WidgetAnimatorImpl.getAnimateIntSlider((SliderModel)widgetModel, n2);
            }
            case 44: {
                return WidgetAnimatorImpl.getAnimateIntSpeller((SpellerModel)widgetModel, n2);
            }
            case 45: {
                return WidgetAnimatorImpl.getAnimateIntSpellerButton((SpellerButtonModel)widgetModel, n2);
            }
            case 46: {
                return WidgetAnimatorImpl.getAnimateIntSpinLabel((SpinLabelModel)widgetModel, n2);
            }
            case 47: {
                return WidgetAnimatorImpl.getAnimateIntStaticImage((StaticImageModel)widgetModel, n2);
            }
            case 48: {
                return WidgetAnimatorImpl.getAnimateIntStatistics((StatisticsModel)widgetModel, n2);
            }
            case 49: {
                return WidgetAnimatorImpl.getAnimateIntTextArea((TextAreaModel)widgetModel, n2);
            }
            case 50: {
                return WidgetAnimatorImpl.getAnimateIntThresholdNotifier((ThresholdNotifierModel)widgetModel, n2);
            }
            case 51: {
                return WidgetAnimatorImpl.getAnimateIntTimerWidget((TimerWidgetModel)widgetModel, n2);
            }
            case 52: {
                return WidgetAnimatorImpl.getAnimateIntTouchArea((TouchAreaModel)widgetModel, n2);
            }
            case 53: {
                return WidgetAnimatorImpl.getAnimateIntTransformContainer((TransformContainerModel)widgetModel, n2);
            }
            case 54: {
                return WidgetAnimatorImpl.getAnimateIntView((ViewModel)widgetModel, n2);
            }
            case 55: {
                return WidgetAnimatorImpl.getAnimateIntWidgetList((WidgetListModel)widgetModel, n2);
            }
        }
        return 0;
    }

    private static void setAnimateIntAsiaSpeller(AsiaSpellerModel asiaSpellerModel, int n, int n2) {
        switch (n) {
            case 0: {
                asiaSpellerModel.set_alpha(n2);
                break;
            }
            case 1: {
                asiaSpellerModel.set_alphabetIndex(n2);
                break;
            }
            case 2: {
                asiaSpellerModel.set_charEncoding(n2);
                break;
            }
            case 3: {
                asiaSpellerModel.set_charMax(n2);
                break;
            }
            case 4: {
                asiaSpellerModel.set_charMin(n2);
                break;
            }
            case 5: {
                asiaSpellerModel.set_compositeBackgroundArrowOffsetX(n2);
                break;
            }
            case 6: {
                asiaSpellerModel.set_compositeBackgroundArrowOffsetY(n2);
                break;
            }
            case 7: {
                asiaSpellerModel.set_compositeBackgroundMode(n2);
                break;
            }
            case 8: {
                asiaSpellerModel.set_filterId(n2);
                break;
            }
            case 9: {
                asiaSpellerModel.set_flyingWindowMode(n2);
                break;
            }
            case 10: {
                asiaSpellerModel.set_height(n2);
                break;
            }
            case 11: {
                asiaSpellerModel.set_hwrMode(n2);
                break;
            }
            case 12: {
                asiaSpellerModel.set_inputType(n2);
                break;
            }
            case 13: {
                asiaSpellerModel.set_languageIndex(n2);
                break;
            }
            case 14: {
                asiaSpellerModel.set_lowerUpper(n2);
                break;
            }
            case 15: {
                asiaSpellerModel.set_matchCount(n2);
                break;
            }
            case 16: {
                asiaSpellerModel.set_mode(n2);
                break;
            }
            case 17: {
                asiaSpellerModel.set_reflectionAlpha(n2);
                break;
            }
            case 18: {
                asiaSpellerModel.set_reflectionDistance(n2);
                break;
            }
            case 19: {
                asiaSpellerModel.set_shiftMode(n2);
                break;
            }
            case 20: {
                asiaSpellerModel.set_subspellerOffsetX(n2);
                break;
            }
            case 21: {
                asiaSpellerModel.set_subspellerOffsetY(n2);
                break;
            }
            case 22: {
                asiaSpellerModel.set_targetId(n2);
                break;
            }
            case 23: {
                asiaSpellerModel.set_width(n2);
                break;
            }
            case 24: {
                asiaSpellerModel.set_x(n2);
                break;
            }
            case 25: {
                asiaSpellerModel.set_y(n2);
                break;
            }
        }
    }

    private static int getAnimateIntAsiaSpeller(AsiaSpellerModel asiaSpellerModel, int n) {
        switch (n) {
            case 0: {
                return asiaSpellerModel.get_alpha();
            }
            case 1: {
                return asiaSpellerModel.get_alphabetIndex();
            }
            case 2: {
                return asiaSpellerModel.get_charEncoding();
            }
            case 3: {
                return asiaSpellerModel.get_charMax();
            }
            case 4: {
                return asiaSpellerModel.get_charMin();
            }
            case 5: {
                return asiaSpellerModel.get_compositeBackgroundArrowOffsetX();
            }
            case 6: {
                return asiaSpellerModel.get_compositeBackgroundArrowOffsetY();
            }
            case 7: {
                return asiaSpellerModel.get_compositeBackgroundMode();
            }
            case 8: {
                return asiaSpellerModel.get_filterId();
            }
            case 9: {
                return asiaSpellerModel.get_flyingWindowMode();
            }
            case 10: {
                return asiaSpellerModel.get_height();
            }
            case 11: {
                return asiaSpellerModel.get_hwrMode();
            }
            case 12: {
                return asiaSpellerModel.get_inputType();
            }
            case 13: {
                return asiaSpellerModel.get_languageIndex();
            }
            case 14: {
                return asiaSpellerModel.get_lowerUpper();
            }
            case 15: {
                return asiaSpellerModel.get_matchCount();
            }
            case 16: {
                return asiaSpellerModel.get_mode();
            }
            case 17: {
                return asiaSpellerModel.get_reflectionAlpha();
            }
            case 18: {
                return asiaSpellerModel.get_reflectionDistance();
            }
            case 19: {
                return asiaSpellerModel.get_shiftMode();
            }
            case 20: {
                return asiaSpellerModel.get_subspellerOffsetX();
            }
            case 21: {
                return asiaSpellerModel.get_subspellerOffsetY();
            }
            case 22: {
                return asiaSpellerModel.get_targetId();
            }
            case 23: {
                return asiaSpellerModel.get_width();
            }
            case 24: {
                return asiaSpellerModel.get_x();
            }
            case 25: {
                return asiaSpellerModel.get_y();
            }
        }
        return 0;
    }

    private static void setAnimateIntButton(ButtonModel buttonModel, int n, int n2) {
        switch (n) {
            case 0: {
                buttonModel.set_alpha(n2);
                break;
            }
            case 1: {
                buttonModel.set_buttonMode(n2);
                break;
            }
            case 2: {
                buttonModel.set_height(n2);
                break;
            }
            case 3: {
                buttonModel.set_reflectionAlpha(n2);
                break;
            }
            case 4: {
                buttonModel.set_reflectionDistance(n2);
                break;
            }
            case 5: {
                buttonModel.set_repeatTimePrimary(n2);
                break;
            }
            case 6: {
                buttonModel.set_repeatTimeSecondary(n2);
                break;
            }
            case 7: {
                buttonModel.set_startTimePrimary(n2);
                break;
            }
            case 8: {
                buttonModel.set_startTimeSecondary(n2);
                break;
            }
            case 9: {
                buttonModel.set_state(n2);
                break;
            }
            case 10: {
                buttonModel.set_targetId(n2);
                break;
            }
            case 11: {
                buttonModel.set_width(n2);
                break;
            }
            case 12: {
                buttonModel.set_x(n2);
                break;
            }
            case 13: {
                buttonModel.set_y(n2);
                break;
            }
        }
    }

    private static int getAnimateIntButton(ButtonModel buttonModel, int n) {
        switch (n) {
            case 0: {
                return buttonModel.get_alpha();
            }
            case 1: {
                return buttonModel.get_buttonMode();
            }
            case 2: {
                return buttonModel.get_height();
            }
            case 3: {
                return buttonModel.get_reflectionAlpha();
            }
            case 4: {
                return buttonModel.get_reflectionDistance();
            }
            case 5: {
                return buttonModel.get_repeatTimePrimary();
            }
            case 6: {
                return buttonModel.get_repeatTimeSecondary();
            }
            case 7: {
                return buttonModel.get_startTimePrimary();
            }
            case 8: {
                return buttonModel.get_startTimeSecondary();
            }
            case 9: {
                return buttonModel.get_state();
            }
            case 10: {
                return buttonModel.get_targetId();
            }
            case 11: {
                return buttonModel.get_width();
            }
            case 12: {
                return buttonModel.get_x();
            }
            case 13: {
                return buttonModel.get_y();
            }
        }
        return 0;
    }

    private static void setAnimateIntCanvas(CanvasModel canvasModel, int n, int n2) {
        switch (n) {
            case 0: {
                canvasModel.set_alpha(n2);
                break;
            }
            case 1: {
                canvasModel.set_displayable(n2);
                break;
            }
            case 2: {
                canvasModel.set_displayableHeight(n2);
                break;
            }
            case 3: {
                canvasModel.set_displayableWidth(n2);
                break;
            }
            case 4: {
                canvasModel.set_dragThreshold(n2);
                break;
            }
            case 5: {
                canvasModel.set_dragThresholdMode(n2);
                break;
            }
            case 6: {
                canvasModel.set_duration(n2);
                break;
            }
            case 7: {
                canvasModel.set_height(n2);
                break;
            }
            case 8: {
                canvasModel.set_mode(n2);
                break;
            }
            case 9: {
                canvasModel.set_scalemode(n2);
                break;
            }
            case 10: {
                canvasModel.set_screenshotmode(n2);
                break;
            }
            case 11: {
                canvasModel.set_targetId(n2);
                break;
            }
            case 12: {
                canvasModel.set_touchForwardingMode(n2);
                break;
            }
            case 13: {
                canvasModel.set_touchTrajectoriesLineWidth(n2);
                break;
            }
            case 14: {
                canvasModel.set_valueMaxX(n2);
                break;
            }
            case 15: {
                canvasModel.set_valueMaxY(n2);
                break;
            }
            case 16: {
                canvasModel.set_valueMinX(n2);
                break;
            }
            case 17: {
                canvasModel.set_valueMinY(n2);
                break;
            }
            case 18: {
                canvasModel.set_width(n2);
                break;
            }
            case 19: {
                canvasModel.set_x(n2);
                break;
            }
            case 20: {
                canvasModel.set_y(n2);
                break;
            }
        }
    }

    private static int getAnimateIntCanvas(CanvasModel canvasModel, int n) {
        switch (n) {
            case 0: {
                return canvasModel.get_alpha();
            }
            case 1: {
                return canvasModel.get_displayable();
            }
            case 2: {
                return canvasModel.get_displayableHeight();
            }
            case 3: {
                return canvasModel.get_displayableWidth();
            }
            case 4: {
                return canvasModel.get_dragThreshold();
            }
            case 5: {
                return canvasModel.get_dragThresholdMode();
            }
            case 6: {
                return canvasModel.get_duration();
            }
            case 7: {
                return canvasModel.get_height();
            }
            case 8: {
                return canvasModel.get_mode();
            }
            case 9: {
                return canvasModel.get_scalemode();
            }
            case 10: {
                return canvasModel.get_screenshotmode();
            }
            case 11: {
                return canvasModel.get_targetId();
            }
            case 12: {
                return canvasModel.get_touchForwardingMode();
            }
            case 13: {
                return canvasModel.get_touchTrajectoriesLineWidth();
            }
            case 14: {
                return canvasModel.get_valueMaxX();
            }
            case 15: {
                return canvasModel.get_valueMaxY();
            }
            case 16: {
                return canvasModel.get_valueMinX();
            }
            case 17: {
                return canvasModel.get_valueMinY();
            }
            case 18: {
                return canvasModel.get_width();
            }
            case 19: {
                return canvasModel.get_x();
            }
            case 20: {
                return canvasModel.get_y();
            }
        }
        return 0;
    }

    private static void setAnimateIntCarImage(CarImageModel carImageModel, int n, int n2) {
        switch (n) {
            case 0: {
                carImageModel.set_alpha(n2);
                break;
            }
            case 1: {
                carImageModel.set_blendMode(n2);
                break;
            }
            case 2: {
                carImageModel.set_height(n2);
                break;
            }
            case 3: {
                carImageModel.set_imageType(n2);
                break;
            }
            case 4: {
                carImageModel.set_scaleMode(n2);
                break;
            }
            case 5: {
                carImageModel.set_targetId(n2);
                break;
            }
            case 6: {
                carImageModel.set_width(n2);
                break;
            }
            case 7: {
                carImageModel.set_x(n2);
                break;
            }
            case 8: {
                carImageModel.set_y(n2);
                break;
            }
        }
    }

    private static int getAnimateIntCarImage(CarImageModel carImageModel, int n) {
        switch (n) {
            case 0: {
                return carImageModel.get_alpha();
            }
            case 1: {
                return carImageModel.get_blendMode();
            }
            case 2: {
                return carImageModel.get_height();
            }
            case 3: {
                return carImageModel.get_imageType();
            }
            case 4: {
                return carImageModel.get_scaleMode();
            }
            case 5: {
                return carImageModel.get_targetId();
            }
            case 6: {
                return carImageModel.get_width();
            }
            case 7: {
                return carImageModel.get_x();
            }
            case 8: {
                return carImageModel.get_y();
            }
        }
        return 0;
    }

    private static void setAnimateIntCarStatus(CarStatusModel carStatusModel, int n, int n2) {
        switch (n) {
            case 0: {
                carStatusModel.set_alpha(n2);
                break;
            }
            case 1: {
                carStatusModel.set_height(n2);
                break;
            }
            case 2: {
                carStatusModel.set_targetId(n2);
                break;
            }
            case 3: {
                carStatusModel.set_width(n2);
                break;
            }
            case 4: {
                carStatusModel.set_x(n2);
                break;
            }
            case 5: {
                carStatusModel.set_y(n2);
                break;
            }
        }
    }

    private static int getAnimateIntCarStatus(CarStatusModel carStatusModel, int n) {
        switch (n) {
            case 0: {
                return carStatusModel.get_alpha();
            }
            case 1: {
                return carStatusModel.get_height();
            }
            case 2: {
                return carStatusModel.get_targetId();
            }
            case 3: {
                return carStatusModel.get_width();
            }
            case 4: {
                return carStatusModel.get_x();
            }
            case 5: {
                return carStatusModel.get_y();
            }
        }
        return 0;
    }

    private static void setAnimateIntClimate(ClimateModel climateModel, int n, int n2) {
        switch (n) {
            case 0: {
                climateModel.set_alpha(n2);
                break;
            }
            case 1: {
                climateModel.set_aspect(n2);
                break;
            }
            case 2: {
                climateModel.set_exhaustsAlpha(n2);
                break;
            }
            case 3: {
                climateModel.set_height(n2);
                break;
            }
            case 4: {
                climateModel.set_targetId(n2);
                break;
            }
            case 5: {
                climateModel.set_width(n2);
                break;
            }
            case 6: {
                climateModel.set_x(n2);
                break;
            }
            case 7: {
                climateModel.set_y(n2);
                break;
            }
        }
    }

    private static int getAnimateIntClimate(ClimateModel climateModel, int n) {
        switch (n) {
            case 0: {
                return climateModel.get_alpha();
            }
            case 1: {
                return climateModel.get_aspect();
            }
            case 2: {
                return climateModel.get_exhaustsAlpha();
            }
            case 3: {
                return climateModel.get_height();
            }
            case 4: {
                return climateModel.get_targetId();
            }
            case 5: {
                return climateModel.get_width();
            }
            case 6: {
                return climateModel.get_x();
            }
            case 7: {
                return climateModel.get_y();
            }
        }
        return 0;
    }

    private static void setAnimateIntClock(ClockModel clockModel, int n, int n2) {
        switch (n) {
            case 0: {
                clockModel.set_alpha(n2);
                break;
            }
            case 1: {
                clockModel.set_blendMode(n2);
                break;
            }
            case 2: {
                clockModel.set_height(n2);
                break;
            }
            case 3: {
                clockModel.set_hour(n2);
                break;
            }
            case 4: {
                clockModel.set_minute(n2);
                break;
            }
            case 5: {
                clockModel.set_second(n2);
                break;
            }
            case 6: {
                clockModel.set_targetId(n2);
                break;
            }
            case 7: {
                clockModel.set_width(n2);
                break;
            }
            case 8: {
                clockModel.set_x(n2);
                break;
            }
            case 9: {
                clockModel.set_y(n2);
                break;
            }
        }
    }

    private static int getAnimateIntClock(ClockModel clockModel, int n) {
        switch (n) {
            case 0: {
                return clockModel.get_alpha();
            }
            case 1: {
                return clockModel.get_blendMode();
            }
            case 2: {
                return clockModel.get_height();
            }
            case 3: {
                return clockModel.get_hour();
            }
            case 4: {
                return clockModel.get_minute();
            }
            case 5: {
                return clockModel.get_second();
            }
            case 6: {
                return clockModel.get_targetId();
            }
            case 7: {
                return clockModel.get_width();
            }
            case 8: {
                return clockModel.get_x();
            }
            case 9: {
                return clockModel.get_y();
            }
        }
        return 0;
    }

    private static void setAnimateIntColorChooser(ColorChooserModel colorChooserModel, int n, int n2) {
        switch (n) {
            case 0: {
                colorChooserModel.set_alpha(n2);
                break;
            }
            case 1: {
                colorChooserModel.set_colorIndex(n2);
                break;
            }
            case 2: {
                colorChooserModel.set_height(n2);
                break;
            }
            case 3: {
                colorChooserModel.set_indicatorValuePointX(n2);
                break;
            }
            case 4: {
                colorChooserModel.set_indicatorValuePointY(n2);
                break;
            }
            case 5: {
                colorChooserModel.set_mode(n2);
                break;
            }
            case 6: {
                colorChooserModel.set_reflectionAlpha(n2);
                break;
            }
            case 7: {
                colorChooserModel.set_reflectionDistance(n2);
                break;
            }
            case 8: {
                colorChooserModel.set_spacingHorizontal(n2);
                break;
            }
            case 9: {
                colorChooserModel.set_state(n2);
                break;
            }
            case 10: {
                colorChooserModel.set_targetId(n2);
                break;
            }
            case 11: {
                colorChooserModel.set_width(n2);
                break;
            }
            case 12: {
                colorChooserModel.set_x(n2);
                break;
            }
            case 13: {
                colorChooserModel.set_y(n2);
                break;
            }
        }
    }

    private static int getAnimateIntColorChooser(ColorChooserModel colorChooserModel, int n) {
        switch (n) {
            case 0: {
                return colorChooserModel.get_alpha();
            }
            case 1: {
                return colorChooserModel.get_colorIndex();
            }
            case 2: {
                return colorChooserModel.get_height();
            }
            case 3: {
                return colorChooserModel.get_indicatorValuePointX();
            }
            case 4: {
                return colorChooserModel.get_indicatorValuePointY();
            }
            case 5: {
                return colorChooserModel.get_mode();
            }
            case 6: {
                return colorChooserModel.get_reflectionAlpha();
            }
            case 7: {
                return colorChooserModel.get_reflectionDistance();
            }
            case 8: {
                return colorChooserModel.get_spacingHorizontal();
            }
            case 9: {
                return colorChooserModel.get_state();
            }
            case 10: {
                return colorChooserModel.get_targetId();
            }
            case 11: {
                return colorChooserModel.get_width();
            }
            case 12: {
                return colorChooserModel.get_x();
            }
            case 13: {
                return colorChooserModel.get_y();
            }
        }
        return 0;
    }

    private static void setAnimateIntCommonImage(CommonImageModel commonImageModel, int n, int n2) {
        switch (n) {
            case 0: {
                commonImageModel.set_alpha(n2);
                break;
            }
            case 1: {
                commonImageModel.set_blendMode(n2);
                break;
            }
            case 2: {
                commonImageModel.set_height(n2);
                break;
            }
            case 3: {
                commonImageModel.set_imageType(n2);
                break;
            }
            case 4: {
                commonImageModel.set_scaleMode(n2);
                break;
            }
            case 5: {
                commonImageModel.set_targetId(n2);
                break;
            }
            case 6: {
                commonImageModel.set_width(n2);
                break;
            }
            case 7: {
                commonImageModel.set_x(n2);
                break;
            }
            case 8: {
                commonImageModel.set_y(n2);
                break;
            }
        }
    }

    private static int getAnimateIntCommonImage(CommonImageModel commonImageModel, int n) {
        switch (n) {
            case 0: {
                return commonImageModel.get_alpha();
            }
            case 1: {
                return commonImageModel.get_blendMode();
            }
            case 2: {
                return commonImageModel.get_height();
            }
            case 3: {
                return commonImageModel.get_imageType();
            }
            case 4: {
                return commonImageModel.get_scaleMode();
            }
            case 5: {
                return commonImageModel.get_targetId();
            }
            case 6: {
                return commonImageModel.get_width();
            }
            case 7: {
                return commonImageModel.get_x();
            }
            case 8: {
                return commonImageModel.get_y();
            }
        }
        return 0;
    }

    private static void setAnimateIntCompass(CompassModel compassModel, int n, int n2) {
        switch (n) {
            case 0: {
                compassModel.set_alpha(n2);
                break;
            }
            case 1: {
                compassModel.set_blendMode(n2);
                break;
            }
            case 2: {
                compassModel.set_distance(n2);
                break;
            }
            case 3: {
                compassModel.set_heading(n2);
                break;
            }
            case 4: {
                compassModel.set_height(n2);
                break;
            }
            case 5: {
                compassModel.set_rotation(n2);
                break;
            }
            case 6: {
                compassModel.set_targetId(n2);
                break;
            }
            case 7: {
                compassModel.set_width(n2);
                break;
            }
            case 8: {
                compassModel.set_x(n2);
                break;
            }
            case 9: {
                compassModel.set_y(n2);
                break;
            }
        }
    }

    private static int getAnimateIntCompass(CompassModel compassModel, int n) {
        switch (n) {
            case 0: {
                return compassModel.get_alpha();
            }
            case 1: {
                return compassModel.get_blendMode();
            }
            case 2: {
                return compassModel.get_distance();
            }
            case 3: {
                return compassModel.get_heading();
            }
            case 4: {
                return compassModel.get_height();
            }
            case 5: {
                return compassModel.get_rotation();
            }
            case 6: {
                return compassModel.get_targetId();
            }
            case 7: {
                return compassModel.get_width();
            }
            case 8: {
                return compassModel.get_x();
            }
            case 9: {
                return compassModel.get_y();
            }
        }
        return 0;
    }

    private static void setAnimateIntContainer(ContainerModel containerModel, int n, int n2) {
        switch (n) {
            case 0: {
                containerModel.set_alpha(n2);
                break;
            }
            case 1: {
                containerModel.set_height(n2);
                break;
            }
            case 2: {
                containerModel.set_reflectionAlpha(n2);
                break;
            }
            case 3: {
                containerModel.set_reflectionDistance(n2);
                break;
            }
            case 4: {
                containerModel.set_targetId(n2);
                break;
            }
            case 5: {
                containerModel.set_width(n2);
                break;
            }
            case 6: {
                containerModel.set_x(n2);
                break;
            }
            case 7: {
                containerModel.set_y(n2);
                break;
            }
        }
    }

    private static int getAnimateIntContainer(ContainerModel containerModel, int n) {
        switch (n) {
            case 0: {
                return containerModel.get_alpha();
            }
            case 1: {
                return containerModel.get_height();
            }
            case 2: {
                return containerModel.get_reflectionAlpha();
            }
            case 3: {
                return containerModel.get_reflectionDistance();
            }
            case 4: {
                return containerModel.get_targetId();
            }
            case 5: {
                return containerModel.get_width();
            }
            case 6: {
                return containerModel.get_x();
            }
            case 7: {
                return containerModel.get_y();
            }
        }
        return 0;
    }

    private static void setAnimateIntControlBar(ControlBarModel controlBarModel, int n, int n2) {
        switch (n) {
            case 0: {
                controlBarModel.set_alpha(n2);
                break;
            }
            case 1: {
                controlBarModel.set_height(n2);
                break;
            }
            case 2: {
                controlBarModel.set_reflectionAlpha(n2);
                break;
            }
            case 3: {
                controlBarModel.set_reflectionDistance(n2);
                break;
            }
            case 4: {
                controlBarModel.set_selectedIndex(n2);
                break;
            }
            case 5: {
                controlBarModel.set_targetId(n2);
                break;
            }
            case 6: {
                controlBarModel.set_visibleButtonCount(n2);
                break;
            }
            case 7: {
                controlBarModel.set_visibleButtonIndex(n2);
                break;
            }
            case 8: {
                controlBarModel.set_width(n2);
                break;
            }
            case 9: {
                controlBarModel.set_x(n2);
                break;
            }
            case 10: {
                controlBarModel.set_y(n2);
                break;
            }
        }
    }

    private static int getAnimateIntControlBar(ControlBarModel controlBarModel, int n) {
        switch (n) {
            case 0: {
                return controlBarModel.get_alpha();
            }
            case 1: {
                return controlBarModel.get_height();
            }
            case 2: {
                return controlBarModel.get_reflectionAlpha();
            }
            case 3: {
                return controlBarModel.get_reflectionDistance();
            }
            case 4: {
                return controlBarModel.get_selectedIndex();
            }
            case 5: {
                return controlBarModel.get_targetId();
            }
            case 6: {
                return controlBarModel.get_visibleButtonCount();
            }
            case 7: {
                return controlBarModel.get_visibleButtonIndex();
            }
            case 8: {
                return controlBarModel.get_width();
            }
            case 9: {
                return controlBarModel.get_x();
            }
            case 10: {
                return controlBarModel.get_y();
            }
        }
        return 0;
    }

    private static void setAnimateIntDropDown(DropDownModel dropDownModel, int n, int n2) {
        switch (n) {
            case 0: {
                dropDownModel.set_alpha(n2);
                break;
            }
            case 1: {
                dropDownModel.set_closeMode(n2);
                break;
            }
            case 2: {
                dropDownModel.set_compositeBackgroundArrowOffsetX(n2);
                break;
            }
            case 3: {
                dropDownModel.set_compositeBackgroundArrowOffsetY(n2);
                break;
            }
            case 4: {
                dropDownModel.set_compositeBackgroundMode(n2);
                break;
            }
            case 5: {
                dropDownModel.set_flyingWindowMode(n2);
                break;
            }
            case 6: {
                dropDownModel.set_height(n2);
                break;
            }
            case 7: {
                dropDownModel.set_layoutAlignment(n2);
                break;
            }
            case 8: {
                dropDownModel.set_reflectionAlpha(n2);
                break;
            }
            case 9: {
                dropDownModel.set_reflectionDistance(n2);
                break;
            }
            case 10: {
                dropDownModel.set_scalingPivot(n2);
                break;
            }
            case 11: {
                dropDownModel.set_targetId(n2);
                break;
            }
            case 12: {
                dropDownModel.set_width(n2);
                break;
            }
            case 13: {
                dropDownModel.set_x(n2);
                break;
            }
            case 14: {
                dropDownModel.set_y(n2);
                break;
            }
            case 15: {
                dropDownModel.set_yOffset(n2);
                break;
            }
        }
    }

    private static int getAnimateIntDropDown(DropDownModel dropDownModel, int n) {
        switch (n) {
            case 0: {
                return dropDownModel.get_alpha();
            }
            case 1: {
                return dropDownModel.get_closeMode();
            }
            case 2: {
                return dropDownModel.get_compositeBackgroundArrowOffsetX();
            }
            case 3: {
                return dropDownModel.get_compositeBackgroundArrowOffsetY();
            }
            case 4: {
                return dropDownModel.get_compositeBackgroundMode();
            }
            case 5: {
                return dropDownModel.get_flyingWindowMode();
            }
            case 6: {
                return dropDownModel.get_height();
            }
            case 7: {
                return dropDownModel.get_layoutAlignment();
            }
            case 8: {
                return dropDownModel.get_reflectionAlpha();
            }
            case 9: {
                return dropDownModel.get_reflectionDistance();
            }
            case 10: {
                return dropDownModel.get_scalingPivot();
            }
            case 11: {
                return dropDownModel.get_targetId();
            }
            case 12: {
                return dropDownModel.get_width();
            }
            case 13: {
                return dropDownModel.get_x();
            }
            case 14: {
                return dropDownModel.get_y();
            }
            case 15: {
                return dropDownModel.get_yOffset();
            }
        }
        return 0;
    }

    private static void setAnimateIntDropDownButton(DropDownButtonModel dropDownButtonModel, int n, int n2) {
        switch (n) {
            case 0: {
                dropDownButtonModel.set_alpha(n2);
                break;
            }
            case 1: {
                dropDownButtonModel.set_buttonMode(n2);
                break;
            }
            case 2: {
                dropDownButtonModel.set_height(n2);
                break;
            }
            case 3: {
                dropDownButtonModel.set_reflectionAlpha(n2);
                break;
            }
            case 4: {
                dropDownButtonModel.set_reflectionDistance(n2);
                break;
            }
            case 5: {
                dropDownButtonModel.set_repeatTimePrimary(n2);
                break;
            }
            case 6: {
                dropDownButtonModel.set_repeatTimeSecondary(n2);
                break;
            }
            case 7: {
                dropDownButtonModel.set_startTimePrimary(n2);
                break;
            }
            case 8: {
                dropDownButtonModel.set_startTimeSecondary(n2);
                break;
            }
            case 9: {
                dropDownButtonModel.set_state(n2);
                break;
            }
            case 10: {
                dropDownButtonModel.set_targetId(n2);
                break;
            }
            case 11: {
                dropDownButtonModel.set_width(n2);
                break;
            }
            case 12: {
                dropDownButtonModel.set_x(n2);
                break;
            }
            case 13: {
                dropDownButtonModel.set_y(n2);
                break;
            }
        }
    }

    private static int getAnimateIntDropDownButton(DropDownButtonModel dropDownButtonModel, int n) {
        switch (n) {
            case 0: {
                return dropDownButtonModel.get_alpha();
            }
            case 1: {
                return dropDownButtonModel.get_buttonMode();
            }
            case 2: {
                return dropDownButtonModel.get_height();
            }
            case 3: {
                return dropDownButtonModel.get_reflectionAlpha();
            }
            case 4: {
                return dropDownButtonModel.get_reflectionDistance();
            }
            case 5: {
                return dropDownButtonModel.get_repeatTimePrimary();
            }
            case 6: {
                return dropDownButtonModel.get_repeatTimeSecondary();
            }
            case 7: {
                return dropDownButtonModel.get_startTimePrimary();
            }
            case 8: {
                return dropDownButtonModel.get_startTimeSecondary();
            }
            case 9: {
                return dropDownButtonModel.get_state();
            }
            case 10: {
                return dropDownButtonModel.get_targetId();
            }
            case 11: {
                return dropDownButtonModel.get_width();
            }
            case 12: {
                return dropDownButtonModel.get_x();
            }
            case 13: {
                return dropDownButtonModel.get_y();
            }
        }
        return 0;
    }

    private static void setAnimateIntDynamicImage(DynamicImageModel dynamicImageModel, int n, int n2) {
        switch (n) {
            case 0: {
                dynamicImageModel.set_alpha(n2);
                break;
            }
            case 1: {
                dynamicImageModel.set_blendMode(n2);
                break;
            }
            case 2: {
                dynamicImageModel.set_borderImageMode(n2);
                break;
            }
            case 3: {
                dynamicImageModel.set_height(n2);
                break;
            }
            case 4: {
                dynamicImageModel.set_reflectionAlpha(n2);
                break;
            }
            case 5: {
                dynamicImageModel.set_reflectionDistance(n2);
                break;
            }
            case 6: {
                dynamicImageModel.set_targetId(n2);
                break;
            }
            case 7: {
                dynamicImageModel.set_transitionNextImageIn(n2);
                break;
            }
            case 8: {
                dynamicImageModel.set_transitionNextImageOut(n2);
                break;
            }
            case 9: {
                dynamicImageModel.set_width(n2);
                break;
            }
            case 10: {
                dynamicImageModel.set_x(n2);
                break;
            }
            case 11: {
                dynamicImageModel.set_y(n2);
                break;
            }
            case 12: {
                dynamicImageModel.set_zoomType(n2);
                break;
            }
        }
    }

    private static int getAnimateIntDynamicImage(DynamicImageModel dynamicImageModel, int n) {
        switch (n) {
            case 0: {
                return dynamicImageModel.get_alpha();
            }
            case 1: {
                return dynamicImageModel.get_blendMode();
            }
            case 2: {
                return dynamicImageModel.get_borderImageMode();
            }
            case 3: {
                return dynamicImageModel.get_height();
            }
            case 4: {
                return dynamicImageModel.get_reflectionAlpha();
            }
            case 5: {
                return dynamicImageModel.get_reflectionDistance();
            }
            case 6: {
                return dynamicImageModel.get_targetId();
            }
            case 7: {
                return dynamicImageModel.get_transitionNextImageIn();
            }
            case 8: {
                return dynamicImageModel.get_transitionNextImageOut();
            }
            case 9: {
                return dynamicImageModel.get_width();
            }
            case 10: {
                return dynamicImageModel.get_x();
            }
            case 11: {
                return dynamicImageModel.get_y();
            }
            case 12: {
                return dynamicImageModel.get_zoomType();
            }
        }
        return 0;
    }

    private static void setAnimateIntEnergyFlow(EnergyFlowModel energyFlowModel, int n, int n2) {
        switch (n) {
            case 0: {
                energyFlowModel.set_alpha(n2);
                break;
            }
            case 1: {
                energyFlowModel.set_batteryState(n2);
                break;
            }
            case 2: {
                energyFlowModel.set_batteryStateOfCharge(n2);
                break;
            }
            case 3: {
                energyFlowModel.set_carType(n2);
                break;
            }
            case 4: {
                energyFlowModel.set_energyState(n2);
                break;
            }
            case 5: {
                energyFlowModel.set_height(n2);
                break;
            }
            case 6: {
                energyFlowModel.set_motionState(n2);
                break;
            }
            case 7: {
                energyFlowModel.set_powerDriveConcept(n2);
                break;
            }
            case 8: {
                energyFlowModel.set_targetId(n2);
                break;
            }
            case 9: {
                energyFlowModel.set_width(n2);
                break;
            }
            case 10: {
                energyFlowModel.set_x(n2);
                break;
            }
            case 11: {
                energyFlowModel.set_y(n2);
                break;
            }
        }
    }

    private static int getAnimateIntEnergyFlow(EnergyFlowModel energyFlowModel, int n) {
        switch (n) {
            case 0: {
                return energyFlowModel.get_alpha();
            }
            case 1: {
                return energyFlowModel.get_batteryState();
            }
            case 2: {
                return energyFlowModel.get_batteryStateOfCharge();
            }
            case 3: {
                return energyFlowModel.get_carType();
            }
            case 4: {
                return energyFlowModel.get_energyState();
            }
            case 5: {
                return energyFlowModel.get_height();
            }
            case 6: {
                return energyFlowModel.get_motionState();
            }
            case 7: {
                return energyFlowModel.get_powerDriveConcept();
            }
            case 8: {
                return energyFlowModel.get_targetId();
            }
            case 9: {
                return energyFlowModel.get_width();
            }
            case 10: {
                return energyFlowModel.get_x();
            }
            case 11: {
                return energyFlowModel.get_y();
            }
        }
        return 0;
    }

    private static void setAnimateIntFlowList(FlowListModel flowListModel, int n, int n2) {
        switch (n) {
            case 0: {
                flowListModel.set_absSelectedIndex(n2);
                break;
            }
            case 1: {
                flowListModel.set_alignment(n2);
                break;
            }
            case 2: {
                flowListModel.set_alpha(n2);
                break;
            }
            case 3: {
                flowListModel.set_distance(n2);
                break;
            }
            case 4: {
                flowListModel.set_elevationAngle(n2);
                break;
            }
            case 5: {
                flowListModel.set_firstItemIndex(n2);
                break;
            }
            case 6: {
                flowListModel.set_firstItemIndexPosition(n2);
                break;
            }
            case 7: {
                flowListModel.set_followItemPosition(n2);
                break;
            }
            case 8: {
                flowListModel.set_followModeDelay(n2);
                break;
            }
            case 9: {
                flowListModel.set_forwardPressDelay(n2);
                break;
            }
            case 10: {
                flowListModel.set_height(n2);
                break;
            }
            case 11: {
                flowListModel.set_itemCount(n2);
                break;
            }
            case 12: {
                flowListModel.set_letterScrollingIndicatorMode(n2);
                break;
            }
            case 13: {
                flowListModel.set_listViewObserverDelay(n2);
                break;
            }
            case 14: {
                flowListModel.set_outline(n2);
                break;
            }
            case 15: {
                flowListModel.set_outlineEffect(n2);
                break;
            }
            case 16: {
                flowListModel.set_outlineScrollingDirection(n2);
                break;
            }
            case 17: {
                flowListModel.set_outlineScrollShortcutSize(n2);
                break;
            }
            case 18: {
                flowListModel.set_radius(n2);
                break;
            }
            case 19: {
                flowListModel.set_reflectionAlpha(n2);
                break;
            }
            case 20: {
                flowListModel.set_reflectionDistance(n2);
                break;
            }
            case 21: {
                flowListModel.set_scrollTypeRotary(n2);
                break;
            }
            case 22: {
                flowListModel.set_scrollTypeTouch(n2);
                break;
            }
            case 23: {
                flowListModel.set_selectedIndex(n2);
                break;
            }
            case 24: {
                flowListModel.set_targetId(n2);
                break;
            }
            case 25: {
                flowListModel.set_visibleItemCount(n2);
                break;
            }
            case 26: {
                flowListModel.set_width(n2);
                break;
            }
            case 27: {
                flowListModel.set_x(n2);
                break;
            }
            case 28: {
                flowListModel.set_y(n2);
                break;
            }
        }
    }

    private static int getAnimateIntFlowList(FlowListModel flowListModel, int n) {
        switch (n) {
            case 0: {
                return flowListModel.get_absSelectedIndex();
            }
            case 1: {
                return flowListModel.get_alignment();
            }
            case 2: {
                return flowListModel.get_alpha();
            }
            case 3: {
                return flowListModel.get_distance();
            }
            case 4: {
                return flowListModel.get_elevationAngle();
            }
            case 5: {
                return flowListModel.get_firstItemIndex();
            }
            case 6: {
                return flowListModel.get_firstItemIndexPosition();
            }
            case 7: {
                return flowListModel.get_followItemPosition();
            }
            case 8: {
                return flowListModel.get_followModeDelay();
            }
            case 9: {
                return flowListModel.get_forwardPressDelay();
            }
            case 10: {
                return flowListModel.get_height();
            }
            case 11: {
                return flowListModel.get_itemCount();
            }
            case 12: {
                return flowListModel.get_letterScrollingIndicatorMode();
            }
            case 13: {
                return flowListModel.get_listViewObserverDelay();
            }
            case 14: {
                return flowListModel.get_outline();
            }
            case 15: {
                return flowListModel.get_outlineEffect();
            }
            case 16: {
                return flowListModel.get_outlineScrollingDirection();
            }
            case 17: {
                return flowListModel.get_outlineScrollShortcutSize();
            }
            case 18: {
                return flowListModel.get_radius();
            }
            case 19: {
                return flowListModel.get_reflectionAlpha();
            }
            case 20: {
                return flowListModel.get_reflectionDistance();
            }
            case 21: {
                return flowListModel.get_scrollTypeRotary();
            }
            case 22: {
                return flowListModel.get_scrollTypeTouch();
            }
            case 23: {
                return flowListModel.get_selectedIndex();
            }
            case 24: {
                return flowListModel.get_targetId();
            }
            case 25: {
                return flowListModel.get_visibleItemCount();
            }
            case 26: {
                return flowListModel.get_width();
            }
            case 27: {
                return flowListModel.get_x();
            }
            case 28: {
                return flowListModel.get_y();
            }
        }
        return 0;
    }

    private static void setAnimateIntGEMAdapter(GEMAdapterModel gEMAdapterModel, int n, int n2) {
        switch (n) {
            case 0: {
                gEMAdapterModel.set_alpha(n2);
                break;
            }
            case 1: {
                gEMAdapterModel.set_decoration(n2);
                break;
            }
            case 2: {
                gEMAdapterModel.set_depth(n2);
                break;
            }
            case 3: {
                gEMAdapterModel.set_height(n2);
                break;
            }
            case 4: {
                gEMAdapterModel.set_projectionType(n2);
                break;
            }
            case 5: {
                gEMAdapterModel.set_reflectionAlpha(n2);
                break;
            }
            case 6: {
                gEMAdapterModel.set_reflectionDistance(n2);
                break;
            }
            case 7: {
                gEMAdapterModel.set_targetId(n2);
                break;
            }
            case 8: {
                gEMAdapterModel.set_touchForwardingMode(n2);
                break;
            }
            case 9: {
                gEMAdapterModel.set_viewTypeSelection(n2);
                break;
            }
            case 10: {
                gEMAdapterModel.set_width(n2);
                break;
            }
            case 11: {
                gEMAdapterModel.set_x(n2);
                break;
            }
            case 12: {
                gEMAdapterModel.set_y(n2);
                break;
            }
            case 13: {
                gEMAdapterModel.set_z(n2);
                break;
            }
        }
    }

    private static int getAnimateIntGEMAdapter(GEMAdapterModel gEMAdapterModel, int n) {
        switch (n) {
            case 0: {
                return gEMAdapterModel.get_alpha();
            }
            case 1: {
                return gEMAdapterModel.get_decoration();
            }
            case 2: {
                return gEMAdapterModel.get_depth();
            }
            case 3: {
                return gEMAdapterModel.get_height();
            }
            case 4: {
                return gEMAdapterModel.get_projectionType();
            }
            case 5: {
                return gEMAdapterModel.get_reflectionAlpha();
            }
            case 6: {
                return gEMAdapterModel.get_reflectionDistance();
            }
            case 7: {
                return gEMAdapterModel.get_targetId();
            }
            case 8: {
                return gEMAdapterModel.get_touchForwardingMode();
            }
            case 9: {
                return gEMAdapterModel.get_viewTypeSelection();
            }
            case 10: {
                return gEMAdapterModel.get_width();
            }
            case 11: {
                return gEMAdapterModel.get_x();
            }
            case 12: {
                return gEMAdapterModel.get_y();
            }
            case 13: {
                return gEMAdapterModel.get_z();
            }
        }
        return 0;
    }

    private static void setAnimateIntGenericCarAdjuster(GenericCarAdjusterModel genericCarAdjusterModel, int n, int n2) {
        switch (n) {
            case 0: {
                genericCarAdjusterModel.set_alpha(n2);
                break;
            }
            case 1: {
                genericCarAdjusterModel.set_configSubType(n2);
                break;
            }
            case 2: {
                genericCarAdjusterModel.set_featureEffectType(n2);
                break;
            }
            case 3: {
                genericCarAdjusterModel.set_height(n2);
                break;
            }
            case 4: {
                genericCarAdjusterModel.set_targetId(n2);
                break;
            }
            case 5: {
                genericCarAdjusterModel.set_width(n2);
                break;
            }
            case 6: {
                genericCarAdjusterModel.set_x(n2);
                break;
            }
            case 7: {
                genericCarAdjusterModel.set_y(n2);
                break;
            }
        }
    }

    private static int getAnimateIntGenericCarAdjuster(GenericCarAdjusterModel genericCarAdjusterModel, int n) {
        switch (n) {
            case 0: {
                return genericCarAdjusterModel.get_alpha();
            }
            case 1: {
                return genericCarAdjusterModel.get_configSubType();
            }
            case 2: {
                return genericCarAdjusterModel.get_featureEffectType();
            }
            case 3: {
                return genericCarAdjusterModel.get_height();
            }
            case 4: {
                return genericCarAdjusterModel.get_targetId();
            }
            case 5: {
                return genericCarAdjusterModel.get_width();
            }
            case 6: {
                return genericCarAdjusterModel.get_x();
            }
            case 7: {
                return genericCarAdjusterModel.get_y();
            }
        }
        return 0;
    }

    private static void setAnimateIntGuidance(GuidanceModel guidanceModel, int n, int n2) {
        switch (n) {
            case 0: {
                guidanceModel.set_alpha(n2);
                break;
            }
            case 1: {
                guidanceModel.set_currentDistancePercent(n2);
                break;
            }
            case 2: {
                guidanceModel.set_direction(n2);
                break;
            }
            case 3: {
                guidanceModel.set_height(n2);
                break;
            }
            case 4: {
                guidanceModel.set_mainElement(n2);
                break;
            }
            case 5: {
                guidanceModel.set_targetId(n2);
                break;
            }
            case 6: {
                guidanceModel.set_width(n2);
                break;
            }
            case 7: {
                guidanceModel.set_x(n2);
                break;
            }
            case 8: {
                guidanceModel.set_y(n2);
                break;
            }
            case 9: {
                guidanceModel.set_zLevel(n2);
                break;
            }
        }
    }

    private static int getAnimateIntGuidance(GuidanceModel guidanceModel, int n) {
        switch (n) {
            case 0: {
                return guidanceModel.get_alpha();
            }
            case 1: {
                return guidanceModel.get_currentDistancePercent();
            }
            case 2: {
                return guidanceModel.get_direction();
            }
            case 3: {
                return guidanceModel.get_height();
            }
            case 4: {
                return guidanceModel.get_mainElement();
            }
            case 5: {
                return guidanceModel.get_targetId();
            }
            case 6: {
                return guidanceModel.get_width();
            }
            case 7: {
                return guidanceModel.get_x();
            }
            case 8: {
                return guidanceModel.get_y();
            }
            case 9: {
                return guidanceModel.get_zLevel();
            }
        }
        return 0;
    }

    private static void setAnimateIntInactiveArea(InactiveAreaModel inactiveAreaModel, int n, int n2) {
        switch (n) {
            case 0: {
                inactiveAreaModel.set_alpha(n2);
                break;
            }
            case 1: {
                inactiveAreaModel.set_height(n2);
                break;
            }
            case 2: {
                inactiveAreaModel.set_reflectionAlpha(n2);
                break;
            }
            case 3: {
                inactiveAreaModel.set_reflectionDistance(n2);
                break;
            }
            case 4: {
                inactiveAreaModel.set_targetId(n2);
                break;
            }
            case 5: {
                inactiveAreaModel.set_width(n2);
                break;
            }
            case 6: {
                inactiveAreaModel.set_x(n2);
                break;
            }
            case 7: {
                inactiveAreaModel.set_y(n2);
                break;
            }
        }
    }

    private static int getAnimateIntInactiveArea(InactiveAreaModel inactiveAreaModel, int n) {
        switch (n) {
            case 0: {
                return inactiveAreaModel.get_alpha();
            }
            case 1: {
                return inactiveAreaModel.get_height();
            }
            case 2: {
                return inactiveAreaModel.get_reflectionAlpha();
            }
            case 3: {
                return inactiveAreaModel.get_reflectionDistance();
            }
            case 4: {
                return inactiveAreaModel.get_targetId();
            }
            case 5: {
                return inactiveAreaModel.get_width();
            }
            case 6: {
                return inactiveAreaModel.get_x();
            }
            case 7: {
                return inactiveAreaModel.get_y();
            }
        }
        return 0;
    }

    private static void setAnimateIntInputField(InputFieldModel inputFieldModel, int n, int n2) {
        switch (n) {
            case 0: {
                inputFieldModel.set_alignmentHorizontal(n2);
                break;
            }
            case 1: {
                inputFieldModel.set_alignmentVertical(n2);
                break;
            }
            case 2: {
                inputFieldModel.set_alpha(n2);
                break;
            }
            case 3: {
                inputFieldModel.set_baselineOffset(n2);
                break;
            }
            case 4: {
                inputFieldModel.set_bevelDepth(n2);
                break;
            }
            case 5: {
                inputFieldModel.set_bevelEnabled(n2);
                break;
            }
            case 6: {
                inputFieldModel.set_cursorMode(n2);
                break;
            }
            case 7: {
                inputFieldModel.set_cursorOffset(n2);
                break;
            }
            case 8: {
                inputFieldModel.set_dynamicResizeDirection(n2);
                break;
            }
            case 9: {
                inputFieldModel.set_dynamicSize(n2);
                break;
            }
            case 10: {
                inputFieldModel.set_glowType(n2);
                break;
            }
            case 11: {
                inputFieldModel.set_height(n2);
                break;
            }
            case 12: {
                inputFieldModel.set_lineBreakMode(n2);
                break;
            }
            case 13: {
                inputFieldModel.set_lineSpacing(n2);
                break;
            }
            case 14: {
                inputFieldModel.set_targetId(n2);
                break;
            }
            case 15: {
                inputFieldModel.set_visualLineCount(n2);
                break;
            }
            case 16: {
                inputFieldModel.set_width(n2);
                break;
            }
            case 17: {
                inputFieldModel.set_x(n2);
                break;
            }
            case 18: {
                inputFieldModel.set_y(n2);
                break;
            }
        }
    }

    private static int getAnimateIntInputField(InputFieldModel inputFieldModel, int n) {
        switch (n) {
            case 0: {
                return inputFieldModel.get_alignmentHorizontal();
            }
            case 1: {
                return inputFieldModel.get_alignmentVertical();
            }
            case 2: {
                return inputFieldModel.get_alpha();
            }
            case 3: {
                return inputFieldModel.get_baselineOffset();
            }
            case 4: {
                return inputFieldModel.get_bevelDepth();
            }
            case 5: {
                return inputFieldModel.get_bevelEnabled();
            }
            case 6: {
                return inputFieldModel.get_cursorMode();
            }
            case 7: {
                return inputFieldModel.get_cursorOffset();
            }
            case 8: {
                return inputFieldModel.get_dynamicResizeDirection();
            }
            case 9: {
                return inputFieldModel.get_dynamicSize();
            }
            case 10: {
                return inputFieldModel.get_glowType();
            }
            case 11: {
                return inputFieldModel.get_height();
            }
            case 12: {
                return inputFieldModel.get_lineBreakMode();
            }
            case 13: {
                return inputFieldModel.get_lineSpacing();
            }
            case 14: {
                return inputFieldModel.get_targetId();
            }
            case 15: {
                return inputFieldModel.get_visualLineCount();
            }
            case 16: {
                return inputFieldModel.get_width();
            }
            case 17: {
                return inputFieldModel.get_x();
            }
            case 18: {
                return inputFieldModel.get_y();
            }
        }
        return 0;
    }

    private static void setAnimateIntInstruments(InstrumentsModel instrumentsModel, int n, int n2) {
        switch (n) {
            case 0: {
                instrumentsModel.set_alpha(n2);
                break;
            }
            case 1: {
                instrumentsModel.set_decoration(n2);
                break;
            }
            case 2: {
                instrumentsModel.set_depth(n2);
                break;
            }
            case 3: {
                instrumentsModel.set_height(n2);
                break;
            }
            case 4: {
                instrumentsModel.set_mode(n2);
                break;
            }
            case 5: {
                instrumentsModel.set_pointerIdx(n2);
                break;
            }
            case 6: {
                instrumentsModel.set_projectionType(n2);
                break;
            }
            case 7: {
                instrumentsModel.set_radiusDrawingArea(n2);
                break;
            }
            case 8: {
                instrumentsModel.set_reflectionAlpha(n2);
                break;
            }
            case 9: {
                instrumentsModel.set_reflectionDistance(n2);
                break;
            }
            case 10: {
                instrumentsModel.set_targetId(n2);
                break;
            }
            case 11: {
                instrumentsModel.set_value(n2);
                break;
            }
            case 12: {
                instrumentsModel.set_valueAngle(n2);
                break;
            }
            case 13: {
                instrumentsModel.set_valueMax(n2);
                break;
            }
            case 14: {
                instrumentsModel.set_valueMin(n2);
                break;
            }
            case 15: {
                instrumentsModel.set_valueOut(n2);
                break;
            }
            case 16: {
                instrumentsModel.set_width(n2);
                break;
            }
            case 17: {
                instrumentsModel.set_x(n2);
                break;
            }
            case 18: {
                instrumentsModel.set_y(n2);
                break;
            }
            case 19: {
                instrumentsModel.set_z(n2);
                break;
            }
        }
    }

    private static int getAnimateIntInstruments(InstrumentsModel instrumentsModel, int n) {
        switch (n) {
            case 0: {
                return instrumentsModel.get_alpha();
            }
            case 1: {
                return instrumentsModel.get_decoration();
            }
            case 2: {
                return instrumentsModel.get_depth();
            }
            case 3: {
                return instrumentsModel.get_height();
            }
            case 4: {
                return instrumentsModel.get_mode();
            }
            case 5: {
                return instrumentsModel.get_pointerIdx();
            }
            case 6: {
                return instrumentsModel.get_projectionType();
            }
            case 7: {
                return instrumentsModel.get_radiusDrawingArea();
            }
            case 8: {
                return instrumentsModel.get_reflectionAlpha();
            }
            case 9: {
                return instrumentsModel.get_reflectionDistance();
            }
            case 10: {
                return instrumentsModel.get_targetId();
            }
            case 11: {
                return instrumentsModel.get_value();
            }
            case 12: {
                return instrumentsModel.get_valueAngle();
            }
            case 13: {
                return instrumentsModel.get_valueMax();
            }
            case 14: {
                return instrumentsModel.get_valueMin();
            }
            case 15: {
                return instrumentsModel.get_valueOut();
            }
            case 16: {
                return instrumentsModel.get_width();
            }
            case 17: {
                return instrumentsModel.get_x();
            }
            case 18: {
                return instrumentsModel.get_y();
            }
            case 19: {
                return instrumentsModel.get_z();
            }
        }
        return 0;
    }

    private static void setAnimateIntIris(IrisModel irisModel, int n, int n2) {
        switch (n) {
            case 0: {
                irisModel.set_acceleration(n2);
                break;
            }
            case 1: {
                irisModel.set_activeSegment(n2);
                break;
            }
            case 2: {
                irisModel.set_alpha(n2);
                break;
            }
            case 3: {
                irisModel.set_height(n2);
                break;
            }
            case 4: {
                irisModel.set_indicatorGlowOffset(n2);
                break;
            }
            case 5: {
                irisModel.set_maxAcceleration(n2);
                break;
            }
            case 6: {
                irisModel.set_maxAccelerationRotation(n2);
                break;
            }
            case 7: {
                irisModel.set_reflectionAlpha(n2);
                break;
            }
            case 8: {
                irisModel.set_reflectionDistance(n2);
                break;
            }
            case 9: {
                irisModel.set_segmentsValueMax(n2);
                break;
            }
            case 10: {
                irisModel.set_segmentsValueMin(n2);
                break;
            }
            case 11: {
                irisModel.set_targetId(n2);
                break;
            }
            case 12: {
                irisModel.set_width(n2);
                break;
            }
            case 13: {
                irisModel.set_x(n2);
                break;
            }
            case 14: {
                irisModel.set_y(n2);
                break;
            }
        }
    }

    private static int getAnimateIntIris(IrisModel irisModel, int n) {
        switch (n) {
            case 0: {
                return irisModel.get_acceleration();
            }
            case 1: {
                return irisModel.get_activeSegment();
            }
            case 2: {
                return irisModel.get_alpha();
            }
            case 3: {
                return irisModel.get_height();
            }
            case 4: {
                return irisModel.get_indicatorGlowOffset();
            }
            case 5: {
                return irisModel.get_maxAcceleration();
            }
            case 6: {
                return irisModel.get_maxAccelerationRotation();
            }
            case 7: {
                return irisModel.get_reflectionAlpha();
            }
            case 8: {
                return irisModel.get_reflectionDistance();
            }
            case 9: {
                return irisModel.get_segmentsValueMax();
            }
            case 10: {
                return irisModel.get_segmentsValueMin();
            }
            case 11: {
                return irisModel.get_targetId();
            }
            case 12: {
                return irisModel.get_width();
            }
            case 13: {
                return irisModel.get_x();
            }
            case 14: {
                return irisModel.get_y();
            }
        }
        return 0;
    }

    private static void setAnimateIntLabeledIcon(LabeledIconModel labeledIconModel, int n, int n2) {
        switch (n) {
            case 0: {
                labeledIconModel.set_alpha(n2);
                break;
            }
            case 1: {
                labeledIconModel.set_blendMode(n2);
                break;
            }
            case 2: {
                labeledIconModel.set_borderImageMode(n2);
                break;
            }
            case 3: {
                labeledIconModel.set_height(n2);
                break;
            }
            case 4: {
                labeledIconModel.set_lineSpacing(n2);
                break;
            }
            case 5: {
                labeledIconModel.set_reflectionAlpha(n2);
                break;
            }
            case 6: {
                labeledIconModel.set_reflectionDistance(n2);
                break;
            }
            case 7: {
                labeledIconModel.set_targetId(n2);
                break;
            }
            case 8: {
                labeledIconModel.set_transitionNextImageIn(n2);
                break;
            }
            case 9: {
                labeledIconModel.set_transitionNextImageOut(n2);
                break;
            }
            case 10: {
                labeledIconModel.set_width(n2);
                break;
            }
            case 11: {
                labeledIconModel.set_x(n2);
                break;
            }
            case 12: {
                labeledIconModel.set_y(n2);
                break;
            }
            case 13: {
                labeledIconModel.set_zoomType(n2);
                break;
            }
        }
    }

    private static int getAnimateIntLabeledIcon(LabeledIconModel labeledIconModel, int n) {
        switch (n) {
            case 0: {
                return labeledIconModel.get_alpha();
            }
            case 1: {
                return labeledIconModel.get_blendMode();
            }
            case 2: {
                return labeledIconModel.get_borderImageMode();
            }
            case 3: {
                return labeledIconModel.get_height();
            }
            case 4: {
                return labeledIconModel.get_lineSpacing();
            }
            case 5: {
                return labeledIconModel.get_reflectionAlpha();
            }
            case 6: {
                return labeledIconModel.get_reflectionDistance();
            }
            case 7: {
                return labeledIconModel.get_targetId();
            }
            case 8: {
                return labeledIconModel.get_transitionNextImageIn();
            }
            case 9: {
                return labeledIconModel.get_transitionNextImageOut();
            }
            case 10: {
                return labeledIconModel.get_width();
            }
            case 11: {
                return labeledIconModel.get_x();
            }
            case 12: {
                return labeledIconModel.get_y();
            }
            case 13: {
                return labeledIconModel.get_zoomType();
            }
        }
        return 0;
    }

    private static void setAnimateIntLaneGuidance(LaneGuidanceModel laneGuidanceModel, int n, int n2) {
        switch (n) {
            case 0: {
                laneGuidanceModel.set_alpha(n2);
                break;
            }
            case 1: {
                laneGuidanceModel.set_blendMode(n2);
                break;
            }
            case 2: {
                laneGuidanceModel.set_height(n2);
                break;
            }
            case 3: {
                laneGuidanceModel.set_numberOfVisibleLanes(n2);
                break;
            }
            case 4: {
                laneGuidanceModel.set_steeringWheelSide(n2);
                break;
            }
            case 5: {
                laneGuidanceModel.set_targetId(n2);
                break;
            }
            case 6: {
                laneGuidanceModel.set_width(n2);
                break;
            }
            case 7: {
                laneGuidanceModel.set_x(n2);
                break;
            }
            case 8: {
                laneGuidanceModel.set_y(n2);
                break;
            }
        }
    }

    private static int getAnimateIntLaneGuidance(LaneGuidanceModel laneGuidanceModel, int n) {
        switch (n) {
            case 0: {
                return laneGuidanceModel.get_alpha();
            }
            case 1: {
                return laneGuidanceModel.get_blendMode();
            }
            case 2: {
                return laneGuidanceModel.get_height();
            }
            case 3: {
                return laneGuidanceModel.get_numberOfVisibleLanes();
            }
            case 4: {
                return laneGuidanceModel.get_steeringWheelSide();
            }
            case 5: {
                return laneGuidanceModel.get_targetId();
            }
            case 6: {
                return laneGuidanceModel.get_width();
            }
            case 7: {
                return laneGuidanceModel.get_x();
            }
            case 8: {
                return laneGuidanceModel.get_y();
            }
        }
        return 0;
    }

    private static void setAnimateIntListItem(ListItemModel listItemModel, int n, int n2) {
        switch (n) {
            case 0: {
                listItemModel.set_activatedIndex(n2);
                break;
            }
            case 1: {
                listItemModel.set_alpha(n2);
                break;
            }
            case 2: {
                listItemModel.set_decoration(n2);
                break;
            }
            case 3: {
                listItemModel.set_depth(n2);
                break;
            }
            case 4: {
                listItemModel.set_dropDownIndex(n2);
                break;
            }
            case 5: {
                listItemModel.set_dynamicIndex(n2);
                break;
            }
            case 6: {
                listItemModel.set_dynamicResizeDirection(n2);
                break;
            }
            case 7: {
                listItemModel.set_height(n2);
                break;
            }
            case 8: {
                listItemModel.set_limitation(n2);
                break;
            }
            case 9: {
                listItemModel.set_projectionType(n2);
                break;
            }
            case 10: {
                listItemModel.set_reflectionAlpha(n2);
                break;
            }
            case 11: {
                listItemModel.set_reflectionDistance(n2);
                break;
            }
            case 12: {
                listItemModel.set_targetId(n2);
                break;
            }
            case 13: {
                listItemModel.set_width(n2);
                break;
            }
            case 14: {
                listItemModel.set_x(n2);
                break;
            }
            case 15: {
                listItemModel.set_y(n2);
                break;
            }
            case 16: {
                listItemModel.set_z(n2);
                break;
            }
        }
    }

    private static int getAnimateIntListItem(ListItemModel listItemModel, int n) {
        switch (n) {
            case 0: {
                return listItemModel.get_activatedIndex();
            }
            case 1: {
                return listItemModel.get_alpha();
            }
            case 2: {
                return listItemModel.get_decoration();
            }
            case 3: {
                return listItemModel.get_depth();
            }
            case 4: {
                return listItemModel.get_dropDownIndex();
            }
            case 5: {
                return listItemModel.get_dynamicIndex();
            }
            case 6: {
                return listItemModel.get_dynamicResizeDirection();
            }
            case 7: {
                return listItemModel.get_height();
            }
            case 8: {
                return listItemModel.get_limitation();
            }
            case 9: {
                return listItemModel.get_projectionType();
            }
            case 10: {
                return listItemModel.get_reflectionAlpha();
            }
            case 11: {
                return listItemModel.get_reflectionDistance();
            }
            case 12: {
                return listItemModel.get_targetId();
            }
            case 13: {
                return listItemModel.get_width();
            }
            case 14: {
                return listItemModel.get_x();
            }
            case 15: {
                return listItemModel.get_y();
            }
            case 16: {
                return listItemModel.get_z();
            }
        }
        return 0;
    }

    private static void setAnimateIntMeshWidget(MeshWidgetModel meshWidgetModel, int n, int n2) {
        switch (n) {
            case 0: {
                meshWidgetModel.set_alpha(n2);
                break;
            }
            case 1: {
                meshWidgetModel.set_height(n2);
                break;
            }
            case 2: {
                meshWidgetModel.set_targetId(n2);
                break;
            }
            case 3: {
                meshWidgetModel.set_width(n2);
                break;
            }
            case 4: {
                meshWidgetModel.set_x(n2);
                break;
            }
            case 5: {
                meshWidgetModel.set_y(n2);
                break;
            }
        }
    }

    private static int getAnimateIntMeshWidget(MeshWidgetModel meshWidgetModel, int n) {
        switch (n) {
            case 0: {
                return meshWidgetModel.get_alpha();
            }
            case 1: {
                return meshWidgetModel.get_height();
            }
            case 2: {
                return meshWidgetModel.get_targetId();
            }
            case 3: {
                return meshWidgetModel.get_width();
            }
            case 4: {
                return meshWidgetModel.get_x();
            }
            case 5: {
                return meshWidgetModel.get_y();
            }
        }
        return 0;
    }

    private static void setAnimateIntOPS(OPSModel oPSModel, int n, int n2) {
        switch (n) {
            case 0: {
                oPSModel.set_alpha(n2);
                break;
            }
            case 1: {
                oPSModel.set_height(n2);
                break;
            }
            case 2: {
                oPSModel.set_radiusFront(n2);
                break;
            }
            case 3: {
                oPSModel.set_radiusRear(n2);
                break;
            }
            case 4: {
                oPSModel.set_targetId(n2);
                break;
            }
            case 5: {
                oPSModel.set_trackDisplay(n2);
                break;
            }
            case 6: {
                oPSModel.set_wheelBase(n2);
                break;
            }
            case 7: {
                oPSModel.set_width(n2);
                break;
            }
            case 8: {
                oPSModel.set_x(n2);
                break;
            }
            case 9: {
                oPSModel.set_y(n2);
                break;
            }
        }
    }

    private static int getAnimateIntOPS(OPSModel oPSModel, int n) {
        switch (n) {
            case 0: {
                return oPSModel.get_alpha();
            }
            case 1: {
                return oPSModel.get_height();
            }
            case 2: {
                return oPSModel.get_radiusFront();
            }
            case 3: {
                return oPSModel.get_radiusRear();
            }
            case 4: {
                return oPSModel.get_targetId();
            }
            case 5: {
                return oPSModel.get_trackDisplay();
            }
            case 6: {
                return oPSModel.get_wheelBase();
            }
            case 7: {
                return oPSModel.get_width();
            }
            case 8: {
                return oPSModel.get_x();
            }
            case 9: {
                return oPSModel.get_y();
            }
        }
        return 0;
    }

    private static void setAnimateIntParticleSystem(ParticleSystemModel particleSystemModel, int n, int n2) {
        switch (n) {
            case 0: {
                particleSystemModel.set_alpha(n2);
                break;
            }
            case 1: {
                particleSystemModel.set_height(n2);
                break;
            }
            case 2: {
                particleSystemModel.set_targetId(n2);
                break;
            }
            case 3: {
                particleSystemModel.set_width(n2);
                break;
            }
            case 4: {
                particleSystemModel.set_x(n2);
                break;
            }
            case 5: {
                particleSystemModel.set_y(n2);
                break;
            }
        }
    }

    private static int getAnimateIntParticleSystem(ParticleSystemModel particleSystemModel, int n) {
        switch (n) {
            case 0: {
                return particleSystemModel.get_alpha();
            }
            case 1: {
                return particleSystemModel.get_height();
            }
            case 2: {
                return particleSystemModel.get_targetId();
            }
            case 3: {
                return particleSystemModel.get_width();
            }
            case 4: {
                return particleSystemModel.get_x();
            }
            case 5: {
                return particleSystemModel.get_y();
            }
        }
        return 0;
    }

    private static void setAnimateIntPictureViewer(PictureViewerModel pictureViewerModel, int n, int n2) {
        switch (n) {
            case 0: {
                pictureViewerModel.set_alpha(n2);
                break;
            }
            case 1: {
                pictureViewerModel.set_blendMode(n2);
                break;
            }
            case 2: {
                pictureViewerModel.set_borderImageMode(n2);
                break;
            }
            case 3: {
                pictureViewerModel.set_height(n2);
                break;
            }
            case 4: {
                pictureViewerModel.set_reflectionAlpha(n2);
                break;
            }
            case 5: {
                pictureViewerModel.set_reflectionDistance(n2);
                break;
            }
            case 6: {
                pictureViewerModel.set_rotationAngle(n2);
                break;
            }
            case 7: {
                pictureViewerModel.set_slideShowDelay(n2);
                break;
            }
            case 8: {
                pictureViewerModel.set_targetId(n2);
                break;
            }
            case 9: {
                pictureViewerModel.set_transitionNextImageIn(n2);
                break;
            }
            case 10: {
                pictureViewerModel.set_transitionNextImageOut(n2);
                break;
            }
            case 11: {
                pictureViewerModel.set_transitionPrevImageIn(n2);
                break;
            }
            case 12: {
                pictureViewerModel.set_transitionPrevImageOut(n2);
                break;
            }
            case 13: {
                pictureViewerModel.set_width(n2);
                break;
            }
            case 14: {
                pictureViewerModel.set_x(n2);
                break;
            }
            case 15: {
                pictureViewerModel.set_y(n2);
                break;
            }
            case 16: {
                pictureViewerModel.set_zoom(n2);
                break;
            }
            case 17: {
                pictureViewerModel.set_zoomInitial(n2);
                break;
            }
            case 18: {
                pictureViewerModel.set_zoomMax(n2);
                break;
            }
            case 19: {
                pictureViewerModel.set_zoomMin(n2);
                break;
            }
            case 20: {
                pictureViewerModel.set_zoomStep(n2);
                break;
            }
            case 21: {
                pictureViewerModel.set_zoomType(n2);
                break;
            }
        }
    }

    private static int getAnimateIntPictureViewer(PictureViewerModel pictureViewerModel, int n) {
        switch (n) {
            case 0: {
                return pictureViewerModel.get_alpha();
            }
            case 1: {
                return pictureViewerModel.get_blendMode();
            }
            case 2: {
                return pictureViewerModel.get_borderImageMode();
            }
            case 3: {
                return pictureViewerModel.get_height();
            }
            case 4: {
                return pictureViewerModel.get_reflectionAlpha();
            }
            case 5: {
                return pictureViewerModel.get_reflectionDistance();
            }
            case 6: {
                return pictureViewerModel.get_rotationAngle();
            }
            case 7: {
                return pictureViewerModel.get_slideShowDelay();
            }
            case 8: {
                return pictureViewerModel.get_targetId();
            }
            case 9: {
                return pictureViewerModel.get_transitionNextImageIn();
            }
            case 10: {
                return pictureViewerModel.get_transitionNextImageOut();
            }
            case 11: {
                return pictureViewerModel.get_transitionPrevImageIn();
            }
            case 12: {
                return pictureViewerModel.get_transitionPrevImageOut();
            }
            case 13: {
                return pictureViewerModel.get_width();
            }
            case 14: {
                return pictureViewerModel.get_x();
            }
            case 15: {
                return pictureViewerModel.get_y();
            }
            case 16: {
                return pictureViewerModel.get_zoom();
            }
            case 17: {
                return pictureViewerModel.get_zoomInitial();
            }
            case 18: {
                return pictureViewerModel.get_zoomMax();
            }
            case 19: {
                return pictureViewerModel.get_zoomMin();
            }
            case 20: {
                return pictureViewerModel.get_zoomStep();
            }
            case 21: {
                return pictureViewerModel.get_zoomType();
            }
        }
        return 0;
    }

    private static void setAnimateIntPopupView(PopupViewModel popupViewModel, int n, int n2) {
        switch (n) {
            case 0: {
                popupViewModel.set_alpha(n2);
                break;
            }
            case 1: {
                popupViewModel.set_compositeBackgroundArrowOffsetX(n2);
                break;
            }
            case 2: {
                popupViewModel.set_compositeBackgroundArrowOffsetY(n2);
                break;
            }
            case 3: {
                popupViewModel.set_compositeBackgroundMode(n2);
                break;
            }
            case 4: {
                popupViewModel.set_decoration(n2);
                break;
            }
            case 5: {
                popupViewModel.set_depth(n2);
                break;
            }
            case 6: {
                popupViewModel.set_height(n2);
                break;
            }
            case 7: {
                popupViewModel.set_projectionType(n2);
                break;
            }
            case 8: {
                popupViewModel.set_reflectionAlpha(n2);
                break;
            }
            case 9: {
                popupViewModel.set_reflectionDistance(n2);
                break;
            }
            case 10: {
                popupViewModel.set_restrictionMode(n2);
                break;
            }
            case 11: {
                popupViewModel.set_targetId(n2);
                break;
            }
            case 12: {
                popupViewModel.set_touchForwardingMode(n2);
                break;
            }
            case 13: {
                popupViewModel.set_viewTypeSelection(n2);
                break;
            }
            case 14: {
                popupViewModel.set_visibleAreaAlignment(n2);
                break;
            }
            case 15: {
                popupViewModel.set_width(n2);
                break;
            }
            case 16: {
                popupViewModel.set_x(n2);
                break;
            }
            case 17: {
                popupViewModel.set_y(n2);
                break;
            }
            case 18: {
                popupViewModel.set_z(n2);
                break;
            }
        }
    }

    private static int getAnimateIntPopupView(PopupViewModel popupViewModel, int n) {
        switch (n) {
            case 0: {
                return popupViewModel.get_alpha();
            }
            case 1: {
                return popupViewModel.get_compositeBackgroundArrowOffsetX();
            }
            case 2: {
                return popupViewModel.get_compositeBackgroundArrowOffsetY();
            }
            case 3: {
                return popupViewModel.get_compositeBackgroundMode();
            }
            case 4: {
                return popupViewModel.get_decoration();
            }
            case 5: {
                return popupViewModel.get_depth();
            }
            case 6: {
                return popupViewModel.get_height();
            }
            case 7: {
                return popupViewModel.get_projectionType();
            }
            case 8: {
                return popupViewModel.get_reflectionAlpha();
            }
            case 9: {
                return popupViewModel.get_reflectionDistance();
            }
            case 10: {
                return popupViewModel.get_restrictionMode();
            }
            case 11: {
                return popupViewModel.get_targetId();
            }
            case 12: {
                return popupViewModel.get_touchForwardingMode();
            }
            case 13: {
                return popupViewModel.get_viewTypeSelection();
            }
            case 14: {
                return popupViewModel.get_visibleAreaAlignment();
            }
            case 15: {
                return popupViewModel.get_width();
            }
            case 16: {
                return popupViewModel.get_x();
            }
            case 17: {
                return popupViewModel.get_y();
            }
            case 18: {
                return popupViewModel.get_z();
            }
        }
        return 0;
    }

    private static void setAnimateIntPreviewLine(PreviewLineModel previewLineModel, int n, int n2) {
        switch (n) {
            case 0: {
                previewLineModel.set_alpha(n2);
                break;
            }
            case 1: {
                previewLineModel.set_compositeBackgroundArrowOffsetX(n2);
                break;
            }
            case 2: {
                previewLineModel.set_compositeBackgroundArrowOffsetY(n2);
                break;
            }
            case 3: {
                previewLineModel.set_compositeBackgroundMode(n2);
                break;
            }
            case 4: {
                previewLineModel.set_flyingWindowMode(n2);
                break;
            }
            case 5: {
                previewLineModel.set_height(n2);
                break;
            }
            case 6: {
                previewLineModel.set_reflectionAlpha(n2);
                break;
            }
            case 7: {
                previewLineModel.set_reflectionDistance(n2);
                break;
            }
            case 8: {
                previewLineModel.set_targetId(n2);
                break;
            }
            case 9: {
                previewLineModel.set_width(n2);
                break;
            }
            case 10: {
                previewLineModel.set_x(n2);
                break;
            }
            case 11: {
                previewLineModel.set_y(n2);
                break;
            }
        }
    }

    private static int getAnimateIntPreviewLine(PreviewLineModel previewLineModel, int n) {
        switch (n) {
            case 0: {
                return previewLineModel.get_alpha();
            }
            case 1: {
                return previewLineModel.get_compositeBackgroundArrowOffsetX();
            }
            case 2: {
                return previewLineModel.get_compositeBackgroundArrowOffsetY();
            }
            case 3: {
                return previewLineModel.get_compositeBackgroundMode();
            }
            case 4: {
                return previewLineModel.get_flyingWindowMode();
            }
            case 5: {
                return previewLineModel.get_height();
            }
            case 6: {
                return previewLineModel.get_reflectionAlpha();
            }
            case 7: {
                return previewLineModel.get_reflectionDistance();
            }
            case 8: {
                return previewLineModel.get_targetId();
            }
            case 9: {
                return previewLineModel.get_width();
            }
            case 10: {
                return previewLineModel.get_x();
            }
            case 11: {
                return previewLineModel.get_y();
            }
        }
        return 0;
    }

    private static void setAnimateIntPureAir(PureAirModel pureAirModel, int n, int n2) {
        switch (n) {
            case 0: {
                pureAirModel.set_airMode(n2);
                break;
            }
            case 1: {
                pureAirModel.set_alpha(n2);
                break;
            }
            case 2: {
                pureAirModel.set_blendMode(n2);
                break;
            }
            case 3: {
                pureAirModel.set_height(n2);
                break;
            }
            case 4: {
                pureAirModel.set_targetId(n2);
                break;
            }
            case 5: {
                pureAirModel.set_valueClean(n2);
                break;
            }
            case 6: {
                pureAirModel.set_width(n2);
                break;
            }
            case 7: {
                pureAirModel.set_x(n2);
                break;
            }
            case 8: {
                pureAirModel.set_y(n2);
                break;
            }
        }
    }

    private static int getAnimateIntPureAir(PureAirModel pureAirModel, int n) {
        switch (n) {
            case 0: {
                return pureAirModel.get_airMode();
            }
            case 1: {
                return pureAirModel.get_alpha();
            }
            case 2: {
                return pureAirModel.get_blendMode();
            }
            case 3: {
                return pureAirModel.get_height();
            }
            case 4: {
                return pureAirModel.get_targetId();
            }
            case 5: {
                return pureAirModel.get_valueClean();
            }
            case 6: {
                return pureAirModel.get_width();
            }
            case 7: {
                return pureAirModel.get_x();
            }
            case 8: {
                return pureAirModel.get_y();
            }
        }
        return 0;
    }

    private static void setAnimateIntPushUp(PushUpModel pushUpModel, int n, int n2) {
        switch (n) {
            case 0: {
                pushUpModel.set_alpha(n2);
                break;
            }
            case 1: {
                pushUpModel.set_closeMode(n2);
                break;
            }
            case 2: {
                pushUpModel.set_compositeBackgroundArrowOffsetX(n2);
                break;
            }
            case 3: {
                pushUpModel.set_compositeBackgroundArrowOffsetY(n2);
                break;
            }
            case 4: {
                pushUpModel.set_compositeBackgroundMode(n2);
                break;
            }
            case 5: {
                pushUpModel.set_flyingWindowMode(n2);
                break;
            }
            case 6: {
                pushUpModel.set_height(n2);
                break;
            }
            case 7: {
                pushUpModel.set_reflectionAlpha(n2);
                break;
            }
            case 8: {
                pushUpModel.set_reflectionDistance(n2);
                break;
            }
            case 9: {
                pushUpModel.set_scalingPivot(n2);
                break;
            }
            case 10: {
                pushUpModel.set_targetId(n2);
                break;
            }
            case 11: {
                pushUpModel.set_width(n2);
                break;
            }
            case 12: {
                pushUpModel.set_x(n2);
                break;
            }
            case 13: {
                pushUpModel.set_y(n2);
                break;
            }
        }
    }

    private static int getAnimateIntPushUp(PushUpModel pushUpModel, int n) {
        switch (n) {
            case 0: {
                return pushUpModel.get_alpha();
            }
            case 1: {
                return pushUpModel.get_closeMode();
            }
            case 2: {
                return pushUpModel.get_compositeBackgroundArrowOffsetX();
            }
            case 3: {
                return pushUpModel.get_compositeBackgroundArrowOffsetY();
            }
            case 4: {
                return pushUpModel.get_compositeBackgroundMode();
            }
            case 5: {
                return pushUpModel.get_flyingWindowMode();
            }
            case 6: {
                return pushUpModel.get_height();
            }
            case 7: {
                return pushUpModel.get_reflectionAlpha();
            }
            case 8: {
                return pushUpModel.get_reflectionDistance();
            }
            case 9: {
                return pushUpModel.get_scalingPivot();
            }
            case 10: {
                return pushUpModel.get_targetId();
            }
            case 11: {
                return pushUpModel.get_width();
            }
            case 12: {
                return pushUpModel.get_x();
            }
            case 13: {
                return pushUpModel.get_y();
            }
        }
        return 0;
    }

    private static void setAnimateIntReferenceWidget(ReferenceWidgetModel referenceWidgetModel, int n, int n2) {
        switch (n) {
            case 0: {
                referenceWidgetModel.set_alpha(n2);
                break;
            }
            case 1: {
                referenceWidgetModel.set_height(n2);
                break;
            }
            case 2: {
                referenceWidgetModel.set_reflectionAlpha(n2);
                break;
            }
            case 3: {
                referenceWidgetModel.set_reflectionDistance(n2);
                break;
            }
            case 4: {
                referenceWidgetModel.set_targetId(n2);
                break;
            }
            case 5: {
                referenceWidgetModel.set_width(n2);
                break;
            }
            case 6: {
                referenceWidgetModel.set_x(n2);
                break;
            }
            case 7: {
                referenceWidgetModel.set_y(n2);
                break;
            }
        }
    }

    private static int getAnimateIntReferenceWidget(ReferenceWidgetModel referenceWidgetModel, int n) {
        switch (n) {
            case 0: {
                return referenceWidgetModel.get_alpha();
            }
            case 1: {
                return referenceWidgetModel.get_height();
            }
            case 2: {
                return referenceWidgetModel.get_reflectionAlpha();
            }
            case 3: {
                return referenceWidgetModel.get_reflectionDistance();
            }
            case 4: {
                return referenceWidgetModel.get_targetId();
            }
            case 5: {
                return referenceWidgetModel.get_width();
            }
            case 6: {
                return referenceWidgetModel.get_x();
            }
            case 7: {
                return referenceWidgetModel.get_y();
            }
        }
        return 0;
    }

    private static void setAnimateIntRunnerWidget(RunnerWidgetModel runnerWidgetModel, int n, int n2) {
        switch (n) {
            case 0: {
                runnerWidgetModel.set_alpha(n2);
                break;
            }
            case 1: {
                runnerWidgetModel.set_height(n2);
                break;
            }
            case 2: {
                runnerWidgetModel.set_mode(n2);
                break;
            }
            case 3: {
                runnerWidgetModel.set_targetId(n2);
                break;
            }
            case 4: {
                runnerWidgetModel.set_timeSpan(n2);
                break;
            }
            case 5: {
                runnerWidgetModel.set_updateInterval(n2);
                break;
            }
            case 6: {
                runnerWidgetModel.set_value(n2);
                break;
            }
            case 7: {
                runnerWidgetModel.set_valueMax(n2);
                break;
            }
            case 8: {
                runnerWidgetModel.set_valueMin(n2);
                break;
            }
            case 9: {
                runnerWidgetModel.set_width(n2);
                break;
            }
            case 10: {
                runnerWidgetModel.set_x(n2);
                break;
            }
            case 11: {
                runnerWidgetModel.set_y(n2);
                break;
            }
        }
    }

    private static int getAnimateIntRunnerWidget(RunnerWidgetModel runnerWidgetModel, int n) {
        switch (n) {
            case 0: {
                return runnerWidgetModel.get_alpha();
            }
            case 1: {
                return runnerWidgetModel.get_height();
            }
            case 2: {
                return runnerWidgetModel.get_mode();
            }
            case 3: {
                return runnerWidgetModel.get_targetId();
            }
            case 4: {
                return runnerWidgetModel.get_timeSpan();
            }
            case 5: {
                return runnerWidgetModel.get_updateInterval();
            }
            case 6: {
                return runnerWidgetModel.get_value();
            }
            case 7: {
                return runnerWidgetModel.get_valueMax();
            }
            case 8: {
                return runnerWidgetModel.get_valueMin();
            }
            case 9: {
                return runnerWidgetModel.get_width();
            }
            case 10: {
                return runnerWidgetModel.get_x();
            }
            case 11: {
                return runnerWidgetModel.get_y();
            }
        }
        return 0;
    }

    private static void setAnimateIntScreen(ScreenModel screenModel, int n, int n2) {
        switch (n) {
            case 0: {
                screenModel.set_alpha(n2);
                break;
            }
            case 1: {
                screenModel.set_decoration(n2);
                break;
            }
            case 2: {
                screenModel.set_depth(n2);
                break;
            }
            case 3: {
                screenModel.set_height(n2);
                break;
            }
            case 4: {
                screenModel.set_projectionType(n2);
                break;
            }
            case 5: {
                screenModel.set_reflectionAlpha(n2);
                break;
            }
            case 6: {
                screenModel.set_reflectionDistance(n2);
                break;
            }
            case 7: {
                screenModel.set_targetId(n2);
                break;
            }
            case 8: {
                screenModel.set_touchForwardingMode(n2);
                break;
            }
            case 9: {
                screenModel.set_viewTypeSelection(n2);
                break;
            }
            case 10: {
                screenModel.set_width(n2);
                break;
            }
            case 11: {
                screenModel.set_x(n2);
                break;
            }
            case 12: {
                screenModel.set_y(n2);
                break;
            }
            case 13: {
                screenModel.set_z(n2);
                break;
            }
        }
    }

    private static int getAnimateIntScreen(ScreenModel screenModel, int n) {
        switch (n) {
            case 0: {
                return screenModel.get_alpha();
            }
            case 1: {
                return screenModel.get_decoration();
            }
            case 2: {
                return screenModel.get_depth();
            }
            case 3: {
                return screenModel.get_height();
            }
            case 4: {
                return screenModel.get_projectionType();
            }
            case 5: {
                return screenModel.get_reflectionAlpha();
            }
            case 6: {
                return screenModel.get_reflectionDistance();
            }
            case 7: {
                return screenModel.get_targetId();
            }
            case 8: {
                return screenModel.get_touchForwardingMode();
            }
            case 9: {
                return screenModel.get_viewTypeSelection();
            }
            case 10: {
                return screenModel.get_width();
            }
            case 11: {
                return screenModel.get_x();
            }
            case 12: {
                return screenModel.get_y();
            }
            case 13: {
                return screenModel.get_z();
            }
        }
        return 0;
    }

    private static void setAnimateIntScreenArea(ScreenAreaModel screenAreaModel, int n, int n2) {
        switch (n) {
            case 0: {
                screenAreaModel.set_alpha(n2);
                break;
            }
            case 1: {
                screenAreaModel.set_decoration(n2);
                break;
            }
            case 2: {
                screenAreaModel.set_depth(n2);
                break;
            }
            case 3: {
                screenAreaModel.set_height(n2);
                break;
            }
            case 4: {
                screenAreaModel.set_projectionType(n2);
                break;
            }
            case 5: {
                screenAreaModel.set_reflectionAlpha(n2);
                break;
            }
            case 6: {
                screenAreaModel.set_reflectionDistance(n2);
                break;
            }
            case 7: {
                screenAreaModel.set_scalemode(n2);
                break;
            }
            case 8: {
                screenAreaModel.set_targetId(n2);
                break;
            }
            case 9: {
                screenAreaModel.set_viewAlignment(n2);
                break;
            }
            case 10: {
                screenAreaModel.set_width(n2);
                break;
            }
            case 11: {
                screenAreaModel.set_x(n2);
                break;
            }
            case 12: {
                screenAreaModel.set_y(n2);
                break;
            }
            case 13: {
                screenAreaModel.set_z(n2);
                break;
            }
        }
    }

    private static int getAnimateIntScreenArea(ScreenAreaModel screenAreaModel, int n) {
        switch (n) {
            case 0: {
                return screenAreaModel.get_alpha();
            }
            case 1: {
                return screenAreaModel.get_decoration();
            }
            case 2: {
                return screenAreaModel.get_depth();
            }
            case 3: {
                return screenAreaModel.get_height();
            }
            case 4: {
                return screenAreaModel.get_projectionType();
            }
            case 5: {
                return screenAreaModel.get_reflectionAlpha();
            }
            case 6: {
                return screenAreaModel.get_reflectionDistance();
            }
            case 7: {
                return screenAreaModel.get_scalemode();
            }
            case 8: {
                return screenAreaModel.get_targetId();
            }
            case 9: {
                return screenAreaModel.get_viewAlignment();
            }
            case 10: {
                return screenAreaModel.get_width();
            }
            case 11: {
                return screenAreaModel.get_x();
            }
            case 12: {
                return screenAreaModel.get_y();
            }
            case 13: {
                return screenAreaModel.get_z();
            }
        }
        return 0;
    }

    private static void setAnimateIntScrollableText(ScrollableTextModel scrollableTextModel, int n, int n2) {
        switch (n) {
            case 0: {
                scrollableTextModel.set_alignmentHorizontal(n2);
                break;
            }
            case 1: {
                scrollableTextModel.set_alpha(n2);
                break;
            }
            case 2: {
                scrollableTextModel.set_baselineOffset(n2);
                break;
            }
            case 3: {
                scrollableTextModel.set_bevelDepth(n2);
                break;
            }
            case 4: {
                scrollableTextModel.set_bevelEnabled(n2);
                break;
            }
            case 5: {
                scrollableTextModel.set_firstLineIndex(n2);
                break;
            }
            case 6: {
                scrollableTextModel.set_glowType(n2);
                break;
            }
            case 7: {
                scrollableTextModel.set_height(n2);
                break;
            }
            case 8: {
                scrollableTextModel.set_lineSpacing(n2);
                break;
            }
            case 9: {
                scrollableTextModel.set_targetId(n2);
                break;
            }
            case 10: {
                scrollableTextModel.set_visualLineCount(n2);
                break;
            }
            case 11: {
                scrollableTextModel.set_width(n2);
                break;
            }
            case 12: {
                scrollableTextModel.set_x(n2);
                break;
            }
            case 13: {
                scrollableTextModel.set_y(n2);
                break;
            }
        }
    }

    private static int getAnimateIntScrollableText(ScrollableTextModel scrollableTextModel, int n) {
        switch (n) {
            case 0: {
                return scrollableTextModel.get_alignmentHorizontal();
            }
            case 1: {
                return scrollableTextModel.get_alpha();
            }
            case 2: {
                return scrollableTextModel.get_baselineOffset();
            }
            case 3: {
                return scrollableTextModel.get_bevelDepth();
            }
            case 4: {
                return scrollableTextModel.get_bevelEnabled();
            }
            case 5: {
                return scrollableTextModel.get_firstLineIndex();
            }
            case 6: {
                return scrollableTextModel.get_glowType();
            }
            case 7: {
                return scrollableTextModel.get_height();
            }
            case 8: {
                return scrollableTextModel.get_lineSpacing();
            }
            case 9: {
                return scrollableTextModel.get_targetId();
            }
            case 10: {
                return scrollableTextModel.get_visualLineCount();
            }
            case 11: {
                return scrollableTextModel.get_width();
            }
            case 12: {
                return scrollableTextModel.get_x();
            }
            case 13: {
                return scrollableTextModel.get_y();
            }
        }
        return 0;
    }

    private static void setAnimateIntScrollbar(ScrollbarModel scrollbarModel, int n, int n2) {
        switch (n) {
            case 0: {
                scrollbarModel.set_alpha(n2);
                break;
            }
            case 1: {
                scrollbarModel.set_height(n2);
                break;
            }
            case 2: {
                scrollbarModel.set_minScrollbarSize(n2);
                break;
            }
            case 3: {
                scrollbarModel.set_orientation(n2);
                break;
            }
            case 4: {
                scrollbarModel.set_paddingMax(n2);
                break;
            }
            case 5: {
                scrollbarModel.set_paddingMin(n2);
                break;
            }
            case 6: {
                scrollbarModel.set_pageSize(n2);
                break;
            }
            case 7: {
                scrollbarModel.set_reflectionAlpha(n2);
                break;
            }
            case 8: {
                scrollbarModel.set_reflectionDistance(n2);
                break;
            }
            case 9: {
                scrollbarModel.set_repeatTime(n2);
                break;
            }
            case 10: {
                scrollbarModel.set_startTime(n2);
                break;
            }
            case 11: {
                scrollbarModel.set_state(n2);
                break;
            }
            case 12: {
                scrollbarModel.set_step(n2);
                break;
            }
            case 13: {
                scrollbarModel.set_stepValues(n2);
                break;
            }
            case 14: {
                scrollbarModel.set_targetId(n2);
                break;
            }
            case 15: {
                scrollbarModel.set_value(n2);
                break;
            }
            case 16: {
                scrollbarModel.set_valueMax(n2);
                break;
            }
            case 17: {
                scrollbarModel.set_valueMin(n2);
                break;
            }
            case 18: {
                scrollbarModel.set_visibilityMode(n2);
                break;
            }
            case 19: {
                scrollbarModel.set_width(n2);
                break;
            }
            case 20: {
                scrollbarModel.set_x(n2);
                break;
            }
            case 21: {
                scrollbarModel.set_y(n2);
                break;
            }
        }
    }

    private static int getAnimateIntScrollbar(ScrollbarModel scrollbarModel, int n) {
        switch (n) {
            case 0: {
                return scrollbarModel.get_alpha();
            }
            case 1: {
                return scrollbarModel.get_height();
            }
            case 2: {
                return scrollbarModel.get_minScrollbarSize();
            }
            case 3: {
                return scrollbarModel.get_orientation();
            }
            case 4: {
                return scrollbarModel.get_paddingMax();
            }
            case 5: {
                return scrollbarModel.get_paddingMin();
            }
            case 6: {
                return scrollbarModel.get_pageSize();
            }
            case 7: {
                return scrollbarModel.get_reflectionAlpha();
            }
            case 8: {
                return scrollbarModel.get_reflectionDistance();
            }
            case 9: {
                return scrollbarModel.get_repeatTime();
            }
            case 10: {
                return scrollbarModel.get_startTime();
            }
            case 11: {
                return scrollbarModel.get_state();
            }
            case 12: {
                return scrollbarModel.get_step();
            }
            case 13: {
                return scrollbarModel.get_stepValues();
            }
            case 14: {
                return scrollbarModel.get_targetId();
            }
            case 15: {
                return scrollbarModel.get_value();
            }
            case 16: {
                return scrollbarModel.get_valueMax();
            }
            case 17: {
                return scrollbarModel.get_valueMin();
            }
            case 18: {
                return scrollbarModel.get_visibilityMode();
            }
            case 19: {
                return scrollbarModel.get_width();
            }
            case 20: {
                return scrollbarModel.get_x();
            }
            case 21: {
                return scrollbarModel.get_y();
            }
        }
        return 0;
    }

    private static void setAnimateIntSequencedImage(SequencedImageModel sequencedImageModel, int n, int n2) {
        switch (n) {
            case 0: {
                sequencedImageModel.set_alpha(n2);
                break;
            }
            case 1: {
                sequencedImageModel.set_blendMode(n2);
                break;
            }
            case 2: {
                sequencedImageModel.set_height(n2);
                break;
            }
            case 3: {
                sequencedImageModel.set_targetId(n2);
                break;
            }
            case 4: {
                sequencedImageModel.set_value(n2);
                break;
            }
            case 5: {
                sequencedImageModel.set_valueMax(n2);
                break;
            }
            case 6: {
                sequencedImageModel.set_valueMin(n2);
                break;
            }
            case 7: {
                sequencedImageModel.set_width(n2);
                break;
            }
            case 8: {
                sequencedImageModel.set_x(n2);
                break;
            }
            case 9: {
                sequencedImageModel.set_y(n2);
                break;
            }
        }
    }

    private static int getAnimateIntSequencedImage(SequencedImageModel sequencedImageModel, int n) {
        switch (n) {
            case 0: {
                return sequencedImageModel.get_alpha();
            }
            case 1: {
                return sequencedImageModel.get_blendMode();
            }
            case 2: {
                return sequencedImageModel.get_height();
            }
            case 3: {
                return sequencedImageModel.get_targetId();
            }
            case 4: {
                return sequencedImageModel.get_value();
            }
            case 5: {
                return sequencedImageModel.get_valueMax();
            }
            case 6: {
                return sequencedImageModel.get_valueMin();
            }
            case 7: {
                return sequencedImageModel.get_width();
            }
            case 8: {
                return sequencedImageModel.get_x();
            }
            case 9: {
                return sequencedImageModel.get_y();
            }
        }
        return 0;
    }

    private static void setAnimateIntSlider(SliderModel sliderModel, int n, int n2) {
        switch (n) {
            case 0: {
                sliderModel.set_alpha(n2);
                break;
            }
            case 1: {
                sliderModel.set_fireEventTimer(n2);
                break;
            }
            case 2: {
                sliderModel.set_height(n2);
                break;
            }
            case 3: {
                sliderModel.set_imageSliderValuePointX(n2);
                break;
            }
            case 4: {
                sliderModel.set_imageSliderValuePointY(n2);
                break;
            }
            case 5: {
                sliderModel.set_orientation(n2);
                break;
            }
            case 6: {
                sliderModel.set_paddingMax(n2);
                break;
            }
            case 7: {
                sliderModel.set_paddingMin(n2);
                break;
            }
            case 8: {
                sliderModel.set_reflectionAlpha(n2);
                break;
            }
            case 9: {
                sliderModel.set_reflectionDistance(n2);
                break;
            }
            case 10: {
                sliderModel.set_state(n2);
                break;
            }
            case 11: {
                sliderModel.set_step(n2);
                break;
            }
            case 12: {
                sliderModel.set_targetId(n2);
                break;
            }
            case 13: {
                sliderModel.set_value(n2);
                break;
            }
            case 14: {
                sliderModel.set_valueMax(n2);
                break;
            }
            case 15: {
                sliderModel.set_valueMin(n2);
                break;
            }
            case 16: {
                sliderModel.set_width(n2);
                break;
            }
            case 17: {
                sliderModel.set_x(n2);
                break;
            }
            case 18: {
                sliderModel.set_y(n2);
                break;
            }
        }
    }

    private static int getAnimateIntSlider(SliderModel sliderModel, int n) {
        switch (n) {
            case 0: {
                return sliderModel.get_alpha();
            }
            case 1: {
                return sliderModel.get_fireEventTimer();
            }
            case 2: {
                return sliderModel.get_height();
            }
            case 3: {
                return sliderModel.get_imageSliderValuePointX();
            }
            case 4: {
                return sliderModel.get_imageSliderValuePointY();
            }
            case 5: {
                return sliderModel.get_orientation();
            }
            case 6: {
                return sliderModel.get_paddingMax();
            }
            case 7: {
                return sliderModel.get_paddingMin();
            }
            case 8: {
                return sliderModel.get_reflectionAlpha();
            }
            case 9: {
                return sliderModel.get_reflectionDistance();
            }
            case 10: {
                return sliderModel.get_state();
            }
            case 11: {
                return sliderModel.get_step();
            }
            case 12: {
                return sliderModel.get_targetId();
            }
            case 13: {
                return sliderModel.get_value();
            }
            case 14: {
                return sliderModel.get_valueMax();
            }
            case 15: {
                return sliderModel.get_valueMin();
            }
            case 16: {
                return sliderModel.get_width();
            }
            case 17: {
                return sliderModel.get_x();
            }
            case 18: {
                return sliderModel.get_y();
            }
        }
        return 0;
    }

    private static void setAnimateIntSpeller(SpellerModel spellerModel, int n, int n2) {
        switch (n) {
            case 0: {
                spellerModel.set_alpha(n2);
                break;
            }
            case 1: {
                spellerModel.set_alphabetIndex(n2);
                break;
            }
            case 2: {
                spellerModel.set_charEncoding(n2);
                break;
            }
            case 3: {
                spellerModel.set_charMax(n2);
                break;
            }
            case 4: {
                spellerModel.set_charMin(n2);
                break;
            }
            case 5: {
                spellerModel.set_compositeBackgroundArrowOffsetX(n2);
                break;
            }
            case 6: {
                spellerModel.set_compositeBackgroundArrowOffsetY(n2);
                break;
            }
            case 7: {
                spellerModel.set_compositeBackgroundMode(n2);
                break;
            }
            case 8: {
                spellerModel.set_flyingWindowMode(n2);
                break;
            }
            case 9: {
                spellerModel.set_height(n2);
                break;
            }
            case 10: {
                spellerModel.set_languageIndex(n2);
                break;
            }
            case 11: {
                spellerModel.set_languageIndicatorDelay(n2);
                break;
            }
            case 12: {
                spellerModel.set_lowerUpper(n2);
                break;
            }
            case 13: {
                spellerModel.set_matchCount(n2);
                break;
            }
            case 14: {
                spellerModel.set_mode(n2);
                break;
            }
            case 15: {
                spellerModel.set_reflectionAlpha(n2);
                break;
            }
            case 16: {
                spellerModel.set_reflectionDistance(n2);
                break;
            }
            case 17: {
                spellerModel.set_shiftMode(n2);
                break;
            }
            case 18: {
                spellerModel.set_subspellerOffsetX(n2);
                break;
            }
            case 19: {
                spellerModel.set_subspellerOffsetY(n2);
                break;
            }
            case 20: {
                spellerModel.set_targetId(n2);
                break;
            }
            case 21: {
                spellerModel.set_width(n2);
                break;
            }
            case 22: {
                spellerModel.set_x(n2);
                break;
            }
            case 23: {
                spellerModel.set_y(n2);
                break;
            }
        }
    }

    private static int getAnimateIntSpeller(SpellerModel spellerModel, int n) {
        switch (n) {
            case 0: {
                return spellerModel.get_alpha();
            }
            case 1: {
                return spellerModel.get_alphabetIndex();
            }
            case 2: {
                return spellerModel.get_charEncoding();
            }
            case 3: {
                return spellerModel.get_charMax();
            }
            case 4: {
                return spellerModel.get_charMin();
            }
            case 5: {
                return spellerModel.get_compositeBackgroundArrowOffsetX();
            }
            case 6: {
                return spellerModel.get_compositeBackgroundArrowOffsetY();
            }
            case 7: {
                return spellerModel.get_compositeBackgroundMode();
            }
            case 8: {
                return spellerModel.get_flyingWindowMode();
            }
            case 9: {
                return spellerModel.get_height();
            }
            case 10: {
                return spellerModel.get_languageIndex();
            }
            case 11: {
                return spellerModel.get_languageIndicatorDelay();
            }
            case 12: {
                return spellerModel.get_lowerUpper();
            }
            case 13: {
                return spellerModel.get_matchCount();
            }
            case 14: {
                return spellerModel.get_mode();
            }
            case 15: {
                return spellerModel.get_reflectionAlpha();
            }
            case 16: {
                return spellerModel.get_reflectionDistance();
            }
            case 17: {
                return spellerModel.get_shiftMode();
            }
            case 18: {
                return spellerModel.get_subspellerOffsetX();
            }
            case 19: {
                return spellerModel.get_subspellerOffsetY();
            }
            case 20: {
                return spellerModel.get_targetId();
            }
            case 21: {
                return spellerModel.get_width();
            }
            case 22: {
                return spellerModel.get_x();
            }
            case 23: {
                return spellerModel.get_y();
            }
        }
        return 0;
    }

    private static void setAnimateIntSpellerButton(SpellerButtonModel spellerButtonModel, int n, int n2) {
        switch (n) {
            case 0: {
                spellerButtonModel.set_alpha(n2);
                break;
            }
            case 1: {
                spellerButtonModel.set_buttonMode(n2);
                break;
            }
            case 2: {
                spellerButtonModel.set_height(n2);
                break;
            }
            case 3: {
                spellerButtonModel.set_reflectionAlpha(n2);
                break;
            }
            case 4: {
                spellerButtonModel.set_reflectionDistance(n2);
                break;
            }
            case 5: {
                spellerButtonModel.set_repeatTimePrimary(n2);
                break;
            }
            case 6: {
                spellerButtonModel.set_repeatTimeSecondary(n2);
                break;
            }
            case 7: {
                spellerButtonModel.set_startTimePrimary(n2);
                break;
            }
            case 8: {
                spellerButtonModel.set_startTimeSecondary(n2);
                break;
            }
            case 9: {
                spellerButtonModel.set_state(n2);
                break;
            }
            case 10: {
                spellerButtonModel.set_stateOffset(n2);
                break;
            }
            case 11: {
                spellerButtonModel.set_targetId(n2);
                break;
            }
            case 12: {
                spellerButtonModel.set_width(n2);
                break;
            }
            case 13: {
                spellerButtonModel.set_x(n2);
                break;
            }
            case 14: {
                spellerButtonModel.set_y(n2);
                break;
            }
        }
    }

    private static int getAnimateIntSpellerButton(SpellerButtonModel spellerButtonModel, int n) {
        switch (n) {
            case 0: {
                return spellerButtonModel.get_alpha();
            }
            case 1: {
                return spellerButtonModel.get_buttonMode();
            }
            case 2: {
                return spellerButtonModel.get_height();
            }
            case 3: {
                return spellerButtonModel.get_reflectionAlpha();
            }
            case 4: {
                return spellerButtonModel.get_reflectionDistance();
            }
            case 5: {
                return spellerButtonModel.get_repeatTimePrimary();
            }
            case 6: {
                return spellerButtonModel.get_repeatTimeSecondary();
            }
            case 7: {
                return spellerButtonModel.get_startTimePrimary();
            }
            case 8: {
                return spellerButtonModel.get_startTimeSecondary();
            }
            case 9: {
                return spellerButtonModel.get_state();
            }
            case 10: {
                return spellerButtonModel.get_stateOffset();
            }
            case 11: {
                return spellerButtonModel.get_targetId();
            }
            case 12: {
                return spellerButtonModel.get_width();
            }
            case 13: {
                return spellerButtonModel.get_x();
            }
            case 14: {
                return spellerButtonModel.get_y();
            }
        }
        return 0;
    }

    private static void setAnimateIntSpinLabel(SpinLabelModel spinLabelModel, int n, int n2) {
        switch (n) {
            case 0: {
                spinLabelModel.set_alignmentHorizontal(n2);
                break;
            }
            case 1: {
                spinLabelModel.set_alpha(n2);
                break;
            }
            case 2: {
                spinLabelModel.set_baselineOffset(n2);
                break;
            }
            case 3: {
                spinLabelModel.set_bevelDepth(n2);
                break;
            }
            case 4: {
                spinLabelModel.set_bevelEnabled(n2);
                break;
            }
            case 5: {
                spinLabelModel.set_characterOffset(n2);
                break;
            }
            case 6: {
                spinLabelModel.set_glowType(n2);
                break;
            }
            case 7: {
                spinLabelModel.set_height(n2);
                break;
            }
            case 8: {
                spinLabelModel.set_lineSpacing(n2);
                break;
            }
            case 9: {
                spinLabelModel.set_mode(n2);
                break;
            }
            case 10: {
                spinLabelModel.set_selectedIndex(n2);
                break;
            }
            case 11: {
                spinLabelModel.set_targetId(n2);
                break;
            }
            case 12: {
                spinLabelModel.set_visualLineCount(n2);
                break;
            }
            case 13: {
                spinLabelModel.set_width(n2);
                break;
            }
            case 14: {
                spinLabelModel.set_x(n2);
                break;
            }
            case 15: {
                spinLabelModel.set_y(n2);
                break;
            }
        }
    }

    private static int getAnimateIntSpinLabel(SpinLabelModel spinLabelModel, int n) {
        switch (n) {
            case 0: {
                return spinLabelModel.get_alignmentHorizontal();
            }
            case 1: {
                return spinLabelModel.get_alpha();
            }
            case 2: {
                return spinLabelModel.get_baselineOffset();
            }
            case 3: {
                return spinLabelModel.get_bevelDepth();
            }
            case 4: {
                return spinLabelModel.get_bevelEnabled();
            }
            case 5: {
                return spinLabelModel.get_characterOffset();
            }
            case 6: {
                return spinLabelModel.get_glowType();
            }
            case 7: {
                return spinLabelModel.get_height();
            }
            case 8: {
                return spinLabelModel.get_lineSpacing();
            }
            case 9: {
                return spinLabelModel.get_mode();
            }
            case 10: {
                return spinLabelModel.get_selectedIndex();
            }
            case 11: {
                return spinLabelModel.get_targetId();
            }
            case 12: {
                return spinLabelModel.get_visualLineCount();
            }
            case 13: {
                return spinLabelModel.get_width();
            }
            case 14: {
                return spinLabelModel.get_x();
            }
            case 15: {
                return spinLabelModel.get_y();
            }
        }
        return 0;
    }

    private static void setAnimateIntStaticImage(StaticImageModel staticImageModel, int n, int n2) {
        switch (n) {
            case 0: {
                staticImageModel.set_alpha(n2);
                break;
            }
            case 1: {
                staticImageModel.set_blendMode(n2);
                break;
            }
            case 2: {
                staticImageModel.set_glowType(n2);
                break;
            }
            case 3: {
                staticImageModel.set_height(n2);
                break;
            }
            case 4: {
                staticImageModel.set_targetId(n2);
                break;
            }
            case 5: {
                staticImageModel.set_width(n2);
                break;
            }
            case 6: {
                staticImageModel.set_x(n2);
                break;
            }
            case 7: {
                staticImageModel.set_y(n2);
                break;
            }
        }
    }

    private static int getAnimateIntStaticImage(StaticImageModel staticImageModel, int n) {
        switch (n) {
            case 0: {
                return staticImageModel.get_alpha();
            }
            case 1: {
                return staticImageModel.get_blendMode();
            }
            case 2: {
                return staticImageModel.get_glowType();
            }
            case 3: {
                return staticImageModel.get_height();
            }
            case 4: {
                return staticImageModel.get_targetId();
            }
            case 5: {
                return staticImageModel.get_width();
            }
            case 6: {
                return staticImageModel.get_x();
            }
            case 7: {
                return staticImageModel.get_y();
            }
        }
        return 0;
    }

    private static void setAnimateIntStatistics(StatisticsModel statisticsModel, int n, int n2) {
        switch (n) {
            case 0: {
                statisticsModel.set_alpha(n2);
                break;
            }
            case 1: {
                statisticsModel.set_barPadding(n2);
                break;
            }
            case 2: {
                statisticsModel.set_height(n2);
                break;
            }
            case 3: {
                statisticsModel.set_numberOfSubValues(n2);
                break;
            }
            case 4: {
                statisticsModel.set_stepSize(n2);
                break;
            }
            case 5: {
                statisticsModel.set_targetId(n2);
                break;
            }
            case 6: {
                statisticsModel.set_valueChangeType(n2);
                break;
            }
            case 7: {
                statisticsModel.set_width(n2);
                break;
            }
            case 8: {
                statisticsModel.set_x(n2);
                break;
            }
            case 9: {
                statisticsModel.set_xMax(n2);
                break;
            }
            case 10: {
                statisticsModel.set_xMin(n2);
                break;
            }
            case 11: {
                statisticsModel.set_y(n2);
                break;
            }
            case 12: {
                statisticsModel.set_yMax(n2);
                break;
            }
            case 13: {
                statisticsModel.set_yMin(n2);
                break;
            }
        }
    }

    private static int getAnimateIntStatistics(StatisticsModel statisticsModel, int n) {
        switch (n) {
            case 0: {
                return statisticsModel.get_alpha();
            }
            case 1: {
                return statisticsModel.get_barPadding();
            }
            case 2: {
                return statisticsModel.get_height();
            }
            case 3: {
                return statisticsModel.get_numberOfSubValues();
            }
            case 4: {
                return statisticsModel.get_stepSize();
            }
            case 5: {
                return statisticsModel.get_targetId();
            }
            case 6: {
                return statisticsModel.get_valueChangeType();
            }
            case 7: {
                return statisticsModel.get_width();
            }
            case 8: {
                return statisticsModel.get_x();
            }
            case 9: {
                return statisticsModel.get_xMax();
            }
            case 10: {
                return statisticsModel.get_xMin();
            }
            case 11: {
                return statisticsModel.get_y();
            }
            case 12: {
                return statisticsModel.get_yMax();
            }
            case 13: {
                return statisticsModel.get_yMin();
            }
        }
        return 0;
    }

    private static void setAnimateIntTextArea(TextAreaModel textAreaModel, int n, int n2) {
        switch (n) {
            case 0: {
                textAreaModel.set_alignmentHorizontal(n2);
                break;
            }
            case 1: {
                textAreaModel.set_alignmentVertical(n2);
                break;
            }
            case 2: {
                textAreaModel.set_alpha(n2);
                break;
            }
            case 3: {
                textAreaModel.set_baselineOffset(n2);
                break;
            }
            case 4: {
                textAreaModel.set_bevelDepth(n2);
                break;
            }
            case 5: {
                textAreaModel.set_bevelEnabled(n2);
                break;
            }
            case 6: {
                textAreaModel.set_dynamicResizeDirection(n2);
                break;
            }
            case 7: {
                textAreaModel.set_dynamicSize(n2);
                break;
            }
            case 8: {
                textAreaModel.set_glowType(n2);
                break;
            }
            case 9: {
                textAreaModel.set_height(n2);
                break;
            }
            case 10: {
                textAreaModel.set_lineBreakMode(n2);
                break;
            }
            case 11: {
                textAreaModel.set_lineSpacing(n2);
                break;
            }
            case 12: {
                textAreaModel.set_targetId(n2);
                break;
            }
            case 13: {
                textAreaModel.set_visualLineCount(n2);
                break;
            }
            case 14: {
                textAreaModel.set_width(n2);
                break;
            }
            case 15: {
                textAreaModel.set_x(n2);
                break;
            }
            case 16: {
                textAreaModel.set_y(n2);
                break;
            }
        }
    }

    private static int getAnimateIntTextArea(TextAreaModel textAreaModel, int n) {
        switch (n) {
            case 0: {
                return textAreaModel.get_alignmentHorizontal();
            }
            case 1: {
                return textAreaModel.get_alignmentVertical();
            }
            case 2: {
                return textAreaModel.get_alpha();
            }
            case 3: {
                return textAreaModel.get_baselineOffset();
            }
            case 4: {
                return textAreaModel.get_bevelDepth();
            }
            case 5: {
                return textAreaModel.get_bevelEnabled();
            }
            case 6: {
                return textAreaModel.get_dynamicResizeDirection();
            }
            case 7: {
                return textAreaModel.get_dynamicSize();
            }
            case 8: {
                return textAreaModel.get_glowType();
            }
            case 9: {
                return textAreaModel.get_height();
            }
            case 10: {
                return textAreaModel.get_lineBreakMode();
            }
            case 11: {
                return textAreaModel.get_lineSpacing();
            }
            case 12: {
                return textAreaModel.get_targetId();
            }
            case 13: {
                return textAreaModel.get_visualLineCount();
            }
            case 14: {
                return textAreaModel.get_width();
            }
            case 15: {
                return textAreaModel.get_x();
            }
            case 16: {
                return textAreaModel.get_y();
            }
        }
        return 0;
    }

    private static void setAnimateIntThresholdNotifier(ThresholdNotifierModel thresholdNotifierModel, int n, int n2) {
        switch (n) {
            case 0: {
                thresholdNotifierModel.set_alpha(n2);
                break;
            }
            case 1: {
                thresholdNotifierModel.set_height(n2);
                break;
            }
            case 2: {
                thresholdNotifierModel.set_targetId(n2);
                break;
            }
            case 3: {
                thresholdNotifierModel.set_value(n2);
                break;
            }
            case 4: {
                thresholdNotifierModel.set_valueMax(n2);
                break;
            }
            case 5: {
                thresholdNotifierModel.set_valueMin(n2);
                break;
            }
            case 6: {
                thresholdNotifierModel.set_width(n2);
                break;
            }
            case 7: {
                thresholdNotifierModel.set_x(n2);
                break;
            }
            case 8: {
                thresholdNotifierModel.set_y(n2);
                break;
            }
        }
    }

    private static int getAnimateIntThresholdNotifier(ThresholdNotifierModel thresholdNotifierModel, int n) {
        switch (n) {
            case 0: {
                return thresholdNotifierModel.get_alpha();
            }
            case 1: {
                return thresholdNotifierModel.get_height();
            }
            case 2: {
                return thresholdNotifierModel.get_targetId();
            }
            case 3: {
                return thresholdNotifierModel.get_value();
            }
            case 4: {
                return thresholdNotifierModel.get_valueMax();
            }
            case 5: {
                return thresholdNotifierModel.get_valueMin();
            }
            case 6: {
                return thresholdNotifierModel.get_width();
            }
            case 7: {
                return thresholdNotifierModel.get_x();
            }
            case 8: {
                return thresholdNotifierModel.get_y();
            }
        }
        return 0;
    }

    private static void setAnimateIntTimerWidget(TimerWidgetModel timerWidgetModel, int n, int n2) {
        switch (n) {
            case 0: {
                timerWidgetModel.set_alpha(n2);
                break;
            }
            case 1: {
                timerWidgetModel.set_durationRestart(n2);
                break;
            }
            case 2: {
                timerWidgetModel.set_durationStart(n2);
                break;
            }
            case 3: {
                timerWidgetModel.set_height(n2);
                break;
            }
            case 4: {
                timerWidgetModel.set_targetId(n2);
                break;
            }
            case 5: {
                timerWidgetModel.set_width(n2);
                break;
            }
            case 6: {
                timerWidgetModel.set_x(n2);
                break;
            }
            case 7: {
                timerWidgetModel.set_y(n2);
                break;
            }
        }
    }

    private static int getAnimateIntTimerWidget(TimerWidgetModel timerWidgetModel, int n) {
        switch (n) {
            case 0: {
                return timerWidgetModel.get_alpha();
            }
            case 1: {
                return timerWidgetModel.get_durationRestart();
            }
            case 2: {
                return timerWidgetModel.get_durationStart();
            }
            case 3: {
                return timerWidgetModel.get_height();
            }
            case 4: {
                return timerWidgetModel.get_targetId();
            }
            case 5: {
                return timerWidgetModel.get_width();
            }
            case 6: {
                return timerWidgetModel.get_x();
            }
            case 7: {
                return timerWidgetModel.get_y();
            }
        }
        return 0;
    }

    private static void setAnimateIntTouchArea(TouchAreaModel touchAreaModel, int n, int n2) {
        switch (n) {
            case 0: {
                touchAreaModel.set_alpha(n2);
                break;
            }
            case 1: {
                touchAreaModel.set_dragThreshold(n2);
                break;
            }
            case 2: {
                touchAreaModel.set_dragThresholdMode(n2);
                break;
            }
            case 3: {
                touchAreaModel.set_duration(n2);
                break;
            }
            case 4: {
                touchAreaModel.set_height(n2);
                break;
            }
            case 5: {
                touchAreaModel.set_mode(n2);
                break;
            }
            case 6: {
                touchAreaModel.set_targetId(n2);
                break;
            }
            case 7: {
                touchAreaModel.set_touchForwardingMode(n2);
                break;
            }
            case 8: {
                touchAreaModel.set_touchTrajectoriesLineWidth(n2);
                break;
            }
            case 9: {
                touchAreaModel.set_valueMaxX(n2);
                break;
            }
            case 10: {
                touchAreaModel.set_valueMaxY(n2);
                break;
            }
            case 11: {
                touchAreaModel.set_valueMinX(n2);
                break;
            }
            case 12: {
                touchAreaModel.set_valueMinY(n2);
                break;
            }
            case 13: {
                touchAreaModel.set_width(n2);
                break;
            }
            case 14: {
                touchAreaModel.set_x(n2);
                break;
            }
            case 15: {
                touchAreaModel.set_y(n2);
                break;
            }
        }
    }

    private static int getAnimateIntTouchArea(TouchAreaModel touchAreaModel, int n) {
        switch (n) {
            case 0: {
                return touchAreaModel.get_alpha();
            }
            case 1: {
                return touchAreaModel.get_dragThreshold();
            }
            case 2: {
                return touchAreaModel.get_dragThresholdMode();
            }
            case 3: {
                return touchAreaModel.get_duration();
            }
            case 4: {
                return touchAreaModel.get_height();
            }
            case 5: {
                return touchAreaModel.get_mode();
            }
            case 6: {
                return touchAreaModel.get_targetId();
            }
            case 7: {
                return touchAreaModel.get_touchForwardingMode();
            }
            case 8: {
                return touchAreaModel.get_touchTrajectoriesLineWidth();
            }
            case 9: {
                return touchAreaModel.get_valueMaxX();
            }
            case 10: {
                return touchAreaModel.get_valueMaxY();
            }
            case 11: {
                return touchAreaModel.get_valueMinX();
            }
            case 12: {
                return touchAreaModel.get_valueMinY();
            }
            case 13: {
                return touchAreaModel.get_width();
            }
            case 14: {
                return touchAreaModel.get_x();
            }
            case 15: {
                return touchAreaModel.get_y();
            }
        }
        return 0;
    }

    private static void setAnimateIntTransformContainer(TransformContainerModel transformContainerModel, int n, int n2) {
        switch (n) {
            case 0: {
                transformContainerModel.set_alpha(n2);
                break;
            }
            case 1: {
                transformContainerModel.set_decoration(n2);
                break;
            }
            case 2: {
                transformContainerModel.set_depth(n2);
                break;
            }
            case 3: {
                transformContainerModel.set_height(n2);
                break;
            }
            case 4: {
                transformContainerModel.set_projectionType(n2);
                break;
            }
            case 5: {
                transformContainerModel.set_reflectionAlpha(n2);
                break;
            }
            case 6: {
                transformContainerModel.set_reflectionDistance(n2);
                break;
            }
            case 7: {
                transformContainerModel.set_targetId(n2);
                break;
            }
            case 8: {
                transformContainerModel.set_width(n2);
                break;
            }
            case 9: {
                transformContainerModel.set_x(n2);
                break;
            }
            case 10: {
                transformContainerModel.set_y(n2);
                break;
            }
            case 11: {
                transformContainerModel.set_z(n2);
                break;
            }
        }
    }

    private static int getAnimateIntTransformContainer(TransformContainerModel transformContainerModel, int n) {
        switch (n) {
            case 0: {
                return transformContainerModel.get_alpha();
            }
            case 1: {
                return transformContainerModel.get_decoration();
            }
            case 2: {
                return transformContainerModel.get_depth();
            }
            case 3: {
                return transformContainerModel.get_height();
            }
            case 4: {
                return transformContainerModel.get_projectionType();
            }
            case 5: {
                return transformContainerModel.get_reflectionAlpha();
            }
            case 6: {
                return transformContainerModel.get_reflectionDistance();
            }
            case 7: {
                return transformContainerModel.get_targetId();
            }
            case 8: {
                return transformContainerModel.get_width();
            }
            case 9: {
                return transformContainerModel.get_x();
            }
            case 10: {
                return transformContainerModel.get_y();
            }
            case 11: {
                return transformContainerModel.get_z();
            }
        }
        return 0;
    }

    private static void setAnimateIntView(ViewModel viewModel, int n, int n2) {
        switch (n) {
            case 0: {
                viewModel.set_alpha(n2);
                break;
            }
            case 1: {
                viewModel.set_decoration(n2);
                break;
            }
            case 2: {
                viewModel.set_depth(n2);
                break;
            }
            case 3: {
                viewModel.set_height(n2);
                break;
            }
            case 4: {
                viewModel.set_projectionType(n2);
                break;
            }
            case 5: {
                viewModel.set_reflectionAlpha(n2);
                break;
            }
            case 6: {
                viewModel.set_reflectionDistance(n2);
                break;
            }
            case 7: {
                viewModel.set_targetId(n2);
                break;
            }
            case 8: {
                viewModel.set_touchForwardingMode(n2);
                break;
            }
            case 9: {
                viewModel.set_viewTypeSelection(n2);
                break;
            }
            case 10: {
                viewModel.set_width(n2);
                break;
            }
            case 11: {
                viewModel.set_x(n2);
                break;
            }
            case 12: {
                viewModel.set_y(n2);
                break;
            }
            case 13: {
                viewModel.set_z(n2);
                break;
            }
        }
    }

    private static int getAnimateIntView(ViewModel viewModel, int n) {
        switch (n) {
            case 0: {
                return viewModel.get_alpha();
            }
            case 1: {
                return viewModel.get_decoration();
            }
            case 2: {
                return viewModel.get_depth();
            }
            case 3: {
                return viewModel.get_height();
            }
            case 4: {
                return viewModel.get_projectionType();
            }
            case 5: {
                return viewModel.get_reflectionAlpha();
            }
            case 6: {
                return viewModel.get_reflectionDistance();
            }
            case 7: {
                return viewModel.get_targetId();
            }
            case 8: {
                return viewModel.get_touchForwardingMode();
            }
            case 9: {
                return viewModel.get_viewTypeSelection();
            }
            case 10: {
                return viewModel.get_width();
            }
            case 11: {
                return viewModel.get_x();
            }
            case 12: {
                return viewModel.get_y();
            }
            case 13: {
                return viewModel.get_z();
            }
        }
        return 0;
    }

    private static void setAnimateIntWidgetList(WidgetListModel widgetListModel, int n, int n2) {
        switch (n) {
            case 0: {
                widgetListModel.set_alignment(n2);
                break;
            }
            case 1: {
                widgetListModel.set_alignmentPage(n2);
                break;
            }
            case 2: {
                widgetListModel.set_alpha(n2);
                break;
            }
            case 3: {
                widgetListModel.set_alphaDragItem(n2);
                break;
            }
            case 4: {
                widgetListModel.set_alphaDragItemSource(n2);
                break;
            }
            case 5: {
                widgetListModel.set_browsingDirection(n2);
                break;
            }
            case 6: {
                widgetListModel.set_firstItemIndex(n2);
                break;
            }
            case 7: {
                widgetListModel.set_firstItemIndexPosition(n2);
                break;
            }
            case 8: {
                widgetListModel.set_followItemPosition(n2);
                break;
            }
            case 9: {
                widgetListModel.set_followModeDelay(n2);
                break;
            }
            case 10: {
                widgetListModel.set_forwardPressDelay(n2);
                break;
            }
            case 11: {
                widgetListModel.set_height(n2);
                break;
            }
            case 12: {
                widgetListModel.set_itemCount(n2);
                break;
            }
            case 13: {
                widgetListModel.set_itemExtent(n2);
                break;
            }
            case 14: {
                widgetListModel.set_letterScrollingIndicatorMode(n2);
                break;
            }
            case 15: {
                widgetListModel.set_listViewObserverDelay(n2);
                break;
            }
            case 16: {
                widgetListModel.set_orientation(n2);
                break;
            }
            case 17: {
                widgetListModel.set_reflectionAlpha(n2);
                break;
            }
            case 18: {
                widgetListModel.set_reflectionDistance(n2);
                break;
            }
            case 19: {
                widgetListModel.set_scrollTypeRotary(n2);
                break;
            }
            case 20: {
                widgetListModel.set_scrollTypeTouch(n2);
                break;
            }
            case 21: {
                widgetListModel.set_selectedIndex(n2);
                break;
            }
            case 22: {
                widgetListModel.set_separatorMode(n2);
                break;
            }
            case 23: {
                widgetListModel.set_separatorOffset(n2);
                break;
            }
            case 24: {
                widgetListModel.set_spacingHorizontal(n2);
                break;
            }
            case 25: {
                widgetListModel.set_spacingPage(n2);
                break;
            }
            case 26: {
                widgetListModel.set_spacingVertical(n2);
                break;
            }
            case 27: {
                widgetListModel.set_targetId(n2);
                break;
            }
            case 28: {
                widgetListModel.set_width(n2);
                break;
            }
            case 29: {
                widgetListModel.set_x(n2);
                break;
            }
            case 30: {
                widgetListModel.set_y(n2);
                break;
            }
        }
    }

    private static int getAnimateIntWidgetList(WidgetListModel widgetListModel, int n) {
        switch (n) {
            case 0: {
                return widgetListModel.get_alignment();
            }
            case 1: {
                return widgetListModel.get_alignmentPage();
            }
            case 2: {
                return widgetListModel.get_alpha();
            }
            case 3: {
                return widgetListModel.get_alphaDragItem();
            }
            case 4: {
                return widgetListModel.get_alphaDragItemSource();
            }
            case 5: {
                return widgetListModel.get_browsingDirection();
            }
            case 6: {
                return widgetListModel.get_firstItemIndex();
            }
            case 7: {
                return widgetListModel.get_firstItemIndexPosition();
            }
            case 8: {
                return widgetListModel.get_followItemPosition();
            }
            case 9: {
                return widgetListModel.get_followModeDelay();
            }
            case 10: {
                return widgetListModel.get_forwardPressDelay();
            }
            case 11: {
                return widgetListModel.get_height();
            }
            case 12: {
                return widgetListModel.get_itemCount();
            }
            case 13: {
                return widgetListModel.get_itemExtent();
            }
            case 14: {
                return widgetListModel.get_letterScrollingIndicatorMode();
            }
            case 15: {
                return widgetListModel.get_listViewObserverDelay();
            }
            case 16: {
                return widgetListModel.get_orientation();
            }
            case 17: {
                return widgetListModel.get_reflectionAlpha();
            }
            case 18: {
                return widgetListModel.get_reflectionDistance();
            }
            case 19: {
                return widgetListModel.get_scrollTypeRotary();
            }
            case 20: {
                return widgetListModel.get_scrollTypeTouch();
            }
            case 21: {
                return widgetListModel.get_selectedIndex();
            }
            case 22: {
                return widgetListModel.get_separatorMode();
            }
            case 23: {
                return widgetListModel.get_separatorOffset();
            }
            case 24: {
                return widgetListModel.get_spacingHorizontal();
            }
            case 25: {
                return widgetListModel.get_spacingPage();
            }
            case 26: {
                return widgetListModel.get_spacingVertical();
            }
            case 27: {
                return widgetListModel.get_targetId();
            }
            case 28: {
                return widgetListModel.get_width();
            }
            case 29: {
                return widgetListModel.get_x();
            }
            case 30: {
                return widgetListModel.get_y();
            }
        }
        return 0;
    }
}

