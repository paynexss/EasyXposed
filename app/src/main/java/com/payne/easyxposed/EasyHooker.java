package com.payne.easyxposed;

import com.payne.easyxposed.module.FakeLocation;
import com.payne.easyxposed.utils.Tool;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

import static com.payne.easyxposed.utils.Tool.myLog;

import android.content.Context;


public final class EasyHooker implements IXposedHookLoadPackage {

	public static final String TAG = "payne";
	private static final String FK = "com.lerist.fakelocation";  //FakeLocation虚拟定位

	public static Context context;

	public static Context TAG() {
		return null;
	}

	@Override
	public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) {
		myLog("Hook Version = 0.1");
		if (lpparam == null) {
			return;
		}
		// WARN：去LSP中确认，实际要被hook的应用包名
		Tool.classLoader = lpparam.classLoader;
		appHook(lpparam);
	}

	private void appHook(XC_LoadPackage.LoadPackageParam lpparam){
		/*Class test = clazzForName("test.a.b.c");
		hookMethod("com.ironsource.sdk.controller.IronSourceWebView$JSInterface",
				"onAdWindowsClosed", test, new XC_MethodHook() {
					@Override
					protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
						super.beforeHookedMethod(param);
						showStack();
					}
				});*/
		if (lpparam.packageName.equals(FK)) {
			FakeLocation.HookVIP(lpparam);
		}
	}
}
