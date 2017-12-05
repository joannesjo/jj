package com.jj.model;

import com.instamojo.wrapper.api.Instamojo;
import com.instamojo.wrapper.api.InstamojoImpl;
import com.instamojo.wrapper.exception.ConnectionException;
import com.instamojo.wrapper.exception.InvalidPaymentOrderException;
import com.instamojo.wrapper.model.PaymentOrder;
import com.instamojo.wrapper.response.CreatePaymentOrderResponse;
import com.instamojo.wrapper.response.PaymentOrderDetailsResponse;
import org.springframework.stereotype.Service;

import java.util.logging.Level;

@Service
public class InstaMojo {
    public String createPayment() {
        PaymentOrder order = new PaymentOrder();
        order.setName("instamojotestname");
        order.setEmail("joannes.webd@gmail.com");
        order.setPhone("9500003698");
        order.setCurrency("INR");
        order.setAmount(10.00);
        order.setDescription("This is a test transaction.");
        order.setRedirectUrl("http://192.168.43.81:8080/testredirect");
        //order.setWebhookUrl("http://www.someurl.com/");
        order.setTransactionId("tid226");
        Instamojo api = null;

        try {
            // gets the reference to the instamojo api
            api = InstamojoImpl.getApi("q6TDJrUVEQ1ZPC4RUix8yrzn45Ph58AcHH3AQVZo", "q1chXTgsLOPuwNtbH4bzOwnBSY2nMj7uktow0zX2irCyMLSBlFozIowezKuhOrUJFzyY6jCiU4yqV0MShtKQz3bbHMnxhYwa7gE95XMpIopcr5rDG6xiXqrhNz0szPV9", "https://api.instamojo.com/v2/", "https://www.instamojo.com/oauth2/token/");


        } catch (ConnectionException e) {
            //LOGGER.log(Level.SEVERE, e.toString(), e);
            e.printStackTrace();
        }


        boolean isOrderValid = order.validate();

        if (isOrderValid) {
            try {
                CreatePaymentOrderResponse createPaymentOrderResponse = api.createNewPaymentOrder(order);
                System.out.println(createPaymentOrderResponse.getPaymentOptions().getPaymentUrl());
                // print the status of the payment order.
                System.out.println(createPaymentOrderResponse.getJsonResponse());
                System.out.println(createPaymentOrderResponse.getPaymentOrder().getStatus());
                PaymentOrderDetailsResponse paymentOrderDetailsResponse = api.getPaymentOrderDetails(createPaymentOrderResponse.getPaymentOrder().getId());
                System.out.println(paymentOrderDetailsResponse.getJsonResponse());
                System.out.println(paymentOrderDetailsResponse.getStatus());

                paymentOrderDetailsResponse = api.getPaymentOrderDetailsByTransactionId(createPaymentOrderResponse.getPaymentOrder().getTransactionId());
                System.out.println(paymentOrderDetailsResponse.getJsonResponse()
                );
                System.out.println(paymentOrderDetailsResponse.getStatus());

            } catch (InvalidPaymentOrderException e) {
                //LOGGER.log(Level.SEVERE, e.toString(), e);
                e.printStackTrace();

                if (order.isTransactionIdInvalid()) {
                    System.out.println("Transaction id is invalid. This is mostly due to duplicate  transaction id.");
                }
                if (order.isCurrencyInvalid()) {
                    System.out.println("Currency is invalid.");
                }
            } catch (ConnectionException e) {
                //LOGGER.log(Level.SEVERE, e.toString(), e);
                e.printStackTrace();

            }
        } else {
            // inform validation errors to the user.
            if (order.isTransactionIdInvalid()) {
                System.out.println("Transaction id is invalid.");
            }
            if (order.isAmountInvalid()) {
                System.out.println("Amount can not be less than 9.00.");
            }
            if (order.isCurrencyInvalid()) {
                System.out.println("Please provide the currency.");
            }
            if (order.isDescriptionInvalid()) {
                System.out.println("Description can not be greater than 255 characters.");
            }
            if (order.isEmailInvalid()) {
                System.out.println("Please provide valid Email Address.");
            }
            if (order.isNameInvalid()) {
                System.out.println("Name can not be greater than 100 characters.");
            }
            if (order.isPhoneInvalid()) {
                System.out.println("Phone is invalid.");
            }
            if (order.isRedirectUrlInvalid()) {
                System.out.println("Please provide valid Redirect url.");
            }

            if (order.isWebhookInvalid()) {
                System.out.println("Provide a valid webhook url");
            }

        }
        return "payment created successfully";
    }
    public String getPaymentStatus(String tid)
    {
        Instamojo api = null;

        try {
            // gets the reference to the instamojo api
            api = InstamojoImpl.getApi("q6TDJrUVEQ1ZPC4RUix8yrzn45Ph58AcHH3AQVZo", "q1chXTgsLOPuwNtbH4bzOwnBSY2nMj7uktow0zX2irCyMLSBlFozIowezKuhOrUJFzyY6jCiU4yqV0MShtKQz3bbHMnxhYwa7gE95XMpIopcr5rDG6xiXqrhNz0szPV9", "https://api.instamojo.com/v2/", "https://www.instamojo.com/oauth2/token/");

            PaymentOrderDetailsResponse paymentOrderDetailsResponse = api.getPaymentOrderDetailsByTransactionId(tid);
            return paymentOrderDetailsResponse.getJsonResponse();
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
            return "Something went wrong";
    }
}
