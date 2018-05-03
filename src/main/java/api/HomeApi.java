package api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Api(value = "ping", description = "BSP Claim Management", tags = {"Ping"})
public interface HomeApi {
    @ApiOperation(value = "Ping", notes = "", tags = {"Ping",})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "success")})
    @RequestMapping(value = "/ping",
            produces = {"test/plain"},
            method = RequestMethod.GET)
    ResponseEntity<String> ping();
}
