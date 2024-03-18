#include <jni.h>
#include <string>
int mul(int a,int b);
extern "C" JNIEXPORT jstring JNICALL
Java_com_example_myapplicationdnk1_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
extern "C"
JNIEXPORT jint JNICALL
Java_com_example_myapplicationdnk1_MainActivity_addFromJNI(JNIEnv *env, jobject thiz, jint a, jint b) {
    // TODO: implement addFromJNI()
    int aa=mul(12,a);
    return aa+b;
}

 int mul(int a,int b)
{
    return a*b;
}
