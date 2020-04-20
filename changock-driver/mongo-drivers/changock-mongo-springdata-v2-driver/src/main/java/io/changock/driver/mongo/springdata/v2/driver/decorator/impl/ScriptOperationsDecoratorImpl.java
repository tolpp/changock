package io.changock.driver.mongo.springdata.v2.driver.decorator.impl;

import io.changock.driver.mongo.springdata.v2.driver.decorator.ScriptOperationsDecorator;
import io.changock.driver.api.lock.guard.invoker.LockGuardInvoker;
import org.springframework.data.mongodb.core.ScriptOperations;

@Deprecated
public class ScriptOperationsDecoratorImpl implements ScriptOperationsDecorator {

    private final ScriptOperations impl;
    private final LockGuardInvoker invoker;

    public ScriptOperationsDecoratorImpl(ScriptOperations impl, LockGuardInvoker invoker) {
        this.impl = impl;
        this.invoker = invoker;
    }
    @Override
    public ScriptOperations getImpl() {
        return impl;
    }

    @Override
    public LockGuardInvoker getInvoker() {
        return invoker;
    }
}