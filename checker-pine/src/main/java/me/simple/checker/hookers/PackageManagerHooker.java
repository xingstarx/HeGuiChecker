package me.simple.checker.hookers;

import android.provider.Settings;
import android.text.TextUtils;

import me.simple.checker.CheckerHelper;
import top.canyie.pine.Pine;
import top.canyie.pine.callback.MethodHook;

//android.app.ApplicationPackageManager
public class PackageManagerHooker {

    public static void hook() throws NoSuchMethodException {
        hookGetInstalledPackages();
        hookGetApplicationInfo();
        hookGetInstalledApplications();
        hookGetInstallerPackageName();
        hookGetPackageInfo();
    }

    private static void hookGetInstalledPackages() throws NoSuchMethodException {
        try {
            Class clazz = Class.forName("android.app.ApplicationPackageManager");
            Pine.hook(clazz.getMethod("getInstalledPackages", int.class), new MethodHook() {
                @Override
                public void beforeCall(Pine.CallFrame callFrame) throws Throwable {
                    super.beforeCall(callFrame);
                    CheckerHelper.showWarn("getInstalledPackages");
                }
            });
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void hookGetApplicationInfo() throws NoSuchMethodException {
        try {
            Class clazz = Class.forName("android.app.ApplicationPackageManager");
            Pine.hook(clazz.getMethod("getApplicationInfo", String.class, int.class), new MethodHook() {
                @Override
                public void beforeCall(Pine.CallFrame callFrame) throws Throwable {
                    super.beforeCall(callFrame);
//                    CheckerHelper.showWarn("getApplicationInfo");
                    try {
                        CheckerHelper.showWarn("getApplicationInfo 参数: " + callFrame.args[0]);
                    } catch (Throwable throwable) {
                        throwable.printStackTrace();
                    }
                }
            });
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    private static void hookGetInstalledApplications() throws NoSuchMethodException {
        try {
            Class clazz = Class.forName("android.app.ApplicationPackageManager");
            Pine.hook(clazz.getMethod("getInstalledApplications", int.class), new MethodHook() {
                @Override
                public void beforeCall(Pine.CallFrame callFrame) throws Throwable {
                    super.beforeCall(callFrame);
                    CheckerHelper.showWarn("getInstalledApplications");
                }
            });
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void hookGetInstallerPackageName() throws NoSuchMethodException {
        try {
            Class clazz = Class.forName("android.app.ApplicationPackageManager");
            Pine.hook(clazz.getMethod("getInstallerPackageName", String.class), new MethodHook() {
                @Override
                public void beforeCall(Pine.CallFrame callFrame) throws Throwable {
                    super.beforeCall(callFrame);
                    CheckerHelper.showWarn("getInstallerPackageName");
                }
            });
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void hookGetPackageInfo() throws NoSuchMethodException {
        try {
            Class clazz = Class.forName("android.app.ApplicationPackageManager");
            Pine.hook(clazz.getMethod("getPackageInfo", String.class, int.class), new MethodHook() {
                @Override
                public void beforeCall(Pine.CallFrame callFrame) throws Throwable {
                    super.beforeCall(callFrame);
//                    CheckerHelper.showWarn("getPackageInfo");
                    try {
                        CheckerHelper.showWarn("getPackageInfo 参数: " + callFrame.args[0]);
                    } catch (Throwable throwable) {
                        throwable.printStackTrace();
                    }
                }
            });
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
