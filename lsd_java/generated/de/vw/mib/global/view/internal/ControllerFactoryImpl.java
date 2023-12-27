/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.global.view.internal;

import de.vw.mib.view.internal.treebuilder.ControllerFactory;
import de.vw.mib.widgets.controller.DefaultAsiaSpellerController;
import de.vw.mib.widgets.controller.DefaultCanvasController;
import de.vw.mib.widgets.controller.DefaultClimateController;
import de.vw.mib.widgets.controller.DefaultClockController;
import de.vw.mib.widgets.controller.DefaultColorChooserController;
import de.vw.mib.widgets.controller.DefaultCompassController;
import de.vw.mib.widgets.controller.DefaultControlBarController;
import de.vw.mib.widgets.controller.DefaultDropDownButtonController;
import de.vw.mib.widgets.controller.DefaultEnergyFlowController;
import de.vw.mib.widgets.controller.DefaultFlowListController;
import de.vw.mib.widgets.controller.DefaultGEMAdapterController;
import de.vw.mib.widgets.controller.DefaultGenericCarAdjusterController;
import de.vw.mib.widgets.controller.DefaultGuidanceController;
import de.vw.mib.widgets.controller.DefaultInactiveAreaController;
import de.vw.mib.widgets.controller.DefaultInputFieldController;
import de.vw.mib.widgets.controller.DefaultInstrumentsController;
import de.vw.mib.widgets.controller.DefaultIrisController;
import de.vw.mib.widgets.controller.DefaultListItemController;
import de.vw.mib.widgets.controller.DefaultPictureViewerController;
import de.vw.mib.widgets.controller.DefaultPopupViewController;
import de.vw.mib.widgets.controller.DefaultPreviewLineController;
import de.vw.mib.widgets.controller.DefaultPureAirController;
import de.vw.mib.widgets.controller.DefaultPushButtonController;
import de.vw.mib.widgets.controller.DefaultPushUpController;
import de.vw.mib.widgets.controller.DefaultReferenceWidgetController;
import de.vw.mib.widgets.controller.DefaultRunnerWidgetController;
import de.vw.mib.widgets.controller.DefaultScreenAreaController;
import de.vw.mib.widgets.controller.DefaultScrollableTextController;
import de.vw.mib.widgets.controller.DefaultScrollbarController;
import de.vw.mib.widgets.controller.DefaultSliderController;
import de.vw.mib.widgets.controller.DefaultSpellerController;
import de.vw.mib.widgets.controller.DefaultStatisticsController;
import de.vw.mib.widgets.controller.DefaultThresholdNotifierController;
import de.vw.mib.widgets.controller.DefaultTimerWidgetController;
import de.vw.mib.widgets.controller.DefaultTouchAreaController;
import de.vw.mib.widgets.controller.DefaultViewController;
import de.vw.mib.widgets.controller.DefaultWidgetListController;
import de.vw.mib.widgets.controller.WidgetController;

public final class ControllerFactoryImpl
implements ControllerFactory {
    @Override
    public WidgetController getControllerInstance(int n) {
        switch (n) {
            case 0: {
                return null;
            }
            case 1: {
                return new DefaultAsiaSpellerController();
            }
            case 2: {
                return new DefaultCanvasController();
            }
            case 3: {
                return new DefaultClimateController();
            }
            case 4: {
                return new DefaultClockController();
            }
            case 5: {
                return new DefaultColorChooserController();
            }
            case 6: {
                return new DefaultCompassController();
            }
            case 7: {
                return new DefaultControlBarController();
            }
            case 8: {
                return new DefaultDropDownButtonController();
            }
            case 9: {
                return new DefaultEnergyFlowController();
            }
            case 10: {
                return new DefaultFlowListController();
            }
            case 11: {
                return new DefaultGEMAdapterController();
            }
            case 12: {
                return new DefaultGenericCarAdjusterController();
            }
            case 13: {
                return new DefaultGuidanceController();
            }
            case 14: {
                return new DefaultInactiveAreaController();
            }
            case 15: {
                return new DefaultInputFieldController();
            }
            case 16: {
                return new DefaultInstrumentsController();
            }
            case 17: {
                return new DefaultIrisController();
            }
            case 18: {
                return new DefaultListItemController();
            }
            case 19: {
                return new DefaultPictureViewerController();
            }
            case 20: {
                return new DefaultPopupViewController();
            }
            case 21: {
                return new DefaultPreviewLineController();
            }
            case 22: {
                return new DefaultPureAirController();
            }
            case 23: {
                return new DefaultPushButtonController();
            }
            case 24: {
                return new DefaultPushUpController();
            }
            case 25: {
                return new DefaultRunnerWidgetController();
            }
            case 26: {
                return new DefaultScreenAreaController();
            }
            case 27: {
                return new DefaultScrollableTextController();
            }
            case 28: {
                return new DefaultScrollbarController();
            }
            case 29: {
                return new DefaultSliderController();
            }
            case 30: {
                return new DefaultSpellerController();
            }
            case 31: {
                return new DefaultStatisticsController();
            }
            case 32: {
                return new DefaultThresholdNotifierController();
            }
            case 33: {
                return new DefaultTimerWidgetController();
            }
            case 34: {
                return new DefaultTouchAreaController();
            }
            case 35: {
                return new DefaultViewController();
            }
            case 36: {
                return new DefaultWidgetListController();
            }
            case 37: {
                return new DefaultPushButtonController();
            }
            case 38: {
                return new DefaultReferenceWidgetController();
            }
        }
        throw new AssertionError((Object)new StringBuffer().append("Controller type out of range [0..38]: ").append(n).toString());
    }

    @Override
    public void releaseControllerInstance(int n, WidgetController widgetController) {
    }
}

