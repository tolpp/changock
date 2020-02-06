package io.changock.driver.base.decorator;


import io.changock.driver.api.lock.LockManager;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.verification.Times;

import java.util.function.Supplier;


public class LockMethodInvokerTest {


  @Test
  public void shouldEnsureLock_WhenNormalSupplier_IfInvoke() {
    // given
    LockManager lockManagerMock = Mockito.mock(LockManager.class);
    Supplier supplierMock = Mockito.mock(Supplier.class);

    // when
    new LockMethodInvoker(lockManagerMock).invoke(supplierMock);

    //then
    Mockito.verify(lockManagerMock, new Times(1)).ensureLockDefault();
    Mockito.verify(supplierMock, new Times(1)).get();

  }

  @Test
  public void shouldEnsureLock_WhenVoidSupplier_IfInvoke() {
    // given
    LockManager lockManagerMock = Mockito.mock(LockManager.class);
    VoidSupplier supplierMock = Mockito.mock(VoidSupplier.class);

    // when
    new LockMethodInvoker(lockManagerMock).invoke(supplierMock);

    //then
    Mockito.verify(lockManagerMock, new Times(1)).ensureLockDefault();
    Mockito.verify(supplierMock, new Times(1)).execute();

  }

}
