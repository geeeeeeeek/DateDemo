/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>


#include <string.h>
#include <stdio.h>
#include <stdlib.h>
#include <errno.h>

#include <android/log.h>


#define  LOG_TAG    "jniLog"

#define printf(...) __android_log_print(ANDROID_LOG_WARN, LOG_TAG, __VA_ARGS__);




#ifndef _Included_com_xqs_datedemo_util_JniUtil
#define _Included_com_xqs_datedemo_util_JniUtil
#ifdef __cplusplus
extern "C" {
#endif


JNIEXPORT jint JNICALL Java_com_xqs_datedemo_util_JniUtil_add(JNIEnv *env, jclass thiz, jint a, jint b) {
    int c;
    c = a+b;
    printf("jni result --> %d ",c);
    return c;
}



#ifdef __cplusplus
}
#endif
#endif