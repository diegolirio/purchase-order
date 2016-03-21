package com.diegolirio.purchaseorder.builder;

import java.util.Calendar;

import com.diegolirio.purchaseorder.builder.PurchaseOrderBuilder;
import com.diegolirio.purchaseorder.models.PurchaseOrder;

public class PurchaseOrderBuilderTest {

	public static PurchaseOrder build() {
		PurchaseOrderBuilder purchaseOrderBuilder = new PurchaseOrderBuilder();		
		PurchaseOrder purchaseOrder = 
			  purchaseOrderBuilder.withEmissionDate(Calendar.getInstance().getTime())
								  .withContactRecipient("João")
								  .withPhoneRecipient("11296785")
								  .withPhoneSender("1129678511")
								  .withPhoneShippingCompany("1146758597")
								  .withRemark("Teste Observacao")
								  .withTypeFreight('R')
								  .withCondicoesPagamento("CARTAO")
								  .build();
		return purchaseOrder;
	}
	
}
