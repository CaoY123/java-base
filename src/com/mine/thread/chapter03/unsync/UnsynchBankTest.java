package com.mine.thread.chapter03.unsync;

/**
 * @description This program shows data corruption when multiple threads access a data structure.
 * @version 1.32 2018-04-10
 * @author Cay Horstmann
 * 注：下列线程没有同步加锁机制，主要用于展示在没有同步的基础上发生总金额错误的情况
 */
public class UnsynchBankTest
{
   public static final int NACCOUNTS = 100;
   public static final double INITIAL_BALANCE = 1000;
   public static final double MAX_AMOUNT = 1000;
   public static final int DELAY = 10;
   
   public static void main(String[] args)
   {
      Bank bank = new Bank(NACCOUNTS, INITIAL_BALANCE);
      for (int i = 0; i < NACCOUNTS; i++)
      {
         int fromAccount = i;
         Runnable r = () -> 
            {
               try
               {
                  while (true)
                  {
                     int toAccount = (int) (bank.size() * Math.random());
                     double amount = MAX_AMOUNT * Math.random();
                     bank.transfer(fromAccount, toAccount, amount);
                     Thread.sleep((int) (DELAY * Math.random()));
                  }
               }
               catch (InterruptedException e)
               {
               }            
            };
         Thread t = new Thread(r);
         t.start();
      }
   }
}
