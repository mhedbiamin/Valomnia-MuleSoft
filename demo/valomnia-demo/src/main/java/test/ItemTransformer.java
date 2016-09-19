/**
 * (C) 2016 ApptivIT �. This software is protected by international copyright. Any use of this software is subject to Valomnia User account
 * through a sales contract between you and ApptivIT �. If such a user account Valomnia is not in place,
 * you can not use the software.
 * a copy of Valomnia GENERAL TERMS AND CONDITIONS has-been included with this distribution in the file LICENSE.md
 */
/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is Licensed under the Apache License, Version 2.0
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0.
 * Other license terms have been included with this distribution in the LICENSE.md file.
 */
/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package test;



import org.mule.api.transformer.TransformerException;
import org.mule.modules.valomnia.entities.Item;
import org.mule.transformer.AbstractMessageTransformer;
import org.mule.api.MuleMessage;


public class ItemTransformer extends AbstractMessageTransformer

{

    @Override
    public Object transformMessage(MuleMessage message, String outputEncoding) throws TransformerException {
        Item item = new Item();
        item.setReference("It004");
        item.setName("Item Test");
        
        item.setDescription("Item for test");

        return item;
    	
}
}
