/**
 * Copyright 2017 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
 
package ai.api.examples.web;

import javax.servlet.annotation.WebServlet;

import ai.api.model.Fulfillment;
import ai.api.model.ResponseMessage;
import ai.api.model.ResponseMessage.ResponseImage;
import ai.api.model.ResponseMessage.ResponseQuickReply;
import ai.api.model.ResponseMessage.ResponseSpeech;
import ai.api.web.AIWebhookServlet;

@WebServlet("/webhook")
public class WebhookSample extends AIWebhookServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doWebhook(AIWebhookRequest input, Fulfillment output) {
	
    output.setSpeech("You said: " + input.getResult().getFulfillment().getSpeech());
    String action = input.getResult().getAction();

    if(action.equals("search_property")){
        
    }
    
    ResponseSpeech speech = new ResponseMessage.ResponseSpeech();
    speech.setSpeech("speech 1", "speech 2");
        
    ResponseImage image = new ResponseMessage.ResponseImage();
    image.setImageUrl("url image");

    ResponseQuickReply quickReply = new ResponseMessage.ResponseQuickReply();
    quickReply.setTitle("Quick title");

    output.setSpeech("test speech");
    output.setMessages(image, quickReply, speech);
    
  }
}
