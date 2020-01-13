rabbitmqadmin declare queue name=danakilat.order.approved.kyc-result-process durable=true
rabbitmqadmin declare binding source=exchange.danakilat destination=danakilat.order.approved.kyc-result-process routing_key=danakilat.order.approved.*

rabbitmqadmin declare queue name=danakilat.credit-application.approved.kyc-result-process durable=true
rabbitmqadmin declare binding source=exchange.danakilat destination=danakilat.credit-application.approved.kyc-result-process routing_key=danakilat.credit-application.approved.*

rabbitmqadmin declare queue name=danakilat.order.canceled-rejected.kyc-result-process  durable=true
rabbitmqadmin declare binding source=exchange.danakilat   destination=danakilat.order.canceled-rejected.kyc-result-process routing_key=danakilat.order.canceled-rejected.*

rabbitmqadmin declare queue name=danakilat.credit-application.rejected.kyc-result-process  durable=true
rabbitmqadmin declare binding source=exchange.danakilat   destination=danakilat.credit-application.rejected.kyc-result-process routing_key=danakilat.credit-application.rejected.*

rabbitmqadmin declare queue name=danakilat.credit-application.returned.kyc-result-process  durable=true
rabbitmqadmin declare binding source=exchange.danakilat   destination=danakilat.credit-application.returned.kyc-result-process routing_key=danakilat.credit-application.returned.*

rabbitmqadmin declare queue name=danakilat.credit-application.canceled.kyc-result-process  durable=true
rabbitmqadmin declare binding source=exchange.danakilat   destination=danakilat.credit-application.canceled.kyc-result-process routing_key=danakilat.credit-application.approved.*

rabbitmqadmin declare queue name=danakilat.order.recommended.kyc-result-process  durable=true
rabbitmqadmin declare binding source=exchange.danakilat   destination=danakilat.order.recommended.kyc-result-process routing_key=danakilat.order.recommended.*

rabbitmqadmin declare queue name=nkp.bank-account-application.approved.kyc-result-process  durable=true
rabbitmqadmin declare binding source=exchange.nkp   destination=nkp.bank-account-application.approved.kyc-result-process routing_key=nkp.bank-account-application.approved.v2

rabbitmqadmin declare queue name=nkp.bank-account-application.declined.kyc-result-process  durable=true
rabbitmqadmin declare binding source=exchange.nkp   destination=nkp.bank-account-application.declined.kyc-result-process routing_key=nkp.bank-account-application.declined.v2

rabbitmqadmin declare queue name=nkp.bank-account-application.returned.kyc-result-process  durable=true
rabbitmqadmin declare binding source=exchange.nkp   destination=nkp.bank-account-application.returned.kyc-result-process routing_key=nkp.bank-account-application.returned.v2

rabbitmqadmin declare queue name=nkp.application.approved.kyc-result-process  durable=true
rabbitmqadmin declare binding source=exchange.nkp   destination=nkp.application.approved.kyc-result-process routing_key=nkp.application.approved

rabbitmqadmin declare queue name=nkp.application.declined.kyc-result-process  durable=true
rabbitmqadmin declare binding source=exchange.nkp   destination=nkp.application.declined.kyc-result-process routing_key=nkp.application.declined

rabbitmqadmin declare queue name=nkp.application.returned.kyc-result-process  durable=true
rabbitmqadmin declare binding source=exchange.nkp   destination=nkp.application.returned.kyc-result-process routing_key=nkp.application.returned