package kawa.lib;

import gnu.expr.Expression;
import gnu.expr.IfExp;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.expr.Special;
import gnu.kawa.lispexpr.LispLanguage;
import gnu.lists.Consumer;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.CallContext;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Values;
import gnu.math.IntNum;
import kawa.lang.Macro;
import kawa.lang.Quote;
import kawa.lang.SyntaxForms;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import kawa.lang.SyntaxRules;
import kawa.lang.SyntaxTemplate;
import kawa.lang.TemplateScope;
import kawa.standard.syntax_case;
import kawa.standard.syntax_error;
import kawa.standard.try_catch;

/* compiled from: prim_syntax.scm */
public class prim_syntax extends ModuleBody {
    public static final prim_syntax $instance = new prim_syntax();
    static final SimpleSymbol Lit0;
    static final SyntaxRules Lit1;
    static final SyntaxRules Lit10;
    static final SimpleSymbol Lit11;
    static final SyntaxRules Lit12;
    static final SimpleSymbol Lit13 = ((SimpleSymbol) new SimpleSymbol("if").readResolve());
    static final SyntaxPattern Lit14 = new SyntaxPattern("\f\u0007\f\u000f\f\u0017\b", new Object[0], 3);
    static final SyntaxTemplate Lit15 = new SyntaxTemplate("\u0001\u0001\u0001", "\u000b", new Object[0], 0);
    static final SyntaxTemplate Lit16 = new SyntaxTemplate("\u0001\u0001\u0001", "\u0013", new Object[0], 0);
    static final SyntaxPattern Lit17 = new SyntaxPattern("\f\u0007\f\u000f\f\u0017\f\u001f\b", new Object[0], 4);
    static final SyntaxTemplate Lit18 = new SyntaxTemplate("\u0001\u0001\u0001\u0001", "\u000b", new Object[0], 0);
    static final SyntaxTemplate Lit19 = new SyntaxTemplate("\u0001\u0001\u0001\u0001", "\u0013", new Object[0], 0);
    static final SimpleSymbol Lit2;
    static final SyntaxTemplate Lit20 = new SyntaxTemplate("\u0001\u0001\u0001\u0001", "\u001b", new Object[0], 0);
    static final SyntaxPattern Lit21 = new SyntaxPattern("\f\u0007\f\u000f\f\u0017\f\u001f\f'+", new Object[0], 6);
    static final SyntaxTemplate Lit22 = new SyntaxTemplate("\u0001\u0001\u0001\u0001\u0001\u0000", "#", new Object[0], 0);
    static final SyntaxPattern Lit23 = new SyntaxPattern("\f\u0007\u000b", new Object[0], 2);
    static final SyntaxTemplate Lit24 = new SyntaxTemplate("\u0001\u0000", "\n", new Object[0], 0);
    static final SimpleSymbol Lit25 = ((SimpleSymbol) new SimpleSymbol("try-catch").readResolve());
    static final SyntaxPattern Lit26 = new SyntaxPattern("\f\u0007\f\u000f-\f\u0017\f\u001f#\u0010\u0018\b", new Object[0], 5);
    static final SyntaxTemplate Lit27 = new SyntaxTemplate("\u0001\u0001\u0003\u0003\u0002", "\u000b", new Object[0], 0);
    static final SyntaxTemplate Lit28 = new SyntaxTemplate("\u0001\u0001\u0003\u0003\u0002", "(\b\u0015A\b\t\u0013\u0011\u0018\u0004\b\u001b\"", new Object[]{Lit49}, 1);
    static final SimpleSymbol Lit29 = ((SimpleSymbol) new SimpleSymbol("letrec").readResolve());
    static final SyntaxRules Lit3;
    static final SyntaxPattern Lit30 = new SyntaxPattern("\f\u0007\f\u000f\u0013", new Object[0], 3);
    static final SyntaxTemplate Lit31 = new SyntaxTemplate("\u0001\u0001\u0000", "\u000b", new Object[0], 0);
    static final SyntaxTemplate Lit32 = new SyntaxTemplate("\u0001\u0001\u0000", "\u0018\u0004", new Object[]{PairWithPosition.make((SimpleSymbol) new SimpleSymbol("%let").readResolve(), LList.Empty, "/Users/ewpatton/Programming/mit/ai2-kawa/kawa/lib/prim_syntax.scm", 512011)}, 0);
    static final SyntaxTemplate Lit33 = new SyntaxTemplate("\u0001\u0001\u0000", "\u0012", new Object[0], 0);
    static final SyntaxPattern Lit34 = new SyntaxPattern("\b", new Object[0], 3);
    static final SyntaxPattern Lit35 = new SyntaxPattern(",\f\u001f\f'\b+", new Object[0], 6);
    static final SyntaxTemplate Lit36 = new SyntaxTemplate("\u0001\u0001\u0000\u0001\u0001\u0000", "\t\u001b\u0018\u0004", new Object[]{PairWithPosition.make(Special.undefined, LList.Empty, "/Users/ewpatton/Programming/mit/ai2-kawa/kawa/lib/prim_syntax.scm", 450594)}, 0);
    static final SyntaxTemplate Lit37 = new SyntaxTemplate("\u0001\u0001\u0000\u0001\u0001\u0000", "\u0011\u0018\u0004\t\u001b\b#", new Object[]{Lit45}, 0);
    static final SyntaxTemplate Lit38 = new SyntaxTemplate("\u0001\u0001\u0000\u0001\u0001\u0000", "*", new Object[0], 0);
    static final SyntaxPattern Lit39 = new SyntaxPattern("L\f\u001f\f'\f/\f7\b;", new Object[0], 8);
    static final SimpleSymbol Lit4;
    static final SyntaxTemplate Lit40 = new SyntaxTemplate("\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000", "\t\u001b\t#\t+\u0018\u0004", new Object[]{PairWithPosition.make(Special.undefined, LList.Empty, "/Users/ewpatton/Programming/mit/ai2-kawa/kawa/lib/prim_syntax.scm", 471102)}, 0);
    static final SyntaxTemplate Lit41 = new SyntaxTemplate("\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000", "\u0011\u0018\u0004\t\u001b\b3", new Object[]{Lit45}, 0);
    static final SyntaxTemplate Lit42 = new SyntaxTemplate("\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000", ":", new Object[0], 0);
    static final SyntaxPattern Lit43 = new SyntaxPattern("\u001c\f\u001f\b#", new Object[0], 5);
    static final SyntaxPattern Lit44 = new SyntaxPattern("\u001b", new Object[0], 4);
    static final SimpleSymbol Lit45 = ((SimpleSymbol) new SimpleSymbol("set!").readResolve());
    static final SimpleSymbol Lit46 = ((SimpleSymbol) new SimpleSymbol("$lookup$").readResolve());
    static final SimpleSymbol Lit47 = ((SimpleSymbol) new SimpleSymbol("kawa.lang.SyntaxForms").readResolve());
    static final SimpleSymbol Lit48 = ((SimpleSymbol) new SimpleSymbol(LispLanguage.quasiquote_sym).readResolve());
    static final SimpleSymbol Lit49 = ((SimpleSymbol) new SimpleSymbol("::").readResolve());
    static final SyntaxRules Lit5;
    static final SimpleSymbol Lit50 = ((SimpleSymbol) new SimpleSymbol("%define").readResolve());
    static final IntNum Lit51 = IntNum.make(9);
    static final IntNum Lit52 = IntNum.make(8);
    static final IntNum Lit53 = IntNum.make(5);
    static final IntNum Lit54 = IntNum.make(4);
    static final IntNum Lit55 = IntNum.make(1);
    static final IntNum Lit56 = IntNum.make(0);
    static final SimpleSymbol Lit57 = ((SimpleSymbol) new SimpleSymbol("%define-syntax").readResolve());
    static final SimpleSymbol Lit58 = ((SimpleSymbol) new SimpleSymbol("lambda").readResolve());
    static final SimpleSymbol Lit6;
    static final SyntaxRules Lit7;
    static final SimpleSymbol Lit8 = ((SimpleSymbol) new SimpleSymbol("syntax-error").readResolve());
    static final SimpleSymbol Lit9;
    public static final Macro define = Macro.make(Lit2, Lit3, $instance);
    public static final Macro define$Mnconstant = Macro.make(Lit6, Lit7, $instance);
    public static final Macro define$Mnprivate = Macro.make(Lit4, Lit5, $instance);
    public static final Macro define$Mnsyntax = Macro.make(Lit0, Lit1, $instance);

    /* renamed from: if reason: not valid java name */
    public static final Macro f4if;
    public static final Macro letrec;
    public static final Macro syntax$Mn$Grexpression = Macro.make(Lit9, Lit10, $instance);
    public static final Macro syntax$Mnbody$Mn$Grexpression = Macro.make(Lit11, Lit12, $instance);
    public static final ModuleMethod syntax$Mnerror;
    public static final Macro try$Mncatch;

    /* compiled from: prim_syntax.scm */
    public class frame extends ModuleBody {
        Object[] $unnamed$0;
        Object out$Mnbindings;
        Object out$Mninits;

        public Object lambda4processBinding(Object b) {
            Object[] objArr;
            Object[] objArr2;
            Object[] allocVars = SyntaxPattern.allocVars(8, this.$unnamed$0);
            if (prim_syntax.Lit34.match(b, allocVars, 0)) {
                return Values.empty;
            }
            if (prim_syntax.Lit35.match(b, allocVars, 0)) {
                this.out$Mnbindings = new Pair(prim_syntax.Lit36.execute(allocVars, TemplateScope.make()), this.out$Mnbindings);
                this.out$Mninits = new Pair(prim_syntax.Lit37.execute(allocVars, TemplateScope.make()), this.out$Mninits);
                return lambda4processBinding(prim_syntax.Lit38.execute(allocVars, TemplateScope.make()));
            } else if (prim_syntax.Lit39.match(b, allocVars, 0)) {
                this.out$Mnbindings = new Pair(prim_syntax.Lit40.execute(allocVars, TemplateScope.make()), this.out$Mnbindings);
                this.out$Mninits = new Pair(prim_syntax.Lit41.execute(allocVars, TemplateScope.make()), this.out$Mninits);
                return lambda4processBinding(prim_syntax.Lit42.execute(allocVars, TemplateScope.make()));
            } else if (prim_syntax.Lit43.match(b, allocVars, 0)) {
                String str = "missing initializion in letrec";
                if (str instanceof Object[]) {
                    objArr2 = (Object[]) str;
                } else {
                    objArr2 = new Object[]{str};
                }
                return prim_syntax.syntaxError(b, objArr2);
            } else if (!prim_syntax.Lit44.match(b, allocVars, 0)) {
                return syntax_case.error("syntax-case", b);
            } else {
                String str2 = "invalid bindings syntax in letrec";
                if (str2 instanceof Object[]) {
                    objArr = (Object[]) str2;
                } else {
                    objArr = new Object[]{str2};
                }
                return prim_syntax.syntaxError(b, objArr);
            }
        }
    }

    static {
        SimpleSymbol simpleSymbol = (SimpleSymbol) new SimpleSymbol("syntax-body->expression").readResolve();
        Lit11 = simpleSymbol;
        Lit12 = new SyntaxRules(new Object[]{simpleSymbol}, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\b", new Object[0], 1), "\u0001", "\u0011\u0018\u0004\b\u0003", new Object[]{PairWithPosition.make(Lit46, Pair.make(Lit47, Pair.make(Pair.make(Lit48, Pair.make((SimpleSymbol) new SimpleSymbol("rewriteBody").readResolve(), LList.Empty)), LList.Empty)), "/Users/ewpatton/Programming/mit/ai2-kawa/kawa/lib/prim_syntax.scm", 270343)}, 0)}, 1);
        SimpleSymbol simpleSymbol2 = (SimpleSymbol) new SimpleSymbol("syntax->expression").readResolve();
        Lit9 = simpleSymbol2;
        Lit10 = new SyntaxRules(new Object[]{simpleSymbol2}, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\b", new Object[0], 1), "\u0001", "\u0011\u0018\u0004\b\u0003", new Object[]{PairWithPosition.make(Lit46, Pair.make(Lit47, Pair.make(Pair.make(Lit48, Pair.make((SimpleSymbol) new SimpleSymbol("rewrite").readResolve(), LList.Empty)), LList.Empty)), "/Users/ewpatton/Programming/mit/ai2-kawa/kawa/lib/prim_syntax.scm", 249863)}, 0)}, 1);
        SimpleSymbol simpleSymbol3 = (SimpleSymbol) new SimpleSymbol("define-constant").readResolve();
        Lit6 = simpleSymbol3;
        Object[] objArr = {simpleSymbol3, Lit49, Lit46};
        Object[] objArr2 = {Lit46, Lit49};
        Object[] objArr3 = {Lit50, Lit46, Lit51};
        Object[] objArr4 = {Lit46};
        Object[] objArr5 = new Object[4];
        objArr5[0] = Lit50;
        objArr5[1] = Lit46;
        objArr5[2] = Lit52;
        Object[] objArr6 = {Lit50, IntNum.make(10), Boolean.TRUE};
        Object[] objArr7 = {Lit49};
        Object[] objArr8 = {Lit50, Lit51};
        Object[] objArr9 = new Object[3];
        objArr9[0] = Lit50;
        objArr9[1] = Lit52;
        Lit7 = new SyntaxRules(objArr, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\\\f\u0002\f\u0007,\f\u000f\f\u0017\b\b\f\n\f\u001f\f'\b", objArr2, 5), "\u0001\u0001\u0001\u0001\u0001", "\u0011\u0018\u0004Q\u0011\u0018\f\t\u0003\b\t\u000b\b\u0013\u0011\u0018\u0014\t\u001b\b#", objArr3, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\\\f\u0002\f\u0007,\f\u000f\f\u0017\b\b\f\u001f\b", objArr4, 4), "\u0001\u0001\u0001\u0001", "\u0011\u0018\u0004Q\u0011\u0018\f\t\u0003\b\t\u000b\b\u0013\u0011\u0018\u0014\u0011\u0018\u001c\b\u001b", objArr5, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\u001c\f\u0007\u000b\u0013", new Object[0], 3), "\u0001\u0000\u0000", "\u0011\u0018\u0004\t\u0003\u0011\u0018\f\u0011\u0018\u0014\t\n\u0012", objArr6, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u0002\f\u000f\f\u0017\b", objArr7, 3), "\u0001\u0001\u0001", "\u0011\u0018\u0004\t\u0003\u0011\u0018\f\t\u000b\b\u0013", objArr8, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\b", new Object[0], 2), "\u0001\u0001", "\u0011\u0018\u0004\t\u0003\u0011\u0018\f\u0011\u0018\u0014\b\u000b", objArr9, 0)}, 5);
        SimpleSymbol simpleSymbol4 = (SimpleSymbol) new SimpleSymbol("define-private").readResolve();
        Lit4 = simpleSymbol4;
        Object[] objArr10 = {simpleSymbol4, Lit49, Lit46};
        Object[] objArr11 = {Lit46, Lit49};
        Object[] objArr12 = {Lit50, Lit46, Lit53};
        Object[] objArr13 = {Lit46};
        Object[] objArr14 = new Object[4];
        objArr14[0] = Lit50;
        objArr14[1] = Lit46;
        objArr14[2] = Lit54;
        Object[] objArr15 = {Lit50, IntNum.make(6), Boolean.TRUE};
        Object[] objArr16 = {Lit49};
        Object[] objArr17 = {Lit50, Lit53};
        Object[] objArr18 = new Object[3];
        objArr18[0] = Lit50;
        objArr18[1] = Lit54;
        Lit5 = new SyntaxRules(objArr10, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\\\f\u0002\f\u0007,\f\u000f\f\u0017\b\b\f\n\f\u001f\f'\b", objArr11, 5), "\u0001\u0001\u0001\u0001\u0001", "\u0011\u0018\u0004Q\u0011\u0018\f\t\u0003\b\t\u000b\b\u0013\u0011\u0018\u0014\t\u001b\b#", objArr12, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\\\f\u0002\f\u0007,\f\u000f\f\u0017\b\b\f\u001f\b", objArr13, 4), "\u0001\u0001\u0001\u0001", "\u0011\u0018\u0004Q\u0011\u0018\f\t\u0003\b\t\u000b\b\u0013\u0011\u0018\u0014\u0011\u0018\u001c\b\u001b", objArr14, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\u001c\f\u0007\u000b\u0013", new Object[0], 3), "\u0001\u0000\u0000", "\u0011\u0018\u0004\t\u0003\u0011\u0018\f\u0011\u0018\u0014\t\n\u0012", objArr15, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u0002\f\u000f\f\u0017\b", objArr16, 3), "\u0001\u0001\u0001", "\u0011\u0018\u0004\t\u0003\u0011\u0018\f\t\u000b\b\u0013", objArr17, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\b", new Object[0], 2), "\u0001\u0001", "\u0011\u0018\u0004\t\u0003\u0011\u0018\f\u0011\u0018\u0014\b\u000b", objArr18, 0)}, 5);
        SimpleSymbol simpleSymbol5 = (SimpleSymbol) new SimpleSymbol("define").readResolve();
        Lit2 = simpleSymbol5;
        Object[] objArr19 = {simpleSymbol5, Lit49, Lit46};
        Object[] objArr20 = {Lit46, Lit49};
        Object[] objArr21 = {Lit50, Lit46, Lit55};
        Object[] objArr22 = {Lit46};
        Object[] objArr23 = new Object[4];
        objArr23[0] = Lit50;
        objArr23[1] = Lit46;
        objArr23[2] = Lit56;
        Object[] objArr24 = {Lit50, IntNum.make(2), Boolean.TRUE};
        Object[] objArr25 = {Lit49};
        Object[] objArr26 = {Lit50, Lit55};
        Object[] objArr27 = new Object[3];
        objArr27[0] = Lit50;
        objArr27[1] = Lit56;
        Lit3 = new SyntaxRules(objArr19, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\\\f\u0002\f\u0007,\f\u000f\f\u0017\b\b\f\n\f\u001f\f'\b", objArr20, 5), "\u0001\u0001\u0001\u0001\u0001", "\u0011\u0018\u0004Q\u0011\u0018\f\t\u0003\b\t\u000b\b\u0013\u0011\u0018\u0014\t\u001b\b#", objArr21, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\\\f\u0002\f\u0007,\f\u000f\f\u0017\b\b\f\u001f\b", objArr22, 4), "\u0001\u0001\u0001\u0001", "\u0011\u0018\u0004Q\u0011\u0018\f\t\u0003\b\t\u000b\b\u0013\u0011\u0018\u0014\u0011\u0018\u001c\b\u001b", objArr23, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\u001c\f\u0007\u000b\u0013", new Object[0], 3), "\u0001\u0000\u0000", "\u0011\u0018\u0004\t\u0003\u0011\u0018\f\u0011\u0018\u0014\t\n\u0012", objArr24, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u0002\f\u000f\f\u0017\b", objArr25, 3), "\u0001\u0001\u0001", "\u0011\u0018\u0004\t\u0003\u0011\u0018\f\t\u000b\b\u0013", objArr26, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\b", new Object[0], 2), "\u0001\u0001", "\u0011\u0018\u0004\t\u0003\u0011\u0018\f\u0011\u0018\u0014\b\u000b", objArr27, 0)}, 5);
        SimpleSymbol simpleSymbol6 = (SimpleSymbol) new SimpleSymbol("define-syntax").readResolve();
        Lit0 = simpleSymbol6;
        Object[] objArr28 = {Lit57, Lit46, Lit58};
        Object[] objArr29 = {Lit57, Lit46};
        Lit1 = new SyntaxRules(new Object[]{simpleSymbol6, Lit46}, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018l\\\f\u0002\f\u0007,\f\u000f\f\u0017\b\b\u001b#", new Object[]{Lit46}, 5), "\u0001\u0001\u0001\u0000\u0000", "\u0011\u0018\u0004Q\u0011\u0018\f\t\u0003\b\t\u000b\b\u0013\b\u0011\u0018\u0014\t\u001a\"", objArr28, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\\\f\u0002\f\u0007,\f\u000f\f\u0017\b\b\f\u001f\b", new Object[]{Lit46}, 4), "\u0001\u0001\u0001\u0001", "\u0011\u0018\u0004Q\u0011\u0018\f\t\u0003\b\t\u000b\b\u0013\b\u001b", objArr29, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\u001c\f\u0007\u000b\u0013", new Object[0], 3), "\u0001\u0000\u0000", "\u0011\u0018\u0004\t\u0003\b\u0011\u0018\f\t\n\u0012", new Object[]{Lit57, Lit58}, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\b", new Object[0], 2), "\u0001\u0001", "\u0011\u0018\u0004\t\u0003\b\u000b", new Object[]{Lit57}, 0)}, 5);
        prim_syntax prim_syntax = $instance;
        syntax$Mnerror = new ModuleMethod(prim_syntax, 1, Lit8, -4095);
        SimpleSymbol simpleSymbol7 = Lit13;
        ModuleMethod moduleMethod = new ModuleMethod(prim_syntax, 2, null, 4097);
        moduleMethod.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/kawa/lib/prim_syntax.scm:69");
        f4if = Macro.make(simpleSymbol7, moduleMethod, $instance);
        SimpleSymbol simpleSymbol8 = Lit25;
        ModuleMethod moduleMethod2 = new ModuleMethod(prim_syntax, 3, null, 4097);
        moduleMethod2.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/kawa/lib/prim_syntax.scm:89");
        try$Mncatch = Macro.make(simpleSymbol8, moduleMethod2, $instance);
        SimpleSymbol simpleSymbol9 = Lit29;
        ModuleMethod moduleMethod3 = new ModuleMethod(prim_syntax, 4, null, 4097);
        moduleMethod3.setProperty("source-location", "/Users/ewpatton/Programming/mit/ai2-kawa/kawa/lib/prim_syntax.scm:98");
        letrec = Macro.make(simpleSymbol9, moduleMethod3, $instance);
        $instance.run();
    }

    public prim_syntax() {
        ModuleInfo.register(this);
    }

    public final void run(CallContext $ctx) {
        Consumer consumer = $ctx.consumer;
    }

    public static Expression syntaxError(Object id, Object... msg) {
        return syntax_error.error(id, msg);
    }

    public Object applyN(ModuleMethod moduleMethod, Object[] objArr) {
        if (moduleMethod.selector != 1) {
            return super.applyN(moduleMethod, objArr);
        }
        Object obj = objArr[0];
        int length = objArr.length - 1;
        Object[] objArr2 = new Object[length];
        while (true) {
            length--;
            if (length < 0) {
                return syntaxError(obj, objArr2);
            }
            objArr2[length] = objArr[length + 1];
        }
    }

    public int matchN(ModuleMethod moduleMethod, Object[] objArr, CallContext callContext) {
        if (moduleMethod.selector != 1) {
            return super.matchN(moduleMethod, objArr, callContext);
        }
        callContext.values = objArr;
        callContext.proc = moduleMethod;
        callContext.pc = 5;
        return 0;
    }

    static Object lambda1(Object x) {
        Object[] objArr;
        Object[] objArr2;
        Object[] allocVars = SyntaxPattern.allocVars(6, null);
        if (Lit14.match(x, allocVars, 0)) {
            return new IfExp(SyntaxForms.rewrite(Lit15.execute(allocVars, TemplateScope.make())), SyntaxForms.rewrite(Lit16.execute(allocVars, TemplateScope.make())), null);
        } else if (Lit17.match(x, allocVars, 0)) {
            return new IfExp(SyntaxForms.rewrite(Lit18.execute(allocVars, TemplateScope.make())), SyntaxForms.rewrite(Lit19.execute(allocVars, TemplateScope.make())), SyntaxForms.rewrite(Lit20.execute(allocVars, TemplateScope.make())));
        } else if (Lit21.match(x, allocVars, 0)) {
            Object execute = Lit22.execute(allocVars, TemplateScope.make());
            String str = "too many expressions for 'if'";
            if (str instanceof Object[]) {
                objArr2 = (Object[]) str;
            } else {
                objArr2 = new Object[]{str};
            }
            return syntaxError(execute, objArr2);
        } else if (!Lit23.match(x, allocVars, 0)) {
            return syntax_case.error("syntax-case", x);
        } else {
            Object execute2 = Lit24.execute(allocVars, TemplateScope.make());
            String str2 = "too few expressions for 'if'";
            if (str2 instanceof Object[]) {
                objArr = (Object[]) str2;
            } else {
                objArr = new Object[]{str2};
            }
            return syntaxError(execute2, objArr);
        }
    }

    public int match1(ModuleMethod moduleMethod, Object obj, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 2:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 3:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            case 4:
                callContext.value1 = obj;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            default:
                return super.match1(moduleMethod, obj, callContext);
        }
    }

    static Object lambda2(Object x) {
        Object[] allocVars = SyntaxPattern.allocVars(5, null);
        if (!Lit26.match(x, allocVars, 0)) {
            return syntax_case.error("syntax-case", x);
        }
        return try_catch.rewrite(Lit27.execute(allocVars, TemplateScope.make()), Lit28.execute(allocVars, TemplateScope.make()));
    }

    static Object lambda3(Object form) {
        frame frame2 = new frame();
        LList lList = LList.Empty;
        frame2.out$Mninits = LList.Empty;
        frame2.out$Mnbindings = lList;
        frame2.$unnamed$0 = SyntaxPattern.allocVars(3, null);
        if (!Lit30.match(form, frame2.$unnamed$0, 0)) {
            return syntax_case.error("syntax-case", form);
        }
        frame2.lambda4processBinding(Lit31.execute(frame2.$unnamed$0, TemplateScope.make()));
        frame2.out$Mnbindings = LList.reverseInPlace(frame2.out$Mnbindings);
        frame2.out$Mninits = LList.reverseInPlace(frame2.out$Mninits);
        TemplateScope make = TemplateScope.make();
        return Quote.append$V(new Object[]{Lit32.execute(frame2.$unnamed$0, make), Quote.consX$V(new Object[]{frame2.out$Mnbindings, Quote.append$V(new Object[]{frame2.out$Mninits, Lit33.execute(frame2.$unnamed$0, make)})})});
    }

    public Object apply1(ModuleMethod moduleMethod, Object obj) {
        switch (moduleMethod.selector) {
            case 2:
                return lambda1(obj);
            case 3:
                return lambda2(obj);
            case 4:
                return lambda3(obj);
            default:
                return super.apply1(moduleMethod, obj);
        }
    }
}
