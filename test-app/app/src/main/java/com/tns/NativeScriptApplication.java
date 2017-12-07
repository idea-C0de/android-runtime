package com.tns;

@com.tns.JavaScriptImplementation(javaScriptFile = "./MyApp.js")
public class NativeScriptApplication extends android.app.Application implements com.tns.NativeScriptHashCodeProvider {
    private static android.app.Application thiz;

    public NativeScriptApplication() {
        super();
        thiz = this;
    }

    public void onCreate()  {
        com.tns.Runtime runtime = RuntimeHelper.initRuntime(this);
        if (!Runtime.isInitialized()) {
            super.onCreate();
            return;
        }
        java.lang.Object[] args = null;
        com.tns.Runtime.callJSMethod(this, "onCreate", void.class, args);
        if (runtime != null) {
            runtime.run();
        }
    }

    public boolean equals__super(java.lang.Object other) {
        return super.equals(other);
    }

    public int hashCode__super() {
        return super.hashCode();
    }

    public static android.app.Application getInstance() {
        return thiz;
    }
}
