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
package io.bsoa.rpc.protocol.dubbo;

import io.bsoa.rpc.ext.Extension;
import io.bsoa.rpc.ext.ExtensionLoaderFactory;
import io.bsoa.rpc.protocol.Protocol;
import io.bsoa.rpc.protocol.ProtocolDecoder;
import io.bsoa.rpc.protocol.ProtocolEncoder;
import io.bsoa.rpc.protocol.ProtocolInfo;
import io.bsoa.rpc.protocol.ProtocolNegotiator;

/**
 * <p></p>
 * <p>
 * Created by zhangg on 2016/12/18 09:22. <br/>
 *
 * @author <a href=mailto:zhanggeng@howtimeflies.org>GengZhang</a>
 */
@Extension(value = "dubbo", code = 3)
public class DubboProtocol implements Protocol {

    private ProtocolInfo protocolInfo = new DubboProtocolInfo();

    @Override
    public ProtocolInfo protocolInfo() {
        return protocolInfo;
    }

    @Override
    public ProtocolEncoder encoder() {
        ProtocolEncoder encoder = ExtensionLoaderFactory.getExtensionLoader(ProtocolEncoder.class)
                .getExtension("dubbo", new Class[]{ProtocolInfo.class}, new Object[]{protocolInfo});
        return encoder;
    }

    @Override
    public ProtocolDecoder decoder() {
        ProtocolDecoder decoder = ExtensionLoaderFactory.getExtensionLoader(ProtocolDecoder.class)
                .getExtension("dubbo", new Class[]{ProtocolInfo.class}, new Object[]{protocolInfo});
        return decoder;
    }

    @Override
    public ProtocolNegotiator negotiator() {
        return null;
    }
}
