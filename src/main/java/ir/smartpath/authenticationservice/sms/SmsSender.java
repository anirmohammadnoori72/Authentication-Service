package ir.smartpath.authenticationservice.sms;


public interface SmsSender {
    public SendSMSResponse sendSMS(String to, String text);
}
