/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.features;

import de.vw.mib.asl.api.speechengine.features.FeatureFactory;
import de.vw.mib.asl.api.speechengine.features.FeatureIds;
import de.vw.mib.asl.api.speechengine.features.GenericTargetFeature;
import de.vw.mib.asl.api.speechengine.features.complex.ComplexCommandFeature;
import de.vw.mib.asl.api.speechengine.features.complex.ComplexHelpPromptsFeature;
import de.vw.mib.asl.api.speechengine.features.complex.ComplexInitialPromptsFeature;
import de.vw.mib.asl.api.speechengine.features.complex.ComplexTeleprompterDataFeature;
import de.vw.mib.asl.api.speechengine.features.model.Command;
import de.vw.mib.asl.api.speechengine.features.model.DynamicString;
import de.vw.mib.asl.api.speechengine.features.model.Event;
import de.vw.mib.asl.api.speechengine.features.model.OrderedPrompts;
import de.vw.mib.asl.api.speechengine.features.model.Prompt;
import de.vw.mib.asl.api.speechengine.features.model.PromptReference;
import de.vw.mib.asl.internal.speechengine.features.client.state.CommandFeatureImpl;
import de.vw.mib.asl.internal.speechengine.features.client.state.HelpPromptsFeatureImpl;
import de.vw.mib.asl.internal.speechengine.features.client.state.InitialPromptsFeatureImpl;
import de.vw.mib.asl.internal.speechengine.features.client.state.TeleprompterDataStateFeatureImpl;
import de.vw.mib.asl.internal.speechengine.features.model.CommandImpl;
import de.vw.mib.asl.internal.speechengine.features.model.DynamicStringImpl;
import de.vw.mib.asl.internal.speechengine.features.model.EventImpl;
import de.vw.mib.asl.internal.speechengine.features.model.OrderedPromptsImpl;
import de.vw.mib.asl.internal.speechengine.features.model.PromptImpl;
import de.vw.mib.asl.internal.speechengine.features.model.PromptReferenceImpl;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;

public class FeatureFactoryImpl
implements FeatureFactory,
FeatureIds {
    public static final String LOGGING_PREFIX;
    private final AbstractClassifiedLogger logger;
    private final Object[] loggerParameter;
    private IntObjectMap featureMap;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechengine$features$master$AbortFeatureImpl;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechengine$features$master$BackFeatureImpl;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechengine$features$client$state$BackstackFeatureImpl;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechengine$features$client$context$ContextEventsFeatureImpl;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechengine$features$client$state$behavior$DialogStepBehaviorFeatureImpl;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechengine$features$master$ErrorsFeatureImpl;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechengine$features$master$HelpFeatureImpl;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechengine$features$client$context$IdleStatemachineFeatureImpl;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechengine$features$master$MainMenuFeatureImpl;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechengine$features$master$PardonFeatureImpl;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechengine$features$master$PauseFeatureImpl;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechengine$features$master$PleaseWaitFeatureImpl;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechengine$features$master$RepeatFeatureImpl;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechengine$features$client$state$behavior$SpeakOnlyFeatureImpl;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechengine$features$master$TimeoutFeatureImpl;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechengine$features$master$ListHelpPromptFeatureImpl;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechengine$features$client$state$ListFeatureImpl;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechengine$features$client$state$CommandOverloadFeatureImpl;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechengine$features$master$TeleprompterOnOffFeatureImpl;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechengine$features$client$context$TeleprompterOnOffContextFeatureImpl;

    public FeatureFactoryImpl(AbstractClassifiedLogger abstractClassifiedLogger) {
        this.logger = abstractClassifiedLogger;
        this.loggerParameter = new Object[]{this.logger};
        this.featureMap = new IntObjectOptHashMap();
        this.featureMap.put(101, class$de$vw$mib$asl$internal$speechengine$features$master$AbortFeatureImpl == null ? (class$de$vw$mib$asl$internal$speechengine$features$master$AbortFeatureImpl = FeatureFactoryImpl.class$("de.vw.mib.asl.internal.speechengine.features.master.AbortFeatureImpl")) : class$de$vw$mib$asl$internal$speechengine$features$master$AbortFeatureImpl);
        this.featureMap.put(102, class$de$vw$mib$asl$internal$speechengine$features$master$BackFeatureImpl == null ? (class$de$vw$mib$asl$internal$speechengine$features$master$BackFeatureImpl = FeatureFactoryImpl.class$("de.vw.mib.asl.internal.speechengine.features.master.BackFeatureImpl")) : class$de$vw$mib$asl$internal$speechengine$features$master$BackFeatureImpl);
        this.featureMap.put(301, class$de$vw$mib$asl$internal$speechengine$features$client$state$BackstackFeatureImpl == null ? (class$de$vw$mib$asl$internal$speechengine$features$client$state$BackstackFeatureImpl = FeatureFactoryImpl.class$("de.vw.mib.asl.internal.speechengine.features.client.state.BackstackFeatureImpl")) : class$de$vw$mib$asl$internal$speechengine$features$client$state$BackstackFeatureImpl);
        this.featureMap.put(201, class$de$vw$mib$asl$internal$speechengine$features$client$context$ContextEventsFeatureImpl == null ? (class$de$vw$mib$asl$internal$speechengine$features$client$context$ContextEventsFeatureImpl = FeatureFactoryImpl.class$("de.vw.mib.asl.internal.speechengine.features.client.context.ContextEventsFeatureImpl")) : class$de$vw$mib$asl$internal$speechengine$features$client$context$ContextEventsFeatureImpl);
        this.featureMap.put(305, class$de$vw$mib$asl$internal$speechengine$features$client$state$behavior$DialogStepBehaviorFeatureImpl == null ? (class$de$vw$mib$asl$internal$speechengine$features$client$state$behavior$DialogStepBehaviorFeatureImpl = FeatureFactoryImpl.class$("de.vw.mib.asl.internal.speechengine.features.client.state.behavior.DialogStepBehaviorFeatureImpl")) : class$de$vw$mib$asl$internal$speechengine$features$client$state$behavior$DialogStepBehaviorFeatureImpl);
        this.featureMap.put(103, class$de$vw$mib$asl$internal$speechengine$features$master$ErrorsFeatureImpl == null ? (class$de$vw$mib$asl$internal$speechengine$features$master$ErrorsFeatureImpl = FeatureFactoryImpl.class$("de.vw.mib.asl.internal.speechengine.features.master.ErrorsFeatureImpl")) : class$de$vw$mib$asl$internal$speechengine$features$master$ErrorsFeatureImpl);
        this.featureMap.put(104, class$de$vw$mib$asl$internal$speechengine$features$master$HelpFeatureImpl == null ? (class$de$vw$mib$asl$internal$speechengine$features$master$HelpFeatureImpl = FeatureFactoryImpl.class$("de.vw.mib.asl.internal.speechengine.features.master.HelpFeatureImpl")) : class$de$vw$mib$asl$internal$speechengine$features$master$HelpFeatureImpl);
        this.featureMap.put(202, class$de$vw$mib$asl$internal$speechengine$features$client$context$IdleStatemachineFeatureImpl == null ? (class$de$vw$mib$asl$internal$speechengine$features$client$context$IdleStatemachineFeatureImpl = FeatureFactoryImpl.class$("de.vw.mib.asl.internal.speechengine.features.client.context.IdleStatemachineFeatureImpl")) : class$de$vw$mib$asl$internal$speechengine$features$client$context$IdleStatemachineFeatureImpl);
        this.featureMap.put(105, class$de$vw$mib$asl$internal$speechengine$features$master$MainMenuFeatureImpl == null ? (class$de$vw$mib$asl$internal$speechengine$features$master$MainMenuFeatureImpl = FeatureFactoryImpl.class$("de.vw.mib.asl.internal.speechengine.features.master.MainMenuFeatureImpl")) : class$de$vw$mib$asl$internal$speechengine$features$master$MainMenuFeatureImpl);
        this.featureMap.put(106, class$de$vw$mib$asl$internal$speechengine$features$master$PardonFeatureImpl == null ? (class$de$vw$mib$asl$internal$speechengine$features$master$PardonFeatureImpl = FeatureFactoryImpl.class$("de.vw.mib.asl.internal.speechengine.features.master.PardonFeatureImpl")) : class$de$vw$mib$asl$internal$speechengine$features$master$PardonFeatureImpl);
        this.featureMap.put(107, class$de$vw$mib$asl$internal$speechengine$features$master$PauseFeatureImpl == null ? (class$de$vw$mib$asl$internal$speechengine$features$master$PauseFeatureImpl = FeatureFactoryImpl.class$("de.vw.mib.asl.internal.speechengine.features.master.PauseFeatureImpl")) : class$de$vw$mib$asl$internal$speechengine$features$master$PauseFeatureImpl);
        this.featureMap.put(108, class$de$vw$mib$asl$internal$speechengine$features$master$PleaseWaitFeatureImpl == null ? (class$de$vw$mib$asl$internal$speechengine$features$master$PleaseWaitFeatureImpl = FeatureFactoryImpl.class$("de.vw.mib.asl.internal.speechengine.features.master.PleaseWaitFeatureImpl")) : class$de$vw$mib$asl$internal$speechengine$features$master$PleaseWaitFeatureImpl);
        this.featureMap.put(109, class$de$vw$mib$asl$internal$speechengine$features$master$RepeatFeatureImpl == null ? (class$de$vw$mib$asl$internal$speechengine$features$master$RepeatFeatureImpl = FeatureFactoryImpl.class$("de.vw.mib.asl.internal.speechengine.features.master.RepeatFeatureImpl")) : class$de$vw$mib$asl$internal$speechengine$features$master$RepeatFeatureImpl);
        this.featureMap.put(306, class$de$vw$mib$asl$internal$speechengine$features$client$state$behavior$SpeakOnlyFeatureImpl == null ? (class$de$vw$mib$asl$internal$speechengine$features$client$state$behavior$SpeakOnlyFeatureImpl = FeatureFactoryImpl.class$("de.vw.mib.asl.internal.speechengine.features.client.state.behavior.SpeakOnlyFeatureImpl")) : class$de$vw$mib$asl$internal$speechengine$features$client$state$behavior$SpeakOnlyFeatureImpl);
        this.featureMap.put(110, class$de$vw$mib$asl$internal$speechengine$features$master$TimeoutFeatureImpl == null ? (class$de$vw$mib$asl$internal$speechengine$features$master$TimeoutFeatureImpl = FeatureFactoryImpl.class$("de.vw.mib.asl.internal.speechengine.features.master.TimeoutFeatureImpl")) : class$de$vw$mib$asl$internal$speechengine$features$master$TimeoutFeatureImpl);
        this.featureMap.put(111, class$de$vw$mib$asl$internal$speechengine$features$master$ListHelpPromptFeatureImpl == null ? (class$de$vw$mib$asl$internal$speechengine$features$master$ListHelpPromptFeatureImpl = FeatureFactoryImpl.class$("de.vw.mib.asl.internal.speechengine.features.master.ListHelpPromptFeatureImpl")) : class$de$vw$mib$asl$internal$speechengine$features$master$ListHelpPromptFeatureImpl);
        this.featureMap.put(307, class$de$vw$mib$asl$internal$speechengine$features$client$state$ListFeatureImpl == null ? (class$de$vw$mib$asl$internal$speechengine$features$client$state$ListFeatureImpl = FeatureFactoryImpl.class$("de.vw.mib.asl.internal.speechengine.features.client.state.ListFeatureImpl")) : class$de$vw$mib$asl$internal$speechengine$features$client$state$ListFeatureImpl);
        this.featureMap.put(308, class$de$vw$mib$asl$internal$speechengine$features$client$state$CommandOverloadFeatureImpl == null ? (class$de$vw$mib$asl$internal$speechengine$features$client$state$CommandOverloadFeatureImpl = FeatureFactoryImpl.class$("de.vw.mib.asl.internal.speechengine.features.client.state.CommandOverloadFeatureImpl")) : class$de$vw$mib$asl$internal$speechengine$features$client$state$CommandOverloadFeatureImpl);
        this.featureMap.put(112, class$de$vw$mib$asl$internal$speechengine$features$master$TeleprompterOnOffFeatureImpl == null ? (class$de$vw$mib$asl$internal$speechengine$features$master$TeleprompterOnOffFeatureImpl = FeatureFactoryImpl.class$("de.vw.mib.asl.internal.speechengine.features.master.TeleprompterOnOffFeatureImpl")) : class$de$vw$mib$asl$internal$speechengine$features$master$TeleprompterOnOffFeatureImpl);
        this.featureMap.put(203, class$de$vw$mib$asl$internal$speechengine$features$client$context$TeleprompterOnOffContextFeatureImpl == null ? (class$de$vw$mib$asl$internal$speechengine$features$client$context$TeleprompterOnOffContextFeatureImpl = FeatureFactoryImpl.class$("de.vw.mib.asl.internal.speechengine.features.client.context.TeleprompterOnOffContextFeatureImpl")) : class$de$vw$mib$asl$internal$speechengine$features$client$context$TeleprompterOnOffContextFeatureImpl);
    }

    @Override
    public GenericTargetFeature createFeature(int n) {
        Class clazz = (Class)this.featureMap.get(n);
        if (clazz == null) {
            this.logger.error().append(new StringBuffer().append("createFeature() found unknown feature with featureID = ").append(n).toString()).log();
            return null;
        }
        try {
            return (GenericTargetFeature)clazz.getConstructors()[0].newInstance(this.loggerParameter);
        }
        catch (Exception exception) {
            this.logger.error().append(new StringBuffer().append("createFeature() could not instantiate feature with featureID = ").append(n).toString()).log();
            return null;
        }
    }

    @Override
    public ComplexHelpPromptsFeature createHelpPromptsFeature() {
        return new HelpPromptsFeatureImpl(this.logger);
    }

    @Override
    public ComplexCommandFeature createCommandFeature() {
        return new CommandFeatureImpl(this.logger);
    }

    @Override
    public ComplexInitialPromptsFeature createInitialPromptsFeature() {
        return new InitialPromptsFeatureImpl(this.logger);
    }

    @Override
    public ComplexTeleprompterDataFeature createTeleprompterDataFeature() {
        return new TeleprompterDataStateFeatureImpl(this.logger);
    }

    @Override
    public Command createCommand(int n, int n2, int n3, int n4, boolean bl, boolean bl2) {
        return new CommandImpl(n, n2, n3, n4, bl, bl2, false);
    }

    @Override
    public Command createCommand(int n, int n2, int n3, int n4, boolean bl, boolean bl2, boolean bl3) {
        return new CommandImpl(n, n2, n3, n4, bl, bl2, bl3);
    }

    @Override
    public Event createEvent(int n) {
        return new EventImpl(n);
    }

    @Override
    public OrderedPrompts createOrderedPrompts(int[] nArray, int n) {
        return new OrderedPromptsImpl(nArray, n);
    }

    @Override
    public Prompt createPrompt(int n, int n2, String[] stringArray) {
        return new PromptImpl(n, n2, stringArray);
    }

    @Override
    public Prompt createDynamicPrompt(int n, int n2, PromptReference[] promptReferenceArray) {
        return new PromptImpl(n, n2, promptReferenceArray);
    }

    @Override
    public Prompt createPrompt(int n, PromptReference[] promptReferenceArray) {
        return new PromptImpl(n, promptReferenceArray);
    }

    @Override
    public PromptReference createPromptReference(String string, String string2, String string3) {
        return new PromptReferenceImpl(string, string2, string3);
    }

    @Override
    public DynamicString createDynamicString(String string, boolean bl) {
        return new DynamicStringImpl(string, bl);
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

