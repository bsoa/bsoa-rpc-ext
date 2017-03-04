/*
 * Copyright 2016 The BSOA Project
 *
 * The BSOA Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package io.bsoa.rpc.protocol.jsf.test;

import io.bsoa.rpc.config.ConsumerConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p></p>
 * <p>
 * Created by zhangg on 2016/12/18 10:58. <br/>
 *
 * @author <a href=mailto:zhanggeng@howtimeflies.org>GengZhang</a>
 */
public class JSFClientTest {

    /**
     * slf4j Logger for this class
     */
    private final static Logger LOGGER = LoggerFactory.getLogger(JSFClientTest.class);

    public static void main(String[] args) throws InterruptedException {

        ConsumerConfig<HelloService> consumerConfig = new ConsumerConfig<>();
        consumerConfig.setInterfaceId(HelloService.class.getName());
//        consumerConfig.setProtocol("jsf");
        consumerConfig.setUrl("127.0.0.1:22000");
        consumerConfig.setTimeout(60000);
        consumerConfig.setRegister(false);

        HelloService helloService = consumerConfig.refer();

        for (int i = 0; i < 100; i++) {
            try {
                String s = helloService.sayHello("xxx", 22);
                LOGGER.warn("{}", s);
            } catch (Exception e) {
                LOGGER.error("", e);
            }
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
            }
        }
        consumerConfig.unRefer();
    }

}
