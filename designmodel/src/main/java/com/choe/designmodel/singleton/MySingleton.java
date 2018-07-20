package com.choe.designmodel.singleton;

/**
 * @author cyk
 * @date 2018/7/20/020 15:04
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
public class MySingleton {

    private static String xxxxx;
    private static MySingleton singleton;

    public static synchronized MySingleton getInstance(){
        if (singleton == null ){
            System.out.println("init");
            synchronized (MySingleton.class){
                singleton = new MySingleton();
            }
        }
        return singleton;
    }



    public String singletonName;

    public String getSingletonName() {
        return singletonName;
    }

    public void setSingletonName(String singletonName) {
        this.singletonName = singletonName;
    }

    public  String getXxxxx() {
        return xxxxx;
    }

    public void setXxxxx(String xxxxx) {
        MySingleton.xxxxx = xxxxx;
    }
}
