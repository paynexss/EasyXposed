package com.payne.easyxposed.module;

import static com.payne.easyxposed.utils.Tool.myLog;
import static com.payne.easyxposed.utils.Tool.showStack;

import android.content.Context;

import com.payne.easyxposed.utils.Tool;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class FakeLocation {

    public static void HookVIP(XC_LoadPackage.LoadPackageParam lpparam) {

        XposedHelpers.findAndHookMethod("com.stub.StubApp",lpparam.classLoader,"a", Context.class, new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                Context context = (Context) param.args[0];
                ClassLoader classLoader = context.getClassLoader();
                XposedHelpers.findAndHookMethod("ށ.ރ.ؠ.ރ.ރ.މ",classLoader, "getType", new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                        myLog("====getType");
                        param.setResult(1);
                    }
                });
                XposedHelpers.findAndHookMethod("ށ.ރ.ؠ.ރ.ރ.މ", classLoader, "getProindate", new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                        myLog("====getProindate");
                        param.setResult(4787107805000L);
                    }
                });
                XposedHelpers.findAndHookMethod("ށ.ރ.ؠ.ؠ.֏", classLoader, "ޅ", new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                        myLog("====yyyy");
                        param.setResult(true);
                    }
                });
                XposedHelpers.findAndHookMethod("ށ.ރ.ؠ.ތ.ހ.ؠ", classLoader, "setToken", java.lang.String.class, new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);
//                        myLog("setToken====:" + param.args[0]);
                        param.args[0] = "Td";
                    }
                });

//                XposedHelpers.findAndHookMethod("ށ.ރ.ؠ.ވ.֏", classLoader, "֏", android.content.Context.class, new XC_MethodReplacement() {
//                    @Override
//                    protected Object replaceHookedMethod(MethodHookParam methodHookParam) throws Throwable {
////                        myLog("no update====");
//                        return null;
//                    }
//                });
            }
        });
    }
}
