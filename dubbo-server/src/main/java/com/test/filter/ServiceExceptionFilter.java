package com.test.filter;

import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.common.logger.Logger;
import org.apache.dubbo.common.logger.LoggerFactory;
import org.apache.dubbo.rpc.Filter;
import org.apache.dubbo.rpc.Invocation;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.Result;
import org.apache.dubbo.rpc.RpcContext;
import org.apache.dubbo.rpc.RpcException;
import org.apache.dubbo.rpc.service.GenericService;

import com.test.exception.ServiceException;

@Activate(group = CommonConstants.PROVIDER)
public class ServiceExceptionFilter implements Filter, Filter.Listener {
    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceExceptionFilter.class);

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        return invoker.invoke(invocation);
    }

    @Override
    public void onResponse(Result appResponse, Invoker<?> invoker, Invocation invocation) {
        if (appResponse.hasException() && GenericService.class != invoker.getInterface()) {
            // 存在异常且非泛化调用
            Throwable exception = appResponse.getException();
            if (exception instanceof ServiceException) {
                return;
            }
            // 示例代码
            if (exception instanceof IllegalArgumentException) {
                appResponse.setException(handleExampleException(exception));
            }
        }
    }

    private ServiceException handleExampleException(Throwable exception) {
        // 返回异常
        return new ServiceException(400, exception.getMessage());
    }

    @Override
    public void onError(Throwable e, Invoker<?> invoker, Invocation invocation) {
        LOGGER.error("Got unchecked and undeclared exception which called by " + RpcContext.getContext().getRemoteHost() + ". service: " + invoker.getInterface().getName() + ", method: " + invocation.getMethodName() + ", exception: " + e.getClass().getName() + ": " + e.getMessage(), e);
    }
}
