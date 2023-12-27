/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.global.view.internal;

import de.vw.mib.view.internal.treebuilder.UIFactory;
import de.vw.mib.widgets.ui.AsiaSpellerUI;
import de.vw.mib.widgets.ui.ButtonUI;
import de.vw.mib.widgets.ui.CanvasUI;
import de.vw.mib.widgets.ui.CarImageUI;
import de.vw.mib.widgets.ui.CarStatusUI;
import de.vw.mib.widgets.ui.Climate2UI;
import de.vw.mib.widgets.ui.ClimateUI;
import de.vw.mib.widgets.ui.ClockUI;
import de.vw.mib.widgets.ui.ColorChooserUI;
import de.vw.mib.widgets.ui.CommonImageUI;
import de.vw.mib.widgets.ui.CompassUI;
import de.vw.mib.widgets.ui.ContainerUI;
import de.vw.mib.widgets.ui.ControlBarUI;
import de.vw.mib.widgets.ui.CustomImageLaneGuidanceUI;
import de.vw.mib.widgets.ui.DropDownButtonUI;
import de.vw.mib.widgets.ui.DropDownUI;
import de.vw.mib.widgets.ui.DynamicImageUI;
import de.vw.mib.widgets.ui.ETC2GuidanceUI;
import de.vw.mib.widgets.ui.ETCGuidanceUI;
import de.vw.mib.widgets.ui.EnergyFlowUI;
import de.vw.mib.widgets.ui.FlowListUI;
import de.vw.mib.widgets.ui.GEMAdapterUI;
import de.vw.mib.widgets.ui.GenericCarAdjusterUI;
import de.vw.mib.widgets.ui.GuidanceUI;
import de.vw.mib.widgets.ui.InactiveAreaUI;
import de.vw.mib.widgets.ui.InputFieldUI;
import de.vw.mib.widgets.ui.InstrumentsGMeterUI;
import de.vw.mib.widgets.ui.InstrumentsPointerUI;
import de.vw.mib.widgets.ui.InstrumentsTiltIndicatorUI;
import de.vw.mib.widgets.ui.IrisUI;
import de.vw.mib.widgets.ui.LabeledIconUI;
import de.vw.mib.widgets.ui.LaneGuidanceUI;
import de.vw.mib.widgets.ui.ListItemUI;
import de.vw.mib.widgets.ui.MeshWidgetUI;
import de.vw.mib.widgets.ui.MotorWayInfoListUI;
import de.vw.mib.widgets.ui.OPSUI;
import de.vw.mib.widgets.ui.ParticleSystemUI;
import de.vw.mib.widgets.ui.PhonePlateListUI;
import de.vw.mib.widgets.ui.PictureViewerUI;
import de.vw.mib.widgets.ui.PopupViewUI;
import de.vw.mib.widgets.ui.PreviewLineUI;
import de.vw.mib.widgets.ui.PureAirUI;
import de.vw.mib.widgets.ui.PushUpUI;
import de.vw.mib.widgets.ui.RadioListScalingUI;
import de.vw.mib.widgets.ui.RadioListUI;
import de.vw.mib.widgets.ui.ReferenceWidgetUI;
import de.vw.mib.widgets.ui.ScreenAreaUI;
import de.vw.mib.widgets.ui.ScreenUI;
import de.vw.mib.widgets.ui.ScrollableTextUI;
import de.vw.mib.widgets.ui.ScrollbarUI;
import de.vw.mib.widgets.ui.SequencedImageUI;
import de.vw.mib.widgets.ui.SliderCurveUI;
import de.vw.mib.widgets.ui.SliderUI;
import de.vw.mib.widgets.ui.SpellerButtonUI;
import de.vw.mib.widgets.ui.SpellerUI;
import de.vw.mib.widgets.ui.SpinLabelPickerUI;
import de.vw.mib.widgets.ui.SpinLabelUI;
import de.vw.mib.widgets.ui.StaticImageUI;
import de.vw.mib.widgets.ui.StatisticsAreaUI;
import de.vw.mib.widgets.ui.StatisticsBarUI;
import de.vw.mib.widgets.ui.StatisticsCurveUI;
import de.vw.mib.widgets.ui.TextAreaUI;
import de.vw.mib.widgets.ui.TouchAreaDiagUI;
import de.vw.mib.widgets.ui.TouchAreaUI;
import de.vw.mib.widgets.ui.TransformContainerUI;
import de.vw.mib.widgets.ui.ViewUI;
import de.vw.mib.widgets.ui.WidgetListUI;
import de.vw.mib.widgets.ui.WidgetUI;

public final class UIFactoryImpl
implements UIFactory {
    @Override
    public WidgetUI getUIInstance(int n) {
        switch (n) {
            case 0: {
                return null;
            }
            case 1: {
                return new AsiaSpellerUI();
            }
            case 2: {
                return new ButtonUI();
            }
            case 3: {
                return new CanvasUI();
            }
            case 4: {
                return new CarImageUI();
            }
            case 5: {
                return new CarStatusUI();
            }
            case 6: {
                return new Climate2UI();
            }
            case 7: {
                return new ClimateUI();
            }
            case 8: {
                return new ClockUI();
            }
            case 9: {
                return new ColorChooserUI();
            }
            case 10: {
                return new CommonImageUI();
            }
            case 11: {
                return new CompassUI();
            }
            case 12: {
                return new ContainerUI();
            }
            case 13: {
                return new ControlBarUI();
            }
            case 14: {
                return new CustomImageLaneGuidanceUI();
            }
            case 15: {
                return new DropDownButtonUI();
            }
            case 16: {
                return new DropDownUI();
            }
            case 17: {
                return new DynamicImageUI();
            }
            case 18: {
                return new ETC2GuidanceUI();
            }
            case 19: {
                return new ETCGuidanceUI();
            }
            case 20: {
                return new EnergyFlowUI();
            }
            case 21: {
                return new FlowListUI();
            }
            case 22: {
                return new GEMAdapterUI();
            }
            case 23: {
                return new GenericCarAdjusterUI();
            }
            case 24: {
                return new GuidanceUI();
            }
            case 25: {
                return new InactiveAreaUI();
            }
            case 26: {
                return new InputFieldUI();
            }
            case 27: {
                return new InstrumentsGMeterUI();
            }
            case 28: {
                return new InstrumentsPointerUI();
            }
            case 29: {
                return new InstrumentsTiltIndicatorUI();
            }
            case 30: {
                return new IrisUI();
            }
            case 31: {
                return new LabeledIconUI();
            }
            case 32: {
                return new LaneGuidanceUI();
            }
            case 33: {
                return new ListItemUI();
            }
            case 34: {
                return new MeshWidgetUI();
            }
            case 35: {
                return new MotorWayInfoListUI();
            }
            case 36: {
                return new OPSUI();
            }
            case 37: {
                return new ParticleSystemUI();
            }
            case 38: {
                return new PhonePlateListUI();
            }
            case 39: {
                return new PictureViewerUI();
            }
            case 40: {
                return new PopupViewUI();
            }
            case 41: {
                return new PreviewLineUI();
            }
            case 42: {
                return new PureAirUI();
            }
            case 43: {
                return new PushUpUI();
            }
            case 44: {
                return new RadioListScalingUI();
            }
            case 45: {
                return new RadioListUI();
            }
            case 46: {
                return new ReferenceWidgetUI();
            }
            case 47: {
                return new ScreenAreaUI();
            }
            case 48: {
                return new ScreenUI();
            }
            case 49: {
                return new ScrollableTextUI();
            }
            case 50: {
                return new ScrollbarUI();
            }
            case 51: {
                return new SequencedImageUI();
            }
            case 52: {
                return new SliderCurveUI();
            }
            case 53: {
                return new SliderUI();
            }
            case 54: {
                return new SpellerButtonUI();
            }
            case 55: {
                return new SpellerUI();
            }
            case 56: {
                return new SpinLabelPickerUI();
            }
            case 57: {
                return new SpinLabelUI();
            }
            case 58: {
                return new StaticImageUI();
            }
            case 59: {
                return new StatisticsAreaUI();
            }
            case 60: {
                return new StatisticsBarUI();
            }
            case 61: {
                return new StatisticsCurveUI();
            }
            case 62: {
                return new TextAreaUI();
            }
            case 63: {
                return new TouchAreaDiagUI();
            }
            case 64: {
                return new TouchAreaUI();
            }
            case 65: {
                return new TransformContainerUI();
            }
            case 66: {
                return new ViewUI();
            }
            case 67: {
                return new WidgetListUI();
            }
        }
        throw new AssertionError((Object)new StringBuffer().append("UI type out of range [0..67]: ").append(n).toString());
    }

    @Override
    public void releaseUIInstance(int n, WidgetUI widgetUI) {
    }
}

