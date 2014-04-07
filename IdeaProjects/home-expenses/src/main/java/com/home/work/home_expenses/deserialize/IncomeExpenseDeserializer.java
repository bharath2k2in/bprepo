package com.home.work.home_expenses.deserialize;

import com.home.work.home_expenses.domain.IncomeExpenseDetail;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.ObjectCodec;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

import java.io.IOException;
import java.util.Date;

/**
 * Created by Bharath on 06-04-2014.
 */
public class IncomeExpenseDeserializer extends JsonDeserializer<IncomeExpenseDetail> {

    @Override
    public IncomeExpenseDetail deserialize(JsonParser jsonParser,
                                           DeserializationContext deserializationContext) throws IOException {

        ObjectCodec oc = jsonParser.getCodec();
        JsonNode node = oc.readTree(jsonParser);
        return new IncomeExpenseDetail(node.get("amount").getDecimalValue(), node.get("description").getTextValue(),
                node.get("category").getTextValue(), new Date(), node.get("amountType").getTextValue());
    }

}
