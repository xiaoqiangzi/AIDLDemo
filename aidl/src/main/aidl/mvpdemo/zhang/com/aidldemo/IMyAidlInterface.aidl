// IMyAidlInterface.aidl
package mvpdemo.zhang.com.aidldemo;

// Declare any non-default types here with import statements

interface IMyAidlInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);

    void setData(String data);//自定义方法声明
     String getData(String data);
}
