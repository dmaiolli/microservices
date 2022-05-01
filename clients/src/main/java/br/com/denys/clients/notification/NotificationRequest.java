package br.com.denys.clients.notification;

import lombok.Builder;

@Builder
public record NotificationRequest(String message,
                                  String sender,
                                  String toCustomerEmail,
                                  Long toCustomerId
                                  ) {
}
