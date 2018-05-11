package api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Api(value = "chuckle", description = "BSP Claim Management", tags = {"Chuckle"})
public interface HomeApi {
    @ApiOperation(value = "ToYou", notes = "", tags = {"ToYou",})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "success")})
    @RequestMapping(value = "/toyou",
            produces = {"test/plain"},
            method = RequestMethod.GET)
    ResponseEntity<String> toYou();

    @ApiOperation(value = "ToMe", notes = "", tags = {"ToMe",})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "success")})
    @RequestMapping(value = "/tome",
            produces = {"test/plain"},
            method = RequestMethod.GET)
    ResponseEntity<String> toMe();
}
