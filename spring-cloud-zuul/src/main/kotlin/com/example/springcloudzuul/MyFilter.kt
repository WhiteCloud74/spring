package com.example.springcloudzuul

import com.netflix.zuul.ZuulFilter
import com.netflix.zuul.context.RequestContext
import org.apache.http.protocol.RequestContent
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class MyFilter : ZuulFilter() {
    var log = LoggerFactory.getLogger(MyFilter::class.java)

    override fun shouldFilter(): Boolean {
        return true
    }

    override fun filterType(): String {
        return "pre"
    }

    override fun filterOrder(): Int {
        return 0
    }

    override fun run(): Any {
        var ctx = RequestContext.getCurrentContext()
        var request = ctx.request
        log.info("${request.method}>>>${request.requestURI}")
        var accessToken = request.getParameter("token")
        if (accessToken == null) {
            log.warn("token is empty")
            ctx.setSendZuulResponse(false)
            ctx.responseStatusCode = 401
            try {
                ctx.response.writer.write("token is empty")
            } catch (e: Exception) {
            }
            return "null"
        }
        log.info("ok")
        return "null"
    }
}