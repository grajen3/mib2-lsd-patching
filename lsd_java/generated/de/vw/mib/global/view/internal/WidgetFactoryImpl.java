/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.global.view.internal;

import de.vw.mib.view.internal.treebuilder.WidgetFactory;
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
import de.vw.mib.widgets.models.WidgetModel;

public final class WidgetFactoryImpl
implements WidgetFactory {
    @Override
    public WidgetModel getWidgetInstance(int n) {
        switch (n) {
            case 1: {
                return new AsiaSpeller();
            }
            case 2: {
                return new Button();
            }
            case 3: {
                return new Canvas();
            }
            case 4: {
                return new CarImage();
            }
            case 5: {
                return new CarStatus();
            }
            case 6: {
                return new Climate();
            }
            case 7: {
                return new Clock();
            }
            case 8: {
                return new ColorChooser();
            }
            case 9: {
                return new CommonImage();
            }
            case 10: {
                return new Compass();
            }
            case 11: {
                return new Container();
            }
            case 12: {
                return new ControlBar();
            }
            case 13: {
                return new DropDown();
            }
            case 14: {
                return new DropDownButton();
            }
            case 15: {
                return new DynamicImage();
            }
            case 16: {
                return new EnergyFlow();
            }
            case 17: {
                return new FlowList();
            }
            case 18: {
                return new GEMAdapter();
            }
            case 19: {
                return new GenericCarAdjuster();
            }
            case 20: {
                return new Guidance();
            }
            case 21: {
                return new InactiveArea();
            }
            case 22: {
                return new InputField();
            }
            case 23: {
                return new Instruments();
            }
            case 24: {
                return new Iris();
            }
            case 25: {
                return new LabeledIcon();
            }
            case 26: {
                return new LaneGuidance();
            }
            case 27: {
                return new ListItem();
            }
            case 28: {
                return new MeshWidget();
            }
            case 29: {
                return new OPS();
            }
            case 30: {
                return new ParticleSystem();
            }
            case 31: {
                return new PictureViewer();
            }
            case 32: {
                return new PopupView();
            }
            case 33: {
                return new PreviewLine();
            }
            case 34: {
                return new PureAir();
            }
            case 35: {
                return new PushUp();
            }
            case 36: {
                return new ReferenceWidget();
            }
            case 37: {
                return new RunnerWidget();
            }
            case 38: {
                return new Screen();
            }
            case 39: {
                return new ScreenArea();
            }
            case 40: {
                return new ScrollableText();
            }
            case 41: {
                return new Scrollbar();
            }
            case 42: {
                return new SequencedImage();
            }
            case 43: {
                return new Slider();
            }
            case 44: {
                return new Speller();
            }
            case 45: {
                return new SpellerButton();
            }
            case 46: {
                return new SpinLabel();
            }
            case 47: {
                return new StaticImage();
            }
            case 48: {
                return new Statistics();
            }
            case 49: {
                return new TextArea();
            }
            case 50: {
                return new ThresholdNotifier();
            }
            case 51: {
                return new TimerWidget();
            }
            case 52: {
                return new TouchArea();
            }
            case 53: {
                return new TransformContainer();
            }
            case 54: {
                return new View();
            }
            case 55: {
                return new WidgetList();
            }
        }
        throw new AssertionError((Object)new StringBuffer().append("Widget type out of range [1..55]: ").append(n).toString());
    }

    @Override
    public void releaseWidgetInstance(int n, WidgetModel widgetModel) {
    }
}

