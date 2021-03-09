package com.reuben.springlearn.aop.proxy;

/**
 * 这个收银小妹很是马虎,长得很漂亮,所以眼睛离不开手机经常不知道在和谁聊天.
 * 有师傅给他说要干嘛他也没好好干,只能又给他配了一个代理员工.在他每次收钱的时候没收他的手机
 */
public class CashierStaffImpl implements CashierStaff{


    @Override
    public void getMoney() {
        System.out.println("收银小妹: 钱收完了,手机给我");
    }
}
