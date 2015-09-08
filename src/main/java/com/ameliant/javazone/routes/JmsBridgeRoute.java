/*
 * Copyright 2015 Jakub Korab
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ameliant.javazone.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * @author jkorab
 */
@Component
public class JmsBridgeRoute extends RouteBuilder {

    @Override
    public void configure() {
        from("jms:queue:in").routeId("JmsBridge")
            .filter(simple("${header[locale]} == 'no_NO'"))
                .transform(simple("Hei! ${body}"))
            .end()
            .to("jms:queue:out");
    }

}
