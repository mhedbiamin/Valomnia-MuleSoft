/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package test;



import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;
import org.mule.api.MuleMessage;


public class ItemTransformer extends AbstractMessageTransformer

{

    @Override
    public Object transformMessage(MuleMessage message, String outputEncoding) throws TransformerException {
        Item item = new Item();
        item.setName("ItemTest");
        item.setReference("It002");
        item.setDescription("Item for test");

        return item;
    }
}
