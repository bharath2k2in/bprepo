package com.home.work.home_expenses.deserialize;

import com.home.work.home_expenses.domain.IncomeExpenseDetail;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.ObjectCodec;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Bharath on 06-04-2014.
 */
public class IncomeExpenseDeserializer extends JsonDeserializer<IncomeExpenseDetail> {

    private SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public IncomeExpenseDetail deserialize(JsonParser jsonParser,
                                           DeserializationContext deserializationContext) throws IOException {

        ObjectCodec oc = jsonParser.getCodec();
        JsonNode node = oc.readTree(jsonParser);

        Date transactionDate = null;
        try {
            final String transactionDateFromRequest = node.get("transactionDate").getTextValue();
            transactionDate = dateFormatter.parse(
                    (transactionDateFromRequest.isEmpty()) ? dateFormatter.format(new Date()) :
                    transactionDateFromRequest);
        } catch (ParseException ex) {
            throw new IllegalArgumentException("Error occurred while parsing date");
        }

        return new IncomeExpenseDetail(node.get("amount").getDecimalValue(), node.get("description").getTextValue(),
                                       node.get("category").getTextValue(), transactionDate,
                                       node.get("amountType").getTextValue());
    }

}
