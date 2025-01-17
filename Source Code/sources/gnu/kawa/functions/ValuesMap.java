package gnu.kawa.functions;

import gnu.bytecode.CodeAttr;
import gnu.bytecode.Label;
import gnu.bytecode.Method;
import gnu.bytecode.Scope;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.ConsumerTarget;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.IfExp;
import gnu.expr.IgnoreTarget;
import gnu.expr.Inlineable;
import gnu.expr.LambdaExp;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.StackTarget;
import gnu.expr.Target;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;
import gnu.mapping.Procedure;
import gnu.mapping.Values;
import gnu.math.IntNum;

public class ValuesMap extends MethodProc implements Inlineable {
    public static final ValuesMap valuesMap = new ValuesMap(-1);
    public static final ValuesMap valuesMapWithPos = new ValuesMap(1);
    private final int startCounter;

    private ValuesMap(int startCounter2) {
        this.startCounter = startCounter2;
        setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileMisc:validateApplyValuesMap");
    }

    public int numArgs() {
        return 8194;
    }

    public void apply(CallContext ctx) throws Throwable {
        Procedure proc = (Procedure) ctx.getNextArg();
        Consumer consumer = ctx.consumer;
        Object val = ctx.getNextArg();
        Procedure.checkArgCount(proc, 1);
        if (val instanceof Values) {
            int ipos = 0;
            int count = this.startCounter;
            Values values = (Values) val;
            while (true) {
                ipos = values.nextPos(ipos);
                if (ipos != 0) {
                    Object v = values.getPosPrevious(ipos);
                    if (this.startCounter >= 0) {
                        int count2 = count + 1;
                        proc.check2(v, IntNum.make(count), ctx);
                        count = count2;
                    } else {
                        proc.check1(v, ctx);
                    }
                    ctx.runUntilDone();
                } else {
                    return;
                }
            }
        } else {
            if (this.startCounter >= 0) {
                proc.check2(val, IntNum.make(this.startCounter), ctx);
            } else {
                proc.check1(val, ctx);
            }
            ctx.runUntilDone();
        }
    }

    static LambdaExp canInline(ApplyExp exp, ValuesMap proc) {
        int i = 2;
        Expression[] args = exp.getArgs();
        if (args.length == 2) {
            Expression arg0 = args[0];
            if (arg0 instanceof LambdaExp) {
                LambdaExp lexp = (LambdaExp) arg0;
                if (lexp.min_args == lexp.max_args) {
                    int i2 = lexp.min_args;
                    if (proc.startCounter < 0) {
                        i = 1;
                    }
                    if (i2 == i) {
                        return lexp;
                    }
                }
            }
        }
        return null;
    }

    public void compile(ApplyExp exp, Compilation comp, Target target) {
        LambdaExp lambda = canInline(exp, this);
        if (lambda == null) {
            ApplyExp.compile(exp, comp, target);
            return;
        }
        Expression[] args = exp.getArgs();
        if ((target instanceof IgnoreTarget) || (target instanceof ConsumerTarget)) {
            compileInlined(lambda, args[1], this.startCounter, null, comp, target);
        } else {
            ConsumerTarget.compileUsingConsumer(exp, comp, target);
        }
    }

    public static void compileInlined(LambdaExp lambda, Expression vals, int startCounter2, Method matchesMethod, Compilation comp, Target target) {
        Variable counter;
        Declaration counterDecl;
        Expression[] args;
        Declaration param = lambda.firstDecl();
        CodeAttr code = comp.getCode();
        Scope scope = code.pushScope();
        Type paramType = param.getType();
        if (startCounter2 >= 0) {
            counter = scope.addVariable(code, Type.intType, "position");
            code.emitPushInt(startCounter2);
            code.emitStore(counter);
            counterDecl = new Declaration(counter);
        } else {
            counter = null;
            counterDecl = null;
        }
        if (!param.isSimple() || matchesMethod != null) {
            param = new Declaration(code.addLocal(paramType.getImplementationType(), Compilation.mangleNameIfNeeded(param.getName())));
        } else {
            param.allocateVariable(code);
        }
        if (startCounter2 >= 0) {
            ReferenceExp referenceExp = new ReferenceExp(param);
            ReferenceExp referenceExp2 = new ReferenceExp(counterDecl);
            args = new Expression[]{referenceExp, referenceExp2};
        } else {
            ReferenceExp referenceExp3 = new ReferenceExp(param);
            args = new Expression[]{referenceExp3};
        }
        Expression app = new ApplyExp((Expression) lambda, args);
        if (matchesMethod != null) {
            if (app.getType().getImplementationType() != Type.booleanType) {
                ReferenceExp referenceExp4 = new ReferenceExp(counterDecl);
                app = new ApplyExp(matchesMethod, new Expression[]{app, referenceExp4});
            }
            ReferenceExp referenceExp5 = new ReferenceExp(param);
            app = new IfExp(app, referenceExp5, QuoteExp.voidExp);
        }
        Variable indexVar = code.addLocal(Type.intType);
        Variable valuesVar = code.addLocal(Type.pointer_type);
        Variable nextVar = code.addLocal(Type.intType);
        vals.compileWithPosition(comp, Target.pushObject);
        code.emitStore(valuesVar);
        code.emitPushInt(0);
        code.emitStore(indexVar);
        Label label = new Label(code);
        Label doneLabel = new Label(code);
        label.define(code);
        code.emitLoad(valuesVar);
        code.emitLoad(indexVar);
        code.emitInvokeStatic(Compilation.typeValues.getDeclaredMethod("nextIndex", 2));
        code.emitDup((Type) Type.intType);
        code.emitStore(nextVar);
        code.emitGotoIfIntLtZero(doneLabel);
        code.emitLoad(valuesVar);
        code.emitLoad(indexVar);
        code.emitInvokeStatic(Compilation.typeValues.getDeclaredMethod("nextValue", 2));
        StackTarget.convert(comp, Type.objectType, paramType);
        param.compileStore(comp);
        app.compile(comp, target);
        if (startCounter2 >= 0) {
            code.emitInc(counter, 1);
        }
        code.emitLoad(nextVar);
        code.emitStore(indexVar);
        code.emitGoto(label);
        doneLabel.define(code);
        code.popScope();
    }

    public Type getReturnType(Expression[] args) {
        return Type.pointer_type;
    }
}
