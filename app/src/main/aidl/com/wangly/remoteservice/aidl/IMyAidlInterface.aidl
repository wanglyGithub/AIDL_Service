// IMyAidlInterface.aidl
package com.wangly.remoteservice.aidl;

// Declare any non-default types here with import statements

/**
* aidl 默认传输基本的类型，
* 如果你需要传输自定义类型的话，需要自定义JavaBean
* 实现 Paceable 重写几个方法，这样才能满足需要！
*
*/

interface IMyAidlInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    String getServiceMethodInfo();
}
