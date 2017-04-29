package com.mgcele.framework.restful;

import com.mgcele.framework.restful.bean.RestResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @author mgcele on 2017/4/29.
 */
public abstract class BaseRestController {

    protected ResponseEntity<RestResponse> success() {
        RestResponse result = new RestResponse().success();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
