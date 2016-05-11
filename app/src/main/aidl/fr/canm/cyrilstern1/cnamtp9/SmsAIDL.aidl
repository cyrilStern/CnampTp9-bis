// SmsAIDL.aidl
package fr.canm.cyrilstern1.cnamtp9;

// Declare any non-default types here with import statements

interface SmsAIDL {
     void startSMSInterceptor();
         void stopSMSInterceptor();

         // ..
         long interceptedSMS();
         String lastSMSReceived();
         String lastSMSIntercepted();
}
