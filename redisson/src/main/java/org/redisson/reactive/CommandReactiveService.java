/**
 * Copyright (c) 2013-2019 Nikita Koksharov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.redisson.reactive;

import org.reactivestreams.Publisher;
import org.redisson.api.RFuture;
import org.redisson.command.CommandAsyncService;
import org.redisson.connection.ConnectionManager;

import reactor.fn.Supplier;

/**
 *
 * @author Nikita Koksharov
 *
 */
public class CommandReactiveService extends CommandAsyncService implements CommandReactiveExecutor {

    public CommandReactiveService(ConnectionManager connectionManager) {
        super(connectionManager);
    }

    @Override
    public <R> Publisher<R> reactive(Supplier<RFuture<R>> supplier) {
        return new NettyFuturePublisher<R>(supplier);
    }

}
